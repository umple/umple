/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.util.*;
import cruise.umple.util.*;

/**
 * @umplesource Generator.ump 36
 * @umplesource Generator_SuperCodeGenerator.ump 1
 */
// line 36 "../../../../src/Generator.ump"
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
  @umplesourcefile(line={16},file={"Generator_SuperCodeGenerator.ump"},javaline={78},length={3})
   public void generate(){
    
  }

  @umplesourcefile(line={18},file={"Generator_SuperCodeGenerator.ump"},javaline={86},length={3})
   public abstract void initializeLangaugeBasedVariables();
  @umplesourcefile(line={21},file={"Generator_SuperCodeGenerator.ump"},javaline={90},length={15})
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

  @umplesourcefile(line={38},file={"Generator_SuperCodeGenerator.ump"},javaline={106},length={10})
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

  @umplesourcefile(line={49},file={"Generator_SuperCodeGenerator.ump"},javaline={118},length={128})
   public String translate(String format, Constraint constraint){
    if(constraint==null)
      return "{0}";
    String expression = "";
    boolean insertNext = false;
    boolean strictNext = format.contains("$strict$");
    boolean plain = format.contains("Plain");
    int mode = format.contains("allParameterOne")?0:format.contains("$constructor$")?1:2;
    List<String> names = Arrays.asList(format.split(":")[0].split(","));
    String previousName = "";
    for(int i=0;i<constraint.numberOfExpressions();i++)
    {      
      ConstraintVariable expr = constraint.getExpression(i);
      if( expr.getType().equals("NAME"))
      {
        if(insertNext)
        {
          String name = //(!plain?ConstraintLookupMap.get("accessor"):"")+
        		                      translate(format+":Plain"+(strictNext?"$strict$":""),expr.getSubConstraint());
          expression = StringFormatter.format(expression,name,previousName);
          previousName = name;
          insertNext = false;
        }
        else
        {
          String name = //(!plain?ConstraintLookupMap.get("accessor"):"")+
        		                      translate(format+":Plain"+(strictNext?"$strict$":""),expr.getSubConstraint());
          expression+=name;
          previousName = name;
        }
      }
      else if( expr.getIsAttribute() )
      {
        String value;
        if(mode==0&&!strictNext)
        {
          value = (ConstraintLookupMap.get("paramaccessor"))+getParameterFromConstraint(expr,plain);
        }
        else if(mode==2&&names.contains(expr.getValue())&&!strictNext)
        {
          value = (ConstraintLookupMap.get("paramaccessor"))+getParameterFromConstraint(expr,plain);
        }
        else if(mode==1&&!strictNext)
        {
          if(expr.getFoundAttribute()!=null&&(expr.getFoundAttribute().getValue()==null||"".equals(expr.getFoundAttribute().getValue())))
          {
            value = (ConstraintLookupMap.get("paramaccessor"))+getParameterFromConstraint(expr,plain);
          }
          else
          {
            value = (ConstraintLookupMap.get("accessor"))+expr.getValue();
          }
        }
        else 
        {
          value = (!strictNext?ConstraintLookupMap.get("accessor"):"")+expr.getValue();
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

  @umplesourcefile(line={179},file={"Generator_SuperCodeGenerator.ump"},javaline={248},length={23})
   public String getParameterFromConstraint(ConstraintVariable expr, Boolean plain){
    if(expr.getFoundAttribute()==null)
    {
      return expr.getValue();
    }
    String value = "";
    if(!expr.getIsAssociation())
    {
      value = translate("parameterOne",(Attribute)expr.getFoundAttribute());
    }
    else 
    {
      if(expr.getIndex()==-1 )
      {
         value = translate("associationMany",(AssociationVariable)expr.getFoundAttribute());
      }
      else {
        value = translate("associationMany",(AssociationVariable)expr.getFoundAttribute());
        value = StringFormatter.format(ConstraintLookupMap.get("[]"),""+expr.getIndex(), value);
      }
    }
    return value;
  }

  @umplesourcefile(line={204},file={"Generator_SuperCodeGenerator.ump"},javaline={273},length={80})
   public void prepareConstraints(UmpleClass aClass){
    Constraint constraint = new Constraint();
    constraint.setNegated(true);
    constraint.setFormat("$constructor$Closed");
    constraint.setInject("");
    constraint.setGen(this);
    for (Constraint ac : aClass.getConstraints())
    {      
      List<ConstraintVariable> alreadyDone = new ArrayList<ConstraintVariable>();
      boolean isAssociation = false;
      CodeInjection before;
      for (ConstraintVariable cur : ac.getExpressions())
      {
        if(cur.getIsAssociation())
          isAssociation = true;
        if(!cur.getIsAttribute()  || alreadyDone.contains(cur))
          continue;
        if(cur.getSubConstraint()!=null&&cur.getSubConstraint().getExpression(0).getValue().equals("initialise"))
          continue;
        alreadyDone.add(cur);
        
        String setMethod_code = StringFormatter.format(translate(cur.getValue()+":Open",ac),"");
        
        if(cur.getIsAssociation())
        {
          before = new CodeInjection("before", cur.getFoundAttribute()==null?("set"+cur.getValue()):translate("setMethod", (AssociationVariable)cur.getFoundAttribute()), setMethod_code, aClass);         
          CodeInjection after = new CodeInjection("after", cur.getFoundAttribute()==null?("set"+cur.getValue()):translate("setMethod",(AssociationVariable)cur.getFoundAttribute()), ConstraintLookupMap.get("end"), aClass);
          before.setIsInternal(true);
          after.setIsInternal(true);
          aClass.addCodeInjection(before);
          aClass.addCodeInjection(after);
          before = new CodeInjection("before", cur.getFoundAttribute()==null?("add"+cur.getValue()):translate("addMethod",(AssociationVariable)cur.getFoundAttribute()), setMethod_code, aClass);         
          after = new CodeInjection("after", cur.getFoundAttribute()==null?("add"+cur.getValue()):translate("addMethod",(AssociationVariable)cur.getFoundAttribute()), ConstraintLookupMap.get("end"), aClass);
          before.setIsInternal(true);
          after.setIsInternal(true);
          aClass.addCodeInjection(before);
          aClass.addCodeInjection(after);
        }
        else {
          before = new CodeInjection("before", cur.getFoundAttribute()==null?("set"+cur.getValue()):translate("setMethod", (Attribute)cur.getFoundAttribute()), setMethod_code, aClass);         
          CodeInjection after = new CodeInjection("after", cur.getFoundAttribute()==null?("set"+cur.getValue()):translate("setMethod",(Attribute)cur.getFoundAttribute()), ConstraintLookupMap.get("end"), aClass);
          before.setIsInternal(true);
          after.setIsInternal(true);
          aClass.addCodeInjection(before);
          aClass.addCodeInjection(after);
        }
      }
      constraint.mergeWith(ac);
      constraint.setInject(constraint.getInject()+" "+ac.toString());
    }
    if(constraint.numberOfExpressions()>0)
    {
      constraint.setInject(StringFormatter.format(ConstraintLookupMap.get("exception"),constraint.getInject()));
      CodeInjection constructor = new CodeInjection("after",  "constructor", constraint, aClass);  
      constructor.setIsInternal(true);
      aClass.addCodeInjection(constructor);
    }
    
   for (Precondition pc : aClass.getPreconditions()){ 
     String methodName = pc.getMethod().getName();
     pc.setNegated(true);
     pc.setGen(this);
     pc.setFormat(pc.toString().replace(" ", "").replace("and", "")+":Closed");
     pc.setInject(StringFormatter.format(ConstraintLookupMap.get("exception")," "+pc.toString()));
     CodeInjection before = new CodeInjection("before", methodName+"Precondition", pc, aClass);         
     before.setIsInternal(true);
     aClass.addCodeInjection(before);    
    }
    
    for (Postcondition pc : aClass.getPostconditions()){ 
     String methodName = pc.getMethod().getName();
     pc.setNegated(true);
     pc.setGen(this);
     pc.setFormat(pc.toString().replace(" ", "").replace("and", "")+":Closed");
     pc.setInject(StringFormatter.format(ConstraintLookupMap.get("exception")," "+pc.toString()));
     CodeInjection before = new CodeInjection("before", methodName+"Postcondition", pc, aClass);         
     before.setIsInternal(true);
     aClass.addCodeInjection(before);    
    }
  }

  @umplesourcefile(line={27},file={"Generator.ump"},javaline={354},length={2})
  @Override
  public String translate(String id, Attribute attribute){
          return "";
  }

  @umplesourcefile(line={28},file={"Generator.ump"},javaline={360},length={2})
  @Override
  public String translate(String id, StateMachine stm){
          return "";
  }

  @umplesourcefile(line={29},file={"Generator.ump"},javaline={366},length={2})
  @Override
  public String translate(String id, Event e){
          return "";
  }

  @umplesourcefile(line={30},file={"Generator.ump"},javaline={372},length={2})
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
  //  @umplesourcefile(line={8},file={"Generator_SuperCodeGenerator.ump"},javaline={390},length={8})
  @umplesourcefile(line={9},file={"Generator_SuperCodeGenerator.ump"},javaline={391},length={7})
  protected Map<String,String> UmpleToPrimitiveMap = new HashMap<String,String>() ;

//  @umplesourcefile(line={9},file={"Generator_SuperCodeGenerator.ump"},javaline={394},length={5})
  @umplesourcefile(line={10},file={"Generator_SuperCodeGenerator.ump"},javaline={395},length={4})
  protected Map<String,String> TraceLookupMap = new HashMap<String,String>() ;

//  @umplesourcefile(line={10},file={"Generator_SuperCodeGenerator.ump"},javaline={398},length={2})
  @umplesourcefile(line={11},file={"Generator_SuperCodeGenerator.ump"},javaline={399},length={1})
  protected Map<String,String> ConstraintLookupMap = new HashMap<String,String>() ;

  
}