<?php
ini_set('display_errors','On');
error_reporting(E_ALL);

define('APP_PATH','uigu2/'); //with trailing slash
define('WEB_DOMAIN','http://vbox'); //with http:// and NO trailing slash
define('WEB_FOLDER','/'); //with trailing slash
//define('WEB_FOLDER','index.php/'); //use this if you do not have mod_rewrite enabled
define('VIEW_PATH','uigu2/views/'); //with trailing slash
define('CONTROLLER_PATH','uigu2/controllers/'); //with trailing slash

require(APP_PATH.'kissmvc_uigu2.php');

session_start();

new Uigu2_Controller(CONTROLLER_PATH,WEB_FOLDER,'main','index');