/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 98 "BcmsCore.ump"
// line 134 "BcmsCore.ump"
public class Route
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Route Associations
  private Vehicle vehicle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Route()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public Vehicle getVehicle()
  {
    return vehicle;
  }

  public boolean hasVehicle()
  {
    boolean has = vehicle != null;
    return has;
  }

  public boolean setVehicle(Vehicle aNewVehicle)
  {
    boolean wasSet = false;
    if (aNewVehicle == null)
    {
      Vehicle existingVehicle = vehicle;
      vehicle = null;
      
      if (existingVehicle != null && existingVehicle.getRoutePlan() != null)
      {
        existingVehicle.setRoutePlan(null);
      }
      wasSet = true;
      return wasSet;
    }

    Vehicle currentVehicle = getVehicle();
    if (currentVehicle != null && !currentVehicle.equals(aNewVehicle))
    {
      currentVehicle.setRoutePlan(null);
    }

    vehicle = aNewVehicle;
    Route existingRoutePlan = aNewVehicle.getRoutePlan();

    if (!equals(existingRoutePlan))
    {
      aNewVehicle.setRoutePlan(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (vehicle != null)
    {
      vehicle.setRoutePlan(null);
    }
  }

}