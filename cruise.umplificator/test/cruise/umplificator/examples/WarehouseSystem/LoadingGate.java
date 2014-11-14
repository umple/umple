/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 24 "WarehouseSystem.ump"
// line 127 "WarehouseSystem.ump"
public class LoadingGate extends MovementLocation
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //LoadingGate Attributes
  private int number;

  //LoadingGate Associations
  private List<DeliverOrShipmentBom> delivery;
  private List<DeliverOrShipmentBom> arrival;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public LoadingGate(int aNumber)
  {
    super();
    number = aNumber;
    delivery = new ArrayList<DeliverOrShipmentBom>();
    arrival = new ArrayList<DeliverOrShipmentBom>();
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

  public int getNumber()
  {
    return number;
  }

  public DeliverOrShipmentBom getDelivery(int index)
  {
    DeliverOrShipmentBom aDelivery = delivery.get(index);
    return aDelivery;
  }

  public List<DeliverOrShipmentBom> getDelivery()
  {
    List<DeliverOrShipmentBom> newDelivery = Collections.unmodifiableList(delivery);
    return newDelivery;
  }

  public int numberOfDelivery()
  {
    int number = delivery.size();
    return number;
  }

  public boolean hasDelivery()
  {
    boolean has = delivery.size() > 0;
    return has;
  }

  public int indexOfDelivery(DeliverOrShipmentBom aDelivery)
  {
    int index = delivery.indexOf(aDelivery);
    return index;
  }

  public DeliverOrShipmentBom getArrival(int index)
  {
    DeliverOrShipmentBom aArrival = arrival.get(index);
    return aArrival;
  }

  public List<DeliverOrShipmentBom> getArrival()
  {
    List<DeliverOrShipmentBom> newArrival = Collections.unmodifiableList(arrival);
    return newArrival;
  }

  public int numberOfArrival()
  {
    int number = arrival.size();
    return number;
  }

  public boolean hasArrival()
  {
    boolean has = arrival.size() > 0;
    return has;
  }

  public int indexOfArrival(DeliverOrShipmentBom aArrival)
  {
    int index = arrival.indexOf(aArrival);
    return index;
  }

  public static int minimumNumberOfDelivery()
  {
    return 0;
  }

  public boolean addDelivery(DeliverOrShipmentBom aDelivery)
  {
    boolean wasAdded = false;
    if (delivery.contains(aDelivery)) { return false; }
    LoadingGate existingSentThrough = aDelivery.getSentThrough();
    if (existingSentThrough == null)
    {
      aDelivery.setSentThrough(this);
    }
    else if (!this.equals(existingSentThrough))
    {
      existingSentThrough.removeDelivery(aDelivery);
      addDelivery(aDelivery);
    }
    else
    {
      delivery.add(aDelivery);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDelivery(DeliverOrShipmentBom aDelivery)
  {
    boolean wasRemoved = false;
    if (delivery.contains(aDelivery))
    {
      delivery.remove(aDelivery);
      aDelivery.setSentThrough(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addDeliveryAt(DeliverOrShipmentBom aDelivery, int index)
  {  
    boolean wasAdded = false;
    if(addDelivery(aDelivery))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDelivery()) { index = numberOfDelivery() - 1; }
      delivery.remove(aDelivery);
      delivery.add(index, aDelivery);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDeliveryAt(DeliverOrShipmentBom aDelivery, int index)
  {
    boolean wasAdded = false;
    if(delivery.contains(aDelivery))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDelivery()) { index = numberOfDelivery() - 1; }
      delivery.remove(aDelivery);
      delivery.add(index, aDelivery);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDeliveryAt(aDelivery, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfArrival()
  {
    return 0;
  }

  public boolean addArrival(DeliverOrShipmentBom aArrival)
  {
    boolean wasAdded = false;
    if (arrival.contains(aArrival)) { return false; }
    LoadingGate existingArriveAt = aArrival.getArriveAt();
    if (existingArriveAt == null)
    {
      aArrival.setArriveAt(this);
    }
    else if (!this.equals(existingArriveAt))
    {
      existingArriveAt.removeArrival(aArrival);
      addArrival(aArrival);
    }
    else
    {
      arrival.add(aArrival);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeArrival(DeliverOrShipmentBom aArrival)
  {
    boolean wasRemoved = false;
    if (arrival.contains(aArrival))
    {
      arrival.remove(aArrival);
      aArrival.setArriveAt(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addArrivalAt(DeliverOrShipmentBom aArrival, int index)
  {  
    boolean wasAdded = false;
    if(addArrival(aArrival))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfArrival()) { index = numberOfArrival() - 1; }
      arrival.remove(aArrival);
      arrival.add(index, aArrival);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveArrivalAt(DeliverOrShipmentBom aArrival, int index)
  {
    boolean wasAdded = false;
    if(arrival.contains(aArrival))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfArrival()) { index = numberOfArrival() - 1; }
      arrival.remove(aArrival);
      arrival.add(index, aArrival);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addArrivalAt(aArrival, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while( !delivery.isEmpty() )
    {
      delivery.get(0).setSentThrough(null);
    }
    while( !arrival.isEmpty() )
    {
      arrival.get(0).setArriveAt(null);
    }
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "number" + ":" + getNumber()+ "]"
     + outputString;
  }
}