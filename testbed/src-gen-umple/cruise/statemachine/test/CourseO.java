/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.statemachine.test;

// line 219 "../../../../src/TestHarnessStateMachine.ump"
public class CourseO
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseO State Machines
  enum One { On, Off }
  private One one;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CourseO()
  {
    setOne(One.On);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getOneFullName()
  {
    String answer = one.toString();
    return answer;
  }

  public One getOne()
  {
    return one;
  }

  public boolean setOne(One aOne)
  {
    one = aOne;
    return true;
  }

  public void delete()
  {}

}