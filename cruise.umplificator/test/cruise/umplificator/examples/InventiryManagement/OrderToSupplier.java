/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 39 "InventoryManagement.ump"
// line 85 "InventoryManagement.ump"
public class OrderToSupplier
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //OrderToSupplier Attributes
  private String poNumber;
  private String dateOrdered;

  //OrderToSupplier Associations
  private List<SupplierOrderLineItem> supplierOrderLineItems;
  private Supplier supplier;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public OrderToSupplier(String aPoNumber, String aDateOrdered, Supplier aSupplier)
  {
    poNumber = aPoNumber;
    dateOrdered = aDateOrdered;
    supplierOrderLineItems = new ArrayList<SupplierOrderLineItem>();
    boolean didAddSupplier = setSupplier(aSupplier);
    if (!didAddSupplier)
    {
      throw new RuntimeException("Unable to create orderToSupplier due to supplier");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPoNumber(String aPoNumber)
  {
    boolean wasSet = false;
    poNumber = aPoNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setDateOrdered(String aDateOrdered)
  {
    boolean wasSet = false;
    dateOrdered = aDateOrdered;
    wasSet = true;
    return wasSet;
  }

  public String getPoNumber()
  {
    return poNumber;
  }

  public String getDateOrdered()
  {
    return dateOrdered;
  }

  public SupplierOrderLineItem getSupplierOrderLineItem(int index)
  {
    SupplierOrderLineItem aSupplierOrderLineItem = supplierOrderLineItems.get(index);
    return aSupplierOrderLineItem;
  }

  public List<SupplierOrderLineItem> getSupplierOrderLineItems()
  {
    List<SupplierOrderLineItem> newSupplierOrderLineItems = Collections.unmodifiableList(supplierOrderLineItems);
    return newSupplierOrderLineItems;
  }

  public int numberOfSupplierOrderLineItems()
  {
    int number = supplierOrderLineItems.size();
    return number;
  }

  public boolean hasSupplierOrderLineItems()
  {
    boolean has = supplierOrderLineItems.size() > 0;
    return has;
  }

  public int indexOfSupplierOrderLineItem(SupplierOrderLineItem aSupplierOrderLineItem)
  {
    int index = supplierOrderLineItems.indexOf(aSupplierOrderLineItem);
    return index;
  }

  public Supplier getSupplier()
  {
    return supplier;
  }

  public static int minimumNumberOfSupplierOrderLineItems()
  {
    return 0;
  }

  public SupplierOrderLineItem addSupplierOrderLineItem(String aNumberOrdered, String aDateExpected, ProductSource aProductSource)
  {
    return new SupplierOrderLineItem(aNumberOrdered, aDateExpected, aProductSource, this);
  }

  public boolean addSupplierOrderLineItem(SupplierOrderLineItem aSupplierOrderLineItem)
  {
    boolean wasAdded = false;
    if (supplierOrderLineItems.contains(aSupplierOrderLineItem)) { return false; }
    OrderToSupplier existingOrderToSupplier = aSupplierOrderLineItem.getOrderToSupplier();
    boolean isNewOrderToSupplier = existingOrderToSupplier != null && !this.equals(existingOrderToSupplier);
    if (isNewOrderToSupplier)
    {
      aSupplierOrderLineItem.setOrderToSupplier(this);
    }
    else
    {
      supplierOrderLineItems.add(aSupplierOrderLineItem);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSupplierOrderLineItem(SupplierOrderLineItem aSupplierOrderLineItem)
  {
    boolean wasRemoved = false;
    //Unable to remove aSupplierOrderLineItem, as it must always have a orderToSupplier
    if (!this.equals(aSupplierOrderLineItem.getOrderToSupplier()))
    {
      supplierOrderLineItems.remove(aSupplierOrderLineItem);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addSupplierOrderLineItemAt(SupplierOrderLineItem aSupplierOrderLineItem, int index)
  {  
    boolean wasAdded = false;
    if(addSupplierOrderLineItem(aSupplierOrderLineItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSupplierOrderLineItems()) { index = numberOfSupplierOrderLineItems() - 1; }
      supplierOrderLineItems.remove(aSupplierOrderLineItem);
      supplierOrderLineItems.add(index, aSupplierOrderLineItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSupplierOrderLineItemAt(SupplierOrderLineItem aSupplierOrderLineItem, int index)
  {
    boolean wasAdded = false;
    if(supplierOrderLineItems.contains(aSupplierOrderLineItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSupplierOrderLineItems()) { index = numberOfSupplierOrderLineItems() - 1; }
      supplierOrderLineItems.remove(aSupplierOrderLineItem);
      supplierOrderLineItems.add(index, aSupplierOrderLineItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSupplierOrderLineItemAt(aSupplierOrderLineItem, index);
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
      existingSupplier.removeOrderToSupplier(this);
    }
    supplier.addOrderToSupplier(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=supplierOrderLineItems.size(); i > 0; i--)
    {
      SupplierOrderLineItem aSupplierOrderLineItem = supplierOrderLineItems.get(i - 1);
      aSupplierOrderLineItem.delete();
    }
    Supplier placeholderSupplier = supplier;
    this.supplier = null;
    placeholderSupplier.removeOrderToSupplier(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "poNumber" + ":" + getPoNumber()+ "," +
            "dateOrdered" + ":" + getDateOrdered()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "supplier = "+(getSupplier()!=null?Integer.toHexString(System.identityHashCode(getSupplier())):"null")
     + outputString;
  }
}