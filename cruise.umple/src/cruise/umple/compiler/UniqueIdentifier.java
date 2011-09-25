/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.605 modeling language!*/

package cruise.umple.compiler;

// Superclass for tracking member variables in all target languages
// TODO: Code smell because we have both an association variable and also an association
// This class should go and instead AssociationEnd should be the member variable
public class UniqueIdentifier extends UmpleVariable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UniqueIdentifier(String aName, String aType, String aModifier, String aValue)
  {
    super(aName, aType, aModifier, aValue);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }

}