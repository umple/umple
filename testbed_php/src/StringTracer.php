<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.1.605 modeling language!*/

class StringTracer
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static $theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StringTracer Attributes
  private $traces;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private function __construct()
  {
    $this->traces = array();
  }

  public static function getInstance()
  {
    if(self::$theInstance == null)
    {
      self::$theInstance = new StringTracer();
    }
    return self::$theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function addTrace($aTrace)
  {
    $wasAdded = false;
    $this->traces[] = $aTrace;
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeTrace($aTrace)
  {
    $wasRemoved = false;
    unset($this->traces[$this->indexOfTrace($aTrace)]);
    $this->traces = array_values($this->traces);
    $wasRemoved = true;
    return $wasRemoved;
  }

  public function getTrace($index)
  {
    $aTrace = $this->traces[$index];
    return $aTrace;
  }

  public function getTraces()
  {
    $newTraces = $this->traces;
    return $newTraces;
  }

  public function numberOfTraces()
  {
    $number = count($this->traces);
    return $number;
  }

  public function hasTraces()
  {
    $has = traces.size() > 0;
    return $has;
  }

  public function indexOfTrace($aTrace)
  {
    $rawAnswer = array_search($aTrace,$this->traces);
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
  
  public static function execute($message) { self::getInstance()->addTrace($message); }
public function reset() { self::getInstance()->traces = array(); }
}
?>