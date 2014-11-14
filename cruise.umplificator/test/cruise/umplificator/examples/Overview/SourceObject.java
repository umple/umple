/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 19 "DMMOverview.ump"
// line 106 "DMMOverview.ump"
public class SourceObject
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SourceObject Associations
  private Defines defines;
  private Declares declares;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SourceObject()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public Defines getDefines()
  {
    return defines;
  }

  public boolean hasDefines()
  {
    boolean has = defines != null;
    return has;
  }

  public Declares getDeclares()
  {
    return declares;
  }

  public boolean hasDeclares()
  {
    boolean has = declares != null;
    return has;
  }

  public boolean setDefines(Defines aNewDefines)
  {
    boolean wasSet = false;
    if (defines != null && !defines.equals(aNewDefines) && equals(defines.getSourceObject()))
    {
      //Unable to setDefines, as existing defines would become an orphan
      return wasSet;
    }

    defines = aNewDefines;
    SourceObject anOldSourceObject = aNewDefines != null ? aNewDefines.getSourceObject() : null;

    if (!this.equals(anOldSourceObject))
    {
      if (anOldSourceObject != null)
      {
        anOldSourceObject.defines = null;
      }
      if (defines != null)
      {
        defines.setSourceObject(this);
      }
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setDeclares(Declares aNewDeclares)
  {
    boolean wasSet = false;
    if (declares != null && !declares.equals(aNewDeclares) && equals(declares.getSourceObject()))
    {
      //Unable to setDeclares, as existing declares would become an orphan
      return wasSet;
    }

    declares = aNewDeclares;
    SourceObject anOldSourceObject = aNewDeclares != null ? aNewDeclares.getSourceObject() : null;

    if (!this.equals(anOldSourceObject))
    {
      if (anOldSourceObject != null)
      {
        anOldSourceObject.declares = null;
      }
      if (declares != null)
      {
        declares.setSourceObject(this);
      }
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Defines existingDefines = defines;
    defines = null;
    if (existingDefines != null)
    {
      existingDefines.delete();
    }
    Declares existingDeclares = declares;
    declares = null;
    if (existingDeclares != null)
    {
      existingDeclares.delete();
    }
  }

}