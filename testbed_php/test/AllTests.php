<?php
date_default_timezone_set("America/New_York");

require_once('../../lib/simpletest/unit_tester.php');
require_once('../../lib/simpletest/reporter.php');
require_once('AllTestHelper.php');

$test = &new GroupTest('All Tests');
loadTestsIn($test,'associations');
loadTestsIn($test,'statemachine');
loadTestsIn($test,'attributes');
loadTestsIn($test,'patterns');
loadTestsIn($test,'tracer');

$reporter = new HtmlReporter();
$test->run($reporter);
