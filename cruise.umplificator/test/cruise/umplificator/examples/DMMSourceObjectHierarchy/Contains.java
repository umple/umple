/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 28 "DMMSourceObjectHierarchy.ump"
// line 162 "DMMSourceObjectHierarchy.ump"
public class Contains
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Contains Associations
  private SourcePart sourcePart;
  private SourceObject sourceObject;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Contains(SourceObject aSourceObject)
  {
    boolean didAddSourceObject = setSourceObject(aSourceObject);
    if (!didAddSourceObject)
    {
      throw new RuntimeException("Unable to create contain due to sourceObject");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public SourcePart getSourcePart()
  {
    return sourcePart;
  }

  public boolean hasSourcePart()
  {
    boolean has = sourcePart != null;
    return has;
  }

  public SourceObject getSourceObject()
  {
    return sourceObject;
  }

  public boolean setSourcePart(SourcePart aNewSourcePart)
  {
    boolean wasSet = false;
    if (aNewSourcePart == null)
    {
      SourcePart existingSourcePart = sourcePart;
      sourcePart = null;
      
      if (existingSourcePart != null && existingSourcePart.getContainedBy() != null)
      {
        existingSourcePart.setContainedBy(null);
      }
      wasSet = true;
      return wasSet;
    }

    SourcePart currentSourcePart = getSourcePart();
    if (currentSourcePart != null && !currentSourcePart.equals(aNewSourcePart))
    {
      currentSourcePart.setContainedBy(null);
    }

    sourcePart = aNewSourcePart;
    Contains existingContainedBy = aNewSourcePart.getContainedBy();

    if (!equals(existingContainedBy))
    {
      aNewSourcePart.setContainedBy(this);
    }
    wasSet = true;
    return wasSet;
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
      existingSourceObject.removeContain(this);
    }
    sourceObject.addContain(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (sourcePart != null)
    {
      sourcePart.setContainedBy(null);
    }
    SourceObject placeholderSourceObject = sourceObject;
    this.sourceObject = null;
    placeholderSourceObject.removeContain(this);
  }

}