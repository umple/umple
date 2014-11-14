/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 76 "DMMSourceObjectHierarchy.ump"
// line 155 "DMMSourceObjectHierarchy.ump"
public class Describes
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Describes Associations
  private SourceObject sourceObject;
  private Comment comment;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Describes(SourceObject aSourceObject)
  {
    boolean didAddSourceObject = setSourceObject(aSourceObject);
    if (!didAddSourceObject)
    {
      throw new RuntimeException("Unable to create describe due to sourceObject");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public SourceObject getSourceObject()
  {
    return sourceObject;
  }

  public Comment getComment()
  {
    return comment;
  }

  public boolean hasComment()
  {
    boolean has = comment != null;
    return has;
  }

  public boolean setSourceObject(SourceObject aSourceObject)
  {
    boolean wasSet = false;
    if (aSourceObject == null)
    {
      return wasSet;
    }

    SourceObject existingSourceObject = sourceObject;
    sourceObject = aSourceObject;
    if (existingSourceObject != null && !existingSourceObject.equals(aSourceObject))
    {
      existingSourceObject.removeDescribe(this);
    }
    sourceObject.addDescribe(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setComment(Comment aNewComment)
  {
    boolean wasSet = false;
    if (aNewComment == null)
    {
      Comment existingComment = comment;
      comment = null;
      
      if (existingComment != null && existingComment.getFoundIn() != null)
      {
        existingComment.setFoundIn(null);
      }
      wasSet = true;
      return wasSet;
    }

    Comment currentComment = getComment();
    if (currentComment != null && !currentComment.equals(aNewComment))
    {
      currentComment.setFoundIn(null);
    }

    comment = aNewComment;
    Describes existingFoundIn = aNewComment.getFoundIn();

    if (!equals(existingFoundIn))
    {
      aNewComment.setFoundIn(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    SourceObject placeholderSourceObject = sourceObject;
    this.sourceObject = null;
    placeholderSourceObject.removeDescribe(this);
    if (comment != null)
    {
      comment.setFoundIn(null);
    }
  }

}