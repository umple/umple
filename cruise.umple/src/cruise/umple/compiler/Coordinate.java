/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.605 modeling language!*/

package cruise.umple.compiler;

public class Coordinate
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Coordinate Attributes
  private int x;
  private int y;
  private int width;
  private int height;

  //Coordinate State Machines
  enum Status { Explicit, Undefined, Defaulted }
  private Status status;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetX;
  private boolean canSetY;
  private boolean canSetWidth;
  private boolean canSetHeight;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Coordinate(int aX, int aY, int aWidth, int aHeight)
  {
    x = aX;
    y = aY;
    width = aWidth;
    height = aHeight;
    setStatus(Status.Explicit);
    cachedHashCode = -1;
    canSetX = true;
    canSetY = true;
    canSetWidth = true;
    canSetHeight = true;
    updateStatus();
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
    if(wasSet) updateStatus();
    return wasSet;
  }

  public boolean setY(int aY)
  {
    boolean wasSet = false;
    if (!canSetY) { return false; }
    y = aY;
    wasSet = true;
    if(wasSet) updateStatus();
    return wasSet;
  }

  public boolean setWidth(int aWidth)
  {
    boolean wasSet = false;
    if (!canSetWidth) { return false; }
    width = aWidth;
    wasSet = true;
    if(wasSet) updateStatus();
    return wasSet;
  }

  public boolean setHeight(int aHeight)
  {
    boolean wasSet = false;
    if (!canSetHeight) { return false; }
    height = aHeight;
    wasSet = true;
    if(wasSet) updateStatus();
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

  public int getWidth()
  {
    return width;
  }

  public int getHeight()
  {
    return height;
  }

  public String getStatusFullName()
  {
    String answer = status.toString();
    return answer;
  }

  public Status getStatus()
  {
    return status;
  }

  public boolean setStatus(Status aStatus)
  {
    status = aStatus;
    return true;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Coordinate compareTo = (Coordinate)obj;
  
    if (x != compareTo.x)
    {
      return false;
    }

    if (y != compareTo.y)
    {
      return false;
    }

    if (width != compareTo.width)
    {
      return false;
    }

    if (height != compareTo.height)
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

    cachedHashCode = cachedHashCode * 23 + width;

    cachedHashCode = cachedHashCode * 23 + height;

    canSetX = false;
    canSetY = false;
    canSetWidth = false;
    canSetHeight = false;
    return cachedHashCode;
  }

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public Point getTopLeft()
  {
    return new Point(x,y);
  }
  
  public Point getTopRight()
  {
    return new Point(x+width,y);
  }
  
  public Point getBottomLeft()
  {
    return new Point(x,y+height);
  }
  
  public Point getBottomRight()
  {
    return new Point(x+width,y+height);
  }
  
  public Point getTopMiddle()
  {
    return new Point(x+width/2,y);
  }
  
  public Point getBottomMiddle()
  {
    return new Point(x+width/2,y+height);
  }
  
  public Point getRightMiddle()
  {
    return new Point(x+width,y+height/2);
  }
  
  public Point getLeftMiddle()
  {
    return new Point(x,y+height/2);
  }
  
  public String whereIs(Coordinate neighbour)
  {
    int topDeltaY = getTopMiddle().getY() - neighbour.getBottomMiddle().getY();
    int topDeltaX = getTopMiddle().getX() - neighbour.getBottomMiddle().getX();

    int bottomDeltaY = neighbour.getTopMiddle().getY() - getBottomMiddle().getY();
    int bottomDeltaX = getBottomMiddle().getX() - neighbour.getTopMiddle().getX(); 

    if (topDeltaY > 0 && Math.abs(topDeltaY) > Math.abs(topDeltaX))
    {
      return "top";
    }
    else if (bottomDeltaY > 0 && Math.abs(bottomDeltaY) > Math.abs(bottomDeltaX))
    {
      return "bottom";
    }
    else if (neighbour.getX() < getX())
    {
      return "left";
    }
    else
    {
      return "right";
    }
  }
  
  public int distanceTo(Coordinate other)
  {
    int a = other.getX() - getX();
    int b = other.getY() - getY();
    int c = (int) Math.round(Math.sqrt(Math.pow(a,2) + Math.pow(b,2)));
    return c; 
  }
  
  public String toString()
  {
    return "(" + getX() + "," + getY() + "," + getWidth() + "," + getHeight() + ")";
  }
  
  private void updateStatus()
  {
    if (x == -1 && y == -1 && width == -1 && height == -1)
    {
      setStatus(Status.Undefined);
    }
    else 
    {
      setStatus(Status.Explicit);
    }
  }
}