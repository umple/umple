<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

class PositionService
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static $theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PositionService Attributes
  private $isConnected;
  private $positions;
  private $positionJSON;
  private $latestResult;

  //PositionService State Machines
  private static $ServiceProvidingCycleIdle = 1;
  private static $ServiceProvidingCycleAllPositionsLoaded = 2;
  private static $ServiceProvidingCycleCreatingPosition = 3;
  private $ServiceProvidingCycle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private function __construct()
  {
    $this->isConnected = NULL;
    $this->positions = NULL;
    $this->positionJSON = NULL;
    $this->latestResult = NULL;
    $this->setServiceProvidingCycle(self::$ServiceProvidingCycleIdle);
    $this->newPosition=NULL;
  }

  public static function getInstance()
  {
    if(self::$theInstance == null)
    {
      self::$theInstance = new PositionService();
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

  public function setPositions($aPositions)
  {
    $wasSet = false;
    $this->positions = $aPositions;
    $wasSet = true;
    return $wasSet;
  }

  public function setPositionJSON($aPositionJSON)
  {
    $wasSet = false;
    $this->positionJSON = $aPositionJSON;
    $wasSet = true;
    $this->createPosition();
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

  public function getPositions()
  {
    $this->getAllPositions();
    return $this->positions;
  }

  public function getPositionJSON()
  {
    return $this->positionJSON;
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
    elseif ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleAllPositionsLoaded) { return "ServiceProvidingCycleAllPositionsLoaded"; }
    elseif ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleCreatingPosition) { return "ServiceProvidingCycleCreatingPosition"; }
    return null;
  }

  public function getAllPositions()
  {
    $wasEventProcessed = false;
    
    $aServiceProvidingCycle = $this->ServiceProvidingCycle;
    if ($aServiceProvidingCycle == self::$ServiceProvidingCycleIdle)
    {
      $this->setServiceProvidingCycle(self::$ServiceProvidingCycleAllPositionsLoaded);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function createPosition()
  {
    $wasEventProcessed = false;
    
    $aServiceProvidingCycle = $this->ServiceProvidingCycle;
    if ($aServiceProvidingCycle == self::$ServiceProvidingCycleIdle)
    {
      $this->setServiceProvidingCycle(self::$ServiceProvidingCycleCreatingPosition);
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
    if ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleAllPositionsLoaded)
    {
      $this->loadAllPositions();
    }
    elseif ($this->ServiceProvidingCycle == self::$ServiceProvidingCycleCreatingPosition)
    {
      $this->addPosition();
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
  
  private function addPosition() {
    $positionData=json_decode($this->positionJSON);
    if (mysql_query("insert into elections.position (name, description) values ('$positionData->name', '$positionData->description')"))
      $this->latestResult='Successfully added!';
    else
      $this->latestResult=mysql_error();
  }
  
  private function loadAllPositions() {
      $result = mysql_query("SELECT * FROM elections.position");

    require_once("./domain/Position.php");
    
    $this->positions='{"positions" : [';
    $first=true;
    while($row = mysql_fetch_array($result)) {
      $anPosition=new Position($row['id_position'],$row['name'],$row['description']);
      if ($first) {
        $this->positions=$this->positions.$this->jsonSerialize($anPosition);
        $first=false;
      } else
        $this->positions=$this->positions.",".$this->jsonSerialize($anPosition);
    }
    $this->positions=$this->positions.']}';

    mysql_close($this->isConnected);
  }
    
  private function jsonSerialize($anPosition) {
    return '{"idPosition":"'.$anPosition->getIdPosition().'","name":"'.$anPosition->getName().'","description":"'.$anPosition->getDescription().'"}';
  }
}
?>