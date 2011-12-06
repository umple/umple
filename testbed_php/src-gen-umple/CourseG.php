<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

class CourseG
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseG State Machines
  private static $StatusOn = 1;
  private static $StatusOff = 2;
  private static $StatusOnNull = 3;
  private static $StatusOnIdle = 4;
  private static $StatusOnRunning = 5;
  private $status;
  private $statusOn;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->setStatus(self::$StatusOn);
    if ($this->status == null) { $this->setStatus(self::$OnNull); }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getStatus()
  {
    if ($this->status == self::$StatusOn) { return "StatusOn"; }
    elseif ($this->status == self::$StatusOff) { return "StatusOff"; }
    return null;
  }

  public function getStatusOn()
  {
    if ($this->statusOn == self::$StatusOnNull) { return "StatusOnNull"; }
    elseif ($this->statusOn == self::$StatusOnIdle) { return "StatusOnIdle"; }
    elseif ($this->statusOn == self::$StatusOnRunning) { return "StatusOnRunning"; }
    return null;
  }

  public function turnOff()
  {
    $wasEventProcessed = false;

    if ($this->status == self::$StatusOn)
    {
      $this->exitStatus();
      $this->setStatus(self::$StatusOff);
      $wasEventProcessed = true;
    }

    return $wasEventProcessed;
  }

  public function flip()
  {
    $wasEventProcessed = false;

    if ($this->status == self::$StatusOff)
    {
      $this->setStatus(self::$StatusOnIdle);
      $wasEventProcessed = true;
    }

    if ($this->statusOn == self::$StatusOnIdle)
    {
      $this->setStatusOn(self::$StatusOnRunning);
      $wasEventProcessed = true;
    }

    return $wasEventProcessed;
  }

  public function enterOn()
  {
    $wasEventProcessed = false;

    if ($this->statusOn == self::$StatusOnNull)
    {
      $this->setStatusOn(self::$StatusOnIdle);
      $wasEventProcessed = true;
    }

    return $wasEventProcessed;
  }

  public function exitOn()
  {
    $wasEventProcessed = false;

    if ($this->statusOn == self::$StatusOnIdle)
    {
      $this->setStatusOn(self::$StatusOnNull);
      $wasEventProcessed = true;
    }
    elseif ($this->statusOn == self::$StatusOnRunning)
    {
      $this->setStatusOn(self::$StatusOnNull);
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
      if ($this->statusOn == self::$StatusOnNull) { $this->setStatusOn("StatusOnIdle"); }
    }
  }

  private function setStatusOn($aStatusOn)
  {
    $this->statusOn = $aStatusOn;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>