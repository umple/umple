<?php
date_default_timezone_set("America/New_York");

require_once('../../dist/libs/php/simpletest/unit_tester.php');
require_once('../../dist/libs/php/simpletest/reporter.php');
require_once('AllTestHelper.php');

$test = new TestSuite('All Tests');
loadTestsIn($test,'associations');
// Issue 935 -> Ignore PHP test, PHP generation to be updated in the future
// loadTestsIn($test,'statemachine');
loadTestsIn($test,'attributes');
loadTestsIn($test,'patterns');
loadTestsIn($test,'tracer');

$reporter = new HtmlReporter();
$test->run($reporter);
