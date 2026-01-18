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
  }
};
