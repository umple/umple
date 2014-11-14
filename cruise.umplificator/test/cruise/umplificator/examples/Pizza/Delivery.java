/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.sql.Time;
import java.util.*;

// line 57 "Pizza.ump"
// line 112 "Pizza.ump"
public class Delivery
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Delivery Attributes
  private Time timePickedUp;
  private Time timeDelivered;

  //Delivery Associations
  private Driver driver;
  private List<Order> orders;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Delivery(Time aTimePickedUp, Time aTimeDelivered, Order... allOrders)
  {
    timePickedUp = aTimePickedUp;
    timeDelivered = aTimeDelivered;
    orders = new ArrayList<Order>();
    boolean didAddOrders = setOrders(allOrders);
    if (!didAddOrders)
    {
      throw new RuntimeException("Unable to create Delivery, must have at least 1 orders");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTimePickedUp(Time aTimePickedUp)
  {
    boolean wasSet = false;
    timePickedUp = aTimePickedUp;
    wasSet = true;
    return wasSet;
  }

  public boolean setTimeDelivered(Time aTimeDelivered)
  {
    boolean wasSet = false;
    timeDelivered = aTimeDelivered;
    wasSet = true;
    return wasSet;
  }

  public Time getTimePickedUp()
  {
    return timePickedUp;
  }

  public Time getTimeDelivered()
  {
    return timeDelivered;
  }

  public Driver getDriver()
  {
    return driver;
  }

  public boolean hasDriver()
  {
    boolean has = driver != null;
    return has;
  }

  public Order getOrder(int index)
  {
    Order aOrder = orders.get(index);
    return aOrder;
  }

  public List<Order> getOrders()
  {
    List<Order> newOrders = Collections.unmodifiableList(orders);
    return newOrders;
  }

  public int numberOfOrders()
  {
    int number = orders.size();
    return number;
  }

  public boolean hasOrders()
  {
    boolean has = orders.size() > 0;
    return has;
  }

  public int indexOfOrder(Order aOrder)
  {
    int index = orders.indexOf(aOrder);
    return index;
  }

  public boolean setDriver(Driver aDriver)
  {
    boolean wasSet = false;
    Driver existingDriver = driver;
    driver = aDriver;
    if (existingDriver != null && !existingDriver.equals(aDriver))
    {
      existingDriver.removeDelivery(this);
    }
    if (aDriver != null)
    {
      aDriver.addDelivery(this);
    }
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfOrders()
  {
    return 1;
  }

  public boolean addOrder(Order aOrder)
  {
    boolean wasAdded = false;
    if (orders.contains(aOrder)) { return false; }
    Delivery existingDelivery = aOrder.getDelivery();
    if (existingDelivery != null && existingDelivery.numberOfOrders() <= minimumNumberOfOrders())
    {
      return wasAdded;
    }
    else if (existingDelivery != null)
    {
      existingDelivery.orders.remove(aOrder);
    }
    orders.add(aOrder);
    setDelivery(aOrder,this);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrder(Order aOrder)
  {
    boolean wasRemoved = false;
    if (orders.contains(aOrder) && numberOfOrders() > minimumNumberOfOrders())
    {
      orders.remove(aOrder);
      setDelivery(aOrder,null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean setOrders(Order... newOrders)
  {
    boolean wasSet = false;
    if (newOrders.length < minimumNumberOfOrders())
    {
      return wasSet;
    }

    ArrayList<Order> checkNewOrders = new ArrayList<Order>();
    HashMap<Delivery,Integer> deliveryToNewOrders = new HashMap<Delivery,Integer>();
    for (Order aOrder : newOrders)
    {
      if (checkNewOrders.contains(aOrder))
      {
        return wasSet;
      }
      else if (aOrder.getDelivery() != null && !this.equals(aOrder.getDelivery()))
      {
        Delivery existingDelivery = aOrder.getDelivery();
        if (!deliveryToNewOrders.containsKey(existingDelivery))
        {
          deliveryToNewOrders.put(existingDelivery, new Integer(existingDelivery.numberOfOrders()));
        }
        Integer currentCount = deliveryToNewOrders.get(existingDelivery);
        int nextCount = currentCount - 1;
        if (nextCount < 1)
        {
          return wasSet;
        }
        deliveryToNewOrders.put(existingDelivery, new Integer(nextCount));
      }
      checkNewOrders.add(aOrder);
    }

    orders.removeAll(checkNewOrders);

    for (Order orphan : orders)
    {
      setDelivery(orphan, null);
    }
    orders.clear();
    for (Order aOrder : newOrders)
    {
      if (aOrder.getDelivery() != null)
      {
        aOrder.getDelivery().orders.remove(aOrder);
      }
      setDelivery(aOrder, this);
      orders.add(aOrder);
    }
    wasSet = true;
    return wasSet;
  }

  private void setDelivery(Order aOrder, Delivery aDelivery)
  {
    try
    {
      java.lang.reflect.Field mentorField = aOrder.getClass().getDeclaredField("delivery");
      mentorField.setAccessible(true);
      mentorField.set(aOrder, aDelivery);
    }
    catch (Exception e)
    {
      throw new RuntimeException("Issue internally setting aDelivery to aOrder", e);
    }
  }

  public boolean addOrderAt(Order aOrder, int index)
  {  
    boolean wasAdded = false;
    if(addOrder(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrderAt(Order aOrder, int index)
  {
    boolean wasAdded = false;
    if(orders.contains(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrderAt(aOrder, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    if (driver != null)
    {
      Driver placeholderDriver = driver;
      this.driver = null;
      placeholderDriver.removeDelivery(this);
    }
    for(Order aOrder : orders)
    {
      setDelivery(aOrder,null);
    }
    orders.clear();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "timePickedUp" + "=" + (getTimePickedUp() != null ? !getTimePickedUp().equals(this)  ? getTimePickedUp().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "timeDelivered" + "=" + (getTimeDelivered() != null ? !getTimeDelivered().equals(this)  ? getTimeDelivered().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "driver = "+(getDriver()!=null?Integer.toHexString(System.identityHashCode(getDriver())):"null")
     + outputString;
  }
}