/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 114 "MicrowaveOven2.ump"
public class Timer
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Timer Attributes
  private int timeMs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Timer()
  {
    timeMs = 0;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTimeMs(int aTimeMs)
  {
    boolean wasSet = false;
    timeMs = aTimeMs;
    wasSet = true;
    return wasSet;
  }

  public int getTimeMs()
  {
    return timeMs;
  }

  public void delete()
  {}

  // line 118 "MicrowaveOven2.ump"
   public int tick(int time){
    while (time > 0){
      setTimeMs(time);
      time = time - 1;
    }
    setTimeMs(time);
    return getTimeMs();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "timeMs" + ":" + getTimeMs()+ "]"
     + outputString;
  }
}