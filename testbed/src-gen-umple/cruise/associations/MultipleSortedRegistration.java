/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.associations;

// line 666 "../../../src/TestHarnessAssociations.ump"
public class MultipleSortedRegistration
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MultipleSortedRegistration Associations
  private MultipleSortedCourse multipleSortedCourse;
  private MultipleSortedStudent multipleSortedStudent;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MultipleSortedRegistration(MultipleSortedCourse aMultipleSortedCourse, MultipleSortedStudent aMultipleSortedStudent)
  {
    // Direct set of variable needed to ensure consistency
    // for multiple sorted associations
    multipleSortedCourse=aMultipleSortedCourse;
    multipleSortedStudent=aMultipleSortedStudent;
    boolean didAddMultipleSortedCourse = setMultipleSortedCourse(aMultipleSortedCourse);
    if (!didAddMultipleSortedCourse)
    {
      throw new RuntimeException("Unable to create multipleSortedRegistration due to multipleSortedCourse");
    }
    boolean didAddMultipleSortedStudent = setMultipleSortedStudent(aMultipleSortedStudent);
    if (!didAddMultipleSortedStudent)
    {
      throw new RuntimeException("Unable to create multipleSortedRegistration due to multipleSortedStudent");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  @umplesourcefile(line={671},file={"TestHarnessAssociations.ump"},javaline={50},length={2})
  public String getName()
  {
    return getMultipleSortedStudent().getName();
  }

  @umplesourcefile(line={673},file={"TestHarnessAssociations.ump"},javaline={55},length={2})
  public String getCode()
  {
    return getMultipleSortedCourse().getCode();
  }

  public MultipleSortedCourse getMultipleSortedCourse()
  {
    return multipleSortedCourse;
  }

  public MultipleSortedStudent getMultipleSortedStudent()
  {
    return multipleSortedStudent;
  }

  public boolean setMultipleSortedCourse(MultipleSortedCourse aMultipleSortedCourse)
  {
    boolean wasSet = false;
    if (aMultipleSortedCourse == null)
    {
      return wasSet;
    }

    MultipleSortedCourse existingMultipleSortedCourse = multipleSortedCourse;
    multipleSortedCourse = aMultipleSortedCourse;
    if (existingMultipleSortedCourse != null && !existingMultipleSortedCourse.equals(aMultipleSortedCourse))
    {
      existingMultipleSortedCourse.removeMultipleSortedRegistration(this);
    }
    multipleSortedCourse.addMultipleSortedRegistration(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setMultipleSortedStudent(MultipleSortedStudent aMultipleSortedStudent)
  {
    boolean wasSet = false;
    if (aMultipleSortedStudent == null)
    {
      return wasSet;
    }

    MultipleSortedStudent existingMultipleSortedStudent = multipleSortedStudent;
    multipleSortedStudent = aMultipleSortedStudent;
    if (existingMultipleSortedStudent != null && !existingMultipleSortedStudent.equals(aMultipleSortedStudent))
    {
      existingMultipleSortedStudent.removeMultipleSortedRegistration(this);
    }
    multipleSortedStudent.addMultipleSortedRegistration(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    MultipleSortedCourse placeholderMultipleSortedCourse = multipleSortedCourse;
    this.multipleSortedCourse = null;
    placeholderMultipleSortedCourse.removeMultipleSortedRegistration(this);
    MultipleSortedStudent placeholderMultipleSortedStudent = multipleSortedStudent;
    this.multipleSortedStudent = null;
    placeholderMultipleSortedStudent.removeMultipleSortedRegistration(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "code" + ":" + getCode()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "multipleSortedCourse = "+(getMultipleSortedCourse()!=null?Integer.toHexString(System.identityHashCode(getMultipleSortedCourse())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "multipleSortedStudent = "+(getMultipleSortedStudent()!=null?Integer.toHexString(System.identityHashCode(getMultipleSortedStudent())):"null")
     + outputString;
  }
}