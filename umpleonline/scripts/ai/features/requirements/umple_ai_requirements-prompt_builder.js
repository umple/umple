// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Requirements Prompt Builder Module - Build prompts for requirements-driven generation

const RequirementsPromptBuilder = (() => {
  "use strict";

  function buildRequirementsPrimer(expectedRequirementIds = []) {
    const ids = (expectedRequirementIds || []).filter(Boolean);
    const idsText = ids.length > 0 ? ids.join(", ") : "<ReqId>";

    return `In Umple, requirements are declared separately using:

- req R01 { ... }   // requirement definition (already present in the editor input)

To indicate that a model element implements requirement(s), use implementsReq. It can appear:

- At top-level, before a class/trait/interface (tags the next entity)
- Inside a class, before a member (tags the next member)
- On the same line as an attribute/association end (tags that member)

Multiple requirements can be listed, comma-separated:

- implementsReq ${idsText};

Example placements (for illustration only):

1) Tag a class:
   implementsReq R01;
   class Example { }

2) Tag a specific attribute:
   class Example {
     totalAmount;
     paidAmount; implementsReq R02, R03;
   }

3) Tag an association and a state machine:
   class Order {
     implementsReq R04;
     1 -> 1 Customer;

     implementsReq R05;
     sm { s1 { e -> s2; } s2 { } }
   }

Important: When generating from requirements, do NOT re-output the req { ... } blocks; generate the model (classes/associations/state machines) and add implementsReq tags to trace back to the requirement IDs.`;
  }

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

  function buildBlockOnlyOutputContract({ generationType, expectedRequirementIds }) {
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

- Output ONLY the corrected generated block (not the user's full model).
- Output EXACTLY ONE fenced code block with language \"umple\":
  \`\`\`umple
  ...
  \`\`\`
- No prose before or after the code block.
${reqRule}
${typeRule}
- Do NOT re-output any req { ... } blocks.
- Do NOT change or reference line-numbered edits in the user's original code; fix only the generated block.
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
      const primer = buildRequirementsPrimer(expectedRequirementIds);

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

      const prompt = `## Task\n\n${taskLine}\n\n## Requirements\n\n${reqText}\n\n## How to use requirements in Umple\n\n${primer}\n\n## Umple quick reference\n\n${cheatSheet}\n\n${examplesText}\n\n${buildOutputContract({ generationType, expectedRequirementIds })}`;

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
      const primer = buildRequirementsPrimer(expectedRequirementIds);

      return `You generated invalid or incomplete Umple. Fix it.\n\n## Requirements\n\n${reqText}\n\n## How to use requirements in Umple\n\n${primer}\n\n## Problems to fix\n\n${errorText}\n\n## Invalid output\n\n\`\`\`umple\n${(invalidCode || "").trim()}\n\`\`\`\n\n${buildOutputContract({ generationType, expectedRequirementIds })}`;
    },

    buildCompilerRepairPrompt({ generationType, requirements, originalCode, invalidBlock, compilerIssuesText } = {}) {
      const expectedRequirementIds = (requirements || []).map(r => r.id).filter(Boolean);
      const reqText = formatRequirements(requirements);
      const primer = buildRequirementsPrimer(expectedRequirementIds);

      const cheatSheet = (typeof AiPrompting !== "undefined" && AiPrompting.getUmpleCheatSheet)
        ? AiPrompting.getUmpleCheatSheet()
        : "";

      const original = (originalCode || "").trim();
      const originalTrimmed = original.length > 8000
        ? `${original.slice(0, 8000)}\n\n// Assumption: Original model truncated for prompt size.`
        : original;

      const issues = (compilerIssuesText || "").trim();
      const issuesBlock = issues
        ? `\n\n## Compiler issues (errors/warnings)\n\n${issues}`
        : "\n\n## Compiler issues (errors/warnings)\n\n- (No details provided)";

      return `You generated an Umple block from requirements, then it was inserted into a user's existing Umple model and compiled.

Fix the GENERATED BLOCK ONLY so that, after insertion into the original model, the compiler reports no errors and no warnings.

## Requirements

${reqText}

## How to use requirements in Umple

${primer}

## Original model (read-only context)

\`\`\`umple
${originalTrimmed}
\`\`\`

## Current generated block (to fix)

\`\`\`umple
${(invalidBlock || "").trim()}
\`\`\`
${issuesBlock}

## Umple quick reference

${cheatSheet}

${buildBlockOnlyOutputContract({ generationType, expectedRequirementIds })}`;
    }
  };
})();
