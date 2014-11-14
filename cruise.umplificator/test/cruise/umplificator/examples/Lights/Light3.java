/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



/**
 * Complex version of the light with five states
 */
// line 40 "Lights.ump"
public class Light3
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Light3 Attributes
  private int brightness;

  //Light3 State Machines
  enum Light { OFF, ON }
  private Light light;
  enum Sm { s1, s2, s3, s4, s5 }
  private Sm sm;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Light3()
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
        if (b==1)
        {
        // line 51 "Lights.ump"
          brightness=b;
          setSm(Sm.s3);
          wasEventProcessed = true;
          break;
        }
        if (b==2)
        {
        // line 52 "Lights.ump"
          brightness=b;
          setSm(Sm.s4);
          wasEventProcessed = true;
          break;
        }
        if (b==3)
        {
        // line 53 "Lights.ump"
          brightness=b;
          setSm(Sm.s5);
          wasEventProcessed = true;
          break;
        }
        break;
      case s3:
        if (b==1)
        {
        // line 57 "Lights.ump"
          brightness=b;
          setSm(Sm.s3);
          wasEventProcessed = true;
          break;
        }
        if (b==2)
        {
        // line 58 "Lights.ump"
          brightness=b;
          setSm(Sm.s4);
          wasEventProcessed = true;
          break;
        }
        if (b==3)
        {
        // line 59 "Lights.ump"
          brightness=b;
          setSm(Sm.s5);
          wasEventProcessed = true;
          break;
        }
        break;
      case s4:
        if (b==1)
        {
        // line 64 "Lights.ump"
          brightness=b;
          setSm(Sm.s3);
          wasEventProcessed = true;
          break;
        }
        if (b==2)
        {
        // line 65 "Lights.ump"
          brightness=b;
          setSm(Sm.s4);
          wasEventProcessed = true;
          break;
        }
        if (b==3)
        {
        // line 66 "Lights.ump"
          brightness=b;
          setSm(Sm.s5);
          wasEventProcessed = true;
          break;
        }
        break;
      case s5:
        if (b==1)
        {
        // line 71 "Lights.ump"
          brightness=b;
          setSm(Sm.s3);
          wasEventProcessed = true;
          break;
        }
        if (b==2)
        {
        // line 72 "Lights.ump"
          brightness=b;
          setSm(Sm.s4);
          wasEventProcessed = true;
          break;
        }
        if (b==3)
        {
        // line 73 "Lights.ump"
          brightness=b;
          setSm(Sm.s5);
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
      case s4:
        setSm(Sm.s1);
        wasEventProcessed = true;
        break;
      case s5:
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
        // line 46 "Lights.ump"
        light = Light.OFF;
        break;
      case s2:
        // line 50 "Lights.ump"
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