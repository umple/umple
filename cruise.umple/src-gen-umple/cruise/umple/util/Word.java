/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.util;

/**
 * @umplesource Util_Code.ump 840
 */
// line 840 "../../../../src/Util_Code.ump"
public class Word
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Word Attributes
  private String singular;
  private String plural;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Word(String aSingular, String aPlural)
  {
    singular = aSingular;
    plural = aPlural;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSingular(String aSingular)
  {
    boolean wasSet = false;
    singular = aSingular;
    wasSet = true;
    return wasSet;
  }

  public boolean setPlural(String aPlural)
  {
    boolean wasSet = false;
    plural = aPlural;
    wasSet = true;
    return wasSet;
  }

  public String getSingular()
  {
    return singular;
  }

  public String getPlural()
  {
    return plural;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "singular" + ":" + getSingular()+ "," +
            "plural" + ":" + getPlural()+ "]"
     + outputString;
  }
}