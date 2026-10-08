<?php
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Runs the PHP tests of UmpleOnline's server-side code:
//   php run_tests.php                         all *_test.php files in this directory
//   php run_tests.php version_history_test.php   just the given files
// Exits with status 1 if any test fails.

require_once(__DIR__."/test_helper.php");

// Unexpected warnings and notices fail the test (errors suppressed with @ do not)
set_error_handler(function($severity, $message, $file, $line) {
  if (!(error_reporting() & $severity)) return false;
  throw new ErrorException($message, 0, $severity, $file, $line);
});

$files = array_slice($argv, 1);
if (count($files) == 0) {
  $files = glob(__DIR__."/*_test.php");
  sort($files);
}
foreach ($files as $file) {
  require_once(strpos($file, "/") === false ? __DIR__."/".$file : $file);
}
exit(UmpleTest::run() ? 0 : 1);
