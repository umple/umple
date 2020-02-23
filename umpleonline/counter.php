<?php
/*
Counter code derived from Justin Tadlock
http://justintadlock.com/web-design/counter
*/

/* counter */

//opens countlog.txt to read the number of hits
$dir = dirname(__FILE__);
$logpath = $dir."/countlog.txt";
$commandlogpath = $dir."/scripts/commandcount.txt";
if(file_exists($logpath)){
	if(!is_writable($logpath)||!is_readable($logpath)) {
		chmod($logpath, 0755);
	}
	$log = fopen($logpath, "r");
	$count = fgets($log,1000);
	fclose($log);
	$count=$count + 1 ;
	if ($count>=1000 && $count<1000000) {
		$count_new=((float)$count/1000, 2, '.', '');
		echo "$count_new" ;
		echo " K visits since October 2018" ;
	}
	elseif ($count>=1000000) {
		$count_new=((float)$count/1000000, 2, '.', '');
		echo "$count_new" ;
		echo " million visits since October 2018" ;
	}
	else {
		$count_new=$count;
		echo "$count_new" ;
		echo " visits since October 2018" ;
	}

	// opens countlog.txt to change new hit number
	$log = fopen($logpath,"w");
	fwrite($log, $count);
	fclose($log);
}

if(file_exists($commandlogpath)){
	if(!is_readable($commandlogpath)) {
		chmod($commandlogpath, 0755);
	}
	$log = fopen($commandlogpath, "r");
	$count = fgets($log,1000);
	fclose($log);
	if ($count>=1000 && $count<1000000) {
		$count_new=((float)$count/1000, 2, '.', '');
		echo " | $count_new K commands run since July 2019" ;
	}
	elseif ($count>=1000000) {
		$count_new=((float)$count/1000000, 2, '.', '');
		echo " | $count_new million commands run since July 2019" ;
	}
	else {
		$count_new=$count;
		echo " | $count_new commands run since July 2019" ;
	}
}


?>
