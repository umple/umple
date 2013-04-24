<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

class CourseY
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseY Attributes
  private $logs;

  //CourseY State Machines
  private static $ActiveStateMachineActiveTopLevelState = 1;
  private static $ActiveStateMachineActiveTopLevelStateNull = 2;
  private static $ActiveStateMachineActiveTopLevelStateThread1 = 3;
  private $activeStateMachine;
  private $activeStateMachineActiveTopLevelState;

  //CourseY Do Activity Threads
  private $doActivityActiveStateMachineActiveTopLevelStateThread1Thread = null;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->logs = array();
    $this->setActiveStateMachineActiveTopLevelState(self::$ActiveStateMachineActiveTopLevelStateNull);
    $this->setActiveStateMachine(self::$ActiveStateMachineActiveTopLevelState);
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

  public function getActiveStateMachineFullName()
  {
    $answer = $this->getActiveStateMachine();
    if ($this->activeStateMachineActiveTopLevelState != self::$ActiveStateMachineActiveTopLevelStateNull) { $answer .= "." . $this->getActiveStateMachineActiveTopLevelState(); }
    return $answer;
  }

  public function getActiveStateMachine()
  {
    if ($this->activeStateMachine == self::$ActiveStateMachineActiveTopLevelState) { return "ActiveStateMachineActiveTopLevelState"; }
    return null;
  }

  public function getActiveStateMachineActiveTopLevelState()
  {
    if ($this->activeStateMachineActiveTopLevelState == self::$ActiveStateMachineActiveTopLevelStateNull) { return "ActiveStateMachineActiveTopLevelStateNull"; }
    elseif ($this->activeStateMachineActiveTopLevelState == self::$ActiveStateMachineActiveTopLevelStateThread1) { return "ActiveStateMachineActiveTopLevelStateThread1"; }
    return null;
  }

  private function enterActiveTopLevelState()
  {
    $wasEventProcessed = false;
    
    $aActiveStateMachineActiveTopLevelState = $this->activeStateMachineActiveTopLevelState;
    if ($aActiveStateMachineActiveTopLevelState == self::$ActiveStateMachineActiveTopLevelStateNull)
    {
      $this->setActiveStateMachineActiveTopLevelState(self::$ActiveStateMachineActiveTopLevelStateThread1);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function exitActiveTopLevelState()
  {
    $wasEventProcessed = false;
    
    $aActiveStateMachineActiveTopLevelState = $this->activeStateMachineActiveTopLevelState;
    if ($aActiveStateMachineActiveTopLevelState == self::$ActiveStateMachineActiveTopLevelStateThread1)
    {
      $this->setActiveStateMachineActiveTopLevelState(self::$ActiveStateMachineActiveTopLevelStateNull);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function exitActiveStateMachine()
  {
    if ($this->activeStateMachine == self::$ActiveStateMachineActiveTopLevelState)
    {
      $this->exitActiveTopLevelState();
    }
  }

  private function setActiveStateMachine($aActiveStateMachine)
  {
    $this->activeStateMachine = $aActiveStateMachine;

    // entry actions and do activities
    if ($this->activeStateMachine == self::$ActiveStateMachineActiveTopLevelState)
    {
      if ($this->activeStateMachineActiveTopLevelState == self::$ActiveStateMachineActiveTopLevelStateNull) { $this->setActiveStateMachineActiveTopLevelState(self::$ActiveStateMachineActiveTopLevelStateThread1); }
    }
  }

  private function setActiveStateMachineActiveTopLevelState($aActiveStateMachineActiveTopLevelState)
  {
    $this->activeStateMachineActiveTopLevelState = $aActiveStateMachineActiveTopLevelState;
    if ($this->activeStateMachine != self::$ActiveStateMachineActiveTopLevelState && $aActiveStateMachineActiveTopLevelState != self::$ActiveStateMachineActiveTopLevelStateNull) { $this->setActiveStateMachine(self::$ActiveStateMachineActiveTopLevelState); }

    // entry actions and do activities
    if ($this->activeStateMachineActiveTopLevelState == self::$ActiveStateMachineActiveTopLevelStateThread1)
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