/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 54 "DMMOverview.ump"
// line 100 "DMMOverview.ump"
public class RelationshipInModel extends Relationship
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RelationshipInModel Associations
  private ModelRelationship modelRelationship;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RelationshipInModel(ModelRelationship aModelRelationship)
  {
    super();
    if (aModelRelationship == null || aModelRelationship.getRelationshipInModel() != null)
    {
      throw new RuntimeException("Unable to create RelationshipInModel due to aModelRelationship");
    }
    modelRelationship = aModelRelationship;
  }

  public RelationshipInModel(String aNameForModelRelationship, ModelElement aToModelElem1ForModelRelationship, ModelElement aToModelElem2ForModelRelationship)
  {
    super();
    modelRelationship = new ModelRelationship(aNameForModelRelationship, aToModelElem1ForModelRelationship, aToModelElem2ForModelRelationship, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public ModelRelationship getModelRelationship()
  {
    return modelRelationship;
  }

  public void delete()
  {
    ModelRelationship existingModelRelationship = modelRelationship;
    modelRelationship = null;
    if (existingModelRelationship != null)
    {
      existingModelRelationship.delete();
    }
    super.delete();
  }

}