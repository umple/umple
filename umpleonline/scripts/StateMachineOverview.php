<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.9.0.2486 modeling language!*/

class StateMachineOverview
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StateMachineOverview Attributes
  private $name;
  private $events;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aName)
  {
    $this->name = $aName;
    $this->events = array();
  }
  
  //------------------------
  // INTERFACE
  //------------------------

  public function setName($aName)
  {
    $this->name = $aName;
    return true;
  }

  public function addEvent($aEvent)
  {
    $this->events[] = $aEvent;
    return true;
  }

  public function removeEvent($aEvent)
  {
    unset($this->events[$this->indexOfEvent($aEvent)]);
    $this->events = array_values($this->events);
    return true;
  }

  public function getName()
  {
    return $this->name;
  }

  public function getEvent($index)
  {
    $aEvent = $this->events[$index];
    return $aEvent;
  }

  public function getEvents()
  {
    $newEvents = $this->events;
    return $newEvents;
  }

  public function numberOfEvents()
  {
    $number = count($this->events); 
    return $number;
  }

  public function indexOfEvent($aEvent)
  {
    $rawAnswer = array_search($aEvent,$this->events);
    $index = $rawAnswer == null && $rawAnswer !== 0 ? -1 : $rawAnswer; 
    return $index;
  }

  public function delete()
  {}

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  function getCurrentState($obj)
  {
    $stateName = call_user_func(array($obj,"get{$this->getName()}"));
    $size = strlen($this->getName());
    $startOfName = substr($stateName,0,$size);
    if ($startOfName == $this->getName())
    {
      $stateName = substr($stateName,$size);
    }
    return $stateName;
  }
}
?>