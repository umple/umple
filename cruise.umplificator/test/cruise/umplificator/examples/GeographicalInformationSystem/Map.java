/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * Positioning
 */
// line 9 "GeographicalInformationSystem.ump"
// line 56 "GeographicalInformationSystem.ump"
public class Map
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Map Attributes
  private String scale;
  private String name;
  private String lattitude;
  private String longitude;
  private String height;
  private String width;

  //Map Associations
  private List<Feature> features;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Map(String aScale, String aName, String aLattitude, String aLongitude, String aHeight, String aWidth)
  {
    scale = aScale;
    name = aName;
    lattitude = aLattitude;
    longitude = aLongitude;
    height = aHeight;
    width = aWidth;
    features = new ArrayList<Feature>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setScale(String aScale)
  {
    boolean wasSet = false;
    scale = aScale;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setLattitude(String aLattitude)
  {
    boolean wasSet = false;
    lattitude = aLattitude;
    wasSet = true;
    return wasSet;
  }

  public boolean setLongitude(String aLongitude)
  {
    boolean wasSet = false;
    longitude = aLongitude;
    wasSet = true;
    return wasSet;
  }

  public boolean setHeight(String aHeight)
  {
    boolean wasSet = false;
    height = aHeight;
    wasSet = true;
    return wasSet;
  }

  public boolean setWidth(String aWidth)
  {
    boolean wasSet = false;
    width = aWidth;
    wasSet = true;
    return wasSet;
  }

  public String getScale()
  {
    return scale;
  }

  public String getName()
  {
    return name;
  }

  public String getLattitude()
  {
    return lattitude;
  }

  public String getLongitude()
  {
    return longitude;
  }

  public String getHeight()
  {
    return height;
  }

  public String getWidth()
  {
    return width;
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

  public Feature addFeature(String aName, FeatureType aFeatureType)
  {
    return new Feature(aName, this, aFeatureType);
  }

  public boolean addFeature(Feature aFeature)
  {
    boolean wasAdded = false;
    if (features.contains(aFeature)) { return false; }
    Map existingMap = aFeature.getMap();
    boolean isNewMap = existingMap != null && !this.equals(existingMap);
    if (isNewMap)
    {
      aFeature.setMap(this);
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
    //Unable to remove aFeature, as it must always have a map
    if (!this.equals(aFeature.getMap()))
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
            "scale" + ":" + getScale()+ "," +
            "name" + ":" + getName()+ "," +
            "lattitude" + ":" + getLattitude()+ "," +
            "longitude" + ":" + getLongitude()+ "," +
            "height" + ":" + getHeight()+ "," +
            "width" + ":" + getWidth()+ "]"
     + outputString;
  }
}