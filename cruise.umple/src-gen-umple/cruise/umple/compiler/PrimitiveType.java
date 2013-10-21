/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;

/**
 * NOT used right now
 * @umplesource Umple.ump 211
 */
// line 211 "../../../../src/Umple.ump"
public class PrimitiveType extends Type
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PrimitiveType Attributes
  private String typeName;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PrimitiveType(String aTypeName)
  {
    super();
    typeName = aTypeName;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTypeName(String aTypeName)
  {
    boolean wasSet = false;
    typeName = aTypeName;
    wasSet = true;
    return wasSet;
  }

  public String getTypeName()
  {
    return typeName;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "typeName" + ":" + getTypeName()+ "]"
     + outputString;
  }
}