// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Stream Utils - Shared helpers for streaming UI updates and safe abort handling

const AiStreamUtils = (() => {
  "use strict";

  function abort(handle) {
    try {
      handle?.abort?.();
      return true;
    } catch (e) {
      return false;
    }
  }

  /**
   * Create a buffered renderer for streaming text.
   * - Accumulates streamed chunks into a single buffer.
   * - Calls `onRender(buffer)` at most once per `updateIntervalMs`.
   */
  function createBufferedTextRenderer({
    onRender,
    onFirstChunk = null,
    updateIntervalMs = 120
  } = {}) {
    let buffer = "";
    let updateTimer = null;
    let hasReceivedFirstChunk = false;

    const renderNow = () => {
      if (typeof onRender !== "function") return;
      onRender(buffer);
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
          if (typeof onFirstChunk === "function") onFirstChunk();
        }
        buffer += String(chunk ?? "");
        scheduleUpdate();
      },
      setText(text) {
        buffer = String(text ?? "");
        scheduleUpdate();
      },
      getText() {
        return buffer;
      },
      hasContent() {
        return !!String(buffer || "").trim();
      },
      flush({ force = false } = {}) {
        if (updateTimer) {
          clearTimeout(updateTimer);
          updateTimer = null;
        }
        if (force || String(buffer || "").trim()) {
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
  }

  return {
    abort,
    createBufferedTextRenderer
  };
})();

