<?php
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// A minimal test harness for UmpleOnline's server-side PHP, so that the tests
// need nothing but the php command line. Test files register tests with
// UmpleTest::add and are run by run_tests.php.

class UmpleTestFailure extends Exception {}

class UmpleTest
{
  private static $tests = array();
  private static $cleanups = array();

  static function add($name, callable $test)
  {
    self::$tests[] = array($name, $test);
  }

  // Registers something to undo after the current test, whether or not it passes
  static function cleanup(callable $action)
  {
    self::$cleanups[] = $action;
  }

  static function run()
  {
    $failures = array();
    foreach (self::$tests as $test) {
      list($name, $body) = $test;
      try {
        $body();
        echo ".";
      } catch (Throwable $e) {
        echo "F";
        $failures[] = array($name, $e);
      } finally {
        while (count(self::$cleanups) > 0) {
          $action = array_pop(self::$cleanups);
          try {
            $action();
          } catch (Throwable $e) {
            // Keep cleaning up
          }
        }
      }
    }
    echo "\n\n";
    foreach ($failures as $failure) {
      list($name, $e) = $failure;
      echo "FAILED: ".$name."\n  ".$e->getMessage()."\n";
      if (!($e instanceof UmpleTestFailure)) echo $e->getTraceAsString()."\n";
      echo "\n";
    }
    echo count(self::$tests)." tests, ".count($failures)." failures\n";
    return count($failures) == 0;
  }
}

function describeValue($value)
{
  return var_export($value, true);
}

function assertTrue($condition, $message = "Expected true")
{
  if (!$condition) throw new UmpleTestFailure($message);
}

function assertFalse($condition, $message = "Expected false")
{
  assertTrue(!$condition, $message);
}

function assertSame($expected, $actual, $message = "")
{
  if ($expected !== $actual) {
    throw new UmpleTestFailure(($message === "" ? "" : $message.": ")
      ."expected ".describeValue($expected).", got ".describeValue($actual));
  }
}

function assertContains($needle, $haystack, $message = "")
{
  if (strpos($haystack, $needle) === false) {
    throw new UmpleTestFailure(($message === "" ? "" : $message.": ")
      ."expected to find ".describeValue($needle)." in ".describeValue($haystack));
  }
}

function assertNotContains($needle, $haystack, $message = "")
{
  if (strpos($haystack, $needle) !== false) {
    throw new UmpleTestFailure(($message === "" ? "" : $message.": ")
      ."did not expect to find ".describeValue($needle));
  }
}

// Creates an empty directory that is deleted after the current test
function makeTemporaryDirectory($prefix = "umple-test-")
{
  $dir = sys_get_temp_dir()."/".$prefix.bin2hex(random_bytes(6));
  mkdir($dir);
  UmpleTest::cleanup(function() use ($dir) { removeDirectory($dir); });
  return $dir;
}

function removeDirectory($dir)
{
  if (!is_dir($dir) || is_link($dir)) return;
  foreach (scandir($dir) as $name) {
    if ($name === "." || $name === "..") continue;
    $path = $dir."/".$name;
    if (is_dir($path) && !is_link($path)) removeDirectory($path);
    else unlink($path);
  }
  rmdir($dir);
}
