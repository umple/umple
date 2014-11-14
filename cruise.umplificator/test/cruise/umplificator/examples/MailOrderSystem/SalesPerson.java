/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 21 "MailOrderSystem.ump"
public class SalesPerson
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SalesPerson Attributes
  private String name;

  //SalesPerson Associations
  private List<OrderFromClient> orderFromClients;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SalesPerson(String aName)
  {
    name = aName;
    orderFromClients = new ArrayList<OrderFromClient>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
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

  public static int minimumNumberOfOrderFromClients()
  {
    return 0;
  }

  public boolean addOrderFromClient(OrderFromClient aOrderFromClient)
  {
    boolean wasAdded = false;
    if (orderFromClients.contains(aOrderFromClient)) { return false; }
    SalesPerson existingSalesPerson = aOrderFromClient.getSalesPerson();
    if (existingSalesPerson == null)
    {
      aOrderFromClient.setSalesPerson(this);
    }
    else if (!this.equals(existingSalesPerson))
    {
      existingSalesPerson.removeOrderFromClient(aOrderFromClient);
      addOrderFromClient(aOrderFromClient);
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
    if (orderFromClients.contains(aOrderFromClient))
    {
      orderFromClients.remove(aOrderFromClient);
      aOrderFromClient.setSalesPerson(null);
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

  public void delete()
  {
    while( !orderFromClients.isEmpty() )
    {
      orderFromClients.get(0).setSalesPerson(null);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]"
     + outputString;
  }
}