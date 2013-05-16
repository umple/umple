/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple;
import cruise.umple.compiler.*;
import cruise.umple.compiler.exceptions.*;
import cruise.umple.builder.*;
import cruise.umple.util.*;
import java.net.*;
import java.io.*;

/**
 * Main program for a jar that can inject calls to Umple at runtime
 * @umplesource Main_Code.ump 190
 */
// line 190 "../../../src/Main_Code.ump"
public class UmpleRunMain
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int line();String file();int javaline();int length();}

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
  // line 200 ../../../src/Main_Code.ump
  public static String console;
    public static boolean displayOutput = true;

  @umplesourcefile(line=203,file="Main_Code.ump",javaline=48,length=75)
    public static void main(String[] args) 
    {
    Thread.currentThread().setUncaughtExceptionHandler(new UmpleExceptionHandler());
    Thread.setDefaultUncaughtExceptionHandler(new UmpleExceptionHandler());
        console = "";

        if (args.length < 2)
        {
            println("Usage: java -jar umplerun.jar <umple_file> <cmd_file>\nExample: java -jar umple.jar airline.ump airline.cmd");
            return;
        }

        String filename = args[0];
        String cmdFilename = args[1];
        UmpleFile umpleFile = new UmpleFile(filename);
        UmpleModel model = new UmpleModel(umpleFile);
        boolean shouldDebug = args.length >= 3 && args[2].equals("--debug");
        boolean shouldCompile = !shouldDebug;

        try
        {
            if (shouldCompile)
            {
                print("Compiling "+ filename +"... ");
                model.run();
                println("success.");
            }
            else
            {
                print("Skipping compilation, entering debug mode");
            }

            print("Building model... ");
            Builder b = new Builder();
            URL jarfile = b.compile(".",umpleFile.getSimpleFileName() + ".jar",umpleFile.getSimpleFileName(),"1.6");

            if (jarfile == null)
            {
                println("failed");
                return;
            }
            println("success.");

            print("Loading model into memory... ");
            URL urls [] = { jarfile };
            URLClassLoader cl = new URLClassLoader(urls);
            println("success.");

            Command cmd = new Command(cl);

            println("Running commands:");
            boolean isFirst = true;
            for (String input : SampleFileWriter.readContent(new File(cmdFilename)).split("\n")) 
            {
                if (isFirst)
                {
                    cmd.addAttributes(input);
                    isFirst = false;
                    continue;
                }
                cmd.exec(input);
                for(String message : cmd.popMessages())
                {
                    println("  " + message);
                }
            }

            println("Done.");
        }
        catch(Exception e)
        {
            println("failed.");
            printerr(e.getMessage());
        }
    }

  @umplesourcefile(line=277,file="Main_Code.ump",javaline=125,length=9)
    private static void print(String output)
    {
        console += output;
        if (displayOutput)
        {
            System.out.print(output);  
        }

    }

  @umplesourcefile(line=287,file="Main_Code.ump",javaline=136,length=4)
    private static void println(String output)
    {
        print(output + "\n");
    }

  @umplesourcefile(line=292,file="Main_Code.ump",javaline=142,length=8)
    private static void printerr(String err)
    {
        console += err;
        if (displayOutput)
        {
            System.err.print(err);
        }
    }

  public static class UmpleExceptionHandler implements Thread.UncaughtExceptionHandler
  {
    public void uncaughtException(Thread t, Throwable e)
    {
      translate(e);
      if(e.getCause()!=null)
      {
        translate(e.getCause());
      }
      e.printStackTrace();
    }
    public void translate(Throwable e)
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
    }
  }
}