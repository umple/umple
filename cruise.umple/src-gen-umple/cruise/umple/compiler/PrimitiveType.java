/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.compiler;

/**
 * NOT used right now
 * @umplesource Umple.ump 201
 */
// line 201 "../../../../src/Umple.ump"
public class PrimitiveType extends Type
{

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