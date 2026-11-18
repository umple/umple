// Many to many, from both ends

"use strict";

const assert = require("node:assert");
const { load } = require("../umple.js");

const Course = load("Course");
const Pupil = load("Pupil");

module.exports = {
  "both ends start empty": () =>
  {
    assert.deepStrictEqual(new Course("c").getPupils(), []);
    assert.deepStrictEqual(new Pupil("p").getCourses(), []);
  },

  "add links both ends": () =>
  {
    const course = new Course("c");
    const pupil = new Pupil("p");
    assert.strictEqual(course.addPupil(pupil), true);
    assert.strictEqual(course.numberOfPupils(), 1);
    assert.strictEqual(pupil.numberOfCourses(), 1);
    assert.strictEqual(pupil.getCourse(0), course);
  },

  "adding the same pair twice does nothing": () =>
  {
    const course = new Course("c");
    const pupil = new Pupil("p");
    course.addPupil(pupil);
    assert.strictEqual(course.addPupil(pupil), false);
    assert.strictEqual(pupil.addCourse(course), false);
    assert.strictEqual(course.numberOfPupils(), 1);
  },

  "remove unlinks both ends": () =>
  {
    const course = new Course("c");
    const pupil = new Pupil("p");
    course.addPupil(pupil);
    assert.strictEqual(course.removePupil(pupil), true);
    assert.strictEqual(course.numberOfPupils(), 0);
    assert.strictEqual(pupil.numberOfCourses(), 0);
  },

  "removing a pair that is not linked reports nothing removed": () =>
  {
    assert.strictEqual(new Course("c").removePupil(new Pupil("p")), false);
  },

  "delete unlinks every partner": () =>
  {
    const course = new Course("c");
    const first = new Pupil("p1");
    const second = new Pupil("p2");
    course.addPupil(first);
    course.addPupil(second);
    course.delete();
    assert.strictEqual(first.numberOfCourses(), 0);
    assert.strictEqual(second.numberOfCourses(), 0);
  }
};
