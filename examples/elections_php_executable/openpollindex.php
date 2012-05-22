<?php
	include("OpenPoll.php");
	include("Credentials.php");

	$openpoll = new OpenPoll(Credentials::$db_hostname,Credentials::$db_username,Credentials::$db_password);
?>