Umple state machines (compressed, feature-complete)

Placement
```umple
class C { sm { S1 { e -> S2; } S2 {} } }                 // inline
class A { st as M; }  statemachine M { S1{e->S2;} S2{} }  // standalone + reuse
```

Core

```umple
State { ... }          // state block
event -> Target;       // transition (semicolon required)
```

Guards, actions, entry/exit/do

* Guard: `[boolean]`
* Action: `/ { code }` (either side of `->`)

```umple
e [cond] / { act(); } -> S2;
e -> / { act(); } S2;
```

* Entry/exit:

```umple
S { entry / { onEnter(); }  exit / { onExit(); } }
```

* Do activity (long-running; interrupted on exit): `do { ... }`
* Rule: keep entry/exit/transition fast; long work in `do`.

Auto-transitions (eventless)

```umple
-> Next;
```

* Fires after entry, or after `do` completes; can include guards/actions.

Event parameters

```umple
S { e(int x) [x > 0] -> T; }
```

* Constraint: same event name ⇒ same parameter types everywhere.

`unspecified` (catch-all)

```umple
S { unspecified -> Error; }
```

* Catches unhandled events.
* In pooled machines, treated as a normal event.

Threading / ordering

* regular (default): synchronous.
* `queued sm { ... }`: enqueue events FIFO; waits until the head event is handleable.
* `pooled sm { ... }`: may process later events first if they’re handleable.

```umple
queued sm { ... }
pooled sm { ... }
```

Final states

* `Final` (capital): implicit top-level final target.

```umple
go -> Final;
```

* `final` keyword: named finals (multiple allowed).

```umple
final Done {}  final Failed {}
```

Concurrency (orthogonal regions)

* Use `||` inside a composite state; composite completes when all regions reach final.

```umple
S { A { ... final Af {} }  ||  B { ... final Bf {} } }
```

Reuse + extension (`as`)

```umple
class X { st as M; }               // reuse standalone machine
class X { st as M {                // extend inline
  cancel S1 -> S0;
  New { go -> S2; }
  S0 { entry / { reset(); } }
}; }
```

Composition / split definitions

* Can extend a machine across multiple class declarations; standalone transitions allowed.

```umple
class X { sm { A { e1 -> B; }  e2 B -> A; } }
class X { sm { e3 A -> B; } }
```

Minimal template

```umple
class Device {
  Boolean ok = true;

  queued sm {
    Idle {
      start(int x) [x > 0] / { init(x); } -> Active;
      unspecified -> Error;
    }
    Active {
      entry / { on(); }
      do { work(); }
      [!ok] -> Error;
      stop -> Final;
    }
    Error {
      entry / { recover(); }
      ready -> Idle;
    }
  }
}
```
