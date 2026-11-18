// Directed associations: only the class that declares them knows about them

"use strict";

const assert = require("node:assert");
const { load } = require("../umple.js");

const Driver = load("Driver");
const Badge = load("Badge");
const Trip = load("Trip");

module.exports = {
  "a directed one starts null and the other class has no method": () =>
  {
    const driver = new Driver("d");
    assert.strictEqual(driver.getBadge(), null);
    assert.strictEqual(typeof new Badge("b").getDriver, "undefined");
  },

  "a directed one is set and unset on its own": () =>
  {
    const driver = new Driver("d");
    const badge = new Badge("b");
    assert.strictEqual(driver.setBadge(badge), true);
    assert.strictEqual(driver.getBadge(), badge);
    assert.strictEqual(driver.setBadge(null), true);
    assert.strictEqual(driver.getBadge(), null);
  },

  "a directed many is added to and removed from on its own": () =>
  {
    const driver = new Driver("d");
    const trip = new Trip("Ottawa");
    assert.deepStrictEqual(driver.getTrips(), []);
    assert.strictEqual(driver.addTrip(trip), true);
    assert.strictEqual(driver.numberOfTrips(), 1);
    assert.strictEqual(driver.addTrip(trip), false);
    assert.strictEqual(driver.removeTrip(trip), true);
    assert.strictEqual(driver.numberOfTrips(), 0);
  },

  "deleting the class that declares a directed end clears it": () =>
  {
    const driver = new Driver("d");
    driver.setBadge(new Badge("b"));
    driver.addTrip(new Trip("Hull"));
    driver.delete();
    assert.strictEqual(driver.getBadge(), null);
    assert.strictEqual(driver.numberOfTrips(), 0);
  }
};
