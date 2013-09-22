<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

class CourseM
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseM State Machines
  private static $OneOn = 1;
  private static $OneOff = 2;
  private $one;

  private static $TwoSlow = 1;
  private static $TwoFast = 2;
  private $two;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->setOne(self::$OneOn);
    $this->setTwo(self::$TwoSlow);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getOneFullName()
  {
    $answer = $this->getOne();
    return $answer;
  }

  public function getTwoFullName()
  {
    $answer = $this->getTwo();
    return $answer;
  }

  public function getOne()
  {
    if ($this->one == self::$OneOn) { return "OneOn"; }
    elseif ($this->one == self::$OneOff) { return "OneOff"; }
    return null;
  }

  public function getTwo()
  {
    if ($this->two == self::$TwoSlow) { return "TwoSlow"; }
    elseif ($this->two == self::$TwoFast) { return "TwoFast"; }
    return null;
  }

  public function flip()
  {
    $wasEventProcessed = false;
    
    $aOne = $this->one;
    $aTwo = $this->two;
    if ($aOne == self::$OneOn)
    {
      $this->setOne(self::$OneOff);
      $wasEventProcessed = true;
    }

    
    if ($aTwo == self::$TwoSlow)
    {
      $this->setTwo(self::$TwoFast);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function setOne($aOne)
  {
    $this->one = $aOne;
  }

  private function setTwo($aTwo)
  {
    $this->two = $aTwo;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>