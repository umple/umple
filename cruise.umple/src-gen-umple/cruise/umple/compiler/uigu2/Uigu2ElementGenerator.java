/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler.uigu2;
import java.util.*;
import cruise.umple.compiler.*;
import cruise.umple.compiler.exceptions.*;
import java.util.*;

/**
 * @umplesource Generator_CodeUigu2.ump 147
 */
// line 147 "../../../../../src/Generator_CodeUigu2.ump"
public class Uigu2ElementGenerator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // STATIC VARIABLES
  //------------------------

  public static final String NL = System.getProperty("line.separator");

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Uigu2ElementGenerator Attributes

  /**
   * keeps track of elements whose codes have already been generated
   */
  private List<UmpleElement> generatedElements;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Uigu2ElementGenerator()
  {
    generatedElements = new ArrayList<UmpleElement>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}


  /**
   * 
   * Returns the generated code specific to an UmpleElement.
   */
  @umplesourcefile(line={163},file={"Generator_CodeUigu2.ump"},javaline={54},length={34})
   public String getCode(UmpleModel model, UmpleElement uElement){
    if(this.generatedElements.contains(uElement)){
      return "";
    }
    StringBuilder code = new StringBuilder();
    String name = uElement.getName();

    if(uElement instanceof UmpleClass){
      UmpleClass aClass = (UmpleClass) uElement;
      code.append("$ELEMENTS['" + name + "']['name'] = '"+name+"';").append(NL);
      code.append("$ELEMENTS['" + name + "']['element_kind'] = 'Class';").append(NL);

      if(aClass.getIsAbstract()){
        code.append("$ELEMENTS['" + name + "']['abstract'] = 1;").append(NL);
      }
      this.appendAttributesCode(code, aClass);
      this.appendAssociationsCode(code, aClass);
      this.appendConstructorCode(code, aClass);
      this.generatedElements.add(uElement);

      if(aClass.isRoot()){
        return code.toString();

      //Use recursion to make sure classes with dependencies are generated last
      }else {
        UmpleClass parent = aClass.getExtendsClass();
        code.append("$ELEMENTS['" + name + "']['parent'] = '" + parent.getName() + "';").append(NL);
        return this.getCode(model, parent) + code.toString();
      }
    //TODO else if(uElement instanceof UmpleInterface){
    }else {
      return "";
    }
  }

  @umplesourcefile(line={198},file={"Generator_CodeUigu2.ump"},javaline={95},length={21})
   private void appendAttributesCode(StringBuilder code, UmpleClass uClass){
    List<Attribute> attributes = this.getAttributesSuperClasses(uClass);
    code.append("$attributes = array();").append(NL);
    if(attributes.size() > 0){
      String name, value, type;
      for (Attribute att : attributes){
        name = att.getName();
        value = att.getValue();
        type = att.getType();
        code.append("$a_attribute = array();").append(NL);
        code.append("$a_attribute['name'] = '" + name + "';").append(NL);
        code.append("$a_attribute['type'] = '" + type + "';").append(NL);
        if(value != null){
          value = value.replaceAll("\"", "");
          code.append("$a_attribute['value'] = '" + value + "';").append(NL);
        }
        code.append("$attributes['" + name + "'] = $a_attribute;").append(NL);
      }
    }
    code.append("$ELEMENTS['" + uClass.getName() + "']['attributes'] = $attributes;").append(NL);
  }

  @umplesourcefile(line={220},file={"Generator_CodeUigu2.ump"},javaline={118},length={16})
   private void appendAssociationsCode(StringBuilder code, UmpleClass uClass){
    String className = uClass.getName();
    List<AssociationVariable> avs = this.getAssociationsSuperClasses(uClass);
    code.append("$associations = array();").append(NL);
    if(avs.size() > 0){
      for(AssociationVariable av : avs){
        String name = av.getName();
        String type = av.getType();
        code.append("$a_association = array();").append(NL);
        code.append("$a_association['name'] = '" + name + "';").append(NL);
        code.append("$a_association['type'] = '" + type + "';").append(NL);
        code.append("$associations['" + name + "'] = $a_association;").append(NL);
      }
    }
    code.append("$ELEMENTS['" + className + "']['associations'] = $associations;").append(NL);
  }

  @umplesourcefile(line={237},file={"Generator_CodeUigu2.ump"},javaline={136},length={17})
   private void appendConstructorCode(StringBuilder code, UmpleClass uClass){
    String className = uClass.getName();
    GeneratedClass gc = uClass.getGeneratedClass();
    String constructorSignature = gc.getLookup("constructorSignature");
    code.append("$constructor_params = array();").append(NL);

    if(!"".equals(constructorSignature)){
      String[] constructorParams = constructorSignature.split(", ");
      for(int i = 0; i < constructorParams.length; i++){
        //"$aAttributeName" => "attributeName"
        String param = constructorParams[i];
        param = Character.toLowerCase(param.charAt(2)) + param.substring(3); 
        code.append("$constructor_params[] = '" + param + "';").append(NL);
      }
    }
    code.append("$ELEMENTS['" + className + "']['constructor_params'] = $constructor_params;").append(NL);
  }


  /**
   * Returns attributes from uClass and from all the classes above it in the inheritance hierarchy.
   * eg. if A is subclass of B, and B is subclass of C. Calling the method for A will return all
   * the attributes of A, B and C
   */
  @umplesourcefile(line={260},file={"Generator_CodeUigu2.ump"},javaline={155},length={9})
   private List<Attribute> getAttributesSuperClasses(UmpleClass uClass){
    List<Attribute> attributes = new ArrayList<Attribute>();
    attributes.addAll(uClass.getAttributes());
    if(!uClass.isRoot()){
      UmpleClass parent = uClass.getExtendsClass();
      attributes.addAll(this.getAttributesSuperClasses(parent));
    }
    return attributes;
  }

  @umplesourcefile(line={270},file={"Generator_CodeUigu2.ump"},javaline={172},length={9})
   private List<AssociationVariable> getAssociationsSuperClasses(UmpleClass uClass){
    List<AssociationVariable> avs = new ArrayList<AssociationVariable>();
    avs.addAll(uClass.getAssociationVariables());
    if(!uClass.isRoot()){
      UmpleClass parent = uClass.getExtendsClass();
      avs.addAll(this.getAssociationsSuperClasses(parent));
    }
    return avs;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]"
     + outputString;
  }
}