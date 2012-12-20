<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.0.352 modeling language!*/

class Floor
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static $nextNumber = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Autounique Attributes
  private $number;

  //Floor Associations
  private $waitingPersons;
  private $elevatorOnThisFloor;
  public $upRequest; //until PHP 5.3 (setAccessible)
  public $downRequest; //until PHP 5.3 (setAccessible)
  private $building;
  private $onItsWayTo;
  private $exitAtPersons;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aBuilding)
  {
    $this->number = self::$nextNumber++;
    $this->waitingPersons = array();
    $didAddBuilding = $this->setBuilding($aBuilding);
    if (!$didAddBuilding)
    {
      throw new Exception("Unable to create floor due to building");
    }
    $this->exitAtPersons = array();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getNumber()
  {
    return $this->number;
  }

  public function getWaitingPerson($index)
  {
    $aWaitingPerson = $this->waitingPersons[$index];
    return $aWaitingPerson;
  }

  public function getWaitingPersons()
  {
    $newWaitingPersons = $this->waitingPersons;
    return $newWaitingPersons;
  }

  public function numberOfWaitingPersons()
  {
    $number = count($this->waitingPersons);
    return $number;
  }

  public function hasWaitingPersons()
  {
    $has = $this->numberOfWaitingPersons() > 0;
    return $has;
  }

  public function indexOfWaitingPerson($aWaitingPerson)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->waitingPersons as $waitingPerson)
    {
      if ($waitingPerson->equals($aWaitingPerson))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getElevatorOnThisFloor()
  {
    return $this->elevatorOnThisFloor;
  }

  public function getUpRequest()
  {
    return $this->upRequest;
  }

  public function getDownRequest()
  {
    return $this->downRequest;
  }

  public function getBuilding()
  {
    return $this->building;
  }

  public function getOnItsWayTo()
  {
    return $this->onItsWayTo;
  }

  public function getExitAtPerson($index)
  {
    $aExitAtPerson = $this->exitAtPersons[$index];
    return $aExitAtPerson;
  }

  public function getExitAtPersons()
  {
    $newExitAtPersons = $this->exitAtPersons;
    return $newExitAtPersons;
  }

  public function numberOfExitAtPersons()
  {
    $number = count($this->exitAtPersons);
    return $number;
  }

  public function hasExitAtPersons()
  {
    $has = $this->numberOfExitAtPersons() > 0;
    return $has;
  }

  public function indexOfExitAtPerson($aExitAtPerson)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->exitAtPersons as $exitAtPerson)
    {
      if ($exitAtPerson->equals($aExitAtPerson))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public static function minimumNumberOfWaitingPersons()
  {
    return 0;
  }

  public function addWaitingPerson($aWaitingPerson)
  {
    $wasAdded = false;
    if ($this->indexOfWaitingPerson($aWaitingPerson) !== -1) { return false; }
    $existingFloor = $aWaitingPerson->getFloor();
    if ($existingFloor == null)
    {
      $aWaitingPerson->setFloor($this);
    }
    elseif ($this !== $existingFloor)
    {
      $existingFloor->removeWaitingPerson($aWaitingPerson);
      $this->addWaitingPerson($aWaitingPerson);
    }
    else
    {
      $this->waitingPersons[] = $aWaitingPerson;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeWaitingPerson($aWaitingPerson)
  {
    $wasRemoved = false;
    if ($this->indexOfWaitingPerson($aWaitingPerson) != -1)
    {
      unset($this->waitingPersons[$this->indexOfWaitingPerson($aWaitingPerson)]);
      $this->waitingPersons = array_values($this->waitingPersons);
      if ($this === $aWaitingPerson->getFloor())
      {
        $aWaitingPerson->setFloor(null);
      }
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function setElevatorOnThisFloor($newElevatorOnThisFloor)
  {
    $wasSet = false;
    if ($newElevatorOnThisFloor == null)
    {
      $existingElevatorOnThisFloor = $this->elevatorOnThisFloor;
      $this->elevatorOnThisFloor = null;
      
      if ($existingElevatorOnThisFloor != null && $existingElevatorOnThisFloor->getFloor() != null)
      {
        $existingElevatorOnThisFloor->setFloor(null);
      }
      $wasSet = true;
      return $wasSet;
    }
    
    $currentElevatorOnThisFloor = $this->getElevatorOnThisFloor();
    if ($currentElevatorOnThisFloor != null && $currentElevatorOnThisFloor != $newElevatorOnThisFloor)
    {
      $currentElevatorOnThisFloor->setFloor(null);
    }
    
    $this->elevatorOnThisFloor = $newElevatorOnThisFloor;
    $existingFloor = $newElevatorOnThisFloor->getFloor();
    
    if ($this != $existingFloor)
    {
      $newElevatorOnThisFloor->setFloor($this);
    }
    $wasSet = true;
    return $wasSet;
  }

  public function setUpRequest($newUpRequest)
  {
    $wasSet = false;
    if ($this->upRequest != null && $this->upRequest != $newUpRequest && $this == $this->upRequest->getFloor())
    {
      //Unable to setUpRequest, as existing upRequest would become an orphan
      return $wasSet;
    }
    
    $this->upRequest = $newUpRequest;
    $oldFloor = $newUpRequest != null ? $newUpRequest->getFloor() : null;
    
    if ($this != $oldFloor)
    {
      if ($oldFloor != null)
      {
        $oldFloor->upRequest = null;
      }
      if ($this->upRequest != null)
      {
        $this->upRequest->setFloor($this);
      }
    }
    $wasSet = true;
    return $wasSet;
  }

  public function setDownRequest($newDownRequest)
  {
    $wasSet = false;
    if ($this->downRequest != null && $this->downRequest != $newDownRequest && $this == $this->downRequest->getFloor())
    {
      //Unable to setDownRequest, as existing downRequest would become an orphan
      return $wasSet;
    }
    
    $this->downRequest = $newDownRequest;
    $oldFloor = $newDownRequest != null ? $newDownRequest->getFloor() : null;
    
    if ($this != $oldFloor)
    {
      if ($oldFloor != null)
      {
        $oldFloor->downRequest = null;
      }
      if ($this->downRequest != null)
      {
        $this->downRequest->setFloor($this);
      }
    }
    $wasSet = true;
    return $wasSet;
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
      $existingBuilding->removeFloor($this);
    }
    $this->building->addFloor($this);
    $wasSet = true;
    return $wasSet;
  }

  public function setOnItsWayTo($aOnItsWayTo)
  {
    $wasSet = false;
    $existingOnItsWayTo = $this->onItsWayTo;
    $this->onItsWayTo = $aOnItsWayTo;
    if ($existingOnItsWayTo != null && $existingOnItsWayTo !== $aOnItsWayTo)
    {
      $existingOnItsWayTo->removeRequestedFloor($this);
    }
    if ($aOnItsWayTo != null && $aOnItsWayTo !== $existingOnItsWayTo)
    {
      $aOnItsWayTo->addRequestedFloor($this);
    }
    $wasSet = true;
    return $wasSet;
  }

  public static function minimumNumberOfExitAtPersons()
  {
    return 0;
  }

  public function addExitAtPerson($aExitAtPerson)
  {
    $wasAdded = false;
    if ($this->indexOfExitAtPerson($aExitAtPerson) !== -1) { return false; }
    $existingDesiredFloor = $aExitAtPerson->getDesiredFloor();
    if ($existingDesiredFloor == null)
    {
      $aExitAtPerson->setDesiredFloor($this);
    }
    elseif ($this !== $existingDesiredFloor)
    {
      $existingDesiredFloor->removeExitAtPerson($aExitAtPerson);
      $this->addExitAtPerson($aExitAtPerson);
    }
    else
    {
      $this->exitAtPersons[] = $aExitAtPerson;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeExitAtPerson($aExitAtPerson)
  {
    $wasRemoved = false;
    if ($this->indexOfExitAtPerson($aExitAtPerson) != -1)
    {
      unset($this->exitAtPersons[$this->indexOfExitAtPerson($aExitAtPerson)]);
      $this->exitAtPersons = array_values($this->exitAtPersons);
      if ($this === $aExitAtPerson->getDesiredFloor())
      {
        $aExitAtPerson->setDesiredFloor(null);
      }
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
    foreach ($this->waitingPersons as $aWaitingPerson)
    {
      $aWaitingPerson->setFloor(null);
    }
    if ($this->elevatorOnThisFloor != null)
    {
      $this->elevatorOnThisFloor->setFloor(null);
    }
    $existingUpRequest = $this->upRequest;
    $this->upRequest = null;
    if ($existingUpRequest != null)
    {
      $existingUpRequest->delete();
    }
    $existingDownRequest = $this->downRequest;
    $this->downRequest = null;
    if ($existingDownRequest != null)
    {
      $existingDownRequest->delete();
    }
    $this->building->removeFloor($this);
    if ($this->onItsWayTo != null)
    {
      $this->onItsWayTo->removeRequestedFloor($this);
    }
    foreach ($this->exitAtPersons as $aExitAtPerson)
    {
      $aExitAtPerson->setDesiredFloor(null);
    }
  }

}
?>