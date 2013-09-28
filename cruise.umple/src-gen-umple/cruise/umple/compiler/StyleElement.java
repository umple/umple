/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;

/**
 * @umplesource Generator_Html.ump 385
 */
// line 385 "../../../../src/Generator_Html.ump"
public class StyleElement implements IHtmlElement
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StyleElement Attributes
  private IHtmlElement parent;
  private Element style;
  private String styleText;

  //Helper Variables
  private boolean canSetStyleText;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  @umplesourcefile(line={393},file={"Generator_Html.ump"},javaline={39},length={2})
  public StyleElement(IHtmlElement aParent, String aStyleText)
  {
    parent = aParent;
    style = null;
    styleText = aStyleText;
    canSetStyleText = false;
    // line 393 "../../../../src/Generator_Html.ump"
    style =new Element(ITagsConstants.style, parent!=null ? parent.getElement() : null);
    		style.addAttribute(new AttributeElement(IAttributesConstants.type, "text/css"));
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

  public IHtmlElement getParent()
  {
    return parent;
  }

  public String getStyleText()
  {
    return styleText;
  }

  public void delete()
  {}

  @umplesourcefile(line={398},file={"Generator_Html.ump"},javaline={69},length={3})
   public Element getElement(){
    return style;
  }

  @umplesourcefile(line={402},file={"Generator_Html.ump"},javaline={74},length={3})
   public String htmlString(){
    return style.toString();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "styleText" + ":" + getStyleText()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "parent" + "=" + (getParent() != null ? !getParent().equals(this)  ? getParent().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}