<?php
/*

Copyright: All contributers to the Umple Project

This file is made available subject to the open source license found at:
http://umple.org/license

*/

if (isset($_POST['action'])) {
	switch ($_POST['action']) {
		case 'addPosition':
			require_once("PositionService.php");
			PositionService::getInstance()->setPositionJSON($_POST['positionJSON']);
			$result=PositionService::getInstance()->getLatestResult();
			echo $result;
		break;
	}
} else
echo <<< _OUT
		<!DOCTYPE html>
        <html>
                <head>
					<script type="text/javascript" src="addposition.js"></script>
					<link rel="stylesheet" href="usecase.css" />
                </head>
                <body>
                    <div class="mainForm">
						<label for="positionName">Enter an position name:</label>
								<input type="text" id="positionName"></input>
						<label for="positionDescriptiom">Enter an position description:</label>
								<input type="text" id="positionDescription"></input>
						<button id="addPosition" onclick="addPosition()">add</button>
						<p id="result"></p>
					</div>
                </body>
        </html>
_OUT
?>