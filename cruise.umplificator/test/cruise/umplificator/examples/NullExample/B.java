/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



/**
 * Definition of a second class
 * Modeling entities can also be added to a class as follows
 * We are adding to B, rather than replacing it
 */
// line 25 "NullExample.ump"
// line 57 "NullExample.ump"
// line 102 "NullExample.ump"
public class B extends A
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //B Attributes
  private int anotherAttribute;

  //B State Machines
  enum Height { high, medium, low }
  private Height height;

  //B Associations
  private D d;
  private C c;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public B(String aName, int aAnotherAttribute, C aC)
  {
    super(aName);
    anotherAttribute = aAnotherAttribute;
    boolean didAddC = setC(aC);
    if (!didAddC)
    {
      throw new RuntimeException("Unable to create b due to c");
    }
    setHeight(Height.high);
  }

  //------------------------
  // INTERFACE
  //------------------------

  /**
   * Can only be set on creation
   */
  public int getAnotherAttribute()
  {
    return anotherAttribute;
  }

  public String getHeightFullName()
  {
    String answer = height.toString();
    return answer;
  }

  public Height getHeight()
  {
    return height;
  }

  public boolean goDown()
  {
    boolean wasEventProcessed = false;
    
    Height aHeight = height;
    switch (aHeight)
    {
      case high:
        setHeight(Height.medium);
        wasEventProcessed = true;
        break;
      case medium:
        // line 82 "NullExample.ump"
        setI(getI()-10);
        setHeight(Height.low);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean goUp()
  {
    boolean wasEventProcessed = false;
    
    Height aHeight = height;
    switch (aHeight)
    {
      case medium:
        setHeight(Height.high);
        wasEventProcessed = true;
        break;
      case low:
        setHeight(Height.medium);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setHeight(Height aHeight)
  {
    height = aHeight;

    // entry actions and do activities
    switch(height)
    {
      case medium:
        // line 78 "NullExample.ump"
        setI(getI()+1);
        break;
    }
  }

  public D getD()
  {
    return d;
  }

  public boolean hasD()
  {
    boolean has = d != null;
    return has;
  }

  public C getC()
  {
    return c;
  }

  public boolean setD(D aNewD)
  {
    boolean wasSet = false;
    if (aNewD == null)
    {
      D existingD = d;
      d = null;
      
      if (existingD != null && existingD.getB() != null)
      {
        existingD.setB(null);
      }
      wasSet = true;
      return wasSet;
    }

    D currentD = getD();
    if (currentD != null && !currentD.equals(aNewD))
    {
      currentD.setB(null);
    }

    d = aNewD;
    B existingB = aNewD.getB();

    if (!equals(existingB))
    {
      aNewD.setB(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setC(C aC)
  {
    boolean wasSet = false;
    if (aC == null)
    {
      return wasSet;
    }

    C existingC = c;
    c = aC;
    if (existingC != null && !existingC.equals(aC))
    {
      existingC.removeB(this);
    }
    c.addB(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (d != null)
    {
      d.setB(null);
    }
    C placeholderC = c;
    this.c = null;
    placeholderC.removeB(this);
    super.delete();
  }


  /**
   * The following shows that you can put arbitrary methods in your code,
   * Since this is Java, it makes sense only to generate Java from this
   */
  // line 92 "NullExample.ump"
   public Integer timesTen(){
    return (anotherAttribute*10);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "anotherAttribute" + ":" + getAnotherAttribute()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "d = "+(getD()!=null?Integer.toHexString(System.identityHashCode(getD())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "c = "+(getC()!=null?Integer.toHexString(System.identityHashCode(getC())):"null")
     + outputString;
  }
}