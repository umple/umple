/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.associations;

// line 514 "../../../src/TestHarnessAssociations.ump"
public class ProgramAH
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramAH Associations
  private MentorAH mentor;
  private StudentAH student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramAH()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorAH getMentor()
  {
    return mentor;
  }

  public StudentAH getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorAH aNewMentor)
  {
    boolean wasSet = false;
    if (aNewMentor == null)
    {
      MentorAH existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorAH currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(aNewMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = aNewMentor;
    ProgramAH existingProgram = aNewMentor.getProgram();

    if (!equals(existingProgram))
    {
      aNewMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentAH aNewStudent)
  {
    boolean wasSet = false;
    if (aNewStudent == null)
    {
      StudentAH existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentAH currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(aNewStudent))
    {
      currentStudent.setProgram(null);
    }

    student = aNewStudent;
    ProgramAH existingProgram = aNewStudent.getProgram();

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