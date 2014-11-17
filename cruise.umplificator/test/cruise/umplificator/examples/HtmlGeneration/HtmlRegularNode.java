/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.regex.Pattern;
import java.util.*;

/**
 * Non-leaf nodes in the html tree
 */
// line 20 "HtmlGeneration.ump"
public class HtmlRegularNode extends HtmlNode
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  public static final String Xmltagstart = "<";
  public static final String Xmltagend = ">";
  public static final String NL = System.getProperty("line.separator");
  public static final String TEXT_0 = " ";
  public static final String TEXT_1 = NL + "  ";
  public static final String TEXT_2 = NL + "  ";
  public static final String TEXT_3 = "/";

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //HtmlRegularNode Attributes
  private String tag;
  private String arguments;
  private int _lineNumber;

  //HtmlRegularNode Associations
  private List<HtmlNode> subnodes;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public HtmlRegularNode(String aTag, String aArguments)
  {
    super();
    tag = aTag;
    arguments = aArguments;
    _lineNumber = 1;
    subnodes = new ArrayList<HtmlNode>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTag(String aTag)
  {
    boolean wasSet = false;
    tag = aTag;
    wasSet = true;
    return wasSet;
  }

  public boolean setArguments(String aArguments)
  {
    boolean wasSet = false;
    arguments = aArguments;
    wasSet = true;
    return wasSet;
  }

  public boolean set_lineNumber(int a_lineNumber)
  {
    boolean wasSet = false;
    _lineNumber = a_lineNumber;
    wasSet = true;
    return wasSet;
  }

  /**
   * Arguments for the constructor
   * e.g. p, h1, a
   */
  public String getTag()
  {
    return tag;
  }

  /**
   * e.g. href
   */
  public String getArguments()
  {
    return arguments;
  }

  public int get_lineNumber()
  {
    return _lineNumber;
  }

  public HtmlNode getSubnode(int index)
  {
    HtmlNode aSubnode = subnodes.get(index);
    return aSubnode;
  }

  /**
   * whatever to emit between tags
   */
  public List<HtmlNode> getSubnodes()
  {
    List<HtmlNode> newSubnodes = Collections.unmodifiableList(subnodes);
    return newSubnodes;
  }

  public int numberOfSubnodes()
  {
    int number = subnodes.size();
    return number;
  }

  public boolean hasSubnodes()
  {
    boolean has = subnodes.size() > 0;
    return has;
  }

  public int indexOfSubnode(HtmlNode aSubnode)
  {
    int index = subnodes.indexOf(aSubnode);
    return index;
  }

  public static int minimumNumberOfSubnodes()
  {
    return 0;
  }

  public boolean addSubnode(HtmlNode aSubnode)
  {
    boolean wasAdded = false;
    if (subnodes.contains(aSubnode)) { return false; }
    if (subnodes.contains(aSubnode)) { return false; }
    if (subnodes.contains(aSubnode)) { return false; }
    if (subnodes.contains(aSubnode)) { return false; }
    subnodes.add(aSubnode);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSubnode(HtmlNode aSubnode)
  {
    boolean wasRemoved = false;
    if (subnodes.contains(aSubnode))
    {
      subnodes.remove(aSubnode);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addSubnodeAt(HtmlNode aSubnode, int index)
  {  
    boolean wasAdded = false;
    if(addSubnode(aSubnode))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSubnodes()) { index = numberOfSubnodes() - 1; }
      subnodes.remove(aSubnode);
      subnodes.add(index, aSubnode);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSubnodeAt(HtmlNode aSubnode, int index)
  {
    boolean wasAdded = false;
    if(subnodes.contains(aSubnode))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSubnodes()) { index = numberOfSubnodes() - 1; }
      subnodes.remove(aSubnode);
      subnodes.add(index, aSubnode);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSubnodeAt(aSubnode, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    subnodes.clear();
    super.delete();
  }

  // line 40 "HtmlGeneration.ump"
  public HtmlTable table(){
    HtmlTable t = new HtmlTable();
    addSubnode(t);
    return t;
  }

  // line 46 "HtmlGeneration.ump"
  public HtmlTextNode text(String s){
    HtmlTextNode t = new HtmlTextNode(s);
    addSubnode(t);
    return(t);
  }

  // line 52 "HtmlGeneration.ump"
  public HtmlRegularNode taggedText(String tag, String arguments, String s){
    HtmlRegularNode r = new HtmlRegularNode(tag, arguments);
    HtmlTextNode t = new HtmlTextNode(s);
    r.addSubnode(t);
    addSubnode(r);
    return(r);
  }

  private String _createSpacesString(int numSpaces){
      StringBuilder spaces =  new StringBuilder();
      for(int i=0; i <numSpaces; i++) {
          spaces.append(" ");
      }
      return spaces.toString();
    
  }

  public StringBuilder _getContent(Integer numSpaces, StringBuilder sb){
    String spaces="";
    StringBuilder newCode = new StringBuilder();
    StringBuilder realSb = sb;
    if(numSpaces > 0) {
        realSb = newCode;
        spaces = _createSpacesString(numSpaces);
        newCode.append(spaces);
    }
    
    realSb.append(Xmltagstart);
    realSb.append(getTag());
    realSb.append(TEXT_0);
    realSb.append(getArguments());
    realSb.append(Xmltagend);
    realSb.append(TEXT_1);
    
  for(HtmlNode n : getSubnodes()) {
    realSb.append(n.getContent());
    realSb.append(TEXT_2);
    }
    realSb.append(Xmltagstart);
    realSb.append(TEXT_3);
    realSb.append(getTag());
    realSb.append(Xmltagend);

    if(numSpaces > 0) {
        newCode.replace(0, newCode.length(), Pattern.compile(NL).matcher(newCode).replaceAll(NL + spaces));
        sb.append(newCode);
    }
    return sb; 
  }

  public String getContent(){
        StringBuilder sb = new StringBuilder();
    return this._getContent(0,sb).toString(); 
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "tag" + ":" + getTag()+ "," +
            "arguments" + ":" + getArguments()+ "," +
            "_lineNumber" + ":" + get_lineNumber()+ "]"
     + outputString;
  }
}