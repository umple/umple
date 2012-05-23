<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

class PollService
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static $theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private function __construct()
  {}

  public static function getInstance()
  {
    if(self::$theInstance == null)
    {
      self::$theInstance = new PollService();
    }
    return self::$theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public function getElectionPolls($db_hostname,$db_username,$db_password,$idElection) {
		$isConnected = mysql_connect($db_hostname,$db_username,$db_password);
		
		$result = mysql_query("SELECT * FROM elections.election where idElection=$idElection");

		require_once("./domain/Election.php");
		$anElection=null;
		
		while($row = mysql_fetch_array($result)) {
			$anElection=new Election($row['idElection'],$row['name'],$row['description']);
		}
		
  		$result = mysql_query("SELECT * FROM elections.poll where theElection=$idElection");

		require_once("./domain/Poll.php");
		
		$allPolls='{"polls" : [';
		$first=true;
		while($row = mysql_fetch_array($result)) {
			$aPoll=new Poll($row['idpoll'],$row['name'],$row['description'],$anElection);
			if ($first) {
				$allPolls=$allPolls.$this->jsonSerialize($aPoll);
				$first=false;
			} else
				$allPolls=$allPolls.",".$this->jsonSerialize($aPoll);
		}
		$allPolls=$allPolls.']}';

		mysql_close($isConnected);
		
		return $allPolls;
	}
	
	public function openPoll($db_hostname,$db_username,$db_password,$idpoll) {
		$isConnected = mysql_connect($db_hostname,$db_username,$db_password);
		
		$wasUpdated=false;
		if ($isConnected) {
			$wasUpdated = mysql_query("update elections.poll set status='open' where idpoll=$idpoll");
		}
		
		if ($isConnected && $wasUpdated)
			return "Poll open!";
		else
			return "An error occured!";
	}
	
	private function jsonSerialize($aPoll) {
		return '{"idpoll":"'.$aPoll->getIdElection().'","name":"'.$aPoll->getName().'","description":"'.$aPoll->getDescription().'","theElection":"'.$aPoll->getTheElection()->getIdElection().'"}';
	}
}
?>