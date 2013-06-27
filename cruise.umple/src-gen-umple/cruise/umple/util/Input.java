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
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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
            "  " + "stream" + "=" + (getStream() != null ? !getStream().equals(this)  ? getStream().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={83},file={"Util_Code.ump"},javaline={67},length={22})
  @umplesourcefile(line={84},file={"Util_Code.ump"},javaline={68},length={12})
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
  
  @umplesourcefile(line={97},file={"Util_Code.ump"},javaline={82},length={8})
  public String readLine()
  {
    try {
      return reader.readLine();
    } catch (IOException e) {
      return "";
    }
  }

}