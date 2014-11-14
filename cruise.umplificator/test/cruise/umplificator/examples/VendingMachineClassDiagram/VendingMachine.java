/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 4 "VendingMachineClassDiagram.ump"
// line 26 "VendingMachineClassDiagram.ump"
// line 53 "VendingMachineClassDiagram.ump"
public class VendingMachine
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static VendingMachine theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //VendingMachine Associations
  private List<Dispenser> slots;
  private List<CoinHolder> coinHolders;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private VendingMachine()
  {
    slots = new ArrayList<Dispenser>();
    coinHolders = new ArrayList<CoinHolder>();
  }

  public static VendingMachine getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new VendingMachine();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Dispenser getSlot(int index)
  {
    Dispenser aSlot = slots.get(index);
    return aSlot;
  }

  public List<Dispenser> getSlots()
  {
    List<Dispenser> newSlots = Collections.unmodifiableList(slots);
    return newSlots;
  }

  public int numberOfSlots()
  {
    int number = slots.size();
    return number;
  }

  public boolean hasSlots()
  {
    boolean has = slots.size() > 0;
    return has;
  }

  public int indexOfSlot(Dispenser aSlot)
  {
    int index = slots.indexOf(aSlot);
    return index;
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

  public static int minimumNumberOfSlots()
  {
    return 0;
  }

  public Dispenser addSlot(Character aRow, Character aColumn)
  {
    return new Dispenser(aRow, aColumn, this);
  }

  public boolean addSlot(Dispenser aSlot)
  {
    boolean wasAdded = false;
    if (slots.contains(aSlot)) { return false; }
    VendingMachine existingVendingMachine = aSlot.getVendingMachine();
    boolean isNewVendingMachine = existingVendingMachine != null && !this.equals(existingVendingMachine);
    if (isNewVendingMachine)
    {
      aSlot.setVendingMachine(this);
    }
    else
    {
      slots.add(aSlot);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSlot(Dispenser aSlot)
  {
    boolean wasRemoved = false;
    //Unable to remove aSlot, as it must always have a vendingMachine
    if (!this.equals(aSlot.getVendingMachine()))
    {
      slots.remove(aSlot);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addSlotAt(Dispenser aSlot, int index)
  {  
    boolean wasAdded = false;
    if(addSlot(aSlot))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSlots()) { index = numberOfSlots() - 1; }
      slots.remove(aSlot);
      slots.add(index, aSlot);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSlotAt(Dispenser aSlot, int index)
  {
    boolean wasAdded = false;
    if(slots.contains(aSlot))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSlots()) { index = numberOfSlots() - 1; }
      slots.remove(aSlot);
      slots.add(index, aSlot);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSlotAt(aSlot, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfCoinHolders()
  {
    return 0;
  }

  public CoinHolder addCoinHolder(int aNumCoinsCapacity, int aCurrentNumberOfCoins, CoinType aCanHold)
  {
    return new CoinHolder(aNumCoinsCapacity, aCurrentNumberOfCoins, aCanHold, this);
  }

  public boolean addCoinHolder(CoinHolder aCoinHolder)
  {
    boolean wasAdded = false;
    if (coinHolders.contains(aCoinHolder)) { return false; }
    VendingMachine existingVendingMachine = aCoinHolder.getVendingMachine();
    boolean isNewVendingMachine = existingVendingMachine != null && !this.equals(existingVendingMachine);
    if (isNewVendingMachine)
    {
      aCoinHolder.setVendingMachine(this);
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
    //Unable to remove aCoinHolder, as it must always have a vendingMachine
    if (!this.equals(aCoinHolder.getVendingMachine()))
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
    for(int i=slots.size(); i > 0; i--)
    {
      Dispenser aSlot = slots.get(i - 1);
      aSlot.delete();
    }
    for(int i=coinHolders.size(); i > 0; i--)
    {
      CoinHolder aCoinHolder = coinHolders.get(i - 1);
      aCoinHolder.delete();
    }
  }

}