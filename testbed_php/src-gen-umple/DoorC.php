<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

class DoorC
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DoorC Attributes
  private $id;
  private $intId;
  private $doubleId;
  private $dateId;
  private $timeId;
  private $booleanId;
  private $doorId;

  //Helper Variables
  private $canSetId;
  private $canSetIntId;
  private $canSetDoubleId;
  private $canSetDateId;
  private $canSetTimeId;
  private $canSetBooleanId;
  private $canSetDoorId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aId, $aIntId, $aDoubleId, $aDateId, $aTimeId, $aBooleanId, $aDoorId)
  {
    $this->id = $aId;
    $this->canSetId = false;
    $this->intId = $aIntId;
    $this->canSetIntId = false;
    $this->doubleId = $aDoubleId;
    $this->canSetDoubleId = false;
    $this->dateId = $aDateId;
    $this->canSetDateId = false;
    $this->timeId = $aTimeId;
    $this->canSetTimeId = false;
    $this->booleanId = $aBooleanId;
    $this->canSetBooleanId = false;
    $this->doorId = $aDoorId;
    $this->canSetDoorId = false;
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

  public function getDateId()
  {
    return $this->dateId;
  }

  public function getTimeId()
  {
    return $this->timeId;
  }

  public function getBooleanId()
  {
    return $this->booleanId;
  }

  public function getDoorId()
  {
    return $this->doorId;
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