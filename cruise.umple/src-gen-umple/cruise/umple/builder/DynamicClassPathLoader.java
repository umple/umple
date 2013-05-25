/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.builder;
import java.io.*;
import java.lang.reflect.*;
import java.net.*;

/**
 * @umplesource Builder_Code.ump 307
 */
// line 307 "../../../../src/Builder_Code.ump"
public class DynamicClassPathLoader
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DynamicClassPathLoader()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  // line 314 ../../../../src/Builder_Code.ump
  private static final Class<?>[] parameters = new Class[]{URL.class};

  @umplesourcefile(line={316},file={"Builder_Code.ump"},javaline={43},length={5})
  public static void addJar(String baseDirectory, String jarname) throws IOException
  {
    URL url = new URL("jar:file:///" + new File(baseDirectory).getAbsolutePath() + "/"+ jarname +"!/");
    DynamicClassPathLoader.addURL(url);
  }
  
  @umplesourcefile(line={322},file={"Builder_Code.ump"},javaline={50},length={16})
  public static void addURL(URL url) throws IOException
  {
    URLClassLoader sysloader = (URLClassLoader)ClassLoader.getSystemClassLoader();
    Class<?> sysclass = URLClassLoader.class;

    try
    {
      Method method = sysclass.getDeclaredMethod("addURL",parameters);
      method.setAccessible(true);
      method.invoke(sysloader,new Object[]{ url });
    }
    catch (Exception e)
    {
      throw new RuntimeException("Error, could not add URL to system classloader",e);
    }
  }

}