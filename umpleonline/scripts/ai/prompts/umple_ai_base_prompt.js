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
- Follow the output contract exactly.
- When the user prompt includes tagged sections like <tag> ... <\\tag>, read each section only from its opening tag to its matching closing tag and do not merge content across blocks.
- Never name attributes identical to the class name.`;

  const UMPLE_CHEAT_SHEET = `Umple quick reference (non-exhaustive):

- Classes: \`class Name { Type a; Type a = default; method(p){ ... } isA Super, I, Trait; }\`
- Interfaces/Traits: \`interface I { Type m(p); }\`  \`trait T { ... }\`  \`class C { isA I, T; }\`
- Enums: \`enum E { A, B }\`
- Associations: \`1 -- * Other;\`  \`* role -- 0..1 Other otherRole;\`  \`1 -> * Other;\`  \`association { 1 A -> * B; }\`
- Multiplicity: \`1\`  \`0..1\`  \`*\`  \`1..*\`  \`m..n\`
- Constraints: \`[booleanExpr]\` on model/attr/assoc/transition
- State machines: \`sm { S1 { e -> S2; } }\`  \`state { initial { -> S1; } S1 { e -> S2; } }\`  \`status { S1 { e(p) [g] / { a; } -> S2; } }\`
- State actions: \`entry / { ... }\`  \`exit / { ... }\`  \`do { ... }\`
- Auto-transition: \`S { -> Next; }\`
- Timed transitions: \`after(msExpr) -> Next;\`  \`afterEvery(msExpr) -> State;\`
- Orthogonal regions: \`Composite { R1 { ... } || R2 { ... } }\`
- Reusable SM: \`statemachine SM { ... }\`  \`class C { st as SM; }\`
- Requirements: \`req R1 { text }\`  \`implementsReq R1, R2;\`
- Composition/features: \`use "file.ump";\`  \`use Mixset;\`  \`use !Mixset;\`  \`require MixsetA;\`  \`generate Target;\`
`;

  const PROMPT_TEXT_CACHE = Object.create(null);
  const PROMPT_LOADERS = Object.create(null);

  function sanitizePromptText(text) {
    const raw = String(text || "").replace(/^\uFEFF/, "");
    const lines = raw.split(/\r?\n/);

    // Some prompt .md sources may accidentally end with an extra standalone code fence.
    while (lines.length > 0 && !lines[lines.length - 1].trim()) lines.pop();
    while (lines.length > 0 && /^```+\s*$/.test(lines[lines.length - 1].trim())) lines.pop();

    return lines.join("\n").trim();
  }

  function fetchText(url) {
    const resolvedUrl = String(url || "").trim();
    if (!resolvedUrl) return Promise.reject(new Error("Prompt URL is empty"));

    if (typeof fetch === "function") {
      return fetch(resolvedUrl)
        .then(r => {
          if (!r.ok) throw new Error(`Failed to load prompt (${r.status}): ${resolvedUrl}`);
          return r.text();
        })
        .then(sanitizePromptText);
    }

    return new Promise((resolve, reject) => {
      try {
        const xhr = new XMLHttpRequest();
        xhr.open("GET", resolvedUrl, true);
        xhr.onreadystatechange = () => {
          if (xhr.readyState !== 4) return;
          if (xhr.status >= 200 && xhr.status < 300) {
            resolve(sanitizePromptText(xhr.responseText));
          } else {
            reject(new Error(`Failed to load prompt (${xhr.status}): ${resolvedUrl}`));
          }
        };
        xhr.send(null);
      } catch (e) {
        reject(e);
      }
    });
  }

  function getPromptText(url) {
    const key = String(url || "").trim();
    if (!key) return Promise.reject(new Error("Prompt URL is empty"));
    if (PROMPT_TEXT_CACHE[key]) return Promise.resolve(PROMPT_TEXT_CACHE[key]);
    if (PROMPT_LOADERS[key]) return PROMPT_LOADERS[key];

    PROMPT_LOADERS[key] = fetchText(key)
      .then(text => {
        PROMPT_TEXT_CACHE[key] = text;
        delete PROMPT_LOADERS[key];
        return text;
      })
      .catch(err => {
        delete PROMPT_LOADERS[key];
        throw err;
      });

    return PROMPT_LOADERS[key];
  }

  function formatFewShotExamples(examples) {
    if (!examples || examples.length === 0) return "";
    return examples
      .map(ex => {
        const title = (ex && ex.title) ? `Example: ${ex.title}` : "Example:";
        return `${title}\n\n\`\`\`umple\n${(ex && ex.code) ? ex.code : ""}\n\`\`\``;
      })
      .join("\n\n");
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
    },

    getPromptText(url) {
      return getPromptText(url);
    }
  };
})();
