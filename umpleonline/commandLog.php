<?php

$logOfCommands = fopen('ump/LogOfCommands.txt', 'w');

$time = time();
$date = date("Y-m-d H:i:s", $time);

// function recordVersion($name, ){
	if (file_exists('ump/LogOfCommands.txt')) {
		echo "File exist."; //debug
		fwrite($logOfCommands, "File exist.");
	}
	else {
		echo "File does not exist."; //debug
	}

	if (isset($_REQUEST["model"]) {
		mkdir("ump/LogOfModelVersions");

		$model = $_REQUEST["model"];
		foreach($contents as $base) {
				$filename = "../ump/".$model."/".$base.".ump";
				if (file_exists($filename))
				{
						$contents = file_get_contents($filename);
						savefile($contents,$filename);
				}
		}
	}
	else {
		echo "Do nothing.";
	}
//}

fwrite($logOfCommands, $date."\n");

fclose($logOfCommands);

echo "</br>";
echo "LogOfCommands.txt";
echo "</br>";
echo "End";

?>
