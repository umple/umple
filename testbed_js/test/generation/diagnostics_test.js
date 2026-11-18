// What the compiler does with a model JavaScript cannot generate: it reports the reason, exits with
// a non-zero status, and leaves no file behind for the class it refused.

"use strict";

const assert = require("node:assert");
const { generate } = require("../umple.js");

function assertRejected(model, message, written)
{
  const result = generate(model);
  assert.notStrictEqual(result.status, 0, "the compiler must exit with a non-zero status:\n" + result.output);
  assert.ok(result.output.includes(message), "expected " + JSON.stringify(message) + " in:\n" + result.output);
  assert.deepStrictEqual(result.files, written, "the files written were " + result.files.join(", "));
}

module.exports = {
  "a state machine is reported and nothing is written": () =>
  {
    assertRejected("class Lamp {\n  status { On { off -> Off; } Off { on -> On; } }\n}\n",
      "State machines cannot be generated in JavaScript yet, so class Lamp was not generated", []);
  },

  "a class named with a reserved word is reported, and the other classes are still generated": () =>
  {
    assertRejected("class function { name; }\nclass Ok { name; }\n",
      "Class function has a name that JavaScript reserves or that generated code uses", ["Ok.js"]);
  },

  "extending an external class is reported and no module is left requiring a missing file": () =>
  {
    assertRejected("external Thread { void start() { } }\nclass Worker { isA Thread; name; }\n",
      "The external superclass Thread cannot be generated in JavaScript yet, so class Worker was not generated", []);
  },

  "a subclass of a class that is not generated is reported and left out as well": () =>
  {
    assertRejected("class Base {\n  0..1 -- * Base series;\n}\nclass Derived { isA Base; name; }\nclass Apart { name; }\n",
      "The superclass Base cannot be generated in JavaScript yet, so class Derived was not generated", ["Apart.js"]);
  },

  "two methods of one name are reported": () =>
  {
    assertRejected("class X {\n  void f() JavaScript { return; }\n  void f(String a) JavaScript { return; }\n}\n",
      "Overloads of method f cannot be generated in JavaScript yet, so class X was not generated", []);
  },

  "a derived attribute is reported": () =>
  {
    assertRejected("class Rect {\n  Integer side;\n  Integer area = { side * side }\n}\n",
      "The derived attribute area cannot be generated in JavaScript yet, so class Rect was not generated", []);
  },

  "a mandatory association end is reported": () =>
  {
    assertRejected("class A {\n  1 -- * B;\n}\nclass B {}\n",
      "cannot be generated in JavaScript yet, so class A was not generated", []);
  },

  "a model with no unsupported feature exits successfully": () =>
  {
    const result = generate("class A {\n  name;\n  0..1 -- * B;\n}\nclass B { label; }\n");
    assert.strictEqual(result.status, 0, result.output);
    assert.deepStrictEqual(result.files, ["A.js", "B.js"]);
  },

  "a method written only for another language is a warning, not an error": () =>
  {
    const result = generate("class X {\n  name;\n  String f() Java { return \"java\"; }\n}\n");
    assert.strictEqual(result.status, 0, result.output);
    assert.ok(result.output.includes("Method f has code only for Java, so it is left out of the generated JavaScript"),
      result.output);
    assert.deepStrictEqual(result.files, ["X.js"]);
  }
};
