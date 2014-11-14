/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 9 "VendingMachineClassDiagram.ump"
// line 60 "VendingMachineClassDiagram.ump"
public class Dispenser
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Dispenser Attributes
  private Character row;
  private Character column;

  //Dispenser Associations
  private VendingMachine vendingMachine;
  private List<ProductInDispenser> productInDispensers;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Dispenser(Character aRow, Character aColumn, VendingMachine aVendingMachine)
  {
    row = aRow;
    column = aColumn;
    boolean didAddVendingMachine = setVendingMachine(aVendingMachine);
    if (!didAddVendingMachine)
    {
      throw new RuntimeException("Unable to create slot due to vendingMachine");
    }
    productInDispensers = new ArrayList<ProductInDispenser>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRow(Character aRow)
  {
    boolean wasSet = false;
    row = aRow;
    wasSet = true;
    return wasSet;
  }

  public boolean setColumn(Character aColumn)
  {
    boolean wasSet = false;
    column = aColumn;
    wasSet = true;
    return wasSet;
  }

  public Character getRow()
  {
    return row;
  }

  public Character getColumn()
  {
    return column;
  }

  public VendingMachine getVendingMachine()
  {
    return vendingMachine;
  }

  public ProductInDispenser getProductInDispenser(int index)
  {
    ProductInDispenser aProductInDispenser = productInDispensers.get(index);
    return aProductInDispenser;
  }

  public List<ProductInDispenser> getProductInDispensers()
  {
    List<ProductInDispenser> newProductInDispensers = Collections.unmodifiableList(productInDispensers);
    return newProductInDispensers;
  }

  public int numberOfProductInDispensers()
  {
    int number = productInDispensers.size();
    return number;
  }

  public boolean hasProductInDispensers()
  {
    boolean has = productInDispensers.size() > 0;
    return has;
  }

  public int indexOfProductInDispenser(ProductInDispenser aProductInDispenser)
  {
    int index = productInDispensers.indexOf(aProductInDispenser);
    return index;
  }

  public boolean setVendingMachine(VendingMachine aVendingMachine)
  {
    boolean wasSet = false;
    if (aVendingMachine == null)
    {
      return wasSet;
    }

    VendingMachine existingVendingMachine = vendingMachine;
    vendingMachine = aVendingMachine;
    if (existingVendingMachine != null && !existingVendingMachine.equals(aVendingMachine))
    {
      existingVendingMachine.removeSlot(this);
    }
    vendingMachine.addSlot(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfProductInDispensers()
  {
    return 0;
  }

  public ProductInDispenser addProductInDispenser(int aNumberProductsOfThisTypeLeft, ProductType aProductType)
  {
    return new ProductInDispenser(aNumberProductsOfThisTypeLeft, this, aProductType);
  }

  public boolean addProductInDispenser(ProductInDispenser aProductInDispenser)
  {
    boolean wasAdded = false;
    if (productInDispensers.contains(aProductInDispenser)) { return false; }
    Dispenser existingDispenser = aProductInDispenser.getDispenser();
    boolean isNewDispenser = existingDispenser != null && !this.equals(existingDispenser);
    if (isNewDispenser)
    {
      aProductInDispenser.setDispenser(this);
    }
    else
    {
      productInDispensers.add(aProductInDispenser);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeProductInDispenser(ProductInDispenser aProductInDispenser)
  {
    boolean wasRemoved = false;
    //Unable to remove aProductInDispenser, as it must always have a dispenser
    if (!this.equals(aProductInDispenser.getDispenser()))
    {
      productInDispensers.remove(aProductInDispenser);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addProductInDispenserAt(ProductInDispenser aProductInDispenser, int index)
  {  
    boolean wasAdded = false;
    if(addProductInDispenser(aProductInDispenser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfProductInDispensers()) { index = numberOfProductInDispensers() - 1; }
      productInDispensers.remove(aProductInDispenser);
      productInDispensers.add(index, aProductInDispenser);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveProductInDispenserAt(ProductInDispenser aProductInDispenser, int index)
  {
    boolean wasAdded = false;
    if(productInDispensers.contains(aProductInDispenser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfProductInDispensers()) { index = numberOfProductInDispensers() - 1; }
      productInDispensers.remove(aProductInDispenser);
      productInDispensers.add(index, aProductInDispenser);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addProductInDispenserAt(aProductInDispenser, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    VendingMachine placeholderVendingMachine = vendingMachine;
    this.vendingMachine = null;
    placeholderVendingMachine.removeSlot(this);
    for(int i=productInDispensers.size(); i > 0; i--)
    {
      ProductInDispenser aProductInDispenser = productInDispensers.get(i - 1);
      aProductInDispenser.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "row" + ":" + getRow()+ "," +
            "column" + ":" + getColumn()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "vendingMachine = "+(getVendingMachine()!=null?Integer.toHexString(System.identityHashCode(getVendingMachine())):"null")
     + outputString;
  }
}