// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Requirements Prompt Builder Module - Build prompts for requirements-driven generation

const RequirementsPromptBuilder = (() => {
  "use strict";

  const Tags = (typeof AiPromptTags !== "undefined") ? AiPromptTags : null;
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
    const keys = ["requirements", ...getGuidanceKeysForGenerationType(generationType)];
    await Promise.all(keys.map(k => ensureGuidanceLoaded(k)));
  }

  async function preloadRepairGuidance(generationType) {
    const keys = ["requirements", ...getGuidanceKeysForGenerationType(generationType)];
    await Promise.all(keys.map(k => ensureGuidanceLoaded(k)));
  }

  function formatRequirements(requirements) {
    return (requirements || [])
      .map(r => `Requirement ${r.id}:\n${(r.text || "").trim()}`)
      .join("\n\n");
  }

  function getSystemPrompt(generationType) {
    const base = (typeof AiPrompting !== "undefined" && AiPrompting.getBaseSystemPrompt)
      ? AiPrompting.getBaseSystemPrompt()
      : "You are an expert in Umple modeling language.";

    return joinBlocks([
      block("system", base, { allowEmpty: true }),
      block("how_to_use_requirements_in_umple", getGuidanceText("requirements"), { allowEmpty: true }),
      ...getGuidanceBlocksForGenerationType(generationType),
      block("directive", "Your job is to generate ONLY valid Umple code.")
    ]);
  }

  function getRepairSystemPrompt(generationType) {
    const base = (typeof AiPrompting !== "undefined" && AiPrompting.getBaseSystemPrompt)
      ? AiPrompting.getBaseSystemPrompt()
      : "You are an expert in Umple modeling language.";

    return joinBlocks([
      block("system", base, { allowEmpty: true }),
      block("role", "You are debugging Umple code. Your task is to FIX compiler errors in a generated block so it compiles cleanly when inserted into the user's existing model."),
      block("how_to_use_requirements_in_umple", getGuidanceText("requirements"), { allowEmpty: true }),
      ...getGuidanceBlocksForGenerationType(generationType),
      block("umple_quick_reference", getCheatSheet(), { allowEmpty: true }),
      block("repair_strategy", [
        "1. Analyze the compiler error message carefully",
        "2. Check for simple typos (misspellings, missing punctuation, incorrect identifiers)",
        "3. Verify syntax against Umple quick reference",
        "4. Ensure the fix doesn't break existing model elements",
        "5. Preserve all implementsReq tags from the original block"
      ].join("\n"))
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

  function getRequirementRule(expectedRequirementIds, mode = "initial") {
    const reqs = (expectedRequirementIds || []).join(", ");
    if (mode === "repair" && !reqs) {
      return "- If requirement IDs are provided, include implementsReq for them.";
    }
    const verb = mode === "repair" ? "need to" : "MUST";
    return `- You ${verb} include implementsReq for: ${reqs} (on the generated class(es) and/or association/sm as appropriate).`;
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

  function buildCommonConstraintRules() {
    return [
      "- Do NOT re-output any req { ... } blocks.",
      "- Do NOT re-output the user's existing model; output ONLY the new model elements to insert.",
      "- Do NOT output position blocks, diagram layout, or @@@skip* directives unless explicitly requested.",
      "- If you must assume something, add a single-line comment inside the code: // Assumption: ..."
    ];
  }

  function buildCommonGuidanceBlocks(generationType) {
    return [
      block("umple_quick_reference", getCheatSheet(), { allowEmpty: true })
    ];
  }

  function buildOutputContract({ generationType, expectedRequirementIds }) {
    return [
      ...buildCommonOutputRules(),
      getRequirementRule(expectedRequirementIds, "initial"),
      getTypeRule(generationType),
      ...buildCommonConstraintRules()
    ].filter(Boolean).join("\n");
  }

  function repair_buildOutputContract({ generationType, expectedRequirementIds }) {
    return [
      ...buildCommonOutputRules(),
      getRequirementRule(expectedRequirementIds, "repair"),
      getTypeRule(generationType),
      "- Do NOT re-output any req { ... } blocks.",
      "- Do NOT re-output the user's existing model; output ONLY the corrected generated block.",
      "- Do NOT change or reference line-numbered edits in the user's original code; fix only the generated block.",
      "- If you must assume something, add a single-line comment inside the code: // Assumption: ..."
    ].filter(Boolean).join("\n");
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

  function validateGenerationShape(code, generationType) {
    const errors = [];
    const hasClassOrAssoc = /\b(class|association)\b/.test(code);
    if (!hasClassOrAssoc) errors.push("No class or association definition found");

    if (generationType === "statemachine") {
      const hasSm = /\b(sm|state|status|flow)\s*\{/.test(code);
      if (!hasSm) errors.push("No state machine block found (expected state/status/sm/flow)");
    }

    return errors;
  }

  return {
    preloadGuidance(generationType) {
      return preloadGuidance(generationType);
    },

    preloadRepairGuidance(generationType) {
      return preloadRepairGuidance(generationType);
    },

    buildGeneration(requirements, generationType) {
      const expectedRequirementIds = (requirements || []).map(r => r.id).filter(Boolean);
      const reqText = formatRequirements(requirements);

      const prompt = joinBlocks([
        block("task", getTaskLine(generationType)),
        block("requirements", reqText, { allowEmpty: true }),
        ...buildCommonGuidanceBlocks(generationType),
        block("output_contract", buildOutputContract({ generationType, expectedRequirementIds }))
      ]);

      return { prompt, systemPrompt: getSystemPrompt(generationType), expectedRequirementIds };
    },

    validateGeneratedUmple({ code, expectedRequirementIds = [], generationType } = {}) {
      const errors = [];
      const text = (code || "").trim();
      if (!text) return { valid: false, errors: ["Generated code is empty"] };

      if (!validateBalancedBraces(text)) errors.push("Unbalanced braces in generated code");
      errors.push(...validateGenerationShape(text, generationType));
      errors.push(...validateImplementsReq(text, expectedRequirementIds));

      return { valid: errors.length === 0, errors };
    },

    repair_buildGeneration({ generationType, requirements, originalCode, invalidBlock, compilerIssuesText } = {}) {
      const expectedRequirementIds = (requirements || []).map(r => r.id).filter(Boolean);
      const reqText = formatRequirements(requirements);

      const original = (originalCode || "").trim();
      const originalTrimmed = original.length > 8000
        ? `${original.slice(0, 8000)}\n\n// Assumption: Original model truncated for prompt size.`
        : original;

      const issues = (compilerIssuesText || "").trim();
      const issuesText = issues ? `Compiler issues with code snippets:\n${issues}` : "- (No details provided)";

      const prompt = joinBlocks([
        block(
          "task",
          "You generated an Umple block from requirements, then it was inserted into a user's existing Umple model and compiled.\n\nFix the GENERATED BLOCK ONLY so that, after insertion into the original model, the compiler reports no errors and no warnings."
        ),
        block("compiler_issues_errors_warnings", issuesText),
        block("current_generated_block_to_fix", `\`\`\`umple\n${(invalidBlock || "").trim()}\n\`\`\``),
        block("original_model_read_only_context", `\`\`\`umple\n${originalTrimmed}\n\`\`\``),
        block("requirements", reqText, { allowEmpty: true }),
        block("output_contract", repair_buildOutputContract({ generationType, expectedRequirementIds }))
      ]);

      return {
        prompt,
        systemPrompt: getRepairSystemPrompt(generationType),
        expectedRequirementIds
      };
    }
  };
})();
