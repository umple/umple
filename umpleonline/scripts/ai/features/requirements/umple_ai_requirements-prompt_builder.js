// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Requirements Prompt Builder Module - Build prompts for requirements-driven generation

const RequirementsPromptBuilder = (() => {
  "use strict";

  const Tags = (typeof AiPromptUtils !== "undefined") ? AiPromptUtils : null;
  const block = (title, content, opts) => (Tags && Tags.block) ? Tags.block(title, content, opts) : String(content || "").trim();
  const joinBlocks = (blocks, opts) => (Tags && Tags.joinBlocks) ? Tags.joinBlocks(blocks, opts) : (blocks || []).filter(Boolean).join("\n\n");

  const GUIDANCE_SOURCES = {
    requirements: {
      url: "scripts/ai/prompts/requirement_guidance_prompt.md",
      blockTitle: "how_to_use_requirements_in_umple"
    },
    statemachine: {
      url: "scripts/ai/prompts/state_machine_guidance_prompt.md",
      blockTitle: "how_to_model_state_machines_in_umple"
    },
    classdiagram: {
      url: "scripts/ai/prompts/class_diagram_guidance_prompt.md",
      blockTitle: "how_to_model_class_diagrams_in_umple"
    },
    statemachine_system: {
      url: "scripts/ai/prompts/state_machine_system_prompt.md",
      blockTitle: "state_machine_critical_rules"
    },
    classdiagram_system: {
      url: "scripts/ai/prompts/class_diagram_system_prompt.md",
      blockTitle: "class_diagram_critical_rules"
    }
  };

  const guidanceTextCache = Object.create(null);
  const guidanceLoaders = Object.create(null);

  function getGuidanceText(key) {
    return String(guidanceTextCache[key] || "").trim();
  }

  function getGuidanceKeysForGenerationType(generationType) {
    if (generationType === "statemachine") return ["statemachine"];
    if (generationType === "classdiagram") return ["classdiagram"];
    return [];
  }

  function getSystemGuidanceKeysForGenerationType(generationType) {
    if (generationType === "statemachine") return ["statemachine_system"];
    if (generationType === "classdiagram") return ["classdiagram_system"];
    return [];
  }

  function getGuidanceBlocksForGenerationType(generationType) {
    const keys = getGuidanceKeysForGenerationType(generationType);
    return keys
      .map(key => {
        const src = GUIDANCE_SOURCES[key];
        if (!src) return "";
        const text = getGuidanceText(key);
        return text ? block(src.blockTitle, text) : "";
      })
      .filter(Boolean);
  }

  function getSystemGuidanceBlocksForGenerationType(generationType) {
    const keys = getSystemGuidanceKeysForGenerationType(generationType);
    return keys
      .map(key => {
        const src = GUIDANCE_SOURCES[key];
        if (!src) return "";
        const text = getGuidanceText(key);
        return text ? block(src.blockTitle, text) : "";
      })
      .filter(Boolean);
  }

  function ensureGuidanceLoaded(key) {
    if (String(guidanceTextCache[key] || "").trim()) return Promise.resolve(guidanceTextCache[key]);
    if (guidanceLoaders[key]) return guidanceLoaders[key];

    const src = GUIDANCE_SOURCES[key];
    const loader = (typeof AiPrompting !== "undefined" && AiPrompting.getPromptText)
      ? AiPrompting.getPromptText
      : null;

    if (!src) return Promise.reject(new Error(`Unknown guidance key: ${key}`));
    if (!loader) return Promise.reject(new Error("AiPrompting.getPromptText is not available"));

    guidanceLoaders[key] = loader(src.url)
      .then(text => {
        guidanceTextCache[key] = text;
        delete guidanceLoaders[key];
        return text;
      })
      .catch(err => {
        delete guidanceLoaders[key];
        throw err;
      });

    return guidanceLoaders[key];
  }

  async function preloadGuidance(generationType) {
    const keys = [
      "requirements",
      ...getGuidanceKeysForGenerationType(generationType),
      ...getSystemGuidanceKeysForGenerationType(generationType)
    ];
    await Promise.all(keys.map(k => ensureGuidanceLoaded(k)));
  }

  function formatRequirements(requirements) {
    return (requirements || [])
      .map(r => `Requirement ${r.id}:\n${(r.text || "").trim()}`)
      .join("\n\n");
  }

  function getSystemPrompt(generationType, requirementsText = "") {
    const base = (typeof AiPrompting !== "undefined" && AiPrompting.getBaseSystemPrompt)
      ? AiPrompting.getBaseSystemPrompt()
      : "You are an expert in Umple modeling language.";

    return joinBlocks([
      block("system", base, { allowEmpty: true }),
      ...getSystemGuidanceBlocksForGenerationType(generationType),
      ...getGuidanceBlocksForGenerationType(generationType),
      block("how_to_use_requirements_in_umple", getGuidanceText("requirements"), { allowEmpty: true }),
      block("requirements", requirementsText, { allowEmpty: true }),
      block("umple_quick_reference", getCheatSheet(), { allowEmpty: true })
    ]);
  }

  function getCheatSheet() {
    return (typeof AiPrompting !== "undefined" && AiPrompting.getUmpleCheatSheet)
      ? AiPrompting.getUmpleCheatSheet()
      : "";
  }

  function getTaskLine(generationType) {
    return generationType === "classdiagram"
      ? "Generate Umple for a class diagram (classes, attributes, associations)."
      : "Generate Umple for a state machine (states, events, transitions, guards/actions if relevant).";
  }

  function getTypeRule(generationType) {
    return generationType === "statemachine"
      ? "- Include at least one class with a state machine using Umple syntax (state/status/sm/flow are acceptable if valid)."
      : generationType === "classdiagram"
        ? "- Include classes/attributes and associations if implied by the requirements."
        : "";
  }

  function getRequirementRule(expectedRequirementIds) {
    const reqs = (expectedRequirementIds || []).join(", ");
    if (!reqs) return "";
    return `- You MUST include implementsReq for: ${reqs} (on the generated class(es) and/or association/sm as appropriate).`;
  }

  function buildCommonOutputRules() {
    return [
      "- Output ONLY Umple code.",
      "- Output EXACTLY ONE fenced code block with language \"umple\":",
      "  ```umple",
      "  ...",
      "  ```",
      "- No prose before or after the code block."
    ];
  }

  // Extra Umple features the user asked for (issue #2485)
  function buildOptionRules(options = {}) {
    const rules = [];
    if (options.includeMethods) {
      rules.push("- Also write the methods the requirements imply, with bodies in simple Java, e.g. Integer total() { ... }; only call generated methods (getX(), setX(...), addY(...), numberOfYs()) or methods you define.");
    }
    if (options.includeMain) {
      rules.push("- Add a demo method public static void main(String [ ] args) Java { ... } in one class that creates objects (or fires events) and prints them.");
    }
    return rules;
  }

  // The user's model without its req blocks, so the AI reuses existing classes (issue #2485)
  const MAX_EXISTING_MODEL_CHARS = 12000;
  function existingModelText(modelText) {
    const source = String(modelText || "");
    if (!source.trim()) return "";
    const blocks = (typeof AiTextUtils !== "undefined" && AiTextUtils.findRequirementBlocks)
      ? AiTextUtils.findRequirementBlocks(source)
      : [];
    let withoutReqs = source;
    for (let i = blocks.length - 1; i >= 0; i--) {
      withoutReqs = withoutReqs.slice(0, blocks[i].start) + withoutReqs.slice(blocks[i].end);
    }
    withoutReqs = withoutReqs.replace(/\n{3,}/g, "\n\n").trim();
    return withoutReqs.length > MAX_EXISTING_MODEL_CHARS
      ? withoutReqs.slice(0, MAX_EXISTING_MODEL_CHARS) + "\n// ... (model truncated)"
      : withoutReqs;
  }

  function buildExistingModelRules(modelText) {
    if (!existingModelText(modelText)) return [];
    return [
      "- The existing_model block shows the user's current model. Reuse its classes; do not declare a duplicate association or attribute.",
      "- To add members to an existing class, declare the class again with only the new members (Umple merges declarations of the same class)."
    ];
  }

  function buildCommonConstraintRules() {
    return [
      "- Do NOT re-output any req { ... } blocks.",
      "- Do NOT re-output the user's existing model; output ONLY the new model elements to insert.",
      "- Do NOT output position blocks, diagram layout, or @@@skip* directives unless explicitly requested.",
      "- If you must assume something, add a single-line comment inside the code: // Assumption: ..."
    ];
  }

  function buildOutputContract({ generationType, expectedRequirementIds, options = {} }) {
    return [
      ...buildCommonOutputRules(),
      getRequirementRule(expectedRequirementIds),
      getTypeRule(generationType),
      ...buildOptionRules(options),
      ...buildExistingModelRules(options.modelText),
      ...buildCommonConstraintRules()
    ].filter(Boolean).join("\n");
  }

  // Updating an already implemented requirement: the AI returns the whole updated model (issue #2485)
  function buildUpdateOutputContract({ generationType, expectedRequirementIds, options = {} }) {
    return [
      ...buildCommonOutputRules(),
      "- Output the COMPLETE updated model: every req block and every model element of the current_model, changed only where the new wording requires it.",
      "- Keep every req block, with its ID unchanged.",
      getRequirementRule(expectedRequirementIds),
      ...buildOptionRules(options),
      "- Do NOT output position blocks, diagram layout, or @@@skip* directives.",
      "- If you must assume something, add a single-line comment inside the code: // Assumption: ..."
    ].filter(Boolean).join("\n");
  }

  function buildUpdateRepairTaskBlock() {
    return [
      "You are debugging Umple code. Follow this workflow:",
      "",
      "1. Read the compiler_issues_errors_warnings",
      "2. Review the previous conversation for the updated model that needs fixing",
      "3. Read the requirements and output_contract",
      "4. Output the corrected COMPLETE updated model that satisfies all constraints"
    ].join("\n");
  }

  function buildRepairTaskBlock() {
    return [
      "You are debugging Umple code. Follow this workflow:",
      "",
      "1. Read the compiler_issues_errors_warnings",
      "2. Review the previous conversation for the generated block that needs fixing and the original model context",
      "3. Read the requirements and output_contract",
      "4. Generate corrected block that satisfies all constraints",
      "",
      "Important:",
      "- Output ONLY the corrected generated block, not the user's entire model",
      "- Do NOT change or reference line-numbered edits in the user's original code",
      "- Fix only the generated block from the conversation history"
    ].join("\n");
  }

  function validateResponseFormat(response) {
    const text = String(response || "");
    if (!text.trim()) return ["Response is empty"];

    const blocks = (typeof AiTextUtils !== "undefined" && AiTextUtils.parseCodeBlocks)
      ? AiTextUtils.parseCodeBlocks(text)
      : [];
    const codeBlocks = blocks.length > 0 ? blocks : [];
    const errors = [];

    if (codeBlocks.length !== 1) {
      errors.push(`Expected exactly one fenced code block, found ${codeBlocks.length}.`);
    } else {
      const language = codeBlocks[0].language;
      if (!language || language !== "umple") {
        errors.push(`Code block language must be "umple" (found "${language || "none"}").`);
      }
    }

    const outside = text.replace(/```[\s\S]*?```/g, "").trim();
    if (outside) {
      errors.push("Response contains text outside the code block.");
    }

    return errors;
  }

  function validateBalancedBraces(code) {
    const open = (code.match(/\{/g) || []).length;
    const close = (code.match(/\}/g) || []).length;
    return open === close;
  }

  function validateImplementsReq(code, expectedRequirementIds) {
    const ids = (expectedRequirementIds || []).filter(Boolean);
    if (ids.length === 0) return [];

    const errors = [];
    const implementsLines = code
      .split("\n")
      .filter(l => l.includes("implementsReq"));

    ids.forEach(id => {
      const idPattern = new RegExp(`\\b${id.replace(/[.*+?^${}()|[\\]\\]/g, "\\$&")}\\b`);
      const found = implementsLines.some(l => idPattern.test(l));
      if (!found) errors.push(`Missing implementsReq for requirement ${id}`);
    });

    return errors;
  }

  function validateOptions(code, options = {}) {
    const errors = [];
    if (options.includeMain && !/\bstatic\s+void\s+main\s*\(/.test(code)) {
      errors.push("No main method found (expected public static void main(String [ ] args) Java { ... })");
    }
    return errors;
  }

  function validateKeptRequirements(code, requirementIds = []) {
    if (requirementIds.length === 0 || typeof AiTextUtils === "undefined" || !AiTextUtils.findRequirementBlocks) return [];
    const kept = new Set(AiTextUtils.findRequirementBlocks(code).map(b => b.id));
    return requirementIds.filter(id => !kept.has(id)).map(id => `The updated model dropped the req block for ${id}`);
  }

  function validateGenerationShape(code, generationType) {
    const errors = [];
    const hasClassOrAssoc = /\b(class|association)\b/.test(code);
    if (!hasClassOrAssoc) errors.push("No class or association definition found");

    if (generationType === "statemachine") {
      // Accept regular/queued/pooled forms, with optional state-machine names.
      // Examples matched:
      // - sm { ... }
      // - queued sm { ... }
      // - queued sm Lifecycle { ... }
      // - state Engine { ... }
      const hasSm = /\b(?:(?:queued|pooled)\s+)?(?:sm|state|status|flow)\b(?:\s+[A-Za-z_][A-Za-z0-9_]*)?\s*\{/.test(code);
      if (!hasSm) errors.push("No state machine block found (expected state/status/sm/flow)");
    }

    return errors;
  }

  return {
    preloadGuidance(generationType) {
      return preloadGuidance(generationType);
    },

    /**
     * Validate generated Umple code.
     * Checks: empty code, balanced braces, expected structure, implementsReq tags.
     * @param {Object} params - {code, expectedRequirementIds, generationType}
     * @returns {Object} {valid: boolean, errors: Array<string>}
     */
    validateGeneratedUmple({ code, expectedRequirementIds = [], generationType, options = {}, keptRequirementIds = [] } = {}) {
      const errors = [];
      const text = (code || "").trim();
      if (!text) return { valid: false, errors: ["Generated code is empty"] };

      if (!validateBalancedBraces(text)) errors.push("Unbalanced braces in generated code");
      errors.push(...validateGenerationShape(text, generationType));
      errors.push(...validateImplementsReq(text, expectedRequirementIds));
      errors.push(...validateOptions(text, options));
      errors.push(...validateKeptRequirements(text, keptRequirementIds));

      return { valid: errors.length === 0, errors };
    },

    /**
     * Validate raw response format against output contract.
     * Checks: single umple code block, no extra text.
     * @param {string} response - Raw AI response
     * @returns {Array<string>} Array of validation errors (empty if valid)
     */
    validateResponseFormat(response) {
      return validateResponseFormat(response);
    },

    /**
     * Convert validation errors to pseudo-compiler error format for integration into compiler loop.
     * These appear as "Validation Error" type with line 1 (block-level issues).
     * @param {Object} params - {code, expectedRequirementIds, generationType}
     * @returns {Array<{severity: string, errorCode: string, message: string, line: number, isPseudoError: boolean}>} Array of pseudo-compiler error objects
     */
    getValidationAsCompilerErrors({ code, expectedRequirementIds = [], generationType, options = {}, keptRequirementIds = [] } = {}) {
      const validation = this.validateGeneratedUmple({ code, expectedRequirementIds, generationType, options, keptRequirementIds });
      if (validation.valid) return [];

      return validation.errors.map(err => ({
        severity: "Error",
        errorCode: "VALIDATION_ERROR",
        message: err,
        line: 1,
        isPseudoError: true
      }));
    },

    // options: { modelText, includeMethods, includeMain } (issue #2485)
    buildGeneration(requirements, generationType, options = {}) {
      const expectedRequirementIds = (requirements || []).map(r => r.id).filter(Boolean);
      const reqText = formatRequirements(requirements);
      const existing = existingModelText(options.modelText);

      const prompt = joinBlocks([
        block("task", getTaskLine(generationType)),
        block("existing_model", existing),
        block("output_contract", buildOutputContract({ generationType, expectedRequirementIds, options }))
      ]);

      return { prompt, systemPrompt: getSystemPrompt(generationType, reqText), expectedRequirementIds };
    },

    // A requirement that is already implemented changed wording: ask for the whole updated model.
    buildUpdate({ requirement, previousText, generationType, modelText, options = {} } = {}) {
      const expectedRequirementIds = requirement?.id ? [requirement.id] : [];
      const reqText = formatRequirements(requirement ? [requirement] : []);
      const task = [
        `Requirement ${requirement?.id} changed.`,
        `Previous wording: ${String(previousText || "").trim()}`,
        `New wording: ${String(requirement?.text || "").trim()}`,
        "Update the current_model so that it implements the new wording. Change only what the new wording requires."
      ].join("\n");

      const prompt = joinBlocks([
        block("task", task),
        block("current_model", String(modelText || "").trim()),
        block("output_contract", buildUpdateOutputContract({ generationType, expectedRequirementIds, options }))
      ]);

      return { prompt, systemPrompt: getSystemPrompt(generationType, reqText), expectedRequirementIds };
    },

    repair_buildGeneration({ generationType, requirements, compilerIssuesText, mode = "insert", options = {} } = {}) {
      const expectedRequirementIds = (requirements || []).map(r => r.id).filter(Boolean);
      const reqText = formatRequirements(requirements);

      const issues = (compilerIssuesText || "").trim();
      const issuesText = issues ? `Errors (compiler and validation) with code snippets:\n${issues}` : "- (No details provided)";

      const prompt = joinBlocks([
        block("task", mode === "replace" ? buildUpdateRepairTaskBlock() : buildRepairTaskBlock()),
        block("compiler_issues_errors_warnings", issuesText),
        block("output_contract", mode === "replace"
          ? buildUpdateOutputContract({ generationType, expectedRequirementIds, options })
          : buildOutputContract({ generationType, expectedRequirementIds, options }))
      ]);

      return {
        prompt,
        systemPrompt: getSystemPrompt(generationType, reqText),
        expectedRequirementIds
      };
    }
  };
})();
