<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.19.0.3287 modeling language!*/

class CourseQ
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseQ State Machines
  private static $OneOff = 1;
  private static $OneOn = 2;
  private $one;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->setOne(self::$OneOff);
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
    if ($this->one == self::$OneOff) { return "OneOff"; }
    elseif ($this->one == self::$OneOn) { return "OneOn"; }
    return null;
  }

  private function __autotransition1__()
  {
    $wasEventProcessed = false;
    
    $aOne = $this->one;
    if ($aOne == self::$OneOff)
    {
      $this->setOne(self::$OneOn);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function setOne($aOne)
  {
    $this->one = $aOne;

    // entry actions and do activities
    if ($this->one == self::$OneOff)
    {
      $this->__autotransition1__();
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