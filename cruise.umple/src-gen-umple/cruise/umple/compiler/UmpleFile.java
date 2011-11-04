/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.umple.compiler;
import java.io.*;
import cruise.umple.compiler.exceptions.*;

/**
 * TODO: Users of this can most likely just use File, so this could be refactored out
 */
public class UmpleFile
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UmpleFile Attributes
  private File file;
  private String fileName;
  private String path;
  private StringBuilder fileContent;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleFile(File aFile)
  {
    file = aFile;
    fileName = null;
    path = null;
    fileContent = init();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setFile(File aFile)
  {
    boolean wasSet = false;
    file = aFile;
    wasSet = true;
    return wasSet;
  }

  public boolean setFileName(String aFileName)
  {
    boolean wasSet = false;
    fileName = aFileName;
    wasSet = true;
    return wasSet;
  }

  public File getFile()
  {
    return file;
  }

  public String getFileName()
  {
    return fileName;
  }

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
   public UmpleFile(String aPath,String aFilename)  {
this(new File(aPath,aFilename));
  }
 public UmpleFile(String aFullFilename)  {
this(new File(aFullFilename));
  }
private StringBuilder init()
  {
    String fullFilename = file.getAbsolutePath();
    fileName = file.getName();
    path = file.getAbsoluteFile().getParentFile().getAbsolutePath();
    fileContent = new StringBuilder();
    if (doesFileExist(fullFilename))
    {
      append(fullFilename);
    }
    return fileContent;
  }
  
  public String getSimpleFileName()
  {

    int lastIndex = fileName.lastIndexOf(".");
    if (lastIndex == -1)
    {
      return fileName;
    }
    else
    {
      return fileName.substring(0, lastIndex);
    }
  }

  public String getFileContent()
  {
    return fileContent.toString();
  }

  public InputStream getFileStream() throws FileNotFoundException
  {
    return new FileInputStream(file);
  }

  private boolean doesFileExist(String aFileName)
  {
    File file = new File(aFileName);
    return file.exists();
  }

  public boolean doesFileExist()
  {
    File file = new File(path,fileName);
    return file.exists();
  }

  public String getPath()
  {
    return path;
  }

  public void append(String aFilename)
  {
    try
    {
      FileReader fileReader = new FileReader(aFilename);
      BufferedReader reader = new BufferedReader(fileReader);

      String nextLine = reader.readLine();
      while (nextLine != null)
      {
        fileContent.append(nextLine);
        nextLine = reader.readLine();
      }
      reader.close();
      fileReader.close();
      cleanContent();
    }
    catch (FileNotFoundException e)
    {
      throw new UmpleCompilerException("File " + aFilename + " was not found.", e);
    }
    catch (IOException e)
    {
      throw new UmpleCompilerException("File " + aFilename + " had IO problems.", e);
    }
  }

  void cleanContent()
  {
    fileContent = new StringBuilder(fileContent.toString().replaceAll("//(\\w|\\d|\\s)*\\n", "\n"));
  }
}