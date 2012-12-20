<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

class ElectionForPosition
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ElectionForPosition Attributes
  private $idElectionForPosition;

  //ElectionForPosition Associations
  private $election;
  private $position;

  //Helper Variables
  private $cachedHashCode;
  private $canSetIdElectionForPosition;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aIdElectionForPosition, $aElection, $aPosition)
  {
    $this->cachedHashCode = -1;
    $this->canSetIdElectionForPosition = true;
    $this->idElectionForPosition = $aIdElectionForPosition;
    $didAddElection = $this->setElection($aElection);
    if (!$didAddElection)
    {
      throw new Exception("Unable to create electionForPosition due to election");
    }
    $didAddPosition = $this->setPosition($aPosition);
    if (!$didAddPosition)
    {
      throw new Exception("Unable to create electionForPosition due to position");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setIdElectionForPosition($aIdElectionForPosition)
  {
    $wasSet = false;
    $this->idElectionForPosition = $aIdElectionForPosition;
    $wasSet = true;
    return $wasSet;
  }

  public function getIdElectionForPosition()
  {
    return $this->idElectionForPosition;
  }

  public function getElection()
  {
    return $this->election;
  }

  public function getPosition()
  {
    return $this->position;
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
      $existingElection->removeElectionForPosition($this);
    }
    $this->election->addElectionForPosition($this);
    $wasSet = true;
    return $wasSet;
  }

  public function setPosition($aPosition)
  {
    $wasSet = false;
    if ($aPosition == null)
    {
      return $wasSet;
    }
    
    $existingPosition = $this->position;
    $this->position = $aPosition;
    if ($existingPosition != null && $existingPosition != $aPosition)
    {
      $existingPosition->removeElectionForPosition($this);
    }
    $this->position->addElectionForPosition($this);
    $wasSet = true;
    return $wasSet;
  }

  public function equals($compareTo)
  {
    if ($compareTo == null) { return false; }
    if (get_class($this) != get_class($compareTo)) { return false; }

    if ($this->idElectionForPosition != $compareTo->idElectionForPosition)
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
    $this->cachedHashCode = $this->cachedHashCode * 23 + $this->idElectionForPosition;

    $this->canSetIdElectionForPosition = false;
    return $this->cachedHashCode;
  }

  public function delete()
  {
    $placeholderElection = $this->election;
    $this->election = null;
    $placeholderElection->removeElectionForPosition($this);
    $placeholderPosition = $this->position;
    $this->position = null;
    $placeholderPosition->removeElectionForPosition($this);
  }

}
?>