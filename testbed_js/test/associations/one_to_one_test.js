// An optional one to an optional one, in both directions

"use strict";

const assert = require("node:assert");
const { load } = require("../umple.js");

const Desk = load("Desk");
const Chair = load("Chair");

module.exports = {
  "both ends start null rather than undefined": () =>
  {
    const desk = new Desk("d1");
    const chair = new Chair("c1");
    assert.strictEqual(desk.getChair(), null);
    assert.strictEqual(chair.getDesk(), null);
    assert.strictEqual(desk.hasChair(), false);
  },

  "setting one end sets the other": () =>
  {
    const desk = new Desk("d1");
    const chair = new Chair("c1");
    assert.strictEqual(desk.setChair(chair), true);
    assert.strictEqual(desk.getChair(), chair);
    assert.strictEqual(chair.getDesk(), desk);
    assert.strictEqual(desk.hasChair(), true);
  },

  "setting null unlinks both ends and reads back as null": () =>
  {
    const desk = new Desk("d1");
    const chair = new Chair("c1");
    desk.setChair(chair);
    assert.strictEqual(desk.setChair(null), true);
    assert.strictEqual(desk.getChair(), null);
    assert.strictEqual(chair.getDesk(), null);
  },

  "setting another partner releases the first": () =>
  {
    const desk = new Desk("d1");
    const first = new Chair("c1");
    const second = new Chair("c2");
    desk.setChair(first);
    desk.setChair(second);
    assert.strictEqual(desk.getChair(), second);
    assert.strictEqual(second.getDesk(), desk);
    assert.strictEqual(first.getDesk(), null);
  },

  "deleting one end unlinks the other": () =>
  {
    const desk = new Desk("d1");
    const chair = new Chair("c1");
    desk.setChair(chair);
    desk.delete();
    assert.strictEqual(chair.getDesk(), null);
  }
};
