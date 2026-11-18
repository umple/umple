/*

Copyright: All contributers to the Umple Project

This file is made available subject to the open source license found at:
https://umple.org/license

*/

// Helpers the tests share: the generated modules, and a way to run the compiler on a model of a
// test's own and read what it reported.

"use strict";

const fs = require("node:fs");
const os = require("node:os");
const path = require("node:path");
const { spawnSync } = require("node:child_process");

const repository = path.resolve(__dirname, "..", "..");
const generated = path.resolve(__dirname, "..", "src-gen-umple");

// The module the harness generated for a class
function load(className)
{
  return require(path.join(generated, className + ".js"));
}

// The jar to generate with: the one the Ant target passes to AllTests.js, else dist/umple.jar
const compilerJar = process.argv[2] || path.join(repository, "dist", "umple.jar");

// Generates one model in a directory of its own and reports the compiler's exit status, its output
// and the files it wrote, so a test can state that a model is rejected and leaves nothing behind.
function generate(model)
{
  const directory = fs.mkdtempSync(path.join(os.tmpdir(), "umple-js-"));
  try
  {
    const file = path.join(directory, "model.ump");
    fs.writeFileSync(file, "generate JavaScript;\n" + model);
    const result = spawnSync("java", ["-jar", compilerJar, file], { encoding: "utf8" });
    if (result.error)
    {
      throw result.error;
    }
    return {
      status: result.status,
      output: (result.stdout || "") + (result.stderr || ""),
      files: fs.readdirSync(directory).filter(name => name.endsWith(".js")).sort()
    };
  }
  finally
  {
    fs.rmSync(directory, { recursive: true, force: true });
  }
}

module.exports = { load, generate, generated, repository };
