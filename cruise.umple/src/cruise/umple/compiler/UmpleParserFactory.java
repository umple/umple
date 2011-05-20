/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.0.352 modeling language!*/

package cruise.umple.compiler;

public class UmpleParserFactory
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleParserFactory()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public static UmpleParser create(String className) 
  {
    Object object = null;
    try 
    {
      Class<?> classDefinition = Class.forName(className);
      object = classDefinition.newInstance();
      return (UmpleParser)object;
    } 
    catch (Exception e) 
    { 
      return null;
    }
  }
  
  public static UmpleParser create(String umpleParserName, UmpleModel model)
  {
    return create(umpleParserName,model,false);
  }
  
  public static UmpleParser create(String umpleParserName, boolean failHardIfInvalid)
  {
    return create(umpleParserName,null,failHardIfInvalid);
  }
  
  public static UmpleParser create(String umpleParserName, UmpleModel model, boolean failHardIfInvalid)
  {
    UmpleParser p = create(umpleParserName);
    if (p == null && failHardIfInvalid)
    {
      org.junit.Assert.fail("Unknown parser " + umpleParserName);
    }
    if (model != null)
    {
      p.setModel(model);
    }
    return p;
  }
}