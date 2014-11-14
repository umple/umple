/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 30 "AfghanRainDesign.ump"
// line 190 "AfghanRainDesign.ump"
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
    cachedHashCode = -1;
    canSetCode = true;
    code = aCode;
    description = aDescription;
    boolean didAddWorker = setWorker(aWorker);
    if (!didAddWorker)
    {
      throw new RuntimeException("Unable to create workerRole due to worker");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCode(String aCode)
  {
    boolean wasSet = false;
    if (!canSetCode) { return false; }
    code = aCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
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
    boolean wasSet = false;
    if (aWorker == null)
    {
      return wasSet;
    }

    Worker existingWorker = worker;
    worker = aWorker;
    if (existingWorker != null && !existingWorker.equals(aWorker))
    {
      existingWorker.removeWorkerRole(this);
    }
    worker.addWorkerRole(this);
    wasSet = true;
    return wasSet;
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
    Worker placeholderWorker = worker;
    this.worker = null;
    placeholderWorker.removeWorkerRole(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "code" + ":" + getCode()+ "," +
            "description" + ":" + getDescription()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "worker = "+(getWorker()!=null?Integer.toHexString(System.identityHashCode(getWorker())):"null")
     + outputString;
  }
}