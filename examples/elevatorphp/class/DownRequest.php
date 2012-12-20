<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.0.352 modeling language!*/

class DownRequest extends FloorRequest
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DownRequest Associations
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
      throw new Exception("Unable to create downRequest due to floor");
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
      //Unable to setFloor to null, as downRequest must always be associated to a floor
      return $wasSet;
    }
    
    $existingDownRequest = $newFloor->getDownRequest();
    if ($existingDownRequest != null && $this != $existingDownRequest)
    {
      //Unable to setFloor, the current floor already has a downRequest, which would be orphaned if it were re-assigned
      return $wasSet;
    }
    
    $oldFloor = $this->floor;
    $this->floor = $newFloor;
    $this->floor->setDownRequest($this);
    
    if ($oldFloor != null)
    {
      $oldFloor->setDownRequest(null);
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
      $existingFloor->setDownRequest(null);
    }
    parent::delete();
  }

}
?>