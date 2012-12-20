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
  private $status;

  //Poll Associations
  private $election;

  //Helper Variables
  private $cachedHashCode;
  private $canSetIdPoll;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aIdPoll, $aName, $aDescription, $aElection)
  {
    $this->cachedHashCode = -1;
    $this->canSetIdPoll = true;
    $this->idPoll = $aIdPoll;
    $this->name = $aName;
    $this->description = $aDescription;
    $this->status = "planned";
    $didAddElection = $this->setElection($aElection);
    if (!$didAddElection)
    {
      throw new Exception("Unable to create poll due to election");
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

  public function setStatus($aStatus)
  {
    $wasSet = false;
    $this->status = $aStatus;
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

  public function getStatus()
  {
    return $this->status;
  }

  public function getElection()
  {
    return $this->election;
  }

  public function setElection($aElection)
  {
    $wasSet = false;
    if ($aElection == null)
    {
      return $wasSet;
    }
    
    $existingElection = $this->election;
    $this->election = $aElection;
    if ($existingElection != null && $existingElection != $aElection)
    {
      $existingElection->removePoll($this);
    }
    $this->election->addPoll($this);
    $wasSet = true;
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

    return true;
  }

  public function hashCode()
  {
    if ($this->cachedHashCode != -1)
    {
      return $this->cachedHashCode;
    }
    $this->cachedHashCode = 17;
    $this->cachedHashCode = $this->cachedHashCode * 23 + $this->idPoll;

    $this->canSetIdPoll = false;
    return $this->cachedHashCode;
  }

  public function delete()
  {
    $placeholderElection = $this->election;
    $this->election = null;
    $placeholderElection->removePoll($this);
  }

}
?>