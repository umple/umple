// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Error Handling Module - Unified error handling for AI features

const AiErrors = {
  // Error types
  types: {
    NETWORK_ERROR: "NETWORK_ERROR",
    CONFIGURATION_ERROR: "CONFIGURATION_ERROR",
    API_ERROR: "API_ERROR",
    VALIDATION_ERROR: "VALIDATION_ERROR",
    PROMPT_LOAD_ERROR: "PROMPT_LOAD_ERROR"
  },

  // Error messages
  messages: {
    NO_PROVIDER: "Please select an AI provider",
    NO_API_KEY: "Please configure your AI API key",
    NO_MODEL: "Please select a model",
    PROVIDER_NOT_CONFIGURED: "Provider not configured",
    API_KEY_NOT_CONFIGURED: "API key not configured",
    MODEL_NOT_CONFIGURED: "Model not configured",
    NETWORK_ERROR: "Network error - please check your connection",
    PROVIDER_REQUIRED: "Provider is required",
    VERIFICATION_FAILED: "API key verification failed"
  },

  /**
   * Create a structured error object
   * @param {string} type - Error type from AiErrors.types
   * @param {string} message - Error message
   * @param {Object} details - Additional error details
   * @returns {Error} Error object with type and details
   */
  createError(type, message, details = {}) {
    const error = new Error(message);
    error.type = type;
    error.details = details;
    error.isAiError = true;
    return error;
  },

  /**
   * Extract error message from API response
   * @param {Object} errorData - Error response data
   * @param {string} defaultMsg - Default error message
   * @returns {string} Extracted error message
   */
  extractErrorMessage(errorData, defaultMsg = "An error occurred") {
    if (!errorData?.error) return defaultMsg;
    return typeof errorData.error === "object"
      ? errorData.error.message || defaultMsg
      : errorData.error;
  },

  _extractErrorDataLike(error) {
    if (!error || typeof error !== "object") return null;

    // Common shapes:
    // - OpenRouter: { error: { message, code, metadata } }
    // - Fetch-based: { error: { ... } }
    // - OpenAI SDK APIError: { status, error: <body> }
    const candidates = [
      error,
      error.error,
      error.response,
      error.body,
      error.data
    ].filter(Boolean);

    for (const c of candidates) {
      if (!c || typeof c !== "object") continue;
      if (c.error) return c;
      if (typeof c.message === "string" || Number.isFinite(c.code) || c.metadata) {
        return { error: c };
      }
    }

    return null;
  },

  normalizeApiError(error, { provider = null, model = null } = {}) {
    const errorData = this._extractErrorDataLike(error);

    const statusFromError = Number.isFinite(error?.status) ? error.status : null;
    const statusFromCode = Number.isFinite(error?.code) ? error.code : null;
    const statusFromBody = Number.isFinite(errorData?.error?.code) ? errorData.error.code : null;
    const status = statusFromError ?? statusFromCode ?? statusFromBody ?? null;

    const metadata = (errorData?.error && typeof errorData.error === "object") ? errorData.error.metadata : null;
    const upstreamProviderName = metadata?.provider_name || null;
    const isByok = metadata?.is_byok;
    const raw = typeof metadata?.raw === "string" ? metadata.raw : null;

    const providerDisplayName = (provider && typeof AiConfig !== "undefined")
      ? (AiConfig.getProviderConfig?.(provider)?.name || provider)
      : provider;

    const baseMessage = this.extractErrorMessage(errorData, error?.message || "API request failed");

    const isRateLimited = status === 429 || /rate.?limit/i.test(String(baseMessage || "") + " " + String(raw || ""));
    const isAuthError = status === 401 || status === 403;

    let userMessage = baseMessage;
    if (isRateLimited) {
      const upstream = upstreamProviderName ? ` (${upstreamProviderName})` : "";
      userMessage = `Rate limited${upstream}. Please retry shortly.`;
      if (provider === "openrouter" && isByok === false) {
        const urlMatch = raw ? raw.match(/https?:\/\/\S+/) : null;
        const url = urlMatch ? urlMatch[0] : "https://openrouter.ai/settings/integrations";
        userMessage += ` If this keeps happening, add your own OpenRouter integration key: ${url}`;
      }
    } else if (isAuthError) {
      userMessage = "Authentication failed. Please check your API key.";
    } else if (status && status >= 500) {
      userMessage = "Provider error. Please retry shortly.";
    }

    // Avoid leaking unrelated top-level fields (e.g., OpenRouter user_id)
    return {
      status,
      provider,
      providerDisplayName,
      model,
      upstreamProviderName,
      isRateLimited,
      isAuthError,
      isByok,
      raw,
      baseMessage,
      userMessage
    };
  },

  toApiError(error, { provider = null, model = null, operation = null } = {}) {
    if (!error) return this.createError(this.types.API_ERROR, "API request failed", { provider, model, operation });
    if (error?.isAiError) return error;
    const normalized = this.normalizeApiError(error, { provider, model });
    return this.createError(
      this.types.API_ERROR,
      normalized.userMessage || normalized.baseMessage || (error.message || "API request failed"),
      { ...normalized, operation }
    );
  },

  /**
   * Create configuration error
   * @param {string} messageKey - Key from AiErrors.messages
   * @returns {Error} Structured error object
   */
  createConfigurationError(messageKey) {
    const message = this.messages[messageKey] || messageKey;
    return this.createError(
      this.types.CONFIGURATION_ERROR,
      message,
      { messageKey }
    );
  },

  /**
   * Create network error
   * @param {string} message - Error message
   * @param {Error} originalError - Original error object
   * @returns {Error} Structured error object
   */
  createNetworkError(message, originalError = null) {
    return this.createError(
      this.types.NETWORK_ERROR,
      message,
      { originalError: originalError?.message }
    );
  },

  /**
   * Create API error from response
   * @param {Response} response - Fetch response object
   * @param {Object} errorData - Parsed error data
   * @param {string} defaultMsg - Default error message
   * @returns {Error} Structured error object
   */
  createApiError(response, errorData, defaultMsg = "API request failed") {
    const message = this.extractErrorMessage(errorData, `${defaultMsg}: ${response?.status || 'unknown'}`);
    return this.createError(
      this.types.API_ERROR,
      message,
      { status: response?.status, errorData }
    );
  },

  /**
   * Create validation error
   * @param {string} message - Validation error message
   * @returns {Error} Structured error object
   */
  createValidationError(message) {
    return this.createError(
      this.types.VALIDATION_ERROR,
      message
    );
  },

  /**
   * Create prompt loading error
   * @param {string} url - URL that failed to load
   * @param {number} status - HTTP status code
   * @returns {Error} Structured error object
   */
  createPromptLoadError(url, status) {
    return this.createError(
      this.types.PROMPT_LOAD_ERROR,
      `Failed to load prompt (${status}): ${url}`,
      { url, status }
    );
  },

  /**
   * Create error from API response
   * @param {Response} response - Fetch response object
   * @param {string} defaultMsg - Default error message
   * @returns {Promise<Error>} Structured error object
   */
  async fromResponse(response, defaultMsg = "API request failed") {
    const errorData = await response.json().catch(() => ({}));
    return this.createApiError(response, errorData, defaultMsg);
  }
};
