/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 110 "OBDCarSystem.ump"
public class SensorReader
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SensorReader Attributes
  private double initialAvailability;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SensorReader()
  {
    initialAvailability = 100;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setInitialAvailability(double aInitialAvailability)
  {
    boolean wasSet = false;
    initialAvailability = aInitialAvailability;
    wasSet = true;
    return wasSet;
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
            "initialAvailability" + ":" + getInitialAvailability()+ "]"
     + outputString;
  }
}