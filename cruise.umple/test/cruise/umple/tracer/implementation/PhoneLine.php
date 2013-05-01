<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

class PhoneLine
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PhoneLine Attributes
  private $id;

  //PhoneLine State Machines
  private static $StateOnHook = 1;
  private static $StateRinging = 2;
  private static $StateCommunicating = 3;
  private static $StateOnHold = 4;
  private static $StateDialing = 5;
  private static $StateWaitingForConnection = 6;
  private static $StateWaitForHook = 7;
  private $state;

  //PhoneLine Associations
  private $otherParty;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aId)
  {
    $this->id = $aId;
    $this->setState(self::$StateOnHook);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setId($aId)
  {
    $wasSet = false;
    $this->id = $aId;
    $wasSet = true;
    return $wasSet;
  }

  public function getId()
  {
    return $this->id;
  }

  public function getStateFullName()
  {
    $answer = $this->getState();
    return $answer;
  }

  public function getState()
  {
    if ($this->state == self::$StateOnHook) { return "StateOnHook"; }
    elseif ($this->state == self::$StateRinging) { return "StateRinging"; }
    elseif ($this->state == self::$StateCommunicating) { return "StateCommunicating"; }
    elseif ($this->state == self::$StateOnHold) { return "StateOnHold"; }
    elseif ($this->state == self::$StateDialing) { return "StateDialing"; }
    elseif ($this->state == self::$StateWaitingForConnection) { return "StateWaitingForConnection"; }
    elseif ($this->state == self::$StateWaitForHook) { return "StateWaitForHook"; }
    return null;
  }

  public function startDialing()
  {
    $wasEventProcessed = false;
    
    $aState = $this->state;
    print("Event=startDialing");
    
    if ($aState == self::$StateOnHook)
    {
      $this->setState(self::$StateDialing);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function incomingCall()
  {
    $wasEventProcessed = false;
    
    $aState = $this->state;
    print("Event=incomingCall");
    
    if ($aState == self::$StateOnHook)
    {
      $this->setState(self::$StateRinging);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function pickUp()
  {
    $wasEventProcessed = false;
    
    $aState = $this->state;
    print("Event=pickUp");
    
    if ($aState == self::$StateRinging)
    {
      getOtherParty().otherPartyPickUp();
      $this->setState(self::$StateCommunicating);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function otherPartyHangUp()
  {
    $wasEventProcessed = false;
    
    $aState = $this->state;
    print("Event=otherPartyHangUp");
    
    if ($aState == self::$StateRinging)
    {
      $this->setState(self::$StateOnHook);
      $wasEventProcessed = true;
    }
    elseif ($aState == self::$StateCommunicating)
    {
      $this->setState(self::$StateWaitForHook);
      $wasEventProcessed = true;
    }
    elseif ($aState == self::$StateOnHold)
    {
      $this->setState(self::$StateWaitForHook);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function hangUp()
  {
    $wasEventProcessed = false;
    
    $aState = $this->state;
    print("Event=hangUp");
    
    if ($aState == self::$StateCommunicating)
    {
      say("click");
      $this->setState(self::$StateOnHook);
      $wasEventProcessed = true;
    }
    elseif ($aState == self::$StateOnHold)
    {
      say("click");
      $this->setState(self::$StateOnHook);
      $wasEventProcessed = true;
    }
    elseif ($aState == self::$StateDialing)
    {
      say("click");
      $this->setState(self::$StateOnHook);
      $wasEventProcessed = true;
    }
    elseif ($aState == self::$StateWaitingForConnection)
    {
      say("click");
      $this->setState(self::$StateOnHook);
      $wasEventProcessed = true;
    }
    elseif ($aState == self::$StateWaitForHook)
    {
      say("click");
      $this->setState(self::$StateOnHook);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function putOnHold()
  {
    $wasEventProcessed = false;
    
    $aState = $this->state;
    print("Event=putOnHold");
    
    if ($aState == self::$StateCommunicating)
    {
      $this->setState(self::$StateOnHold);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function takeOffHold()
  {
    $wasEventProcessed = false;
    
    $aState = $this->state;
    print("Event=takeOffHold");
    
    if ($aState == self::$StateOnHold)
    {
      $this->setState(self::$StateCommunicating);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function completeNumber()
  {
    $wasEventProcessed = false;
    
    $aState = $this->state;
    print("Event=completeNumber");
    
    if ($aState == self::$StateDialing)
    {
      $this->setState(self::$StateWaitingForConnection);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function otherPartyPickUp()
  {
    $wasEventProcessed = false;
    
    $aState = $this->state;
    print("Event=otherPartyPickUp");
    
    if ($aState == self::$StateWaitingForConnection)
    {
      $this->setState(self::$StateCommunicating);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function timeOut()
  {
    $wasEventProcessed = false;
    
    $aState = $this->state;
    print("Event=timeOut");
    
    if ($aState == self::$StateWaitingForConnection)
    {
      $this->setState(self::$StateOnHook);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function setState($aState)
  {
    $this->state = $aState;

    // entry actions and do activities
    if ($this->state == self::$StateOnHook)
    {
      print("Tracing state StateOnHook entry action(s)");
      if(getOtherParty() != null) {
          getOtherParty().otherPartyHangUp();
        } 
        setOtherParty(null); p();
    }
    elseif ($this->state == self::$StateRinging)
    {
      say("ring ring ring!");
    }
    elseif ($this->state == self::$StateCommunicating)
    {
      say("Hello "+getOtherParty().getId());
    }
    elseif ($this->state == self::$StateDialing)
    {
      say("pat pat pat");
    }
    elseif ($this->state == self::$StateWaitingForConnection)
    {
      getOtherParty().incomingCall();
    }
    elseif ($this->state == self::$StateWaitForHook)
    {
      say("OOO OOO OOO");
    }
  }

  public function getOtherParty()
  {
    return $this->otherParty;
  }

  public function setOtherParty($aNewOtherParty)
  {
    $wasSet = false;
    if ($aNewOtherParty == null)
    {
      $existingOtherParty = $this->otherParty;
      $this->otherParty = null;
      
      if ($existingOtherParty != null && $existingOtherParty->getOtherParty() != null)
      {
        $existingOtherParty->setOtherParty(null);
      }
      $wasSet = true;
      return $wasSet;
    }
    
    $currentOtherParty = $this->getOtherParty();
    if ($currentOtherParty != null && $currentOtherParty != $aNewOtherParty)
    {
      $currentOtherParty->setOtherParty(null);
    }
    
    $this->otherParty = $aNewOtherParty;
    $existingOtherParty = $aNewOtherParty->getOtherParty();
    
    if ($this != $existingOtherParty)
    {
      $aNewOtherParty->setOtherParty($this);
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
    if ($this->otherParty != null)
    {
      $this->otherParty->setOtherParty(null);
    }
  }

  public function toString()
  {
    return getId();
  }

  public function p()
  {
    System.out.println("  other party of "+getId()+"="+getOtherParty());
  }

  public function say(String s)
  {
    String voice ="";
    if(getId().equals("line2")) voice=" -v Victoria";
    try {
      Runtime.getRuntime().exec("say "+getId()+" "+s+voice);
    }
    catch (IOException e) {}
    pause(2000);
  }

  public function pause(long ms)
  {
    try {
      Thread.currentThread().sleep(ms);//sleep for 1000 ms
    }
    catch(InterruptedException ie){
    }
  }

}
?>