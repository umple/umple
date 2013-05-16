/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.docs;

/**
 * @umplesource Documenter_Code.ump 13
 */
// line 13 "../../../../src/Documenter_Code.ump"
public class DocumenterMain
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int line();String file();int javaline();int length();}

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
  // line 15 ../../../../src/Documenter_Code.ump
  private static String console = "";
  
  @umplesourcefile(line=17,file="Documenter_Code.ump",javaline=40,length=26)
  public static void main(String[] args) 
  {
    Thread.currentThread().setUncaughtExceptionHandler(new UmpleExceptionHandler());
    Thread.setDefaultUncaughtExceptionHandler(new UmpleExceptionHandler());
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
   
  @umplesourcefile(line=42,file="Documenter_Code.ump",javaline=68,length=5)
  private static void println(String output)
  {
    console += output + "\n";
    System.out.println(output);
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