/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 19 "GeographicalInformationSystem.ump"
// line 111 "GeographicalInformationSystem.ump"
public class PointFeature extends Feature
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PointFeature Associations
  private Point point;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PointFeature(String aName, Map aMap, FeatureType aFeatureType, Point aPoint)
  {
    super(aName, aMap, aFeatureType);
    if (!setPoint(aPoint))
    {
      throw new RuntimeException("Unable to create PointFeature due to aPoint");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Point getPoint()
  {
    return point;
  }

  public boolean setPoint(Point aNewPoint)
  {
    boolean wasSet = false;
    if (aNewPoint != null)
    {
      point = aNewPoint;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    point = null;
    super.delete();
  }

}