/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.statemachine.test;

// line 219 "../../../../src/TestHarnessStateMachine.ump"
public class CourseO
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int line();String file();int javaline();int length();}

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