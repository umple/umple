/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.statemachine.test;

public class CourseM
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseM State Machines
  enum One { On, Off }
  private One one;
  enum Two { Slow, Fast }
  private Two two;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CourseM()
  {
    setOne(One.On);
    setTwo(Two.Slow);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getOneFullName()
  {
    String answer = one.toString();
    return answer;
  }

  public String getTwoFullName()
  {
    String answer = two.toString();
    return answer;
  }

  public One getOne()
  {
    return one;
  }

  public Two getTwo()
  {
    return two;
  }

  public boolean flip()
  {
    boolean wasEventProcessed = false;
    
    One aOne = one;
    Two aTwo = two;
    switch (aOne)
    {
      case On:
        setOne(One.Off);
        wasEventProcessed = true;
        break;
    }

    switch (aTwo)
    {
      case Slow:
        setTwo(Two.Fast);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private void setOne(One aOne)
  {
    one = aOne;
  }

  private void setTwo(Two aTwo)
  {
    two = aTwo;
  }

  public void delete()
  {}

}