<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.0.352 modeling language!*/

class Building
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Building Attributes
  private $name;

  //Building Associations
  private $floors;
  private $elevators;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aName)
  {
    $this->name = $aName;
    $this->floors = array();
    $this->elevators = array();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setName($aName)
  {
    $wasSet = false;
    $this->name = $aName;
    $wasSet = true;
    StringTracer::execute("name={$aName}");
    return $wasSet;
  }

  public function getName()
  {
    return $this->name;
  }

  public function getFloor($index)
  {
    $aFloor = $this->floors[$index];
    return $aFloor;
  }

  public function getFloors()
  {
    $newFloors = $this->floors;
    return $newFloors;
  }

  public function numberOfFloors()
  {
    $number = count($this->floors);
    return $number;
  }

  public function hasFloors()
  {
    $has = $this->numberOfFloors() > 0;
    return $has;
  }

  public function indexOfFloor($aFloor)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->floors as $floor)
    {
      if ($floor->equals($aFloor))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getElevator($index)
  {
    $aElevator = $this->elevators[$index];
    return $aElevator;
  }

  public function getElevators()
  {
    $newElevators = $this->elevators;
    return $newElevators;
  }

  public function numberOfElevators()
  {
    $number = count($this->elevators);
    return $number;
  }

  public function hasElevators()
  {
    $has = $this->numberOfElevators() > 0;
    return $has;
  }

  public function indexOfElevator($aElevator)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->elevators as $elevator)
    {
      if ($elevator->equals($aElevator))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public static function minimumNumberOfFloors()
  {
    return 0;
  }

  public function addFloorVia()
  {
    return new Floor($this);
  }

  public function addFloor($aFloor)
  {
    $wasAdded = false;
    if ($this->indexOfFloor($aFloor) !== -1) { return false; }
    $existingBuilding = $aFloor->getBuilding();
    $isNewBuilding = $existingBuilding != null && $this !== $existingBuilding;
    if ($isNewBuilding)
    {
      $aFloor->setBuilding($this);
    }
    else
    {
      $this->floors[] = $aFloor;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeFloor($aFloor)
  {
    $wasRemoved = false;
    //Unable to remove aFloor, as it must always have a building
    if ($this !== $aFloor->getBuilding())
    {
      unset($this->floors[$this->indexOfFloor($aFloor)]);
      $this->floors = array_values($this->floors);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public static function minimumNumberOfElevators()
  {
    return 0;
  }

  public function addElevatorVia($aDirection, $aIsMoving)
  {
    return new Elevator($aDirection, $aIsMoving, $this);
  }

  public function addElevator($aElevator)
  {
    $wasAdded = false;
    if ($this->indexOfElevator($aElevator) !== -1) { return false; }
    $existingBuilding = $aElevator->getBuilding();
    $isNewBuilding = $existingBuilding != null && $this !== $existingBuilding;
    if ($isNewBuilding)
    {
      $aElevator->setBuilding($this);
    }
    else
    {
      $this->elevators[] = $aElevator;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeElevator($aElevator)
  {
    $wasRemoved = false;
    //Unable to remove aElevator, as it must always have a building
    if ($this !== $aElevator->getBuilding())
    {
      unset($this->elevators[$this->indexOfElevator($aElevator)]);
      $this->elevators = array_values($this->elevators);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    foreach ($this->floors as $aFloor)
    {
      $aFloor->delete();
    }
    foreach ($this->elevators as $aElevator)
    {
      $aElevator->delete();
    }
  }

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public function getFloorsReversed()
  {
    return array_reverse($this->getFloors());
  }
  
  public function buttonPressed($action)
  {
    $input = explode("_",$action);
    $direction = $input[1];
    $floorNumber = $input[2];
    
    foreach ($this->getFloors() as $aFloor)
    {
      if ($aFloor->getNumber() == $floorNumber)
      {
        $request = $direction == "up" ? $aFloor->getUpRequest() : $aFloor->getDownRequest();
        $request->setIsCalled(true);
        return;
      }
    }    
  }


  public function nextStep()
  {
    foreach ($this->getElevators() as $elevator)
    {
      $this->moveElevator($elevator);
      $this->openDoors($elevator);
      if ($elevator->getIsMoving() || $elevator->getPercentageDoorOpen() != 1)
      {
        continue;
      }

      $this->peopleEnterElevator($elevator);
      $this->peopleExitElevator($elevator);
    }
  }
  
  public function moveElevator($e)
  {
    if (!$e->getIsMoving())
    {
      return;
    }
    
    $currentFloor = $this->indexOfFloor($e->getFloor());
    $nextFloor = $currentFloor + $e->getDirectionOffset();
    $maxFloor = $this->numberOfFloors() - 1;
    if ($nextFloor <= $maxFloor && $nextFloor >= 0)
    {
      $this->getFloor($nextFloor)->setElevatorOnThisFloor($e);
    }
    
    if ($nextFloor >= $maxFloor || $nextFloor <= 0)
    {
      $e->switchDirections();
    }
  }
  
  public function openDoors($e)
  {
    if ($e->getFloor() == null)
    {
      return;
    }
    $f = $e->getFloor();
    $up = $f->getUpRequest();
    $down = $f->getDownRequest();

    if ($up != null && $e->isUp() && $up->getIsCalled())
    {
      $up->setIsCalled(false);
      $e->setIsMoving(false);
      $e->setPercentageDoorOpen(0.25);
    }
    else if ($down != null && $e->isDown() && $down->getIsCalled())
    {
      $down->setIsCalled(false);
      $e->setIsMoving(false);
      $e->setPercentageDoorOpen(0.25);
    }
    else if ($e->indexOfRequestedFloor($f) != -1)
    {
      $e->removeRequestedFloor($f);
      $e->setIsMoving(false);
      $e->setPercentageDoorOpen(0.25);
    }
    
    if (!$e->getIsMoving() && $e->getPercentageDoorOpen() == 1)
    {
      $e->setPercentageDoorOpen(0);
      $e->setIsMoving(true);
    }
    else if (!$e->getIsMoving())
    {
      $e->setPercentageDoorOpen($e->getPercentageDoorOpen() + 0.25);
    }

  }
  
  public function peopleEnterElevator($e)
  {
    $f = $e->getFloor();
    for ($i=0; $i<$f->numberOfWaitingPersons();)
    {
      $p = $f->getWaitingPerson($i);
      
      if ($p->getDesiredFloor() == null)
      {
        $i++;
        continue;
      }
      $f->removeWaitingPerson($p);
      $e->addRidingPerson($p);
      $e->addRequestedFloor($p->getDesiredFloor());
    }
  }
  
  public function peopleExitElevator($e)
  {
    $f = $e->getFloor();
    for ($i=0; $i<$e->numberOfRidingPersons();)
    {
      $p = $e->getRidingPerson($i);
      if ($f == $p->getDesiredFloor())
      {
        $e->removeRidingPerson($p);
        $p->setDesiredFloor(null);
        $p->setFloor($f);
      }
      else
      {
        $i++;
      }
    }
  }
}
?>