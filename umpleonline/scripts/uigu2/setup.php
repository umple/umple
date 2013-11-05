<?php

/*EDIT BELOW: parent URL of the folder where index.php is located
 *eg. to access 'http://a/b/c/index.php', use 'http://a/b/' (with trailing slash) */
define('WEB_DOMAIN_ROOT','http://default/');

/*EDIT BELOW: parent path of the folder where index.php is located,
 *relative to the <DocumentRoot> element of the apache config file 
 *eg.  if <DocumentRoot> is '/var/www/' and the full path is '/var/www/a/b/index.php'
 *use '/a/' (with trailing slash) */
define('WEB_FOLDER_ROOT','/');

define('APP_PATH','app/');
define('VIEW_PATH',APP_PATH.'views/');
define('CONTROLLER_PATH',APP_PATH.'controllers/');
