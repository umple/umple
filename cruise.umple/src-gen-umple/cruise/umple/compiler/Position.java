/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.nio.file.*;

/**
 * Used to indicate the coordinates of a position when parsing.  This is done by keeping track of the
 * filename, the line number and the corresponding offset on that line number.
 * @umplesource Parser.ump 122
 * @umplesource Parser_Code.ump 321
 */
// line 122 "../../../../src/Parser.ump"
// line 321 "../../../../src/Parser_Code.ump"
public class Position
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Position Attributes
  private String filename;
  private int lineNumber;
  private int characterOffset;
  private int offset;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetFilename;
  private boolean canSetLineNumber;
  private boolean canSetCharacterOffset;
  private boolean canSetOffset;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Position(String aFilename, int aLineNumber, int aCharacterOffset, int aOffset)
  {
    cachedHashCode = -1;
    canSetFilename = true;
    canSetLineNumber = true;
    canSetCharacterOffset = true;
    canSetOffset = true;
    filename = aFilename;
    lineNumber = aLineNumber;
    characterOffset = aCharacterOffset;
    offset = aOffset;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setFilename(String aFilename)
  {
    boolean wasSet = false;
    if (!canSetFilename) { return false; }
    filename = aFilename;
    wasSet = true;
    return wasSet;
  }

  public boolean setLineNumber(int aLineNumber)
  {
    boolean wasSet = false;
    if (!canSetLineNumber) { return false; }
    lineNumber = aLineNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setCharacterOffset(int aCharacterOffset)
  {
    boolean wasSet = false;
    if (!canSetCharacterOffset) { return false; }
    characterOffset = aCharacterOffset;
    wasSet = true;
    return wasSet;
  }

  public boolean setOffset(int aOffset)
  {
    boolean wasSet = false;
    if (!canSetOffset) { return false; }
    offset = aOffset;
    wasSet = true;
    return wasSet;
  }

  /**
   * The filename of the position.
   */
  public String getFilename()
  {
    return filename;
  }

  /**
   * The line number of the position.
   */
  public int getLineNumber()
  {
    return lineNumber;
  }

  /**
   * The character offset of the position.
   */
  public int getCharacterOffset()
  {
    return characterOffset;
  }

  /**
   * The offset of the position.
   */
  public int getOffset()
  {
    return offset;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Position compareTo = (Position)obj;
  
    if (filename == null && compareTo.filename != null)
    {
      return false;
    }
    else if (filename != null && !filename.equals(compareTo.filename))
    {
      return false;
    }

    if (lineNumber != compareTo.lineNumber)
    {
      return false;
    }

    if (characterOffset != compareTo.characterOffset)
    {
      return false;
    }

    if (offset != compareTo.offset)
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    if (filename != null)
    {
      cachedHashCode = cachedHashCode * 23 + filename.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    cachedHashCode = cachedHashCode * 23 + lineNumber;

    cachedHashCode = cachedHashCode * 23 + characterOffset;

    cachedHashCode = cachedHashCode * 23 + offset;

    canSetFilename = false;
    canSetLineNumber = false;
    canSetCharacterOffset = false;
    canSetOffset = false;
    return cachedHashCode;
  }

  public void delete()
  {}

  @umplesourcefile(line={325},file={"Parser_Code.ump"},javaline={193},length={3})
   public  Position(int aLineNumber, int aCharacterOffset, int aOffset){
    this(null, aLineNumber, aCharacterOffset, aOffset);
  }

  @umplesourcefile(line={330},file={"Parser_Code.ump"},javaline={198},length={3})
   public Position copy(){
    return new Position(filename,lineNumber,characterOffset,offset);
  }

  @umplesourcefile(line={335},file={"Parser_Code.ump"},javaline={203},length={4})
   public Position add(Position more){
    String tfile = filename == null ? more.getFilename() : filename;
    return new Position(filename, getLineNumber() + more.getLineNumber() - 1, getCharacterOffset() + more.getCharacterOffset(), getOffset() + more.getOffset());
  }

  @umplesourcefile(line={341},file={"Parser_Code.ump"},javaline={209},length={3})
   public String toString(){
    return cruise.umple.util.StringFormatter.format("[{0},{1}]", getLineNumber(), getCharacterOffset());
  }

  @umplesourcefile(line={346},file={"Parser_Code.ump"},javaline={214},length={11})
   private int countChars(String str, char c){
    int count = 0;
    for (int i = 0; i < str.length(); i++)
    {
      if (str.charAt(i) == c)
      {
        count= count + 1;
      }
    }
    return count;
  }

  @umplesourcefile(line={359},file={"Parser_Code.ump"},javaline={227},length={3})
   private String deWindowsify(String str){
    return str.replace('\\','/');
  }


  /**
   * This version of getRelativePath is complete, but uses the java.nio library, requiring Java 7.
   * It was written by mistake, the author not knowing that Java 7 was not supported on the build server.
   * As a result, it has been replaced by the placeholder above, that simply returns the full path.
   */
  @umplesourcefile(line={367},file={"Parser_Code.ump"},javaline={232},length={55})
   public String getRelativePath(UmpleClass parent, String language){
    if (filename == null)
    {
      return "";
    }
    if (parent == null)
    { //No parent class? This might happen with state machines
      return Paths.get(filename).getFileName().toString();
    }
    
    //Find path relative to namespace folders
    String packageName = parent.getPackageName();
    if (packageName == null || packageName.equals(""))
    { //No package, file is output in current directory
      return Paths.get(filename).getFileName().toString();
    } 
    else
    { //Has a package, add appropriate number of ..
      int pathCount = countChars(packageName, '.') + 1;
      StringBuilder build = new StringBuilder();
      for (int i = 0; i < pathCount; i++)
      {
        build.append("../");
      }
      
      //Add on relative path from generator location
      if (parent.getSourceModel() == null)
      {
        build.append(Paths.get(filename).getFileName());
        return deWindowsify(build.toString());
      }
      Path currentPath = Paths.get(parent.getSourceModel().getUmpleFile().getPath()).toAbsolutePath();
      Path generatesPath = null;
      GenerateTarget [] generates = parent.getSourceModel().getGenerates();
      for (int i = 0; i < generates.length; i++)
      {
        if (generates[i].getLanguage().equals(language))
        {
          generatesPath = currentPath.resolve(Paths.get(generates[i].getPath())).normalize();
        }
      }
      if (generatesPath != null)
      {
      	Path result = generatesPath.relativize(currentPath);
      	if (!result.equals(Paths.get("")))
      	{
      	  result = result.normalize();
      	  build.append(result.toString() + '/');
      	}
      }
      
      build.append(Paths.get(filename).getFileName());
      return deWindowsify(build.toString());
    }
  }

}