/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.11.1.3376 modeling language!*/

package cruise.statemachine.test;

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