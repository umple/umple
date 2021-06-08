<?php
date_default_timezone_set("America/New_York");
$defaultPath = "true";
require_once($defaultPath == "true" ? "../../dist/libs/php/simpletest/unit_tester.php": "../../dist/gradle/libs/php/simpletest-1.1.0/unit_tester.php");
require_once($defaultPath == "true" ? '../../dist/libs/php/simpletest/reporter.php':'../../dist/gradle/libs/php/simpletest-1.1.0/reporter.php');
require_once('AllTestHelper.php');

$test = new TestSuite('All Tests');
loadTestsIn($test,'associations');
loadTestsIn($test,'statemachine');
loadTestsIn($test,'attributes');
loadTestsIn($test,'patterns');
// issue#1525  I commented out this beacuse no tracer folder found in the /umple/testbed_php/test/.
//loadTestsIn($test,'tracer');

$reporter = new HtmlReporter();
$test->run($reporter);
