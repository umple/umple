/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



/**
 * Door: controlled passage from one access zone to another
 */
// line 106 "AccessControl2.ump"
// line 214 "AccessControl2.ump"
public class Door
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Door Attributes
  private boolean lock;

  //Door Associations
  private AccessPoint controls;
  private AccessZone accessedThrough;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Door(AccessPoint aControls, AccessZone aAccessedThrough)
  {
    lock = false;
    if (aControls == null || aControls.getDoor() != null)
    {
      throw new RuntimeException("Unable to create Door due to aControls");
    }
    controls = aControls;
    boolean didAddAccessedThrough = setAccessedThrough(aAccessedThrough);
    if (!didAddAccessedThrough)
    {
      throw new RuntimeException("Unable to create door due to accessedThrough");
    }
  }

  public Door(Authorizer aControlsForControls, AccessZone aAccessedThrough)
  {
    lock = false;
    controls = new AccessPoint(this, aControlsForControls);
    boolean didAddAccessedThrough = setAccessedThrough(aAccessedThrough);
    if (!didAddAccessedThrough)
    {
      throw new RuntimeException("Unable to create door due to accessedThrough");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLock(boolean aLock)
  {
    boolean wasSet = false;
    lock = aLock;
    wasSet = true;
    return wasSet;
  }

  public boolean getLock()
  {
    return lock;
  }

  public AccessPoint getControls()
  {
    return controls;
  }

  public AccessZone getAccessedThrough()
  {
    return accessedThrough;
  }

  public boolean setAccessedThrough(AccessZone aAccessedThrough)
  {
    boolean wasSet = false;
    //Must provide accessedThrough to door
    if (aAccessedThrough == null)
    {
      return wasSet;
    }

    if (accessedThrough != null && accessedThrough.numberOfDoors() <= AccessZone.minimumNumberOfDoors())
    {
      return wasSet;
    }

    AccessZone existingAccessedThrough = accessedThrough;
    accessedThrough = aAccessedThrough;
    if (existingAccessedThrough != null && !existingAccessedThrough.equals(aAccessedThrough))
    {
      boolean didRemove = existingAccessedThrough.removeDoor(this);
      if (!didRemove)
      {
        accessedThrough = existingAccessedThrough;
        return wasSet;
      }
    }
    accessedThrough.addDoor(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    AccessPoint existingControls = controls;
    controls = null;
    if (existingControls != null)
    {
      existingControls.delete();
    }
    AccessZone placeholderAccessedThrough = accessedThrough;
    this.accessedThrough = null;
    placeholderAccessedThrough.removeDoor(this);
  }

  // line 110 "AccessControl2.ump"
   public void unLock(){
    setLock(false);
    System.out.println("Door is unLocked  Lock= " + getLock());
  }

  // line 114 "AccessControl2.ump"
   public void lock(){
    setLock(true);
    System.out.println("Door is Locked Lock= " + getLock());
  }

  // line 118 "AccessControl2.ump"
   public void pushDoor(){
    System.out.println("User pushes the door");
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "lock" + ":" + getLock()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "controls = "+(getControls()!=null?Integer.toHexString(System.identityHashCode(getControls())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "accessedThrough = "+(getAccessedThrough()!=null?Integer.toHexString(System.identityHashCode(getAccessedThrough())):"null")
     + outputString;
  }
}