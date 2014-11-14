/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package MFP.core.blue;
import java.util.*;
import MFP.core.black.*;

// line 23 "../../../../ManufactoringPlantController.ump"
// line 136 "../../../../ManufactoringPlantController.ump"
public class Product
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Product Attributes
  private String serialNumber;

  //Product Associations
  private List<Product> packagedWith;
  private Supplier supplier;
  private Product product;
  private ProductType productType;
  private ProductRun productRun;
  private OrderLineItem orderLineItem;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Product(String aSerialNumber, ProductType aProductType, OrderLineItem aOrderLineItem)
  {
    serialNumber = aSerialNumber;
    packagedWith = new ArrayList<Product>();
    boolean didAddProductType = setProductType(aProductType);
    if (!didAddProductType)
    {
      throw new RuntimeException("Unable to create product due to productType");
    }
    boolean didAddOrderLineItem = setOrderLineItem(aOrderLineItem);
    if (!didAddOrderLineItem)
    {
      throw new RuntimeException("Unable to create product due to orderLineItem");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSerialNumber(String aSerialNumber)
  {
    boolean wasSet = false;
    serialNumber = aSerialNumber;
    wasSet = true;
    return wasSet;
  }

  public String getSerialNumber()
  {
    return serialNumber;
  }

  public Product getPackagedWith(int index)
  {
    Product aPackagedWith = packagedWith.get(index);
    return aPackagedWith;
  }

  public List<Product> getPackagedWith()
  {
    List<Product> newPackagedWith = Collections.unmodifiableList(packagedWith);
    return newPackagedWith;
  }

  public int numberOfPackagedWith()
  {
    int number = packagedWith.size();
    return number;
  }

  public boolean hasPackagedWith()
  {
    boolean has = packagedWith.size() > 0;
    return has;
  }

  public int indexOfPackagedWith(Product aPackagedWith)
  {
    int index = packagedWith.indexOf(aPackagedWith);
    return index;
  }

  public Supplier getSupplier()
  {
    return supplier;
  }

  public boolean hasSupplier()
  {
    boolean has = supplier != null;
    return has;
  }

  public Product getProduct()
  {
    return product;
  }

  public boolean hasProduct()
  {
    boolean has = product != null;
    return has;
  }

  public ProductType getProductType()
  {
    return productType;
  }

  public ProductRun getProductRun()
  {
    return productRun;
  }

  public boolean hasProductRun()
  {
    boolean has = productRun != null;
    return has;
  }

  public OrderLineItem getOrderLineItem()
  {
    return orderLineItem;
  }

  public static int minimumNumberOfPackagedWith()
  {
    return 0;
  }

  public boolean addPackagedWith(Product aPackagedWith)
  {
    boolean wasAdded = false;
    if (packagedWith.contains(aPackagedWith)) { return false; }
    Product existingProduct = aPackagedWith.getProduct();
    if (existingProduct == null)
    {
      aPackagedWith.setProduct(this);
    }
    else if (!this.equals(existingProduct))
    {
      existingProduct.removePackagedWith(aPackagedWith);
      addPackagedWith(aPackagedWith);
    }
    else
    {
      packagedWith.add(aPackagedWith);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePackagedWith(Product aPackagedWith)
  {
    boolean wasRemoved = false;
    if (packagedWith.contains(aPackagedWith))
    {
      packagedWith.remove(aPackagedWith);
      aPackagedWith.setProduct(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addPackagedWithAt(Product aPackagedWith, int index)
  {  
    boolean wasAdded = false;
    if(addPackagedWith(aPackagedWith))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPackagedWith()) { index = numberOfPackagedWith() - 1; }
      packagedWith.remove(aPackagedWith);
      packagedWith.add(index, aPackagedWith);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePackagedWithAt(Product aPackagedWith, int index)
  {
    boolean wasAdded = false;
    if(packagedWith.contains(aPackagedWith))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPackagedWith()) { index = numberOfPackagedWith() - 1; }
      packagedWith.remove(aPackagedWith);
      packagedWith.add(index, aPackagedWith);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPackagedWithAt(aPackagedWith, index);
    }
    return wasAdded;
  }

  public boolean setSupplier(Supplier aSupplier)
  {
    boolean wasSet = false;
    Supplier existingSupplier = supplier;
    supplier = aSupplier;
    if (existingSupplier != null && !existingSupplier.equals(aSupplier))
    {
      existingSupplier.removeProduct(this);
    }
    if (aSupplier != null)
    {
      aSupplier.addProduct(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setProduct(Product aProduct)
  {
    boolean wasSet = false;
    Product existingProduct = product;
    product = aProduct;
    if (existingProduct != null && !existingProduct.equals(aProduct))
    {
      existingProduct.removePackagedWith(this);
    }
    if (aProduct != null)
    {
      aProduct.addPackagedWith(this);
    }
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
      existingProductType.removeProduct(this);
    }
    productType.addProduct(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setProductRun(ProductRun aProductRun)
  {
    boolean wasSet = false;
    ProductRun existingProductRun = productRun;
    productRun = aProductRun;
    if (existingProductRun != null && !existingProductRun.equals(aProductRun))
    {
      existingProductRun.removeProduct(this);
    }
    if (aProductRun != null)
    {
      aProductRun.addProduct(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setOrderLineItem(OrderLineItem aOrderLineItem)
  {
    boolean wasSet = false;
    if (aOrderLineItem == null)
    {
      return wasSet;
    }

    OrderLineItem existingOrderLineItem = orderLineItem;
    orderLineItem = aOrderLineItem;
    if (existingOrderLineItem != null && !existingOrderLineItem.equals(aOrderLineItem))
    {
      existingOrderLineItem.removeProduct(this);
    }
    orderLineItem.addProduct(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    while( !packagedWith.isEmpty() )
    {
      packagedWith.get(0).setProduct(null);
    }
    if (supplier != null)
    {
      Supplier placeholderSupplier = supplier;
      this.supplier = null;
      placeholderSupplier.removeProduct(this);
    }
    if (product != null)
    {
      Product placeholderProduct = product;
      this.product = null;
      placeholderProduct.removePackagedWith(this);
    }
    ProductType placeholderProductType = productType;
    this.productType = null;
    placeholderProductType.removeProduct(this);
    if (productRun != null)
    {
      ProductRun placeholderProductRun = productRun;
      this.productRun = null;
      placeholderProductRun.removeProduct(this);
    }
    OrderLineItem placeholderOrderLineItem = orderLineItem;
    this.orderLineItem = null;
    placeholderOrderLineItem.removeProduct(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "serialNumber" + ":" + getSerialNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "supplier = "+(getSupplier()!=null?Integer.toHexString(System.identityHashCode(getSupplier())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "productType = "+(getProductType()!=null?Integer.toHexString(System.identityHashCode(getProductType())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "productRun = "+(getProductRun()!=null?Integer.toHexString(System.identityHashCode(getProductRun())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "orderLineItem = "+(getOrderLineItem()!=null?Integer.toHexString(System.identityHashCode(getOrderLineItem())):"null")
     + outputString;
  }
}