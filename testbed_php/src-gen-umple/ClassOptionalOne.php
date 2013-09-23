<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

class ClassOptionalOne
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassOptionalOne Associations
  private $classOtherclass;

  //Helper Variables
  private $canSetClassOtherclass;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aClassOtherclass)
  {
    $this->canSetClassOtherclass = true;
    $this->setClassOtherclass($aClassOtherclass);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getClassOtherclass()
  {
    return $this->classOtherclass;
  }

  private function setClassOtherclass($aNewClassOtherclass)
  {
    $wasSet = false;
    if (!$this->canSetClassOtherclass) { return false; }
    $this->canSetClassOtherclass = false;
    $this->classOtherclass = $aNewClassOtherclass;
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