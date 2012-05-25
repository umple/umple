<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

class ElectionService
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static $theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ElectionService Attributes
  private $db_hostname;
  private $db_username;
  private $db_password;
  private $elections;

  //ElectionService State Machines
  private static $ServiceProvidingCycleIdle = 1;
  private static $ServiceProvidingCycleAllElectionsLoaded = 2;
  private $ServiceProvidingCycle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private function __construct()
  {
    $this->db_hostname = NULL;
    $this->db_username = NULL;
    $this->db_password = NULL;
    $this->elections = NULL;
    $this->setServiceProvidingCycle(self::$ServiceProvidingCycleIdle);
  }

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

  public function setDb_hostname($aDb_hostname)
  {
    $wasSet = false;
    $this->db_hostname = $aDb_hostname;
    $wasSet = true;
    return $wasSet;
  }

  public function setDb_username($aDb_username)
  {
    $wasSet = false;
    $this->db_username = $aDb_username;
    $wasSet = true;
    return $wasSet;
  }

  public function setDb_password($aDb_password)
  {
    $wasSet = false;
    $this->db_password = $aDb_password;
    $wasSet = true;
    return $wasSet;
  }

  public function setElections($aElections)
  {
    $wasSet = false;
    $this->elections = $aElections;
    $wasSet = true;
    return $wasSet;
  }

  public function getDb_hostname()
  {
    return $this->db_hostname;
  }

  public function getDb_username()
  {
    return $this->db_username;
  }

  public function getDb_password()
  {
    return $this->db_password;
  }

  public function getElections()
  {
    return $this->elections;
  }

  public function getServiceProvidingCycleFullName()
  {
    $answer = $this->getServiceProvidingCycle();
    return $answer;
  }

  public function getServiceProvidingCycle()
  {
    if ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleIdle) { return "ServiceProvidingCycleIdle"; }
    elseif ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleAllElectionsLoaded) { return "ServiceProvidingCycleAllElectionsLoaded"; }
    return null;
  }

  public function getAllElections()
  {
    $wasEventProcessed = false;
    
    $aServiceProvidingCycle = $this->ServiceProvidingCycle;
    if ($aServiceProvidingCycle == self::$ServiceProvidingCycleIdle)
    {
      $this->setServiceProvidingCycle(self::$ServiceProvidingCycleAllElectionsLoaded);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function setServiceProvidingCycle($aServiceProvidingCycle)
  {
    $this->ServiceProvidingCycle = $aServiceProvidingCycle;

    // entry actions and do activities
    if ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleAllElectionsLoaded)
    {
      $this->loadAllElections($this->db_hostname,$this->db_username,$this->db_password);
    }
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  private function loadAllElections($db_hostname,$db_username,$db_password) {
		$isConnected = mysql_connect($db_hostname,$db_username,$db_password);
  		$result = mysql_query("SELECT * FROM elections.election");

		require_once("./domain/Election.php");
		
		$this->elections='{"elections" : [';
		$first=true;
		while($row = mysql_fetch_array($result)) {
			$anElection=new Election($row['id_election'],$row['name'],$row['description']);
			if ($first) {
				$this->elections=$this->elections.$this->jsonSerialize($anElection);
				$first=false;
			} else
				$this->elections=$this->elections.",".$this->jsonSerialize($anElection);
		}
		$this->elections=$this->elections.']}';

		mysql_close($isConnected);
	}
	
	private function jsonSerialize($anElection) {
		return '{"idElection":"'.$anElection->getIdElection().'","name":"'.$anElection->getName().'","description":"'.$anElection->getDescription().'"}';
	}
}
?>