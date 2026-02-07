// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Controller - Core API facade for storage and provider operations

const AiApi = {
  STORAGE_KEY_PROVIDER_DATA: AiStorage.STORAGE_KEY_PROVIDER_DATA,
  STORAGE_KEY_PROVIDER: AiStorage.STORAGE_KEY_PROVIDER,

  saveApiKey(provider, apiKey) {
    return AiStorage.saveApiKey(provider, apiKey);
  },

  getApiKey(provider = null) {
    const providerToUse = provider || this.getProvider();
    if (!providerToUse) return "";
    return AiStorage.getApiKey(providerToUse);
  },

  saveProvider(provider) {
    return AiStorage.saveProvider(provider);
  },

  getProvider() {
    return AiStorage.getProvider();
  },

  saveModel(model, provider = null) {
    return AiStorage.saveModel(model, provider);
  },

  getModel(provider = null) {
    const providerToUse = provider || this.getProvider();
    if (!providerToUse) return "";
    return AiStorage.getModel(providerToUse);
  },

  isVerified(provider = null) {
    return AiStorage.isVerified(provider);
  },

  setVerified(verified, provider = null) {
    return AiStorage.setVerified(verified, provider);
  },

  async verifyKey(provider, apiKey) {
    return AiProviderAdapters.verifyKey(provider, apiKey);
  },

  async fetchModels(provider, apiKey) {
    return AiProviderAdapters.fetchModels(provider, apiKey);
  },

  parseModelsResponse(provider, responseData) {
    return AiProviderAdapters.parseModelsResponse(provider, responseData);
  },

  /**
   * Send a chat completion request using a chat context
   * @param {{systemPrompt: string, messages: Array<{role: string, content: string}>}} context
   * @param {Object} options - Optional configuration {maxTokens}
   * @returns {Promise<string>} The generated text response
   */
  async chat(context, options = {}) {
    const provider = this.getProvider();
    const apiKey = this.getApiKey(provider);
    const model = this.getModel();

    if (!provider) throw AiErrors.createConfigurationError("PROVIDER_NOT_CONFIGURED");
    if (!apiKey) throw AiErrors.createConfigurationError("API_KEY_NOT_CONFIGURED");
    if (!model) throw AiErrors.createConfigurationError("MODEL_NOT_CONFIGURED");

    return AiProviderAdapters.chat(provider, apiKey, model, context, options);
  },

  /**
   * Stream a chat completion response using a chat context
   * @param {{systemPrompt: string, messages: Array<{role: string, content: string}>}} context
   * @param {Object} options - Optional configuration {maxTokens}
   * @param {Object} callbacks - Optional callbacks {onDelta, onTruncated}
   * @returns {{abort: Function, done: Promise<string>}} Stream handle
   */
  chatStream(context, options = {}, callbacks = {}) {
    const provider = this.getProvider();
    const apiKey = this.getApiKey(provider);
    const model = this.getModel();

    if (!provider) throw AiErrors.createConfigurationError("PROVIDER_NOT_CONFIGURED");
    if (!apiKey) throw AiErrors.createConfigurationError("API_KEY_NOT_CONFIGURED");
    if (!model) throw AiErrors.createConfigurationError("MODEL_NOT_CONFIGURED");

    return AiProviderAdapters.chatStream(provider, apiKey, model, context, options, callbacks);
  }
};
