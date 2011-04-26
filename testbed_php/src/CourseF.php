<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.0.352 modeling language!*/

class CourseF
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseF State Machines
  private static $StatusOff = 1;
  private static $StatusOn = 2;
  private static $StatusMotorIdleNull = 3;
  private static $StatusMotorIdleMotorIdle = 4;
  private static $StatusMotorIdleMotorRunning = 5;
  private static $StatusFanIdleNull = 6;
  private static $StatusFanIdleFanIdle = 7;
  private static $StatusFanIdleFanRunning = 8;
  private $status;
  private $statusMotorIdle;
  private $statusFanIdle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->setStatus(self::$StatusOff);
    if ($this->status == null) { $this->setStatus(self::$OffNull); }
    if ($this->status == null) { $this->setStatus(self::$OffNull); }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getStatus()
  {
    if ($this->status == self::$StatusOff) { return "StatusOff"; }
    elseif ($this->status == self::$StatusOn) { return "StatusOn"; }
    return null;
  }

  public function getStatusMotorIdle()
  {
    if ($this->statusMotorIdle == self::$StatusMotorIdleNull) { return "StatusMotorIdleNull"; }
    elseif ($this->statusMotorIdle == self::$StatusMotorIdleMotorIdle) { return "StatusMotorIdleMotorIdle"; }
    elseif ($this->statusMotorIdle == self::$StatusMotorIdleMotorRunning) { return "StatusMotorIdleMotorRunning"; }
    return null;
  }

  public function getStatusFanIdle()
  {
    if ($this->statusFanIdle == self::$StatusFanIdleNull) { return "StatusFanIdleNull"; }
    elseif ($this->statusFanIdle == self::$StatusFanIdleFanIdle) { return "StatusFanIdleFanIdle"; }
    elseif ($this->statusFanIdle == self::$StatusFanIdleFanRunning) { return "StatusFanIdleFanRunning"; }
    return null;
  }

  public function turnOn()
  {
    $wasEventProcessed = false;

    if ($this->status == self::$StatusOff)
    {
      $this->setStatus(self::$StatusOn);
      $wasEventProcessed = true;
    }

    return $wasEventProcessed;
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

  public function enterOn()
  {
    $wasEventProcessed = false;

    if ($this->statusMotorIdle == self::$StatusMotorIdleNull)
    {
      $this->setStatusMotorIdle(self::$StatusMotorIdleMotorIdle);
      $wasEventProcessed = true;
    }

    if ($this->statusFanIdle == self::$StatusFanIdleNull)
    {
      $this->setStatusFanIdle(self::$StatusFanIdleFanIdle);
      $wasEventProcessed = true;
    }

    return $wasEventProcessed;
  }

  public function exitOn()
  {
    $wasEventProcessed = false;

    if ($this->statusMotorIdle == self::$StatusMotorIdleMotorIdle)
    {
      $this->setStatusMotorIdle(self::$StatusMotorIdleNull);
      $wasEventProcessed = true;
    }
    elseif ($this->statusMotorIdle == self::$StatusMotorIdleMotorRunning)
    {
      $this->setStatusMotorIdle(self::$StatusMotorIdleNull);
      $wasEventProcessed = true;
    }

    if ($this->statusFanIdle == self::$StatusFanIdleFanIdle)
    {
      $this->setStatusFanIdle(self::$StatusFanIdleNull);
      $wasEventProcessed = true;
    }
    elseif ($this->statusFanIdle == self::$StatusFanIdleFanRunning)
    {
      $this->setStatusFanIdle(self::$StatusFanIdleNull);
      $wasEventProcessed = true;
    }

    return $wasEventProcessed;
  }

  public function flip()
  {
    $wasEventProcessed = false;

    if ($this->statusMotorIdle == self::$StatusMotorIdleMotorIdle)
    {
      $this->setStatusMotorIdle(self::$StatusMotorIdleMotorRunning);
      $wasEventProcessed = true;
    }
    elseif ($this->statusMotorIdle == self::$StatusMotorIdleMotorRunning)
    {
      $this->setStatusMotorIdle(self::$StatusMotorIdleMotorIdle);
      $wasEventProcessed = true;
    }

    return $wasEventProcessed;
  }

  public function flop()
  {
    $wasEventProcessed = false;

    if ($this->statusFanIdle == self::$StatusFanIdleFanIdle)
    {
      $this->setStatusFanIdle(self::$StatusFanIdleFanRunning);
      $wasEventProcessed = true;
    }
    elseif ($this->statusFanIdle == self::$StatusFanIdleFanRunning)
    {
      $this->setStatusFanIdle(self::$StatusFanIdleFanIdle);
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
      if ($this->statusMotorIdle == self::$StatusMotorIdleNull) { $this->setStatusMotorIdle("StatusMotorIdleMotorIdle"); }
      if ($this->statusFanIdle == self::$StatusFanIdleNull) { $this->setStatusFanIdle("StatusFanIdleFanIdle"); }
    }
  }

  private function setStatusMotorIdle($aStatusMotorIdle)
  {
    $this->statusMotorIdle = $aStatusMotorIdle;
  }

  private function setStatusFanIdle($aStatusFanIdle)
  {
    $this->statusFanIdle = $aStatusFanIdle;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>