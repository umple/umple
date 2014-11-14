/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 43 "DMMSourceObjectHierarchy.ump"
// line 169 "DMMSourceObjectHierarchy.ump"
public class Includes
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Includes Associations
  private SourceFile includes;
  private SourceFile included;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Includes(SourceFile aIncludes, SourceFile aIncluded)
  {
    boolean didAddIncludes = setIncludes(aIncludes);
    if (!didAddIncludes)
    {
      throw new RuntimeException("Unable to create included due to includes");
    }
    boolean didAddIncluded = setIncluded(aIncluded);
    if (!didAddIncluded)
    {
      throw new RuntimeException("Unable to create include due to included");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public SourceFile getIncludes()
  {
    return includes;
  }

  public SourceFile getIncluded()
  {
    return included;
  }

  public boolean setIncludes(SourceFile aIncludes)
  {
    boolean wasSet = false;
    if (aIncludes == null)
    {
      return wasSet;
    }

    SourceFile existingIncludes = includes;
    includes = aIncludes;
    if (existingIncludes != null && !existingIncludes.equals(aIncludes))
    {
      existingIncludes.removeIncluded(this);
    }
    includes.addIncluded(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setIncluded(SourceFile aIncluded)
  {
    boolean wasSet = false;
    if (aIncluded == null)
    {
      return wasSet;
    }

    SourceFile existingIncluded = included;
    included = aIncluded;
    if (existingIncluded != null && !existingIncluded.equals(aIncluded))
    {
      existingIncluded.removeInclude(this);
    }
    included.addInclude(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    SourceFile placeholderIncludes = includes;
    this.includes = null;
    placeholderIncludes.removeIncluded(this);
    SourceFile placeholderIncluded = included;
    this.included = null;
    placeholderIncluded.removeInclude(this);
  }

}