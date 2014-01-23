/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import cruise.umple.compiler.Position;
import java.util.*;

/**
 * A method in an Umple class or interface
 * Umple Methods are coded by the programmer in the language(s) of their choice
 * 
 * @umplesource Umple.ump 110
 * @umplesource Umple_Code.ump 434
 */
// line 110 "../../../../src/Umple.ump"
// line 434 "../../../../src/Umple_Code.ump"
public class Method
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Method Attributes
  private boolean isAbstract;
  private String modifier;
  private String name;
  private Position position;
  private Position codePosition;
  private Position endPosition;
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
    isAbstract = false;
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

  public boolean setIsAbstract(boolean aIsAbstract)
  {
    boolean wasSet = false;
    isAbstract = aIsAbstract;
    wasSet = true;
    return wasSet;
  }

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

  public boolean setPosition(Position aPosition)
  {
    boolean wasSet = false;
    position = aPosition;
    wasSet = true;
    return wasSet;
  }

  public boolean setCodePosition(Position aCodePosition)
  {
    boolean wasSet = false;
    codePosition = aCodePosition;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndPosition(Position aEndPosition)
  {
    boolean wasSet = false;
    endPosition = aEndPosition;
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

  /**
   * Specifies whether or not the Method is abstract.
   */
  public boolean getIsAbstract()
  {
    return isAbstract;
  }

  /**
   * The modifier associated with the method.
   */
  public String getModifier()
  {
    return modifier;
  }

  /**
   * The name of the method.
   */
  public String getName()
  {
    return name;
  }

  public Position getPosition()
  {
    return position;
  }

  public Position getCodePosition()
  {
    return codePosition;
  }

  public Position getEndPosition()
  {
    return endPosition;
  }

  /**
   * The type of the method.
   */
  public String getType()
  {
    return type;
  }

  /**
   * Specifies whether or not the method is implemented.
   */
  public boolean getIsImplemented()
  {
    return isImplemented;
  }

  public boolean isIsAbstract()
  {
    return isAbstract;
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

  /**
   * The method parameters.
   */
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

  /**
   * The comments associated with the method (such as the Javadoc above it).
   */
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

  public boolean addMethodParameterAt(MethodParameter aMethodParameter, int index)
  {  
    boolean wasAdded = false;
    if(addMethodParameter(aMethodParameter))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMethodParameters()) { index = numberOfMethodParameters() - 1; }
      methodParameters.remove(aMethodParameter);
      methodParameters.add(index, aMethodParameter);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMethodParameterAt(MethodParameter aMethodParameter, int index)
  {
    boolean wasAdded = false;
    if(methodParameters.contains(aMethodParameter))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMethodParameters()) { index = numberOfMethodParameters() - 1; }
      methodParameters.remove(aMethodParameter);
      methodParameters.add(index, aMethodParameter);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMethodParameterAt(aMethodParameter, index);
    }
    return wasAdded;
  }

  public boolean setMethodBody(MethodBody aNewMethodBody)
  {
    boolean wasSet = false;
    methodBody = aNewMethodBody;
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

  public boolean addCommentAt(Comment aComment, int index)
  {  
    boolean wasAdded = false;
    if(addComment(aComment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfComments()) { index = numberOfComments() - 1; }
      comments.remove(aComment);
      comments.add(index, aComment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCommentAt(Comment aComment, int index)
  {
    boolean wasAdded = false;
    if(comments.contains(aComment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfComments()) { index = numberOfComments() - 1; }
      comments.remove(aComment);
      comments.add(index, aComment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCommentAt(aComment, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    methodParameters.clear();
    methodBody = null;
    comments.clear();
  }

  @umplesourcefile(line={439},file={"Umple_Code.ump"},javaline={391},length={6})
   public boolean getExistsInLanguage(String lang){
    if(getMethodBody().getExtraCode(lang)==null)
      return isImplemented;
    else 
      return true;
  }

  @umplesourcefile(line={446},file={"Umple_Code.ump"},javaline={399},length={30})
   public String toString(){
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