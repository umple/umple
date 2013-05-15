/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.associations;

// line 615 "../../../src/TestHarnessAssociations.ump"
public class ClassOneAssociation
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int line();String file();int javaline();int length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassOneAssociation Associations
  private Otherclass otherclass;

  //Helper Variables
  private boolean canSetOtherclass;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ClassOneAssociation(Otherclass aOtherclass)
  {
    canSetOtherclass = true;
    if (!setOtherclass(aOtherclass))
    {
      throw new RuntimeException("Unable to create ClassOneAssociation due to aOtherclass");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Otherclass getOtherclass()
  {
    return otherclass;
  }

  private boolean setOtherclass(Otherclass aNewOtherclass)
  {
    boolean wasSet = false;
    if (!canSetOtherclass) { return false; }
    canSetOtherclass = false;
    if (aNewOtherclass != null)
    {
      otherclass = aNewOtherclass;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {}

}