<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

class Voter
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Voter Attributes
  private $idVoter;
  private $name;
  private $address;
  private $telephone;

  //Helper Variables
  private $cachedHashCode;
  private $canSetIdVoter;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aIdVoter, $aName, $aAddress, $aTelephone)
  {
    $this->cachedHashCode = -1;
    $this->canSetIdVoter = true;
    $this->idVoter = $aIdVoter;
    $this->name = $aName;
    $this->address = $aAddress;
    $this->telephone = $aTelephone;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setIdVoter($aIdVoter)
  {
    $wasSet = false;
    if (!$this->canSetIdVoter) { return false; }
    $this->idVoter = $aIdVoter;
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

  public function getIdVoter()
  {
    return $this->idVoter;
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

  public function equals($compareTo)
  {
    if ($compareTo == null) { return false; }
    if (get_class($this) != get_class($compareTo)) { return false; }

    if ($this->idVoter != $compareTo->idVoter)
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
    $this->cachedHashCode = $this->cachedHashCode * 23 + $this->idVoter;

    $this->canSetIdVoter = false;
    return $this->cachedHashCode;
  }

  public function delete()
  {}

}
?>