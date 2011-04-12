/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.11.1.3376 modeling language!*/

package cruise.test;
import java.util.*;

public class StudentQ
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentQ Attributes
  private int number;

  //StudentQ Associations
  private ProgramQ program;
  private List<MentorQ> mentors;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentQ(int aNumber)
  {
    number = aNumber;
    mentors = new ArrayList<MentorQ>();
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

  public ProgramQ getProgram()
  {
    return program;
  }

  public MentorQ getMentor(int index)
  {
    MentorQ aMentor = mentors.get(index);
    return aMentor;
  }

  public List<MentorQ> getMentors()
  {
    List<MentorQ> newMentors = Collections.unmodifiableList(mentors);
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

  public int indexOfMentor(MentorQ aMentor)
  {
    int index = mentors.indexOf(aMentor);
    return index;
  }

  public boolean setProgram(ProgramQ newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramQ existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getStudent() != null)
      {
        existingProgram.setStudent(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramQ currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setStudent(null);
    }

    program = newProgram;
    StudentQ existingStudent = newProgram.getStudent();

    if (!equals(existingStudent))
    {
      newProgram.setStudent(this);
    }
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfMentors()
  {
    return 0;
  }

  public boolean addMentor(MentorQ aMentor)
  {
    boolean wasAdded = false;
    if (mentors.contains(aMentor)) { return false; }
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

  public boolean removeMentor(MentorQ aMentor)
  {
    boolean wasRemoved = false;
    if (!mentors.contains(aMentor))
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

  public void delete()
  {
    if (program != null)
    {
      program.setStudent(null);
    }
    ArrayList<MentorQ> copyOfMentors = new ArrayList<MentorQ>(mentors);
    mentors.clear();
    for(MentorQ aMentor : copyOfMentors)
    {
      if (aMentor.numberOfStudents() <= MentorQ.minimumNumberOfStudents())
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