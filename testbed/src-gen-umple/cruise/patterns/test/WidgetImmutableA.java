/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.patterns.test;

// line 4 "../../../../src/TestHarnessPatternsImmutable.ump"
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

  private boolean setWidgetImmutableB(WidgetImmutableB aNewWidgetImmutableB)
  {
    boolean wasSet = false;
    if (!canSetWidgetImmutableB) { return false; }
    canSetWidgetImmutableB = false;
    if (aNewWidgetImmutableB != null)
    {
      widgetImmutableB = aNewWidgetImmutableB;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "widgetImmutableB" + "=" + getWidgetImmutableB() != null ? !getWidgetImmutableB() .equals(this)  ? getWidgetImmutableB().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }
}