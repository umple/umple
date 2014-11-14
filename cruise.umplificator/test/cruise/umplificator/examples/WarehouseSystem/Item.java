/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 39 "WarehouseSystem.ump"
// line 101 "WarehouseSystem.ump"
public class Item
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Item Attributes
  private double value;
  private int hazardID;
  private int breakability;

  //Item Associations
  private BoxOrPallet boxOrPallet;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Item(double aValue, int aHazardID, int aBreakability, BoxOrPallet aBoxOrPallet)
  {
    value = aValue;
    hazardID = aHazardID;
    breakability = aBreakability;
    boolean didAddBoxOrPallet = setBoxOrPallet(aBoxOrPallet);
    if (!didAddBoxOrPallet)
    {
      throw new RuntimeException("Unable to create item due to boxOrPallet");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setValue(double aValue)
  {
    boolean wasSet = false;
    value = aValue;
    wasSet = true;
    return wasSet;
  }

  public boolean setHazardID(int aHazardID)
  {
    boolean wasSet = false;
    hazardID = aHazardID;
    wasSet = true;
    return wasSet;
  }

  public boolean setBreakability(int aBreakability)
  {
    boolean wasSet = false;
    breakability = aBreakability;
    wasSet = true;
    return wasSet;
  }

  public double getValue()
  {
    return value;
  }

  public int getHazardID()
  {
    return hazardID;
  }

  public int getBreakability()
  {
    return breakability;
  }

  public BoxOrPallet getBoxOrPallet()
  {
    return boxOrPallet;
  }

  public boolean setBoxOrPallet(BoxOrPallet aBoxOrPallet)
  {
    boolean wasSet = false;
    if (aBoxOrPallet == null)
    {
      return wasSet;
    }

    BoxOrPallet existingBoxOrPallet = boxOrPallet;
    boxOrPallet = aBoxOrPallet;
    if (existingBoxOrPallet != null && !existingBoxOrPallet.equals(aBoxOrPallet))
    {
      existingBoxOrPallet.removeItem(this);
    }
    boxOrPallet.addItem(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    BoxOrPallet placeholderBoxOrPallet = boxOrPallet;
    this.boxOrPallet = null;
    placeholderBoxOrPallet.removeItem(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "value" + ":" + getValue()+ "," +
            "hazardID" + ":" + getHazardID()+ "," +
            "breakability" + ":" + getBreakability()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "boxOrPallet = "+(getBoxOrPallet()!=null?Integer.toHexString(System.identityHashCode(getBoxOrPallet())):"null")
     + outputString;
  }
}