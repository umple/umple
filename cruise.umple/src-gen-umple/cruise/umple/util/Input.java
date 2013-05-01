/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.util;
import java.io.*;

/**
 * @umplesource Util_Code.ump 77
 */
// line 77 "../../../../src/Util_Code.ump"
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


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "stream" + "=" + getStream() != null ? !getStream() .equals(this)  ? getStream().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 84 ../../../../src/Util_Code.ump
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