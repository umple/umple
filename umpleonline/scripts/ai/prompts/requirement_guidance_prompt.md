# Umple Requirements (agent-oriented, minimal, correct)

## Semantics
- `req`: define a reusable requirement (ID + raw text).
- `implementsReq`: attach requirement IDs to model elements.
- Purpose: lightweight traceability (many-to-many).
- **Not** the same as `require` (mixset dependency).

---

## Grammar

### Define
```umple
req <ReqID> {
  <free-form text>
}
````

* `<ReqID>`: user-defined identifier.
* Body is raw text until `}`.

### Attach

```umple
implementsReq R01;
implementsReq R01, R02;
```

---

## Attachment scope

`implementsReq` applies to the **next element**.

Supported elements (non-exhaustive):

* class, interface, trait
* attribute
* association
* method
* state machine / state

### Canonical (prefix, unambiguous)

```umple
implementsReq R01;
class A {
  implementsReq R02;
  x;

  implementsReq R03;
  sm { s1 { e -> s2; } s2 {} }
}
```

### Inline (allowed, less explicit)

```umple
class B {
  y; implementsReq R01, R02;
}
```

---

## Multiple IDs

```umple
implementsReq R01, R02, R03;
```

---

## Requirements document generation

Generator: `PlainRequirementsDoc`

```umple
generate PlainRequirementsDoc;
```

### Options

```umple
suboption "reqSortID";      // sort by ID (default)
suboption "reqSortStat";    // sort by text
suboption "reqHideNotImpl"; // omit unattached reqs
```

---

## Recommended conventions

* Centralize all `req` blocks (e.g., `requirements.ump`).
* Stable IDs (e.g., `REQ-<DOMAIN>-<NNN>`).
* One requirement = one testable statement.
* Prefer prefix attachments.

---

## Minimal complete example

```umple
suboption "reqSortID";
generate PlainRequirementsDoc;

req REQ-AUTH-001 { Auth required before access. }
req REQ-AUTH-002 { Session expires after 30 min idle. }

implementsReq REQ-AUTH-001;
class UserService {

  implementsReq REQ-AUTH-002;
  Integer sessionTimeout = 30;

  implementsReq REQ-AUTH-001, REQ-AUTH-002;
  Boolean isSessionValid() { return true; }
}
```

```
