/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



/**
 * Version of the light with just one state
 */
// line 27 "Lights.ump"
public class Light2
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Light2 Attributes
  private int brightness;

  //Light2 State Machines
  enum Light { OFF, ON }
  private Light light;
  enum Sm { s2 }
  private Sm sm;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Light2()
  {
    brightness = 0;
    setLight(Light.OFF);
    setSm(Sm.s2);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setBrightness(int aBrightness)
  {
    boolean wasSet = false;
    brightness = aBrightness;
    wasSet = true;
    return wasSet;
  }

  public int getBrightness()
  {
    return brightness;
  }

  public String getLightFullName()
  {
    String answer = light.toString();
    return answer;
  }

  public String getSmFullName()
  {
    String answer = sm.toString();
    return answer;
  }

  public Light getLight()
  {
    return light;
  }

  public Sm getSm()
  {
    return sm;
  }

  public boolean on()
  {
    boolean wasEventProcessed = false;
    
    Sm aSm = sm;
    switch (aSm)
    {
      case s2:
        if (getLightFullName().equals(Light.OFF))
        {
        // line 32 "Lights.ump"
          light = Light.ON; brightness = 0;
          setSm(Sm.s2);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean set(Integer b)
  {
    boolean wasEventProcessed = false;
    
    Sm aSm = sm;
    switch (aSm)
    {
      case s2:
        if (getLightFullName().equals(Light.ON)&&b>=1&&b<=3)
        {
        // line 33 "Lights.ump"
          brightness=b;
          setSm(Sm.s2);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean off()
  {
    boolean wasEventProcessed = false;
    
    Sm aSm = sm;
    switch (aSm)
    {
      case s2:
        if (getLightFullName().equals(Light.ON))
        {
        // line 34 "Lights.ump"
          light = Light.OFF;
          setSm(Sm.s2);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean setLight(Light aLight)
  {
    light = aLight;
    return true;
  }

  private void setSm(Sm aSm)
  {
    sm = aSm;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "brightness" + ":" + getBrightness()+ "]"
     + outputString;
  }
}