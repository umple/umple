/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 11 "Ovens.ump"
public class Oven1
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Oven1 Attributes
  private int leftTime;

  //Oven1 State Machines
  enum Cook { OFF, ON }
  private Cook cook;
  enum Ovenstate { s1_1, s1_2, s1_3 }
  private Ovenstate ovenstate;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Oven1()
  {
    leftTime = 0;
    setCook(Cook.OFF);
    setOvenstate(Ovenstate.s1_1);
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
      case s1_1:
        if (t>0)
        {
        // line 16 "Ovens.ump"
          leftTime = t;
          setOvenstate(Ovenstate.s1_2);
          wasEventProcessed = true;
          break;
        }
        break;
      case s1_2:
        if (t>0)
        {
        // line 19 "Ovens.ump"
          leftTime = t;
          setOvenstate(Ovenstate.s1_2);
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
      case s1_2:
        // line 20 "Ovens.ump"
        cook = Cook.ON;
        setOvenstate(Ovenstate.s1_3);
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