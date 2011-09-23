/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.605 modeling language!*/

package cruise.umple.compiler;

public class Comment
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Comment Attributes
  private String text;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Comment(String aText)
  {
    text = aText;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setText(String aText)
  {
    boolean wasSet = false;
    text = aText;
    wasSet = true;
    return wasSet;
  }

  public String getText()
  {
    return text;
  }

  public void delete()
  {}

}