<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.${svn.Revision} modeling language!*/

class CourseB
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseB Attributes
  private $log;

  //CourseB State Machines
  private static $StatusOpen = 1;
  private static $StatusClosed = 2;
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
    elseif ($this->status == self::$StatusClosed) { return "StatusClosed"; }
    return null;
  }

  public function anEvent()
  {
    $wasEventProcessed = false;
    
    $aStatus = $this->status;
    if ($aStatus == self::$StatusOpen)
    {
      $this->exitStatus();
      $this->setStatus(self::$StatusClosed);
      $wasEventProcessed = true;
    }
    elseif ($aStatus == self::$StatusClosed)
    {
      $this->setStatus(self::$StatusOpen);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function exitStatus()
  {
    if ($this->status == self::$StatusOpen)
    {
      $this->log = "exit called";
    }
  }

  private function setStatus($aStatus)
  {
    $this->status = $aStatus;

    // entry actions and do activities
    if ($this->status == self::$StatusOpen)
    {
      $this->log = "entry called";
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