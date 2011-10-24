/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.14.0.957 modeling language!*/

package cruise.attributes.test;
import java.sql.Time;

public class DoorF
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DoorF Attributes
  private Time d1;
  private Time d2;
  private Time d3;
  private Time d4;

  //Helper Variables
  private boolean canSetD2;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DoorF()
  {
    d1 = Time.valueOf("12:51:51");
    d2 = Time.valueOf("12:52:52");
    canSetD2 = false;
    resetD3();
    d4 = Time.valueOf("12:54:54");
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setD1(Time aD1)
  {
    boolean wasSet = false;
    d1 = aD1;
    wasSet = true;
    return wasSet;
  }

  public boolean setD3(Time aD3)
  {
    boolean wasSet = false;
    d3 = aD3;
    wasSet = true;
    return wasSet;
  }

  public boolean resetD3()
  {
    boolean wasReset = false;
    d3 = getDefaultD3();
    wasReset = true;
    return wasReset;
  }

  public boolean setD4(Time aD4)
  {
    boolean wasSet = false;
    d4 = aD4;
    wasSet = true;
    return wasSet;
  }

  public Time getD1()
  {
    return d1;
  }

  public Time getD2()
  {
    return d2;
  }

  public Time getD3()
  {
    return d3;
  }

  public Time getDefaultD3()
  {
    return Time.valueOf("12:53:53");
  }

  public Time getD4()
  {
    return d4;
  }

  public void delete()
  {}

}