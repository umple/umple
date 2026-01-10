// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Storage Module - Handles localStorage operations for AI configuration

const AiStorage = {
  // LocalStorage keys for storing preferences
  STORAGE_KEY_API_KEYS: "umpleAiApiKeys", // Map of provider -> apiKey
  STORAGE_KEY_PROVIDER: "umpleAiProvider",
  STORAGE_KEY_MODEL: "umpleAiModel",
  STORAGE_KEY_VERIFIED: "umpleAiApiKeyVerified",

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
   * Get all API keys map from localStorage
   * @returns {Object} Map of provider -> apiKey
   */
  getApiKeysMap() {
    return this._withStorage(
      () => {
        const stored = localStorage.getItem(this.STORAGE_KEY_API_KEYS);
        if (stored) {
          return JSON.parse(stored);
        }
        
        // Backward compatibility: migrate old single API key format
        const oldKey = localStorage.getItem("umpleAiApiKey");
        if (oldKey) {
          const oldProvider = localStorage.getItem(this.STORAGE_KEY_PROVIDER) || "";
          const keysMap = oldProvider ? { [oldProvider]: oldKey } : {};
          // Save in new format and remove old key
          localStorage.setItem(this.STORAGE_KEY_API_KEYS, JSON.stringify(keysMap));
          localStorage.removeItem("umpleAiApiKey");
          return keysMap;
        }
        
        return {};
      },
      "Error retrieving API keys map:"
    ) ?? {};
  },

  /**
   * Save API keys map to localStorage
   * @param {Object} keysMap - Map of provider -> apiKey
   * @returns {boolean} Success status
   */
  saveApiKeysMap(keysMap) {
    return this._withStorage(
      () => {
        localStorage.setItem(this.STORAGE_KEY_API_KEYS, JSON.stringify(keysMap));
        return true;
      },
      "Error saving API keys map:"
    ) ?? false;
  },

  /**
   * Save API key for a specific provider to localStorage
   * @param {string} provider - The provider name
   * @param {string} apiKey - The API key to save
   * @returns {boolean} Success status
   */
  saveApiKey(provider, apiKey) {
    if (!provider) {
      console.error("Provider is required to save API key");
      return false;
    }
    const key = apiKey?.trim();
    const keysMap = this.getApiKeysMap();
    if (key) {
      keysMap[provider] = key;
    } else {
      delete keysMap[provider];
    }
    return this.saveApiKeysMap(keysMap);
  },

  /**
   * Retrieve API key for a specific provider from localStorage
   * @param {string} provider - The provider name
   * @returns {string} The API key for the provider, or empty string if not found
   */
  getApiKey(provider) {
    if (!provider) return "";
    const keysMap = this.getApiKeysMap();
    return keysMap[provider] || "";
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
   * @returns {string} The model name, or empty string if not found
   */
  getModel() {
    return this._withStorage(
      () => localStorage.getItem(this.STORAGE_KEY_MODEL) || "",
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
         const stored = localStorage.getItem(this.STORAGE_KEY_VERIFIED);
         if (stored) {
           try {
             const verifiedMap = JSON.parse(stored);
             return verifiedMap[providerToCheck] === true;
           } catch (e) {
             return stored === "true";
           }
         }
         return false;
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
         let verifiedMap = {};
         const stored = localStorage.getItem(this.STORAGE_KEY_VERIFIED);
         
         if (stored) {
           try {
             verifiedMap = JSON.parse(stored);
           } catch (e) {
             verifiedMap = {};
           }
         }
         
         if (verified) {
           verifiedMap[providerToSet] = true;
         } else {
           delete verifiedMap[providerToSet];
         }
         
         localStorage.setItem(this.STORAGE_KEY_VERIFIED, JSON.stringify(verifiedMap));
         return true;
       },
       "Error setting verification status:"
     ) ?? false;
   }
};

