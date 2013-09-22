/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.patterns.test;

// line 55 "../../../../src/TestHarnessPatternsImmutable.ump"
public class ClassOne
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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

  private boolean setClassOtherclass(ClassOtherclass aNewClassOtherclass)
  {
    boolean wasSet = false;
    if (!canSetClassOtherclass) { return false; }
    canSetClassOtherclass = false;
    if (aNewClassOtherclass != null)
    {
      classOtherclass = aNewClassOtherclass;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {}

}