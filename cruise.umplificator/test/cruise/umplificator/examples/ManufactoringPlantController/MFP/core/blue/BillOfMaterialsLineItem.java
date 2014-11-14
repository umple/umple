/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package MFP.core.blue;
import java.util.*;
import MFP.core.black.*;
import MFP.core.red.*;

// line 9 "../../../../ManufactoringPlantController.ump"
// line 127 "../../../../ManufactoringPlantController.ump"
public class BillOfMaterialsLineItem
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //BillOfMaterialsLineItem Attributes
  private String numberRequired;

  //BillOfMaterialsLineItem Associations
  private List<BillOfMaterialsLineItem> bill;
  private ProductType productType;
  private ProductType consistsOf;
  private BillOfMaterialsLineItem billOfMaterialsLineItem;
  private AssemblyStep assemblyStep;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public BillOfMaterialsLineItem(String aNumberRequired, ProductType aProductType, ProductType aConsistsOf, AssemblyStep aAssemblyStep)
  {
    numberRequired = aNumberRequired;
    bill = new ArrayList<BillOfMaterialsLineItem>();
    boolean didAddProductType = setProductType(aProductType);
    if (!didAddProductType)
    {
      throw new RuntimeException("Unable to create bill due to productType");
    }
    boolean didAddConsistsOf = setConsistsOf(aConsistsOf);
    if (!didAddConsistsOf)
    {
      throw new RuntimeException("Unable to create billOfMaterialsLineItem due to consistsOf");
    }
    boolean didAddAssemblyStep = setAssemblyStep(aAssemblyStep);
    if (!didAddAssemblyStep)
    {
      throw new RuntimeException("Unable to create billOfMaterialsLineItem due to assemblyStep");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumberRequired(String aNumberRequired)
  {
    boolean wasSet = false;
    numberRequired = aNumberRequired;
    wasSet = true;
    return wasSet;
  }

  public String getNumberRequired()
  {
    return numberRequired;
  }

  public BillOfMaterialsLineItem getBill(int index)
  {
    BillOfMaterialsLineItem aBill = bill.get(index);
    return aBill;
  }

  public List<BillOfMaterialsLineItem> getBill()
  {
    List<BillOfMaterialsLineItem> newBill = Collections.unmodifiableList(bill);
    return newBill;
  }

  public int numberOfBill()
  {
    int number = bill.size();
    return number;
  }

  public boolean hasBill()
  {
    boolean has = bill.size() > 0;
    return has;
  }

  public int indexOfBill(BillOfMaterialsLineItem aBill)
  {
    int index = bill.indexOf(aBill);
    return index;
  }

  public ProductType getProductType()
  {
    return productType;
  }

  public ProductType getConsistsOf()
  {
    return consistsOf;
  }

  public BillOfMaterialsLineItem getBillOfMaterialsLineItem()
  {
    return billOfMaterialsLineItem;
  }

  public boolean hasBillOfMaterialsLineItem()
  {
    boolean has = billOfMaterialsLineItem != null;
    return has;
  }

  public AssemblyStep getAssemblyStep()
  {
    return assemblyStep;
  }

  public static int minimumNumberOfBill()
  {
    return 0;
  }

  public boolean addBill(BillOfMaterialsLineItem aBill)
  {
    boolean wasAdded = false;
    if (bill.contains(aBill)) { return false; }
    BillOfMaterialsLineItem existingBillOfMaterialsLineItem = aBill.getBillOfMaterialsLineItem();
    if (existingBillOfMaterialsLineItem == null)
    {
      aBill.setBillOfMaterialsLineItem(this);
    }
    else if (!this.equals(existingBillOfMaterialsLineItem))
    {
      existingBillOfMaterialsLineItem.removeBill(aBill);
      addBill(aBill);
    }
    else
    {
      bill.add(aBill);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeBill(BillOfMaterialsLineItem aBill)
  {
    boolean wasRemoved = false;
    if (bill.contains(aBill))
    {
      bill.remove(aBill);
      aBill.setBillOfMaterialsLineItem(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addBillAt(BillOfMaterialsLineItem aBill, int index)
  {  
    boolean wasAdded = false;
    if(addBill(aBill))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBill()) { index = numberOfBill() - 1; }
      bill.remove(aBill);
      bill.add(index, aBill);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBillAt(BillOfMaterialsLineItem aBill, int index)
  {
    boolean wasAdded = false;
    if(bill.contains(aBill))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBill()) { index = numberOfBill() - 1; }
      bill.remove(aBill);
      bill.add(index, aBill);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBillAt(aBill, index);
    }
    return wasAdded;
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
      existingProductType.removeBill(this);
    }
    productType.addBill(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setConsistsOf(ProductType aConsistsOf)
  {
    boolean wasSet = false;
    if (aConsistsOf == null)
    {
      return wasSet;
    }

    ProductType existingConsistsOf = consistsOf;
    consistsOf = aConsistsOf;
    if (existingConsistsOf != null && !existingConsistsOf.equals(aConsistsOf))
    {
      existingConsistsOf.removeBillOfMaterialsLineItem(this);
    }
    consistsOf.addBillOfMaterialsLineItem(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setBillOfMaterialsLineItem(BillOfMaterialsLineItem aBillOfMaterialsLineItem)
  {
    boolean wasSet = false;
    BillOfMaterialsLineItem existingBillOfMaterialsLineItem = billOfMaterialsLineItem;
    billOfMaterialsLineItem = aBillOfMaterialsLineItem;
    if (existingBillOfMaterialsLineItem != null && !existingBillOfMaterialsLineItem.equals(aBillOfMaterialsLineItem))
    {
      existingBillOfMaterialsLineItem.removeBill(this);
    }
    if (aBillOfMaterialsLineItem != null)
    {
      aBillOfMaterialsLineItem.addBill(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setAssemblyStep(AssemblyStep aAssemblyStep)
  {
    boolean wasSet = false;
    if (aAssemblyStep == null)
    {
      return wasSet;
    }

    AssemblyStep existingAssemblyStep = assemblyStep;
    assemblyStep = aAssemblyStep;
    if (existingAssemblyStep != null && !existingAssemblyStep.equals(aAssemblyStep))
    {
      existingAssemblyStep.removeBillOfMaterialsLineItem(this);
    }
    assemblyStep.addBillOfMaterialsLineItem(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    while( !bill.isEmpty() )
    {
      bill.get(0).setBillOfMaterialsLineItem(null);
    }
    ProductType placeholderProductType = productType;
    this.productType = null;
    placeholderProductType.removeBill(this);
    ProductType placeholderConsistsOf = consistsOf;
    this.consistsOf = null;
    placeholderConsistsOf.removeBillOfMaterialsLineItem(this);
    if (billOfMaterialsLineItem != null)
    {
      BillOfMaterialsLineItem placeholderBillOfMaterialsLineItem = billOfMaterialsLineItem;
      this.billOfMaterialsLineItem = null;
      placeholderBillOfMaterialsLineItem.removeBill(this);
    }
    AssemblyStep placeholderAssemblyStep = assemblyStep;
    this.assemblyStep = null;
    placeholderAssemblyStep.removeBillOfMaterialsLineItem(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "numberRequired" + ":" + getNumberRequired()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "productType = "+(getProductType()!=null?Integer.toHexString(System.identityHashCode(getProductType())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "consistsOf = "+(getConsistsOf()!=null?Integer.toHexString(System.identityHashCode(getConsistsOf())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "assemblyStep = "+(getAssemblyStep()!=null?Integer.toHexString(System.identityHashCode(getAssemblyStep())):"null")
     + outputString;
  }
}