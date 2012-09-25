/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.patterns.test;

public class ClassOne
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassOne Associations
  private ClassOtherclass classOtherclass;

  //Helper Variables
  private boolean canSetClassOtherclass;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ClassOne(ClassOtherclass aClassOtherclass)
  {
    canSetClassOtherclass = true;
    if (!setClassOtherclass(aClassOtherclass))
    {
      throw new RuntimeException("Unable to create ClassOne due to aClassOtherclass");
    }
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
    if (newClassOtherclass != null)
    {
      classOtherclass = newClassOtherclass;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {}

}