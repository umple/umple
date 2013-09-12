/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler.uigu2;
import java.util.*;
import cruise.umple.compiler.*;
import cruise.umple.compiler.exceptions.*;

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


  /**
   * 
   * Returns the generated code specific to an UmpleElement.
   */
  @umplesourcefile(line={24},file={"Generator_CodeUigu2.ump"},javaline={44},length={34})
   public String getCode(UmpleModel model, UmpleElement uElement){
    StringBuilder code = new StringBuilder();
    String name = uElement.getName();
    String elementKind = null;

    //keys of $ELEMENTS are already the names, but this may be needed
    this.appendToElementsArray(code,name,"name","'"+name+"'");

    if(uElement instanceof UmpleClass){
      UmpleClass aClass = (UmpleClass)uElement;
      String className = aClass.getName();
      
      //TODO
      UmpleClass parentClass = aClass.getExtendsClass();
      if(parentClass != null){
        throw new UmpleCompilerException("Support for Inherited Classes is currently under development.",
          new UnsupportedOperationException());
      }

      elementKind = "Class";
      code.append("$constructor = array();").append(nl);
      this.appendAttributesCode(code, aClass);
      this.appendAssociationsCode(code, aClass);
      this.appendToElementsArray(code, className, "constructor", "$constructor");

      if(aClass.getIsAbstract()){
        this.appendToElementsArray(code, className, "abstract", "1");
      }
    }else if(uElement instanceof UmpleInterface){
      elementKind = "Interface";
    }
    this.appendToElementsArray(code,name,"element_kind","'"+elementKind+"'");
    return code.toString();
  }

  @umplesourcefile(line={59},file={"Generator_CodeUigu2.ump"},javaline={85},length={26})
   private void appendAttributesCode(StringBuilder code, UmpleClass uClass){
    List<Attribute> attributes = uClass.getAttributes();
    code.append("$attributes = array();").append(nl);
    String name, value, type;
    for (Attribute att : attributes){
      name = att.getName();
      value = att.getValue();
      type = att.getType();
      code.append("$a_attribute = array();").append(nl);
      code.append("$a_attribute['name'] = '" + name + "';").append(nl);
      code.append("$a_attribute['type'] = '" + type + "';").append(nl);
      if(value != null){
        value = value.replaceAll("\"", "");
        code.append("$a_attribute['value'] = '" + value + "';").append(nl);
      }
      if(att.getIsLazy()){
        code.append("$a_attribute['lazy'] = " + 1 + ";").append(nl);
        code.append("$attributes['" + name + "'] = $a_attribute;").append(nl);
      }else{
        code.append("$attributes['" + name + "'] = $a_attribute;").append(nl);
        //attribute must be initialized in constructor
        code.append("$constructor[] =& $attributes['" + name + "'];").append(nl);
      }
    }
    this.appendToElementsArray(code,uClass.getName(),"attributes","$attributes");
  }

  @umplesourcefile(line={86},file={"Generator_CodeUigu2.ump"},javaline={113},length={4})
   private void appendAssociationsCode(StringBuilder code, UmpleClass uClass){
    Association[] associations = uClass.getAssociations();
    //TODO: iterate Associations, add to $associations within $ELEMENTS, add to $constructor
  }


  /**
   * 
   * appends code that adds to the $ELEMENTS php array (where information about UmpleElements are passed to
   * UIGU) the specified key and value, ie. "$ELEMENTS[elementName][key] = value;"
   */
  @umplesourcefile(line={95},file={"Generator_CodeUigu2.ump"},javaline={119},length={4})
   private void appendToElementsArray(StringBuilder code, String elementName, String key, String value){
    code.append("$ELEMENTS['").append(elementName).append("']['").append(key).append("']");
    code.append(" = ").append(value).append(";").append(nl);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]"
     + outputString;
  }
}