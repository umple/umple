<?php
/* 
Counter code derived from Justin Tadlock
http://justintadlock.com/web-design/counter
*/

/* counter */

//opens countlog.txt to read the number of hits
$dir = dirname(__FILE__);
$logpath = $dir."/countlog.txt";
$versionpath = $dir."/scripts/versionRunning.txt"; 
$commandlogpath = $dir."/scripts/commandcount.txt";
$visitsString = "visits since October 2018";
$commandsRunString = "commands run since July 2019";
$branchpath = "/tmp/umplegitbranch.txt";
if(file_exists($logpath)){
	if(!is_writable($logpath)||!is_readable($logpath)) {
		chmod($logpath, 0755);
	}
	$log = fopen($logpath, "r");
	$count = fgets($log,1000);
	fclose($log);
	$count=$count + 1 ;
  if ($count>=1000 && $count<1000000) {
  $count_new=number_format((float)$count/1000, 2, '.', '');
    echo "$count_new K $visitsString" ;
  }
  elseif ($count>=1000000) {
    $count_new=number_format((float)$count/1000000, 2, '.', '');
    echo "$count_new million $visitsString" ;
  }
  else {
    $count_new=$count;
    echo "$count_new $visitsString" ;
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
    $count_new=number_format((float)$count/1000, 2, '.', '');
    echo " | $count_new K $commandsRunString" ;
  }
  elseif ($count>=1000000) {
    $count_new=number_format((float)$count/1000000, 2, '.', '');
    echo " | $count_new million $commandsRunString" ;
  }
  else {
    $count_new=$count;
    echo " | $count_new $commandsRunString" ;
  }
}

if(file_exists($versionpath)){
	if(!is_readable($versionpath)) {
		chmod($versionpath, 0755);
	}
	$vfile = fopen($versionpath, "r");
	$currentversion = fgets($vfile,1000);
	fclose($vfile);
	echo " | v$currentversion" ;
}


if(file_exists($branchpath)){
	if(!is_readable($branchpath)) {
		chmod($branchpath, 0755);
	}
	$bfile = fopen($branchpath, "r");
	$currentbranch = fgets($bfile,1000);
	fclose($bfile);
	echo " | $currentbranch" ;
}


?>
