/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 16 "MailOrderSystem.ump"
public class OrderFromClient
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //OrderFromClient Attributes
  private String ourOrderNumber;
  private String datePlaced;
  private String clientsPurchaseOrder;
  private String creditCardToCharge;

  //OrderFromClient Associations
  private List<ClientOrderLineItem> clientOrderLineItems;
  private Client client;
  private SalesPerson salesPerson;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public OrderFromClient(String aOurOrderNumber, String aDatePlaced, String aClientsPurchaseOrder, String aCreditCardToCharge, Client aClient)
  {
    ourOrderNumber = aOurOrderNumber;
    datePlaced = aDatePlaced;
    clientsPurchaseOrder = aClientsPurchaseOrder;
    creditCardToCharge = aCreditCardToCharge;
    clientOrderLineItems = new ArrayList<ClientOrderLineItem>();
    boolean didAddClient = setClient(aClient);
    if (!didAddClient)
    {
      throw new RuntimeException("Unable to create orderFromClient due to client");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setOurOrderNumber(String aOurOrderNumber)
  {
    boolean wasSet = false;
    ourOrderNumber = aOurOrderNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setDatePlaced(String aDatePlaced)
  {
    boolean wasSet = false;
    datePlaced = aDatePlaced;
    wasSet = true;
    return wasSet;
  }

  public boolean setClientsPurchaseOrder(String aClientsPurchaseOrder)
  {
    boolean wasSet = false;
    clientsPurchaseOrder = aClientsPurchaseOrder;
    wasSet = true;
    return wasSet;
  }

  public boolean setCreditCardToCharge(String aCreditCardToCharge)
  {
    boolean wasSet = false;
    creditCardToCharge = aCreditCardToCharge;
    wasSet = true;
    return wasSet;
  }

  public String getOurOrderNumber()
  {
    return ourOrderNumber;
  }

  public String getDatePlaced()
  {
    return datePlaced;
  }

  public String getClientsPurchaseOrder()
  {
    return clientsPurchaseOrder;
  }

  public String getCreditCardToCharge()
  {
    return creditCardToCharge;
  }

  public ClientOrderLineItem getClientOrderLineItem(int index)
  {
    ClientOrderLineItem aClientOrderLineItem = clientOrderLineItems.get(index);
    return aClientOrderLineItem;
  }

  public List<ClientOrderLineItem> getClientOrderLineItems()
  {
    List<ClientOrderLineItem> newClientOrderLineItems = Collections.unmodifiableList(clientOrderLineItems);
    return newClientOrderLineItems;
  }

  public int numberOfClientOrderLineItems()
  {
    int number = clientOrderLineItems.size();
    return number;
  }

  public boolean hasClientOrderLineItems()
  {
    boolean has = clientOrderLineItems.size() > 0;
    return has;
  }

  public int indexOfClientOrderLineItem(ClientOrderLineItem aClientOrderLineItem)
  {
    int index = clientOrderLineItems.indexOf(aClientOrderLineItem);
    return index;
  }

  public Client getClient()
  {
    return client;
  }

  public SalesPerson getSalesPerson()
  {
    return salesPerson;
  }

  public boolean hasSalesPerson()
  {
    boolean has = salesPerson != null;
    return has;
  }

  public static int minimumNumberOfClientOrderLineItems()
  {
    return 0;
  }

  public ClientOrderLineItem addClientOrderLineItem(String aNumberOrdered, String aPricePerUnitCharged, Product aProduct)
  {
    return new ClientOrderLineItem(aNumberOrdered, aPricePerUnitCharged, this, aProduct);
  }

  public boolean addClientOrderLineItem(ClientOrderLineItem aClientOrderLineItem)
  {
    boolean wasAdded = false;
    if (clientOrderLineItems.contains(aClientOrderLineItem)) { return false; }
    OrderFromClient existingOrderFromClient = aClientOrderLineItem.getOrderFromClient();
    boolean isNewOrderFromClient = existingOrderFromClient != null && !this.equals(existingOrderFromClient);
    if (isNewOrderFromClient)
    {
      aClientOrderLineItem.setOrderFromClient(this);
    }
    else
    {
      clientOrderLineItems.add(aClientOrderLineItem);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeClientOrderLineItem(ClientOrderLineItem aClientOrderLineItem)
  {
    boolean wasRemoved = false;
    //Unable to remove aClientOrderLineItem, as it must always have a orderFromClient
    if (!this.equals(aClientOrderLineItem.getOrderFromClient()))
    {
      clientOrderLineItems.remove(aClientOrderLineItem);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addClientOrderLineItemAt(ClientOrderLineItem aClientOrderLineItem, int index)
  {  
    boolean wasAdded = false;
    if(addClientOrderLineItem(aClientOrderLineItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfClientOrderLineItems()) { index = numberOfClientOrderLineItems() - 1; }
      clientOrderLineItems.remove(aClientOrderLineItem);
      clientOrderLineItems.add(index, aClientOrderLineItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveClientOrderLineItemAt(ClientOrderLineItem aClientOrderLineItem, int index)
  {
    boolean wasAdded = false;
    if(clientOrderLineItems.contains(aClientOrderLineItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfClientOrderLineItems()) { index = numberOfClientOrderLineItems() - 1; }
      clientOrderLineItems.remove(aClientOrderLineItem);
      clientOrderLineItems.add(index, aClientOrderLineItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addClientOrderLineItemAt(aClientOrderLineItem, index);
    }
    return wasAdded;
  }

  public boolean setClient(Client aClient)
  {
    boolean wasSet = false;
    if (aClient == null)
    {
      return wasSet;
    }

    Client existingClient = client;
    client = aClient;
    if (existingClient != null && !existingClient.equals(aClient))
    {
      existingClient.removeOrderFromClient(this);
    }
    client.addOrderFromClient(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setSalesPerson(SalesPerson aSalesPerson)
  {
    boolean wasSet = false;
    SalesPerson existingSalesPerson = salesPerson;
    salesPerson = aSalesPerson;
    if (existingSalesPerson != null && !existingSalesPerson.equals(aSalesPerson))
    {
      existingSalesPerson.removeOrderFromClient(this);
    }
    if (aSalesPerson != null)
    {
      aSalesPerson.addOrderFromClient(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=clientOrderLineItems.size(); i > 0; i--)
    {
      ClientOrderLineItem aClientOrderLineItem = clientOrderLineItems.get(i - 1);
      aClientOrderLineItem.delete();
    }
    Client placeholderClient = client;
    this.client = null;
    placeholderClient.removeOrderFromClient(this);
    if (salesPerson != null)
    {
      SalesPerson placeholderSalesPerson = salesPerson;
      this.salesPerson = null;
      placeholderSalesPerson.removeOrderFromClient(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "ourOrderNumber" + ":" + getOurOrderNumber()+ "," +
            "datePlaced" + ":" + getDatePlaced()+ "," +
            "clientsPurchaseOrder" + ":" + getClientsPurchaseOrder()+ "," +
            "creditCardToCharge" + ":" + getCreditCardToCharge()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "client = "+(getClient()!=null?Integer.toHexString(System.identityHashCode(getClient())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "salesPerson = "+(getSalesPerson()!=null?Integer.toHexString(System.identityHashCode(getSalesPerson())):"null")
     + outputString;
  }
}