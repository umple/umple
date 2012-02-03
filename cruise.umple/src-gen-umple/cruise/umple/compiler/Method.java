/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * Code supporting interfaces
 */
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
  private List<Comment> comments;

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
    comments = new ArrayList<Comment>();
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

  public boolean isIsImplemented()
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

  public Comment getComment(int index)
  {
    Comment aComment = comments.get(index);
    return aComment;
  }

  public List<Comment> getComments()
  {
    List<Comment> newComments = Collections.unmodifiableList(comments);
    return newComments;
  }

  public int numberOfComments()
  {
    int number = comments.size();
    return number;
  }

  public boolean hasComments()
  {
    boolean has = comments.size() > 0;
    return has;
  }

  public int indexOfComment(Comment aComment)
  {
    int index = comments.indexOf(aComment);
    return index;
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

  public static int minimumNumberOfComments()
  {
    return 0;
  }

  public boolean addComment(Comment aComment)
  {
    boolean wasAdded = false;
    if (comments.contains(aComment)) { return false; }
    comments.add(aComment);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeComment(Comment aComment)
  {
    boolean wasRemoved = false;
    if (comments.contains(aComment))
    {
      comments.remove(aComment);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public void delete()
  {
    methodParameters.clear();
    methodBody = null;
    comments.clear();
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