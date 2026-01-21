// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Requirements Self-Correction - Compiler-based self-correction loop

const RequirementsSelfCorrection = {
  getInsertionPos(docText) {
    const modelDelimiter = (typeof Page !== "undefined" && Page.modelDelimiter) ? Page.modelDelimiter : null;
    const modelEndIndex = modelDelimiter ? docText.indexOf(modelDelimiter) : -1;
    const insertBeforeIndex = modelEndIndex >= 0 ? modelEndIndex : docText.length;

    const modelText = docText.slice(0, insertBeforeIndex);
    const reqPattern = /req\s+(\w+(?:[-_]\w+)*)\s*\{[^}]*\}/gs;
    let lastReqEnd = -1;
    let match;

    while ((match = reqPattern.exec(modelText)) !== null) {
      lastReqEnd = match.index + match[0].length;
    }

    return lastReqEnd >= 0 ? lastReqEnd : insertBeforeIndex;
  },

  buildMergedCode(docText, blockCode) {
    const insertPos = this.getInsertionPos(docText);
    const codeText = String(blockCode || "").trim();
    const prefix = AiTextUtils.computePrefix(docText, insertPos);
    const suffix = AiTextUtils.computeSuffix(docText, insertPos);
    const insertText = prefix + codeText + suffix;
    const mergedText = docText.slice(0, insertPos) + insertText + docText.slice(insertPos);

    const highlightFrom = insertPos + prefix.length;
    const highlightTo = highlightFrom + codeText.length;

    return { insertPos, insertText, mergedText, highlightFrom, highlightTo, codeText };
  },

  async run({
    originalCode,
    generatedBlock,
    requirements,
    generationType,
    systemPrompt,
    dialog,
    statusDiv,
    expectedRequirementIds,
    onStreamDelta
  } = {}) {
    const maxPasses = AiCompilerService.getSelfCorrectionMaxPasses();
    let currentBlock = String(generatedBlock || "").trim();
    if (!currentBlock) return { block: currentBlock };

    let baseline = null;
    try {
      baseline = await AiCompilerService.compileUmpleWithServer(originalCode);
      if (baseline.issues.length > 0) {
        RequirementsDialog.appendRequirementsOutput("Baseline compile: the original model already has issues:");
        RequirementsDialog.appendRequirementsOutput(AiCompilerService.formatIssuesForLog(baseline.issues));
      } else {
        RequirementsDialog.appendRequirementsOutput("Baseline compile: no issues in original model.");
      }
    } catch (e) {
      RequirementsDialog.appendRequirementsOutput(`Baseline compile failed: ${e.message}`);
    }

    const seenBlocks = new Set();
    const initialBlock = String(currentBlock || "").trim();
    if (initialBlock) {
      seenBlocks.add(initialBlock);
    }
    let lastIssueSignature = null;
    let stagnantIssueCount = 0;

    if (typeof RequirementsPromptBuilder !== "undefined" && RequirementsPromptBuilder.preloadRepairGuidance) {
      try {
        await RequirementsPromptBuilder.preloadRepairGuidance(generationType);
      } catch (e) {
        RequirementsDialog.appendRequirementsOutput(`Repair guidance preload failed (continuing anyway): ${e.message}`);
      }
    }

    for (let pass = 1; pass <= maxPasses; pass++) {
      if (dialog?.stopped) {
        RequirementsDialog.appendRequirementsOutput(`\nSelf-correction stopped by user at pass ${pass}.`);
        break;
      }

      RequirementsDialog.setStatusMessage(statusDiv, "Compiler", `Self-correction pass ${pass}/${maxPasses}: compiling...`);
      RequirementsDialog.appendRequirementsOutput(`\nSelf-correction pass ${pass}: compiling merged model...`);

      const merged = this.buildMergedCode(originalCode, currentBlock);
      const insertedStartLine = AiTextUtils.computeLineNumberAtIndex(merged.mergedText, merged.highlightFrom);
      const insertedEndLine = AiTextUtils.computeLineNumberAtIndex(merged.mergedText, merged.highlightTo);
      const mergedText = merged.mergedText;

      let compiled;
      try {
        compiled = await AiCompilerService.compileUmpleWithServer(mergedText);
      } catch (e) {
        RequirementsDialog.appendRequirementsOutput(`Compile failed: ${e.message}`);
        break;
      }

      const issues = compiled.issues || [];

      if (typeof RequirementsPromptBuilder !== "undefined" && RequirementsPromptBuilder.getValidationAsCompilerErrors) {
        const validationErrors = RequirementsPromptBuilder.getValidationAsCompilerErrors({
          code: currentBlock,
          expectedRequirementIds: expectedRequirementIds || [],
          generationType
        });
        if (validationErrors.length > 0) {
          RequirementsDialog.appendRequirementsOutput(`Validation issues found: ${validationErrors.map(e => e.message).join(", ")}`);
          issues.unshift(...validationErrors);
        }
      }

      const errorIssues = issues.filter(issue => issue.severity === "Error");
      if (errorIssues.length === 0) {
        const warningCount = issues.filter(issue => issue.severity === "Warning").length;
        RequirementsDialog.appendRequirementsOutput(
          warningCount > 0
            ? `Compiler reports no errors (${warningCount} warning(s) ignored for self-correction).`
            : "Compiler reports no errors."
        );
        return { block: currentBlock };
      }

      const baselineIssues = baseline?.issues || [];
      const baselineIssueKeys = baselineIssues.length > 0
        ? new Set(baselineIssues.map(issue => AiCompilerService.getIssueKey(issue)))
        : new Set();

      const nonBaselineErrors = baselineIssueKeys.size > 0
        ? errorIssues.filter(issue => !baselineIssueKeys.has(AiCompilerService.getIssueKey(issue)))
        : errorIssues;

      if (baselineIssueKeys.size > 0) {
        RequirementsDialog.appendRequirementsOutput(`Baseline issues: ${baselineIssues.length}`);
      }

      if (baselineIssueKeys.size > 0 && nonBaselineErrors.length === 0) {
        RequirementsDialog.appendRequirementsOutput("Only baseline errors remain; stopping self-correction.");
        return { block: currentBlock };
      }

      const focusErrorIssues = nonBaselineErrors.length > 0 ? nonBaselineErrors : errorIssues;
      const inInsertedRange = focusErrorIssues.filter(i => Number.isFinite(i.line) && i.line >= insertedStartLine && i.line <= insertedEndLine);
      const focusIssues = inInsertedRange.length > 0 ? inInsertedRange : focusErrorIssues;

      const issueSignature = focusIssues.map(issue => AiCompilerService.getIssueKey(issue)).join("||");
      if (issueSignature && issueSignature === lastIssueSignature) {
        stagnantIssueCount += 1;
      } else {
        stagnantIssueCount = 0;
        lastIssueSignature = issueSignature;
      }

      if (stagnantIssueCount >= 3) {
        RequirementsDialog.appendRequirementsOutput("Compiler issues did not change after 3 repair attempts; stopping self-correction.");
        break;
      }

      const validationErrorCount = errorIssues.filter(i => i.errorCode === "VALIDATION_ERROR").length;
      const compilerErrorCount = errorIssues.length - validationErrorCount;
      const errorSummary = [];
      if (compilerErrorCount > 0) errorSummary.push(`${compilerErrorCount} compiler`);
      if (validationErrorCount > 0) errorSummary.push(`${validationErrorCount} validation`);
      RequirementsDialog.appendRequirementsOutput(`Found ${errorSummary.join(" + ")} error(s) in merged model.`);

      if (inInsertedRange.length > 0) {
        RequirementsDialog.appendRequirementsOutput(`Focusing on ${inInsertedRange.length} issue(s) within the inserted block (lines ${insertedStartLine}-${insertedEndLine}).`);
      } else {
        RequirementsDialog.appendRequirementsOutput("No issues were located within the inserted block line range; attempting to fix by adjusting the generated block anyway.");
      }
      RequirementsDialog.appendRequirementsOutput(AiCompilerService.formatIssuesForLog(focusIssues));

      const compilerIssuesText = focusIssues.map(issue => {
        const codeSuffix = issue.errorCode ? ` (${issue.errorCode})` : "";
        const lineText = Number.isFinite(issue.line) ? issue.line : "?";
        const blockLine = Number.isFinite(issue.line) && issue.line >= insertedStartLine && issue.line <= insertedEndLine
          ? issue.line - insertedStartLine + 1
          : null;
        const blockText = Number.isFinite(blockLine) ? ` (block line ${blockLine})` : "";
        let issueText = `- ${issue.severity}${codeSuffix} on merged line ${lineText}${blockText}: ${issue.message}`;

        if (Number.isFinite(issue.line) && mergedText) {
          const snippet = AiTextUtils.getLinesAround(mergedText, issue.line - 1, 2);
          if (snippet) {
            issueText += `\n  snippet:\n${snippet.split("\n").map(l => "  " + l).join("\n")}`;
          }
        }

        return issueText;
      }).join("\n");

      const repairResult = (typeof RequirementsPromptBuilder !== "undefined" && RequirementsPromptBuilder.repair_buildGeneration)
        ? RequirementsPromptBuilder.repair_buildGeneration({
          generationType,
          requirements,
          originalCode,
          invalidBlock: currentBlock,
          compilerIssuesText
        })
        : {
          prompt: `Fix the following Umple block so that it compiles with the original model without errors.\n\nOriginal model:\n\n\`\`\`umple\n${originalCode}\n\`\`\`\n\nBlock to fix:\n\n\`\`\`umple\n${currentBlock}\n\`\`\`\n\nCompiler issues:\n${compilerIssuesText}\n\nOutput ONLY the corrected block as a single \`\`\`umple\`\`\` code block.`,
          systemPrompt
        };

      RequirementsDialog.setStatusMessage(statusDiv, "LLM", `Repairing errors (compiler + validation) in block (pass ${pass}/${maxPasses})...`);
      RequirementsDialog.appendRequirementsOutput("Asking AI to repair the generated block...");

      let repairedResponse;
      try {
        const codeArea = document.getElementById("generatedCodeArea");
        let repairedText = "";
        if (codeArea) {
          codeArea.value = "";
          codeArea.placeholder = "Repairing generated block...";
        }

        const activeStream = AiApi.chatStream(repairResult.prompt, repairResult.systemPrompt, {}, {
          onDelta: (deltaText) => {
            repairedText += deltaText;
            if (codeArea) {
              codeArea.value = repairedText;
              codeArea.scrollTop = codeArea.scrollHeight;
            }
            if (onStreamDelta) onStreamDelta(deltaText);
          }
        });

        if (typeof AiRequirements !== "undefined") {
          AiRequirements.activeStream = activeStream;
        }

        repairedResponse = await activeStream.done;

        if (typeof AiRequirements !== "undefined") {
          AiRequirements.activeStream = null;
        }

        if (dialog?.stopped) {
          RequirementsDialog.appendRequirementsOutput("\nSelf-correction stopped by user.");
          break;
        }
      } catch (e) {
        RequirementsDialog.appendRequirementsOutput(`AI repair failed: ${e.message}`);
        break;
      }

      const repairedBlock = String(AiTextUtils.extractUmpleCode(repairedResponse) || "").trim();
      if (!repairedBlock) {
        RequirementsDialog.appendRequirementsOutput("AI repair produced empty output; stopping.");
        break;
      }

      if (repairedBlock.trim() === String(currentBlock || "").trim()) {
        RequirementsDialog.appendRequirementsOutput("AI repair repeated the current output; stopping.");
        break;
      }

      if (seenBlocks.has(repairedBlock)) {
        RequirementsDialog.appendRequirementsOutput("AI repair repeated an earlier output; stopping.");
        break;
      }

      currentBlock = repairedBlock;
      seenBlocks.add(repairedBlock);

      RequirementsDialog.appendRequirementsOutput("Retrying compile with repaired block...");
    }

    RequirementsDialog.appendRequirementsOutput("Self-correction stopped before reaching a clean compile.");
    return { block: currentBlock };
  }
};
