/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.umple;
import cruise.umple.compiler.*;
import cruise.umple.compiler.exceptions.*;

public class UmpleRunMain
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleRunMain()
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
  public static boolean displayOutput = true;
  
   public static void main(String[] args) 
   {
     console = "";
     
     if (args.length == 0)
     {
       println("Usage: java -jar umplerun.jar <umple_file> <cmd_file>\nExample: java -jar umple.jar airline.ump airline.cmd");
       return;
     }
     
     String filename = args[0];
     UmpleFile umpleFile = new UmpleFile(filename);
     UmpleModel model = new UmpleModel(umpleFile);
     
     try
     {
         print("Compiling "+ filename +"... ");
         model.run();
         println("success.");
     }
     catch(UmpleCompilerException e)
     {
         println("failed.");
         printerr(e.getMessage());
     }
     
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
   
   private static void print(String output)
   {
     console += output;
     if (displayOutput)
     {
       System.out.print(output);  
     }
     
   }
   
   private static void println(String output)
   {
     print(output + "\n");
   }

   private static void printerr(String err)
   {
     console += err;
     if (displayOutput)
     {
       System.err.print(err);
     }
   }
}