/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package MFP.core.blue;
import java.util.*;
import MFP.core.black.*;

// line 17 "../../../../ManufactoringPlantController.ump"
// line 155 "../../../../ManufactoringPlantController.ump"
public class Supplier
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Supplier Attributes
  private String name;

  //Supplier Associations
  private List<ProductType> productTypes;
  private List<Product> products;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Supplier(String aName)
  {
    name = aName;
    productTypes = new ArrayList<ProductType>();
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

  public ProductType getProductType(int index)
  {
    ProductType aProductType = productTypes.get(index);
    return aProductType;
  }

  public List<ProductType> getProductTypes()
  {
    List<ProductType> newProductTypes = Collections.unmodifiableList(productTypes);
    return newProductTypes;
  }

  public int numberOfProductTypes()
  {
    int number = productTypes.size();
    return number;
  }

  public boolean hasProductTypes()
  {
    boolean has = productTypes.size() > 0;
    return has;
  }

  public int indexOfProductType(ProductType aProductType)
  {
    int index = productTypes.indexOf(aProductType);
    return index;
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

  public static int minimumNumberOfProductTypes()
  {
    return 0;
  }

  public boolean addProductType(ProductType aProductType)
  {
    boolean wasAdded = false;
    if (productTypes.contains(aProductType)) { return false; }
    productTypes.add(aProductType);
    if (aProductType.indexOfSupplier(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aProductType.addSupplier(this);
      if (!wasAdded)
      {
        productTypes.remove(aProductType);
      }
    }
    return wasAdded;
  }

  public boolean removeProductType(ProductType aProductType)
  {
    boolean wasRemoved = false;
    if (!productTypes.contains(aProductType))
    {
      return wasRemoved;
    }

    int oldIndex = productTypes.indexOf(aProductType);
    productTypes.remove(oldIndex);
    if (aProductType.indexOfSupplier(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aProductType.removeSupplier(this);
      if (!wasRemoved)
      {
        productTypes.add(oldIndex,aProductType);
      }
    }
    return wasRemoved;
  }

  public boolean addProductTypeAt(ProductType aProductType, int index)
  {  
    boolean wasAdded = false;
    if(addProductType(aProductType))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfProductTypes()) { index = numberOfProductTypes() - 1; }
      productTypes.remove(aProductType);
      productTypes.add(index, aProductType);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveProductTypeAt(ProductType aProductType, int index)
  {
    boolean wasAdded = false;
    if(productTypes.contains(aProductType))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfProductTypes()) { index = numberOfProductTypes() - 1; }
      productTypes.remove(aProductType);
      productTypes.add(index, aProductType);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addProductTypeAt(aProductType, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfProducts()
  {
    return 0;
  }

  public boolean addProduct(Product aProduct)
  {
    boolean wasAdded = false;
    if (products.contains(aProduct)) { return false; }
    Supplier existingSupplier = aProduct.getSupplier();
    if (existingSupplier == null)
    {
      aProduct.setSupplier(this);
    }
    else if (!this.equals(existingSupplier))
    {
      existingSupplier.removeProduct(aProduct);
      addProduct(aProduct);
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
    if (products.contains(aProduct))
    {
      products.remove(aProduct);
      aProduct.setSupplier(null);
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
    ArrayList<ProductType> copyOfProductTypes = new ArrayList<ProductType>(productTypes);
    productTypes.clear();
    for(ProductType aProductType : copyOfProductTypes)
    {
      aProductType.removeSupplier(this);
    }
    while( !products.isEmpty() )
    {
      products.get(0).setSupplier(null);
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