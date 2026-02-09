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

  _clearChildren(element) {
    if (!element) return;
    while (element.firstChild) {
      element.removeChild(element.firstChild);
    }
  },

  _setSelectSingleOption(select, label) {
    if (!select) return;
    this._clearChildren(select);
    const option = document.createElement("option");
    option.value = "";
    option.textContent = (label ?? "").toString();
    select.appendChild(option);
  },

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
    this._getElement("aiProviderLink", "providerLink");
    this._getElement("selectAiModel", "modelSelect");
    this._getElement("inputAiApiKey", "inputField");
    this._getElement("apiKeyStatus", "statusDiv");
    this._getElement("aiUsageSummary", "usageSummary");
    this._getElement("buttonResetAiUsage", "resetUsageButton");
    return this.elements;
  },

  /**
   * Update status message display (uses CSS classes)
   * @param {string} message - Status message
   * @param {string} kind - Message type: 'error' | 'success' | ''
   */
  setStatusMessage(message, kind = "") {
    const statusDiv = this._getElement("apiKeyStatus", "statusDiv");
    if (!statusDiv) return;

    const text = (message ?? "").toString();
    statusDiv.textContent = text;

    statusDiv.className = "ai-key-status-message";
    if (!text) {
      statusDiv.classList.add("is-hidden");
      return;
    }

    if (kind) {
      statusDiv.classList.add(`ai-status-message--${kind}`);
    }
  },

  /**
   * Clear status message
   */
  clearStatus() {
    const statusDiv = this._getElement("apiKeyStatus", "statusDiv");
    if (statusDiv) {
      statusDiv.textContent = "";
      statusDiv.className = "ai-key-status-message is-hidden";
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
    const trigger = document.getElementById("aiModelDropdownTrigger");
    const selected = document.getElementById("aiModelDropdownSelected");
    const modelSelect = this._getElement("selectAiModel", "modelSelect");

    if (selected) {
      selected.textContent = "Loading models...";
    }
    if (trigger) {
      trigger.classList.add("disabled");
      trigger.setAttribute("aria-disabled", "true");
    }
    if (modelSelect) {
      this._setSelectSingleOption(modelSelect, "Loading models...");
      modelSelect.disabled = true;
    }
    this._closeDropdown();
  },

  /**
   * Set model select to error state
   * @param {string} message - Error message to display
   */
  setModelsError(message) {
    const trigger = document.getElementById("aiModelDropdownTrigger");
    const selected = document.getElementById("aiModelDropdownSelected");
    const modelSelect = this._getElement("selectAiModel", "modelSelect");

    if (selected) {
      selected.textContent = message;
    }
    if (trigger) {
      trigger.classList.remove("disabled");
      trigger.setAttribute("aria-disabled", "false");
    }
    if (modelSelect) {
      this._setSelectSingleOption(modelSelect, message);
      modelSelect.disabled = false;
    }
    this._closeDropdown();
  },

  /**
   * Populate model select with options (grouped by provider for OpenRouter)
   * @param {Array} models - Array of {value, label, modelProvider, pricing} objects
   */
  setModelsOptions(models) {
    const modelSelect = this._getElement("selectAiModel", "modelSelect");
    const trigger = document.getElementById("aiModelDropdownTrigger");
    const selected = document.getElementById("aiModelDropdownSelected");
    const optionsContainer = document.getElementById("aiModelDropdownOptions");

    if (!modelSelect || !optionsContainer) return;

    // Enable the dropdown trigger
    if (trigger) {
      trigger.classList.remove("disabled");
      trigger.setAttribute("aria-disabled", "false");
    }

    if (models.length === 0) {
      this._setSelectSingleOption(modelSelect, "No models available");
      modelSelect.disabled = false;
      if (selected) selected.textContent = "No models available";
      this.updateModelCostDisplay(null);
      this._renderDropdownOptions([]);
      return;
    }

    // Store model data for pricing lookup
    this._modelsData = new Map(models.map(m => [m.value, m]));
    this._modelsList = models;

    // Check if models have provider information (OpenRouter only)
    const hasProviderInfo = models.some(m => m.modelProvider);

    // Helper function to check if model is free (zero cost for both input and output)
    const isFreeModel = (model) => {
      if (!model.pricing) return false;
      const inputCost = model.pricing.input;
      const outputCost = model.pricing.output;
      return inputCost === 0 && outputCost === 0;
    };

    // Clear and populate the hidden select for form submission/storage
    this._clearChildren(modelSelect);
    const fragment = document.createDocumentFragment();

    const appendOption = (parent, model, labelOverride = null) => {
      const option = document.createElement("option");
      option.value = model.value;
      option.textContent = (labelOverride ?? model.label ?? "").toString();
      parent.appendChild(option);
    };

    // Organize models for the dropdown
    let organizedModels = [];

    if (hasProviderInfo) {
      // Separate free models from paid models
      const freeModels = models.filter(model => isFreeModel(model));
      const paidModels = models.filter(model => !isFreeModel(model));

      // Sort free models alphabetically by label
      freeModels.sort((a, b) => a.label.localeCompare(b.label));

      // Group paid models by provider and sort within each group
      const groupedPaidModels = AiProviderUtils.groupModelsByProvider(paidModels);
      Object.keys(groupedPaidModels).forEach(provider => {
        groupedPaidModels[provider].sort((a, b) => a.label.localeCompare(b.label));
      });

      // Sort providers alphabetically (with "unknown" at the end)
      const providers = Object.keys(groupedPaidModels).sort((a, b) => {
        if (a === "unknown") return 1;
        if (b === "unknown") return -1;
        return a.localeCompare(b);
      });

      // Free models section at the top
      if (freeModels.length > 0) {
        organizedModels.push({
          type: "group",
          label: `🆓 Free Models (${freeModels.length})`,
          models: freeModels
        });
        freeModels.forEach(model => appendOption(fragment, model));
      }

      // Paid models grouped by provider
      providers.forEach(provider => {
        const providerModels = groupedPaidModels[provider];
        organizedModels.push({
          type: "group",
          label: `${provider} (${providerModels.length})`,
          models: providerModels
        });
        providerModels.forEach(model => appendOption(fragment, model));
      });
    } else {
      // No provider info: simple list (OpenAI, Google)
      // Separate and sort free models first, then paid models
      const freeModels = models.filter(model => isFreeModel(model));
      const paidModels = models.filter(model => !isFreeModel(model));

      freeModels.sort((a, b) => a.label.localeCompare(b.label));
      paidModels.sort((a, b) => a.label.localeCompare(b.label));

      const allModels = [...freeModels, ...paidModels];

      allModels.forEach(model => {
        const isFree = isFreeModel(model);
        const label = isFree ? `🆓 ${model.label}` : model.label;
        appendOption(fragment, model, label);
      });

      organizedModels = allModels.map(m => ({ type: "model", ...m }));
    }

    modelSelect.appendChild(fragment);
    modelSelect.disabled = false;

    // Store organized models for dropdown rendering
    this._organizedModels = organizedModels;

    // Render dropdown options
    this._renderDropdownOptions(organizedModels);

    // Setup dropdown event listeners (once)
    if (!this._dropdownListenersSetup) {
      this._setupDropdownListeners();
      this._dropdownListenersSetup = true;
    }

    // Add change listener for pricing display
    if (!this._modelChangeListener) {
      this._modelChangeListener = true;
      modelSelect.addEventListener('change', () => this._onModelChange());
    }

    // Update pricing for currently selected model after loading
    this._onModelChange();
  },

  /**
   * Render dropdown options
   * @param {Array} organizedModels - Organized model data
   * @param {string} filter - Optional filter text
   */
  _renderDropdownOptions(organizedModels, filter = "") {
    const optionsContainer = document.getElementById("aiModelDropdownOptions");
    if (!optionsContainer) return;

    this._clearChildren(optionsContainer);

    // Handle undefined or empty models
    if (!organizedModels || !Array.isArray(organizedModels) || organizedModels.length === 0) {
      const noResults = document.createElement("div");
      noResults.className = "ai-model-dropdown-no-results";
      noResults.textContent = "No models available";
      optionsContainer.appendChild(noResults);
      return;
    }

    const filterLower = filter.toLowerCase().trim();
    let hasResults = false;

    const isFreeModel = (model) => {
      if (!model.pricing) return false;
      return model.pricing.input === 0 && model.pricing.output === 0;
    };

    const matchesFilter = (text) => text.toLowerCase().includes(filterLower);

    organizedModels.forEach(item => {
      if (item.type === "group") {
        // Filter models within the group
        const filteredModels = filterLower
          ? item.models.filter(m => matchesFilter(m.label) || matchesFilter(item.label))
          : item.models;

        if (filteredModels.length === 0) return;

        hasResults = true;

        const groupEl = document.createElement("div");
        groupEl.className = "ai-model-dropdown-group";

        const labelEl = document.createElement("div");
        labelEl.className = "ai-model-dropdown-group-label";
        labelEl.textContent = item.label;
        groupEl.appendChild(labelEl);

        filteredModels.forEach(model => {
          const optionEl = document.createElement("div");
          optionEl.className = "ai-model-dropdown-option";
          optionEl.setAttribute("role", "option");
          optionEl.setAttribute("data-value", model.value);
          optionEl.textContent = isFreeModel(model) ? `🆓 ${model.label}` : model.label;
          optionEl.addEventListener("click", () => this._selectModel(model.value));
          groupEl.appendChild(optionEl);
        });

        optionsContainer.appendChild(groupEl);
      } else if (item.type === "model" || item.value) {
        // Flat list model
        const model = item.type === "model" ? item : item;
        if (filterLower && !matchesFilter(model.label)) return;

        hasResults = true;

        const optionEl = document.createElement("div");
        optionEl.className = "ai-model-dropdown-option";
        optionEl.setAttribute("role", "option");
        optionEl.setAttribute("data-value", model.value);
        optionEl.textContent = isFreeModel(model) ? `🆓 ${model.label}` : model.label;
        optionEl.addEventListener("click", () => this._selectModel(model.value));
        optionsContainer.appendChild(optionEl);
      }
    });

    if (!hasResults) {
      const noResults = document.createElement("div");
      noResults.className = "ai-model-dropdown-no-results";
      noResults.textContent = "No models found";
      optionsContainer.appendChild(noResults);
    }
  },

  /**
   * Setup dropdown event listeners
   */
  _setupDropdownListeners() {
    const trigger = document.getElementById("aiModelDropdownTrigger");
    const menu = document.getElementById("aiModelDropdownMenu");
    const searchInput = document.getElementById("aiModelSearchInput");

    if (!trigger || !menu) return;

    // Toggle dropdown on trigger click
    trigger.addEventListener("click", (e) => {
      if (trigger.classList.contains("disabled")) return;
      e.stopPropagation();
      this._toggleDropdown();
    });

    // Keyboard navigation for trigger
    trigger.addEventListener("keydown", (e) => {
      if (trigger.classList.contains("disabled")) return;
      if (e.key === "Enter" || e.key === " ") {
        e.preventDefault();
        this._toggleDropdown();
      } else if (e.key === "ArrowDown") {
        e.preventDefault();
        this._openDropdown();
        this._focusFirstOption();
      }
    });

    // Search input filtering
    if (searchInput) {
      searchInput.addEventListener("input", (e) => {
        this._renderDropdownOptions(this._organizedModels, e.target.value);
      });

      searchInput.addEventListener("keydown", (e) => {
        if (e.key === "Escape") {
          this._closeDropdown();
          trigger.focus();
        } else if (e.key === "ArrowDown") {
          e.preventDefault();
          this._focusFirstOption();
        }
      });
    }

    // Close dropdown when clicking outside
    document.addEventListener("click", (e) => {
      if (!trigger.contains(e.target) && !menu.contains(e.target)) {
        this._closeDropdown();
      }
    });

    // Close on escape key
    document.addEventListener("keydown", (e) => {
      if (e.key === "Escape" && this._isDropdownOpen()) {
        this._closeDropdown();
      }
    });
  },

  /**
   * Toggle dropdown open/closed
   */
  _toggleDropdown() {
    if (this._isDropdownOpen()) {
      this._closeDropdown();
    } else {
      this._openDropdown();
    }
  },

  /**
   * Check if dropdown is open
   * @returns {boolean}
   */
  _isDropdownOpen() {
    const menu = document.getElementById("aiModelDropdownMenu");
    return menu && !menu.classList.contains("is-hidden");
  },

  /**
   * Open the dropdown
   */
  _openDropdown() {
    const trigger = document.getElementById("aiModelDropdownTrigger");
    const menu = document.getElementById("aiModelDropdownMenu");
    const searchInput = document.getElementById("aiModelSearchInput");

    if (!menu || !trigger) return;

    menu.classList.remove("is-hidden");
    trigger.setAttribute("aria-expanded", "true");

    // Focus search input when opening
    if (searchInput) {
      setTimeout(() => searchInput.focus(), 10);
    }

    // Highlight current selection
    this._highlightCurrentSelection();
  },

  /**
   * Close the dropdown
   */
  _closeDropdown() {
    const trigger = document.getElementById("aiModelDropdownTrigger");
    const menu = document.getElementById("aiModelDropdownMenu");
    const searchInput = document.getElementById("aiModelSearchInput");

    if (menu) menu.classList.add("is-hidden");
    if (trigger) trigger.setAttribute("aria-expanded", "false");

    // Clear search when closing
    if (searchInput) {
      searchInput.value = "";
      if (this._organizedModels) {
        this._renderDropdownOptions(this._organizedModels, "");
      }
    }
  },

  /**
   * Focus the first option in the dropdown
   */
  _focusFirstOption() {
    const optionsContainer = document.getElementById("aiModelDropdownOptions");
    if (!optionsContainer) return;

    const firstOption = optionsContainer.querySelector(".ai-model-dropdown-option");
    if (firstOption) {
      firstOption.classList.add("highlighted");
      firstOption.scrollIntoView({ block: "nearest" });
    }
  },

  /**
   * Highlight the currently selected option
   */
  _highlightCurrentSelection() {
    const modelSelect = this._getElement("selectAiModel", "modelSelect");
    const optionsContainer = document.getElementById("aiModelDropdownOptions");
    if (!modelSelect || !optionsContainer) return;

    const currentValue = modelSelect.value;
    const options = optionsContainer.querySelectorAll(".ai-model-dropdown-option");

    options.forEach(opt => {
      opt.classList.remove("selected", "highlighted");
      if (opt.getAttribute("data-value") === currentValue) {
        opt.classList.add("selected");
        opt.scrollIntoView({ block: "nearest" });
      }
    });
  },

  /**
   * Select a model
   * @param {string} value - Model value to select
   */
  _selectModel(value) {
    const modelSelect = this._getElement("selectAiModel", "modelSelect");
    const selected = document.getElementById("aiModelDropdownSelected");

    if (modelSelect) {
      modelSelect.value = value;
      modelSelect.dispatchEvent(new Event("change"));
    }

    if (selected) {
      const modelData = this._modelsData?.get(value);
      selected.textContent = modelData?.label || value;
    }

    this._closeDropdown();

    // Update the trigger element for accessibility
    const trigger = document.getElementById("aiModelDropdownTrigger");
    if (trigger) {
      trigger.focus();
    }
  },

  /**
   * Update model cost display below select dropdown
   * @param {string} modelId - Selected model ID
   */
  updateModelCostDisplay(modelId) {
    // Find existing cost display element
    let costDisplay = document.getElementById("aiModelCostDisplay");

    if (!modelId) {
      if (costDisplay) costDisplay.remove();
      return;
    }

    const modelData = this._modelsData?.get(modelId);
    const pricing = modelData?.pricing;

    let inputCost = "—";
    let outputCost = "—";

    if (pricing) {
      // Pricing is already stored as USD per million tokens.
      inputCost = this._formatPricing(pricing.input);
      outputCost = this._formatPricing(pricing.output);
    }

    const costHtml = `<div id="aiModelCostDisplay" class="ai-model-cost">$${inputCost}/M input tokens $${outputCost}/M output tokens</div>`;

    if (costDisplay) {
      costDisplay.outerHTML = costHtml;
    } else {
      const modelContainer = document.getElementById("ttAiModel");
      if (modelContainer) {
        modelContainer.insertAdjacentHTML('beforeend', costHtml);
      }
    }
  },

  /**
   * Format pricing value for display
   * @param {number} value - Pricing per million tokens
   * @returns {string} Formatted price string
   */
  _formatPricing(value) {
    if (!Number.isFinite(value)) return "—";
    return value.toFixed(2);
  },

  /**
   * Update cost display when model selection changes (attached to select)
   */
  _onModelChange() {
    const modelSelect = this._getElement("selectAiModel", "modelSelect");
    if (modelSelect) {
      this.updateModelCostDisplay(modelSelect.value);
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
    const selected = document.getElementById("aiModelDropdownSelected");
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

    // Get saved model from localStorage
    const savedModel = getModel();
    let modelToSelect = null;

    if (savedModel) {
      // Check if the saved model exists in the options
      const optionExists = Array.from(modelSelect.options).some(option => option.value === savedModel);
      if (optionExists) {
        modelSelect.value = savedModel;
        modelToSelect = savedModel;
      } else {
        console.warn(`Saved model "${savedModel}" not found in available models`);
      }
    }

    // Initialize or recover by saving the current selection
    if (!modelToSelect) {
      const fallbackModel = modelSelect.value || modelSelect.options[0]?.value || "";
      if (fallbackModel) {
        modelSelect.value = fallbackModel;
        saveModel(fallbackModel);
        modelToSelect = fallbackModel;
      }
    }

    // Update the dropdown display
    if (modelToSelect && selected) {
      const modelData = this._modelsData?.get(modelToSelect);
      selected.textContent = modelData?.label || modelToSelect;
    }

    this.updateModelCostDisplay(modelSelect.value);
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
  },

  _formatNumber(value) {
    if (!Number.isFinite(value)) return "—";
    return Math.round(value).toLocaleString();
  },

  _formatTokens(value) {
    if (!Number.isFinite(value)) return "—";
    const k = value / 1000;
    if (k < 1) {
      return `${Math.round(value)} tokens`;
    } else if (k < 1000) {
      return `${k.toFixed(1)}K`;
    } else {
      return `${(k / 1000).toFixed(2)}M`;
    }
  },

  _formatCost(value) {
    if (!Number.isFinite(value)) return "—";
    return `$${value.toFixed(4)}`;
  },

  _getProviderLabel(provider) {
    const config = typeof AiConfig !== "undefined" ? AiConfig.getProviderConfig(provider) : null;
    return config?.name || provider;
  },

  _getProviderLinkInfo(provider) {
    const linkLabel = "Get API Key";
    const linkMap = {
      openai: {
        label: linkLabel,
        url: "https://platform.openai.com/"
      },
      google: {
        label: linkLabel,
        url: "https://aistudio.google.com/apikey"
      },
      openrouter: {
        label: linkLabel,
        url: "https://openrouter.ai/"
      }
    };

    return linkMap[provider] || null;
  },

  updateProviderLink(provider) {
    const link = this._getElement("aiProviderLink", "providerLink");
    if (!link) return;

    const info = this._getProviderLinkInfo(provider);

    if (!info) {
      link.classList.add("is-hidden");
      link.removeAttribute("href");
      link.textContent = "";
      link.setAttribute("tabindex", "-1");
      link.removeAttribute("title");
      return;
    }

    link.textContent = info.label;
    link.href = info.url;
    link.title = info.url;
    link.classList.remove("is-hidden");
    link.setAttribute("tabindex", "0");
  },

  renderUsage(usageMap, provider) {
    const container = this._getElement("aiUsageSummary", "usageSummary");
    const resetButton = this._getElement("buttonResetAiUsage", "resetUsageButton");
    if (!container) return;
    const section = container.closest(".ai-usage-section");

    if (!provider) {
      if (section) section.classList.add("is-hidden");
      container.innerHTML = "";
      if (resetButton) resetButton.classList.add("is-hidden");
      return;
    }

    const usage = usageMap?.[provider] || {};
    const hasUsage = Number.isFinite(usage.requests) || Number.isFinite(usage.totalTokens);
    const hasCost = Number.isFinite(usage.costUsd);

    if (!hasCost) {
      if (section) section.classList.add("is-hidden");
      container.innerHTML = "";
      if (resetButton) resetButton.classList.add("is-hidden");
      return;
    }

    if (!hasUsage) {
      if (section) section.classList.add("is-hidden");
      container.innerHTML = "";
      if (resetButton) resetButton.classList.add("is-hidden");
      return;
    }

    if (section) section.classList.remove("is-hidden");
    if (resetButton) resetButton.classList.remove("is-hidden");

    const total = this._formatTokens(usage.totalTokens);
    const input = this._formatTokens(usage.inputTokens);
    const output = this._formatTokens(usage.outputTokens);
    const requests = this._formatNumber(usage.requests);
    const cost = this._formatCost(usage.costUsd);
    container.innerHTML = `
      <div class="ai-usage-primary">
        ${total} · ${requests} req · ${cost}
      </div>
      <div class="ai-usage-secondary">
        ↳ In: ${input} / Out: ${output}
      </div>
    `;
  }
};
