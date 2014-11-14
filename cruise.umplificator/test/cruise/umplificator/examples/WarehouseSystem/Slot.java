/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 13 "WarehouseSystem.ump"
// line 138 "WarehouseSystem.ump"
public class Slot
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Slot Attributes
  private int number;
  private double width;

  //Slot Associations
  private SlotSet slotSet;
  private Level level;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Slot(int aNumber, double aWidth, SlotSet aSlotSet, Level aLevel)
  {
    number = aNumber;
    width = aWidth;
    boolean didAddSlotSet = setSlotSet(aSlotSet);
    if (!didAddSlotSet)
    {
      throw new RuntimeException("Unable to create slot due to slotSet");
    }
    boolean didAddLevel = setLevel(aLevel);
    if (!didAddLevel)
    {
      throw new RuntimeException("Unable to create slot due to level");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumber(int aNumber)
  {
    boolean wasSet = false;
    number = aNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setWidth(double aWidth)
  {
    boolean wasSet = false;
    width = aWidth;
    wasSet = true;
    return wasSet;
  }

  public int getNumber()
  {
    return number;
  }

  public double getWidth()
  {
    return width;
  }

  public SlotSet getSlotSet()
  {
    return slotSet;
  }

  public Level getLevel()
  {
    return level;
  }

  public boolean setSlotSet(SlotSet aSlotSet)
  {
    boolean wasSet = false;
    if (aSlotSet == null)
    {
      return wasSet;
    }

    SlotSet existingSlotSet = slotSet;
    slotSet = aSlotSet;
    if (existingSlotSet != null && !existingSlotSet.equals(aSlotSet))
    {
      existingSlotSet.removeSlot(this);
    }
    slotSet.addSlot(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setLevel(Level aLevel)
  {
    boolean wasSet = false;
    if (aLevel == null)
    {
      return wasSet;
    }

    Level existingLevel = level;
    level = aLevel;
    if (existingLevel != null && !existingLevel.equals(aLevel))
    {
      existingLevel.removeSlot(this);
    }
    level.addSlot(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    SlotSet placeholderSlotSet = slotSet;
    this.slotSet = null;
    placeholderSlotSet.removeSlot(this);
    Level placeholderLevel = level;
    this.level = null;
    placeholderLevel.removeSlot(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "number" + ":" + getNumber()+ "," +
            "width" + ":" + getWidth()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "slotSet = "+(getSlotSet()!=null?Integer.toHexString(System.identityHashCode(getSlotSet())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "level = "+(getLevel()!=null?Integer.toHexString(System.identityHashCode(getLevel())):"null")
     + outputString;
  }
}