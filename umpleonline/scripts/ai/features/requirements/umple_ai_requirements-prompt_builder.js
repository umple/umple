// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Requirements Prompt Builder Module - Build prompts for requirements-driven generation

const RequirementsPromptBuilder = (() => {
  "use strict";

  function formatRequirements(requirements) {
    return (requirements || [])
      .map(r => `Requirement ${r.id}:\n${(r.text || "").trim()}`)
      .join("\n\n");
  }

  function inferExampleTags(generationType) {
    if (generationType === "statemachine") return ["statemachine", "actions", "guards", "timed"];
    if (generationType === "classdiagram") return ["classdiagram", "associations", "attributes"];
    return [];
  }

  function selectExamples(generationType, limit) {
    if (typeof AiPromptExamples === "undefined") return [];
    const tags = inferExampleTags(generationType);
    return AiPromptExamples.getExamplesByTags(tags, limit);
  }

  function buildOutputContract({ generationType, expectedRequirementIds }) {
    const reqs = (expectedRequirementIds || []).join(", ");
    const reqRule = reqs
      ? `- You MUST include implementsReq for: ${reqs} (on the generated class(es) and/or association/state machine as appropriate).`
      : "- If requirement IDs are provided, include implementsReq for them.";

    const typeRule = generationType === "statemachine"
      ? "- Include at least one class with a state machine using Umple syntax (state/status/sm/flow are acceptable if valid)."
      : generationType === "classdiagram"
        ? "- Include classes/attributes and associations if implied by the requirements."
        : "";

    return `## Output contract (follow strictly)

- Output ONLY Umple code.
- Output EXACTLY ONE fenced code block with language \"umple\":
  \`\`\`umple
  ...
  \`\`\`
- No prose before or after the code block.
${reqRule}
${typeRule}
- Do NOT output position blocks, diagram layout, or @@@skip* directives unless explicitly requested.
- If you must assume something, add a single-line comment inside the code: // Assumption: ...`;
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
    buildGeneration(requirements, generationType) {
      const expectedRequirementIds = (requirements || []).map(r => r.id).filter(Boolean);
      const reqText = formatRequirements(requirements);
      const examples = selectExamples(generationType, generationType === "statemachine" ? 2 : 1);

      const taskLine = generationType === "classdiagram"
        ? "Generate Umple for a class diagram (classes, attributes, associations)."
        : "Generate Umple for a state machine (states, events, transitions, guards/actions if relevant).";

      const cheatSheet = (typeof AiPrompting !== "undefined" && AiPrompting.getUmpleCheatSheet)
        ? AiPrompting.getUmpleCheatSheet()
        : "";

      const examplesText = (typeof AiPrompting !== "undefined" && AiPrompting.formatFewShotExamples)
        ? AiPrompting.formatFewShotExamples(examples)
        : "";

      const systemPrompt = (() => {
        const base = (typeof AiPrompting !== "undefined" && AiPrompting.getBaseSystemPrompt)
          ? AiPrompting.getBaseSystemPrompt()
          : "You are an expert in Umple modeling language.";

        return `${base}\n\nYour job is to generate ONLY valid Umple code.`;
      })();

      const prompt = `## Task\n\n${taskLine}\n\n## Requirements\n\n${reqText}\n\n## Umple quick reference\n\n${cheatSheet}\n\n${examplesText}\n\n${buildOutputContract({ generationType, expectedRequirementIds })}`;

      return { prompt, systemPrompt, expectedRequirementIds };
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

    buildRepairPrompt({ generationType, requirements, invalidCode, errors } = {}) {
      const expectedRequirementIds = (requirements || []).map(r => r.id).filter(Boolean);
      const reqText = formatRequirements(requirements);
      const errorText = (errors || []).map(e => `- ${e}`).join("\n");

      return `You generated invalid or incomplete Umple. Fix it.\n\n## Requirements\n\n${reqText}\n\n## Problems to fix\n\n${errorText}\n\n## Invalid output\n\n\`\`\`umple\n${(invalidCode || "").trim()}\n\`\`\`\n\n${buildOutputContract({ generationType, expectedRequirementIds })}`;
    }
  };
})();
