/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;

/**
 * A Coordinate is used in  the layout of classes
 * It represents the shape of a class box in a diagram
 * 
 * @umplesource Umple.ump 654
 * @umplesource Umple_Code.ump 2007
 */
// line 654 "../../../../src/Umple.ump"
// line 2007 "../../../../src/Umple_Code.ump"
public class Coordinate
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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

  @umplesourcefile(line={663},file={"Umple.ump"},javaline={59},length={1})
  public Coordinate(int aX, int aY, int aWidth, int aHeight)
  {
    cachedHashCode = -1;
    canSetX = true;
    canSetY = true;
    canSetWidth = true;
    canSetHeight = true;
    x = aX;
    y = aY;
    width = aWidth;
    height = aHeight;
    setStatus(Status.Explicit);
    // line 663 "../../../../src/Umple.ump"
    updateStatus();
  }

  //------------------------
  // INTERFACE
  //------------------------

  @umplesourcefile(line={664},file={"Umple.ump"},javaline={74},length={1})
  public boolean setX(int aX)
  {
    boolean wasSet = false;
    if (!canSetX) { return false; }
    x = aX;
    wasSet = true;
    // line 664 "../../../../src/Umple.ump"
    if(wasSet) updateStatus();
    return wasSet;
  }

  @umplesourcefile(line={665},file={"Umple.ump"},javaline={85},length={1})
  public boolean setY(int aY)
  {
    boolean wasSet = false;
    if (!canSetY) { return false; }
    y = aY;
    wasSet = true;
    // line 665 "../../../../src/Umple.ump"
    if(wasSet) updateStatus();
    return wasSet;
  }

  @umplesourcefile(line={666},file={"Umple.ump"},javaline={96},length={1})
  public boolean setWidth(int aWidth)
  {
    boolean wasSet = false;
    if (!canSetWidth) { return false; }
    width = aWidth;
    wasSet = true;
    // line 666 "../../../../src/Umple.ump"
    if(wasSet) updateStatus();
    return wasSet;
  }

  @umplesourcefile(line={667},file={"Umple.ump"},javaline={107},length={1})
  public boolean setHeight(int aHeight)
  {
    boolean wasSet = false;
    if (!canSetHeight) { return false; }
    height = aHeight;
    wasSet = true;
    // line 667 "../../../../src/Umple.ump"
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

  @umplesourcefile(line={2011},file={"Umple_Code.ump"},javaline={207},length={3})
   public Point getTopLeft(){
    return new Point(x,y);
  }

  @umplesourcefile(line={2016},file={"Umple_Code.ump"},javaline={212},length={3})
   public Point getTopRight(){
    return new Point(x+width,y);
  }

  @umplesourcefile(line={2021},file={"Umple_Code.ump"},javaline={217},length={3})
   public Point getBottomLeft(){
    return new Point(x,y+height);
  }

  @umplesourcefile(line={2026},file={"Umple_Code.ump"},javaline={222},length={3})
   public Point getBottomRight(){
    return new Point(x+width,y+height);
  }

  @umplesourcefile(line={2031},file={"Umple_Code.ump"},javaline={227},length={3})
   public Point getTopMiddle(){
    return new Point(x+width/2,y);
  }

  @umplesourcefile(line={2036},file={"Umple_Code.ump"},javaline={232},length={3})
   public Point getBottomMiddle(){
    return new Point(x+width/2,y+height);
  }

  @umplesourcefile(line={2041},file={"Umple_Code.ump"},javaline={237},length={3})
   public Point getRightMiddle(){
    return new Point(x+width,y+height/2);
  }

  @umplesourcefile(line={2046},file={"Umple_Code.ump"},javaline={242},length={3})
   public Point getLeftMiddle(){
    return new Point(x,y+height/2);
  }

  @umplesourcefile(line={2051},file={"Umple_Code.ump"},javaline={247},length={24})
   public String whereIs(Coordinate neighbour){
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

  @umplesourcefile(line={2077},file={"Umple_Code.ump"},javaline={273},length={6})
   public int distanceTo(Coordinate other){
    int a = other.getX() - getX();
    int b = other.getY() - getY();
    int c = (int) Math.round(Math.sqrt(Math.pow(a,2) + Math.pow(b,2)));
    return c;
  }

  @umplesourcefile(line={2085},file={"Umple_Code.ump"},javaline={281},length={3})
   public String toString(){
    return "(" + getX() + "," + getY() + "," + getWidth() + "," + getHeight() + ")";
  }

  @umplesourcefile(line={2090},file={"Umple_Code.ump"},javaline={286},length={10})
   private void updateStatus(){
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