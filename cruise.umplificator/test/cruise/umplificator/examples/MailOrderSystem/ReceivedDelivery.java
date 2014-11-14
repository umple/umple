/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 56 "MailOrderSystem.ump"
public class ReceivedDelivery
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ReceivedDelivery Attributes
  private String numberReceived;
  private String actualCostPerUnit;

  //ReceivedDelivery Associations
  private List<ReceivedLineItem> receivedLineItems;
  private Supplier supplier;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ReceivedDelivery(String aNumberReceived, String aActualCostPerUnit, Supplier aSupplier)
  {
    numberReceived = aNumberReceived;
    actualCostPerUnit = aActualCostPerUnit;
    receivedLineItems = new ArrayList<ReceivedLineItem>();
    boolean didAddSupplier = setSupplier(aSupplier);
    if (!didAddSupplier)
    {
      throw new RuntimeException("Unable to create receivedDelivery due to supplier");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumberReceived(String aNumberReceived)
  {
    boolean wasSet = false;
    numberReceived = aNumberReceived;
    wasSet = true;
    return wasSet;
  }

  public boolean setActualCostPerUnit(String aActualCostPerUnit)
  {
    boolean wasSet = false;
    actualCostPerUnit = aActualCostPerUnit;
    wasSet = true;
    return wasSet;
  }

  public String getNumberReceived()
  {
    return numberReceived;
  }

  public String getActualCostPerUnit()
  {
    return actualCostPerUnit;
  }

  public ReceivedLineItem getReceivedLineItem(int index)
  {
    ReceivedLineItem aReceivedLineItem = receivedLineItems.get(index);
    return aReceivedLineItem;
  }

  public List<ReceivedLineItem> getReceivedLineItems()
  {
    List<ReceivedLineItem> newReceivedLineItems = Collections.unmodifiableList(receivedLineItems);
    return newReceivedLineItems;
  }

  public int numberOfReceivedLineItems()
  {
    int number = receivedLineItems.size();
    return number;
  }

  public boolean hasReceivedLineItems()
  {
    boolean has = receivedLineItems.size() > 0;
    return has;
  }

  public int indexOfReceivedLineItem(ReceivedLineItem aReceivedLineItem)
  {
    int index = receivedLineItems.indexOf(aReceivedLineItem);
    return index;
  }

  public Supplier getSupplier()
  {
    return supplier;
  }

  public static int minimumNumberOfReceivedLineItems()
  {
    return 0;
  }

  public ReceivedLineItem addReceivedLineItem(String aNumberReceived, String aActualCostPerUnit, SupplierOrderLineItem aSupplierOrderLineItem)
  {
    return new ReceivedLineItem(aNumberReceived, aActualCostPerUnit, this, aSupplierOrderLineItem);
  }

  public boolean addReceivedLineItem(ReceivedLineItem aReceivedLineItem)
  {
    boolean wasAdded = false;
    if (receivedLineItems.contains(aReceivedLineItem)) { return false; }
    ReceivedDelivery existingReceivedDelivery = aReceivedLineItem.getReceivedDelivery();
    boolean isNewReceivedDelivery = existingReceivedDelivery != null && !this.equals(existingReceivedDelivery);
    if (isNewReceivedDelivery)
    {
      aReceivedLineItem.setReceivedDelivery(this);
    }
    else
    {
      receivedLineItems.add(aReceivedLineItem);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeReceivedLineItem(ReceivedLineItem aReceivedLineItem)
  {
    boolean wasRemoved = false;
    //Unable to remove aReceivedLineItem, as it must always have a receivedDelivery
    if (!this.equals(aReceivedLineItem.getReceivedDelivery()))
    {
      receivedLineItems.remove(aReceivedLineItem);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addReceivedLineItemAt(ReceivedLineItem aReceivedLineItem, int index)
  {  
    boolean wasAdded = false;
    if(addReceivedLineItem(aReceivedLineItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfReceivedLineItems()) { index = numberOfReceivedLineItems() - 1; }
      receivedLineItems.remove(aReceivedLineItem);
      receivedLineItems.add(index, aReceivedLineItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveReceivedLineItemAt(ReceivedLineItem aReceivedLineItem, int index)
  {
    boolean wasAdded = false;
    if(receivedLineItems.contains(aReceivedLineItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfReceivedLineItems()) { index = numberOfReceivedLineItems() - 1; }
      receivedLineItems.remove(aReceivedLineItem);
      receivedLineItems.add(index, aReceivedLineItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addReceivedLineItemAt(aReceivedLineItem, index);
    }
    return wasAdded;
  }

  public boolean setSupplier(Supplier aSupplier)
  {
    boolean wasSet = false;
    if (aSupplier == null)
    {
      return wasSet;
    }

    Supplier existingSupplier = supplier;
    supplier = aSupplier;
    if (existingSupplier != null && !existingSupplier.equals(aSupplier))
    {
      existingSupplier.removeReceivedDelivery(this);
    }
    supplier.addReceivedDelivery(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=receivedLineItems.size(); i > 0; i--)
    {
      ReceivedLineItem aReceivedLineItem = receivedLineItems.get(i - 1);
      aReceivedLineItem.delete();
    }
    Supplier placeholderSupplier = supplier;
    this.supplier = null;
    placeholderSupplier.removeReceivedDelivery(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "numberReceived" + ":" + getNumberReceived()+ "," +
            "actualCostPerUnit" + ":" + getActualCostPerUnit()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "supplier = "+(getSupplier()!=null?Integer.toHexString(System.identityHashCode(getSupplier())):"null")
     + outputString;
  }
}