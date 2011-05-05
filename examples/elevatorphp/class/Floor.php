<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.6.0.1712 modeling language!*/

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
    return $this->waitingPersons[$index];
  }

  public function getWaitingPersons()
  {
    return $this->waitingPersons;
  }

  public function numberOfWaitingPersons()
  {
    return count($this->waitingPersons);
  }

  public function hasWaitingPersons()
  {
    return $this->numberOfWaitingPersons() > 0;
  }

  public function indexOfWaitingPerson($aWaitingPerson)
  {
    $rawAnswer = array_search($aWaitingPerson,$this->waitingPersons);
    return $rawAnswer == null && $rawAnswer !== 0 ? -1 : $rawAnswer; 
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
    return $this->exitAtPersons[$index];
  }

  public function getExitAtPersons()
  {
    return $this->exitAtPersons;
  }

  public function numberOfExitAtPersons()
  {
    return count($this->exitAtPersons);
  }

  public function hasExitAtPersons()
  {
    return $this->numberOfExitAtPersons() > 0;
  }

  public function indexOfExitAtPerson($aExitAtPerson)
  {
    $rawAnswer = array_search($aExitAtPerson,$this->exitAtPersons);
    return $rawAnswer == null && $rawAnswer !== 0 ? -1 : $rawAnswer; 
  }

  public function addWaitingPerson($aWaitingPerson)
  {
    if ($this->indexOfWaitingPerson($aWaitingPerson) != -1)
    {
      return false;
    }

    $existingFloor = $aWaitingPerson->getFloor();
    if ($existingFloor == null)
    {
      $this->waitingPersons[] = $aWaitingPerson;
      $aWaitingPerson->setFloor($this);
    }
    else if ($existingFloor != $this)
    {
      $existingFloor->removeWaitingPerson($aWaitingPerson);
      $this->addWaitingPerson($aWaitingPerson);
    }
    else
    {
      $this->waitingPersons[] = $aWaitingPerson;
    }
    return true;
  }

  public function removeWaitingPerson($aWaitingPerson)
  {
    if ($this->indexOfWaitingPerson($aWaitingPerson) == -1)
    {
      return false;
    }
    else
    {
      unset($this->waitingPersons[$this->indexOfWaitingPerson($aWaitingPerson)]);
      $this->waitingPersons = array_values($this->waitingPersons);
      $aWaitingPerson->setFloor(null);
      return true;
    }
  }

  public function setElevatorOnThisFloor($newElevatorOnThisFloor)
  {
    if ($newElevatorOnThisFloor == null)
    {
      $existingElevatorOnThisFloor = $this->elevatorOnThisFloor;
      $this->elevatorOnThisFloor = null;
      
      if ($existingElevatorOnThisFloor != null && $existingElevatorOnThisFloor->getFloor() != null)
      {
        $existingElevatorOnThisFloor->setFloor(null);
      }
      return;
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
  }

  public function setUpRequest($newUpRequest)
  {
    if ($this->upRequest != null && $this->upRequest != $newUpRequest && $this == $this->upRequest->getFloor())
    {
      //Unable to setUpRequest, as existing upRequest would become an orphan
      return false;
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
    return true;
  }

  public function setDownRequest($newDownRequest)
  {
    if ($this->downRequest != null && $this->downRequest != $newDownRequest && $this == $this->downRequest->getFloor())
    {
      //Unable to setDownRequest, as existing downRequest would become an orphan
      return false;
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
    return true;
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
      $existingBuilding->removeFloor($this);
    }
    $this->building->addFloor($this);
    return true;
  }

  public function setOnItsWayTo($aOnItsWayTo)
  {
    $existingOnItsWayTo = $this->onItsWayTo;
    $this->onItsWayTo = $aOnItsWayTo;
    if ($existingOnItsWayTo != null && $existingOnItsWayTo != $aOnItsWayTo)
    {
      $existingOnItsWayTo->removeRequestedFloor($this);
    }
    if ($aOnItsWayTo != null)
    {
      $aOnItsWayTo->addRequestedFloor($this);  
    }
  }

  public function addExitAtPerson($aExitAtPerson)
  {
    if ($this->indexOfExitAtPerson($aExitAtPerson) != -1)
    {
      return false;
    }

    $existingDesiredFloor = $aExitAtPerson->getDesiredFloor();
    if ($existingDesiredFloor == null)
    {
      $this->exitAtPersons[] = $aExitAtPerson;
      $aExitAtPerson->setDesiredFloor($this);
    }
    else if ($existingDesiredFloor != $this)
    {
      $existingDesiredFloor->removeExitAtPerson($aExitAtPerson);
      $this->addExitAtPerson($aExitAtPerson);
    }
    else
    {
      $this->exitAtPersons[] = $aExitAtPerson;
    }
    return true;
  }

  public function removeExitAtPerson($aExitAtPerson)
  {
    if ($this->indexOfExitAtPerson($aExitAtPerson) == -1)
    {
      return false;
    }
    else
    {
      unset($this->exitAtPersons[$this->indexOfExitAtPerson($aExitAtPerson)]);
      $this->exitAtPersons = array_values($this->exitAtPersons);
      $aExitAtPerson->setDesiredFloor(null);
      return true;
    }
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