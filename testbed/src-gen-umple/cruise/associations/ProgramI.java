/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.${svn.Revision} modeling language!*/

package cruise.associations;

// line 133 "../../../src/TestHarnessAssociations.ump"
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

  public boolean setMentorI(MentorI aNewMentorI)
  {
    boolean wasSet = false;
    if (aNewMentorI == null)
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
    if (currentMentorI != null && !currentMentorI.equals(aNewMentorI))
    {
      currentMentorI.setProgram(null);
    }

    mentorI = aNewMentorI;
    ProgramI existingProgram = aNewMentorI.getProgram();

    if (!equals(existingProgram))
    {
      aNewMentorI.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudentI(StudentI aNewStudentI)
  {
    boolean wasSet = false;
    if (aNewStudentI == null)
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
    if (currentStudentI != null && !currentStudentI.equals(aNewStudentI))
    {
      currentStudentI.setProgram(null);
    }

    studentI = aNewStudentI;
    ProgramI existingProgram = aNewStudentI.getProgram();

    if (!equals(existingProgram))
    {
      aNewStudentI.setProgram(this);
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