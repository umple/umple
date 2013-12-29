<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

class CourseY
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseY Attributes
  private $logs;

  //CourseY State Machines
  private static $StateMachine1TopLevel = 1;
  private static $StateMachine1TopLevelNull = 2;
  private static $StateMachine1TopLevelThread1 = 3;
  private $stateMachine1;
  private $stateMachine1TopLevel;

  //CourseY Do Activity Threads
  private $doActivityStateMachine1TopLevelThread1Thread = null;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->logs = array();
    $this->setStateMachine1TopLevel(self::$StateMachine1TopLevelNull);
    $this->setStateMachine1(self::$StateMachine1TopLevel);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function addLog($aLog)
  {
    $wasAdded = false;
    $this->logs[] = $aLog;
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeLog($aLog)
  {
    $wasRemoved = false;
    unset($this->logs[$this->indexOfLog($aLog)]);
    $this->logs = array_values($this->logs);
    $wasRemoved = true;
    return $wasRemoved;
  }

  public function getLog($index)
  {
    $aLog = $this->logs[$index];
    return $aLog;
  }

  public function getLogs()
  {
    $newLogs = $this->logs;
    return $newLogs;
  }

  public function numberOfLogs()
  {
    $number = count($this->logs);
    return $number;
  }

  public function hasLogs()
  {
    $has = logs.size() > 0;
    return $has;
  }

  public function indexOfLog($aLog)
  {
    $rawAnswer = array_search($aLog,$this->logs);
    $index = $rawAnswer == null && $rawAnswer !== 0 ? -1 : $rawAnswer;
    return $index;
  }

  public function getStateMachine1FullName()
  {
    $answer = $this->getStateMachine1();
    if ($this->stateMachine1TopLevel != self::$StateMachine1TopLevelNull) { $answer .= "." . $this->getStateMachine1TopLevel(); }
    return $answer;
  }

  public function getStateMachine1()
  {
    if ($this->stateMachine1 == self::$StateMachine1TopLevel) { return "StateMachine1TopLevel"; }
    return null;
  }

  public function getStateMachine1TopLevel()
  {
    if ($this->stateMachine1TopLevel == self::$StateMachine1TopLevelNull) { return "StateMachine1TopLevelNull"; }
    elseif ($this->stateMachine1TopLevel == self::$StateMachine1TopLevelThread1) { return "StateMachine1TopLevelThread1"; }
    return null;
  }

  private function enterTopLevel()
  {
    $wasEventProcessed = false;
    
    $aStateMachine1TopLevel = $this->stateMachine1TopLevel;
    if ($aStateMachine1TopLevel == self::$StateMachine1TopLevelNull)
    {
      $this->setStateMachine1TopLevel(self::$StateMachine1TopLevelThread1);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function exitTopLevel()
  {
    $wasEventProcessed = false;
    
    $aStateMachine1TopLevel = $this->stateMachine1TopLevel;
    if ($aStateMachine1TopLevel == self::$StateMachine1TopLevelThread1)
    {
      $this->setStateMachine1TopLevel(self::$StateMachine1TopLevelNull);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function exitStateMachine1()
  {
    if ($this->stateMachine1 == self::$StateMachine1TopLevel)
    {
      $this->exitTopLevel();
    }
  }

  private function setStateMachine1($aStateMachine1)
  {
    $this->stateMachine1 = $aStateMachine1;

    // entry actions and do activities
    if ($this->stateMachine1 == self::$StateMachine1TopLevel)
    {
      if ($this->stateMachine1TopLevel == self::$StateMachine1TopLevelNull) { $this->setStateMachine1TopLevel(self::$StateMachine1TopLevelThread1); }
    }
  }

  private function setStateMachine1TopLevel($aStateMachine1TopLevel)
  {
    $this->stateMachine1TopLevel = $aStateMachine1TopLevel;
    if ($this->stateMachine1 != self::$StateMachine1TopLevel && $aStateMachine1TopLevel != self::$StateMachine1TopLevelNull) { $this->setStateMachine1(self::$StateMachine1TopLevel); }

    // entry actions and do activities
    if ($this->stateMachine1TopLevel == self::$StateMachine1TopLevelThread1)
    {
      addLog("Active entry");
    }
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>