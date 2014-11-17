/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.sql.Time;

/**
 * Police or fire vehicle
 * From Requirements section 8 Data Dictionary
 */
// line 60 "BcmsCore.ump"
// line 128 "BcmsCore.ump"
public class Vehicle
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Vehicle Attributes
  private String vehicleID;
  private Location currentLocation;
  private Time eta;
  private Location intendedLocation;
  private boolean brokenDown;
  private boolean inTrafficCongestion;

  //Vehicle State Machines
  enum LocationStatus { station, enRouteToCrisis, atCrisis, enrouteReturn }
  private LocationStatus locationStatus;

  //Vehicle Associations
  private Route routePlan;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Vehicle(String aVehicleID, Location aCurrentLocation, Time aEta, Location aIntendedLocation, boolean aBrokenDown, boolean aInTrafficCongestion)
  {
    vehicleID = aVehicleID;
    currentLocation = aCurrentLocation;
    eta = aEta;
    intendedLocation = aIntendedLocation;
    brokenDown = aBrokenDown;
    inTrafficCongestion = aInTrafficCongestion;
    setLocationStatus(LocationStatus.station);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setVehicleID(String aVehicleID)
  {
    boolean wasSet = false;
    vehicleID = aVehicleID;
    wasSet = true;
    return wasSet;
  }

  public boolean setCurrentLocation(Location aCurrentLocation)
  {
    boolean wasSet = false;
    currentLocation = aCurrentLocation;
    wasSet = true;
    return wasSet;
  }

  public boolean setEta(Time aEta)
  {
    boolean wasSet = false;
    eta = aEta;
    wasSet = true;
    return wasSet;
  }

  public boolean setIntendedLocation(Location aIntendedLocation)
  {
    boolean wasSet = false;
    intendedLocation = aIntendedLocation;
    wasSet = true;
    return wasSet;
  }

  public boolean setBrokenDown(boolean aBrokenDown)
  {
    boolean wasSet = false;
    brokenDown = aBrokenDown;
    wasSet = true;
    return wasSet;
  }

  public boolean setInTrafficCongestion(boolean aInTrafficCongestion)
  {
    boolean wasSet = false;
    inTrafficCongestion = aInTrafficCongestion;
    wasSet = true;
    return wasSet;
  }

  public String getVehicleID()
  {
    return vehicleID;
  }

  public Location getCurrentLocation()
  {
    return currentLocation;
  }

  public Time getEta()
  {
    return eta;
  }

  public Location getIntendedLocation()
  {
    return intendedLocation;
  }

  public boolean getBrokenDown()
  {
    return brokenDown;
  }

  public boolean getInTrafficCongestion()
  {
    return inTrafficCongestion;
  }

  public boolean isBrokenDown()
  {
    return brokenDown;
  }

  public boolean isInTrafficCongestion()
  {
    return inTrafficCongestion;
  }

  public String getLocationStatusFullName()
  {
    String answer = locationStatus.toString();
    return answer;
  }

  public LocationStatus getLocationStatus()
  {
    return locationStatus;
  }

  public boolean setLocationStatus(LocationStatus aLocationStatus)
  {
    locationStatus = aLocationStatus;
    return true;
  }

  public Route getRoutePlan()
  {
    return routePlan;
  }

  public boolean hasRoutePlan()
  {
    boolean has = routePlan != null;
    return has;
  }

  public boolean setRoutePlan(Route aNewRoutePlan)
  {
    boolean wasSet = false;
    if (aNewRoutePlan == null)
    {
      Route existingRoutePlan = routePlan;
      routePlan = null;
      
      if (existingRoutePlan != null && existingRoutePlan.getVehicle() != null)
      {
        existingRoutePlan.setVehicle(null);
      }
      wasSet = true;
      return wasSet;
    }

    Route currentRoutePlan = getRoutePlan();
    if (currentRoutePlan != null && !currentRoutePlan.equals(aNewRoutePlan))
    {
      currentRoutePlan.setVehicle(null);
    }

    routePlan = aNewRoutePlan;
    Vehicle existingVehicle = aNewRoutePlan.getVehicle();

    if (!equals(existingVehicle))
    {
      aNewRoutePlan.setVehicle(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (routePlan != null)
    {
      routePlan.setVehicle(null);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "vehicleID" + ":" + getVehicleID()+ "," +
            "brokenDown" + ":" + getBrokenDown()+ "," +
            "inTrafficCongestion" + ":" + getInTrafficCongestion()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "currentLocation" + "=" + (getCurrentLocation() != null ? !getCurrentLocation().equals(this)  ? getCurrentLocation().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "eta" + "=" + (getEta() != null ? !getEta().equals(this)  ? getEta().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "intendedLocation" + "=" + (getIntendedLocation() != null ? !getIntendedLocation().equals(this)  ? getIntendedLocation().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "routePlan = "+(getRoutePlan()!=null?Integer.toHexString(System.identityHashCode(getRoutePlan())):"null")
     + outputString;
  }
}