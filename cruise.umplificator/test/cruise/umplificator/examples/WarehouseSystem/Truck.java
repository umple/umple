/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 29 "WarehouseSystem.ump"
// line 106 "WarehouseSystem.ump"
public class Truck
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Truck Attributes
  private int registerNum;
  private boolean isWaiting;

  //Truck Associations
  private List<DeliverOrShipmentBom> deliverOrShipmentBoms;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Truck(int aRegisterNum, boolean aIsWaiting)
  {
    registerNum = aRegisterNum;
    isWaiting = aIsWaiting;
    deliverOrShipmentBoms = new ArrayList<DeliverOrShipmentBom>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRegisterNum(int aRegisterNum)
  {
    boolean wasSet = false;
    registerNum = aRegisterNum;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsWaiting(boolean aIsWaiting)
  {
    boolean wasSet = false;
    isWaiting = aIsWaiting;
    wasSet = true;
    return wasSet;
  }

  public int getRegisterNum()
  {
    return registerNum;
  }

  public boolean getIsWaiting()
  {
    return isWaiting;
  }

  public boolean isIsWaiting()
  {
    return isWaiting;
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

  public static int minimumNumberOfDeliverOrShipmentBoms()
  {
    return 0;
  }

  public DeliverOrShipmentBom addDeliverOrShipmentBom(double aStartTimeLoadOrUnload, double aEndTimeExpected)
  {
    return new DeliverOrShipmentBom(aStartTimeLoadOrUnload, aEndTimeExpected, this);
  }

  public boolean addDeliverOrShipmentBom(DeliverOrShipmentBom aDeliverOrShipmentBom)
  {
    boolean wasAdded = false;
    if (deliverOrShipmentBoms.contains(aDeliverOrShipmentBom)) { return false; }
    Truck existingTruck = aDeliverOrShipmentBom.getTruck();
    boolean isNewTruck = existingTruck != null && !this.equals(existingTruck);
    if (isNewTruck)
    {
      aDeliverOrShipmentBom.setTruck(this);
    }
    else
    {
      deliverOrShipmentBoms.add(aDeliverOrShipmentBom);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDeliverOrShipmentBom(DeliverOrShipmentBom aDeliverOrShipmentBom)
  {
    boolean wasRemoved = false;
    //Unable to remove aDeliverOrShipmentBom, as it must always have a truck
    if (!this.equals(aDeliverOrShipmentBom.getTruck()))
    {
      deliverOrShipmentBoms.remove(aDeliverOrShipmentBom);
      wasRemoved = true;
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

  public void delete()
  {
    for(int i=deliverOrShipmentBoms.size(); i > 0; i--)
    {
      DeliverOrShipmentBom aDeliverOrShipmentBom = deliverOrShipmentBoms.get(i - 1);
      aDeliverOrShipmentBom.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "registerNum" + ":" + getRegisterNum()+ "," +
            "isWaiting" + ":" + getIsWaiting()+ "]"
     + outputString;
  }
}