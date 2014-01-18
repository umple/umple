/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;

/**
 * @umplesource Generator_Html.ump 252
 */
// line 252 "../../../../src/Generator_Html.ump"
public class HtmlElement implements IHtmlElement
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //HtmlElement Attributes
  private Element html;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  @umplesourcefile(line={256},file={"Generator_Html.ump"},javaline={31},length={2})
  public HtmlElement()
  {
    html = null;
    // line 256 "../../../../src/Generator_Html.ump"
    html = new Element(ITagsConstants.HTML, null);
    		html.addAttribute( new AttributeElement( IAttributesConstants.XLMNS, "http://www.w3.org/1999/xhtml"));
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}

  @umplesourcefile(line={262},file={"Generator_Html.ump"},javaline={44},length={3})
  public Element getElement(){
    return html;
  }

  @umplesourcefile(line={266},file={"Generator_Html.ump"},javaline={49},length={3})
  public String htmlString(){
    return html.toString();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]"
     + outputString;
  }
}