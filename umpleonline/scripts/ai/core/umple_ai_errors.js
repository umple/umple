// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Error Handling Module - Unified error handling for AI features

const AiErrors = {
  // Error types
  types: {
    NETWORK_ERROR: "NETWORK_ERROR",
    API_ERROR: "API_ERROR",
    VALIDATION_ERROR: "VALIDATION_ERROR",
    STORAGE_ERROR: "STORAGE_ERROR",
    CONFIGURATION_ERROR: "CONFIGURATION_ERROR",
    PARSE_ERROR: "PARSE_ERROR"
  },

  // Error messages
  messages: {
    NO_PROVIDER: "Please select an AI provider",
    NO_API_KEY: "Please configure your AI API key",
    NO_MODEL: "Please select a model",
    PROVIDER_NOT_CONFIGURED: "Provider not configured",
    API_KEY_NOT_CONFIGURED: "API key not configured",
    MODEL_NOT_CONFIGURED: "Model not configured",
    VERIFICATION_FAILED: "API key verification failed",
    MODEL_LOAD_FAILED: "Failed to load models",
    NETWORK_ERROR: "Network error - please check your connection",
    INVALID_REQUIREMENT: "Invalid requirement format",
    NO_REQUIREMENTS_FOUND: "No requirements found in your Umple code",
    NO_REQUIREMENTS_SELECTED: "Please select at least one requirement"
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

  /**
   * Create error from fetch response
   * @param {Response} response - Fetch response object
   * @param {string} defaultMsg - Default error message
   * @returns {Error} Structured error object
   */
  async fromResponse(response, defaultMsg = "API request failed") {
    let errorData = {};
    let message = defaultMsg;

    try {
      errorData = await response.json();
    } catch (e) {
      // If response is not JSON, use status text
      message = response.statusText || defaultMsg;
    }

    message = this.extractErrorMessage(errorData, message);

    const error = this.createError(
      this.types.API_ERROR,
      message,
      {
        statusCode: response.status,
        statusText: response.statusText,
        responseData: errorData
      }
    );

    return error;
  },

  /**
   * Create network error
   * @param {string} message - Error message
   * @param {Error} originalError - Original error object
   * @returns {Error} Structured error object
   */
  createNetworkError(message = this.messages.NETWORK_ERROR, originalError = null) {
    return this.createError(
      this.types.NETWORK_ERROR,
      message,
      { originalError }
    );
  },

  /**
   * Create validation error
   * @param {string} message - Error message
   * @param {Object} validationDetails - Validation details
   * @returns {Error} Structured error object
   */
  createValidationError(message, validationDetails = {}) {
    return this.createError(
      this.types.VALIDATION_ERROR,
      message,
      validationDetails
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
  }
};
