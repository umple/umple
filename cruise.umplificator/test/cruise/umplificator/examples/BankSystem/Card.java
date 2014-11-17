/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 67 "BankSystem.ump"
public class Card
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Card Attributes
  private String holderName;

  //Card Associations
  private CreditCardAccount creditCardAccount;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Card(String aHolderName, CreditCardAccount aCreditCardAccount)
  {
    holderName = aHolderName;
    boolean didAddCreditCardAccount = setCreditCardAccount(aCreditCardAccount);
    if (!didAddCreditCardAccount)
    {
      throw new RuntimeException("Unable to create card due to creditCardAccount");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setHolderName(String aHolderName)
  {
    boolean wasSet = false;
    holderName = aHolderName;
    wasSet = true;
    return wasSet;
  }

  public String getHolderName()
  {
    return holderName;
  }

  public CreditCardAccount getCreditCardAccount()
  {
    return creditCardAccount;
  }

  public boolean setCreditCardAccount(CreditCardAccount aCreditCardAccount)
  {
    boolean wasSet = false;
    //Must provide creditCardAccount to card
    if (aCreditCardAccount == null)
    {
      return wasSet;
    }

    if (creditCardAccount != null && creditCardAccount.numberOfCards() <= CreditCardAccount.minimumNumberOfCards())
    {
      return wasSet;
    }

    CreditCardAccount existingCreditCardAccount = creditCardAccount;
    creditCardAccount = aCreditCardAccount;
    if (existingCreditCardAccount != null && !existingCreditCardAccount.equals(aCreditCardAccount))
    {
      boolean didRemove = existingCreditCardAccount.removeCard(this);
      if (!didRemove)
      {
        creditCardAccount = existingCreditCardAccount;
        return wasSet;
      }
    }
    creditCardAccount.addCard(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    CreditCardAccount placeholderCreditCardAccount = creditCardAccount;
    this.creditCardAccount = null;
    placeholderCreditCardAccount.removeCard(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "holderName" + ":" + getHolderName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "creditCardAccount = "+(getCreditCardAccount()!=null?Integer.toHexString(System.identityHashCode(getCreditCardAccount())):"null")
     + outputString;
  }
}