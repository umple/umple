/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.8.1.2163 modeling language!*/

package cruise.umple.compiler;

public class FacadeMethod
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //FacadeMethod Attributes
  private String context;
  private String returnType;
  private String name;
  private String argumentsFormal;
  private String className;
  private String methodType;
  private String properName;
  private boolean custom;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public FacadeMethod(String aContext, String aReturnType, String aName, String aArgumentsFormal, String aClassName, String aMethodType, String aProperName)
  {
    context = aContext;
    returnType = aReturnType;
    name = aName;
    argumentsFormal = aArgumentsFormal;
    className = aClassName;
    methodType = aMethodType;
    properName = aProperName;
    custom = false;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setContext(String aContext)
  {
    context = aContext;
    return true;
  }

  public boolean setReturnType(String aReturnType)
  {
    returnType = aReturnType;
    return true;
  }

  public boolean setName(String aName)
  {
    name = aName;
    return true;
  }

  public boolean setArgumentsFormal(String aArgumentsFormal)
  {
    argumentsFormal = aArgumentsFormal;
    return true;
  }

  public boolean setClassName(String aClassName)
  {
    className = aClassName;
    return true;
  }

  public boolean setMethodType(String aMethodType)
  {
    methodType = aMethodType;
    return true;
  }

  public boolean setProperName(String aProperName)
  {
    properName = aProperName;
    return true;
  }

  public boolean setCustom(boolean aCustom)
  {
    custom = aCustom;
    return true;
  }

  public String getContext()
  {
    return context;
  }

  public String getReturnType()
  {
    return returnType;
  }

  public String getName()
  {
    return name;
  }

  public String getArgumentsFormal()
  {
    return argumentsFormal;
  }

  public String getClassName()
  {
    return className;
  }

  public String getMethodType()
  {
    return methodType;
  }

  public String getProperName()
  {
    return properName;
  }

  public boolean getCustom()
  {
    return custom;
  }

  public void delete()
  {}

}