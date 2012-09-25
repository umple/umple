/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;

public class ClassOneAssociation
{

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

  private boolean setOtherclass(Otherclass newOtherclass)
  {
    boolean wasSet = false;
    if (!canSetOtherclass) { return false; }
    canSetOtherclass = false;
    if (newOtherclass != null)
    {
      otherclass = newOtherclass;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {}

}