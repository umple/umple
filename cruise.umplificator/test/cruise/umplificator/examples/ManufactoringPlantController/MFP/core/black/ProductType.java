/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package MFP.core.black;
import MFP.core.blue.*;
import java.util.*;
import MFP.core.blue.*;
import MFP.core.red.*;

// line 43 "../../../../ManufactoringPlantController.ump"
// line 103 "../../../../ManufactoringPlantController.ump"
public class ProductType
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProductType Attributes
  private String description;

  //ProductType Associations
  private List<AssemblyStep> assemblySteps;
  private List<Bin> keptIn;
  private List<Product> products;
  private List<BillOfMaterialsLineItem> bill;
  private List<BillOfMaterialsLineItem> billOfMaterialsLineItems;
  private List<Supplier> suppliers;
  private List<ProductRun> productRuns;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProductType(String aDescription)
  {
    description = aDescription;
    assemblySteps = new ArrayList<AssemblyStep>();
    keptIn = new ArrayList<Bin>();
    products = new ArrayList<Product>();
    bill = new ArrayList<BillOfMaterialsLineItem>();
    billOfMaterialsLineItems = new ArrayList<BillOfMaterialsLineItem>();
    suppliers = new ArrayList<Supplier>();
    productRuns = new ArrayList<ProductRun>();
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

  public AssemblyStep getAssemblyStep(int index)
  {
    AssemblyStep aAssemblyStep = assemblySteps.get(index);
    return aAssemblyStep;
  }

  /**
   * ordered association
   */
  public List<AssemblyStep> getAssemblySteps()
  {
    List<AssemblyStep> newAssemblySteps = Collections.unmodifiableList(assemblySteps);
    return newAssemblySteps;
  }

  public int numberOfAssemblySteps()
  {
    int number = assemblySteps.size();
    return number;
  }

  public boolean hasAssemblySteps()
  {
    boolean has = assemblySteps.size() > 0;
    return has;
  }

  public int indexOfAssemblyStep(AssemblyStep aAssemblyStep)
  {
    int index = assemblySteps.indexOf(aAssemblyStep);
    return index;
  }

  public Bin getKeptIn(int index)
  {
    Bin aKeptIn = keptIn.get(index);
    return aKeptIn;
  }

  public List<Bin> getKeptIn()
  {
    List<Bin> newKeptIn = Collections.unmodifiableList(keptIn);
    return newKeptIn;
  }

  public int numberOfKeptIn()
  {
    int number = keptIn.size();
    return number;
  }

  public boolean hasKeptIn()
  {
    boolean has = keptIn.size() > 0;
    return has;
  }

  public int indexOfKeptIn(Bin aKeptIn)
  {
    int index = keptIn.indexOf(aKeptIn);
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

  public Supplier getSupplier(int index)
  {
    Supplier aSupplier = suppliers.get(index);
    return aSupplier;
  }

  public List<Supplier> getSuppliers()
  {
    List<Supplier> newSuppliers = Collections.unmodifiableList(suppliers);
    return newSuppliers;
  }

  public int numberOfSuppliers()
  {
    int number = suppliers.size();
    return number;
  }

  public boolean hasSuppliers()
  {
    boolean has = suppliers.size() > 0;
    return has;
  }

  public int indexOfSupplier(Supplier aSupplier)
  {
    int index = suppliers.indexOf(aSupplier);
    return index;
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

  public static int minimumNumberOfAssemblySteps()
  {
    return 0;
  }

  public AssemblyStep addAssemblyStep(String aDescription)
  {
    return new AssemblyStep(aDescription, this);
  }

  public boolean addAssemblyStep(AssemblyStep aAssemblyStep)
  {
    boolean wasAdded = false;
    if (assemblySteps.contains(aAssemblyStep)) { return false; }
    ProductType existingProductType = aAssemblyStep.getProductType();
    boolean isNewProductType = existingProductType != null && !this.equals(existingProductType);
    if (isNewProductType)
    {
      aAssemblyStep.setProductType(this);
    }
    else
    {
      assemblySteps.add(aAssemblyStep);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAssemblyStep(AssemblyStep aAssemblyStep)
  {
    boolean wasRemoved = false;
    //Unable to remove aAssemblyStep, as it must always have a productType
    if (!this.equals(aAssemblyStep.getProductType()))
    {
      assemblySteps.remove(aAssemblyStep);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addAssemblyStepAt(AssemblyStep aAssemblyStep, int index)
  {  
    boolean wasAdded = false;
    if(addAssemblyStep(aAssemblyStep))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssemblySteps()) { index = numberOfAssemblySteps() - 1; }
      assemblySteps.remove(aAssemblyStep);
      assemblySteps.add(index, aAssemblyStep);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAssemblyStepAt(AssemblyStep aAssemblyStep, int index)
  {
    boolean wasAdded = false;
    if(assemblySteps.contains(aAssemblyStep))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssemblySteps()) { index = numberOfAssemblySteps() - 1; }
      assemblySteps.remove(aAssemblyStep);
      assemblySteps.add(index, aAssemblyStep);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAssemblyStepAt(aAssemblyStep, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfKeptIn()
  {
    return 0;
  }

  public Bin addKeptIn(String aNumber)
  {
    return new Bin(aNumber, this);
  }

  public boolean addKeptIn(Bin aKeptIn)
  {
    boolean wasAdded = false;
    if (keptIn.contains(aKeptIn)) { return false; }
    ProductType existingProductType = aKeptIn.getProductType();
    boolean isNewProductType = existingProductType != null && !this.equals(existingProductType);
    if (isNewProductType)
    {
      aKeptIn.setProductType(this);
    }
    else
    {
      keptIn.add(aKeptIn);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeKeptIn(Bin aKeptIn)
  {
    boolean wasRemoved = false;
    //Unable to remove aKeptIn, as it must always have a productType
    if (!this.equals(aKeptIn.getProductType()))
    {
      keptIn.remove(aKeptIn);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addKeptInAt(Bin aKeptIn, int index)
  {  
    boolean wasAdded = false;
    if(addKeptIn(aKeptIn))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfKeptIn()) { index = numberOfKeptIn() - 1; }
      keptIn.remove(aKeptIn);
      keptIn.add(index, aKeptIn);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveKeptInAt(Bin aKeptIn, int index)
  {
    boolean wasAdded = false;
    if(keptIn.contains(aKeptIn))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfKeptIn()) { index = numberOfKeptIn() - 1; }
      keptIn.remove(aKeptIn);
      keptIn.add(index, aKeptIn);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addKeptInAt(aKeptIn, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfProducts()
  {
    return 0;
  }

  public Product addProduct(String aSerialNumber, OrderLineItem aOrderLineItem)
  {
    return new Product(aSerialNumber, this, aOrderLineItem);
  }

  public boolean addProduct(Product aProduct)
  {
    boolean wasAdded = false;
    if (products.contains(aProduct)) { return false; }
    ProductType existingProductType = aProduct.getProductType();
    boolean isNewProductType = existingProductType != null && !this.equals(existingProductType);
    if (isNewProductType)
    {
      aProduct.setProductType(this);
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
    //Unable to remove aProduct, as it must always have a productType
    if (!this.equals(aProduct.getProductType()))
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

  public static int minimumNumberOfBill()
  {
    return 0;
  }

  public BillOfMaterialsLineItem addBill(String aNumberRequired, ProductType aConsistsOf, AssemblyStep aAssemblyStep)
  {
    return new BillOfMaterialsLineItem(aNumberRequired, this, aConsistsOf, aAssemblyStep);
  }

  public boolean addBill(BillOfMaterialsLineItem aBill)
  {
    boolean wasAdded = false;
    if (bill.contains(aBill)) { return false; }
    ProductType existingProductType = aBill.getProductType();
    boolean isNewProductType = existingProductType != null && !this.equals(existingProductType);
    if (isNewProductType)
    {
      aBill.setProductType(this);
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
    //Unable to remove aBill, as it must always have a productType
    if (!this.equals(aBill.getProductType()))
    {
      bill.remove(aBill);
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

  public static int minimumNumberOfBillOfMaterialsLineItems()
  {
    return 0;
  }

  public BillOfMaterialsLineItem addBillOfMaterialsLineItem(String aNumberRequired, ProductType aProductType, AssemblyStep aAssemblyStep)
  {
    return new BillOfMaterialsLineItem(aNumberRequired, aProductType, this, aAssemblyStep);
  }

  public boolean addBillOfMaterialsLineItem(BillOfMaterialsLineItem aBillOfMaterialsLineItem)
  {
    boolean wasAdded = false;
    if (billOfMaterialsLineItems.contains(aBillOfMaterialsLineItem)) { return false; }
    ProductType existingConsistsOf = aBillOfMaterialsLineItem.getConsistsOf();
    boolean isNewConsistsOf = existingConsistsOf != null && !this.equals(existingConsistsOf);
    if (isNewConsistsOf)
    {
      aBillOfMaterialsLineItem.setConsistsOf(this);
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
    //Unable to remove aBillOfMaterialsLineItem, as it must always have a consistsOf
    if (!this.equals(aBillOfMaterialsLineItem.getConsistsOf()))
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

  public static int minimumNumberOfSuppliers()
  {
    return 0;
  }

  public boolean addSupplier(Supplier aSupplier)
  {
    boolean wasAdded = false;
    if (suppliers.contains(aSupplier)) { return false; }
    suppliers.add(aSupplier);
    if (aSupplier.indexOfProductType(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aSupplier.addProductType(this);
      if (!wasAdded)
      {
        suppliers.remove(aSupplier);
      }
    }
    return wasAdded;
  }

  public boolean removeSupplier(Supplier aSupplier)
  {
    boolean wasRemoved = false;
    if (!suppliers.contains(aSupplier))
    {
      return wasRemoved;
    }

    int oldIndex = suppliers.indexOf(aSupplier);
    suppliers.remove(oldIndex);
    if (aSupplier.indexOfProductType(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aSupplier.removeProductType(this);
      if (!wasRemoved)
      {
        suppliers.add(oldIndex,aSupplier);
      }
    }
    return wasRemoved;
  }

  public boolean addSupplierAt(Supplier aSupplier, int index)
  {  
    boolean wasAdded = false;
    if(addSupplier(aSupplier))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSuppliers()) { index = numberOfSuppliers() - 1; }
      suppliers.remove(aSupplier);
      suppliers.add(index, aSupplier);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSupplierAt(Supplier aSupplier, int index)
  {
    boolean wasAdded = false;
    if(suppliers.contains(aSupplier))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSuppliers()) { index = numberOfSuppliers() - 1; }
      suppliers.remove(aSupplier);
      suppliers.add(index, aSupplier);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSupplierAt(aSupplier, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfProductRuns()
  {
    return 0;
  }

  public ProductRun addProductRun(String aTimePeriod, String aNumUnits, AssemblyLine aAssemblyLine)
  {
    return new ProductRun(aTimePeriod, aNumUnits, this, aAssemblyLine);
  }

  public boolean addProductRun(ProductRun aProductRun)
  {
    boolean wasAdded = false;
    if (productRuns.contains(aProductRun)) { return false; }
    ProductType existingProductType = aProductRun.getProductType();
    boolean isNewProductType = existingProductType != null && !this.equals(existingProductType);
    if (isNewProductType)
    {
      aProductRun.setProductType(this);
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
    //Unable to remove aProductRun, as it must always have a productType
    if (!this.equals(aProductRun.getProductType()))
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
    for(int i=assemblySteps.size(); i > 0; i--)
    {
      AssemblyStep aAssemblyStep = assemblySteps.get(i - 1);
      aAssemblyStep.delete();
    }
    for(int i=keptIn.size(); i > 0; i--)
    {
      Bin aKeptIn = keptIn.get(i - 1);
      aKeptIn.delete();
    }
    for(int i=products.size(); i > 0; i--)
    {
      Product aProduct = products.get(i - 1);
      aProduct.delete();
    }
    for(int i=bill.size(); i > 0; i--)
    {
      BillOfMaterialsLineItem aBill = bill.get(i - 1);
      aBill.delete();
    }
    for(int i=billOfMaterialsLineItems.size(); i > 0; i--)
    {
      BillOfMaterialsLineItem aBillOfMaterialsLineItem = billOfMaterialsLineItems.get(i - 1);
      aBillOfMaterialsLineItem.delete();
    }
    ArrayList<Supplier> copyOfSuppliers = new ArrayList<Supplier>(suppliers);
    suppliers.clear();
    for(Supplier aSupplier : copyOfSuppliers)
    {
      aSupplier.removeProductType(this);
    }
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
            "description" + ":" + getDescription()+ "]"
     + outputString;
  }
}