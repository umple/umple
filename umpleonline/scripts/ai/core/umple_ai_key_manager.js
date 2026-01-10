// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI API Key Management for UmpleOnline
// Handles multiple AI provider API key storage and calling (frontend only)
// Refactored to use modular architecture: AiStorage, AiProviderAdapters, AiUI

const AiApi = {
  // Expose storage keys for backward compatibility
  STORAGE_KEY_API_KEYS: AiStorage.STORAGE_KEY_API_KEYS,
  STORAGE_KEY_PROVIDER: AiStorage.STORAGE_KEY_PROVIDER,
  STORAGE_KEY_MODEL: AiStorage.STORAGE_KEY_MODEL,
  STORAGE_KEY_VERIFIED: AiStorage.STORAGE_KEY_VERIFIED,

  // Expose provider endpoints for backward compatibility
  get PROVIDER_ENDPOINTS() {
    return AiProviderAdapters.ENDPOINTS;
  },

  // Cache DOM elements to avoid repeated lookups (for backward compatibility)
  get elements() {
    return AiUI.elements;
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

  saveModel(model) {
    return AiStorage.saveModel(model);
  },

  getModel(checkUI = false) {
    const storedModel = AiStorage.getModel();
    
    // If no stored model and checkUI is true, check the actual select element
    if (!storedModel && checkUI) {
      const modelSelect = AiUI.elements.modelSelect || document.getElementById("selectAiModel");
      if (modelSelect && modelSelect.value) {
        return modelSelect.value;
      }
    }
    
    return storedModel;
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

  // UI methods - delegate to AiUI
  updateStatus(message, isError) {
    AiUI.updateStatus(message, isError);
  },

  clearStatus() {
    AiUI.clearStatus();
  },

  showModelSelection() {
    AiUI.showModelSelection();
  },

  hideModelSelection() {
    AiUI.hideModelSelection();
  },

  updateStatusIndicator() {
    const provider = this.getProvider();
    const apiKey = this.getApiKey(provider);
    const model = this.getModel(true);
    const verified = AiStorage.isVerified(provider);
    
    AiUI.updateStatusIndicator({ provider, apiKey, model, verified });
  },

  showSettingsModal() {
    AiUI.showSettingsModal();
    // Reload preferences when modal opens
    this.loadPreferences();
    // Ensure saved model is selected (fallback if models are already loaded)
    setTimeout(() => this.restoreSavedModel(), 100);
    this.updateStatusIndicator();
  },

  hideSettingsModal() {
    AiUI.hideSettingsModal();
    // Update status indicator when modal closes
    this.updateStatusIndicator();
  },

  restoreSavedModel() {
    AiUI.restoreSavedModel(
      (checkUI) => this.getModel(checkUI),
      (model) => this.saveModel(model)
    );
  },

  toggleApiKeyVisibility() {
    AiUI.toggleApiKeyVisibility();
  },

  // Helper methods (kept for backward compatibility)
  _withStorage(action, errorMsg) {
    return AiStorage._withStorage(action, errorMsg);
  },

  _getErrorMessage(errorData, defaultMsg) {
    return AiProviderAdapters._getErrorMessage(errorData, defaultMsg);
  },

  _getApiKeysMap() {
    return AiStorage.getApiKeysMap();
  },

  _saveApiKeysMap(keysMap) {
    return AiStorage.saveApiKeysMap(keysMap);
  },

  /**
   * Load models for the selected provider
   * @param {string} provider - The provider name
   * @param {string} apiKey - The API key
   * @param {function} callback - Optional callback with success boolean
   */
  async loadModels(provider, apiKey, callback) {
    await AiUI.loadModels(
      provider,
      apiKey,
      (p, k) => AiProviderAdapters.fetchModels(p, k),
      (p, d) => AiProviderAdapters.parseModelsResponse(p, d),
      () => this.restoreSavedModel(),
      () => {
        callback?.(true);
      },
      () => callback?.(false)
    );
  },

  /**
   * Load saved preferences into the UI
   */
  loadPreferences() {
    AiUI.loadPreferences(AiStorage, (provider, apiKey) => {
      this.loadModels(provider, apiKey, success => {
        if (success) {
          this.showModelSelection();
        }
        this.updateStatusIndicator();
      });
    });
    this.updateStatusIndicator();
  },

  /**
   * Verify the API key by making an authenticated request
   * If successful, show the models dropdown
   */
  async verifyApiKey() {
    const providerSelect = AiUI.elements.providerSelect || document.getElementById("selectAiProvider");
    const inputField = AiUI.elements.inputField || document.getElementById("inputAiApiKey");

    if (!providerSelect || !inputField) {
      this.updateStatus("UI elements not found", true);
      return;
    }

    const provider = providerSelect.value;
    const apiKey = inputField.value.trim();

    if (!provider) {
      this.updateStatus("Please select a provider first", true);
      return;
    }

    if (!apiKey) {
      this.updateStatus("Please enter an API key", true);
      return;
    }

    // Save API key for this provider and save provider selection
    this.saveApiKey(provider, apiKey);
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
          this.updateStatus("Success!", false);
          this.showModelSelection();
          AiStorage.setVerified(true, provider);
          // Update status indicator after a brief delay to ensure model select is populated
          setTimeout(() => this.updateStatusIndicator(), 100);
        } else {
          this.updateStatus("Failed to load models after verification.", true);
          AiStorage.setVerified(false, provider);
          this.updateStatusIndicator();
        }
      });
    } else {
      // API key invalid
      this.updateStatus(`API key verification failed: ${result.error}`, true);
      AiStorage.setVerified(false, provider);
      this.updateStatusIndicator();
    }
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
  },

  /**
   * Initialize event handlers and load saved preferences
   */
  init() {
    // Load saved preferences
    this.loadPreferences();

    // Settings row click handler (entire row is clickable)
    const settingsRow = document.getElementById("buttonAiSettings");
    if (settingsRow) {
      const openModal = event => {
        event.preventDefault();
        this.showSettingsModal();
      };
      settingsRow.addEventListener("click", openModal);
      settingsRow.addEventListener("keypress", event => {
        if (event.key === "Enter" || event.key === " ") openModal(event);
      });
    }

    // Close button in modal
    const closeButton = document.getElementById("btnCloseAiSettings");
    if (closeButton) {
      const closeModal = event => {
        event.preventDefault();
        this.hideSettingsModal();
      };
      closeButton.addEventListener("click", closeModal);
      closeButton.addEventListener("keypress", event => {
        if (event.key === "Enter" || event.key === " ") closeModal(event);
      });
    }

    // Close modal on overlay click
    const modal = document.getElementById("aiSettingsModal");
    if (modal) {
      const overlay = modal.querySelector(".dialog-overlay");
      if (overlay) {
        overlay.addEventListener("click", () => this.hideSettingsModal());
      }
    }

    // Provider selection change handler
    const providerSelect = AiUI.elements.providerSelect;
    if (providerSelect) {
      providerSelect.addEventListener("change", () => {
        const newProvider = providerSelect.value;
        const inputField = AiUI.elements.inputField;
        
        this.saveProvider(newProvider);
        this.clearStatus();
        
        const apiKey = this.getApiKey(newProvider);
        
        if (inputField) {
          inputField.value = apiKey;
          if (!apiKey) {
            inputField.placeholder = "Enter your API key";
            inputField.classList.add("api-key-empty-hint");
          } else {
            inputField.placeholder = "";
            inputField.classList.remove("api-key-empty-hint");
          }
        }
        
        if (apiKey && AiStorage.isVerified(newProvider)) {
          this.loadModels(newProvider, apiKey, success => {
            if (success) {
              this.showModelSelection();
            } else {
              this.hideModelSelection();
              AiStorage.setVerified(false, newProvider);
            }
            this.updateStatusIndicator();
          });
          return;
        }
        
        this.hideModelSelection();
        AiStorage.setVerified(false, newProvider);
        this.updateStatusIndicator();
      });
    }

    // Model selection change handler
    const modelSelect = AiUI.elements.modelSelect;
    if (modelSelect) {
      modelSelect.addEventListener("change", () => {
        const selectedValue = modelSelect.value;
        if (selectedValue) {
          this.saveModel(selectedValue);
        } else {
          // Clear saved model if empty selection
          this.saveModel("");
        }
        this.clearStatus();
        this.updateStatusIndicator();
      });
    }

    // API key input field handler - save on blur
    const inputField = AiUI.elements.inputField;
    if (inputField) {
      inputField.addEventListener("blur", () => {
        const provider = AiUI.elements.providerSelect?.value || this.getProvider();
        const apiKey = inputField.value.trim();
        if (provider && apiKey) {
          this.saveApiKey(provider, apiKey);
          this.updateStatusIndicator();
        }
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

    // API key visibility toggle handler
    const toggleButton = document.getElementById("toggleApiKeyVisibility");
    if (toggleButton && inputField) {
      toggleButton.addEventListener("click", () => {
        this.toggleApiKeyVisibility();
      });
      toggleButton.addEventListener("keypress", event => {
        if (event.key === "Enter" || event.key === " ") {
          event.preventDefault();
          this.toggleApiKeyVisibility();
        }
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
