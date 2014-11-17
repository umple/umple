/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 27 "DMMOverview.ump"
// line 111 "DMMOverview.ump"
public class Declares
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Declares Associations
  private SourceObject sourceObject;
  private ModelObject modelObject;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Declares(SourceObject aSourceObject, ModelObject aModelObject)
  {
    boolean didAddSourceObject = setSourceObject(aSourceObject);
    if (!didAddSourceObject)
    {
      throw new RuntimeException("Unable to create declares due to sourceObject");
    }
    boolean didAddModelObject = setModelObject(aModelObject);
    if (!didAddModelObject)
    {
      throw new RuntimeException("Unable to create declare due to modelObject");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public SourceObject getSourceObject()
  {
    return sourceObject;
  }

  public ModelObject getModelObject()
  {
    return modelObject;
  }

  public boolean setSourceObject(SourceObject aNewSourceObject)
  {
    boolean wasSet = false;
    if (aNewSourceObject == null)
    {
      //Unable to setSourceObject to null, as declares must always be associated to a sourceObject
      return wasSet;
    }
    
    Declares existingDeclares = aNewSourceObject.getDeclares();
    if (existingDeclares != null && !equals(existingDeclares))
    {
      //Unable to setSourceObject, the current sourceObject already has a declares, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    SourceObject anOldSourceObject = sourceObject;
    sourceObject = aNewSourceObject;
    sourceObject.setDeclares(this);

    if (anOldSourceObject != null)
    {
      anOldSourceObject.setDeclares(null);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setModelObject(ModelObject aModelObject)
  {
    boolean wasSet = false;
    if (aModelObject == null)
    {
      return wasSet;
    }

    ModelObject existingModelObject = modelObject;
    modelObject = aModelObject;
    if (existingModelObject != null && !existingModelObject.equals(aModelObject))
    {
      existingModelObject.removeDeclare(this);
    }
    modelObject.addDeclare(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    SourceObject existingSourceObject = sourceObject;
    sourceObject = null;
    if (existingSourceObject != null)
    {
      existingSourceObject.setDeclares(null);
    }
    ModelObject placeholderModelObject = modelObject;
    this.modelObject = null;
    placeholderModelObject.removeDeclare(this);
  }

}