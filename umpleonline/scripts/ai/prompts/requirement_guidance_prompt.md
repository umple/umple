Umple requirements guidance (implementation tagging only)

Goal: Map existing requirement IDs to generated model elements using precise `implementsReq` usage.

Core syntax
- Requirement definition in existing model: `req ID { ... }`
- Requirement tagging: `implementsReq ID1, ID2;`
- `implementsReq` applies to the next model element.

Tagging rules
- Do not generate or repeat `req { ... }` blocks in generated output.
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

Minimal pattern
```umple
class BookingService {
  implementsReq REQ-101, REQ-205;
  sm { Idle { start -> Active; } Active {} }
}
```
