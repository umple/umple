/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.associations;

// line 79 "../../../src/LocalHarness.ump"
public class StudentAP
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentAP Attributes
  private int number;

  //StudentAP Associations
  private MentorAP mentor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentAP(int aNumber, MentorAP aMentor)
  {
    number = aNumber;
    if (aMentor == null || aMentor.getStudent() != null)
    {
      throw new RuntimeException("Unable to create StudentAP due to aMentor");
    }
    mentor = aMentor;
  }

  public StudentAP(int aNumber, String aNameForMentor, GradStudentAP aGradStudentForMentor)
  {
    number = aNumber;
    mentor = new MentorAP(aNameForMentor, aGradStudentForMentor, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumber(int aNumber)
  {
    boolean wasSet = false;
    number = aNumber;
    wasSet = true;
    return wasSet;
  }

  public int getNumber()
  {
    return number;
  }

  public MentorAP getMentor()
  {
    return mentor;
  }

  public void delete()
  {
    MentorAP existingMentor = mentor;
    mentor = null;
    if (existingMentor != null)
    {
      existingMentor.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "number" + ":" + getNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "mentor = "+(getMentor()!=null?Integer.toHexString(System.identityHashCode(getMentor())):"null")
     + outputString;
  }
}