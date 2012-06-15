/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.umple.compiler;
import java.io.*;
import java.util.*;
import cruise.umple.util.*;
import cruise.umple.compiler.exceptions.*;

public class SimulateGenerator implements CodeGenerator
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SimulateGenerator Attributes
  private UmpleModel model;
  private String output;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SimulateGenerator()
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
  
  public void generate()
  {
    StringBuilder code = new StringBuilder();

    code.append("<?php\n");
    code.append("$modelOverview = new ModelOverview();\n");
    for (UmpleClass uClass : model.getUmpleClasses())
    {
      code.append(StringFormatter.format("$aClass = new ClassOverview(\"{0}\",$modelOverview);\n",uClass.getName()));
      for(Attribute av : uClass.getAttributes())
      {
        String typeName = av.getType() == null ? "String" : av.getType();
        String isList = av.getIsList() ? "true" : "false";
        code.append(StringFormatter.format("new Attribute(\"{0}\",\"{1}\",{2},$aClass);\n",typeName,av.getName(),isList));
      }

      ArrayList<Association> internalAssociations = new ArrayList<Association>();
      for(Association as : uClass.getAssociations())
      {
        AssociationEnd myEnd = as.getEnd(0);
        AssociationEnd theirEnd = as.getEnd(1);

        if (internalAssociations.contains(as))
        {
          continue;
        }

        if (myEnd.getClassName().equals(theirEnd.getClassName()))
        {
          internalAssociations.add(as);
          code.append(StringFormatter.format("new AssociationEnd({0},{1},\"{2}\",\"{3}\",$aClass);\n",myEnd.getMultiplicity().getLowerBound(),myEnd.getMultiplicity().getUpperBound(),myEnd.getClassName(),myEnd.getRoleName()));
          code.append(StringFormatter.format("new AssociationEnd({0},{1},\"{2}\",\"{3}\",$aClass);\n",theirEnd.getMultiplicity().getLowerBound(),theirEnd.getMultiplicity().getUpperBound(),theirEnd.getClassName(),theirEnd.getRoleName()));
        }
        else
        {
          if (theirEnd.getClassName().equals(uClass.getName()))
          {
            myEnd = as.getEnd(1);
            theirEnd = as.getEnd(0);
          }
          code.append(StringFormatter.format("new AssociationEnd({0},{1},\"{2}\",\"{3}\",$aClass);\n",theirEnd.getMultiplicity().getLowerBound(),theirEnd.getMultiplicity().getUpperBound(),theirEnd.getClassName(),theirEnd.getRoleName()));
        }
      }

      for (StateMachine sm : uClass.getStateMachines())
      {
        code.append(StringFormatter.format("$aStateMachine = new StateMachine(\"{0}\",$aClass);\n",StringFormatter.toPascalCase(sm.getName())));
        for (Event e : sm.getEvents())
        {
          code.append(StringFormatter.format("$aStateMachine->addEvent(\"{0}\");\n",e.getName())); 
        }
      }
    }

    /*    
          if (model.numberOfUmpleClasses() > 0 && model.getUmpleClass(0).numberOfStateMachines() > 0)
          {
          UmpleClass uClass = model.getUmpleClass(0);
          StateMachine machine = uClass.getStateMachine(0);
          code.append("<?php\n");
          code.append(StringFormatter.format("$model = retrieveModel('inputModel',new {0}());\n",uClass.getName()));
          code.append(StringFormatter.format("$stateMachineName = '{0}';\n",StringFormatter.toPascalCase(machine.getName())));

          boolean isFirst = true;
          code.append("$allEventNames = array(");
          for (Event e : machine.getEvents())
          {
          if (!isFirst)
          {
          code.append(",");
          }
          isFirst = false;
          code.append(StringFormatter.format("'{0}'",e.getName()));
          }
          code.append(");\n");
          }
     */

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

      BufferedWriter bw = new BufferedWriter(new FileWriter(path + File.separator + "model.php"));
      bw.write(model.getCode());
      bw.flush();
      bw.close();
    }
    catch (Exception e)
    {
      throw new UmpleCompilerException("There was a problem with generating simulate code." + e, e);
    }
  }
}