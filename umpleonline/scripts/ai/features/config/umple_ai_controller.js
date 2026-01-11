// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Controller - UI orchestration and event wiring for AI settings

const AiController = {
  elements: {},
  _initialized: false,

  /**
   * Check if AI settings are configured
   * @returns {Object} {configured: boolean, message: string}
   */
  checkApiConfig() {
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

    if (!AiApi.isVerified(provider)) {
      return {
        configured: false,
        message: "Please verify your API key in the AI section first."
      };
    }

    return { configured: true, message: "" };
  },

  init() {
    if (this._initialized) return;
    this.elements = AiUI.initElements();
    this._initialized = true;

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
    const providerSelect = this.elements.providerSelect;
    if (providerSelect) {
      providerSelect.addEventListener("change", () => {
        const newProvider = providerSelect.value;
        const inputField = this.elements.inputField;

        AiApi.saveProvider(newProvider);
        this.clearStatus();

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
              this.showModelSelection();
            } else {
              this.hideModelSelection();
              AiApi.setVerified(false, newProvider);
            }
            this.updateStatusIndicator();
          });
          return;
        }

        this.hideModelSelection();
        AiApi.setVerified(false, newProvider);
        this.updateStatusIndicator();
      });
    }

    // Model selection change handler
    const modelSelect = this.elements.modelSelect;
    if (modelSelect) {
      modelSelect.addEventListener("change", () => {
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
      inputField.addEventListener("blur", () => {
        const provider = this.elements.providerSelect?.value || AiApi.getProvider();
        const apiKey = inputField.value.trim();
        if (provider && apiKey) {
          AiApi.saveApiKey(provider, apiKey);
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
  },

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
    const provider = AiApi.getProvider();
    const apiKey = AiApi.getApiKey(provider);
    const model = AiApi.getModel(false, provider);
    const verified = AiApi.isVerified(provider);

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

  /**
   * Show the AI settings dialog (alias for showSettingsModal to match feature pattern)
   */
  showDialog() {
    this.showSettingsModal();
  },

  hideSettingsModal() {
    AiUI.hideSettingsModal();
    // Update status indicator when modal closes
    this.updateStatusIndicator();
  },

  restoreSavedModel(provider = null) {
    const providerToUse = provider || AiApi.getProvider();
    AiUI.restoreSavedModel(
      () => AiApi.getModel(false, providerToUse),
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
    await AiUI.loadModels(
      provider,
      apiKey,
      (p, k) => AiApi.fetchModels(p, k),
      (p, d) => AiApi.parseModelsResponse(p, d),
      () => this.restoreSavedModel(provider),
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
    AiUI.loadPreferences(AiApi, (provider, apiKey) => {
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
    const providerSelect = AiUI.getElement("selectAiProvider", "providerSelect");
    const inputField = AiUI.getElement("inputAiApiKey", "inputField");

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
    AiApi.saveApiKey(provider, apiKey);
    AiApi.saveProvider(provider);

    // Update status and hide model dropdown until verified
    this.updateStatus("Verifying API key...", false);
    this.hideModelSelection();

    // Actually verify the API key with an authenticated request
    const result = await AiApi.verifyKey(provider, apiKey);

    if (result.valid) {
      // API key is valid, now load models
      this.loadModels(provider, apiKey, success => {
        if (success) {
          this.updateStatus("Success!", false);
          this.showModelSelection();
          AiApi.setVerified(true, provider);
          // Update status indicator after a brief delay to ensure model select is populated
          setTimeout(() => this.updateStatusIndicator(), 100);
        } else {
          this.updateStatus("Failed to load models after verification.", true);
          AiApi.setVerified(false, provider);
          this.updateStatusIndicator();
        }
      });
    } else {
      // API key invalid
      this.updateStatus(`API key verification failed: ${result.error}`, true);
      AiApi.setVerified(false, provider);
      this.updateStatusIndicator();
    }
  },

  toggleApiKeyVisibility() {
    AiUI.toggleApiKeyVisibility();
  }
};

window.AiController = AiController;
