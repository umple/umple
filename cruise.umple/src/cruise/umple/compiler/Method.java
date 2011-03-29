/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.11.1.3376 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

public class Method
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Method Attributes
  private String modifier;
  private String name;
  private String type;
  private boolean isImplemented;

  //Method Associations
  private List<MethodParameter> methodParameters;
  private MethodBody methodBody;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Method(String aModifier, String aName, String aType, boolean aIsImplemented)
  {
    modifier = aModifier;
    name = aName;
    type = aType;
    isImplemented = aIsImplemented;
    methodParameters = new ArrayList<MethodParameter>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setModifier(String aModifier)
  {
    boolean wasSet = false;
    modifier = aModifier;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setType(String aType)
  {
    boolean wasSet = false;
    type = aType;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsImplemented(boolean aIsImplemented)
  {
    boolean wasSet = false;
    isImplemented = aIsImplemented;
    wasSet = true;
    return wasSet;
  }

  public String getModifier()
  {
    return modifier;
  }

  public String getName()
  {
    return name;
  }

  public String getType()
  {
    return type;
  }

  public boolean getIsImplemented()
  {
    return isImplemented;
  }

  public MethodParameter getMethodParameter(int index)
  {
    MethodParameter aMethodParameter = methodParameters.get(index);
    return aMethodParameter;
  }

  public List<MethodParameter> getMethodParameters()
  {
    List<MethodParameter> newMethodParameters = Collections.unmodifiableList(methodParameters);
    return newMethodParameters;
  }

  public int numberOfMethodParameters()
  {
    int number = methodParameters.size();
    return number;
  }

  public boolean hasMethodParameters()
  {
    boolean has = methodParameters.size() > 0;
    return has;
  }

  public int indexOfMethodParameter(MethodParameter aMethodParameter)
  {
    int index = methodParameters.indexOf(aMethodParameter);
    return index;
  }

  public MethodBody getMethodBody()
  {
    return methodBody;
  }

  public static int minimumNumberOfMethodParameters()
  {
    return 0;
  }

  public boolean addMethodParameter(MethodParameter aMethodParameter)
  {
    boolean wasAdded = false;
    if (methodParameters.contains(aMethodParameter)) { return false; }
    methodParameters.add(aMethodParameter);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeMethodParameter(MethodParameter aMethodParameter)
  {
    boolean wasRemoved = false;
    if (methodParameters.contains(aMethodParameter))
    {
      methodParameters.remove(aMethodParameter);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean setMethodBody(MethodBody newMethodBody)
  {
    boolean wasSet = false;
    methodBody = newMethodBody;
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    methodParameters.clear();
    methodBody = null;
  }

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public String toString()
  {
	  StringBuffer methodBuffer = new StringBuffer();
	  methodBuffer.append(" " + this.getType()+ " " + this.getName());
	  methodBuffer.append("(");
	  String paramName="";
	  String paramType="";
	  String aSingleParameter="";
	  String isList="";
	  String parameters = "";
	  String finalParams= "";
	  if (this.hasMethodParameters()){
		  for (MethodParameter aMethodParam : this.getMethodParameters()) 
		  {
			  paramName = aMethodParam.getName();
			  paramType = aMethodParam.getType();
			  isList = aMethodParam.getIsList() ? " [] " : " ";
			  aSingleParameter = paramType + isList + paramName;
			  parameters += aSingleParameter + ",";
		  }
		  finalParams = parameters.substring(0, parameters.length()-1);
		  methodBuffer.append(finalParams);
	  }
	  methodBuffer.append(")");
	  methodBuffer.append("  {");
	  methodBuffer.append(System.getProperty("line.separator"));
	  methodBuffer.append(    this.getMethodBody().getExtraCode());
	  methodBuffer.append(System.getProperty("line.separator"));
	  methodBuffer.append("  }");
	  return methodBuffer.toString();
  }
}