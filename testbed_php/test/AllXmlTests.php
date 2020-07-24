<?php
date_default_timezone_set("America/New_York");

require_once('../../dist/libs/php/simpletest/unit_tester.php');
require_once('../../dist/libs/php/simpletest/reporter.php');
require_once('AllTestHelper.php');

$test = new TestSuite('All Tests');
loadTestsIn($test,'associations');
loadTestsIn($test,'statemachine');
loadTestsIn($test,'attributes');
// issue#1525  I commented out this beacuse no tracer folder found in the /umple/testbed_php/test/.
// loadTestsIn($test,'tracer');

$reporter = new XmlReporter();
$test->run($reporter);