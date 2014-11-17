/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 59 "BankingSystemB.ump"
// line 95 "BankingSystemB.ump"
public class Currency
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Currency Attributes
  private String code;
  private String exchangeRate;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Currency(String aCode, String aExchangeRate)
  {
    code = aCode;
    exchangeRate = aExchangeRate;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCode(String aCode)
  {
    boolean wasSet = false;
    code = aCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setExchangeRate(String aExchangeRate)
  {
    boolean wasSet = false;
    exchangeRate = aExchangeRate;
    wasSet = true;
    return wasSet;
  }

  public String getCode()
  {
    return code;
  }

  public String getExchangeRate()
  {
    return exchangeRate;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "code" + ":" + getCode()+ "," +
            "exchangeRate" + ":" + getExchangeRate()+ "]"
     + outputString;
  }
}