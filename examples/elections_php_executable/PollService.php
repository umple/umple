<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

class PollService
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static $theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PollService Attributes
  private $idElection;
  private $idpoll;
  private $allPolls;
  private $latestResult;
  private $isConnected;
  private $pollJSON;

  //PollService State Machines
  private static $ServiceProvidingCycleIdle = 1;
  private static $ServiceProvidingCycleLoadingElectionPolls = 2;
  private static $ServiceProvidingCycleOpeningPoll = 3;
  private static $ServiceProvidingCycleCreatingPoll = 4;
  private $ServiceProvidingCycle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private function __construct()
  {
    $this->idElection = 0;
    $this->idpoll = 0;
    $this->allPolls = NULL;
    $this->latestResult = NULL;
    $this->isConnected = NULL;
    $this->pollJSON = NULL;
    $this->setServiceProvidingCycle(self::$ServiceProvidingCycleIdle);
  }

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

  public function setIdElection($aIdElection)
  {
    $wasSet = false;
    $this->idElection = $aIdElection;
    $wasSet = true;
    return $wasSet;
  }

  public function setIdpoll($aIdpoll)
  {
    $wasSet = false;
    $this->idpoll = $aIdpoll;
    $wasSet = true;
    return $wasSet;
  }

  public function setAllPolls($aAllPolls)
  {
    $wasSet = false;
    $this->allPolls = $aAllPolls;
    $wasSet = true;
    return $wasSet;
  }

  public function setLatestResult($aLatestResult)
  {
    $wasSet = false;
    $this->latestResult = $aLatestResult;
    $wasSet = true;
    return $wasSet;
  }

  public function setIsConnected($aIsConnected)
  {
    $wasSet = false;
    $this->isConnected = $aIsConnected;
    $wasSet = true;
    return $wasSet;
  }

  public function setPollJSON($aPollJSON)
  {
    $wasSet = false;
    $this->pollJSON = $aPollJSON;
    $wasSet = true;
    $this->createPoll();
    return $wasSet;
  }

  public function getIdElection()
  {
    return $this->idElection;
  }

  public function getIdpoll()
  {
    return $this->idpoll;
  }

  public function getAllPolls()
  {
    return $this->allPolls;
  }

  public function getLatestResult()
  {
    return $this->latestResult;
  }

  public function getIsConnected()
  {
    return $this->isConnected;
  }

  public function getPollJSON()
  {
    return $this->pollJSON;
  }

  public function getServiceProvidingCycleFullName()
  {
    $answer = $this->getServiceProvidingCycle();
    return $answer;
  }

  public function getServiceProvidingCycle()
  {
    if ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleIdle) { return "ServiceProvidingCycleIdle"; }
    elseif ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleLoadingElectionPolls) { return "ServiceProvidingCycleLoadingElectionPolls"; }
    elseif ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleOpeningPoll) { return "ServiceProvidingCycleOpeningPoll"; }
    elseif ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleCreatingPoll) { return "ServiceProvidingCycleCreatingPoll"; }
    return null;
  }

  public function getElectionPolls()
  {
    $wasEventProcessed = false;
    
    $aServiceProvidingCycle = $this->ServiceProvidingCycle;
    if ($aServiceProvidingCycle == self::$ServiceProvidingCycleIdle)
    {
      $this->setServiceProvidingCycle(self::$ServiceProvidingCycleLoadingElectionPolls);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function openPoll()
  {
    $wasEventProcessed = false;
    
    $aServiceProvidingCycle = $this->ServiceProvidingCycle;
    if ($aServiceProvidingCycle == self::$ServiceProvidingCycleIdle)
    {
      $this->setServiceProvidingCycle(self::$ServiceProvidingCycleOpeningPoll);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function createPoll()
  {
    $wasEventProcessed = false;
    
    $aServiceProvidingCycle = $this->ServiceProvidingCycle;
    if ($aServiceProvidingCycle == self::$ServiceProvidingCycleIdle)
    {
      $this->setServiceProvidingCycle(self::$ServiceProvidingCycleCreatingPoll);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function __autotransition244__()
  {
    $wasEventProcessed = false;
    
    $aServiceProvidingCycle = $this->ServiceProvidingCycle;
    if ($aServiceProvidingCycle == self::$ServiceProvidingCycleLoadingElectionPolls)
    {
      $this->setServiceProvidingCycle(self::$ServiceProvidingCycleIdle);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function __autotransition245__()
  {
    $wasEventProcessed = false;
    
    $aServiceProvidingCycle = $this->ServiceProvidingCycle;
    if ($aServiceProvidingCycle == self::$ServiceProvidingCycleOpeningPoll)
    {
      $this->setServiceProvidingCycle(self::$ServiceProvidingCycleIdle);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function __autotransition246__()
  {
    $wasEventProcessed = false;
    
    $aServiceProvidingCycle = $this->ServiceProvidingCycle;
    if ($aServiceProvidingCycle == self::$ServiceProvidingCycleCreatingPoll)
    {
      $this->setServiceProvidingCycle(self::$ServiceProvidingCycleIdle);
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
    if ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleLoadingElectionPolls)
    {
      $this->loadElectionPolls($this->idElection);
    }
    elseif ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleOpeningPoll)
    {
      $this->tryToOpenPoll($this->idpoll);
    }
    elseif ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleCreatingPoll)
    {
      $this->tryToCreatePoll();
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
  
  private function loadElectionPolls($idElection) {
		$result = mysql_query("SELECT * FROM elections.election where id_election=$idElection");

		require_once("./domain/Election.php");
		$anElection=null;
		
		while($row = mysql_fetch_array($result)) {
			$anElection=new Election($row['id_election'],$row['name'],$row['description']);
		}
		
  		$result = mysql_query("SELECT * FROM elections.poll where election_id_election=$idElection");

		require_once("./domain/Poll.php");
		
		$this->allPolls='{"polls" : [';
		$first=true;
		while($row = mysql_fetch_array($result)) {
			$aPoll=new Poll($row['id_poll'],$row['name'],$row['description'],$anElection);
			if ($first) {
				$this->allPolls=$this->allPolls.$this->jsonSerialize($aPoll);
				$first=false;
			} else
				$this->allPolls=$this->allPolls.",".$this->jsonSerialize($aPoll);
		}
		$this->allPolls=$this->allPolls.']}';
	}
	
	private function tryToOpenPoll($idpoll) {
		$wasUpdated=false;
		if ($this->isConnected) {
			$wasUpdated = mysql_query("update elections.poll set status='open' where id_poll=$idpoll");
		}
		
		if ($this->isConnected && $wasUpdated)
			$this->latestResult='Poll open!';
		else
			$this->latestResult='An error occured!';
	}
	
		
	private function tryToCreatePoll() {
		$pollData=json_decode($this->pollJSON);
		if (mysql_query("insert into elections.poll (election_id_election, name, description) values ('$pollData->election', '$pollData->name', '$pollData->description')"))
			$this->latestResult='Successfully added!';
		else
			$this->latestResult=mysql_error();
	}
	
	private function jsonSerialize($aPoll) {
		return '{"idpoll":"'.$aPoll->getIdPoll().'","name":"'.$aPoll->getName().'","description":"'.$aPoll->getDescription().'","theElection":"'.$aPoll->getElection()->getIdElection().'"}';
	}
}
?>