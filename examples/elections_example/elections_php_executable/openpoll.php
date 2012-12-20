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
		case 'loadElectionPolls':
			require_once("PollService.php");
			PollService::getInstance()->setIdElection($_POST['idElection']);
			PollService::getInstance()->getElectionPolls();
			$allPolls=PollService::getInstance()->getAllPolls();
			echo $allPolls;
		break;
		case 'openPoll':
			require_once("PollService.php");
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
                	<script type="text/javascript" src="openpoll.js"></script>
					<link rel="stylesheet" href="usecase.css" />
                </head>
                <body onload="loadAllElections()">
                    <div class="mainForm">
                        <label for="elections">Select an election:</label>
                                <select id="elections"  onchange="loadElectionPolls(this)"></select>
                        <label for="polls">Select a poll:</label>
                                <select id="polls"></select>
                        <button id="openPoll" onclick="openPoll()">Open</button>
                        <p id="result"></p>
                    </div>
                </body>
        </html>
_OUT
?>