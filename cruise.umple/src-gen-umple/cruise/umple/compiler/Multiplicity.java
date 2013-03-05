/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.util.*;

/**
 * TODO: extract derived attributes from Umple_Code.ump (getLowerBound etc.)
 */
// line 463 "../../../../src/Umple.ump"
// line 1447 "../../../../src/Umple_Code.ump"
public class Multiplicity
{

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
  
  // line 1450 ../../../../src/Umple_Code.ump
  public void setRange(String lowerBound, String upperBound)
  {
    minimum = lowerBound;
    maximum = upperBound;
  }

  public String getRange()
  {
    String lowerBound = getLowerBound() == -1 ? "*" : getLowerBound() + ""; 
    String upperBound = getUpperBound() == -1 ? "*" : getUpperBound() + "";
    return StringFormatter.format("[{0},{1}]",lowerBound,upperBound);
  }

  public String[] getRangeParts()
  {
    String lowerBound = getLowerBound() == -1 ? "*" : getLowerBound() + ""; 
    String upperBound = getUpperBound() == -1 ? "*" : getUpperBound() + "";
    return new String[] { lowerBound, upperBound };
  }

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

  public boolean isLowerBoundMany()
  {
    return getLowerBound() == -1;
  }

  public boolean isUpperBoundMany()
  {
    return getUpperBound() == -1;
  }

  public boolean isLowerBoundNumeric()
  {
    return getLowerBound() >= -1;
  }

  public boolean isUpperBoundNumeric()
  {
    return getUpperBound() >= -1;
  }

  public boolean isMany()
  {
    return getUpperBound() > 1 || getUpperBound() == -1;
  }

  public boolean isOne()
  {
    return getUpperBound() == 1;
  }

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