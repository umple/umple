<?php
spl_autoload_register(function ($class_name) 
{
  if ($class_name == "Date")
  {
    return;
  }
  if ($class_name == "DOMDocument")
  {
    echo "DOMDocument not installed, because php-xml not installed, so cannot do Php Testing, so <strong>0</strong> fails since 0 tried.";
    exit(0);
  }  
  
  require_once "../src-gen-umple/" . $class_name . '.php';
});

function endsWith($str, $sub ) 
{
  return ( substr( $str, strlen( $str ) - strlen( $sub ) ) == $sub );
}

function loadTestsIn($test,$directoryName)
{
  if ($handle = opendir($directoryName)) { 
    while (false !== ($file = readdir($handle))) 
    { 
      if (endsWith($file,"Test.php")) 
      { 
        $test->addFile("{$directoryName}/{$file}");
      } 
    } 
    closedir($handle); 
  }
}