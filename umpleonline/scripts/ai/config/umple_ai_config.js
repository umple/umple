// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Configuration Module - Centralized configuration for AI features

const AiConfig = {
  // Provider configuration for OpenAI SDK
  providers: {
    openai: {
      name: "OpenAI",
      baseURL: "https://api.openai.com/v1"
    },
    google: {
      name: "Google Gemini",
      baseURL: "https://generativelanguage.googleapis.com/v1beta/openai"
    },
    openrouter: {
      name: "OpenRouter",
      baseURL: "https://openrouter.ai/api/v1",
      defaultHeaders: {
        "HTTP-Referer": typeof window !== "undefined" ? window.location.origin : "",
        "X-Title": "UmpleOnline"
      }
    }
  },

  // Default AI generation parameters
  defaults: {
    maxTokens: 10000
  },

  /**
   * Get configuration for a provider
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
      maxTokens: overrides.maxTokens ?? this.defaults.maxTokens
    };
  }
};
