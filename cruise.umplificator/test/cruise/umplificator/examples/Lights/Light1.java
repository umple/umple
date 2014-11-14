/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 6 "Lights.ump"
public class Light1
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Light1 Attributes
  private int brightness;

  //Light1 State Machines
  enum Light { OFF, ON }
  private Light light;
  enum Sm { s1, s2, s3 }
  private Sm sm;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Light1()
  {
    brightness = 0;
    setLight(Light.OFF);
    setSm(Sm.s1);
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
      case s1:
        setSm(Sm.s2);
        wasEventProcessed = true;
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
        if (b>=1&&b<=3)
        {
        // line 17 "Lights.ump"
          brightness=b;
          setSm(Sm.s3);
          wasEventProcessed = true;
          break;
        }
        break;
      case s3:
        if (b>=1&&b<=3)
        {
        // line 20 "Lights.ump"
          brightness=b;
          setSm(Sm.s3);
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
      case s3:
        setSm(Sm.s1);
        wasEventProcessed = true;
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

    // entry actions and do activities
    switch(sm)
    {
      case s1:
        // line 12 "Lights.ump"
        light = Light.OFF;
        break;
      case s2:
        // line 16 "Lights.ump"
        light = Light.ON; brightness = 0;
        break;
    }
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