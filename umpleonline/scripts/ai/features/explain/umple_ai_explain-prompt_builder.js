// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Explain Prompt Builder Module - Build prompts for code explanation

const ExplainPromptBuilder = (() => {
  "use strict";

  const Tags = (typeof AiPromptUtils !== "undefined") ? AiPromptUtils : null;
  const block = (title, content, opts) => (Tags && Tags.block) ? Tags.block(title, content, opts) : String(content || "").trim();
  const joinBlocks = (blocks, opts) => (Tags && Tags.joinBlocks) ? Tags.joinBlocks(blocks, opts) : (blocks || []).filter(Boolean).join("\n\n");

  // Use shared markdown renderer if available
  const Markdown = (typeof AiMarkdownUtils !== "undefined") ? AiMarkdownUtils : null;

  // ============================================================================
  // CONSTANTS
  // ============================================================================

  const MIN_EXPLANATION_LENGTH = 50;

  const SYSTEM_PROMPT = (() => {
    const base = (typeof AiPrompting !== "undefined" && AiPrompting.getBaseSystemPrompt)
      ? AiPrompting.getBaseSystemPrompt()
      : "You are an expert in Umple (https://cruise.umple.org/umple/): its textual modeling syntax, class/state-machine/traits/aspects, associations & multiplicities, constraints, generation targets (Java/PHP/… as supported by Umple), and common Umple patterns.";

    return joinBlocks([
      block("system", base, { allowEmpty: true }),
      block("directive", "Your job is to explain any Umple snippet (or mixed Umple + generated code) clearly and accurately."),
      block("goals", [
        "- Preserve correctness: be precise and accurate, do not invent features"
      ]),
      block("rules", [
        "- Your audience are familiar with modeling and have basic coding background",
        "- Be precise and accurate in your explanations",
        "- Do not assume missing context",
        "- Keep output concise but complete",
        "- Use markdown syntax (level 2 headings `##` for all section titles)",
        "- Only summary-style content should have bullet points; avoid bullet points in most cases"
      ])
    ]);
  })();

  const INITIAL_PROMPT_TEMPLATE = joinBlocks([
    block("task", "Explain the following Umple code."),
    block("response_structure_follow_strictly", [
      "1. ## Summary: A one-sentence summary of what the snippet models/does",
      "2. ## Walkthrough: Explain the Umple code in plain language, and provide a high-level workflow explanation.",
      "3. Use level 2 headings (`## Title`) for all section titles in your response",
    ]),
    block("code_to_explain", "```umple\n{{code}}\n```"),
    block("your_response", "Provide your explanation following the structure above.")
  ]);

  const FOLLOW_UP_PROMPT_TEMPLATE = joinBlocks([
    block("conversation_history", "{{conversationHistory}}", { allowEmpty: true }),
    block("user_question", "{{userQuestion}}"),
    block("instructions", [
      "Answer based on the original Umple code and previous explanation. Be precise and accurate. Reference specific code elements."
    ])
  ]);

  // ============================================================================
  // PUBLIC API
  // ============================================================================

  return {
    /**
     * Get system prompt for code explanation
     * @returns {string} System prompt
     */
    getSystemPrompt() {
      return SYSTEM_PROMPT;
    },

    /**
     * Build initial explanation prompt
     * @param {string} umpleCode - The Umple code to explain
     * @returns {string} Complete prompt for code explanation
     */
    buildInitialPrompt(umpleCode) {
      return INITIAL_PROMPT_TEMPLATE.replace(/\{\{code\}\}/g, umpleCode);
    },

    /**
     * Build follow-up prompt with conversation context
     * @param {Array<Object>} conversationHistory - Array of conversation messages
     * @param {string} userQuestion - User's follow-up question
     * @returns {string} Complete prompt for follow-up
     */
    buildFollowUpPrompt(conversationHistory, userQuestion) {
      const formattedHistory = this.formatConversationHistory(conversationHistory);

      return FOLLOW_UP_PROMPT_TEMPLATE
        .replace(/\{\{conversationHistory\}\}/g, formattedHistory)
        .replace(/\{\{userQuestion\}\}/g, userQuestion);
    },

    /**
     * Format explanation with basic markdown-like formatting
     * @param {string} explanationText - Explanation text to format
     * @returns {string} Formatted HTML
     */
    formatExplanation(explanationText) {
      return (Markdown && typeof Markdown.render === "function")
        ? Markdown.render(explanationText)
        : (explanationText || "");
    },

    /**
     * Build custom prompt with template
     * @param {string} template - Prompt template with {{code}} placeholder
     * @param {string} umpleCode - The Umple code
     * @param {Object} additionalVariables - Additional template variables (optional)
     * @returns {string} Custom prompt with all variables replaced
     */
    buildCustomPrompt(template, umpleCode, additionalVariables = {}) {
      let prompt = template.replace(/\{\{code\}\}/g, umpleCode);

      // Replace additional template variables
      Object.entries(additionalVariables).forEach(([key, value]) => {
        const placeholderPattern = new RegExp(`\\{\\{${key}\\}\\}`, "g");
        prompt = prompt.replace(placeholderPattern, value);
      });

      return prompt;
    },

    /**
     * Validate explanation response
     * @param {string} explanation - Generated explanation text
     * @returns {Object} Validation result with valid flag and errors array
     */
    validateExplanation(explanation) {
      const errors = this.collectValidationErrors(explanation);

      return {
        valid: errors.length === 0,
        errors
      };
    },

    // ==========================================================================
    // PRIVATE HELPERS
    // ==========================================================================

    /**
     * Format conversation history into text format
     * @private
     * @param {Array<Object>} conversationHistory - Array of conversation messages
     * @returns {string} Formatted conversation history
     */
    formatConversationHistory(conversationHistory) {
      return conversationHistory
        .map(message => `${message.role}: ${message.content}`)
        .join("\n\n");
    },

    /**
     * Escape HTML special characters to prevent XSS
     * @private
     * @param {string} text - Text to escape
     * @returns {string} HTML-escaped text
     */
    escapeHtml(text) {
      return AiTextUtils.escapeHtml(text);
    },

    /**
     * Collect validation errors for explanation text
     * @private
     * @param {string} explanation - Explanation text to validate
     * @returns {Array<string>} Array of error messages (empty if valid)
     */
    collectValidationErrors(explanation) {
      const errors = [];

      // Check for empty or whitespace-only content
      if (!explanation || explanation.trim().length === 0) {
        errors.push("Explanation is empty");
        return errors; // Early return for empty explanations
      }

      // Check minimum length requirement
      if (explanation.length < MIN_EXPLANATION_LENGTH) {
        errors.push("Explanation seems too short to be useful");
      }

      return errors;
    }
  };
})();
