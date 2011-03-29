/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.8.1.2163 modeling language!*/

package afghan_rainfall;
import java.util.*;

public class Worker
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Worker Attributes
  private int id;
  private String gender;
  private String name;
  private String other_work_details;

  //Worker Associations
  private List<Office> offices;
  private List<WorkerRole> workerRoles;
  private WorkersOnSurvey workersOnSurvey;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Worker(int aId, String aGender, String aName, String aOther_work_details, WorkersOnSurvey aWorkersOnSurvey)
  {
    id = aId;
    gender = aGender;
    name = aName;
    other_work_details = aOther_work_details;
    offices = new ArrayList<Office>();
    workerRoles = new ArrayList<WorkerRole>();
    boolean didAddWorkersOnSurvey = setWorkersOnSurvey(aWorkersOnSurvey);
    if (!didAddWorkersOnSurvey)
    {
      throw new RuntimeException("Unable to create worker due to workersOnSurvey");
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

  public boolean setGender(String aGender)
  {
    gender = aGender;
    return true;
  }

  public boolean setName(String aName)
  {
    name = aName;
    return true;
  }

  public boolean setOther_work_details(String aOther_work_details)
  {
    other_work_details = aOther_work_details;
    return true;
  }

  public int getId()
  {
    return id;
  }

  public String getGender()
  {
    return gender;
  }

  public String getName()
  {
    return name;
  }

  public String getOther_work_details()
  {
    return other_work_details;
  }

  public Office getOffice(int index)
  {
    return offices.get(index);
  }

  public List<Office> getOffices()
  {
    return Collections.unmodifiableList(offices);
  }

  public int numberOfOffices()
  {
    return offices.size();
  }

  public boolean hasOffices()
  {
    return offices.size() > 0;
  }

  public int indexOfOffice(Office aOffice)
  {
    return offices.indexOf(aOffice);
  }

  public WorkerRole getWorkerRole(int index)
  {
    return workerRoles.get(index);
  }

  public List<WorkerRole> getWorkerRoles()
  {
    return Collections.unmodifiableList(workerRoles);
  }

  public int numberOfWorkerRoles()
  {
    return workerRoles.size();
  }

  public boolean hasWorkerRoles()
  {
    return workerRoles.size() > 0;
  }

  public int indexOfWorkerRole(WorkerRole aWorkerRole)
  {
    return workerRoles.indexOf(aWorkerRole);
  }

  public WorkersOnSurvey getWorkersOnSurvey()
  {
    return workersOnSurvey;
  }

  public Office addOffice(int aId, String aName, String aOther_office_details)
  {
    return new Office(aId, aName, aOther_office_details, this);
  }

  public boolean addOffice(Office aOffice)
  {
    if (offices.contains(aOffice))
    {
      return false;
    }

    Worker existingWorker = aOffice.getWorker();
    boolean isNewWorker = existingWorker != null && !existingWorker.equals(this);
    if (isNewWorker)
    {
      aOffice.setWorker(this);
    }
    else
    {
      offices.add(aOffice);
    }
    return true;
  }

  public boolean removeOffice(Office aOffice)
  {
    //Unable to remove aOffice, as it must always have a worker
    if (aOffice.getWorker().equals(this))
    {
      return false;
    }
    else
    {
      offices.remove(aOffice);
      return true;
    }
  }

  public WorkerRole addWorkerRole(String aCode, String aDescription)
  {
    return new WorkerRole(aCode, aDescription, this);
  }

  public boolean addWorkerRole(WorkerRole aWorkerRole)
  {
    if (workerRoles.contains(aWorkerRole))
    {
      return false;
    }

    Worker existingWorker = aWorkerRole.getWorker();
    boolean isNewWorker = existingWorker != null && !existingWorker.equals(this);
    if (isNewWorker)
    {
      aWorkerRole.setWorker(this);
    }
    else
    {
      workerRoles.add(aWorkerRole);
    }
    return true;
  }

  public boolean removeWorkerRole(WorkerRole aWorkerRole)
  {
    //Unable to remove aWorkerRole, as it must always have a worker
    if (aWorkerRole.getWorker().equals(this))
    {
      return false;
    }
    else
    {
      workerRoles.remove(aWorkerRole);
      return true;
    }
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
      existingWorkersOnSurvey.removeWorker(this);
    }
    workersOnSurvey.addWorker(this);
    return true;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Worker compareTo = (Worker)obj;
  
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
    for(Office aOffice : offices)
    {
      aOffice.delete();
    }
    for(WorkerRole aWorkerRole : workerRoles)
    {
      aWorkerRole.delete();
    }
    workersOnSurvey.removeWorker(this);
  }

}