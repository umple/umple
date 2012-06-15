<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

class CourseE
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseE Attributes
  private $logs;

  //CourseE State Machines
  private static $StatusOff = 1;
  private static $StatusSleep = 2;
  private static $StatusOn = 3;
  private static $StatusOnNull = 4;
  private static $StatusOnPlay = 5;
  private static $StatusOnPause = 6;
  private $status;
  private $statusOn;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->logs = array();
    $this->setStatusOn(self::$StatusOnNull);
    $this->setStatus(self::$StatusOff);
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
    if ($this->statusOn != self::$StatusOnNull) { $answer .= "." . $this->getStatusOn(); }
    return $answer;
  }

  public function getStatus()
  {
    if ($this->status == self::$StatusOff) { return "StatusOff"; }
    elseif ($this->status == self::$StatusSleep) { return "StatusSleep"; }
    elseif ($this->status == self::$StatusOn) { return "StatusOn"; }
    return null;
  }

  public function getStatusOn()
  {
    if ($this->statusOn == self::$StatusOnNull) { return "StatusOnNull"; }
    elseif ($this->statusOn == self::$StatusOnPlay) { return "StatusOnPlay"; }
    elseif ($this->statusOn == self::$StatusOnPause) { return "StatusOnPause"; }
    return null;
  }

  public function turnOn()
  {
    $wasEventProcessed = false;
    
    $aStatus = $this->status;
    if ($aStatus == self::$StatusOff)
    {
      $this->exitStatus();
      $this->setStatus(self::$StatusOn);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function turnSleep()
  {
    $wasEventProcessed = false;
    
    $aStatus = $this->status;
    if ($aStatus == self::$StatusOff)
    {
      $this->exitStatus();
      $this->setStatus(self::$StatusSleep);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function wake()
  {
    $wasEventProcessed = false;
    
    $aStatus = $this->status;
    if ($aStatus == self::$StatusSleep)
    {
      $this->exitStatus();
      $this->setStatusOn(self::$StatusOnPause);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function turnOff()
  {
    $wasEventProcessed = false;
    
    $aStatus = $this->status;
    if ($aStatus == self::$StatusOn)
    {
      $this->exitStatus();
      $this->setStatus(self::$StatusOff);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function enterOn()
  {
    $wasEventProcessed = false;
    
    $aStatusOn = $this->statusOn;
    if ($aStatusOn == self::$StatusOnNull)
    {
      $this->setStatusOn(self::$StatusOnPlay);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function exitOn()
  {
    $wasEventProcessed = false;
    
    $aStatusOn = $this->statusOn;
    if ($aStatusOn == self::$StatusOnPlay)
    {
      $this->setStatusOn(self::$StatusOnNull);
      $wasEventProcessed = true;
    }
    elseif ($aStatusOn == self::$StatusOnPause)
    {
      $this->setStatusOn(self::$StatusOnNull);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function push()
  {
    $wasEventProcessed = false;
    
    $aStatusOn = $this->statusOn;
    if ($aStatusOn == self::$StatusOnPlay)
    {
      $this->exitStatusOn();
      $this->setStatusOn(self::$StatusOnPause);
      $wasEventProcessed = true;
    }
    elseif ($aStatusOn == self::$StatusOnPause)
    {
      $this->exitStatusOn();
      $this->setStatusOn(self::$StatusOnPlay);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function standby()
  {
    $wasEventProcessed = false;
    
    $aStatusOn = $this->statusOn;
    if ($aStatusOn == self::$StatusOnPause)
    {
      $this->exitStatusOn();
      $this->setStatus(self::$StatusSleep);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function exitStatus()
  {
    if ($this->status == self::$StatusOff)
    {
      $this->addLog("Exit Off");
    }
    elseif ($this->status == self::$StatusSleep)
    {
      $this->addLog("Exit Sleep");
    }
    elseif ($this->status == self::$StatusOn)
    {
      $this->exitOn();
      $this->addLog("Exit On");
    }
  }

  private function setStatus($aStatus)
  {
    $this->status = $aStatus;

    // entry actions and do activities
    if ($this->status == self::$StatusOff)
    {
      $this->addLog("Enter Off");
    }
    elseif ($this->status == self::$StatusSleep)
    {
      $this->addLog("Enter Sleep");
    }
    elseif ($this->status == self::$StatusOn)
    {
      $this->addLog("Enter On");
      if ($this->statusOn == self::$StatusOnNull) { $this->setStatusOn(self::$StatusOnPlay); }
    }
  }

  private function exitStatusOn()
  {
    if ($this->statusOn == self::$StatusOnPlay)
    {
      $this->addLog("Exit Play");
    }
    elseif ($this->statusOn == self::$StatusOnPause)
    {
      $this->addLog("Exit Pause");
    }
  }

  private function setStatusOn($aStatusOn)
  {
    $this->statusOn = $aStatusOn;
    if ($this->status != self::$StatusOn && $aStatusOn != self::$StatusOnNull) { $this->setStatus(self::$StatusOn); }

    // entry actions and do activities
    if ($this->statusOn == self::$StatusOnPlay)
    {
      $this->addLog("Enter Play");
    }
    elseif ($this->statusOn == self::$StatusOnPause)
    {
      $this->addLog("Enter Pause");
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