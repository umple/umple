<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

class WidgetE
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //WidgetE Attributes
  private $ids;
  private $logs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->ids = array();
    $this->logs = array();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function addId($aId)
  {
    $wasAdded = false;
    // line 44 "../../../../src/TestHarnessPatterns.ump"
    addLog("before addId:" + numberOfIds());
    $this->ids[] = $aId;
    $wasAdded = true;
    // line 45 "../../../../src/TestHarnessPatterns.ump"
    addLog("after addId:" + numberOfIds());
    return $wasAdded;
  }

  public function removeId($aId)
  {
    $wasRemoved = false;
    // line 46 "../../../../src/TestHarnessPatterns.ump"
    addLog("before removeId:" + numberOfIds());
    unset($this->ids[$this->indexOfId($aId)]);
    $this->ids = array_values($this->ids);
    $wasRemoved = true;
    // line 47 "../../../../src/TestHarnessPatterns.ump"
    addLog("after removeId:" + numberOfIds());
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

  public function getId($index)
  {
    // line 50 "../../../../src/TestHarnessPatterns.ump"
    addLog("before getId");
    $aId = $this->ids[$index];
    // line 51 "../../../../src/TestHarnessPatterns.ump"
    addLog("after getId");
    return $aId;
  }

  public function getIds()
  {
    // line 52 "../../../../src/TestHarnessPatterns.ump"
    addLog("before getIds");
    $newIds = $this->ids;
    // line 53 "../../../../src/TestHarnessPatterns.ump"
    addLog("after getIds");
    return $newIds;
  }

  public function numberOfIds()
  {
    $number = count($this->ids);
    return $number;
  }

  public function hasIds()
  {
    $has = ids.size() > 0;
    return $has;
  }

  public function indexOfId($aId)
  {
    // line 48 "../../../../src/TestHarnessPatterns.ump"
    addLog("before indexOfId");
    $rawAnswer = array_search($aId,$this->ids);
    $index = $rawAnswer == null && $rawAnswer !== 0 ? -1 : $rawAnswer;
    // line 49 "../../../../src/TestHarnessPatterns.ump"
    addLog("after indexOfId");
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

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>