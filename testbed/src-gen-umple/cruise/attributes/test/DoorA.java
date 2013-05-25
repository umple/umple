/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.attributes.test;
import java.sql.Date;
import java.sql.Time;

// line 4 "../../../../src/TestHarnessAttributes.ump"
// line 4 "../../../../src/LocalHarness.ump"
public class DoorA
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DoorA Attributes
  private String id;
  private int intId;
  private double doubleId;
  private boolean booleanId;
  private DoorB doorId;
  private Date dateId;
  private Time timeId;

  //Helper Variables
  private boolean canSetId;
  private boolean canSetIntId;
  private boolean canSetDoubleId;
  private boolean canSetBooleanId;
  private boolean canSetDoorId;
  private boolean canSetDateId;
  private boolean canSetTimeId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DoorA()
  {
    id = "1";
    canSetId = false;
    intId = 2;
    canSetIntId = false;
    doubleId = 3.4;
    canSetDoubleId = false;
    booleanId = false;
    canSetBooleanId = false;
    doorId = new DoorB(5);
    canSetDoorId = false;
    dateId = new Date(1234);
    canSetDateId = false;
    timeId = new Time(1235);
    canSetTimeId = false;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getId()
  {
    return id;
  }

  public int getIntId()
  {
    return intId;
  }

  public double getDoubleId()
  {
    return doubleId;
  }

  public boolean getBooleanId()
  {
    return booleanId;
  }

  public DoorB getDoorId()
  {
    return doorId;
  }

  public Date getDateId()
  {
    return dateId;
  }

  public Time getTimeId()
  {
    return timeId;
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
            "  " + "doorId" + "=" + (getDoorId() != null ? !getDoorId().equals(this)  ? getDoorId().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "dateId" + "=" + (getDateId() != null ? !getDateId().equals(this)  ? getDateId().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "timeId" + "=" + (getTimeId() != null ? !getTimeId().equals(this)  ? getTimeId().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}