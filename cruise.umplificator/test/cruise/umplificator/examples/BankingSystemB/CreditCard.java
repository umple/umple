/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 32 "BankingSystemB.ump"
// line 100 "BankingSystemB.ump"
public class CreditCard extends ReusableFinancialInstrument
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CreditCard Attributes
  private String creditLimit;
  private String name;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CreditCard(String aNumber, String aPin, Currency aCurrency, FinancialInstitution aFinancialInstitution, String aCreditLimit, String aName)
  {
    super(aNumber, aPin, aCurrency, aFinancialInstitution);
    creditLimit = aCreditLimit;
    name = aName;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCreditLimit(String aCreditLimit)
  {
    boolean wasSet = false;
    creditLimit = aCreditLimit;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getCreditLimit()
  {
    return creditLimit;
  }

  public String getName()
  {
    return name;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "creditLimit" + ":" + getCreditLimit()+ "," +
            "name" + ":" + getName()+ "]"
     + outputString;
  }
}