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

  //Election Associations
  private $polls;
  private $electionForPositions;

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
    $this->polls = array();
    $this->electionForPositions = array();
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

  public function getPoll($index)
  {
    $aPoll = $this->polls[$index];
    return $aPoll;
  }

  public function getPolls()
  {
    $newPolls = $this->polls;
    return $newPolls;
  }

  public function numberOfPolls()
  {
    $number = count($this->polls);
    return $number;
  }

  public function hasPolls()
  {
    $has = $this->numberOfPolls() > 0;
    return $has;
  }

  public function indexOfPoll($aPoll)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->polls as $poll)
    {
      if ($poll->equals($aPoll))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
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

  public static function minimumNumberOfPolls()
  {
    return 0;
  }

  public function addPollVia($aIdPoll, $aName, $aDescription)
  {
    return new Poll($aIdPoll, $aName, $aDescription, $this);
  }

  public function addPoll($aPoll)
  {
    $wasAdded = false;
    $existingElection = $aPoll->getElection();
    $isNewElection = $existingElection != null && $this !== $existingElection;
    if ($isNewElection)
    {
      $aPoll->setElection($this);
    }
    else
    {
      $this->polls[] = $aPoll;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removePoll($aPoll)
  {
    $wasRemoved = false;
    //Unable to remove aPoll, as it must always have a election
    if ($this !== $aPoll->getElection())
    {
      unset($this->polls[$this->indexOfPoll($aPoll)]);
      $this->polls = array_values($this->polls);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public static function minimumNumberOfElectionForPositions()
  {
    return 0;
  }

  public function addElectionForPositionVia($aIdElectionForPosition, $aPosition)
  {
    return new ElectionForPosition($aIdElectionForPosition, $this, $aPosition);
  }

  public function addElectionForPosition($aElectionForPosition)
  {
    $wasAdded = false;
    $existingElection = $aElectionForPosition->getElection();
    $isNewElection = $existingElection != null && $this !== $existingElection;
    if ($isNewElection)
    {
      $aElectionForPosition->setElection($this);
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
    //Unable to remove aElectionForPosition, as it must always have a election
    if ($this !== $aElectionForPosition->getElection())
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
    $this->cachedHashCode = $this->cachedHashCode * 23 + $this->idElection;

    $this->canSetIdElection = false;
    return $this->cachedHashCode;
  }

  public function delete()
  {
    foreach ($this->polls as $aPoll)
    {
      $aPoll->delete();
    }
    foreach ($this->electionForPositions as $aElectionForPosition)
    {
      $aElectionForPosition->delete();
    }
  }

}
?>