<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

class CourseR
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseR Attributes
  private $logs;

  //CourseR State Machines
  private static $OneOff = 1;
  private static $OneOn = 2;
  private $one;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->logs = array();
    $this->setOne(self::$OneOff);
  }

  //------------------------
  // INTERFACE
  //------------------------

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

  public function getOneFullName()
  {
    $answer = $this->getOne();
    return $answer;
  }

  public function getOne()
  {
    if ($this->one == self::$OneOff) { return "OneOff"; }
    elseif ($this->one == self::$OneOn) { return "OneOn"; }
    return null;
  }

  public function __autotransition2__()
  {
    $wasEventProcessed = false;
    
    $aOne = $this->one;
    if ($aOne == self::$OneOff)
    {
      $this->exitOne();
      $this->setOne(self::$OneOn);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function exitOne()
  {
    if ($this->one == self::$OneOff)
    {
      $this->addLog("Exit Off");
    }
    elseif ($this->one == self::$OneOn)
    {
      $this->addLog("Exit On");
    }
  }

  private function setOne($aOne)
  {
    $this->one = $aOne;

    // entry actions and do activities
    if ($this->one == self::$OneOff)
    {
      $this->addLog("Enter Off");
      $this->__autotransition2__();
    }
    elseif ($this->one == self::$OneOn)
    {
      $this->addLog("Enter On");
    }
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>