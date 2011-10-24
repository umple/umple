/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.957 modeling language!*/

package cruise.umple.compiler;

public class GenerateTarget
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GenerateTarget Attributes
  private String language;
  private String path;
  private boolean override;
  private boolean overrideAll;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetLanguage;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GenerateTarget(String aLanguage, String aPath)
  {
    language = aLanguage;
    path = aPath;
    override = false;
    overrideAll = false;
    cachedHashCode = -1;
    canSetLanguage = true;
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

  public String getLanguage()
  {
    return language;
  }

  public String getPath()
  {
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

}