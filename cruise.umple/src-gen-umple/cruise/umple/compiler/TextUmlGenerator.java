/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import java.io.*;
import java.util.*;
import cruise.umple.util.*;
import cruise.umple.compiler.exceptions.*;

// line 82 "../../../../src/Generator.ump"
// line 663 "../../../../src/Generator_Code.ump"
public class TextUmlGenerator implements CodeGenerator
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TextUmlGenerator Attributes
  private UmpleModel model;
  private String output;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TextUmlGenerator()
  {
    model = null;
    output = "";
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

  public boolean setOutput(String aOutput)
  {
    boolean wasSet = false;
    output = aOutput;
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

  public String getOutput()
  {
    return output;
  }

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 666 ../../../../src/Generator_Code.ump
  public void generate()
  {
    StringBuilder code = new StringBuilder();
    StringBuilder subCode;
    ArrayList<Association> allAssociations = new ArrayList<Association>();

    boolean isFirst = true;
    for (UmpleClass uClass : model.getUmpleClasses())
    {
      subCode =  new StringBuilder();
      if (isFirst)
      {
        isFirst = false;
        code.append(StringFormatter.format("package {0};\n",uClass.getPackageName()));
        code.append(StringFormatter.format("  import {0}::dataType;\n",uClass.getPackageName()));

        code.append("  package dataType;\n");
        code.append("    primitive String;\n");
        code.append("    primitive Integer;\n");
        code.append("    primitive Double;\n");
        code.append("    primitive Date;\n");
        code.append("    primitive Time;\n");
        code.append("    primitive Boolean;\n");
        code.append("  end;\n\n");
      }

      String classDeclaration = "class ";
      classDeclaration += uClass.getName();
      if (uClass.getExtendsClass() != null)
      {
        classDeclaration += StringFormatter.format(" specializes {0}",uClass.getExtendsClass().getName());
      }
      String implementedInterfaces="";
      if (uClass.hasParentInterface()){
        for (UmpleInterface uInterface : uClass.getParentInterface())
        {
          implementedInterfaces += uInterface.getName() + "," ; 
        }
        implementedInterfaces = implementedInterfaces.substring(0, implementedInterfaces.length()-1);	
        classDeclaration += StringFormatter.format(" implements {0}",implementedInterfaces);
      }
      code.append(StringFormatter.format("  {0}\n",classDeclaration));
      for(Attribute av : uClass.getAttributes())
      {
        String typeName = av.getType() == null ? "String" : av.getType();
        code.append(StringFormatter.format("    attribute {1} : {0};\n",typeName,av.getName()));
      }

      for(Association as : uClass.getAssociations())
      {
        if (allAssociations.contains(as))
        {
          continue;
        }
        allAssociations.add(as);
        AssociationEnd left = as.getEnd(0);
        AssociationEnd right = as.getEnd(1);

        String assocName = as.getName() == null ? "" : StringFormatter.format(" {0}",as.getName());
        subCode.append(StringFormatter.format("  association{0}\n",assocName));
        subCode.append(StringFormatter.format("    navigable role {0} : {1}{2};\n",left.getRoleName(),left.getClassName(),left.getMultiplicity().getRange()));
        subCode.append(StringFormatter.format("    navigable role {0} : {1}{2};\n",right.getRoleName(),right.getClassName(),right.getMultiplicity().getRange()));
        subCode.append("  end;\n\n");
      }

      for (StateMachine sm : uClass.getStateMachines())
      {
        if ("Simple".equals(sm.getType()))
        {
          String enumerationName = StringFormatter.toPascalCase(sm.getName());
          code.append(StringFormatter.format("    attribute {0} : {1};\n",sm.getName(),enumerationName));
          subCode.append(StringFormatter.format("  enumeration {0}\n",enumerationName));
          boolean isFirstEvent = true;
          for (State s : sm.getStates())
          {
            if (isFirstEvent)
            {
              subCode.append("    ");
            }
            else
            {
              subCode.append(", ");
            }
            isFirstEvent = false;
            subCode.append(StringFormatter.format("{0}",s.getName())); 
          }
          subCode.append("\n  end;\n\n");
        }
      }     

      code.append("  end;\n\n");
      code.append(subCode.toString());
    }

    boolean isFirstInterface = model.hasUmpleInterfaces() ? true : false;
    for (UmpleInterface uInterface : model.getUmpleInterfaces())
    {
      subCode =  new StringBuilder();
      if (isFirstInterface)
      {
        isFirstInterface = false;
        String interfaceDeclaration = "interface ";
        interfaceDeclaration += uInterface.getName();
        subCode.append(StringFormatter.format("  {0}\n",interfaceDeclaration));
        subCode.append("  end;\n\n");
      }
      code.append(subCode.toString());
    }

    if (!isFirst && !isFirstInterface)
    {
      code.append("end.\n");
    }

    model.setCode(code.toString());
    writeModel();
  }

  private void writeModel()
  {
    try
    {
      String path = model.getUmpleFile().getPath();
      File file = new File(path);
      file.mkdirs();
      String modelFilename = path + File.separator + model.getUmpleFile().getSimpleFileName() + ".tuml";
      BufferedWriter bw = new BufferedWriter(new FileWriter(modelFilename));
      bw.write(model.getCode());
      bw.flush();
      bw.close();
    }
    catch (Exception e)
    {
      throw new UmpleCompilerException("There was a problem with generating TextUml code." + e, e);
    }
  }
}