<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.19.0.3287 modeling language!*/

class ClassMStarAssociation
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassMStarAssociation Associations
  private $otherclasses;

  //Helper Variables
  private $canSetOtherclasses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($allOtherclasses)
  {
    $this->canSetOtherclasses = true;
    $this->otherclasses = array();
    $didAddOtherclasses = $this->setOtherclasses($allOtherclasses);
    if (!$didAddOtherclasses)
    {
      throw new Exception("Unable to create ClassMStarAssociation, must have at least 2 otherclasses");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getOtherclass($index)
  {
    $aOtherclass = $this->otherclasses[$index];
    return $aOtherclass;
  }

  public function getOtherclasses()
  {
    $newOtherclasses = $this->otherclasses;
    return $newOtherclasses;
  }

  public function numberOfOtherclasses()
  {
    $number = count($this->otherclasses);
    return $number;
  }

  public function hasOtherclasses()
  {
    $has = $this->numberOfOtherclasses() > 0;
    return $has;
  }

  public function indexOfOtherclass($aOtherclass)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->otherclasses as $otherclass)
    {
      if ($otherclass->equals($aOtherclass))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public static function minimumNumberOfOtherclasses()
  {
    return 2;
  }

  private function setOtherclasses($newOtherclasses)
  {
    $wasSet = false;
    if (!$this->canSetOtherclasses) { return false; }
    $this->canSetOtherclasses = false;
    $verifiedOtherclasses = array();
    foreach ($newOtherclasses as $aOtherclass)
    {
      if (array_search($aOtherclass,$verifiedOtherclasses) !== false)
      {
        continue;
      }
      $verifiedOtherclasses[] = $aOtherclass;
    }

    if (count($verifiedOtherclasses) != count($newOtherclasses) || count($verifiedOtherclasses) < self::minimumNumberOfOtherclasses())
    {
      return $wasSet;
    }

    $this->otherclasses = $verifiedOtherclasses;
    $wasSet = true;
    return $wasSet;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>