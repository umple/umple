// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Settings Controller - Event wiring and state flow for AI settings

const AiSettings = {
  elements: {},
  _initialized: false,
  _usageListenerBound: false,

  _bindOnce(element, datasetKey, eventName, handler) {
    if (!element) return;
    if (element.dataset[datasetKey]) return;
    element.dataset[datasetKey] = "1";
    element.addEventListener(eventName, handler);
  },

  init() {
    this.elements = AiSettingsView.initElements();

    if (!this._initialized) {
      this._initialized = true;
      // Load saved preferences
      this.loadPreferences();
    }

    // Settings row click handler (entire row is clickable)
    const settingsRow = document.getElementById("buttonAiSettings");
    if (settingsRow) {
      const openModal = event => {
        event.preventDefault();
        this.showSettingsModal();
      };

      this._bindOnce(settingsRow, "aiBoundOpenSettings", "click", openModal);
      this._bindOnce(settingsRow, "aiBoundOpenSettingsKeypress", "keypress", event => {
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

      this._bindOnce(closeButton, "aiBoundCloseSettings", "click", closeModal);
      this._bindOnce(closeButton, "aiBoundCloseSettingsKeypress", "keypress", event => {
        if (event.key === "Enter" || event.key === " ") closeModal(event);
      });
    }

    // Close modal on overlay click
    const modal = document.getElementById("aiSettingsModal");
    if (modal) {
      const overlay = modal.querySelector(".dialog-overlay");
      if (overlay) {
        this._bindOnce(
          overlay,
          "aiBoundOverlayClose",
          "click",
          () => this.hideSettingsModal()
        );
      }
    }

    // Provider selection change handler
    const providerSelect = this.elements.providerSelect;
    if (providerSelect) {
      this._bindOnce(providerSelect, "aiBoundProviderChange", "change", () => {
        const newProvider = providerSelect.value;
        const inputField = this.elements.inputField;

        AiApi.saveProvider(newProvider);
        this.clearStatus();
        AiSettingsView.updateProviderLink(newProvider);

        const apiKey = AiApi.getApiKey(newProvider);

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

        if (apiKey && AiApi.isVerified(newProvider)) {
          this.loadModels(newProvider, apiKey, success => {
            if (success) {
              AiSettingsView.showModelSelection();
            } else {
              AiSettingsView.hideModelSelection();
              AiApi.setVerified(false, newProvider);
            }
            this.updateStatusIndicator();
            this.refreshUsage();
          });
          return;
        }

        AiSettingsView.hideModelSelection();
        AiApi.setVerified(false, newProvider);
        this.updateStatusIndicator();
        this.refreshUsage();
      });
    }

    // Model selection change handler
    const modelSelect = this.elements.modelSelect;
    if (modelSelect) {
      this._bindOnce(modelSelect, "aiBoundModelChange", "change", () => {
        const provider = this.elements.providerSelect?.value || AiApi.getProvider();
        const selectedValue = modelSelect.value;
        if (selectedValue) {
          AiApi.saveModel(selectedValue, provider);
        } else {
          // Clear saved model if empty selection
          AiApi.saveModel("", provider);
        }
        this.clearStatus();
        this.updateStatusIndicator();
      });
    }

    // API key input field handler - save on blur
    const inputField = this.elements.inputField;
    if (inputField) {
      this._bindOnce(inputField, "aiBoundApiKeyBlur", "blur", () => {
        const provider = this.elements.providerSelect?.value || AiApi.getProvider();
        if (!provider) return;

        const apiKey = inputField.value.trim();
        inputField.value = apiKey;

        // Allow clearing a previously-saved key by saving an empty value.
        AiApi.saveApiKey(provider, apiKey);

        if (!apiKey) {
          inputField.placeholder = "Enter your API key";
          inputField.classList.add("api-key-empty-hint");
        } else {
          inputField.placeholder = "";
          inputField.classList.remove("api-key-empty-hint");
        }

        // Any change to the key invalidates verification/model list until re-verified.
        AiApi.setVerified(false, provider);
        AiSettingsView.hideModelSelection();
        this.clearStatus();
        this.updateStatusIndicator();
      });

      // Also save on Enter key
      this._bindOnce(inputField, "aiBoundApiKeyKeypress", "keypress", event => {
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

      this._bindOnce(verifyButton, "aiBoundVerifyClick", "click", handler);
      this._bindOnce(verifyButton, "aiBoundVerifyKeypress", "keypress", event => {
        if (event.key === "Enter" || event.key === " ") handler(event);
      });
    }

    // API key visibility toggle handler
    const toggleButton = document.getElementById("toggleApiKeyVisibility");
    if (toggleButton && inputField) {

      this._bindOnce(toggleButton, "aiBoundToggleVisibilityClick", "click", () => {
        this.toggleApiKeyVisibility();
      });
      this._bindOnce(toggleButton, "aiBoundToggleVisibilityKeypress", "keypress", event => {
        if (event.key === "Enter" || event.key === " ") {
          event.preventDefault();
          this.toggleApiKeyVisibility();
        }
      });
    }

    // Reset usage button handler
    const resetUsageButton = this.elements.resetUsageButton;
    if (resetUsageButton) {
      const handler = event => {
        event.preventDefault();
        AiStorage.resetUsage();
        this.refreshUsage();
      };

      this._bindOnce(resetUsageButton, "aiBoundResetUsage", "click", handler);
      this._bindOnce(resetUsageButton, "aiBoundResetUsageKeypress", "keypress", event => {
        if (event.key === "Enter" || event.key === " ") handler(event);
      });
    }

    if (!this._usageListenerBound && typeof window !== "undefined") {
      this._usageListenerBound = true;
      window.addEventListener("aiUsageUpdated", () => {
        const modal = document.getElementById("aiSettingsModal");
        if (modal && !modal.classList.contains("is-hidden")) {
          this.refreshUsage();
        }
      });
    }
  },

  updateStatus(message, kind) {
    AiSettingsView.setStatusMessage(message, kind);
  },

  clearStatus() {
    AiSettingsView.clearStatus();
  },

  updateStatusIndicator() {
    const provider = AiApi.getProvider();
    const apiKey = AiApi.getApiKey(provider);
    const model = AiApi.getModel(provider);
    const verified = AiApi.isVerified(provider);

    AiSettingsView.updateStatusIndicator({ provider, apiKey, model, verified });
  },

  showSettingsModal() {
    AiSettingsView.showSettingsModal();
    // Reload preferences when modal opens
    this.loadPreferences();
    // Ensure saved model is selected (fallback if models are already loaded)
    setTimeout(() => this.restoreSavedModel(), 100);
    this.refreshUsage();
    this.updateStatusIndicator();
  },

  hideSettingsModal() {
    AiSettingsView.hideSettingsModal();
    // Update status indicator when modal closes
    this.updateStatusIndicator();
  },

  restoreSavedModel(provider = null) {
    const providerToUse = provider || AiApi.getProvider();
    AiSettingsView.restoreSavedModel(
      () => AiApi.getModel(providerToUse),
      model => AiApi.saveModel(model, providerToUse)
    );
  },

  /**
   * Load models for the selected provider
   * @param {string} provider - The provider name
   * @param {string} apiKey - The API key
   * @param {function} callback - Optional callback with success boolean
   */
  async loadModels(provider, apiKey, callback) {
    AiSettingsView.setModelsLoading();

    try {
      const response = await AiApi.fetchModels(provider, apiKey);

      if (!response.ok) {
        const errorData = await response.json().catch(() => ({}));

        // Handle authentication errors
        if (response.status === 401 || response.status === 403) {
          const errorMsg = AiErrors.extractErrorMessage(errorData, "Enter API key to load models");
          AiSettingsView.setModelsError(errorMsg);
          callback?.(false);
          return;
        }

        // Other errors
        throw AiErrors.createApiError(response, errorData, "Failed to fetch models");
      }

      const data = await response.json();
      const models = AiApi.parseModelsResponse(provider, data);

      AiSettingsView.setModelsOptions(models);
      this.restoreSavedModel(provider);
      callback?.(true);
    } catch (error) {
      console.error("Error loading models:", error);
      const errorMessage = error.message ? `Error: ${error.message}` : "Error loading models";
      AiSettingsView.setModelsError(errorMessage);
      callback?.(false);
    }
  },

  /**
   * Load saved preferences into the UI
   */
  loadPreferences() {
    let savedProvider = AiApi.getProvider();
    // Fallback to OpenRouter if no provider is saved
    if (!savedProvider) {
      savedProvider = "openrouter";
      AiApi.saveProvider(savedProvider);
    }
    const savedApiKey = AiApi.getApiKey(savedProvider);

    // Update UI with saved values
    AiSettingsView.setProviderValue(savedProvider);
    AiSettingsView.setApiKeyValue(savedApiKey);
    AiSettingsView.updateProviderLink(savedProvider);

    const wasVerified = AiApi.isVerified(savedProvider);
    if (wasVerified && savedApiKey && savedProvider) {
      this.loadModels(savedProvider, savedApiKey, success => {
        if (success) {
          AiSettingsView.showModelSelection();
        }
        this.updateStatusIndicator();
      });
    } else {
      AiSettingsView.hideModelSelection();
      this.updateStatusIndicator();
    }

    this.refreshUsage();
  },

  /**
   * Verify the API key by making an authenticated request
   * If successful, show the models dropdown
   */
  async verifyApiKey() {
    const providerSelect = AiSettingsView.getElement("selectAiProvider", "providerSelect");
    const inputField = AiSettingsView.getElement("inputAiApiKey", "inputField");

    if (!providerSelect || !inputField) {
      this.updateStatus("UI elements not found", "error");
      return;
    }

    const provider = providerSelect.value;
    const apiKey = inputField.value.trim();

    if (!provider) {
      this.updateStatus("Please select a provider first", "error");
      return;
    }

    if (!apiKey) {
      this.updateStatus("Please enter an API key", "error");
      return;
    }

    // Save API key for this provider and save provider selection
    AiApi.saveApiKey(provider, apiKey);
    AiApi.saveProvider(provider);

    // Update status and hide model dropdown until verified
    this.updateStatus("Verifying API key...", "success");
    AiSettingsView.hideModelSelection();

    // Actually verify the API key with an authenticated request
    const result = await AiApi.verifyKey(provider, apiKey);

    if (result.valid) {
      // API key is valid, now load models
      this.loadModels(provider, apiKey, success => {
        if (success) {
          this.updateStatus("Success!", "success");
          AiSettingsView.showModelSelection();
          AiApi.setVerified(true, provider);
          // Update status indicator after a brief delay to ensure model select is populated
          setTimeout(() => this.updateStatusIndicator(), 100);
        } else {
          this.updateStatus("Failed to load models after verification.", "error");
          AiApi.setVerified(false, provider);
          this.updateStatusIndicator();
        }
      });
    } else {
      // API key invalid
      this.updateStatus(`API key verification failed: ${result.error}`, "error");
      AiApi.setVerified(false, provider);
      this.updateStatusIndicator();
    }
  },

  toggleApiKeyVisibility() {
    AiSettingsView.toggleApiKeyVisibility();
  },

  refreshUsage() {
    const usageMap = AiStorage.getAllUsage();
    const provider = this.elements.providerSelect?.value || AiApi.getProvider();
    AiSettingsView.renderUsage(usageMap, provider);
  }
};

// Expose as global
window.AiSettings = AiSettings;
