<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

class CourseP
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseP State Machines
  private static $OneOn = 1;
  private static $OneAmber = 2;
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
    elseif ($this->one == self::$OneAmber) { return "OneAmber"; }
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

  public function flip()
  {
    $wasEventProcessed = false;
    
    $aOne = $this->one;
    if ($aOne == self::$OneOn)
    {
      $this->setOne(self::$OneAmber);
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