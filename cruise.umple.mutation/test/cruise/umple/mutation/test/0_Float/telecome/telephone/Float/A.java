/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package telecome.telephone.Float;

// line 8 "../../../FloatMutation_uModel_attributeTyped_float.ump"
public class A
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //A Attributes
  private int x;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public A(int aX)
  {
    x = aX;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setX(int aX)
  {
    boolean wasSet = false;
    x = aX;
    wasSet = true;
    return wasSet;
  }

  public int getX()
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