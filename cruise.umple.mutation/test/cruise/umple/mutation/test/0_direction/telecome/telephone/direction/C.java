/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package telecome.telephone.direction;

// line 14 "../../../directionMutation_uModel_useFiles2.ump"
public class C
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //C Associations
  private A a;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public C(A aA)
  {
    boolean didAddA = setA(aA);
    if (!didAddA)
    {
      throw new RuntimeException("Unable to create c due to a. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public A getA()
  {
    return a;
  }
  /* Code from template association_SetOneToMany */
  public boolean setA(A aA)
  {
    boolean wasSet = false;
    if (aA == null)
    {
      return wasSet;
    }

    A existingA = a;
    a = aA;
    if (existingA != null && !existingA.equals(aA))
    {
      existingA.removeC(this);
    }
    a.addC(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    A placeholderA = a;
    this.a = null;
    if(placeholderA != null)
    {
      placeholderA.removeC(this);
    }
  }

}