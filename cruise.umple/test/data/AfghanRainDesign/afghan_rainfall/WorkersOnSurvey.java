/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.8.1.2163 modeling language!*/

package afghan_rainfall;
import java.sql.Date;
import java.util.*;

public class WorkersOnSurvey
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //WorkersOnSurvey Attributes
  private int id;
  private Date date_assigned_from;
  private Date date_assigned_to;

  //WorkersOnSurvey Associations
  private List<VillageSurvey> villageSurveys;
  private List<Worker> workers;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public WorkersOnSurvey(int aId, Date aDate_assigned_from, Date aDate_assigned_to)
  {
    id = aId;
    date_assigned_from = aDate_assigned_from;
    date_assigned_to = aDate_assigned_to;
    villageSurveys = new ArrayList<VillageSurvey>();
    workers = new ArrayList<Worker>();
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

  public boolean setDate_assigned_from(Date aDate_assigned_from)
  {
    date_assigned_from = aDate_assigned_from;
    return true;
  }

  public boolean setDate_assigned_to(Date aDate_assigned_to)
  {
    date_assigned_to = aDate_assigned_to;
    return true;
  }

  public int getId()
  {
    return id;
  }

  public Date getDate_assigned_from()
  {
    return date_assigned_from;
  }

  public Date getDate_assigned_to()
  {
    return date_assigned_to;
  }

  public VillageSurvey getVillageSurvey(int index)
  {
    return villageSurveys.get(index);
  }

  public List<VillageSurvey> getVillageSurveys()
  {
    return Collections.unmodifiableList(villageSurveys);
  }

  public int numberOfVillageSurveys()
  {
    return villageSurveys.size();
  }

  public boolean hasVillageSurveys()
  {
    return villageSurveys.size() > 0;
  }

  public int indexOfVillageSurvey(VillageSurvey aVillageSurvey)
  {
    return villageSurveys.indexOf(aVillageSurvey);
  }

  public Worker getWorker(int index)
  {
    return workers.get(index);
  }

  public List<Worker> getWorkers()
  {
    return Collections.unmodifiableList(workers);
  }

  public int numberOfWorkers()
  {
    return workers.size();
  }

  public boolean hasWorkers()
  {
    return workers.size() > 0;
  }

  public int indexOfWorker(Worker aWorker)
  {
    return workers.indexOf(aWorker);
  }

  public VillageSurvey addVillageSurvey(int aId, Date aDue_date, String aStatus, Date aCompletion_date)
  {
    return new VillageSurvey(aId, aDue_date, aStatus, aCompletion_date, this);
  }

  public boolean addVillageSurvey(VillageSurvey aVillageSurvey)
  {
    if (villageSurveys.contains(aVillageSurvey))
    {
      return false;
    }

    WorkersOnSurvey existingWorkersOnSurvey = aVillageSurvey.getWorkersOnSurvey();
    boolean isNewWorkersOnSurvey = existingWorkersOnSurvey != null && !existingWorkersOnSurvey.equals(this);
    if (isNewWorkersOnSurvey)
    {
      aVillageSurvey.setWorkersOnSurvey(this);
    }
    else
    {
      villageSurveys.add(aVillageSurvey);
    }
    return true;
  }

  public boolean removeVillageSurvey(VillageSurvey aVillageSurvey)
  {
    //Unable to remove aVillageSurvey, as it must always have a workersOnSurvey
    if (aVillageSurvey.getWorkersOnSurvey().equals(this))
    {
      return false;
    }
    else
    {
      villageSurveys.remove(aVillageSurvey);
      return true;
    }
  }

  public Worker addWorker(int aId, String aGender, String aName, String aOther_work_details)
  {
    return new Worker(aId, aGender, aName, aOther_work_details, this);
  }

  public boolean addWorker(Worker aWorker)
  {
    if (workers.contains(aWorker))
    {
      return false;
    }

    WorkersOnSurvey existingWorkersOnSurvey = aWorker.getWorkersOnSurvey();
    boolean isNewWorkersOnSurvey = existingWorkersOnSurvey != null && !existingWorkersOnSurvey.equals(this);
    if (isNewWorkersOnSurvey)
    {
      aWorker.setWorkersOnSurvey(this);
    }
    else
    {
      workers.add(aWorker);
    }
    return true;
  }

  public boolean removeWorker(Worker aWorker)
  {
    //Unable to remove aWorker, as it must always have a workersOnSurvey
    if (aWorker.getWorkersOnSurvey().equals(this))
    {
      return false;
    }
    else
    {
      workers.remove(aWorker);
      return true;
    }
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    WorkersOnSurvey compareTo = (WorkersOnSurvey)obj;
  
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
    for(VillageSurvey aVillageSurvey : villageSurveys)
    {
      aVillageSurvey.delete();
    }
    for(Worker aWorker : workers)
    {
      aWorker.delete();
    }
  }

}