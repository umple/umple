<?php
/*

Copyright: All contributers to the Umple Project

This file is made available subject to the open source license found at:
http://umple.org/license

*/

if (isset($_POST['action'])) {
	switch ($_POST['action']) {
		case 'registerCandidate':
			require_once("CandidateService.php");
			CandidateService::getInstance()->setCandidateJSON($_POST['candidateJSON']);
			$result=CandidateService::getInstance()->getLatestResult();
			echo $result;
		break;
	}
} else
echo <<< _OUT
		<!DOCTYPE html>
        <html>
                <head>
					<script type="text/javascript" src="registercandidate.js"></script>
					<link rel="stylesheet" href="usecase.css" />
                </head>
                <body>
                    <div class="mainForm">
						<label for="candidateName">Candidate Name:</label>
								<input type="text" id="candidateName"></input>
						<label for="candidateAddress">Candidate Address:</label>
								<input type="text" id="candidateAddress"></input>
						<label for="candidateTelephone">Candidate Telephone:</label>
								<input type="tel"text" id="candidateTelephone"></input>
						<button id="registerCandidate" onclick="registerCandidate()">
                        	register
                        </button>
						<p id="result"></p>
					</div>
                </body>
        </html>
_OUT
?>