/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 74 "WarehouseSystem.ump"
// line 94 "WarehouseSystem.ump"
public class BoxOrPallet
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //BoxOrPallet Attributes
  private int rfidTagNumber;
  private double lengthINmm;
  private double widthINmm;
  private double heightINmm;
  private double weightINkg;
  private String contentType;

  //BoxOrPallet Associations
  private List<DeliverOrShipmentBom> deliverOrShipmentBoms;
  private List<Item> items;
  private SlotSet slotSet;
  private List<RwbmMovement> rwbmMovements;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public BoxOrPallet(int aRfidTagNumber, double aLengthINmm, double aWidthINmm, double aHeightINmm, double aWeightINkg, String aContentType)
  {
    rfidTagNumber = aRfidTagNumber;
    lengthINmm = aLengthINmm;
    widthINmm = aWidthINmm;
    heightINmm = aHeightINmm;
    weightINkg = aWeightINkg;
    contentType = aContentType;
    deliverOrShipmentBoms = new ArrayList<DeliverOrShipmentBom>();
    items = new ArrayList<Item>();
    rwbmMovements = new ArrayList<RwbmMovement>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRfidTagNumber(int aRfidTagNumber)
  {
    boolean wasSet = false;
    rfidTagNumber = aRfidTagNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setLengthINmm(double aLengthINmm)
  {
    boolean wasSet = false;
    lengthINmm = aLengthINmm;
    wasSet = true;
    return wasSet;
  }

  public boolean setWidthINmm(double aWidthINmm)
  {
    boolean wasSet = false;
    widthINmm = aWidthINmm;
    wasSet = true;
    return wasSet;
  }

  public boolean setHeightINmm(double aHeightINmm)
  {
    boolean wasSet = false;
    heightINmm = aHeightINmm;
    wasSet = true;
    return wasSet;
  }

  public boolean setWeightINkg(double aWeightINkg)
  {
    boolean wasSet = false;
    weightINkg = aWeightINkg;
    wasSet = true;
    return wasSet;
  }

  public boolean setContentType(String aContentType)
  {
    boolean wasSet = false;
    contentType = aContentType;
    wasSet = true;
    return wasSet;
  }

  public int getRfidTagNumber()
  {
    return rfidTagNumber;
  }

  public double getLengthINmm()
  {
    return lengthINmm;
  }

  public double getWidthINmm()
  {
    return widthINmm;
  }

  public double getHeightINmm()
  {
    return heightINmm;
  }

  public double getWeightINkg()
  {
    return weightINkg;
  }

  public String getContentType()
  {
    return contentType;
  }

  public DeliverOrShipmentBom getDeliverOrShipmentBom(int index)
  {
    DeliverOrShipmentBom aDeliverOrShipmentBom = deliverOrShipmentBoms.get(index);
    return aDeliverOrShipmentBom;
  }

  public List<DeliverOrShipmentBom> getDeliverOrShipmentBoms()
  {
    List<DeliverOrShipmentBom> newDeliverOrShipmentBoms = Collections.unmodifiableList(deliverOrShipmentBoms);
    return newDeliverOrShipmentBoms;
  }

  public int numberOfDeliverOrShipmentBoms()
  {
    int number = deliverOrShipmentBoms.size();
    return number;
  }

  public boolean hasDeliverOrShipmentBoms()
  {
    boolean has = deliverOrShipmentBoms.size() > 0;
    return has;
  }

  public int indexOfDeliverOrShipmentBom(DeliverOrShipmentBom aDeliverOrShipmentBom)
  {
    int index = deliverOrShipmentBoms.indexOf(aDeliverOrShipmentBom);
    return index;
  }

  public Item getItem(int index)
  {
    Item aItem = items.get(index);
    return aItem;
  }

  public List<Item> getItems()
  {
    List<Item> newItems = Collections.unmodifiableList(items);
    return newItems;
  }

  public int numberOfItems()
  {
    int number = items.size();
    return number;
  }

  public boolean hasItems()
  {
    boolean has = items.size() > 0;
    return has;
  }

  public int indexOfItem(Item aItem)
  {
    int index = items.indexOf(aItem);
    return index;
  }

  public SlotSet getSlotSet()
  {
    return slotSet;
  }

  public boolean hasSlotSet()
  {
    boolean has = slotSet != null;
    return has;
  }

  public RwbmMovement getRwbmMovement(int index)
  {
    RwbmMovement aRwbmMovement = rwbmMovements.get(index);
    return aRwbmMovement;
  }

  public List<RwbmMovement> getRwbmMovements()
  {
    List<RwbmMovement> newRwbmMovements = Collections.unmodifiableList(rwbmMovements);
    return newRwbmMovements;
  }

  public int numberOfRwbmMovements()
  {
    int number = rwbmMovements.size();
    return number;
  }

  public boolean hasRwbmMovements()
  {
    boolean has = rwbmMovements.size() > 0;
    return has;
  }

  public int indexOfRwbmMovement(RwbmMovement aRwbmMovement)
  {
    int index = rwbmMovements.indexOf(aRwbmMovement);
    return index;
  }

  public static int minimumNumberOfDeliverOrShipmentBoms()
  {
    return 0;
  }

  public boolean addDeliverOrShipmentBom(DeliverOrShipmentBom aDeliverOrShipmentBom)
  {
    boolean wasAdded = false;
    if (deliverOrShipmentBoms.contains(aDeliverOrShipmentBom)) { return false; }
    deliverOrShipmentBoms.add(aDeliverOrShipmentBom);
    if (aDeliverOrShipmentBom.indexOfBoxOrPallet(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aDeliverOrShipmentBom.addBoxOrPallet(this);
      if (!wasAdded)
      {
        deliverOrShipmentBoms.remove(aDeliverOrShipmentBom);
      }
    }
    return wasAdded;
  }

  public boolean removeDeliverOrShipmentBom(DeliverOrShipmentBom aDeliverOrShipmentBom)
  {
    boolean wasRemoved = false;
    if (!deliverOrShipmentBoms.contains(aDeliverOrShipmentBom))
    {
      return wasRemoved;
    }

    int oldIndex = deliverOrShipmentBoms.indexOf(aDeliverOrShipmentBom);
    deliverOrShipmentBoms.remove(oldIndex);
    if (aDeliverOrShipmentBom.indexOfBoxOrPallet(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aDeliverOrShipmentBom.removeBoxOrPallet(this);
      if (!wasRemoved)
      {
        deliverOrShipmentBoms.add(oldIndex,aDeliverOrShipmentBom);
      }
    }
    return wasRemoved;
  }

  public boolean addDeliverOrShipmentBomAt(DeliverOrShipmentBom aDeliverOrShipmentBom, int index)
  {  
    boolean wasAdded = false;
    if(addDeliverOrShipmentBom(aDeliverOrShipmentBom))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDeliverOrShipmentBoms()) { index = numberOfDeliverOrShipmentBoms() - 1; }
      deliverOrShipmentBoms.remove(aDeliverOrShipmentBom);
      deliverOrShipmentBoms.add(index, aDeliverOrShipmentBom);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDeliverOrShipmentBomAt(DeliverOrShipmentBom aDeliverOrShipmentBom, int index)
  {
    boolean wasAdded = false;
    if(deliverOrShipmentBoms.contains(aDeliverOrShipmentBom))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDeliverOrShipmentBoms()) { index = numberOfDeliverOrShipmentBoms() - 1; }
      deliverOrShipmentBoms.remove(aDeliverOrShipmentBom);
      deliverOrShipmentBoms.add(index, aDeliverOrShipmentBom);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDeliverOrShipmentBomAt(aDeliverOrShipmentBom, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfItems()
  {
    return 0;
  }

  public Item addItem(double aValue, int aHazardID, int aBreakability)
  {
    return new Item(aValue, aHazardID, aBreakability, this);
  }

  public boolean addItem(Item aItem)
  {
    boolean wasAdded = false;
    if (items.contains(aItem)) { return false; }
    BoxOrPallet existingBoxOrPallet = aItem.getBoxOrPallet();
    boolean isNewBoxOrPallet = existingBoxOrPallet != null && !this.equals(existingBoxOrPallet);
    if (isNewBoxOrPallet)
    {
      aItem.setBoxOrPallet(this);
    }
    else
    {
      items.add(aItem);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeItem(Item aItem)
  {
    boolean wasRemoved = false;
    //Unable to remove aItem, as it must always have a boxOrPallet
    if (!this.equals(aItem.getBoxOrPallet()))
    {
      items.remove(aItem);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addItemAt(Item aItem, int index)
  {  
    boolean wasAdded = false;
    if(addItem(aItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItems()) { index = numberOfItems() - 1; }
      items.remove(aItem);
      items.add(index, aItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveItemAt(Item aItem, int index)
  {
    boolean wasAdded = false;
    if(items.contains(aItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItems()) { index = numberOfItems() - 1; }
      items.remove(aItem);
      items.add(index, aItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addItemAt(aItem, index);
    }
    return wasAdded;
  }

  public boolean setSlotSet(SlotSet aNewSlotSet)
  {
    boolean wasSet = false;
    if (aNewSlotSet == null)
    {
      SlotSet existingSlotSet = slotSet;
      slotSet = null;
      
      if (existingSlotSet != null && existingSlotSet.getBoxOrPallet() != null)
      {
        existingSlotSet.setBoxOrPallet(null);
      }
      wasSet = true;
      return wasSet;
    }

    SlotSet currentSlotSet = getSlotSet();
    if (currentSlotSet != null && !currentSlotSet.equals(aNewSlotSet))
    {
      currentSlotSet.setBoxOrPallet(null);
    }

    slotSet = aNewSlotSet;
    BoxOrPallet existingBoxOrPallet = aNewSlotSet.getBoxOrPallet();

    if (!equals(existingBoxOrPallet))
    {
      aNewSlotSet.setBoxOrPallet(this);
    }
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfRwbmMovements()
  {
    return 0;
  }

  public RwbmMovement addRwbmMovement(double aStartTime, double aEndTime, MovementLocation aTo, MovementLocation aFrom)
  {
    return new RwbmMovement(aStartTime, aEndTime, aTo, aFrom, this);
  }

  public boolean addRwbmMovement(RwbmMovement aRwbmMovement)
  {
    boolean wasAdded = false;
    if (rwbmMovements.contains(aRwbmMovement)) { return false; }
    BoxOrPallet existingMovedBox = aRwbmMovement.getMovedBox();
    boolean isNewMovedBox = existingMovedBox != null && !this.equals(existingMovedBox);
    if (isNewMovedBox)
    {
      aRwbmMovement.setMovedBox(this);
    }
    else
    {
      rwbmMovements.add(aRwbmMovement);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRwbmMovement(RwbmMovement aRwbmMovement)
  {
    boolean wasRemoved = false;
    //Unable to remove aRwbmMovement, as it must always have a movedBox
    if (!this.equals(aRwbmMovement.getMovedBox()))
    {
      rwbmMovements.remove(aRwbmMovement);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addRwbmMovementAt(RwbmMovement aRwbmMovement, int index)
  {  
    boolean wasAdded = false;
    if(addRwbmMovement(aRwbmMovement))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRwbmMovements()) { index = numberOfRwbmMovements() - 1; }
      rwbmMovements.remove(aRwbmMovement);
      rwbmMovements.add(index, aRwbmMovement);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRwbmMovementAt(RwbmMovement aRwbmMovement, int index)
  {
    boolean wasAdded = false;
    if(rwbmMovements.contains(aRwbmMovement))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRwbmMovements()) { index = numberOfRwbmMovements() - 1; }
      rwbmMovements.remove(aRwbmMovement);
      rwbmMovements.add(index, aRwbmMovement);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRwbmMovementAt(aRwbmMovement, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<DeliverOrShipmentBom> copyOfDeliverOrShipmentBoms = new ArrayList<DeliverOrShipmentBom>(deliverOrShipmentBoms);
    deliverOrShipmentBoms.clear();
    for(DeliverOrShipmentBom aDeliverOrShipmentBom : copyOfDeliverOrShipmentBoms)
    {
      aDeliverOrShipmentBom.removeBoxOrPallet(this);
    }
    for(int i=items.size(); i > 0; i--)
    {
      Item aItem = items.get(i - 1);
      aItem.delete();
    }
    if (slotSet != null)
    {
      slotSet.setBoxOrPallet(null);
    }
    for(int i=rwbmMovements.size(); i > 0; i--)
    {
      RwbmMovement aRwbmMovement = rwbmMovements.get(i - 1);
      aRwbmMovement.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "rfidTagNumber" + ":" + getRfidTagNumber()+ "," +
            "lengthINmm" + ":" + getLengthINmm()+ "," +
            "widthINmm" + ":" + getWidthINmm()+ "," +
            "heightINmm" + ":" + getHeightINmm()+ "," +
            "weightINkg" + ":" + getWeightINkg()+ "," +
            "contentType" + ":" + getContentType()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "slotSet = "+(getSlotSet()!=null?Integer.toHexString(System.identityHashCode(getSlotSet())):"null")
     + outputString;
  }
}