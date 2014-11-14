/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 22 "DMMOverview.ump"
// line 118 "DMMOverview.ump"
public class Defines
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Defines Associations
  private SourceObject sourceObject;
  private ModelObject modelObject;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Defines(SourceObject aSourceObject, ModelObject aModelObject)
  {
    boolean didAddSourceObject = setSourceObject(aSourceObject);
    if (!didAddSourceObject)
    {
      throw new RuntimeException("Unable to create defines due to sourceObject");
    }
    boolean didAddModelObject = setModelObject(aModelObject);
    if (!didAddModelObject)
    {
      throw new RuntimeException("Unable to create defines due to modelObject");
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
      //Unable to setSourceObject to null, as defines must always be associated to a sourceObject
      return wasSet;
    }
    
    Defines existingDefines = aNewSourceObject.getDefines();
    if (existingDefines != null && !equals(existingDefines))
    {
      //Unable to setSourceObject, the current sourceObject already has a defines, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    SourceObject anOldSourceObject = sourceObject;
    sourceObject = aNewSourceObject;
    sourceObject.setDefines(this);

    if (anOldSourceObject != null)
    {
      anOldSourceObject.setDefines(null);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setModelObject(ModelObject aNewModelObject)
  {
    boolean wasSet = false;
    if (aNewModelObject == null)
    {
      //Unable to setModelObject to null, as defines must always be associated to a modelObject
      return wasSet;
    }
    
    Defines existingDefines = aNewModelObject.getDefines();
    if (existingDefines != null && !equals(existingDefines))
    {
      //Unable to setModelObject, the current modelObject already has a defines, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    ModelObject anOldModelObject = modelObject;
    modelObject = aNewModelObject;
    modelObject.setDefines(this);

    if (anOldModelObject != null)
    {
      anOldModelObject.setDefines(null);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    SourceObject existingSourceObject = sourceObject;
    sourceObject = null;
    if (existingSourceObject != null)
    {
      existingSourceObject.setDefines(null);
    }
    ModelObject existingModelObject = modelObject;
    modelObject = null;
    if (existingModelObject != null)
    {
      existingModelObject.setDefines(null);
    }
  }

}