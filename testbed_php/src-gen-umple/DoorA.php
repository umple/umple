<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.${svn.Revision} modeling language!*/

class DoorA
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DoorA Attributes
  private $id;
  private $intId;
  private $doubleId;
  private $booleanId;
  private $doorId;
  private $dateId;
  private $timeId;

  //Helper Variables
  private $canSetId;
  private $canSetIntId;
  private $canSetDoubleId;
  private $canSetBooleanId;
  private $canSetDoorId;
  private $canSetDateId;
  private $canSetTimeId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->id = "1";
    $this->canSetId = false;
    $this->intId = 2;
    $this->canSetIntId = false;
    $this->doubleId = 3.4;
    $this->canSetDoubleId = false;
    $this->booleanId = false;
    $this->canSetBooleanId = false;
    $this->doorId = new DoorB(5);
    $this->canSetDoorId = false;
    $this->dateId = date(1234);
    $this->canSetDateId = false;
    $this->timeId = time(1235);
    $this->canSetTimeId = false;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getId()
  {
    return $this->id;
  }

  public function getIntId()
  {
    return $this->intId;
  }

  public function getDoubleId()
  {
    return $this->doubleId;
  }

  public function getBooleanId()
  {
    return $this->booleanId;
  }

  public function getDoorId()
  {
    return $this->doorId;
  }

  public function getDateId()
  {
    return $this->dateId;
  }

  public function getTimeId()
  {
    return $this->timeId;
  }

  public function isBooleanId()
  {
    return $this->booleanId;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>