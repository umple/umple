/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package routesAndLocations;

/**
 * Turns are used to model illegal turns, e.g. turning left
 * when there is 'no left turn' allowed, or 'no U turn' allowed.
 */
// line 80 "../../RoutesAndLocations.ump"
// line 132 "../../RoutesAndLocations.ump"
public class Turn
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Turn Attributes
  private RoadSegment turnFrom;
  private RoadSegment turnTo;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Turn(RoadSegment aTurnFrom, RoadSegment aTurnTo)
  {
    turnFrom = aTurnFrom;
    turnTo = aTurnTo;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTurnFrom(RoadSegment aTurnFrom)
  {
    boolean wasSet = false;
    turnFrom = aTurnFrom;
    wasSet = true;
    return wasSet;
  }

  public boolean setTurnTo(RoadSegment aTurnTo)
  {
    boolean wasSet = false;
    turnTo = aTurnTo;
    wasSet = true;
    return wasSet;
  }

  public RoadSegment getTurnFrom()
  {
    return turnFrom;
  }

  public RoadSegment getTurnTo()
  {
    return turnTo;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "turnFrom" + "=" + (getTurnFrom() != null ? !getTurnFrom().equals(this)  ? getTurnFrom().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "turnTo" + "=" + (getTurnTo() != null ? !getTurnTo().equals(this)  ? getTurnTo().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}