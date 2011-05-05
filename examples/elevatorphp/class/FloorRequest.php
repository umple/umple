<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.6.0.1712 modeling language!*/

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
    $this->isCalled = $aIsCalled;
    return true;
  }

  public function getIsCalled()
  {
    return $this->isCalled;
  }

  public function delete()
  {}

}
?>