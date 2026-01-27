/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


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