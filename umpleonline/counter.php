<?php
/* 
Counter code derived from Justin Tadlock
http://justintadlock.com/web-design/counter
*/

/* counter */

//opens countlog.txt to read the number of hits
$dir = dirname(__FILE__);
$logpath = $dir."/countlog.txt";
if(!file_exists($logpath)){
	$log = fopen($logpath,"w");
	fwrite($log, 0);
	fclose($log);
}
if(!is_writable($logpath)||!is_readable($logpath)) {
	chmod($logpath, 0755);
}
$log = fopen($logpath, "r");
$count = fgets($log,1000);
fclose($log);
$count=$count + 1 ;
echo "$count" ;
echo " visits since October 2018" ;

// opens countlog.txt to change new hit number
$log = fopen($logpath,"w");
fwrite($log, $count);
fclose($log);


?>
