// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Configuration Module - Centralized configuration for AI features

const AiConfig = {
  // Provider API endpoints configuration
  providers: {
    openai: {
      endpoint: "https://api.openai.com/v1",
      modelsUrl: "https://api.openai.com/v1/models",
      chatUrl: "https://api.openai.com/v1/chat/completions",
      timeout: 30000,
      maxRetries: 3
    },
    anthropic: {
      endpoint: "https://api.anthropic.com/v1",
      modelsUrl: "https://api.anthropic.com/v1/models",
      chatUrl: "https://api.anthropic.com/v1/messages",
      version: "2023-06-01",
      timeout: 30000,
      maxRetries: 3
    },
    google: {
      endpoint: "https://generativelanguage.googleapis.com/v1beta",
      modelsUrl: "https://generativelanguage.googleapis.com/v1beta/models",
      chatUrl: "https://generativelanguage.googleapis.com/v1beta/models",
      timeout: 30000,
      maxRetries: 3
    },
    openrouter: {
      endpoint: "https://openrouter.ai/api/v1",
      modelsUrl: "https://openrouter.ai/api/v1/models",
      verifyUrl: "https://openrouter.ai/api/v1/auth/key",
      chatUrl: "https://openrouter.ai/api/v1/chat/completions",
      timeout: 30000,
      maxRetries: 3
    }
  },

  // Default AI generation parameters
  defaults: {
    temperature: 0.7,
    maxTokens: 2000,
    timeout: 30000
  },

  // Requirements generation configuration
  requirements: {
    // Maximum length of requirement text to display in summary
    summaryLength: 100,
    // Default generation type
    defaultGenerationType: "classdiagram",
    // Whether to use all requirements by default
    defaultUseAllRequirements: true
  },

  // UI configuration
  ui: {
    // Modal default width
    modalWidth: "400px",
    // Modal max width
    modalMaxWidth: "400px",
    // Status message durations (ms)
    statusDuration: {
      success: 3000,
      error: 5000,
      info: 3000
    }
  },

  /**
   * Get endpoint configuration for a provider
   * @param {string} provider - Provider name
   * @returns {Object|null} Provider configuration or null
   */
  getProviderConfig(provider) {
    return this.providers[provider] || null;
  },

  /**
   * Get API endpoint URL for a provider
   * @param {string} provider - Provider name
   * @param {string} endpointType - Type of endpoint (modelsUrl, chatUrl, etc.)
   * @returns {string|null} Endpoint URL or null
   */
  getEndpoint(provider, endpointType) {
    const config = this.getProviderConfig(provider);
    return config ? config[endpointType] : null;
  },

  /**
   * Get default generation parameters
   * @param {Object} overrides - Optional parameter overrides
   * @returns {Object} Generation parameters
   */
  getGenerationParams(overrides = {}) {
    return {
      temperature: overrides.temperature ?? this.defaults.temperature,
      maxTokens: overrides.maxTokens ?? this.defaults.maxTokens,
      timeout: overrides.timeout ?? this.defaults.timeout
    };
  },

  /**
   * Load user configuration from localStorage
   * User configuration can override defaults
   * @returns {Object} User configuration overrides
   */
  loadUserConfig() {
    try {
      if (typeof Storage === "undefined") {
        return {};
      }

      const userConfig = localStorage.getItem("umpleAiUserConfig");
      return userConfig ? JSON.parse(userConfig) : {};
    } catch (e) {
      console.warn("Error loading user AI config:", e);
      return {};
    }
  },

  /**
   * Save user configuration to localStorage
   * @param {Object} config - Configuration overrides to save
   */
  saveUserConfig(config) {
    try {
      if (typeof Storage === "undefined") {
        return false;
      }

      // user's config overrides default config
      const currentConfig = this.loadUserConfig();
      const mergedConfig = { ...currentConfig, ...config };
      localStorage.setItem("umpleAiUserConfig", JSON.stringify(mergedConfig));
      return true;
    } catch (e) {
      console.warn("Error saving user AI config:", e);
      return false;
    }
  },

  /**
   * Get configuration value with user override support
   * @param {string} path - Dot-notation path (e.g., 'defaults.temperature')
   * @param {*} defaultValue - Default value if not found
   * @returns {*} Configuration value
   */
  get(path, defaultValue = null) {
    const userConfig = this.loadUserConfig();
    const keys = path.split(".");

    // Check user config first
    let value = userConfig;
    for (const key of keys) {
      if (value && typeof value === "object" && key in value) {
        value = value[key];
      } else {
        value = null;
        break;
      }
    }

    // If found in user config, return it
    if (value !== null) {
      return value;
    }

    // Otherwise, get from default config
    value = this;
    for (const key of keys) {
      if (value && typeof value === "object" && key in value) {
        value = value[key];
      } else {
        return defaultValue;
      }
    }

    return value;
  }
};
