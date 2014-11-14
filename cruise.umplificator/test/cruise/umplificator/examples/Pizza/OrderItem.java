/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 26 "Pizza.ump"
// line 84 "Pizza.ump"
public class OrderItem
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //OrderItem Attributes
  private int number;
  private float totalPrice;

  //OrderItem Associations
  private Order order;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public OrderItem(int aNumber, float aTotalPrice, Order aOrder)
  {
    number = aNumber;
    totalPrice = aTotalPrice;
    boolean didAddOrder = setOrder(aOrder);
    if (!didAddOrder)
    {
      throw new RuntimeException("Unable to create orderItem due to order");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumber(int aNumber)
  {
    boolean wasSet = false;
    number = aNumber;
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

  public int getNumber()
  {
    return number;
  }

  public float getTotalPrice()
  {
    return totalPrice;
  }

  public Order getOrder()
  {
    return order;
  }

  public boolean setOrder(Order aOrder)
  {
    boolean wasSet = false;
    if (aOrder == null)
    {
      return wasSet;
    }

    Order existingOrder = order;
    order = aOrder;
    if (existingOrder != null && !existingOrder.equals(aOrder))
    {
      existingOrder.removeOrderItem(this);
    }
    order.addOrderItem(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Order placeholderOrder = order;
    this.order = null;
    placeholderOrder.removeOrderItem(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "number" + ":" + getNumber()+ "," +
            "totalPrice" + ":" + getTotalPrice()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "order = "+(getOrder()!=null?Integer.toHexString(System.identityHashCode(getOrder())):"null")
     + outputString;
  }
}