/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.util;

/**
 * @umplesource Util_Code.ump 850
 */
// line 850 "../../../../src/Util_Code.ump"
public class DeleteLanguage
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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