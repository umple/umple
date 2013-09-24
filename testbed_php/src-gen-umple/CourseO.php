<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

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

  public function stay()
  {
    $wasEventProcessed = false;
    
    $aOne = $this->one;
    if ($aOne == self::$OneOn)
    {
      $this->setOne(self::$OneOn);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function setOne($aOne)
  {
    $this->one = $aOne;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>