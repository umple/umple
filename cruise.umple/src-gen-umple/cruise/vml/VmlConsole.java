/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.vml;
import java.io.*;
import cruise.umple.util.*;

/**
 * @umplesource Vml_Code.ump 15
 */
// line 15 "../../../src/Vml_Code.ump"
public class VmlConsole
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public VmlConsole()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 19 ../../../src/Vml_Code.ump
  public static String console = "";
  
  public static void main(String[] args) 
  {
    console = "";
     
    if (args.length < 2)
    {
      println("Usage: java -jar vml.jar <output_file> <input_files>\nExample: java -jar vml.jar myProgram.ump myBase.vml myInvoke.vml");
      return;
    }
     
    String outputFile = args[0];
    String[] inputFiles = new String[args.length - 1];
    for (int i=1; i<args.length; i++)
    {
      inputFiles[i-1] = args[i];
    }

    VmlParser parser = new VmlParser("vml");
    for(String filename : inputFiles)
    {
      File file = new File(filename);
      String input = SampleFileWriter.readContent(file);
      boolean answer = parser.parse("program",input).getWasSuccess();
      
      if (answer)
      {
        answer = parser.analyze().getWasSuccess();
      }
      
      if (!answer)
      {
        println("Unable to parser: ["+ file.getAbsolutePath() +"]");
      }
    }
    
    SampleFileWriter.createFile(outputFile,parser.getSystem().getCode());
    println("Successfully created ["+ outputFile +"]");
  }
   
  private static void println(String output)
  {
    console += output + "\n";
    System.out.println(output);
  }
}