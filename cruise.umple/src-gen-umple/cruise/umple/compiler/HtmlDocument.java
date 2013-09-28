/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;

/**
 * @umplesource Generator_Html.ump 444
 */
// line 444 "../../../../src/Generator_Html.ump"
public class HtmlDocument
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //HtmlDocument Attributes
  private boolean parentHtml;
  private IHtmlElement parent;

  //Helper Variables
  private boolean canSetParentHtml;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  @umplesourcefile(line={448},file={"Generator_Html.ump"},javaline={37},length={5})
  public HtmlDocument(boolean aParentHtml)
  {
    parentHtml = aParentHtml;
    canSetParentHtml = false;
    parent = null;
    // line 448 "../../../../src/Generator_Html.ump"
    if(parentHtml) {
    			parent = new HtmlElement();
    		} else {
    			parent = new DivElement();
    		}
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean getParentHtml()
  {
    return parentHtml;
  }

  public boolean isParentHtml()
  {
    return parentHtml;
  }

  public void delete()
  {}

  @umplesourcefile(line={456},file={"Generator_Html.ump"},javaline={62},length={4})
   public TableElement createTable(int aColumns){
    TableElement tbl = new TableElement(parent, aColumns);
		return tbl;
  }

  @umplesourcefile(line={461},file={"Generator_Html.ump"},javaline={68},length={9})
   public ScriptElement createScript(String... aScriptTexts){
    StringBuffer stringBuffer = new StringBuffer(""); //$NON-NLS-1$
		for(String text: aScriptTexts){
			stringBuffer.append(text);
			stringBuffer.append("\n"); //$NON-NLS-1$
		}
		ScriptElement script = new ScriptElement(parent, stringBuffer.toString());
		return script;
  }

  @umplesourcefile(line={471},file={"Generator_Html.ump"},javaline={79},length={9})
   public StyleElement createStyle(String... aStyleTexts){
    StringBuffer stringBuffer = new StringBuffer(""); //$NON-NLS-1$
		for(String text: aStyleTexts){
			stringBuffer.append(text);
			stringBuffer.append("\n"); //$NON-NLS-1$
		}
		StyleElement style = new StyleElement(parent, stringBuffer.toString());
		return style;
  }

  @umplesourcefile(line={481},file={"Generator_Html.ump"},javaline={90},length={4})
  public ParagraphElement createParagraphElement(String aText, boolean aSmall){
    ParagraphElement p = new ParagraphElement(parent, aText, aSmall);
		return p;
  }

  @umplesourcefile(line={486},file={"Generator_Html.ump"},javaline={96},length={3})
  public String htmlString(){
    return parent.htmlString();
  }

  @umplesourcefile(line={490},file={"Generator_Html.ump"},javaline={101},length={3})
  public String toString(){
    return this.htmlString();
  }

}