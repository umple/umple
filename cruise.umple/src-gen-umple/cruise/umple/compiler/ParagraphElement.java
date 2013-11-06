/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;

/**
 * @umplesource Generator_Html.ump 406
 */
// line 406 "../../../../src/Generator_Html.ump"
public class ParagraphElement implements IHtmlElement
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ParagraphElement Attributes
  private IHtmlElement parent;
  private Element par;
  private String text;
  private boolean small;

  //Helper Variables
  private boolean canSetText;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  @umplesourcefile(line={416},file={"Generator_Html.ump"},javaline={41},length={6})
  public ParagraphElement(IHtmlElement aParent, String aText, boolean aSmall)
  {
    parent = aParent;
    par = null;
    text = aText;
    canSetText = false;
    small = aSmall;
    // line 416 "../../../../src/Generator_Html.ump"
    if(aSmall) {
    			par = new Element(ITagsConstants.SMALL, new Element(ITagsConstants.P, parent!=null ? parent.getElement() : null));
    		} else {
    			par = new Element(ITagsConstants.P, parent!=null ? parent.getElement() : null);
    		}
    		par.appendTextContents(true,text);
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

  public boolean setSmall(boolean aSmall)
  {
    boolean wasSet = false;
    small = aSmall;
    wasSet = true;
    return wasSet;
  }

  public IHtmlElement getParent()
  {
    return parent;
  }

  public String getText()
  {
    return text;
  }

  public boolean getSmall()
  {
    return small;
  }

  public boolean isSmall()
  {
    return small;
  }

  public void delete()
  {}

  @umplesourcefile(line={426},file={"Generator_Html.ump"},javaline={94},length={5})
   private void appendText(String text){
    if(!isNull(text)) {
			par.appendTextContents(true,text);
		}
  }

  @umplesourcefile(line={432},file={"Generator_Html.ump"},javaline={101},length={3})
   private boolean isNull(String attr){
    return attr == null || attr.length() == 0;
  }

  @umplesourcefile(line={436},file={"Generator_Html.ump"},javaline={106},length={3})
  public Element getElement(){
    return par;
  }

  @umplesourcefile(line={440},file={"Generator_Html.ump"},javaline={111},length={3})
  public String htmlString(){
    return par.toString();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "text" + ":" + getText()+ "," +
            "small" + ":" + getSmall()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "parent" + "=" + (getParent() != null ? !getParent().equals(this)  ? getParent().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}