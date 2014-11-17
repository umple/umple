/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.regex.Pattern;
import java.util.*;

// line 104 "HtmlGeneration.ump"
public class HtmlGen
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  public static final String NL = System.getProperty("line.separator");
  public static final String TEXT_0 = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">";
  public static final String TEXT_1 = "xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\"";
  public static final String TEXT_2 = NL + "<html ";
  public static final String TEXT_3 = " >" + NL + "  <head>" + NL + "  ";
  public static final String TEXT_4 = "    ";
  public static final String TEXT_5 = NL + "  ";
  public static final String TEXT_6 = "  </head>" + NL + "  <body>" + NL + "  ";
  public static final String TEXT_7 = "    ";
  public static final String TEXT_8 = NL + "  ";
  public static final String TEXT_9 = "  </body>" + NL + "</html>" + NL;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //HtmlGen Attributes
  private HtmlNode firstNode;
  private int _lineNumber;

  //HtmlGen Associations
  private List<HtmlNode> headerNodes;
  private List<HtmlNode> bodyNodes;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public HtmlGen()
  {
    _lineNumber = 1;
    headerNodes = new ArrayList<HtmlNode>();
    bodyNodes = new ArrayList<HtmlNode>();
    // line 112 "HtmlGeneration.ump"
    firstNode = new HtmlTextNode(filehead());
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setFirstNode(HtmlNode aFirstNode)
  {
    boolean wasSet = false;
    firstNode = aFirstNode;
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

  public HtmlNode getFirstNode()
  {
    return firstNode;
  }

  public int get_lineNumber()
  {
    return _lineNumber;
  }

  public HtmlNode getHeaderNode(int index)
  {
    HtmlNode aHeaderNode = headerNodes.get(index);
    return aHeaderNode;
  }

  /**
   * Subtrees for the header and body
   */
  public List<HtmlNode> getHeaderNodes()
  {
    List<HtmlNode> newHeaderNodes = Collections.unmodifiableList(headerNodes);
    return newHeaderNodes;
  }

  public int numberOfHeaderNodes()
  {
    int number = headerNodes.size();
    return number;
  }

  public boolean hasHeaderNodes()
  {
    boolean has = headerNodes.size() > 0;
    return has;
  }

  public int indexOfHeaderNode(HtmlNode aHeaderNode)
  {
    int index = headerNodes.indexOf(aHeaderNode);
    return index;
  }

  public HtmlNode getBodyNode(int index)
  {
    HtmlNode aBodyNode = bodyNodes.get(index);
    return aBodyNode;
  }

  public List<HtmlNode> getBodyNodes()
  {
    List<HtmlNode> newBodyNodes = Collections.unmodifiableList(bodyNodes);
    return newBodyNodes;
  }

  public int numberOfBodyNodes()
  {
    int number = bodyNodes.size();
    return number;
  }

  public boolean hasBodyNodes()
  {
    boolean has = bodyNodes.size() > 0;
    return has;
  }

  public int indexOfBodyNode(HtmlNode aBodyNode)
  {
    int index = bodyNodes.indexOf(aBodyNode);
    return index;
  }

  public static int minimumNumberOfHeaderNodes()
  {
    return 0;
  }

  public boolean addHeaderNode(HtmlNode aHeaderNode)
  {
    boolean wasAdded = false;
    if (headerNodes.contains(aHeaderNode)) { return false; }
    headerNodes.add(aHeaderNode);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeHeaderNode(HtmlNode aHeaderNode)
  {
    boolean wasRemoved = false;
    if (headerNodes.contains(aHeaderNode))
    {
      headerNodes.remove(aHeaderNode);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addHeaderNodeAt(HtmlNode aHeaderNode, int index)
  {  
    boolean wasAdded = false;
    if(addHeaderNode(aHeaderNode))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfHeaderNodes()) { index = numberOfHeaderNodes() - 1; }
      headerNodes.remove(aHeaderNode);
      headerNodes.add(index, aHeaderNode);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveHeaderNodeAt(HtmlNode aHeaderNode, int index)
  {
    boolean wasAdded = false;
    if(headerNodes.contains(aHeaderNode))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfHeaderNodes()) { index = numberOfHeaderNodes() - 1; }
      headerNodes.remove(aHeaderNode);
      headerNodes.add(index, aHeaderNode);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addHeaderNodeAt(aHeaderNode, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfBodyNodes()
  {
    return 0;
  }

  public boolean addBodyNode(HtmlNode aBodyNode)
  {
    boolean wasAdded = false;
    if (bodyNodes.contains(aBodyNode)) { return false; }
    bodyNodes.add(aBodyNode);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeBodyNode(HtmlNode aBodyNode)
  {
    boolean wasRemoved = false;
    if (bodyNodes.contains(aBodyNode))
    {
      bodyNodes.remove(aBodyNode);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addBodyNodeAt(HtmlNode aBodyNode, int index)
  {  
    boolean wasAdded = false;
    if(addBodyNode(aBodyNode))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBodyNodes()) { index = numberOfBodyNodes() - 1; }
      bodyNodes.remove(aBodyNode);
      bodyNodes.add(index, aBodyNode);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBodyNodeAt(HtmlNode aBodyNode, int index)
  {
    boolean wasAdded = false;
    if(bodyNodes.contains(aBodyNode))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBodyNodes()) { index = numberOfBodyNodes() - 1; }
      bodyNodes.remove(aBodyNode);
      bodyNodes.add(index, aBodyNode);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBodyNodeAt(aBodyNode, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    headerNodes.clear();
    bodyNodes.clear();
  }


  /**
   * Creates a new simple node; but does not add it anywhere
   */
  // line 141 "HtmlGeneration.ump"
  public HtmlRegularNode simpleNode(String tag, String content){
    HtmlTextNode t = new HtmlTextNode(content);
    HtmlRegularNode r = new HtmlRegularNode(tag,"");
    r.addSubnode(t);
    return r;
  }


  /**
   * Add a top level node of any type that contains a string
   */
  // line 149 "HtmlGeneration.ump"
  public HtmlNode addNode(HtmlNode n){
    addBodyNode(n);
    return n;
  }


  /**
   * Add a node of any type that contains a string
   */
  // line 155 "HtmlGeneration.ump"
  public HtmlRegularNode addSimpleNode(String tag, String text){
    HtmlRegularNode t = simpleNode(tag,text);
    addBodyNode(t);
    return t;
  }


  /**
   * Adds a top level header at a certain level with plain text
   * Subsequent calls can be made to add additional elements
   * to the result
   */
  // line 164 "HtmlGeneration.ump"
  public HtmlRegularNode h(int level, String text){
    return addSimpleNode("h"+level,text);
  }


  /**
   * Adds a top level p with plain text
   * Subsequent calls can add additional elements to the p
   * beyond just the text
   */
  // line 171 "HtmlGeneration.ump"
  public HtmlRegularNode p(String text){
    return addSimpleNode("p",text);
  }


  /**
   * Adds a top level table
   */
  // line 177 "HtmlGeneration.ump"
  public HtmlTable table(){
    HtmlTable t = new HtmlTable();
    addBodyNode(t);
    return t;
  }

  private String _createSpacesString(int numSpaces){
      StringBuilder spaces =  new StringBuilder();
      for(int i=0; i <numSpaces; i++) {
          spaces.append(" ");
      }
      return spaces.toString();
    
  }

  public StringBuilder _filehead(Integer numSpaces, StringBuilder sb){
    String spaces="";
    StringBuilder newCode = new StringBuilder();
    StringBuilder realSb = sb;
    if(numSpaces > 0) {
        realSb = newCode;
        spaces = _createSpacesString(numSpaces);
        newCode.append(spaces);
    }
    
    realSb.append(TEXT_0);

    if(numSpaces > 0) {
        newCode.replace(0, newCode.length(), Pattern.compile(NL).matcher(newCode).replaceAll(NL + spaces));
        sb.append(newCode);
    }
    return sb; 
  }

  public String filehead(){
        StringBuilder sb = new StringBuilder();
    return this._filehead(0,sb).toString(); 
  }

  public StringBuilder _xmlns(Integer numSpaces, StringBuilder sb){
    String spaces="";
    StringBuilder newCode = new StringBuilder();
    StringBuilder realSb = sb;
    if(numSpaces > 0) {
        realSb = newCode;
        spaces = _createSpacesString(numSpaces);
        newCode.append(spaces);
    }
    
    realSb.append(TEXT_1);

    if(numSpaces > 0) {
        newCode.replace(0, newCode.length(), Pattern.compile(NL).matcher(newCode).replaceAll(NL + spaces));
        sb.append(newCode);
    }
    return sb; 
  }

  public String xmlns(){
        StringBuilder sb = new StringBuilder();
    return this._xmlns(0,sb).toString(); 
  }

  public StringBuilder _wholefile(Integer numSpaces, StringBuilder sb){
    String spaces="";
    StringBuilder newCode = new StringBuilder();
    StringBuilder realSb = sb;
    if(numSpaces > 0) {
        realSb = newCode;
        spaces = _createSpacesString(numSpaces);
        newCode.append(spaces);
    }
    
    realSb.append(getFirstNode().getContent());
    realSb.append(TEXT_2);
    realSb.append(xmlns());
    realSb.append(TEXT_3);
    for(HtmlNode h: getHeaderNodes()) {
    realSb.append(TEXT_4);
    realSb.append(h.getContent());
    realSb.append(TEXT_5);
    }
    realSb.append(TEXT_6);
    for(HtmlNode h: getBodyNodes()) {
    realSb.append(TEXT_7);
    realSb.append(h.getContent());
    realSb.append(TEXT_8);
    }
    realSb.append(TEXT_9);

    if(numSpaces > 0) {
        newCode.replace(0, newCode.length(), Pattern.compile(NL).matcher(newCode).replaceAll(NL + spaces));
        sb.append(newCode);
    }
    return sb; 
  }

  public String wholefile(){
        StringBuilder sb = new StringBuilder();
    return this._wholefile(0,sb).toString(); 
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "_lineNumber" + ":" + get_lineNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "firstNode" + "=" + (getFirstNode() != null ? !getFirstNode().equals(this)  ? getFirstNode().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}