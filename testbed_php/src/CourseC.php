<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.0.352 modeling language!*/

class CourseC
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseC Attributes
  private $logs;

  //CourseC State Machines
  private $status;

  // status constants
  private static $StatusOpen = 1;
  private static $StatusClosed = 2;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->logs = array();
    $this->setStatus(self::$StatusOpen);
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

  public function getStatus()
  {
    if ($this->status == self::$StatusOpen) { return "StatusOpen"; }
    elseif ($this->status == self::$StatusClosed) { return "StatusClosed"; }
    return null;
  }

  public function flip()
  {
    $wasEventProcessed = false;

    if ($this->status == self::$StatusOpen)
    {
      $this->setStatus(self::$StatusClosed);
      $wasEventProcessed = true;
    }
    elseif ($this->status == self::$StatusClosed)
    {
      $this->setStatus(self::$StatusOpen);
      $wasEventProcessed = true;
    }

    return $wasEventProcessed;
  }

  private function setStatus($aStatus)
  {
    $this->status = $aStatus;

    // entry actions and do activities
    if ($this->status == self::$StatusOpen)
    {
      $this->addLog("Open Entry");
      usleep(400000);
        $this->addLog("Do Activity On Open");
    }
    elseif ($this->status == self::$StatusClosed)
    {
      $this->addLog("Closed Entry");
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