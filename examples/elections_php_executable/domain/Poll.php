<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

class Poll
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Poll Attributes
  private $idPoll;
  private $name;
  private $description;

  //Poll Associations
  private $election;

  //Helper Variables
  private $cachedHashCode;
  private $canSetIdPoll;
  private $canSetElection;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aIdPoll, $aName, $aDescription, $aElection)
  {
    $this->cachedHashCode = -1;
    $this->canSetIdPoll = true;
    $this->canSetElection = true;
    $this->idPoll = $aIdPoll;
    $this->name = $aName;
    $this->description = $aDescription;
    if (!$this->setElection($aElection))
    {
      throw new Exception("Unable to create Poll due to aElection");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setIdPoll($aIdPoll)
  {
    $wasSet = false;
    $this->idPoll = $aIdPoll;
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

  public function getIdPoll()
  {
    return $this->idPoll;
  }

  public function getName()
  {
    return $this->name;
  }

  public function getDescription()
  {
    return $this->description;
  }

  public function getElection()
  {
    return $this->election;
  }

  public function setElection($newElection)
  {
    $wasSet = false;
    if ($newElection != null)
    {
      $this->election = $newElection;
      $wasSet = true;
    }
    return $wasSet;
  }

  public function equals($compareTo)
  {
    if ($compareTo == null) { return false; }
    if (get_class($this) != get_class($compareTo)) { return false; }

    if ($this->idPoll != $compareTo->idPoll)
    {
      return false;
    }

    if ($this->election != $compareTo->election)
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
    if ($this->idPoll != null)
    {
      $this->cachedHashCode = $this->cachedHashCode * 23 + spl_object_hash($this->idPoll);
    }
    else
    {
      $this->cachedHashCode = $this->cachedHashCode * 23;
    }

    if ($this->election != null)
    {
      $this->cachedHashCode = $this->cachedHashCode * 23 + spl_object_hash($this->election);
    }
    else
    {
      $this->cachedHashCode = $this->cachedHashCode * 23;
    }

    $this->canSetIdPoll = false;
    $this->canSetElection = false;
    return $this->cachedHashCode;
  }

  public function delete()
  {
    $this->election = null;
  }

}
?>