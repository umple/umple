/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package shared;

public class Credentials
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Credentials theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Credentials Attributes
  private String db_hostname;
  private String db_username;
  private String db_password;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private Credentials()
  {
    db_hostname = "localhost:3306";
    db_username = "umple";
    db_password = "ems";
  }

  public static Credentials getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new Credentials();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDb_hostname(String aDb_hostname)
  {
    boolean wasSet = false;
    db_hostname = aDb_hostname;
    wasSet = true;
    return wasSet;
  }

  public boolean setDb_username(String aDb_username)
  {
    boolean wasSet = false;
    db_username = aDb_username;
    wasSet = true;
    return wasSet;
  }

  public boolean setDb_password(String aDb_password)
  {
    boolean wasSet = false;
    db_password = aDb_password;
    wasSet = true;
    return wasSet;
  }

  public String getDb_hostname()
  {
    return db_hostname;
  }

  public String getDb_username()
  {
    return db_username;
  }

  public String getDb_password()
  {
    return db_password;
  }

  public void delete()
  {}

}