<?php
date_default_timezone_set("America/New_York");

require_once('../../lib/simpletest/unit_tester.php');
require_once('../../lib/simpletest/reporter.php');



function __autoload($class_name) 
{
  if ($class_name == "Date")
  {
    return;
  }
  require_once "../src/" . $class_name . '.php';
}

function endsWith($str, $sub ) 
{
  return ( substr( $str, strlen( $str ) - strlen( $sub ) ) == $sub );
}

function loadTestsIn($test,$directoryName)
{
  if ($handle = opendir($directoryName)) { 
    while (false !== ($file = readdir($handle))) 
    { 
      //if (endsWith($file,"NToMStarTest.php"))
      if (endsWith($file,"Test.php")) 
      { 
        $test->addTestFile("{$directoryName}/{$file}");
      } 
    } 
    closedir($handle); 
  }
}

$test = &new GroupTest('All Tests');
loadTestsIn($test,'associations');
loadTestsIn($test,'statemachine');
loadTestsIn($test,'attributes');

$reporter = new HtmlReporter();
$reporter = new TextReporter();
$test->run($reporter);
