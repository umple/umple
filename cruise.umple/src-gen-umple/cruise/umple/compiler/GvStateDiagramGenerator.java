/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import java.io.*;
import java.util.*;
import cruise.umple.util.*;
import cruise.umple.compiler.exceptions.*;

// line 96 "../../../../src/Generator.ump"
// line 804 "../../../../src/Generator_Code.ump"
public class GvStateDiagramGenerator implements CodeGenerator
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GvStateDiagramGenerator Attributes
  private UmpleModel model;
  private String output;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GvStateDiagramGenerator()
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
  
  // line 807 ../../../../src/Generator_Code.ump
  public void generate()
  {
    StringBuilder code = new StringBuilder();
    Boolean isFirstState = true;

    code.append("digraph state {\n");
    code.append("    compound = true;\n");
    code.append("    size=\"10,10\"\n");
    code.append("    node [shape = point, fillcolor=\"black\", width=0.2 ]; start\n");
    code.append("    node [shape = rectangle, width=1,style=rounded];\n");

    for (UmpleClass uClass : model.getUmpleClasses())
    {
      for (StateMachine sm : uClass.getStateMachines())
      {
        for (State s : sm.getStates())
        {
          code.append("\n");
          if(isFirstState) {
            isFirstState = false;
            code.append("    start -> "+s.getName()+"\n");
          }
          for (Transition t : s.getNextTransition()) {
            code.append("    "+t.getFromState().getName() +" -> "+t.getNextState().getName()+" [ label = \""+t.getEvent().getName()+"\" ];\n");
          }
        }
      }
    }

    code.append("}\n");

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
      String modelFilename = path + File.separator + model.getUmpleFile().getSimpleFileName() + ".gv";
      BufferedWriter bw = new BufferedWriter(new FileWriter(modelFilename));
      bw.write(model.getCode());
      bw.flush();
      bw.close();
    }
    catch (Exception e)
    {
      throw new UmpleCompilerException("There was a problem with generating GraphVis State Machine code." + e, e);
    }
  }
}