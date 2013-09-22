/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.patterns.test;
import java.util.*;

// line 18 "../../../../src/TestHarnessPatternsImmutable.ump"
public class WidgetSubclass extends WidgetImmutableB
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //WidgetSubclass Attributes
  private String type;

  //WidgetSubclass Associations
  private List<WidgetImmutableB> widgetImmutableBs;

  //Helper Variables
  private boolean canSetType;
  private boolean canSetWidgetImmutableBs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public WidgetSubclass(String aName, String aType, WidgetImmutableB... allWidgetImmutableBs)
  {
    super(aName);
    type = aType;
    canSetType = false;
    canSetWidgetImmutableBs = true;
    widgetImmutableBs = new ArrayList<WidgetImmutableB>();
    boolean didAddWidgetImmutableBs = setWidgetImmutableBs(allWidgetImmutableBs);
    if (!didAddWidgetImmutableBs)
    {
      throw new RuntimeException("Unable to create WidgetSubclass, must have 2 or fewer widgetImmutableBs, no duplicates.");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getType()
  {
    return type;
  }

  public WidgetImmutableB getWidgetImmutableB(int index)
  {
    WidgetImmutableB aWidgetImmutableB = widgetImmutableBs.get(index);
    return aWidgetImmutableB;
  }

  public List<WidgetImmutableB> getWidgetImmutableBs()
  {
    List<WidgetImmutableB> newWidgetImmutableBs = Collections.unmodifiableList(widgetImmutableBs);
    return newWidgetImmutableBs;
  }

  public int numberOfWidgetImmutableBs()
  {
    int number = widgetImmutableBs.size();
    return number;
  }

  public boolean hasWidgetImmutableBs()
  {
    boolean has = widgetImmutableBs.size() > 0;
    return has;
  }

  public int indexOfWidgetImmutableB(WidgetImmutableB aWidgetImmutableB)
  {
    int index = widgetImmutableBs.indexOf(aWidgetImmutableB);
    return index;
  }

  public static int minimumNumberOfWidgetImmutableBs()
  {
    return 0;
  }

  public static int maximumNumberOfWidgetImmutableBs()
  {
    return 2;
  }

  private boolean setWidgetImmutableBs(WidgetImmutableB... newWidgetImmutableBs)
  {
    boolean wasSet = false;
    if (!canSetWidgetImmutableBs) { return false; }
    canSetWidgetImmutableBs = false;
    ArrayList<WidgetImmutableB> verifiedWidgetImmutableBs = new ArrayList<WidgetImmutableB>();
    for (WidgetImmutableB aWidgetImmutableB : newWidgetImmutableBs)
    {
      if (verifiedWidgetImmutableBs.contains(aWidgetImmutableB))
      {
        continue;
      }
      verifiedWidgetImmutableBs.add(aWidgetImmutableB);
    }

    if (verifiedWidgetImmutableBs.size() != newWidgetImmutableBs.length || verifiedWidgetImmutableBs.size() > maximumNumberOfWidgetImmutableBs())
    {
      return wasSet;
    }

    widgetImmutableBs.clear();
    widgetImmutableBs.addAll(verifiedWidgetImmutableBs);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "type" + ":" + getType()+ "]"
     + outputString;
  }
}