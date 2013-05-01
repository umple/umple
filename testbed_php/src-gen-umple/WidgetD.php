<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.${svn.Revision} modeling language!*/

class WidgetD
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //WidgetD Attributes
  private $id;
  private $logs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aId)
  {
    $this->id = $aId;
    $this->logs = array();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setId($aId)
  {
    $wasSet = false;
    // line 32 "../../../../src/TestHarnessPatterns.ump"
    addLog("before setId:" + id);
    $this->id = $aId;
    $wasSet = true;
    // line 33 "../../../../src/TestHarnessPatterns.ump"
    addLog("after setId:" + id);
    return $wasSet;
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

  public function getId()
  {
    // line 34 "../../../../src/TestHarnessPatterns.ump"
    addLog("before getId");
    $aId = $this->id;
    // line 35 "../../../../src/TestHarnessPatterns.ump"
    addLog("after getId");
    return $aId;
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

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>