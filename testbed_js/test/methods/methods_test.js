// Methods written in the model: generated getters, parameters, static methods, and a method that
// uses another generated class

"use strict";

const assert = require("node:assert");
const { load } = require("../umple.js");

const Order = load("Order");
const Line = load("Line");

module.exports = {
  "a method reads an attribute through its generated getter": () =>
  {
    assert.strictEqual(new Order("A-1").label(), "order A-1");
  },

  "a method takes parameters and uses the generated association API": () =>
  {
    const order = new Order("A-1");
    assert.strictEqual(order.addItem("pencil", 3), true);
    assert.strictEqual(order.numberOfLines(), 1);
    assert.strictEqual(order.getLine(0).getName(), "pencil");
    assert.strictEqual(order.getLine(0).getQuantity(), 3);
  },

  "a method walks the objects of a many end": () =>
  {
    const order = new Order("A-1");
    order.addItem("pencil", 3);
    order.addItem("eraser", 2);
    assert.strictEqual(order.total(), 5);
  },

  "a static method is generated as a static method": () =>
  {
    assert.strictEqual(Order.currency(), "CAD");
    assert.strictEqual(typeof new Order("A-1").currency, "undefined");
  },

  "a method of another class reaches back over the association": () =>
  {
    const order = new Order("A-1");
    order.addItem("pencil", 3);
    assert.strictEqual(order.getLine(0).owner(), "A-1");
    assert.strictEqual(new Line("loose", 1).owner(), "none");
  },

  "a method with no JavaScript body is left out": () =>
  {
    assert.strictEqual(typeof new Order("A-1").javaOnly, "undefined");
  }
};
