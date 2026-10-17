// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Constants

// Finish reason constants (OpenAI SDK uses string literals, not exported constants)
const FinishReason = {
  STOP: 'stop',
  LENGTH: 'length',
  TOOL_CALLS: 'tool_calls',
  CONTENT_FILTER: 'content_filter',
  FUNCTION_CALL: 'function_call'
};

const AiConstants = {
  FinishReason
};

window.AiConstants = AiConstants;
