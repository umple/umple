<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.0.352 modeling language!*/

class FloorRequest
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //FloorRequest Attributes
  private $isCalled;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aIsCalled)
  {
    $this->isCalled = $aIsCalled;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setIsCalled($aIsCalled)
  {
    $wasSet = false;
    $this->isCalled = $aIsCalled;
    $wasSet = true;
    return $wasSet;
  }

  public function getIsCalled()
  {
    return $this->isCalled;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>