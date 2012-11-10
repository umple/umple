/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;
import java.util.*;

public class StudentAD
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentAD Attributes
  private int number;

  //StudentAD Associations
  private ProgramAD program;
  private List<MentorAD> mentors;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentAD(int aNumber)
  {
    number = aNumber;
    mentors = new ArrayList<MentorAD>();
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

  public ProgramAD getProgram()
  {
    return program;
  }

  public MentorAD getMentor(int index)
  {
    MentorAD aMentor = mentors.get(index);
    return aMentor;
  }

  public List<MentorAD> getMentors()
  {
    List<MentorAD> newMentors = Collections.unmodifiableList(mentors);
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

  public int indexOfMentor(MentorAD aMentor)
  {
    int index = mentors.indexOf(aMentor);
    return index;
  }

  public boolean setProgram(ProgramAD newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramAD existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getStudent() != null)
      {
        existingProgram.setStudent(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramAD currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setStudent(null);
    }

    program = newProgram;
    StudentAD existingStudent = newProgram.getStudent();

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
    return 3;
  }

  public boolean addMentor(MentorAD aMentor)
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

  public boolean removeMentor(MentorAD aMentor)
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

  public boolean setMentors(MentorAD... newMentors)
  {
    boolean wasSet = false;
    ArrayList<MentorAD> verifiedMentors = new ArrayList<MentorAD>();
    for (MentorAD aMentor : newMentors)
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

    ArrayList<MentorAD> oldMentors = new ArrayList<MentorAD>(mentors);
    mentors.clear();
    for (MentorAD newMentor : verifiedMentors)
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

    for (MentorAD oldMentor : oldMentors)
    {
      oldMentor.removeStudent(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean addMentorAt(MentorAD aMentor, int index)
  {  
    boolean wasAdded = false;
    if(addMentor(aMentor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMentors()) { index = numberOfMentors() - 1; }
      mentors.remove(aMentor);
      mentors.add(index, aMentor);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMentorAt(MentorAD aMentor, int index)
  {
    boolean wasAdded = false;
    if(mentors.contains(aMentor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMentors()) { index = numberOfMentors() - 1; }
      mentors.remove(aMentor);
      mentors.add(index, aMentor);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMentorAt(aMentor, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    if (program != null)
    {
      program.setStudent(null);
    }
    ArrayList<MentorAD> copyOfMentors = new ArrayList<MentorAD>(mentors);
    mentors.clear();
    for(MentorAD aMentor : copyOfMentors)
    {
      aMentor.removeStudent(this);
    }
  }

}