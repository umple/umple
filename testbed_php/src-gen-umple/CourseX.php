<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.19.0.3287 modeling language!*/

class CourseX
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseX Attributes
  private $logs;

  //CourseX State Machines
  private static $StatusOpen = 1;
  private static $StatusOpenNull = 2;
  private static $StatusOpenWhite = 3;
  private static $StatusOpenGreen = 4;
  private static $StatusOpenBlack = 5;
  private static $StatusOpenGreenNull = 6;
  private static $StatusOpenGreenGreenStatus = 7;
  private static $StatusOpenGreenGreenStatusNull = 8;
  private static $StatusOpenGreenGreenStatusGreenStatusOn = 9;
  private $status;
  private $statusOpen;
  private $statusOpenGreen;
  private $statusOpenGreenGreenStatus;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->logs = array();
    $this->setStatusOpen(self::$StatusOpenNull);
    $this->setStatusOpenGreen(self::$StatusOpenGreenNull);
    $this->setStatusOpenGreenGreenStatus(self::$StatusOpenGreenGreenStatusNull);
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

  public function getStatusFullName()
  {
    $answer = $this->getStatus();
    if ($this->statusOpen != self::$StatusOpenNull) { $answer .= "." . $this->getStatusOpen(); }
    if ($this->statusOpenGreen != self::$StatusOpenGreenNull) { $answer .= "." . $this->getStatusOpenGreen(); }
    if ($this->statusOpenGreenGreenStatus != self::$StatusOpenGreenGreenStatusNull) { $answer .= "." . $this->getStatusOpenGreenGreenStatus(); }
    if ($this->statusOpenGreenGreenStatus != self::$StatusOpenGreenGreenStatusNull) { $answer .= "." . $this->getStatusOpenGreenGreenStatus(); }
    return $answer;
  }

  public function getStatus()
  {
    if ($this->status == self::$StatusOpen) { return "StatusOpen"; }
    return null;
  }

  public function getStatusOpen()
  {
    if ($this->statusOpen == self::$StatusOpenNull) { return "StatusOpenNull"; }
    elseif ($this->statusOpen == self::$StatusOpenWhite) { return "StatusOpenWhite"; }
    elseif ($this->statusOpen == self::$StatusOpenGreen) { return "StatusOpenGreen"; }
    elseif ($this->statusOpen == self::$StatusOpenBlack) { return "StatusOpenBlack"; }
    return null;
  }

  public function getStatusOpenGreen()
  {
    if ($this->statusOpenGreen == self::$StatusOpenGreenNull) { return "StatusOpenGreenNull"; }
    elseif ($this->statusOpenGreen == self::$StatusOpenGreenGreenStatus) { return "StatusOpenGreenGreenStatus"; }
    return null;
  }

  public function getStatusOpenGreenGreenStatus()
  {
    if ($this->statusOpenGreenGreenStatus == self::$StatusOpenGreenGreenStatusNull) { return "StatusOpenGreenGreenStatusNull"; }
    elseif ($this->statusOpenGreenGreenStatus == self::$StatusOpenGreenGreenStatusGreenStatusOn) { return "StatusOpenGreenGreenStatusGreenStatusOn"; }
    return null;
  }

  private function enterOpen()
  {
    $wasEventProcessed = false;
    
    $aStatusOpen = $this->statusOpen;
    $aStatusOpenGreen = $this->statusOpenGreen;
    $aStatusOpenGreenGreenStatus = $this->statusOpenGreenGreenStatus;
    if ($aStatusOpen == self::$StatusOpenNull)
    {
      $this->setStatusOpen(self::$StatusOpenWhite);
      $wasEventProcessed = true;
    }

    
    if ($aStatusOpenGreen == self::$StatusOpenGreenNull)
    {
      $this->setStatusOpenGreen(self::$StatusOpenGreenGreenStatus);
      $wasEventProcessed = true;
    }

    
    if ($aStatusOpenGreenGreenStatus == self::$StatusOpenGreenGreenStatusNull)
    {
      $this->setStatusOpenGreenGreenStatus(self::$StatusOpenGreenGreenStatusGreenStatusOn);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function exitOpen()
  {
    $wasEventProcessed = false;
    
    $aStatusOpen = $this->statusOpen;
    $aStatusOpenGreen = $this->statusOpenGreen;
    $aStatusOpenGreenGreenStatus = $this->statusOpenGreenGreenStatus;
    if ($aStatusOpen == self::$StatusOpenWhite)
    {
      $this->setStatusOpen(self::$StatusOpenNull);
      $wasEventProcessed = true;
    }
    elseif ($aStatusOpen == self::$StatusOpenGreen)
    {
      $this->setStatusOpen(self::$StatusOpenNull);
      $wasEventProcessed = true;
    }
    elseif ($aStatusOpen == self::$StatusOpenBlack)
    {
      $this->setStatusOpen(self::$StatusOpenNull);
      $wasEventProcessed = true;
    }

    
    if ($aStatusOpenGreen == self::$StatusOpenGreenGreenStatus)
    {
      $this->setStatusOpenGreen(self::$StatusOpenGreenNull);
      $wasEventProcessed = true;
    }

    
    if ($aStatusOpenGreenGreenStatus == self::$StatusOpenGreenGreenStatusGreenStatusOn)
    {
      $this->setStatusOpenGreenGreenStatus(self::$StatusOpenGreenGreenStatusNull);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function e()
  {
    $wasEventProcessed = false;
    
    $aStatusOpen = $this->statusOpen;
    if ($aStatusOpen == self::$StatusOpenWhite)
    {
      $this->setStatusOpen(self::$StatusOpenGreen);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function e2()
  {
    $wasEventProcessed = false;
    
    $aStatusOpenGreen = $this->statusOpenGreen;
    if ($aStatusOpenGreen == self::$StatusOpenGreenGreenStatus)
    {
      $this->exitStatusOpenGreen();
      $this->setStatus(self::$StatusOpen);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function check()
  {
    $wasEventProcessed = false;
    
    $aStatusOpenGreenGreenStatus = $this->statusOpenGreenGreenStatus;
    if ($aStatusOpenGreenGreenStatus == self::$StatusOpenGreenGreenStatusGreenStatusOn)
    {
      $this->exitStatusOpenGreen();
      $this->setStatusOpen(self::$StatusOpenWhite);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function exitStatus()
  {
    if ($this->status == self::$StatusOpen)
    {
      $this->exitOpen();
    }
  }

  private function setStatus($aStatus)
  {
    $this->status = $aStatus;

    // entry actions and do activities
    if ($this->status == self::$StatusOpen)
    {
      if ($this->statusOpen == self::$StatusOpenNull) { $this->setStatusOpen(self::$StatusOpenWhite); }
    }
  }

  private function exitStatusOpen()
  {
    if ($this->statusOpen == self::$StatusOpenGreen)
    {
      $this->exitOpen();
    }
  }

  private function setStatusOpen($aStatusOpen)
  {
    $this->statusOpen = $aStatusOpen;
    if ($this->status != self::$StatusOpen && $aStatusOpen != self::$StatusOpenNull) { $this->setStatus(self::$StatusOpen); }

    // entry actions and do activities
    if ($this->statusOpen == self::$StatusOpenWhite)
    {
      addLog("White entry");
    }
    elseif ($this->statusOpen == self::$StatusOpenGreen)
    {
      if ($this->statusOpenGreen == self::$StatusOpenGreenNull) { $this->setStatusOpenGreen(self::$StatusOpenGreenGreenStatus); }
    }
  }

  private function exitStatusOpenGreen()
  {
    if ($this->statusOpenGreen == self::$StatusOpenGreenGreenStatus)
    {
      $this->exitOpen();
    }
  }

  private function setStatusOpenGreen($aStatusOpenGreen)
  {
    $this->statusOpenGreen = $aStatusOpenGreen;
    if ($this->statusOpen != self::$StatusOpenGreen && $aStatusOpenGreen != self::$StatusOpenGreenNull) { $this->setStatusOpen(self::$StatusOpenGreen); }

    // entry actions and do activities
    if ($this->statusOpenGreen == self::$StatusOpenGreenGreenStatus)
    {
      if ($this->statusOpenGreenGreenStatus == self::$StatusOpenGreenGreenStatusNull) { $this->setStatusOpenGreenGreenStatus(self::$StatusOpenGreenGreenStatusGreenStatusOn); }
    }
  }

  private function setStatusOpenGreenGreenStatus($aStatusOpenGreenGreenStatus)
  {
    $this->statusOpenGreenGreenStatus = $aStatusOpenGreenGreenStatus;
    if ($this->statusOpenGreen != self::$StatusOpenGreenGreenStatus && $aStatusOpenGreenGreenStatus != self::$StatusOpenGreenGreenStatusNull) { $this->setStatusOpenGreen(self::$StatusOpenGreenGreenStatus); }

    // entry actions and do activities
    if ($this->statusOpenGreenGreenStatus == self::$StatusOpenGreenGreenStatusGreenStatusOn)
    {
      addLog("GreenStatusOn Entry");
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