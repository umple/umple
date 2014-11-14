/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 48 "DMMOverview.ump"
// line 75 "DMMOverview.ump"
public class ModelRelationship extends ModelObject
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ModelRelationship Associations
  private ModelElement toModelElem1;
  private ModelElement toModelElem2;
  private RelationshipInModel relationshipInModel;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ModelRelationship(String aName, ModelElement aToModelElem1, ModelElement aToModelElem2, RelationshipInModel aRelationshipInModel)
  {
    super(aName);
    boolean didAddToModelElem1 = setToModelElem1(aToModelElem1);
    if (!didAddToModelElem1)
    {
      throw new RuntimeException("Unable to create toModelRel1 due to toModelElem1");
    }
    boolean didAddToModelElem2 = setToModelElem2(aToModelElem2);
    if (!didAddToModelElem2)
    {
      throw new RuntimeException("Unable to create toModelRel2 due to toModelElem2");
    }
    if (aRelationshipInModel == null || aRelationshipInModel.getModelRelationship() != null)
    {
      throw new RuntimeException("Unable to create ModelRelationship due to aRelationshipInModel");
    }
    relationshipInModel = aRelationshipInModel;
  }

  public ModelRelationship(String aName, ModelElement aToModelElem1, ModelElement aToModelElem2)
  {
    super(aName);
    boolean didAddToModelElem1 = setToModelElem1(aToModelElem1);
    if (!didAddToModelElem1)
    {
      throw new RuntimeException("Unable to create toModelRel1 due to toModelElem1");
    }
    boolean didAddToModelElem2 = setToModelElem2(aToModelElem2);
    if (!didAddToModelElem2)
    {
      throw new RuntimeException("Unable to create toModelRel2 due to toModelElem2");
    }
    relationshipInModel = new RelationshipInModel(this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public ModelElement getToModelElem1()
  {
    return toModelElem1;
  }

  public ModelElement getToModelElem2()
  {
    return toModelElem2;
  }

  public RelationshipInModel getRelationshipInModel()
  {
    return relationshipInModel;
  }

  public boolean setToModelElem1(ModelElement aToModelElem1)
  {
    boolean wasSet = false;
    if (aToModelElem1 == null)
    {
      return wasSet;
    }

    ModelElement existingToModelElem1 = toModelElem1;
    toModelElem1 = aToModelElem1;
    if (existingToModelElem1 != null && !existingToModelElem1.equals(aToModelElem1))
    {
      existingToModelElem1.removeToModelRel1(this);
    }
    toModelElem1.addToModelRel1(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setToModelElem2(ModelElement aToModelElem2)
  {
    boolean wasSet = false;
    if (aToModelElem2 == null)
    {
      return wasSet;
    }

    ModelElement existingToModelElem2 = toModelElem2;
    toModelElem2 = aToModelElem2;
    if (existingToModelElem2 != null && !existingToModelElem2.equals(aToModelElem2))
    {
      existingToModelElem2.removeToModelRel2(this);
    }
    toModelElem2.addToModelRel2(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ModelElement placeholderToModelElem1 = toModelElem1;
    this.toModelElem1 = null;
    placeholderToModelElem1.removeToModelRel1(this);
    ModelElement placeholderToModelElem2 = toModelElem2;
    this.toModelElem2 = null;
    placeholderToModelElem2.removeToModelRel2(this);
    RelationshipInModel existingRelationshipInModel = relationshipInModel;
    relationshipInModel = null;
    if (existingRelationshipInModel != null)
    {
      existingRelationshipInModel.delete();
    }
    super.delete();
  }

}