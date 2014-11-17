/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.io.IOException;

// line 65 "Phone.ump"
public class PhoneLine
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  public static final String Click = "click";
  public static final String Dial = "dial";
  public static final String Beep = "beep";
  public static final String Hello = "hello";
  public static final String RingRing = "ring ring";

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PhoneLine Attributes
  private String id;
  private String voice;

  //PhoneLine State Machines
  enum State { onHook, ringing, communicating, onHold, dialing, waitingForConnection, waitForHook }
  private State state;

  //PhoneLine Associations
  private PhoneLine otherParty;
  private PhoneSystemSimulation phoneSystemSimulation;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PhoneLine(String aId, String aVoice, PhoneSystemSimulation aPhoneSystemSimulation)
  {
    id = aId;
    voice = aVoice;
    boolean didAddPhoneSystemSimulation = setPhoneSystemSimulation(aPhoneSystemSimulation);
    if (!didAddPhoneSystemSimulation)
    {
      throw new RuntimeException("Unable to create line due to phoneSystemSimulation");
    }
    setState(State.onHook);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setVoice(String aVoice)
  {
    boolean wasSet = false;
    voice = aVoice;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public String getVoice()
  {
    return voice;
  }

  public String getStateFullName()
  {
    String answer = state.toString();
    return answer;
  }

  public State getState()
  {
    return state;
  }

  public boolean startDialing()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case onHook:
        setState(State.dialing);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean incomingCall()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case onHook:
        setState(State.ringing);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean pickUp()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case ringing:
        // line 90 "Phone.ump"
        getOtherParty().otherPartyPickUp();
        setState(State.communicating);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean otherPartyHangUp()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case ringing:
        setState(State.onHook);
        wasEventProcessed = true;
        break;
      case communicating:
        setState(State.waitForHook);
        wasEventProcessed = true;
        break;
      case onHold:
        setState(State.waitForHook);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean autoPickup()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case ringing:
        // line 92 "Phone.ump"
        getOtherParty().otherPartyPickUp();
        setState(State.communicating);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean hangUp()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case communicating:
        // line 96 "Phone.ump"
        say(Click);
        setState(State.onHook);
        wasEventProcessed = true;
        break;
      case onHold:
        // line 101 "Phone.ump"
        say(Click);
        setState(State.onHook);
        wasEventProcessed = true;
        break;
      case dialing:
        // line 108 "Phone.ump"
        say(Click);
        setState(State.onHook);
        wasEventProcessed = true;
        break;
      case waitingForConnection:
        // line 113 "Phone.ump"
        say(Click);
        setState(State.onHook);
        wasEventProcessed = true;
        break;
      case waitForHook:
        // line 118 "Phone.ump"
        say(Click);
        setState(State.onHook);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean putOnHold()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case communicating:
        setState(State.onHold);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean takeOffHold()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case onHold:
        setState(State.communicating);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean completeNumber()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case dialing:
        setState(State.waitingForConnection);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean otherPartyPickUp()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case waitingForConnection:
        setState(State.communicating);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timeOut()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case waitingForConnection:
        setState(State.onHook);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setState(State aState)
  {
    state = aState;

    // entry actions and do activities
    switch(state)
    {
      case onHook:
        // line 79 "Phone.ump"
        if(getOtherParty() != null) {
          getOtherParty().otherPartyHangUp();
        } 
        setOtherParty(null); p();
        break;
      case ringing:
        // line 89 "Phone.ump"
        say(RingRing);
        break;
      case communicating:
        // line 95 "Phone.ump"
        say(Hello+getOtherParty().getId());
        break;
      case dialing:
        // line 106 "Phone.ump"
        say(Dial);
        break;
      case waitingForConnection:
        // line 111 "Phone.ump"
        getOtherParty().incomingCall();
        break;
      case waitForHook:
        // line 117 "Phone.ump"
        say(Beep);
        break;
    }
  }

  public PhoneLine getOtherParty()
  {
    return otherParty;
  }

  public boolean hasOtherParty()
  {
    boolean has = otherParty != null;
    return has;
  }

  public PhoneSystemSimulation getPhoneSystemSimulation()
  {
    return phoneSystemSimulation;
  }

  public boolean setOtherParty(PhoneLine aNewOtherParty)
  {
    boolean wasSet = false;
    if (aNewOtherParty == null)
    {
      PhoneLine existingOtherParty = otherParty;
      otherParty = null;
      
      if (existingOtherParty != null && existingOtherParty.getOtherParty() != null)
      {
        existingOtherParty.setOtherParty(null);
      }
      wasSet = true;
      return wasSet;
    }

    PhoneLine currentOtherParty = getOtherParty();
    if (currentOtherParty != null && !currentOtherParty.equals(aNewOtherParty))
    {
      currentOtherParty.setOtherParty(null);
    }

    otherParty = aNewOtherParty;
    PhoneLine existingOtherParty = aNewOtherParty.getOtherParty();

    if (!equals(existingOtherParty))
    {
      aNewOtherParty.setOtherParty(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setPhoneSystemSimulation(PhoneSystemSimulation aPhoneSystemSimulation)
  {
    boolean wasSet = false;
    if (aPhoneSystemSimulation == null)
    {
      return wasSet;
    }

    PhoneSystemSimulation existingPhoneSystemSimulation = phoneSystemSimulation;
    phoneSystemSimulation = aPhoneSystemSimulation;
    if (existingPhoneSystemSimulation != null && !existingPhoneSystemSimulation.equals(aPhoneSystemSimulation))
    {
      existingPhoneSystemSimulation.removeLine(this);
    }
    phoneSystemSimulation.addLine(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (otherParty != null)
    {
      otherParty.setOtherParty(null);
    }
    PhoneSystemSimulation placeholderPhoneSystemSimulation = phoneSystemSimulation;
    this.phoneSystemSimulation = null;
    placeholderPhoneSystemSimulation.removeLine(this);
  }

  // line 123 "Phone.ump"
  public String toString(){
    return getId();
  }

  // line 127 "Phone.ump"
  public void p(){
    // System.out.println("  other party of "+getId()+"="+getOtherParty());
  }

  // line 131 "Phone.ump"
  public void say(String s){
    try {
      Runtime.getRuntime().exec("say "+getId()+" "+s+" -v "+getVoice());
    }
    catch (IOException e) {}
    pause(2000);
  }

  // line 139 "Phone.ump"
  public void pause(long ms){
    try {
      Thread.currentThread().sleep(ms);//sleep for 1000 ms
    }
    catch(InterruptedException ie){
    }
  }

}