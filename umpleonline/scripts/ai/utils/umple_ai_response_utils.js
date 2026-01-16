// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Response Utilities - Parsing and extraction from AI responses

const AiResponseUtils = {
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
  }
};
