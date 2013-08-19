<?php
ini_set('display_errors','On');
error_reporting(E_ALL);

require_once('setup.php');
require_once(APP_PATH.'kissmvc_uigu2.php');

session_start();

//loading of domain classes by demand
function __autoload($classname) {
  $filename = $classname.'.php';
  if(file_exists($filename)){
    require_once($classname.'.php');
  }
}

new Uigu2_Controller(CONTROLLER_PATH,WEB_FOLDER,'main','index');
