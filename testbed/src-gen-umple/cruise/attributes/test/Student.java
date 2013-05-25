/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.attributes.test;

// line 3 "../../../../src/TestHarnessConstraints.ump"
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
    if ( !(aAge>18))
    {
      throw new RuntimeException("Please provide a valid age");
    }
    age = aAge;
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