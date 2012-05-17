<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

class Election
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Election Attributes
  private $idElection;
  private $name;
  private $description;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aIdElection, $aName, $aDescription)
  {
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
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>