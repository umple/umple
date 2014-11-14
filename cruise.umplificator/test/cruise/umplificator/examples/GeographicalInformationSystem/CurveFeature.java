/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 26 "GeographicalInformationSystem.ump"
// line 100 "GeographicalInformationSystem.ump"
public class CurveFeature extends Feature
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CurveFeature Associations
  private List<Point> points;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CurveFeature(String aName, Map aMap, FeatureType aFeatureType)
  {
    super(aName, aMap, aFeatureType);
    points = new ArrayList<Point>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Point getPoint(int index)
  {
    Point aPoint = points.get(index);
    return aPoint;
  }

  public List<Point> getPoints()
  {
    List<Point> newPoints = Collections.unmodifiableList(points);
    return newPoints;
  }

  public int numberOfPoints()
  {
    int number = points.size();
    return number;
  }

  public boolean hasPoints()
  {
    boolean has = points.size() > 0;
    return has;
  }

  public int indexOfPoint(Point aPoint)
  {
    int index = points.indexOf(aPoint);
    return index;
  }

  public static int minimumNumberOfPoints()
  {
    return 0;
  }

  public boolean addPoint(Point aPoint)
  {
    boolean wasAdded = false;
    if (points.contains(aPoint)) { return false; }
    if (points.contains(aPoint)) { return false; }
    points.add(aPoint);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePoint(Point aPoint)
  {
    boolean wasRemoved = false;
    if (points.contains(aPoint))
    {
      points.remove(aPoint);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addPointAt(Point aPoint, int index)
  {  
    boolean wasAdded = false;
    if(addPoint(aPoint))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPoints()) { index = numberOfPoints() - 1; }
      points.remove(aPoint);
      points.add(index, aPoint);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePointAt(Point aPoint, int index)
  {
    boolean wasAdded = false;
    if(points.contains(aPoint))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPoints()) { index = numberOfPoints() - 1; }
      points.remove(aPoint);
      points.add(index, aPoint);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPointAt(aPoint, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    points.clear();
    super.delete();
  }

}