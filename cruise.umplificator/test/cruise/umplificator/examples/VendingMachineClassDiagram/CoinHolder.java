/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 36 "VendingMachineClassDiagram.ump"
// line 82 "VendingMachineClassDiagram.ump"
public class CoinHolder
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CoinHolder Attributes
  private int numCoinsCapacity;
  private int currentNumberOfCoins;

  //CoinHolder Associations
  private CoinType canHold;
  private VendingMachine vendingMachine;
  private List<CoinHolderTransaction> coinHolderTransactions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CoinHolder(int aNumCoinsCapacity, int aCurrentNumberOfCoins, CoinType aCanHold, VendingMachine aVendingMachine)
  {
    numCoinsCapacity = aNumCoinsCapacity;
    currentNumberOfCoins = aCurrentNumberOfCoins;
    boolean didAddCanHold = setCanHold(aCanHold);
    if (!didAddCanHold)
    {
      throw new RuntimeException("Unable to create coinHolder due to canHold");
    }
    boolean didAddVendingMachine = setVendingMachine(aVendingMachine);
    if (!didAddVendingMachine)
    {
      throw new RuntimeException("Unable to create coinHolder due to vendingMachine");
    }
    coinHolderTransactions = new ArrayList<CoinHolderTransaction>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumCoinsCapacity(int aNumCoinsCapacity)
  {
    boolean wasSet = false;
    numCoinsCapacity = aNumCoinsCapacity;
    wasSet = true;
    return wasSet;
  }

  public boolean setCurrentNumberOfCoins(int aCurrentNumberOfCoins)
  {
    boolean wasSet = false;
    currentNumberOfCoins = aCurrentNumberOfCoins;
    wasSet = true;
    return wasSet;
  }

  public int getNumCoinsCapacity()
  {
    return numCoinsCapacity;
  }

  public int getCurrentNumberOfCoins()
  {
    return currentNumberOfCoins;
  }

  public CoinType getCanHold()
  {
    return canHold;
  }

  public VendingMachine getVendingMachine()
  {
    return vendingMachine;
  }

  public CoinHolderTransaction getCoinHolderTransaction(int index)
  {
    CoinHolderTransaction aCoinHolderTransaction = coinHolderTransactions.get(index);
    return aCoinHolderTransaction;
  }

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

  public boolean setCanHold(CoinType aCanHold)
  {
    boolean wasSet = false;
    if (aCanHold == null)
    {
      return wasSet;
    }

    CoinType existingCanHold = canHold;
    canHold = aCanHold;
    if (existingCanHold != null && !existingCanHold.equals(aCanHold))
    {
      existingCanHold.removeCoinHolder(this);
    }
    canHold.addCoinHolder(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setVendingMachine(VendingMachine aVendingMachine)
  {
    boolean wasSet = false;
    if (aVendingMachine == null)
    {
      return wasSet;
    }

    VendingMachine existingVendingMachine = vendingMachine;
    vendingMachine = aVendingMachine;
    if (existingVendingMachine != null && !existingVendingMachine.equals(aVendingMachine))
    {
      existingVendingMachine.removeCoinHolder(this);
    }
    vendingMachine.addCoinHolder(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfCoinHolderTransactions()
  {
    return 0;
  }

  public CoinHolderTransaction addCoinHolderTransaction(int aNumCoinsInOrOut, ProductTransaction aProductTransaction)
  {
    return new CoinHolderTransaction(aNumCoinsInOrOut, this, aProductTransaction);
  }

  public boolean addCoinHolderTransaction(CoinHolderTransaction aCoinHolderTransaction)
  {
    boolean wasAdded = false;
    if (coinHolderTransactions.contains(aCoinHolderTransaction)) { return false; }
    CoinHolder existingSourceOrDestination = aCoinHolderTransaction.getSourceOrDestination();
    boolean isNewSourceOrDestination = existingSourceOrDestination != null && !this.equals(existingSourceOrDestination);
    if (isNewSourceOrDestination)
    {
      aCoinHolderTransaction.setSourceOrDestination(this);
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
    //Unable to remove aCoinHolderTransaction, as it must always have a sourceOrDestination
    if (!this.equals(aCoinHolderTransaction.getSourceOrDestination()))
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
    CoinType placeholderCanHold = canHold;
    this.canHold = null;
    placeholderCanHold.removeCoinHolder(this);
    VendingMachine placeholderVendingMachine = vendingMachine;
    this.vendingMachine = null;
    placeholderVendingMachine.removeCoinHolder(this);
    for(int i=coinHolderTransactions.size(); i > 0; i--)
    {
      CoinHolderTransaction aCoinHolderTransaction = coinHolderTransactions.get(i - 1);
      aCoinHolderTransaction.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "numCoinsCapacity" + ":" + getNumCoinsCapacity()+ "," +
            "currentNumberOfCoins" + ":" + getCurrentNumberOfCoins()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "canHold = "+(getCanHold()!=null?Integer.toHexString(System.identityHashCode(getCanHold())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "vendingMachine = "+(getVendingMachine()!=null?Integer.toHexString(System.identityHashCode(getVendingMachine())):"null")
     + outputString;
  }
}