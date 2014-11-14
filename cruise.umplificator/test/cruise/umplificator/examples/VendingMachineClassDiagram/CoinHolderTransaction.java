/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



/**
 * The number of coins transferred to or from a CoinHolder
 */
// line 49 "VendingMachineClassDiagram.ump"
// line 95 "VendingMachineClassDiagram.ump"
public class CoinHolderTransaction
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CoinHolderTransaction Attributes
  private int numCoinsInOrOut;

  //CoinHolderTransaction Associations
  private CoinHolder sourceOrDestination;
  private ProductTransaction productTransaction;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CoinHolderTransaction(int aNumCoinsInOrOut, CoinHolder aSourceOrDestination, ProductTransaction aProductTransaction)
  {
    numCoinsInOrOut = aNumCoinsInOrOut;
    boolean didAddSourceOrDestination = setSourceOrDestination(aSourceOrDestination);
    if (!didAddSourceOrDestination)
    {
      throw new RuntimeException("Unable to create coinHolderTransaction due to sourceOrDestination");
    }
    boolean didAddProductTransaction = setProductTransaction(aProductTransaction);
    if (!didAddProductTransaction)
    {
      throw new RuntimeException("Unable to create coinHolderTransaction due to productTransaction");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumCoinsInOrOut(int aNumCoinsInOrOut)
  {
    boolean wasSet = false;
    numCoinsInOrOut = aNumCoinsInOrOut;
    wasSet = true;
    return wasSet;
  }

  /**
   * negative if used to provide change
   */
  public int getNumCoinsInOrOut()
  {
    return numCoinsInOrOut;
  }

  public CoinHolder getSourceOrDestination()
  {
    return sourceOrDestination;
  }

  public ProductTransaction getProductTransaction()
  {
    return productTransaction;
  }

  public boolean setSourceOrDestination(CoinHolder aSourceOrDestination)
  {
    boolean wasSet = false;
    if (aSourceOrDestination == null)
    {
      return wasSet;
    }

    CoinHolder existingSourceOrDestination = sourceOrDestination;
    sourceOrDestination = aSourceOrDestination;
    if (existingSourceOrDestination != null && !existingSourceOrDestination.equals(aSourceOrDestination))
    {
      existingSourceOrDestination.removeCoinHolderTransaction(this);
    }
    sourceOrDestination.addCoinHolderTransaction(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setProductTransaction(ProductTransaction aProductTransaction)
  {
    boolean wasSet = false;
    if (aProductTransaction == null)
    {
      return wasSet;
    }

    ProductTransaction existingProductTransaction = productTransaction;
    productTransaction = aProductTransaction;
    if (existingProductTransaction != null && !existingProductTransaction.equals(aProductTransaction))
    {
      existingProductTransaction.removeCoinHolderTransaction(this);
    }
    productTransaction.addCoinHolderTransaction(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    CoinHolder placeholderSourceOrDestination = sourceOrDestination;
    this.sourceOrDestination = null;
    placeholderSourceOrDestination.removeCoinHolderTransaction(this);
    ProductTransaction placeholderProductTransaction = productTransaction;
    this.productTransaction = null;
    placeholderProductTransaction.removeCoinHolderTransaction(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "numCoinsInOrOut" + ":" + getNumCoinsInOrOut()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "sourceOrDestination = "+(getSourceOrDestination()!=null?Integer.toHexString(System.identityHashCode(getSourceOrDestination())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "productTransaction = "+(getProductTransaction()!=null?Integer.toHexString(System.identityHashCode(getProductTransaction())):"null")
     + outputString;
  }
}