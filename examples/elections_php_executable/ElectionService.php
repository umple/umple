<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

class ElectionService
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
      self::$theInstance = new ElectionService();
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
  
  public function getAllElections($db_hostname,$db_username,$db_password) {
		$isConnected = mysql_connect($db_hostname,$db_username,$db_password);
  		$result = mysql_query("SELECT * FROM elections.election");

		require_once("./domain/Election.php");
		
		$allElections='{"elections" : [';
		$first=true;
		while($row = mysql_fetch_array($result)) {
			$anElection=new Election($row['idElection'],$row['name'],$row['description']);
			//print_r($anElection);
			//echo "<br/><a href=OpenPollController.php?election_id=".$anElection->getIdElection().">Open ".$anElection->getName()."</a><br/>";
			if ($first) {
				$allElections=$allElections.$this->jsonSerialize($anElection);
				$first=false;
			} else
				$allElections=$allElections.",".$this->jsonSerialize($anElection);
		}
		$allElections=$allElections.']}';

		mysql_close($isConnected);
		
		return $allElections;
	}
	
	private function jsonSerialize($anElection) {
		return '{"idElection":"'.$anElection->getIdElection().'","name":"'.$anElection->getName().'","description":"'.$anElection->getDescription().'"}';
		
	}
	/*db_hostname;
	db_username;
	db_password;*/
 
      	  /*entry / {$this->isConnected = mysql_connect($this->db_hostname,$this->db_username,$this->db_password);}
          [$this->isConnected] connected -> Connected;
          [!$this->isConnected] notConnected -> Failed;
      	  do
      	  {
      	  	$this->connected();
      	  	$this->notConnected();
          }*/
      
      /*Connected {
      	entry / {echo "Connected!";}
      	do {
      		$result = mysql_query("SELECT * FROM elections.election");

			require_once("Election.php");
			
			while($row = mysql_fetch_array($result)) {
				$anElection=new Election($row['idElection'],$row['name'],$row['description']);
				print_r($anElection);
				echo "<br/><a href=OpenPollController.php?election_id=".$anElection->getIdElection().">Open ".$anElection->getName()."</a><br/>";
			}

			mysql_close($this->isConnected);
      	}
      }*/
}
?>