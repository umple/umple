/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import cruise.umple.util.*;

/**
 * A multplicity constrains the number of linked objects at one end of an
 * association
 * 
 * TODO: extract derived attributes from Umple_Code.ump (getLowerBound etc.)
 * In Umple_Code.ump: Methods for querying various propertiies of a Multiplicit
 * @umplesource Umple.ump 595
 * @umplesource Umple_Code.ump 1797
 */
// line 595 "../../../../src/Umple.ump"
// line 1797 "../../../../src/Umple_Code.ump"
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

  /**
   * used when minimum=maximum;
   */
  public String getBound()
  {
    return bound;
  }

  public String getMinimum()
  {
    return minimum;
  }

  public String getMaximum()
  {
    return maximum;
  }

  @umplesourcefile(line={604},file={"Umple.ump"},javaline={106},length={2})
  public String getParserable()
  {
    return getBound() != null ? getBound() : getMinimum().equals("0") && getMaximum().equals("*") ? "*" : getMinimum() + ".." + getMaximum();
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

  @umplesourcefile(line={1803},file={"Umple_Code.ump"},javaline={190},length={4})
   public void setRange(String lowerBound, String upperBound){
    minimum = lowerBound;
    maximum = upperBound;
  }

  @umplesourcefile(line={1809},file={"Umple_Code.ump"},javaline={196},length={5})
   public String getRange(){
    String lowerBound = getLowerBound() == -1 ? "*" : getLowerBound() + ""; 
    String upperBound = getUpperBound() == -1 ? "*" : getUpperBound() + "";
    return StringFormatter.format("[{0},{1}]",lowerBound,upperBound);
  }

  @umplesourcefile(line={1816},file={"Umple_Code.ump"},javaline={203},length={5})
   public String[] getRangeParts(){
    String lowerBound = getLowerBound() == -1 ? "*" : getLowerBound() + ""; 
    String upperBound = getUpperBound() == -1 ? "*" : getUpperBound() + "";
    return new String[] { lowerBound, upperBound };
  }

  @umplesourcefile(line={1823},file={"Umple_Code.ump"},javaline={210},length={30})
   public boolean isValid(){
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

  @umplesourcefile(line={1855},file={"Umple_Code.ump"},javaline={242},length={10})
   public void minimizeRange(Multiplicity compareTo){
    if (compareTo.getLowerBound() > getLowerBound() && compareTo.minimum != null)
    {
      minimum = compareTo.minimum;
    }
    if (compareTo.getUpperBound() < getUpperBound() && compareTo.maximum != null && compareTo.getUpperBound() != -1)
    {
      maximum = compareTo.maximum;
    }
  }

  @umplesourcefile(line={1867},file={"Umple_Code.ump"},javaline={254},length={10})
   public int getLowerBound(){
    if (getBound() != null)
    {
      return parseInt(getBound(),0);
    }
    else
    {
      return parseInt(getMinimum(),-1);
    }
  }

  @umplesourcefile(line={1879},file={"Umple_Code.ump"},javaline={266},length={10})
   public int getUpperBound(){
    if (getBound() != null)
    {
      return parseInt(getBound(),-1);
    }
    else
    {
      return parseInt(getMaximum(),-1);
    }
  }

  @umplesourcefile(line={1891},file={"Umple_Code.ump"},javaline={278},length={3})
   public boolean isLowerBoundMany(){
    return getLowerBound() == -1;
  }

  @umplesourcefile(line={1896},file={"Umple_Code.ump"},javaline={283},length={3})
   public boolean isUpperBoundMany(){
    return getUpperBound() == -1;
  }

  @umplesourcefile(line={1901},file={"Umple_Code.ump"},javaline={288},length={3})
   public boolean isLowerBoundNumeric(){
    return getLowerBound() >= -1;
  }

  @umplesourcefile(line={1906},file={"Umple_Code.ump"},javaline={293},length={3})
   public boolean isUpperBoundNumeric(){
    return getUpperBound() >= -1;
  }

  @umplesourcefile(line={1911},file={"Umple_Code.ump"},javaline={298},length={3})
   public boolean isMany(){
    return getUpperBound() > 1 || getUpperBound() == -1;
  }

  @umplesourcefile(line={1916},file={"Umple_Code.ump"},javaline={303},length={3})
   public boolean isOne(){
    return getUpperBound() == 1;
  }

  @umplesourcefile(line={1921},file={"Umple_Code.ump"},javaline={308},length={17})
   private int parseInt(String input, int defaultIfStar){
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


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "maximum" + ":" + getMaximum()+ "," +
            "minimum" + ":" + getMinimum()+ "," +
            "bound" + ":" + getBound()+ "," +
            "parserable" + ":" + getParserable()+ "]"
     + outputString;
  }
}