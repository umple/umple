/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.8.1.2163 modeling language!*/

package afghan_rainfall;

public class WorkerRole
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //WorkerRole Attributes
  private String code;
  private String description;

  //WorkerRole Associations
  private Worker worker;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetCode;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public WorkerRole(String aCode, String aDescription, Worker aWorker)
  {
    code = aCode;
    description = aDescription;
    boolean didAddWorker = setWorker(aWorker);
    if (!didAddWorker)
    {
      throw new RuntimeException("Unable to create workerRole due to worker");
    }
    cachedHashCode = -1;
    canSetCode = true;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCode(String aCode)
  {
    if (!canSetCode)
    {
      return false;
    }
    code = aCode;
    return true;
  }

  public boolean setDescription(String aDescription)
  {
    description = aDescription;
    return true;
  }

  public String getCode()
  {
    return code;
  }

  public String getDescription()
  {
    return description;
  }

  public Worker getWorker()
  {
    return worker;
  }

  public boolean setWorker(Worker aWorker)
  {
    if (aWorker == null)
    {
      return false;
    }
    
    Worker existingWorker = worker;
    worker = aWorker;
    if (existingWorker != null && !existingWorker.equals(aWorker))
    {
      existingWorker.removeWorkerRole(this);
    }
    worker.addWorkerRole(this);
    return true;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    WorkerRole compareTo = (WorkerRole)obj;
  
    if (code == null && compareTo.code != null)
    {
      return false;
    }
    else if (code != null && !code.equals(compareTo.code))
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
    if (code != null)
    {
      cachedHashCode = cachedHashCode * 23 + code.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetCode = false;
    return cachedHashCode;
  }

  public void delete()
  {
    worker.removeWorkerRole(this);
  }

}