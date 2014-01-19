/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;

/**
 * @umplesource Generator_Html.ump 443
 */
// line 443 "../../../../src/Generator_Html.ump"
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

  @umplesourcefile(line={457},file={"Generator_Html.ump"},javaline={63},length={4})
   public TableElement createTable(int aColumns){
    TableElement tbl = new TableElement(parent, aColumns);
		return tbl;
  }

  @umplesourcefile(line={462},file={"Generator_Html.ump"},javaline={69},length={9})
   public ScriptElement createScript(String... aScriptTexts){
    StringBuffer stringBuffer = new StringBuffer(""); //$NON-NLS-1$
		for(String text: aScriptTexts){
			stringBuffer.append(text);
			stringBuffer.append("\n"); //$NON-NLS-1$
		}
		ScriptElement script = new ScriptElement(parent, stringBuffer.toString());
		return script;
  }

  @umplesourcefile(line={472},file={"Generator_Html.ump"},javaline={80},length={9})
   public StyleElement createStyle(String... aStyleTexts){
    StringBuffer stringBuffer = new StringBuffer(""); //$NON-NLS-1$
		for(String text: aStyleTexts){
			stringBuffer.append(text);
			stringBuffer.append("\n"); //$NON-NLS-1$
		}
		StyleElement style = new StyleElement(parent, stringBuffer.toString());
		return style;
  }

  @umplesourcefile(line={482},file={"Generator_Html.ump"},javaline={91},length={4})
  public ParagraphElement createParagraphElement(String aText, boolean aSmall){
    ParagraphElement p = new ParagraphElement(parent, aText, aSmall);
		return p;
  }

  @umplesourcefile(line={487},file={"Generator_Html.ump"},javaline={97},length={3})
  public String htmlString(){
    return parent.htmlString();
  }

  @umplesourcefile(line={491},file={"Generator_Html.ump"},javaline={102},length={3})
  public String toString(){
    return this.htmlString();
  }

}