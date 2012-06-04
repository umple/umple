<?php
if (isset($_POST['action'])) {
	switch ($_POST['action']) {
		case 'loadAllElections':
			require_once("ElectionService.php");
			$allElections=ElectionService::getInstance()->getElections();
			echo $allElections;
		break;
		case 'addPoll':
			require_once("PollService.php");
			PollService::getInstance()->setPollJSON($_POST['pollJSON']);
			$result=PollService::getInstance()->getLatestResult();
			echo $result;
		break;
	}
} else
echo <<< _OUT
		<!DOCTYPE html>
        <html>
                <head>
					<script type="text/javascript" src="addpoll.js">
					</script>
					<link rel="stylesheet" href="usecase.css" />
                </head>
                <body onload="loadAllElections()">
                    <div class="mainForm">
                        <label for="pollName">Enter a poll name:</label>
                                <input type="text" id="pollName"></input>
                        <label for="pollDescriptiom">Enter a poll description:</label>
                                <input type="text" id="pollDescription"></input>
                        <label for="elections">Select an election:</label>
                                <select id="elections"></select>
                        <button id="addPoll" onclick="addPoll()">add</button>
                        <p id="result"></p>
                    </div>
                </body>
        </html>
_OUT
?>