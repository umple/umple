/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package afghan_rainfall;
import java.util.*;

/**
 * associationClass Workder
 */
// line 34 "../AfghanRainDesign.ump"
// line 143 "../AfghanRainDesign.ump"
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
    cachedHashCode = -1;
    canSetId = true;
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

  public boolean setGender(String aGender)
  {
    boolean wasSet = false;
    gender = aGender;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setOther_work_details(String aOther_work_details)
  {
    boolean wasSet = false;
    other_work_details = aOther_work_details;
    wasSet = true;
    return wasSet;
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
    Office aOffice = offices.get(index);
    return aOffice;
  }

  public List<Office> getOffices()
  {
    List<Office> newOffices = Collections.unmodifiableList(offices);
    return newOffices;
  }

  public int numberOfOffices()
  {
    int number = offices.size();
    return number;
  }

  public boolean hasOffices()
  {
    boolean has = offices.size() > 0;
    return has;
  }

  public int indexOfOffice(Office aOffice)
  {
    int index = offices.indexOf(aOffice);
    return index;
  }

  public WorkerRole getWorkerRole(int index)
  {
    WorkerRole aWorkerRole = workerRoles.get(index);
    return aWorkerRole;
  }

  public List<WorkerRole> getWorkerRoles()
  {
    List<WorkerRole> newWorkerRoles = Collections.unmodifiableList(workerRoles);
    return newWorkerRoles;
  }

  public int numberOfWorkerRoles()
  {
    int number = workerRoles.size();
    return number;
  }

  public boolean hasWorkerRoles()
  {
    boolean has = workerRoles.size() > 0;
    return has;
  }

  public int indexOfWorkerRole(WorkerRole aWorkerRole)
  {
    int index = workerRoles.indexOf(aWorkerRole);
    return index;
  }

  public WorkersOnSurvey getWorkersOnSurvey()
  {
    return workersOnSurvey;
  }

  public static int minimumNumberOfOffices()
  {
    return 0;
  }

  public Office addOffice(int aId, String aName, String aOther_office_details)
  {
    return new Office(aId, aName, aOther_office_details, this);
  }

  public boolean addOffice(Office aOffice)
  {
    boolean wasAdded = false;
    if (offices.contains(aOffice)) { return false; }
    Worker existingWorker = aOffice.getWorker();
    boolean isNewWorker = existingWorker != null && !this.equals(existingWorker);
    if (isNewWorker)
    {
      aOffice.setWorker(this);
    }
    else
    {
      offices.add(aOffice);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOffice(Office aOffice)
  {
    boolean wasRemoved = false;
    //Unable to remove aOffice, as it must always have a worker
    if (!this.equals(aOffice.getWorker()))
    {
      offices.remove(aOffice);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addOfficeAt(Office aOffice, int index)
  {  
    boolean wasAdded = false;
    if(addOffice(aOffice))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOffices()) { index = numberOfOffices() - 1; }
      offices.remove(aOffice);
      offices.add(index, aOffice);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOfficeAt(Office aOffice, int index)
  {
    boolean wasAdded = false;
    if(offices.contains(aOffice))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOffices()) { index = numberOfOffices() - 1; }
      offices.remove(aOffice);
      offices.add(index, aOffice);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOfficeAt(aOffice, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfWorkerRoles()
  {
    return 0;
  }

  public WorkerRole addWorkerRole(String aCode, String aDescription)
  {
    return new WorkerRole(aCode, aDescription, this);
  }

  public boolean addWorkerRole(WorkerRole aWorkerRole)
  {
    boolean wasAdded = false;
    if (workerRoles.contains(aWorkerRole)) { return false; }
    Worker existingWorker = aWorkerRole.getWorker();
    boolean isNewWorker = existingWorker != null && !this.equals(existingWorker);
    if (isNewWorker)
    {
      aWorkerRole.setWorker(this);
    }
    else
    {
      workerRoles.add(aWorkerRole);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeWorkerRole(WorkerRole aWorkerRole)
  {
    boolean wasRemoved = false;
    //Unable to remove aWorkerRole, as it must always have a worker
    if (!this.equals(aWorkerRole.getWorker()))
    {
      workerRoles.remove(aWorkerRole);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addWorkerRoleAt(WorkerRole aWorkerRole, int index)
  {  
    boolean wasAdded = false;
    if(addWorkerRole(aWorkerRole))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWorkerRoles()) { index = numberOfWorkerRoles() - 1; }
      workerRoles.remove(aWorkerRole);
      workerRoles.add(index, aWorkerRole);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveWorkerRoleAt(WorkerRole aWorkerRole, int index)
  {
    boolean wasAdded = false;
    if(workerRoles.contains(aWorkerRole))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWorkerRoles()) { index = numberOfWorkerRoles() - 1; }
      workerRoles.remove(aWorkerRole);
      workerRoles.add(index, aWorkerRole);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addWorkerRoleAt(aWorkerRole, index);
    }
    return wasAdded;
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
      existingWorkersOnSurvey.removeWorker(this);
    }
    workersOnSurvey.addWorker(this);
    wasSet = true;
    return wasSet;
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
    for(int i=offices.size(); i > 0; i--)
    {
      Office aOffice = offices.get(i - 1);
      aOffice.delete();
    }
    for(int i=workerRoles.size(); i > 0; i--)
    {
      WorkerRole aWorkerRole = workerRoles.get(i - 1);
      aWorkerRole.delete();
    }
    WorkersOnSurvey placeholderWorkersOnSurvey = workersOnSurvey;
    this.workersOnSurvey = null;
    placeholderWorkersOnSurvey.removeWorker(this);
  }

}