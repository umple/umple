/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * Represents the generation target, such as what the generated output language will be.
 * @umplesource Umple.ump 662
 * @umplesource Umple_Code.ump 2000
 */
// line 662 "../../../../src/Umple.ump"
// line 2000 "../../../../src/Umple_Code.ump"
public class GenerateTarget
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GenerateTarget Attributes
  private String language;
  private String path;
  private boolean override;
  private boolean overrideAll;
  private Map<String,String> options;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetLanguage;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GenerateTarget(String aLanguage, String aPath)
  {
    cachedHashCode = -1;
    canSetLanguage = true;
    language = aLanguage;
    path = aPath;
    override = false;
    overrideAll = false;
    options = new HashMap<String,String>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLanguage(String aLanguage)
  {
    boolean wasSet = false;
    if (!canSetLanguage) { return false; }
    language = aLanguage;
    wasSet = true;
    return wasSet;
  }

  public boolean setPath(String aPath)
  {
    boolean wasSet = false;
    path = aPath;
    wasSet = true;
    return wasSet;
  }

  public boolean setOverride(boolean aOverride)
  {
    boolean wasSet = false;
    override = aOverride;
    wasSet = true;
    return wasSet;
  }

  public boolean setOverrideAll(boolean aOverrideAll)
  {
    boolean wasSet = false;
    overrideAll = aOverrideAll;
    wasSet = true;
    return wasSet;
  }

  /**
   * The target language, such as Java, Cpp, Php or Ruby.
   */
  public String getLanguage()
  {
    return language;
  }

  @umplesourcefile(line={676},file={"Umple.ump"},javaline={98},length={1})
  public String getPath()
  {
    // line 676 "../../../../src/Umple.ump"
    if(path == null) path = "";
    return path;
  }

  public boolean getOverride()
  {
    return override;
  }

  public boolean getOverrideAll()
  {
    return overrideAll;
  }

  public boolean isOverride()
  {
    return override;
  }

  public boolean isOverrideAll()
  {
    return overrideAll;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    GenerateTarget compareTo = (GenerateTarget)obj;
  
    if (language == null && compareTo.language != null)
    {
      return false;
    }
    else if (language != null && !language.equals(compareTo.language))
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
    if (language != null)
    {
      cachedHashCode = cachedHashCode * 23 + language.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetLanguage = false;
    return cachedHashCode;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "language" + ":" + getLanguage()+ "," +
            "path" + ":" + getPath()+ "," +
            "override" + ":" + getOverride()+ "," +
            "overrideAll" + ":" + getOverrideAll()+ "]"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={2000},file={"Umple_Code.ump"},javaline={179},length={8})
  @umplesourcefile(line={2001},file={"Umple_Code.ump"},javaline={180},length={3})
  public void setOption (String key, String value){
    this.options.put(key, value);
  }

  @umplesourcefile(line={2005},file={"Umple_Code.ump"},javaline={185},length={3})
  public String getOption (String key){
    return this.options.get(key);
  }

}