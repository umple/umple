/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 74 "HtmlGeneration.ump"
public class HtmlRow extends HtmlRegularNode
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public HtmlRow(String aTag, String aArguments)
  {
    super(aTag, aArguments);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }

  // line 78 "HtmlGeneration.ump"
  public  HtmlRow(){
    super("tr","");
  }


  /**
   * Add a cell that contains text
   */
  // line 83 "HtmlGeneration.ump"
  public HtmlCell td(String s){
    HtmlCell c = td();
    c.text(s);
    return(c);
  }


  /**
   * Add a cell that can contain anything
   */
  // line 90 "HtmlGeneration.ump"
  public HtmlCell td(){
    HtmlCell c = new HtmlCell();
    addSubnode(c);
    return c;
  }

}