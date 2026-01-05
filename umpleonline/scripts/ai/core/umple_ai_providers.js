// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Provider Adapters - Provider-specific API logic using adapter pattern

const AiProviderAdapters = {
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
          ],
          temperature: params.temperature,
          max_tokens: params.maxTokens
        };
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
          ],
          temperature: params.temperature,
          max_tokens: params.maxTokens
        };
        break;

      default:
        throw AiErrors.createConfigurationError("PROVIDER_NOT_CONFIGURED");
    }

    return { url, headers, body };
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

    return models;
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

    const response = await fetch(url, {
      method: "POST",
      headers,
      body: JSON.stringify(body)
    });

    if (!response.ok) {
      throw await AiErrors.fromResponse(response, "API request failed");
    }

    const data = await response.json();
    return this.parseChatResponse(provider, data);
  }
};
