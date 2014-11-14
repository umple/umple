/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 29 "MailOrderSystem.ump"
public class ShipmentToClient
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ShipmentToClient Attributes
  private String dateShipped;
  private String invoiceNumber;
  private String totalPriceOfShipment;
  private String amountPaid;

  //ShipmentToClient Associations
  private List<ShipmentLineItem> shipmentLineItems;
  private Client client;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ShipmentToClient(String aDateShipped, String aInvoiceNumber, String aTotalPriceOfShipment, String aAmountPaid, Client aClient)
  {
    dateShipped = aDateShipped;
    invoiceNumber = aInvoiceNumber;
    totalPriceOfShipment = aTotalPriceOfShipment;
    amountPaid = aAmountPaid;
    shipmentLineItems = new ArrayList<ShipmentLineItem>();
    boolean didAddClient = setClient(aClient);
    if (!didAddClient)
    {
      throw new RuntimeException("Unable to create shipmentToClient due to client");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDateShipped(String aDateShipped)
  {
    boolean wasSet = false;
    dateShipped = aDateShipped;
    wasSet = true;
    return wasSet;
  }

  public boolean setInvoiceNumber(String aInvoiceNumber)
  {
    boolean wasSet = false;
    invoiceNumber = aInvoiceNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setTotalPriceOfShipment(String aTotalPriceOfShipment)
  {
    boolean wasSet = false;
    totalPriceOfShipment = aTotalPriceOfShipment;
    wasSet = true;
    return wasSet;
  }

  public boolean setAmountPaid(String aAmountPaid)
  {
    boolean wasSet = false;
    amountPaid = aAmountPaid;
    wasSet = true;
    return wasSet;
  }

  public String getDateShipped()
  {
    return dateShipped;
  }

  public String getInvoiceNumber()
  {
    return invoiceNumber;
  }

  public String getTotalPriceOfShipment()
  {
    return totalPriceOfShipment;
  }

  public String getAmountPaid()
  {
    return amountPaid;
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

  public Client getClient()
  {
    return client;
  }

  public static int minimumNumberOfShipmentLineItems()
  {
    return 0;
  }

  public ShipmentLineItem addShipmentLineItem(String aNumShipped, ClientOrderLineItem aClientOrderLineItem)
  {
    return new ShipmentLineItem(aNumShipped, aClientOrderLineItem, this);
  }

  public boolean addShipmentLineItem(ShipmentLineItem aShipmentLineItem)
  {
    boolean wasAdded = false;
    if (shipmentLineItems.contains(aShipmentLineItem)) { return false; }
    ShipmentToClient existingShipmentToClient = aShipmentLineItem.getShipmentToClient();
    boolean isNewShipmentToClient = existingShipmentToClient != null && !this.equals(existingShipmentToClient);
    if (isNewShipmentToClient)
    {
      aShipmentLineItem.setShipmentToClient(this);
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
    //Unable to remove aShipmentLineItem, as it must always have a shipmentToClient
    if (!this.equals(aShipmentLineItem.getShipmentToClient()))
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
      existingClient.removeShipmentToClient(this);
    }
    client.addShipmentToClient(this);
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
    Client placeholderClient = client;
    this.client = null;
    placeholderClient.removeShipmentToClient(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "dateShipped" + ":" + getDateShipped()+ "," +
            "invoiceNumber" + ":" + getInvoiceNumber()+ "," +
            "totalPriceOfShipment" + ":" + getTotalPriceOfShipment()+ "," +
            "amountPaid" + ":" + getAmountPaid()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "client = "+(getClient()!=null?Integer.toHexString(System.identityHashCode(getClient())):"null")
     + outputString;
  }
}