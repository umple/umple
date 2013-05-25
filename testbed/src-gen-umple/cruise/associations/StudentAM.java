/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.associations;

// line 588 "../../../src/TestHarnessAssociations.ump"
public class StudentAM
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentAM Attributes
  private int id;

  //StudentAM Associations
  private MentorAM mentor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentAM(int aId)
  {
    id = aId;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(int aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public int getId()
  {
    return id;
  }

  public MentorAM getMentor()
  {
    return mentor;
  }

  public boolean setMentor(MentorAM aMentor)
  {
    boolean wasSet = false;
    MentorAM existingMentor = mentor;
    mentor = aMentor;
    if (existingMentor != null && !existingMentor.equals(aMentor))
    {
      existingMentor.removeStudent(this);
    }
    if (aMentor != null)
    {
      aMentor.addStudent(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (mentor != null)
    {
      MentorAM placeholderMentor = mentor;
      this.mentor = null;
      placeholderMentor.removeStudent(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "id" + ":" + getId()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "mentor" + "=" + (getMentor() != null ? !getMentor().equals(this)  ? getMentor().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}