Umple state machine guidance (agent-focused)

Goal: Generate concise, valid Umple state machines that compile on first pass.

Hard syntax constraints
- Place machines inside classes (`sm`, `state`, `status`, or `flow`) unless intentionally reusable via `statemachine Name { ... }` + `x as Name;`.
- Every transition ends with `;`.
- Transition form: `event(args) [guard] / { action } -> Target;`
- Auto-transition form: `-> Target;`
- State actions: `entry / { ... }`, `exit / { ... }`, `do { ... }`
- Same event name in one machine must use the same parameter signature everywhere.
- Target must be an existing state, `Final`, or `State.H` / `State.HStar`.
- Do not define a user state named `Final`; use `final Done {}` for named final states.

Semantic guidance
- `sm`: synchronous/default.
- `queued sm`: FIFO queue; head event waits until handleable.
- `pooled sm`: may process later handleable events before earlier unhandleable ones.
- `unspecified -> Error;` catches otherwise-unhandled events in regular/queued machines; in pooled machines it behaves like a normal event.
- Regions use `||`; a composite completes when each region reaches a final state.
- Use nesting to avoid repeating shared transitions.
- Use history for interrupted composite behavior: `.H` (shallow), `.HStar` (deep).

Modeling checklist
1. Start with explicit lifecycle states and distinct names.
2. Ensure each non-final state has meaningful outgoing behavior.
3. Avoid duplicate unguarded same-event transitions from the same state.
4. Use mutually exclusive guards when one event branches.
5. Keep transition/entry/exit actions short; place long-running work in `do`.
6. Add at least one recovery path for unexpected events.
7. If assumptions are needed, add one inline comment: `// Assumption: ...`.

Minimal pattern
```umple
class Device {
  queued sm {
    Idle { start(int x) [x > 0] -> Active; unspecified -> Error; }
    Active { stop -> Final; }
    Error { reset -> Idle; }
  }
}
```
