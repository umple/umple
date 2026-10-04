// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Compiler Service - Compiler interaction and issue parsing

const AiCompilerService = {
  /**
   * Get compiler language
   * @returns {string} Language for compiler
   */
  getCompilerLanguage() {
    return "Json";
  },

  /**
   * Get maximum self-correction passes
   * @returns {number} Max passes
   */
  getSelfCorrectionMaxPasses() {
    return 10;
  },

  /**
   * Parse compiler issues from error HTML
   * @param {string} errorHtml - HTML response from compiler
   * @returns {Array<Object>} Array of issues {severity, line, message, errorCode}
   */
  parseCompilerIssuesFromErrorHtml(errorHtml) {
    const html = String(errorHtml || "");
    if (!html.trim()) return [];

    const issues = [];

    try {
      const container = document.createElement("div");
      container.innerHTML = html;
      const errorRow = container.querySelector("#errorRow");

      if (errorRow) {
        const fonts = Array.from(errorRow.querySelectorAll("font"));

        const findNextHelpLink = (fontEl) => {
          let node = fontEl.nextSibling;
          while (node) {
            if (node.nodeType === 1) {
              const tag = node.tagName.toLowerCase();
              if (tag === "i") {
                const link = node.querySelector("a");
                if (link) return link;
              }
              if (tag === "font") break;
            }
            node = node.nextSibling;
          }
          return null;
        };

        fonts.forEach(fontEl => {
          const text = String(fontEl.textContent || "").replace(/\s+/g, " ").trim();
          const severity = text.startsWith("Warning") ? "Warning" : (text.startsWith("Error") ? "Error" : "Unknown");

          const lineLink = fontEl.querySelector("a");
          const lineText = String(lineLink?.textContent || "");
          const lineMatch = lineText.match(/(\d+)/);
          const line = lineMatch ? parseInt(lineMatch[1], 10) : null;

          let message = text;
          const colonIndex = message.indexOf(":");
          if (colonIndex >= 0) message = message.slice(colonIndex + 1).trim();
          message = message.replace(/\.$/, "").trim();

          const helpLink = findNextHelpLink(fontEl);
          const helpText = String(helpLink?.textContent || "");
          const codeMatch = helpText.match(/\(([^)]+)\)/);
          const errorCode = codeMatch ? codeMatch[1].trim() : "";

          if (severity !== "Unknown" || message) {
            issues.push({ severity, line, message, errorCode });
          }
        });

        if (issues.length > 0) return issues;
      }
    } catch (e) {
      // Fall through to text parsing
      if (typeof console !== "undefined" && console.warn) {
        console.warn("AiCompilerService: HTML parsing failed, falling back to text parsing", e?.message || e);
      }
    }

    const text = AiTextUtils.stripHtmlToText(html);
    const regex = /\b(Error|Warning)\s+on\s+line\s+(\d+)\s*:\s*([\s\S]*?)\.(?:\s*More information\s*\(([^)]+)\))?/g;
    let match;
    while ((match = regex.exec(text)) !== null) {
      issues.push({
        severity: match[1],
        line: parseInt(match[2], 10),
        message: (match[3] || "").trim(),
        errorCode: (match[4] || "").trim()
      });
    }

    if (issues.length === 0 && /\b(Error|Warning)\b/i.test(text)) {
      issues.push({ severity: "Unknown", line: null, message: text, errorCode: "" });
    }

    return issues;
  },

  /**
   * Generate unique key for an issue
   * @param {Object} issue - Issue object
   * @returns {string} Unique key
   */
  getIssueKey(issue) {
    const severity = (issue?.severity || "").trim();
    const errorCode = (issue?.errorCode || "").trim();
    const message = (issue?.message || "").trim();
    return `${severity}|${errorCode}|${message}`;
  },

  /**
   * Format issues for log output
   * @param {Array<Object>} issues - Array of issues
   * @returns {string} Formatted log string
   */
  formatIssuesForLog(issues) {
    return (issues || []).map(i => {
      const codeSuffix = i.errorCode ? ` (${i.errorCode})` : "";
      const lineText = Number.isFinite(i.line) ? i.line : "?";
      return `- ${i.severity} on line ${lineText}${codeSuffix}: ${i.message}`;
    }).join("\n");
  },

  /**
   * Compile Umple code with server
   * @param {string} umpleCode - Umple code to compile
   * @returns {Promise<Object>} Promise resolving to {errorHtml, issues}
   */
  async compileUmpleWithServer(umpleCode) {
    const language = this.getCompilerLanguage();
    const filename = (typeof Page !== "undefined" && Page.getFilename) ? (Page.getFilename() || "") : "";
    const theme = (typeof Action !== "undefined" && Action.getThemePreference) ? Action.getThemePreference() : "system";

    const postData = [
      `language=${encodeURIComponent(language)}`,
      "error=true",
      `umpleCode=${encodeURIComponent(String(umpleCode || ""))}`,
      `filename=${encodeURIComponent(filename)}`,
      `theme=${encodeURIComponent(theme)}`
    ].join("&");

    return new Promise((resolve, reject) => {
      if (typeof Ajax === "undefined" || !Ajax.sendRequest) {
        reject(new Error("Ajax subsystem not available"));
        return;
      }

      Ajax.sendRequest("scripts/compiler.php", (http) => {
        try {
          const responseText = String(http?.responseText || "");
          const splitIndex = responseText.indexOf("URL_SPLIT");
          const errorHtml = (splitIndex >= 0 ? responseText.slice(0, splitIndex) : responseText).trim();
          const issues = this.parseCompilerIssuesFromErrorHtml(errorHtml);
          resolve({ errorHtml, issues });
        } catch (e) {
          reject(e);
        }
      }, postData);
    });
  }
};
