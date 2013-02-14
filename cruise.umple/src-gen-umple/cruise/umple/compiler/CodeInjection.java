/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.compiler.Position;

// line 222 "../../../../src/Umple.ump"
// line 511 "../../../../src/Umple_Code.ump"
public class CodeInjection
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CodeInjection Attributes
  private String type;
  private String operation;
  private CodeBlock snippet;
  private Position position;
  private boolean isInternal;

  //CodeInjection Associations
  private UmpleClass umpleClass;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CodeInjection(String aType, String aOperation, UmpleClass aUmpleClass)
  {
    type = aType;
    operation = aOperation;
    snippet = new CodeBlock();
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

  public boolean setSnippet(CodeBlock aSnippet)
  {
    boolean wasSet = false;
    snippet = aSnippet;
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

  public CodeBlock getSnippet()
  {
    return snippet;
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
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
   public CodeInjection(String a,String b,String c,UmpleClass d)  {
this(a,b, d);
		setCode(c);
  }
// line 518 ../../../../src/Umple_Code.ump
  public void setCode(String str)
	{
		snippet.setCode(str);
	}
	public String getCode()
	{
		return snippet.getCode();
	}	
	public void setCode(String lang, String code)
	{
		snippet.setCode(lang, code);
	}
	public String getCode(String lang)
	{
		return snippet.getCode(lang);
	}
}