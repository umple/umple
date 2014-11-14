/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



/**
 * Version of the Oven with a high-cohesion, low-coupling state machine
 */
// line 53 "Ovens.ump"
public class Oven3
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Oven3 Attributes
  private int leftTime;

  //Oven3 State Machines
  enum Cook { OFF, ON }
  private Cook cook;
  enum Ovenstate { s3_1 }
  private Ovenstate ovenstate;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Oven3()
  {
    leftTime = 0;
    setCook(Cook.OFF);
    setOvenstate(Ovenstate.s3_1);
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
      case s3_1:
        if (getCookFullName().equals(Cook.OFF)&&t>0)
        {
        // line 58 "Ovens.ump"
          leftTime = t;
          setOvenstate(Ovenstate.s3_1);
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
      case s3_1:
        if (getCookFullName().equals(Cook.OFF)&&getLeftTime()>0)
        {
        // line 59 "Ovens.ump"
          cook = Cook.ON;
          setOvenstate(Ovenstate.s3_1);
          wasEventProcessed = true;
          break;
        }
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