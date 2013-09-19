/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;

/**
 * Used to associated condition patern for an umple elemnt. Designed to be generic so, this elemnt
 * can be of different types
 * @umplesource Generator_UmpleModelWalker.ump 45
 */
// line 45 "../../../../src/Generator_UmpleModelWalker.ump"
public class Condition
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Condition Attributes
  private String condition;
  private Object element;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Condition(String aCondition, Object aElement)
  {
    condition = aCondition;
    element = aElement;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCondition(String aCondition)
  {
    boolean wasSet = false;
    condition = aCondition;
    wasSet = true;
    return wasSet;
  }

  public boolean setElement(Object aElement)
  {
    boolean wasSet = false;
    element = aElement;
    wasSet = true;
    return wasSet;
  }

  public String getCondition()
  {
    return condition;
  }

  public Object getElement()
  {
    return element;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "condition" + ":" + getCondition()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "element" + "=" + (getElement() != null ? !getElement().equals(this)  ? getElement().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}