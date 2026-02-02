// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Storage Module - Handles localStorage operations for AI configuration

const AiStorage = {
  // LocalStorage keys for storing preferences
  STORAGE_KEY_PROVIDER_DATA: "umpleAiProviderData", // Map of provider -> { apiKey, model, verified }
  STORAGE_KEY_PROVIDER: "umpleAiProvider",

  /**
   * Execute localStorage operation with error handling
   * Handles private mode and other localStorage restrictions
   * @param {Function} action - Function to execute
   * @param {string} errorMsg - Error message for logging
   * @returns {*} Result of action or null on error
   */
  _withStorage(action, errorMsg) {
    try {
      if (typeof Storage === "undefined") {
        return null;
      }
      return action();
    } catch (e) {
      // Handle specific errors silently for private mode compatibility
      if (e.name === "QuotaExceededError" || e.name === "NS_ERROR_DOM_QUOTA_REACHED") {
        console.warn("localStorage quota exceeded:", errorMsg);
      } else if (e.name === "SecurityError" || e.code === 18) {
        // Private mode or security restriction - fail silently
      } else {
        console.error(errorMsg, e);
      }
      return null;
    }
  },

  /**
   * Normalize provider data entries before storage (now includes usage)
   * @param {Object} providerData - Map of provider -> data
   * @returns {Object} Sanitized map
   */
  _sanitizeProviderDataMap(providerData) {
    if (!providerData || typeof providerData !== "object") return {};

    const sanitized = {};
    Object.entries(providerData).forEach(([provider, data]) => {
      if (!provider || !data || typeof data !== "object") return;

      const entry = {};
      if (data.apiKey) entry.apiKey = String(data.apiKey).trim();
      if (data.model) entry.model = String(data.model).trim();
      if (data.verified === true) entry.verified = true;

      // Sanitize usage data
      if (data.usage && typeof data.usage === "object") {
        const usage = {};
        const toNumber = value => {
          const num = Number(value);
          return Number.isFinite(num) ? num : null;
        };

        const requests = toNumber(data.usage.requests);
        const inputTokens = toNumber(data.usage.inputTokens);
        const outputTokens = toNumber(data.usage.outputTokens);
        const totalTokens = toNumber(data.usage.totalTokens);
        const costUsd = toNumber(data.usage.costUsd);
        const lastUsedAt = data.usage.lastUsedAt ? String(data.usage.lastUsedAt) : "";

        if (requests != null) usage.requests = Math.max(0, Math.floor(requests));
        if (inputTokens != null) usage.inputTokens = Math.max(0, Math.floor(inputTokens));
        if (outputTokens != null) usage.outputTokens = Math.max(0, Math.floor(outputTokens));
        if (totalTokens != null) usage.totalTokens = Math.max(0, Math.floor(totalTokens));
        if (costUsd != null) usage.costUsd = Math.max(0, costUsd);
        if (lastUsedAt) usage.lastUsedAt = lastUsedAt;

        if (Object.keys(usage).length > 0) {
          entry.usage = usage;
        }
      }

      if (entry.apiKey || entry.model || entry.verified) {
        sanitized[provider] = entry;
      }
    });

    return sanitized;
  },

  /**
   * Get provider data map from localStorage
   * @returns {Object} Map of provider -> { apiKey, model, verified, usage }
   */
  getProviderDataMap() {
    return this._withStorage(
      () => {
        const stored = localStorage.getItem(this.STORAGE_KEY_PROVIDER_DATA);
        if (stored) {
          try {
            return this._sanitizeProviderDataMap(JSON.parse(stored));
          } catch (e) {
            return {};
          }
        }

        return {};
      },
      "Error retrieving provider data map:"
    ) ?? {};
  },

  /**
   * Save provider data map to localStorage
   * @param {Object} providerData - Map of provider -> { apiKey, model, verified, usage }
   * @returns {boolean} Success status
   */
  saveProviderDataMap(providerData) {
    return this._withStorage(
      () => {
        const sanitized = this._sanitizeProviderDataMap(providerData);
        if (Object.keys(sanitized).length > 0) {
          localStorage.setItem(this.STORAGE_KEY_PROVIDER_DATA, JSON.stringify(sanitized));
        } else {
          localStorage.removeItem(this.STORAGE_KEY_PROVIDER_DATA);
        }
        return true;
      },
      "Error saving provider data map:"
    ) ?? false;
  },

  /**
   * Get usage data for all providers
   * @returns {Object} Map of provider -> usage data
   */
  getAllUsage() {
    const providerData = this.getProviderDataMap();
    const usage = {};
    Object.entries(providerData).forEach(([provider, data]) => {
      if (data.usage) {
        usage[provider] = data.usage;
      }
    });
    return usage;
  },

  /**
   * Record usage for a provider
   * @param {string} provider - Provider name
   * @param {Object} usageDelta - {requests,inputTokens,outputTokens,totalTokens,costUsd}
   * @returns {boolean} Success status
   */
  recordUsage(provider, usageDelta = {}) {
    if (!provider) return false;

    const delta = usageDelta && typeof usageDelta === "object" ? usageDelta : {};
    const toNumber = value => {
      const num = Number(value);
      return Number.isFinite(num) ? num : null;
    };

    const providerData = this.getProviderDataMap();
    const providerEntry = providerData[provider] || {};
    const usage = providerEntry.usage || {};

    const requests = toNumber(delta.requests);
    const inputTokens = toNumber(delta.inputTokens);
    const outputTokens = toNumber(delta.outputTokens);
    let totalTokens = toNumber(delta.totalTokens);
    const costUsd = toNumber(delta.costUsd);

    if (totalTokens == null && Number.isFinite(inputTokens) && Number.isFinite(outputTokens)) {
      totalTokens = inputTokens + outputTokens;
    }

    usage.requests = Math.max(0, Math.floor((usage.requests || 0) + (requests != null ? requests : 1)));
    if (inputTokens != null) usage.inputTokens = Math.max(0, Math.floor((usage.inputTokens || 0) + inputTokens));
    if (outputTokens != null) usage.outputTokens = Math.max(0, Math.floor((usage.outputTokens || 0) + outputTokens));
    if (totalTokens != null) usage.totalTokens = Math.max(0, Math.floor((usage.totalTokens || 0) + totalTokens));
    if (costUsd != null) usage.costUsd = Math.max(0, (usage.costUsd || 0) + costUsd);
    usage.lastUsedAt = new Date().toISOString();

    providerEntry.usage = usage;
    providerData[provider] = providerEntry;
    const saved = this.saveProviderDataMap(providerData);

    if (saved && typeof window !== "undefined" && window.dispatchEvent) {
      window.dispatchEvent(new CustomEvent("aiUsageUpdated", { detail: { provider } }));
    }

    return saved;
  },

  /**
   * Reset usage for a provider (or all providers)
   * @param {string|null} provider - Provider name or null for all
   * @returns {boolean} Success status
   */
  resetUsage(provider = null) {
    const providerData = this.getProviderDataMap();

    if (provider) {
      const entry = providerData[provider];
      if (entry) {
        delete entry.usage;
        providerData[provider] = entry;
      }
      return this.saveProviderDataMap(providerData);
    }

    // Reset usage for all providers
    Object.keys(providerData).forEach(p => {
      if (providerData[p]) {
        delete providerData[p].usage;
      }
    });
    return this.saveProviderDataMap(providerData);
  },

  /**
   * Save API key for a specific provider to localStorage
   * @param {string} provider - The provider name
   * @param {string} apiKey - The API key to save
   * @returns {boolean} Success status
   */
  saveApiKey(provider, apiKey) {
    if (!provider) {
      throw AiErrors.createValidationError("Provider is required to save API key");
    }
    const key = apiKey?.trim();
    const providerData = this.getProviderDataMap();
    const entry = providerData[provider] || {};
    if (key) {
      entry.apiKey = key;
    } else {
      delete entry.apiKey;
    }
    providerData[provider] = entry;
    return this.saveProviderDataMap(providerData);
  },

  /**
   * Retrieve API key for a specific provider from localStorage
   * @param {string} provider - The provider name
   * @returns {string} The API key for the provider, or empty string if not found
   */
  getApiKey(provider) {
    if (!provider) return "";
    const providerData = this.getProviderDataMap();
    return providerData[provider]?.apiKey || "";
  },

  /**
   * Save provider to localStorage
   * @param {string} provider - The provider name
   * @returns {boolean} Success status
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
   * @returns {string} The provider name, or empty string if not found
   */
  getProvider() {
    return this._withStorage(
      () => localStorage.getItem(this.STORAGE_KEY_PROVIDER) || "",
      "Error retrieving provider:"
    ) ?? "";
  },

  /**
   * Save model to localStorage
   * @param {string} model - The model name
   * @returns {boolean} Success status
   */
  saveModel(model, provider = null) {
    const providerToUse = provider || this.getProvider();
    if (!providerToUse) {
      throw AiErrors.createValidationError("Provider is required to save model");
    }
    const trimmedModel = model?.trim();
    return this._withStorage(
      () => {
        const providerData = this.getProviderDataMap();
        const entry = providerData[providerToUse] || {};
        if (trimmedModel) {
          entry.model = trimmedModel;
        } else {
          delete entry.model;
        }
        providerData[providerToUse] = entry;
        return this.saveProviderDataMap(providerData);
      },
      "Error saving model:"
    ) ?? false;
  },

  /**
   * Retrieve model from localStorage
   * @returns {string} The model name, or empty string if not found
   */
  getModel(provider = null) {
    const providerToUse = provider || this.getProvider();
    if (!providerToUse) return "";
    return this._withStorage(
      () => {
        const providerData = this.getProviderDataMap();
        return providerData[providerToUse]?.model || "";
      },
      "Error retrieving model:"
    ) ?? "";
  },

   /**
    * Check if API key was previously verified for a specific provider
    * @param {string} provider - The provider name (optional, uses current provider if not provided)
    * @returns {boolean} True if verified for that provider
    */
   isVerified(provider = null) {
     const providerToCheck = provider || this.getProvider();
     if (!providerToCheck) return false;

     return this._withStorage(
       () => {
         const providerData = this.getProviderDataMap();
         return providerData[providerToCheck]?.verified === true;
       },
       "Error checking verification status:"
     ) ?? false;
   },

   /**
    * Set verification status for a specific provider
    * @param {boolean} verified - Verification status
    * @param {string} provider - The provider name (optional, uses current provider if not provided)
    * @returns {boolean} Success status
    */
   setVerified(verified, provider = null) {
     const providerToSet = provider || this.getProvider();
     if (!providerToSet) return false;

     return this._withStorage(
       () => {
         const providerData = this.getProviderDataMap();
         const entry = providerData[providerToSet] || {};
         if (verified) {
           entry.verified = true;
         } else {
           delete entry.verified;
         }
         providerData[providerToSet] = entry;
         return this.saveProviderDataMap(providerData);
       },
       "Error setting verification status:"
     ) ?? false;
   }
};
