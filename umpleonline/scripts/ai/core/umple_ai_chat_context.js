// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Chat Context - Shared context container for multi-turn chat sessions

const AiChatContext = {
  /**
   * Create a new chat context
   * @param {string} systemPrompt
   * @param {Array<{role: string, content: string}>} initialMessages
   * @returns {{systemPrompt: string, messages: Array<{role: "user"|"assistant", content: string}>}}
   */
  create(systemPrompt = "", initialMessages = []) {
    const context = {
      systemPrompt: String(systemPrompt || "").trim(),
      messages: []
    };

    (Array.isArray(initialMessages) ? initialMessages : []).forEach(message => {
      this.addMessage(context, message?.role, message?.content);
    });

    return context;
  },

  /**
   * Validate a context object
   * @param {Object} context
   * @returns {boolean}
   */
  isValid(context) {
    return !!context && typeof context === "object" && Array.isArray(context.messages);
  },

  /**
   * Add a message to context
   * @param {Object} context
   * @param {string} role
   * @param {string} content
   * @returns {Object} context
   */
  addMessage(context, role, content) {
    if (!this.isValid(context)) {
      throw AiErrors.createValidationError("Invalid chat context");
    }

    const normalizedRole = String(role || "").trim();
    if (normalizedRole !== "user" && normalizedRole !== "assistant") {
      throw AiErrors.createValidationError(`Invalid chat role: ${normalizedRole || "(empty)"}`);
    }

    const text = String(content || "").trim();
    if (!text) {
      throw AiErrors.createValidationError("Message content cannot be empty");
    }

    context.messages.push({ role: normalizedRole, content: text });
    return context;
  },

  addUser(context, content) {
    return this.addMessage(context, "user", content);
  },

  addAssistant(context, content) {
    return this.addMessage(context, "assistant", content);
  },

  /**
   * Keep only the latest N user/assistant messages
   * @param {Object} context
   * @param {number} keepLastN
   * @returns {Object} context
   */
  trim(context, keepLastN = 10) {
    if (!this.isValid(context)) return context;
    const n = Math.max(0, Number(keepLastN) || 0);
    if (n === 0) {
      context.messages = [];
      return context;
    }
    if (context.messages.length > n) {
      context.messages = context.messages.slice(-n);
    }
    return context;
  },

  /**
   * Convert context to provider-compatible message list
   * @param {Object} context
   * @returns {Array<{role: string, content: string}>}
   */
  contextToMessages(context) {
    if (!this.isValid(context)) {
      throw AiErrors.createValidationError("Invalid chat context");
    }

    const messages = [];
    const systemPrompt = String(context.systemPrompt || "").trim();
    if (systemPrompt) {
      messages.push({ role: "system", content: systemPrompt });
    }

    context.messages.forEach(message => {
      if (!message || typeof message !== "object") return;
      const role = String(message.role || "").trim();
      const content = String(message.content || "").trim();
      if ((role === "user" || role === "assistant") && content) {
        messages.push({ role, content });
      }
    });

    if (messages.length === 0) {
      throw AiErrors.createValidationError("Chat context has no messages");
    }

    return messages;
  },

  // Alias retained for internal call sites.
  toMessages(context) {
    return this.contextToMessages(context);
  }
};
