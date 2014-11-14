/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * It is possible for a dispenser to have
 * one product type 'in front' and another in behind
 */
// line 16 "VendingMachineClassDiagram.ump"
// line 65 "VendingMachineClassDiagram.ump"
public class ProductInDispenser
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProductInDispenser Attributes
  private int numberProductsOfThisTypeLeft;

  //ProductInDispenser Associations
  private Dispenser dispenser;
  private ProductType productType;
  private List<ProductTransaction> productTransactions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProductInDispenser(int aNumberProductsOfThisTypeLeft, Dispenser aDispenser, ProductType aProductType)
  {
    numberProductsOfThisTypeLeft = aNumberProductsOfThisTypeLeft;
    boolean didAddDispenser = setDispenser(aDispenser);
    if (!didAddDispenser)
    {
      throw new RuntimeException("Unable to create productInDispenser due to dispenser");
    }
    boolean didAddProductType = setProductType(aProductType);
    if (!didAddProductType)
    {
      throw new RuntimeException("Unable to create productInDispenser due to productType");
    }
    productTransactions = new ArrayList<ProductTransaction>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumberProductsOfThisTypeLeft(int aNumberProductsOfThisTypeLeft)
  {
    boolean wasSet = false;
    numberProductsOfThisTypeLeft = aNumberProductsOfThisTypeLeft;
    wasSet = true;
    return wasSet;
  }

  public int getNumberProductsOfThisTypeLeft()
  {
    return numberProductsOfThisTypeLeft;
  }

  public Dispenser getDispenser()
  {
    return dispenser;
  }

  public ProductType getProductType()
  {
    return productType;
  }

  public ProductTransaction getProductTransaction(int index)
  {
    ProductTransaction aProductTransaction = productTransactions.get(index);
    return aProductTransaction;
  }

  public List<ProductTransaction> getProductTransactions()
  {
    List<ProductTransaction> newProductTransactions = Collections.unmodifiableList(productTransactions);
    return newProductTransactions;
  }

  public int numberOfProductTransactions()
  {
    int number = productTransactions.size();
    return number;
  }

  public boolean hasProductTransactions()
  {
    boolean has = productTransactions.size() > 0;
    return has;
  }

  public int indexOfProductTransaction(ProductTransaction aProductTransaction)
  {
    int index = productTransactions.indexOf(aProductTransaction);
    return index;
  }

  public boolean setDispenser(Dispenser aDispenser)
  {
    boolean wasSet = false;
    if (aDispenser == null)
    {
      return wasSet;
    }

    Dispenser existingDispenser = dispenser;
    dispenser = aDispenser;
    if (existingDispenser != null && !existingDispenser.equals(aDispenser))
    {
      existingDispenser.removeProductInDispenser(this);
    }
    dispenser.addProductInDispenser(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setProductType(ProductType aProductType)
  {
    boolean wasSet = false;
    if (aProductType == null)
    {
      return wasSet;
    }

    ProductType existingProductType = productType;
    productType = aProductType;
    if (existingProductType != null && !existingProductType.equals(aProductType))
    {
      existingProductType.removeProductInDispenser(this);
    }
    productType.addProductInDispenser(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfProductTransactions()
  {
    return 0;
  }

  public ProductTransaction addProductTransaction()
  {
    return new ProductTransaction(this);
  }

  public boolean addProductTransaction(ProductTransaction aProductTransaction)
  {
    boolean wasAdded = false;
    if (productTransactions.contains(aProductTransaction)) { return false; }
    ProductInDispenser existingProductInDispenser = aProductTransaction.getProductInDispenser();
    boolean isNewProductInDispenser = existingProductInDispenser != null && !this.equals(existingProductInDispenser);
    if (isNewProductInDispenser)
    {
      aProductTransaction.setProductInDispenser(this);
    }
    else
    {
      productTransactions.add(aProductTransaction);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeProductTransaction(ProductTransaction aProductTransaction)
  {
    boolean wasRemoved = false;
    //Unable to remove aProductTransaction, as it must always have a productInDispenser
    if (!this.equals(aProductTransaction.getProductInDispenser()))
    {
      productTransactions.remove(aProductTransaction);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addProductTransactionAt(ProductTransaction aProductTransaction, int index)
  {  
    boolean wasAdded = false;
    if(addProductTransaction(aProductTransaction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfProductTransactions()) { index = numberOfProductTransactions() - 1; }
      productTransactions.remove(aProductTransaction);
      productTransactions.add(index, aProductTransaction);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveProductTransactionAt(ProductTransaction aProductTransaction, int index)
  {
    boolean wasAdded = false;
    if(productTransactions.contains(aProductTransaction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfProductTransactions()) { index = numberOfProductTransactions() - 1; }
      productTransactions.remove(aProductTransaction);
      productTransactions.add(index, aProductTransaction);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addProductTransactionAt(aProductTransaction, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Dispenser placeholderDispenser = dispenser;
    this.dispenser = null;
    placeholderDispenser.removeProductInDispenser(this);
    ProductType placeholderProductType = productType;
    this.productType = null;
    placeholderProductType.removeProductInDispenser(this);
    for(int i=productTransactions.size(); i > 0; i--)
    {
      ProductTransaction aProductTransaction = productTransactions.get(i - 1);
      aProductTransaction.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "numberProductsOfThisTypeLeft" + ":" + getNumberProductsOfThisTypeLeft()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "dispenser = "+(getDispenser()!=null?Integer.toHexString(System.identityHashCode(getDispenser())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "productType = "+(getProductType()!=null?Integer.toHexString(System.identityHashCode(getProductType())):"null")
     + outputString;
  }
}