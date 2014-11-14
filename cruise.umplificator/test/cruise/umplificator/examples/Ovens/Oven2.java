/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



/**
 * Version of the Oven with a low-cohesion, hight-coupling state machine
 */
// line 28 "Ovens.ump"
public class Oven2
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Oven2 Attributes
  private int leftTime;

  //Oven2 State Machines
  enum Cook { OFF, ON }
  private Cook cook;
  enum Ovenstate { s2_1, s2_2, s2_3, s2_4 }
  private Ovenstate ovenstate;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Oven2()
  {
    leftTime = 0;
    setCook(Cook.OFF);
    setOvenstate(Ovenstate.s2_1);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLeftTime(int aLeftTime)
  {
    boolean wasSet = false;
    leftTime = aLeftTime;
    wasSet = true;
    return wasSet;
  }

  public int getLeftTime()
  {
    return leftTime;
  }

  public String getCookFullName()
  {
    String answer = cook.toString();
    return answer;
  }

  public String getOvenstateFullName()
  {
    String answer = ovenstate.toString();
    return answer;
  }

  public Cook getCook()
  {
    return cook;
  }

  public Ovenstate getOvenstate()
  {
    return ovenstate;
  }

  public boolean enterTime(Integer t)
  {
    boolean wasEventProcessed = false;
    
    Ovenstate aOvenstate = ovenstate;
    switch (aOvenstate)
    {
      case s2_1:
        if (t>1)
        {
        // line 33 "Ovens.ump"
          leftTime = t;
          setOvenstate(Ovenstate.s2_2);
          wasEventProcessed = true;
          break;
        }
        if (t==1)
        {
        // line 34 "Ovens.ump"
          leftTime = t;
          setOvenstate(Ovenstate.s2_3);
          wasEventProcessed = true;
          break;
        }
        break;
      case s2_2:
        if (t>1)
        {
        // line 37 "Ovens.ump"
          leftTime = t;
          setOvenstate(Ovenstate.s2_2);
          wasEventProcessed = true;
          break;
        }
        if (t==1)
        {
        // line 38 "Ovens.ump"
          leftTime = t;
          setOvenstate(Ovenstate.s2_3);
          wasEventProcessed = true;
          break;
        }
        break;
      case s2_3:
        if (t>1)
        {
        // line 42 "Ovens.ump"
          leftTime = t;
          setOvenstate(Ovenstate.s2_2);
          wasEventProcessed = true;
          break;
        }
        if (t==1)
        {
        // line 43 "Ovens.ump"
          leftTime = t;
          setOvenstate(Ovenstate.s2_3);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean start()
  {
    boolean wasEventProcessed = false;
    
    Ovenstate aOvenstate = ovenstate;
    switch (aOvenstate)
    {
      case s2_2:
        setOvenstate(Ovenstate.s2_4);
        wasEventProcessed = true;
        break;
      case s2_3:
        setOvenstate(Ovenstate.s2_4);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean setCook(Cook aCook)
  {
    cook = aCook;
    return true;
  }

  private void setOvenstate(Ovenstate aOvenstate)
  {
    ovenstate = aOvenstate;

    // entry actions and do activities
    switch(ovenstate)
    {
      case s2_4:
        // line 47 "Ovens.ump"
        cook = Cook.ON;
        break;
    }
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "leftTime" + ":" + getLeftTime()+ "]"
     + outputString;
  }
}