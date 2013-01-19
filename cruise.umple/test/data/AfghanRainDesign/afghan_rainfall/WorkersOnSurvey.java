/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package afghan_rainfall;
import java.sql.Date;
import java.util.*;

// line 47 "../AfghanRainDesign.ump"
// line 163 "../AfghanRainDesign.ump"
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
  private List<VillageSurvey> villageSurveies;
  private List<Worker> workers;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public WorkersOnSurvey(int aId, Date aDate_assigned_from, Date aDate_assigned_to)
  {
    cachedHashCode = -1;
    canSetId = true;
    id = aId;
    date_assigned_from = aDate_assigned_from;
    date_assigned_to = aDate_assigned_to;
    villageSurveies = new ArrayList<VillageSurvey>();
    workers = new ArrayList<Worker>();
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

  public boolean setDate_assigned_from(Date aDate_assigned_from)
  {
    boolean wasSet = false;
    date_assigned_from = aDate_assigned_from;
    wasSet = true;
    return wasSet;
  }

  public boolean setDate_assigned_to(Date aDate_assigned_to)
  {
    boolean wasSet = false;
    date_assigned_to = aDate_assigned_to;
    wasSet = true;
    return wasSet;
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
    VillageSurvey aVillageSurvey = villageSurveies.get(index);
    return aVillageSurvey;
  }

  public List<VillageSurvey> getVillageSurveies()
  {
    List<VillageSurvey> newVillageSurveies = Collections.unmodifiableList(villageSurveies);
    return newVillageSurveies;
  }

  public int numberOfVillageSurveies()
  {
    int number = villageSurveies.size();
    return number;
  }

  public boolean hasVillageSurveies()
  {
    boolean has = villageSurveies.size() > 0;
    return has;
  }

  public int indexOfVillageSurvey(VillageSurvey aVillageSurvey)
  {
    int index = villageSurveies.indexOf(aVillageSurvey);
    return index;
  }

  public Worker getWorker(int index)
  {
    Worker aWorker = workers.get(index);
    return aWorker;
  }

  public List<Worker> getWorkers()
  {
    List<Worker> newWorkers = Collections.unmodifiableList(workers);
    return newWorkers;
  }

  public int numberOfWorkers()
  {
    int number = workers.size();
    return number;
  }

  public boolean hasWorkers()
  {
    boolean has = workers.size() > 0;
    return has;
  }

  public int indexOfWorker(Worker aWorker)
  {
    int index = workers.indexOf(aWorker);
    return index;
  }

  public static int minimumNumberOfVillageSurveies()
  {
    return 0;
  }

  public VillageSurvey addVillageSurvey(int aId, Date aDue_date, Date aCompletion_date)
  {
    return new VillageSurvey(aId, aDue_date, aCompletion_date, this);
  }

  public boolean addVillageSurvey(VillageSurvey aVillageSurvey)
  {
    boolean wasAdded = false;
    if (villageSurveies.contains(aVillageSurvey)) { return false; }
    WorkersOnSurvey existingWorkersOnSurvey = aVillageSurvey.getWorkersOnSurvey();
    boolean isNewWorkersOnSurvey = existingWorkersOnSurvey != null && !this.equals(existingWorkersOnSurvey);
    if (isNewWorkersOnSurvey)
    {
      aVillageSurvey.setWorkersOnSurvey(this);
    }
    else
    {
      villageSurveies.add(aVillageSurvey);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeVillageSurvey(VillageSurvey aVillageSurvey)
  {
    boolean wasRemoved = false;
    //Unable to remove aVillageSurvey, as it must always have a workersOnSurvey
    if (!this.equals(aVillageSurvey.getWorkersOnSurvey()))
    {
      villageSurveies.remove(aVillageSurvey);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addVillageSurveyAt(VillageSurvey aVillageSurvey, int index)
  {  
    boolean wasAdded = false;
    if(addVillageSurvey(aVillageSurvey))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVillageSurveies()) { index = numberOfVillageSurveies() - 1; }
      villageSurveies.remove(aVillageSurvey);
      villageSurveies.add(index, aVillageSurvey);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveVillageSurveyAt(VillageSurvey aVillageSurvey, int index)
  {
    boolean wasAdded = false;
    if(villageSurveies.contains(aVillageSurvey))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVillageSurveies()) { index = numberOfVillageSurveies() - 1; }
      villageSurveies.remove(aVillageSurvey);
      villageSurveies.add(index, aVillageSurvey);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addVillageSurveyAt(aVillageSurvey, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfWorkers()
  {
    return 0;
  }

  public Worker addWorker(int aId, String aGender, String aName, String aOther_work_details)
  {
    return new Worker(aId, aGender, aName, aOther_work_details, this);
  }

  public boolean addWorker(Worker aWorker)
  {
    boolean wasAdded = false;
    if (workers.contains(aWorker)) { return false; }
    WorkersOnSurvey existingWorkersOnSurvey = aWorker.getWorkersOnSurvey();
    boolean isNewWorkersOnSurvey = existingWorkersOnSurvey != null && !this.equals(existingWorkersOnSurvey);
    if (isNewWorkersOnSurvey)
    {
      aWorker.setWorkersOnSurvey(this);
    }
    else
    {
      workers.add(aWorker);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeWorker(Worker aWorker)
  {
    boolean wasRemoved = false;
    //Unable to remove aWorker, as it must always have a workersOnSurvey
    if (!this.equals(aWorker.getWorkersOnSurvey()))
    {
      workers.remove(aWorker);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addWorkerAt(Worker aWorker, int index)
  {  
    boolean wasAdded = false;
    if(addWorker(aWorker))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWorkers()) { index = numberOfWorkers() - 1; }
      workers.remove(aWorker);
      workers.add(index, aWorker);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveWorkerAt(Worker aWorker, int index)
  {
    boolean wasAdded = false;
    if(workers.contains(aWorker))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWorkers()) { index = numberOfWorkers() - 1; }
      workers.remove(aWorker);
      workers.add(index, aWorker);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addWorkerAt(aWorker, index);
    }
    return wasAdded;
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
    for(int i=villageSurveies.size(); i > 0; i--)
    {
      VillageSurvey aVillageSurvey = villageSurveies.get(i - 1);
      aVillageSurvey.delete();
    }
    for(int i=workers.size(); i > 0; i--)
    {
      Worker aWorker = workers.get(i - 1);
      aWorker.delete();
    }
  }

}