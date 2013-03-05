/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.associations;
import java.util.*;

// line 288 "../../../src/TestHarnessAssociations.ump"
public class StudentS
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentS Attributes
  private int number;

  //StudentS Associations
  private ProgramS program;
  private List<MentorS> mentors;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentS(int aNumber)
  {
    number = aNumber;
    mentors = new ArrayList<MentorS>();
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

  public ProgramS getProgram()
  {
    return program;
  }

  public MentorS getMentor(int index)
  {
    MentorS aMentor = mentors.get(index);
    return aMentor;
  }

  public List<MentorS> getMentors()
  {
    List<MentorS> newMentors = Collections.unmodifiableList(mentors);
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

  public int indexOfMentor(MentorS aMentor)
  {
    int index = mentors.indexOf(aMentor);
    return index;
  }

  public boolean setProgram(ProgramS newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramS existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getStudent() != null)
      {
        existingProgram.setStudent(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramS currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setStudent(null);
    }

    program = newProgram;
    StudentS existingStudent = newProgram.getStudent();

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

  public static int minimumNumberOfMentors()
  {
    return 2;
  }

  public static int maximumNumberOfMentors()
  {
    return 4;
  }

  public boolean addMentor(MentorS aMentor)
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

  public boolean removeMentor(MentorS aMentor)
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

  public boolean setMentors(MentorS... newMentors)
  {
    boolean wasSet = false;
    ArrayList<MentorS> verifiedMentors = new ArrayList<MentorS>();
    for (MentorS aMentor : newMentors)
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

    ArrayList<MentorS> oldMentors = new ArrayList<MentorS>(mentors);
    mentors.clear();
    for (MentorS newMentor : verifiedMentors)
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

    for (MentorS oldMentor : oldMentors)
    {
      oldMentor.removeStudent(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean addMentorAt(MentorS aMentor, int index)
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

  public boolean addOrMoveMentorAt(MentorS aMentor, int index)
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
    ArrayList<MentorS> copyOfMentors = new ArrayList<MentorS>(mentors);
    mentors.clear();
    for(MentorS aMentor : copyOfMentors)
    {
      if (aMentor.numberOfStudents() <= MentorS.minimumNumberOfStudents())
      {
        aMentor.delete();
      }
      else
      {
        aMentor.removeStudent(this);
      }
    }
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "number" + ":" + getNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "program" + "=" + getProgram() != null ? !getProgram() .equals(this)  ? getProgram().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }
}