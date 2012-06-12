<?php
/*

Copyright: All contributers to the Umple Project

This file is made available subject to the open source license found at:
http://umple.org/license

*/

if (isset($_POST['action'])) {
	switch ($_POST['action']) {
		case 'loadAllElections':
			require_once("ElectionService.php");
			$allElections=ElectionService::getInstance()->getElections();
			echo $allElections;
		break;
		case 'loadAllPositions':
			require_once("PositionService.php");
			$allPositions=PositionService::getInstance()->getPositions();
			echo $allPositions;
		break;
		case 'addElectionForPosition':
			require_once("ElectionForPositionService.php");
			$first=true;
			$result='';
			foreach ($_POST as $json) {
				if (!$first) {
					ElectionForPositionService::getInstance()->setEfpJSON($json);
					$result=$result.ElectionForPositionService::getInstance()->getLatestResult();
				} else
					$first=false;
			}
			echo $result;
		break;
	}
} else
echo <<< _OUT
		<!DOCTYPE html>
        <html>
                <head>
					<script type="text/javascript" src="addelectionforposition.js">
					</script>
					<link rel="stylesheet" href="usecase.css" />
                </head>
                <body onload="loadAllElections();loadAllPositions();">
                    <div class="mainForm">
                        <label for="positions">Select a position:</label>
                                <select id="positions" multiple="multiple"></select>
                        <label for="elections">Select an election:</label>
                                <select id="elections"></select>
                        <button id="update" onclick="update()">update</button>
                        <p id="result"></p>
                    </div>
                </body>
        </html>
_OUT
?>