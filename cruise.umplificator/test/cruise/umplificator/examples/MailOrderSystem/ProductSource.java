/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 39 "MailOrderSystem.ump"
public class ProductSource
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProductSource Attributes
  private String supplierCode;
  private String advertisedCostPerUnit;

  //ProductSource Associations
  private List<SupplierOrderLineItem> supplierOrderLineItems;
  private Product product;
  private Supplier supplier;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProductSource(String aSupplierCode, String aAdvertisedCostPerUnit, Product aProduct, Supplier aSupplier)
  {
    supplierCode = aSupplierCode;
    advertisedCostPerUnit = aAdvertisedCostPerUnit;
    supplierOrderLineItems = new ArrayList<SupplierOrderLineItem>();
    boolean didAddProduct = setProduct(aProduct);
    if (!didAddProduct)
    {
      throw new RuntimeException("Unable to create productSource due to product");
    }
    boolean didAddSupplier = setSupplier(aSupplier);
    if (!didAddSupplier)
    {
      throw new RuntimeException("Unable to create productSource due to supplier");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSupplierCode(String aSupplierCode)
  {
    boolean wasSet = false;
    supplierCode = aSupplierCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setAdvertisedCostPerUnit(String aAdvertisedCostPerUnit)
  {
    boolean wasSet = false;
    advertisedCostPerUnit = aAdvertisedCostPerUnit;
    wasSet = true;
    return wasSet;
  }

  public String getSupplierCode()
  {
    return supplierCode;
  }

  public String getAdvertisedCostPerUnit()
  {
    return advertisedCostPerUnit;
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

  public Product getProduct()
  {
    return product;
  }

  public Supplier getSupplier()
  {
    return supplier;
  }

  public static int minimumNumberOfSupplierOrderLineItems()
  {
    return 0;
  }

  public SupplierOrderLineItem addSupplierOrderLineItem(String aNumberOrdered, String aDateExpected, OrderToSupplier aOrderToSupplier)
  {
    return new SupplierOrderLineItem(aNumberOrdered, aDateExpected, this, aOrderToSupplier);
  }

  public boolean addSupplierOrderLineItem(SupplierOrderLineItem aSupplierOrderLineItem)
  {
    boolean wasAdded = false;
    if (supplierOrderLineItems.contains(aSupplierOrderLineItem)) { return false; }
    ProductSource existingProductSource = aSupplierOrderLineItem.getProductSource();
    boolean isNewProductSource = existingProductSource != null && !this.equals(existingProductSource);
    if (isNewProductSource)
    {
      aSupplierOrderLineItem.setProductSource(this);
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
    //Unable to remove aSupplierOrderLineItem, as it must always have a productSource
    if (!this.equals(aSupplierOrderLineItem.getProductSource()))
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

  public boolean setProduct(Product aProduct)
  {
    boolean wasSet = false;
    if (aProduct == null)
    {
      return wasSet;
    }

    Product existingProduct = product;
    product = aProduct;
    if (existingProduct != null && !existingProduct.equals(aProduct))
    {
      existingProduct.removeProductSource(this);
    }
    product.addProductSource(this);
    wasSet = true;
    return wasSet;
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
      existingSupplier.removeProductSource(this);
    }
    supplier.addProductSource(this);
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
    Product placeholderProduct = product;
    this.product = null;
    placeholderProduct.removeProductSource(this);
    Supplier placeholderSupplier = supplier;
    this.supplier = null;
    placeholderSupplier.removeProductSource(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "supplierCode" + ":" + getSupplierCode()+ "," +
            "advertisedCostPerUnit" + ":" + getAdvertisedCostPerUnit()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "product = "+(getProduct()!=null?Integer.toHexString(System.identityHashCode(getProduct())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "supplier = "+(getSupplier()!=null?Integer.toHexString(System.identityHashCode(getSupplier())):"null")
     + outputString;
  }
}