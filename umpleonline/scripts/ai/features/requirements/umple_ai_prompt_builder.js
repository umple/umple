// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Prompt Builder Module - Build prompts for AI code generation

const PromptBuilder = (() => {
  "use strict";

  // ============================================================================
  // CONSTANTS
  // ============================================================================

  const SYSTEM_PROMPT = `You are an expert in Umple modeling language. Generate only valid Umple code without explanations.`;

  const STATE_MACHINE_PROMPT_TEMPLATE = `You are an expert in Umple modeling language. Based on the following requirement(s), generate ONLY Umple code for a state machine.

Requirements:
{{requirements}}

Generate Umple code that includes:
1. A class with the state machine
2. Use implementsReq to tag the class and state machine with the requirement ID(s)
3. States with transitions based on events mentioned in the requirements
4. Use proper Umple state machine syntax

Rules:
- Output ONLY valid Umple code, no explanations
- Use this format:
  class ClassName {
    implementsReq RequirementID;
    sm {
      state1 { event -> state2; }
      state2 {}
    }
  }
- Include all relevant states and transitions from the requirements
- Use meaningful names for classes, states, and events

Umple code:`;

  const CLASS_DIAGRAM_PROMPT_TEMPLATE = `You are an expert in Umple modeling language. Based on the following requirement(s), generate ONLY Umple code for a class diagram.

Requirements:
{{requirements}}

Generate Umple code that includes:
1. Classes with attributes based on the requirements
2. Use implementsReq to tag classes with the requirement ID(s)
3. Associations between classes if mentioned in requirements
4. Use proper Umple class diagram syntax

Rules:
- Output ONLY valid Umple code, no explanations
- Use this format:
  class ClassName {
    implementsReq RequirementID;
    attributeName;
    anotherAttribute;
  }

  association {
    implementsReq RequirementID;
    1 Class1 -> * Class2;
  }
- Include all entities and relationships mentioned in the requirements
- Use meaningful names for classes and attributes
- Infer cardinalities from requirement descriptions

Umple code:`;

  // ============================================================================
  // REGEX PATTERNS
  // ============================================================================

  const REGEX_PATTERNS = {
    markdownCodeBlock: /```(?:umple)?\s*([\s\S]*?)```/,
    umpleKeyword: /(?:class|interface|trait|association)\s+\w+/,
    classDefinition: /class\s+\w+/,
    implementsReq: /implementsReq\s+/
  };

  // ============================================================================
  // PUBLIC API
  // ============================================================================

  return {
    /**
     * Get system prompt for code generation
     * @returns {string} System prompt
     */
    getSystemPrompt() {
      return SYSTEM_PROMPT;
    },

    /**
     * Build prompt for state machine generation
     * @param {Array<Object>} requirements - Array of requirement objects
     * @returns {string} Complete prompt for state machine generation
     */
    buildStatemachinePrompt(requirements) {
      const formattedRequirements = RequirementParser.formatForPrompt(requirements);

      return STATE_MACHINE_PROMPT_TEMPLATE.replace(
        /\{\{requirements\}\}/g,
        formattedRequirements
      );
    },

    /**
     * Build prompt for class diagram generation
     * @param {Array<Object>} requirements - Array of requirement objects
     * @returns {string} Complete prompt for class diagram generation
     */
    buildClassDiagramPrompt(requirements) {
      const formattedRequirements = RequirementParser.formatForPrompt(requirements);

      return CLASS_DIAGRAM_PROMPT_TEMPLATE.replace(
        /\{\{requirements\}\}/g,
        formattedRequirements
      );
    },

    /**
     * Build prompt based on generation type
     * @param {Array<Object>} requirements - Array of requirement objects
     * @param {string} generationType - Type of generation ('statemachine' or 'classdiagram')
     * @returns {string} Complete prompt
     * @throws {Error} If generation type is unknown
     */
    buildPrompt(requirements, generationType) {
      switch (generationType) {
        case "statemachine":
          return this.buildStatemachinePrompt(requirements);

        case "classdiagram":
          return this.buildClassDiagramPrompt(requirements);

        default:
          throw new Error(`Unknown generation type: ${generationType}`);
      }
    },

    /**
     * Extract Umple code from AI response
     * Handles multiple response formats (markdown code blocks, plain text)
     * @param {string} aiResponse - Raw AI response
     * @returns {string} Extracted Umple code
     */
    extractUmpleCode(aiResponse) {
      // Try to extract code from markdown code blocks first
      const codeBlockMatch = aiResponse.match(REGEX_PATTERNS.markdownCodeBlock);
      if (codeBlockMatch) {
        return codeBlockMatch[1].trim();
      }

      // If no code block, try to find class definitions or req statements
      const keywordMatch = aiResponse.match(REGEX_PATTERNS.umpleKeyword);
      if (keywordMatch) {
        // Return everything from the first Umple keyword
        const startIndex = aiResponse.indexOf(keywordMatch[0]);
        return aiResponse.substring(startIndex).trim();
      }

      // Return the whole response, trimmed
      return aiResponse.trim();
    },

    /**
     * Build custom prompt with template
     * @param {string} template - Prompt template with {{requirements}} placeholder
     * @param {Array<Object>} requirements - Array of requirement objects
     * @param {Object} additionalVariables - Additional template variables (optional)
     * @returns {string} Custom prompt with all variables replaced
     */
    buildCustomPrompt(template, requirements, additionalVariables = {}) {
      const formattedRequirements = RequirementParser.formatForPrompt(requirements);
      let prompt = template.replace(/\{\{requirements\}\}/g, formattedRequirements);

      // Replace additional template variables
      Object.entries(additionalVariables).forEach(([key, value]) => {
        const placeholderPattern = new RegExp(`\\{\\{${key}\\}\\}`, "g");
        prompt = prompt.replace(placeholderPattern, value);
      });

      return prompt;
    },

    /**
     * Validate generated Umple code
     * @param {string} generatedCode - Generated Umple code
     * @returns {Object} Validation result with valid flag and errors array
     */
    validateGeneratedCode(generatedCode) {
      const errors = this.collectValidationErrors(generatedCode);

      return {
        valid: errors.length === 0,
        errors
      };
    },

    // ==========================================================================
    // PRIVATE HELPERS
    // ==========================================================================

    /**
     * Collect validation errors for generated code
     * @private
     * @param {string} generatedCode - Generated Umple code to validate
     * @returns {Array<string>} Array of error messages (empty if valid)
     */
    collectValidationErrors(generatedCode) {
      const errors = [];

      // Check for empty code
      if (!generatedCode || generatedCode.trim().length === 0) {
        errors.push("Generated code is empty");
        return errors; // Early return for empty code
      }

      // Check for basic Umple syntax elements
      this.validateUmpleSyntax(generatedCode, errors);

      // Check for balanced braces
      this.validateBraceBalance(generatedCode, errors);

      return errors;
    },

    /**
     * Validate Umple syntax elements
     * @private
     * @param {string} code - Generated code to validate
     * @param {Array<string>} errors - Array to collect errors
     */
    validateUmpleSyntax(code, errors) {
      const hasClass = REGEX_PATTERNS.classDefinition.test(code);
      const hasImplementsReq = REGEX_PATTERNS.implementsReq.test(code);

      // Not all generated code needs to have implementsReq, but warn if missing
      if (hasClass && !hasImplementsReq) {
        // Warning only, not an error
        console.warn("Generated code does not use implementsReq to link to requirements");
      }
    },

    /**
     * Validate that braces are balanced
     * @private
     * @param {string} code - Generated code to validate
     * @param {Array<string>} errors - Array to collect errors
     */
    validateBraceBalance(code, errors) {
      const openBraceCount = (code.match(/\{/g) || []).length;
      const closeBraceCount = (code.match(/\}/g) || []).length;

      if (openBraceCount !== closeBraceCount) {
        errors.push(
          `Unbalanced braces: ${openBraceCount} open, ${closeBraceCount} close`
        );
      }
    }
  };
})();
