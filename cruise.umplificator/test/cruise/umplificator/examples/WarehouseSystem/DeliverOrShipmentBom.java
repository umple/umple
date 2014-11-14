/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * Both associations should be ->
 * Positioning
 */
// line 67 "WarehouseSystem.ump"
// line 87 "WarehouseSystem.ump"
public class DeliverOrShipmentBom
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DeliverOrShipmentBom Attributes
  private double startTimeLoadOrUnload;
  private double endTimeExpected;

  //DeliverOrShipmentBom Associations
  private LoadingGate sentThrough;
  private LoadingGate arriveAt;
  private Truck truck;
  private List<BoxOrPallet> boxOrPallets;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DeliverOrShipmentBom(double aStartTimeLoadOrUnload, double aEndTimeExpected, Truck aTruck)
  {
    startTimeLoadOrUnload = aStartTimeLoadOrUnload;
    endTimeExpected = aEndTimeExpected;
    boolean didAddTruck = setTruck(aTruck);
    if (!didAddTruck)
    {
      throw new RuntimeException("Unable to create deliverOrShipmentBom due to truck");
    }
    boxOrPallets = new ArrayList<BoxOrPallet>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStartTimeLoadOrUnload(double aStartTimeLoadOrUnload)
  {
    boolean wasSet = false;
    startTimeLoadOrUnload = aStartTimeLoadOrUnload;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndTimeExpected(double aEndTimeExpected)
  {
    boolean wasSet = false;
    endTimeExpected = aEndTimeExpected;
    wasSet = true;
    return wasSet;
  }

  public double getStartTimeLoadOrUnload()
  {
    return startTimeLoadOrUnload;
  }

  public double getEndTimeExpected()
  {
    return endTimeExpected;
  }

  public LoadingGate getSentThrough()
  {
    return sentThrough;
  }

  public boolean hasSentThrough()
  {
    boolean has = sentThrough != null;
    return has;
  }

  public LoadingGate getArriveAt()
  {
    return arriveAt;
  }

  public boolean hasArriveAt()
  {
    boolean has = arriveAt != null;
    return has;
  }

  public Truck getTruck()
  {
    return truck;
  }

  public BoxOrPallet getBoxOrPallet(int index)
  {
    BoxOrPallet aBoxOrPallet = boxOrPallets.get(index);
    return aBoxOrPallet;
  }

  public List<BoxOrPallet> getBoxOrPallets()
  {
    List<BoxOrPallet> newBoxOrPallets = Collections.unmodifiableList(boxOrPallets);
    return newBoxOrPallets;
  }

  public int numberOfBoxOrPallets()
  {
    int number = boxOrPallets.size();
    return number;
  }

  public boolean hasBoxOrPallets()
  {
    boolean has = boxOrPallets.size() > 0;
    return has;
  }

  public int indexOfBoxOrPallet(BoxOrPallet aBoxOrPallet)
  {
    int index = boxOrPallets.indexOf(aBoxOrPallet);
    return index;
  }

  public boolean setSentThrough(LoadingGate aSentThrough)
  {
    boolean wasSet = false;
    LoadingGate existingSentThrough = sentThrough;
    sentThrough = aSentThrough;
    if (existingSentThrough != null && !existingSentThrough.equals(aSentThrough))
    {
      existingSentThrough.removeDelivery(this);
    }
    if (aSentThrough != null)
    {
      aSentThrough.addDelivery(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setArriveAt(LoadingGate aArriveAt)
  {
    boolean wasSet = false;
    LoadingGate existingArriveAt = arriveAt;
    arriveAt = aArriveAt;
    if (existingArriveAt != null && !existingArriveAt.equals(aArriveAt))
    {
      existingArriveAt.removeArrival(this);
    }
    if (aArriveAt != null)
    {
      aArriveAt.addArrival(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setTruck(Truck aTruck)
  {
    boolean wasSet = false;
    if (aTruck == null)
    {
      return wasSet;
    }

    Truck existingTruck = truck;
    truck = aTruck;
    if (existingTruck != null && !existingTruck.equals(aTruck))
    {
      existingTruck.removeDeliverOrShipmentBom(this);
    }
    truck.addDeliverOrShipmentBom(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfBoxOrPallets()
  {
    return 0;
  }

  public boolean addBoxOrPallet(BoxOrPallet aBoxOrPallet)
  {
    boolean wasAdded = false;
    if (boxOrPallets.contains(aBoxOrPallet)) { return false; }
    boxOrPallets.add(aBoxOrPallet);
    if (aBoxOrPallet.indexOfDeliverOrShipmentBom(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aBoxOrPallet.addDeliverOrShipmentBom(this);
      if (!wasAdded)
      {
        boxOrPallets.remove(aBoxOrPallet);
      }
    }
    return wasAdded;
  }

  public boolean removeBoxOrPallet(BoxOrPallet aBoxOrPallet)
  {
    boolean wasRemoved = false;
    if (!boxOrPallets.contains(aBoxOrPallet))
    {
      return wasRemoved;
    }

    int oldIndex = boxOrPallets.indexOf(aBoxOrPallet);
    boxOrPallets.remove(oldIndex);
    if (aBoxOrPallet.indexOfDeliverOrShipmentBom(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aBoxOrPallet.removeDeliverOrShipmentBom(this);
      if (!wasRemoved)
      {
        boxOrPallets.add(oldIndex,aBoxOrPallet);
      }
    }
    return wasRemoved;
  }

  public boolean addBoxOrPalletAt(BoxOrPallet aBoxOrPallet, int index)
  {  
    boolean wasAdded = false;
    if(addBoxOrPallet(aBoxOrPallet))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBoxOrPallets()) { index = numberOfBoxOrPallets() - 1; }
      boxOrPallets.remove(aBoxOrPallet);
      boxOrPallets.add(index, aBoxOrPallet);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBoxOrPalletAt(BoxOrPallet aBoxOrPallet, int index)
  {
    boolean wasAdded = false;
    if(boxOrPallets.contains(aBoxOrPallet))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBoxOrPallets()) { index = numberOfBoxOrPallets() - 1; }
      boxOrPallets.remove(aBoxOrPallet);
      boxOrPallets.add(index, aBoxOrPallet);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBoxOrPalletAt(aBoxOrPallet, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    if (sentThrough != null)
    {
      LoadingGate placeholderSentThrough = sentThrough;
      this.sentThrough = null;
      placeholderSentThrough.removeDelivery(this);
    }
    if (arriveAt != null)
    {
      LoadingGate placeholderArriveAt = arriveAt;
      this.arriveAt = null;
      placeholderArriveAt.removeArrival(this);
    }
    Truck placeholderTruck = truck;
    this.truck = null;
    placeholderTruck.removeDeliverOrShipmentBom(this);
    ArrayList<BoxOrPallet> copyOfBoxOrPallets = new ArrayList<BoxOrPallet>(boxOrPallets);
    boxOrPallets.clear();
    for(BoxOrPallet aBoxOrPallet : copyOfBoxOrPallets)
    {
      aBoxOrPallet.removeDeliverOrShipmentBom(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "startTimeLoadOrUnload" + ":" + getStartTimeLoadOrUnload()+ "," +
            "endTimeExpected" + ":" + getEndTimeExpected()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "sentThrough = "+(getSentThrough()!=null?Integer.toHexString(System.identityHashCode(getSentThrough())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "arriveAt = "+(getArriveAt()!=null?Integer.toHexString(System.identityHashCode(getArriveAt())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "truck = "+(getTruck()!=null?Integer.toHexString(System.identityHashCode(getTruck())):"null")
     + outputString;
  }
}