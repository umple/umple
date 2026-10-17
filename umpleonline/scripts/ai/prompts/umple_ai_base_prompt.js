// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Prompting - Shared, global prompting primitives for Umple features

const AiPrompting = (() => {
  "use strict";

  const BASE_SYSTEM_PROMPT = `You are an expert in Umple (https://cruise.umple.org/umple/), a textual modeling language for classes, associations, and state machines.

Rules:
- Use only valid Umple syntax and only context provided in the prompt.
- If ambiguous, choose the simplest compilable model and add one inline comment: // Assumption: ...
- Follow the output contract exactly.
- When tagged blocks like <tag>...</tag> appear, read each block independently from opening to matching closing tag.
- Never name an attribute the same as its class.`;

  const UMPLE_CHEAT_SHEET = `Umple quick reference (minimal):

- Classes/attributes: \`class Name { Type a; Type b = value; isA Super, I, Trait; }\`
- Interfaces/traits: \`interface I { Type m(p); }\`  \`trait T { ... }\`
- Enums: \`enum E { A, B }\`
- Associations: \`1 -- * B;\`  \`1 -> * B;\`  \`association { 1 A -> * B; }\`  composition: \`1 <@>- * Part;\`
- Multiplicity: \`1\`  \`0..1\`  \`*\`  \`1..*\`  \`m..n\`
- State machine: \`sm { S1 { e(p) [g] / { a; } -> S2; } S2 {} }\`
- State actions: \`entry / { ... }\`  \`exit / { ... }\`  \`do { ... }\`  auto: \`-> Next;\`
- Advanced SM: \`queued sm { ... }\`  \`pooled sm { ... }\`  regions: \`A { ... } || B { ... }\`  history: \`Parent.H\` / \`Parent.HStar\`
- Final states: \`-> Final;\` or \`final Done {}\`
- Reuse SM: \`statemachine M { ... }\`  \`class C { x as M; }\`
- Requirements: \`req R1 { text }\`  \`implementsReq R1, R2;\`
- External type: \`external Type {}\`
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
          if (!r.ok) throw AiErrors.createPromptLoadError(resolvedUrl, r.status);
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
            reject(AiErrors.createPromptLoadError(resolvedUrl, xhr.status));
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

  return {
    getBaseSystemPrompt() {
      return BASE_SYSTEM_PROMPT;
    },

    getUmpleCheatSheet() {
      return UMPLE_CHEAT_SHEET;
    },

    getPromptText(url) {
      return getPromptText(url);
    }
  };
})();
