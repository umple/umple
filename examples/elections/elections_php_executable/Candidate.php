<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

class Candidate
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Candidate Attributes
  private $idCandidate;
  private $name;
  private $address;
  private $telephone;

  //Candidate Associations
  private $candidatures;

  //Helper Variables
  private $cachedHashCode;
  private $canSetIdCandidate;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aIdCandidate, $aName, $aAddress, $aTelephone)
  {
    $this->cachedHashCode = -1;
    $this->canSetIdCandidate = true;
    $this->idCandidate = $aIdCandidate;
    $this->name = $aName;
    $this->address = $aAddress;
    $this->telephone = $aTelephone;
    $this->candidatures = array();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setIdCandidate($aIdCandidate)
  {
    $wasSet = false;
    if (!$this->canSetIdCandidate) { return false; }
    $this->idCandidate = $aIdCandidate;
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

  public function setAddress($aAddress)
  {
    $wasSet = false;
    $this->address = $aAddress;
    $wasSet = true;
    return $wasSet;
  }

  public function setTelephone($aTelephone)
  {
    $wasSet = false;
    $this->telephone = $aTelephone;
    $wasSet = true;
    return $wasSet;
  }

  public function getIdCandidate()
  {
    return $this->idCandidate;
  }

  public function getName()
  {
    return $this->name;
  }

  public function getAddress()
  {
    return $this->address;
  }

  public function getTelephone()
  {
    return $this->telephone;
  }

  public function getCandidature($index)
  {
    $aCandidature = $this->candidatures[$index];
    return $aCandidature;
  }

  public function getCandidatures()
  {
    $newCandidatures = $this->candidatures;
    return $newCandidatures;
  }

  public function numberOfCandidatures()
  {
    $number = count($this->candidatures);
    return $number;
  }

  public function hasCandidatures()
  {
    $has = $this->numberOfCandidatures() > 0;
    return $has;
  }

  public function indexOfCandidature($aCandidature)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->candidatures as $candidature)
    {
      if ($candidature->equals($aCandidature))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public static function minimumNumberOfCandidatures()
  {
    return 0;
  }

  public function addCandidatureVia($aIdCandidature, $aElectionForPosition)
  {
    return new Candidature($aIdCandidature, $this, $aElectionForPosition);
  }

  public function addCandidature($aCandidature)
  {
    $wasAdded = false;
    if ($this->indexOfCandidature($aCandidature) !== -1) { return false; }
    $existingCandidate = $aCandidature->getCandidate();
    $isNewCandidate = $existingCandidate != null && $this !== $existingCandidate;
    if ($isNewCandidate)
    {
      $aCandidature->setCandidate($this);
    }
    else
    {
      $this->candidatures[] = $aCandidature;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeCandidature($aCandidature)
  {
    $wasRemoved = false;
    //Unable to remove aCandidature, as it must always have a candidate
    if ($this !== $aCandidature->getCandidate())
    {
      unset($this->candidatures[$this->indexOfCandidature($aCandidature)]);
      $this->candidatures = array_values($this->candidatures);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function equals($compareTo)
  {
    if ($compareTo == null) { return false; }
    if (get_class($this) != get_class($compareTo)) { return false; }

    if ($this->idCandidate != $compareTo->idCandidate)
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
    $this->cachedHashCode = $this->cachedHashCode * 23 + $this->idCandidate;

    $this->canSetIdCandidate = false;
    return $this->cachedHashCode;
  }

  public function delete()
  {
    foreach ($this->candidatures as $aCandidature)
    {
      $aCandidature->delete();
    }
  }

}
?>