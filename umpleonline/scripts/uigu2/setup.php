<?php

/*EDIT BELOW: parent URL of the folder where index.php is located
 *eg. to access 'http://a/b/c/index.php', use 'http://a/b/' (with trailing slash) */
//define('WEB_DOMAIN_ROOT','http://default/');
$webPrefix = $_SERVER["HTTP_HOST"].$_SERVER["REQUEST_URI"];
$cutoff=strpos($webPrefix,"/ump/");
$actualpath=substr($webPrefix,0,$cutoff+5);
define('WEB_DOMAIN_ROOT','http://'.$actualpath);
/*EDIT BELOW: parent path of the folder where index.php is located,
 *relative to the <DocumentRoot> element of the apache config file 
 *eg.  if <DocumentRoot> is '/var/www/' and the full path is '/var/www/a/b/index.php'
 *use '/a/' (with trailing slash) */
$pathStart=strpos($actualpath,"/umpleonline/");
$wfr=substr($actualpath,$pathStart);
define('WEB_FOLDER_ROOT',$wfr);
define('APP_PATH','app/');
define('VIEW_PATH',APP_PATH.'views/');
define('CONTROLLER_PATH',APP_PATH.'controllers/');

