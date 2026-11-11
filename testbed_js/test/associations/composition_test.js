// Compositions: deleting the whole deletes its parts

"use strict";

const assert = require("node:assert");
const { load } = require("../umple.js");

const House = load("House");
const Room = load("Room");
const Car = load("Car");
const Engine = load("Engine");

module.exports = {
  "a part is added to the whole like any many end": () =>
  {
    const house = new House("1 Main");
    const room = new Room("kitchen");
    assert.strictEqual(house.addRoom(room), true);
    assert.strictEqual(house.numberOfRooms(), 1);
    assert.strictEqual(room.getHouse(), house);
  },

  "deleting the whole deletes its parts": () =>
  {
    const house = new House("1 Main");
    const first = new Room("kitchen");
    const second = new Room("hall");
    house.addRoom(first);
    house.addRoom(second);
    house.delete();
    assert.strictEqual(house.numberOfRooms(), 0);
    assert.strictEqual(first.getHouse(), null);
    assert.strictEqual(second.getHouse(), null);
  },

  "a one to one composition starts null and links both ends": () =>
  {
    const car = new Car("ABC 123");
    const engine = new Engine("E-1");
    assert.strictEqual(car.getEngine(), null);
    assert.strictEqual(engine.getCar(), null);
    assert.strictEqual(car.setEngine(engine), true);
    assert.strictEqual(car.getEngine(), engine);
    assert.strictEqual(engine.getCar(), car);
  },

  "deleting the whole of a one to one composition releases the part": () =>
  {
    const car = new Car("ABC 123");
    const engine = new Engine("E-1");
    car.setEngine(engine);
    car.delete();
    assert.strictEqual(engine.getCar(), null);
  }
};
