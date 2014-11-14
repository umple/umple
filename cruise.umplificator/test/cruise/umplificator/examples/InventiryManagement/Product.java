/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * Positioning
 */
// line 15 "InventoryManagement.ump"
// line 48 "InventoryManagement.ump"
public class Product
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Product Attributes
  private String ourCode;
  private String description;
  private String picture;
  private String ourListPricePerunit;
  private String numberInInventory;
  private String numberToKeepInv;

  //Product Associations
  private List<ProductSource> productSources;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Product(String aOurCode, String aDescription, String aPicture, String aOurListPricePerunit, String aNumberInInventory, String aNumberToKeepInv)
  {
    ourCode = aOurCode;
    description = aDescription;
    picture = aPicture;
    ourListPricePerunit = aOurListPricePerunit;
    numberInInventory = aNumberInInventory;
    numberToKeepInv = aNumberToKeepInv;
    productSources = new ArrayList<ProductSource>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setOurCode(String aOurCode)
  {
    boolean wasSet = false;
    ourCode = aOurCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public boolean setPicture(String aPicture)
  {
    boolean wasSet = false;
    picture = aPicture;
    wasSet = true;
    return wasSet;
  }

  public boolean setOurListPricePerunit(String aOurListPricePerunit)
  {
    boolean wasSet = false;
    ourListPricePerunit = aOurListPricePerunit;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumberInInventory(String aNumberInInventory)
  {
    boolean wasSet = false;
    numberInInventory = aNumberInInventory;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumberToKeepInv(String aNumberToKeepInv)
  {
    boolean wasSet = false;
    numberToKeepInv = aNumberToKeepInv;
    wasSet = true;
    return wasSet;
  }

  public String getOurCode()
  {
    return ourCode;
  }

  public String getDescription()
  {
    return description;
  }

  public String getPicture()
  {
    return picture;
  }

  public String getOurListPricePerunit()
  {
    return ourListPricePerunit;
  }

  public String getNumberInInventory()
  {
    return numberInInventory;
  }

  public String getNumberToKeepInv()
  {
    return numberToKeepInv;
  }

  public ProductSource getProductSource(int index)
  {
    ProductSource aProductSource = productSources.get(index);
    return aProductSource;
  }

  public List<ProductSource> getProductSources()
  {
    List<ProductSource> newProductSources = Collections.unmodifiableList(productSources);
    return newProductSources;
  }

  public int numberOfProductSources()
  {
    int number = productSources.size();
    return number;
  }

  public boolean hasProductSources()
  {
    boolean has = productSources.size() > 0;
    return has;
  }

  public int indexOfProductSource(ProductSource aProductSource)
  {
    int index = productSources.indexOf(aProductSource);
    return index;
  }

  public static int minimumNumberOfProductSources()
  {
    return 0;
  }

  public ProductSource addProductSource(String aAdvertisedCostPerUnit, Supplier aSupplier)
  {
    return new ProductSource(aAdvertisedCostPerUnit, this, aSupplier);
  }

  public boolean addProductSource(ProductSource aProductSource)
  {
    boolean wasAdded = false;
    if (productSources.contains(aProductSource)) { return false; }
    Product existingProduct = aProductSource.getProduct();
    boolean isNewProduct = existingProduct != null && !this.equals(existingProduct);
    if (isNewProduct)
    {
      aProductSource.setProduct(this);
    }
    else
    {
      productSources.add(aProductSource);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeProductSource(ProductSource aProductSource)
  {
    boolean wasRemoved = false;
    //Unable to remove aProductSource, as it must always have a product
    if (!this.equals(aProductSource.getProduct()))
    {
      productSources.remove(aProductSource);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addProductSourceAt(ProductSource aProductSource, int index)
  {  
    boolean wasAdded = false;
    if(addProductSource(aProductSource))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfProductSources()) { index = numberOfProductSources() - 1; }
      productSources.remove(aProductSource);
      productSources.add(index, aProductSource);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveProductSourceAt(ProductSource aProductSource, int index)
  {
    boolean wasAdded = false;
    if(productSources.contains(aProductSource))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfProductSources()) { index = numberOfProductSources() - 1; }
      productSources.remove(aProductSource);
      productSources.add(index, aProductSource);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addProductSourceAt(aProductSource, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=productSources.size(); i > 0; i--)
    {
      ProductSource aProductSource = productSources.get(i - 1);
      aProductSource.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "ourCode" + ":" + getOurCode()+ "," +
            "description" + ":" + getDescription()+ "," +
            "picture" + ":" + getPicture()+ "," +
            "ourListPricePerunit" + ":" + getOurListPricePerunit()+ "," +
            "numberInInventory" + ":" + getNumberInInventory()+ "," +
            "numberToKeepInv" + ":" + getNumberToKeepInv()+ "]"
     + outputString;
  }
}