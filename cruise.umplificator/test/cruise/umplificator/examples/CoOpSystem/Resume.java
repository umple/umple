/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 56 "CoOpSystem.ump"
// line 121 "CoOpSystem.ump"
public class Resume
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Resume Attributes
  private String text;

  //Resume Associations
  private Student student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Resume(String aText, Student aStudent)
  {
    text = aText;
    boolean didAddStudent = setStudent(aStudent);
    if (!didAddStudent)
    {
      throw new RuntimeException("Unable to create resume due to student");
    }
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

  public boolean setStudent(Student aNewStudent)
  {
    boolean wasSet = false;
    if (aNewStudent == null)
    {
      //Unable to setStudent to null, as resume must always be associated to a student
      return wasSet;
    }
    
    Resume existingResume = aNewStudent.getResume();
    if (existingResume != null && !equals(existingResume))
    {
      //Unable to setStudent, the current student already has a resume, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    Student anOldStudent = student;
    student = aNewStudent;
    student.setResume(this);

    if (anOldStudent != null)
    {
      anOldStudent.setResume(null);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Student existingStudent = student;
    student = null;
    if (existingStudent != null)
    {
      existingStudent.setResume(null);
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