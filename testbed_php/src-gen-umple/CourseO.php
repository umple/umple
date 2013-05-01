<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

class CourseO
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseO State Machines
  private static $OneOn = 1;
  private static $OneOff = 2;
  private $one;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->setOne(self::$OneOn);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getOneFullName()
  {
    $answer = $this->getOne();
    return $answer;
  }

  public function getOne()
  {
    if ($this->one == self::$OneOn) { return "OneOn"; }
    elseif ($this->one == self::$OneOff) { return "OneOff"; }
    return null;
  }

  public function setOne($aOne)
  {
    if ($aOne == "OneOn" || $aOne == self::$OneOn)
    {
      $this->one = self::$OneOn;
      return true;
    }
    elseif ($aOne == "OneOff" || $aOne == self::$OneOff)
    {
      $this->one = self::$OneOff;
      return true;
    }
    else
    {
      return false;
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