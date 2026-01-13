// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Provider Adapters - Provider-specific API logic using adapter pattern

const AiProviderAdapters = {
  _createStreamHandle(promise, abortFn) {
    return {
      abort: typeof abortFn === "function" ? abortFn : () => {},
      done: promise
    };
  },

  async _readSse(response, onEvent, signal) {
    if (!response?.body || !response.body.getReader) {
      throw new Error("Streaming not supported in this environment");
    }

    const reader = response.body.getReader();
    const decoder = new TextDecoder("utf-8");
    let buffer = "";

    const emitEvent = (rawEvent) => {
      const lines = String(rawEvent || "").split("\n");
      let eventType = "message";
      const dataLines = [];
      for (let i = 0; i < lines.length; i++) {
        const line = lines[i];
        if (line.startsWith("event:")) {
          eventType = line.slice(6).trim() || "message";
        } else if (line.startsWith("data:")) {
          dataLines.push(line.slice(5).trimStart());
        }
      }

      const data = dataLines.join("\n");
      if (!data) return;
      onEvent?.({ event: eventType, data });
    };

    try {
      while (true) {
        if (signal?.aborted) {
          const abortError = new Error("Aborted");
          abortError.name = "AbortError";
          throw abortError;
        }

        const { value, done } = await reader.read();
        if (done) break;

        buffer += decoder.decode(value, { stream: true }).replace(/\r\n/g, "\n");
        let sepIndex;
        while ((sepIndex = buffer.indexOf("\n\n")) !== -1) {
          const rawEvent = buffer.slice(0, sepIndex);
          buffer = buffer.slice(sepIndex + 2);
          emitEvent(rawEvent);
        }
      }
    } finally {
      try {
        reader.releaseLock();
      } catch (e) {
        // ignore
      }
    }

    if (buffer.trim()) {
      emitEvent(buffer);
    }
  },

  async _readNdjson(response, onJson, signal) {
    if (!response?.body || !response.body.getReader) {
      throw new Error("Streaming not supported in this environment");
    }

    const reader = response.body.getReader();
    const decoder = new TextDecoder("utf-8");
    let buffer = "";

    const handleLine = (line) => {
      const trimmed = String(line || "").trim();
      if (!trimmed) return;
      const payload = trimmed.startsWith("data:") ? trimmed.slice(5).trimStart() : trimmed;
      if (!payload) return;
      try {
        onJson?.(JSON.parse(payload));
      } catch (e) {
        // ignore partial / non-JSON lines
      }
    };

    try {
      while (true) {
        if (signal?.aborted) {
          const abortError = new Error("Aborted");
          abortError.name = "AbortError";
          throw abortError;
        }

        const { value, done } = await reader.read();
        if (done) break;

        buffer += decoder.decode(value, { stream: true }).replace(/\r\n/g, "\n");
        let nlIndex;
        while ((nlIndex = buffer.indexOf("\n")) !== -1) {
          const line = buffer.slice(0, nlIndex);
          buffer = buffer.slice(nlIndex + 1);
          handleLine(line);
        }
      }
    } finally {
      try {
        reader.releaseLock();
      } catch (e) {
        // ignore
      }
    }

    if (buffer.trim()) {
      handleLine(buffer);
    }
  },

  _extractGoogleDeltaText(chunk) {
    const parts = chunk?.candidates?.[0]?.content?.parts;
    if (!Array.isArray(parts)) return "";
    return parts.map(p => p?.text || "").join("");
  },

  /**
   * Get endpoint configuration for a provider (delegates to AiConfig)
   * @param {string} provider - Provider name
   * @returns {Object|null} Endpoint configuration or null
   */
  getEndpoint(provider) {
    return AiConfig.getProviderConfig(provider);
  },

  /**
   * Build request headers for a provider
   * @param {string} provider - Provider name
   * @param {string} apiKey - API key
   * @returns {Object} Headers object
   */
  buildHeaders(provider, apiKey) {
    const headers = { "Content-Type": "application/json" };
    const config = this.getEndpoint(provider);
    const key = apiKey?.trim();

    switch (provider) {
      case "openai":
      case "openrouter":
        if (key) headers["Authorization"] = `Bearer ${key}`;
        if (provider === "openrouter") {
          headers["HTTP-Referer"] = window.location.origin;
          headers["X-Title"] = "UmpleOnline";
        }
        break;
      case "anthropic":
        if (key) {
          headers["x-api-key"] = key;
          headers["anthropic-version"] = config?.version || "2023-06-01";
        }
        break;
      case "google":
        // Google uses key in URL, not headers
        break;
    }

    return headers;
  },

  /**
   * Build verification request for a provider
   * @param {string} provider - Provider name
   * @param {string} apiKey - API key
   * @returns {Object} {url, headers} for verification request
   * @throws {Error} If provider is unknown
   */
  buildVerificationRequest(provider, apiKey) {
    const endpoint = this.getEndpoint(provider);
    if (!endpoint) {
      throw AiErrors.createConfigurationError("PROVIDER_NOT_CONFIGURED");
    }

    const headers = this.buildHeaders(provider, apiKey);
    let url;

    if (provider === "openrouter") {
      url = endpoint.verifyUrl;
      if (!apiKey?.trim()) {
        throw AiErrors.createConfigurationError("NO_API_KEY");
      }
    } else if (provider === "google") {
      const key = apiKey?.trim();
      if (!key) {
        throw AiErrors.createConfigurationError("NO_API_KEY");
      }
      url = `${endpoint.modelsUrl}?key=${encodeURIComponent(key)}`;
    } else {
      url = endpoint.modelsUrl;
    }

    return { url, headers };
  },

  /**
   * Build models fetch request for a provider
   * @param {string} provider - Provider name
   * @param {string} apiKey - API key (optional for some providers)
   * @returns {Object} {url, headers} for models request
   */
  buildModelsRequest(provider, apiKey) {
    const endpoint = this.getEndpoint(provider);
    if (!endpoint) {
      throw AiErrors.createConfigurationError("PROVIDER_NOT_CONFIGURED");
    }

    const headers = this.buildHeaders(provider, apiKey);
    let url = endpoint.modelsUrl;

    if (provider === "google") {
      const key = apiKey?.trim();
      if (!key) {
        throw AiErrors.createConfigurationError("NO_API_KEY");
      }
      url = `${endpoint.modelsUrl}?key=${encodeURIComponent(key)}`;
    }

    return { url, headers };
  },

  /**
   * Build chat completion request for a provider
   * @param {string} provider - Provider name
   * @param {string} apiKey - API key
   * @param {string} model - Model name
   * @param {string} prompt - User prompt
   * @param {string} systemPrompt - System prompt (optional)
   * @param {Object} options - {temperature, maxTokens}
   * @returns {Object} {url, headers, body} for chat request
   */
  buildChatRequest(provider, apiKey, model, prompt, systemPrompt = "", options = {}) {
    const endpoint = this.getEndpoint(provider);
    if (!endpoint) {
      throw AiErrors.createConfigurationError("PROVIDER_NOT_CONFIGURED");
    }

    const headers = this.buildHeaders(provider, apiKey);
    const params = AiConfig.getGenerationParams(options);
    let url, body;

    switch (provider) {
      case "openai":
        url = endpoint.chatUrl;
        body = {
          model,
          messages: [
            ...(systemPrompt ? [{ role: "system", content: systemPrompt }] : []),
            { role: "user", content: prompt }
          ]
        };
        if (AiProviderUtils.isGpt5FamilyModel(model)) {
          body.reasoning_effort = "minimal";
        } else {
          body.temperature = params.temperature;
        }
        const tokenLimitField = AiProviderUtils.getOpenAiTokenLimitField(model);
        const tokenBudget = AiProviderUtils.isGpt5FamilyModel(model) ? (params.maxTokens + 1024) : params.maxTokens;
        body[tokenLimitField] = tokenBudget;
        if (options?.stream) body.stream = true;
        break;

      case "anthropic":
        url = endpoint.chatUrl;
        body = {
          model,
          max_tokens: params.maxTokens,
          messages: [{ role: "user", content: prompt }],
          ...(systemPrompt && { system: systemPrompt }),
          temperature: params.temperature
        };
        if (options?.stream) body.stream = true;
        break;

      case "google":
        url = `${endpoint.chatUrl}/${model}:generateContent?key=${apiKey}`;
        body = {
          contents: [{ parts: [{ text: prompt }] }],
          ...(systemPrompt && { systemInstruction: { parts: [{ text: systemPrompt }] } }),
          generationConfig: {
            temperature: params.temperature,
            maxOutputTokens: params.maxTokens
          }
        };
        break;

      case "openrouter":
        url = endpoint.chatUrl;
        body = {
          model,
          messages: [
            ...(systemPrompt ? [{ role: "system", content: systemPrompt }] : []),
            { role: "user", content: prompt }
          ]
        };
        if (!AiProviderUtils.isGpt5FamilyModel(model)) {
          body.temperature = params.temperature;
        }
        if (AiProviderUtils.isGpt5FamilyModel(model)) {
          body.max_completion_tokens = params.maxTokens;
        } else {
          body.max_tokens = params.maxTokens;
        }
        if (options?.stream) body.stream = true;
        break;

      default:
        throw AiErrors.createConfigurationError("PROVIDER_NOT_CONFIGURED");
    }

    return { url, headers, body };
  },

  _buildStreamRequest(provider, apiKey, model, prompt, systemPrompt = "", options = {}) {
    if (provider === "google") {
      const endpoint = this.getEndpoint(provider);
      if (!endpoint) {
        throw AiErrors.createConfigurationError("PROVIDER_NOT_CONFIGURED");
      }
      const params = AiConfig.getGenerationParams(options);
      const url = `${endpoint.chatUrl}/${model}:streamGenerateContent?key=${apiKey}`;
      const headers = this.buildHeaders(provider, apiKey);
      headers.Accept = "application/json";
      const body = {
        contents: [{ parts: [{ text: prompt }] }],
        ...(systemPrompt && { systemInstruction: { parts: [{ text: systemPrompt }] } }),
        generationConfig: {
          temperature: params.temperature,
          maxOutputTokens: params.maxTokens
        }
      };
      return { url, headers, body, mode: "ndjson" };
    }

    const { url, headers, body } = this.buildChatRequest(provider, apiKey, model, prompt, systemPrompt, {
      ...options,
      stream: true
    });
    headers.Accept = "text/event-stream";
    return { url, headers, body, mode: "sse" };
  },

  async _sendStreamingRequest(url, headers, body, signal) {
    return fetch(url, {
      method: "POST",
      headers,
      body: JSON.stringify(body),
      signal
    });
  },

  async _sendStreamingRequestWithFallback(provider, url, headers, body, signal) {
    let response = await this._sendStreamingRequest(url, headers, body, signal);
    if (response.ok) return { response, body };

    const error = await AiErrors.fromResponse(response, "API request failed");
    const adjustedBody = AiProviderUtils.openAIParamsFallback(provider, body, error);
    if (!adjustedBody) throw error;

    response = await this._sendStreamingRequest(url, headers, adjustedBody, signal);
    if (!response.ok) {
      throw await AiErrors.fromResponse(response, "API request failed");
    }

    return { response, body: adjustedBody };
  },

  async _streamOpenAiCompatible(response, onDelta, signal) {
    let fullText = "";

    await this._readSse(response, ({ data }) => {
      if (data === "[DONE]") return;
      let payload;
      try {
        payload = JSON.parse(data);
      } catch (e) {
        return;
      }

      const deltaText = payload?.choices?.[0]?.delta?.content;
      if (deltaText) {
        fullText += deltaText;
        onDelta?.(deltaText);
      }
    }, signal);

    return fullText;
  },

  async _streamAnthropic(response, onDelta, signal) {
    let fullText = "";

    await this._readSse(response, ({ data }) => {
      if (data === "[DONE]") return;

      let payload;
      try {
        payload = JSON.parse(data);
      } catch (e) {
        return;
      }

      const deltaText = payload?.delta?.text;
      if (deltaText) {
        fullText += deltaText;
        onDelta?.(deltaText);
      }
    }, signal);

    return fullText;
  },

  async _streamGoogle(response, onDelta, signal) {
    let fullText = "";

    const contentType = (response.headers.get("content-type") || "").toLowerCase();
    if (contentType.includes("text/event-stream")) {
      await this._readSse(response, ({ data }) => {
        let payload;
        try {
          payload = JSON.parse(data);
        } catch (e) {
          return;
        }
        const deltaText = this._extractGoogleDeltaText(payload);
        if (deltaText) {
          fullText += deltaText;
          onDelta?.(deltaText);
        }
      }, signal);

      return fullText;
    }

    await this._readNdjson(response, (payload) => {
      const deltaText = this._extractGoogleDeltaText(payload);
      if (deltaText) {
        fullText += deltaText;
        onDelta?.(deltaText);
      }
    }, signal);

    return fullText;
  },

  /**
   * Parse models response from provider
   * @param {string} provider - Provider name
   * @param {Object} responseData - Response data from API
   * @returns {Array<Object>} Array of {value, label} model objects
   */
  parseModelsResponse(provider, responseData) {
    const models = [];

    switch (provider) {
      case "openai":
        responseData.data?.forEach(model => {
          if (model.id) {
            models.push({ value: model.id, label: model.id });
          }
        });
        break;

      case "anthropic":
        responseData.data?.forEach(model => {
          if (model.id) models.push({ value: model.id, label: model.id });
        });
        break;

      case "google":
        responseData.models?.forEach(model => {
          if (model.name && model.supportedGenerationMethods?.includes("generateContent")) {
            const modelId = model.name.replace("models/", "");
            models.push({ value: modelId, label: model.displayName || modelId });
          }
        });
        break;

      case "openrouter":
        responseData.data?.forEach(model => {
          if (model.id) {
            const pricing = model.pricing ? ` (${model.pricing.prompt}/${model.pricing.completion})` : "";
            models.push({ value: model.id, label: `${model.name || model.id}${pricing}` });
          }
        });
        break;
    }

    return AiProviderUtils.filterModelsForProvider(provider, models);
  },

  /**
   * Parse chat completion response from provider
   * @param {string} provider - Provider name
   * @param {Object} responseData - Response data from API
   * @returns {string} Generated text content
   */
  parseChatResponse(provider, responseData) {
    switch (provider) {
      case "openai":
      case "openrouter":
        return responseData.choices?.[0]?.message?.content || "";
      case "anthropic":
        return responseData.content?.[0]?.text || "";
      case "google":
        return responseData.candidates?.[0]?.content?.parts?.[0]?.text || "";
      default:
        return "";
    }
  },

  /**
   * Verify API key by making an authenticated request
   * @param {string} provider - Provider name
   * @param {string} apiKey - API key
   * @returns {Promise<Object>} {valid: boolean, error?: string}
   */
  async verifyKey(provider, apiKey) {
    try {
      const { url, headers } = this.buildVerificationRequest(provider, apiKey);
      const response = await fetch(url, { method: "GET", headers });

      if (!response.ok) {
        const error = await AiErrors.fromResponse(response, "Verification failed");
        return { valid: false, error: error.message };
      }

      return { valid: true };
    } catch (error) {
      console.error("Error verifying API key:", error);
      const isNetworkError = error.name === "TypeError" || error.message.includes("fetch");
      const errorToReturn = isNetworkError
        ? AiErrors.createNetworkError("Network error during verification", error)
        : error;

      return { valid: false, error: errorToReturn.message };
    }
  },

  /**
   * Fetch available models from the provider's API
   * @param {string} provider - Provider name
   * @param {string} apiKey - API key (optional for some providers)
   * @returns {Promise<Response>} Fetch response
   */
  async fetchModels(provider, apiKey) {
    const { url, headers } = this.buildModelsRequest(provider, apiKey);
    return fetch(url, { method: "GET", headers });
  },

  /**
   * Send a chat completion request
   * @param {string} provider - Provider name
   * @param {string} apiKey - API key
   * @param {string} model - Model name
   * @param {string} prompt - User prompt
   * @param {string} systemPrompt - System prompt (optional)
   * @param {Object} options - {temperature, maxTokens}
   * @returns {Promise<string>} Generated text response
   */
  async chat(provider, apiKey, model, prompt, systemPrompt = "", options = {}) {
    const { url, headers, body } = this.buildChatRequest(provider, apiKey, model, prompt, systemPrompt, options);

    const send = (requestBody) => fetch(url, {
      method: "POST",
      headers,
      body: JSON.stringify(requestBody)
    });

    let response = await send(body);
    if (!response.ok) {
      const error = await AiErrors.fromResponse(response, "API request failed");
      const adjustedBody = AiProviderUtils.openAIParamsFallback(provider, body, error);
      if (adjustedBody) {
        response = await send(adjustedBody);
        if (!response.ok) {
          throw await AiErrors.fromResponse(response, "API request failed");
        }
      } else {
        throw error;
      }
    }

    let data = await response.json();
    let text = this.parseChatResponse(provider, data);

    if (!text && provider === "openai" && AiProviderUtils.isGpt5FamilyModel(model) && data?.choices?.[0]?.finish_reason === "length") {
      const tokenLimitField = AiProviderUtils.getOpenAiTokenLimitField(model);
      const current = body?.[tokenLimitField];
      const bumped = typeof current === "number" ? Math.max(current + 1024, current * 2) : current;
      const retryBody = { ...body, reasoning_effort: "minimal" };
      if (typeof bumped === "number") retryBody[tokenLimitField] = bumped;

      response = await send(retryBody);
      if (!response.ok) {
        const error = await AiErrors.fromResponse(response, "API request failed");
        const adjustedRetryBody = AiProviderUtils.openAIParamsFallback(provider, retryBody, error);
        if (adjustedRetryBody) {
          response = await send(adjustedRetryBody);
          if (!response.ok) throw await AiErrors.fromResponse(response, "API request failed");
        } else {
          throw error;
        }
      }

      data = await response.json();
      text = this.parseChatResponse(provider, data);
    }

    return text;
  },

  /**
   * Stream a chat completion request
   * @param {string} provider - Provider name
   * @param {string} apiKey - API key
   * @param {string} model - Model name
   * @param {string} prompt - User prompt
   * @param {string} systemPrompt - System prompt (optional)
   * @param {Object} options - {temperature, maxTokens, timeout}
   * @param {Object} callbacks - {onDelta}
   * @returns {{abort: Function, done: Promise<string>}} Stream handle
   */
  chatStream(provider, apiKey, model, prompt, systemPrompt = "", options = {}, callbacks = {}) {
    const controller = new AbortController();
    const signal = controller.signal;
    const onDelta = callbacks?.onDelta;

    const done = (async () => {
      if (!window.ReadableStream || !window.TextDecoder || !fetch) {
        const text = await this.chat(provider, apiKey, model, prompt, systemPrompt, options);
        onDelta?.(text);
        return text;
      }

      const { url, headers, body, mode } = this._buildStreamRequest(provider, apiKey, model, prompt, systemPrompt, options);

      let response;
      if (provider === "openai" || provider === "openrouter") {
        const result = await this._sendStreamingRequestWithFallback(provider, url, headers, body, signal);
        response = result.response;
      } else {
        response = await this._sendStreamingRequest(url, headers, body, signal);
        if (!response.ok) {
          throw await AiErrors.fromResponse(response, "API request failed");
        }
      }

      if (mode === "ndjson") {
        return this._streamGoogle(response, onDelta, signal);
      }

      switch (provider) {
        case "openai":
        case "openrouter":
          return this._streamOpenAiCompatible(response, onDelta, signal);
        case "anthropic":
          return this._streamAnthropic(response, onDelta, signal);
        case "google":
          return this._streamGoogle(response, onDelta, signal);
        default:
          return this.chat(provider, apiKey, model, prompt, systemPrompt, options);
      }
    })();

    return this._createStreamHandle(done, () => controller.abort());
  }
};
