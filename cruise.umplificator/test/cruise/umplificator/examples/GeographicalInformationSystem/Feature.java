/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 15 "GeographicalInformationSystem.ump"
// line 78 "GeographicalInformationSystem.ump"
public class Feature
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Feature Attributes
  private String name;

  //Feature Associations
  private Map map;
  private FeatureType featureType;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Feature(String aName, Map aMap, FeatureType aFeatureType)
  {
    name = aName;
    boolean didAddMap = setMap(aMap);
    if (!didAddMap)
    {
      throw new RuntimeException("Unable to create feature due to map");
    }
    boolean didAddFeatureType = setFeatureType(aFeatureType);
    if (!didAddFeatureType)
    {
      throw new RuntimeException("Unable to create feature due to featureType");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public Map getMap()
  {
    return map;
  }

  public FeatureType getFeatureType()
  {
    return featureType;
  }

  public boolean setMap(Map aMap)
  {
    boolean wasSet = false;
    if (aMap == null)
    {
      return wasSet;
    }

    Map existingMap = map;
    map = aMap;
    if (existingMap != null && !existingMap.equals(aMap))
    {
      existingMap.removeFeature(this);
    }
    map.addFeature(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setFeatureType(FeatureType aFeatureType)
  {
    boolean wasSet = false;
    if (aFeatureType == null)
    {
      return wasSet;
    }

    FeatureType existingFeatureType = featureType;
    featureType = aFeatureType;
    if (existingFeatureType != null && !existingFeatureType.equals(aFeatureType))
    {
      existingFeatureType.removeFeature(this);
    }
    featureType.addFeature(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Map placeholderMap = map;
    this.map = null;
    placeholderMap.removeFeature(this);
    FeatureType placeholderFeatureType = featureType;
    this.featureType = null;
    placeholderFeatureType.removeFeature(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "map = "+(getMap()!=null?Integer.toHexString(System.identityHashCode(getMap())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "featureType = "+(getFeatureType()!=null?Integer.toHexString(System.identityHashCode(getFeatureType())):"null")
     + outputString;
  }
}