/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.io.*;
import cruise.umple.compiler.exceptions.*;

/**
 * TODO: Users of this can most likely just use File, so this could be refactored out
 * @umplesource UmpleHelper.ump 23
 * @umplesource UmpleHelper_Code.ump 12
 */
// line 23 "../../../../src/UmpleHelper.ump"
// line 12 "../../../../src/UmpleHelper_Code.ump"
public class UmpleFile
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int line();String file();int javaline();int length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UmpleFile Attributes
  private File file;
  private String fileName;
  private String path;
  private StringBuilder fileContent;
  private String linkedFiles;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleFile(File aFile)
  {
    file = aFile;
    fileName = null;
    path = null;
    fileContent = init();
    linkedFiles = "";
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


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "fileName" + ":" + getFileName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "file" + "=" + (getFile() != null ? !getFile().equals(this)  ? getFile().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
    @umplesourcefile(line=0,file="",javaline=91,length=3)
 public UmpleFile(String aPath,String aFilename)  {
this(new File(aPath,aFilename));
  }
  @umplesourcefile(line=3,file="",javaline=95,length=3)
 public UmpleFile(String aFullFilename)  {
this(new File(aFullFilename));
  }
// line 25 ../../../../src/UmpleHelper_Code.ump
  @umplesourcefile(line=25,file="UmpleHelper_Code.ump",javaline=100,length=12)
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
  
  @umplesourcefile(line=38,file="UmpleHelper_Code.ump",javaline=114,length=13)
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

  @umplesourcefile(line=52,file="UmpleHelper_Code.ump",javaline=129,length=4)
  public String getFileContent()
  {
    return fileContent.toString();
  }

  @umplesourcefile(line=57,file="UmpleHelper_Code.ump",javaline=135,length=4)
  public InputStream getFileStream() throws FileNotFoundException
  {
    return new FileInputStream(file);
  }

  @umplesourcefile(line=62,file="UmpleHelper_Code.ump",javaline=141,length=5)
  private boolean doesFileExist(String aFileName)
  {
    File file = new File(aFileName);
    return file.exists();
  }

  @umplesourcefile(line=68,file="UmpleHelper_Code.ump",javaline=148,length=5)
  public boolean doesFileExist()
  {
    File file = new File(path,fileName);
    return file.exists();
  }

  @umplesourcefile(line=74,file="UmpleHelper_Code.ump",javaline=155,length=4)
  public String getPath()
  {
    return path;
  }
  
  @umplesourcefile(line=79,file="UmpleHelper_Code.ump",javaline=161,length=4)
  public String getParent()
  {
    return ((new File(path)).getParent().toString());
  }

  @umplesourcefile(line=84,file="UmpleHelper_Code.ump",javaline=167,length=26)
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
  
  // this is used to add command-based linked Umple files to the proper list.
  @umplesourcefile(line=117,file="UmpleHelper_Code.ump",javaline=201,length=3)
  public void addLinkedFiles(String filename) {
  	linkedFiles = linkedFiles+"use "+filename+";\n";
  }
  
  // this is used to get list of command-based linked Umple files.
  @umplesourcefile(line=122,file="UmpleHelper_Code.ump",javaline=207,length=3)
  public String getLinkedFiles() {
 	 return "\n"+linkedFiles;
  }

}