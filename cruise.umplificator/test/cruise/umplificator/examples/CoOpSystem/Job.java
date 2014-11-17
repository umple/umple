/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.sql.Date;
import java.util.*;

// line 20 "CoOpSystem.ump"
// line 90 "CoOpSystem.ump"
public class Job
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Job Attributes
  private String description;
  private String location;
  private Date startDate;
  private Date endDate;

  //Job Associations
  private List<Program> programs;
  private List<Application> applications;
  private Employer employer;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Job(String aDescription, String aLocation, Date aStartDate, Date aEndDate, Employer aEmployer, Program... allPrograms)
  {
    description = aDescription;
    location = aLocation;
    startDate = aStartDate;
    endDate = aEndDate;
    programs = new ArrayList<Program>();
    boolean didAddPrograms = setPrograms(allPrograms);
    if (!didAddPrograms)
    {
      throw new RuntimeException("Unable to create Job, must have at least 1 programs");
    }
    applications = new ArrayList<Application>();
    boolean didAddEmployer = setEmployer(aEmployer);
    if (!didAddEmployer)
    {
      throw new RuntimeException("Unable to create job due to employer");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public boolean setLocation(String aLocation)
  {
    boolean wasSet = false;
    location = aLocation;
    wasSet = true;
    return wasSet;
  }

  public boolean setStartDate(Date aStartDate)
  {
    boolean wasSet = false;
    startDate = aStartDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndDate(Date aEndDate)
  {
    boolean wasSet = false;
    endDate = aEndDate;
    wasSet = true;
    return wasSet;
  }

  public String getDescription()
  {
    return description;
  }

  public String getLocation()
  {
    return location;
  }

  public Date getStartDate()
  {
    return startDate;
  }

  public Date getEndDate()
  {
    return endDate;
  }

  public Program getProgram(int index)
  {
    Program aProgram = programs.get(index);
    return aProgram;
  }

  public List<Program> getPrograms()
  {
    List<Program> newPrograms = Collections.unmodifiableList(programs);
    return newPrograms;
  }

  public int numberOfPrograms()
  {
    int number = programs.size();
    return number;
  }

  public boolean hasPrograms()
  {
    boolean has = programs.size() > 0;
    return has;
  }

  public int indexOfProgram(Program aProgram)
  {
    int index = programs.indexOf(aProgram);
    return index;
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

  public Employer getEmployer()
  {
    return employer;
  }

  public boolean isNumberOfProgramsValid()
  {
    boolean isValid = numberOfPrograms() >= minimumNumberOfPrograms();
    return isValid;
  }

  public static int minimumNumberOfPrograms()
  {
    return 1;
  }

  public boolean addProgram(Program aProgram)
  {
    boolean wasAdded = false;
    if (programs.contains(aProgram)) { return false; }
    programs.add(aProgram);
    if (aProgram.indexOfJob(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aProgram.addJob(this);
      if (!wasAdded)
      {
        programs.remove(aProgram);
      }
    }
    return wasAdded;
  }

  public boolean removeProgram(Program aProgram)
  {
    boolean wasRemoved = false;
    if (!programs.contains(aProgram))
    {
      return wasRemoved;
    }

    if (numberOfPrograms() <= minimumNumberOfPrograms())
    {
      return wasRemoved;
    }

    int oldIndex = programs.indexOf(aProgram);
    programs.remove(oldIndex);
    if (aProgram.indexOfJob(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aProgram.removeJob(this);
      if (!wasRemoved)
      {
        programs.add(oldIndex,aProgram);
      }
    }
    return wasRemoved;
  }

  public boolean setPrograms(Program... newPrograms)
  {
    boolean wasSet = false;
    ArrayList<Program> verifiedPrograms = new ArrayList<Program>();
    for (Program aProgram : newPrograms)
    {
      if (verifiedPrograms.contains(aProgram))
      {
        continue;
      }
      verifiedPrograms.add(aProgram);
    }

    if (verifiedPrograms.size() != newPrograms.length || verifiedPrograms.size() < minimumNumberOfPrograms())
    {
      return wasSet;
    }

    ArrayList<Program> oldPrograms = new ArrayList<Program>(programs);
    programs.clear();
    for (Program aNewProgram : verifiedPrograms)
    {
      programs.add(aNewProgram);
      if (oldPrograms.contains(aNewProgram))
      {
        oldPrograms.remove(aNewProgram);
      }
      else
      {
        aNewProgram.addJob(this);
      }
    }

    for (Program anOldProgram : oldPrograms)
    {
      anOldProgram.removeJob(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean addProgramAt(Program aProgram, int index)
  {  
    boolean wasAdded = false;
    if(addProgram(aProgram))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPrograms()) { index = numberOfPrograms() - 1; }
      programs.remove(aProgram);
      programs.add(index, aProgram);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveProgramAt(Program aProgram, int index)
  {
    boolean wasAdded = false;
    if(programs.contains(aProgram))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPrograms()) { index = numberOfPrograms() - 1; }
      programs.remove(aProgram);
      programs.add(index, aProgram);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addProgramAt(aProgram, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfApplications()
  {
    return 0;
  }

  public Application addApplication(Student aStudent)
  {
    return new Application(aStudent, this);
  }

  public boolean addApplication(Application aApplication)
  {
    boolean wasAdded = false;
    if (applications.contains(aApplication)) { return false; }
    Job existingJob = aApplication.getJob();
    boolean isNewJob = existingJob != null && !this.equals(existingJob);
    if (isNewJob)
    {
      aApplication.setJob(this);
    }
    else
    {
      applications.add(aApplication);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeApplication(Application aApplication)
  {
    boolean wasRemoved = false;
    //Unable to remove aApplication, as it must always have a job
    if (!this.equals(aApplication.getJob()))
    {
      applications.remove(aApplication);
      wasRemoved = true;
    }
    return wasRemoved;
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

  public boolean setEmployer(Employer aEmployer)
  {
    boolean wasSet = false;
    if (aEmployer == null)
    {
      return wasSet;
    }

    Employer existingEmployer = employer;
    employer = aEmployer;
    if (existingEmployer != null && !existingEmployer.equals(aEmployer))
    {
      existingEmployer.removeJob(this);
    }
    employer.addJob(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Program> copyOfPrograms = new ArrayList<Program>(programs);
    programs.clear();
    for(Program aProgram : copyOfPrograms)
    {
      aProgram.removeJob(this);
    }
    for(int i=applications.size(); i > 0; i--)
    {
      Application aApplication = applications.get(i - 1);
      aApplication.delete();
    }
    Employer placeholderEmployer = employer;
    this.employer = null;
    placeholderEmployer.removeJob(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "description" + ":" + getDescription()+ "," +
            "location" + ":" + getLocation()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "startDate" + "=" + (getStartDate() != null ? !getStartDate().equals(this)  ? getStartDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "endDate" + "=" + (getEndDate() != null ? !getEndDate().equals(this)  ? getEndDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "employer = "+(getEmployer()!=null?Integer.toHexString(System.identityHashCode(getEmployer())):"null")
     + outputString;
  }
}