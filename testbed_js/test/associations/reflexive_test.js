// A reflexive optional one to many

"use strict";

const assert = require("node:assert");
const { load } = require("../umple.js");

const Employee = load("Employee");

module.exports = {
  "both ends of a reflexive association start empty": () =>
  {
    const employee = new Employee("e");
    assert.deepStrictEqual(employee.getSubordinates(), []);
    assert.strictEqual(employee.getEmployee(), null);
  },

  "adding a subordinate sets its manager": () =>
  {
    const manager = new Employee("m");
    const worker = new Employee("w");
    assert.strictEqual(manager.addSubordinate(worker), true);
    assert.strictEqual(manager.numberOfSubordinates(), 1);
    assert.strictEqual(worker.getEmployee(), manager);
  },

  "a subordinate moves between managers": () =>
  {
    const first = new Employee("m1");
    const second = new Employee("m2");
    const worker = new Employee("w");
    first.addSubordinate(worker);
    second.addSubordinate(worker);
    assert.strictEqual(first.numberOfSubordinates(), 0);
    assert.strictEqual(second.numberOfSubordinates(), 1);
    assert.strictEqual(worker.getEmployee(), second);
  },

  "deleting a manager releases its subordinates": () =>
  {
    const manager = new Employee("m");
    const worker = new Employee("w");
    manager.addSubordinate(worker);
    manager.delete();
    assert.strictEqual(worker.getEmployee(), null);
  }
};
