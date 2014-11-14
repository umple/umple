/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.sql.Time;
import java.util.*;
import java.sql.Date;

// line 13 "Airline.ump"
// line 61 "Airline.ump"
public class RegularFlight
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<Integer, RegularFlight> regularflightsByFlightNumber = new HashMap<Integer, RegularFlight>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RegularFlight Attributes
  private Time time;
  private int flightNumber;

  //RegularFlight Associations
  private List<SpecificFlight> specificFlights;
  private Airline airline;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RegularFlight(Time aTime, int aFlightNumber, Airline aAirline)
  {
    time = aTime;
    if (!setFlightNumber(aFlightNumber))
    {
      throw new RuntimeException("Cannot create due to duplicate flightNumber");
    }
    specificFlights = new ArrayList<SpecificFlight>();
    boolean didAddAirline = setAirline(aAirline);
    if (!didAddAirline)
    {
      throw new RuntimeException("Unable to create regularFlight due to airline");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTime(Time aTime)
  {
    boolean wasSet = false;
    time = aTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setFlightNumber(int aFlightNumber)
  {
    boolean wasSet = false;
    Integer anOldFlightNumber = getFlightNumber();
    if (hasWithFlightNumber(aFlightNumber)) {
      return wasSet;
    }
    flightNumber = aFlightNumber;
    wasSet = true;
    if (anOldFlightNumber != null) {
      regularflightsByFlightNumber.remove(anOldFlightNumber);
    }
    regularflightsByFlightNumber.put(aFlightNumber, this);
    return wasSet;
  }

  public Time getTime()
  {
    return time;
  }

  public int getFlightNumber()
  {
    return flightNumber;
  }

  public static RegularFlight getWithFlightNumber(int aFlightNumber)
  {
    return regularflightsByFlightNumber.get(aFlightNumber);
  }

  public static boolean hasWithFlightNumber(int aFlightNumber)
  {
    return getWithFlightNumber(aFlightNumber) != null;
  }

  public SpecificFlight getSpecificFlight(int index)
  {
    SpecificFlight aSpecificFlight = specificFlights.get(index);
    return aSpecificFlight;
  }

  public List<SpecificFlight> getSpecificFlights()
  {
    List<SpecificFlight> newSpecificFlights = Collections.unmodifiableList(specificFlights);
    return newSpecificFlights;
  }

  public int numberOfSpecificFlights()
  {
    int number = specificFlights.size();
    return number;
  }

  public boolean hasSpecificFlights()
  {
    boolean has = specificFlights.size() > 0;
    return has;
  }

  public int indexOfSpecificFlight(SpecificFlight aSpecificFlight)
  {
    int index = specificFlights.indexOf(aSpecificFlight);
    return index;
  }

  public Airline getAirline()
  {
    return airline;
  }

  public static int minimumNumberOfSpecificFlights()
  {
    return 0;
  }

  public SpecificFlight addSpecificFlight(Date aDate)
  {
    return new SpecificFlight(aDate, this);
  }

  public boolean addSpecificFlight(SpecificFlight aSpecificFlight)
  {
    boolean wasAdded = false;
    if (specificFlights.contains(aSpecificFlight)) { return false; }
    RegularFlight existingRegularFlight = aSpecificFlight.getRegularFlight();
    boolean isNewRegularFlight = existingRegularFlight != null && !this.equals(existingRegularFlight);
    if (isNewRegularFlight)
    {
      aSpecificFlight.setRegularFlight(this);
    }
    else
    {
      specificFlights.add(aSpecificFlight);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSpecificFlight(SpecificFlight aSpecificFlight)
  {
    boolean wasRemoved = false;
    //Unable to remove aSpecificFlight, as it must always have a regularFlight
    if (!this.equals(aSpecificFlight.getRegularFlight()))
    {
      specificFlights.remove(aSpecificFlight);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addSpecificFlightAt(SpecificFlight aSpecificFlight, int index)
  {  
    boolean wasAdded = false;
    if(addSpecificFlight(aSpecificFlight))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSpecificFlights()) { index = numberOfSpecificFlights() - 1; }
      specificFlights.remove(aSpecificFlight);
      specificFlights.add(index, aSpecificFlight);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSpecificFlightAt(SpecificFlight aSpecificFlight, int index)
  {
    boolean wasAdded = false;
    if(specificFlights.contains(aSpecificFlight))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSpecificFlights()) { index = numberOfSpecificFlights() - 1; }
      specificFlights.remove(aSpecificFlight);
      specificFlights.add(index, aSpecificFlight);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSpecificFlightAt(aSpecificFlight, index);
    }
    return wasAdded;
  }

  public boolean setAirline(Airline aAirline)
  {
    boolean wasSet = false;
    if (aAirline == null)
    {
      return wasSet;
    }

    Airline existingAirline = airline;
    airline = aAirline;
    if (existingAirline != null && !existingAirline.equals(aAirline))
    {
      existingAirline.removeRegularFlight(this);
    }
    airline.addRegularFlight(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    regularflightsByFlightNumber.remove(getFlightNumber());
    for(int i=specificFlights.size(); i > 0; i--)
    {
      SpecificFlight aSpecificFlight = specificFlights.get(i - 1);
      aSpecificFlight.delete();
    }
    Airline placeholderAirline = airline;
    this.airline = null;
    placeholderAirline.removeRegularFlight(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "flightNumber" + ":" + getFlightNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "time" + "=" + (getTime() != null ? !getTime().equals(this)  ? getTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "airline = "+(getAirline()!=null?Integer.toHexString(System.identityHashCode(getAirline())):"null")
     + outputString;
  }
}