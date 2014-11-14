/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 74 "OBDCarSystem.ump"
public class ConditionCheckAdapter
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ConditionCheckAdapter Attributes
  private CarInformation carInformation;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ConditionCheckAdapter(CarInformation aCarInformation)
  {
    carInformation = aCarInformation;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCarInformation(CarInformation aCarInformation)
  {
    boolean wasSet = false;
    carInformation = aCarInformation;
    wasSet = true;
    return wasSet;
  }

  public CarInformation getCarInformation()
  {
    return carInformation;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "carInformation" + "=" + (getCarInformation() != null ? !getCarInformation().equals(this)  ? getCarInformation().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}