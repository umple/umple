// An optional one to many, from both ends

"use strict";

const assert = require("node:assert");
const { load } = require("../umple.js");

const Team = load("Team");
const Player = load("Player");

module.exports = {
  "the many end starts empty and the one end starts null": () =>
  {
    const team = new Team("t");
    const player = new Player("p");
    assert.deepStrictEqual(team.getPlayers(), []);
    assert.strictEqual(team.numberOfPlayers(), 0);
    assert.strictEqual(team.hasPlayers(), false);
    assert.strictEqual(player.getTeam(), null);
  },

  "add links both ends": () =>
  {
    const team = new Team("t");
    const player = new Player("p");
    assert.strictEqual(team.addPlayer(player), true);
    assert.strictEqual(team.numberOfPlayers(), 1);
    assert.strictEqual(team.getPlayer(0), player);
    assert.strictEqual(team.indexOfPlayer(player), 0);
    assert.strictEqual(player.getTeam(), team);
  },

  "adding the same object twice does nothing": () =>
  {
    const team = new Team("t");
    const player = new Player("p");
    team.addPlayer(player);
    assert.strictEqual(team.addPlayer(player), false);
    assert.strictEqual(team.numberOfPlayers(), 1);
  },

  "remove unlinks both ends": () =>
  {
    const team = new Team("t");
    const player = new Player("p");
    team.addPlayer(player);
    assert.strictEqual(team.removePlayer(player), true);
    assert.strictEqual(team.numberOfPlayers(), 0);
    assert.strictEqual(player.getTeam(), null);
  },

  "setting the one end moves the object between the many ends": () =>
  {
    const first = new Team("t1");
    const second = new Team("t2");
    const player = new Player("p");
    first.addPlayer(player);
    assert.strictEqual(player.setTeam(second), true);
    assert.strictEqual(first.numberOfPlayers(), 0);
    assert.strictEqual(second.numberOfPlayers(), 1);
    assert.strictEqual(player.getTeam(), second);
  },

  "getPlayers returns a copy, so the list cannot be changed behind the object": () =>
  {
    const team = new Team("t");
    team.addPlayer(new Player("p"));
    const players = team.getPlayers();
    players.length = 0;
    assert.strictEqual(team.numberOfPlayers(), 1);
  },

  "the index methods place an object": () =>
  {
    const team = new Team("t");
    const first = new Player("p1");
    const second = new Player("p2");
    team.addPlayer(first);
    assert.strictEqual(team.addPlayerAt(second, 0), true);
    assert.strictEqual(team.getPlayer(0), second);
    assert.strictEqual(team.addOrMovePlayerAt(second, 1), true);
    assert.strictEqual(team.getPlayer(1), second);
  },

  "deleting the one end unlinks every object of the many end": () =>
  {
    const team = new Team("t");
    const first = new Player("p1");
    const second = new Player("p2");
    team.addPlayer(first);
    team.addPlayer(second);
    team.delete();
    assert.strictEqual(first.getTeam(), null);
    assert.strictEqual(second.getTeam(), null);
  },

  "deleting an object of the many end takes it out of the one end": () =>
  {
    const team = new Team("t");
    const player = new Player("p");
    team.addPlayer(player);
    player.delete();
    assert.strictEqual(team.numberOfPlayers(), 0);
  },

  "the minimum number of objects is zero": () =>
  {
    assert.strictEqual(Team.minimumNumberOfPlayers(), 0);
  }
};
