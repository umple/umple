/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;

/**
 * @umplesource Generator_Html.ump 361
 */
// line 361 "../../../../src/Generator_Html.ump"
public class ScriptElement implements IHtmlElement
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ScriptElement Attributes
  private IHtmlElement parent;
  private Element script;
  private String scriptText;

  //Helper Variables
  private boolean canSetScriptText;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  @umplesourcefile(line={370},file={"Generator_Html.ump"},javaline={39},length={2})
  public ScriptElement(IHtmlElement aParent, String aScriptText)
  {
    parent = aParent;
    script = null;
    scriptText = aScriptText;
    canSetScriptText = false;
    // line 370 "../../../../src/Generator_Html.ump"
    script = new Element(ITagsConstants.SCRIPT, parent!=null ? parent.getElement() : null);
    		script.addAttribute( new AttributeElement(IAttributesConstants.TYPE, "text/javascript"));
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

  public String getScriptText()
  {
    return scriptText;
  }

  public void delete()
  {}

  @umplesourcefile(line={375},file={"Generator_Html.ump"},javaline={69},length={3})
  public Element getElement(){
    return script;
  }

  @umplesourcefile(line={379},file={"Generator_Html.ump"},javaline={74},length={3})
  public String htmlString(){
    return script.toString();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "scriptText" + ":" + getScriptText()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "parent" + "=" + (getParent() != null ? !getParent().equals(this)  ? getParent().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}