<?php
if (isset($_POST['action'])) {
        require_once("electionService.php");
        require_once("Credentials.php");
        $allElections=ElectionService::getInstance()->getAllElections(Credentials::$db_hostname,Credentials::$db_username,Credentials::$db_password);
        echo $allElections;
} else
echo <<< _OUT
        <html>
                <head>
                <script type="text/javascript" src="openpoll.js">
                        </script>
                </head>
                <body onload="loadAllElections()">
                <label for="elections">Select an election:</label>
                        <select id="elections"></select>
                </body>
        </html>
_OUT
?>
