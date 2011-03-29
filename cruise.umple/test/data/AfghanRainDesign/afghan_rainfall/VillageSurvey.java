/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.8.1.2163 modeling language!*/

package afghan_rainfall;
import java.sql.Date;

public class VillageSurvey
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //VillageSurvey Attributes
  private int id;
  private Date due_date;
  private String status;
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

  public VillageSurvey(int aId, Date aDue_date, String aStatus, Date aCompletion_date, WorkersOnSurvey aWorkersOnSurvey)
  {
    id = aId;
    due_date = aDue_date;
    status = aStatus;
    completion_date = aCompletion_date;
    boolean didAddWorkersOnSurvey = setWorkersOnSurvey(aWorkersOnSurvey);
    if (!didAddWorkersOnSurvey)
    {
      throw new RuntimeException("Unable to create villageSurvey due to workersOnSurvey");
    }
    cachedHashCode = -1;
    canSetId = true;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(int aId)
  {
    if (!canSetId)
    {
      return false;
    }
    id = aId;
    return true;
  }

  public boolean setDue_date(Date aDue_date)
  {
    due_date = aDue_date;
    return true;
  }

  public boolean setStatus(String aStatus)
  {
    status = aStatus;
    return true;
  }

  public boolean setCompletion_date(Date aCompletion_date)
  {
    completion_date = aCompletion_date;
    return true;
  }

  public int getId()
  {
    return id;
  }

  public Date getDue_date()
  {
    return due_date;
  }

  public String getStatus()
  {
    return status;
  }

  public Date getCompletion_date()
  {
    return completion_date;
  }

  public Village getVillage()
  {
    return village;
  }

  public WorkersOnSurvey getWorkersOnSurvey()
  {
    return workersOnSurvey;
  }

  public boolean setVillage(Village newVillage)
  {
    village = newVillage;
    return true;
  }

  public boolean setWorkersOnSurvey(WorkersOnSurvey aWorkersOnSurvey)
  {
    if (aWorkersOnSurvey == null)
    {
      return false;
    }
    
    WorkersOnSurvey existingWorkersOnSurvey = workersOnSurvey;
    workersOnSurvey = aWorkersOnSurvey;
    if (existingWorkersOnSurvey != null && !existingWorkersOnSurvey.equals(aWorkersOnSurvey))
    {
      existingWorkersOnSurvey.removeVillageSurvey(this);
    }
    workersOnSurvey.addVillageSurvey(this);
    return true;
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
    workersOnSurvey.removeVillageSurvey(this);
  }

}