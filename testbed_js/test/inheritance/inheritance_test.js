// Inheritance over three levels, with an abstract class and an abstract method

"use strict";

const assert = require("node:assert");
const { load } = require("../umple.js");

const Vehicle = load("Vehicle");
const Truck = load("Truck");
const Pickup = load("Pickup");

module.exports = {
  "an abstract class cannot be instantiated": () =>
  {
    assert.throws(() => new Vehicle("ABC 123"), TypeError);
  },

  "a subclass of an abstract class can be instantiated": () =>
  {
    const truck = new Truck("ABC 123", 2.5);
    assert.ok(truck instanceof Vehicle);
    assert.strictEqual(truck.getPlate(), "ABC 123");
    assert.strictEqual(truck.getLoad(), 2.5);
  },

  "the constructor of a subclass passes the inherited attributes up": () =>
  {
    const pickup = new Pickup("XYZ 789", 1.0, true);
    assert.ok(pickup instanceof Truck);
    assert.ok(pickup instanceof Vehicle);
    assert.strictEqual(pickup.getPlate(), "XYZ 789");
    assert.strictEqual(pickup.getLoad(), 1.0);
    assert.strictEqual(pickup.getCanopy(), true);
    assert.strictEqual(pickup.getWheels(), 4);
  },

  "an inherited setter changes the inherited attribute": () =>
  {
    const pickup = new Pickup("XYZ 789", 1.0, true);
    assert.strictEqual(pickup.setPlate("QRS 456"), true);
    assert.strictEqual(pickup.getPlate(), "QRS 456");
  },

  "a method of the superclass calls the implementation of the subclass": () =>
  {
    assert.strictEqual(new Truck("ABC 123", 2.5).describe(), "truck ABC 123");
    assert.strictEqual(new Pickup("XYZ 789", 1.0, false).describe(), "pickup XYZ 789");
  },

  "an abstract method reports a call that reaches it": () =>
  {
    assert.throws(() => Vehicle.prototype.kind.call(Object.create(Vehicle.prototype)), TypeError);
  },

  "a subclass overrides the abstract method": () =>
  {
    assert.strictEqual(new Truck("ABC 123", 2.5).kind(), "truck");
    assert.strictEqual(new Pickup("XYZ 789", 1.0, false).kind(), "pickup");
  },

  "delete of a subclass runs the whole chain": () =>
  {
    const pickup = new Pickup("XYZ 789", 1.0, true);
    pickup.delete();
    assert.strictEqual(pickup.getPlate(), "XYZ 789");
  }
};
