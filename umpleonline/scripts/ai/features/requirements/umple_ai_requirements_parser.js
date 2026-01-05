// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Requirements Parser Module - Parse and validate Umple requirements

const RequirementParser = {
  // Regex pattern for matching requirements: req ID { text }
  PATTERN: /req\s+(\w+(?:[-_]\w+)*)\s*\{([^}]*)\}/gs,

  // Valid requirement ID pattern (alphanumeric, hyphens, underscores)
  ID_PATTERN: /^[a-zA-Z0-9_-]+$/,

  /**
   * Parse all requirements from Umple code
   * @param {string} umpleCode - The Umple code to parse
   * @returns {Array<Object>} Array of requirement objects {id, text, startIndex, endIndex}
   */
  parseRequirements(umpleCode) {
    const requirements = [];
    let match;

    // Reset regex state
    this.PATTERN.lastIndex = 0;

    while ((match = this.PATTERN.exec(umpleCode)) !== null) {
      const id = match[1].trim();
      const text = match[2].trim();

      if (id && text) {
        requirements.push({
          id,
          text,
          startIndex: match.index,
          endIndex: match.index + match[0].length
        });
      }
    }

    return requirements;
  },

  /**
   * Validate a requirement object
   * @param {Object} requirement - Requirement object {id, text}
   * @throws {Error} If requirement is invalid
   */
  validateRequirement(requirement) {
    if (!requirement) {
      throw AiErrors.createValidationError(
        "Requirement object is null or undefined",
        { requirement }
      );
    }

    if (!requirement.id) {
      throw AiErrors.createValidationError(
        "Requirement must have an ID",
        { requirement }
      );
    }

    if (!this.ID_PATTERN.test(requirement.id)) {
      throw AiErrors.createValidationError(
        `Invalid requirement ID: "${requirement.id}". ID must be alphanumeric (can include hyphens and underscores)`,
        { requirement, id: requirement.id }
      );
    }

    if (!requirement.text || requirement.text.trim().length === 0) {
      throw AiErrors.createValidationError(
        `Requirement "${requirement.id}" has empty text`,
        { requirement, id: requirement.id }
      );
    }

    if (requirement.text.length > 10000) {
      throw AiErrors.createValidationError(
        `Requirement "${requirement.id}" is too long (max 10000 characters)`,
        { requirement, id: requirement.id, length: requirement.text.length }
      );
    }
  },

  /**
   * Validate multiple requirements
   * @param {Array<Object>} requirements - Array of requirement objects
   * @returns {Object} Validation result {valid: boolean, errors: Array<Error>}
   */
  validateRequirements(requirements) {
    const errors = [];

    for (const requirement of requirements) {
      try {
        this.validateRequirement(requirement);
      } catch (error) {
        errors.push(error);
      }
    }

    return {
      valid: errors.length === 0,
      errors
    };
  },

  /**
   * Filter requirements by IDs
   * @param {string} umpleCode - Umple code to parse
   * @param {Array<string>} ids - Array of requirement IDs to filter
   * @returns {Array<Object>} Filtered requirements
   */
  findRequirementsById(umpleCode, ids) {
    const allRequirements = this.parseRequirements(umpleCode);
    const idSet = new Set(ids);

    return allRequirements.filter(req => idSet.has(req.id));
  },

  /**
   * Get a single requirement by ID
   * @param {string} umpleCode - Umple code to parse
   * @param {string} id - Requirement ID
   * @returns {Object|null} Requirement object or null if not found
   */
  findRequirementById(umpleCode, id) {
    const requirements = this.parseRequirements(umpleCode);
    return requirements.find(req => req.id === id) || null;
  },

  /**
   * Get requirement summary text for display
   * @param {Object} requirement - Requirement object
   * @param {number} maxLength - Maximum length of summary
   * @returns {string} Summary text
   */
  getSummary(requirement, maxLength = null) {
    const length = maxLength ?? AiConfig.get("requirements.summaryLength", 100);
    const text = requirement.text || "";

    if (text.length <= length) {
      return text;
    }

    return text.substring(0, length) + "...";
  },

  /**
   * Check if Umple code contains any requirements
   * @param {string} umpleCode - Umple code to check
   * @returns {boolean} True if requirements are found
   */
  hasRequirements(umpleCode) {
    this.PATTERN.lastIndex = 0;
    return this.PATTERN.test(umpleCode);
  },

  /**
   * Count requirements in Umple code
   * @param {string} umpleCode - Umple code to count
   * @returns {number} Number of requirements
   */
  countRequirements(umpleCode) {
    return this.parseRequirements(umpleCode).length;
  },

  /**
   * Extract requirement IDs from Umple code
   * @param {string} umpleCode - Umple code to extract from
   * @returns {Array<string>} Array of requirement IDs
   */
  getRequirementIds(umpleCode) {
    const requirements = this.parseRequirements(umpleCode);
    return requirements.map(req => req.id);
  },

  /**
   * Format requirements for display in AI prompt
   * @param {Array<Object>} requirements - Array of requirement objects
   * @returns {string} Formatted requirements text
   */
  formatForPrompt(requirements) {
    return requirements
      .map(req => `Requirement ${req.id}:\n${req.text}`)
      .join("\n\n");
  }
};
