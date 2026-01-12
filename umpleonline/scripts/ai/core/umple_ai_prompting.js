// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Prompting - Shared, global prompting primitives for Umple features

const AiPrompting = (() => {
  "use strict";

  const BASE_SYSTEM_PROMPT = `You are an expert in Umple (https://cruise.umple.org/umple/): its textual modeling syntax for classes, associations, and state machines.

Rules:
- Do not invent Umple syntax or project context.
- If something is ambiguous, choose the simplest valid Umple and note assumptions inside Umple comments.
- Follow the output contract exactly.`;

  const UMPLE_CHEAT_SHEET = `Umple quick reference (non-exhaustive):

- Classes:
  class Name { attribute; Type attr = default; method(...) { ... } }
- Associations:
  1 -- * OtherClass;
  * roleName -- 0..1 OtherClass otherRole;
  association { 1 A -> * B; }
- State machines:
  state { initial { -> s1; } s1 { event -> s2; } }
  status { s1 { event [guard] / { action; } -> s2; } }
  entry / { ... }  exit / { ... }
  after(msExpr) -> next;  afterEvery(msExpr) -> state;
`;

  function formatFewShotExamples(examples) {
    if (!examples || examples.length === 0) return "";
    const blocks = examples
      .map(ex => `### ${ex.title}\n\n\`\`\`umple\n${ex.code}\n\`\`\``)
      .join("\n\n");
    return `## Examples (style to follow)\n\n${blocks}`;
  }

  return {
    getBaseSystemPrompt() {
      return BASE_SYSTEM_PROMPT;
    },

    getUmpleCheatSheet() {
      return UMPLE_CHEAT_SHEET;
    },

    formatFewShotExamples(examples) {
      return formatFewShotExamples(examples);
    }
  };
})();
