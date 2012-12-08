/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.umple;
import cruise.umple.compiler.*;
import cruise.umple.compiler.exceptions.*;
import java.util.List;
import java.util.Arrays;
import joptsimple.*;
import java.io.IOException;

// line 14 "../../../src/Main_Code.ump"
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
  
  // line 24 ../../../src/Main_Code.ump
  public static String console;
    private static OptionParser optparser;

    public static void main(String[] args) 
    {

        console = "";

        OptionSet optset = optParse(args);
        if (preModelOptionProcess(optset)) {
            return;
        }

        List<String> nonOpt = optset.nonOptionArguments();

        if (nonOpt.isEmpty()) {
            println("Please specify <umple_file> to process");
            printUsage();
            return;
        }

        String filename = nonOpt.get(0);
        println(filename);
        UmpleFile umpleFile = new UmpleFile(filename);
        UmpleModel model = new UmpleModel(umpleFile);

        if (postModelOptionProcess(optset, model)) {
            return;
        }

        try
        {
            model.run();
        }
        catch(UmpleCompilerException e)
        {
            printerr(e.getMessage());
            if(!model.isShouldGenerate())
                System.exit(-1);
        }

        // Compile success means the output was generated
		boolean compileSuccess = model.getLastResult().getWasSuccess();

        // The "c" option causes an attempt to compile the resulting base language
        // code. Not completely tested at current time.
        if (compileSuccess && optset.has("c")) {
            CodeCompiler compiler = new CodeCompiler();
            compileSuccess = compiler.compile(model, (String)optset.valueOf("c"));
        }

        String successWord = compileSuccess ? "Success! " : "";
        println(successWord + "Processed "+ filename +".");

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
     * optionProcess: process the option arguments which does not require UmpleModel
     * Argument: optSet - set of the options and corresponding arguments
     * Return: boolean - If application should terminate immediately after return
     */
    private static boolean preModelOptionProcess(OptionSet optSet) {
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

    private static boolean postModelOptionProcess(OptionSet optset, UmpleModel model) {
        if (optset.has("generate")) {
            boolean override=false;
            String path = "";
            if (optset.has("override")) {
                override = true;
            }
            if (optset.has("path")) {
                path = (String)optset.valueOf("path");
            }
            String lang = (String)optset.valueOf("generate");
            GenerateTarget gt = new GenerateTarget(lang, path);
            gt.setOverrideAll(override);
            model.addGenerate(Arrays.asList(gt));
        }
        return false;
    }

    private static OptionSet optParse(String[] args)
    {
        optparser = new OptionParser();
        optparser.acceptsAll(Arrays.asList("version", "v"), "Print out the current Umple version number");
        optparser.acceptsAll(Arrays.asList("help"), "Display the help message");
        optparser.acceptsAll(Arrays.asList("g", "generate"), "Specify the output language: Java,Cpp,Php,Ruby,SQL,Ruby,Json,Ecore,TextUml,GvStateDiagram,Yuml").withRequiredArg().ofType(String.class);
        optparser.acceptsAll(Arrays.asList("override"), "If a output language <lang> is specified using option -g, ouptut will only generate language <lang>");
        optparser.acceptsAll(Arrays.asList("path"), "If a output language is specified using option -g, output source code will be placed to path").withRequiredArg().ofType(String.class);
        optparser.acceptsAll(Arrays.asList("c","compile"), "Indicate to the entry class to compile, or with argument - to compile all outputfiles").withRequiredArg().ofType(String.class);

        OptionSet optSet = null;

        try 
        {
            optSet = optparser.parse(args);
        } 
        catch (joptsimple.OptionException e) 
        {
            println("Option:" + e.getMessage());
            printUsage();
        }

        return optSet;
    }
}