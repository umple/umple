/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.605 modeling language!*/

package cruise.vml;
import java.util.*;

public class VmlSystem
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //VmlSystem Attributes
  private String code;

  //VmlSystem Associations
  private List<CodeSnippet> codeSnippets;
  private List<Concern> concerns;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public VmlSystem()
  {
    code = null;
    codeSnippets = new ArrayList<CodeSnippet>();
    concerns = new ArrayList<Concern>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCode(String aCode)
  {
    boolean wasSet = false;
    code = aCode;
    wasSet = true;
    return wasSet;
  }

  public String getCode()
  {
    code = "";
    for (CodeSnippet snippet : codeSnippets)
    {
      code += snippet.getCode();
      code += "\n";
    }
    return code;
  }

  public CodeSnippet getCodeSnippet(int index)
  {
    CodeSnippet aCodeSnippet = codeSnippets.get(index);
    return aCodeSnippet;
  }

  public List<CodeSnippet> getCodeSnippets()
  {
    List<CodeSnippet> newCodeSnippets = Collections.unmodifiableList(codeSnippets);
    return newCodeSnippets;
  }

  public int numberOfCodeSnippets()
  {
    int number = codeSnippets.size();
    return number;
  }

  public boolean hasCodeSnippets()
  {
    boolean has = codeSnippets.size() > 0;
    return has;
  }

  public int indexOfCodeSnippet(CodeSnippet aCodeSnippet)
  {
    int index = codeSnippets.indexOf(aCodeSnippet);
    return index;
  }

  public Concern getConcern(int index)
  {
    Concern aConcern = concerns.get(index);
    return aConcern;
  }

  public List<Concern> getConcerns()
  {
    List<Concern> newConcerns = Collections.unmodifiableList(concerns);
    return newConcerns;
  }

  public int numberOfConcerns()
  {
    int number = concerns.size();
    return number;
  }

  public boolean hasConcerns()
  {
    boolean has = concerns.size() > 0;
    return has;
  }

  public int indexOfConcern(Concern aConcern)
  {
    int index = concerns.indexOf(aConcern);
    return index;
  }

  public static int minimumNumberOfCodeSnippets()
  {
    return 0;
  }

  public boolean addCodeSnippet(CodeSnippet aCodeSnippet)
  {
    boolean wasAdded = false;
    if (codeSnippets.contains(aCodeSnippet)) { return false; }
    codeSnippets.add(aCodeSnippet);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCodeSnippet(CodeSnippet aCodeSnippet)
  {
    boolean wasRemoved = false;
    if (codeSnippets.contains(aCodeSnippet))
    {
      codeSnippets.remove(aCodeSnippet);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public static int minimumNumberOfConcerns()
  {
    return 0;
  }

  public boolean addConcern(Concern aConcern)
  {
    boolean wasAdded = false;
    if (concerns.contains(aConcern)) { return false; }
    VmlSystem existingVmlSystem = aConcern.getVmlSystem();
    if (existingVmlSystem == null)
    {
      aConcern.setVmlSystem(this);
    }
    else if (!this.equals(existingVmlSystem))
    {
      existingVmlSystem.removeConcern(aConcern);
      addConcern(aConcern);
    }
    else
    {
      concerns.add(aConcern);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeConcern(Concern aConcern)
  {
    boolean wasRemoved = false;
    if (concerns.contains(aConcern))
    {
      concerns.remove(aConcern);
      aConcern.setVmlSystem(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public void delete()
  {
    codeSnippets.clear();
    for(Concern aConcern : concerns)
    {
      aConcern.setVmlSystem(null);
    }
  }

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public Concern getConcern(String concernName)
  {
    if (concernName == null)
    {
      return null;
    }
    for (Concern c : getConcerns())
    {
      if (concernName.equals(c.getName()))
      {
        return c;
      }
    }
    return null;
  }
}