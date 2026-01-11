// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Manager - Core API facade for storage and provider operations

const AiApi = {
  // Expose storage keys for backward compatibility
  STORAGE_KEY_PROVIDER_DATA: AiStorage.STORAGE_KEY_PROVIDER_DATA,
  STORAGE_KEY_PROVIDER: AiStorage.STORAGE_KEY_PROVIDER,

  // Expose provider endpoints for backward compatibility
  get PROVIDER_ENDPOINTS() {
    return AiProviderAdapters.ENDPOINTS;
  },

  // Storage methods - delegate to AiStorage
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

  getModel(checkUI = false, provider = null) {
    // checkUI retained for backward compatibility; selection is stored on change.
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

  // Provider methods - delegate to AiProviderAdapters
  async verifyKey(provider, apiKey) {
    return AiProviderAdapters.verifyKey(provider, apiKey);
  },

  async fetchModels(provider, apiKey) {
    return AiProviderAdapters.fetchModels(provider, apiKey);
  },

  parseModelsResponse(provider, responseData) {
    return AiProviderAdapters.parseModelsResponse(provider, responseData);
  },

  // Helper methods (kept for backward compatibility)
  _withStorage(action, errorMsg) {
    return AiStorage._withStorage(action, errorMsg);
  },

  _getErrorMessage(errorData, defaultMsg) {
    return AiErrors.extractErrorMessage(errorData, defaultMsg);
  },

  _getApiKeysMap() {
    return AiStorage.getApiKeysMap();
  },

  _saveApiKeysMap(keysMap) {
    return AiStorage.saveApiKeysMap(keysMap);
  },

  /**
   * Send a chat completion request to the configured AI provider
   * @param {string} prompt - The user prompt to send
   * @param {string} systemPrompt - Optional system prompt (ignored by some providers)
   * @param {Object} options - Optional configuration {temperature, maxTokens}
   * @returns {Promise<string>} The generated text response
   */
  async chat(prompt, systemPrompt = "", options = {}) {
    const provider = this.getProvider();
    const apiKey = this.getApiKey(provider);
    const model = this.getModel();

    if (!provider) throw new Error("Provider not configured");
    if (!apiKey) throw new Error("API key not configured");
    if (!model) throw new Error("Model not selected");

    return AiProviderAdapters.chat(provider, apiKey, model, prompt, systemPrompt, options);
  }
};
