/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 22 "MailOrderSystemClientOrder.ump"
// line 67 "MailOrderSystemClientOrder.ump"
public class ClientOrderLineItem
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClientOrderLineItem Attributes
  private String numberOrdered;
  private String pricePerUnitCharged;

  //ClientOrderLineItem Associations
  private List<ShipmentLineItem> shipmentLineItems;
  private OrderFromClient orderFromClient;
  private Product product;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ClientOrderLineItem(String aNumberOrdered, String aPricePerUnitCharged, OrderFromClient aOrderFromClient, Product aProduct)
  {
    numberOrdered = aNumberOrdered;
    pricePerUnitCharged = aPricePerUnitCharged;
    shipmentLineItems = new ArrayList<ShipmentLineItem>();
    boolean didAddOrderFromClient = setOrderFromClient(aOrderFromClient);
    if (!didAddOrderFromClient)
    {
      throw new RuntimeException("Unable to create clientOrderLineItem due to orderFromClient");
    }
    boolean didAddProduct = setProduct(aProduct);
    if (!didAddProduct)
    {
      throw new RuntimeException("Unable to create clientOrderLineItem due to product");
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

  public boolean setPricePerUnitCharged(String aPricePerUnitCharged)
  {
    boolean wasSet = false;
    pricePerUnitCharged = aPricePerUnitCharged;
    wasSet = true;
    return wasSet;
  }

  public String getNumberOrdered()
  {
    return numberOrdered;
  }

  public String getPricePerUnitCharged()
  {
    return pricePerUnitCharged;
  }

  public ShipmentLineItem getShipmentLineItem(int index)
  {
    ShipmentLineItem aShipmentLineItem = shipmentLineItems.get(index);
    return aShipmentLineItem;
  }

  public List<ShipmentLineItem> getShipmentLineItems()
  {
    List<ShipmentLineItem> newShipmentLineItems = Collections.unmodifiableList(shipmentLineItems);
    return newShipmentLineItems;
  }

  public int numberOfShipmentLineItems()
  {
    int number = shipmentLineItems.size();
    return number;
  }

  public boolean hasShipmentLineItems()
  {
    boolean has = shipmentLineItems.size() > 0;
    return has;
  }

  public int indexOfShipmentLineItem(ShipmentLineItem aShipmentLineItem)
  {
    int index = shipmentLineItems.indexOf(aShipmentLineItem);
    return index;
  }

  public OrderFromClient getOrderFromClient()
  {
    return orderFromClient;
  }

  public Product getProduct()
  {
    return product;
  }

  public static int minimumNumberOfShipmentLineItems()
  {
    return 0;
  }

  public ShipmentLineItem addShipmentLineItem(String aNumShipped, ShipmentToClient aShipmentToClient)
  {
    return new ShipmentLineItem(aNumShipped, this, aShipmentToClient);
  }

  public boolean addShipmentLineItem(ShipmentLineItem aShipmentLineItem)
  {
    boolean wasAdded = false;
    if (shipmentLineItems.contains(aShipmentLineItem)) { return false; }
    ClientOrderLineItem existingClientOrderLineItem = aShipmentLineItem.getClientOrderLineItem();
    boolean isNewClientOrderLineItem = existingClientOrderLineItem != null && !this.equals(existingClientOrderLineItem);
    if (isNewClientOrderLineItem)
    {
      aShipmentLineItem.setClientOrderLineItem(this);
    }
    else
    {
      shipmentLineItems.add(aShipmentLineItem);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeShipmentLineItem(ShipmentLineItem aShipmentLineItem)
  {
    boolean wasRemoved = false;
    //Unable to remove aShipmentLineItem, as it must always have a clientOrderLineItem
    if (!this.equals(aShipmentLineItem.getClientOrderLineItem()))
    {
      shipmentLineItems.remove(aShipmentLineItem);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addShipmentLineItemAt(ShipmentLineItem aShipmentLineItem, int index)
  {  
    boolean wasAdded = false;
    if(addShipmentLineItem(aShipmentLineItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfShipmentLineItems()) { index = numberOfShipmentLineItems() - 1; }
      shipmentLineItems.remove(aShipmentLineItem);
      shipmentLineItems.add(index, aShipmentLineItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveShipmentLineItemAt(ShipmentLineItem aShipmentLineItem, int index)
  {
    boolean wasAdded = false;
    if(shipmentLineItems.contains(aShipmentLineItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfShipmentLineItems()) { index = numberOfShipmentLineItems() - 1; }
      shipmentLineItems.remove(aShipmentLineItem);
      shipmentLineItems.add(index, aShipmentLineItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addShipmentLineItemAt(aShipmentLineItem, index);
    }
    return wasAdded;
  }

  public boolean setOrderFromClient(OrderFromClient aOrderFromClient)
  {
    boolean wasSet = false;
    if (aOrderFromClient == null)
    {
      return wasSet;
    }

    OrderFromClient existingOrderFromClient = orderFromClient;
    orderFromClient = aOrderFromClient;
    if (existingOrderFromClient != null && !existingOrderFromClient.equals(aOrderFromClient))
    {
      existingOrderFromClient.removeClientOrderLineItem(this);
    }
    orderFromClient.addClientOrderLineItem(this);
    wasSet = true;
    return wasSet;
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
      existingProduct.removeClientOrderLineItem(this);
    }
    product.addClientOrderLineItem(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=shipmentLineItems.size(); i > 0; i--)
    {
      ShipmentLineItem aShipmentLineItem = shipmentLineItems.get(i - 1);
      aShipmentLineItem.delete();
    }
    OrderFromClient placeholderOrderFromClient = orderFromClient;
    this.orderFromClient = null;
    placeholderOrderFromClient.removeClientOrderLineItem(this);
    Product placeholderProduct = product;
    this.product = null;
    placeholderProduct.removeClientOrderLineItem(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "numberOrdered" + ":" + getNumberOrdered()+ "," +
            "pricePerUnitCharged" + ":" + getPricePerUnitCharged()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "orderFromClient = "+(getOrderFromClient()!=null?Integer.toHexString(System.identityHashCode(getOrderFromClient())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "product = "+(getProduct()!=null?Integer.toHexString(System.identityHashCode(getProduct())):"null")
     + outputString;
  }
}