/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.patterns.test;

public class WidgetImmutableA
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //WidgetImmutableA Attributes
  private String name;

  //WidgetImmutableA Associations
  private WidgetImmutableB widgetImmutableB;

  //Helper Variables
  private boolean canSetName;
  private boolean canSetWidgetImmutableB;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public WidgetImmutableA(String aName, WidgetImmutableB aWidgetImmutableB)
  {
    name = aName;
    canSetName = false;
    canSetWidgetImmutableB = true;
    if (!setWidgetImmutableB(aWidgetImmutableB))
    {
      throw new RuntimeException("Unable to create WidgetImmutableA due to aWidgetImmutableB");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getName()
  {
    return name;
  }

  public WidgetImmutableB getWidgetImmutableB()
  {
    return widgetImmutableB;
  }

  private boolean setWidgetImmutableB(WidgetImmutableB newWidgetImmutableB)
  {
    boolean wasSet = false;
    if (!canSetWidgetImmutableB) { return false; }
    canSetWidgetImmutableB = false;
    if (newWidgetImmutableB != null)
    {
      widgetImmutableB = newWidgetImmutableB;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {}

}