/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 62 "CoOpSystem.ump"
// line 127 "CoOpSystem.ump"
public class Transcript
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Transcript Attributes
  private String text;

  //Transcript Associations
  private Student student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Transcript(String aText, Student aStudent)
  {
    text = aText;
    if (aStudent == null || aStudent.getTranscript() != null)
    {
      throw new RuntimeException("Unable to create Transcript due to aStudent");
    }
    student = aStudent;
  }

  public Transcript(String aText, int aStNumForStudent, Program... allProgramsForStudent)
  {
    text = aText;
    student = new Student(aStNumForStudent, this, allProgramsForStudent);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setText(String aText)
  {
    boolean wasSet = false;
    text = aText;
    wasSet = true;
    return wasSet;
  }

  public String getText()
  {
    return text;
  }

  public Student getStudent()
  {
    return student;
  }

  public void delete()
  {
    Student existingStudent = student;
    student = null;
    if (existingStudent != null)
    {
      existingStudent.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "text" + ":" + getText()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "student = "+(getStudent()!=null?Integer.toHexString(System.identityHashCode(getStudent())):"null")
     + outputString;
  }
}