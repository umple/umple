/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.util.*;

/**
 * A multplicity constrains the number of linked objects at one end of an
 * association
 * 
 * TODO: extract derived attributes from Umple_Code.ump (getLowerBound etc.)
 * In Umple_Code.ump: Methods for querying various propertiies of a Multiplicit
 * @umplesource Umple.ump 569
 * @umplesource Umple_Code.ump 1521
 */
// line 569 "../../../../src/Umple.ump"
// line 1521 "../../../../src/Umple_Code.ump"
public class Multiplicity
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Multiplicity Attributes
  private String bound;
  private String minimum;
  private String maximum;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetBound;
  private boolean canSetMinimum;
  private boolean canSetMaximum;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Multiplicity()
  {
    cachedHashCode = -1;
    canSetBound = true;
    canSetMinimum = true;
    canSetMaximum = true;
    bound = null;
    minimum = null;
    maximum = null;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setBound(String aBound)
  {
    boolean wasSet = false;
    if (!canSetBound) { return false; }
    bound = aBound;
    wasSet = true;
    return wasSet;
  }

  public boolean setMinimum(String aMinimum)
  {
    boolean wasSet = false;
    if (!canSetMinimum) { return false; }
    minimum = aMinimum;
    wasSet = true;
    return wasSet;
  }

  public boolean setMaximum(String aMaximum)
  {
    boolean wasSet = false;
    if (!canSetMaximum) { return false; }
    maximum = aMaximum;
    wasSet = true;
    return wasSet;
  }

  public String getBound()
  {
    return bound;
  }

  /**
   * used when minimum=maximum;
   */
  public String getMinimum()
  {
    return minimum;
  }

  public String getMaximum()
  {
    return maximum;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Multiplicity compareTo = (Multiplicity)obj;
  
    if (bound == null && compareTo.bound != null)
    {
      return false;
    }
    else if (bound != null && !bound.equals(compareTo.bound))
    {
      return false;
    }

    if (minimum == null && compareTo.minimum != null)
    {
      return false;
    }
    else if (minimum != null && !minimum.equals(compareTo.minimum))
    {
      return false;
    }

    if (maximum == null && compareTo.maximum != null)
    {
      return false;
    }
    else if (maximum != null && !maximum.equals(compareTo.maximum))
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
    if (bound != null)
    {
      cachedHashCode = cachedHashCode * 23 + bound.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    if (minimum != null)
    {
      cachedHashCode = cachedHashCode * 23 + minimum.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    if (maximum != null)
    {
      cachedHashCode = cachedHashCode * 23 + maximum.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetBound = false;
    canSetMinimum = false;
    canSetMaximum = false;
    return cachedHashCode;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "maximum" + ":" + getMaximum()+ "," +
            "minimum" + ":" + getMinimum()+ "," +
            "bound" + ":" + getBound()+ "]"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={1523},file={"Umple_Code.ump"},javaline={196},length={137})
  @umplesourcefile(line={1524},file={"Umple_Code.ump"},javaline={197},length={5})
  public void setRange(String lowerBound, String upperBound)
  {
    minimum = lowerBound;
    maximum = upperBound;
  }

  @umplesourcefile(line={1530},file={"Umple_Code.ump"},javaline={204},length={6})
  public String getRange()
  {
    String lowerBound = getLowerBound() == -1 ? "*" : getLowerBound() + ""; 
    String upperBound = getUpperBound() == -1 ? "*" : getUpperBound() + "";
    return StringFormatter.format("[{0},{1}]",lowerBound,upperBound);
  }

  @umplesourcefile(line={1537},file={"Umple_Code.ump"},javaline={212},length={6})
  public String[] getRangeParts()
  {
    String lowerBound = getLowerBound() == -1 ? "*" : getLowerBound() + ""; 
    String upperBound = getUpperBound() == -1 ? "*" : getUpperBound() + "";
    return new String[] { lowerBound, upperBound };
  }

  @umplesourcefile(line={1544},file={"Umple_Code.ump"},javaline={220},length={31})
  public boolean isValid()
  {
    if ("*".equals(getMinimum()))
    {
      return false;
    }

    if ("-1".equals(getMinimum()) || "-1".equals(getMaximum()) || "-1".equals(getBound()))
    {
      return false;
    }

    if (getLowerBound() < -1 || getUpperBound() < -1)
    {
      return false;
    }
    
    // Fix for issue 292
    if (getUpperBound() == 0)
    {
      return false;
    }


    if (getLowerBound() > getUpperBound() && !isUpperBoundMany())
    {
      return false;
    }

    return true;
  }

  @umplesourcefile(line={1576},file={"Umple_Code.ump"},javaline={253},length={11})
  public void minimizeRange(Multiplicity compareTo)
  {
    if (compareTo.getLowerBound() > getLowerBound() && compareTo.minimum != null)
    {
      minimum = compareTo.minimum;
    }
    if (compareTo.getUpperBound() < getUpperBound() && compareTo.maximum != null && compareTo.getUpperBound() != -1)
    {
      maximum = compareTo.maximum;
    }
  }

  @umplesourcefile(line={1588},file={"Umple_Code.ump"},javaline={266},length={11})
  public int getLowerBound()
  {
    if (getBound() != null)
    {
      return parseInt(getBound(),0);
    }
    else
    {
      return parseInt(getMinimum(),-1);
    }
  }

  @umplesourcefile(line={1600},file={"Umple_Code.ump"},javaline={279},length={11})
  public int getUpperBound()
  {
    if (getBound() != null)
    {
      return parseInt(getBound(),-1);
    }
    else
    {
      return parseInt(getMaximum(),-1);
    }
  }

  @umplesourcefile(line={1612},file={"Umple_Code.ump"},javaline={292},length={4})
  public boolean isLowerBoundMany()
  {
    return getLowerBound() == -1;
  }

  @umplesourcefile(line={1617},file={"Umple_Code.ump"},javaline={298},length={4})
  public boolean isUpperBoundMany()
  {
    return getUpperBound() == -1;
  }

  @umplesourcefile(line={1622},file={"Umple_Code.ump"},javaline={304},length={4})
  public boolean isLowerBoundNumeric()
  {
    return getLowerBound() >= -1;
  }

  @umplesourcefile(line={1627},file={"Umple_Code.ump"},javaline={310},length={4})
  public boolean isUpperBoundNumeric()
  {
    return getUpperBound() >= -1;
  }

  @umplesourcefile(line={1632},file={"Umple_Code.ump"},javaline={316},length={4})
  public boolean isMany()
  {
    return getUpperBound() > 1 || getUpperBound() == -1;
  }

  @umplesourcefile(line={1637},file={"Umple_Code.ump"},javaline={322},length={4})
  public boolean isOne()
  {
    return getUpperBound() == 1;
  }

  @umplesourcefile(line={1642},file={"Umple_Code.ump"},javaline={328},length={18})
  private int parseInt(String input, int defaultIfStar)
  {
    try
    {
      if ("*".equals(input))
      {
        return defaultIfStar;
      }
      else
      {
        return Integer.parseInt(input);
      }
    }
    catch(Exception e)
    {
      return -2;
    }
  }

}