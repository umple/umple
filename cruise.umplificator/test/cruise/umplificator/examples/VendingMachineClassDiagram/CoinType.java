/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 30 "VendingMachineClassDiagram.ump"
// line 77 "VendingMachineClassDiagram.ump"
public class CoinType
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CoinType Attributes
  private int value;
  private int weight;
  private int diameter;

  //CoinType Associations
  private List<CoinHolder> coinHolders;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CoinType(int aValue, int aWeight, int aDiameter)
  {
    value = aValue;
    weight = aWeight;
    diameter = aDiameter;
    coinHolders = new ArrayList<CoinHolder>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setValue(int aValue)
  {
    boolean wasSet = false;
    value = aValue;
    wasSet = true;
    return wasSet;
  }

  public boolean setWeight(int aWeight)
  {
    boolean wasSet = false;
    weight = aWeight;
    wasSet = true;
    return wasSet;
  }

  public boolean setDiameter(int aDiameter)
  {
    boolean wasSet = false;
    diameter = aDiameter;
    wasSet = true;
    return wasSet;
  }

  /**
   * cents
   */
  public int getValue()
  {
    return value;
  }

  /**
   * grams
   */
  public int getWeight()
  {
    return weight;
  }

  /**
   * micrometers
   */
  public int getDiameter()
  {
    return diameter;
  }

  public CoinHolder getCoinHolder(int index)
  {
    CoinHolder aCoinHolder = coinHolders.get(index);
    return aCoinHolder;
  }

  public List<CoinHolder> getCoinHolders()
  {
    List<CoinHolder> newCoinHolders = Collections.unmodifiableList(coinHolders);
    return newCoinHolders;
  }

  public int numberOfCoinHolders()
  {
    int number = coinHolders.size();
    return number;
  }

  public boolean hasCoinHolders()
  {
    boolean has = coinHolders.size() > 0;
    return has;
  }

  public int indexOfCoinHolder(CoinHolder aCoinHolder)
  {
    int index = coinHolders.indexOf(aCoinHolder);
    return index;
  }

  public static int minimumNumberOfCoinHolders()
  {
    return 0;
  }

  public CoinHolder addCoinHolder(int aNumCoinsCapacity, int aCurrentNumberOfCoins, VendingMachine aVendingMachine)
  {
    return new CoinHolder(aNumCoinsCapacity, aCurrentNumberOfCoins, this, aVendingMachine);
  }

  public boolean addCoinHolder(CoinHolder aCoinHolder)
  {
    boolean wasAdded = false;
    if (coinHolders.contains(aCoinHolder)) { return false; }
    CoinType existingCanHold = aCoinHolder.getCanHold();
    boolean isNewCanHold = existingCanHold != null && !this.equals(existingCanHold);
    if (isNewCanHold)
    {
      aCoinHolder.setCanHold(this);
    }
    else
    {
      coinHolders.add(aCoinHolder);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCoinHolder(CoinHolder aCoinHolder)
  {
    boolean wasRemoved = false;
    //Unable to remove aCoinHolder, as it must always have a canHold
    if (!this.equals(aCoinHolder.getCanHold()))
    {
      coinHolders.remove(aCoinHolder);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addCoinHolderAt(CoinHolder aCoinHolder, int index)
  {  
    boolean wasAdded = false;
    if(addCoinHolder(aCoinHolder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCoinHolders()) { index = numberOfCoinHolders() - 1; }
      coinHolders.remove(aCoinHolder);
      coinHolders.add(index, aCoinHolder);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCoinHolderAt(CoinHolder aCoinHolder, int index)
  {
    boolean wasAdded = false;
    if(coinHolders.contains(aCoinHolder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCoinHolders()) { index = numberOfCoinHolders() - 1; }
      coinHolders.remove(aCoinHolder);
      coinHolders.add(index, aCoinHolder);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCoinHolderAt(aCoinHolder, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=coinHolders.size(); i > 0; i--)
    {
      CoinHolder aCoinHolder = coinHolders.get(i - 1);
      aCoinHolder.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "value" + ":" + getValue()+ "," +
            "weight" + ":" + getWeight()+ "," +
            "diameter" + ":" + getDiameter()+ "]"
     + outputString;
  }
}