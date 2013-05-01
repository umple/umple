/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.associations;

// line 93 "../../../src/TestHarnessAssociations.ump"
public class ProgramF
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramF Associations
  private MentorF mentor;
  private StudentF student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramF()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorF getMentor()
  {
    return mentor;
  }

  public StudentF getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorF aNewMentor)
  {
    boolean wasSet = false;
    if (aNewMentor == null)
    {
      MentorF existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorF currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(aNewMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = aNewMentor;
    ProgramF existingProgram = aNewMentor.getProgram();

    if (!equals(existingProgram))
    {
      aNewMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentF aNewStudent)
  {
    boolean wasSet = false;
    if (aNewStudent == null)
    {
      StudentF existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentF currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(aNewStudent))
    {
      currentStudent.setProgram(null);
    }

    student = aNewStudent;
    ProgramF existingProgram = aNewStudent.getProgram();

    if (!equals(existingProgram))
    {
      aNewStudent.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (mentor != null)
    {
      mentor.setProgram(null);
    }
    if (student != null)
    {
      student.setProgram(null);
    }
  }

}