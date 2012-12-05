/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.umple.util;
import java.io.*;

public class Input
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Input Attributes
  private InputStream stream;
  private BufferedReader reader;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Input(InputStream aStream)
  {
    stream = aStream;
    reader = new BufferedReader(new InputStreamReader(aStream));
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStream(InputStream aStream)
  {
    boolean wasSet = false;
    stream = aStream;
    wasSet = true;
    return wasSet;
  }

  public InputStream getStream()
  {
    return stream;
  }

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public String readUmpleFile(String[] args, PrintStream writer)
  {
    if (args.length > 0)
    {
      return args[0];
    }
    else
    {
      writer.println("Please specify the file to compile:");
      return readLine();
    }
  }
  
  public String readLine()
  {
    try {
      return reader.readLine();
    } catch (IOException e) {
      return "";
    }
  }
}