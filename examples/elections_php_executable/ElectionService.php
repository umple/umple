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
  private $isConnected;
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
    $this->isConnected = NULL;
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

  public function setIsConnected($aIsConnected)
  {
    $wasSet = false;
    $this->isConnected = $aIsConnected;
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

  public function getIsConnected()
  {
    return $this->isConnected;
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
    require_once("Credentials.php");
		$this->isConnected = mysql_connect(Credentials::$db_hostname,Credentials::$db_username,Credentials::$db_password);
    $this->ServiceProvidingCycle = $aServiceProvidingCycle;

    // entry actions and do activities
    if ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleAllElectionsLoaded)
    {
      $this->loadAllElections();
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
  
  private function loadAllElections() {
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

		mysql_close($this->isConnected);
	}
	
	private function jsonSerialize($anElection) {
		return '{"idElection":"'.$anElection->getIdElection().'","name":"'.$anElection->getName().'","description":"'.$anElection->getDescription().'"}';
	}
}
?>