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
  private $db_hostname;
  private $db_username;
  private $db_password;
  private $idElection;
  private $idpoll;
  private $allPolls;
  private $latestResult;

  //PollService State Machines
  private static $ServiceProvidingCycleIdle = 1;
  private static $ServiceProvidingCycleElectionPollsLoaded = 2;
  private static $ServiceProvidingCyclePollOpened = 3;
  private $ServiceProvidingCycle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private function __construct()
  {
    $this->db_hostname = NULL;
    $this->db_username = NULL;
    $this->db_password = NULL;
    $this->idElection = 0;
    $this->idpoll = 0;
    $this->allPolls = NULL;
    $this->latestResult = NULL;
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

  public function getServiceProvidingCycleFullName()
  {
    $answer = $this->getServiceProvidingCycle();
    return $answer;
  }

  public function getServiceProvidingCycle()
  {
    if ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleIdle) { return "ServiceProvidingCycleIdle"; }
    elseif ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleElectionPollsLoaded) { return "ServiceProvidingCycleElectionPollsLoaded"; }
    elseif ($this->ServiceProvidingCycle == self::$ServiceProvidingCyclePollOpened) { return "ServiceProvidingCyclePollOpened"; }
    return null;
  }

  public function getElectionPolls()
  {
    $wasEventProcessed = false;
    
    $aServiceProvidingCycle = $this->ServiceProvidingCycle;
    if ($aServiceProvidingCycle == self::$ServiceProvidingCycleIdle)
    {
      $this->setServiceProvidingCycle(self::$ServiceProvidingCycleElectionPollsLoaded);
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
      $this->setServiceProvidingCycle(self::$ServiceProvidingCyclePollOpened);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function setServiceProvidingCycle($aServiceProvidingCycle)
  {
    $this->ServiceProvidingCycle = $aServiceProvidingCycle;

    // entry actions and do activities
    if ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleElectionPollsLoaded)
    {
      $this->loadElectionPolls($this->db_hostname,$this->db_username,$this->db_password,$this->idElection);
    }
    elseif ($this->ServiceProvidingCycle == self::$ServiceProvidingCyclePollOpened)
    {
      $this->tryToOpenPoll($this->db_hostname,$this->db_username,$this->db_password,$this->idpoll);
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
  
  public function loadElectionPolls($db_hostname,$db_username,$db_password,$idElection) {
		$isConnected = mysql_connect($db_hostname,$db_username,$db_password);
		
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

		mysql_close($isConnected);
	}
	
	public function tryToOpenPoll($db_hostname,$db_username,$db_password,$idpoll) {
		$isConnected = mysql_connect($db_hostname,$db_username,$db_password);
		
		$wasUpdated=false;
		if ($isConnected) {
			$wasUpdated = mysql_query("update elections.poll set status='open' where id_poll=$idpoll");
		}
		
		if ($isConnected && $wasUpdated)
			$this->latestResult='Poll open!';
		else
			$this->latestResult='An error occured!';
	}
	
	private function jsonSerialize($aPoll) {
		return '{"idpoll":"'.$aPoll->getIdPoll().'","name":"'.$aPoll->getName().'","description":"'.$aPoll->getDescription().'","theElection":"'.$aPoll->getElection()->getIdElection().'"}';
	}
}
?>