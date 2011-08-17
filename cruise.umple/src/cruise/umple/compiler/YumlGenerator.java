/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.605 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.util.*;

public class YumlGenerator implements CodeGenerator
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //YumlGenerator Attributes
  private UmpleModel model;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public YumlGenerator()
  {
    model = null;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setModel(UmpleModel aModel)
  {
    boolean wasSet = false;
    model = aModel;
    wasSet = true;
    return wasSet;
  }

  public UmpleModel getModel()
  {
    return model;
  }

  public void delete()
  {}

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public void generate()
  {
    StringBuilder yuml = new StringBuilder();
    for (UmpleClass aClass : model.getUmpleClasses())
    {
      yuml.append("[");
      yuml.append(aClass.getName());
      if (aClass.numberOfAttributes() > 0)
      {
        yuml.append("|");
        for (Attribute aVar : aClass.getAttributes())
        {
          if (aVar.getType() == null)
          {
            yuml.append(StringFormatter.format("{0};",aVar.getName(),aVar.getType()));  
            
          }
          else
          {
            yuml.append(StringFormatter.format("{0}:{1};",aVar.getName(),aVar.getType()));  
          }
        }
      }
      yuml.append("],");
       
      if (aClass.getExtendsClass() != null)
      {
        UmpleClass parent = aClass.getExtendsClass();
        yuml.append(StringFormatter.format("[{0}]^-[{1}],",parent.getName(),aClass.getName()));
      }
      
    }
    
    for (Association aAssoc : model.getAssociations())
    {
      UmpleClass c1 = model.getUmpleClass(aAssoc.getEnd(0).getClassName());
      UmpleClass c2 = model.getUmpleClass(aAssoc.getEnd(1).getClassName());
      String mult1 = aAssoc.getEnd(0).toSimpleString();
      String mult2 = aAssoc.getEnd(1).toSimpleString();
      
      String direction = "-";
      if (aAssoc.getIsLeftNavigable() && !aAssoc.getIsRightNavigable())
      {
        direction = "<-";
      }
      else if (!aAssoc.getIsLeftNavigable() && aAssoc.getIsRightNavigable())
      {
        direction = "->";
      }
      yuml.append(StringFormatter.format("[{0}]{2}{4}{3}[{1}],",c1.getName(),c2.getName(),mult1,mult2,direction));
    }
    
    model.setCode(yuml.toString());
  }
}