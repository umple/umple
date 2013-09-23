/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.statemachine.test;

// line 4 "../../../../src/TestHarnessStateMachine.ump"
public class CourseA
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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