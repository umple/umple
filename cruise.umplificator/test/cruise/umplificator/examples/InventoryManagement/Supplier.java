/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 21 "InventoryManagement.ump"
// line 60 "InventoryManagement.ump"
public class Supplier
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Supplier Attributes
  private String id;
  private String name;
  private String address;

  //Supplier Associations
  private List<ProductSource> productSources;
  private List<OrderToSupplier> orderToSuppliers;
  private List<ReceivedDelivery> receivedDeliveries;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Supplier(String aId, String aName, String aAddress)
  {
    id = aId;
    name = aName;
    address = aAddress;
    productSources = new ArrayList<ProductSource>();
    orderToSuppliers = new ArrayList<OrderToSupplier>();
    receivedDeliveries = new ArrayList<ReceivedDelivery>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public String getAddress()
  {
    return address;
  }

  public ProductSource getProductSource(int index)
  {
    ProductSource aProductSource = productSources.get(index);
    return aProductSource;
  }

  public List<ProductSource> getProductSources()
  {
    List<ProductSource> newProductSources = Collections.unmodifiableList(productSources);
    return newProductSources;
  }

  public int numberOfProductSources()
  {
    int number = productSources.size();
    return number;
  }

  public boolean hasProductSources()
  {
    boolean has = productSources.size() > 0;
    return has;
  }

  public int indexOfProductSource(ProductSource aProductSource)
  {
    int index = productSources.indexOf(aProductSource);
    return index;
  }

  public OrderToSupplier getOrderToSupplier(int index)
  {
    OrderToSupplier aOrderToSupplier = orderToSuppliers.get(index);
    return aOrderToSupplier;
  }

  public List<OrderToSupplier> getOrderToSuppliers()
  {
    List<OrderToSupplier> newOrderToSuppliers = Collections.unmodifiableList(orderToSuppliers);
    return newOrderToSuppliers;
  }

  public int numberOfOrderToSuppliers()
  {
    int number = orderToSuppliers.size();
    return number;
  }

  public boolean hasOrderToSuppliers()
  {
    boolean has = orderToSuppliers.size() > 0;
    return has;
  }

  public int indexOfOrderToSupplier(OrderToSupplier aOrderToSupplier)
  {
    int index = orderToSuppliers.indexOf(aOrderToSupplier);
    return index;
  }

  public ReceivedDelivery getReceivedDelivery(int index)
  {
    ReceivedDelivery aReceivedDelivery = receivedDeliveries.get(index);
    return aReceivedDelivery;
  }

  public List<ReceivedDelivery> getReceivedDeliveries()
  {
    List<ReceivedDelivery> newReceivedDeliveries = Collections.unmodifiableList(receivedDeliveries);
    return newReceivedDeliveries;
  }

  public int numberOfReceivedDeliveries()
  {
    int number = receivedDeliveries.size();
    return number;
  }

  public boolean hasReceivedDeliveries()
  {
    boolean has = receivedDeliveries.size() > 0;
    return has;
  }

  public int indexOfReceivedDelivery(ReceivedDelivery aReceivedDelivery)
  {
    int index = receivedDeliveries.indexOf(aReceivedDelivery);
    return index;
  }

  public static int minimumNumberOfProductSources()
  {
    return 0;
  }

  public ProductSource addProductSource(String aAdvertisedCostPerUnit, Product aProduct)
  {
    return new ProductSource(aAdvertisedCostPerUnit, aProduct, this);
  }

  public boolean addProductSource(ProductSource aProductSource)
  {
    boolean wasAdded = false;
    if (productSources.contains(aProductSource)) { return false; }
    Supplier existingSupplier = aProductSource.getSupplier();
    boolean isNewSupplier = existingSupplier != null && !this.equals(existingSupplier);
    if (isNewSupplier)
    {
      aProductSource.setSupplier(this);
    }
    else
    {
      productSources.add(aProductSource);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeProductSource(ProductSource aProductSource)
  {
    boolean wasRemoved = false;
    //Unable to remove aProductSource, as it must always have a supplier
    if (!this.equals(aProductSource.getSupplier()))
    {
      productSources.remove(aProductSource);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addProductSourceAt(ProductSource aProductSource, int index)
  {  
    boolean wasAdded = false;
    if(addProductSource(aProductSource))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfProductSources()) { index = numberOfProductSources() - 1; }
      productSources.remove(aProductSource);
      productSources.add(index, aProductSource);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveProductSourceAt(ProductSource aProductSource, int index)
  {
    boolean wasAdded = false;
    if(productSources.contains(aProductSource))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfProductSources()) { index = numberOfProductSources() - 1; }
      productSources.remove(aProductSource);
      productSources.add(index, aProductSource);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addProductSourceAt(aProductSource, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfOrderToSuppliers()
  {
    return 0;
  }

  public OrderToSupplier addOrderToSupplier(String aPoNumber, String aDateOrdered)
  {
    return new OrderToSupplier(aPoNumber, aDateOrdered, this);
  }

  public boolean addOrderToSupplier(OrderToSupplier aOrderToSupplier)
  {
    boolean wasAdded = false;
    if (orderToSuppliers.contains(aOrderToSupplier)) { return false; }
    Supplier existingSupplier = aOrderToSupplier.getSupplier();
    boolean isNewSupplier = existingSupplier != null && !this.equals(existingSupplier);
    if (isNewSupplier)
    {
      aOrderToSupplier.setSupplier(this);
    }
    else
    {
      orderToSuppliers.add(aOrderToSupplier);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrderToSupplier(OrderToSupplier aOrderToSupplier)
  {
    boolean wasRemoved = false;
    //Unable to remove aOrderToSupplier, as it must always have a supplier
    if (!this.equals(aOrderToSupplier.getSupplier()))
    {
      orderToSuppliers.remove(aOrderToSupplier);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addOrderToSupplierAt(OrderToSupplier aOrderToSupplier, int index)
  {  
    boolean wasAdded = false;
    if(addOrderToSupplier(aOrderToSupplier))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrderToSuppliers()) { index = numberOfOrderToSuppliers() - 1; }
      orderToSuppliers.remove(aOrderToSupplier);
      orderToSuppliers.add(index, aOrderToSupplier);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrderToSupplierAt(OrderToSupplier aOrderToSupplier, int index)
  {
    boolean wasAdded = false;
    if(orderToSuppliers.contains(aOrderToSupplier))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrderToSuppliers()) { index = numberOfOrderToSuppliers() - 1; }
      orderToSuppliers.remove(aOrderToSupplier);
      orderToSuppliers.add(index, aOrderToSupplier);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrderToSupplierAt(aOrderToSupplier, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfReceivedDeliveries()
  {
    return 0;
  }

  public ReceivedDelivery addReceivedDelivery(String aNumberReceived, String aActualCostPerUnit)
  {
    return new ReceivedDelivery(aNumberReceived, aActualCostPerUnit, this);
  }

  public boolean addReceivedDelivery(ReceivedDelivery aReceivedDelivery)
  {
    boolean wasAdded = false;
    if (receivedDeliveries.contains(aReceivedDelivery)) { return false; }
    Supplier existingSupplier = aReceivedDelivery.getSupplier();
    boolean isNewSupplier = existingSupplier != null && !this.equals(existingSupplier);
    if (isNewSupplier)
    {
      aReceivedDelivery.setSupplier(this);
    }
    else
    {
      receivedDeliveries.add(aReceivedDelivery);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeReceivedDelivery(ReceivedDelivery aReceivedDelivery)
  {
    boolean wasRemoved = false;
    //Unable to remove aReceivedDelivery, as it must always have a supplier
    if (!this.equals(aReceivedDelivery.getSupplier()))
    {
      receivedDeliveries.remove(aReceivedDelivery);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addReceivedDeliveryAt(ReceivedDelivery aReceivedDelivery, int index)
  {  
    boolean wasAdded = false;
    if(addReceivedDelivery(aReceivedDelivery))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfReceivedDeliveries()) { index = numberOfReceivedDeliveries() - 1; }
      receivedDeliveries.remove(aReceivedDelivery);
      receivedDeliveries.add(index, aReceivedDelivery);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveReceivedDeliveryAt(ReceivedDelivery aReceivedDelivery, int index)
  {
    boolean wasAdded = false;
    if(receivedDeliveries.contains(aReceivedDelivery))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfReceivedDeliveries()) { index = numberOfReceivedDeliveries() - 1; }
      receivedDeliveries.remove(aReceivedDelivery);
      receivedDeliveries.add(index, aReceivedDelivery);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addReceivedDeliveryAt(aReceivedDelivery, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=productSources.size(); i > 0; i--)
    {
      ProductSource aProductSource = productSources.get(i - 1);
      aProductSource.delete();
    }
    for(int i=orderToSuppliers.size(); i > 0; i--)
    {
      OrderToSupplier aOrderToSupplier = orderToSuppliers.get(i - 1);
      aOrderToSupplier.delete();
    }
    for(int i=receivedDeliveries.size(); i > 0; i--)
    {
      ReceivedDelivery aReceivedDelivery = receivedDeliveries.get(i - 1);
      aReceivedDelivery.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "name" + ":" + getName()+ "," +
            "address" + ":" + getAddress()+ "]"
     + outputString;
  }
}