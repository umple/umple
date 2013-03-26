/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/



// line 1 "BasicConstraint7.ump"
public class student
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //student Attributes
  private int age;
  private int weight;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public student(int aAge, int aWeight)
  {
    if ( !(!(18>aAge)))
    {
      throw new RuntimeException("Please provide a valid age");
    }
    age = aAge;
    weight = aWeight;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAge(int aAge)
  {
    boolean wasSet = false;
    if (!(18>aAge))
    {
    age = aAge;
    wasSet = true;
    }
    return wasSet;
  }

  public boolean setWeight(int aWeight)
  {
    boolean wasSet = false;
    weight = aWeight;
    wasSet = true;
    return wasSet;
  }

  public int getAge()
  {
    return age;
  }

  public int getWeight()
  {
    return weight;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "age" + ":" + getAge()+ "," +
            "weight" + ":" + getWeight()+ "]"
     + outputString;
  }
}