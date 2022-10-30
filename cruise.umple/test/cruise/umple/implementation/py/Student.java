/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/



// line 2 "ImmutableNotLazyAttributeConstructor.ump"
public class Student
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Student Attributes
  private String number;
  private String number2;

  //Helper Variables
  private boolean canSetNumber2;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Student(String aNumber)
  {
    number = aNumber;
    canSetNumber2 = true;
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template attribute_SetImmutable */
  public boolean setNumber2(String aNumber2)
  {
    boolean wasSet = false;
    canSetNumber2 = false;
    number2 = aNumber2;
    wasSet = true;
    return wasSet;
  }

  public String getNumber()
  {
    return number;
  }

  public String getNumber2()
  {
    return number2;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "number" + ":" + getNumber()+ "," +
            "number2" + ":" + getNumber2()+ "]";
  }
}