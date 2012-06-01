<?php
if (isset($_POST['action'])) {
	switch ($_POST['action']) {
		case 'addElection':
			require_once("ElectionService.php");
			$result=ElectionService::getInstance()->setElectionJSON($_POST['electionJSON']);
			echo $result;
		break;
	}
} else
echo <<< _OUT
		<!DOCTYPE html>
        <html>
                <head>
                <script type="text/javascript" src="addelection.js">
                        </script>
                </head>
                <body>
                <label for="electionName">Enter an election name:</label>
                        <input type="text" id="electionName"></input>
                <label for="electionDescriptiom">Enter an election description:</label>
                        <input type="text" id="electionDescription"></input>
                <button id="addElection" onclick="addElection()">add</button>
                <p id="result"></p>
                </body>
        </html>
_OUT
?>