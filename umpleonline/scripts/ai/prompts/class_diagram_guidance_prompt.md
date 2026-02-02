Umple class diagrams (compressed, feature-complete)

Goal: model domain as classes + attributes + associations (valid Umple).

Classes
```umple
class Person {
  String name;
  Integer age;
}
```

* Class names typically start with a capital.
* Class body may include attributes, associations, methods, state machines, `isA` (inheritance), etc.

Attributes

```umple
class Student {
  String name;
  Integer number;
  Boolean enrolled = false;

  lazy Date birthDate;        // no ctor arg; default init (0/false/null)
  immutable String id;        // ctor arg; no setter
  const Integer MAX = 10;     // class constant (static final)
  unique String email;        // unique across instances
  autounique Integer uid;     // auto-assigned unique int (read-only)
  defaulted Integer level;    // resetLevel(), getDefaultLevel()
  internal String cache;      // no getter/setter
}
```

* Multi-valued:

```umple
String[] tags;
Integer[] scores = {1, 2, 3};
```

* `settable` is the default (ctor arg + setter).

Associations (relationships)
Basic forms:

* Inline (inside a class):

```umple
class Group { * -- * Item;  1 -> 0..1 Description; }
```

* Independent:

```umple
association { * Group -- * Item; }
```

Navigability

* `--` both ways, `->` left→right only, `<-` right→left only, `><` none.

```umple
class A { 1 -- * B;  1 -> * C; }
```

Multiplicity (both ends)

* `1` exactly one, `0..1` optional, `*` many, `1..*` mandatory many, `m..n` bounded.

```umple
class Student {
  * -- * Course;          // many-to-many
  1 -- 0..1 Advisor;      // one-to-optional
  0..1 -> * Publication;  // optional to many (directed)
}
```

Role names (use when it improves clarity / multiple links)

```umple
class GraduateStudent { * -- 0..2 Professor supervisor; }
```

Composition (strong ownership: deleting parent deletes children)

```umple
class Vehicle { 0..1 <@>- 2..4 Wheel wheels; }
```

* `<@>-` composition marker on parent side; `-<@>` on child side.

Reflexive (self-association)

```umple
class Employee { * -- 0..1 Employee manager; }
```

External types (declared as external)

```umple
class A { 1 -- 0..1 ExternalClass externalRef; }
external ExternalClass {}
```

Generalization (inheritance)

```umple
class Person { String name; }
class Student { isA Person; Integer number; }
class Employee { isA Person; String position; }
```

* Multiple inheritance:

```umple
class TeachingAssistant { isA Person, Student, Teacher; }
```

* Alternative nesting form:

```umple
class Person {
  String name;
  class Student { Integer number; }
}
```

Interfaces

```umple
interface Drawable { void draw(); }    // declarations only (no bodies)
class Shape {
  isA Drawable;
  void draw() { /* impl */ }
}
```

Minimal template

```umple
class Person { String name; immutable String id; }
class Course { String code; Integer credits; }

class Student {
  isA Person;
  Integer studentNumber;
  * -- * Course coursesTaken;
}

class Department { String name; 1 <@>- * Professor staff; }
class Professor  { String title; }
```

Troubleshooting

**Duplicate associations between same classes**

There can ONLY be ONE association between any two classes. Do NOT define the same relationship in both classes.

WRONG (duplicate association creates conflict):
```umple
class Interview {
  * -- 0..1 Application;  // defined in Interview
}

class Application {
  1 -- 1 Interview;  // CONFLICT: same relationship again!
}
```

CORRECT (define association ONCE only):
```umple
// Option 1: Define in either class
class Interview {
  * -- 0..1 Application;
}

class Application {
  // No association to Interview here (already defined above)
}

// Option 2: Use independent association statement
association { * Interview -- 0..1 Application; }

class Interview { }
class Application { }
```
