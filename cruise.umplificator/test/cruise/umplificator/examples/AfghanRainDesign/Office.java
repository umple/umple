/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 21 "AfghanRainDesign.ump"
// line 174 "AfghanRainDesign.ump"
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
    cachedHashCode = -1;
    canSetId = true;
    id = aId;
    name = aName;
    other_office_details = aOther_office_details;
    boolean didAddWorker = setWorker(aWorker);
    if (!didAddWorker)
    {
      throw new RuntimeException("Unable to create office due to worker");
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

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setOther_office_details(String aOther_office_details)
  {
    boolean wasSet = false;
    other_office_details = aOther_office_details;
    wasSet = true;
    return wasSet;
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
    boolean wasSet = false;
    if (aWorker == null)
    {
      return wasSet;
    }

    Worker existingWorker = worker;
    worker = aWorker;
    if (existingWorker != null && !existingWorker.equals(aWorker))
    {
      existingWorker.removeOffice(this);
    }
    worker.addOffice(this);
    wasSet = true;
    return wasSet;
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
    Worker placeholderWorker = worker;
    this.worker = null;
    placeholderWorker.removeOffice(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "name" + ":" + getName()+ "," +
            "other_office_details" + ":" + getOther_office_details()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "worker = "+(getWorker()!=null?Integer.toHexString(System.identityHashCode(getWorker())):"null")
     + outputString;
  }
}