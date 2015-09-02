<?php
date_default_timezone_set("America/New_York");

require_once('../../dist/libs/php/simpletest/unit_tester.php');
require_once('../../dist/libs/php/simpletest/reporter.php');
require_once('AllTestHelper.php');

$test = new TestSuite('All Tests');
loadTestsIn($test,'associations');
loadTestsIn($test,'statemachine');
loadTestsIn($test,'attributes');
loadTestsIn($test,'tracer');

$reporter = new XmlReporter();
$test->run($reporter);