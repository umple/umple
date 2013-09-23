/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.associations;

// line 74 "../../../src/LocalHarness.ump"
public class MentorAP
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorAP Attributes
  private String name;

  //MentorAP Associations
  private GradStudentAP gradStudent;
  private StudentAP student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorAP(String aName, GradStudentAP aGradStudent, StudentAP aStudent)
  {
    name = aName;
    if (aGradStudent == null || aGradStudent.getMentorAP() != null)
    {
      throw new RuntimeException("Unable to create MentorAP due to aGradStudent");
    }
    gradStudent = aGradStudent;
    if (aStudent == null || aStudent.getMentor() != null)
    {
      throw new RuntimeException("Unable to create MentorAP due to aStudent");
    }
    student = aStudent;
  }

  public MentorAP(String aName, int aNumberForStudent)
  {
    name = aName;
    gradStudent = new GradStudentAP(this);
    student = new StudentAP(aNumberForStudent, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public GradStudentAP getGradStudent()
  {
    return gradStudent;
  }

  public StudentAP getStudent()
  {
    return student;
  }

  public void delete()
  {
    GradStudentAP existingGradStudent = gradStudent;
    gradStudent = null;
    if (existingGradStudent != null)
    {
      existingGradStudent.delete();
    }
    StudentAP existingStudent = student;
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
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "gradStudent = "+(getGradStudent()!=null?Integer.toHexString(System.identityHashCode(getGradStudent())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "student = "+(getStudent()!=null?Integer.toHexString(System.identityHashCode(getStudent())):"null")
     + outputString;
  }
}