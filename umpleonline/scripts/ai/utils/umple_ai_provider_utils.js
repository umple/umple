// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Provider Utils - provider-agnostic helper logic

const AiProviderUtils = {
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
        const baseIds = ids.filter(id => /^gpt-\d+(?:\.\d+){0,3}$/i.test(id));
        const miniIds = ids.filter(id => /^gpt-\d+(?:\.\d+){0,3}-mini$/i.test(id));
        const nanoIds = ids.filter(id => /^gpt-\d+(?:\.\d+){0,3}-nano$/i.test(id));

        const parseGpt = (id) => this._parseDotVersionAfterPrefix(id, "gpt-");
        const base = this._pickLatestModelId(baseIds, parseGpt);
        const mini = this._pickLatestModelId(miniIds, parseGpt);
        const nano = this._pickLatestModelId(nanoIds, parseGpt);
        return toModelList([base, mini, nano]);
      }

      case "google": {
        const flashIds = ids.filter(id => /(^|-)flash($|-)/i.test(id) && !/(^|-)flash-lite($|-)/i.test(id));
        const proIds = ids.filter(id => /(^|-)pro($|-)/i.test(id));

        const parseGemini = (id) => this._parseDotVersionAfterPrefix(id, "gemini-");
        const flash = this._pickLatestModelId(flashIds, parseGemini);
        const pro = this._pickLatestModelId(proIds, parseGemini);
        return toModelList([flash, pro]);
      }

      case "anthropic": {
        const haikuIds = ids.filter(id => String(id).toLowerCase().includes("haiku"));
        const sonnetIds = ids.filter(id => String(id).toLowerCase().includes("sonnet"));

        const parseClaude = (id) => {
          const parts = String(id).match(/\d+/g);
          if (!parts) return null;
          return parts.map(n => Number.parseInt(n, 10));
        };
        const haiku = this._pickLatestModelId(haikuIds, parseClaude);
        const sonnet = this._pickLatestModelId(sonnetIds, parseClaude);
        return toModelList([haiku, sonnet]);
      }

      case "openrouter":
      default:
        return models;
    }
  },

  isGpt5FamilyModel(model) {
    if (!model) return false;
    const m = String(model).toLowerCase();
    return m.startsWith("gpt-5") || m.includes("/gpt-5");
  },

  getOpenAiTokenLimitField(model) {
    return this.isGpt5FamilyModel(model) ? "max_completion_tokens" : "max_tokens";
  },

  openAIParamsFallback(provider, body, error) {
    if (provider !== "openai" && provider !== "openrouter") return null;
    if (!body || typeof body !== "object") return null;

    const updated = { ...body };
    let changed = false;

    const message = (error?.message || "").toLowerCase();
    const param = error?.details?.responseData?.error?.param;

    const mentionsMaxTokens = message.includes("max_tokens");
    const mentionsMaxCompletionTokens = message.includes("max_completion_tokens");

    if ((param === "max_tokens" || mentionsMaxTokens) && mentionsMaxCompletionTokens && typeof updated.max_tokens === "number") {
      updated.max_completion_tokens = updated.max_tokens;
      delete updated.max_tokens;
      changed = true;
    }

    if ((param === "max_completion_tokens" || mentionsMaxCompletionTokens) && mentionsMaxTokens && typeof updated.max_completion_tokens === "number") {
      updated.max_tokens = updated.max_completion_tokens;
      delete updated.max_completion_tokens;
      changed = true;
    }

    const mentionsTemperature = message.includes("'temperature'") || message.includes(" temperature ");
    if ((param === "temperature" || mentionsTemperature) && Object.prototype.hasOwnProperty.call(updated, "temperature")) {
      delete updated.temperature;
      changed = true;
    }

    const knownOptionalParams = ["reasoning_effort", "verbosity", "top_p", "presence_penalty", "frequency_penalty"];
    if (param && knownOptionalParams.includes(param) && Object.prototype.hasOwnProperty.call(updated, param)) {
      delete updated[param];
      changed = true;
    }

    return changed ? updated : null;
  }
};
