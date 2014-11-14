/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 19 "Insurance.ump"
// line 113 "Insurance.ump"
public class Transaction
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Transaction Attributes
  private String date;

  //Transaction Associations
  private InsurancePolicy insurancePolicy;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Transaction(String aDate, InsurancePolicy aInsurancePolicy)
  {
    date = aDate;
    boolean didAddInsurancePolicy = setInsurancePolicy(aInsurancePolicy);
    if (!didAddInsurancePolicy)
    {
      throw new RuntimeException("Unable to create transaction due to insurancePolicy");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDate(String aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public String getDate()
  {
    return date;
  }

  public InsurancePolicy getInsurancePolicy()
  {
    return insurancePolicy;
  }

  public boolean setInsurancePolicy(InsurancePolicy aInsurancePolicy)
  {
    boolean wasSet = false;
    if (aInsurancePolicy == null)
    {
      return wasSet;
    }

    InsurancePolicy existingInsurancePolicy = insurancePolicy;
    insurancePolicy = aInsurancePolicy;
    if (existingInsurancePolicy != null && !existingInsurancePolicy.equals(aInsurancePolicy))
    {
      existingInsurancePolicy.removeTransaction(this);
    }
    insurancePolicy.addTransaction(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    InsurancePolicy placeholderInsurancePolicy = insurancePolicy;
    this.insurancePolicy = null;
    placeholderInsurancePolicy.removeTransaction(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "date" + ":" + getDate()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "insurancePolicy = "+(getInsurancePolicy()!=null?Integer.toHexString(System.identityHashCode(getInsurancePolicy())):"null")
     + outputString;
  }
}