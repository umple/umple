// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Explain Feature for UmpleOnline
// Explains Umple code with follow-up conversation support

const AiExplain = {
  // Conversation history for follow-up context
  conversationHistory: [],

  // Current explanation for context
  currentExplanation: null,

  // Active stream handle (for abort)
  activeStream: null,

  // Thinking animation state
  thinkingInterval: null,

  /**
   * Check if API key and model are configured
   * @returns {Object} {configured: boolean, message: string}
   */
  checkApiConfig() {
    return AiConfigValidation.checkApiConfig({ requireVerified: false });
  },


  /**
   * Reset conversation history
   */
  resetConversation() {
    this.conversationHistory = [];
    this.currentExplanation = null;
  },

  abortActiveStream() {
    try {
      this.activeStream?.abort?.();
    } catch (e) {
      // ignore
    } finally {
      this.activeStream = null;
    }
    this.stopThinkingAnimation();
  },

  /**
   * Start thinking animation in explanation text
   * @param {HTMLElement} targetElement - Element to animate
   */
  startThinkingAnimation(targetElement) {
    if (!targetElement) return;

    this.stopThinkingAnimation();

    let dots = 0;
    const updateThinking = () => {
      dots = (dots % 3) + 1;
      targetElement.textContent = "thinking" + ".".repeat(dots);
    };

    updateThinking();
    this.thinkingInterval = setInterval(updateThinking, 500);
  },

  /**
   * Stop thinking animation
   */
  stopThinkingAnimation() {
    if (this.thinkingInterval) {
      clearInterval(this.thinkingInterval);
      this.thinkingInterval = null;
    }
  },

  /**
   * Add message to conversation history
   * @param {string} role - Role ('user' or 'assistant')
   * @param {string} content - Message content
   */
  addToHistory(role, content) {
    this.conversationHistory.push({ role, content });

    // Keep only last 10 messages to manage token usage
    if (this.conversationHistory.length > 10) {
      this.conversationHistory = this.conversationHistory.slice(-10);
    }
  },

  _createBufferedStreamRenderer({ targetElement, scrollContainer = null, format, onFirstChunk = null, updateIntervalMs = 120 }) {
    let buffer = "";
    let updateTimer = null;
    let hasReceivedFirstChunk = false;

    const renderNow = () => {
      if (!targetElement) return;
      targetElement.innerHTML = format(buffer);
      if (scrollContainer) {
        scrollContainer.scrollTop = scrollContainer.scrollHeight;
      }
    };

    const scheduleUpdate = () => {
      if (updateTimer) return;
      updateTimer = setTimeout(() => {
        updateTimer = null;
        renderNow();
      }, updateIntervalMs);
    };

    return {
      append(chunk) {
        if (!hasReceivedFirstChunk) {
          hasReceivedFirstChunk = true;
          if (typeof onFirstChunk === "function") {
            onFirstChunk();
          }
        }
        buffer += chunk;
        scheduleUpdate();
      },
      hasContent() {
        return !!buffer.trim();
      },
      flush() {
        if (updateTimer) {
          clearTimeout(updateTimer);
          updateTimer = null;
        }
        if (buffer.trim()) {
          renderNow();
        }
      },
      clearTimer() {
        if (updateTimer) {
          clearTimeout(updateTimer);
          updateTimer = null;
        }
      }
    };
  },

  /**
   * Show the explain dialog and start explaining immediately
   */
  async showDialog() {
    // Get current Umple code
    const umpleCode = Page.codeMirrorEditor6?.state.doc.toString() || "";

    if (!umpleCode.trim()) {
      alert("No code in the editor to explain. Please enter some Umple code first.");
      return;
    }

    // Check API configuration
    const apiConfig = this.checkApiConfig();
    if (!apiConfig.configured) {
      if (typeof AiSettings !== "undefined" && AiSettings.showSettingsModal) {
        AiSettings.showSettingsModal();
      }
      alert(apiConfig.message);
      return;
    }

    // Create and show dialog with loading state
    this.createDialog();

    // Reset conversation and start explaining immediately
    this.resetConversation();
    await this.performExplanation(umpleCode);
  },

  /**
   * Create the explain dialog UI
   */
  createDialog() {
    // Remove existing dialog if any
    const existingDialog = document.getElementById("aiExplainDialog");
    if (existingDialog) {
      existingDialog.remove();
    }

    // Create dialog container
    const dialog = document.createElement("div");
    dialog.id = "aiExplainDialog";
    dialog.className = "ai-explain-dialog";

    // Create overlay
    const overlay = document.createElement("div");
    overlay.className = "dialog-overlay";
    dialog.appendChild(overlay);

    // Create dialog content
    const content = document.createElement("div");
    content.className = "dialog-content";

    // Title
    const title = document.createElement("h3");
    title.textContent = "Explain Code";
    content.appendChild(title);

    // Status message (shown first)
    const statusDiv = document.createElement("div");
    statusDiv.id = "explainStatusMessage";
    statusDiv.className = "status-message";
    statusDiv.textContent = "";
    content.appendChild(statusDiv);

    // Explanation display area (hidden initially)
    const explanationContainer = document.createElement("div");
    explanationContainer.id = "explanationContainer";
    explanationContainer.className = "explanation-container";

    const explanationText = document.createElement("div");
    explanationText.id = "explanationText";
    explanationText.className = "explanation-text";
    explanationContainer.appendChild(explanationText);

    content.appendChild(explanationContainer);

    // Follow-up section (hidden initially)
    const followUpContainer = document.createElement("div");
    followUpContainer.id = "followUpContainer";
    followUpContainer.className = "followup-container";
    followUpContainer.style.display = "none";

    const followUpInput = document.createElement("input");
    followUpInput.type = "text";
    followUpInput.id = "followUpInput";
    followUpInput.className = "followup-input";
    followUpInput.placeholder = "Ask a follow-up question...";
    followUpContainer.appendChild(followUpInput);

    content.appendChild(followUpContainer);

    // Dialog buttons
    const buttonsDiv = document.createElement("div");
    buttonsDiv.className = "dialog-buttons";

    const btnNewConversation = document.createElement("div");
    btnNewConversation.id = "btnNewConversation";
    btnNewConversation.className = "jQuery-palette-button unselectable ui-button ui-corner-all ui-widget";
    btnNewConversation.tabIndex = 0;
    btnNewConversation.setAttribute("role", "button");
    btnNewConversation.style.display = "none";
    btnNewConversation.textContent = "New Conversation";
    buttonsDiv.appendChild(btnNewConversation);

    const btnAsk = document.createElement("div");
    btnAsk.id = "btnAsk";
    btnAsk.className = "jQuery-palette-button unselectable ui-button ui-corner-all ui-widget";
    btnAsk.tabIndex = 0;
    btnAsk.setAttribute("role", "button");
    btnAsk.style.display = "none";
    btnAsk.textContent = "Ask";
    buttonsDiv.appendChild(btnAsk);

    const btnCancel = document.createElement("div");
    btnCancel.id = "btnCancel";
    btnCancel.className = "jQuery-palette-button unselectable ui-button ui-corner-all ui-widget";
    btnCancel.tabIndex = 0;
    btnCancel.setAttribute("role", "button");
    btnCancel.textContent = "Close";
    buttonsDiv.appendChild(btnCancel);

    content.appendChild(buttonsDiv);

    dialog.appendChild(content);
    document.body.appendChild(dialog);

    // Set up event listeners
    this.setupDialogEvents(dialog);
  },

  /**
   * Set up event listeners for the dialog
   * @param {HTMLElement} dialog - The dialog element
   */
  setupDialogEvents(dialog) {
    // Ask button (follow-up)
    const btnAsk = document.getElementById("btnAsk");
    const askHandler = event => {
      event.preventDefault();
      this.handleFollowUp(dialog);
    };
    btnAsk.addEventListener("click", askHandler);
    btnAsk.addEventListener("keypress", event => {
      if (event.key === "Enter" || event.key === " ") askHandler(event);
    });

    // Enter key on follow-up input
    const followUpInput = document.getElementById("followUpInput");
    followUpInput.addEventListener("keypress", event => {
      if (event.key === "Enter") {
        event.preventDefault();
        this.handleFollowUp(dialog);
      }
    });

    // New Conversation button
    const btnNewConversation = document.getElementById("btnNewConversation");
    const newConvHandler = event => {
      event.preventDefault();
      this.abortActiveStream();
      dialog.remove();
      this.showDialog();
    };
    btnNewConversation.addEventListener("click", newConvHandler);
    btnNewConversation.addEventListener("keypress", event => {
      if (event.key === "Enter" || event.key === " ") newConvHandler(event);
    });

    // Cancel button
    const btnCancel = document.getElementById("btnCancel");
    const cancelHandler = event => {
      event.preventDefault();
      this.abortActiveStream();
      dialog.remove();
    };
    btnCancel.addEventListener("click", cancelHandler);
    btnCancel.addEventListener("keypress", event => {
      if (event.key === "Enter" || event.key === " ") cancelHandler(event);
    });

    // Close on overlay click
    const overlay = dialog.querySelector(".dialog-overlay");
    overlay.addEventListener("click", () => {
      this.abortActiveStream();
      dialog.remove();
    });
  },

  /**
   * Perform the explanation
   * @param {string} umpleCode - The Umple code to explain
   */
  async performExplanation(umpleCode) {
    const statusDiv = document.getElementById("explainStatusMessage");
    const explanationContainer = document.getElementById("explanationContainer");
    const explanationText = document.getElementById("explanationText");
    const followUpContainer = document.getElementById("followUpContainer");
    const btnAsk = document.getElementById("btnAsk");
    const btnNewConversation = document.getElementById("btnNewConversation");
    const followUpInput = document.getElementById("followUpInput");

    // Update status
    statusDiv.textContent = "Analyzing your code...";
    statusDiv.className = "status-message ai-status--info";

    this.abortActiveStream();
    explanationText.textContent = "";

    // Start thinking animation
    this.startThinkingAnimation(explanationText);

    const renderer = this._createBufferedStreamRenderer({
      targetElement: explanationText,
      format: text => ExplainPromptBuilder.formatExplanation(text),
      onFirstChunk: () => this.stopThinkingAnimation()
    });

    try {
      // Build prompt using ExplainPromptBuilder
      const prompt = ExplainPromptBuilder.buildInitialPrompt(umpleCode);
      const systemPrompt = ExplainPromptBuilder.getSystemPrompt();

      // Call AI API (stream)
      this.activeStream = AiApi.chatStream(prompt, systemPrompt, {}, {
        onDelta: chunk => {
          renderer.append(chunk);
        }
      });

      const explanation = await this.activeStream.done;
      this.activeStream = null;
      this.stopThinkingAnimation();
      renderer.clearTimer();
      // Validate explanation
      const validation = ExplainPromptBuilder.validateExplanation(explanation);
      if (!validation.valid) {
        console.warn("Explanation validation warnings:", validation.errors);
      }

      // Store explanation and update history
      this.currentExplanation = explanation;
      this.addToHistory("assistant", explanation);

      // Display explanation with markdown-like formatting
      explanationText.innerHTML = ExplainPromptBuilder.formatExplanation(explanation);

      // Show follow-up UI
      followUpContainer.style.display = "block";
      followUpInput.style.display = "block";
      btnAsk.style.display = "inline-block";
      btnNewConversation.style.display = "inline-block";

      // Update status
      statusDiv.textContent = "";
      statusDiv.className = "status-message";

      // Focus follow-up input
      followUpInput.focus();
    } catch (error) {
      if (error?.name === "AbortError") {
        this.stopThinkingAnimation();
        if (!renderer.hasContent()) {
          explanationText.textContent = "stopped";
        }
        return;
      }
      this.stopThinkingAnimation();
      if (!renderer.hasContent()) {
        explanationText.textContent = "";
      }
      console.error("Error explaining code:", error);
      statusDiv.textContent = `Error: ${error.message}`;
      statusDiv.className = "status-message ai-status--error";
    } finally {
      renderer.flush();
    }
  },

  /**
   * Handle follow-up question
   * @param {HTMLElement} dialog - The dialog element
   */
  async handleFollowUp(dialog) {
    const statusDiv = document.getElementById("explainStatusMessage");
    const btnAsk = document.getElementById("btnAsk");
    const followUpInput = document.getElementById("followUpInput");
    const explanationText = document.getElementById("explanationText");

    const userQuestion = followUpInput.value.trim();

    if (!userQuestion) {
      statusDiv.textContent = "Please enter a question";
      statusDiv.className = "status-message ai-status--error";
      return;
    }

    // Disable button and show loading
    btnAsk.classList.add("disabled");
    btnAsk.textContent = "Asking...";
    followUpInput.disabled = true;
    statusDiv.textContent = "Getting answer...";
    statusDiv.className = "status-message ai-status--info";

    this.abortActiveStream();

    let renderer = null;
    let answerTarget = null;

    try {
      // Add user question to history
      this.addToHistory("user", userQuestion);

      // Build follow-up prompt using ExplainPromptBuilder
      const prompt = ExplainPromptBuilder.buildFollowUpPrompt(
        this.conversationHistory,
        userQuestion
      );
      const systemPrompt = ExplainPromptBuilder.getSystemPrompt();

      // Append placeholder Q/A
      const qaWrapper = document.createElement("div");
      qaWrapper.className = "followup-qa";

      const qDiv = document.createElement("div");
      qDiv.className = "followup-question";
      const qStrong = document.createElement("strong");
      qStrong.textContent = "You:";
      qDiv.appendChild(qStrong);
      qDiv.appendChild(document.createTextNode(` ${userQuestion}`));

      const aDiv = document.createElement("div");
      aDiv.className = "followup-answer";
      const aContent = document.createElement("div");
      aContent.className = "followup-answer-content";
      aContent.textContent = "";
      answerTarget = aContent;
      aDiv.appendChild(aContent);

      renderer = this._createBufferedStreamRenderer({
        targetElement: aContent,
        scrollContainer: explanationText,
        format: text => ExplainPromptBuilder.formatExplanation(text),
        onFirstChunk: () => this.stopThinkingAnimation()
      });

      qaWrapper.appendChild(qDiv);
      qaWrapper.appendChild(aDiv);
      explanationText.appendChild(qaWrapper);
      explanationText.appendChild(document.createElement("hr"));

      // Scroll to bottom after adding Q/A
      explanationText.scrollTop = explanationText.scrollHeight;

      // Call AI API (stream)
      // Start thinking animation for the answer
      this.startThinkingAnimation(aContent);

      this.activeStream = AiApi.chatStream(prompt, systemPrompt, {}, {
        onDelta: chunk => {
          renderer?.append(chunk);
        }
      });

      const answer = await this.activeStream.done;
      this.activeStream = null;
      this.stopThinkingAnimation();

      renderer?.clearTimer();

      // Add answer to history
      this.addToHistory("assistant", answer);

      // Final formatting pass for the answer
      aContent.innerHTML = ExplainPromptBuilder.formatExplanation(answer);

      // Final scroll to bottom
      explanationText.scrollTop = explanationText.scrollHeight;

      // Clear input
      followUpInput.value = "";

      statusDiv.textContent = "";
      statusDiv.className = "status-message";

      // Focus follow-up input
      followUpInput.focus();
    } catch (error) {
      if (error?.name === "AbortError") {
        this.stopThinkingAnimation();
        if (!renderer?.hasContent() && answerTarget) {
          answerTarget.textContent = "stopped";
        }
        return;
      }
      this.stopThinkingAnimation();
      if (!renderer?.hasContent() && answerTarget) {
        answerTarget.textContent = "";
      }
      console.error("Error asking follow-up:", error);
      statusDiv.textContent = `Error: ${error.message}`;
      statusDiv.className = "status-message ai-status--error";
    } finally {
      renderer?.flush();
      btnAsk.classList.remove("disabled");
      btnAsk.textContent = "Ask";
      followUpInput.disabled = false;
    }
  }
};
