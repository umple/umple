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
    expectedRequirementIds,
    log = null,
    setStatus = null,
    shouldStop = null,
    setActiveStream = null,
    onRepairTextReset = null,
    onRepairTextUpdate = null,
    onStreamDelta
  } = {}) {
    const safeLog = typeof log === "function" ? log : () => {};
    const safeSetStatus = typeof setStatus === "function" ? setStatus : () => {};
    const safeShouldStop = typeof shouldStop === "function" ? shouldStop : () => false;
    const safeSetActiveStream = typeof setActiveStream === "function" ? setActiveStream : () => {};
    const safeRepairReset = typeof onRepairTextReset === "function" ? onRepairTextReset : () => {};
    const safeRepairUpdate = typeof onRepairTextUpdate === "function" ? onRepairTextUpdate : () => {};

    const maxPasses = AiCompilerService.getSelfCorrectionMaxPasses();
    let currentBlock = String(generatedBlock || "").trim();
    if (!currentBlock) return { block: currentBlock };

    let baseline = null;
    try {
      baseline = await AiCompilerService.compileUmpleWithServer(originalCode);
      if (baseline.issues.length > 0) {
        safeLog("Baseline compile: the original model already has issues:");
        safeLog(AiCompilerService.formatIssuesForLog(baseline.issues));
      } else {
        safeLog("Baseline compile: no issues in original model.");
      }
    } catch (e) {
      safeLog(`Baseline compile failed: ${e.message}`);
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
        safeLog(`Repair guidance preload failed (continuing anyway): ${e.message}`);
      }
    }

    for (let pass = 1; pass <= maxPasses; pass++) {
      if (safeShouldStop()) {
        safeLog(`\nSelf-correction stopped by user at pass ${pass}.`);
        break;
      }

      safeSetStatus("Compiler", `Self-correction pass ${pass}/${maxPasses}: compiling...`);
      safeLog(`\nSelf-correction pass ${pass}: compiling merged model...`);

      const merged = this.buildMergedCode(originalCode, currentBlock);
      const insertedStartLine = AiTextUtils.computeLineNumberAtIndex(merged.mergedText, merged.highlightFrom);
      const insertedEndLine = AiTextUtils.computeLineNumberAtIndex(merged.mergedText, merged.highlightTo);
      const mergedText = merged.mergedText;

      let compiled;
      try {
        compiled = await AiCompilerService.compileUmpleWithServer(mergedText);
      } catch (e) {
        safeLog(`Compile failed: ${e.message}`);
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
          safeLog(`Validation issues found: ${validationErrors.map(e => e.message).join(", ")}`);
          issues.unshift(...validationErrors);
        }
      }

      const errorIssues = issues.filter(issue => issue.severity === "Error");
      if (errorIssues.length === 0) {
        const warningCount = issues.filter(issue => issue.severity === "Warning").length;
        safeLog(
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
        safeLog(`Baseline issues: ${baselineIssues.length}`);
      }

      if (baselineIssueKeys.size > 0 && nonBaselineErrors.length === 0) {
        safeLog("Only baseline errors remain; stopping self-correction.");
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
        safeLog("Compiler issues did not change after 3 repair attempts; stopping self-correction.");
        break;
      }

      const validationErrorCount = errorIssues.filter(i => i.errorCode === "VALIDATION_ERROR").length;
      const compilerErrorCount = errorIssues.length - validationErrorCount;
      const errorSummary = [];
      if (compilerErrorCount > 0) errorSummary.push(`${compilerErrorCount} compiler`);
      if (validationErrorCount > 0) errorSummary.push(`${validationErrorCount} validation`);
      safeLog(`Found ${errorSummary.join(" + ")} error(s) in merged model.`);

      if (inInsertedRange.length > 0) {
        safeLog(`Focusing on ${inInsertedRange.length} issue(s) within the inserted block (lines ${insertedStartLine}-${insertedEndLine}).`);
      } else {
        safeLog("No issues were located within the inserted block line range; attempting to fix by adjusting the generated block anyway.");
      }
      safeLog(AiCompilerService.formatIssuesForLog(focusIssues));

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

      safeSetStatus("LLM", `Repairing errors (compiler + validation) in block (pass ${pass}/${maxPasses})...`);
      safeLog("Asking AI to repair the generated block...");

      let repairedResponse;
      try {
        safeRepairReset("Repairing generated block...");
        const streamRenderer = AiStreamUtils.createBufferedTextRenderer({
          updateIntervalMs: 40,
          onRender: text => {
            safeRepairUpdate(text);
          }
        });

        const activeStream = AiApi.chatStream(repairResult.prompt, repairResult.systemPrompt, {}, {
          onDelta: (deltaText) => {
            streamRenderer.append(deltaText);
            if (onStreamDelta) onStreamDelta(deltaText);
          }
        });

        safeSetActiveStream(activeStream);

        repairedResponse = await activeStream.done;
        streamRenderer.flush({ force: true });
        safeSetActiveStream(null);

        if (safeShouldStop()) {
          safeLog("\nSelf-correction stopped by user.");
          break;
        }
      } catch (e) {
        safeSetActiveStream(null);
        if (e?.name === "AbortError" || safeShouldStop()) {
          safeLog("\nSelf-correction stopped by user.");
          break;
        }
        safeLog(`AI repair failed: ${e.message}`);
        break;
      }

      const repairedBlock = String(AiTextUtils.extractUmpleCode(repairedResponse) || "").trim();
      if (!repairedBlock) {
        safeLog("AI repair produced empty output; stopping.");
        break;
      }

      if (repairedBlock.trim() === String(currentBlock || "").trim()) {
        safeLog("AI repair repeated the current output; stopping.");
        break;
      }

      if (seenBlocks.has(repairedBlock)) {
        safeLog("AI repair repeated an earlier output; stopping.");
        break;
      }

      currentBlock = repairedBlock;
      seenBlocks.add(repairedBlock);

      safeLog("Retrying compile with repaired block...");
    }

    safeLog("Self-correction stopped before reaching a clean compile.");
    return { block: currentBlock };
  }
};
