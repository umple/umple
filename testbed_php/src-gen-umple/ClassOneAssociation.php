<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

class ClassOneAssociation
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassOneAssociation Associations
  private $otherclass;

  //Helper Variables
  private $canSetOtherclass;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aOtherclass)
  {
    $this->canSetOtherclass = true;
    if (!$this->setOtherclass($aOtherclass))
    {
      throw new Exception("Unable to create ClassOneAssociation due to aOtherclass");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getOtherclass()
  {
    return $this->otherclass;
  }

  private function setOtherclass($newOtherclass)
  {
    $wasSet = false;
    if (!$this->canSetOtherclass) { return false; }
    $this->canSetOtherclass = false;
    if ($newOtherclass != null)
    {
      $this->otherclass = $newOtherclass;
      $wasSet = true;
    }
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