/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



/**
 * The station coordinator is the automated
 * agent of the Human coordinator in
 * either the fire service (FSC) or police 
 * service (PSC).
 * Any running version of this program will 
 * just have one of these active as the
 * current coordinator and one or more active 
 * as remote coordinators to communicate with
 */
// line 89 "BcmsCore.ump"
// line 107 "BcmsCore.ump"
public class StationCoordinator
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StationCoordinator Attributes
  private String identification;
  private boolean police;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StationCoordinator(String aIdentification, boolean aPolice)
  {
    identification = aIdentification;
    police = aPolice;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIdentification(String aIdentification)
  {
    boolean wasSet = false;
    identification = aIdentification;
    wasSet = true;
    return wasSet;
  }

  public boolean setPolice(boolean aPolice)
  {
    boolean wasSet = false;
    police = aPolice;
    wasSet = true;
    return wasSet;
  }

  public String getIdentification()
  {
    return identification;
  }

  /**
   * false for fire
   */
  public boolean getPolice()
  {
    return police;
  }

  public boolean isPolice()
  {
    return police;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "identification" + ":" + getIdentification()+ "," +
            "police" + ":" + getPolice()+ "]"
     + outputString;
  }
}