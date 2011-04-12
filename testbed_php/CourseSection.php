<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.7.2.1968 modeling language!*/

class CourseSection
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseSection State Machines
  private $status;

  // status constants
  private static $Planned = 1;
  private static $OpenNotEnoughStudents = 2;
  private static $Cancelled = 3;
  private static $OpenEnoughStudents = 4;
  private static $Closed = 5;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->status = self::$Planned;
  }
  
  //------------------------
  // INTERFACE
  //------------------------

  public function getStatus()
  {
    if ($this->status == self::$Planned) { return "Planned"; }
    elseif ($this->status == self::$OpenNotEnoughStudents) { return "OpenNotEnoughStudents"; }
    elseif ($this->status == self::$Cancelled) { return "Cancelled"; }
    elseif ($this->status == self::$OpenEnoughStudents) { return "OpenEnoughStudents"; }
    elseif ($this->status == self::$Closed) { return "Closed"; }
    return null;
  }

  public function openRegistration()
  {
    if ($this->status == self::$Planned)
    {
      $this->status = self::$OpenNotEnoughStudents;
      return true;
    }
    return false;
  }

  public function requestToRegister()
  {
    if ($this->status == self::$OpenNotEnoughStudents)
    {
      $this->status = self::$OpenNotEnoughStudents;
      return true;
    }
    elseif ($this->status == self::$OpenEnoughStudents)
    {
      $this->status = self::$OpenEnoughStudents;
      return true;
    }
    return false;
  }

  public function closeRegistration()
  {
    if ($this->status == self::$OpenNotEnoughStudents)
    {
      $this->status = self::$Cancelled;
      return true;
    }
    elseif ($this->status == self::$OpenEnoughStudents)
    {
      $this->status = self::$Closed;
      return true;
    }
    return false;
  }

  public function cancel()
  {
    if ($this->status == self::$OpenNotEnoughStudents)
    {
      $this->status = self::$Cancelled;
      return true;
    }
    return false;
  }

  public function classSizeExceedsMinimum()
  {
    if ($this->status == self::$OpenNotEnoughStudents)
    {
      $this->status = self::$OpenEnoughStudents;
      return true;
    }
    return false;
  }

  public function classSizeExceedsMaximum()
  {
    if ($this->status == self::$OpenEnoughStudents)
    {
      $this->status = self::$Closed;
      return true;
    }
    return false;
  }

  public function delete()
  {}

}
?>