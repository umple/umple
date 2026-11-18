// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Text Utilities - Text processing helpers for AI features

const AiTextUtils = {
  /**
   * Normalize newlines to Unix-style \n
   * @param {string} text - Input text
   * @returns {string} Text with normalized newlines
   */
  normalizeNewlines(text) {
    return String(text || "").replace(/\r\n/g, "\n");
  },

  /**
   * Strip HTML tags and scripts/styles from HTML string
   * @param {string} html - HTML string
   * @returns {string} Plain text
   */
  stripHtmlToText(html) {
    const raw = String(html || "")
      .replace(/<script[\s\S]*?<\/script>/gi, "")
      .replace(/<style[\s\S]*?<\/style>/gi, "");
    const div = document.createElement("div");
    div.innerHTML = raw;
    return (div.textContent || div.innerText || "").trim();
  },

  /**
   * Compute line number at a given character index
   * @param {string} text - Full text
   * @param {number} index - Character index
   * @returns {number} Line number (0-based)
   */
  computeLineNumberAtIndex(text, index) {
    const safeIndex = Math.max(0, Math.min(Number(index) || 0, String(text || "").length));
    return this.normalizeNewlines(String(text || "").slice(0, safeIndex)).split("\n").length - 1;
  },

  /**
   * Get prefix (spacing) before insertion point
   * @param {string} docText - Document text
   * @param {number} pos - Insertion position
   * @returns {string} Prefix newlines
   */
  computePrefix(docText, pos) {
    const before = this.normalizeNewlines(docText.slice(0, pos));
    const trailingNewlines = (before.match(/\n*$/) || [""])[0].length;
    const needed = Math.max(2 - trailingNewlines, 0);
    return "\n".repeat(needed);
  },

  /**
   * Get suffix (spacing) after insertion point
   * @param {string} docText - Document text
   * @param {number} pos - Insertion position
   * @returns {string} Suffix newlines
   */
  computeSuffix(docText, pos) {
    const after = this.normalizeNewlines(docText.slice(pos));
    const leadingNewlines = (after.match(/^\n*/) || [""])[0].length;
    const needed = Math.max(2 - leadingNewlines, 0);
    return "\n".repeat(needed);
  },

  /**
   * Escape HTML special characters
   * @param {string} text - Text to escape
   * @returns {string} HTML-escaped text
   */
  escapeHtml(text) {
    const tempElement = document.createElement("div");
    tempElement.textContent = text;
    return tempElement.innerHTML;
  },

  /**
   * Truncate text to maximum length
   * @param {string} text - Text to truncate
   * @param {number} maxLength - Maximum length
   * @param {string} suffix - Suffix to append when truncating
   * @returns {string} Truncated text
   */
  truncate(text, maxLength, suffix = "...") {
    const str = String(text || "");
    if (str.length <= maxLength) return str;
    return str.slice(0, maxLength - suffix.length) + suffix;
  },

  /**
   * Get lines around a target line with context
   * @param {string} text - Full text
   * @param {number} targetLine - Target line number (0-based)
   * @param {number} contextLines - Number of lines before and after to include
   * @returns {string} Formatted snippet with line numbers
   */
  getLinesAround(text, targetLine, contextLines = 2) {
    const normalized = this.normalizeNewlines(String(text || ""));
    const lines = normalized.split("\n");
    const safeTargetLine = Math.max(0, Math.min(Number(targetLine) || 0, lines.length - 1));
    const startLine = Math.max(0, safeTargetLine - contextLines);
    const endLine = Math.min(lines.length - 1, safeTargetLine + contextLines);

    const result = [];
    for (let i = startLine; i <= endLine; i++) {
      const lineContent = lines[i] || "";
      const truncated = this.truncate(lineContent, 80, "...");
      result.push(`${i + 1}: ${truncated}`);
    }
    return result.join("\n");
  },

  /**
   * Extract Umple code from AI response
   * @param {string} response - Raw AI response
   * @returns {string} Extracted Umple code
   */
  extractUmpleCode(response) {
    const text = String(response || "");

    const codeBlockMatch = text.match(/```(?:umple)?\s*([\s\S]*?)```/);
    if (codeBlockMatch) {
      return codeBlockMatch[1].trim();
    }

    const classMatch = text.match(/(?:class|interface|trait|association)\s+\w+/);
    if (classMatch) {
      const startIndex = text.indexOf(classMatch[0]);
      return text.substring(startIndex).trim();
    }

    return text.trim();
  },

  /**
   * Parse multiple code blocks from AI response
   * @param {string} response - Raw AI response
   * @returns {Array<{language: string, code: string}>} Array of parsed blocks
   */
  parseCodeBlocks(response) {
    const text = String(response || "");
    const blocks = [];
    const regex = /```(\w+)?\s*([\s\S]*?)```/g;
    let match;

    while ((match = regex.exec(text)) !== null) {
      blocks.push({
        language: (match[1] || "").trim().toLowerCase(),
        code: match[2].trim()
      });
    }

    return blocks;
  },

  /**
   * Find active `req ID { ... }` blocks in Umple code, skipping any that are inside
   * // or /* *\/ comments or string literals. The body of a req is taken verbatim up
   * to its closing brace, so text such as URLs containing // is preserved.
   * @param {string} umpleCode - Umple source text
   * @returns {Array<{id: string, text: string, start: number, end: number}>} Blocks with offsets into umpleCode
   */
  findRequirementBlocks(umpleCode) {
    return this.scanRequirements(umpleCode).blocks;
  },

  /**
   * Find the requirement IDs named by active `implementsReq` statements, e.g.
   * `implementsReq R1, R2;` or `implementsReq Speed(High);`, ignoring comments,
   * string literals and requirement bodies.
   * @param {string} umpleCode - Umple source text
   * @returns {Set<string>} Implemented requirement IDs
   */
  findImplementedRequirementIds(umpleCode) {
    return this.scanRequirements(umpleCode).implementedIds;
  },

  /**
   * Walk Umple code outside comments and string literals, collecting req blocks and
   * the IDs named by implementsReq statements.
   * @param {string} umpleCode - Umple source text
   * @returns {{blocks: Array<{id: string, text: string, start: number, end: number}>, implementedIds: Set<string>}}
   */
  scanRequirements(umpleCode) {
    const source = String(umpleCode || "");
    const blocks = [];
    const implementedIds = new Set();
    const reqPattern = /req\s+(\w+(?:[-_]\w+)*)\s*\{([^}]*)\}/y;
    const implementsPattern = /implementsReq\s+([^;{}]*);/y;
    const atWordStart = i => i === 0 || !/\w/.test(source[i - 1]);
    // Not source.startsWith(token, i): Prototype.js, loaded by UmpleOnline, replaces it with a version that ignores i
    const startsAt = (token, i) => source.slice(i, i + token.length) === token;
    let i = 0;

    while (i < source.length) {
      if (startsAt("//", i)) {
        const lineEnd = source.indexOf("\n", i);
        i = lineEnd < 0 ? source.length : lineEnd + 1;
        continue;
      }
      if (startsAt("/*", i)) {
        const commentEnd = source.indexOf("*/", i + 2);
        i = commentEnd < 0 ? source.length : commentEnd + 2;
        continue;
      }
      if (source[i] === "\"") {
        let j = i + 1;
        while (j < source.length && source[j] !== "\"" && source[j] !== "\n") {
          j += source[j] === "\\" ? 2 : 1;
        }
        i = j + 1;
        continue;
      }
      if (startsAt("implementsReq", i) && atWordStart(i)) {
        implementsPattern.lastIndex = i;
        const match = implementsPattern.exec(source);
        if (match) {
          // Drop quality qualifiers such as Speed(High) before splitting the list
          match[1].replace(/\([^)]*\)/g, "").split(",")
            .map(id => id.trim())
            .filter(Boolean)
            .forEach(id => implementedIds.add(id));
          i = implementsPattern.lastIndex;
          continue;
        }
      }
      if (startsAt("req", i) && atWordStart(i)) {
        reqPattern.lastIndex = i;
        const match = reqPattern.exec(source);
        if (match) {
          blocks.push({ id: match[1].trim(), text: match[2].trim(), start: i, end: reqPattern.lastIndex });
          i = reqPattern.lastIndex;
          continue;
        }
      }
      i++;
    }

    return { blocks, implementedIds };
  },

  /**
   * The lines added and removed from one text to another, in order (a longest common subsequence
   * of lines). Blank lines are left out and lines are compared without their surrounding spaces.
   * @param {string} oldText - Text before
   * @param {string} newText - Text after
   * @returns {Array<{type: string, text: string}>} type is "same", "added" or "removed"
   */
  diffLines(oldText, newText) {
    const toLines = text => String(text || "").split(/\r?\n/).filter(line => line.trim());
    const a = toLines(oldText);
    const b = toLines(newText);
    const keyA = a.map(line => line.trim());
    const keyB = b.map(line => line.trim());

    // Lines that did not change at the start and at the end are not compared one by one
    let start = 0;
    while (start < a.length && start < b.length && keyA[start] === keyB[start]) start++;
    let endA = a.length;
    let endB = b.length;
    while (endA > start && endB > start && keyA[endA - 1] === keyB[endB - 1]) {
      endA--;
      endB--;
    }

    const result = a.slice(0, start).map(text => ({ type: "same", text }));
    const n = endA - start;
    const m = endB - start;
    if (n * m > 1000000) {
      // Too large to compare line by line: the changed middle is shown as removed, then added
      a.slice(start, endA).forEach(text => result.push({ type: "removed", text }));
      b.slice(start, endB).forEach(text => result.push({ type: "added", text }));
    } else {
      // common[i][j]: length of the longest common subsequence of the middle lines from i and j on
      const common = [];
      for (let i = 0; i <= n; i++) common.push(new Uint32Array(m + 1));
      for (let i = n - 1; i >= 0; i--) {
        for (let j = m - 1; j >= 0; j--) {
          common[i][j] = keyA[start + i] === keyB[start + j]
            ? common[i + 1][j + 1] + 1
            : Math.max(common[i + 1][j], common[i][j + 1]);
        }
      }
      let i = 0;
      let j = 0;
      while (i < n || j < m) {
        if (i < n && j < m && keyA[start + i] === keyB[start + j]) {
          result.push({ type: "same", text: b[start + j] });
          i++;
          j++;
        } else if (j >= m || (i < n && common[i + 1][j] >= common[i][j + 1])) {
          result.push({ type: "removed", text: a[start + i] });
          i++;
        } else {
          result.push({ type: "added", text: b[start + j] });
          j++;
        }
      }
    }
    b.slice(endB).forEach(text => result.push({ type: "same", text }));
    return result;
  }
};
