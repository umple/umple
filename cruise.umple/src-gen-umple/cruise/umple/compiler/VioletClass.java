/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;

/**
 * @umplesource Violet.ump 34
 */
// line 34 "../../../../src/Violet.ump"
public class VioletClass
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int line();String file();int javaline();int length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //VioletClass Attributes
  private String name;
  private double x;
  private double y;

  //VioletClass Associations
  private VioletClass parentClass;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public VioletClass(String aName, double aX, double aY)
  {
    name = aName;
    x = aX;
    y = aY;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setX(double aX)
  {
    boolean wasSet = false;
    x = aX;
    wasSet = true;
    return wasSet;
  }

  public boolean setY(double aY)
  {
    boolean wasSet = false;
    y = aY;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public double getX()
  {
    return x;
  }

  public double getY()
  {
    return y;
  }

  public VioletClass getParentClass()
  {
    return parentClass;
  }

  public boolean setParentClass(VioletClass aNewParentClass)
  {
    boolean wasSet = false;
    parentClass = aNewParentClass;
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    parentClass = null;
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "x" + ":" + getX()+ "," +
            "y" + ":" + getY()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "parentClass" + "=" + getParentClass() != null ? !getParentClass() .equals(this)  ? getParentClass().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }
}