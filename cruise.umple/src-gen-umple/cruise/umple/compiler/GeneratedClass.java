/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.umple.compiler;

/**
 * Represents a class that is generated from an Umple class, such as a Java or Cpp class.
 */
public class GeneratedClass extends GeneratedElement
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GeneratedClass Associations
  private UmpleModel model;
  private UmpleClass uClass;
  private GeneratedClass parentClass;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GeneratedClass(UmpleModel aModel, UmpleClass aUClass)
  {
    super();
    if (!setModel(aModel))
    {
      throw new RuntimeException("Unable to create GeneratedClass due to aModel");
    }
    if (!setUClass(aUClass))
    {
      throw new RuntimeException("Unable to create GeneratedClass due to aUClass");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public UmpleModel getModel()
  {
    return model;
  }

  public UmpleClass getUClass()
  {
    return uClass;
  }

  public GeneratedClass getParentClass()
  {
    return parentClass;
  }

  public boolean setModel(UmpleModel newModel)
  {
    boolean wasSet = false;
    if (newModel != null)
    {
      model = newModel;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setUClass(UmpleClass newUClass)
  {
    boolean wasSet = false;
    if (newUClass != null)
    {
      uClass = newUClass;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setParentClass(GeneratedClass newParentClass)
  {
    boolean wasSet = false;
    parentClass = newParentClass;
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    model = null;
    uClass = null;
    parentClass = null;
    super.delete();
  }

}