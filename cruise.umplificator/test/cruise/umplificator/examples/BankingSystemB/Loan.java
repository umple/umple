/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 72 "BankingSystemB.ump"
// line 118 "BankingSystemB.ump"
public class Loan extends BankAccount
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Loan(String aAccountNumber, String aBalance, float aOverdraftOrCreditLimit, Branch aBranch)
  {
    super(aAccountNumber, aBalance, aOverdraftOrCreditLimit, aBranch);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }

}