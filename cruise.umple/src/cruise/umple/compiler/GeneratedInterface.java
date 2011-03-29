/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.11.1.3376 modeling language!*/

package cruise.umple.compiler;

public class GeneratedInterface extends GeneratedElement
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GeneratedInterface Attributes
  private String code;

  //GeneratedInterface Associations
  private UmpleModel model;
  private UmpleInterface uInterface;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GeneratedInterface(UmpleModel aModel, UmpleInterface aUInterface)
  {
    super();
    code = null;
    if (!setModel(aModel))
    {
      throw new RuntimeException("Unable to create GeneratedInterface due to aModel");
    }
    if (!setUInterface(aUInterface))
    {
      throw new RuntimeException("Unable to create GeneratedInterface due to aUInterface");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCode(String aCode)
  {
    boolean wasSet = false;
    code = aCode;
    wasSet = true;
    return wasSet;
  }

  public String getCode()
  {
    return code;
  }

  public UmpleModel getModel()
  {
    return model;
  }

  public UmpleInterface getUInterface()
  {
    return uInterface;
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

  public boolean setUInterface(UmpleInterface newUInterface)
  {
    boolean wasSet = false;
    if (newUInterface != null)
    {
      uInterface = newUInterface;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    model = null;
    uInterface = null;
    super.delete();
  }

}