<?php

require_once("scripts/compiler_config.php");
require_once("scripts/tab_control.php");

function intiateLogging() {
	$logOfCommands = fopen("ump/LogOfCommands.txt", 'w');
}

intiateLogging(); //initiate the logging

//$model = $_REQUEST["model"];

//save function
//function saving() {
	if (file_exists("ump/LogOfCommands.txt")) {
		$model = $_REQUEST["model"];

		mkdir("ump/".$dirname."/LogOfModelVersions"); // the first time it would need to create this

		$dataHandle = dataStore()->createData();
		$workDir = $dataHandle->getWorkDir();

		$filename = $workDir->getPath().'LogOfModelVersions/"."1".".txt'); //Each version has to have an new file name with a number
		$contents = file_get_contents($filename); //get contents
		savefile($contents, $filename); //save file
	}
	else {
		echo "Do nothing.";
	}
//}

$logOfCommands = fopen('ump/LogOfCommands.txt', 'w');
fwrite($logOfCommands, "OK");
fclose($logOfCommands);

echo "</br>";
echo "End";

?>
