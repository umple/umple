/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * Represents the generation target, such as what the generated output language will be.
 * @umplesource Umple.ump 715
 * @umplesource Umple_Code.ump 2100
 */
// line 715 "../../../../src/Umple.ump"
// line 2100 "../../../../src/Umple_Code.ump"
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

  /**
   * optional parameters that may differ by instance, and not significant enough to warrant a Subclass (used in Uigu2Generator)
   */
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

  @umplesourcefile(line={729},file={"Umple.ump"},javaline={102},length={1})
  public String getPath()
  {
    // line 729 "../../../../src/Umple.ump"
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

  @umplesourcefile(line={2101},file={"Umple_Code.ump"},javaline={169},length={3})
   public void setOption(String key, String value){
    this.options.put(key, value);
  }

  @umplesourcefile(line={2105},file={"Umple_Code.ump"},javaline={174},length={3})
   public String getOption(String key){
    return this.options.get(key);
  }


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
}