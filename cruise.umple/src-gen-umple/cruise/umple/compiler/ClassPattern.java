/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;

/**
 * A pattern object is used to persist Patentable information for a class elemnt such as
 * abstract, delegate, immutable, etc.
 * @umplesource Generator_UmpleModelWalker.ump 36
 */
// line 36 "../../../../src/Generator_UmpleModelWalker.ump"
public class ClassPattern
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassPattern Attributes
  private UmpleClass classPattern;
  private String pattern;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ClassPattern(UmpleClass aClassPattern, String aPattern)
  {
    classPattern = aClassPattern;
    pattern = aPattern;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setClassPattern(UmpleClass aClassPattern)
  {
    boolean wasSet = false;
    classPattern = aClassPattern;
    wasSet = true;
    return wasSet;
  }

  public boolean setPattern(String aPattern)
  {
    boolean wasSet = false;
    pattern = aPattern;
    wasSet = true;
    return wasSet;
  }

  public UmpleClass getClassPattern()
  {
    return classPattern;
  }

  public String getPattern()
  {
    return pattern;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "pattern" + ":" + getPattern()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "classPattern" + "=" + (getClassPattern() != null ? !getClassPattern().equals(this)  ? getClassPattern().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}