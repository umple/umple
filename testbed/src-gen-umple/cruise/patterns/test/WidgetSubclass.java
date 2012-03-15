/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.patterns.test;

public class WidgetSubclass extends WidgetImmutableA
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //WidgetSubclass Attributes
  private String type;

  //Helper Variables
  private boolean canSetType;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public WidgetSubclass(String aName, WidgetImmutableB aWidgetImmutableB, String aType)
  {
    super(aName, aWidgetImmutableB);
    type = aType;
    canSetType = false;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getType()
  {
    return type;
  }

  public void delete()
  {
    super.delete();
  }

}