<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

class Election
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Election Attributes
  private $idElection;
  private $name;
  private $description;

  //Helper Variables
  private $cachedHashCode;
  private $canSetIdElection;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aIdElection, $aName, $aDescription)
  {
    $this->cachedHashCode = -1;
    $this->canSetIdElection = true;
    $this->idElection = $aIdElection;
    $this->name = $aName;
    $this->description = $aDescription;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setIdElection($aIdElection)
  {
    $wasSet = false;
    $this->idElection = $aIdElection;
    $wasSet = true;
    return $wasSet;
  }

  public function setName($aName)
  {
    $wasSet = false;
    $this->name = $aName;
    $wasSet = true;
    return $wasSet;
  }

  public function setDescription($aDescription)
  {
    $wasSet = false;
    $this->description = $aDescription;
    $wasSet = true;
    return $wasSet;
  }

  public function getIdElection()
  {
    return $this->idElection;
  }

  public function getName()
  {
    return $this->name;
  }

  public function getDescription()
  {
    return $this->description;
  }

  public function equals($compareTo)
  {
    if ($compareTo == null) { return false; }
    if (get_class($this) != get_class($compareTo)) { return false; }

    if ($this->idElection != $compareTo->idElection)
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
    if ($this->idElection != null)
    {
      $this->cachedHashCode = $this->cachedHashCode * 23 + spl_object_hash($this->idElection);
    }
    else
    {
      $this->cachedHashCode = $this->cachedHashCode * 23;
    }

    $this->canSetIdElection = false;
    return $this->cachedHashCode;
  }

  public function delete()
  {}

}
?>