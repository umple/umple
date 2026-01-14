# Umple State Machines (agent-oriented, minimal, correct)

## Placement
- **Inline** inside class:
```umple
class C {
  sm { S1 { e -> S2; } S2 {} }
}
````

* **Standalone + reuse**:

```umple
class A { st as M; }
statemachine M { S1 { e -> S2; } S2 {} }
```

---

## Core grammar

* **State**

```umple
State { ... }
```

* **Transition**

```umple
event -> Target;
```

---

## Guards & actions

* **Guard**: `[boolean]`
* **Action**: `/ { code }` (before or after arrow)

```umple
e [cond] / { act(); } -> S2;
e -> / { act(); } S2;
```

* **Entry / Exit**

```umple
S {
  entry / { onEnter(); }
  exit  / { onExit(); }
}
```

* **Do activity** (long-running, interruptible on exit)

```umple
S { do { work(); } }
```

Rule: keep entry/exit/transition fast; long work in `do`.

---

## Auto-transitions (eventless)

```umple
-> Next;
```

* Fires after entry, or after `do` completes.
* May include guards/actions.

---

## Event parameters

```umple
S { e(int x) [x > 0] -> T; }
```

Constraint: same event name ⇒ same parameter types everywhere.

---

## `unspecified` (catch-all)

```umple
S {
  unspecified -> Error;
}
```

* Catches unhandled events.
* In **pooled** machines, treated as a normal event.

---

## Threading / ordering

* **regular** (default): synchronous.
* **queued sm**:

  * enqueue events, FIFO, wait until head is handleable.
* **pooled sm**:

  * may process later events first if handleable.

```umple
queued sm { ... }
pooled sm { ... }
```

---

## Final states

* **`Final`** (capital): implicit top-level final.

```umple
go -> Final;
```

* **`final`** keyword: named finals (multiple allowed).

```umple
final Done {}
final Failed {}
```

---

## Concurrency (orthogonal regions)

* Use `||` inside composite state.
* Region completes when **all** sub-machines reach final.

```umple
S {
  A { ... final Af {} }
  ||
  B { ... final Bf {} }
}
```

---

## Reuse + extension (`as`)

* Use standalone machine:

```umple
class X { st as M; }
```

* Extend inline:

```umple
class X {
  st as M {
    cancel S1 -> S0;
    New { go -> S2; }
    S0 { entry / { reset(); } }
  };
}
```

---

## Composition / split definitions

* State machines can be extended across class declarations.
* Standalone transitions allowed.

```umple
class X {
  sm {
    A { e1 -> B; }
    e2 B -> A;
  }
}
class X {
  sm {
    e3 A -> B;
  }
}
```

---

## Minimal feature-complete template

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

```
