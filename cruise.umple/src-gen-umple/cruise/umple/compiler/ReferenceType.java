/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;

/**
 * NOT used right now
 * @umplesource Umple.ump 218
 */
// line 218 "../../../../src/Umple.ump"
public class ReferenceType extends Type
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ReferenceType Associations
  private UmpleClass umpleClass;
  private UmpleInterface umpleInterface;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ReferenceType()
  {
    super();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public UmpleClass getUmpleClass()
  {
    return umpleClass;
  }

  public UmpleInterface getUmpleInterface()
  {
    return umpleInterface;
  }

  public boolean setUmpleClass(UmpleClass aNewUmpleClass)
  {
    boolean wasSet = false;
    umpleClass = aNewUmpleClass;
    wasSet = true;
    return wasSet;
  }

  public boolean setUmpleInterface(UmpleInterface aNewUmpleInterface)
  {
    boolean wasSet = false;
    umpleInterface = aNewUmpleInterface;
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    umpleClass = null;
    umpleInterface = null;
    super.delete();
  }

}