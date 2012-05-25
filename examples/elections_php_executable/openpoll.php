<?php
if (isset($_POST['action'])) {
	switch ($_POST['action']) {
		case 'loadAllElections':
			require_once("ElectionService.php");
			require_once("Credentials.php");
			require_once("Credentials.php");
			ElectionService::getInstance()->setDb_hostname(Credentials::$db_hostname);
			ElectionService::getInstance()->setDb_username(Credentials::$db_username);
			ElectionService::getInstance()->setDb_password(Credentials::$db_password);
			ElectionService::getInstance()->getAllElections();
			$allElections=ElectionService::getInstance()->getElections();
			echo $allElections;
		break;
		case 'loadElectionPolls':
			require_once("PollService.php");
			require_once("Credentials.php");
			PollService::getInstance()->setDb_hostname(Credentials::$db_hostname);
			PollService::getInstance()->setDb_username(Credentials::$db_username);
			PollService::getInstance()->setDb_password(Credentials::$db_password);
			PollService::getInstance()->setIdElection($_POST['idElection']);
			PollService::getInstance()->getElectionPolls();
			$allPolls=PollService::getInstance()->getAllPolls();
			echo $allPolls;
		break;
		case 'openPoll':
			require_once("PollService.php");
			require_once("Credentials.php");
			PollService::getInstance()->setDb_hostname(Credentials::$db_hostname);
			PollService::getInstance()->setDb_username(Credentials::$db_username);
			PollService::getInstance()->setDb_password(Credentials::$db_password);
			PollService::getInstance()->setIdElection($_POST['idpoll']);
			PollService::getInstance()->openPoll();
			$result=PollService::getInstance()->getLatestResult();
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