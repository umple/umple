/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.compiler.Position;
import cruise.umple.util.*;
import java.util.*;

/**
 * A block of code that can be injected into one or more methods, constructor, etc.
 * @umplesource Umple.ump 280
 * @umplesource Umple_Code.ump 533
 */
// line 280 "../../../../src/Umple.ump"
// line 533 "../../../../src/Umple_Code.ump"
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
  private Constraint constraint;

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

  public Constraint getConstraint()
  {
    return constraint;
  }

  public boolean setUmpleClass(UmpleClass aNewUmpleClass)
  {
    boolean wasSet = false;
    if (aNewUmpleClass != null)
    {
      umpleClass = aNewUmpleClass;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setConstraint(Constraint aNewConstraint)
  {
    boolean wasSet = false;
    constraint = aNewConstraint;
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    umpleClass = null;
    constraint = null;
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "type" + ":" + getType()+ "," +
            "operation" + ":" + getOperation()+ "," +
            "isInternal" + ":" + getIsInternal()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "constraint" + "=" + getSnippet() != null ? !getSnippet() .equals(this)  ? getSnippet().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "umpleClass" + "=" + getPosition() != null ? !getPosition() .equals(this)  ? getPosition().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "snippet" + "=" + getUmpleClass() != null ? !getUmpleClass() .equals(this)  ? getUmpleClass().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "position" + "=" + getConstraint() != null ? !getConstraint() .equals(this)  ? getConstraint().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
   public CodeInjection(String a,String b,String c,UmpleClass d)  {
this(a,b, d);
    setCode(c);
  }
// line 540 ../../../../src/Umple_Code.ump
  public void setCode(String str)
  {
    snippet.setCode(str);
  }
  public String getCode()
  {
  	if(constraint == null)
  	{
  	  return snippet.getCode();
  	}
  	else
  	{
  	  if("Java".equals(CodeBlock.languageUsed))
  	  {
  	  	return StringFormatter.format((new JavaGenerator()).translate("Closed",getConstraint()),
  	  		snippet.getCode()
  	  	);
  	  }
  	  else if("Php".equals(CodeBlock.languageUsed))
  	  {
  	  	return StringFormatter.format((new RubyGenerator()).translate("Closed",getConstraint()),
  	  		snippet.getCode()
  	  	);
  	  }
  	  else if("Ruby".equals(CodeBlock.languageUsed))
  	  {
  	  	return StringFormatter.format((new RubyGenerator()).translate("Closed",getConstraint()),
  	  		snippet.getCode()
  	  	);
  	  }
  	  else if("Cpp".equals(CodeBlock.languageUsed))
  	  {
  	  	return StringFormatter.format((new RubyGenerator()).translate("Closed",getConstraint()),
  	  		snippet.getCode()
  	  	);
  	  }
  	  return snippet.getCode();
  	}
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