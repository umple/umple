/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.11.1.3376 modeling language!*/

package cruise.attributes.test;
import java.sql.Date;
import java.sql.Time;

public class DoorC
{

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

  public void delete()
  {}

}