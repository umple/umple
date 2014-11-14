/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 32 "Pizza.ump"
// line 89 "Pizza.ump"
public class PizzaOrder extends OrderItem
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PizzaOrder Attributes
  private String kind;

  //PizzaOrder Associations
  private List<ToppingType> toppings;
  private StandardPizzaSize standardPizzaSize;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PizzaOrder(int aNumber, float aTotalPrice, Order aOrder, String aKind, StandardPizzaSize aStandardPizzaSize)
  {
    super(aNumber, aTotalPrice, aOrder);
    kind = aKind;
    toppings = new ArrayList<ToppingType>();
    if (!setStandardPizzaSize(aStandardPizzaSize))
    {
      throw new RuntimeException("Unable to create PizzaOrder due to aStandardPizzaSize");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setKind(String aKind)
  {
    boolean wasSet = false;
    kind = aKind;
    wasSet = true;
    return wasSet;
  }

  public String getKind()
  {
    return kind;
  }

  public ToppingType getTopping(int index)
  {
    ToppingType aTopping = toppings.get(index);
    return aTopping;
  }

  public List<ToppingType> getToppings()
  {
    List<ToppingType> newToppings = Collections.unmodifiableList(toppings);
    return newToppings;
  }

  public int numberOfToppings()
  {
    int number = toppings.size();
    return number;
  }

  public boolean hasToppings()
  {
    boolean has = toppings.size() > 0;
    return has;
  }

  public int indexOfTopping(ToppingType aTopping)
  {
    int index = toppings.indexOf(aTopping);
    return index;
  }

  public StandardPizzaSize getStandardPizzaSize()
  {
    return standardPizzaSize;
  }

  public static int minimumNumberOfToppings()
  {
    return 0;
  }

  public boolean addTopping(ToppingType aTopping)
  {
    boolean wasAdded = false;
    if (toppings.contains(aTopping)) { return false; }
    toppings.add(aTopping);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTopping(ToppingType aTopping)
  {
    boolean wasRemoved = false;
    if (toppings.contains(aTopping))
    {
      toppings.remove(aTopping);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addToppingAt(ToppingType aTopping, int index)
  {  
    boolean wasAdded = false;
    if(addTopping(aTopping))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfToppings()) { index = numberOfToppings() - 1; }
      toppings.remove(aTopping);
      toppings.add(index, aTopping);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveToppingAt(ToppingType aTopping, int index)
  {
    boolean wasAdded = false;
    if(toppings.contains(aTopping))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfToppings()) { index = numberOfToppings() - 1; }
      toppings.remove(aTopping);
      toppings.add(index, aTopping);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addToppingAt(aTopping, index);
    }
    return wasAdded;
  }

  public boolean setStandardPizzaSize(StandardPizzaSize aNewStandardPizzaSize)
  {
    boolean wasSet = false;
    if (aNewStandardPizzaSize != null)
    {
      standardPizzaSize = aNewStandardPizzaSize;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    toppings.clear();
    standardPizzaSize = null;
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "kind" + ":" + getKind()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "standardPizzaSize = "+(getStandardPizzaSize()!=null?Integer.toHexString(System.identityHashCode(getStandardPizzaSize())):"null")
     + outputString;
  }
}