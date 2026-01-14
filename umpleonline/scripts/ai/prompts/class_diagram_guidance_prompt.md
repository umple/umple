# Umple Class Diagrams (agent-oriented, minimal, correct)

## Goal
Model a domain as **classes + attributes + associations** using valid Umple.

---

## Classes

Define a class with `class` keyword followed by a name (start with capital letter) and a body in braces.

```umple
class Person {
  String name;
  Integer age;
}
```

Classes can contain: attributes, associations, methods, state machines, interfaces, generalizations (via `isA`), and more.

---

## Attributes

Attributes represent simple data stored in a class.

```umple
class Student {
  String name;
  Integer number;
  Boolean enrolled = false;
  lazy Date birthDate;
  immutable String id;
}
```

**Modifiers** (choose as needed):
- **lazy**: No constructor argument; initialized to default (0, false, null).
- **settable**: Constructor argument required; mutable via set method (default).
- **immutable**: Constructor argument required; no set method generated.
- **const**: Class constant (`static final` in Java).
- **unique**: Value must be unique across instances.
- **autounique**: Auto-assigned unique integer; read-only.
- **defaulted**: Reset to default via `resetX()`; query default via `getDefaultX()`.
- **internal**: No getter/setter; for internal use only.

**Multi-valued**:
```umple
String[] tags;
Integer[] scores = {1, 2, 3};
```

---

## Associations (relationships)

Associations define links between classes. Specify multiplicity on both ends.

### Basic syntax

**Inline** (inside a class):
```umple
class Group {
  * -- * Item;
  1 -> 0..1 Description;
}
```

**Independent** (outside classes):
```umple
association {
  * Group -- * Item;
}
```

### Navigability

- `--` : Bidirectional (both ends can access each other)
- `->` : Directed (left can access right, right cannot access left)
- `<-` : Directed (right can access left, left cannot access right)
- `><` : No navigation (both ends cannot access each other)

```umple
class A {
  1 -- * B;  // both ways
  1 -> * C;  // A can access C, C cannot access A
}
```

### Multiplicity

Indicates allowable number of linked objects.

| Multiplicity | Meaning |
|--------------|----------|
| `1` | Exactly one (mandatory) |
| `0..1` | Optional (zero or one) |
| `*` | Many (0 or more) |
| `1..*` | One or more (mandatory many) |
| `m..n` | Between m and n (inclusive) |

```umple
class Student {
  * -- * Course;           // many-to-many
  1 -- 0..1 Advisor;       // one-to-optional
  0..1 -> * Publication;   // zero-or-one to many
}
```

### Role names

Clarify relationships, especially when classes associate in multiple ways.

```umple
class GraduateStudent {
  * -- 0..2 Professor supervisor;
}
```

### Composition

Strong ownership: deleting parent deletes children regardless of multiplicity.

```umple
class Vehicle {
  0..1 <@>- 2..4 Wheel wheels;
}
```

- `<@>-` : Parent composed with children (parent side)
- `-<@>` : Children composed with parent (child side)

### Reflexive

Association from a class to itself.

```umple
class Employee {
  * -- 0..1 Employee manager;
}
```

### External

Link to classes defined elsewhere (non-Umple code).

```umple
class A {
  1 -- 0..1 ExternalClass externalRef;
}

external ExternalClass {}
```

---

## Generalization (inheritance)

Use `isA` for subclass relationships.

```umple
class Person {
  name;
}

class Student {
  isA Person;
  Integer number;
}

class Employee {
  isA Person;
  String position;
}
```

**Alternative syntax** (nesting):
```umple
class Person {
  name;

  class Student {
    Integer number;
  }
}
```

Multiple inheritance:
```umple
class TeachingAssistant {
  isA Person, Student, Teacher;
}
```

---

## Interfaces

Define abstract method contracts. Classes implement via `isA`.

```umple
interface Drawable {
  void draw();
}

class Shape {
  isA Drawable;
  void draw() {
    // implementation
  }
}
```

Interfaces can only contain: dependencies, method declarations (no body), `isA` clauses.

---

## Minimal feature-complete template

```umple
// Classes with attributes
class Person {
  String name;
  immutable String id;
}

class Course {
  String code;
  Integer credits;
}

// Association with multiplicities and role name
class Student {
  isA Person;
  Integer studentNumber;
  * -- * Course coursesTaken;
}

// Composition: Department owns Professors
class Department {
  String name;
  1 <@>- * Professor staff;
}

class Professor {
  String title;
}
```
