/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 35 "MailOrderSystem.ump"
public class ProductCategory
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProductCategory Attributes
  private String name;

  //ProductCategory Associations
  private List<Product> products;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProductCategory(String aName)
  {
    name = aName;
    products = new ArrayList<Product>();
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

  public Product getProduct(int index)
  {
    Product aProduct = products.get(index);
    return aProduct;
  }

  public List<Product> getProducts()
  {
    List<Product> newProducts = Collections.unmodifiableList(products);
    return newProducts;
  }

  public int numberOfProducts()
  {
    int number = products.size();
    return number;
  }

  public boolean hasProducts()
  {
    boolean has = products.size() > 0;
    return has;
  }

  public int indexOfProduct(Product aProduct)
  {
    int index = products.indexOf(aProduct);
    return index;
  }

  public static int minimumNumberOfProducts()
  {
    return 0;
  }

  public Product addProduct(String aOurCode, String aDescription, String aPicture, String aOurListPricePerunit, String aNumberInInventory, String aNumberToKeepInv)
  {
    return new Product(aOurCode, aDescription, aPicture, aOurListPricePerunit, aNumberInInventory, aNumberToKeepInv, this);
  }

  public boolean addProduct(Product aProduct)
  {
    boolean wasAdded = false;
    if (products.contains(aProduct)) { return false; }
    ProductCategory existingProductCategory = aProduct.getProductCategory();
    boolean isNewProductCategory = existingProductCategory != null && !this.equals(existingProductCategory);
    if (isNewProductCategory)
    {
      aProduct.setProductCategory(this);
    }
    else
    {
      products.add(aProduct);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeProduct(Product aProduct)
  {
    boolean wasRemoved = false;
    //Unable to remove aProduct, as it must always have a productCategory
    if (!this.equals(aProduct.getProductCategory()))
    {
      products.remove(aProduct);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addProductAt(Product aProduct, int index)
  {  
    boolean wasAdded = false;
    if(addProduct(aProduct))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfProducts()) { index = numberOfProducts() - 1; }
      products.remove(aProduct);
      products.add(index, aProduct);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveProductAt(Product aProduct, int index)
  {
    boolean wasAdded = false;
    if(products.contains(aProduct))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfProducts()) { index = numberOfProducts() - 1; }
      products.remove(aProduct);
      products.add(index, aProduct);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addProductAt(aProduct, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=products.size(); i > 0; i--)
    {
      Product aProduct = products.get(i - 1);
      aProduct.delete();
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