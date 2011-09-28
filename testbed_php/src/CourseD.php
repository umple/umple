<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.605 modeling language!*/

class CourseD
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseD State Machines
  private static $StatusOpen = 1;
  private static $StatusClosed = 2;
  private $status;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->setStatus(self::$StatusOpen);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getStatus()
  {
    if ($this->status == self::$StatusOpen) { return "StatusOpen"; }
    elseif ($this->status == self::$StatusClosed) { return "StatusClosed"; }
    return null;
  }

  public function timeoutOpenToClosed()
  {
    $wasEventProcessed = false;

    if ($this->status == self::$StatusOpen)
    {
      $this->setStatus(self::$StatusClosed);
      $wasEventProcessed = true;
    }

    return $wasEventProcessed;
  }

  private function setStatus($aStatus)
  {
    $this->status = $aStatus;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>