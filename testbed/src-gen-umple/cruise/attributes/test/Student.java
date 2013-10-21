/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.attributes.test;

// line 2 "../../../../src/TestHarnessConstraints.ump"
public class Student
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Student Attributes
  private int age;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Student(int aAge)
  {
    age = aAge;
    if ( !((aAge>18)))
    {
      throw new RuntimeException("Please provide a valid age");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAge(int aAge)
  {
    boolean wasSet = false;
    if (aAge>18)
    {
    age = aAge;
    wasSet = true;
    }
    return wasSet;
  }

  public int getAge()
  {
    return age;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "age" + ":" + getAge()+ "]"
     + outputString;
  }
}