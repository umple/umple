/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * Positioning
 */
// line 9 "Insurance.ump"
// line 68 "Insurance.ump"
public class InsurancePolicy
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //InsurancePolicy Attributes
  private String policyNumber;
  private String monthlyPremium;
  private String starDate;
  private String endDate;
  private String insuradValue;

  //InsurancePolicy Associations
  private List<Transaction> transactions;
  private Person holder;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public InsurancePolicy(String aPolicyNumber, String aMonthlyPremium, String aStarDate, String aEndDate, String aInsuradValue, Person aHolder)
  {
    policyNumber = aPolicyNumber;
    monthlyPremium = aMonthlyPremium;
    starDate = aStarDate;
    endDate = aEndDate;
    insuradValue = aInsuradValue;
    transactions = new ArrayList<Transaction>();
    boolean didAddHolder = setHolder(aHolder);
    if (!didAddHolder)
    {
      throw new RuntimeException("Unable to create insurancePolicy due to holder");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPolicyNumber(String aPolicyNumber)
  {
    boolean wasSet = false;
    policyNumber = aPolicyNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setMonthlyPremium(String aMonthlyPremium)
  {
    boolean wasSet = false;
    monthlyPremium = aMonthlyPremium;
    wasSet = true;
    return wasSet;
  }

  public boolean setStarDate(String aStarDate)
  {
    boolean wasSet = false;
    starDate = aStarDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndDate(String aEndDate)
  {
    boolean wasSet = false;
    endDate = aEndDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setInsuradValue(String aInsuradValue)
  {
    boolean wasSet = false;
    insuradValue = aInsuradValue;
    wasSet = true;
    return wasSet;
  }

  public String getPolicyNumber()
  {
    return policyNumber;
  }

  public String getMonthlyPremium()
  {
    return monthlyPremium;
  }

  public String getStarDate()
  {
    return starDate;
  }

  public String getEndDate()
  {
    return endDate;
  }

  public String getInsuradValue()
  {
    return insuradValue;
  }

  public Transaction getTransaction(int index)
  {
    Transaction aTransaction = transactions.get(index);
    return aTransaction;
  }

  public List<Transaction> getTransactions()
  {
    List<Transaction> newTransactions = Collections.unmodifiableList(transactions);
    return newTransactions;
  }

  public int numberOfTransactions()
  {
    int number = transactions.size();
    return number;
  }

  public boolean hasTransactions()
  {
    boolean has = transactions.size() > 0;
    return has;
  }

  public int indexOfTransaction(Transaction aTransaction)
  {
    int index = transactions.indexOf(aTransaction);
    return index;
  }

  public Person getHolder()
  {
    return holder;
  }

  public static int minimumNumberOfTransactions()
  {
    return 0;
  }

  public Transaction addTransaction(String aDate)
  {
    return new Transaction(aDate, this);
  }

  public boolean addTransaction(Transaction aTransaction)
  {
    boolean wasAdded = false;
    if (transactions.contains(aTransaction)) { return false; }
    if (transactions.contains(aTransaction)) { return false; }
    if (transactions.contains(aTransaction)) { return false; }
    InsurancePolicy existingInsurancePolicy = aTransaction.getInsurancePolicy();
    boolean isNewInsurancePolicy = existingInsurancePolicy != null && !this.equals(existingInsurancePolicy);
    if (isNewInsurancePolicy)
    {
      aTransaction.setInsurancePolicy(this);
    }
    else
    {
      transactions.add(aTransaction);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTransaction(Transaction aTransaction)
  {
    boolean wasRemoved = false;
    //Unable to remove aTransaction, as it must always have a insurancePolicy
    if (!this.equals(aTransaction.getInsurancePolicy()))
    {
      transactions.remove(aTransaction);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addTransactionAt(Transaction aTransaction, int index)
  {  
    boolean wasAdded = false;
    if(addTransaction(aTransaction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTransactions()) { index = numberOfTransactions() - 1; }
      transactions.remove(aTransaction);
      transactions.add(index, aTransaction);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTransactionAt(Transaction aTransaction, int index)
  {
    boolean wasAdded = false;
    if(transactions.contains(aTransaction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTransactions()) { index = numberOfTransactions() - 1; }
      transactions.remove(aTransaction);
      transactions.add(index, aTransaction);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTransactionAt(aTransaction, index);
    }
    return wasAdded;
  }

  public boolean setHolder(Person aHolder)
  {
    boolean wasSet = false;
    if (aHolder == null)
    {
      return wasSet;
    }

    Person existingHolder = holder;
    holder = aHolder;
    if (existingHolder != null && !existingHolder.equals(aHolder))
    {
      existingHolder.removeInsurancePolicy(this);
    }
    holder.addInsurancePolicy(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=transactions.size(); i > 0; i--)
    {
      Transaction aTransaction = transactions.get(i - 1);
      aTransaction.delete();
    }
    Person placeholderHolder = holder;
    this.holder = null;
    placeholderHolder.removeInsurancePolicy(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "policyNumber" + ":" + getPolicyNumber()+ "," +
            "monthlyPremium" + ":" + getMonthlyPremium()+ "," +
            "starDate" + ":" + getStarDate()+ "," +
            "endDate" + ":" + getEndDate()+ "," +
            "insuradValue" + ":" + getInsuradValue()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "holder = "+(getHolder()!=null?Integer.toHexString(System.identityHashCode(getHolder())):"null")
     + outputString;
  }
}