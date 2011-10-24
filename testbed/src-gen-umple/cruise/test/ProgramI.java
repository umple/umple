/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.14.0.957 modeling language!*/

package cruise.test;

public class ProgramI
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramI Associations
  private MentorI mentorI;
  private StudentI studentI;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramI()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorI getMentorI()
  {
    return mentorI;
  }

  public StudentI getStudentI()
  {
    return studentI;
  }

  public boolean setMentorI(MentorI newMentorI)
  {
    boolean wasSet = false;
    if (newMentorI == null)
    {
      MentorI existingMentorI = mentorI;
      mentorI = null;
      
      if (existingMentorI != null && existingMentorI.getProgram() != null)
      {
        existingMentorI.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorI currentMentorI = getMentorI();
    if (currentMentorI != null && !currentMentorI.equals(newMentorI))
    {
      currentMentorI.setProgram(null);
    }

    mentorI = newMentorI;
    ProgramI existingProgram = newMentorI.getProgram();

    if (!equals(existingProgram))
    {
      newMentorI.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudentI(StudentI newStudentI)
  {
    boolean wasSet = false;
    if (newStudentI == null)
    {
      StudentI existingStudentI = studentI;
      studentI = null;
      
      if (existingStudentI != null && existingStudentI.getProgram() != null)
      {
        existingStudentI.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentI currentStudentI = getStudentI();
    if (currentStudentI != null && !currentStudentI.equals(newStudentI))
    {
      currentStudentI.setProgram(null);
    }

    studentI = newStudentI;
    ProgramI existingProgram = newStudentI.getProgram();

    if (!equals(existingProgram))
    {
      newStudentI.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (mentorI != null)
    {
      mentorI.setProgram(null);
    }
    if (studentI != null)
    {
      studentI.setProgram(null);
    }
  }

}