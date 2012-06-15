/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;
import java.util.*;

public class StudentX
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentX Attributes
  private int number;

  //StudentX Associations
  private ProgramX program;
  private List<MentorX> mentors;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentX(int aNumber)
  {
    number = aNumber;
    mentors = new ArrayList<MentorX>();
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

  public ProgramX getProgram()
  {
    return program;
  }

  public MentorX getMentor(int index)
  {
    MentorX aMentor = mentors.get(index);
    return aMentor;
  }

  public List<MentorX> getMentors()
  {
    List<MentorX> newMentors = Collections.unmodifiableList(mentors);
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

  public int indexOfMentor(MentorX aMentor)
  {
    int index = mentors.indexOf(aMentor);
    return index;
  }

  public boolean setProgram(ProgramX newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramX existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getStudent() != null)
      {
        existingProgram.setStudent(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramX currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setStudent(null);
    }

    program = newProgram;
    StudentX existingStudent = newProgram.getStudent();

    if (!equals(existingStudent))
    {
      newProgram.setStudent(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean isNumberOfMentorsValid()
  {
    boolean isValid = numberOfMentors() >= minimumNumberOfMentors();
    return isValid;
  }

  public static int minimumNumberOfMentors()
  {
    return 2;
  }

  public boolean addMentor(MentorX aMentor)
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

  public boolean removeMentor(MentorX aMentor)
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

  public boolean setMentors(MentorX... newMentors)
  {
    boolean wasSet = false;
    ArrayList<MentorX> verifiedMentors = new ArrayList<MentorX>();
    for (MentorX aMentor : newMentors)
    {
      if (verifiedMentors.contains(aMentor))
      {
        continue;
      }
      verifiedMentors.add(aMentor);
    }

    if (verifiedMentors.size() != newMentors.length || verifiedMentors.size() < minimumNumberOfMentors())
    {
      return wasSet;
    }

    ArrayList<MentorX> oldMentors = new ArrayList<MentorX>(mentors);
    mentors.clear();
    for (MentorX newMentor : verifiedMentors)
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

    for (MentorX oldMentor : oldMentors)
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
    ArrayList<MentorX> copyOfMentors = new ArrayList<MentorX>(mentors);
    mentors.clear();
    for(MentorX aMentor : copyOfMentors)
    {
      if (aMentor.numberOfStudents() <= MentorX.minimumNumberOfStudents())
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