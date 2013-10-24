/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * @umplesource Generator_Html.ump 285
 */
// line 285 "../../../../src/Generator_Html.ump"
public class TableElement implements IHtmlElement
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TableElement Attributes
  private IHtmlElement parent;
  private int columns;
  private int index;
  private List<String> titles;
  private Element table;
  private Element tableBody;
  private Element headersRow;
  private String id;
  private String bodyId;
  private String cssClass;
  private int border;

  //Helper Variables
  private boolean canSetColumns;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  @umplesourcefile(line={304},file={"Generator_Html.ump"},javaline={56},length={4})
  public TableElement(IHtmlElement aParent, int aColumns)
  {
    parent = aParent;
    columns = aColumns;
    canSetColumns = false;
    index = 0;
    titles = new ArrayList<String>();
    table = null;
    tableBody = null;
    headersRow = null;
    resetId();
    resetBodyId();
    resetCssClass();
    resetBorder();
    // line 304 "../../../../src/Generator_Html.ump"
    table = new Element(ITagsConstants.TABLE, parent!=null ? parent.getElement() : null);
    		tableBody = new Element(ITagsConstants.TBODY,table);		
    		headersRow = new Element(ITagsConstants.TR, tableBody);
    		headersRow.addAttribute(new AttributeElement(IAttributesConstants.ID, "headersRow"));
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setParent(IHtmlElement aParent)
  {
    boolean wasSet = false;
    parent = aParent;
    wasSet = true;
    return wasSet;
  }

  @umplesourcefile(line={311},file={"Generator_Html.ump"},javaline={81},length={3})
  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    // line 311 "../../../../src/Generator_Html.ump"
    if(!isNull(id)) {
    			table.addAttribute( new AttributeElement(IAttributesConstants.ID, id));
    		}
    return wasSet;
  }

  @umplesourcefile(line={311},file={"Generator_Html.ump"},javaline={81},length={3})
  public boolean resetId()
  {
    boolean wasReset = false;
    id = getDefaultId();
    wasReset = true;
    return wasReset;
  }

  @umplesourcefile(line={317},file={"Generator_Html.ump"},javaline={101},length={3})
  public boolean setBodyId(String aBodyId)
  {
    boolean wasSet = false;
    bodyId = aBodyId;
    wasSet = true;
    // line 317 "../../../../src/Generator_Html.ump"
    if(!isNull(bodyId)) {
    			tableBody.addAttribute( new AttributeElement(IAttributesConstants.ID, bodyId));
    		}
    return wasSet;
  }

  @umplesourcefile(line={317},file={"Generator_Html.ump"},javaline={101},length={3})
  public boolean resetBodyId()
  {
    boolean wasReset = false;
    bodyId = getDefaultBodyId();
    wasReset = true;
    return wasReset;
  }

  @umplesourcefile(line={323},file={"Generator_Html.ump"},javaline={121},length={3})
  public boolean setCssClass(String aCssClass)
  {
    boolean wasSet = false;
    cssClass = aCssClass;
    wasSet = true;
    // line 323 "../../../../src/Generator_Html.ump"
    if(!isNull(cssClass)) {
    			table.addAttribute( new AttributeElement(IAttributesConstants.ATTRIBUTE_CLASS, cssClass));
    		}
    return wasSet;
  }

  @umplesourcefile(line={323},file={"Generator_Html.ump"},javaline={121},length={3})
  public boolean resetCssClass()
  {
    boolean wasReset = false;
    cssClass = getDefaultCssClass();
    wasReset = true;
    return wasReset;
  }

  @umplesourcefile(line={329},file={"Generator_Html.ump"},javaline={141},length={1})
  public boolean setBorder(int aBorder)
  {
    boolean wasSet = false;
    border = aBorder;
    wasSet = true;
    // line 329 "../../../../src/Generator_Html.ump"
    table.addAttribute( new AttributeElement(IAttributesConstants.BORDER, String.valueOf(border)));
    return wasSet;
  }

  @umplesourcefile(line={329},file={"Generator_Html.ump"},javaline={141},length={1})
  public boolean resetBorder()
  {
    boolean wasReset = false;
    border = getDefaultBorder();
    wasReset = true;
    return wasReset;
  }

  public IHtmlElement getParent()
  {
    return parent;
  }

  public int getColumns()
  {
    return columns;
  }

  public String getId()
  {
    return id;
  }

  public String getDefaultId()
  {
    return "";
  }

  public String getBodyId()
  {
    return bodyId;
  }

  public String getDefaultBodyId()
  {
    return "";
  }

  public String getCssClass()
  {
    return cssClass;
  }

  public String getDefaultCssClass()
  {
    return "";
  }

  /**
   * defaulted String cssHeadersRow = "";defaulted String cssHeadersColumn = "";
   */
  public int getBorder()
  {
    return border;
  }

  public int getDefaultBorder()
  {
    return 0;
  }

  public void delete()
  {}

  @umplesourcefile(line={333},file={"Generator_Html.ump"},javaline={217},length={8})
   public void addRow(String [] rowData){
    Element tableRow = new Element(ITagsConstants.TR, tableBody);
		tableRow.addAttribute(new AttributeElement(IAttributesConstants.ID, "TableRow"+index));
		for(int cellIndex=0 ;cellIndex<columns; cellIndex++){
			Element td = new Element(ITagsConstants.TD, tableRow);
			td.appendText(rowData[cellIndex]);
		}
  }

  @umplesourcefile(line={349},file={"Generator_Html.ump"},javaline={227},length={3})
   private boolean isNull(String attr){
    return attr == null || attr.length() == 0;
  }

  @umplesourcefile(line={353},file={"Generator_Html.ump"},javaline={232},length={3})
  public Element getElement(){
    return table;
  }

  @umplesourcefile(line={357},file={"Generator_Html.ump"},javaline={237},length={3})
  public String htmlString(){
    return table.toString();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "columns" + ":" + getColumns()+ "," +
            "id" + ":" + getId()+ "," +
            "bodyId" + ":" + getBodyId()+ "," +
            "cssClass" + ":" + getCssClass()+ "," +
            "border" + ":" + getBorder()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "parent" + "=" + (getParent() != null ? !getParent().equals(this)  ? getParent().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={341},file={"Generator_Html.ump"},javaline={258},length={8})
  void setTitles (String titles []) 
  {
    for(int index=0 ;index<columns; index++){
			Element th = new Element(ITagsConstants.TH, headersRow);
			th.appendText(titles[index]);
		}
  }

  
}