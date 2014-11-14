/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 35 "WarehouseSystem.ump"
// line 143 "WarehouseSystem.ump"
public class Rwbm
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Rwbm Attributes
  private int id;

  //Rwbm Associations
  private RwbmMovement rwbmMovement;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Rwbm(int aId, RwbmMovement aRwbmMovement)
  {
    id = aId;
    boolean didAddRwbmMovement = setRwbmMovement(aRwbmMovement);
    if (!didAddRwbmMovement)
    {
      throw new RuntimeException("Unable to create rwbm due to rwbmMovement");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(int aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public int getId()
  {
    return id;
  }

  public RwbmMovement getRwbmMovement()
  {
    return rwbmMovement;
  }

  public boolean setRwbmMovement(RwbmMovement aRwbmMovement)
  {
    boolean wasSet = false;
    if (aRwbmMovement == null)
    {
      return wasSet;
    }

    RwbmMovement existingRwbmMovement = rwbmMovement;
    rwbmMovement = aRwbmMovement;
    if (existingRwbmMovement != null && !existingRwbmMovement.equals(aRwbmMovement))
    {
      existingRwbmMovement.removeRwbm(this);
    }
    rwbmMovement.addRwbm(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    RwbmMovement placeholderRwbmMovement = rwbmMovement;
    this.rwbmMovement = null;
    placeholderRwbmMovement.removeRwbm(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "rwbmMovement = "+(getRwbmMovement()!=null?Integer.toHexString(System.identityHashCode(getRwbmMovement())):"null")
     + outputString;
  }
}