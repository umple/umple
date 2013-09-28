/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.util.*;
import cruise.umple.util.*;

/**
 * @umplesource Generator.ump 37
 * @umplesource Generator_SuperCodeGenerator.ump 1
 */
// line 37 "../../../../src/Generator.ump"
// line 1 "../../../../src/Generator_SuperCodeGenerator.ump"
public abstract class SuperCodeGenerator implements CodeGenerator,CodeTranslator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SuperCodeGenerator Attributes
  private UmpleModel model;
  private String output;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  @umplesourcefile(line={2},file={"Generator_SuperCodeGenerator.ump"},javaline={37},length={4})
  public SuperCodeGenerator()
  {
    model = null;
    output = "";
    // line 2 "../../../../src/Generator_SuperCodeGenerator.ump"
    UmpleToPrimitiveMap = new HashMap<String, String>();
        TraceLookupMap = new HashMap<String,String>();	
        ConstraintLookupMap = new HashMap<String,String>();
        initializeLangaugeBasedVariables();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setModel(UmpleModel aModel)
  {
    boolean wasSet = false;
    model = aModel;
    wasSet = true;
    return wasSet;
  }

  public boolean setOutput(String aOutput)
  {
    boolean wasSet = false;
    output = aOutput;
    wasSet = true;
    return wasSet;
  }

  public UmpleModel getModel()
  {
    return model;
  }

  public String getOutput()
  {
    return output;
  }

  public void delete()
  {}


  /**
   * This method is because of issue number 373;
   */
  @umplesourcefile(line={14},file={"Generator_SuperCodeGenerator.ump"},javaline={77},length={3})
   public void generate(){
    
  }

  @umplesourcefile(line={18},file={"Generator_SuperCodeGenerator.ump"},javaline={86},length={3})
   public abstract void initializeLangaugeBasedVariables();
  @umplesourcefile(line={20},file={"Generator_SuperCodeGenerator.ump"},javaline={89},length={15})
   public String getType(UmpleVariable av){
    String myType = av.getType();
    if (myType == null || myType.length() == 0)
    {
      return UmpleToPrimitiveMap.get("String");
    }
    else if (UmpleToPrimitiveMap.containsKey(myType))
    {
      return UmpleToPrimitiveMap.get(myType);
    }
    else
    {
      return myType;
   	}
  }

  @umplesourcefile(line={36},file={"Generator_SuperCodeGenerator.ump"},javaline={105},length={10})
   public String translate(String keyName, TraceItem ti){
    if (keyName.length()>5&&"trace".equals(keyName.substring(0,5)))
	{
	  return TraceLookupMap.get(keyName.substring(5).toLowerCase());
    }
    else 
    {
      return "INVALID KEYNAME IN TRANSLATE";
    }
  }

  @umplesourcefile(line={48},file={"Generator_SuperCodeGenerator.ump"},javaline={117},length={149})
   public String translate(String format, Constraint constraint){
    if(constraint==null)
      return "{0}";
    String expression = "";
    boolean insertNext = false;
    boolean strictNext = false;
    boolean plain = format.contains("Plain");
    String previousName = "";
    for(int i=0;i<constraint.numberOfExpressions();i++)
    {      
      ConstraintVariable expr = constraint.getExpression(i);
      if( expr.getType().equals("NAME"))
      {
        if(insertNext)
        {
          String name = (!plain?ConstraintLookupMap.get("accessor"):"")+
        		                      translate(format+":Plain",expr.getSubConstraint());
          expression = StringFormatter.format(expression,name,previousName);
          previousName = name;
          insertNext = false;
        }
        else
        {
          String name = (!plain?ConstraintLookupMap.get("accessor"):"")+
        		                      translate(format+":Plain",expr.getSubConstraint());
          expression+=name;
          previousName = name;
        }
      }
      else if( expr.getIsAttribute() )
      {
        String value;
        if(format.contains("allParameterOne")&&!strictNext)
        {
          if(!expr.getIsAssociation())
          {
             value = (!plain?ConstraintLookupMap.get("accessor"):"")+
                     (expr.getFoundAttribute()==null?expr.getValue():translate("parameterOne",(Attribute)expr.getFoundAttribute()));
          }
          else 
          {
            if(expr.getIndex()==-1)
            {
              value = (!plain?ConstraintLookupMap.get("accessor"):"")+
                      (expr.getFoundAttribute()==null?expr.getValue():translate("associationMany",(AssociationVariable)expr.getFoundAttribute()));
            }
            else {
              value = (!plain?ConstraintLookupMap.get("accessor"):"")+
                      (expr.getFoundAttribute()==null?expr.getValue():translate("associationMany",(AssociationVariable)expr.getFoundAttribute())); 
              value = StringFormatter.format(ConstraintLookupMap.get("[]"),""+expr.getIndex(), value);
            }
          }
        }
        else if(Arrays.asList(format.split(":")[0].split(",")).contains(expr.getValue())&&!strictNext)
        {
          if(!expr.getIsAssociation())
          {
             value = (!plain?ConstraintLookupMap.get("accessor"):"")+
                     (expr.getFoundAttribute()==null?expr.getValue():translate("parameterOne",(Attribute)expr.getFoundAttribute()));
          }
          else 
          {
            if(expr.getIndex()==-1 )
            {
              value = (!plain?ConstraintLookupMap.get("accessor"):"")+
                      (expr.getFoundAttribute()==null?expr.getValue():translate("associationMany",(AssociationVariable)expr.getFoundAttribute()));
            }
            else {
              value = (!plain?ConstraintLookupMap.get("accessor"):"")+
                      (expr.getFoundAttribute()==null?expr.getValue():translate("associationMany",(AssociationVariable)expr.getFoundAttribute()));
              value = StringFormatter.format(ConstraintLookupMap.get("[]"),""+expr.getIndex(), value);
            }
          }
        }
        else 
        {
          value = (!plain?ConstraintLookupMap.get("accessor"):"")+expr.getValue();
          strictNext=false;
        }
        if(insertNext){
          expression = StringFormatter.format(expression,value,previousName);
          insertNext = false;
        }
        else {
          expression += value;
        }
      } 
      else // STATIC OR OPERATOR
      { 
        if(expr.getValue().equals("."))
        {
          strictNext=true;
        }
        if(expr.getIsOperator()) //Operator
        {
          String opValue = expr.getValue();
          if(!expr.getIsPrimitive()&&ConstraintLookupMap.containsKey(opValue))
          {
            if(insertNext)
            {
              expression = StringFormatter.format(expression,ConstraintLookupMap.get(opValue));
              insertNext = true;
            }
            else 
            {
              expression += ConstraintLookupMap.get(opValue);
              insertNext = true;
            }
          }
          else //Static
          {
			if(insertNext)
            {
              expression = StringFormatter.format(expression,opValue,previousName);
              insertNext = false;
            }
            else 
            {
              expression += opValue;
            }
          }
        }
        else if(insertNext){
          expression = StringFormatter.format(expression,expr.getValue());
          insertNext = false;
        }
        else {
          expression += expr.getValue();
        }
      }
    }
    if(plain)
    {
      return expression;
    }
    else if(format.contains("Not"))
    {
      expression = " !("+expression+")";
    }
    if(format.contains("Closed"))
    {
      return StringFormatter.format(ConstraintLookupMap.get("ifstatement")+"\n  {1}\n"+ConstraintLookupMap.get("end"),expression, "{0}");
    }
    else if(format.contains("Open"))
    {
      return StringFormatter.format(ConstraintLookupMap.get("ifstatement"),expression, "{0}");
    }
    return StringFormatter.format(ConstraintLookupMap.get("ifstatement")+"\n  {1}\n"+ConstraintLookupMap.get("end"),expression, "{0}");
  }

  @umplesourcefile(line={27},file={"Generator.ump"},javaline={268},length={2})
  @Override
  public String translate(String id, Attribute attribute){
          return "";
  }

  @umplesourcefile(line={28},file={"Generator.ump"},javaline={274},length={2})
  @Override
  public String translate(String id, StateMachine stm){
          return "";
  }

  @umplesourcefile(line={29},file={"Generator.ump"},javaline={280},length={2})
  @Override
  public String translate(String id, Event e){
          return "";
  }

  @umplesourcefile(line={30},file={"Generator.ump"},javaline={286},length={2})
  @Override
  public String translate(String id, AssociationVariable aVar){
          return "";
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "output" + ":" + getOutput()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "model" + "=" + (getModel() != null ? !getModel().equals(this)  ? getModel().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={8},file={"Generator_SuperCodeGenerator.ump"},javaline={304},length={8})
  Map <String,String> UmpleToPrimitiveMap ;

//  @umplesourcefile(line={9},file={"Generator_SuperCodeGenerator.ump"},javaline={307},length={5})
  Map <String,String> TraceLookupMap ;

//  @umplesourcefile(line={10},file={"Generator_SuperCodeGenerator.ump"},javaline={310},length={2})
  Map <String,String> ConstraintLookupMap ;

}