Class diagram generation: critical enforcement rules

- Output compilable Umple structural code only.
- Use valid class and association syntax with multiplicity on both ends.
- Define each intended relationship once (either inline in one class or in an `association { ... }` block).
- If multiple associations exist between the same class pair, use distinct role names.
- Avoid role names identical to the class name; use meaningful role names or omit them.
- Keep associated types defined; if external, declare with `external Type {}`.
- For interface associations, use one-way class-to-interface navigation (`->`).
- Keep the model minimal and requirement-driven; avoid speculative entities/associations.
