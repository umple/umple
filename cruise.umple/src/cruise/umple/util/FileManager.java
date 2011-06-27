/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.1.605 modeling language!*/

package cruise.umple.util;
import java.io.*;

public class FileManager
{

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

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public static String loadFile(String filename)
  {
    try 
    {
      return loadFile(new FileReader(filename));
    } 
    catch (Exception e) 
    {
      return null;
    }  
  }   
  
  public static String loadFile(File file)
  {
    try 
    {
      return loadFile(new FileReader(file));
    } 
    catch (Exception e) 
    {
      return null;
    } 
  }   

  public static File writeFileToDisk(String filename, String text)
  {
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
  
  public static void writeFileToDisk(File file, String text)
  {
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
  
  //```````````````````````
  // INTERFACE
  //``````````````````````` 
  
  private static void writeFileToDisk(FileOutputStream fout, String text) throws IOException
  {
    OutputStream bout = new BufferedOutputStream(fout);
    OutputStreamWriter out = new OutputStreamWriter(bout);

    out.write(text);
    out.flush();
    out.close();
  }
  
  private static String loadFile(FileReader reader)
  {
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
}