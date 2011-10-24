/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.14.0.957 modeling language!*/

package cruise.attributes.test;
import java.sql.Date;
import java.sql.Time;

public class DoorA
{

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

}