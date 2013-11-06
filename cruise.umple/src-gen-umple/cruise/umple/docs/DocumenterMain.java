/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.docs;

/**
 * @umplesource Documenter_Code.ump 12
 */
// line 12 "../../../../src/Documenter_Code.ump"
public class DocumenterMain
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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

  @umplesourcefile(line={19},file={"Documenter_Code.ump"},javaline={35},length={23})
   public static  void main(String [] args){
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

  @umplesourcefile(line={44},file={"Documenter_Code.ump"},javaline={62},length={4})
   private static  void println(String output){
    console += output + "\n";
    System.out.println(output);
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={14},file={"Documenter_Code.ump"},javaline={70},length={2})
  private static String console = "" ;

  
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