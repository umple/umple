// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Provider Utils - provider-agnostic helper logic

var _aiGlobal = (typeof window !== "undefined") ? window : globalThis;

var AiProviderUtils = _aiGlobal.AiProviderUtils || {
  _compareIntArrays(a, b) {
    const aArr = Array.isArray(a) ? a : [];
    const bArr = Array.isArray(b) ? b : [];
    const len = Math.max(aArr.length, bArr.length);
    for (let i = 0; i < len; i++) {
      const av = aArr[i] ?? 0;
      const bv = bArr[i] ?? 0;
      if (av !== bv) return av - bv;
    }
    return 0;
  },

  _parseDotVersionAfterPrefix(id, prefix) {
    const value = String(id || "").toLowerCase();
    if (!value.startsWith(prefix)) return null;
    const rest = value.slice(prefix.length);
    const match = rest.match(/^(\d+(?:\.\d+){0,3})/);
    if (!match) return null;
    return match[1].split(".").map(n => Number.parseInt(n, 10));
  },

  /**
   * Parse GPT version from GPT-Codex model ID
   * GPT-Codex models follow pattern: gpt-X.X-codex (e.g., gpt-5.2-codex)
   * Extract the GPT version number (e.g., 5.2 from gpt-5.2-codex)
   * @param {string} id - Model ID
   * @returns {Array|null} Version number array or null
   */
  _parseGptCodexVersion(id) {
    const value = String(id || "").toLowerCase();
    // Match pattern: gpt-X.X-codex where X.X is version (e.g., 5.2, 4.1, etc.)
    const match = value.match(/^gpt-([\d.]+)-codex$/);
    if (!match) return null;
    const versionStr = match[1];
    return versionStr.split(".").map(n => Number.parseInt(n, 10));
  },

  /**
   * Extract the original model provider from OpenRouter model ID
   * OpenRouter aggregates models from many providers in one marketplace
   * Model IDs follow pattern: <provider>/<model-name>
   * @param {string} modelId - The model ID (e.g., "openai/gpt-4-turbo")
   * @returns {string} The provider name (e.g., "openai", "anthropic", "deepseek")
   */
  extractModelProvider(modelId) {
    if (!modelId || typeof modelId !== "string") return "unknown";
    const parts = modelId.split("/");
    if (parts.length < 2) return "unknown";
    return parts[0].toLowerCase();
  },

  _pickLatestModelId(ids, versionParser = null) {
    const list = (ids || []).filter(Boolean);
    if (list.length === 0) return null;

    const latestAlias = list.find(id => String(id).toLowerCase().endsWith("-latest"));
    if (latestAlias) return latestAlias;

    if (typeof versionParser === "function") {
      let bestId = null;
      let bestVersion = null;
      list.forEach(id => {
        const v = versionParser(id);
        if (!v) return;
        if (!bestId || this._compareIntArrays(v, bestVersion) > 0) {
          bestId = id;
          bestVersion = v;
        }
      });
      if (bestId) return bestId;
    }

    let bestId = list[0];
    let bestDate = null;
    list.forEach(id => {
      const m = String(id).match(/(\d{8})/);
      const date = m ? Number.parseInt(m[1], 10) : null;
      if (date && (!bestDate || date > bestDate)) {
        bestDate = date;
        bestId = id;
      }
    });
    return bestId;
  },

  filterModelsForProvider(provider, models) {
    if (!Array.isArray(models) || models.length === 0) return models;

    const ids = models.map(m => m.value).filter(Boolean);
    const toModelList = (keepIds) => {
      const keep = new Set((keepIds || []).filter(Boolean));
      const filtered = models.filter(m => keep.has(m.value));
      return filtered.length > 0 ? filtered : models;
    };

    switch (provider) {
      case "openai": {
        // GPT text/chat models
        const baseIds = ids.filter(id => /^gpt-\d+(?:\.\d+){0,3}$/i.test(id));
        const miniIds = ids.filter(id => /^gpt-\d+(?:\.\d+){0,3}-mini$/i.test(id));
        const nanoIds = ids.filter(id => /^gpt-\d+(?:\.\d+){0,3}-nano$/i.test(id));

        // GPT-Codex code generation models (constrained to gpt-X.X-codex pattern)
        // Exclude models with -mini, -nano, -lite suffixes
        const codexIds = ids.filter(id => /^gpt-[\d.]+-codex(?!-mini|-nano|-lite)$/i.test(id));

        const parseGpt = (id) => this._parseDotVersionAfterPrefix(id, "gpt-");
        const base = this._pickLatestModelId(baseIds, parseGpt);
        const mini = this._pickLatestModelId(miniIds, parseGpt);
        const nano = this._pickLatestModelId(nanoIds, parseGpt);
        // Find latest GPT-Codex by parsing GPT version number
        const codex = this._pickLatestModelId(codexIds, (id) => this._parseGptCodexVersion(id));
        return toModelList([base, mini, nano, codex]);
      }

      case "google": {
        const flashIds = ids.filter(id => /(^|-)flash($|-)/i.test(id) && !/(^|-)flash-lite($|-)/i.test(id));
        const proIds = ids.filter(id => /(^|-)pro($|-)/i.test(id));

        const parseGemini = (id) => this._parseDotVersionAfterPrefix(id, "gemini-");
        const flash = this._pickLatestModelId(flashIds, parseGemini);
        const pro = this._pickLatestModelId(proIds, parseGemini);
        return toModelList([flash, pro]);
      }

      default:
        return models;
    }
  },

  /**
   * Convert AI response content (various formats) to a text string
   * Handles: string, array of parts, object with text property
   * @param {any} content - Response content in various formats
   * @returns {string} Plain text string
   */
  contentToText(content) {
    if (content == null) return "";
    if (typeof content === "string") return content;
    if (Array.isArray(content)) {
      return content
        .map(part => {
          if (typeof part === "string") return part;
          if (!part || typeof part !== "object") return "";
          if (typeof part.text === "string") return part.text;
          if (part.text && typeof part.text === "object" && typeof part.text.value === "string") return part.text.value;
          return "";
        })
        .join("");
    }
    if (typeof content === "object") {
      if (typeof content.text === "string") return content.text;
      if (content.text && typeof content.text === "object" && typeof content.text.value === "string") return content.text.value;
    }
    return String(content);
  },

  /**
   * Check if model requires max_completion_tokens instead of max_tokens
   * GPT-5 series and reasoning models (o1, o3) require max_completion_tokens
   * @param {string} model - Model name
   * @returns {boolean} True if model needs max_completion_tokens
   */
  usesMaxCompletionTokens(model) {
    if (!model) return false;
    const m = String(model).toLowerCase();
    return /gpt-?5/.test(m) || /\bo[13](-|$)/.test(m) || m.includes("/o1") || m.includes("/o3") || m.includes("/gpt-5") || m.includes("/gpt5");
  },

  /**
   * Group models by their original provider (for OpenRouter)
   * OpenRouter aggregates models from many providers (OpenAI, Anthropic, etc.)
   * This function creates a grouped object: { provider: [models] }
   * @param {Array} models - Array of model objects with modelProvider property
   * @returns {Object} Grouped models by provider
   */
  groupModelsByProvider(models) {
    const groups = {};

    models.forEach(model => {
      const provider = model.modelProvider || "unknown";
      if (!groups[provider]) {
        groups[provider] = [];
      }
      groups[provider].push(model);
    });

    return groups;
  }
};

_aiGlobal.AiProviderUtils = AiProviderUtils;
