/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.stats;
import cruise.umple.util.*;

/**
 * @umplesource UmpleStats_Code.ump 13
 */
// line 13 "../../../../src/UmpleStats_Code.ump"
public class StatsMain
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StatsMain()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}

  @umplesourcefile(line={22},file={"UmpleStats_Code.ump"},javaline={36},length={30})
   public static  void main(String [] args){
    Thread.currentThread().setUncaughtExceptionHandler(new UmpleExceptionHandler());
    Thread.setDefaultUncaughtExceptionHandler(new UmpleExceptionHandler());
    console = "";
    
    if (args.length != 2)
    {
      println("Usage: java -jar umplestats.jar <results_file> <project_listing_file>");
      println("Example: java -jar umplestats.jar all.results projects.txt");
      println("Where, projects.txt is looks something like like:");
      println("---------\np1\nC:/dev/airline.ump\np2\nC:/dev/elevator.ump");
      return;
    }
    
    String outputFilename = args[0];
    String projectListings = FileManager.loadFile(args[1]);
    String[] allProjects = projectListings.split("\n");
    
    
    println("Analyzing umple applications:");
    MetricsCollector collector = new MetricsCollector();
    for(int i=1; i<allProjects.length; i+=2)
    {
      String projectName = allProjects[i-1];
      String inputFilename = allProjects[i];
      boolean didAnalyze = collector.analyze(projectName,inputFilename);
      String text = didAnalyze ? "success" : "failed";
      println("["+ inputFilename +"], " + text);
    }
    collector.save(outputFilename);
    println("Saved results to ["+ outputFilename +"]");
  }

  @umplesourcefile(line={54},file={"UmpleStats_Code.ump"},javaline={70},length={4})
   private static  void println(String output){
    console += output + "\n";
    System.out.println(output);
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={17},file={"UmpleStats_Code.ump"},javaline={78},length={2})
  public static String console ;

  
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