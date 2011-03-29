/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.11.1.3376 modeling language!*/

package cruise.umple.compiler;

public class ReferenceType extends Type
{

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

  public boolean setUmpleClass(UmpleClass newUmpleClass)
  {
    boolean wasSet = false;
    umpleClass = newUmpleClass;
    wasSet = true;
    return wasSet;
  }

  public boolean setUmpleInterface(UmpleInterface newUmpleInterface)
  {
    boolean wasSet = false;
    umpleInterface = newUmpleInterface;
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