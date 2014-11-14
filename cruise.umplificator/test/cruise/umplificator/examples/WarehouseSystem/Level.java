/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 18 "WarehouseSystem.ump"
// line 132 "WarehouseSystem.ump"
public class Level
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Level Attributes
  private int height;
  private int number;

  //Level Associations
  private List<Slot> slots;
  private Row row;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Level(int aHeight, int aNumber, Row aRow)
  {
    height = aHeight;
    number = aNumber;
    slots = new ArrayList<Slot>();
    boolean didAddRow = setRow(aRow);
    if (!didAddRow)
    {
      throw new RuntimeException("Unable to create level due to row");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setHeight(int aHeight)
  {
    boolean wasSet = false;
    height = aHeight;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumber(int aNumber)
  {
    boolean wasSet = false;
    number = aNumber;
    wasSet = true;
    return wasSet;
  }

  public int getHeight()
  {
    return height;
  }

  public int getNumber()
  {
    return number;
  }

  public Slot getSlot(int index)
  {
    Slot aSlot = slots.get(index);
    return aSlot;
  }

  public List<Slot> getSlots()
  {
    List<Slot> newSlots = Collections.unmodifiableList(slots);
    return newSlots;
  }

  public int numberOfSlots()
  {
    int number = slots.size();
    return number;
  }

  public boolean hasSlots()
  {
    boolean has = slots.size() > 0;
    return has;
  }

  public int indexOfSlot(Slot aSlot)
  {
    int index = slots.indexOf(aSlot);
    return index;
  }

  public Row getRow()
  {
    return row;
  }

  public static int minimumNumberOfSlots()
  {
    return 0;
  }

  public Slot addSlot(int aNumber, double aWidth, SlotSet aSlotSet)
  {
    return new Slot(aNumber, aWidth, aSlotSet, this);
  }

  public boolean addSlot(Slot aSlot)
  {
    boolean wasAdded = false;
    if (slots.contains(aSlot)) { return false; }
    Level existingLevel = aSlot.getLevel();
    boolean isNewLevel = existingLevel != null && !this.equals(existingLevel);
    if (isNewLevel)
    {
      aSlot.setLevel(this);
    }
    else
    {
      slots.add(aSlot);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSlot(Slot aSlot)
  {
    boolean wasRemoved = false;
    //Unable to remove aSlot, as it must always have a level
    if (!this.equals(aSlot.getLevel()))
    {
      slots.remove(aSlot);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addSlotAt(Slot aSlot, int index)
  {  
    boolean wasAdded = false;
    if(addSlot(aSlot))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSlots()) { index = numberOfSlots() - 1; }
      slots.remove(aSlot);
      slots.add(index, aSlot);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSlotAt(Slot aSlot, int index)
  {
    boolean wasAdded = false;
    if(slots.contains(aSlot))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSlots()) { index = numberOfSlots() - 1; }
      slots.remove(aSlot);
      slots.add(index, aSlot);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSlotAt(aSlot, index);
    }
    return wasAdded;
  }

  public boolean setRow(Row aRow)
  {
    boolean wasSet = false;
    if (aRow == null)
    {
      return wasSet;
    }

    Row existingRow = row;
    row = aRow;
    if (existingRow != null && !existingRow.equals(aRow))
    {
      existingRow.removeLevel(this);
    }
    row.addLevel(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=slots.size(); i > 0; i--)
    {
      Slot aSlot = slots.get(i - 1);
      aSlot.delete();
    }
    Row placeholderRow = row;
    this.row = null;
    placeholderRow.removeLevel(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "height" + ":" + getHeight()+ "," +
            "number" + ":" + getNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "row = "+(getRow()!=null?Integer.toHexString(System.identityHashCode(getRow())):"null")
     + outputString;
  }
}