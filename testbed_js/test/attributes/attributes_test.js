// Attributes: the generated constructor, getters, setters, lazy, defaulted and immutable attributes

"use strict";

const assert = require("node:assert");
const { load } = require("../umple.js");

const Student = load("Student");
const Account = load("Account");
const Keywords = load("Keywords");

module.exports = {
  "the constructor takes every attribute that has no value": () =>
  {
    const student = new Student("Ada", 19, 3.9, true);
    assert.strictEqual(student.getName(), "Ada");
    assert.strictEqual(student.getAge(), 19);
    assert.strictEqual(student.getGpa(), 3.9);
    assert.strictEqual(student.getEnrolled(), true);
  },

  "a boolean attribute also has an is method": () =>
  {
    assert.strictEqual(new Student("Ada", 19, 3.9, true).isEnrolled(), true);
    assert.strictEqual(new Student("Bo", 20, 2.0, false).isEnrolled(), false);
  },

  "a setter reports that it set the attribute": () =>
  {
    const student = new Student("Ada", 19, 3.9, true);
    assert.strictEqual(student.setName("Grace"), true);
    assert.strictEqual(student.getName(), "Grace");
    assert.strictEqual(student.setAge(21), true);
    assert.strictEqual(student.getAge(), 21);
  },

  "an attribute with a value is not a constructor parameter": () =>
  {
    const account = new Account("A-1");
    assert.strictEqual(account.getBalance(), 100);
    assert.strictEqual(account.getRate(), -1.5);
    assert.strictEqual(account.getClosed(), false);
    assert.strictEqual(account.getLabel(), "none");
    assert.strictEqual(account.getMissing(), null);
  },

  "an immutable attribute has no setter": () =>
  {
    const account = new Account("A-1");
    assert.strictEqual(account.getId(), "A-1");
    assert.strictEqual(typeof account.setId, "undefined");
  },

  "a lazy attribute starts null and can be set": () =>
  {
    const account = new Account("A-1");
    assert.strictEqual(account.getNickname(), null);
    assert.strictEqual(account.setNickname("savings"), true);
    assert.strictEqual(account.getNickname(), "savings");
  },

  "a defaulted attribute can be reset to its default": () =>
  {
    const account = new Account("A-1");
    assert.strictEqual(account.getStatus(), "active");
    assert.strictEqual(account.getDefaultStatus(), "active");
    assert.strictEqual(account.setStatus("frozen"), true);
    assert.strictEqual(account.getStatus(), "frozen");
    assert.strictEqual(account.resetStatus(), true);
    assert.strictEqual(account.getStatus(), "active");
  },

  "a name JavaScript reserves is fine for an attribute or a role": () =>
  {
    const one = new Keywords("c", 1, true);
    const other = new Keywords("d", 2, false);
    assert.strictEqual(one.getClass(), "c");
    assert.strictEqual(one.getVar(), 1);
    assert.strictEqual(one.isStatic(), true);
    assert.strictEqual(one.addFunction(other), true);
    assert.strictEqual(one.numberOfFunctions(), 1);
    assert.strictEqual(other.getKeywords(), one);
  }
};
