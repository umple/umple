// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Fix Prompt Builder Module - Build prompts for compiler error fix guidance

const FixPromptBuilder = (() => {
  "use strict";

  const Tags = (typeof AiPromptUtils !== "undefined") ? AiPromptUtils : null;
  const block = (title, content, opts) => (Tags && Tags.block) ? Tags.block(title, content, opts) : String(content || "").trim();
  const joinBlocks = (blocks, opts) => (Tags && Tags.joinBlocks) ? Tags.joinBlocks(blocks, opts) : (blocks || []).filter(Boolean).join("\n\n");

  // ============================================================================
  // CONSTANTS
  // ============================================================================

  const GUIDANCE_SOURCE = {
    url: "scripts/ai/prompts/fix_guidance_prompt.md",
    blockTitle: "umple_compiler_error_diagnosis_and_fix_guidance"
  };

  const MAX_TOKENS = 500;

  // ============================================================================
  // CACHING
  // ============================================================================

  const guidanceTextCache = Object.create(null);
  const guidanceLoader = Object.create(null);

  function getGuidanceText() {
    return String(guidanceTextCache.fix || "").trim();
  }

  function ensureGuidanceLoaded() {
    if (String(guidanceTextCache.fix || "").trim()) {
      return Promise.resolve(guidanceTextCache.fix);
    }
    if (guidanceLoader.fix) {
      return guidanceLoader.fix;
    }

    const loader = (typeof AiPrompting !== "undefined" && AiPrompting.getPromptText)
      ? AiPrompting.getPromptText
      : null;

    if (!loader) {
      return Promise.reject(new Error("AiPrompting.getPromptText is not available"));
    }

    guidanceLoader.fix = loader(GUIDANCE_SOURCE.url)
      .then(text => {
        guidanceTextCache.fix = text;
        delete guidanceLoader.fix;
        return text;
      })
      .catch(err => {
        delete guidanceLoader.fix;
        throw err;
      });

    return guidanceLoader.fix;
  }

  async function preloadGuidance() {
    return ensureGuidanceLoaded();
  }

  // ============================================================================
  // PROMPT BUILDING
  // ============================================================================

  function formatIssueSummary(issue) {
    const issueLine = Number.isFinite(issue?.line) ? issue.line : "?";
    return [
      `- severity: ${issue?.severity || ""}`,
      `- line: ${issueLine}`,
      `- errorCode: ${issue?.errorCode || ""}`,
      `- message: ${issue?.message || ""}`
    ].join("\n");
  }

  function formatIssueContext(context) {
    return context || "(no context available)";
  }

  function buildGuidancePrompt(issue, errorHtml) {
    const issueSummary = formatIssueSummary(issue);
    const context = formatIssueContext(issue?.context || "");

    return joinBlocks([
      block("task", [
        "Provide a short, concise description of how to fix this Umple compiler issue.",
        "First check for simple typos (misspellings, missing punctuation, or incorrect identifiers)."
      ]),
      block("compiler_issue", issueSummary),
      block("local_context_line_numbers_included", context),
      block(GUIDANCE_SOURCE.blockTitle, getGuidanceText()),
      block("umple_quick_reference", getCheatSheet()),
      block("output_contract_follow_strictly", [
        "- Output 1-2 short sentences, plain text only.",
        "- Do NOT output code or bullet points.",
        "- Do NOT mention that you are an AI model.",
        "- When referencing lines, use only: 'line N' or 'lines N-M' (N/M are numbers).",
        "- If it looks like a typo, mention the likely typo fix first.",
        "- Keep it actionable and specific to the error."
      ])
    ]);
  }

  function getSystemPrompt() {
    const base = (typeof AiPrompting !== "undefined" && AiPrompting.getBaseSystemPrompt)
      ? AiPrompting.getBaseSystemPrompt()
      : "You are an expert in Umple modeling language.";

    return joinBlocks([
      block("system", base, { allowEmpty: true }),
      block("directive", "Give concise, actionable fix guidance."),
      block("output_format", [
        "1. Examine the overall REPL correctness (such as typos or similar errors)",
        "2. Scan the issue-related errors, where the issue represents the compiler output errors",
        "",
        getGuidanceText()
      ])
    ]);
  }

  function getCheatSheet() {
    return (typeof AiPrompting !== "undefined" && AiPrompting.getUmpleCheatSheet)
      ? AiPrompting.getUmpleCheatSheet()
      : "";
  }

  // ============================================================================
  // TEXT PROCESSING
  // ============================================================================

  function cleanGuidanceText(text) {
    let output = String(text || "").trim();
    output = output.replace(/^[\-•*]\s+/g, "");
    output = output.replace(/```[\s\S]*?```/g, "").trim();
    output = output.replace(/\s+/g, " ");
    return output;
  }

  function formatGuidanceHtml(text) {
    const safe = escapeHtml(text);
    return safe.replace(/\bline(s)?\s+(\d+)(\s*[-–]\s*(\d+))?/gi, (match, plural, start) => {
      return `<a href="javascript:Action.setCaretPosition(${start});Action.updateLineNumberDisplay();">${match}</a>`;
    });
  }

  function escapeHtml(text) {
    return String(text || "")
      .replace(/&/g, "&amp;")
      .replace(/</g, "&lt;")
      .replace(/>/g, "&gt;")
      .replace(/"/g, "&quot;")
      .replace(/'/g, "&#39;");
  }

  // ============================================================================
  // PUBLIC API
  // ============================================================================

  return {
    /**
     * Preload the guidance file for fix feature
     * @returns {Promise<void>}
     */
    preloadGuidance() {
      return preloadGuidance();
    },

    /**
     * Build the complete guidance prompt for a compiler issue
     * @param {Object} issue - The compiler issue object with severity, line, errorCode, message
     * @param {string} errorHtml - Full compiler error HTML (optional)
     * @returns {Object} { prompt: string, systemPrompt: string }
     */
    buildGuidancePrompt(issue, errorHtml) {
      const prompt = buildGuidancePrompt(issue, errorHtml);
      const systemPrompt = getSystemPrompt();
      return { prompt, systemPrompt };
    },

    /**
     * Get the system prompt for fix guidance
     * @returns {string} System prompt
     */
    getSystemPrompt() {
      return getSystemPrompt();
    },

    /**
     * Clean the guidance text output from AI
     * @param {string} text - Raw guidance text from AI
     * @returns {string} Cleaned guidance text
     */
    cleanGuidanceText(text) {
      return cleanGuidanceText(text);
    },

    /**
     * Format guidance text as HTML with clickable line references
     * @param {string} text - Cleaned guidance text
     * @returns {string} HTML formatted guidance
     */
    formatGuidanceHtml(text) {
      return formatGuidanceHtml(text);
    }
  };
})();
