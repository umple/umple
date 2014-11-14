/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 14 "OBDCarSystem.ump"
public class BoardData
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //BoardData Attributes
  private int carsTime;
  private int kilometerage;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public BoardData(int aCarsTime, int aKilometerage)
  {
    carsTime = aCarsTime;
    kilometerage = aKilometerage;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCarsTime(int aCarsTime)
  {
    boolean wasSet = false;
    carsTime = aCarsTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setKilometerage(int aKilometerage)
  {
    boolean wasSet = false;
    kilometerage = aKilometerage;
    wasSet = true;
    return wasSet;
  }

  public int getCarsTime()
  {
    return carsTime;
  }

  public int getKilometerage()
  {
    return kilometerage;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "carsTime" + ":" + getCarsTime()+ "," +
            "kilometerage" + ":" + getKilometerage()+ "]"
     + outputString;
  }
}