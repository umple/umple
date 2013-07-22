/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler.uigu2;
import java.util.*;
import cruise.umple.compiler.*;

/**
 * This was not compiled with Jet, but compatibility was maintained
 * @umplesource Generator_CodeUigu2.ump 13
 */
// line 13 "../../../../../src/Generator_CodeUigu2.ump"
public class Uigu2ElementGenerator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // STATIC VARIABLES
  //------------------------

  public static final String nl = System.getProperty("line.separator");

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Uigu2ElementGenerator()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={22},file={"Generator_CodeUigu2.ump"},javaline={53},length={43})
  @umplesourcefile(line={23},file={"Generator_CodeUigu2.ump"},javaline={54},length={20})
  public String getCode(UmpleModel model, UmpleElement uElement) {
    StringBuilder code = new StringBuilder();
    String name = uElement.getName();
    String elementKind = null;

    code.append("$ELEMENTS['").append(name).append("']['name'] = '");
    code.append(name).append("';").append(nl);

    if(uElement instanceof UmpleClass){
      elementKind = "Class";
      this.appendAttributesCode(code, (UmpleClass)uElement);
    }else if(uElement instanceof UmpleInterface){
      elementKind = "Interface";
    }
    
    code.append("$ELEMENTS['").append(name).append("']['element_kind'] = '");
    code.append(elementKind).append("';").append(nl);
    code.append(nl);
    return code.toString();
  }

  /**
   * Adds to the StringBuilder being built php code that deals with attributes.
   */
  @umplesourcefile(line={47},file={"Generator_CodeUigu2.ump"},javaline={79},length={18})
  private void appendAttributesCode(StringBuilder code, UmpleClass uClass) {
    List<Attribute> attributes = uClass.getAttributes();
    Attribute att;
    code.append("$attributes = array();").append(nl);    
    for (int i = 0, size = attributes.size(); i < size; i++) {
      att = attributes.get(i);
      //deal with default value "null" and double quotes inside String
      String value = att.getValue() == null? "" : att.getValue();
      if(value.indexOf("\"") == 0){
        value = value.replaceAll("\"", "");
      }
      code.append("$attributes[" + i +"]['name'] = '" + att.getName() + "';").append(nl);
      code.append("$attributes[" + i +"]['type'] = '" + att.getType() + "';").append(nl);
      code.append("$attributes[" + i +"]['value'] = '" + value + "';").append(nl);
    }
    code.append("$ELEMENTS['").append(uClass.getName()).append("']['attributes'] = $attributes;");
    code.append(nl);
  }

}