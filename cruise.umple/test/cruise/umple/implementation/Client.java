/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/



/**
 * attributes on both sides of the constraint's boolean expression
 */
// line 2 "BasicConstraint3.ump"
public class Client
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Client Attributes
  private int minAge;
  private int age;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Client(int aMinAge, int aAge)
  {
    if ( !(aAge>aMinAge))
    {
      throw new RuntimeException("Please provide a valid age and minAge");
    }
    minAge = aMinAge;
    age = aAge;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setMinAge(int aMinAge)
  {
    boolean wasSet = false;
    if (age>aMinAge)
    {
    minAge = aMinAge;
    wasSet = true;
    }
    return wasSet;
  }

  public boolean setAge(int aAge)
  {
    boolean wasSet = false;
    if (aAge>minAge)
    {
    age = aAge;
    wasSet = true;
    }
    return wasSet;
  }

  public int getMinAge()
  {
    return minAge;
  }

  public int getAge()
  {
    return age;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "minAge" + ":" + getMinAge()+ "," +
            "age" + ":" + getAge()+ "]"
     + outputString;
  }
}