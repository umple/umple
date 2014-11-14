/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package BankingSystem.core.intangableResources;
import java.util.*;
import BankingSystem.core.tangableResources.*;

/**
 * Positioning
 */
// line 36 "../../../../BankingSystemA.ump"
// line 91 "../../../../BankingSystemA.ump"
public class Account
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Account Attributes
  private int accountNumber;
  private float balance;
  private float creditLimit;

  //Account Associations
  private AccountType accountType;
  private List<Client> clients;
  private Branch branch;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Account(int aAccountNumber, float aBalance, float aCreditLimit, AccountType aAccountType, Branch aBranch)
  {
    accountNumber = aAccountNumber;
    balance = aBalance;
    creditLimit = aCreditLimit;
    if (!setAccountType(aAccountType))
    {
      throw new RuntimeException("Unable to create Account due to aAccountType");
    }
    clients = new ArrayList<Client>();
    boolean didAddBranch = setBranch(aBranch);
    if (!didAddBranch)
    {
      throw new RuntimeException("Unable to create account due to branch");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAccountNumber(int aAccountNumber)
  {
    boolean wasSet = false;
    accountNumber = aAccountNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setBalance(float aBalance)
  {
    boolean wasSet = false;
    balance = aBalance;
    wasSet = true;
    return wasSet;
  }

  public boolean setCreditLimit(float aCreditLimit)
  {
    boolean wasSet = false;
    creditLimit = aCreditLimit;
    wasSet = true;
    return wasSet;
  }

  public int getAccountNumber()
  {
    return accountNumber;
  }

  public float getBalance()
  {
    return balance;
  }

  public float getCreditLimit()
  {
    return creditLimit;
  }

  public AccountType getAccountType()
  {
    return accountType;
  }

  public Client getClient(int index)
  {
    Client aClient = clients.get(index);
    return aClient;
  }

  public List<Client> getClients()
  {
    List<Client> newClients = Collections.unmodifiableList(clients);
    return newClients;
  }

  public int numberOfClients()
  {
    int number = clients.size();
    return number;
  }

  public boolean hasClients()
  {
    boolean has = clients.size() > 0;
    return has;
  }

  public int indexOfClient(Client aClient)
  {
    int index = clients.indexOf(aClient);
    return index;
  }

  public Branch getBranch()
  {
    return branch;
  }

  public boolean setAccountType(AccountType aNewAccountType)
  {
    boolean wasSet = false;
    if (aNewAccountType != null)
    {
      accountType = aNewAccountType;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean isNumberOfClientsValid()
  {
    boolean isValid = numberOfClients() >= minimumNumberOfClients() && numberOfClients() <= maximumNumberOfClients();
    return isValid;
  }

  public static int minimumNumberOfClients()
  {
    return 1;
  }

  public static int maximumNumberOfClients()
  {
    return 2;
  }

  public boolean addClient(Client aClient)
  {
    boolean wasAdded = false;
    if (clients.contains(aClient)) { return false; }
    if (clients.contains(aClient)) { return false; }
    if (clients.contains(aClient)) { return false; }
    if (numberOfClients() >= maximumNumberOfClients())
    {
      return wasAdded;
    }

    clients.add(aClient);
    if (aClient.indexOfAccount(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aClient.addAccount(this);
      if (!wasAdded)
      {
        clients.remove(aClient);
      }
    }
    return wasAdded;
  }

  public boolean removeClient(Client aClient)
  {
    boolean wasRemoved = false;
    if (!clients.contains(aClient))
    {
      return wasRemoved;
    }

    if (numberOfClients() <= minimumNumberOfClients())
    {
      return wasRemoved;
    }

    int oldIndex = clients.indexOf(aClient);
    clients.remove(oldIndex);
    if (aClient.indexOfAccount(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aClient.removeAccount(this);
      if (!wasRemoved)
      {
        clients.add(oldIndex,aClient);
      }
    }
    return wasRemoved;
  }

  public boolean setClients(Client... newClients)
  {
    boolean wasSet = false;
    ArrayList<Client> verifiedClients = new ArrayList<Client>();
    for (Client aClient : newClients)
    {
      if (verifiedClients.contains(aClient))
      {
        continue;
      }
      verifiedClients.add(aClient);
    }

    if (verifiedClients.size() != newClients.length || verifiedClients.size() < minimumNumberOfClients() || verifiedClients.size() > maximumNumberOfClients())
    {
      return wasSet;
    }

    ArrayList<Client> oldClients = new ArrayList<Client>(clients);
    clients.clear();
    for (Client aNewClient : verifiedClients)
    {
      clients.add(aNewClient);
      if (oldClients.contains(aNewClient))
      {
        oldClients.remove(aNewClient);
      }
      else
      {
        aNewClient.addAccount(this);
      }
    }

    for (Client anOldClient : oldClients)
    {
      anOldClient.removeAccount(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean addClientAt(Client aClient, int index)
  {  
    boolean wasAdded = false;
    if(addClient(aClient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfClients()) { index = numberOfClients() - 1; }
      clients.remove(aClient);
      clients.add(index, aClient);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveClientAt(Client aClient, int index)
  {
    boolean wasAdded = false;
    if(clients.contains(aClient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfClients()) { index = numberOfClients() - 1; }
      clients.remove(aClient);
      clients.add(index, aClient);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addClientAt(aClient, index);
    }
    return wasAdded;
  }

  public boolean setBranch(Branch aBranch)
  {
    boolean wasSet = false;
    if (aBranch == null)
    {
      return wasSet;
    }

    Branch existingBranch = branch;
    branch = aBranch;
    if (existingBranch != null && !existingBranch.equals(aBranch))
    {
      existingBranch.removeAccount(this);
    }
    branch.addAccount(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    accountType = null;
    ArrayList<Client> copyOfClients = new ArrayList<Client>(clients);
    clients.clear();
    for(Client aClient : copyOfClients)
    {
      if (aClient.numberOfAccounts() <= Client.minimumNumberOfAccounts())
      {
        aClient.delete();
      }
      else
      {
        aClient.removeAccount(this);
      }
    }
    Branch placeholderBranch = branch;
    this.branch = null;
    placeholderBranch.removeAccount(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "accountNumber" + ":" + getAccountNumber()+ "," +
            "balance" + ":" + getBalance()+ "," +
            "creditLimit" + ":" + getCreditLimit()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "accountType = "+(getAccountType()!=null?Integer.toHexString(System.identityHashCode(getAccountType())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "branch = "+(getBranch()!=null?Integer.toHexString(System.identityHashCode(getBranch())):"null")
     + outputString;
  }
}