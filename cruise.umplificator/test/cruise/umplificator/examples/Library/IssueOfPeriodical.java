/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 35 "Library.ump"
// line 75 "Library.ump"
public class IssueOfPeriodical extends EditionOrIssue
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //IssueOfPeriodical Attributes
  private String volume;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public IssueOfPeriodical(String aIssueNumber, String aPublishedDate, Publisher aPublisher, Publication aPublication, String aVolume)
  {
    super(aIssueNumber, aPublishedDate, aPublisher, aPublication);
    volume = aVolume;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setVolume(String aVolume)
  {
    boolean wasSet = false;
    volume = aVolume;
    wasSet = true;
    return wasSet;
  }

  public String getVolume()
  {
    return volume;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "volume" + ":" + getVolume()+ "]"
     + outputString;
  }
}