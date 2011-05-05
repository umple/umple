<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.0.352 modeling language!*/

class UpRequest extends FloorRequest
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UpRequest Associations
  private $floor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aIsCalled, $aFloor)
  {
    parent::__construct($aIsCalled);
    $didAddFloor = $this->setFloor($aFloor);
    if (!$didAddFloor)
    {
      throw new Exception("Unable to create upRequest due to floor");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getFloor()
  {
    return $this->floor;
  }

  public function setFloor($newFloor)
  {
    $wasSet = false;
    if ($newFloor == null)
    {
      //Unable to setFloor to null, as upRequest must always be associated to a floor
      return $wasSet;
    }
    
    $existingUpRequest = $newFloor->getUpRequest();
    if ($existingUpRequest != null && $this != $existingUpRequest)
    {
      //Unable to setFloor, the current floor already has a upRequest, which would be orphaned if it were re-assigned
      return $wasSet;
    }
    
    $oldFloor = $this->floor;
    $this->floor = $newFloor;
    $this->floor->setUpRequest($this);
    
    if ($oldFloor != null)
    {
      $oldFloor->setUpRequest(null);
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
    $existingFloor = $this->floor;
    $this->floor = null;
    if ($existingFloor != null)
    {
      $existingFloor->setUpRequest(null);
    }
    parent::delete();
  }

}
?>