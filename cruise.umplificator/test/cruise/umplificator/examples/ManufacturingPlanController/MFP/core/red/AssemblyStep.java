/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package MFP.core.red;
import java.util.*;
import MFP.core.blue.*;
import MFP.core.black.*;

// line 29 "../../../../ManufacturingPlantController.ump"
// line 142 "../../../../ManufacturingPlantController.ump"
public class AssemblyStep
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AssemblyStep Attributes
  private String description;

  //AssemblyStep Associations
  private List<BillOfMaterialsLineItem> billOfMaterialsLineItems;
  private List<RobotAllocation> robotAllocations;
  private ProductType productType;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AssemblyStep(String aDescription, ProductType aProductType)
  {
    description = aDescription;
    billOfMaterialsLineItems = new ArrayList<BillOfMaterialsLineItem>();
    robotAllocations = new ArrayList<RobotAllocation>();
    boolean didAddProductType = setProductType(aProductType);
    if (!didAddProductType)
    {
      throw new RuntimeException("Unable to create assemblyStep due to productType");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public String getDescription()
  {
    return description;
  }

  public BillOfMaterialsLineItem getBillOfMaterialsLineItem(int index)
  {
    BillOfMaterialsLineItem aBillOfMaterialsLineItem = billOfMaterialsLineItems.get(index);
    return aBillOfMaterialsLineItem;
  }

  public List<BillOfMaterialsLineItem> getBillOfMaterialsLineItems()
  {
    List<BillOfMaterialsLineItem> newBillOfMaterialsLineItems = Collections.unmodifiableList(billOfMaterialsLineItems);
    return newBillOfMaterialsLineItems;
  }

  public int numberOfBillOfMaterialsLineItems()
  {
    int number = billOfMaterialsLineItems.size();
    return number;
  }

  public boolean hasBillOfMaterialsLineItems()
  {
    boolean has = billOfMaterialsLineItems.size() > 0;
    return has;
  }

  public int indexOfBillOfMaterialsLineItem(BillOfMaterialsLineItem aBillOfMaterialsLineItem)
  {
    int index = billOfMaterialsLineItems.indexOf(aBillOfMaterialsLineItem);
    return index;
  }

  public RobotAllocation getRobotAllocation(int index)
  {
    RobotAllocation aRobotAllocation = robotAllocations.get(index);
    return aRobotAllocation;
  }

  public List<RobotAllocation> getRobotAllocations()
  {
    List<RobotAllocation> newRobotAllocations = Collections.unmodifiableList(robotAllocations);
    return newRobotAllocations;
  }

  public int numberOfRobotAllocations()
  {
    int number = robotAllocations.size();
    return number;
  }

  public boolean hasRobotAllocations()
  {
    boolean has = robotAllocations.size() > 0;
    return has;
  }

  public int indexOfRobotAllocation(RobotAllocation aRobotAllocation)
  {
    int index = robotAllocations.indexOf(aRobotAllocation);
    return index;
  }

  public ProductType getProductType()
  {
    return productType;
  }

  public static int minimumNumberOfBillOfMaterialsLineItems()
  {
    return 0;
  }

  public BillOfMaterialsLineItem addBillOfMaterialsLineItem(String aNumberRequired, ProductType aProductType, ProductType aConsistsOf)
  {
    return new BillOfMaterialsLineItem(aNumberRequired, aProductType, aConsistsOf, this);
  }

  public boolean addBillOfMaterialsLineItem(BillOfMaterialsLineItem aBillOfMaterialsLineItem)
  {
    boolean wasAdded = false;
    if (billOfMaterialsLineItems.contains(aBillOfMaterialsLineItem)) { return false; }
    AssemblyStep existingAssemblyStep = aBillOfMaterialsLineItem.getAssemblyStep();
    boolean isNewAssemblyStep = existingAssemblyStep != null && !this.equals(existingAssemblyStep);
    if (isNewAssemblyStep)
    {
      aBillOfMaterialsLineItem.setAssemblyStep(this);
    }
    else
    {
      billOfMaterialsLineItems.add(aBillOfMaterialsLineItem);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeBillOfMaterialsLineItem(BillOfMaterialsLineItem aBillOfMaterialsLineItem)
  {
    boolean wasRemoved = false;
    //Unable to remove aBillOfMaterialsLineItem, as it must always have a assemblyStep
    if (!this.equals(aBillOfMaterialsLineItem.getAssemblyStep()))
    {
      billOfMaterialsLineItems.remove(aBillOfMaterialsLineItem);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addBillOfMaterialsLineItemAt(BillOfMaterialsLineItem aBillOfMaterialsLineItem, int index)
  {  
    boolean wasAdded = false;
    if(addBillOfMaterialsLineItem(aBillOfMaterialsLineItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBillOfMaterialsLineItems()) { index = numberOfBillOfMaterialsLineItems() - 1; }
      billOfMaterialsLineItems.remove(aBillOfMaterialsLineItem);
      billOfMaterialsLineItems.add(index, aBillOfMaterialsLineItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBillOfMaterialsLineItemAt(BillOfMaterialsLineItem aBillOfMaterialsLineItem, int index)
  {
    boolean wasAdded = false;
    if(billOfMaterialsLineItems.contains(aBillOfMaterialsLineItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBillOfMaterialsLineItems()) { index = numberOfBillOfMaterialsLineItems() - 1; }
      billOfMaterialsLineItems.remove(aBillOfMaterialsLineItem);
      billOfMaterialsLineItems.add(index, aBillOfMaterialsLineItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBillOfMaterialsLineItemAt(aBillOfMaterialsLineItem, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfRobotAllocations()
  {
    return 0;
  }

  public RobotAllocation addRobotAllocation(String aTimePeriod, Robot aRobot)
  {
    return new RobotAllocation(aTimePeriod, this, aRobot);
  }

  public boolean addRobotAllocation(RobotAllocation aRobotAllocation)
  {
    boolean wasAdded = false;
    if (robotAllocations.contains(aRobotAllocation)) { return false; }
    AssemblyStep existingAssemblyStep = aRobotAllocation.getAssemblyStep();
    boolean isNewAssemblyStep = existingAssemblyStep != null && !this.equals(existingAssemblyStep);
    if (isNewAssemblyStep)
    {
      aRobotAllocation.setAssemblyStep(this);
    }
    else
    {
      robotAllocations.add(aRobotAllocation);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRobotAllocation(RobotAllocation aRobotAllocation)
  {
    boolean wasRemoved = false;
    //Unable to remove aRobotAllocation, as it must always have a assemblyStep
    if (!this.equals(aRobotAllocation.getAssemblyStep()))
    {
      robotAllocations.remove(aRobotAllocation);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addRobotAllocationAt(RobotAllocation aRobotAllocation, int index)
  {  
    boolean wasAdded = false;
    if(addRobotAllocation(aRobotAllocation))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRobotAllocations()) { index = numberOfRobotAllocations() - 1; }
      robotAllocations.remove(aRobotAllocation);
      robotAllocations.add(index, aRobotAllocation);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRobotAllocationAt(RobotAllocation aRobotAllocation, int index)
  {
    boolean wasAdded = false;
    if(robotAllocations.contains(aRobotAllocation))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRobotAllocations()) { index = numberOfRobotAllocations() - 1; }
      robotAllocations.remove(aRobotAllocation);
      robotAllocations.add(index, aRobotAllocation);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRobotAllocationAt(aRobotAllocation, index);
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
      existingProductType.removeAssemblyStep(this);
    }
    productType.addAssemblyStep(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=billOfMaterialsLineItems.size(); i > 0; i--)
    {
      BillOfMaterialsLineItem aBillOfMaterialsLineItem = billOfMaterialsLineItems.get(i - 1);
      aBillOfMaterialsLineItem.delete();
    }
    for(int i=robotAllocations.size(); i > 0; i--)
    {
      RobotAllocation aRobotAllocation = robotAllocations.get(i - 1);
      aRobotAllocation.delete();
    }
    ProductType placeholderProductType = productType;
    this.productType = null;
    placeholderProductType.removeAssemblyStep(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "description" + ":" + getDescription()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "productType = "+(getProductType()!=null?Integer.toHexString(System.identityHashCode(getProductType())):"null")
     + outputString;
  }
}