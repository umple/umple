/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 16 "Pizza.ump"
// line 78 "Pizza.ump"
public class Order
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Order Attributes
  private String timePlaced;
  private String contactPhoneNumber;
  private float totalPrice;
  private String creditCardCharged;
  private String expiryDate;

  //Order Associations
  private List<OrderItem> orderItems;
  private Account account;
  private Delivery delivery;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Order(String aTimePlaced, String aContactPhoneNumber, float aTotalPrice, String aCreditCardCharged, String aExpiryDate)
  {
    timePlaced = aTimePlaced;
    contactPhoneNumber = aContactPhoneNumber;
    totalPrice = aTotalPrice;
    creditCardCharged = aCreditCardCharged;
    expiryDate = aExpiryDate;
    orderItems = new ArrayList<OrderItem>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTimePlaced(String aTimePlaced)
  {
    boolean wasSet = false;
    timePlaced = aTimePlaced;
    wasSet = true;
    return wasSet;
  }

  public boolean setContactPhoneNumber(String aContactPhoneNumber)
  {
    boolean wasSet = false;
    contactPhoneNumber = aContactPhoneNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setTotalPrice(float aTotalPrice)
  {
    boolean wasSet = false;
    totalPrice = aTotalPrice;
    wasSet = true;
    return wasSet;
  }

  public boolean setCreditCardCharged(String aCreditCardCharged)
  {
    boolean wasSet = false;
    creditCardCharged = aCreditCardCharged;
    wasSet = true;
    return wasSet;
  }

  public boolean setExpiryDate(String aExpiryDate)
  {
    boolean wasSet = false;
    expiryDate = aExpiryDate;
    wasSet = true;
    return wasSet;
  }

  public String getTimePlaced()
  {
    return timePlaced;
  }

  public String getContactPhoneNumber()
  {
    return contactPhoneNumber;
  }

  public float getTotalPrice()
  {
    return totalPrice;
  }

  public String getCreditCardCharged()
  {
    return creditCardCharged;
  }

  public String getExpiryDate()
  {
    return expiryDate;
  }

  public OrderItem getOrderItem(int index)
  {
    OrderItem aOrderItem = orderItems.get(index);
    return aOrderItem;
  }

  public List<OrderItem> getOrderItems()
  {
    List<OrderItem> newOrderItems = Collections.unmodifiableList(orderItems);
    return newOrderItems;
  }

  public int numberOfOrderItems()
  {
    int number = orderItems.size();
    return number;
  }

  public boolean hasOrderItems()
  {
    boolean has = orderItems.size() > 0;
    return has;
  }

  public int indexOfOrderItem(OrderItem aOrderItem)
  {
    int index = orderItems.indexOf(aOrderItem);
    return index;
  }

  public Account getAccount()
  {
    return account;
  }

  public boolean hasAccount()
  {
    boolean has = account != null;
    return has;
  }

  public Delivery getDelivery()
  {
    return delivery;
  }

  public boolean hasDelivery()
  {
    boolean has = delivery != null;
    return has;
  }

  public static int minimumNumberOfOrderItems()
  {
    return 0;
  }

  public OrderItem addOrderItem(int aNumber, float aTotalPrice)
  {
    return new OrderItem(aNumber, aTotalPrice, this);
  }

  public boolean addOrderItem(OrderItem aOrderItem)
  {
    boolean wasAdded = false;
    if (orderItems.contains(aOrderItem)) { return false; }
    Order existingOrder = aOrderItem.getOrder();
    boolean isNewOrder = existingOrder != null && !this.equals(existingOrder);
    if (isNewOrder)
    {
      aOrderItem.setOrder(this);
    }
    else
    {
      orderItems.add(aOrderItem);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrderItem(OrderItem aOrderItem)
  {
    boolean wasRemoved = false;
    //Unable to remove aOrderItem, as it must always have a order
    if (!this.equals(aOrderItem.getOrder()))
    {
      orderItems.remove(aOrderItem);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addOrderItemAt(OrderItem aOrderItem, int index)
  {  
    boolean wasAdded = false;
    if(addOrderItem(aOrderItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrderItems()) { index = numberOfOrderItems() - 1; }
      orderItems.remove(aOrderItem);
      orderItems.add(index, aOrderItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrderItemAt(OrderItem aOrderItem, int index)
  {
    boolean wasAdded = false;
    if(orderItems.contains(aOrderItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrderItems()) { index = numberOfOrderItems() - 1; }
      orderItems.remove(aOrderItem);
      orderItems.add(index, aOrderItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrderItemAt(aOrderItem, index);
    }
    return wasAdded;
  }

  public boolean setAccount(Account aAccount)
  {
    boolean wasSet = false;
    Account existingAccount = account;
    account = aAccount;
    if (existingAccount != null && !existingAccount.equals(aAccount))
    {
      existingAccount.removeOrder(this);
    }
    if (aAccount != null)
    {
      aAccount.addOrder(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setDelivery(Delivery aDelivery)
  {
    //
    // This source of this source generation is association_SetOptionalOneToMandatoryMany.jet
    // This set file assumes the generation of a maximumNumberOfXXX method does not exist because 
    // it's not required (No upper bound)
    //   
    boolean wasSet = false;
    Delivery existingDelivery = delivery;

    if (existingDelivery == null)
    {
      if (aDelivery != null)
      {
        if (aDelivery.addOrder(this))
        {
          existingDelivery = aDelivery;
          wasSet = true;
        }
      }
    } 
    else if (existingDelivery != null)
    {
      if (aDelivery == null)
      {
        if (existingDelivery.minimumNumberOfOrders() < existingDelivery.numberOfOrders())
        {
          existingDelivery.removeOrder(this);
          existingDelivery = aDelivery;  // aDelivery == null
          wasSet = true;
        }
      } 
      else
      {
        if (existingDelivery.minimumNumberOfOrders() < existingDelivery.numberOfOrders())
        {
          existingDelivery.removeOrder(this);
          aDelivery.addOrder(this);
          existingDelivery = aDelivery;
          wasSet = true;
        }
      }
    }
    if (wasSet)
    {
      delivery = existingDelivery;
    }
    return wasSet;
  }
  
  public void delete()
  {
    for(int i=orderItems.size(); i > 0; i--)
    {
      OrderItem aOrderItem = orderItems.get(i - 1);
      aOrderItem.delete();
    }
    if (account != null)
    {
      Account placeholderAccount = account;
      this.account = null;
      placeholderAccount.removeOrder(this);
    }
    if (delivery != null)
    {
      if (delivery.numberOfOrders() <= 1)
      {
        delivery.delete();
      }
      else
      {
        Delivery placeholderDelivery = delivery;
        this.delivery = null;
        placeholderDelivery.removeOrder(this);
      }
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "timePlaced" + ":" + getTimePlaced()+ "," +
            "contactPhoneNumber" + ":" + getContactPhoneNumber()+ "," +
            "totalPrice" + ":" + getTotalPrice()+ "," +
            "creditCardCharged" + ":" + getCreditCardCharged()+ "," +
            "expiryDate" + ":" + getExpiryDate()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "account = "+(getAccount()!=null?Integer.toHexString(System.identityHashCode(getAccount())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "delivery = "+(getDelivery()!=null?Integer.toHexString(System.identityHashCode(getDelivery())):"null")
     + outputString;
  }
}