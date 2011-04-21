/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.0.352 modeling language!*/

package cruise.test;

public class ProgramAB
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramAB Associations
  private MentorAB mentor;
  private StudentAB student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramAB()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorAB getMentor()
  {
    return mentor;
  }

  public StudentAB getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorAB newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorAB existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorAB currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramAB existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentAB newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentAB existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentAB currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramAB existingProgram = newStudent.getProgram();

    if (!equals(existingProgram))
    {
      newStudent.setProgram(this);
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