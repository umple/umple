<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

class CourseI
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseI State Machines
  private static $StatusOn = 1;
  private static $StatusOff = 2;
  private static $StatusOnNull = 3;
  private static $StatusOnRunning = 4;
  private static $StatusOnRunningNull = 5;
  private static $StatusOnRunningPlay = 6;
  private static $StatusOffNull = 7;
  private static $StatusOffIdle = 8;
  private static $StatusOffFull = 9;
  private $status;
  private $statusOn;
  private $statusOnRunning;
  private $statusOff;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->setStatusOn(self::$StatusOnNull);
    $this->setStatusOnRunning(self::$StatusOnRunningNull);
    $this->setStatusOff(self::$StatusOffNull);
    $this->setStatus(self::$StatusOn);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getStatusFullName()
  {
    $answer = $this->getStatus();
    if ($this->statusOn != self::$StatusOnNull) { $answer .= "." . $this->getStatusOn(); }
    if ($this->statusOnRunning != self::$StatusOnRunningNull) { $answer .= "." . $this->getStatusOnRunning(); }
    if ($this->statusOff != self::$StatusOffNull) { $answer .= "." . $this->getStatusOff(); }
    return $answer;
  }

  public function getStatus()
  {
    if ($this->status == self::$StatusOn) { return "StatusOn"; }
    elseif ($this->status == self::$StatusOff) { return "StatusOff"; }
    return null;
  }

  public function getStatusOn()
  {
    if ($this->statusOn == self::$StatusOnNull) { return "StatusOnNull"; }
    elseif ($this->statusOn == self::$StatusOnRunning) { return "StatusOnRunning"; }
    return null;
  }

  public function getStatusOnRunning()
  {
    if ($this->statusOnRunning == self::$StatusOnRunningNull) { return "StatusOnRunningNull"; }
    elseif ($this->statusOnRunning == self::$StatusOnRunningPlay) { return "StatusOnRunningPlay"; }
    return null;
  }

  public function getStatusOff()
  {
    if ($this->statusOff == self::$StatusOffNull) { return "StatusOffNull"; }
    elseif ($this->statusOff == self::$StatusOffIdle) { return "StatusOffIdle"; }
    elseif ($this->statusOff == self::$StatusOffFull) { return "StatusOffFull"; }
    return null;
  }

  public function flip()
  {
    $wasEventProcessed = false;
    
    $aStatus = $this->status;
    $aStatusOn = $this->statusOn;
    $aStatusOnRunning = $this->statusOnRunning;
    $aStatusOff = $this->statusOff;
    if ($aStatus == self::$StatusOn)
    {
      $this->exitStatus();
      $this->setStatus(self::$StatusOff);
      $wasEventProcessed = true;
    }
    elseif ($aStatus == self::$StatusOff)
    {
      $this->exitStatus();
      $this->setStatus(self::$StatusOn);
      $wasEventProcessed = true;
    }

    
    if ($aStatusOn == self::$StatusOnRunning)
    {
      $this->exitStatusOn();
      $this->setStatusOff(self::$StatusOffIdle);
      $wasEventProcessed = true;
    }

    
    if ($aStatusOnRunning == self::$StatusOnRunningPlay)
    {
      $this->setStatusOff(self::$StatusOffFull);
      $wasEventProcessed = true;
    }

    
    if ($aStatusOff == self::$StatusOffIdle)
    {
      $this->setStatusOn(self::$StatusOnRunning);
      $wasEventProcessed = true;
    }
    elseif ($aStatusOff == self::$StatusOffFull)
    {
      $this->setStatusOnRunning(self::$StatusOnRunningPlay);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function enterOn()
  {
    $wasEventProcessed = false;
    
    $aStatusOn = $this->statusOn;
    if ($aStatusOn == self::$StatusOnNull)
    {
      $this->setStatusOn(self::$StatusOnRunning);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function exitOn()
  {
    $wasEventProcessed = false;
    
    $aStatusOn = $this->statusOn;
    if ($aStatusOn == self::$StatusOnRunning)
    {
      $this->exitStatusOn();
      $this->setStatusOn(self::$StatusOnNull);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function enterRunning()
  {
    $wasEventProcessed = false;
    
    $aStatusOnRunning = $this->statusOnRunning;
    if ($aStatusOnRunning == self::$StatusOnRunningNull)
    {
      $this->setStatusOnRunning(self::$StatusOnRunningPlay);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function exitRunning()
  {
    $wasEventProcessed = false;
    
    $aStatusOnRunning = $this->statusOnRunning;
    if ($aStatusOnRunning == self::$StatusOnRunningPlay)
    {
      $this->setStatusOnRunning(self::$StatusOnRunningNull);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function enterOff()
  {
    $wasEventProcessed = false;
    
    $aStatusOff = $this->statusOff;
    if ($aStatusOff == self::$StatusOffNull)
    {
      $this->setStatusOff(self::$StatusOffIdle);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function exitOff()
  {
    $wasEventProcessed = false;
    
    $aStatusOff = $this->statusOff;
    if ($aStatusOff == self::$StatusOffIdle)
    {
      $this->setStatusOff(self::$StatusOffNull);
      $wasEventProcessed = true;
    }
    elseif ($aStatusOff == self::$StatusOffFull)
    {
      $this->setStatusOff(self::$StatusOffNull);
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
    elseif ($this->status == self::$StatusOff)
    {
      $this->exitOff();
    }
  }

  private function setStatus($aStatus)
  {
    $this->status = $aStatus;

    // entry actions and do activities
    if ($this->status == self::$StatusOn)
    {
      if ($this->statusOn == self::$StatusOnNull) { $this->setStatusOn(self::$StatusOnRunning); }
    }
    elseif ($this->status == self::$StatusOff)
    {
      if ($this->statusOff == self::$StatusOffNull) { $this->setStatusOff(self::$StatusOffIdle); }
    }
  }

  private function exitStatusOn()
  {
    if ($this->statusOn == self::$StatusOnRunning)
    {
      $this->exitRunning();
    }
  }

  private function setStatusOn($aStatusOn)
  {
    $this->statusOn = $aStatusOn;
    if ($this->status != self::$StatusOn && $aStatusOn != self::$StatusOnNull) { $this->setStatus(self::$StatusOn); }

    // entry actions and do activities
    if ($this->statusOn == self::$StatusOnRunning)
    {
      if ($this->statusOnRunning == self::$StatusOnRunningNull) { $this->setStatusOnRunning(self::$StatusOnRunningPlay); }
    }
  }

  private function setStatusOnRunning($aStatusOnRunning)
  {
    $this->statusOnRunning = $aStatusOnRunning;
    if ($this->statusOn != self::$StatusOnRunning && $aStatusOnRunning != self::$StatusOnRunningNull) { $this->setStatusOn(self::$StatusOnRunning); }
  }

  private function setStatusOff($aStatusOff)
  {
    $this->statusOff = $aStatusOff;
    if ($this->status != self::$StatusOff && $aStatusOff != self::$StatusOffNull) { $this->setStatus(self::$StatusOff); }
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>