/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import java.io.*;
import java.util.*;
import cruise.umple.util.*;
import cruise.umple.compiler.exceptions.*;

/**
 * @umplesource Generator.ump 149
 * @umplesource Generator_CodeSimpleMetrics.ump 17
 */
// line 149 "../../../../src/Generator.ump"
// line 17 "../../../../src/Generator_CodeSimpleMetrics.ump"
public class SimpleMetricsGenerator implements CodeGenerator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SimpleMetricsGenerator Attributes
  private UmpleModel model;
  private String output;
  private StringBuilder code;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SimpleMetricsGenerator()
  {
    model = null;
    output = "";
    code = new StringBuilder();
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

  public boolean setCode(StringBuilder aCode)
  {
    boolean wasSet = false;
    code = aCode;
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

  public StringBuilder getCode()
  {
    return code;
  }

  public void delete()
  {}

  @umplesourcefile(line={23},file={"Generator_CodeSimpleMetrics.ump"},javaline={93},length={26})
   public void generate(){
    // Output basic file header
    code.append("      M E T R I C S    G E N E R A T E D    B Y    U M P L E    F R O M   <"+model.getUmpleFile().getSimpleFileName()+".ump>\n\n");
  
	// GET DATA ABOUT LINES (CODE, BLANKS, COMMENTS)
  	CodeMetrics codemetrics = new CodeMetrics();
  	codemetrics.setModel(model);
  	codemetrics.setCode(code);
    codemetrics.calculate(); 
  	
  	// GET DATA FROM CLASSES
  	ClassMetrics classmetrics = new ClassMetrics();
  	classmetrics.setModel(model);
  	classmetrics.setCode(codemetrics.getCode());
    classmetrics.calculate(); 
    
    // GET DATA FROM STATE MACHINES
  	StateMachineMetrics SMMeasure = new StateMachineMetrics();  	
  	SMMeasure.setModel(model);
  	SMMeasure.setCode(classmetrics.getCode());
  	SMMeasure.calculate();
  	
  	model.setCode(code.toString());
    writeModel();
    return;
  }


  /**
   * Output the metrics to a file
   */
  @umplesourcefile(line={52},file={"Generator_CodeSimpleMetrics.ump"},javaline={121},length={17})
  public void writeModel(){
    try
    {
      String path = model.getUmpleFile().getPath();
      File file = new File(path);
      file.mkdirs();
      String modelFilename = path + File.separator + model.getUmpleFile().getSimpleFileName() + ".metrics";
      BufferedWriter bw = new BufferedWriter(new FileWriter(modelFilename));
      bw.write(model.getCode());
      bw.flush();
      bw.close();
    }
    catch (Exception e)
    {
      throw new UmpleCompilerException("There was a problem with generating simple metrics." + e, e);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "output" + ":" + getOutput()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "model" + "=" + (getModel() != null ? !getModel().equals(this)  ? getModel().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "code" + "=" + (getCode() != null ? !getCode().equals(this)  ? getCode().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}