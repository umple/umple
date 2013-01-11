/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.statemachine.test;

// line 208 "../../../../src/TestHarnessStateMachine.ump"
public class CourseN
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseN State Machines
  enum One { On, Off }
  private One one;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CourseN()
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

  public boolean stay()
  {
    boolean wasEventProcessed = false;
    
    One aOne = one;
    switch (aOne)
    {
      case On:
        setOne(One.On);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean flip()
  {
    boolean wasEventProcessed = false;
    
    One aOne = one;
    switch (aOne)
    {
      case On:
        setOne(One.Off);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private void setOne(One aOne)
  {
    one = aOne;
  }

  public void delete()
  {}

}