/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



/**
 * Simple text to be output between tags - these are leaves
 */
// line 14 "HtmlGeneration.ump"
public class HtmlTextNode extends HtmlNode
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //HtmlTextNode Attributes
  private String content;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public HtmlTextNode(String aContent)
  {
    super();
    content = aContent;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setContent(String aContent)
  {
    boolean wasSet = false;
    content = aContent;
    wasSet = true;
    return wasSet;
  }

  public String getContent()
  {
    return content;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "content" + ":" + getContent()+ "]"
     + outputString;
  }
}