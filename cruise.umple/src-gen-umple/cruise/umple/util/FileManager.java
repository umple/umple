/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.util;
import java.io.*;

/**
 * @umplesource Util_Code.ump 107
 */
// line 107 "../../../../src/Util_Code.ump"
public class FileManager
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public FileManager()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}


  /**
   * ```````````````````````
   * INTERFACE
   * ```````````````````````
   */
  @umplesourcefile(line={115},file={"Util_Code.ump"},javaline={35},length={10})
   public static  String loadFile(String filename){
    try 
    {
      return loadFile(new FileReader(filename));
    } 
    catch (Exception e) 
    {
      return null;
    }
  }

  @umplesourcefile(line={127},file={"Util_Code.ump"},javaline={53},length={10})
   public static  String loadFile(File file){
    try 
    {
      return loadFile(new FileReader(file));
    } 
    catch (Exception e) 
    {
      return null;
    }
  }

  @umplesourcefile(line={139},file={"Util_Code.ump"},javaline={65},length={12})
   public static  File writeFileToDisk(String filename, String text){
    try 
    {
      FileOutputStream fout = new FileOutputStream(filename);
      FileManager.writeFileToDisk(fout,text);
      return new File(filename);
    } 
    catch (Exception e) 
    {
      throw new RuntimeException("Error writing ["+ filename +"] to disk",e);
    }
  }

  @umplesourcefile(line={153},file={"Util_Code.ump"},javaline={79},length={11})
   public static  void writeFileToDisk(File file, String text){
    try 
    {
      FileOutputStream fout = new FileOutputStream(file);
      FileManager.writeFileToDisk(fout,text);
    } 
    catch (Exception e) 
    {
      throw new RuntimeException("Error writing ["+ file.getAbsoluteFile() +"] to disk",e);
    }
  }

  @umplesourcefile(line={180},file={"Util_Code.ump"},javaline={92},length={22})
   private static  String loadFile(FileReader reader){
    try 
    {
      String content = "";
      BufferedReader in = new BufferedReader(reader);
      String input;
      while ((input = in.readLine()) != null) 
      {
        if (!"".equals(content))
        {
          content += "\n";  
        }
        content += input;
      }
      in.close();
      return content;
    } 
    catch (Exception e) 
    {
      return null;
    }
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={169},file={"Util_Code.ump"},javaline={119},length={10})
  @umplesourcefile(line={170},file={"Util_Code.ump"},javaline={120},length={9})
  private static void writeFileToDisk(FileOutputStream fout, String text) throws IOException 
  {
    OutputStream bout = new BufferedOutputStream(fout);
    OutputStreamWriter out = new OutputStreamWriter(bout);

    out.write(text);
    out.flush();
    out.close();
  }

}