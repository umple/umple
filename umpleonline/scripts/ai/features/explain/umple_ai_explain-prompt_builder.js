// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Explain Prompt Builder Module - Build prompts for code explanation

const ExplainPromptBuilder = (() => {
  "use strict";

  // ============================================================================
  // CONSTANTS
  // ============================================================================

  const MIN_EXPLANATION_LENGTH = 50;

  const SYSTEM_PROMPT = (() => {
    const base = (typeof AiPrompting !== "undefined" && AiPrompting.getBaseSystemPrompt)
      ? AiPrompting.getBaseSystemPrompt()
      : "You are an expert in Umple (https://cruise.umple.org/umple/): its textual modeling syntax, class/state-machine/traits/aspects, associations & multiplicities, constraints, generation targets (Java/PHP/… as supported by Umple), and common Umple patterns.";

    return `${base}\n\nYour job is to explain any Umple snippet (or mixed Umple + generated code) clearly and accurately.`;
  })();

  const INITIAL_PROMPT_TEMPLATE = `Explain the following Umple code.

## Goals

- Explain what the model/code means (domain intent), not just what each line says
- Make the explanation accessible to a reader with limited modeling or coding background
- Preserve correctness: be precise and accurate, do not invent features
- If something is ambiguous or invalid Umple, say so and propose fixes

## Response Structure (follow strictly)

1. **One-sentence summary** of what the snippet models/does

2. **Key elements** (bullet list covering only relevant constructs present):
   - Classes / attributes / methods
   - Associations (role names, multiplicities, navigability, qualifiers)
   - Inheritance / traits
   - State machines (states, events, guards, actions, entry/exit)
   - Constraints (pre/post/invariants), if present
   - Code generation implications (what fields/methods will be generated, lifecycle methods, association management methods)

3. **Walkthrough**: Explain the snippet in small chunks, in plain language
   - Avoid jargon; if you must use a term (e.g., multiplicity, guard), define it in one sentence

4. **Concrete example**: Show a tiny scenario with example objects or a short event sequence demonstrating behavior (especially for associations or state machines)

5. **Pitfalls & improvements** (only if applicable):
   - List likely mistakes, ambiguities, or better modeling choices
   - Provide corrected Umple snippets when helpful

## Rules

- Be precise and accurate in your explanations
- Do not assume missing context
- Keep output concise but complete
- Prefer clear bullets over long paragraphs
- If the snippet includes errors, point to the exact part and explain what Umple expects instead
- Use markdown formatting (headers, bullets, code blocks) for readability

## Code to Explain

\`\`\`umple
{{code}}
\`\`\`

## Your Response

Provide your explanation following the structure above:`;

  const FOLLOW_UP_PROMPT_TEMPLATE = `{{conversationHistory}}

User: {{userQuestion}}

Answer based on the original Umple code and previous explanation. Be precise and accurate. Reference specific code elements.

Assistant:`;

  // ============================================================================
  // MARKDOWN REGEX PATTERNS
  // ============================================================================

  const MARKDOWN_PATTERNS = {
    codeBlock: /```(\w+)?\s*([\s\S]*?)```/g,
    inlineCode: /`([^`]+)`/g,
    bold: /\*\*([^*]+)\*\*/g,
    italic: /\*([^*]+)\*/g,
    lineBreak: /\n/g
  };

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
      let formatted = this.escapeHtml(explanationText);

      // Apply markdown transformations in order
      formatted = formatted
        .replace(MARKDOWN_PATTERNS.codeBlock, "<pre><code>$2</code></pre>")
        .replace(MARKDOWN_PATTERNS.inlineCode, "<code>$1</code>")
        .replace(MARKDOWN_PATTERNS.bold, "<strong>$1</strong>")
        .replace(MARKDOWN_PATTERNS.italic, "<em>$1</em>")
        .replace(MARKDOWN_PATTERNS.lineBreak, "<br/>");

      return formatted;
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
      const tempElement = document.createElement("div");
      tempElement.textContent = text;
      return tempElement.innerHTML;
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
