Umple requirements guidance (implementation tagging only)

Goal: Map existing requirement IDs to generated model elements using precise `implementsReq` usage.

Core syntax
- Requirement definition in existing model: `req ID { ... }`
- Requirement tagging: `implementsReq ID1, ID2;`
- `implementsReq` applies to the next model element.

Requirement types
- A requirement may name its type after the ID: `req US1 userStory { ... }`. Without a type, the body is free text.
- `userStory`: `who` is the role (often a class), `what` the capability (an operation, attribute or event), `when` a condition (a guard or a state), `why` the reason (not modelled).
- `useCase`: `who` is the actor; each `userStep` is an actor action (usually an event) and each `systemResponse` what the system then does (an action or a change of state); steps happen in the order written; `[condition]` on a step is a guard; `include` reuses another use case's steps and `isA` specializes another use case.
- `ears`: `while` is a precondition (usually a state), `when` a trigger (an event), `if` an unwanted trigger (an event leading to error handling), `where` an optional feature (a mixset), `system` the responding class, and `shall` the response (a transition or an action).

Tagging rules
- Do not generate or repeat `req { ... }` blocks in generated output.
- Never treat commented-out requirements (`// req ...` or `/* req ... */`) as active; only implement IDs provided for generation.
- Place `implementsReq` immediately before the element it tags (preferred and unambiguous).
- Common targets: class, interface, trait, attribute, association, method, and entire state machine block.
- For state-machine generation, tag the class or machine block, not individual states.
- Reuse requirement IDs exactly as provided; do not rename or invent IDs.
- If one requirement is implemented in multiple generated elements, repeat `implementsReq` on each relevant element.
- Do not repeat the same full `implementsReq` list.
- If multiple requirements apply to one element, combine them: `implementsReq R1, R2;`.

Optional requirements-doc directives (only when explicitly requested)
- `generate PlainRequirementsDoc;`
- `suboption "reqSortID";` (default sort)
- `suboption "reqSortStat";` (sort by statement text)
- `suboption "reqHideNotImpl";` (hide unimplemented requirements)
- `suboption "reqQC";` (emit a side-by-side comparison table of every quality requirement across every quality-tagged mixset)

Minimal pattern
```umple
class BookingService {
  implementsReq REQ-101, REQ-205;
  sm { Idle { start -> Active; } Active {} }
}
```
