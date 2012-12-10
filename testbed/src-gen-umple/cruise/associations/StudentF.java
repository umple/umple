/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;

// line 87 "../../../src/TestHarnessAssociations.ump"
public class StudentF
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextX = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Autounique Attributes
  private int x;

  //StudentF Associations
  private ProgramF program;
  private MentorF mentor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentF()
  {
    x = nextX++;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public int getX()
  {
    return x;
  }

  public ProgramF getProgram()
  {
    return program;
  }

  public MentorF getMentor()
  {
    return mentor;
  }

  public boolean setProgram(ProgramF newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramF existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getStudent() != null)
      {
        existingProgram.setStudent(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramF currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setStudent(null);
    }

    program = newProgram;
    StudentF existingStudent = newProgram.getStudent();

    if (!equals(existingStudent))
    {
      newProgram.setStudent(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setMentor(MentorF aMentor)
  {
    //
    // This source of this source generation is association_SetOptionalOneToMandatoryMany.jet
    // This set file assumes the generation of a maximumNumberOfXXX method does not exist because 
    // it's not required (No upper bound)
    //   
    boolean wasSet = false;
    MentorF existingMentor = mentor;
	
    if (existingMentor == null)
    {
      if (aMentor != null)
      {
        if (aMentor.addStudent(this))
        {
          existingMentor = aMentor;
          wasSet = true;
        }
      }
    } 
    else if (existingMentor != null)
    {
      if (aMentor == null)
      {
        if (existingMentor.minimumNumberOfStudents() < existingMentor.numberOfStudents())
        {
          existingMentor.removeStudent(this);
          existingMentor = aMentor;  // aMentor == null
          wasSet = true;
        }
      } 
      else
      {
        if (existingMentor.minimumNumberOfStudents() < existingMentor.numberOfStudents())
        {
          existingMentor.removeStudent(this);
          aMentor.addStudent(this);
          existingMentor = aMentor;
          wasSet = true;
        }
      }
    }
    if (wasSet)
    {
      mentor = existingMentor;
    }
    return wasSet;
  }
  
  public void delete()
  {
    if (program != null)
    {
      program.setStudent(null);
    }
    if (mentor != null)
    {
      if (mentor.numberOfStudents() <= 2)
      {
        mentor.delete();
      }
      else
      {
        MentorF placeholderMentor = mentor;
        this.mentor = null;
        placeholderMentor.removeStudent(this);
      }
    }
  }

}