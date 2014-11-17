/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 50 "BankingSystemA.ump"
// line 124 "BankingSystemA.ump"
public class Privilege
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Privilege Attributes
  private String description;

  //Privilege Associations
  private List<AccountType> accountTypes;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Privilege(String aDescription)
  {
    description = aDescription;
    accountTypes = new ArrayList<AccountType>();
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

  public AccountType getAccountType(int index)
  {
    AccountType aAccountType = accountTypes.get(index);
    return aAccountType;
  }

  public List<AccountType> getAccountTypes()
  {
    List<AccountType> newAccountTypes = Collections.unmodifiableList(accountTypes);
    return newAccountTypes;
  }

  public int numberOfAccountTypes()
  {
    int number = accountTypes.size();
    return number;
  }

  public boolean hasAccountTypes()
  {
    boolean has = accountTypes.size() > 0;
    return has;
  }

  public int indexOfAccountType(AccountType aAccountType)
  {
    int index = accountTypes.indexOf(aAccountType);
    return index;
  }

  public static int minimumNumberOfAccountTypes()
  {
    return 0;
  }

  public boolean addAccountType(AccountType aAccountType)
  {
    boolean wasAdded = false;
    if (accountTypes.contains(aAccountType)) { return false; }
    accountTypes.add(aAccountType);
    if (aAccountType.indexOfPrivilege(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aAccountType.addPrivilege(this);
      if (!wasAdded)
      {
        accountTypes.remove(aAccountType);
      }
    }
    return wasAdded;
  }

  public boolean removeAccountType(AccountType aAccountType)
  {
    boolean wasRemoved = false;
    if (!accountTypes.contains(aAccountType))
    {
      return wasRemoved;
    }

    int oldIndex = accountTypes.indexOf(aAccountType);
    accountTypes.remove(oldIndex);
    if (aAccountType.indexOfPrivilege(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aAccountType.removePrivilege(this);
      if (!wasRemoved)
      {
        accountTypes.add(oldIndex,aAccountType);
      }
    }
    return wasRemoved;
  }

  public boolean addAccountTypeAt(AccountType aAccountType, int index)
  {  
    boolean wasAdded = false;
    if(addAccountType(aAccountType))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccountTypes()) { index = numberOfAccountTypes() - 1; }
      accountTypes.remove(aAccountType);
      accountTypes.add(index, aAccountType);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAccountTypeAt(AccountType aAccountType, int index)
  {
    boolean wasAdded = false;
    if(accountTypes.contains(aAccountType))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccountTypes()) { index = numberOfAccountTypes() - 1; }
      accountTypes.remove(aAccountType);
      accountTypes.add(index, aAccountType);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAccountTypeAt(aAccountType, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<AccountType> copyOfAccountTypes = new ArrayList<AccountType>(accountTypes);
    accountTypes.clear();
    for(AccountType aAccountType : copyOfAccountTypes)
    {
      aAccountType.removePrivilege(this);
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