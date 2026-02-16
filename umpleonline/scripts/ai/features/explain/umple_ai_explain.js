// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Explain Feature for UmpleOnline
// Explains Umple code with follow-up conversation support

const AiExplain = {
  // Chat context for follow-up conversation
  chatContext: null,

  // Active stream handle (for abort)
  activeStream: null,

  // Thinking animation state
  thinkingInterval: null,

  // Minimized state
  isMinimized: false,

  /**
   * Check if API key and model are configured
   * @returns {Object} {configured: boolean, message: string}
   */
  checkApiConfig() {
    return AiConfigValidation.checkApiConfig({ requireVerified: true });
  },


  /**
   * Reset conversation history
   */
  resetConversation() {
    this.chatContext = null;
    this.updateExplainButtonIndicator();
  },

  /**
   * Check if there's an ongoing conversation
   * @returns {boolean}
   */
  hasOngoingConversation() {
    return !!(this.chatContext && Array.isArray(this.chatContext.messages) && this.chatContext.messages.length > 0);
  },

  /**
   * Update the indicator on the Explain button
   */
  updateExplainButtonIndicator() {
    const explainButton = document.getElementById("buttonExplain");
    if (!explainButton) return;

    let indicator = document.getElementById("explainButtonIndicator");

    if (this.hasOngoingConversation()) {
      if (!indicator) {
        indicator = document.createElement("span");
        indicator.id = "explainButtonIndicator";
        indicator.className = "explain-button-indicator";
        indicator.textContent = "●";
        indicator.title = "Ongoing conversation";
        explainButton.appendChild(indicator);
      }
    } else if (indicator) {
      indicator.remove();
    }
  },

  abortActiveStream() {
    AiStreamUtils?.abort?.(this.activeStream);
    this.activeStream = null;
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
   * Show the explain dialog and start explaining immediately
   */
  async showDialog() {
    // If dialog exists and is minimized, restore it first (before any validation)
    // This ensures users can always get back to their minimized conversation
    const existingDialog = document.getElementById("aiExplainDialog");
    if (existingDialog && this.isMinimized) {
      this.restoreDialog();
      return;
    }

    // If dialog exists with content but not minimized, just focus it
    if (existingDialog && !this.isMinimized) {
      return;
    }

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
    const dialog = this.createDialog();

    // Only reset conversation if there isn't one already
    // (Allows resuming minimized conversations)
    if (!this.hasOngoingConversation()) {
      this.resetConversation();
    }
    await this.performExplanation(dialog, umpleCode);
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

    // Header with title and minimize button
    const header = document.createElement("div");
    header.className = "ai-explain-header";

    const title = document.createElement("h3");
    title.textContent = "Explain Code";
    header.appendChild(title);

    // Minimize button
    const btnMinimize = document.createElement("button");
    btnMinimize.id = "btnMinimizeExplain";
    btnMinimize.className = "ai-explain-minimize-btn";
    btnMinimize.innerHTML = "&#8211;"; // En dash for minimize icon
    btnMinimize.setAttribute("aria-label", "Minimize dialog");
    btnMinimize.setAttribute("title", "Minimize (conversation will be saved)");
    header.appendChild(btnMinimize);

    // Tooltip for minimize button (custom tooltip to ensure it appears above dialog)
    const minimizeTooltip = document.createElement("span");
    minimizeTooltip.className = "ai-explain-tooltip";
    minimizeTooltip.textContent = "Minimize (conversation will be saved)";
    btnMinimize.appendChild(minimizeTooltip);

    content.appendChild(header);

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
    followUpInput.setAttribute("title", "Ask a follow-up question about this explanation");
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
    btnNewConversation.setAttribute("aria-label", "Start a new conversation");
    btnNewConversation.setAttribute("title", "Start a new explanation using the current editor code");
    btnNewConversation.style.display = "none";
    btnNewConversation.textContent = "New Conversation";
    buttonsDiv.appendChild(btnNewConversation);

    const btnAsk = document.createElement("div");
    btnAsk.id = "btnAsk";
    btnAsk.className = "jQuery-palette-button unselectable ui-button ui-corner-all ui-widget";
    btnAsk.tabIndex = 0;
    btnAsk.setAttribute("role", "button");
    btnAsk.setAttribute("aria-label", "Ask follow-up question");
    btnAsk.setAttribute("title", "Send your follow-up question to the AI");
    btnAsk.style.display = "none";
    btnAsk.textContent = "Ask";
    buttonsDiv.appendChild(btnAsk);

    const btnCancel = document.createElement("div");
    btnCancel.id = "btnCancelExplain";
    btnCancel.className = "jQuery-palette-button unselectable ui-button ui-corner-all ui-widget";
    btnCancel.tabIndex = 0;
    btnCancel.setAttribute("role", "button");
    btnCancel.setAttribute("aria-label", "Close explanation dialog");
    btnCancel.setAttribute("title", "Close this dialog and clear the conversation");
    btnCancel.textContent = "Close";
    buttonsDiv.appendChild(btnCancel);

    content.appendChild(buttonsDiv);

    dialog.appendChild(content);
    document.body.appendChild(dialog);

    // Set up event listeners
    this.setupDialogEvents(dialog);

    return dialog;
  },

  /**
   * Minimize the dialog (preserve content and history)
   */
  minimizeDialog() {
    const dialog = document.getElementById("aiExplainDialog");
    if (!dialog) return;

    // Store minimized state
    this.isMinimized = true;

    // Hide the full dialog to allow interaction with the page
    dialog.style.display = "none";

    // Update status to indicate minimized state
    if (typeof AiController !== "undefined" && AiController.updateStatus) {
      AiController.updateStatus("Explanation minimized. Click Explain to resume.");
    }
  },

  /**
   * Restore the minimized dialog
   */
  restoreDialog() {
    const dialog = document.getElementById("aiExplainDialog");
    if (!dialog) return;

    // Show the dialog
    dialog.style.display = "";
    this.isMinimized = false;

    // Focus the follow-up input if container is visible
    const followUpContainer = dialog.querySelector("#followUpContainer");
    const followUpInput = dialog.querySelector("#followUpInput");
    if (followUpInput && followUpContainer && followUpContainer.style.display !== "none") {
      followUpInput.focus();
    }
  },

  /**
   * Set up event listeners for the dialog
   * @param {HTMLElement} dialog - The dialog element
   */
  setupDialogEvents(dialog) {
    // Minimize button
    const btnMinimize = dialog.querySelector("#btnMinimizeExplain");
    if (btnMinimize && !btnMinimize.dataset.aiEventsBound) {
      btnMinimize.dataset.aiEventsBound = "true";
      const minimizeHandler = event => {
        event.preventDefault();
        this.minimizeDialog();
      };
      btnMinimize.addEventListener("click", minimizeHandler);
    }

    // Ask button (follow-up)
    const btnAsk = dialog.querySelector("#btnAsk");
    if (btnAsk && !btnAsk.dataset.aiEventsBound) {
      btnAsk.dataset.aiEventsBound = "true";
      const askHandler = event => {
        event.preventDefault();
        this.handleFollowUp(dialog);
      };
      btnAsk.addEventListener("click", askHandler);
      btnAsk.addEventListener("keydown", event => {
        if (event.key === "Enter" || event.key === " ") {
          event.preventDefault();
          askHandler(event);
        }
      });
    }

    // Enter key on follow-up input
    const followUpInput = dialog.querySelector("#followUpInput");
    if (followUpInput && !followUpInput.dataset.aiEventsBound) {
      followUpInput.dataset.aiEventsBound = "true";
      followUpInput.addEventListener("keypress", event => {
        if (event.key === "Enter") {
          event.preventDefault();
          this.handleFollowUp(dialog);
        }
      });
    }

    // New Conversation button
    const btnNewConversation = dialog.querySelector("#btnNewConversation");
    if (btnNewConversation && !btnNewConversation.dataset.aiEventsBound) {
      btnNewConversation.dataset.aiEventsBound = "true";
      const newConvHandler = event => {
        event.preventDefault();
        this.abortActiveStream();
        this.isMinimized = false;
        this.resetConversation();
        dialog.remove();
        this.showDialog();
      };
      btnNewConversation.addEventListener("click", newConvHandler);
      btnNewConversation.addEventListener("keydown", event => {
        if (event.key === "Enter" || event.key === " ") {
          event.preventDefault();
          newConvHandler(event);
        }
      });
    }

    // Cancel button
    const btnCancel = dialog.querySelector("#btnCancelExplain");
    if (btnCancel && !btnCancel.dataset.aiEventsBound) {
      btnCancel.dataset.aiEventsBound = "true";
      const cancelHandler = event => {
        event.preventDefault();
        this.abortActiveStream();
        this.isMinimized = false;
        this.resetConversation();
        dialog.remove();
      };
      btnCancel.addEventListener("click", cancelHandler);
      btnCancel.addEventListener("keydown", event => {
        if (event.key === "Enter" || event.key === " ") {
          event.preventDefault();
          cancelHandler(event);
        }
      });
    }

    // Close on overlay click - only bind once per dialog
    const overlay = dialog.querySelector(".dialog-overlay");
    if (overlay && !overlay.dataset.aiEventsBound) {
      overlay.dataset.aiEventsBound = "true";
      overlay.addEventListener("click", () => {
        this.abortActiveStream();
        this.isMinimized = false;
        this.resetConversation();
        dialog.remove();
      });
    }
  },

  /**
   * Perform the explanation
   * @param {HTMLElement} dialog - The dialog element
   * @param {string} umpleCode - The Umple code to explain
   */
  async performExplanation(dialog, umpleCode) {
    const statusDiv = dialog?.querySelector("#explainStatusMessage");
    const explanationText = dialog?.querySelector("#explanationText");
    const followUpContainer = dialog?.querySelector("#followUpContainer");
    const btnAsk = dialog?.querySelector("#btnAsk");
    const btnNewConversation = dialog?.querySelector("#btnNewConversation");
    const followUpInput = dialog?.querySelector("#followUpInput");

    if (!statusDiv || !explanationText || !followUpContainer || !btnAsk || !btnNewConversation || !followUpInput) {
      return;
    }

    // Update status
    statusDiv.textContent = "Analyzing your code...";
    statusDiv.className = "status-message ai-status--info";

    this.abortActiveStream();
    explanationText.textContent = "";

    // Start thinking animation
    this.startThinkingAnimation(explanationText);

    const buffered = AiStreamUtils.createBufferedTextRenderer({
      onFirstChunk: () => this.stopThinkingAnimation(),
      onRender: text => {
        if (!explanationText) return;
        explanationText.innerHTML = ExplainPromptBuilder.formatExplanation(text);
      },
      updateIntervalMs: 120
    });

    try {
      // Append raw Umple code to context (system prompt defines explainer role)
      if (!this.chatContext) {
        this.chatContext = AiChatContext.create(ExplainPromptBuilder.getSystemPrompt());
      }
      AiChatContext.addUser(this.chatContext, umpleCode);
      this.updateExplainButtonIndicator();

      // Call AI API (stream)
      this.activeStream = AiApi.chatStream(this.chatContext, {}, {
        onDelta: chunk => {
          buffered.append(chunk);
        }
      });

      const explanation = await this.activeStream.done;
      this.activeStream = null;
      this.stopThinkingAnimation();
      buffered.clearTimer();
      // Validate explanation
      const validation = ExplainPromptBuilder.validateExplanation(explanation);
      if (!validation.valid) {
        console.warn("Explanation validation warnings:", validation.errors);
      }

      // Update history
      if (String(explanation || "").trim()) {
        AiChatContext.addAssistant(this.chatContext, explanation);
        this.updateExplainButtonIndicator();
      }

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
        if (!buffered.hasContent()) {
          explanationText.textContent = "stopped";
        }
        return;
      }
      this.stopThinkingAnimation();
      if (!buffered.hasContent()) {
        explanationText.textContent = "";
      }
      console.error("Error explaining code:", error);
      statusDiv.textContent = `Error: ${error.message}`;
      statusDiv.className = "status-message ai-status--error";
    } finally {
      buffered.flush();
    }
  },

  /**
   * Handle follow-up question
   * @param {HTMLElement} dialog - The dialog element
   */
  async handleFollowUp(dialog) {
    const statusDiv = dialog?.querySelector("#explainStatusMessage");
    const btnAsk = dialog?.querySelector("#btnAsk");
    const followUpInput = dialog?.querySelector("#followUpInput");
    const explanationText = dialog?.querySelector("#explanationText");

    if (!statusDiv || !btnAsk || !followUpInput || !explanationText) {
      return;
    }

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
      // Append raw follow-up question to context
      if (!this.chatContext) {
        this.chatContext = AiChatContext.create(ExplainPromptBuilder.getSystemPrompt());
      }
      AiChatContext.addUser(this.chatContext, userQuestion);
      this.updateExplainButtonIndicator();

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

      renderer = AiStreamUtils.createBufferedTextRenderer({
        onFirstChunk: () => this.stopThinkingAnimation(),
        onRender: text => {
          if (!aContent) return;
          aContent.innerHTML = ExplainPromptBuilder.formatExplanation(text);
          if (explanationText) {
            explanationText.scrollTop = explanationText.scrollHeight;
          }
        },
        updateIntervalMs: 120
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

      this.activeStream = AiApi.chatStream(this.chatContext, {}, {
        onDelta: chunk => {
          renderer?.append(chunk);
        }
      });

      const answer = await this.activeStream.done;
      this.activeStream = null;
      this.stopThinkingAnimation();

      renderer?.clearTimer();

      // Add answer to history
      if (String(answer || "").trim()) {
        AiChatContext.addAssistant(this.chatContext, answer);
        this.updateExplainButtonIndicator();
      }

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
