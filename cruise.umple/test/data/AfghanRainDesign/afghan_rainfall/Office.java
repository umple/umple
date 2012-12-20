/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.8.1.2163 modeling language!*/

package afghan_rainfall;

public class Office
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Office Attributes
  private int id;
  private String name;
  private String other_office_details;

  //Office Associations
  private Worker worker;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Office(int aId, String aName, String aOther_office_details, Worker aWorker)
  {
    id = aId;
    name = aName;
    other_office_details = aOther_office_details;
    boolean didAddWorker = setWorker(aWorker);
    if (!didAddWorker)
    {
      throw new RuntimeException("Unable to create office due to worker");
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

  public boolean setName(String aName)
  {
    name = aName;
    return true;
  }

  public boolean setOther_office_details(String aOther_office_details)
  {
    other_office_details = aOther_office_details;
    return true;
  }

  public int getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public String getOther_office_details()
  {
    return other_office_details;
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
      existingWorker.removeOffice(this);
    }
    worker.addOffice(this);
    return true;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Office compareTo = (Office)obj;
  
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
    worker.removeOffice(this);
  }

}