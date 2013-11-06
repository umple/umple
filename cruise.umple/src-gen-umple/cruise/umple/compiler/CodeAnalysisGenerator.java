/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.io.*;
import java.util.*;
import cruise.umple.util.*;
import cruise.umple.compiler.exceptions.*;

/**
 * @umplesource Generator.ump 121
 * @umplesource Generator_CodeAnalysis.ump 20
 */
// line 121 "../../../../src/Generator.ump"
// line 20 "../../../../src/Generator_CodeAnalysis.ump"
public class CodeAnalysisGenerator implements CodeGenerator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CodeAnalysisGenerator Attributes
  private UmpleModel model;
  private String output;
  private HtmlDocument doc;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CodeAnalysisGenerator()
  {
    model = null;
    output = "";
    doc = new HtmlDocument(true);
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

  public boolean setDoc(HtmlDocument aDoc)
  {
    boolean wasSet = false;
    doc = aDoc;
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

  public HtmlDocument getDoc()
  {
    return doc;
  }

  public void delete()
  {}

  @umplesourcefile(line={26},file={"Generator_CodeAnalysis.ump"},javaline={93},length={11})
  public void generate(){
    doc.createParagraphElement("Code Analysis from "+model.getUmpleFile().getSimpleFileName()+".ump", false);
    UmpleModelWalker walker = new UmpleModelWalker(model);
    walker.accept( new LLOCMetricVisitor(doc)); // LLOC Metrics
    walker.accept( new McCabeMetricVisitor(doc));  // McCabe Metrics
    walker.accept( new ClassStatsVisitor(doc));  // Class Stats Stats
    walker.accept( new StateMachineStatsVisitor(doc));  // Class StateMachines Stats
	model.setCode(doc.toString());
    writeModel();
    return;
  }


  /**
   * Output the metrics to a file
   */
  @umplesourcefile(line={40},file={"Generator_CodeAnalysis.ump"},javaline={106},length={17})
  public void writeModel(){
    try
    {
      String path = model.getUmpleFile().getPath();
      File file = new File(path);
      file.mkdirs();
      String modelFilename = path + File.separator + model.getUmpleFile().getSimpleFileName() + ".html";
      BufferedWriter bw = new BufferedWriter(new FileWriter(modelFilename));
      bw.write(model.getCode());
      bw.flush();
      bw.close();
    }
    catch (Exception e)
    {
      throw new UmpleCompilerException("Code Analysis Exception: " + e, e);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "output" + ":" + getOutput()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "model" + "=" + (getModel() != null ? !getModel().equals(this)  ? getModel().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "doc" + "=" + (getDoc() != null ? !getDoc().equals(this)  ? getDoc().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}