/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;

/**
 * @umplesource Generator_Html.ump 253
 */
// line 253 "../../../../src/Generator_Html.ump"
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
    html = new Element(ITagsConstants.html, null);
    		html.addAttribute( new AttributeElement( IAttributesConstants.xlmns, "http://www.w3.org/1999/xhtml"));
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}

  @umplesourcefile(line={261},file={"Generator_Html.ump"},javaline={43},length={3})
  public Element getElement(){
    return html;
  }

  @umplesourcefile(line={265},file={"Generator_Html.ump"},javaline={48},length={3})
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