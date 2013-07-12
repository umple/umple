/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.compiler.Position;
import cruise.umple.util.*;
import java.util.*;

/**
 * A block of code that can be injected into one or more methods, constructor, etc.
 * @umplesource Umple.ump 283
 * @umplesource Umple_Code.ump 533
 */
// line 283 "../../../../src/Umple.ump"
// line 533 "../../../../src/Umple_Code.ump"
public class CodeInjection
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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
            "  " + "snippet" + "=" + (getSnippet() != null ? !getSnippet().equals(this)  ? getSnippet().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "position" + "=" + (getPosition() != null ? !getPosition().equals(this)  ? getPosition().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "umpleClass = "+(getUmpleClass()!=null?Integer.toHexString(System.identityHashCode(getUmpleClass())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "constraint = "+(getConstraint()!=null?Integer.toHexString(System.identityHashCode(getConstraint())):"null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
    @umplesourcefile(line={0},file={""},javaline={179},length={4})
 public CodeInjection(String a,String b,String c,UmpleClass d)  {
this(a,b, d);
    setCode(c);
  }
//  @umplesourcefile(line={539},file={"Umple_Code.ump"},javaline={184},length={48})
  @umplesourcefile(line={540},file={"Umple_Code.ump"},javaline={185},length={4})
  public void setCode(String str)
  {
    snippet.setCode(str);
  }
  @umplesourcefile(line={544},file={"Umple_Code.ump"},javaline={190},length={35})
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
  @umplesourcefile(line={579},file={"Umple_Code.ump"},javaline={226},length={4})
  public void setCode(String lang, String code)
  {
    snippet.setCode(lang, code);
  }
  @umplesourcefile(line={583},file={"Umple_Code.ump"},javaline={231},length={4})
  public String getCode(String lang)
  {
    return snippet.getCode(lang);
  }

}