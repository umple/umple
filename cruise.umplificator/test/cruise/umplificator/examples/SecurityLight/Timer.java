/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 77 "SecurityLight.ump"
public class Timer
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Timer Attributes
  private long startTime;
  private long stopTime;
  private boolean lighting;

  //Timer Associations
  private ExternalSecurityLight externalSecurityLight;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Timer(ExternalSecurityLight aExternalSecurityLight)
  {
    startTime = 0L;
    stopTime = 0L;
    lighting = false;
    if (aExternalSecurityLight == null || aExternalSecurityLight.getTimer() != null)
    {
      throw new RuntimeException("Unable to create Timer due to aExternalSecurityLight");
    }
    externalSecurityLight = aExternalSecurityLight;
  }

  public Timer()
  {
    startTime = 0L;
    stopTime = 0L;
    lighting = false;
    externalSecurityLight = new ExternalSecurityLight(this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStartTime(long aStartTime)
  {
    boolean wasSet = false;
    startTime = aStartTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setStopTime(long aStopTime)
  {
    boolean wasSet = false;
    stopTime = aStopTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setLighting(boolean aLighting)
  {
    boolean wasSet = false;
    lighting = aLighting;
    wasSet = true;
    return wasSet;
  }

  public long getStartTime()
  {
    return startTime;
  }

  public long getStopTime()
  {
    return stopTime;
  }

  public boolean getLighting()
  {
    return lighting;
  }

  public ExternalSecurityLight getExternalSecurityLight()
  {
    return externalSecurityLight;
  }

  public void delete()
  {
    ExternalSecurityLight existingExternalSecurityLight = externalSecurityLight;
    externalSecurityLight = null;
    if (existingExternalSecurityLight != null)
    {
      existingExternalSecurityLight.delete();
    }
  }

  // line 84 "SecurityLight.ump"
   public void startTimer(){
    System.out.println("start timing");
    this.startTime = System.currentTimeMillis();
    this.lighting = true;
  }

  // line 90 "SecurityLight.ump"
   public void stopTimer(){
    this.stopTime = this.getStartTime() + 10000L;
   this.lighting = false;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "startTime" + ":" + getStartTime()+ "," +
            "stopTime" + ":" + getStopTime()+ "," +
            "lighting" + ":" + getLighting()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "externalSecurityLight = "+(getExternalSecurityLight()!=null?Integer.toHexString(System.identityHashCode(getExternalSecurityLight())):"null")
     + outputString;
  }
}