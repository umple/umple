/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;

/**
 * @umplesource Generator_Html.ump 269
 */
// line 269 "../../../../src/Generator_Html.ump"
public class DivElement implements IHtmlElement
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DivElement Attributes
  private Element div;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  @umplesourcefile(line={273},file={"Generator_Html.ump"},javaline={31},length={1})
  public DivElement()
  {
    div = null;
    // line 273 "../../../../src/Generator_Html.ump"
    div = new Element(ITagsConstants.DIV, null);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}

  @umplesourcefile(line={278},file={"Generator_Html.ump"},javaline={43},length={3})
  public Element getElement(){
    return div;
  }

  @umplesourcefile(line={282},file={"Generator_Html.ump"},javaline={48},length={3})
  public String htmlString(){
    return div.toString();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]"
     + outputString;
  }
}