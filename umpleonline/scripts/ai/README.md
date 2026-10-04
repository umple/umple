# AI Features for Umple

This directory contains AI-powered features for Umple Online, including code generation from requirements, compiler error fixing, code explanation, and self-correction loops.

## Directory Structure

```
ai/
├── config/           # Configuration and validation
├── core/             # Core AI services (providers, chat context, compiler service)
├── features/         # Feature implementations
├── prompts/          # Prompt templates and guidance files
└── utils/            # Shared utilities (prompt building, text processing, streaming)
```

## Building Prompts
```javascript
block(title, content, { trimContent: true, allowEmpty: false })
```

- `title`: Block tag name (normalized to lowercase/snake_case)
- `content`: String or array of strings
- `trimContent`: Trim whitespace (default: true)
- `allowEmpty`: Include empty blocks (default: false)

Block syntax:
```
<tag_name>
Content here...
</tag_name>
```

## Prompt Structure

### System Prompt

The system prompt is static per feature and includes:

```
<system>
Base system instructions from AiPrompting.getBaseSystemPrompt()
</system>

<state_machine_critical_rules>
Loaded from prompts/state_machine_system_prompt.md
</state_machine_critical_rules>

<how_to_model_state_machines_in_umple>
Loaded from prompts/state_machine_guidance_prompt.md
</how_to_model_state_machines_in_umple>

<how_to_use_requirements_in_umple>
Loaded from prompts/requirement_guidance_prompt.md
</how_to_use_requirements_in_umple>

<requirements>
Formatted requirement text
</requirements>

<umple_quick_reference>
Quick syntax reference from AiPrompting.getUmpleCheatSheet()
</umple_quick_reference>
```

### Guidance Injection

Guidance is loaded from markdown files in `prompts/` and injected based on generation type:

| Generation Type | System Guidance | Feature Guidance |
|----------------|-----------------|------------------|
| `statemachine` | `state_machine_system_prompt.md` | `state_machine_guidance_prompt.md` |
| `classdiagram` | `class_diagram_system_prompt.md` | `class_diagram_guidance_prompt.md` |

### User Prompt

The user prompt is dynamic and task-specific:

**Initial Generation:**
```
<task>
(Task to generate)
</task>

<output_contract>
- Output ONLY Umple code.
- Output EXACTLY ONE fenced code block with language "umple".
- Include implementsReq for: REQ-001, REQ-002.
- Include at least one class with a state machine.
- Do NOT re-output any req { ... } blocks.
</output_contract>
```

**Repair (Self-Correction):**
```
<task>
(Task to repair)
</task>

<compiler_issues_errors_warnings>
Errors with code snippets...
</compiler_issues_errors_warnings>

<output_contract>
Same constraints as initial generation.
</output_contract>
```

## Context Building

Multi-turn conversations use `AiChatContext`:

```javascript
// Create context with system prompt
const context = AiChatContext.create(systemPrompt);

// Add user message
AiChatContext.addUser(context, generationPrompt);

// Add assistant response
AiChatContext.addAssistant(context, aiResponse);

// Convert to provider messages
const messages = AiChatContext.contextToMessages(context);
// [{role: "system", content: "..."}, {role: "user", content: "..."}, ...]
```

## Prompt Prefix Reuse and Caching

Explain and Requirements Generate both use an append-only `AiChatContext` to keep request prefixes stable across turns.

- Explain flow: first user turn is raw Umple code; follow-ups append only the new question and assistant answer.
- Generate flow: initial generation and each self-correction pass run in the same context; repair prompts append only compiler/validation deltas, while original guidance and requirements remain in the stable prefix.

Why this matters:

- Many providers/models can cache repeated prompt prefixes and reduce billed input tokens on later turns.
- Cache behavior is provider/model specific (and may depend on TTL/minimum-prefix rules), so cache savings are opportunistic rather than guaranteed.

## Provider Interface

All features use a unified provider interface:

```javascript
const stream = AiApi.chatStream(context, { maxTokens: 800 }, {
  onDelta: chunk => {
    // Streamed text chunk
  }
});
const fullText = await stream.done;
```

Supported providers: OpenAI, Google Gemini, OpenRouter.
