<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

class TraceStm
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TraceStm Attributes
  private $log;

  //TraceStm State Machines
  private static $StatusOpen = 1;
  private static $StatusClose = 2;
  private static $StatusHalfOpen = 3;
  private static $StatusHalfClose = 4;
  private $status;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->log = "initial value";
    $this->setStatus(self::$StatusOpen);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setLog($aLog)
  {
    $wasSet = false;
    $this->log = $aLog;
    $wasSet = true;
    return $wasSet;
  }

  public function getLog()
  {
    return $this->log;
  }

  public function getStatusFullName()
  {
    $answer = $this->getStatus();
    return $answer;
  }

  public function getStatus()
  {
    if ($this->status == self::$StatusOpen) { return "StatusOpen"; }
    elseif ($this->status == self::$StatusClose) { return "StatusClose"; }
    elseif ($this->status == self::$StatusHalfOpen) { return "StatusHalfOpen"; }
    elseif ($this->status == self::$StatusHalfClose) { return "StatusHalfClose"; }
    return null;
  }

  public function ev1()
  {
    $wasEventProcessed = false;
    
    $aStatus = $this->status;
    print("Event=ev1");
    
    print("Event=ev1");
    
    print("Event=ev1");
    
    if ($aStatus == self::$StatusOpen)
    {
      $this->exitStatus();
      $this->setStatus(self::$StatusClose);
      $wasEventProcessed = true;
    }
    elseif ($aStatus == self::$StatusClose)
    {
      $this->exitStatus();
      $this->setStatus(self::$StatusOpen);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function ev2()
  {
    $wasEventProcessed = false;
    
    $aStatus = $this->status;
    print("Event=ev2");
    
    print("Event=ev2");
    
    print("Event=ev2");
    
    if ($aStatus == self::$StatusHalfOpen)
    {
      $this->setStatus(self::$StatusHalfClose);
      $wasEventProcessed = true;
    }
    elseif ($aStatus == self::$StatusHalfClose)
    {
      $this->setStatus(self::$StatusHalfOpen);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function exitStatus()
  {
    if ($this->status == self::$StatusOpen)
    {
      log = "exit called";
    }
    elseif ($this->status == self::$StatusClose)
    {
      log = "exit called";
    }
  }

  private function setStatus($aStatus)
  {
    $this->status = $aStatus;

    // entry actions and do activities
    if ($this->status == self::$StatusOpen)
    {
      print("Tracing state StatusOpen entry action(s)");
      log = "entry called";
    }
    elseif ($this->status == self::$StatusClose)
    {
      log = "Close entry called";
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