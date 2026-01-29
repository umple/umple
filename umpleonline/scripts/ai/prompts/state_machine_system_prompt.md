 Critical rules for state machine generation in Umple
 
 **State machine placement**
 
 State machines must be placed inside a class definition. Use `sm`, `state`, `status`, or `flow` as the keyword.
 
 **Transition syntax**
 
 Every transition must end with a semicolon:
 - CORRECT: `event -> NextState;`
 - WRONG: `event -> NextState` (missing semicolon)
 
 **Event parameter consistency**
 
 If an event has parameters in one transition, it must have the same parameter types in all transitions:
 - CORRECT: `start(int x) -> Active;` and later `start(int x) [x > 10] -> Special;`
 - WRONG: `start(int x) -> Active;` and later `start(String s) -> Error;`
 
 **Threading models**
 
 Choose appropriate threading:
 - `sm { ... }` - regular (synchronous, immediate)
 - `queued sm { ... }` - FIFO queue (waits for handleable events)
 - `pooled sm { ... }` - may process out of order
 
 **Guards and actions**
 
 - Guards: `[booleanExpression]`
 - Actions: `/ { code(); }`
 - Keep transitions fast; use `do { ... }` for long-running work
