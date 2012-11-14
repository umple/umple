/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * An element partaining to an entity with Umple.
 */
public class UmpleElement
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UmpleElement Attributes
  private String name;
  private String umpFile;
  private String modifier;
  private List<String> namespaces;
  private String packageName;
  private String extraCode;
  private boolean isInternal;
  private Coordinate position;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleElement(String aName)
  {
    name = aName;
    umpFile = "";
    modifier = null;
    namespaces = new ArrayList<String>();
    packageName = "";
    extraCode = "";
    isInternal = false;
    position = new Coordinate(-1,-1,-1,-1);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setUmpFile(String aUmpFile)
  {
    boolean wasSet = false;
    umpFile = aUmpFile;
    wasSet = true;
    return wasSet;
  }

  public boolean setModifier(String aModifier)
  {
    boolean wasSet = false;
    modifier = aModifier;
    wasSet = true;
    return wasSet;
  }

  public boolean addNamespace(String aNamespace)
  {
    boolean wasAdded = false;
    wasAdded = namespaces.add(aNamespace);
    return wasAdded;
  }

  public boolean removeNamespace(String aNamespace)
  {
    boolean wasRemoved = false;
    wasRemoved = namespaces.remove(aNamespace);
    return wasRemoved;
  }

  public boolean setPackageName(String aPackageName)
  {
    boolean wasSet = false;
    if (aPackageName == null) { return false; }
    packageName = aPackageName;
    wasSet = true;
    return wasSet;
  }

  public boolean setExtraCode(String aExtraCode)
  {
    boolean wasSet = false;
    extraCode = aExtraCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsInternal(boolean aIsInternal)
  {
    boolean wasSet = false;
    isInternal = aIsInternal;
    wasSet = true;
    return wasSet;
  }

  public boolean setPosition(Coordinate aPosition)
  {
    boolean wasSet = false;
    position = aPosition;
    wasSet = true;
    return wasSet;
  }

  /**
   * The name of the Umple element.
   */
  public String getName()
  {
    return name;
  }

  /**
   * The original ump file
   */
  public String getUmpFile()
  {
    return umpFile;
  }

  /**
   * The modifier associated with the Umple element.
   */
  public String getModifier()
  {
    return modifier;
  }

  public String getNamespace(int index)
  {
    String aNamespace = namespaces.get(index);
    return aNamespace;
  }

  public String[] getNamespaces()
  {
    String[] newNamespaces = namespaces.toArray(new String[namespaces.size()]);
    return newNamespaces;
  }

  public int numberOfNamespaces()
  {
    int number = namespaces.size();
    return number;
  }

  public boolean hasNamespaces()
  {
    boolean has = namespaces.size() > 0;
    return has;
  }

  public int indexOfNamespace(String aNamespace)
  {
    int index = namespaces.indexOf(aNamespace);
    return index;
  }

  public String getPackageName()
  {
    return packageName;
  }

  /**
   * The code associated with the Umple element.
   */
  public String getExtraCode()
  {
    return extraCode;
  }

  /**
   * Specifies whether or not the Umple element is internal.
   */
  public boolean getIsInternal()
  {
    return isInternal;
  }

  /**
   * Specifies the position of this Umple element (ex. The UmpleOnline diagram).
   */
  public Coordinate getPosition()
  {
    return position;
  }

  public boolean isIsInternal()
  {
    return isInternal;
  }

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public void appendExtraCode(String newCode)
  {
    appendExtraCode(newCode,true);
  }

  public void appendExtraCode(String newCode, boolean addNewline)
  {
    if (newCode == null) 
    { 
      return;
    }
    if (!"".equals(extraCode) && addNewline)
    {
      extraCode += System.getProperty("line.separator");
    } 
    extraCode += newCode;
  }
}