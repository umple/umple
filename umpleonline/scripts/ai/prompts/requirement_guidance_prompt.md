````markdown
Umple requirements (implementation-only, compressed)

Attach requirement IDs with `implementsReq`; it applies to the *next element*.

Attach (single or multiple)
```umple
implementsReq R01;
implementsReq R01, R02, R03;
````

Where you can attach (common)

* class / interface / trait
* attribute
* association
* method
* state machine (not individual states)

Preferred usage (prefix; unambiguous)

```umple
implementsReq R01;
class A {
  implementsReq R02;
  String x;

  implementsReq R03;
  sm { s1 { e -> s2; } s2 {} }
}
```

Inline (allowed; less explicit)

```umple
class B { String y; implementsReq R01, R02; }
```

Requirements doc generation

```umple
generate PlainRequirementsDoc;
suboption "reqSortID";       // default
suboption "reqSortStat";     // sort by text
suboption "reqHideNotImpl";  // omit unattached reqs
```

Recommended conventions (for agents)

* Use stable IDs (e.g., `REQ-<DOMAIN>-<NNN>`).
* One attachment block per element; prefer prefix form.
* Keep IDs consistent across files.

Minimal example

```umple
suboption "reqSortID";
generate PlainRequirementsDoc;

implementsReq REQ-AUTH-001;
class UserService {
  implementsReq REQ-AUTH-002;
  Integer sessionTimeout = 30;

  implementsReq REQ-AUTH-001, REQ-AUTH-002;
  Boolean isSessionValid() { return true; }
}
```
