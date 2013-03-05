/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.attributes.test;
import java.sql.Date;
import java.sql.Time;

// line 29 "../../../../src/TestHarnessAttributes.ump"
// line 11 "../../../../src/LocalHarness.ump"
public class DoorD
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DoorD Attributes
  private String id;
  private int intId;
  private double doubleId;
  private boolean booleanId;
  private DoorB doorId;
  private Date dateId;
  private Time timeId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DoorD()
  {
    resetId();
    resetIntId();
    resetDoubleId();
    resetBooleanId();
    resetDoorId();
    resetDateId();
    resetTimeId();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean resetId()
  {
    boolean wasReset = false;
    id = getDefaultId();
    wasReset = true;
    return wasReset;
  }

  public boolean setIntId(int aIntId)
  {
    boolean wasSet = false;
    intId = aIntId;
    wasSet = true;
    return wasSet;
  }

  public boolean resetIntId()
  {
    boolean wasReset = false;
    intId = getDefaultIntId();
    wasReset = true;
    return wasReset;
  }

  public boolean setDoubleId(double aDoubleId)
  {
    boolean wasSet = false;
    doubleId = aDoubleId;
    wasSet = true;
    return wasSet;
  }

  public boolean resetDoubleId()
  {
    boolean wasReset = false;
    doubleId = getDefaultDoubleId();
    wasReset = true;
    return wasReset;
  }

  public boolean setBooleanId(boolean aBooleanId)
  {
    boolean wasSet = false;
    booleanId = aBooleanId;
    wasSet = true;
    return wasSet;
  }

  public boolean resetBooleanId()
  {
    boolean wasReset = false;
    booleanId = getDefaultBooleanId();
    wasReset = true;
    return wasReset;
  }

  public boolean setDoorId(DoorB aDoorId)
  {
    boolean wasSet = false;
    doorId = aDoorId;
    wasSet = true;
    return wasSet;
  }

  public boolean resetDoorId()
  {
    boolean wasReset = false;
    doorId = getDefaultDoorId();
    wasReset = true;
    return wasReset;
  }

  public boolean setDateId(Date aDateId)
  {
    boolean wasSet = false;
    dateId = aDateId;
    wasSet = true;
    return wasSet;
  }

  public boolean resetDateId()
  {
    boolean wasReset = false;
    dateId = getDefaultDateId();
    wasReset = true;
    return wasReset;
  }

  public boolean setTimeId(Time aTimeId)
  {
    boolean wasSet = false;
    timeId = aTimeId;
    wasSet = true;
    return wasSet;
  }

  public boolean resetTimeId()
  {
    boolean wasReset = false;
    timeId = getDefaultTimeId();
    wasReset = true;
    return wasReset;
  }

  public String getId()
  {
    return id;
  }

  public String getDefaultId()
  {
    return "1";
  }

  public int getIntId()
  {
    return intId;
  }

  public int getDefaultIntId()
  {
    return 2;
  }

  public double getDoubleId()
  {
    return doubleId;
  }

  public double getDefaultDoubleId()
  {
    return 3.4;
  }

  public boolean getBooleanId()
  {
    return booleanId;
  }

  public boolean getDefaultBooleanId()
  {
    return false;
  }

  public DoorB getDoorId()
  {
    return doorId;
  }

  public DoorB getDefaultDoorId()
  {
    return new DoorB(5);
  }

  public Date getDateId()
  {
    return dateId;
  }

  public Date getDefaultDateId()
  {
    return new Date(1234);
  }

  public Time getTimeId()
  {
    return timeId;
  }

  public Time getDefaultTimeId()
  {
    return new Time(1235);
  }

  public boolean isBooleanId()
  {
    return booleanId;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "intId" + ":" + getIntId()+ "," +
            "doubleId" + ":" + getDoubleId()+ "," +
            "booleanId" + ":" + getBooleanId()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "doorId" + "=" + getDoorId() != null ? !getDoorId() .equals(this)  ? getDoorId().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "dateId" + "=" + getDateId() != null ? !getDateId() .equals(this)  ? getDateId().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "timeId" + "=" + getTimeId() != null ? !getTimeId() .equals(this)  ? getTimeId().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }
}