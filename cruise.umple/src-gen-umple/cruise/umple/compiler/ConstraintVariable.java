/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * Under Development
 * @umplesource Umple.ump 224
 */
// line 224 "../../../../src/Umple.ump"
public class ConstraintVariable
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ConstraintVariable Attributes
  private String type;
  private String value;
  private boolean isAssociation;
  private int index;
  private boolean isPrimitive;
  private UmpleVariable foundAttribute;

  //ConstraintVariable Associations
  private Constraint subConstraint;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetValue;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ConstraintVariable(String aType, String aValue)
  {
    cachedHashCode = -1;
    canSetValue = true;
    type = aType;
    value = aValue;
    isAssociation = false;
    index = -1;
    isPrimitive = true;
    foundAttribute = null;
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

  public boolean setValue(String aValue)
  {
    boolean wasSet = false;
    if (!canSetValue) { return false; }
    value = aValue;
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

  public boolean setFoundAttribute(UmpleVariable aFoundAttribute)
  {
    boolean wasSet = false;
    foundAttribute = aFoundAttribute;
    wasSet = true;
    return wasSet;
  }

  public String getType()
  {
    return type;
  }

  /**
   * NOT USED: One order of parsing list each type of Umple Variable (Including the Constrained Variable).
   */
  public String getValue()
  {
    return value;
  }

  @umplesourcefile(line={229},file={"Umple.ump"},javaline={122},length={2})
  public boolean getIsAttribute()
  {
    return !"SYNTAX".equals(type)&&!"OPERATOR".equals(type);
  }

  @umplesourcefile(line={230},file={"Umple.ump"},javaline={127},length={2})
  public boolean getIsOperator()
  {
    return "OPERATOR".equals(type);
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

  @umplesourcefile(line={234},file={"Umple.ump"},javaline={149},length={6})
  public boolean getIsNumeric()
  {
    return "integer".equals(type.toLowerCase())||
    "float".equals(type.toLowerCase())||
     "double".equals(type.toLowerCase());
  }

  public UmpleVariable getFoundAttribute()
  {
    return foundAttribute;
  }

  public Constraint getSubConstraint()
  {
    return subConstraint;
  }

  public boolean setSubConstraint(Constraint aNewSubConstraint)
  {
    boolean wasSet = false;
    subConstraint = aNewSubConstraint;
    wasSet = true;
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    ConstraintVariable compareTo = (ConstraintVariable)obj;
  
    if (value == null && compareTo.value != null)
    {
      return false;
    }
    else if (value != null && !value.equals(compareTo.value))
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
    if (value != null)
    {
      cachedHashCode = cachedHashCode * 23 + value.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetValue = false;
    return cachedHashCode;
  }

  public void delete()
  {
    subConstraint = null;
  }

  @umplesourcefile(line={238},file={"Umple.ump"},javaline={216},length={4})
  public ConstraintVariable isNotPrimitive(){
    isPrimitive = false;
    return this;
  }

  @umplesourcefile(line={242},file={"Umple.ump"},javaline={222},length={16})
  public UmpleVariable getAttribute(UmpleClass aClass){
    if(!getIsAttribute()) {
      return null;
    }
    UmpleVariable uv = aClass.getAttribute(this.getValue());
    
    if(uv!=null){
      setFoundAttribute(uv);
      isAssociation = ((Attribute)uv).getIsList();
      return uv;
    }
    uv = aClass.getAssociationVariable(this.getValue());
    setFoundAttribute(uv);
    isAssociation = uv!=null;
    return uv;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "value" + ":" + getValue()+ "," +
            "type" + ":" + getType()+ "," +
            "isAttribute" + ":" + getIsAttribute()+ "," +
            "isOperator" + ":" + getIsOperator()+ "," +
            "isAssociation" + ":" + getIsAssociation()+ "," +
            "index" + ":" + getIndex()+ "," +
            "isPrimitive" + ":" + getIsPrimitive()+ "," +
            "isNumeric" + ":" + getIsNumeric()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "foundAttribute" + "=" + (getFoundAttribute() != null ? !getFoundAttribute().equals(this)  ? getFoundAttribute().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "subConstraint = "+(getSubConstraint()!=null?Integer.toHexString(System.identityHashCode(getSubConstraint())):"null")
     + outputString;
  }
}