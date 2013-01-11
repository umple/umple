/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.associations;
import java.util.*;

// line 416 "../../../src/TestHarnessAssociations.ump"
public class StudentAA
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentAA Attributes
  private int number;

  //StudentAA Associations
  private ProgramAA program;
  private List<MentorAA> mentors;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentAA(int aNumber)
  {
    number = aNumber;
    mentors = new ArrayList<MentorAA>();
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

  public ProgramAA getProgram()
  {
    return program;
  }

  public MentorAA getMentor(int index)
  {
    MentorAA aMentor = mentors.get(index);
    return aMentor;
  }

  public List<MentorAA> getMentors()
  {
    List<MentorAA> newMentors = Collections.unmodifiableList(mentors);
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

  public int indexOfMentor(MentorAA aMentor)
  {
    int index = mentors.indexOf(aMentor);
    return index;
  }

  public boolean setProgram(ProgramAA newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramAA existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getStudent() != null)
      {
        existingProgram.setStudent(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramAA currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setStudent(null);
    }

    program = newProgram;
    StudentAA existingStudent = newProgram.getStudent();

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

  public boolean addMentor(MentorAA aMentor)
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

  public boolean removeMentor(MentorAA aMentor)
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

  public boolean addMentorAt(MentorAA aMentor, int index)
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

  public boolean addOrMoveMentorAt(MentorAA aMentor, int index)
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
    ArrayList<MentorAA> copyOfMentors = new ArrayList<MentorAA>(mentors);
    mentors.clear();
    for(MentorAA aMentor : copyOfMentors)
    {
      aMentor.removeStudent(this);
    }
  }

}