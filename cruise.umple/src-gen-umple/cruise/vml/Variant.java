/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.vml;

// line 52 "../../../src/Vml.ump"
// line 159 "../../../src/Vml_Code.ump"
// line 385 "../../../src/Vml_Code.ump"
public class Variant
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Variant Attributes
  private String name;

  //Variant Associations
  private CodeSnippet codeSnippet;
  private VariationPoint variationPoint;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetName;
  private boolean canSetCodeSnippet;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Variant(String aName)
  {
    cachedHashCode = -1;
    canSetName = true;
    canSetCodeSnippet = true;
    name = aName;
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

  public CodeSnippet getCodeSnippet()
  {
    return codeSnippet;
  }

  public VariationPoint getVariationPoint()
  {
    return variationPoint;
  }

  public boolean setCodeSnippet(CodeSnippet newCodeSnippet)
  {
    boolean wasSet = false;
    if (!canSetCodeSnippet) { return false; }
    codeSnippet = newCodeSnippet;
    wasSet = true;
    return wasSet;
  }

  public boolean setVariationPoint(VariationPoint aVariationPoint)
  {
    boolean wasSet = false;
    VariationPoint existingVariationPoint = variationPoint;
    variationPoint = aVariationPoint;
    if (existingVariationPoint != null && !existingVariationPoint.equals(aVariationPoint))
    {
      existingVariationPoint.removeVariant(this);
    }
    if (aVariationPoint != null)
    {
      aVariationPoint.addVariant(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Variant compareTo = (Variant)obj;
  
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

    canSetName = false;
    canSetCodeSnippet = false;
    return cachedHashCode;
  }

  public void delete()
  {
    codeSnippet = null;
    if (variationPoint != null)
    {
      VariationPoint placeholderVariationPoint = variationPoint;
      this.variationPoint = null;
      placeholderVariationPoint.removeVariant(this);
    }
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 161 ../../../src/Vml_Code.ump
  public String toString()
  {
    if (name == null)
    {
      return "";
    }
    else
    {
      return name;
    }
  }
}