/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;

public class ClassOptionalOneAssociation
{

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

  private boolean setOtherclass(Otherclass newOtherclass)
  {
    boolean wasSet = false;
    if (!canSetOtherclass) { return false; }
    canSetOtherclass = false;
    otherclass = newOtherclass;
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {}

}