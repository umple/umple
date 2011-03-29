/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.11.1.3376 modeling language!*/

package cruise.umple;
import cruise.umple.compiler.*;

public class UmpleConsoleMain
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleConsoleMain()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public static String console;
  
   public static void main(String[] args) 
   {
     console = "";
     
     if (args.length == 0)
     {
       println("Usage: java -jar umple.jar <umple_file>\nExample: java -jar umple.jar airline.ump");
       return;
     }
     
     String filename = args[0];
     UmpleFile umpleFile = new UmpleFile(filename);
     UmpleModel model = new UmpleModel(umpleFile);
     model.run();
     println("Success! Processed "+ filename +".");
     
//     Compiler compiler = new Compiler();
//     URL jarfile = compiler.compile(umpleFile.getPath());
//     
//     if (jarfile != null)
//     {
//       println("Success! Processed "+ filename +".");
//     }
//     else
//     {
//       println("Failure! Unable to process " + filename + ".");
//     }
   }
   
   private static void println(String output)
   {
     console += output + "\n";
     System.out.println(output);
   }
}