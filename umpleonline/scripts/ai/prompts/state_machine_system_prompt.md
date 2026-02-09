State machine generation: critical enforcement rules

- Output compilable Umple state machine code only.
- Place each machine inside a class using `sm`, `state`, `status`, or `flow` (or explicitly reuse a standalone machine via `as`).
- End every transition with `;`.
- Use valid transition shape: `event(args) [guard] / { action } -> Target;` or `-> Target;`.
- Keep event signatures consistent: same event name => same parameter signature across that machine.
- Keep all targets valid (`existingState`, `Final`, `State.H`, `State.HStar`).
- Prefer explicit error handling for unexpected events (for example `unspecified -> Error;` where appropriate).
- Use `queued sm` or `pooled sm` only when ordering semantics are required; otherwise prefer regular `sm`.
- Keep transition/entry/exit actions short; move long-running work to `do`.
