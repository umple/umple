<?php

function __autoload($class_name) 
{
  if ($class_name == "Date")
  {
    return;
  }
  require_once "../src-gen-umple/" . $class_name . '.php';
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