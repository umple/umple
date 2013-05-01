/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.${svn.Revision} modeling language!*/

package cruise.statemachine.test;

// line 4 "../../../../src/TestHarnessStateMachine.ump"
public class CourseA
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseA State Machines
  enum Status {  }
  private Status status;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CourseA()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public String getStatusFullName()
  {
    String answer = status.toString();
    return answer;
  }

  public Status getStatus()
  {
    return status;
  }

  public void delete()
  {}

}