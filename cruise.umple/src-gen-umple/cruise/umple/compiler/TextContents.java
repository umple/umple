/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * @umplesource Generator_Html.ump 241
 */
// line 241 "../../../../src/Generator_Html.ump"
public class TextContents extends Element
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TextContents(String aTagName, Element aParent)
  {
    super(aTagName, aParent);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }

  @umplesourcefile(line={243},file={"Generator_Html.ump"},javaline={39},length={3})
  public String htmlString(){
    return getTagName();
  }

}