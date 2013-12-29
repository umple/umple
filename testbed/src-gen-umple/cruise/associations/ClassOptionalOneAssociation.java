/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.associations;

// line 627 "../../../src/TestHarnessAssociations.ump"
public class ClassOptionalOneAssociation
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassOptionalOneAssociation Associations
  private Otherclass otherclass;

  //Helper Variables
  private boolean canSetOtherclass;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ClassOptionalOneAssociation(Otherclass aOtherclass)
  {
    canSetOtherclass = true;
    setOtherclass(aOtherclass);
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
    otherclass = aNewOtherclass;
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {}

}