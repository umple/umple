/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.vml;
import java.io.*;
import cruise.umple.util.*;

/**
 * @umplesource Vml_Code.ump 14
 */
// line 14 "../../../src/Vml_Code.ump"
public class VmlConsole
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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

  @umplesourcefile(line={21},file={"Vml_Code.ump"},javaline={36},length={37})
   public static  void main(String [] args){
    Thread.currentThread().setUncaughtExceptionHandler(new UmpleExceptionHandler());
    Thread.setDefaultUncaughtExceptionHandler(new UmpleExceptionHandler());
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

  @umplesourcefile(line={60},file={"Vml_Code.ump"},javaline={77},length={4})
   private static  void println(String output){
    console += output + "\n";
    System.out.println(output);
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={18},file={"Vml_Code.ump"},javaline={86},length={2})
  public static String console = "" ;

  
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
              for(java.lang.annotation.Annotation anno: meth.getAnnotations())
              {
                if(anno.annotationType().getSimpleName().equals("umplesourcefile"))
                {
                  int[] methodlength = (int[])anno.annotationType().getMethod("length", new Class[]{}).invoke(anno,new Object[]{});
                  int[] javaline = (int[])anno.annotationType().getMethod("javaline", new Class[]{}).invoke(anno,new Object[]{});
                  int[] line = (int[])anno.annotationType().getMethod("line", new Class[]{}).invoke(anno,new Object[]{});
                  String[] file = (String[])anno.annotationType().getMethod("file", new Class[]{}).invoke(anno,new Object[]{});
                  for(int i=0;i<file.length;i++)
                  {
                    int distanceFromStart = element.getLineNumber()-javaline[i]-(("main".equals(methodName))?2:0);
                    if(file[i] == "")
                    {
                      break;
                    }
                    else if(distanceFromStart>=0&&distanceFromStart<=methodlength[i])
                    {
                      result.add(new StackTraceElement(element.getClassName(),element.getMethodName(),file[i],line[i]+distanceFromStart));
                      methodFound = true;
                      break;
                    }
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