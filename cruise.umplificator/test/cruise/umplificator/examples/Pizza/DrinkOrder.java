/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 50 "Pizza.ump"
// line 107 "Pizza.ump"
public class DrinkOrder extends OrderItem
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DrinkOrder Attributes
  private String drinkSize;
  private String size;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DrinkOrder(int aNumber, float aTotalPrice, Order aOrder, String aDrinkSize, String aSize)
  {
    super(aNumber, aTotalPrice, aOrder);
    drinkSize = aDrinkSize;
    size = aSize;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDrinkSize(String aDrinkSize)
  {
    boolean wasSet = false;
    drinkSize = aDrinkSize;
    wasSet = true;
    return wasSet;
  }

  public boolean setSize(String aSize)
  {
    boolean wasSet = false;
    size = aSize;
    wasSet = true;
    return wasSet;
  }

  public String getDrinkSize()
  {
    return drinkSize;
  }

  public String getSize()
  {
    return size;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "drinkSize" + ":" + getDrinkSize()+ "," +
            "size" + ":" + getSize()+ "]"
     + outputString;
  }
}