// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// Umple Dialog Component - Reusable dialog/modal component

const UmpleDialog = {
  // Track active dialogs
  activeDialogs: new Set(),

  /**
   * Show a dialog with options
   * @param {Object} options - Dialog options
   * @param {string} options.title - Dialog title
   * @param {string|HTMLElement} options.content - Dialog content (HTML string or element)
   * @param {Array<Object>} options.buttons - Array of button definitions
   * @param {string} options.buttons[].text - Button text
   * @param {Function} options.buttons[].onClick - Button click handler
   * @param {boolean} options.buttons[].primary - Whether button is primary (default: false)
   * @param {boolean} options.buttons[].disabled - Whether button is disabled (default: false)
   * @param {string} options.width - Dialog width (default: '400px')
   * @param {string} options.maxWidth - Dialog max width (default: '400px')
   * @param {boolean} options.closeOnOverlay - Close on overlay click (default: true)
   * @param {boolean} options.showCloseButton - Show close button (default: true)
   * @param {Function} options.onClose - Callback when dialog is closed
   * @param {string} options.dialogClass - Additional CSS class for dialog
   * @param {boolean} options.nonDismissible - Prevent closing via overlay or ESC (default: false)
   * @returns {HTMLElement} The dialog element
   */
  show(options) {
    const {
      title = "",
      content = "",
      buttons = [],
      width = "400px",
      maxWidth = "400px",
      closeOnOverlay = true,
      showCloseButton = true,
      onClose = null,
      dialogClass = "",
      nonDismissible = false
    } = options;

    // Remove existing dialog with same class if any
    if (dialogClass) {
      const existing = document.querySelector(`.umple-dialog.${dialogClass}`);
      if (existing) {
        this.close(existing);
      }
    }

    // Create dialog container
    const dialog = document.createElement("div");
    dialog.className = `umple-dialog ${dialogClass}`.trim();
    dialog.style.width = width;
    dialog.style.maxWidth = maxWidth;

    // Create overlay
    const overlay = document.createElement("div");
    overlay.className = "dialog-overlay";
    if (nonDismissible) {
      overlay.style.pointerEvents = "none";
    }
    dialog.appendChild(overlay);

    // Create dialog content
    const contentDiv = document.createElement("div");
    contentDiv.className = "dialog-content";

    // Add title
    if (title) {
      const titleElement = document.createElement("h3");
      titleElement.textContent = title;
      contentDiv.appendChild(titleElement);
    }

    // Add content
    if (typeof content === "string") {
      const contentWrapper = document.createElement("div");
      contentWrapper.innerHTML = content;
      contentDiv.appendChild(contentWrapper);
    } else if (content instanceof HTMLElement) {
      contentDiv.appendChild(content);
    }

    // Add buttons
    if (buttons.length > 0) {
      const buttonsDiv = document.createElement("div");
      buttonsDiv.className = "dialog-buttons";

      buttons.forEach(buttonConfig => {
        const button = this.createButton(buttonConfig);
        buttonsDiv.appendChild(button);
      });

      contentDiv.appendChild(buttonsDiv);
    }

    // Add close button
    if (showCloseButton && !nonDismissible) {
      const closeBtn = document.createElement("div");
      closeBtn.className = "dialog-close-button";
      closeBtn.innerHTML = "&times;";
      closeBtn.setAttribute("role", "button");
      closeBtn.tabIndex = 0;
      closeBtn.title = "Close";

      const closeHandler = (event) => {
        event.preventDefault();
        this.close(dialog);
      };

      closeBtn.addEventListener("click", closeHandler);
      closeBtn.addEventListener("keypress", (event) => {
        if (event.key === "Enter" || event.key === " ") {
          closeHandler(event);
        }
      });

      contentDiv.appendChild(closeBtn);
    }

    dialog.appendChild(contentDiv);
    document.body.appendChild(dialog);

    // Track dialog
    this.activeDialogs.add(dialog);

    // Set up event listeners
    if (!nonDismissible) {
      // Close on overlay click
      if (closeOnOverlay) {
        overlay.addEventListener("click", () => this.close(dialog));
      }

      // Close on ESC key
      const escHandler = (event) => {
        if (event.key === "Escape" && this.activeDialogs.has(dialog)) {
          this.close(dialog);
        }
      };
      document.addEventListener("keydown", escHandler);
      dialog._escHandler = escHandler;
    }

    // Store onClose callback
    dialog._onClose = onClose;

    // Focus first focusable element
    setTimeout(() => {
      const focusable = dialog.querySelector(
        'button, [href], input, select, textarea, [tabindex]:not([tabindex="-1"])'
      );
      if (focusable) {
        focusable.focus();
      }
    }, 100);

    return dialog;
  },

  /**
   * Create a button element
   * @param {Object} config - Button configuration
   * @returns {HTMLElement} Button element
   */
  createButton(config) {
    const {
      text = "",
      onClick = null,
      primary = false,
      disabled = false,
      className = ""
    } = config;

    const button = document.createElement("div");
    button.className = `jQuery-palette-button unselectable ui-button ui-corner-all ui-widget ${className} ${primary ? "ui-state-primary" : ""}`.trim();
    button.tabIndex = 0;
    button.setAttribute("role", "button");
    button.textContent = text;

    if (disabled) {
      button.classList.add("disabled");
      button.setAttribute("aria-disabled", "true");
    }

    if (onClick && !disabled) {
      const handler = (event) => {
        event.preventDefault();
        const result = onClick(event, button);

        // Close dialog if onClick returns true
        if (result === true) {
          const dialog = button.closest(".umple-dialog");
          if (dialog) {
            this.close(dialog);
          }
        }
      };

      button.addEventListener("click", handler);
      button.addEventListener("keypress", (event) => {
        if (event.key === "Enter" || event.key === " ") {
          handler(event);
        }
      });
    }

    return button;
  },

  /**
   * Close a dialog
   * @param {HTMLElement} dialog - Dialog element to close
   */
  close(dialog) {
    if (!dialog || !this.activeDialogs.has(dialog)) {
      return;
    }

    // Remove ESC handler
    if (dialog._escHandler) {
      document.removeEventListener("keydown", dialog._escHandler);
      delete dialog._escHandler;
    }

    // Call onClose callback
    if (dialog._onClose) {
      try {
        dialog._onClose(dialog);
      } catch (error) {
        console.error("Error in dialog onClose callback:", error);
      }
    }

    // Remove from DOM and tracking
    dialog.remove();
    this.activeDialogs.delete(dialog);
  },

  /**
   * Close all active dialogs
   */
  closeAll() {
    const dialogs = Array.from(this.activeDialogs);
    dialogs.forEach(dialog => this.close(dialog));
  },

  /**
   * Show a confirmation dialog
   * @param {string} message - Confirmation message
   * @param {string} title - Dialog title (default: "Confirm")
   * @returns {Promise<boolean>} Promise resolving to true if confirmed
   */
  confirm(message, title = "Confirm") {
    return new Promise((resolve) => {
      const dialog = this.show({
        title,
        content: `<p>${message}</p>`,
        buttons: [
          {
            text: "Cancel",
            onClick: () => {
              resolve(false);
              return true; // Close dialog
            }
          },
          {
            text: "OK",
            primary: true,
            onClick: () => {
              resolve(true);
              return true; // Close dialog
            }
          }
        ]
      });

      // Store resolve function for ESC key
      dialog._confirmResolve = resolve;
      dialog._onClose = () => {
        if (dialog._confirmResolve) {
          dialog._confirmResolve(false);
        }
      };
    });
  },

  /**
   * Show an alert dialog
   * @param {string} message - Alert message
   * @param {string} title - Dialog title (default: "Alert")
   * @returns {Promise<void>} Promise resolving when dialog is closed
   */
  alert(message, title = "Alert") {
    return new Promise((resolve) => {
      this.show({
        title,
        content: `<p>${message}</p>`,
        buttons: [
          {
            text: "OK",
            primary: true,
            onClick: () => {
              resolve();
              return true; // Close dialog
            }
          }
        ]
      });
    });
  },

  /**
   * Update dialog content
   * @param {HTMLElement} dialog - Dialog element
   * @param {string|HTMLElement} newContent - New content
   */
  updateContent(dialog, newContent) {
    if (!dialog) return;

    const contentDiv = dialog.querySelector(".dialog-content");
    if (!contentDiv) return;

    // Find the content wrapper (first div after h3)
    let contentWrapper = contentDiv.querySelector("div:not(.dialog-buttons):not(.dialog-close-button)");
    if (!contentWrapper) {
      contentWrapper = document.createElement("div");
      contentDiv.insertBefore(contentWrapper, contentDiv.firstChild.nextSibling);
    }

    if (typeof newContent === "string") {
      contentWrapper.innerHTML = newContent;
    } else if (newContent instanceof HTMLElement) {
      contentWrapper.innerHTML = "";
      contentWrapper.appendChild(newContent);
    }
  },

  /**
   * Get dialog element by class
   * @param {string} dialogClass - Dialog class name
   * @returns {HTMLElement|null} Dialog element or null
   */
  getDialog(dialogClass) {
    return document.querySelector(`.umple-dialog.${dialogClass}`);
  },

  /**
   * Check if a dialog is open
   * @param {string} dialogClass - Dialog class name
   * @returns {boolean} True if dialog is open
   */
  isOpen(dialogClass) {
    return this.getDialog(dialogClass) !== null;
  }
};
