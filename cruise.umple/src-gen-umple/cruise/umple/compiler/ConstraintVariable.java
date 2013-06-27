/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;

/**
 * Under Development
 * @umplesource Umple.ump 221
 */
// line 221 "../../../../src/Umple.ump"
public class ConstraintVariable
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ConstraintVariable Attributes
  private String type;
  private String constrainedVariable;
  private boolean isAssociation;
  private int index;
  private boolean isPrimitive;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetConstrainedVariable;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ConstraintVariable(String aType, String aConstrainedVariable)
  {
    cachedHashCode = -1;
    canSetConstrainedVariable = true;
    type = aType;
    constrainedVariable = aConstrainedVariable;
    isAssociation = false;
    index = -1;
    isPrimitive = false;
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

  public boolean setConstrainedVariable(String aConstrainedVariable)
  {
    boolean wasSet = false;
    if (!canSetConstrainedVariable) { return false; }
    constrainedVariable = aConstrainedVariable;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsAssociation(boolean aIsAssociation)
  {
    boolean wasSet = false;
    isAssociation = aIsAssociation;
    wasSet = true;
    return wasSet;
  }

  public boolean setIndex(int aIndex)
  {
    boolean wasSet = false;
    index = aIndex;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsPrimitive(boolean aIsPrimitive)
  {
    boolean wasSet = false;
    isPrimitive = aIsPrimitive;
    wasSet = true;
    return wasSet;
  }

  public String getType()
  {
    return type;
  }

  /**
   * NOT USED: One order of parsing list each type of Umple Variable (Inlcuding the Constrained Variable).
   */
  public String getConstrainedVariable()
  {
    return constrainedVariable;
  }

  public String getValue()
  {
    return constrainedVariable;
  }

  public boolean getIsAttribute()
  {
    return !"SYNTAX".equals(type)&&!"OPERATOR".equals(type);
  }

  public boolean getIsAssociation()
  {
    return isAssociation;
  }

  public int getIndex()
  {
    return index;
  }

  public boolean getIsPrimitive()
  {
    return isPrimitive;
  }

  public boolean getIsNumeric()
  {
    return "integer".equals(type.toLowerCase())||
    "float".equals(type.toLowerCase())||
     "double".equals(type.toLowerCase());
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    ConstraintVariable compareTo = (ConstraintVariable)obj;
  
    if (constrainedVariable == null && compareTo.constrainedVariable != null)
    {
      return false;
    }
    else if (constrainedVariable != null && !constrainedVariable.equals(compareTo.constrainedVariable))
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    if (constrainedVariable != null)
    {
      cachedHashCode = cachedHashCode * 23 + constrainedVariable.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetConstrainedVariable = false;
    return cachedHashCode;
  }

  public void delete()
  {}

  @umplesourcefile(line={234},file={"Umple.ump"},javaline={179},length={13})
  public UmpleVariable getAttribute(UmpleClass aClass){
    if(!getIsAttribute()) {
      return null;
    }
    UmpleVariable uv = aClass.getAttribute(this.getConstrainedVariable());
    if(uv!=null){
      isAssociation = ((Attribute)uv).getIsList();
      return uv;
    }
    uv = aClass.getAssociationVariable(this.getConstrainedVariable());
    isAssociation = uv!=null;
    return uv;
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "constrainedVariable" + ":" + getConstrainedVariable()+ "," +
            "type" + ":" + getType()+ "," +
            "value" + ":" + getValue()+ "," +
            "isAttribute" + ":" + getIsAttribute()+ "," +
            "isAssociation" + ":" + getIsAssociation()+ "," +
            "index" + ":" + getIndex()+ "," +
            "isPrimitive" + ":" + getIsPrimitive()+ "," +
            "isNumeric" + ":" + getIsNumeric()+ "]"
     + outputString;
  }
}