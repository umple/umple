// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Prompt Utils - Shared, global utilities for building structured prompts using <tag>...<\tag>

const AiPromptUtils = (() => {
  "use strict";

  function normalizeTagName(name) {
    const raw = String(name || "").trim();
    const normalized = raw
      .toLowerCase()
      .replace(/[^a-z0-9_-]+/g, "_")
      .replace(/^_+/, "")
      .replace(/_+$/, "");

    return normalized || "section";
  }

  function toText(content) {
    if (content === null || content === undefined) return "";
    if (Array.isArray(content)) return content.filter(Boolean).map(String).join("\n");
    return String(content);
  }

  function block(title, content, { trimContent = true, allowEmpty = false } = {}) {
    const tag = normalizeTagName(title);
    let body = toText(content);
    if (trimContent) body = body.trim();
    if (!allowEmpty && !body) return "";
    return `<${tag}>\n${body}\n</${tag}>`;
  }

  function joinBlocks(blocks, { separator = "\n\n" } = {}) {
    return (blocks || []).filter(Boolean).join(separator);
  }

  return {
    normalizeTagName,
    block,
    joinBlocks
  };
})();
