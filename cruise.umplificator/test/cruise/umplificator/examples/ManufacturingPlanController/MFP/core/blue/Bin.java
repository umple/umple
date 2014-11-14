/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package MFP.core.blue;
import MFP.core.black.*;

// line 15 "../../../../ManufacturingPlantController.ump"
// line 163 "../../../../ManufacturingPlantController.ump"
public class Bin
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Bin Attributes
  private String number;

  //Bin Associations
  private ProductType productType;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Bin(String aNumber, ProductType aProductType)
  {
    number = aNumber;
    boolean didAddProductType = setProductType(aProductType);
    if (!didAddProductType)
    {
      throw new RuntimeException("Unable to create keptIn due to productType");
    }
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

  public ProductType getProductType()
  {
    return productType;
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
      existingProductType.removeKeptIn(this);
    }
    productType.addKeptIn(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ProductType placeholderProductType = productType;
    this.productType = null;
    placeholderProductType.removeKeptIn(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "number" + ":" + getNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "productType = "+(getProductType()!=null?Integer.toHexString(System.identityHashCode(getProductType())):"null")
     + outputString;
  }
}