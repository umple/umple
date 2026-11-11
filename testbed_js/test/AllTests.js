/*

Copyright: All contributers to the Umple Project

This file is made available subject to the open source license found at:
https://umple.org/license

*/

// Runs every *_test.js under this directory against the modules in testbed_js/src-gen-umple, prints
// an HTML table of the results for the QA page, and exits with a non-zero status if anything failed.
// The Ant target passes the jar to generate with as the first argument (see umple.js).

"use strict";

const fs = require("node:fs");
const path = require("node:path");

// The number of tests the suite has (see the check after the run). A test file that was deleted or
// misnamed would otherwise drop its tests without a failure.
const INVENTORY = 64;

function testFiles(directory)
{
  const found = [];
  for (const entry of fs.readdirSync(directory, { withFileTypes: true }).sort((a, b) => a.name.localeCompare(b.name)))
  {
    const full = path.join(directory, entry.name);
    if (entry.isDirectory())
    {
      found.push(...testFiles(full));
    }
    else if (entry.name.endsWith("_test.js"))
    {
      found.push(full);
    }
  }
  return found;
}

function escape(text)
{
  return String(text).replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;");
}

const root = __dirname;
const rows = [];
let run = 0;
let failed = 0;

for (const file of testFiles(root))
{
  const moduleName = path.relative(root, file).replace(/\\/g, "/");
  let suite;
  try
  {
    suite = require(file);
  }
  catch (error)
  {
    failed++;
    rows.push([moduleName, "(could not be loaded)", "ERROR", error.stack || String(error)]);
    continue;
  }
  for (const [name, test] of Object.entries(suite))
  {
    run++;
    try
    {
      test();
      rows.push([moduleName, name, "PASS", ""]);
    }
    catch (error)
    {
      failed++;
      rows.push([moduleName, name, "FAIL", error.stack || String(error)]);
      process.stderr.write(moduleName + " " + name + ": " + (error.stack || error) + "\n");
    }
  }
}

const colours = { PASS: "#66CD00", FAIL: "#FF0000", ERROR: "#FF0000" };
let table = "<style> table, th, td { border-collapse: collapse; padding: 8px 12px; border: 1px solid #ddd; }"
  + " tr:first-child { background-color: #a6caf0; font-weight: bold } </style>";
table += "<table><tr><td>ID</td><td>Module</td><td>Test</td><td>Status</td><td>Message</td></tr>";
rows.forEach(([moduleName, name, status, message], index) =>
{
  table += "<tr><td>" + (index + 1) + "</td><td>" + escape(moduleName) + "</td><td>" + escape(name)
    + "</td><td style='background-color:" + colours[status] + "'>" + status + "</td><td>" + escape(message) + "</td></tr>";
});
table += "</table>";
table += "Successful: " + (run - failed) + " / " + run + " (" + (run === 0 ? "0.00" : (100 * (run - failed) / run).toFixed(2)) + "%)";
process.stdout.write(table + "\n");

if (run !== INVENTORY)
{
  process.stderr.write(run + " tests ran, not the inventory of " + INVENTORY + ": a test file is missing or"
    + " misnamed, or the inventory needs updating\n");
}
process.exit(failed === 0 && run === INVENTORY ? 0 : 1);
