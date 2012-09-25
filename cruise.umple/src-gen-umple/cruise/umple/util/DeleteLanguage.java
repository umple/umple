/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.umple.util;

public class DeleteLanguage
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static DeleteLanguage theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private DeleteLanguage()
  {}

  public static DeleteLanguage getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new DeleteLanguage();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}

}