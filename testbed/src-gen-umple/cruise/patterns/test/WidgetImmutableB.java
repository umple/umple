/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.patterns.test;

// line 13 "../../../../src/TestHarnessPatternsImmutable.ump"
public class WidgetImmutableB
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //WidgetImmutableB Attributes
  private String name;

  //Helper Variables
  private boolean canSetName;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public WidgetImmutableB(String aName)
  {
    name = aName;
    canSetName = false;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getName()
  {
    return name;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]"
     + outputString;
  }
}