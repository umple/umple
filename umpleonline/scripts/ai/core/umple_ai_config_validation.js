// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Configuration Validation - Unified configuration checking for AI features

const AiConfigValidation = {
  /**
   * Check if AI is properly configured
   * @param {Object} options - Options
   * @param {boolean} options.requireVerified - Whether to require verified key (default: true)
   * @returns {Object} {configured: boolean, message: string}
   */
  checkApiConfig(options = {}) {
    const { requireVerified = true } = options;

    const provider = AiApi.getProvider();
    if (!provider) {
      return {
        configured: false,
        message: "Please select an AI provider in the AI section first."
      };
    }

    const apiKey = AiApi.getApiKey(provider);
    if (!apiKey) {
      return {
        configured: false,
        message: "Please configure your AI API key in the AI section first."
      };
    }

    const model = AiApi.getModel();
    if (!model) {
      return {
        configured: false,
        message: "Please verify your API key and select a model in the AI section."
      };
    }

    if (requireVerified) {
      const isVerified = AiStorage.isVerified(provider);
      if (!isVerified) {
        return {
          configured: false,
          message: "Please verify your API key first."
        };
      }
    }

    return { configured: true };
  },

  /**
   * Check if provider is selected
   * @returns {Object} {ready: boolean, message?: string}
   */
  checkProvider() {
    const provider = AiApi.getProvider();
    if (!provider) {
      return { ready: false, message: "Please select an AI provider." };
    }
    return { ready: true, provider };
  },

  /**
   * Check if API key is configured for current provider
   * @returns {Object} {ready: boolean, message?: string}
   */
  checkApiKey() {
    const providerResult = this.checkProvider();
    if (!providerResult.ready) return providerResult;

    const provider = providerResult.provider;
    const apiKey = AiApi.getApiKey(provider);
    if (!apiKey) {
      return { ready: false, message: "Please configure your API key." };
    }
    return { ready: true, apiKey };
  },

  /**
   * Check if model is selected
   * @returns {Object} {ready: boolean, message?: string}
   */
  checkModel() {
    const keyResult = this.checkApiKey();
    if (!keyResult.ready) return keyResult;

    const model = AiApi.getModel();
    if (!model) {
      return { ready: false, message: "Please select a model." };
    }
    return { ready: true, model };
  }
};
