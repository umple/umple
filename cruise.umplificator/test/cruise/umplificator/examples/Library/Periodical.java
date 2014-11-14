/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 42 "Library.ump"
// line 59 "Library.ump"
public class Periodical extends Publication
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Periodical Attributes
  private String issn;
  private String frequency;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Periodical(String aName, String aIssn, String aFrequency)
  {
    super(aName);
    issn = aIssn;
    frequency = aFrequency;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIssn(String aIssn)
  {
    boolean wasSet = false;
    issn = aIssn;
    wasSet = true;
    return wasSet;
  }

  public boolean setFrequency(String aFrequency)
  {
    boolean wasSet = false;
    frequency = aFrequency;
    wasSet = true;
    return wasSet;
  }

  public String getIssn()
  {
    return issn;
  }

  public String getFrequency()
  {
    return frequency;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "issn" + ":" + getIssn()+ "," +
            "frequency" + ":" + getFrequency()+ "]"
     + outputString;
  }
}