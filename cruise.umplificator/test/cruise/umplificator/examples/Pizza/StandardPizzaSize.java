/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 45 "Pizza.ump"
// line 102 "Pizza.ump"
public class StandardPizzaSize
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StandardPizzaSize Attributes
  private String sizeLabel;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StandardPizzaSize(String aSizeLabel)
  {
    sizeLabel = aSizeLabel;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSizeLabel(String aSizeLabel)
  {
    boolean wasSet = false;
    sizeLabel = aSizeLabel;
    wasSet = true;
    return wasSet;
  }

  public String getSizeLabel()
  {
    return sizeLabel;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "sizeLabel" + ":" + getSizeLabel()+ "]"
     + outputString;
  }
}