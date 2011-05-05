<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.6.0.1712 modeling language!*/

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
    $this->name = $aName;
    return true;
  }

  public function getName()
  {
    return $this->name;
  }

  public function getFloor($index)
  {
    return $this->floors[$index];
  }

  public function getFloors()
  {
    return $this->floors;
  }

  public function numberOfFloors()
  {
    return count($this->floors);
  }

  public function hasFloors()
  {
    return $this->numberOfFloors() > 0;
  }

  public function indexOfFloor($aFloor)
  {
    $rawAnswer = array_search($aFloor,$this->floors);
    return $rawAnswer == null && $rawAnswer !== 0 ? -1 : $rawAnswer; 
  }

  public function getElevator($index)
  {
    return $this->elevators[$index];
  }

  public function getElevators()
  {
    return $this->elevators;
  }

  public function numberOfElevators()
  {
    return count($this->elevators);
  }

  public function hasElevators()
  {
    return $this->numberOfElevators() > 0;
  }

  public function indexOfElevator($aElevator)
  {
    $rawAnswer = array_search($aElevator,$this->elevators);
    return $rawAnswer == null && $rawAnswer !== 0 ? -1 : $rawAnswer; 
  }

  public function addFloorVia()
  {
    return new Floor($this);
  }

  public function addFloor($aFloor)
  {
    if ($this->indexOfFloor($aFloor) != -1)
    {
      return false;
    }

    $existingBuilding = $aFloor->getBuilding();
    $isNewBuilding = $existingBuilding != null && $existingBuilding != $this;

    if ($isNewBuilding)
    {
      $aFloor->setBuilding($this);
    }
    else
    {
      $this->floors[] = $aFloor;
    }
    return true;
  }

  public function removeFloor($aFloor)
  {
    //Unable to remove aFloor, as it must always have a building
    if ($aFloor->getBuilding() == $this)
    {
      return false;
    }
    else
    {
      unset($this->floors[$this->indexOfFloor($aFloor)]);
      $this->floors = array_values($this->floors);
      return true;
    }
  }

  public function addElevatorVia($aDirection, $aIsMoving)
  {
    return new Elevator($aDirection, $aIsMoving, $this);
  }

  public function addElevator($aElevator)
  {
    if ($this->indexOfElevator($aElevator) != -1)
    {
      return false;
    }

    $existingBuilding = $aElevator->getBuilding();
    $isNewBuilding = $existingBuilding != null && $existingBuilding != $this;

    if ($isNewBuilding)
    {
      $aElevator->setBuilding($this);
    }
    else
    {
      $this->elevators[] = $aElevator;
    }
    return true;
  }

  public function removeElevator($aElevator)
  {
    //Unable to remove aElevator, as it must always have a building
    if ($aElevator->getBuilding() == $this)
    {
      return false;
    }
    else
    {
      unset($this->elevators[$this->indexOfElevator($aElevator)]);
      $this->elevators = array_values($this->elevators);
      return true;
    }
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