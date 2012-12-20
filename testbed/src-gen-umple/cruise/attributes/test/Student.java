/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.attributes.test;

// line 3 "../../../../src/TestHarnessConstraints.ump"
public class Student
{

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
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAge(int aAge)
  {
    boolean wasSet = false;
    if ((aAge>18))
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

}