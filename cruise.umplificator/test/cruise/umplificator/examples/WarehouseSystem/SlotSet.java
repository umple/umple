/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 7 "WarehouseSystem.ump"
// line 148 "WarehouseSystem.ump"
public class SlotSet extends MovementLocation
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SlotSet Associations
  private BoxOrPallet boxOrPallet;
  private List<Slot> slots;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SlotSet()
  {
    super();
    slots = new ArrayList<Slot>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public BoxOrPallet getBoxOrPallet()
  {
    return boxOrPallet;
  }

  public boolean hasBoxOrPallet()
  {
    boolean has = boxOrPallet != null;
    return has;
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

  public boolean setBoxOrPallet(BoxOrPallet aNewBoxOrPallet)
  {
    boolean wasSet = false;
    if (aNewBoxOrPallet == null)
    {
      BoxOrPallet existingBoxOrPallet = boxOrPallet;
      boxOrPallet = null;
      
      if (existingBoxOrPallet != null && existingBoxOrPallet.getSlotSet() != null)
      {
        existingBoxOrPallet.setSlotSet(null);
      }
      wasSet = true;
      return wasSet;
    }

    BoxOrPallet currentBoxOrPallet = getBoxOrPallet();
    if (currentBoxOrPallet != null && !currentBoxOrPallet.equals(aNewBoxOrPallet))
    {
      currentBoxOrPallet.setSlotSet(null);
    }

    boxOrPallet = aNewBoxOrPallet;
    SlotSet existingSlotSet = aNewBoxOrPallet.getSlotSet();

    if (!equals(existingSlotSet))
    {
      aNewBoxOrPallet.setSlotSet(this);
    }
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfSlots()
  {
    return 0;
  }

  public Slot addSlot(int aNumber, double aWidth, Level aLevel)
  {
    return new Slot(aNumber, aWidth, this, aLevel);
  }

  public boolean addSlot(Slot aSlot)
  {
    boolean wasAdded = false;
    if (slots.contains(aSlot)) { return false; }
    SlotSet existingSlotSet = aSlot.getSlotSet();
    boolean isNewSlotSet = existingSlotSet != null && !this.equals(existingSlotSet);
    if (isNewSlotSet)
    {
      aSlot.setSlotSet(this);
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
    //Unable to remove aSlot, as it must always have a slotSet
    if (!this.equals(aSlot.getSlotSet()))
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

  public void delete()
  {
    if (boxOrPallet != null)
    {
      boxOrPallet.setSlotSet(null);
    }
    for(int i=slots.size(); i > 0; i--)
    {
      Slot aSlot = slots.get(i - 1);
      aSlot.delete();
    }
    super.delete();
  }

}