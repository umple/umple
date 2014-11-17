/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 42 "CoOpSystem.ump"
// line 109 "CoOpSystem.ump"
public class TimeSlot
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TimeSlot Attributes
  private String startTime;
  private String endTime;
  private String status;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TimeSlot(String aStartTime, String aEndTime, String aStatus)
  {
    startTime = aStartTime;
    endTime = aEndTime;
    status = aStatus;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStartTime(String aStartTime)
  {
    boolean wasSet = false;
    startTime = aStartTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndTime(String aEndTime)
  {
    boolean wasSet = false;
    endTime = aEndTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setStatus(String aStatus)
  {
    boolean wasSet = false;
    status = aStatus;
    wasSet = true;
    return wasSet;
  }

  public String getStartTime()
  {
    return startTime;
  }

  public String getEndTime()
  {
    return endTime;
  }

  public String getStatus()
  {
    return status;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "startTime" + ":" + getStartTime()+ "," +
            "endTime" + ":" + getEndTime()+ "," +
            "status" + ":" + getStatus()+ "]"
     + outputString;
  }
}