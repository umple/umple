<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

class CourseL
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseL Attributes
  private $logs;

  //CourseL State Machines
  private static $StatusOn = 1;
  private static $StatusMotorIdleNull = 2;
  private static $StatusMotorIdleMotorIdle = 3;
  private static $StatusMotorIdleFinal = 4;
  private static $StatusFanIdleNull = 5;
  private static $StatusFanIdleFanIdle = 6;
  private static $StatusFanIdleFinal = 7;
  private $status;
  private $statusMotorIdle;
  private $statusFanIdle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->logs = array();
    $this->setStatusMotorIdle(self::$StatusMotorIdleNull);
    $this->setStatusFanIdle(self::$StatusFanIdleNull);
    $this->setStatus(self::$StatusOn);
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

  public function getStatusFullName()
  {
    $answer = $this->getStatus();
    if ($this->statusMotorIdle != self::$StatusMotorIdleNull) { $answer .= "." . $this->getStatusMotorIdle(); }
    if ($this->statusFanIdle != self::$StatusFanIdleNull) { $answer .= "." . $this->getStatusFanIdle(); }
    return $answer;
  }

  public function getStatus()
  {
    if ($this->status == self::$StatusOn) { return "StatusOn"; }
    return null;
  }

  public function getStatusMotorIdle()
  {
    if ($this->statusMotorIdle == self::$StatusMotorIdleNull) { return "StatusMotorIdleNull"; }
    elseif ($this->statusMotorIdle == self::$StatusMotorIdleMotorIdle) { return "StatusMotorIdleMotorIdle"; }
    elseif ($this->statusMotorIdle == self::$StatusMotorIdleFinal) { return "StatusMotorIdleFinal"; }
    return null;
  }

  public function getStatusFanIdle()
  {
    if ($this->statusFanIdle == self::$StatusFanIdleNull) { return "StatusFanIdleNull"; }
    elseif ($this->statusFanIdle == self::$StatusFanIdleFanIdle) { return "StatusFanIdleFanIdle"; }
    elseif ($this->statusFanIdle == self::$StatusFanIdleFinal) { return "StatusFanIdleFinal"; }
    return null;
  }

  private function enterOn()
  {
    $wasEventProcessed = false;
    
    $aStatusMotorIdle = $this->statusMotorIdle;
    $aStatusFanIdle = $this->statusFanIdle;
    if ($aStatusMotorIdle == self::$StatusMotorIdleNull)
    {
      $this->setStatusMotorIdle(self::$StatusMotorIdleMotorIdle);
      $wasEventProcessed = true;
    }

    
    if ($aStatusFanIdle == self::$StatusFanIdleNull)
    {
      $this->setStatusFanIdle(self::$StatusFanIdleFanIdle);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function exitOn()
  {
    $wasEventProcessed = false;
    
    $aStatusMotorIdle = $this->statusMotorIdle;
    $aStatusFanIdle = $this->statusFanIdle;
    if ($aStatusMotorIdle == self::$StatusMotorIdleMotorIdle)
    {
      $this->setStatusMotorIdle(self::$StatusMotorIdleNull);
      $wasEventProcessed = true;
    }
    elseif ($aStatusMotorIdle == self::$StatusMotorIdleFinal)
    {
      $this->setStatusMotorIdle(self::$StatusMotorIdleNull);
      $wasEventProcessed = true;
    }

    
    if ($aStatusFanIdle == self::$StatusFanIdleFanIdle)
    {
      $this->setStatusFanIdle(self::$StatusFanIdleNull);
      $wasEventProcessed = true;
    }
    elseif ($aStatusFanIdle == self::$StatusFanIdleFinal)
    {
      $this->setStatusFanIdle(self::$StatusFanIdleNull);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function flip()
  {
    $wasEventProcessed = false;
    
    $aStatusMotorIdle = $this->statusMotorIdle;
    if ($aStatusMotorIdle == self::$StatusMotorIdleMotorIdle)
    {
      $this->setStatusMotorIdle(self::$StatusMotorIdleFinal);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function flop()
  {
    $wasEventProcessed = false;
    
    $aStatusFanIdle = $this->statusFanIdle;
    if ($aStatusFanIdle == self::$StatusFanIdleFanIdle)
    {
      $this->setStatusFanIdle(self::$StatusFanIdleFinal);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function exitStatus()
  {
    if ($this->status == self::$StatusOn)
    {
      $this->exitOn();
    }
  }

  private function setStatus($aStatus)
  {
    $this->status = $aStatus;

    // entry actions and do activities
    if ($this->status == self::$StatusOn)
    {
      if ($this->statusMotorIdle == self::$StatusMotorIdleNull) { $this->setStatusMotorIdle(self::$StatusMotorIdleMotorIdle); }
      if ($this->statusFanIdle == self::$StatusFanIdleNull) { $this->setStatusFanIdle(self::$StatusFanIdleFanIdle); }
    }
  }

  private function setStatusMotorIdle($aStatusMotorIdle)
  {
    $this->statusMotorIdle = $aStatusMotorIdle;
    if ($this->status != self::$StatusOn && $aStatusMotorIdle != self::$StatusMotorIdleNull) { $this->setStatus(self::$StatusOn); }

    // entry actions and do activities
    if ($this->statusMotorIdle == self::$StatusMotorIdleFinal)
    {
      $this->delete();
    }
  }

  private function setStatusFanIdle($aStatusFanIdle)
  {
    $this->statusFanIdle = $aStatusFanIdle;
    if ($this->status != self::$StatusOn && $aStatusFanIdle != self::$StatusFanIdleNull) { $this->setStatus(self::$StatusOn); }

    // entry actions and do activities
    if ($this->statusFanIdle == self::$StatusFanIdleFinal)
    {
      $this->delete();
    }
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    // line 124 "../../../../src/TestHarnessStateMachinePhp.ump"
    $this->addLog("deleted");
  }

}
?>