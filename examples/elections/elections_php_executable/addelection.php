<?php
/*

Copyright: All contributers to the Umple Project

This file is made available subject to the open source license found at:
http://umple.org/license

*/

if (isset($_POST['action'])) {
	switch ($_POST['action']) {
		case 'addElection':
			require_once("ElectionService.php");
			ElectionService::getInstance()->setElectionJSON($_POST['electionJSON']);
			$result=ElectionService::getInstance()->getLatestResult();
			echo $result;
		break;
	}
} else
echo <<< _OUT
		<!DOCTYPE html>
        <html>
                <head>
					<script type="text/javascript" src="addelection.js"></script>
					<link rel="stylesheet" href="usecase.css" />
                </head>
                <body>
                    <div class="mainForm">
						<label for="electionName">Enter an election name:</label>
								<input type="text" id="electionName"></input>
						<label for="electionDescriptiom">Enter an election description:</label>
								<input type="text" id="electionDescription"></input>
						<button id="addElection" onclick="addElection()">add</button>
						<p id="result"></p>
					</div>
                </body>
        </html>
_OUT
?>