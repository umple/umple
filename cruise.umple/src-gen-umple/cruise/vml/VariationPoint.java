/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.vml;
import java.util.*;

public class VariationPoint
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //VariationPoint Attributes
  private String name;

  //VariationPoint State Machines
  enum Kind { Optional, Alternative }
  private Kind kind;

  //VariationPoint Associations
  private CodeSnippet codeSnippet;
  private List<Variant> variants;
  private List<VariationPoint> requires;
  private Concern concern;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetConcern;
  private boolean canSetName;
  private boolean canSetCodeSnippet;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public VariationPoint(String aName)
  {
    cachedHashCode = -1;
    canSetConcern = true;
    canSetName = true;
    canSetCodeSnippet = true;
    name = aName;
    variants = new ArrayList<Variant>();
    requires = new ArrayList<VariationPoint>();
    setKind(Kind.Optional);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    if (!canSetName) { return false; }
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getKindFullName()
  {
    String answer = kind.toString();
    return answer;
  }

  public Kind getKind()
  {
    return kind;
  }

  public boolean setKind(Kind aKind)
  {
    kind = aKind;
    return true;
  }

  public CodeSnippet getCodeSnippet()
  {
    return codeSnippet;
  }

  public Variant getVariant(int index)
  {
    Variant aVariant = variants.get(index);
    return aVariant;
  }

  public List<Variant> getVariants()
  {
    List<Variant> newVariants = Collections.unmodifiableList(variants);
    return newVariants;
  }

  public int numberOfVariants()
  {
    int number = variants.size();
    return number;
  }

  public boolean hasVariants()
  {
    boolean has = variants.size() > 0;
    return has;
  }

  public int indexOfVariant(Variant aVariant)
  {
    int index = variants.indexOf(aVariant);
    return index;
  }

  public VariationPoint getRequire(int index)
  {
    VariationPoint aRequire = requires.get(index);
    return aRequire;
  }

  public List<VariationPoint> getRequires()
  {
    List<VariationPoint> newRequires = Collections.unmodifiableList(requires);
    return newRequires;
  }

  public int numberOfRequires()
  {
    int number = requires.size();
    return number;
  }

  public boolean hasRequires()
  {
    boolean has = requires.size() > 0;
    return has;
  }

  public int indexOfRequire(VariationPoint aRequire)
  {
    int index = requires.indexOf(aRequire);
    return index;
  }

  public Concern getConcern()
  {
    return concern;
  }

  public boolean setCodeSnippet(CodeSnippet newCodeSnippet)
  {
    boolean wasSet = false;
    if (!canSetCodeSnippet) { return false; }
    codeSnippet = newCodeSnippet;
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfVariants()
  {
    return 0;
  }

  public boolean addVariant(Variant aVariant)
  {
    boolean wasAdded = false;
    if (variants.contains(aVariant)) { return false; }
    VariationPoint existingVariationPoint = aVariant.getVariationPoint();
    if (existingVariationPoint == null)
    {
      aVariant.setVariationPoint(this);
    }
    else if (!this.equals(existingVariationPoint))
    {
      existingVariationPoint.removeVariant(aVariant);
      addVariant(aVariant);
    }
    else
    {
      variants.add(aVariant);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeVariant(Variant aVariant)
  {
    boolean wasRemoved = false;
    if (variants.contains(aVariant))
    {
      variants.remove(aVariant);
      aVariant.setVariationPoint(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public static int minimumNumberOfRequires()
  {
    return 0;
  }

  public boolean addRequire(VariationPoint aRequire)
  {
    boolean wasAdded = false;
    if (requires.contains(aRequire)) { return false; }
    requires.add(aRequire);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRequire(VariationPoint aRequire)
  {
    boolean wasRemoved = false;
    if (requires.contains(aRequire))
    {
      requires.remove(aRequire);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean setConcern(Concern aConcern)
  {
    boolean wasSet = false;
    if (!canSetConcern) { return false; }
    Concern existingConcern = concern;
    concern = aConcern;
    if (existingConcern != null && !existingConcern.equals(aConcern))
    {
      existingConcern.removeVariationPoint(this);
    }
    if (aConcern != null)
    {
      aConcern.addVariationPoint(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    VariationPoint compareTo = (VariationPoint)obj;
  
    if (concern == null && compareTo.concern != null)
    {
      return false;
    }
    else if (concern != null && !concern.equals(compareTo.concern))
    {
      return false;
    }

    if (name == null && compareTo.name != null)
    {
      return false;
    }
    else if (name != null && !name.equals(compareTo.name))
    {
      return false;
    }

    if (codeSnippet == null && compareTo.codeSnippet != null)
    {
      return false;
    }
    else if (codeSnippet != null && !codeSnippet.equals(compareTo.codeSnippet))
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
    if (concern != null)
    {
      cachedHashCode = cachedHashCode * 23 + concern.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }
    if (name != null)
    {
      cachedHashCode = cachedHashCode * 23 + name.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    if (codeSnippet != null)
    {
      cachedHashCode = cachedHashCode * 23 + codeSnippet.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetConcern = false;
    canSetName = false;
    canSetCodeSnippet = false;
    return cachedHashCode;
  }

  public void delete()
  {
    codeSnippet = null;
    for(Variant aVariant : variants)
    {
      aVariant.setVariationPoint(null);
    }
    requires.clear();
    if (concern != null)
    {
      Concern placeholderConcern = concern;
      this.concern = null;
      placeholderConcern.removeVariationPoint(this);
    }
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public String toString()
  {
    if (codeSnippet == null)
    {
      return name + ":" + kind + ":";
    }
    else
    {
      return name + ":" + kind + ":" + codeSnippet;
    }
  }
  
  public Variant getVariant(String name)
  {
    if (name == null)
    {
      return null;
    }
    for (Variant var : getVariants())
    {
      if (name.equals(var.getName()))
      {
        return var;
      }
    }
    return null;
  }
}