/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.umple;
import cruise.umple.compiler.*;
import cruise.umple.compiler.exceptions.*;
import java.util.List;
import java.util.Arrays;
import joptsimple.*;
import java.io.IOException;

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
  private static OptionParser optparser;
  
   public static void main(String[] args) 
   {
     
     console = "";

     OptionSet optset = optParse(args);
     if (optionProcess(optset)) {
         return;
     }

     List<String> nonOpt = optset.nonOptionArguments();

     if (nonOpt.isEmpty()) {
         println("Please specify <umple_file> for process");
         printUsage();
         return;
     }
     
     String filename = nonOpt.get(0);
     println(filename);
     UmpleFile umpleFile = new UmpleFile(filename);
     UmpleModel model = new UmpleModel(umpleFile);

     if (optset.has("generate")) {
         String lang = (String)optset.valueOf("generate");
         model.addGenerate(lang);
     }

     try
     {
    	 model.run();
    	 println("Success! Processed "+ filename +".");
     }
     catch(UmpleCompilerException e)
     {
    	 printerr(e.getMessage());
    	 if(!model.isShouldGenerate())
    		 System.exit(-1);
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
   
   private static void println(String output)
   {
     console += output + "\n";
     System.out.println(output);
   }
   private static void printerr(String err)
   {
   	console += err;
   	System.err.print(err);
   }
   private static void printUsage() {
       println("Usage: java -jar umple.jar [options] <umple_file>\nExample: java -jar umple.jar airline.ump");
       try{
           optparser.printHelpOn(System.out);
       } catch (IOException e) {
       }
   }
   /**
    * optionProcess: process the option arguments
    * Argument: optSet - set of the options and corresponding arguments
    * Return: boolean - If application should terminate immediately after return
    */
   private static boolean optionProcess(OptionSet optSet) {
       if (optSet == null) {
           return true;
       }
       if (optSet.has("version")) {
           println("Version: " + UmpleModel.versionNumber);
           return true;
       }
       if (optSet.has("help")) {
           printUsage();
           return true;
       }
       return false;
   }

   private static OptionSet optParse(String[] args)
   {
       optparser = new OptionParser();
       optparser.acceptsAll(Arrays.asList("version", "v"), "Print out the current Umple version number");
       optparser.acceptsAll(Arrays.asList("help"), "Display the help message");
       optparser.acceptsAll(Arrays.asList("g", "generate"), "Specify the output language").withRequiredArg().ofType(String.class);

       OptionSet optSet = null;
       try {
           optSet = optparser.parse(args);
       } catch (joptsimple.OptionException e) {
           println("Option:" + e.getMessage());
           printUsage();
       }
       return optSet;
   }
}