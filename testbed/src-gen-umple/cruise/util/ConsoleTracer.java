/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.util;

public class ConsoleTracer
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static ConsoleTracer theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private ConsoleTracer()
  {
    handle("Time,Thread,UmpleFile,LineNumber,Class,Object,Operation,Name,Value");
  }

  public static ConsoleTracer getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new ConsoleTracer();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
    @umplesourcefile(line={0},file={""},javaline={50},length={4})
public static void handle(String message)
  {
     System.err.println(message);
  }
static{getInstance();}

}