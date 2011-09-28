<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.605 modeling language!*/

class DoorB
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DoorB Attributes
  private $id;

  //Helper Variables
  private $cachedHashCode;
  private $canSetId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aId)
  {
    $this->id = $aId;
    $this->cachedHashCode = -1;
    $this->canSetId = true;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setId($aId)
  {
    $wasSet = false;
    if (!$this->canSetId) { return false; }
    $this->id = $aId;
    $wasSet = true;
    return $wasSet;
  }

  public function getId()
  {
    return $this->id;
  }

  public function equals($compareTo)
  {
    if ($compareTo == null) { return false; }
    if (get_class($this) != get_class($compareTo)) { return false; }

    if ($this->id != $compareTo->id)
    {
      return false;
    }

    return true;
  }

  public function hashCode()
  {
    if ($this->cachedHashCode != -1)
    {
      return $this->cachedHashCode;
    }
    $this->cachedHashCode = 17;
    $this->cachedHashCode = $this->cachedHashCode * 23 + $this->id;

    $this->canSetId = false;
    return $this->cachedHashCode;
  }

  public function delete()
  {}

}
?>