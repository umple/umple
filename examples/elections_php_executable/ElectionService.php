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
  private $electionJSON;
  private $latestResult;

  //ElectionService State Machines
  private static $ServiceProvidingCycleIdle = 1;
  private static $ServiceProvidingCycleAllElectionsLoaded = 2;
  private static $ServiceProvidingCycleCreatingElection = 3;
  private $ServiceProvidingCycle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private function __construct()
  {
    $this->isConnected = NULL;
    $this->elections = NULL;
    $this->electionJSON = NULL;
    $this->latestResult = NULL;
    $this->setServiceProvidingCycle(self::$ServiceProvidingCycleIdle);
    $this->newElection=NULL;
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

  public function setElectionJSON($aElectionJSON)
  {
    $wasSet = false;
    $this->electionJSON = $aElectionJSON;
    $wasSet = true;
    $this->createElection();
    return $wasSet;
  }

  public function setLatestResult($aLatestResult)
  {
    $wasSet = false;
    $this->latestResult = $aLatestResult;
    $wasSet = true;
    return $wasSet;
  }

  public function getIsConnected()
  {
    return $this->isConnected;
  }

  public function getElections()
  {
    $this->getAllElections();
    return $this->elections;
  }

  public function getElectionJSON()
  {
    return $this->electionJSON;
  }

  public function getLatestResult()
  {
    return $this->latestResult;
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
    elseif ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleCreatingElection) { return "ServiceProvidingCycleCreatingElection"; }
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

  public function createElection()
  {
    $wasEventProcessed = false;
    
    $aServiceProvidingCycle = $this->ServiceProvidingCycle;
    if ($aServiceProvidingCycle == self::$ServiceProvidingCycleIdle)
    {
      $this->setServiceProvidingCycle(self::$ServiceProvidingCycleCreatingElection);
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
    elseif ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleCreatingElection)
    {
      $this->addElection();
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
	
	private function addElection() {
		$electionData=json_decode($this->electionJSON);
		if (mysql_query("insert into elections.election (name, description) values ('$electionData->name', '$electionData->description')"))
			$this->latestResult='Successfully added!';
		else
			$this->latestResult=mysql_error();
	}
	
	private function jsonSerialize($anElection) {
		return '{"idElection":"'.$anElection->getIdElection().'","name":"'.$anElection->getName().'","description":"'.$anElection->getDescription().'"}';
	}
}
?>