/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * Positioning
 */
// line 32 "MailOrderSystemClientOrder.ump"
// line 42 "MailOrderSystemClientOrder.ump"
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
  private List<ClientOrderLineItem> clientOrderLineItems;
  private ProductCategory productCategory;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Product(String aOurCode, String aDescription, String aPicture, String aOurListPricePerunit, String aNumberInInventory, String aNumberToKeepInv, ProductCategory aProductCategory)
  {
    ourCode = aOurCode;
    description = aDescription;
    picture = aPicture;
    ourListPricePerunit = aOurListPricePerunit;
    numberInInventory = aNumberInInventory;
    numberToKeepInv = aNumberToKeepInv;
    clientOrderLineItems = new ArrayList<ClientOrderLineItem>();
    boolean didAddProductCategory = setProductCategory(aProductCategory);
    if (!didAddProductCategory)
    {
      throw new RuntimeException("Unable to create product due to productCategory");
    }
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

  public ClientOrderLineItem getClientOrderLineItem(int index)
  {
    ClientOrderLineItem aClientOrderLineItem = clientOrderLineItems.get(index);
    return aClientOrderLineItem;
  }

  public List<ClientOrderLineItem> getClientOrderLineItems()
  {
    List<ClientOrderLineItem> newClientOrderLineItems = Collections.unmodifiableList(clientOrderLineItems);
    return newClientOrderLineItems;
  }

  public int numberOfClientOrderLineItems()
  {
    int number = clientOrderLineItems.size();
    return number;
  }

  public boolean hasClientOrderLineItems()
  {
    boolean has = clientOrderLineItems.size() > 0;
    return has;
  }

  public int indexOfClientOrderLineItem(ClientOrderLineItem aClientOrderLineItem)
  {
    int index = clientOrderLineItems.indexOf(aClientOrderLineItem);
    return index;
  }

  public ProductCategory getProductCategory()
  {
    return productCategory;
  }

  public static int minimumNumberOfClientOrderLineItems()
  {
    return 0;
  }

  public ClientOrderLineItem addClientOrderLineItem(String aNumberOrdered, String aPricePerUnitCharged, OrderFromClient aOrderFromClient)
  {
    return new ClientOrderLineItem(aNumberOrdered, aPricePerUnitCharged, aOrderFromClient, this);
  }

  public boolean addClientOrderLineItem(ClientOrderLineItem aClientOrderLineItem)
  {
    boolean wasAdded = false;
    if (clientOrderLineItems.contains(aClientOrderLineItem)) { return false; }
    Product existingProduct = aClientOrderLineItem.getProduct();
    boolean isNewProduct = existingProduct != null && !this.equals(existingProduct);
    if (isNewProduct)
    {
      aClientOrderLineItem.setProduct(this);
    }
    else
    {
      clientOrderLineItems.add(aClientOrderLineItem);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeClientOrderLineItem(ClientOrderLineItem aClientOrderLineItem)
  {
    boolean wasRemoved = false;
    //Unable to remove aClientOrderLineItem, as it must always have a product
    if (!this.equals(aClientOrderLineItem.getProduct()))
    {
      clientOrderLineItems.remove(aClientOrderLineItem);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addClientOrderLineItemAt(ClientOrderLineItem aClientOrderLineItem, int index)
  {  
    boolean wasAdded = false;
    if(addClientOrderLineItem(aClientOrderLineItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfClientOrderLineItems()) { index = numberOfClientOrderLineItems() - 1; }
      clientOrderLineItems.remove(aClientOrderLineItem);
      clientOrderLineItems.add(index, aClientOrderLineItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveClientOrderLineItemAt(ClientOrderLineItem aClientOrderLineItem, int index)
  {
    boolean wasAdded = false;
    if(clientOrderLineItems.contains(aClientOrderLineItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfClientOrderLineItems()) { index = numberOfClientOrderLineItems() - 1; }
      clientOrderLineItems.remove(aClientOrderLineItem);
      clientOrderLineItems.add(index, aClientOrderLineItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addClientOrderLineItemAt(aClientOrderLineItem, index);
    }
    return wasAdded;
  }

  public boolean setProductCategory(ProductCategory aProductCategory)
  {
    boolean wasSet = false;
    if (aProductCategory == null)
    {
      return wasSet;
    }

    ProductCategory existingProductCategory = productCategory;
    productCategory = aProductCategory;
    if (existingProductCategory != null && !existingProductCategory.equals(aProductCategory))
    {
      existingProductCategory.removeProduct(this);
    }
    productCategory.addProduct(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=clientOrderLineItems.size(); i > 0; i--)
    {
      ClientOrderLineItem aClientOrderLineItem = clientOrderLineItems.get(i - 1);
      aClientOrderLineItem.delete();
    }
    ProductCategory placeholderProductCategory = productCategory;
    this.productCategory = null;
    placeholderProductCategory.removeProduct(this);
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
            "numberToKeepInv" + ":" + getNumberToKeepInv()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "productCategory = "+(getProductCategory()!=null?Integer.toHexString(System.identityHashCode(getProductCategory())):"null")
     + outputString;
  }
}