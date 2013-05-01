<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

// The class representing the telephone system
class PhoneSystemSimulation
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static $theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PhoneSystemSimulation Attributes
  private $line1;
  private $line2;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private function __construct()
  {
    $this->line1 = new PhoneLine("line1");
    $this->line2 = new PhoneLine("line2");
  }

  public static function getInstance()
  {
    if(self::$theInstance == null)
    {
      self::$theInstance = new PhoneSystemSimulation();
    }
    return self::$theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setLine1($aLine1)
  {
    $wasSet = false;
    $this->line1 = $aLine1;
    $wasSet = true;
    return $wasSet;
  }

  public function setLine2($aLine2)
  {
    $wasSet = false;
    $this->line2 = $aLine2;
    $wasSet = true;
    return $wasSet;
  }

  public function getLine1()
  {
    return $this->line1;
  }

  public function getLine2()
  {
    return $this->line2;
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
  
  // line 8 ../Phone.ump
  static PhoneSystemSimulation s;
  
  
  
  public static void main(String [ ] args) {
    s = getInstance();
    
    while(true) {
    
      // To Do - randomly choose who initiates
    
    
      // Initate a call
      s.line1.startDialing();
      s.line1.pause(200);
      s.line1.setOtherParty(s.line2);
      s.line1.completeNumber();
        s.line1.p(); s.line2.p(); // Will be done by tracing associations

      // The other party can choose whether to pick up or not.
      if(Math.random() > 0.5) {
        s.line2.pickUp();
      
        // While talking either party can hang up
        if(Math.random() > 0.5) {
          s.line1.hangUp();
          s.line2.hangUp(); // assuming it doesn't forget
        }
        else {
          s.line2.hangUp();
          s.line1.hangUp(); // assuming it doesn't forget
        }
      }
      else {
        // Hang up while waiting and the other will too
        s.line1.hangUp();
      }
    }
  }
}
?>