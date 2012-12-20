<?php

require_once("data.php");
require_once("display.php");

function __autoload($class_name) 
{
  require_once "class/" . $class_name . '.php';
}


?>
