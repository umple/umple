<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

class Candidature
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Candidature Attributes
  private $idCandidature;

  //Candidature Associations
  private $candidate;
  private $electionForPosition;

  //Helper Variables
  private $cachedHashCode;
  private $canSetIdCandidature;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aIdCandidature, $aCandidate, $aElectionForPosition)
  {
    $this->cachedHashCode = -1;
    $this->canSetIdCandidature = true;
    $this->idCandidature = $aIdCandidature;
    $didAddCandidate = $this->setCandidate($aCandidate);
    if (!$didAddCandidate)
    {
      throw new Exception("Unable to create candidature due to candidate");
    }
    $didAddElectionForPosition = $this->setElectionForPosition($aElectionForPosition);
    if (!$didAddElectionForPosition)
    {
      throw new Exception("Unable to create candidature due to electionForPosition");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setIdCandidature($aIdCandidature)
  {
    $wasSet = false;
    if (!$this->canSetIdCandidature) { return false; }
    $this->idCandidature = $aIdCandidature;
    $wasSet = true;
    return $wasSet;
  }

  public function getIdCandidature()
  {
    return $this->idCandidature;
  }

  public function getCandidate()
  {
    return $this->candidate;
  }

  public function getElectionForPosition()
  {
    return $this->electionForPosition;
  }

  public function setCandidate($aCandidate)
  {
    $wasSet = false;
    if ($aCandidate == null)
    {
      return $wasSet;
    }
    
    $existingCandidate = $this->candidate;
    $this->candidate = $aCandidate;
    if ($existingCandidate != null && $existingCandidate != $aCandidate)
    {
      $existingCandidate->removeCandidature($this);
    }
    $this->candidate->addCandidature($this);
    $wasSet = true;
    return $wasSet;
  }

  public function setElectionForPosition($aElectionForPosition)
  {
    $wasSet = false;
    if ($aElectionForPosition == null)
    {
      return $wasSet;
    }
    
    $existingElectionForPosition = $this->electionForPosition;
    $this->electionForPosition = $aElectionForPosition;
    if ($existingElectionForPosition != null && $existingElectionForPosition != $aElectionForPosition)
    {
      $existingElectionForPosition->removeCandidature($this);
    }
    $this->electionForPosition->addCandidature($this);
    $wasSet = true;
    return $wasSet;
  }

  public function equals($compareTo)
  {
    if ($compareTo == null) { return false; }
    if (get_class($this) != get_class($compareTo)) { return false; }

    if ($this->idCandidature != $compareTo->idCandidature)
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
    $this->cachedHashCode = $this->cachedHashCode * 23 + $this->idCandidature;

    $this->canSetIdCandidature = false;
    return $this->cachedHashCode;
  }

  public function delete()
  {
    $placeholderCandidate = $this->candidate;
    $this->candidate = null;
    $placeholderCandidate->removeCandidature($this);
    $placeholderElectionForPosition = $this->electionForPosition;
    $this->electionForPosition = null;
    $placeholderElectionForPosition->removeCandidature($this);
  }

}
?>