/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.umple.docs;

public class DocumenterMain
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DocumenterMain()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  private static String console = "";
  
  public static void main(String[] args) 
  {
    console = "";
     
    if (args.length < 2)
    {
      println("Usage: java -jar umpledocs.jar <data_dir> <output_dir>\nExample: java -jar umple-docs.jar docs output");
      return;
    }
     
    String dataDirectory = args[0];
    String outputDirectory = args[1];
    Documenter doc = new Documenter(dataDirectory,outputDirectory);
    boolean didGenerate = doc.generate();
    
    if (didGenerate)
    {
      println("Success!");
    }
    for (String message : doc.getMessages())
    {
      println(message);
    }
  }
   
  private static void println(String output)
  {
    console += output + "\n";
    System.out.println(output);
  }
}