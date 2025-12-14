// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI API Key Management for UmpleOnline
// Handles multiple AI provider API key storage and calling (frontend only)

const AiApi = {
  // LocalStorage keys for storing preferences
  STORAGE_KEY: "umpleAiApiKey",
  STORAGE_KEY_PROVIDER: "umpleAiProvider",
  STORAGE_KEY_MODEL: "umpleAiModel",
  STORAGE_KEY_VERIFIED: "umpleAiApiKeyVerified",

  // Provider API endpoints
  PROVIDER_ENDPOINTS: {
    openai: { modelsUrl: "https://api.openai.com/v1/models" },
    anthropic: { modelsUrl: "https://api.anthropic.com/v1/models" },
    google: { modelsUrl: "https://generativelanguage.googleapis.com/v1beta/models" },
    openrouter: {
      modelsUrl: "https://openrouter.ai/api/v1/models",
      verifyUrl: "https://openrouter.ai/api/v1/auth/key"
    }
  },

  // Cache DOM elements to avoid repeated lookups
  elements: {},

  // Helper: Execute localStorage operation with error handling
  _withStorage(action, errorMsg) {
    try {
      return typeof Storage !== "undefined" ? action() : null;
    } catch (e) {
      console.error(errorMsg, e);
      return null;
    }
  },

  // Helper: Extract error message from API response
  _getErrorMessage(errorData, defaultMsg) {
    if (!errorData?.error) return defaultMsg;
    return typeof errorData.error === "object" ? errorData.error.message || defaultMsg : errorData.error;
  },

  /**
   * Save API key to localStorage
   */
  saveApiKey(apiKey) {
    const key = apiKey?.trim();
    return this._withStorage(
      () => {
        key ? localStorage.setItem(this.STORAGE_KEY, key) : localStorage.removeItem(this.STORAGE_KEY);
        return true;
      },
      "Error saving API key:"
    ) ?? false;
  },

  /**
   * Retrieve API key from localStorage
   */
  getApiKey() {
    return this._withStorage(
      () => localStorage.getItem(this.STORAGE_KEY) || "",
      "Error retrieving API key:"
    ) ?? "";
  },

  /**
   * Save provider to localStorage
   */
  saveProvider(provider) {
    return this._withStorage(
      () => {
        provider ? localStorage.setItem(this.STORAGE_KEY_PROVIDER, provider) : localStorage.removeItem(this.STORAGE_KEY_PROVIDER);
        return true;
      },
      "Error saving provider:"
    ) ?? false;
  },

  /**
   * Retrieve provider from localStorage
   */
  getProvider() {
    return this._withStorage(
      () => localStorage.getItem(this.STORAGE_KEY_PROVIDER) || "openrouter",
      "Error retrieving provider:"
    ) ?? "openrouter";
  },

  /**
   * Save model to localStorage
   */
  saveModel(model) {
    return this._withStorage(
      () => {
        model ? localStorage.setItem(this.STORAGE_KEY_MODEL, model) : localStorage.removeItem(this.STORAGE_KEY_MODEL);
        return true;
      },
      "Error saving model:"
    ) ?? false;
  },

  /**
   * Retrieve model from localStorage
   */
  getModel() {
    return this._withStorage(
      () => localStorage.getItem(this.STORAGE_KEY_MODEL) || "",
      "Error retrieving model:"
    ) ?? "";
  },

  /**
   * Fetch available models from the provider's API directly
   */
  fetchModels(provider, apiKey) {
    const endpoint = this.PROVIDER_ENDPOINTS[provider];
    if (!endpoint) {
      console.error("Unknown provider:", provider);
      return Promise.reject("Unknown provider");
    }

    const headers = { "Content-Type": "application/json" };
    const key = apiKey?.trim();

    // Add provider-specific authentication
    if (provider === "openai" || provider === "openrouter") {
      if (key) headers["Authorization"] = `Bearer ${key}`;
    } else if (provider === "anthropic") {
      if (key) {
        headers["x-api-key"] = key;
        headers["anthropic-version"] = "2023-06-01";
      }
    } else if (provider === "google") {
      const url = key ? `${endpoint.modelsUrl}?key=${encodeURIComponent(key)}` : endpoint.modelsUrl;
      return fetch(url, { method: "GET", headers });
    }

    return fetch(endpoint.modelsUrl, { method: "GET", headers });
  },

  /**
   * Verify API key by making an authenticated request
   * For OpenRouter: uses /auth/key endpoint (requires authentication)
   * For other providers: uses models endpoint
   */
  async verifyKey(provider, apiKey) {
    const endpoint = this.PROVIDER_ENDPOINTS[provider];
    if (!endpoint) {
      return { valid: false, error: "Unknown provider" };
    }

    const headers = { "Content-Type": "application/json" };
    const key = apiKey?.trim();

    let url;
    if (provider === "openrouter") {
      // OpenRouter: Use the verify endpoint that requires authentication
      url = endpoint.verifyUrl;
      if (!key) {
        return { valid: false, error: "API key required for OpenRouter" };
      }
      headers["Authorization"] = `Bearer ${key}`;
    } else if (provider === "openai") {
      url = endpoint.modelsUrl;
      if (key) headers["Authorization"] = `Bearer ${key}`;
    } else if (provider === "anthropic") {
      url = endpoint.modelsUrl;
      if (key) {
        headers["x-api-key"] = key;
        headers["anthropic-version"] = "2023-06-01";
      }
    } else if (provider === "google") {
      // Google: Add key as query parameter
      url = key ? `${endpoint.modelsUrl}?key=${encodeURIComponent(key)}` : endpoint.modelsUrl;
    }

    try {
      const response = await fetch(url, { method: "GET", headers });

      if (!response.ok) {
        const errorData = await response.json().catch(() => ({}));
        const errorMsg = this._getErrorMessage(errorData, `Verification failed: ${response.status}`);
        return { valid: false, error: errorMsg };
      }

      return { valid: true };
    } catch (error) {
      console.error("Error verifying API key:", error);
      return { valid: false, error: error.message || "Network error" };
    }
  },

  /**
   * Parse models response from provider
   */
  parseModelsResponse(provider, responseData) {
    const models = [];

    switch (provider) {
      case "openai":
        responseData.data?.forEach(model => {
          if (model.id?.includes("gpt") || model.id?.includes("o1")) {
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
   * Load models for the selected provider
   * @param {string} provider - The provider name
   * @param {string} apiKey - The API key
   * @param {function} callback - Optional callback with success boolean
   */
  async loadModels(provider, apiKey, callback) {
    const modelSelect = this.elements.modelSelect || document.getElementById("selectAiModel");
    if (!modelSelect) {
      callback?.(false);
      return;
    }

    // Cache the element for future use
    this.elements.modelSelect = modelSelect;

    // Clear and show loading
    modelSelect.innerHTML = '<option value="">Loading models...</option>';
    modelSelect.disabled = true;

    // For OpenRouter, we can fetch without API key
    const keyToUse = (provider === "openrouter" && !apiKey) ? null : apiKey;

    try {
      const response = await this.fetchModels(provider, keyToUse);

      if (!response.ok) {
        const errorData = await response.json().catch(() => ({}));

        // Handle authentication errors
        if (response.status === 401 || response.status === 403) {
          const errorMsg = this._getErrorMessage(errorData, "Enter API key to load models");
          modelSelect.innerHTML = `<option value="">${errorMsg}</option>`;
          modelSelect.disabled = false;
          callback?.(false);
          return;
        }

        // Other errors
        const errorMsg = this._getErrorMessage(errorData, `Failed to fetch models: ${response.status}`);
        throw new Error(errorMsg);
      }

      const data = await response.json();
      const models = this.parseModelsResponse(provider, data);

      if (models.length === 0) {
        modelSelect.innerHTML = '<option value="">No models available</option>';
      } else {
        modelSelect.innerHTML = models
          .map(model => `<option value="${model.value}">${model.label}</option>`)
          .join("");

        // Restore saved model selection
        const savedModel = this.getModel();
        if (savedModel) modelSelect.value = savedModel;
      }

      modelSelect.disabled = false;
      callback?.(true);
    } catch (error) {
      console.error("Error loading models:", error);
      const errorMessage = error.message ? `Error: ${error.message}` : "Error loading models";
      modelSelect.innerHTML = `<option value="">${errorMessage}</option>`;
      modelSelect.disabled = false;
      callback?.(false);
    }
  },

  /**
   * Load saved preferences into the UI
   */
  loadPreferences() {
    const providerSelect = this.elements.providerSelect || document.getElementById("selectAiProvider");
    if (providerSelect) {
      providerSelect.value = this.getProvider();
      this.elements.providerSelect = providerSelect;
    }

    const inputField = this.elements.inputField || document.getElementById("inputAiApiKey");
    if (inputField) {
      inputField.value = this.getApiKey();
      this.elements.inputField = inputField;
    }

    // Only load models if API key was previously verified
    const wasVerified = localStorage.getItem(this.STORAGE_KEY_VERIFIED) === "true";
    if (wasVerified && inputField?.value && providerSelect) {
      this.loadModels(providerSelect.value, this.getApiKey(), success => {
        if (success) this.showModelSelection();
      });
    } else {
      this.hideModelSelection();
    }
  },

  /**
   * Update status message display
   */
  updateStatus(message, isError) {
    const statusDiv = this.elements.statusDiv || document.getElementById("apiKeyStatus");
    if (statusDiv) {
      statusDiv.textContent = message;
      statusDiv.style.color = isError ? "#d32f2f" : "#2e7d32";
      statusDiv.style.fontWeight = "normal";
      this.elements.statusDiv = statusDiv;
    }
  },

  /**
   * Clear status message
   */
  clearStatus() {
    const statusDiv = this.elements.statusDiv || document.getElementById("apiKeyStatus");
    if (statusDiv) {
      statusDiv.textContent = "";
      this.elements.statusDiv = statusDiv;
    }
  },

  /**
   * Verify the API key by making an authenticated request
   * If successful, show the models dropdown
   */
  async verifyApiKey() {
    const providerSelect = this.elements.providerSelect || document.getElementById("selectAiProvider");
    const inputField = this.elements.inputField || document.getElementById("inputAiApiKey");

    if (!providerSelect || !inputField) {
      this.updateStatus("UI elements not found", true);
      return;
    }

    const provider = providerSelect.value;
    const apiKey = inputField.value.trim();

    if (!apiKey) {
      this.updateStatus("Please enter an API key first", true);
      return;
    }

    // Save API key and provider
    this.saveApiKey(apiKey);
    this.saveProvider(provider);

    // Update status and hide model dropdown until verified
    this.updateStatus("Verifying API key...", false);
    this.hideModelSelection();

    // Actually verify the API key with an authenticated request
    const result = await this.verifyKey(provider, apiKey);

    if (result.valid) {
      // API key is valid, now load models
      this.loadModels(provider, apiKey, success => {
        if (success) {
          this.updateStatus("Success! Please select a model", false);
          this.showModelSelection();
          localStorage.setItem(this.STORAGE_KEY_VERIFIED, "true");
        } else {
          this.updateStatus("Failed to load models after verification.", true);
          localStorage.removeItem(this.STORAGE_KEY_VERIFIED);
        }
      });
    } else {
      // API key invalid
      this.updateStatus(`API key verification failed: ${result.error}`, true);
      localStorage.removeItem(this.STORAGE_KEY_VERIFIED);
    }
  },

  /**
   * Show model selection UI
   */
  showModelSelection() {
    const modelLabel = this.elements.modelLabel || document.getElementById("labelAiModel");
    const modelSelect = this.elements.modelSelect || document.getElementById("selectAiModel");

    if (modelLabel) {
      modelLabel.style.display = "block";
      this.elements.modelLabel = modelLabel;
    }
    if (modelSelect) {
      modelSelect.style.display = "block";
      this.elements.modelSelect = modelSelect;
    }
  },

  /**
   * Hide model selection UI
   */
  hideModelSelection() {
    const modelLabel = this.elements.modelLabel || document.getElementById("labelAiModel");
    const modelSelect = this.elements.modelSelect || document.getElementById("selectAiModel");

    if (modelLabel) {
      modelLabel.style.display = "none";
      this.elements.modelLabel = modelLabel;
    }
    if (modelSelect) {
      modelSelect.style.display = "none";
      this.elements.modelSelect = modelSelect;
    }
  },

  /**
   * Initialize event handlers and load saved preferences
   */
  init() {
    // Load saved preferences
    this.loadPreferences();

    // Provider selection change handler
    const providerSelect = this.elements.providerSelect;
    if (providerSelect) {
      providerSelect.addEventListener("change", () => {
        this.saveProvider(providerSelect.value);
        this.hideModelSelection();
        this.clearStatus();
        localStorage.removeItem(this.STORAGE_KEY_VERIFIED);
      });
    }

    // Model selection change handler
    const modelSelect = this.elements.modelSelect;
    if (modelSelect) {
      modelSelect.addEventListener("change", () => {
        if (modelSelect.value) this.saveModel(modelSelect.value);
        this.clearStatus();
      });
    }

    // API key input field handler - save on blur
    const inputField = this.elements.inputField;
    if (inputField) {
      inputField.addEventListener("blur", () => {
        const apiKey = inputField.value.trim();
        if (apiKey) this.saveApiKey(apiKey);
      });

      // Also save on Enter key
      inputField.addEventListener("keypress", event => {
        if (event.key === "Enter") {
          event.preventDefault();
          this.verifyApiKey();
        }
      });
    }

    // Verify button click handler
    const verifyButton = document.getElementById("buttonVerifyApiKey");
    if (verifyButton) {
      const handler = event => {
        event.preventDefault();
        this.verifyApiKey();
      };

      verifyButton.addEventListener("click", handler);
      verifyButton.addEventListener("keypress", event => {
        if (event.key === "Enter" || event.key === " ") handler(event);
      });
    }
  }
};

// Initialize when DOM is ready
// Use setTimeout to ensure all elements are available, especially since scripts are loaded via document.write
if (document.readyState === "loading") {
  document.addEventListener("DOMContentLoaded", () => setTimeout(() => AiApi.init(), 100));
} else {
  // DOM is already loaded, but wait a bit to ensure all scripts are initialized
  setTimeout(() => AiApi.init(), 100);
}
