/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/



// line 1 "BasicPrecondition1.ump"
public class Client
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Client Attributes
  private int minAge;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Client(int aMinAge)
  {
    minAge = aMinAge;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setMinAge(int aMinAge)
  {
    boolean wasSet = false;
    minAge = aMinAge;
    wasSet = true;
    return wasSet;
  }

  public int getMinAge()
  {
    return minAge;
  }

  public void delete()
  {}

  // line 4 "BasicPrecondition1.ump"
  public int someMethod(Integer arg){

    if ( !(arg>5))
    {
      throw new RuntimeException("Please provide a valid arg");
    }
    if ( !(minAge<8))
    {
      throw new RuntimeException("Please provide a valid minAge");
    }
    // rest of stuff that we don't interpret
 return 0;
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "minAge" + ":" + getMinAge()+ "]"
     + outputString;
  }
}