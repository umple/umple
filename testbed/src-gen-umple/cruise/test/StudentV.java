/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.test;
import java.util.*;

public class StudentV
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentV Attributes
  private int number;

  //StudentV Associations
  private ProgramV program;
  private List<MentorV> mentors;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentV(int aNumber)
  {
    number = aNumber;
    mentors = new ArrayList<MentorV>();
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

  public ProgramV getProgram()
  {
    return program;
  }

  public MentorV getMentor(int index)
  {
    MentorV aMentor = mentors.get(index);
    return aMentor;
  }

  public List<MentorV> getMentors()
  {
    List<MentorV> newMentors = Collections.unmodifiableList(mentors);
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

  public int indexOfMentor(MentorV aMentor)
  {
    int index = mentors.indexOf(aMentor);
    return index;
  }

  public boolean setProgram(ProgramV newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramV existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getStudent() != null)
      {
        existingProgram.setStudent(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramV currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setStudent(null);
    }

    program = newProgram;
    StudentV existingStudent = newProgram.getStudent();

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
    return 4;
  }

  public static int minimumNumberOfMentors()
  {
    return 4;
  }

  public static int maximumNumberOfMentors()
  {
    return 4;
  }

  public boolean addMentor(MentorV aMentor)
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

  public boolean removeMentor(MentorV aMentor)
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

  public boolean setMentors(MentorV... newMentors)
  {
    boolean wasSet = false;
    ArrayList<MentorV> verifiedMentors = new ArrayList<MentorV>();
    for (MentorV aMentor : newMentors)
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

    ArrayList<MentorV> oldMentors = new ArrayList<MentorV>(mentors);
    mentors.clear();
    for (MentorV newMentor : verifiedMentors)
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

    for (MentorV oldMentor : oldMentors)
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
    ArrayList<MentorV> copyOfMentors = new ArrayList<MentorV>(mentors);
    mentors.clear();
    for(MentorV aMentor : copyOfMentors)
    {
      if (aMentor.numberOfStudents() <= MentorV.minimumNumberOfStudents())
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