<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

class CandidateService
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static $theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CandidateService Attributes
  private $isConnected;
  private $candidates;
  private $candidateJSON;
  private $latestResult;

  //CandidateService State Machines
  private static $ServiceProvidingCycleIdle = 1;
  private static $ServiceProvidingCycleAllCandidatesLoaded = 2;
  private static $ServiceProvidingCycleCreatingCandidate = 3;
  private $ServiceProvidingCycle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private function __construct()
  {
    $this->isConnected = NULL;
    $this->candidates = NULL;
    $this->candidateJSON = NULL;
    $this->latestResult = NULL;
    $this->setServiceProvidingCycle(self::$ServiceProvidingCycleIdle);
    $this->newCandidate=NULL;
  }

  public static function getInstance()
  {
    if(self::$theInstance == null)
    {
      self::$theInstance = new CandidateService();
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

  public function setCandidates($aCandidates)
  {
    $wasSet = false;
    $this->candidates = $aCandidates;
    $wasSet = true;
    return $wasSet;
  }

  public function setCandidateJSON($aCandidateJSON)
  {
    $wasSet = false;
    $this->candidateJSON = $aCandidateJSON;
    $wasSet = true;
    $this->createCandidate();
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

  public function getCandidates()
  {
    $this->getAllCandidates();
    return $this->candidates;
  }

  public function getCandidateJSON()
  {
    return $this->candidateJSON;
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
    elseif ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleAllCandidatesLoaded) { return "ServiceProvidingCycleAllCandidatesLoaded"; }
    elseif ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleCreatingCandidate) { return "ServiceProvidingCycleCreatingCandidate"; }
    return null;
  }

  public function getAllCandidates()
  {
    $wasEventProcessed = false;
    
    $aServiceProvidingCycle = $this->ServiceProvidingCycle;
    if ($aServiceProvidingCycle == self::$ServiceProvidingCycleIdle)
    {
      $this->setServiceProvidingCycle(self::$ServiceProvidingCycleAllCandidatesLoaded);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function createCandidate()
  {
    $wasEventProcessed = false;
    
    $aServiceProvidingCycle = $this->ServiceProvidingCycle;
    if ($aServiceProvidingCycle == self::$ServiceProvidingCycleIdle)
    {
      $this->setServiceProvidingCycle(self::$ServiceProvidingCycleCreatingCandidate);
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
    if ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleAllCandidatesLoaded)
    {
      $this->loadAllCandidates();
    }
    elseif ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleCreatingCandidate)
    {
      $this->addCandidate();
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
  
  private function loadAllCandidates() {
    $result = mysql_query("SELECT * FROM elections.candidate");

    require_once("./domain/Candidate.php");
    
    $this->candidates='{"candidates" : [';
    $first=true;
    while($row = mysql_fetch_array($result)) {
      $aCandidate=new Candidate($row['id_candidate'],$row['name'],$row['address'],$row['telephone']);
      if ($first) {
        $this->candidates=$this->candidates.$this->jsonSerialize($aCandidate);
        $first=false;
      } else
        $this->candidates=$this->candidates.",".$this->jsonSerialize($aCandidate);
    }
    $this->candidates=$this->candidates.']}';

    mysql_close($this->isConnected);
  }
  
  private function addCandidate() {
    $candidateData=json_decode($this->candidateJSON);
    if (mysql_query("insert into elections.candidate (name, address, telephone) values ('$candidateData->name', '$candidateData->address', '$candidateData->telephone')"))
      $this->latestResult='Candidate Successfully Registered!';
    else
      $this->latestResult=mysql_error();
  }
  
  private function jsonSerialize($aCandidate) {
    return '{"idCandidate":"'.$aCandidate->getIdCandidate().'","name":"'.$aCandidate->getName().'","description":"'.$aCandidate->getDescription().'"}';
  }
}
?>