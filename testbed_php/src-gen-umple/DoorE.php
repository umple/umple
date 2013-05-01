<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.${svn.Revision} modeling language!*/

class DoorE
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DoorE Attributes
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
    $this->d1 = date("y-m-d", strtotime("1978-12-01"));
    $this->d2 = date("y-m-d", strtotime("1978-12-02"));
    $this->canSetD2 = false;
    $this->resetD3();
    $this->d4 = date("1978-12-04");
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
    return date("y-m-d", strtotime("1978-12-03"));
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