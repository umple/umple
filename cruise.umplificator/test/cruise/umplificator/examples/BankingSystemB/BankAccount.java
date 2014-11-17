/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;
import java.sql.Date;

/**
 * Positioning
 */
// line 49 "BankingSystemB.ump"
// line 77 "BankingSystemB.ump"
public class BankAccount extends FinancialInstrument
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //BankAccount Attributes
  private String accountNumber;
  private String balance;
  private float overdraftOrCreditLimit;

  //BankAccount Associations
  private List<DebitCard> debitCards;
  private List<Cheque> cheques;
  private Branch branch;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public BankAccount(String aAccountNumber, String aBalance, float aOverdraftOrCreditLimit, Branch aBranch)
  {
    super();
    accountNumber = aAccountNumber;
    balance = aBalance;
    overdraftOrCreditLimit = aOverdraftOrCreditLimit;
    debitCards = new ArrayList<DebitCard>();
    cheques = new ArrayList<Cheque>();
    boolean didAddBranch = setBranch(aBranch);
    if (!didAddBranch)
    {
      throw new RuntimeException("Unable to create bankAccount due to branch");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAccountNumber(String aAccountNumber)
  {
    boolean wasSet = false;
    accountNumber = aAccountNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setBalance(String aBalance)
  {
    boolean wasSet = false;
    balance = aBalance;
    wasSet = true;
    return wasSet;
  }

  public boolean setOverdraftOrCreditLimit(float aOverdraftOrCreditLimit)
  {
    boolean wasSet = false;
    overdraftOrCreditLimit = aOverdraftOrCreditLimit;
    wasSet = true;
    return wasSet;
  }

  public String getAccountNumber()
  {
    return accountNumber;
  }

  public String getBalance()
  {
    return balance;
  }

  public float getOverdraftOrCreditLimit()
  {
    return overdraftOrCreditLimit;
  }

  public DebitCard getDebitCard(int index)
  {
    DebitCard aDebitCard = debitCards.get(index);
    return aDebitCard;
  }

  public List<DebitCard> getDebitCards()
  {
    List<DebitCard> newDebitCards = Collections.unmodifiableList(debitCards);
    return newDebitCards;
  }

  public int numberOfDebitCards()
  {
    int number = debitCards.size();
    return number;
  }

  public boolean hasDebitCards()
  {
    boolean has = debitCards.size() > 0;
    return has;
  }

  public int indexOfDebitCard(DebitCard aDebitCard)
  {
    int index = debitCards.indexOf(aDebitCard);
    return index;
  }

  public Cheque getCheque(int index)
  {
    Cheque aCheque = cheques.get(index);
    return aCheque;
  }

  public List<Cheque> getCheques()
  {
    List<Cheque> newCheques = Collections.unmodifiableList(cheques);
    return newCheques;
  }

  public int numberOfCheques()
  {
    int number = cheques.size();
    return number;
  }

  public boolean hasCheques()
  {
    boolean has = cheques.size() > 0;
    return has;
  }

  public int indexOfCheque(Cheque aCheque)
  {
    int index = cheques.indexOf(aCheque);
    return index;
  }

  public Branch getBranch()
  {
    return branch;
  }

  public static int minimumNumberOfDebitCards()
  {
    return 0;
  }

  public boolean addDebitCard(DebitCard aDebitCard)
  {
    boolean wasAdded = false;
    if (debitCards.contains(aDebitCard)) { return false; }
    if (debitCards.contains(aDebitCard)) { return false; }
    debitCards.add(aDebitCard);
    if (aDebitCard.indexOfBankAccount(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aDebitCard.addBankAccount(this);
      if (!wasAdded)
      {
        debitCards.remove(aDebitCard);
      }
    }
    return wasAdded;
  }

  public boolean removeDebitCard(DebitCard aDebitCard)
  {
    boolean wasRemoved = false;
    if (!debitCards.contains(aDebitCard))
    {
      return wasRemoved;
    }

    int oldIndex = debitCards.indexOf(aDebitCard);
    debitCards.remove(oldIndex);
    if (aDebitCard.indexOfBankAccount(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aDebitCard.removeBankAccount(this);
      if (!wasRemoved)
      {
        debitCards.add(oldIndex,aDebitCard);
      }
    }
    return wasRemoved;
  }

  public boolean addDebitCardAt(DebitCard aDebitCard, int index)
  {  
    boolean wasAdded = false;
    if(addDebitCard(aDebitCard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDebitCards()) { index = numberOfDebitCards() - 1; }
      debitCards.remove(aDebitCard);
      debitCards.add(index, aDebitCard);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDebitCardAt(DebitCard aDebitCard, int index)
  {
    boolean wasAdded = false;
    if(debitCards.contains(aDebitCard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDebitCards()) { index = numberOfDebitCards() - 1; }
      debitCards.remove(aDebitCard);
      debitCards.add(index, aDebitCard);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDebitCardAt(aDebitCard, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfCheques()
  {
    return 0;
  }

  public Cheque addCheque(String aAmount, Date aDate, String aSequenceNumber)
  {
    return new Cheque(aAmount, aDate, aSequenceNumber, this);
  }

  public boolean addCheque(Cheque aCheque)
  {
    boolean wasAdded = false;
    if (cheques.contains(aCheque)) { return false; }
    if (cheques.contains(aCheque)) { return false; }
    BankAccount existingBankAccount = aCheque.getBankAccount();
    boolean isNewBankAccount = existingBankAccount != null && !this.equals(existingBankAccount);
    if (isNewBankAccount)
    {
      aCheque.setBankAccount(this);
    }
    else
    {
      cheques.add(aCheque);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCheque(Cheque aCheque)
  {
    boolean wasRemoved = false;
    //Unable to remove aCheque, as it must always have a bankAccount
    if (!this.equals(aCheque.getBankAccount()))
    {
      cheques.remove(aCheque);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addChequeAt(Cheque aCheque, int index)
  {  
    boolean wasAdded = false;
    if(addCheque(aCheque))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCheques()) { index = numberOfCheques() - 1; }
      cheques.remove(aCheque);
      cheques.add(index, aCheque);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveChequeAt(Cheque aCheque, int index)
  {
    boolean wasAdded = false;
    if(cheques.contains(aCheque))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCheques()) { index = numberOfCheques() - 1; }
      cheques.remove(aCheque);
      cheques.add(index, aCheque);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addChequeAt(aCheque, index);
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
      existingBranch.removeBankAccount(this);
    }
    branch.addBankAccount(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<DebitCard> copyOfDebitCards = new ArrayList<DebitCard>(debitCards);
    debitCards.clear();
    for(DebitCard aDebitCard : copyOfDebitCards)
    {
      if (aDebitCard.numberOfBankAccounts() <= DebitCard.minimumNumberOfBankAccounts())
      {
        aDebitCard.delete();
      }
      else
      {
        aDebitCard.removeBankAccount(this);
      }
    }
    for(int i=cheques.size(); i > 0; i--)
    {
      Cheque aCheque = cheques.get(i - 1);
      aCheque.delete();
    }
    Branch placeholderBranch = branch;
    this.branch = null;
    placeholderBranch.removeBankAccount(this);
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "accountNumber" + ":" + getAccountNumber()+ "," +
            "balance" + ":" + getBalance()+ "," +
            "overdraftOrCreditLimit" + ":" + getOverdraftOrCreditLimit()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "branch = "+(getBranch()!=null?Integer.toHexString(System.identityHashCode(getBranch())):"null")
     + outputString;
  }
}