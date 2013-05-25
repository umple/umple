/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.attributes.test;
import java.sql.Date;
import java.sql.Time;

// line 18 "../../../../src/TestHarnessAttributes.ump"
public class DoorC
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DoorC Attributes
  private String id;
  private int intId;
  private double doubleId;
  private Date dateId;
  private Time timeId;
  private boolean booleanId;
  private DoorB doorId;

  //Helper Variables
  private boolean canSetId;
  private boolean canSetIntId;
  private boolean canSetDoubleId;
  private boolean canSetDateId;
  private boolean canSetTimeId;
  private boolean canSetBooleanId;
  private boolean canSetDoorId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DoorC(String aId, int aIntId, double aDoubleId, Date aDateId, Time aTimeId, boolean aBooleanId, DoorB aDoorId)
  {
    id = aId;
    canSetId = false;
    intId = aIntId;
    canSetIntId = false;
    doubleId = aDoubleId;
    canSetDoubleId = false;
    dateId = aDateId;
    canSetDateId = false;
    timeId = aTimeId;
    canSetTimeId = false;
    booleanId = aBooleanId;
    canSetBooleanId = false;
    doorId = aDoorId;
    canSetDoorId = false;
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

  public Date getDateId()
  {
    return dateId;
  }

  public Time getTimeId()
  {
    return timeId;
  }

  public boolean getBooleanId()
  {
    return booleanId;
  }

  public DoorB getDoorId()
  {
    return doorId;
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
            "  " + "dateId" + "=" + (getDateId() != null ? !getDateId().equals(this)  ? getDateId().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "timeId" + "=" + (getTimeId() != null ? !getTimeId().equals(this)  ? getTimeId().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "doorId" + "=" + (getDoorId() != null ? !getDoorId().equals(this)  ? getDoorId().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}