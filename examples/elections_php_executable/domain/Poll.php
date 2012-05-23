<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

class Poll
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Poll Attributes
  private $idElection;
  private $name;
  private $description;

  //Poll Associations
  private $theElection;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aIdElection, $aName, $aDescription, $aTheElection)
  {
    $this->idElection = $aIdElection;
    $this->name = $aName;
    $this->description = $aDescription;
    if (!$this->setTheElection($aTheElection))
    {
      throw new Exception("Unable to create Poll due to aTheElection");
    }
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

  public function getTheElection()
  {
    return $this->theElection;
  }

  public function setTheElection($newTheElection)
  {
    $wasSet = false;
    if ($newTheElection != null)
    {
      $this->theElection = $newTheElection;
      $wasSet = true;
    }
    return $wasSet;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $this->theElection = null;
  }

}
?>