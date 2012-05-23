<?php
if (isset($_POST['action'])) {
	switch ($_POST['action']) {
		case 'loadAllElections':
			require_once("ElectionService.php");
			require_once("Credentials.php");
			$allElections=ElectionService::getInstance()->getAllElections(Credentials::$db_hostname,Credentials::$db_username,Credentials::$db_password);
			echo $allElections;
		break;
		case 'loadElectionPolls':
			require_once("PollService.php");
			require_once("Credentials.php");
			$allPolls=PollService::getInstance()->getElectionPolls(Credentials::$db_hostname,Credentials::$db_username,Credentials::$db_password,$_POST['idElection']);
			echo $allPolls;
		break;
		case 'openPoll':
			require_once("PollService.php");
			require_once("Credentials.php");
			$result=PollService::getInstance()->openPoll(Credentials::$db_hostname,Credentials::$db_username,Credentials::$db_password,$_POST['idpoll']);
			echo $result;
		break;
	}
} else
echo <<< _OUT
		<!DOCTYPE html>
        <html>
                <head>
                <script type="text/javascript" src="openpoll.js">
                        </script>
                </head>
                <body onload="loadAllElections()">
                <label for="elections">Select an election:</label>
                        <select id="elections"  onchange="loadElectionPolls(this)"></select>
                <label for="polls">Select a poll:</label>
                        <select id="polls"></select>
                <button id="openPoll" onclick="openPoll()">Open</button>
                <p id="result"></p>
                </body>
        </html>
_OUT
?>