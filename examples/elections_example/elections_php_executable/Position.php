<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

class Position
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Position Attributes
  private $idPosition;
  private $name;
  private $description;

  //Position Associations
  private $electionForPositions;

  //Helper Variables
  private $cachedHashCode;
  private $canSetIdPosition;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aIdPosition, $aName, $aDescription)
  {
    $this->cachedHashCode = -1;
    $this->canSetIdPosition = true;
    $this->idPosition = $aIdPosition;
    $this->name = $aName;
    $this->description = $aDescription;
    $this->electionForPositions = array();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setIdPosition($aIdPosition)
  {
    $wasSet = false;
    if (!$this->canSetIdPosition) { return false; }
    $this->idPosition = $aIdPosition;
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

  public function getIdPosition()
  {
    return $this->idPosition;
  }

  public function getName()
  {
    return $this->name;
  }

  public function getDescription()
  {
    return $this->description;
  }

  public function getElectionForPosition($index)
  {
    $aElectionForPosition = $this->electionForPositions[$index];
    return $aElectionForPosition;
  }

  public function getElectionForPositions()
  {
    $newElectionForPositions = $this->electionForPositions;
    return $newElectionForPositions;
  }

  public function numberOfElectionForPositions()
  {
    $number = count($this->electionForPositions);
    return $number;
  }

  public function hasElectionForPositions()
  {
    $has = $this->numberOfElectionForPositions() > 0;
    return $has;
  }

  public function indexOfElectionForPosition($aElectionForPosition)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->electionForPositions as $electionForPosition)
    {
      if ($electionForPosition->equals($aElectionForPosition))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public static function minimumNumberOfElectionForPositions()
  {
    return 0;
  }

  public function addElectionForPositionVia($aIdElectionForPosition, $aElection)
  {
    return new ElectionForPosition($aIdElectionForPosition, $aElection, $this);
  }

  public function addElectionForPosition($aElectionForPosition)
  {
    $wasAdded = false;
    if ($this->indexOfElectionForPosition($aElectionForPosition) !== -1) { return false; }
    $existingPosition = $aElectionForPosition->getPosition();
    $isNewPosition = $existingPosition != null && $this !== $existingPosition;
    if ($isNewPosition)
    {
      $aElectionForPosition->setPosition($this);
    }
    else
    {
      $this->electionForPositions[] = $aElectionForPosition;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeElectionForPosition($aElectionForPosition)
  {
    $wasRemoved = false;
    //Unable to remove aElectionForPosition, as it must always have a position
    if ($this !== $aElectionForPosition->getPosition())
    {
      unset($this->electionForPositions[$this->indexOfElectionForPosition($aElectionForPosition)]);
      $this->electionForPositions = array_values($this->electionForPositions);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function equals($compareTo)
  {
    if ($compareTo == null) { return false; }
    if (get_class($this) != get_class($compareTo)) { return false; }

    if ($this->idPosition != $compareTo->idPosition)
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
    $this->cachedHashCode = $this->cachedHashCode * 23 + $this->idPosition;

    $this->canSetIdPosition = false;
    return $this->cachedHashCode;
  }

  public function delete()
  {
    foreach ($this->electionForPositions as $aElectionForPosition)
    {
      $aElectionForPosition->delete();
    }
  }

}
?>