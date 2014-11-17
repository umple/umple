/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 36 "CoOpSystem.ump"
// line 103 "CoOpSystem.ump"
public class Interview
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Interview Attributes
  private String location;

  //Interview Associations
  private TimeSlot timeSlot;
  private List<Application> applications;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Interview(String aLocation, Application... allApplications)
  {
    location = aLocation;
    applications = new ArrayList<Application>();
    boolean didAddApplications = setApplications(allApplications);
    if (!didAddApplications)
    {
      throw new RuntimeException("Unable to create Interview, must have at least 1 applications");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLocation(String aLocation)
  {
    boolean wasSet = false;
    location = aLocation;
    wasSet = true;
    return wasSet;
  }

  public String getLocation()
  {
    return location;
  }

  public TimeSlot getTimeSlot()
  {
    return timeSlot;
  }

  public boolean hasTimeSlot()
  {
    boolean has = timeSlot != null;
    return has;
  }

  public Application getApplication(int index)
  {
    Application aApplication = applications.get(index);
    return aApplication;
  }

  public List<Application> getApplications()
  {
    List<Application> newApplications = Collections.unmodifiableList(applications);
    return newApplications;
  }

  public int numberOfApplications()
  {
    int number = applications.size();
    return number;
  }

  public boolean hasApplications()
  {
    boolean has = applications.size() > 0;
    return has;
  }

  public int indexOfApplication(Application aApplication)
  {
    int index = applications.indexOf(aApplication);
    return index;
  }

  public boolean setTimeSlot(TimeSlot aNewTimeSlot)
  {
    boolean wasSet = false;
    timeSlot = aNewTimeSlot;
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfApplications()
  {
    return 1;
  }

  public boolean addApplication(Application aApplication)
  {
    boolean wasAdded = false;
    if (applications.contains(aApplication)) { return false; }
    Interview existingInterview = aApplication.getInterview();
    if (existingInterview != null && existingInterview.numberOfApplications() <= minimumNumberOfApplications())
    {
      return wasAdded;
    }
    else if (existingInterview != null)
    {
      existingInterview.applications.remove(aApplication);
    }
    applications.add(aApplication);
    setInterview(aApplication,this);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeApplication(Application aApplication)
  {
    boolean wasRemoved = false;
    if (applications.contains(aApplication) && numberOfApplications() > minimumNumberOfApplications())
    {
      applications.remove(aApplication);
      setInterview(aApplication,null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean setApplications(Application... newApplications)
  {
    boolean wasSet = false;
    if (newApplications.length < minimumNumberOfApplications())
    {
      return wasSet;
    }

    ArrayList<Application> checkNewApplications = new ArrayList<Application>();
    HashMap<Interview,Integer> interviewToNewApplications = new HashMap<Interview,Integer>();
    for (Application aApplication : newApplications)
    {
      if (checkNewApplications.contains(aApplication))
      {
        return wasSet;
      }
      else if (aApplication.getInterview() != null && !this.equals(aApplication.getInterview()))
      {
        Interview existingInterview = aApplication.getInterview();
        if (!interviewToNewApplications.containsKey(existingInterview))
        {
          interviewToNewApplications.put(existingInterview, new Integer(existingInterview.numberOfApplications()));
        }
        Integer currentCount = interviewToNewApplications.get(existingInterview);
        int nextCount = currentCount - 1;
        if (nextCount < 1)
        {
          return wasSet;
        }
        interviewToNewApplications.put(existingInterview, new Integer(nextCount));
      }
      checkNewApplications.add(aApplication);
    }

    applications.removeAll(checkNewApplications);

    for (Application orphan : applications)
    {
      setInterview(orphan, null);
    }
    applications.clear();
    for (Application aApplication : newApplications)
    {
      if (aApplication.getInterview() != null)
      {
        aApplication.getInterview().applications.remove(aApplication);
      }
      setInterview(aApplication, this);
      applications.add(aApplication);
    }
    wasSet = true;
    return wasSet;
  }

  private void setInterview(Application aApplication, Interview aInterview)
  {
    try
    {
      java.lang.reflect.Field mentorField = aApplication.getClass().getDeclaredField("interview");
      mentorField.setAccessible(true);
      mentorField.set(aApplication, aInterview);
    }
    catch (Exception e)
    {
      throw new RuntimeException("Issue internally setting aInterview to aApplication", e);
    }
  }

  public boolean addApplicationAt(Application aApplication, int index)
  {  
    boolean wasAdded = false;
    if(addApplication(aApplication))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfApplications()) { index = numberOfApplications() - 1; }
      applications.remove(aApplication);
      applications.add(index, aApplication);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveApplicationAt(Application aApplication, int index)
  {
    boolean wasAdded = false;
    if(applications.contains(aApplication))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfApplications()) { index = numberOfApplications() - 1; }
      applications.remove(aApplication);
      applications.add(index, aApplication);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addApplicationAt(aApplication, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    timeSlot = null;
    for(Application aApplication : applications)
    {
      setInterview(aApplication,null);
    }
    applications.clear();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "location" + ":" + getLocation()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "timeSlot = "+(getTimeSlot()!=null?Integer.toHexString(System.identityHashCode(getTimeSlot())):"null")
     + outputString;
  }
}