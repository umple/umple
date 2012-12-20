<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

class ClassOne
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassOne Associations
  private $classOtherclass;

  //Helper Variables
  private $canSetClassOtherclass;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aClassOtherclass)
  {
    $this->canSetClassOtherclass = true;
    if (!$this->setClassOtherclass($aClassOtherclass))
    {
      throw new Exception("Unable to create ClassOne due to aClassOtherclass");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getClassOtherclass()
  {
    return $this->classOtherclass;
  }

  private function setClassOtherclass($newClassOtherclass)
  {
    $wasSet = false;
    if (!$this->canSetClassOtherclass) { return false; }
    $this->canSetClassOtherclass = false;
    if ($newClassOtherclass != null)
    {
      $this->classOtherclass = $newClassOtherclass;
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