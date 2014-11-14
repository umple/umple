/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 41 "PingPong.ump"
public class Atomic
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Atomic Attributes
  private Component1 cmp1;
  private Component2 cmp2;
  private int startValue;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Atomic(Component1 aCmp1, Component2 aCmp2, int aStartValue)
  {
    cmp1 = aCmp1;
    cmp2 = aCmp2;
    startValue = aStartValue;
    // line 46 "PingPong.ump"
    cmp1->pIn1(startValue);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCmp1(Component1 aCmp1)
  {
    boolean wasSet = false;
    cmp1 = aCmp1;
    wasSet = true;
    return wasSet;
  }

  public boolean setCmp2(Component2 aCmp2)
  {
    boolean wasSet = false;
    cmp2 = aCmp2;
    wasSet = true;
    return wasSet;
  }

  public boolean setStartValue(int aStartValue)
  {
    boolean wasSet = false;
    startValue = aStartValue;
    wasSet = true;
    return wasSet;
  }

  public Component1 getCmp1()
  {
    return cmp1;
  }

  public Component2 getCmp2()
  {
    return cmp2;
  }

  public int getStartValue()
  {
    return startValue;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "startValue" + ":" + getStartValue()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "cmp1" + "=" + (getCmp1() != null ? !getCmp1().equals(this)  ? getCmp1().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "cmp2" + "=" + (getCmp2() != null ? !getCmp2().equals(this)  ? getCmp2().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}