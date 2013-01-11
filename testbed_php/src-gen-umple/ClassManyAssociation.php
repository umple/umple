<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

class ClassManyAssociation
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassManyAssociation Associations
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
      throw new Exception("Unable to create ClassManyAssociation, must not have duplicate otherclasses.");
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
    return 0;
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

    if (count($verifiedOtherclasses) != count($newOtherclasses))
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