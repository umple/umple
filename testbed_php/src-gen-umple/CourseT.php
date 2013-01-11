<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

class CourseT
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseT Attributes
  private $count;

  //CourseT State Machines
  private static $OneOff = 1;
  private static $OneOn = 2;
  private static $OneWait = 3;
  private $one;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aCount)
  {
    $this->count = $aCount;
    $this->setOne(self::$OneOff);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setCount($aCount)
  {
    $wasSet = false;
    $this->count = $aCount;
    $wasSet = true;
    return $wasSet;
  }

  public function getCount()
  {
    return $this->count;
  }

  public function getOneFullName()
  {
    $answer = $this->getOne();
    return $answer;
  }

  public function getOne()
  {
    if ($this->one == self::$OneOff) { return "OneOff"; }
    elseif ($this->one == self::$OneOn) { return "OneOn"; }
    elseif ($this->one == self::$OneWait) { return "OneWait"; }
    return null;
  }

  private function __autotransition3__()
  {
    $wasEventProcessed = false;
    
    $aOne = $this->one;
    if ($aOne == self::$OneOff)
    {
      if ($this->count > 10)
      {
        $this->setOne(self::$OneOn);
        $wasEventProcessed = true;
      }
    }
    return $wasEventProcessed;
  }

  private function __autotransition4__()
  {
    $wasEventProcessed = false;
    
    $aOne = $this->one;
    if ($aOne == self::$OneOff)
    {
      if ($this->count <= 10)
      {
        $this->setOne(self::$OneWait);
        $wasEventProcessed = true;
      }
    }
    return $wasEventProcessed;
  }

  private function setOne($aOne)
  {
    $this->one = $aOne;

    // entry actions and do activities
    if ($this->one == self::$OneOff)
    {
      $this->__autotransition3__();
      $this->__autotransition4__();
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