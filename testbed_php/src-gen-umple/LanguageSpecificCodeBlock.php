<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

class LanguageSpecificCodeBlock
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //LanguageSpecificCodeBlock Attributes
  private $name;

  //LanguageSpecificCodeBlock State Machines
  private static $StateAllLanguages = 1;
  private static $StateTo = 2;
  private $state;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aName)
  {
    $this->name = $aName;
    $this->setState(self::$StateAllLanguages);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setName($aName)
  {
    $wasSet = false;
    // line 70 "../../../../src/TestHarnessPatterns.ump"
    $lang = "I am ";
    $this->name = $aName;
    $wasSet = true;
    // line 71 "../../../../src/TestHarnessPatterns.ump"
    $this->name = $lang + "php";
    return $wasSet;
  }

  public function getName()
  {
    return $this->name;
  }

  public function getLanguageImplementedIn()
  {
    return "Php";
  }

  public function getStateFullName()
  {
    $answer = $this->getState();
    return $answer;
  }

  public function getState()
  {
    if ($this->state == self::$StateAllLanguages) { return "StateAllLanguages"; }
    elseif ($this->state == self::$StateTo) { return "StateTo"; }
    return null;
  }

  public function applySpecificAction()
  {
    $wasEventProcessed = false;
    
    $aState = $this->state;
    if ($aState == self::$StateAllLanguages)
    {
      if (!$this->isJava())
      {
        $this->name = "actionphp";
        $this->setState(self::$StateTo);
        $wasEventProcessed = true;
      }
    }
    return $wasEventProcessed;
  }

  private function setState($aState)
  {
    $this->state = $aState;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

  public function isJava()
  {
    
return false;
  }

}
?>