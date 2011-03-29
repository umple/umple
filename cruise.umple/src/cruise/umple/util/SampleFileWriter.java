/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.11.1.3376 modeling language!*/

package cruise.umple.util;
import java.io.*;
import org.junit.*;

public class SampleFileWriter
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SampleFileWriter()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public static String readContent(File filename)
  {
    BufferedReader reader = null;
    StringBuffer answer = new StringBuffer();
    
    try
    {
      reader = new BufferedReader(new FileReader(filename));
      String nextLine = null;
      while (( nextLine = reader.readLine()) != null)
      {
        answer.append(nextLine);
        answer.append("\n");
      } 
      
    }
    catch (Exception e)
    {
      throw new RuntimeException("Unable to read content",e);
    }
    finally
    {
      closeAsRequired(reader);
    }    
    return answer.toString();

  }
  
  public static void assertEitherFileContent(File expected1, File expected2, String actual)
  {
    try
    {
      assertFileContent(expected1,actual);
    }
    catch (AssertionError e)
    {
      assertFileContent(expected2,actual);
    }
  }
  
  public static void assertFileContent(File expected, String actual)
  {
    
    BufferedReader expectedReader = null;
    BufferedReader actualReader = null;
    
    try
    {
      expectedReader = new BufferedReader(new FileReader(expected));
      actualReader = new BufferedReader(new StringReader(actual));

      String expectedLine = null;
      String actualLine = null;
      
      int line = 0;
      do 
      {
        expectedLine = expectedReader.readLine();
        actualLine = actualReader.readLine();
        line++;
        Assert.assertEquals("Failed at:" + line,expectedLine,actualLine);
      } 
      while (expectedLine != null && actualLine != null);
    }
    catch (Exception e)
    {
      Assert.fail(e.getMessage());
    }
    finally
    {
      closeAsRequired(expectedReader);
      closeAsRequired(actualReader);
    }    
  }
  
  public static void closeAsRequired(BufferedReader reader)
  {
    if (reader != null)
    {
      try
      {
        reader.close();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
  }
  
  public static String rationalize(String path)
  {
    File f = new File(path);
    if (f.exists())
    {
      return path;
    }
    else
    {
      return "../cruise.umple/" + path;
    }    
  }
  
  public static void createFile(String filename, String input)
  {
    try
    {
      BufferedWriter out = new BufferedWriter(new FileWriter(filename));
      out.write(input);
      out.close();
    }
    catch (IOException e)
    {
      throw new RuntimeException("Unable to create file [" + filename + "]", e);
    }
  }
  
  public static void destroy(String filename)
  {
    
    File file = new File(filename);
    
    if (file.isDirectory())
    {
      destroy(file);
    }
    else
    {
      file.delete();
    }
  }
  
  private static void destroy(File path)
  {
    if( path.exists() ) {
      File[] files = path.listFiles();
      for(int i=0; i<files.length; i++) {
         if(files[i].isDirectory()) {
           destroy(files[i]);
         }
         else {
           files[i].delete();
         }
      }
    }
    path.delete();
  }
}