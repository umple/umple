<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.6.0.1712 modeling language!*/

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
    $this->direction = $aDirection;
    return true;
  }

  public function setIsMoving($aIsMoving)
  {
    $this->isMoving = $aIsMoving;
    return true;
  }

  public function setPercentageDoorOpen($aPercentageDoorOpen)
  {
    $this->percentageDoorOpen = $aPercentageDoorOpen;
    return true;
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
    return $this->requestedFloors[$index];
  }

  public function getRequestedFloors()
  {
    return $this->requestedFloors;
  }

  public function numberOfRequestedFloors()
  {
    return count($this->requestedFloors);
  }

  public function hasRequestedFloors()
  {
    return $this->numberOfRequestedFloors() > 0;
  }

  public function indexOfRequestedFloor($aRequestedFloor)
  {
    $rawAnswer = array_search($aRequestedFloor,$this->requestedFloors);
    return $rawAnswer == null && $rawAnswer !== 0 ? -1 : $rawAnswer; 
  }

  public function getRidingPerson($index)
  {
    return $this->ridingPersons[$index];
  }

  public function getRidingPersons()
  {
    return $this->ridingPersons;
  }

  public function numberOfRidingPersons()
  {
    return count($this->ridingPersons);
  }

  public function hasRidingPersons()
  {
    return $this->numberOfRidingPersons() > 0;
  }

  public function indexOfRidingPerson($aRidingPerson)
  {
    $rawAnswer = array_search($aRidingPerson,$this->ridingPersons);
    return $rawAnswer == null && $rawAnswer !== 0 ? -1 : $rawAnswer; 
  }

  public function getBuilding()
  {
    return $this->building;
  }

  public function getFloor()
  {
    return $this->floor;
  }

  public function addRequestedFloor($aRequestedFloor)
  {
    if ($this->indexOfRequestedFloor($aRequestedFloor) != -1)
    {
      return false;
    }

    $existingOnItsWayTo = $aRequestedFloor->getOnItsWayTo();
    if ($existingOnItsWayTo == null)
    {
      $this->requestedFloors[] = $aRequestedFloor;
      $aRequestedFloor->setOnItsWayTo($this);
    }
    else if ($existingOnItsWayTo != $this)
    {
      $existingOnItsWayTo->removeRequestedFloor($aRequestedFloor);
      $this->addRequestedFloor($aRequestedFloor);
    }
    else
    {
      $this->requestedFloors[] = $aRequestedFloor;
    }
    return true;
  }

  public function removeRequestedFloor($aRequestedFloor)
  {
    if ($this->indexOfRequestedFloor($aRequestedFloor) == -1)
    {
      return false;
    }
    else
    {
      unset($this->requestedFloors[$this->indexOfRequestedFloor($aRequestedFloor)]);
      $this->requestedFloors = array_values($this->requestedFloors);
      $aRequestedFloor->setOnItsWayTo(null);
      return true;
    }
  }

  public function addRidingPerson($aRidingPerson)
  {
    if ($this->indexOfRidingPerson($aRidingPerson) != -1)
    {
      return false;
    }

    $existingElevator = $aRidingPerson->getElevator();
    if ($existingElevator == null)
    {
      $this->ridingPersons[] = $aRidingPerson;
      $aRidingPerson->setElevator($this);
    }
    else if ($existingElevator != $this)
    {
      $existingElevator->removeRidingPerson($aRidingPerson);
      $this->addRidingPerson($aRidingPerson);
    }
    else
    {
      $this->ridingPersons[] = $aRidingPerson;
    }
    return true;
  }

  public function removeRidingPerson($aRidingPerson)
  {
    if ($this->indexOfRidingPerson($aRidingPerson) == -1)
    {
      return false;
    }
    else
    {
      unset($this->ridingPersons[$this->indexOfRidingPerson($aRidingPerson)]);
      $this->ridingPersons = array_values($this->ridingPersons);
      $aRidingPerson->setElevator(null);
      return true;
    }
  }

  public function setBuilding($aBuilding)
  {
    if ($aBuilding == null)
    {
      return false;
    }
    
    $existingBuilding = $this->building;
    $this->building = $aBuilding;
    if ($existingBuilding != null && $existingBuilding != $aBuilding)
    {
      $existingBuilding->removeElevator($this);
    }
    $this->building->addElevator($this);
    return true;
  }

  public function setFloor($newFloor)
  {
    if ($newFloor == null)
    {
      $existingFloor = $this->floor;
      $this->floor = null;
      
      if ($existingFloor != null && $existingFloor->getElevatorOnThisFloor() != null)
      {
        $existingFloor->setElevatorOnThisFloor(null);
      }
      return;
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