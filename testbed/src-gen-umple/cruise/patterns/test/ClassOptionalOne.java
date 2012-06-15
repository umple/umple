/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.patterns.test;

public class ClassOptionalOne
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassOptionalOne Associations
  private ClassOtherclass classOtherclass;

  //Helper Variables
  private boolean canSetClassOtherclass;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ClassOptionalOne(ClassOtherclass aClassOtherclass)
  {
    canSetClassOtherclass = true;
    setClassOtherclass(aClassOtherclass);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public ClassOtherclass getClassOtherclass()
  {
    return classOtherclass;
  }

  private boolean setClassOtherclass(ClassOtherclass newClassOtherclass)
  {
    boolean wasSet = false;
    if (!canSetClassOtherclass) { return false; }
    canSetClassOtherclass = false;
    classOtherclass = newClassOtherclass;
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {}

}