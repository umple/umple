/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 1 "MailOrderSystem.ump"
public class ReceivedLineItem
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ReceivedLineItem Attributes
  private String numberReceived;
  private String actualCostPerUnit;

  //ReceivedLineItem Associations
  private ReceivedDelivery receivedDelivery;
  private SupplierOrderLineItem supplierOrderLineItem;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ReceivedLineItem(String aNumberReceived, String aActualCostPerUnit, ReceivedDelivery aReceivedDelivery, SupplierOrderLineItem aSupplierOrderLineItem)
  {
    numberReceived = aNumberReceived;
    actualCostPerUnit = aActualCostPerUnit;
    boolean didAddReceivedDelivery = setReceivedDelivery(aReceivedDelivery);
    if (!didAddReceivedDelivery)
    {
      throw new RuntimeException("Unable to create receivedLineItem due to receivedDelivery");
    }
    boolean didAddSupplierOrderLineItem = setSupplierOrderLineItem(aSupplierOrderLineItem);
    if (!didAddSupplierOrderLineItem)
    {
      throw new RuntimeException("Unable to create receivedLineItem due to supplierOrderLineItem");
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

  public ReceivedDelivery getReceivedDelivery()
  {
    return receivedDelivery;
  }

  public SupplierOrderLineItem getSupplierOrderLineItem()
  {
    return supplierOrderLineItem;
  }

  public boolean setReceivedDelivery(ReceivedDelivery aReceivedDelivery)
  {
    boolean wasSet = false;
    if (aReceivedDelivery == null)
    {
      return wasSet;
    }

    ReceivedDelivery existingReceivedDelivery = receivedDelivery;
    receivedDelivery = aReceivedDelivery;
    if (existingReceivedDelivery != null && !existingReceivedDelivery.equals(aReceivedDelivery))
    {
      existingReceivedDelivery.removeReceivedLineItem(this);
    }
    receivedDelivery.addReceivedLineItem(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setSupplierOrderLineItem(SupplierOrderLineItem aSupplierOrderLineItem)
  {
    boolean wasSet = false;
    if (aSupplierOrderLineItem == null)
    {
      return wasSet;
    }

    SupplierOrderLineItem existingSupplierOrderLineItem = supplierOrderLineItem;
    supplierOrderLineItem = aSupplierOrderLineItem;
    if (existingSupplierOrderLineItem != null && !existingSupplierOrderLineItem.equals(aSupplierOrderLineItem))
    {
      existingSupplierOrderLineItem.removeReceivedLineItem(this);
    }
    supplierOrderLineItem.addReceivedLineItem(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ReceivedDelivery placeholderReceivedDelivery = receivedDelivery;
    this.receivedDelivery = null;
    placeholderReceivedDelivery.removeReceivedLineItem(this);
    SupplierOrderLineItem placeholderSupplierOrderLineItem = supplierOrderLineItem;
    this.supplierOrderLineItem = null;
    placeholderSupplierOrderLineItem.removeReceivedLineItem(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "numberReceived" + ":" + getNumberReceived()+ "," +
            "actualCostPerUnit" + ":" + getActualCostPerUnit()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "receivedDelivery = "+(getReceivedDelivery()!=null?Integer.toHexString(System.identityHashCode(getReceivedDelivery())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "supplierOrderLineItem = "+(getSupplierOrderLineItem()!=null?Integer.toHexString(System.identityHashCode(getSupplierOrderLineItem())):"null")
     + outputString;
  }
}