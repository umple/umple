/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple;
import cruise.umple.compiler.*;
import cruise.umple.compiler.exceptions.*;
import java.util.List;
import java.util.Arrays;
import joptsimple.*;
import java.io.IOException;
import java.io.*;

/**
 * Main program for the command line Umple compiler
 * Run java -jar umple.jar --help for details
 * Takes an umple file as an argument, which can in turn use (include) other
 * @umplesource Main_Code.ump 19
 */
// line 19 "../../../src/Main_Code.ump"
public class UmpleConsoleMain
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int line();String file();int javaline();int length();}

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
  // line 30 ../../../src/Main_Code.ump
  public static String console;
    private static OptionParser optparser;

  @umplesourcefile(line=33,file="Main_Code.ump",javaline=51,length=74)
    public static void main(String[] args) 
    {
    Thread.currentThread().setUncaughtExceptionHandler(new UmpleExceptionHandler());
    Thread.setDefaultUncaughtExceptionHandler(new UmpleExceptionHandler());

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
		//this loop is used to add command-based linked umple files and to show names of them.
		for (int i=1;i<nonOpt.size(); i++) {
			umpleFile.addLinkedFiles(nonOpt.get(i));
			println(nonOpt.get(i));
		}
		
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
          for (int i=0;i<nonOpt.size(); i++) {
			println(successWord + "Processed "+ nonOpt.get(i) +".");
		  }
		  if(compileSuccess)
		  {
		    return;
		  }
          System.exit(compileSuccess ? 0 : 1); 
        }
        catch(Exception ex) {
          System.err.println("Umple compiler error. Stack trace follows");
          cruise.umple.util.ExceptionDumper.dumpCompilerError(ex);
          System.exit(-1);
        }
        System.exit(0);
    }

  @umplesourcefile(line=106,file="Main_Code.ump",javaline=127,length=5)
    private static void println(String output)
    {
        console += output + "\n";
        System.out.println(output);
    }
  @umplesourcefile(line=111,file="Main_Code.ump",javaline=133,length=5)
    private static void printerr(String err)
    {
        console += err;
        System.err.print(err);
    }
  @umplesourcefile(line=116,file="Main_Code.ump",javaline=139,length=7)
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
  @umplesourcefile(line=128,file="Main_Code.ump",javaline=152,length=14)
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

  @umplesourcefile(line=143,file="Main_Code.ump",javaline=168,length=17)
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

  @umplesourcefile(line=161,file="Main_Code.ump",javaline=187,length=24)
    private static OptionSet optParse(String[] args)
    {
        optparser = new OptionParser();
        optparser.acceptsAll(Arrays.asList("version", "v"), "Print out the current Umple version number");
        optparser.acceptsAll(Arrays.asList("help"), "Display the help message");
        optparser.acceptsAll(Arrays.asList("g", "generate"), "Specify the output language: Java,Cpp,RTCpp,Php,Ruby,SQL,Ruby,Json,Ecore,TextUml,GvStateDiagram,GvClassDiagram,Yuml").withRequiredArg().ofType(String.class);
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

  public static class UmpleExceptionHandler implements Thread.UncaughtExceptionHandler
  {
    public void uncaughtException(Thread t, Throwable e)
    {
      java.util.List<StackTraceElement> result = new java.util.ArrayList<StackTraceElement>();
      StackTraceElement[] elements = e.getStackTrace();
      try
      {
        for(StackTraceElement element:elements)
        {
          Class clazz = Class.forName(element.getClassName());
          String methodName = element.getMethodName();
          boolean methodFound = false;
          for(java.lang.reflect.Method meth:clazz.getDeclaredMethods())
          {
            if(meth.getName().equals(methodName))
            {
              int line = -1;
              String file = "";
              for(java.lang.annotation.Annotation anno: meth.getAnnotations())
              {
                if(anno.annotationType().getSimpleName().equals("umplesourcefile"))
                {
                  int methodlength = (Integer)anno.annotationType().getMethod("length", new Class[]{}).invoke(anno,new Object[]{});
                  int distanceFromStart = (element.getLineNumber()-(Integer)anno.annotationType().getMethod("javaline", new Class[]{}).invoke(anno,new Object[]{}));
                  distanceFromStart-=("main".equals(methodName))?2:0;
                  line = (Integer)anno.annotationType().getMethod("line", new Class[]{}).invoke(anno,new Object[]{})+distanceFromStart;
                  file = (String)anno.annotationType().getMethod("file", new Class[]{}).invoke(anno,new Object[]{});
                  if(file == "")
                  {
                    break;
                  }
                  else if(distanceFromStart>=0&&distanceFromStart<=methodlength)
                  {
                    result.add(new StackTraceElement(element.getClassName(),element.getMethodName(),file,line));
                    methodFound = true;
                    break;
                  }
                }
              }
              if(methodFound)
              {
                break;
              }
            }
          }
          if(!methodFound)
          {
            result.add(element);
          }
        }
      }
      catch (Exception e1)
      {
        e1.printStackTrace();
      }
      e.setStackTrace(result.toArray(new StackTraceElement[0]));
      e.printStackTrace();
    }
  }
}