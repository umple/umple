/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 134 "OBDCarSystem.ump"
public class CarSystem
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CarSystem Attributes
  private SensorReader clientWheels;
  private SensorReader clientMotorOil;
  private SensorReader clientParticleFilter;
  private SensorReader clientSparkPlugAdaptive;
  private ConditionCheckAdapter conditionCheckAdapter;
  private MotorRotationSpeed motorRotationSpeed;
  private MotorOilQuantity motorOilQuantity;
  private MotorOilViscosity motorOilViscosity;
  private ThrottleControl throttleControl;
  private MotorOilCheck motorOilCheck;
  private CarInformation carInformation;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CarSystem(SensorReader aClientWheels, SensorReader aClientMotorOil, SensorReader aClientParticleFilter, SensorReader aClientSparkPlugAdaptive, ConditionCheckAdapter aConditionCheckAdapter, MotorRotationSpeed aMotorRotationSpeed, MotorOilQuantity aMotorOilQuantity, MotorOilViscosity aMotorOilViscosity, ThrottleControl aThrottleControl, MotorOilCheck aMotorOilCheck, CarInformation aCarInformation)
  {
    clientWheels = aClientWheels;
    clientMotorOil = aClientMotorOil;
    clientParticleFilter = aClientParticleFilter;
    clientSparkPlugAdaptive = aClientSparkPlugAdaptive;
    conditionCheckAdapter = aConditionCheckAdapter;
    motorRotationSpeed = aMotorRotationSpeed;
    motorOilQuantity = aMotorOilQuantity;
    motorOilViscosity = aMotorOilViscosity;
    throttleControl = aThrottleControl;
    motorOilCheck = aMotorOilCheck;
    carInformation = aCarInformation;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setClientWheels(SensorReader aClientWheels)
  {
    boolean wasSet = false;
    clientWheels = aClientWheels;
    wasSet = true;
    return wasSet;
  }

  public boolean setClientMotorOil(SensorReader aClientMotorOil)
  {
    boolean wasSet = false;
    clientMotorOil = aClientMotorOil;
    wasSet = true;
    return wasSet;
  }

  public boolean setClientParticleFilter(SensorReader aClientParticleFilter)
  {
    boolean wasSet = false;
    clientParticleFilter = aClientParticleFilter;
    wasSet = true;
    return wasSet;
  }

  public boolean setClientSparkPlugAdaptive(SensorReader aClientSparkPlugAdaptive)
  {
    boolean wasSet = false;
    clientSparkPlugAdaptive = aClientSparkPlugAdaptive;
    wasSet = true;
    return wasSet;
  }

  public boolean setConditionCheckAdapter(ConditionCheckAdapter aConditionCheckAdapter)
  {
    boolean wasSet = false;
    conditionCheckAdapter = aConditionCheckAdapter;
    wasSet = true;
    return wasSet;
  }

  public boolean setMotorRotationSpeed(MotorRotationSpeed aMotorRotationSpeed)
  {
    boolean wasSet = false;
    motorRotationSpeed = aMotorRotationSpeed;
    wasSet = true;
    return wasSet;
  }

  public boolean setMotorOilQuantity(MotorOilQuantity aMotorOilQuantity)
  {
    boolean wasSet = false;
    motorOilQuantity = aMotorOilQuantity;
    wasSet = true;
    return wasSet;
  }

  public boolean setMotorOilViscosity(MotorOilViscosity aMotorOilViscosity)
  {
    boolean wasSet = false;
    motorOilViscosity = aMotorOilViscosity;
    wasSet = true;
    return wasSet;
  }

  public boolean setThrottleControl(ThrottleControl aThrottleControl)
  {
    boolean wasSet = false;
    throttleControl = aThrottleControl;
    wasSet = true;
    return wasSet;
  }

  public boolean setMotorOilCheck(MotorOilCheck aMotorOilCheck)
  {
    boolean wasSet = false;
    motorOilCheck = aMotorOilCheck;
    wasSet = true;
    return wasSet;
  }

  public boolean setCarInformation(CarInformation aCarInformation)
  {
    boolean wasSet = false;
    carInformation = aCarInformation;
    wasSet = true;
    return wasSet;
  }

  public SensorReader getClientWheels()
  {
    return clientWheels;
  }

  public SensorReader getClientMotorOil()
  {
    return clientMotorOil;
  }

  public SensorReader getClientParticleFilter()
  {
    return clientParticleFilter;
  }

  public SensorReader getClientSparkPlugAdaptive()
  {
    return clientSparkPlugAdaptive;
  }

  public ConditionCheckAdapter getConditionCheckAdapter()
  {
    return conditionCheckAdapter;
  }

  public MotorRotationSpeed getMotorRotationSpeed()
  {
    return motorRotationSpeed;
  }

  public MotorOilQuantity getMotorOilQuantity()
  {
    return motorOilQuantity;
  }

  public MotorOilViscosity getMotorOilViscosity()
  {
    return motorOilViscosity;
  }

  public ThrottleControl getThrottleControl()
  {
    return throttleControl;
  }

  public MotorOilCheck getMotorOilCheck()
  {
    return motorOilCheck;
  }

  public CarInformation getCarInformation()
  {
    return carInformation;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "clientWheels" + "=" + (getClientWheels() != null ? !getClientWheels().equals(this)  ? getClientWheels().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "clientMotorOil" + "=" + (getClientMotorOil() != null ? !getClientMotorOil().equals(this)  ? getClientMotorOil().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "clientParticleFilter" + "=" + (getClientParticleFilter() != null ? !getClientParticleFilter().equals(this)  ? getClientParticleFilter().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "clientSparkPlugAdaptive" + "=" + (getClientSparkPlugAdaptive() != null ? !getClientSparkPlugAdaptive().equals(this)  ? getClientSparkPlugAdaptive().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "conditionCheckAdapter" + "=" + (getConditionCheckAdapter() != null ? !getConditionCheckAdapter().equals(this)  ? getConditionCheckAdapter().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "motorRotationSpeed" + "=" + (getMotorRotationSpeed() != null ? !getMotorRotationSpeed().equals(this)  ? getMotorRotationSpeed().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "motorOilQuantity" + "=" + (getMotorOilQuantity() != null ? !getMotorOilQuantity().equals(this)  ? getMotorOilQuantity().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "motorOilViscosity" + "=" + (getMotorOilViscosity() != null ? !getMotorOilViscosity().equals(this)  ? getMotorOilViscosity().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "throttleControl" + "=" + (getThrottleControl() != null ? !getThrottleControl().equals(this)  ? getThrottleControl().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "motorOilCheck" + "=" + (getMotorOilCheck() != null ? !getMotorOilCheck().equals(this)  ? getMotorOilCheck().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "carInformation" + "=" + (getCarInformation() != null ? !getCarInformation().equals(this)  ? getCarInformation().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}