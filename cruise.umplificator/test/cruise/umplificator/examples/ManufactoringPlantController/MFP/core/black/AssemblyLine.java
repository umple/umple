/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package MFP.core.black;
import java.util.*;

// line 51 "../../../../ManufactoringPlantController.ump"
// line 97 "../../../../ManufactoringPlantController.ump"
public class AssemblyLine
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AssemblyLine Attributes
  private String number;

  //AssemblyLine Associations
  private List<ProductRun> productRuns;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AssemblyLine(String aNumber)
  {
    number = aNumber;
    productRuns = new ArrayList<ProductRun>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumber(String aNumber)
  {
    boolean wasSet = false;
    number = aNumber;
    wasSet = true;
    return wasSet;
  }

  public String getNumber()
  {
    return number;
  }

  public ProductRun getProductRun(int index)
  {
    ProductRun aProductRun = productRuns.get(index);
    return aProductRun;
  }

  public List<ProductRun> getProductRuns()
  {
    List<ProductRun> newProductRuns = Collections.unmodifiableList(productRuns);
    return newProductRuns;
  }

  public int numberOfProductRuns()
  {
    int number = productRuns.size();
    return number;
  }

  public boolean hasProductRuns()
  {
    boolean has = productRuns.size() > 0;
    return has;
  }

  public int indexOfProductRun(ProductRun aProductRun)
  {
    int index = productRuns.indexOf(aProductRun);
    return index;
  }

  public static int minimumNumberOfProductRuns()
  {
    return 0;
  }

  public ProductRun addProductRun(String aTimePeriod, String aNumUnits, ProductType aProductType)
  {
    return new ProductRun(aTimePeriod, aNumUnits, aProductType, this);
  }

  public boolean addProductRun(ProductRun aProductRun)
  {
    boolean wasAdded = false;
    if (productRuns.contains(aProductRun)) { return false; }
    AssemblyLine existingAssemblyLine = aProductRun.getAssemblyLine();
    boolean isNewAssemblyLine = existingAssemblyLine != null && !this.equals(existingAssemblyLine);
    if (isNewAssemblyLine)
    {
      aProductRun.setAssemblyLine(this);
    }
    else
    {
      productRuns.add(aProductRun);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeProductRun(ProductRun aProductRun)
  {
    boolean wasRemoved = false;
    //Unable to remove aProductRun, as it must always have a assemblyLine
    if (!this.equals(aProductRun.getAssemblyLine()))
    {
      productRuns.remove(aProductRun);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addProductRunAt(ProductRun aProductRun, int index)
  {  
    boolean wasAdded = false;
    if(addProductRun(aProductRun))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfProductRuns()) { index = numberOfProductRuns() - 1; }
      productRuns.remove(aProductRun);
      productRuns.add(index, aProductRun);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveProductRunAt(ProductRun aProductRun, int index)
  {
    boolean wasAdded = false;
    if(productRuns.contains(aProductRun))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfProductRuns()) { index = numberOfProductRuns() - 1; }
      productRuns.remove(aProductRun);
      productRuns.add(index, aProductRun);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addProductRunAt(aProductRun, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=productRuns.size(); i > 0; i--)
    {
      ProductRun aProductRun = productRuns.get(i - 1);
      aProductRun.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "number" + ":" + getNumber()+ "]"
     + outputString;
  }
}