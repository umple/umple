<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.10.2.2921 modeling language!*/

class History
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //History Attributes
  private $events;
  private $states;
  private $logs;
  private $actions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->events = array();
    $this->states = array();
    $this->logs = array();
    $this->actions = array();
  }

  //------------------------
  // INTERFACE
  //------------------------

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

  public function addState($aState)
  {
    $wasAdded = false;
    $this->states[] = $aState;
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeState($aState)
  {
    $wasRemoved = false;
    unset($this->states[$this->indexOfState($aState)]);
    $this->states = array_values($this->states);
    $wasRemoved = true;
    return $wasRemoved;
  }

  public function addLog($aLog)
  {
    $wasAdded = false;
    $this->logs[] = $aLog;
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeLog($aLog)
  {
    $wasRemoved = false;
    unset($this->logs[$this->indexOfLog($aLog)]);
    $this->logs = array_values($this->logs);
    $wasRemoved = true;
    return $wasRemoved;
  }

  public function addAction($aAction)
  {
    $wasAdded = false;
    $this->actions[] = $aAction;
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeAction($aAction)
  {
    $wasRemoved = false;
    unset($this->actions[$this->indexOfAction($aAction)]);
    $this->actions = array_values($this->actions);
    $wasRemoved = true;
    return $wasRemoved;
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

  public function getState($index)
  {
    $aState = $this->states[$index];
    return $aState;
  }

  public function getStates()
  {
    $newStates = $this->states;
    return $newStates;
  }

  public function numberOfStates()
  {
    $number = count($this->states);
    return $number;
  }

  public function hasStates()
  {
    $has = states.size() > 0;
    return $has;
  }

  public function indexOfState($aState)
  {
    $rawAnswer = array_search($aState,$this->states);
    $index = $rawAnswer == null && $rawAnswer !== 0 ? -1 : $rawAnswer;
    return $index;
  }

  public function getLog($index)
  {
    $aLog = $this->logs[$index];
    return $aLog;
  }

  public function getLogs()
  {
    $newLogs = $this->logs;
    return $newLogs;
  }

  public function numberOfLogs()
  {
    $number = count($this->logs);
    return $number;
  }

  public function hasLogs()
  {
    $has = logs.size() > 0;
    return $has;
  }

  public function indexOfLog($aLog)
  {
    $rawAnswer = array_search($aLog,$this->logs);
    $index = $rawAnswer == null && $rawAnswer !== 0 ? -1 : $rawAnswer;
    return $index;
  }

  public function getAction($index)
  {
    $aAction = $this->actions[$index];
    return $aAction;
  }

  public function getActions()
  {
    $newActions = $this->actions;
    return $newActions;
  }

  public function numberOfActions()
  {
    $number = count($this->actions);
    return $number;
  }

  public function hasActions()
  {
    $has = actions.size() > 0;
    return $has;
  }

  public function indexOfAction($aAction)
  {
    $rawAnswer = array_search($aAction,$this->actions);
    $index = $rawAnswer == null && $rawAnswer !== 0 ? -1 : $rawAnswer;
    return $index;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public function getLatestLogs()
  {
    return array_reverse($this->logs);
  }
}
?>