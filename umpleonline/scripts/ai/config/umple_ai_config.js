// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Configuration Module - Centralized configuration for AI features

const AiConfig = {
  // Provider API endpoints configuration
  providers: {
    openai: {
      modelsUrl: "https://api.openai.com/v1/models",
      chatUrl: "https://api.openai.com/v1/chat/completions",
      timeout: 30000,
      maxRetries: 3
    },
    google: {
      modelsUrl: "https://generativelanguage.googleapis.com/v1beta/models",
      chatUrl: "https://generativelanguage.googleapis.com/v1beta/models",
      timeout: 30000,
      maxRetries: 3
    },
    openrouter: {
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

  /**
   * Get endpoint configuration for a provider
   * @param {string} provider - Provider name
   * @returns {Object|null} Provider configuration or null
   */
  getProviderConfig(provider) {
    return this.providers[provider] || null;
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
  }
};
