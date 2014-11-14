/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 22 "VendingMachineClassDiagram.ump"
// line 72 "VendingMachineClassDiagram.ump"
public class ProductType
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProductType Attributes
  private int pricePerUnit;

  //ProductType Associations
  private List<ProductInDispenser> productInDispensers;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProductType(int aPricePerUnit)
  {
    pricePerUnit = aPricePerUnit;
    productInDispensers = new ArrayList<ProductInDispenser>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPricePerUnit(int aPricePerUnit)
  {
    boolean wasSet = false;
    pricePerUnit = aPricePerUnit;
    wasSet = true;
    return wasSet;
  }

  /**
   * cents
   */
  public int getPricePerUnit()
  {
    return pricePerUnit;
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

  public static int minimumNumberOfProductInDispensers()
  {
    return 0;
  }

  public ProductInDispenser addProductInDispenser(int aNumberProductsOfThisTypeLeft, Dispenser aDispenser)
  {
    return new ProductInDispenser(aNumberProductsOfThisTypeLeft, aDispenser, this);
  }

  public boolean addProductInDispenser(ProductInDispenser aProductInDispenser)
  {
    boolean wasAdded = false;
    if (productInDispensers.contains(aProductInDispenser)) { return false; }
    ProductType existingProductType = aProductInDispenser.getProductType();
    boolean isNewProductType = existingProductType != null && !this.equals(existingProductType);
    if (isNewProductType)
    {
      aProductInDispenser.setProductType(this);
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
    //Unable to remove aProductInDispenser, as it must always have a productType
    if (!this.equals(aProductInDispenser.getProductType()))
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
            "pricePerUnit" + ":" + getPricePerUnit()+ "]"
     + outputString;
  }
}