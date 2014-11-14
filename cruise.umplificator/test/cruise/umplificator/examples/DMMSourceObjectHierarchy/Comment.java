/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 72 "DMMSourceObjectHierarchy.ump"
// line 130 "DMMSourceObjectHierarchy.ump"
public class Comment extends SourcePart
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Comment Associations
  private Describes foundIn;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Comment(String aStartLine, String aStartChar, String aEndLine, String aEndChar)
  {
    super(aStartLine, aStartChar, aEndLine, aEndChar);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Describes getFoundIn()
  {
    return foundIn;
  }

  public boolean hasFoundIn()
  {
    boolean has = foundIn != null;
    return has;
  }

  public boolean setFoundIn(Describes aNewFoundIn)
  {
    boolean wasSet = false;
    if (aNewFoundIn == null)
    {
      Describes existingFoundIn = foundIn;
      foundIn = null;
      
      if (existingFoundIn != null && existingFoundIn.getComment() != null)
      {
        existingFoundIn.setComment(null);
      }
      wasSet = true;
      return wasSet;
    }

    Describes currentFoundIn = getFoundIn();
    if (currentFoundIn != null && !currentFoundIn.equals(aNewFoundIn))
    {
      currentFoundIn.setComment(null);
    }

    foundIn = aNewFoundIn;
    Comment existingComment = aNewFoundIn.getComment();

    if (!equals(existingComment))
    {
      aNewFoundIn.setComment(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (foundIn != null)
    {
      foundIn.setComment(null);
    }
    super.delete();
  }

}