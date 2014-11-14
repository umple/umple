/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 33 "GeographicalInformationSystem.ump"
// line 67 "GeographicalInformationSystem.ump"
public class FeatureType
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //FeatureType Attributes
  private String description;

  //FeatureType Associations
  private List<Feature> features;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public FeatureType(String aDescription)
  {
    description = aDescription;
    features = new ArrayList<Feature>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public String getDescription()
  {
    return description;
  }

  public Feature getFeature(int index)
  {
    Feature aFeature = features.get(index);
    return aFeature;
  }

  public List<Feature> getFeatures()
  {
    List<Feature> newFeatures = Collections.unmodifiableList(features);
    return newFeatures;
  }

  public int numberOfFeatures()
  {
    int number = features.size();
    return number;
  }

  public boolean hasFeatures()
  {
    boolean has = features.size() > 0;
    return has;
  }

  public int indexOfFeature(Feature aFeature)
  {
    int index = features.indexOf(aFeature);
    return index;
  }

  public static int minimumNumberOfFeatures()
  {
    return 0;
  }

  public Feature addFeature(String aName, Map aMap)
  {
    return new Feature(aName, aMap, this);
  }

  public boolean addFeature(Feature aFeature)
  {
    boolean wasAdded = false;
    if (features.contains(aFeature)) { return false; }
    if (features.contains(aFeature)) { return false; }
    if (features.contains(aFeature)) { return false; }
    FeatureType existingFeatureType = aFeature.getFeatureType();
    boolean isNewFeatureType = existingFeatureType != null && !this.equals(existingFeatureType);
    if (isNewFeatureType)
    {
      aFeature.setFeatureType(this);
    }
    else
    {
      features.add(aFeature);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeFeature(Feature aFeature)
  {
    boolean wasRemoved = false;
    //Unable to remove aFeature, as it must always have a featureType
    if (!this.equals(aFeature.getFeatureType()))
    {
      features.remove(aFeature);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addFeatureAt(Feature aFeature, int index)
  {  
    boolean wasAdded = false;
    if(addFeature(aFeature))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFeatures()) { index = numberOfFeatures() - 1; }
      features.remove(aFeature);
      features.add(index, aFeature);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveFeatureAt(Feature aFeature, int index)
  {
    boolean wasAdded = false;
    if(features.contains(aFeature))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFeatures()) { index = numberOfFeatures() - 1; }
      features.remove(aFeature);
      features.add(index, aFeature);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addFeatureAt(aFeature, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=features.size(); i > 0; i--)
    {
      Feature aFeature = features.get(i - 1);
      aFeature.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "description" + ":" + getDescription()+ "]"
     + outputString;
  }
}