/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple;
import cruise.umple.compiler.*;
import cruise.umple.compiler.exceptions.*;
import java.util.List;
import java.util.Arrays;
import joptsimple.*;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;
import java.util.regex.*;

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
  
  // line 27 ../../../src/Main_Code.ump
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

        try {
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
        catch(Exception ex) {
          System.err.println("Umple compiler error. Stack trace follows");
          
          String generatedSourcePath = System.getenv("GeneratedSourcePath");
          if (generatedSourcePath == null) {
            System.err.println("To locate the error in the original Umple source, set GeneratedSourcePath to where the generated Java is located:\ne.g. setenv GeneratedSourcePath ~/umple/cruise.umple/src-gen-umple");
          }
          else {
            System.err.println("Using GeneratedSourcePath="+generatedSourcePath);
          }
          System.err.println("Exception "+ex.getClass().getName()+" in");
          StackTraceElement [] st = ex.getStackTrace();
          StackTraceElement ust = null;
          for (int i=0;i<st.length;i++) {
            System.err.println(st[i].toString());
            if(generatedSourcePath != null) {
              ust = javaToUmpleStackTrace(st[i], generatedSourcePath);
              if(ust != null) {
                System.err.println("   => "+ust.getFileName()+":"+ust.getLineNumber());
              }
            }
          }

          System.exit(-1);
        }
        System.exit(0);
    }

    // Translate the java stack trace line information into the corresponding Umple line
    public static StackTraceElement javaToUmpleStackTrace(StackTraceElement javaStack, String generatedSourcePath) {
      StackTraceElement newSt;
      String javaFileName = javaStack.getFileName();
      String umpleFileName="Did not find line = information in Java code";
      int javaLineNumber = javaStack.getLineNumber();;
      int umpleLineNumber=1000000; // Dummy so errors can be noticed
      String fullClassPath = javaStack.getClassName();
      
      // TODO -- need to test on Windows
      
      // Walk up the class name packages to find the Java file
      String fileToScan=generatedSourcePath;
      String dirs[] = fullClassPath.split("\\.",-1);
      int walks = 0; // Depth of tree we will walk
      for (int d=0; d<dirs.length; d++) {
        String trialFile = fileToScan+System.getProperty("file.separator")+dirs[d];
        File f = new File(trialFile);
        if(!f.isDirectory()) {
          break; // We have gone too far
        }
        fileToScan = trialFile;
        walks++;
      }
      
      // At this point fileToScan is either invalid or contains the directory of the
      // file we need 
      fileToScan=fileToScan+System.getProperty("file.separator")+javaFileName;
      
      // System.err.println("!!"+fileToScan); //debug

      // We have hopefully found the file, now open it
      Scanner sc;
      try {
        sc = new Scanner(new BufferedReader(new FileReader(fileToScan)));
      }
      catch (FileNotFoundException fne) {
        return null;
      }

      String foundLine;
      Pattern linePattern = Pattern.compile(".*line ([0-9]+) (.*)");
      MatchResult result;
      
      for (int lineNum=1; sc.hasNextLine(); lineNum++) {
        foundLine = sc.nextLine();
        
        // if foundLine is a line directive reset the line directive counter
        Matcher m = linePattern.matcher(foundLine);
        if(m.matches()) {
          umpleFileName = m.group(2);
          umpleLineNumber = Integer.parseInt(m.group(1))-1;
        }
        else {
          umpleLineNumber++;
        }

        if(lineNum == javaLineNumber) {
          break;         
        }
      }
      
      // If umpleFileName has leading "../" remove as many of them as there were 
      // levels that we walked up
      String prefix = ".."+System.getProperty("file.separator");
      for(int w=0; w<walks; w++) {
        if(umpleFileName.startsWith(prefix)) {
          umpleFileName = umpleFileName.substring(3,umpleFileName.length());
        }
      }
            
      return new StackTraceElement(javaStack.getClassName(),  javaStack.getMethodName(), umpleFileName, umpleLineNumber);
     
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