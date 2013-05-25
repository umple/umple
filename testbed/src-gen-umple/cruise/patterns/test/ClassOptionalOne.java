/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.patterns.test;

// line 67 "../../../../src/TestHarnessPatternsImmutable.ump"
public class ClassOptionalOne
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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

  private boolean setClassOtherclass(ClassOtherclass aNewClassOtherclass)
  {
    boolean wasSet = false;
    if (!canSetClassOtherclass) { return false; }
    canSetClassOtherclass = false;
    classOtherclass = aNewClassOtherclass;
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {}

}