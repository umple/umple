// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Provider Adapters - OpenAI SDK-based implementation for all providers

const AiProviderAdapters = {
  // Cache OpenAI client instances by provider:apiKey
  _clients: new Map(),

  async _retryIfEmptyReasoningOnly(client, requestParams, response, model) {
    const content = response?.choices?.[0]?.message?.content;
    const finishReason = response?.choices?.[0]?.finish_reason;
    const completionTokens = response?.usage?.completion_tokens;
    const reasoningTokens = response?.usage?.completion_tokens_details?.reasoning_tokens;

    const reasoningOnly =
      (content === "" || content == null) &&
      finishReason === "length" &&
      Number.isFinite(completionTokens) &&
      Number.isFinite(reasoningTokens) &&
      completionTokens > 0 &&
      reasoningTokens >= completionTokens;

    if (!reasoningOnly) return response;

    // Retry once with a larger token budget.
    const bumped = { ...requestParams };

    const usesMaxCompletionTokens = AiProviderUtils.usesMaxCompletionTokens(model);
    const current = Number(usesMaxCompletionTokens ? requestParams.max_completion_tokens : requestParams.max_tokens) || 0;
    const next = current > 0 ? current * 2 : 16000;
    if (usesMaxCompletionTokens) bumped.max_completion_tokens = next;
    else bumped.max_tokens = next;

    return client.chat.completions.create(bumped);
  },

  _normalizeUsage(usage, response = null) {
    const toNumber = value => {
      const num = Number(value);
      return Number.isFinite(num) ? num : null;
    };

    const inputTokens = toNumber(usage?.prompt_tokens ?? usage?.input_tokens);
    const outputTokens = toNumber(usage?.completion_tokens ?? usage?.output_tokens);
    let totalTokens = toNumber(usage?.total_tokens);
    if (totalTokens == null && Number.isFinite(inputTokens) && Number.isFinite(outputTokens)) {
      totalTokens = inputTokens + outputTokens;
    }

    const costUsd = toNumber(usage?.cost ?? response?.cost ?? response?.usage?.cost);

    return {
      inputTokens,
      outputTokens,
      totalTokens,
      costUsd
    };
  },

  _recordUsage(provider, usage, response = null) {
    const normalized = this._normalizeUsage(usage, response);
    AiStorage.recordUsage(provider, {
      requests: 1,
      inputTokens: normalized.inputTokens,
      outputTokens: normalized.outputTokens,
      totalTokens: normalized.totalTokens,
      costUsd: normalized.costUsd
    });
  },

  /**
   * Get or create an OpenAI client for the given provider and API key
   * @param {string} provider - Provider name
   * @param {string} apiKey - API key
   * @returns {OpenAI} OpenAI client instance
   */
  _getClient(provider, apiKey) {
    const config = AiConfig.getProviderConfig(provider);
    if (!config) {
      throw AiErrors.createConfigurationError("PROVIDER_NOT_CONFIGURED");
    }

    const cacheKey = `${provider}:${apiKey}`;
    if (!this._clients.has(cacheKey)) {
      const clientConfig = {
        apiKey,
        baseURL: config.baseURL,
        dangerouslyAllowBrowser: true
      };

      if (config.defaultHeaders) {
        clientConfig.defaultHeaders = config.defaultHeaders;
      }

      this._clients.set(cacheKey, new OpenAI(clientConfig));
    }
    return this._clients.get(cacheKey);
  },

  /**
   * Clear cached client for a provider (useful when API key changes)
   * @param {string} provider - Provider name
   * @param {string} apiKey - API key
   */
  clearClient(provider, apiKey) {
    const cacheKey = `${provider}:${apiKey}`;
    this._clients.delete(cacheKey);
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
   * Verify API key by making an authenticated request
   * @param {string} provider - Provider name
   * @param {string} apiKey - API key
   * @returns {Promise<Object>} {valid: boolean, error?: string}
   */
  async verifyKey(provider, apiKey) {
    if (!provider) {
      return { valid: false, error: "Provider not selected" };
    }
    if (!apiKey) {
      return { valid: false, error: "API key not provided" };
    }

    try {
      const client = this._getClient(provider, apiKey);
      await client.models.list();
      return { valid: true };
    } catch (error) {
      console.error("Error verifying API key:", error);
      return { valid: false, error: error.message || "Verification failed" };
    }
  },

  /**
   * Fetch available models from the provider's API
   * @param {string} provider - Provider name
   * @param {string} apiKey - API key
   * @returns {Promise<Object>} Response with models data
   */
  async fetchModels(provider, apiKey) {
    if (!apiKey) {
      throw AiErrors.createConfigurationError("NO_API_KEY");
    }

    const client = this._getClient(provider, apiKey);
    let response;

    // For OpenRouter, filter by programming category
    if (provider === "openrouter") {
      response = await client.models.list({ category: "programming" });
    } else {
      response = await client.models.list();
    }

    // Return in a format compatible with existing parseModelsResponse
    return { ok: true, json: () => Promise.resolve({ data: response.data }) };
  },

  /**
   * Parse models response from provider
   * @param {string} provider - Provider name
   * @param {Object} responseData - Response data from API
   * @returns {Array<Object>} Array of {value, label, modelProvider} model objects
   */
  parseModelsResponse(provider, responseData) {
    const models = [];
    const data = responseData.data || [];

    data.forEach(model => {
      if (model.id) {
        const modelObj = { value: model.id, label: model.id };

        // For OpenRouter, extract original model provider from model ID
        if (provider === "openrouter") {
          modelObj.modelProvider = AiProviderUtils.extractModelProvider(model.id);
        }

        models.push(modelObj);
      }
    });

    return AiProviderUtils.filterModelsForProvider(provider, models);
  },

  /**
   * Send a chat completion request
   * @param {string} provider - Provider name
   * @param {string} apiKey - API key
   * @param {string} model - Model name
   * @param {string} prompt - User prompt
   * @param {string} systemPrompt - System prompt (optional)
   * @param {Object} options - {maxTokens}
   * @returns {Promise<string>} Generated text response
   */
  async chat(provider, apiKey, model, prompt, systemPrompt = "", options = {}) {
    const client = this._getClient(provider, apiKey);
    const params = AiConfig.getGenerationParams(options);

    const messages = [];
    if (systemPrompt) {
      messages.push({ role: "system", content: systemPrompt });
    }
    messages.push({ role: "user", content: prompt });

    const requestParams = {
      model,
      messages
    };

    // max_completion_tokens is newer, but most providers still support max_tokens
    if (AiProviderUtils.usesMaxCompletionTokens(model)) {
      requestParams.max_completion_tokens = params.maxTokens;
    } else {
      requestParams.max_tokens = params.maxTokens;
    }

    let response = await client.chat.completions.create(requestParams);
    this._recordUsage(provider, response?.usage, response);

    const retriedResponse = await this._retryIfEmptyReasoningOnly(client, requestParams, response, model);
    if (retriedResponse !== response) {
      response = retriedResponse;
      this._recordUsage(provider, response?.usage, response);
    } else {
      response = retriedResponse;
    }

    const content = response.choices?.[0]?.message?.content;
    return AiProviderUtils.contentToText(content);
  },

  /**
   * Stream a chat completion request
   * @param {string} provider - Provider name
   * @param {string} apiKey - API key
   * @param {string} model - Model name
   * @param {string} prompt - User prompt
   * @param {string} systemPrompt - System prompt (optional)
   * @param {Object} options - {maxTokens}
   * @param {Object} callbacks - {onDelta, onTruncated}
   * @returns {{abort: Function, done: Promise<string>}} Stream handle
   */
  chatStream(provider, apiKey, model, prompt, systemPrompt = "", options = {}, callbacks = {}) {
    const controller = new AbortController();
    const client = this._getClient(provider, apiKey);
    const params = AiConfig.getGenerationParams(options);
    const onDelta = callbacks?.onDelta;
    const onTruncated = callbacks?.onTruncated;

    const done = (async () => {
      const messages = [];
      if (systemPrompt) {
        messages.push({ role: "system", content: systemPrompt });
      }
      messages.push({ role: "user", content: prompt });

      const requestParams = {
        model,
        messages,
        stream: true,
        stream_options: {
          include_usage: true
        }
      };

      // Use max_completion_tokens for GPT-5 and reasoning models, max_tokens for others
      if (AiProviderUtils.usesMaxCompletionTokens(model)) {
        requestParams.max_completion_tokens = params.maxTokens;
      } else {
        requestParams.max_tokens = params.maxTokens;
      }

      const stream = await client.chat.completions.create(
        requestParams,
        { signal: controller.signal }
      );

      let fullText = "";
      let finishReason = null;
      let usage = null;
      for await (const chunk of stream) {
        if (controller.signal.aborted) {
          break;
        }
        const choice = chunk.choices?.[0];
        if (choice?.finish_reason) finishReason = choice.finish_reason;
        const deltaObj = choice?.delta;
        const deltaContent = deltaObj?.content ?? "";
        const deltaText = AiProviderUtils.contentToText(deltaContent);
        if (deltaText) {
          fullText += deltaText;
          onDelta?.(deltaText);
        }
        if (chunk?.usage) {
          usage = chunk.usage;
        }
      }

      if (!controller.signal.aborted && finishReason === "length") {
        onTruncated?.();
      }

      if (!controller.signal.aborted) {
        if (usage) {
          this._recordUsage(provider, usage, null);
        } else {
          AiStorage.recordUsage(provider, { requests: 1 });
        }
      }

      return fullText;
    })();

    return {
      abort: () => controller.abort(),
      done
    };
  }
};
