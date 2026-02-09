Umple class diagram guidance (agent-focused)

Goal: Generate minimal, valid class-structure Umple (classes, attributes, associations, inheritance/interfaces).

Core syntax
- Class: `class Name { ... }` (capitalized names).
- Attribute: `Type name;` with optional initializer `Type name = value;`.
- Inheritance / interface / trait inclusion: `isA Super, InterfaceOrTrait;`.
- Interfaces contain method declarations only (no bodies).
- Inline association: `class A { 1 -- * B roleName; }`
- Independent association: `association { 1 A -> * B; }`
- Multiplicity is required at both ends: `1`, `0..1`, `*`, `1..*`, `m..n`.
- Navigability markers: `--`, `->`, `<-`, `><`.
- Composition markers: `<@>-` or `-<@>`.

High-impact constraints
- Define each intended relationship once (inline in one class OR in an `association` block).
- If multiple associations exist between the same class pair, use distinct role names to disambiguate; avoid duplicate unnamed links (E019).
- Avoid role names that match class names (W089); use meaningful role names or omit them.
- An association to an interface must be one-way from class to interface (`->`).
- Every associated type must exist; if external, declare it as `external Type {}`.
- Keep identifiers collision-free and meaningful.

Modeling checklist
1. Extract stable entities from requirements.
2. Add only essential attributes first (identity + core properties).
3. Add associations only when runtime links are implied.
4. Choose conservative multiplicities unless requirements are explicit.
5. Use composition only for true ownership/lifecycle dependency.
6. Keep first draft compilable and refine incrementally.

Minimal pattern
```umple
class Student { String name; Integer number; * -- * Course courses; }
class Course { String code; }
class Transcript { 1 -> 1 Student owner; }
```
