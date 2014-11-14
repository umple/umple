/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * Positioning
 */
// line 33 "Library.ump"
// line 47 "Library.ump"
public class EditionOfBook extends EditionOrIssue
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //EditionOfBook Attributes
  private String isbn;
  private String libOfCongress;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public EditionOfBook(String aIssueNumber, String aPublishedDate, Publisher aPublisher, Publication aPublication, String aIsbn, String aLibOfCongress)
  {
    super(aIssueNumber, aPublishedDate, aPublisher, aPublication);
    isbn = aIsbn;
    libOfCongress = aLibOfCongress;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIsbn(String aIsbn)
  {
    boolean wasSet = false;
    isbn = aIsbn;
    wasSet = true;
    return wasSet;
  }

  public boolean setLibOfCongress(String aLibOfCongress)
  {
    boolean wasSet = false;
    libOfCongress = aLibOfCongress;
    wasSet = true;
    return wasSet;
  }

  public String getIsbn()
  {
    return isbn;
  }

  public String getLibOfCongress()
  {
    return libOfCongress;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "isbn" + ":" + getIsbn()+ "," +
            "libOfCongress" + ":" + getLibOfCongress()+ "]"
     + outputString;
  }
}