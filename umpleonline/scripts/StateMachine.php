<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.10.2.2921 modeling language!*/

class StateMachine
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StateMachine Attributes
  private $name;
  private $events;

  //StateMachine Associations
  private $classOverview;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aName, $aClassOverview)
  {
    $this->name = $aName;
    $this->events = array();
    $didAddClassOverview = $this->setClassOverview($aClassOverview);
    if (!$didAddClassOverview)
    {
      throw new Exception("Unable to create stateMachine due to classOverview");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setName($aName)
  {
    $wasSet = false;
    $this->name = $aName;
    $wasSet = true;
    return $wasSet;
  }

  public function addEvent($aEvent)
  {
    $wasAdded = false;
    $this->events[] = $aEvent;
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeEvent($aEvent)
  {
    $wasRemoved = false;
    unset($this->events[$this->indexOfEvent($aEvent)]);
    $this->events = array_values($this->events);
    $wasRemoved = true;
    return $wasRemoved;
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

  public function hasEvents()
  {
    $has = events.size() > 0;
    return $has;
  }

  public function indexOfEvent($aEvent)
  {
    $rawAnswer = array_search($aEvent,$this->events);
    $index = $rawAnswer == null && $rawAnswer !== 0 ? -1 : $rawAnswer;
    return $index;
  }

  public function getClassOverview()
  {
    return $this->classOverview;
  }

  public function setClassOverview($aClassOverview)
  {
    $wasSet = false;
    if ($aClassOverview == null)
    {
      return $wasSet;
    }
    
    $existingClassOverview = $this->classOverview;
    $this->classOverview = $aClassOverview;
    if ($existingClassOverview != null && $existingClassOverview != $aClassOverview)
    {
      $existingClassOverview->removeStateMachine($this);
    }
    $this->classOverview->addStateMachine($this);
    $wasSet = true;
    return $wasSet;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $this->classOverview->removeStateMachine($this);
  }

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