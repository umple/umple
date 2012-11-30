/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.patterns.test;
import java.util.*;

public class WidgetMutableB
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //WidgetMutableB Associations
  private List<WidgetImmutableB> widgetImmutableBs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public WidgetMutableB()
  {
    widgetImmutableBs = new ArrayList<WidgetImmutableB>();
  }

  //------------------------
  // INTERFACE
  //------------------------

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
    return 10;
  }

  public boolean addWidgetImmutableB(WidgetImmutableB aWidgetImmutableB)
  {
    boolean wasAdded = false;
    if (widgetImmutableBs.contains(aWidgetImmutableB)) { return false; }
    if (numberOfWidgetImmutableBs() < maximumNumberOfWidgetImmutableBs())
    {
      widgetImmutableBs.add(aWidgetImmutableB);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean removeWidgetImmutableB(WidgetImmutableB aWidgetImmutableB)
  {
    boolean wasRemoved = false;
    if (widgetImmutableBs.contains(aWidgetImmutableB))
    {
      widgetImmutableBs.remove(aWidgetImmutableB);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean setWidgetImmutableBs(WidgetImmutableB... newWidgetImmutableBs)
  {
    boolean wasSet = false;
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
    widgetImmutableBs.clear();
  }

}