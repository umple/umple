/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * Under Development
 * @umplesource Umple.ump 227
 * @umplesource Umple_Code.ump 1330
 */
// line 227 "../../../../src/Umple.ump"
// line 1330 "../../../../src/Umple_Code.ump"
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

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ConstraintVariable(String aType, String aValue)
  {
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

  public boolean getIsAttribute()
  {
    return !"SYNTAX".equals(type)&&!"OPERATOR".equals(type);
  }

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

  public void delete()
  {
    subConstraint = null;
  }

  @umplesourcefile(line={1332},file={"Umple_Code.ump"},javaline={169},length={4})
  public ConstraintVariable isNotPrimitive(){
    isPrimitive = false;
    return this;
  }

  @umplesourcefile(line={1336},file={"Umple_Code.ump"},javaline={175},length={19})
  public UmpleVariable getAttribute(UmpleClass aClass){
    if(!getIsAttribute()) {
      return null;
    }
    if(aClass==null){
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

  @umplesourcefile(line={1356},file={"Umple_Code.ump"},javaline={196},length={15})
   public boolean equals(Object object){
    if(object==null)
    {
      return false;
    }
    ConstraintVariable cv = (ConstraintVariable)object;
    if(cv.getSubConstraint()!=null&&getSubConstraint()!=null)
    {
      return cv.getValue().equals(getValue())&&cv.getSubConstraint().equals(getSubConstraint());
    }
    else
    {
      return cv.getValue().equals(getValue());
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "type" + ":" + getType()+ "," +
            "value" + ":" + getValue()+ "," +
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