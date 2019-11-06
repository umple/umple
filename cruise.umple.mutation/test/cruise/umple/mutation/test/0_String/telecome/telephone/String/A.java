/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package telecome.telephone.String;

// line 8 "../../../StringMutation_uModel_attributeTyped_string.ump"
public class A
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //A Attributes
  private double x;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public A(double aX)
  {
    x = aX;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setX(double aX)
  {
    boolean wasSet = false;
    x = aX;
    wasSet = true;
    return wasSet;
  }

  public double getX()
  {
    return x;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "x" + ":" + getX()+ "]";
  }
}