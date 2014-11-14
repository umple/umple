/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



/**
 * Example system representing aspects of a Car On-Board Diagnosis (OBD)
 * Demonstrates the composite Structure Diagram in Umple
 */
// line 6 "OBDCarSystem.ump"
public class CarInformation
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CarInformation Attributes
  private int motorOilclientData;
  private int particleFilterclientData;
  private int sparkPlugclientData;
  private int wheelsclientData;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CarInformation(int aMotorOilclientData, int aParticleFilterclientData, int aSparkPlugclientData, int aWheelsclientData)
  {
    motorOilclientData = aMotorOilclientData;
    particleFilterclientData = aParticleFilterclientData;
    sparkPlugclientData = aSparkPlugclientData;
    wheelsclientData = aWheelsclientData;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setMotorOilclientData(int aMotorOilclientData)
  {
    boolean wasSet = false;
    motorOilclientData = aMotorOilclientData;
    wasSet = true;
    return wasSet;
  }

  public boolean setParticleFilterclientData(int aParticleFilterclientData)
  {
    boolean wasSet = false;
    particleFilterclientData = aParticleFilterclientData;
    wasSet = true;
    return wasSet;
  }

  public boolean setSparkPlugclientData(int aSparkPlugclientData)
  {
    boolean wasSet = false;
    sparkPlugclientData = aSparkPlugclientData;
    wasSet = true;
    return wasSet;
  }

  public boolean setWheelsclientData(int aWheelsclientData)
  {
    boolean wasSet = false;
    wheelsclientData = aWheelsclientData;
    wasSet = true;
    return wasSet;
  }

  public int getMotorOilclientData()
  {
    return motorOilclientData;
  }

  public int getParticleFilterclientData()
  {
    return particleFilterclientData;
  }

  public int getSparkPlugclientData()
  {
    return sparkPlugclientData;
  }

  public int getWheelsclientData()
  {
    return wheelsclientData;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "motorOilclientData" + ":" + getMotorOilclientData()+ "," +
            "particleFilterclientData" + ":" + getParticleFilterclientData()+ "," +
            "sparkPlugclientData" + ":" + getSparkPlugclientData()+ "," +
            "wheelsclientData" + ":" + getWheelsclientData()+ "]"
     + outputString;
  }
}