/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * Every product purchase is recorded
 */
// line 43 "VendingMachineClassDiagram.ump"
// line 88 "VendingMachineClassDiagram.ump"
public class ProductTransaction
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProductTransaction Associations
  private ProductInDispenser productInDispenser;
  private List<CoinHolderTransaction> coinHolderTransactions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProductTransaction(ProductInDispenser aProductInDispenser)
  {
    boolean didAddProductInDispenser = setProductInDispenser(aProductInDispenser);
    if (!didAddProductInDispenser)
    {
      throw new RuntimeException("Unable to create productTransaction due to productInDispenser");
    }
    coinHolderTransactions = new ArrayList<CoinHolderTransaction>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public ProductInDispenser getProductInDispenser()
  {
    return productInDispenser;
  }

  public CoinHolderTransaction getCoinHolderTransaction(int index)
  {
    CoinHolderTransaction aCoinHolderTransaction = coinHolderTransactions.get(index);
    return aCoinHolderTransaction;
  }

  /**
   * coins entered and change given
   */
  public List<CoinHolderTransaction> getCoinHolderTransactions()
  {
    List<CoinHolderTransaction> newCoinHolderTransactions = Collections.unmodifiableList(coinHolderTransactions);
    return newCoinHolderTransactions;
  }

  public int numberOfCoinHolderTransactions()
  {
    int number = coinHolderTransactions.size();
    return number;
  }

  public boolean hasCoinHolderTransactions()
  {
    boolean has = coinHolderTransactions.size() > 0;
    return has;
  }

  public int indexOfCoinHolderTransaction(CoinHolderTransaction aCoinHolderTransaction)
  {
    int index = coinHolderTransactions.indexOf(aCoinHolderTransaction);
    return index;
  }

  public boolean setProductInDispenser(ProductInDispenser aProductInDispenser)
  {
    boolean wasSet = false;
    if (aProductInDispenser == null)
    {
      return wasSet;
    }

    ProductInDispenser existingProductInDispenser = productInDispenser;
    productInDispenser = aProductInDispenser;
    if (existingProductInDispenser != null && !existingProductInDispenser.equals(aProductInDispenser))
    {
      existingProductInDispenser.removeProductTransaction(this);
    }
    productInDispenser.addProductTransaction(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfCoinHolderTransactions()
  {
    return 0;
  }

  public CoinHolderTransaction addCoinHolderTransaction(int aNumCoinsInOrOut, CoinHolder aSourceOrDestination)
  {
    return new CoinHolderTransaction(aNumCoinsInOrOut, aSourceOrDestination, this);
  }

  public boolean addCoinHolderTransaction(CoinHolderTransaction aCoinHolderTransaction)
  {
    boolean wasAdded = false;
    if (coinHolderTransactions.contains(aCoinHolderTransaction)) { return false; }
    ProductTransaction existingProductTransaction = aCoinHolderTransaction.getProductTransaction();
    boolean isNewProductTransaction = existingProductTransaction != null && !this.equals(existingProductTransaction);
    if (isNewProductTransaction)
    {
      aCoinHolderTransaction.setProductTransaction(this);
    }
    else
    {
      coinHolderTransactions.add(aCoinHolderTransaction);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCoinHolderTransaction(CoinHolderTransaction aCoinHolderTransaction)
  {
    boolean wasRemoved = false;
    //Unable to remove aCoinHolderTransaction, as it must always have a productTransaction
    if (!this.equals(aCoinHolderTransaction.getProductTransaction()))
    {
      coinHolderTransactions.remove(aCoinHolderTransaction);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addCoinHolderTransactionAt(CoinHolderTransaction aCoinHolderTransaction, int index)
  {  
    boolean wasAdded = false;
    if(addCoinHolderTransaction(aCoinHolderTransaction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCoinHolderTransactions()) { index = numberOfCoinHolderTransactions() - 1; }
      coinHolderTransactions.remove(aCoinHolderTransaction);
      coinHolderTransactions.add(index, aCoinHolderTransaction);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCoinHolderTransactionAt(CoinHolderTransaction aCoinHolderTransaction, int index)
  {
    boolean wasAdded = false;
    if(coinHolderTransactions.contains(aCoinHolderTransaction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCoinHolderTransactions()) { index = numberOfCoinHolderTransactions() - 1; }
      coinHolderTransactions.remove(aCoinHolderTransaction);
      coinHolderTransactions.add(index, aCoinHolderTransaction);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCoinHolderTransactionAt(aCoinHolderTransaction, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ProductInDispenser placeholderProductInDispenser = productInDispenser;
    this.productInDispenser = null;
    placeholderProductInDispenser.removeProductTransaction(this);
    for(int i=coinHolderTransactions.size(); i > 0; i--)
    {
      CoinHolderTransaction aCoinHolderTransaction = coinHolderTransactions.get(i - 1);
      aCoinHolderTransaction.delete();
    }
  }

}