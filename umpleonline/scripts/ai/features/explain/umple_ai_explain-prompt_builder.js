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
  const Markdown = (typeof AiMarkdownUtils !== "undefined") ? AiMarkdownUtils : null;

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

  return {
    getSystemPrompt() {
      return SYSTEM_PROMPT;
    },

    formatExplanation(explanationText) {
      return (Markdown && typeof Markdown.render === "function")
        ? Markdown.render(explanationText)
        : (explanationText || "");
    },

    validateExplanation(explanation) {
      const errors = this.collectValidationErrors(explanation);
      return {
        valid: errors.length === 0,
        errors
      };
    },

    collectValidationErrors(explanation) {
      const errors = [];
      if (!explanation || explanation.trim().length === 0) {
        errors.push("Explanation is empty");
        return errors;
      }

      if (explanation.length < MIN_EXPLANATION_LENGTH) {
        errors.push("Explanation seems too short to be useful");
      }

      return errors;
    }
  };
})();
