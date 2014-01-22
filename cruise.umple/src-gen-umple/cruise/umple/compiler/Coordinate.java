/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;

/**
 * A Coordinate is used in  the layout of classes
 * It represents the shape of a class box in a diagram
 * 
 * @umplesource Umple.ump 658
 * @umplesource Umple_Code.ump 2032
 */
// line 658 "../../../../src/Umple.ump"
// line 2032 "../../../../src/Umple_Code.ump"
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

  @umplesourcefile(line={667},file={"Umple.ump"},javaline={59},length={1})
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
    // line 667 "../../../../src/Umple.ump"
    updateStatus();
  }

  //------------------------
  // INTERFACE
  //------------------------

  @umplesourcefile(line={668},file={"Umple.ump"},javaline={74},length={1})
  public boolean setX(int aX)
  {
    boolean wasSet = false;
    if (!canSetX) { return false; }
    x = aX;
    wasSet = true;
    // line 668 "../../../../src/Umple.ump"
    if(wasSet) updateStatus();
    return wasSet;
  }

  @umplesourcefile(line={669},file={"Umple.ump"},javaline={85},length={1})
  public boolean setY(int aY)
  {
    boolean wasSet = false;
    if (!canSetY) { return false; }
    y = aY;
    wasSet = true;
    // line 669 "../../../../src/Umple.ump"
    if(wasSet) updateStatus();
    return wasSet;
  }

  @umplesourcefile(line={670},file={"Umple.ump"},javaline={96},length={1})
  public boolean setWidth(int aWidth)
  {
    boolean wasSet = false;
    if (!canSetWidth) { return false; }
    width = aWidth;
    wasSet = true;
    // line 670 "../../../../src/Umple.ump"
    if(wasSet) updateStatus();
    return wasSet;
  }

  @umplesourcefile(line={671},file={"Umple.ump"},javaline={107},length={1})
  public boolean setHeight(int aHeight)
  {
    boolean wasSet = false;
    if (!canSetHeight) { return false; }
    height = aHeight;
    wasSet = true;
    // line 671 "../../../../src/Umple.ump"
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

  @umplesourcefile(line={2038},file={"Umple_Code.ump"},javaline={208},length={3})
   public Point getTopLeft(){
    return new Point(x,y);
  }

  @umplesourcefile(line={2043},file={"Umple_Code.ump"},javaline={213},length={3})
   public Point getTopRight(){
    return new Point(x+width,y);
  }

  @umplesourcefile(line={2048},file={"Umple_Code.ump"},javaline={218},length={3})
   public Point getBottomLeft(){
    return new Point(x,y+height);
  }

  @umplesourcefile(line={2053},file={"Umple_Code.ump"},javaline={223},length={3})
   public Point getBottomRight(){
    return new Point(x+width,y+height);
  }

  @umplesourcefile(line={2058},file={"Umple_Code.ump"},javaline={228},length={3})
   public Point getTopMiddle(){
    return new Point(x+width/2,y);
  }

  @umplesourcefile(line={2063},file={"Umple_Code.ump"},javaline={233},length={3})
   public Point getBottomMiddle(){
    return new Point(x+width/2,y+height);
  }

  @umplesourcefile(line={2068},file={"Umple_Code.ump"},javaline={238},length={3})
   public Point getRightMiddle(){
    return new Point(x+width,y+height/2);
  }

  @umplesourcefile(line={2073},file={"Umple_Code.ump"},javaline={243},length={3})
   public Point getLeftMiddle(){
    return new Point(x,y+height/2);
  }

  @umplesourcefile(line={2078},file={"Umple_Code.ump"},javaline={248},length={24})
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

  @umplesourcefile(line={2104},file={"Umple_Code.ump"},javaline={274},length={6})
   public int distanceTo(Coordinate other){
    int a = other.getX() - getX();
    int b = other.getY() - getY();
    int c = (int) Math.round(Math.sqrt(Math.pow(a,2) + Math.pow(b,2)));
    return c;
  }

  @umplesourcefile(line={2112},file={"Umple_Code.ump"},javaline={282},length={3})
   public String toString(){
    return "(" + getX() + "," + getY() + "," + getWidth() + "," + getHeight() + ")";
  }

  @umplesourcefile(line={2117},file={"Umple_Code.ump"},javaline={287},length={10})
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