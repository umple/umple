/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package MFP.core.black;
import java.util.*;
import MFP.core.blue.*;

/**
 * Associations classes taken out and substituted with basic classes and associations on May 26, 2008
 * because of lack of implementations for associations classes in current Umple 2.0
 * association ProductRun{
 * timePeriod;
 * numUnits;
 * ProductType;
 * AssemblyLine;
 * }
 * association BillOfMaterialsLineItem{ 
 * numberRequired; 
 * reflexive;
 * ProductType;
 * ProductType consistsOf;
 * }
 * association RobotAllocation {
 * timePeriod;
 * AssemblyStep;
 * Robot;
 * }
 */
// line 53 "../../../../ManufactoringPlantController.ump"
// line 88 "../../../../ManufactoringPlantController.ump"
public class ProductRun
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProductRun Attributes
  private String timePeriod;
  private String numUnits;

  //ProductRun Associations
  private ProductType productType;
  private AssemblyLine assemblyLine;
  private List<Product> products;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProductRun(String aTimePeriod, String aNumUnits, ProductType aProductType, AssemblyLine aAssemblyLine)
  {
    timePeriod = aTimePeriod;
    numUnits = aNumUnits;
    boolean didAddProductType = setProductType(aProductType);
    if (!didAddProductType)
    {
      throw new RuntimeException("Unable to create productRun due to productType");
    }
    boolean didAddAssemblyLine = setAssemblyLine(aAssemblyLine);
    if (!didAddAssemblyLine)
    {
      throw new RuntimeException("Unable to create productRun due to assemblyLine");
    }
    products = new ArrayList<Product>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTimePeriod(String aTimePeriod)
  {
    boolean wasSet = false;
    timePeriod = aTimePeriod;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumUnits(String aNumUnits)
  {
    boolean wasSet = false;
    numUnits = aNumUnits;
    wasSet = true;
    return wasSet;
  }

  public String getTimePeriod()
  {
    return timePeriod;
  }

  public String getNumUnits()
  {
    return numUnits;
  }

  public ProductType getProductType()
  {
    return productType;
  }

  public AssemblyLine getAssemblyLine()
  {
    return assemblyLine;
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
      existingProductType.removeProductRun(this);
    }
    productType.addProductRun(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setAssemblyLine(AssemblyLine aAssemblyLine)
  {
    boolean wasSet = false;
    if (aAssemblyLine == null)
    {
      return wasSet;
    }

    AssemblyLine existingAssemblyLine = assemblyLine;
    assemblyLine = aAssemblyLine;
    if (existingAssemblyLine != null && !existingAssemblyLine.equals(aAssemblyLine))
    {
      existingAssemblyLine.removeProductRun(this);
    }
    assemblyLine.addProductRun(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfProducts()
  {
    return 0;
  }

  public boolean addProduct(Product aProduct)
  {
    boolean wasAdded = false;
    if (products.contains(aProduct)) { return false; }
    ProductRun existingProductRun = aProduct.getProductRun();
    if (existingProductRun == null)
    {
      aProduct.setProductRun(this);
    }
    else if (!this.equals(existingProductRun))
    {
      existingProductRun.removeProduct(aProduct);
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
      aProduct.setProductRun(null);
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
    ProductType placeholderProductType = productType;
    this.productType = null;
    placeholderProductType.removeProductRun(this);
    AssemblyLine placeholderAssemblyLine = assemblyLine;
    this.assemblyLine = null;
    placeholderAssemblyLine.removeProductRun(this);
    while( !products.isEmpty() )
    {
      products.get(0).setProductRun(null);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "timePeriod" + ":" + getTimePeriod()+ "," +
            "numUnits" + ":" + getNumUnits()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "productType = "+(getProductType()!=null?Integer.toHexString(System.identityHashCode(getProductType())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "assemblyLine = "+(getAssemblyLine()!=null?Integer.toHexString(System.identityHashCode(getAssemblyLine())):"null")
     + outputString;
  }
}