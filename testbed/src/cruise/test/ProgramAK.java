/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.0.352 modeling language!*/

package cruise.test;

public class ProgramAK
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramAK Associations
  private MentorAK mentor;
  private StudentAK student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramAK()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorAK getMentor()
  {
    return mentor;
  }

  public StudentAK getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorAK newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorAK existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorAK currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramAK existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentAK newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentAK existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentAK currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramAK existingProgram = newStudent.getProgram();

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