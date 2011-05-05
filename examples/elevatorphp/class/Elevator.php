<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.0.352 modeling language!*/

class Elevator
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Elevator Attributes
  private $direction;
  private $isMoving;
  private $percentageDoorOpen;

  //Elevator Associations
  private $requestedFloors;
  private $ridingPersons;
  private $building;
  private $floor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aDirection, $aIsMoving, $aBuilding)
  {
    $this->direction = $aDirection;
    $this->isMoving = $aIsMoving;
    $this->percentageDoorOpen = 0;
    $this->requestedFloors = array();
    $this->ridingPersons = array();
    $didAddBuilding = $this->setBuilding($aBuilding);
    if (!$didAddBuilding)
    {
      throw new Exception("Unable to create elevator due to building");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setDirection($aDirection)
  {
    $wasSet = false;
    $this->direction = $aDirection;
    $wasSet = true;
    return $wasSet;
  }

  public function setIsMoving($aIsMoving)
  {
    $wasSet = false;
    $this->isMoving = $aIsMoving;
    $wasSet = true;
    return $wasSet;
  }

  public function setPercentageDoorOpen($aPercentageDoorOpen)
  {
    $wasSet = false;
    $this->percentageDoorOpen = $aPercentageDoorOpen;
    $wasSet = true;
    StringTracer::execute("percentageDoorOpen={$aPercentageDoorOpen}");
    return $wasSet;
  }

  public function getDirection()
  {
    return $this->direction;
  }

  public function getIsMoving()
  {
    return $this->isMoving;
  }

  public function getPercentageDoorOpen()
  {
    return $this->percentageDoorOpen;
  }

  public function getRequestedFloor($index)
  {
    $aRequestedFloor = $this->requestedFloors[$index];
    return $aRequestedFloor;
  }

  public function getRequestedFloors()
  {
    $newRequestedFloors = $this->requestedFloors;
    return $newRequestedFloors;
  }

  public function numberOfRequestedFloors()
  {
    $number = count($this->requestedFloors);
    return $number;
  }

  public function hasRequestedFloors()
  {
    $has = $this->numberOfRequestedFloors() > 0;
    return $has;
  }

  public function indexOfRequestedFloor($aRequestedFloor)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->requestedFloors as $requestedFloor)
    {
      if ($requestedFloor->equals($aRequestedFloor))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getRidingPerson($index)
  {
    $aRidingPerson = $this->ridingPersons[$index];
    return $aRidingPerson;
  }

  public function getRidingPersons()
  {
    $newRidingPersons = $this->ridingPersons;
    return $newRidingPersons;
  }

  public function numberOfRidingPersons()
  {
    $number = count($this->ridingPersons);
    return $number;
  }

  public function hasRidingPersons()
  {
    $has = $this->numberOfRidingPersons() > 0;
    return $has;
  }

  public function indexOfRidingPerson($aRidingPerson)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->ridingPersons as $ridingPerson)
    {
      if ($ridingPerson->equals($aRidingPerson))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getBuilding()
  {
    return $this->building;
  }

  public function getFloor()
  {
    return $this->floor;
  }

  public static function minimumNumberOfRequestedFloors()
  {
    return 0;
  }

  public function addRequestedFloor($aRequestedFloor)
  {
    $wasAdded = false;
    if ($this->indexOfRequestedFloor($aRequestedFloor) !== -1) { return false; }
    $existingOnItsWayTo = $aRequestedFloor->getOnItsWayTo();
    if ($existingOnItsWayTo == null)
    {
      $aRequestedFloor->setOnItsWayTo($this);
    }
    elseif ($this !== $existingOnItsWayTo)
    {
      $existingOnItsWayTo->removeRequestedFloor($aRequestedFloor);
      $this->addRequestedFloor($aRequestedFloor);
    }
    else
    {
      $this->requestedFloors[] = $aRequestedFloor;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeRequestedFloor($aRequestedFloor)
  {
    $wasRemoved = false;
    if ($this->indexOfRequestedFloor($aRequestedFloor) != -1)
    {
      unset($this->requestedFloors[$this->indexOfRequestedFloor($aRequestedFloor)]);
      $this->requestedFloors = array_values($this->requestedFloors);
      if ($this === $aRequestedFloor->getOnItsWayTo())
      {
        $aRequestedFloor->setOnItsWayTo(null);
      }
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public static function minimumNumberOfRidingPersons()
  {
    return 0;
  }

  public function addRidingPerson($aRidingPerson)
  {
    $wasAdded = false;
    if ($this->indexOfRidingPerson($aRidingPerson) !== -1) { return false; }
    $existingElevator = $aRidingPerson->getElevator();
    if ($existingElevator == null)
    {
      $aRidingPerson->setElevator($this);
    }
    elseif ($this !== $existingElevator)
    {
      $existingElevator->removeRidingPerson($aRidingPerson);
      $this->addRidingPerson($aRidingPerson);
    }
    else
    {
      $this->ridingPersons[] = $aRidingPerson;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeRidingPerson($aRidingPerson)
  {
    $wasRemoved = false;
    if ($this->indexOfRidingPerson($aRidingPerson) != -1)
    {
      unset($this->ridingPersons[$this->indexOfRidingPerson($aRidingPerson)]);
      $this->ridingPersons = array_values($this->ridingPersons);
      if ($this === $aRidingPerson->getElevator())
      {
        $aRidingPerson->setElevator(null);
      }
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function setBuilding($aBuilding)
  {
    $wasSet = false;
    if ($aBuilding == null)
    {
      return $wasSet;
    }
    
    $existingBuilding = $this->building;
    $this->building = $aBuilding;
    if ($existingBuilding != null && $existingBuilding != $aBuilding)
    {
      $existingBuilding->removeElevator($this);
    }
    $this->building->addElevator($this);
    $wasSet = true;
    return $wasSet;
  }

  public function setFloor($newFloor)
  {
    $wasSet = false;
    if ($newFloor == null)
    {
      $existingFloor = $this->floor;
      $this->floor = null;
      
      if ($existingFloor != null && $existingFloor->getElevatorOnThisFloor() != null)
      {
        $existingFloor->setElevatorOnThisFloor(null);
      }
      $wasSet = true;
      return $wasSet;
    }
    
    $currentFloor = $this->getFloor();
    if ($currentFloor != null && $currentFloor != $newFloor)
    {
      $currentFloor->setElevatorOnThisFloor(null);
    }
    
    $this->floor = $newFloor;
    $existingElevatorOnThisFloor = $newFloor->getElevatorOnThisFloor();
    
    if ($this != $existingElevatorOnThisFloor)
    {
      $newFloor->setElevatorOnThisFloor($this);
    }
    $wasSet = true;
    return $wasSet;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    foreach ($this->requestedFloors as $aRequestedFloor)
    {
      $aRequestedFloor->setOnItsWayTo(null);
    }
    foreach ($this->ridingPersons as $aRidingPerson)
    {
      $aRidingPerson->setElevator(null);
    }
    $this->building->removeElevator($this);
    if ($this->floor != null)
    {
      $this->floor->setElevatorOnThisFloor(null);
    }
  }

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public function getDirectionOffset()
  {
    return $this->getDirection() == "up" ? 1 : -1;
  }
  
  public function switchDirections()
  {
    $this->setDirection($this->getDirection() == "up" ? "down" : "up");
  }
  
  public function isUp()
  {
    return $this->getDirection() == "up";
  }

  public function isDown()
  {
    return $this->getDirection() == "down";
  }
}
?>