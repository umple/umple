/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 72 "BankSystem.ump"
public class Branch extends Division
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Branch Attributes
  private String address;
  private String branchNumber;

  //Branch Associations
  private List<Account> accounts;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Branch(String aName, String aAddress, String aBranchNumber)
  {
    super(aName);
    address = aAddress;
    branchNumber = aBranchNumber;
    accounts = new ArrayList<Account>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setBranchNumber(String aBranchNumber)
  {
    boolean wasSet = false;
    branchNumber = aBranchNumber;
    wasSet = true;
    return wasSet;
  }

  public String getAddress()
  {
    return address;
  }

  public String getBranchNumber()
  {
    return branchNumber;
  }

  public Account getAccount(int index)
  {
    Account aAccount = accounts.get(index);
    return aAccount;
  }

  public List<Account> getAccounts()
  {
    List<Account> newAccounts = Collections.unmodifiableList(accounts);
    return newAccounts;
  }

  public int numberOfAccounts()
  {
    int number = accounts.size();
    return number;
  }

  public boolean hasAccounts()
  {
    boolean has = accounts.size() > 0;
    return has;
  }

  public int indexOfAccount(Account aAccount)
  {
    int index = accounts.indexOf(aAccount);
    return index;
  }

  public static int minimumNumberOfAccounts()
  {
    return 0;
  }

  public Account addAccount(int aAccountNumber, float aBalance, float aCreditLimit, AccountType aAccountType)
  {
    return new Account(aAccountNumber, aBalance, aCreditLimit, aAccountType, this);
  }

  public boolean addAccount(Account aAccount)
  {
    boolean wasAdded = false;
    if (accounts.contains(aAccount)) { return false; }
    Branch existingBranch = aAccount.getBranch();
    boolean isNewBranch = existingBranch != null && !this.equals(existingBranch);
    if (isNewBranch)
    {
      aAccount.setBranch(this);
    }
    else
    {
      accounts.add(aAccount);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAccount(Account aAccount)
  {
    boolean wasRemoved = false;
    //Unable to remove aAccount, as it must always have a branch
    if (!this.equals(aAccount.getBranch()))
    {
      accounts.remove(aAccount);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addAccountAt(Account aAccount, int index)
  {  
    boolean wasAdded = false;
    if(addAccount(aAccount))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccounts()) { index = numberOfAccounts() - 1; }
      accounts.remove(aAccount);
      accounts.add(index, aAccount);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAccountAt(Account aAccount, int index)
  {
    boolean wasAdded = false;
    if(accounts.contains(aAccount))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccounts()) { index = numberOfAccounts() - 1; }
      accounts.remove(aAccount);
      accounts.add(index, aAccount);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAccountAt(aAccount, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=accounts.size(); i > 0; i--)
    {
      Account aAccount = accounts.get(i - 1);
      aAccount.delete();
    }
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "address" + ":" + getAddress()+ "," +
            "branchNumber" + ":" + getBranchNumber()+ "]"
     + outputString;
  }
}