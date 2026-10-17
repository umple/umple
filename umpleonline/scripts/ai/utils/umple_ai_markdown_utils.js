// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Markdown Utilities - Markdown rendering and formatting for AI responses

const AiMarkdownUtils = (() => {
  "use strict";

  // ============================================================================
  // MARKDOWN REGEX PATTERNS
  // ============================================================================

  const MARKDOWN_PATTERNS = {
    codeBlock: /```(\w+)?\s*([\s\S]*?)```/g,
    inlineCode: /`([^`]+)`/g,
    bold: /\*\*([^*]+)\*\*/g,
    italic: /\*([^*]+)\*/g,
    lineBreak: /\n/g,
    header: /^(#{1,6})\s+(.+)$/gm
  };

  // Table detection patterns (strict GFM)
  const TABLE_SEPARATOR_REGEX = /^\s*\|?\s*:?-+:?\s*(?:\|\s*:?-+:?\s*)*\|?\s*$/;
  const TABLE_ROW_REGEX = /^\s*\|.*\|\s*$/;

  // ============================================================================
  // TABLE PARSING HELPERS
  // ============================================================================

  /**
   * Check if a line looks like a table row (contains pipes)
   * @private
   * @param {string} line - Line to check
   * @returns {boolean}
   */
  function isTableRow(line) {
    return TABLE_ROW_REGEX.test(line);
  }

  /**
   * Check if a line is a valid table separator row
   * @private
   * @param {string} line - Line to check
   * @returns {boolean}
   */
  function isTableSeparator(line) {
    if (!TABLE_SEPARATOR_REGEX.test(line)) return false;
    // Must have at least one column with 3+ dashes
    const parts = line.split('|').map(p => p.trim()).filter(p => p.length > 0);
    return parts.every(p => /^:?-{3,}:?$/.test(p));
  }

  /**
   * Parse a table row into cells
   * @private
   * @param {string} line - Table row line
   * @returns {string[]}
   */
  function parseTableRow(line) {
    // Split by | and trim, filter empty cells from leading/trailing pipes
    return line.split('|').map(cell => cell.trim()).filter((cell, i, arr) => {
      // Keep non-empty cells, but also keep empty cells between pipes
      if (cell.length > 0) return true;
      // Skip leading/trailing empty cells only
      if (i === 0 || i === arr.length - 1) return false;
      return true;
    });
  }

  /**
   * Apply inline formatting to cell content
   * @private
   * @param {string} cell - Cell content (already HTML-escaped)
   * @returns {string}
   */
  function formatCellContent(cell) {
    return cell
      .replace(MARKDOWN_PATTERNS.inlineCode, "<code>$1</code>")
      .replace(MARKDOWN_PATTERNS.bold, "<strong>$1</strong>")
      .replace(MARKDOWN_PATTERNS.italic, "<em>$1</em>");
  }

  /**
   * Parse and convert a table block to HTML
   * @private
   * @param {string[]} lines - Array of table lines (header, separator, body rows)
   * @returns {string} HTML table
   */
  function parseTableToHtml(lines) {
    if (lines.length < 2) return lines.join('<br/>');

    const headerCells = parseTableRow(lines[0]);
    const numColumns = headerCells.length;

    // Build header
    let html = '<div class="ai-md-table-wrap"><table class="ai-md-table"><thead><tr>';
    headerCells.forEach(cell => {
      html += `<th>${formatCellContent(cell)}</th>`;
    });
    html += '</tr></thead><tbody>';

    // Process body rows (skip separator at index 1)
    for (let i = 2; i < lines.length; i++) {
      const rowCells = parseTableRow(lines[i]);
      // Pad or trim cells to match header column count
      while (rowCells.length < numColumns) rowCells.push('');
      if (rowCells.length > numColumns) rowCells.length = numColumns;

      html += '<tr>';
      rowCells.forEach(cell => {
        html += `<td>${formatCellContent(cell)}</td>`;
      });
      html += '</tr>';
    }

    html += '</tbody></table></div>';
    return html;
  }

  /**
   * Extract and convert all tables from text
   * @private
   * @param {string} text - Text to process (already HTML-escaped)
   * @returns {string} Text with tables converted to HTML
   */
  function extractAndConvertTables(text) {
    const lines = text.split('\n');
    const result = [];
    let i = 0;

    while (i < lines.length) {
      const line = lines[i];

      // Check for potential table start (current line looks like a row)
      if (isTableRow(line) && i + 1 < lines.length && isTableSeparator(lines[i + 1])) {
        // Found a table: header at i, separator at i+1
        const tableLines = [lines[i], lines[i + 1]];
        i += 2;

        // Collect body rows
        while (i < lines.length && isTableRow(lines[i])) {
          tableLines.push(lines[i]);
          i++;
        }

        // Convert table to HTML
        result.push(parseTableToHtml(tableLines));
      } else {
        // Not a table, keep as is
        result.push(line);
        i++;
      }
    }

    return result.join('\n');
  }

  const CODE_BLOCK_PLACEHOLDER_REGEX = /^\x00CODE_BLOCK_\d+\x00$/;
  const HEADER_BLOCK_REGEX = /^<h[1-6]>.*<\/h[1-6]>$/i;
  const TABLE_BLOCK_REGEX = /^<div class="ai-md-table-wrap">[\s\S]*<\/div>$/;

  function isStandaloneBlockLine(line) {
    const trimmed = String(line || "").trim();
    if (!trimmed) return false;

    return CODE_BLOCK_PLACEHOLDER_REGEX.test(trimmed)
      || HEADER_BLOCK_REGEX.test(trimmed)
      || TABLE_BLOCK_REGEX.test(trimmed);
  }

  /**
   * Render markdown lines into block-aware HTML.
   * - Blank lines separate paragraphs.
   * - Single line breaks inside paragraphs become <br/>.
   * - Standalone block lines (headers, tables, code placeholders) stay block-level.
   * @private
   * @param {string} text - Text after inline markdown transformations
   * @returns {string} HTML with paragraph and line-break handling
   */
  function renderParagraphsAndBreaks(text) {
    const lines = text.split('\n');
    const blocks = [];
    let paragraphLines = [];

    function flushParagraph() {
      if (paragraphLines.length === 0) return;

      const paragraphHtml = paragraphLines
        .join('\n')
        .replace(MARKDOWN_PATTERNS.lineBreak, "<br/>");

      blocks.push(`<p>${paragraphHtml}</p>`);
      paragraphLines = [];
    }

    lines.forEach(line => {
      if (/^\s*$/.test(line)) {
        flushParagraph();
        return;
      }

      if (isStandaloneBlockLine(line)) {
        flushParagraph();
        blocks.push(line.trim());
        return;
      }

      paragraphLines.push(line);
    });

    flushParagraph();
    return blocks.join('\n');
  }

  // ============================================================================
  // PUBLIC API
  // ============================================================================

  return {
    /**
     * Render markdown text to HTML
     * Supports: headers, code blocks, inline code, bold, italic, tables, paragraphs, line breaks
     * @param {string} text - Markdown text to render
     * @returns {string} Rendered HTML
     */
    render(text) {
      if (!text) return "";

      // Escape HTML first to prevent XSS
      let formatted = this.escapeHtml(text);

      // Protect code blocks by replacing them with placeholders
      const codeBlocks = [];
      formatted = formatted.replace(MARKDOWN_PATTERNS.codeBlock, (match, lang, code) => {
        const placeholder = `\x00CODE_BLOCK_${codeBlocks.length}\x00`;
        codeBlocks.push(`<pre><code>${code}</code></pre>`);
        return placeholder;
      });

      // Extract and convert tables (must happen before lineBreak conversion)
      formatted = extractAndConvertTables(formatted);

      // Apply remaining markdown transformations
      formatted = formatted
        .replace(MARKDOWN_PATTERNS.header, (match, hashes, content) => {
          const level = hashes.length;
          return `<h${level}>${content.trim()}</h${level}>`;
        })
        .replace(MARKDOWN_PATTERNS.inlineCode, "<code>$1</code>")
        .replace(MARKDOWN_PATTERNS.bold, "<strong>$1</strong>")
        .replace(MARKDOWN_PATTERNS.italic, "<em>$1</em>");

      // Render paragraphs and line breaks in a block-aware way
      formatted = renderParagraphsAndBreaks(formatted);

      // Restore code blocks
      codeBlocks.forEach((block, i) => {
        formatted = formatted.replace(`\x00CODE_BLOCK_${i}\x00`, block);
      });

      return formatted;
    },

    /**
     * Escape HTML special characters to prevent XSS
     * @param {string} text - Text to escape
     * @returns {string} HTML-escaped text
     */
    escapeHtml(text) {
      if (typeof AiTextUtils !== "undefined" && AiTextUtils.escapeHtml) {
        return AiTextUtils.escapeHtml(text);
      }
      // Fallback if AiTextUtils is not available
      const tempElement = document.createElement("div");
      tempElement.textContent = text;
      return tempElement.innerHTML;
    }
  };
})();
