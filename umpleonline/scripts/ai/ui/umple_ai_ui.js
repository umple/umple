// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI UI Module - Handles UI updates and modal management

const AiUI = {
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
   * Update status message display
   * @param {string} message - Status message
   * @param {boolean} isError - Whether it's an error message
   */
  updateStatus(message, isError) {
    const statusDiv = this._getElement("apiKeyStatus", "statusDiv");
    if (statusDiv) {
      statusDiv.textContent = message;
      statusDiv.style.color = isError ? "#d32f2f" : "#2e7d32";
      statusDiv.style.fontWeight = "normal";
    }
  },

  /**
   * Clear status message
   */
  clearStatus() {
    const statusDiv = this._getElement("apiKeyStatus", "statusDiv");
    if (statusDiv) {
      statusDiv.textContent = "";
    }
  },

  /**
   * Show model selection UI
   */
  showModelSelection() {
    const modelContainer = document.getElementById("ttAiModel");
    if (modelContainer) {
      modelContainer.style.display = "flex";
    }
  },

  /**
   * Hide model selection UI
   */
  hideModelSelection() {
    const modelContainer = document.getElementById("ttAiModel");
    if (modelContainer) {
      modelContainer.style.display = "none";
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
      modal.style.display = "flex";
    }
  },

  /**
   * Hide the AI settings modal
   */
  hideSettingsModal() {
    const modal = document.getElementById("aiSettingsModal");
    if (modal) {
      modal.style.display = "none";
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
      // Max 10 retries (2 seconds total at 200ms intervals)
      const maxRetries = 10;
      if (retryCount < maxRetries) {
        // Set flag to prevent other calls from also retrying
        this.modelRestoreInProgress = true;
        setTimeout(() => {
          this.modelRestoreInProgress = false;
          this.restoreSavedModel(getModel, saveModel, retryCount + 1);
        }, 200);
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
   * Load models into the model select dropdown
   * @param {string} provider - Provider name
   * @param {string} apiKey - API key
   * @param {Function} fetchModels - Function to fetch models
   * @param {Function} parseModels - Function to parse models response
   * @param {Function} restoreModel - Function to restore saved model selection
   * @param {Function} onSuccess - Callback on success
   * @param {Function} onError - Callback on error
   */
  async loadModels(provider, apiKey, fetchModels, parseModels, restoreModel, onSuccess, onError) {
    const modelSelect = this._getElement("selectAiModel", "modelSelect");
    if (!modelSelect) {
      onError?.();
      return;
    }

    // Clear and show loading
    modelSelect.innerHTML = '<option value="">Loading models...</option>';
    modelSelect.disabled = true;

    // For OpenRouter, we can fetch without API key
    const keyToUse = (provider === "openrouter" && !apiKey) ? null : apiKey;

    try {
      const response = await fetchModels(provider, keyToUse);

      if (!response.ok) {
        const errorData = await response.json().catch(() => ({}));

        // Handle authentication errors
        if (response.status === 401 || response.status === 403) {
          const errorMsg = this._getErrorMessage(errorData, "Enter API key to load models");
          modelSelect.innerHTML = `<option value="">${errorMsg}</option>`;
          modelSelect.disabled = false;
          onError?.();
          return;
        }

        // Other errors
        const errorMsg = this._getErrorMessage(errorData, `Failed to fetch models: ${response.status}`);
        throw new Error(errorMsg);
      }

      const data = await response.json();
      const models = parseModels(provider, data);

      if (models.length === 0) {
        modelSelect.innerHTML = '<option value="">No models available</option>';
      } else {
        modelSelect.innerHTML = models
          .map(model => `<option value="${model.value}">${model.label}</option>`)
          .join("");

        // Restore saved model selection
        restoreModel?.();
      }

      modelSelect.disabled = false;
      onSuccess?.();
    } catch (error) {
      console.error("Error loading models:", error);
      const errorMessage = error.message ? `Error: ${error.message}` : "Error loading models";
      modelSelect.innerHTML = `<option value="">${errorMessage}</option>`;
      modelSelect.disabled = false;
      onError?.();
    }
  },

  /**
   * Load saved preferences into the UI
   * @param {Object} storage - Storage object with getProvider, getApiKey, isVerified
   * @param {Function} loadModelsCallback - Callback to load models
   */
   loadPreferences(storage, loadModelsCallback) {
    const providerSelect = this._getElement("selectAiProvider", "providerSelect");
    if (providerSelect) {
      const savedProvider = storage.getProvider();
      providerSelect.value = savedProvider;
    }

    const inputField = this._getElement("inputAiApiKey", "inputField");
    const currentProvider = providerSelect?.value || storage.getProvider();
    if (inputField) {
      inputField.value = storage.getApiKey(currentProvider);
    }

    const wasVerified = storage.isVerified(currentProvider);
    const apiKey = storage.getApiKey(currentProvider);
    if (wasVerified && apiKey && providerSelect) {
      loadModelsCallback?.(currentProvider, apiKey);
    } else {
      this.hideModelSelection();
    }
  },

  /**
   * Helper: Extract error message from API response
   * @param {Object} errorData - Error response data
   * @param {string} defaultMsg - Default error message
   * @returns {string} Error message
   */
  _getErrorMessage(errorData, defaultMsg) {
    if (!errorData?.error) return defaultMsg;
    return typeof errorData.error === "object" ? errorData.error.message || defaultMsg : errorData.error;
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
  }
};
