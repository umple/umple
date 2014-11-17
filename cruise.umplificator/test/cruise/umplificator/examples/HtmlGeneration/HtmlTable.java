/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 60 "HtmlGeneration.ump"
public class HtmlTable extends HtmlRegularNode
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public HtmlTable(String aTag, String aArguments)
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

  // line 64 "HtmlGeneration.ump"
  public  HtmlTable(){
    super("table","");
  }

  // line 68 "HtmlGeneration.ump"
  public HtmlRow tr(){
    HtmlRow r = new HtmlRow();
    addSubnode(r);
    return r;
  }

}