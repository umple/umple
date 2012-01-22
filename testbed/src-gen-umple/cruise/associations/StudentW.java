/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.associations;
import java.util.*;

public class StudentW
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentW Attributes
  private int number;

  //StudentW Associations
  private ProgramW program;
  private List<MentorW> mentors;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentW(int aNumber)
  {
    number = aNumber;
    mentors = new ArrayList<MentorW>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumber(int aNumber)
  {
    boolean wasSet = false;
    number = aNumber;
    wasSet = true;
    return wasSet;
  }

  public int getNumber()
  {
    return number;
  }

  public ProgramW getProgram()
  {
    return program;
  }

  public MentorW getMentor(int index)
  {
    MentorW aMentor = mentors.get(index);
    return aMentor;
  }

  public List<MentorW> getMentors()
  {
    List<MentorW> newMentors = Collections.unmodifiableList(mentors);
    return newMentors;
  }

  public int numberOfMentors()
  {
    int number = mentors.size();
    return number;
  }

  public boolean hasMentors()
  {
    boolean has = mentors.size() > 0;
    return has;
  }

  public int indexOfMentor(MentorW aMentor)
  {
    int index = mentors.indexOf(aMentor);
    return index;
  }

  public boolean setProgram(ProgramW newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramW existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getStudent() != null)
      {
        existingProgram.setStudent(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramW currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setStudent(null);
    }

    program = newProgram;
    StudentW existingStudent = newProgram.getStudent();

    if (!equals(existingStudent))
    {
      newProgram.setStudent(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean isNumberOfMentorsValid()
  {
    boolean isValid = numberOfMentors() >= minimumNumberOfMentors() && numberOfMentors() <= maximumNumberOfMentors();
    return isValid;
  }

  public static int requiredNumberOfMentors()
  {
    return 2;
  }

  public static int minimumNumberOfMentors()
  {
    return 2;
  }

  public static int maximumNumberOfMentors()
  {
    return 2;
  }

  public boolean addMentor(MentorW aMentor)
  {
    boolean wasAdded = false;
    if (mentors.contains(aMentor)) { return false; }
    if (numberOfMentors() >= maximumNumberOfMentors())
    {
      return wasAdded;
    }

    mentors.add(aMentor);
    if (aMentor.indexOfStudent(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aMentor.addStudent(this);
      if (!wasAdded)
      {
        mentors.remove(aMentor);
      }
    }
    return wasAdded;
  }

  public boolean removeMentor(MentorW aMentor)
  {
    boolean wasRemoved = false;
    if (!mentors.contains(aMentor))
    {
      return wasRemoved;
    }

    if (numberOfMentors() <= minimumNumberOfMentors())
    {
      return wasRemoved;
    }

    int oldIndex = mentors.indexOf(aMentor);
    mentors.remove(oldIndex);
    if (aMentor.indexOfStudent(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aMentor.removeStudent(this);
      if (!wasRemoved)
      {
        mentors.add(oldIndex,aMentor);
      }
    }
    return wasRemoved;
  }

  public boolean setMentors(MentorW... newMentors)
  {
    boolean wasSet = false;
    ArrayList<MentorW> verifiedMentors = new ArrayList<MentorW>();
    for (MentorW aMentor : newMentors)
    {
      if (verifiedMentors.contains(aMentor))
      {
        continue;
      }
      verifiedMentors.add(aMentor);
    }

    if (verifiedMentors.size() != newMentors.length || verifiedMentors.size() < minimumNumberOfMentors() || verifiedMentors.size() > maximumNumberOfMentors())
    {
      return wasSet;
    }

    ArrayList<MentorW> oldMentors = new ArrayList<MentorW>(mentors);
    mentors.clear();
    for (MentorW newMentor : verifiedMentors)
    {
      mentors.add(newMentor);
      if (oldMentors.contains(newMentor))
      {
        oldMentors.remove(newMentor);
      }
      else
      {
        newMentor.addStudent(this);
      }
    }

    for (MentorW oldMentor : oldMentors)
    {
      oldMentor.removeStudent(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (program != null)
    {
      program.setStudent(null);
    }
    ArrayList<MentorW> copyOfMentors = new ArrayList<MentorW>(mentors);
    mentors.clear();
    for(MentorW aMentor : copyOfMentors)
    {
      if (aMentor.numberOfStudents() <= MentorW.minimumNumberOfStudents())
      {
        aMentor.delete();
      }
      else
      {
        aMentor.removeStudent(this);
      }
    }
  }

}