/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;

/**
 * A root class elemnt. It is used to backtrack the parent package when walking through
 * an elemnt (@see IWalker, UmpleModelVisitor)
 * @umplesource Generator_UmpleModelWalker.ump 24
 */
// line 24 "../../../../src/Generator_UmpleModelWalker.ump"
public class Package
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Package Attributes
  private String packageName;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Package(String aPackageName)
  {
    packageName = aPackageName;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPackageName(String aPackageName)
  {
    boolean wasSet = false;
    packageName = aPackageName;
    wasSet = true;
    return wasSet;
  }

  public String getPackageName()
  {
    return packageName;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "packageName" + ":" + getPackageName()+ "]"
     + outputString;
  }
}