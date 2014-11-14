/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 31 "MailOrderSystemClientOrder.ump"
// line 73 "MailOrderSystemClientOrder.ump"
public class ShipmentLineItem
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ShipmentLineItem Attributes
  private String numShipped;

  //ShipmentLineItem Associations
  private ClientOrderLineItem clientOrderLineItem;
  private ShipmentToClient shipmentToClient;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ShipmentLineItem(String aNumShipped, ClientOrderLineItem aClientOrderLineItem, ShipmentToClient aShipmentToClient)
  {
    numShipped = aNumShipped;
    boolean didAddClientOrderLineItem = setClientOrderLineItem(aClientOrderLineItem);
    if (!didAddClientOrderLineItem)
    {
      throw new RuntimeException("Unable to create shipmentLineItem due to clientOrderLineItem");
    }
    boolean didAddShipmentToClient = setShipmentToClient(aShipmentToClient);
    if (!didAddShipmentToClient)
    {
      throw new RuntimeException("Unable to create shipmentLineItem due to shipmentToClient");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumShipped(String aNumShipped)
  {
    boolean wasSet = false;
    numShipped = aNumShipped;
    wasSet = true;
    return wasSet;
  }

  public String getNumShipped()
  {
    return numShipped;
  }

  public ClientOrderLineItem getClientOrderLineItem()
  {
    return clientOrderLineItem;
  }

  public ShipmentToClient getShipmentToClient()
  {
    return shipmentToClient;
  }

  public boolean setClientOrderLineItem(ClientOrderLineItem aClientOrderLineItem)
  {
    boolean wasSet = false;
    if (aClientOrderLineItem == null)
    {
      return wasSet;
    }

    ClientOrderLineItem existingClientOrderLineItem = clientOrderLineItem;
    clientOrderLineItem = aClientOrderLineItem;
    if (existingClientOrderLineItem != null && !existingClientOrderLineItem.equals(aClientOrderLineItem))
    {
      existingClientOrderLineItem.removeShipmentLineItem(this);
    }
    clientOrderLineItem.addShipmentLineItem(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setShipmentToClient(ShipmentToClient aShipmentToClient)
  {
    boolean wasSet = false;
    if (aShipmentToClient == null)
    {
      return wasSet;
    }

    ShipmentToClient existingShipmentToClient = shipmentToClient;
    shipmentToClient = aShipmentToClient;
    if (existingShipmentToClient != null && !existingShipmentToClient.equals(aShipmentToClient))
    {
      existingShipmentToClient.removeShipmentLineItem(this);
    }
    shipmentToClient.addShipmentLineItem(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ClientOrderLineItem placeholderClientOrderLineItem = clientOrderLineItem;
    this.clientOrderLineItem = null;
    placeholderClientOrderLineItem.removeShipmentLineItem(this);
    ShipmentToClient placeholderShipmentToClient = shipmentToClient;
    this.shipmentToClient = null;
    placeholderShipmentToClient.removeShipmentLineItem(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "numShipped" + ":" + getNumShipped()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "clientOrderLineItem = "+(getClientOrderLineItem()!=null?Integer.toHexString(System.identityHashCode(getClientOrderLineItem())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "shipmentToClient = "+(getShipmentToClient()!=null?Integer.toHexString(System.identityHashCode(getShipmentToClient())):"null")
     + outputString;
  }
}