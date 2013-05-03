/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.compiler;

/**
 * class GeneratedInterface
 * {
 * isA GeneratedElement;
 * //code = null;
 * -> 1 UmpleModel model;
 * 0..1 -> 1 UmpleInterface uInterface;
 * }
 * A point in cartesian coordinates, used in representing the layout of a
 * diagram in Umple
 * @umplesource Umple.ump 608
 * @umplesource Umple_Code.ump 1704
 */
// line 608 "../../../../src/Umple.ump"
// line 1704 "../../../../src/Umple_Code.ump"
public class Point
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Point Attributes
  private int x;
  private int y;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetX;
  private boolean canSetY;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Point(int aX, int aY)
  {
    cachedHashCode = -1;
    canSetX = true;
    canSetY = true;
    x = aX;
    y = aY;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setX(int aX)
  {
    boolean wasSet = false;
    if (!canSetX) { return false; }
    x = aX;
    wasSet = true;
    return wasSet;
  }

  public boolean setY(int aY)
  {
    boolean wasSet = false;
    if (!canSetY) { return false; }
    y = aY;
    wasSet = true;
    return wasSet;
  }

  public int getX()
  {
    return x;
  }

  public int getY()
  {
    return y;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Point compareTo = (Point)obj;
  
    if (x != compareTo.x)
    {
      return false;
    }

    if (y != compareTo.y)
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    cachedHashCode = cachedHashCode * 23 + x;

    cachedHashCode = cachedHashCode * 23 + y;

    canSetX = false;
    canSetY = false;
    return cachedHashCode;
  }

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 1707 ../../../../src/Umple_Code.ump
  public static Point create(int n)
  {
    int p = (int)Math.sqrt(n) + 1;
    if (n - (p-2)*p <= p)
    {
      return new Point(n - (p-2)*p, p);
    }
    else
    {
      return new Point(p, n - (p-1) * p);
    }
  }

  public String toString()
  {
    return "(" + getX() + "," + getY() + ")";
  }
}