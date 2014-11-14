/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 38 "DMMSourceObjectHierarchy.ump"
// line 115 "DMMSourceObjectHierarchy.ump"
public class SourceFile extends SourceUnit
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SourceFile Attributes
  private String path;

  //SourceFile Associations
  private List<Includes> included;
  private List<Includes> includes;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SourceFile(String aName, String aPath)
  {
    super(aName);
    path = aPath;
    included = new ArrayList<Includes>();
    includes = new ArrayList<Includes>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPath(String aPath)
  {
    boolean wasSet = false;
    path = aPath;
    wasSet = true;
    return wasSet;
  }

  public String getPath()
  {
    return path;
  }

  public Includes getIncluded(int index)
  {
    Includes aIncluded = included.get(index);
    return aIncluded;
  }

  public List<Includes> getIncluded()
  {
    List<Includes> newIncluded = Collections.unmodifiableList(included);
    return newIncluded;
  }

  public int numberOfIncluded()
  {
    int number = included.size();
    return number;
  }

  public boolean hasIncluded()
  {
    boolean has = included.size() > 0;
    return has;
  }

  public int indexOfIncluded(Includes aIncluded)
  {
    int index = included.indexOf(aIncluded);
    return index;
  }

  public Includes getInclude(int index)
  {
    Includes aInclude = includes.get(index);
    return aInclude;
  }

  public List<Includes> getIncludes()
  {
    List<Includes> newIncludes = Collections.unmodifiableList(includes);
    return newIncludes;
  }

  public int numberOfIncludes()
  {
    int number = includes.size();
    return number;
  }

  public boolean hasIncludes()
  {
    boolean has = includes.size() > 0;
    return has;
  }

  public int indexOfInclude(Includes aInclude)
  {
    int index = includes.indexOf(aInclude);
    return index;
  }

  public static int minimumNumberOfIncluded()
  {
    return 0;
  }

  public Includes addIncluded(SourceFile aIncluded)
  {
    return new Includes(this, aIncluded);
  }

  public boolean addIncluded(Includes aIncluded)
  {
    boolean wasAdded = false;
    if (included.contains(aIncluded)) { return false; }
    SourceFile existingIncludes = aIncluded.getIncludes();
    boolean isNewIncludes = existingIncludes != null && !this.equals(existingIncludes);
    if (isNewIncludes)
    {
      aIncluded.setIncludes(this);
    }
    else
    {
      included.add(aIncluded);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeIncluded(Includes aIncluded)
  {
    boolean wasRemoved = false;
    //Unable to remove aIncluded, as it must always have a includes
    if (!this.equals(aIncluded.getIncludes()))
    {
      included.remove(aIncluded);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addIncludedAt(Includes aIncluded, int index)
  {  
    boolean wasAdded = false;
    if(addIncluded(aIncluded))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIncluded()) { index = numberOfIncluded() - 1; }
      included.remove(aIncluded);
      included.add(index, aIncluded);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveIncludedAt(Includes aIncluded, int index)
  {
    boolean wasAdded = false;
    if(included.contains(aIncluded))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIncluded()) { index = numberOfIncluded() - 1; }
      included.remove(aIncluded);
      included.add(index, aIncluded);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addIncludedAt(aIncluded, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfIncludes()
  {
    return 0;
  }

  public Includes addInclude(SourceFile aIncludes)
  {
    return new Includes(aIncludes, this);
  }

  public boolean addInclude(Includes aInclude)
  {
    boolean wasAdded = false;
    if (includes.contains(aInclude)) { return false; }
    SourceFile existingIncluded = aInclude.getIncluded();
    boolean isNewIncluded = existingIncluded != null && !this.equals(existingIncluded);
    if (isNewIncluded)
    {
      aInclude.setIncluded(this);
    }
    else
    {
      includes.add(aInclude);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeInclude(Includes aInclude)
  {
    boolean wasRemoved = false;
    //Unable to remove aInclude, as it must always have a included
    if (!this.equals(aInclude.getIncluded()))
    {
      includes.remove(aInclude);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addIncludeAt(Includes aInclude, int index)
  {  
    boolean wasAdded = false;
    if(addInclude(aInclude))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIncludes()) { index = numberOfIncludes() - 1; }
      includes.remove(aInclude);
      includes.add(index, aInclude);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveIncludeAt(Includes aInclude, int index)
  {
    boolean wasAdded = false;
    if(includes.contains(aInclude))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIncludes()) { index = numberOfIncludes() - 1; }
      includes.remove(aInclude);
      includes.add(index, aInclude);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addIncludeAt(aInclude, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=included.size(); i > 0; i--)
    {
      Includes aIncluded = included.get(i - 1);
      aIncluded.delete();
    }
    for(int i=includes.size(); i > 0; i--)
    {
      Includes aInclude = includes.get(i - 1);
      aInclude.delete();
    }
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "path" + ":" + getPath()+ "]"
     + outputString;
  }
}