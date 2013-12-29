/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.19.0.3287 modeling language!*/

package cruise.associations;

// line 89 "../../../src/TestHarnessAssociations.ump"
public class StudentF
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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

  public boolean setProgram(ProgramF aNewProgram)
  {
    boolean wasSet = false;
    if (aNewProgram == null)
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
    if (currentProgram != null && !currentProgram.equals(aNewProgram))
    {
      currentProgram.setStudent(null);
    }

    program = aNewProgram;
    StudentF existingStudent = aNewProgram.getStudent();

    if (!equals(existingStudent))
    {
      aNewProgram.setStudent(this);
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


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "x" + ":" + getX()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "program = "+(getProgram()!=null?Integer.toHexString(System.identityHashCode(getProgram())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "mentor = "+(getMentor()!=null?Integer.toHexString(System.identityHashCode(getMentor())):"null")
     + outputString;
  }
}