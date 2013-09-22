/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.patterns.test;

// line 4 "../../../../src/TestHarnessPatternsImmutable.ump"
public class WidgetImmutableA
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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
            "  " + "widgetImmutableB = "+(getWidgetImmutableB()!=null?Integer.toHexString(System.identityHashCode(getWidgetImmutableB())):"null")
     + outputString;
  }
}