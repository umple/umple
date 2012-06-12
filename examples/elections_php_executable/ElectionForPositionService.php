<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1834 modeling language!*/

class ElectionForPositionService
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static $theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ElectionForPositionService Attributes
  private $idElection;
  private $idPosition;
  private $latestResult;
  private $isConnected;
  private $efpJSON;
  private $efpFound;

  //ElectionForPositionService State Machines
  private static $ServiceProvidingCycleIdle = 1;
  private static $ServiceProvidingCycleCreatingElectionForPosition = 2;
  private static $ServiceProvidingCycleFindingElectionForPosition = 3;
  private $ServiceProvidingCycle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private function __construct()
  {
    $this->idElection = 0;
    $this->idPosition = 0;
    $this->latestResult = NULL;
    $this->isConnected = NULL;
    $this->efpJSON = NULL;
    $this->efpFound = NULL;
    $this->setServiceProvidingCycle(self::$ServiceProvidingCycleIdle);
  }

  public static function getInstance()
  {
    if(self::$theInstance == null)
    {
      self::$theInstance = new ElectionForPositionService();
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

  public function setIdPosition($aIdPosition)
  {
    $wasSet = false;
    $this->idPosition = $aIdPosition;
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

  public function setEfpJSON($aEfpJSON)
  {
    $wasSet = false;
    $this->efpJSON = $aEfpJSON;
    $wasSet = true;
    $this->createElectionForPosition();
    return $wasSet;
  }

  public function getIdElection()
  {
    return $this->idElection;
  }

  public function getIdPosition()
  {
    return $this->idPosition;
  }

  public function getLatestResult()
  {
    return $this->latestResult;
  }

  public function getIsConnected()
  {
    return $this->isConnected;
  }

  public function getEfpJSON()
  {
    return $this->efpJSON;
  }

  public function getServiceProvidingCycleFullName()
  {
    $answer = $this->getServiceProvidingCycle();
    return $answer;
  }

  public function getServiceProvidingCycle()
  {
    if ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleIdle) { return "ServiceProvidingCycleIdle"; }
    elseif ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleCreatingElectionForPosition) { return "ServiceProvidingCycleCreatingElectionForPosition"; }
    elseif ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleFindingElectionForPosition) { return "ServiceProvidingCycleFindingElectionForPosition"; }
    return null;
  }

  public function createElectionForPosition()
  {
    $wasEventProcessed = false;
    
    $aServiceProvidingCycle = $this->ServiceProvidingCycle;
    if ($aServiceProvidingCycle == self::$ServiceProvidingCycleIdle)
    {
      $this->setServiceProvidingCycle(self::$ServiceProvidingCycleFindingElectionForPosition);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function __autotransition1__()
  {
    $wasEventProcessed = false;
    
    $aServiceProvidingCycle = $this->ServiceProvidingCycle;
    if ($aServiceProvidingCycle == self::$ServiceProvidingCycleCreatingElectionForPosition)
    {
      $this->setServiceProvidingCycle(self::$ServiceProvidingCycleIdle);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function __autotransition2__()
  {
    $wasEventProcessed = false;
    
    $aServiceProvidingCycle = $this->ServiceProvidingCycle;
    if ($aServiceProvidingCycle == self::$ServiceProvidingCycleFindingElectionForPosition)
    {
      if ($this->efpFound)
      {
        $this->setServiceProvidingCycle(self::$ServiceProvidingCycleIdle);
        $wasEventProcessed = true;
      }
    }
    return $wasEventProcessed;
  }

  private function __autotransition3__()
  {
    $wasEventProcessed = false;
    
    $aServiceProvidingCycle = $this->ServiceProvidingCycle;
    if ($aServiceProvidingCycle == self::$ServiceProvidingCycleFindingElectionForPosition)
    {
      if (!$this->efpFound)
      {
        $this->setServiceProvidingCycle(self::$ServiceProvidingCycleCreatingElectionForPosition);
        $wasEventProcessed = true;
      }
    }
    return $wasEventProcessed;
  }

  private function setServiceProvidingCycle($aServiceProvidingCycle)
  {
    require_once("Credentials.php");
    $this->isConnected = mysql_connect(Credentials::$db_hostname,Credentials::$db_username,Credentials::$db_password);
    $this->ServiceProvidingCycle = $aServiceProvidingCycle;

    // entry actions and do activities
    if ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleCreatingElectionForPosition)
    {
      $this->tryToCreateElectionForPosition();
      $this->__autotransition1__();
    }
    elseif ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleFindingElectionForPosition)
    {
      $this->tryFindingElectionForPosition();
      $this->__autotransition2__();
      $this->__autotransition3__();
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
  
  private function tryToCreateElectionForPosition() {
    $efpData=json_decode($this->efpJSON);
    if (mysql_query("insert into elections.election_for_position (election_id_election, position_id_position) values ('$efpData->election', '$efpData->position')"))
      $this->latestResult='Successfully added!';
    else
      $this->latestResult=mysql_error();
  }
  
  private function tryFindingElectionForPosition() {
    $efpData=json_decode($this->efpJSON);
    $this->efpFound=true;
    $result = mysql_query("SELECT * FROM elections.election_for_position where election_id_election='$efpData->election' and position_id_position='$efpData->position'");
    if (mysql_num_rows($result)==0)
      $this->efpFound=false;
  }
}
?>