/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 17 "BankingSystemB.ump"
// line 133 "BankingSystemB.ump"
public class Bank extends FinancialInstitution
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Bank Associations
  private List<Branch> branchs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Bank(String aName)
  {
    super(aName);
    branchs = new ArrayList<Branch>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Branch getBranch(int index)
  {
    Branch aBranch = branchs.get(index);
    return aBranch;
  }

  public List<Branch> getBranchs()
  {
    List<Branch> newBranchs = Collections.unmodifiableList(branchs);
    return newBranchs;
  }

  public int numberOfBranchs()
  {
    int number = branchs.size();
    return number;
  }

  public boolean hasBranchs()
  {
    boolean has = branchs.size() > 0;
    return has;
  }

  public int indexOfBranch(Branch aBranch)
  {
    int index = branchs.indexOf(aBranch);
    return index;
  }

  public static int minimumNumberOfBranchs()
  {
    return 0;
  }

  public Branch addBranch(String aName, String aAddress)
  {
    return new Branch(aName, aAddress, this);
  }

  public boolean addBranch(Branch aBranch)
  {
    boolean wasAdded = false;
    if (branchs.contains(aBranch)) { return false; }
    Bank existingBank = aBranch.getBank();
    boolean isNewBank = existingBank != null && !this.equals(existingBank);
    if (isNewBank)
    {
      aBranch.setBank(this);
    }
    else
    {
      branchs.add(aBranch);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeBranch(Branch aBranch)
  {
    boolean wasRemoved = false;
    //Unable to remove aBranch, as it must always have a bank
    if (!this.equals(aBranch.getBank()))
    {
      branchs.remove(aBranch);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addBranchAt(Branch aBranch, int index)
  {  
    boolean wasAdded = false;
    if(addBranch(aBranch))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBranchs()) { index = numberOfBranchs() - 1; }
      branchs.remove(aBranch);
      branchs.add(index, aBranch);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBranchAt(Branch aBranch, int index)
  {
    boolean wasAdded = false;
    if(branchs.contains(aBranch))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBranchs()) { index = numberOfBranchs() - 1; }
      branchs.remove(aBranch);
      branchs.add(index, aBranch);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBranchAt(aBranch, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=branchs.size(); i > 0; i--)
    {
      Branch aBranch = branchs.get(i - 1);
      aBranch.delete();
    }
    super.delete();
  }

}