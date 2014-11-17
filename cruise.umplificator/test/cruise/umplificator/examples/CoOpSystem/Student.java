/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 49 "CoOpSystem.ump"
// line 114 "CoOpSystem.ump"
public class Student
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Student Attributes
  private int stNum;

  //Student Associations
  private Transcript transcript;
  private List<TimeSlot> timeSlots;
  private List<Program> programs;
  private List<Application> applications;
  private Resume resume;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Student(int aStNum, Transcript aTranscript, Program... allPrograms)
  {
    stNum = aStNum;
    if (aTranscript == null || aTranscript.getStudent() != null)
    {
      throw new RuntimeException("Unable to create Student due to aTranscript");
    }
    transcript = aTranscript;
    timeSlots = new ArrayList<TimeSlot>();
    programs = new ArrayList<Program>();
    boolean didAddPrograms = setPrograms(allPrograms);
    if (!didAddPrograms)
    {
      throw new RuntimeException("Unable to create Student, must have at least 1 programs");
    }
    applications = new ArrayList<Application>();
  }

  public Student(int aStNum, String aTextForTranscript, Program... allPrograms)
  {
    stNum = aStNum;
    transcript = new Transcript(aTextForTranscript, this);
    timeSlots = new ArrayList<TimeSlot>();
    programs = new ArrayList<Program>();
    boolean didAddPrograms = setPrograms(allPrograms);
    if (!didAddPrograms)
    {
      throw new RuntimeException("Unable to create Student, must have at least 1 programs");
    }
    applications = new ArrayList<Application>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStNum(int aStNum)
  {
    boolean wasSet = false;
    stNum = aStNum;
    wasSet = true;
    return wasSet;
  }

  public int getStNum()
  {
    return stNum;
  }

  public Transcript getTranscript()
  {
    return transcript;
  }

  public TimeSlot getTimeSlot(int index)
  {
    TimeSlot aTimeSlot = timeSlots.get(index);
    return aTimeSlot;
  }

  public List<TimeSlot> getTimeSlots()
  {
    List<TimeSlot> newTimeSlots = Collections.unmodifiableList(timeSlots);
    return newTimeSlots;
  }

  public int numberOfTimeSlots()
  {
    int number = timeSlots.size();
    return number;
  }

  public boolean hasTimeSlots()
  {
    boolean has = timeSlots.size() > 0;
    return has;
  }

  public int indexOfTimeSlot(TimeSlot aTimeSlot)
  {
    int index = timeSlots.indexOf(aTimeSlot);
    return index;
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

  public Resume getResume()
  {
    return resume;
  }

  public boolean hasResume()
  {
    boolean has = resume != null;
    return has;
  }

  public static int minimumNumberOfTimeSlots()
  {
    return 0;
  }

  public boolean addTimeSlot(TimeSlot aTimeSlot)
  {
    boolean wasAdded = false;
    if (timeSlots.contains(aTimeSlot)) { return false; }
    timeSlots.add(aTimeSlot);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTimeSlot(TimeSlot aTimeSlot)
  {
    boolean wasRemoved = false;
    if (timeSlots.contains(aTimeSlot))
    {
      timeSlots.remove(aTimeSlot);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addTimeSlotAt(TimeSlot aTimeSlot, int index)
  {  
    boolean wasAdded = false;
    if(addTimeSlot(aTimeSlot))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTimeSlots()) { index = numberOfTimeSlots() - 1; }
      timeSlots.remove(aTimeSlot);
      timeSlots.add(index, aTimeSlot);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTimeSlotAt(TimeSlot aTimeSlot, int index)
  {
    boolean wasAdded = false;
    if(timeSlots.contains(aTimeSlot))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTimeSlots()) { index = numberOfTimeSlots() - 1; }
      timeSlots.remove(aTimeSlot);
      timeSlots.add(index, aTimeSlot);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTimeSlotAt(aTimeSlot, index);
    }
    return wasAdded;
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
    if (aProgram.indexOfStudent(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aProgram.addStudent(this);
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
    if (aProgram.indexOfStudent(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aProgram.removeStudent(this);
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
        aNewProgram.addStudent(this);
      }
    }

    for (Program anOldProgram : oldPrograms)
    {
      anOldProgram.removeStudent(this);
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

  public Application addApplication(Job aJob)
  {
    return new Application(this, aJob);
  }

  public boolean addApplication(Application aApplication)
  {
    boolean wasAdded = false;
    if (applications.contains(aApplication)) { return false; }
    Student existingStudent = aApplication.getStudent();
    boolean isNewStudent = existingStudent != null && !this.equals(existingStudent);
    if (isNewStudent)
    {
      aApplication.setStudent(this);
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
    //Unable to remove aApplication, as it must always have a student
    if (!this.equals(aApplication.getStudent()))
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

  public boolean setResume(Resume aNewResume)
  {
    boolean wasSet = false;
    if (resume != null && !resume.equals(aNewResume) && equals(resume.getStudent()))
    {
      //Unable to setResume, as existing resume would become an orphan
      return wasSet;
    }

    resume = aNewResume;
    Student anOldStudent = aNewResume != null ? aNewResume.getStudent() : null;

    if (!this.equals(anOldStudent))
    {
      if (anOldStudent != null)
      {
        anOldStudent.resume = null;
      }
      if (resume != null)
      {
        resume.setStudent(this);
      }
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Transcript existingTranscript = transcript;
    transcript = null;
    if (existingTranscript != null)
    {
      existingTranscript.delete();
    }
    timeSlots.clear();
    ArrayList<Program> copyOfPrograms = new ArrayList<Program>(programs);
    programs.clear();
    for(Program aProgram : copyOfPrograms)
    {
      aProgram.removeStudent(this);
    }
    for(int i=applications.size(); i > 0; i--)
    {
      Application aApplication = applications.get(i - 1);
      aApplication.delete();
    }
    Resume existingResume = resume;
    resume = null;
    if (existingResume != null)
    {
      existingResume.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "stNum" + ":" + getStNum()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "transcript = "+(getTranscript()!=null?Integer.toHexString(System.identityHashCode(getTranscript())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "resume = "+(getResume()!=null?Integer.toHexString(System.identityHashCode(getResume())):"null")
     + outputString;
  }
}