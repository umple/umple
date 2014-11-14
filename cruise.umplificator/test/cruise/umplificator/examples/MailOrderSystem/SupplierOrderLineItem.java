/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 62 "MailOrderSystem.ump"
public class SupplierOrderLineItem
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SupplierOrderLineItem Attributes
  private String numberOrdered;
  private String dateExpected;

  //SupplierOrderLineItem Associations
  private List<ReceivedLineItem> receivedLineItems;
  private ProductSource productSource;
  private OrderToSupplier orderToSupplier;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SupplierOrderLineItem(String aNumberOrdered, String aDateExpected, ProductSource aProductSource, OrderToSupplier aOrderToSupplier)
  {
    numberOrdered = aNumberOrdered;
    dateExpected = aDateExpected;
    receivedLineItems = new ArrayList<ReceivedLineItem>();
    boolean didAddProductSource = setProductSource(aProductSource);
    if (!didAddProductSource)
    {
      throw new RuntimeException("Unable to create supplierOrderLineItem due to productSource");
    }
    boolean didAddOrderToSupplier = setOrderToSupplier(aOrderToSupplier);
    if (!didAddOrderToSupplier)
    {
      throw new RuntimeException("Unable to create supplierOrderLineItem due to orderToSupplier");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumberOrdered(String aNumberOrdered)
  {
    boolean wasSet = false;
    numberOrdered = aNumberOrdered;
    wasSet = true;
    return wasSet;
  }

  public boolean setDateExpected(String aDateExpected)
  {
    boolean wasSet = false;
    dateExpected = aDateExpected;
    wasSet = true;
    return wasSet;
  }

  public String getNumberOrdered()
  {
    return numberOrdered;
  }

  public String getDateExpected()
  {
    return dateExpected;
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

  public ProductSource getProductSource()
  {
    return productSource;
  }

  public OrderToSupplier getOrderToSupplier()
  {
    return orderToSupplier;
  }

  public static int minimumNumberOfReceivedLineItems()
  {
    return 0;
  }

  public ReceivedLineItem addReceivedLineItem(String aNumberReceived, String aActualCostPerUnit, ReceivedDelivery aReceivedDelivery)
  {
    return new ReceivedLineItem(aNumberReceived, aActualCostPerUnit, aReceivedDelivery, this);
  }

  public boolean addReceivedLineItem(ReceivedLineItem aReceivedLineItem)
  {
    boolean wasAdded = false;
    if (receivedLineItems.contains(aReceivedLineItem)) { return false; }
    SupplierOrderLineItem existingSupplierOrderLineItem = aReceivedLineItem.getSupplierOrderLineItem();
    boolean isNewSupplierOrderLineItem = existingSupplierOrderLineItem != null && !this.equals(existingSupplierOrderLineItem);
    if (isNewSupplierOrderLineItem)
    {
      aReceivedLineItem.setSupplierOrderLineItem(this);
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
    //Unable to remove aReceivedLineItem, as it must always have a supplierOrderLineItem
    if (!this.equals(aReceivedLineItem.getSupplierOrderLineItem()))
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

  public boolean setProductSource(ProductSource aProductSource)
  {
    boolean wasSet = false;
    if (aProductSource == null)
    {
      return wasSet;
    }

    ProductSource existingProductSource = productSource;
    productSource = aProductSource;
    if (existingProductSource != null && !existingProductSource.equals(aProductSource))
    {
      existingProductSource.removeSupplierOrderLineItem(this);
    }
    productSource.addSupplierOrderLineItem(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setOrderToSupplier(OrderToSupplier aOrderToSupplier)
  {
    boolean wasSet = false;
    if (aOrderToSupplier == null)
    {
      return wasSet;
    }

    OrderToSupplier existingOrderToSupplier = orderToSupplier;
    orderToSupplier = aOrderToSupplier;
    if (existingOrderToSupplier != null && !existingOrderToSupplier.equals(aOrderToSupplier))
    {
      existingOrderToSupplier.removeSupplierOrderLineItem(this);
    }
    orderToSupplier.addSupplierOrderLineItem(this);
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
    ProductSource placeholderProductSource = productSource;
    this.productSource = null;
    placeholderProductSource.removeSupplierOrderLineItem(this);
    OrderToSupplier placeholderOrderToSupplier = orderToSupplier;
    this.orderToSupplier = null;
    placeholderOrderToSupplier.removeSupplierOrderLineItem(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "numberOrdered" + ":" + getNumberOrdered()+ "," +
            "dateExpected" + ":" + getDateExpected()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "productSource = "+(getProductSource()!=null?Integer.toHexString(System.identityHashCode(getProductSource())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "orderToSupplier = "+(getOrderToSupplier()!=null?Integer.toHexString(System.identityHashCode(getOrderToSupplier())):"null")
     + outputString;
  }
}