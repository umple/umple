// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Fix Feature for UmpleOnline
// Provides per-issue guidance (no auto-edit) in compiler output.

const AiFix = {
  activeRequest: null,
  issueCache: [],
  highlightEffect: null,
  highlightField: null,
  highlightHandler: null,

  checkApiConfig() {
    return AiConfigValidation.checkApiConfig({ requireVerified: false });
  },

  abortActiveRequest() {
    try {
      this.activeRequest?.abort?.();
    } catch (e) {
      // ignore
    } finally {
      this.activeRequest = null;
    }
  },

  decorateErrorOutput(container, errorHtml) {
    if (!container) return;

    const html = String(errorHtml || "");
    if (!html.trim()) return;

    const errorRow = container.querySelector("#errorRow");
    if (!errorRow) return;

    const issues = AiCompilerService.parseCompilerIssuesFromErrorHtml(html);
    this.issueCache = issues || [];

    const grouped = this.groupIssueNodes(errorRow);
    if (!grouped.length) return;

    errorRow.innerHTML = "";

    grouped.forEach((nodes, index) => {
      const issue = this.issueCache[index] || null;
      const issueRow = document.createElement("div");
      issueRow.className = "ai-fix-issue";
      issueRow.dataset.issueIndex = String(index);

      const icon = document.createElement("button");
      icon.type = "button";
      icon.className = "ai-fix-icon";
      icon.title = "AI fix guidance";
      icon.innerHTML = "<svg viewBox=\"0 0 24 24\" aria-hidden=\"true\" focusable=\"false\" fill=\"none\" stroke=\"currentColor\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"><path d=\"M7 10h3v-3l-3.5 -3.5a6 6 0 0 1 8 8l6 6a2 2 0 0 1 -3 3l-6 -6a6 6 0 0 1 -8 -8l3.5 3.5\" /></svg>";
      icon.addEventListener("click", (event) => {
        event.preventDefault();
        event.stopPropagation();
        this.handleFixClick(issueRow, issue, html);
      });

      const header = document.createElement("div");
      header.className = "ai-fix-issue-header";

      const content = document.createElement("span");
      content.className = "ai-fix-issue-content";
      nodes.forEach(node => content.appendChild(node));

      header.appendChild(icon);
      header.appendChild(content);
      issueRow.appendChild(header);
      errorRow.appendChild(issueRow);
    });
  },

  groupIssueNodes(errorRow) {
    const nodes = Array.from(errorRow.childNodes);
    const groups = [];
    let current = [];

    nodes.forEach(node => {
      if (node.nodeType === 1 && node.tagName.toLowerCase() === "br") {
        if (current.length) {
          groups.push(current);
          current = [];
        }
        return;
      }

      if (node.nodeType === 3 && !String(node.textContent || "").trim()) {
        return;
      }

      current.push(node);
    });

    if (current.length) groups.push(current);
    return groups;
  },

  async handleFixClick(issueRow, issue, errorHtml) {
    if (!issueRow) return;
    const apiConfig = this.checkApiConfig();
    if (!apiConfig.configured) {
      if (typeof AiController !== "undefined" && AiController.showSettingsModal) {
        AiController.showSettingsModal();
      }
      alert(apiConfig.message);
      return;
    }

    this.goToIssue(issue);

    const subBullets = this.ensureSubBulletContainer(issueRow, true);
    const scan = this.runBasicScan(Page.codeMirrorEditor6?.state.doc.toString() || "");
    if (scan.issues.length > 0) {
      this.appendSubBullet(subBullets, `Scan: ${scan.issues.join("; ")}`);
      this.appendSubBullet(
        subBullets,
        `Stats: lines ${scan.stats.lines}, non-empty ${scan.stats.nonEmptyLines}, chars ${scan.stats.chars}`
      );
    }

    const guidanceBullet = this.appendSubBullet(subBullets, "Generating fix guidance…", true);

    try {
      this.abortActiveRequest();
      const prompt = this.buildGuidancePrompt(issue, errorHtml);
      const systemPrompt = this.getSystemPrompt();

      let buffer = "";
      this.activeRequest = AiApi.chatStream(prompt, systemPrompt, { maxTokens: 500 }, {
        onDelta: chunk => {
          buffer += chunk;
          guidanceBullet.textContent = `- ${buffer}`;
        }
      });

      const resultText = await this.activeRequest.done;
      const cleaned = this.cleanGuidanceText(resultText);
      const formatted = this.formatGuidanceHtml(cleaned || "No guidance produced.");
      guidanceBullet.innerHTML = `- ${formatted}`;
      guidanceBullet.classList.remove("ai-fix-sub-bullet-pending");
    } catch (e) {
      if (e?.name === "AbortError") {
        guidanceBullet.textContent = "- Stopped.";
        return;
      }
      guidanceBullet.textContent = `- Error: ${e?.message || e}`;
      guidanceBullet.classList.remove("ai-fix-sub-bullet-pending");
    } finally {
      this.activeRequest = null;
    }
  },

  ensureSubBulletContainer(issueRow, reset = false) {
    let container = issueRow.querySelector(".ai-fix-sub-bullets");
    if (container && reset) {
      container.remove();
      container = null;
    }
    if (container) return container;

    container = document.createElement("div");
    container.className = "ai-fix-sub-bullets";
    issueRow.appendChild(container);
    return container;
  },

  appendSubBullet(container, text, pending = false) {
    const bullet = document.createElement("div");
    bullet.className = "ai-fix-sub-bullet-item";
    if (pending) bullet.classList.add("ai-fix-sub-bullet-pending");
    bullet.textContent = `- ${text}`;
    container.appendChild(bullet);
    return bullet;
  },

  // Rule based scan 
  runBasicScan(code) {
    const issues = [];
    const stats = {
      lines: 0,
      nonEmptyLines: 0,
      chars: 0
    };

    const text = String(code || "");
    const lines = text.split(/\r?\n/);
    stats.lines = lines.length;
    stats.nonEmptyLines = lines.filter(line => line.trim()).length;
    stats.chars = text.length;

    const braceCount = (text.match(/\{/g) || []).length - (text.match(/\}/g) || []).length;
    const parenCount = (text.match(/\(/g) || []).length - (text.match(/\)/g) || []).length;
    const bracketCount = (text.match(/\[/g) || []).length - (text.match(/\]/g) || []).length;

    if (braceCount !== 0) {
      issues.push(`Unbalanced braces ({ vs }): ${braceCount > 0 ? "missing }" : "missing {"}`);
    }
    if (parenCount !== 0) {
      issues.push(`Unbalanced parentheses (( vs )): ${parenCount > 0 ? "missing )" : "missing ("}`);
    }
    if (bracketCount !== 0) {
      issues.push(`Unbalanced brackets ([ vs ]): ${bracketCount > 0 ? "missing ]" : "missing ["}`);
    }

    const doubleQuotes = (text.match(/(?<!\\)"/g) || []).length;
    if (doubleQuotes % 2 !== 0) {
      issues.push("Unclosed double quote detected");
    }
    const singleQuotes = (text.match(/(?<!\\)'/g) || []).length;
    if (singleQuotes % 2 !== 0) {
      issues.push("Unclosed single quote detected");
    }

    const classNameMissing = lines.some(line => /^\s*class\s*(\{|$)/.test(line));
    if (classNameMissing) {
      issues.push("Class declaration missing a name");
    }

    return { issues, stats };
  },
  goToIssue(issue) {
    if (!Page.codeMirrorEditor6 || !issue || !Number.isFinite(issue.line)) return;
    this.ensureHighlightExtension();

    const view = Page.codeMirrorEditor6;
    const doc = view.state.doc;
    const lineNo = Math.max(1, Math.min(issue.line, doc.lines));
    const line = doc.line(lineNo);

    const effects = [];
    if (typeof cm6 !== "undefined" && cm6.EditorView && cm6.EditorView.scrollIntoView) {
      effects.push(cm6.EditorView.scrollIntoView(line.from, { y: "center" }));
    }
    if (this.highlightEffect) {
      effects.push(this.highlightEffect.of(line.from));
    }

    view.dispatch({
      selection: { anchor: line.from, head: line.to },
      effects
    });
    view.focus();
  },

  ensureHighlightExtension() {
    if (this.highlightEffect || !Page.codeMirrorEditor6 || typeof cm6 === "undefined") return;
    if (!cm6.StateEffect || !cm6.StateField || !cm6.Decoration || !cm6.EditorView) return;

    const highlightEffect = cm6.StateEffect.define({
      map: (value, mapping) => (value == null ? null : mapping.mapPos(value))
    });

    const highlightField = cm6.StateField.define({
      create() {
        return null;
      },
      update(value, tr) {
        for (const effect of tr.effects) {
          if (effect.is(highlightEffect)) {
            value = effect.value;
          }
        }
        if (value != null && tr.docChanged) {
          value = tr.changes.mapPos(value);
        }
        return value;
      },
      provide: f => cm6.EditorView.decorations.from(f, val => {
        if (val == null) return cm6.Decoration.none;
        return cm6.Decoration.set([
          cm6.Decoration.line({ class: "ai-fix-highlight-line" }).range(val)
        ]);
      })
    });

    Page.codeMirrorEditor6.dispatch({
      effects: cm6.StateEffect.appendConfig.of([highlightField])
    });

    this.highlightEffect = highlightEffect;
    this.highlightField = highlightField;

    if (!this.highlightHandler) {
      this.highlightHandler = (event) => {
        const view = Page.codeMirrorEditor6;
        if (!view || !this.highlightField || !this.highlightEffect) return;
        const current = view.state.field(this.highlightField, false);
        if (current == null) return;

        const pos = view.posAtCoords({ x: event.clientX, y: event.clientY });
        if (pos == null) return;

        const line = view.state.doc.lineAt(pos);
        if (line.from === current) {
          view.dispatch({ effects: this.highlightEffect.of(null) });
        }
      };
      Page.codeMirrorEditor6.dom.addEventListener("mousedown", this.highlightHandler);
    }
  },

  buildGuidancePrompt(issue, errorHtml) {
    const base = (typeof AiPrompting !== "undefined" && AiPrompting.getUmpleCheatSheet)
      ? AiPrompting.getUmpleCheatSheet()
      : "";

    const context = this.getIssueContext(issue);
    const issueLine = Number.isFinite(issue?.line) ? issue.line : "?";
    const issueSummary = [
      `- severity: ${issue?.severity || ""}`,
      `- line: ${issueLine}`,
      `- errorCode: ${issue?.errorCode || ""}`,
      `- message: ${issue?.message || ""}`
    ].join("\n");

    return [
      "## Task",
      "Provide a short, concise description of how to fix this Umple compiler issue.",
      "First check for simple typos (misspellings, missing punctuation, or incorrect identifiers).",
      "",
      "## Compiler issue",
      issueSummary,
      "",
      "## Local context (line numbers included)",
      context || "(no context available)",
      "",
      "## Umple quick reference",
      base,
      "",
      "## Output contract (follow strictly)",
      "- Output 1-2 short sentences, plain text only.",
      "- Do NOT output code or bullet points.",
      "- Do NOT mention that you are an AI model.",
      "- When referencing lines, use only: 'line N' or 'lines N-M' (N/M are numbers).",
      "- If it looks like a typo, mention the likely typo fix first.",
      "- Keep it actionable and specific to the error."
    ].join("\n");
  },

  getIssueContext(issue) {
    if (!Page.codeMirrorEditor6 || !issue || !Number.isFinite(issue.line)) return "";
    const doc = Page.codeMirrorEditor6.state.doc;
    const lineNo = Math.max(1, Math.min(issue.line, doc.lines));
    const lines = [];
    for (let i = 1; i <= doc.lines; i++) {
      const line = doc.line(i);
      lines.push(`${i}: ${line.text}`);
    }
    return lines.join("\n");
  },

  getSystemPrompt() {
    const base = (typeof AiPrompting !== "undefined" && AiPrompting.getBaseSystemPrompt)
      ? AiPrompting.getBaseSystemPrompt()
      : "You are an expert in Umple modeling language.";
    return [
      base,
      "",
      "Give concise, actionable fix guidance.",
      "Output format:",
      "1. Examine the overall REPL correctness (such as typos or similar errors)",
      "2. Scan the issue-related errors, where the issue represents the compiler output errors"
    ].join("\n");
  },

  cleanGuidanceText(text) {
    let output = String(text || "").trim();
    output = output.replace(/^[\-•*]\s+/g, "");
    output = output.replace(/```[\s\S]*?```/g, "").trim();
    output = output.replace(/\s+/g, " ");
    return output;
  },

  formatGuidanceHtml(text) {
    const safe = this.escapeHtml(text);
    return safe.replace(/\bline(s)?\s+(\d+)(\s*[-–]\s*(\d+))?/gi, (match, plural, start) => {
      return `<a href="javascript:Action.setCaretPosition(${start});Action.updateLineNumberDisplay();">${match}</a>`;
    });
  },

  escapeHtml(text) {
    return String(text || "")
      .replace(/&/g, "&amp;")
      .replace(/</g, "&lt;")
      .replace(/>/g, "&gt;")
      .replace(/"/g, "&quot;")
      .replace(/'/g, "&#39;");
  }
};

