/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.sql.Date;

// line 63 "AfghanRainDesign.ump"
// line 154 "AfghanRainDesign.ump"
public class VillageSurvey
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //VillageSurvey Attributes
  private int id;
  private Date due_date;
  private Date completion_date;

  //VillageSurvey Associations
  private Village village;
  private WorkersOnSurvey workersOnSurvey;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public VillageSurvey(int aId, Date aDue_date, Date aCompletion_date, WorkersOnSurvey aWorkersOnSurvey)
  {
    cachedHashCode = -1;
    canSetId = true;
    id = aId;
    due_date = aDue_date;
    completion_date = aCompletion_date;
    boolean didAddWorkersOnSurvey = setWorkersOnSurvey(aWorkersOnSurvey);
    if (!didAddWorkersOnSurvey)
    {
      throw new RuntimeException("Unable to create villageSurvey due to workersOnSurvey");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(int aId)
  {
    boolean wasSet = false;
    if (!canSetId) { return false; }
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setDue_date(Date aDue_date)
  {
    boolean wasSet = false;
    due_date = aDue_date;
    wasSet = true;
    return wasSet;
  }

  public boolean setCompletion_date(Date aCompletion_date)
  {
    boolean wasSet = false;
    completion_date = aCompletion_date;
    wasSet = true;
    return wasSet;
  }

  public int getId()
  {
    return id;
  }

  public Date getDue_date()
  {
    return due_date;
  }

  public Date getCompletion_date()
  {
    return completion_date;
  }

  public Village getVillage()
  {
    return village;
  }

  public boolean hasVillage()
  {
    boolean has = village != null;
    return has;
  }

  public WorkersOnSurvey getWorkersOnSurvey()
  {
    return workersOnSurvey;
  }

  public boolean setVillage(Village aNewVillage)
  {
    boolean wasSet = false;
    village = aNewVillage;
    wasSet = true;
    return wasSet;
  }

  public boolean setWorkersOnSurvey(WorkersOnSurvey aWorkersOnSurvey)
  {
    boolean wasSet = false;
    if (aWorkersOnSurvey == null)
    {
      return wasSet;
    }

    WorkersOnSurvey existingWorkersOnSurvey = workersOnSurvey;
    workersOnSurvey = aWorkersOnSurvey;
    if (existingWorkersOnSurvey != null && !existingWorkersOnSurvey.equals(aWorkersOnSurvey))
    {
      existingWorkersOnSurvey.removeVillageSurvey(this);
    }
    workersOnSurvey.addVillageSurvey(this);
    wasSet = true;
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    VillageSurvey compareTo = (VillageSurvey)obj;
  
    if (id != compareTo.id)
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    cachedHashCode = cachedHashCode * 23 + id;

    canSetId = false;
    return cachedHashCode;
  }

  public void delete()
  {
    village = null;
    WorkersOnSurvey placeholderWorkersOnSurvey = workersOnSurvey;
    this.workersOnSurvey = null;
    placeholderWorkersOnSurvey.removeVillageSurvey(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "due_date" + "=" + (getDue_date() != null ? !getDue_date().equals(this)  ? getDue_date().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "completion_date" + "=" + (getCompletion_date() != null ? !getCompletion_date().equals(this)  ? getCompletion_date().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "village = "+(getVillage()!=null?Integer.toHexString(System.identityHashCode(getVillage())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "workersOnSurvey = "+(getWorkersOnSurvey()!=null?Integer.toHexString(System.identityHashCode(getWorkersOnSurvey())):"null")
     + outputString;
  }
}