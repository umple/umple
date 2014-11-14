/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 19 "OBDCarSystem.ump"
public class RelativeData
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RelativeData Attributes
  private double relativeWear;
  private double initialAvailability;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RelativeData(double aRelativeWear, double aInitialAvailability)
  {
    relativeWear = aRelativeWear;
    initialAvailability = aInitialAvailability;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRelativeWear(double aRelativeWear)
  {
    boolean wasSet = false;
    relativeWear = aRelativeWear;
    wasSet = true;
    return wasSet;
  }

  public boolean setInitialAvailability(double aInitialAvailability)
  {
    boolean wasSet = false;
    initialAvailability = aInitialAvailability;
    wasSet = true;
    return wasSet;
  }

  public double getRelativeWear()
  {
    return relativeWear;
  }

  public double getInitialAvailability()
  {
    return initialAvailability;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "relativeWear" + ":" + getRelativeWear()+ "," +
            "initialAvailability" + ":" + getInitialAvailability()+ "]"
     + outputString;
  }
}