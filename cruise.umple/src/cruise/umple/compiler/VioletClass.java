/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.605 modeling language!*/

package cruise.umple.compiler;

public class VioletClass
{

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

  public boolean setParentClass(VioletClass newParentClass)
  {
    boolean wasSet = false;
    parentClass = newParentClass;
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    parentClass = null;
  }

}