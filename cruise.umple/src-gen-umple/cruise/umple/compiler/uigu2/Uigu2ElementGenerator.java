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
  @umplesourcefile(line={24},file={"Generator_CodeUigu2.ump"},javaline={44},length={35})
   public String getCode(UmpleModel model, UmpleElement uElement){
    StringBuilder code = new StringBuilder();
    String name = uElement.getName();
    String elementKind = null;

    //keys of $ELEMENTS are already the names, but this may be needed
    this.appendToElementsArray(code,name,"name","'"+name+"'");

    if(uElement instanceof UmpleClass){
      UmpleClass aClass = (UmpleClass)uElement;
      
      //TODO
      Association[] associations = aClass.getAssociations();
      if(associations.length > 0){
        throw new UmpleCompilerException("Support for Associations is currently under development.",
          new UnsupportedOperationException());
      }
      //TODO
      UmpleClass parentClass = aClass.getExtendsClass();
      if(parentClass != null){
        throw new UmpleCompilerException("Support for Inherited Classes is currently under development.",
          new UnsupportedOperationException());
      }

      elementKind = "Class";
      this.appendAttributesCode(code, aClass);
      if(aClass.getIsAbstract()){
        this.appendToElementsArray(code,aClass.getName(),"abstract","1");
      }
    }else if(uElement instanceof UmpleInterface){
      elementKind = "Interface";
    }
    this.appendToElementsArray(code,name,"element_kind","'"+elementKind+"'");
    return code.toString();
  }


  /**
   * 
   * Adds to the $ELEMENTS php array (where information about UmpleElements are passed to
   * UIGU) the specified key and value, ie. "$ELEMENTS[elementName][key] = value;"
   */
  @umplesourcefile(line={64},file={"Generator_CodeUigu2.ump"},javaline={86},length={4})
   private void appendToElementsArray(StringBuilder code, String elementName, String key, String value){
    code.append("$ELEMENTS['").append(elementName).append("']['").append(key).append("']");
    code.append(" = ").append(value).append(";").append(nl);
  }


  /**
   * 
   * Adds to the StringBuilder being built php code that deals with attributes.
   */
  @umplesourcefile(line={72},file={"Generator_CodeUigu2.ump"},javaline={98},length={22})
   private void appendAttributesCode(StringBuilder code, UmpleClass uClass){
    List<Attribute> attributes = uClass.getAttributes();
    Attribute att;
    code.append("$attributes = array();").append(nl);    
    for (int i = 0, size = attributes.size(); i < size; i++) {
      att = attributes.get(i);
      code.append("$attributes[" + i +"]['name'] = '" + att.getName() + "';").append(nl);
      code.append("$attributes[" + i +"]['type'] = '" + att.getType() + "';").append(nl);
      String value = att.getValue();
      if(value != null){
        value = value.replaceAll("\"", "");
        code.append("$attributes[" + i +"]['value'] = '" + value + "';").append(nl);
      }
      if(att.getIsLazy()){
        code.append("$attributes[" + i +"]['lazy'] = '" + 1 + "';").append(nl);
      }else{
        //attribute must be initialized in constructor
        code.append("$attributes[" + i +"]['constructor_param'] = '" + 1 + "';").append(nl);
      }
    }
    this.appendToElementsArray(code,uClass.getName(),"attributes","$attributes");
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]"
     + outputString;
  }
}