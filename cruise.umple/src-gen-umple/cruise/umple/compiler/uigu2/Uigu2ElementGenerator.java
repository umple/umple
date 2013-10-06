/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

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
  @umplesourcefile(line={24},file={"Generator_CodeUigu2.ump"},javaline={44},length={31})
   public String getCode(UmpleModel model, UmpleElement uElement){
    StringBuilder code = new StringBuilder();
    String name = uElement.getName();
    String elementKind = null;

    code.append("//Generated code for Umple Element " + name).append(nl);
    code.append("$ELEMENTS['" + name + "']['name'] = '"+name+"';").append(nl);

    if(uElement instanceof UmpleClass){
      elementKind = "Class";
      UmpleClass aClass = (UmpleClass) uElement;
      String className = aClass.getName();
      
      UmpleClass parentClass = aClass.getExtendsClass();
      if(parentClass != null){
        throw new UmpleCompilerException("Support for Inherited Classes is currently under development.",
          new UnsupportedOperationException());
      }
      this.appendAttributesCode(code, aClass);
      this.appendAssociationsCode(code, aClass);
      this.appendConstructorCode(code, aClass);

      if(aClass.getIsAbstract()){
        code.append("$ELEMENTS['" + name + "']['abstract'] = 1;").append(nl);
      }
    }else if(uElement instanceof UmpleInterface){
      elementKind = "Interface";
    }
    code.append("$ELEMENTS['" + name + "']['element_kind'] = '" + elementKind + "';").append(nl);
    return code.toString();
  }

  @umplesourcefile(line={56},file={"Generator_CodeUigu2.ump"},javaline={82},length={19})
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
      code.append("$attributes['" + name + "'] = $a_attribute;").append(nl);
    }
    code.append("$ELEMENTS['" + uClass.getName() + "']['attributes'] = $attributes;").append(nl);
  }

  @umplesourcefile(line={76},file={"Generator_CodeUigu2.ump"},javaline={103},length={14})
   private void appendAssociationsCode(StringBuilder code, UmpleClass uClass){
    String className = uClass.getName();
    List<AssociationVariable> avs = uClass.getAssociationVariables();
    code.append("$associations = array();").append(nl);
    for(AssociationVariable av : avs){
      String name = av.getName();
      String type = av.getType();
      code.append("$a_association = array();").append(nl);
      code.append("$a_association['name'] = '" + name + "';").append(nl);
      code.append("$a_association['type'] = '" + type + "';").append(nl);
      code.append("$associations['" + name + "'] = $a_association;").append(nl);
    }
    code.append("$ELEMENTS['" + className + "']['associations'] = $associations;").append(nl);
  }

  @umplesourcefile(line={91},file={"Generator_CodeUigu2.ump"},javaline={119},length={25})
   private void appendConstructorCode(StringBuilder code, UmpleClass uClass){
    String className = uClass.getName();
    code.append("$constructor = array();").append(nl);
    GeneratedClass gc = uClass.getGeneratedClass();
    String constructorSignature = gc.getLookup("constructorSignature");
    String[] constructorParams = constructorSignature.split(", ");
    for(int i = 0; i < constructorParams.length; i++){
      //"$aAttributeName" => "attributeName"
      String param = constructorParams[i];
      param = Character.toLowerCase(param.charAt(2)) + param.substring(3); 

      //TODO: call recursively in case of being a subclass
      Attribute att = uClass.getAttribute(param);
      if(att != null){
        code.append("$constructor[] =& $ELEMENTS['" + className + "']['attributes']['" + att.getName() + "'];").append(nl);
      }else {
        //TODO: call recursively in case of being a subclass
        AssociationVariable av = uClass.getAssociationVariable(param);
        if(av != null){
          code.append("$constructor[] =& $ELEMENTS['" + className + "']['associations']['" + av.getName() + "'];").append(nl);
        }
      }
    }
    code.append("$ELEMENTS['" + className + "']['constructor'] = $constructor;").append(nl);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]"
     + outputString;
  }
}