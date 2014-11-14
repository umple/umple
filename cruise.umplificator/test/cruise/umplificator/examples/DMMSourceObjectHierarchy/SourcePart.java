/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * Positioning
 */
// line 20 "DMMSourceObjectHierarchy.ump"
// line 95 "DMMSourceObjectHierarchy.ump"
public class SourcePart extends SourceObject
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SourcePart Attributes
  private String startLine;
  private String startChar;
  private String endLine;
  private String endChar;

  //SourcePart Associations
  private Contains containedBy;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SourcePart(String aStartLine, String aStartChar, String aEndLine, String aEndChar)
  {
    super();
    startLine = aStartLine;
    startChar = aStartChar;
    endLine = aEndLine;
    endChar = aEndChar;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStartLine(String aStartLine)
  {
    boolean wasSet = false;
    startLine = aStartLine;
    wasSet = true;
    return wasSet;
  }

  public boolean setStartChar(String aStartChar)
  {
    boolean wasSet = false;
    startChar = aStartChar;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndLine(String aEndLine)
  {
    boolean wasSet = false;
    endLine = aEndLine;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndChar(String aEndChar)
  {
    boolean wasSet = false;
    endChar = aEndChar;
    wasSet = true;
    return wasSet;
  }

  public String getStartLine()
  {
    return startLine;
  }

  public String getStartChar()
  {
    return startChar;
  }

  public String getEndLine()
  {
    return endLine;
  }

  public String getEndChar()
  {
    return endChar;
  }

  public Contains getContainedBy()
  {
    return containedBy;
  }

  public boolean hasContainedBy()
  {
    boolean has = containedBy != null;
    return has;
  }

  public boolean setContainedBy(Contains aNewContainedBy)
  {
    boolean wasSet = false;
    if (aNewContainedBy == null)
    {
      Contains existingContainedBy = containedBy;
      containedBy = null;
      
      if (existingContainedBy != null && existingContainedBy.getSourcePart() != null)
      {
        existingContainedBy.setSourcePart(null);
      }
      wasSet = true;
      return wasSet;
    }

    Contains currentContainedBy = getContainedBy();
    if (currentContainedBy != null && !currentContainedBy.equals(aNewContainedBy))
    {
      currentContainedBy.setSourcePart(null);
    }

    containedBy = aNewContainedBy;
    SourcePart existingSourcePart = aNewContainedBy.getSourcePart();

    if (!equals(existingSourcePart))
    {
      aNewContainedBy.setSourcePart(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (containedBy != null)
    {
      containedBy.setSourcePart(null);
    }
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "startLine" + ":" + getStartLine()+ "," +
            "startChar" + ":" + getStartChar()+ "," +
            "endLine" + ":" + getEndLine()+ "," +
            "endChar" + ":" + getEndChar()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "containedBy = "+(getContainedBy()!=null?Integer.toHexString(System.identityHashCode(getContainedBy())):"null")
     + outputString;
  }
}