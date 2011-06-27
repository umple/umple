<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.1.605 modeling language!*/

class DoorF
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DoorF Attributes
  private $d1;
  private $d2;
  private $d3;
  private $d4;

  //Helper Variables
  private $canSetD2;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->d1 = date("h:i:s", strtotime("12:51:51"));
    $this->d2 = date("h:i:s", strtotime("12:52:52"));
    $this->canSetD2 = false;
    $this->resetD3();
    $this->d4 = date("12:53:54");
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setD1($aD1)
  {
    $wasSet = false;
    $this->d1 = $aD1;
    $wasSet = true;
    return $wasSet;
  }

  public function setD3($aD3)
  {
    $wasSet = false;
    $this->d3 = $aD3;
    $wasSet = true;
    return $wasSet;
  }

  public function resetD3()
  {
    $wasReset = false;
    $this->d3 = $this->getDefaultD3();
    $wasReset = true;
    return $wasReset;
  }

  public function setD4($aD4)
  {
    $wasSet = false;
    $this->d4 = $aD4;
    $wasSet = true;
    return $wasSet;
  }

  public function getD1()
  {
    return $this->d1;
  }

  public function getD2()
  {
    return $this->d2;
  }

  public function getD3()
  {
    return $this->d3;
  }

  public function getDefaultD3()
  {
    return date("h:i:s", strtotime("12:53:53"));
  }

  public function getD4()
  {
    return $this->d4;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>