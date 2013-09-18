/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;

/**
 * Represents a class that is generated from an Umple class, such as a Java or Cpp class.
 * @umplesource Umple.ump 637
 */
// line 637 "../../../../src/Umple.ump"
public class GeneratedClass extends GeneratedElement
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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

  public boolean setModel(UmpleModel aNewModel)
  {
    boolean wasSet = false;
    if (aNewModel != null)
    {
      model = aNewModel;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setUClass(UmpleClass aNewUClass)
  {
    boolean wasSet = false;
    if (aNewUClass != null)
    {
      uClass = aNewUClass;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setParentClass(GeneratedClass aNewParentClass)
  {
    boolean wasSet = false;
    parentClass = aNewParentClass;
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