/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.compiler.Position;

// line 203 "../../../../src/Umple.ump"
public class CodeInjection
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CodeInjection Attributes
  private String type;
  private String operation;
  private String code;
  private Position position;
  private boolean isInternal;

  //CodeInjection Associations
  private UmpleClass umpleClass;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CodeInjection(String aType, String aOperation, String aCode, UmpleClass aUmpleClass)
  {
    type = aType;
    operation = aOperation;
    code = aCode;
    isInternal = false;
    if (!setUmpleClass(aUmpleClass))
    {
      throw new RuntimeException("Unable to create CodeInjection due to aUmpleClass");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setType(String aType)
  {
    boolean wasSet = false;
    type = aType;
    wasSet = true;
    return wasSet;
  }

  public boolean setOperation(String aOperation)
  {
    boolean wasSet = false;
    operation = aOperation;
    wasSet = true;
    return wasSet;
  }

  public boolean setCode(String aCode)
  {
    boolean wasSet = false;
    code = aCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setPosition(Position aPosition)
  {
    boolean wasSet = false;
    position = aPosition;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsInternal(boolean aIsInternal)
  {
    boolean wasSet = false;
    isInternal = aIsInternal;
    wasSet = true;
    return wasSet;
  }

  public String getType()
  {
    return type;
  }

  public String getOperation()
  {
    return operation;
  }

  public String getCode()
  {
    return code;
  }

  public Position getPosition()
  {
    return position;
  }

  public boolean getIsInternal()
  {
    return isInternal;
  }

  public boolean isIsInternal()
  {
    return isInternal;
  }

  public UmpleClass getUmpleClass()
  {
    return umpleClass;
  }

  public boolean setUmpleClass(UmpleClass newUmpleClass)
  {
    boolean wasSet = false;
    if (newUmpleClass != null)
    {
      umpleClass = newUmpleClass;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    umpleClass = null;
  }

}