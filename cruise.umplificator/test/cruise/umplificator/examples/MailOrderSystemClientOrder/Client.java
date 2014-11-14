/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 9 "MailOrderSystemClientOrder.ump"
// line 48 "MailOrderSystemClientOrder.ump"
public class Client
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Client Attributes
  private String number;
  private String name;
  private String address;
  private String phone;
  private String creditLimit;

  //Client Associations
  private List<OrderFromClient> orderFromClients;
  private List<ShipmentToClient> shipmentToClients;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Client(String aNumber, String aName, String aAddress, String aPhone, String aCreditLimit)
  {
    number = aNumber;
    name = aName;
    address = aAddress;
    phone = aPhone;
    creditLimit = aCreditLimit;
    orderFromClients = new ArrayList<OrderFromClient>();
    shipmentToClients = new ArrayList<ShipmentToClient>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumber(String aNumber)
  {
    boolean wasSet = false;
    number = aNumber;
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

  public boolean setPhone(String aPhone)
  {
    boolean wasSet = false;
    phone = aPhone;
    wasSet = true;
    return wasSet;
  }

  public boolean setCreditLimit(String aCreditLimit)
  {
    boolean wasSet = false;
    creditLimit = aCreditLimit;
    wasSet = true;
    return wasSet;
  }

  public String getNumber()
  {
    return number;
  }

  public String getName()
  {
    return name;
  }

  public String getAddress()
  {
    return address;
  }

  public String getPhone()
  {
    return phone;
  }

  public String getCreditLimit()
  {
    return creditLimit;
  }

  public OrderFromClient getOrderFromClient(int index)
  {
    OrderFromClient aOrderFromClient = orderFromClients.get(index);
    return aOrderFromClient;
  }

  public List<OrderFromClient> getOrderFromClients()
  {
    List<OrderFromClient> newOrderFromClients = Collections.unmodifiableList(orderFromClients);
    return newOrderFromClients;
  }

  public int numberOfOrderFromClients()
  {
    int number = orderFromClients.size();
    return number;
  }

  public boolean hasOrderFromClients()
  {
    boolean has = orderFromClients.size() > 0;
    return has;
  }

  public int indexOfOrderFromClient(OrderFromClient aOrderFromClient)
  {
    int index = orderFromClients.indexOf(aOrderFromClient);
    return index;
  }

  public ShipmentToClient getShipmentToClient(int index)
  {
    ShipmentToClient aShipmentToClient = shipmentToClients.get(index);
    return aShipmentToClient;
  }

  public List<ShipmentToClient> getShipmentToClients()
  {
    List<ShipmentToClient> newShipmentToClients = Collections.unmodifiableList(shipmentToClients);
    return newShipmentToClients;
  }

  public int numberOfShipmentToClients()
  {
    int number = shipmentToClients.size();
    return number;
  }

  public boolean hasShipmentToClients()
  {
    boolean has = shipmentToClients.size() > 0;
    return has;
  }

  public int indexOfShipmentToClient(ShipmentToClient aShipmentToClient)
  {
    int index = shipmentToClients.indexOf(aShipmentToClient);
    return index;
  }

  public static int minimumNumberOfOrderFromClients()
  {
    return 0;
  }

  public OrderFromClient addOrderFromClient(String aOurOrderNumber, String aDatePlaced, String aClientsPurchaseOrder, String aCreditCardToCharge)
  {
    return new OrderFromClient(aOurOrderNumber, aDatePlaced, aClientsPurchaseOrder, aCreditCardToCharge, this);
  }

  public boolean addOrderFromClient(OrderFromClient aOrderFromClient)
  {
    boolean wasAdded = false;
    if (orderFromClients.contains(aOrderFromClient)) { return false; }
    Client existingClient = aOrderFromClient.getClient();
    boolean isNewClient = existingClient != null && !this.equals(existingClient);
    if (isNewClient)
    {
      aOrderFromClient.setClient(this);
    }
    else
    {
      orderFromClients.add(aOrderFromClient);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrderFromClient(OrderFromClient aOrderFromClient)
  {
    boolean wasRemoved = false;
    //Unable to remove aOrderFromClient, as it must always have a client
    if (!this.equals(aOrderFromClient.getClient()))
    {
      orderFromClients.remove(aOrderFromClient);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addOrderFromClientAt(OrderFromClient aOrderFromClient, int index)
  {  
    boolean wasAdded = false;
    if(addOrderFromClient(aOrderFromClient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrderFromClients()) { index = numberOfOrderFromClients() - 1; }
      orderFromClients.remove(aOrderFromClient);
      orderFromClients.add(index, aOrderFromClient);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrderFromClientAt(OrderFromClient aOrderFromClient, int index)
  {
    boolean wasAdded = false;
    if(orderFromClients.contains(aOrderFromClient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrderFromClients()) { index = numberOfOrderFromClients() - 1; }
      orderFromClients.remove(aOrderFromClient);
      orderFromClients.add(index, aOrderFromClient);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrderFromClientAt(aOrderFromClient, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfShipmentToClients()
  {
    return 0;
  }

  public ShipmentToClient addShipmentToClient(String aDateShipped, String aInvoiceNumber, String aTotalPriceOfShipment, String aAmountPaid)
  {
    return new ShipmentToClient(aDateShipped, aInvoiceNumber, aTotalPriceOfShipment, aAmountPaid, this);
  }

  public boolean addShipmentToClient(ShipmentToClient aShipmentToClient)
  {
    boolean wasAdded = false;
    if (shipmentToClients.contains(aShipmentToClient)) { return false; }
    Client existingClient = aShipmentToClient.getClient();
    boolean isNewClient = existingClient != null && !this.equals(existingClient);
    if (isNewClient)
    {
      aShipmentToClient.setClient(this);
    }
    else
    {
      shipmentToClients.add(aShipmentToClient);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeShipmentToClient(ShipmentToClient aShipmentToClient)
  {
    boolean wasRemoved = false;
    //Unable to remove aShipmentToClient, as it must always have a client
    if (!this.equals(aShipmentToClient.getClient()))
    {
      shipmentToClients.remove(aShipmentToClient);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addShipmentToClientAt(ShipmentToClient aShipmentToClient, int index)
  {  
    boolean wasAdded = false;
    if(addShipmentToClient(aShipmentToClient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfShipmentToClients()) { index = numberOfShipmentToClients() - 1; }
      shipmentToClients.remove(aShipmentToClient);
      shipmentToClients.add(index, aShipmentToClient);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveShipmentToClientAt(ShipmentToClient aShipmentToClient, int index)
  {
    boolean wasAdded = false;
    if(shipmentToClients.contains(aShipmentToClient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfShipmentToClients()) { index = numberOfShipmentToClients() - 1; }
      shipmentToClients.remove(aShipmentToClient);
      shipmentToClients.add(index, aShipmentToClient);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addShipmentToClientAt(aShipmentToClient, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=orderFromClients.size(); i > 0; i--)
    {
      OrderFromClient aOrderFromClient = orderFromClients.get(i - 1);
      aOrderFromClient.delete();
    }
    for(int i=shipmentToClients.size(); i > 0; i--)
    {
      ShipmentToClient aShipmentToClient = shipmentToClients.get(i - 1);
      aShipmentToClient.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "number" + ":" + getNumber()+ "," +
            "name" + ":" + getName()+ "," +
            "address" + ":" + getAddress()+ "," +
            "phone" + ":" + getPhone()+ "," +
            "creditLimit" + ":" + getCreditLimit()+ "]"
     + outputString;
  }
}