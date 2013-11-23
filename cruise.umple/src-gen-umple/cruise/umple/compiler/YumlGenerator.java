/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.util.*;
import cruise.umple.util.*;

/**
 * @umplesource Generator.ump 177
 * @umplesource Generator_CodeYuml.ump 11
 */
// line 177 "../../../../src/Generator.ump"
// line 11 "../../../../src/Generator_CodeYuml.ump"
public class YumlGenerator implements CodeGenerator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //YumlGenerator Attributes
  private UmpleModel model;
  private String outputPath;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public YumlGenerator()
  {
    model = null;
    outputPath = "";
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

  public boolean setOutputPath(String aOutputPath)
  {
    boolean wasSet = false;
    outputPath = aOutputPath;
    wasSet = true;
    return wasSet;
  }

  /**
   * Contains various aspects from an Umple file (.ump), such as classes, attributes, associations and methods.  Generated output is based
   * off of what's contained in here.
   */
  public UmpleModel getModel()
  {
    return model;
  }

  public String getOutputPath()
  {
    return outputPath;
  }

  public void delete()
  {}

  @umplesourcefile(line={17},file={"Generator_CodeYuml.ump"},javaline={76},length={83})
   public void generate(){
    StringBuilder yuml = new StringBuilder();
    for (UmpleInterface uInterface: model.getUmpleInterfaces()) {
    	yuml.append("[<<");
    	//there is a known bug that yUML interface cannot take attributes
        yuml.append(uInterface.getName());
        yuml.append(">>],");
	}
	
    for (UmpleClass aClass : model.getUmpleClasses())
    {
      yuml.append("[");
      yuml.append(aClass.getName());
      if (aClass.numberOfAttributes() > 0)
      {
        yuml.append("|");
        for (Attribute aVar : aClass.getAttributes())
        {
          String modifier = aVar.getModifier();
          String name = aVar.getName();
          String type = aVar.getType();
          if (modifier.equals("settable"))
        	  name = "+"+name;
          else if (modifier.equals("internal"))
        	  name = "-"+name;
          if (aVar.getType() == null)
            yuml.append(StringFormatter.format("{0};", name, type));  
          else
            yuml.append(StringFormatter.format("{0}:{1};", name, type));  
        }
      }
      if (aClass.numberOfMethods() > 0)
      {
    	yuml.append("|");
    	for (Method method : aClass.getMethods()) {
          String methodModifier = method.getModifier();
    	  String methodName = method.getName();
    	  methodName = methodModifier.contains("private")?"-"+methodName:"+"+methodName;
    	  yuml.append(StringFormatter.format("{0}();", methodName));
    	}
      }
      yuml.append("],");

      if (aClass.getExtendsClass() != null)
      {
        UmpleClass parent = aClass.getExtendsClass();
        yuml.append(StringFormatter.format("[{0}]^-[{1}],",parent.getName(),aClass.getName()));
      }
      for (UmpleInterface uInterface : aClass.getParentInterface()) {
        yuml.append(StringFormatter.format("[<<{0}>>]^-.-[{1}],",uInterface.getName(),aClass.getName()));
      }
    }

    for (Association aAssoc : model.getAssociations())
    {
      UmpleClass c1 = model.getUmpleClass(aAssoc.getEnd(0).getClassName());
      UmpleClass c2 = model.getUmpleClass(aAssoc.getEnd(1).getClassName());
      String mult1 = aAssoc.getEnd(0).toSimpleString();
      String mult2 = aAssoc.getEnd(1).toSimpleString();
      List<AssociationEnd> assocEnds= aAssoc.getEnds();
      AssociationEnd roleName1= new AssociationEnd(null,null,null,null, null);
      AssociationEnd roleName2= new AssociationEnd(null,null,null,null, null);

      if(!assocEnds.isEmpty())
      {  
        roleName1 = assocEnds.get(0);
        roleName2 = assocEnds.get(1);
      }

      String direction = "-";
      if (aAssoc.getIsLeftNavigable() && !aAssoc.getIsRightNavigable())
      {
        direction = "<-";
      }
      else if (!aAssoc.getIsLeftNavigable() && aAssoc.getIsRightNavigable())
      {
        direction = "->";
      }
      yuml.append(StringFormatter.format("[{0}]{5}{2}{4}{6}{3}[{1}],",c1.getName(),c2.getName(),mult1,mult2,direction,roleName1.getRoleName()+" ",roleName2.getRoleName()+" "));
    }

    model.setCode(yuml.toString());
  }


  /**
   * Allows independent code generation tools
   * Different generators will do different things regarding where the files are put, etc.
   */
  @umplesourcefile(line={21},file={"Generator.ump"},javaline={160},length={2})
  @Override
  public boolean setOutput(String aString){
          return false;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "outputPath" + ":" + getOutputPath()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "model" + "=" + (getModel() != null ? !getModel().equals(this)  ? getModel().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}