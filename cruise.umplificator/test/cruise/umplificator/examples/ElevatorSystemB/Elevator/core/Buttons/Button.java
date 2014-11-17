/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package Elevator.core.Buttons;

// line 34 "../../../../ElevatorSystemB.ump"
// line 67 "../../../../ElevatorSystemB.ump"
public class Button
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Button Attributes
  private boolean lightOn;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Button(boolean aLightOn)
  {
    lightOn = aLightOn;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLightOn(boolean aLightOn)
  {
    boolean wasSet = false;
    lightOn = aLightOn;
    wasSet = true;
    return wasSet;
  }

  public boolean getLightOn()
  {
    return lightOn;
  }

  public boolean isLightOn()
  {
    return lightOn;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "lightOn" + ":" + getLightOn()+ "]"
     + outputString;
  }
}