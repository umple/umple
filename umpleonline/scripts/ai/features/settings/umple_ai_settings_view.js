// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Settings View - DOM manipulation for AI settings UI (view-only)

const AiSettingsView = {
  // Cache DOM elements to avoid repeated lookups
  elements: {},
  
  // Flag to prevent double model restoration
  modelRestoreInProgress: false,

  /**
   * Get or cache a DOM element
   * @param {string} id - Element ID
   * @param {string} cacheKey - Key to cache element
   * @returns {HTMLElement|null} Element or null
   */
  _getElement(id, cacheKey) {
    if (!this.elements[cacheKey]) {
      this.elements[cacheKey] = document.getElementById(id);
    }
    return this.elements[cacheKey];
  },

  /**
   * Public wrapper for cached element access
   * @param {string} id - Element ID
   * @param {string} cacheKey - Key to cache element
   * @returns {HTMLElement|null} Element or null
   */
  getElement(id, cacheKey) {
    return this._getElement(id, cacheKey);
  },

  /**
   * Initialize and cache key AI settings elements
   * @returns {Object} Cached elements
   */
  initElements() {
    this._getElement("selectAiProvider", "providerSelect");
    this._getElement("selectAiModel", "modelSelect");
    this._getElement("inputAiApiKey", "inputField");
    this._getElement("apiKeyStatus", "statusDiv");
    return this.elements;
  },

  /**
   * Update status message display (uses CSS classes)
   * @param {string} message - Status message
   * @param {string} kind - Message type: 'error' | 'success' | ''
   */
  setStatusMessage(message, kind = "") {
    const statusDiv = this._getElement("apiKeyStatus", "statusDiv");
    if (statusDiv) {
      statusDiv.textContent = message;
      statusDiv.className = "";
      if (kind) {
        statusDiv.classList.add(`ai-status-message--${kind}`);
      }
    }
  },

  /**
   * Clear status message
   */
  clearStatus() {
    const statusDiv = this._getElement("apiKeyStatus", "statusDiv");
    if (statusDiv) {
      statusDiv.textContent = "";
      statusDiv.className = "";
    }
  },

  /**
   * Show model selection UI
   */
  showModelSelection() {
    const modelContainer = document.getElementById("ttAiModel");
    if (modelContainer) {
      modelContainer.classList.remove("is-hidden");
    }
  },

  /**
   * Hide model selection UI
   */
  hideModelSelection() {
    const modelContainer = document.getElementById("ttAiModel");
    if (modelContainer) {
      modelContainer.classList.add("is-hidden");
    }
  },

  /**
   * Update the AI status indicator in the sidebar
   * @param {Object} config - Configuration object {provider, apiKey, model, verified}
   */
  updateStatusIndicator(config) {
    const indicator = document.getElementById("aiStatusIndicator");
    const statusText = document.getElementById("aiStatusText");
    
    if (!indicator || !statusText) return;
    
    const { provider, apiKey, model, verified } = config;
    
    if (provider && apiKey && model && verified) {
      indicator.className = "ai-status-indicator ready";
      indicator.title = `AI Ready - ${provider} - ${model}`;
      statusText.textContent = model;
      statusText.title = `${provider} - ${model}`;
    } else if (provider && apiKey && verified) {
      indicator.className = "ai-status-indicator ready";
      indicator.title = "AI configured (select model)";
      statusText.textContent = "Select model";
      statusText.title = provider;
    } else if (provider && apiKey) {
      indicator.className = "ai-status-indicator not-ready";
      indicator.title = "API key not verified";
      statusText.textContent = "Verify key";
      statusText.title = "";
    } else {
      indicator.className = "ai-status-indicator not-ready";
      indicator.title = "AI not configured";
      statusText.textContent = "Not configured";
      statusText.title = "";
    }
  },

  /**
   * Show the AI settings modal
   */
  showSettingsModal() {
    const modal = document.getElementById("aiSettingsModal");
    if (modal) {
      modal.classList.remove("is-hidden");
    }
  },

  /**
   * Hide the AI settings modal
   */
  hideSettingsModal() {
    const modal = document.getElementById("aiSettingsModal");
    if (modal) {
      modal.classList.add("is-hidden");
    }
  },

  /**
   * Set model select to loading state
   */
  setModelsLoading() {
    const modelSelect = this._getElement("selectAiModel", "modelSelect");
    if (modelSelect) {
      modelSelect.innerHTML = '<option value="">Loading models...</option>';
      modelSelect.disabled = true;
    }
  },

  /**
   * Set model select to error state
   * @param {string} message - Error message to display
   */
  setModelsError(message) {
    const modelSelect = this._getElement("selectAiModel", "modelSelect");
    if (modelSelect) {
      modelSelect.innerHTML = `<option value="">${message}</option>`;
      modelSelect.disabled = false;
    }
  },

  /**
   * Populate model select with options
   * @param {Array} models - Array of {value, label} objects
   */
  setModelsOptions(models) {
    const modelSelect = this._getElement("selectAiModel", "modelSelect");
    if (modelSelect) {
      if (models.length === 0) {
        modelSelect.innerHTML = '<option value="">No models available</option>';
      } else {
        modelSelect.innerHTML = models
          .map(model => `<option value="${model.value}">${model.label}</option>`)
          .join("");
      }
      modelSelect.disabled = false;
    }
  },

  /**
   * Restore saved model selection in the model select dropdown
   * @param {Function} getModel - Function to get stored model
   * @param {Function} saveModel - Function to save model
   * @param {number} retryCount - Current retry count (internal use)
   */
  restoreSavedModel(getModel, saveModel, retryCount = 0) {
    const modelSelect = this._getElement("selectAiModel", "modelSelect");
    if (!modelSelect) return;

    // Prevent race condition - skip if restoration already in progress
    if (this.modelRestoreInProgress) return;
    
    // Check if models are actually loaded (not just "Loading..." or empty)
    const hasModels = modelSelect.options.length > 0 && 
                      modelSelect.options[0].value !== "" && 
                      !modelSelect.options[0].text.includes("Loading") &&
                      !modelSelect.options[0].text.includes("Error") &&
                      !modelSelect.options[0].text.includes("No models");
    
    if (!hasModels) {
      // Set flag to prevent other calls from also retrying
      this.modelRestoreInProgress = true;
      // Max 10 retries (2 seconds total at 200ms intervals)
      const maxRetries = 10;
      if (retryCount < maxRetries) {
        setTimeout(() => {
          this.modelRestoreInProgress = false;
          this.restoreSavedModel(getModel, saveModel, retryCount + 1);
        }, 200);
      } else {
        this.modelRestoreInProgress = false;
      }
      return;
    }

    // Get saved model from localStorage (no UI fallback)
    const savedModel = getModel(false);
    if (savedModel) {
      // Check if the saved model exists in the options
      const optionExists = Array.from(modelSelect.options).some(option => option.value === savedModel);
      if (optionExists) {
        modelSelect.value = savedModel;
        return;
      }

      console.warn(`Saved model "${savedModel}" not found in available models`);
    }

    // Initialize or recover by saving the current selection
    const fallbackModel = modelSelect.value || modelSelect.options[0]?.value || "";
    if (fallbackModel) {
      modelSelect.value = fallbackModel;
      saveModel(fallbackModel);
    }
  },

  /**
   * Toggle API key visibility between password and text
   */
  toggleApiKeyVisibility() {
    const inputField = this._getElement("inputAiApiKey", "inputField");
    const toggleButton = document.getElementById("toggleApiKeyVisibility");
    
    if (!inputField) return;
    
    const isPassword = inputField.type === "password";
    inputField.type = isPassword ? "text" : "password";
    
    if (toggleButton) {
      toggleButton.classList.toggle("visible", isPassword);
    }
  },

  /**
   * Set provider select value
   * @param {string} value - Provider value to select
   */
  setProviderValue(value) {
    const providerSelect = this._getElement("selectAiProvider", "providerSelect");
    if (providerSelect) {
      providerSelect.value = value;
    }
  },

  /**
   * Set API key input value
   * @param {string} value - API key value
   */
  setApiKeyValue(value) {
    const inputField = this._getElement("inputAiApiKey", "inputField");
    if (inputField) {
      inputField.value = value;
    }
  }
};
