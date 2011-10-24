<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

class DoorD
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DoorD Attributes
  private $id;
  private $intId;
  private $doubleId;
  private $booleanId;
  private $doorId;
  private $dateId;
  private $timeId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->resetId();
    $this->resetIntId();
    $this->resetDoubleId();
    $this->resetBooleanId();
    $this->resetDoorId();
    $this->resetDateId();
    $this->resetTimeId();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setId($aId)
  {
    $wasSet = false;
    $this->id = $aId;
    $wasSet = true;
    return $wasSet;
  }

  public function resetId()
  {
    $wasReset = false;
    $this->id = $this->getDefaultId();
    $wasReset = true;
    return $wasReset;
  }

  public function setIntId($aIntId)
  {
    $wasSet = false;
    $this->intId = $aIntId;
    $wasSet = true;
    return $wasSet;
  }

  public function resetIntId()
  {
    $wasReset = false;
    $this->intId = $this->getDefaultIntId();
    $wasReset = true;
    return $wasReset;
  }

  public function setDoubleId($aDoubleId)
  {
    $wasSet = false;
    $this->doubleId = $aDoubleId;
    $wasSet = true;
    return $wasSet;
  }

  public function resetDoubleId()
  {
    $wasReset = false;
    $this->doubleId = $this->getDefaultDoubleId();
    $wasReset = true;
    return $wasReset;
  }

  public function setBooleanId($aBooleanId)
  {
    $wasSet = false;
    $this->booleanId = $aBooleanId;
    $wasSet = true;
    return $wasSet;
  }

  public function resetBooleanId()
  {
    $wasReset = false;
    $this->booleanId = $this->getDefaultBooleanId();
    $wasReset = true;
    return $wasReset;
  }

  public function setDoorId($aDoorId)
  {
    $wasSet = false;
    $this->doorId = $aDoorId;
    $wasSet = true;
    return $wasSet;
  }

  public function resetDoorId()
  {
    $wasReset = false;
    $this->doorId = $this->getDefaultDoorId();
    $wasReset = true;
    return $wasReset;
  }

  public function setDateId($aDateId)
  {
    $wasSet = false;
    $this->dateId = $aDateId;
    $wasSet = true;
    return $wasSet;
  }

  public function resetDateId()
  {
    $wasReset = false;
    $this->dateId = $this->getDefaultDateId();
    $wasReset = true;
    return $wasReset;
  }

  public function setTimeId($aTimeId)
  {
    $wasSet = false;
    $this->timeId = $aTimeId;
    $wasSet = true;
    return $wasSet;
  }

  public function resetTimeId()
  {
    $wasReset = false;
    $this->timeId = $this->getDefaultTimeId();
    $wasReset = true;
    return $wasReset;
  }

  public function getId()
  {
    return $this->id;
  }

  public function getDefaultId()
  {
    return "1";
  }

  public function getIntId()
  {
    return $this->intId;
  }

  public function getDefaultIntId()
  {
    return 2;
  }

  public function getDoubleId()
  {
    return $this->doubleId;
  }

  public function getDefaultDoubleId()
  {
    return 3.4;
  }

  public function getBooleanId()
  {
    return $this->booleanId;
  }

  public function getDefaultBooleanId()
  {
    return false;
  }

  public function getDoorId()
  {
    return $this->doorId;
  }

  public function getDefaultDoorId()
  {
    return new DoorB(5);
  }

  public function getDateId()
  {
    return $this->dateId;
  }

  public function getDefaultDateId()
  {
    return date(1234);
  }

  public function getTimeId()
  {
    return $this->timeId;
  }

  public function getDefaultTimeId()
  {
    return time(1235);
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