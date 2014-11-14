/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 4 "ParliamentBill.ump"
public class Bill
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Bill Attributes
  private boolean isCommonsBill;

  //Bill State Machines
  enum BillState { inPreparation, inHouseOfCommons, inSenate, awaitingRoyalAssent, actOfParliament, withdrawn }
  enum BillStateInHouseOfCommons { Null, firstReading, secondReading, committeeConsideration, thirdReading }
  enum BillStateInSenate { Null, firstReadingS, secondReadingS, committeeConsiderationS, thirdReadingS }
  private BillState billState;
  private BillStateInHouseOfCommons billStateInHouseOfCommons;
  private BillStateInSenate billStateInSenate;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Bill()
  {
    isCommonsBill = true;
    setBillStateInHouseOfCommons(BillStateInHouseOfCommons.Null);
    setBillStateInSenate(BillStateInSenate.Null);
    setBillState(BillState.inPreparation);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIsCommonsBill(boolean aIsCommonsBill)
  {
    boolean wasSet = false;
    isCommonsBill = aIsCommonsBill;
    wasSet = true;
    return wasSet;
  }

  public boolean getIsCommonsBill()
  {
    return isCommonsBill;
  }

  public boolean isIsCommonsBill()
  {
    return isCommonsBill;
  }

  public String getBillStateFullName()
  {
    String answer = billState.toString();
    if (billStateInHouseOfCommons != BillStateInHouseOfCommons.Null) { answer += "." + billStateInHouseOfCommons.toString(); }
    if (billStateInSenate != BillStateInSenate.Null) { answer += "." + billStateInSenate.toString(); }
    return answer;
  }

  public BillState getBillState()
  {
    return billState;
  }

  public BillStateInHouseOfCommons getBillStateInHouseOfCommons()
  {
    return billStateInHouseOfCommons;
  }

  public BillStateInSenate getBillStateInSenate()
  {
    return billStateInSenate;
  }

  public boolean introduceInHouse()
  {
    boolean wasEventProcessed = false;
    
    BillState aBillState = billState;
    switch (aBillState)
    {
      case inPreparation:
        setBillState(BillState.inHouseOfCommons);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean introduceInSenate()
  {
    boolean wasEventProcessed = false;
    
    BillState aBillState = billState;
    switch (aBillState)
    {
      case inPreparation:
        // line 9 "ParliamentBill.ump"
        isCommonsBill = false;
        setBillState(BillState.inSenate);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean withdraw()
  {
    boolean wasEventProcessed = false;
    
    BillState aBillState = billState;
    switch (aBillState)
    {
      case inHouseOfCommons:
        exitBillState();
        setBillState(BillState.withdrawn);
        wasEventProcessed = true;
        break;
      case inSenate:
        exitBillState();
        setBillState(BillState.withdrawn);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean voteFails()
  {
    boolean wasEventProcessed = false;
    
    BillState aBillState = billState;
    switch (aBillState)
    {
      case inHouseOfCommons:
        exitBillState();
        setBillState(BillState.withdrawn);
        wasEventProcessed = true;
        break;
      case inSenate:
        exitBillState();
        setBillState(BillState.withdrawn);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean royalAssent()
  {
    boolean wasEventProcessed = false;
    
    BillState aBillState = billState;
    switch (aBillState)
    {
      case awaitingRoyalAssent:
        setBillState(BillState.actOfParliament);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean modify()
  {
    boolean wasEventProcessed = false;
    
    BillState aBillState = billState;
    switch (aBillState)
    {
      case withdrawn:
        setBillState(BillState.inPreparation);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean enterInHouseOfCommons()
  {
    boolean wasEventProcessed = false;
    
    BillStateInHouseOfCommons aBillStateInHouseOfCommons = billStateInHouseOfCommons;
    switch (aBillStateInHouseOfCommons)
    {
      case Null:
        setBillStateInHouseOfCommons(BillStateInHouseOfCommons.firstReading);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean exitInHouseOfCommons()
  {
    boolean wasEventProcessed = false;
    
    BillStateInHouseOfCommons aBillStateInHouseOfCommons = billStateInHouseOfCommons;
    switch (aBillStateInHouseOfCommons)
    {
      case firstReading:
        setBillStateInHouseOfCommons(BillStateInHouseOfCommons.Null);
        wasEventProcessed = true;
        break;
      case secondReading:
        setBillStateInHouseOfCommons(BillStateInHouseOfCommons.Null);
        wasEventProcessed = true;
        break;
      case committeeConsideration:
        setBillStateInHouseOfCommons(BillStateInHouseOfCommons.Null);
        wasEventProcessed = true;
        break;
      case thirdReading:
        setBillStateInHouseOfCommons(BillStateInHouseOfCommons.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean votePasses()
  {
    boolean wasEventProcessed = false;
    
    BillStateInHouseOfCommons aBillStateInHouseOfCommons = billStateInHouseOfCommons;
    BillStateInSenate aBillStateInSenate = billStateInSenate;
    switch (aBillStateInHouseOfCommons)
    {
      case firstReading:
        setBillStateInHouseOfCommons(BillStateInHouseOfCommons.secondReading);
        wasEventProcessed = true;
        break;
      case secondReading:
        setBillStateInHouseOfCommons(BillStateInHouseOfCommons.committeeConsideration);
        wasEventProcessed = true;
        break;
      case committeeConsideration:
        setBillStateInHouseOfCommons(BillStateInHouseOfCommons.thirdReading);
        wasEventProcessed = true;
        break;
      case thirdReading:
        if (getIsCommonsBill())
        {
          exitBillState();
          setBillState(BillState.inSenate);
          wasEventProcessed = true;
          break;
        }
        if (!getIsCommonsBill())
        {
          exitBillState();
          setBillState(BillState.awaitingRoyalAssent);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    switch (aBillStateInSenate)
    {
      case firstReadingS:
        setBillStateInSenate(BillStateInSenate.secondReadingS);
        wasEventProcessed = true;
        break;
      case secondReadingS:
        setBillStateInSenate(BillStateInSenate.committeeConsiderationS);
        wasEventProcessed = true;
        break;
      case committeeConsiderationS:
        setBillStateInSenate(BillStateInSenate.thirdReadingS);
        wasEventProcessed = true;
        break;
      case thirdReadingS:
        if (getIsCommonsBill())
        {
          exitBillState();
          setBillState(BillState.awaitingRoyalAssent);
          wasEventProcessed = true;
          break;
        }
        if (!getIsCommonsBill())
        {
          exitBillState();
          setBillState(BillState.inHouseOfCommons);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean enterInSenate()
  {
    boolean wasEventProcessed = false;
    
    BillStateInSenate aBillStateInSenate = billStateInSenate;
    switch (aBillStateInSenate)
    {
      case Null:
        setBillStateInSenate(BillStateInSenate.firstReadingS);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean exitInSenate()
  {
    boolean wasEventProcessed = false;
    
    BillStateInSenate aBillStateInSenate = billStateInSenate;
    switch (aBillStateInSenate)
    {
      case firstReadingS:
        setBillStateInSenate(BillStateInSenate.Null);
        wasEventProcessed = true;
        break;
      case secondReadingS:
        setBillStateInSenate(BillStateInSenate.Null);
        wasEventProcessed = true;
        break;
      case committeeConsiderationS:
        setBillStateInSenate(BillStateInSenate.Null);
        wasEventProcessed = true;
        break;
      case thirdReadingS:
        setBillStateInSenate(BillStateInSenate.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitBillState()
  {
    switch(billState)
    {
      case inHouseOfCommons:
        exitInHouseOfCommons();
        break;
      case inSenate:
        exitInSenate();
        break;
    }
  }

  private void setBillState(BillState aBillState)
  {
    billState = aBillState;

    // entry actions and do activities
    switch(billState)
    {
      case inHouseOfCommons:
        if (billStateInHouseOfCommons == BillStateInHouseOfCommons.Null) { setBillStateInHouseOfCommons(BillStateInHouseOfCommons.firstReading); }
        break;
      case inSenate:
        if (billStateInSenate == BillStateInSenate.Null) { setBillStateInSenate(BillStateInSenate.firstReadingS); }
        break;
    }
  }

  private void setBillStateInHouseOfCommons(BillStateInHouseOfCommons aBillStateInHouseOfCommons)
  {
    billStateInHouseOfCommons = aBillStateInHouseOfCommons;
    if (billState != BillState.inHouseOfCommons && aBillStateInHouseOfCommons != BillStateInHouseOfCommons.Null) { setBillState(BillState.inHouseOfCommons); }
  }

  private void setBillStateInSenate(BillStateInSenate aBillStateInSenate)
  {
    billStateInSenate = aBillStateInSenate;
    if (billState != BillState.inSenate && aBillStateInSenate != BillStateInSenate.Null) { setBillState(BillState.inSenate); }
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "isCommonsBill" + ":" + getIsCommonsBill()+ "]"
     + outputString;
  }
}