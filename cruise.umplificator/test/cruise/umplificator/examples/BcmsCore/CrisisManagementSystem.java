/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 27 "BcmsCore.ump"
// line 123 "BcmsCore.ump"
public class CrisisManagementSystem
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static CrisisManagementSystem theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private CrisisManagementSystem()
  {}

  public static CrisisManagementSystem getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new CrisisManagementSystem();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}

}