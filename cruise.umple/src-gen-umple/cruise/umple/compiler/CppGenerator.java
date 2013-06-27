/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.*;
import java.io.*;
import cruise.umple.util.*;
import cruise.umple.compiler.exceptions.*;
import cruise.umple.compiler.cpp.*;

/**
 * @umplesource Generator.ump 212
 * @umplesource Generator_CodeCpp.ump 12
 */
// line 212 "../../../../src/Generator.ump"
// line 12 "../../../../src/Generator_CodeCpp.ump"
public class CppGenerator implements CodeGenerator,CodeTranslator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CppGenerator Attributes
  private UmpleModel model;
  private String output;
  private boolean callHeader;
  private boolean callLttng;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CppGenerator()
  {
    model = null;
    output = "";
    callHeader = false;
    callLttng = false;
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

  public boolean setCallHeader(boolean aCallHeader)
  {
    boolean wasSet = false;
    callHeader = aCallHeader;
    wasSet = true;
    return wasSet;
  }

  public boolean setCallLttng(boolean aCallLttng)
  {
    boolean wasSet = false;
    callLttng = aCallLttng;
    wasSet = true;
    return wasSet;
  }

  /**
   * Contains various aspects from an Umple file (.ump), such as classes, attributes, associations and methods.  Generated output is based
   * off of what's contained in here.
   */
  public UmpleModel getModel()
  {
    return model;
  }

  public String getOutput()
  {
    return output;
  }

  public boolean getCallHeader()
  {
    return callHeader;
  }

  public boolean getCallLttng()
  {
    return callLttng;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "output" + ":" + getOutput()+ "," +
            "callHeader" + ":" + getCallHeader()+ "," +
            "callLttng" + ":" + getCallLttng()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "model" + "=" + (getModel() != null ? !getModel().equals(this)  ? getModel().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={15},file={"Generator_CodeCpp.ump"},javaline={123},length={1347})
  private static Map<String,String> UpperCaseSingularLookupMap;
  private static Map<String,String> UpperCasePluralLookupMap;
  private static Map<String,String> AsIsSingularLookupMap;
  private static Map<String,String> AsIsPluralLookupMap;
  private static Map<String,String> UmpleToJavaPrimitiveMap;
  private static Map<String,String> TraceLookupMap;
  private static List<String> OneOrManyLookup;
  
  static
  {
    UpperCaseSingularLookupMap = new HashMap<String, String>();
    UpperCaseSingularLookupMap.put("parameterOne", "a{0}");
    UpperCaseSingularLookupMap.put("removeParameterOne", "placeholder{0}");    
    UpperCaseSingularLookupMap.put("parameterNew", "new{0}");
    UpperCaseSingularLookupMap.put("parameterNext", "next{0}");
    UpperCaseSingularLookupMap.put("addMethod", "add{0}");
    UpperCaseSingularLookupMap.put("removeMethod", "remove{0}");
    UpperCaseSingularLookupMap.put("indexOfMethod", "indexOf{0}");
    UpperCaseSingularLookupMap.put("parameterOld", "old{0}");
    UpperCaseSingularLookupMap.put("parameterExisting", "existing{0}");
    UpperCaseSingularLookupMap.put("parameterIsNew", "isNew{0}");
    UpperCaseSingularLookupMap.put("associationNew", "new{0}");
    UpperCaseSingularLookupMap.put("canSetMethod", "canSet{0}");
    UpperCaseSingularLookupMap.put("parameterCurrent", "current{0}");
    UpperCaseSingularLookupMap.put("deleteMethod", "delete{0}");
    UpperCaseSingularLookupMap.put("setMethod", "set{0}");
    UpperCaseSingularLookupMap.put("enterMethod", "enter{0}");
    UpperCaseSingularLookupMap.put("exitMethod", "exit{0}");
    UpperCaseSingularLookupMap.put("resetMethod", "reset{0}");
    UpperCaseSingularLookupMap.put("getMethod", "get{0}");
    UpperCaseSingularLookupMap.put("getFullMethod", "get{0}FullName");
    UpperCaseSingularLookupMap.put("getStringMethod", "get{0}StringName");
    UpperCaseSingularLookupMap.put("isFinalMethod", "is{0}Final");    
    UpperCaseSingularLookupMap.put("getDefaultMethod", "getDefault{0}");
    UpperCaseSingularLookupMap.put("didAdd", "didAdd{0}");
    UpperCaseSingularLookupMap.put("hasMethod", "has{0}");
    UpperCaseSingularLookupMap.put("associationCanSetOne","canSet{0}");
    UpperCaseSingularLookupMap.put("attributeCanSetOne","canSet{0}");
    UpperCaseSingularLookupMap.put("eventStartMethod", "start{0}Handler");
    UpperCaseSingularLookupMap.put("eventStopMethod", "stop{0}Handler");    
    UpperCaseSingularLookupMap.put("stateNull", "Null");

    UpperCasePluralLookupMap = new HashMap<String, String>();
    UpperCasePluralLookupMap.put("parameterMany", "new{0}");
    UpperCasePluralLookupMap.put("parameterAll", "all{0}");
    UpperCasePluralLookupMap.put("numberOfMethod", "numberOf{0}");
    UpperCasePluralLookupMap.put("minimumNumberOfMethod", "minimumNumberOf{0}");
    UpperCasePluralLookupMap.put("maximumNumberOfMethod", "maximumNumberOf{0}");
    UpperCasePluralLookupMap.put("isNumberOfValidMethod", "isNumberOf{0}Valid");
    UpperCasePluralLookupMap.put("parameterVerifiedMany", "verified{0}");
    UpperCasePluralLookupMap.put("parameterOldMany", "old{0}");
    UpperCasePluralLookupMap.put("parameterCheckNewMany", "checkNew{0}");
    UpperCasePluralLookupMap.put("parameterCopyOfMany", "copyOf{0}");
    UpperCasePluralLookupMap.put("getManyMethod", "get{0}");
    UpperCasePluralLookupMap.put("parameterMany", "new{0}");
    UpperCasePluralLookupMap.put("setManyMethod", "set{0}");
    UpperCasePluralLookupMap.put("didAddMany", "didAdd{0}");
    UpperCasePluralLookupMap.put("hasManyMethod", "has{0}");
    UpperCasePluralLookupMap.put("associationCanSetMany","canSet{0}");
    UpperCasePluralLookupMap.put("attributeCanSetMany","canSet{0}");
    UpperCasePluralLookupMap.put("requiredNumberOfMethod", "requiredNumberOf{0}");

    AsIsSingularLookupMap = new HashMap<String, String>();
    AsIsSingularLookupMap.put("associationOne","{0}");
    AsIsSingularLookupMap.put("attributeOne","{0}");
    AsIsSingularLookupMap.put("stateMachineOne","{0}");
    AsIsSingularLookupMap.put("stateOne","{0}");
    AsIsSingularLookupMap.put("stateString","\"{0}\"");
    AsIsSingularLookupMap.put("eventMethod","{0}");
    AsIsSingularLookupMap.put("eventHandler", "{0}Handler");
        
    AsIsPluralLookupMap = new HashMap<String, String>();
    AsIsPluralLookupMap.put("associationMany","{0}");
    AsIsPluralLookupMap.put("attributeMany","{0}");
    
    OneOrManyLookup = new ArrayList<String>();
    OneOrManyLookup.add("attribute");
    OneOrManyLookup.add("parameter");
    
    UmpleToJavaPrimitiveMap = new HashMap<String, String>();
    UmpleToJavaPrimitiveMap.put("Integer","int");
    UmpleToJavaPrimitiveMap.put("Boolean","bool");
    UmpleToJavaPrimitiveMap.put("Double","double");
    UmpleToJavaPrimitiveMap.put("Float","float");
    UmpleToJavaPrimitiveMap.put("String","string");
    
    TraceLookupMap = new HashMap<String,String>();
    TraceLookupMap.put("indent","    ");
    TraceLookupMap.put("template","{0}Tracer.handle( {1} );");
    TraceLookupMap.put("timestamp","new Date()");
    TraceLookupMap.put("identifier","System.identityHashCode({0})");
    TraceLookupMap.put("thread","Thread.currentThread().getId()");
    TraceLookupMap.put("self","this");
  }
  
  @umplesourcefile(line={111},file={"Generator_CodeCpp.ump"},javaline={219},length={29})
  public void generate()
  {
    prepare();
    UmpleElement lastElement = null;
    try
    {
      for (UmpleElement currentElement : model.getUmpleElements())
      {
        if ("external".equals(currentElement.getModifier()))
        {
          continue;
        }
        writeFile(currentElement);
        lastElement = currentElement;
      }
    }
    catch (Exception e)
    {
      throw new UmpleCompilerException("There was a problem with generating classes. " + e, e);
    }

    if (lastElement == null)
    {
      String message = "There was a problem with generating classes.\nNo clases were compiled.\n";
      message += "Check the first line statement for probable cause.";
      throw new UmpleCompilerException(message,null);
    }
    GeneratorHelper.postpare(model);
  }
  
  
  @umplesourcefile(line={142},file={"Generator_CodeCpp.ump"},javaline={251},length={26})
    public ILang getLanguageFor(UmpleElement aElement)
  {
	if (aElement instanceof UmpleInterface)
    {
      
        return new CppInterfaceHeaderGenerator();
        
      
    }
    else if (aElement instanceof UmpleClass)
    {
    	if (callHeader == false)
    	{
    		callHeader = true;
    		return new CppClassGenerator();
    	}
    	
    	else if (callHeader == true)
    	{
    		callHeader = false;
    		return new CppHeaderGenerator();
    	}
      
    }
    return null;
  }
  
  @umplesourcefile(line={169},file={"Generator_CodeCpp.ump"},javaline={279},length={16})
  public String getType(UmpleVariable av)
  {
    String myType = av.getType();
    if (myType == null || myType.length() == 0)
    {
      return "string";
    }
    else if (UmpleToJavaPrimitiveMap.containsKey(myType))
    {
      return UmpleToJavaPrimitiveMap.get(myType);
    }
    else
    {
      return myType;
    }
  }
  
  @umplesourcefile(line={186},file={"Generator_CodeCpp.ump"},javaline={297},length={4})
  public boolean isNullable(UmpleVariable av)
  {
    return !UmpleToJavaPrimitiveMap.containsKey(av.getType());
  }
  @umplesourcefile(line={190},file={"Generator_CodeCpp.ump"},javaline={302},length={73})
  public String translate(String format, Constraint constraint)
  {
  	if(constraint==null)
  	  return "{0}";
  	
  	if(format.contains("Values")) 
    {
      String out = "";
      if(constraint.numberOfExpressions()==1)
      {
        return constraint.getExpression(0).getValue();
      }
      else
      {
      	List<ConstraintVariable> alreadyDone = new ArrayList<ConstraintVariable>();
      	for(int m = 0; m < constraint.numberOfExpressions()-1; m++)
      	{
      	  if(constraint.getExpression(m).getIsAttribute()&&!alreadyDone.contains(constraint.getExpression(m)))
      	  {
      	  	alreadyDone.add(constraint.getExpression(m));
      	    out += constraint.getExpression(m).getValue()+", ";
      	  }
      	}
      	boolean onlyOne = false;
      	if(constraint.getExpression(constraint.numberOfExpressions()-1).getIsAttribute()&&!alreadyDone.contains(constraint.getExpression(constraint.numberOfExpressions()-1)))
      	{
          if(alreadyDone.size()==1)
      	  {
      	    out = out.substring(0,out.length()-2);
      	  } 
      	  if(alreadyDone.size()>0)
      	  {
      		out += " and " ;
      	  }	
      	  else
      	  {
      	  	onlyOne = true;
      	  }
       	  out += constraint.getExpression(constraint.numberOfExpressions()-1).getValue();
       	  alreadyDone.add(constraint.getExpression(constraint.numberOfExpressions()-1));
      	}  
      	if(alreadyDone.size()==1 && !onlyOne)
      	{
      	  out = out.substring(0,out.length()-2);
      	} 
      	   	
      }      
      return out;
    }  
  	  
  	String expression = "";
  	for(ConstraintVariable expr: constraint.getExpressions())
  	{
  		if( expr.getIsAttribute() )
        {
        	if(format.contains("allParameterOne"))
        	{
        		expression += "a"+expr.getValue().substring(0,1).toUpperCase()+expr.getValue().substring(1);
        	}
            else if(format.contains(expr.getValue()))
            {
        	   expression += "a"+expr.getValue().substring(0,1).toUpperCase()+expr.getValue().substring(1);
            }
            else 
            { 
        	  expression += expr.getValue();
            }
          } 
          else
          { //This appends all the STATIC code, further features may require additional if statments to analyze them seperately.
            expression += expr.getValue();
          }
  	}
  	if(format.contains("Not")) 
    {
      expression = " !("+expression+")";
    }
  	if(format.contains("Closed"))
  	{
  		return StringFormatter.format("  if({0})\n    {\n    {1}\n    }",expression, "{0}");
  	}
  	else if(format.contains("Open"))
  	{
  		return StringFormatter.format("  if({0})\n    {\n    {1}\n",expression, "{0}");
  	}
  	return StringFormatter.format("  if({0})\n    {\n    {1}\n    }",expression, "{0}");
  }
  
  @umplesourcefile(line={278},file={"Generator_CodeCpp.ump"},javaline={391},length={9})
  public String translate(String keyName, TraceItem ti)
  {
  	if (keyName.length()>5&&"trace".equals(keyName.substring(0,5))){
    	return TraceLookupMap.get(keyName.substring(5).toLowerCase());
    }
    else {
    	return "INVALID KEYNAME IN TRANSLATE";
    }
  }
  
  @umplesourcefile(line={288},file={"Generator_CodeCpp.ump"},javaline={402},length={4})
  public String relatedTranslate(String name, AssociationVariable av)
  {
    return translate(name,av.getRelatedAssociation());
  }
  
  @umplesourcefile(line={293},file={"Generator_CodeCpp.ump"},javaline={408},length={36})
  public String translate(String keyName, State state)
  {
    String singularName = state.getName();
    String pluralName = model.getGlossary().getPlural(singularName);
  
    if (UpperCasePluralLookupMap.containsKey(keyName))
    {
      return StringFormatter.format(UpperCasePluralLookupMap.get(keyName),getUpperCaseName(pluralName));
    }
    else if (UpperCaseSingularLookupMap.containsKey(keyName))
    {
      return StringFormatter.format(UpperCaseSingularLookupMap.get(keyName),getUpperCaseName(singularName));
    }
    else if (AsIsPluralLookupMap.containsKey(keyName))
    {
      return StringFormatter.format(AsIsPluralLookupMap.get(keyName),pluralName);
    }
    else if (AsIsSingularLookupMap.containsKey(keyName))
    {
      return StringFormatter.format(AsIsSingularLookupMap.get(keyName),singularName);
    }
    else if ("doActivityMethod".equals(keyName))
    {
      return StringFormatter.format("doActivity{0}{1}",getUpperCaseName(state.getStateMachine().getName()),getUpperCaseName(state.getName())); 
    }
    else if ("doActivityThread".equals(keyName))
    {
      return StringFormatter.format("doActivity{0}{1}Thread",getUpperCaseName(state.getStateMachine().getName()),getUpperCaseName(state.getName())); 
    }
    else if ("type".equals(keyName))
    {
      return getUpperCaseName(state.getStateMachine().getName());
    }
    
    return "UNKNOWN ID: " + keyName;
  }
  
  @umplesourcefile(line={330},file={"Generator_CodeCpp.ump"},javaline={446},length={45})
  public String translate(String keyName, StateMachine sm)
  {
    String singularName = sm.getFullName();
    String pluralName = model.getGlossary().getPlural(singularName);
  
    if (UpperCasePluralLookupMap.containsKey(keyName))
    {
      return StringFormatter.format(UpperCasePluralLookupMap.get(keyName),getUpperCaseName(pluralName));
    }
    else if (UpperCaseSingularLookupMap.containsKey(keyName))
    {
      return StringFormatter.format(UpperCaseSingularLookupMap.get(keyName),getUpperCaseName(singularName));
    }
    else if (AsIsPluralLookupMap.containsKey(keyName))
    {
      return StringFormatter.format(AsIsPluralLookupMap.get(keyName),pluralName);
    }
    else if (AsIsSingularLookupMap.containsKey(keyName))
    {
      return StringFormatter.format(AsIsSingularLookupMap.get(keyName),singularName);
    }
    else if ("typeGet".equals(keyName) || "typeFull".equals(keyName))
    {
      return "string";
    }
    else if ("type".equals(keyName))
    {
      return getUpperCaseName(sm.getFullName());
    }
    else if ("listStates".equals(keyName))
    {
      String allEnums = "";
      for(State state : sm.getStates())
      {
        if (allEnums.length() > 0)
        {
          allEnums += ", ";
        }
        allEnums += translate("stateOne",state);
      }
      return allEnums;
    }
    
    return "UNKNOWN ID: " + keyName;
  }
  
  @umplesourcefile(line={376},file={"Generator_CodeCpp.ump"},javaline={493},length={24})
  public String translate(String keyName, Event event)
  {
    String singularName = event.getName();
    String pluralName = model.getGlossary().getPlural(singularName);

    if (UpperCasePluralLookupMap.containsKey(keyName))
    {
      return StringFormatter.format(UpperCasePluralLookupMap.get(keyName),getUpperCaseName(pluralName));
    }
    else if (UpperCaseSingularLookupMap.containsKey(keyName))
    {
      return StringFormatter.format(UpperCaseSingularLookupMap.get(keyName),getUpperCaseName(singularName));
    }
    else if (AsIsPluralLookupMap.containsKey(keyName))
    {
      return StringFormatter.format(AsIsPluralLookupMap.get(keyName),pluralName);
    }
    else if (AsIsSingularLookupMap.containsKey(keyName))
    {
      return StringFormatter.format(AsIsSingularLookupMap.get(keyName),singularName);
    }
    
    return "UNKNOWN ID: " + keyName;
  }  
  
  @umplesourcefile(line={401},file={"Generator_CodeCpp.ump"},javaline={519},length={961})
  public String translate(String name, UmpleInterface aInterface)
  {
    if ("packageDefinition".equals(name))
    {
    	if (aInterface.getPackageName()==null)
    	{
    		return aInterface.getPackageName().length() == 0 ? "" : "namespace " +"{";
    	}
    	else
    	{
    		return aInterface.getPackageName().length() == 0 ? "" : "namespace " + aInterface.getPackageName() + "{";
    	}
    }
    if ("isA".equals(name))
    {
      return getImplementsForInterfaces(aInterface);
    }
    return "";
  }
  
  @umplesourcefile(line={421},file={"Generator_CodeCpp.ump"},javaline={540},length={31})
  public String translate(String methodType)
  {
    if ("String".equals(methodType))
    {
      return "string";
    }
    if ("Integer".equals(methodType))
    {
      return "int";
    }
    if ("Boolean".equals(methodType))
    {
      return "bool";
    }       
    
    if ("Double".equals(methodType))
    {
    	return "double";
    }
    
    if ("Float".equals(methodType))
    {
    	return "float";
    }
    
    if (methodType.equals(""))
    		{
    	return"void";
    		}
    return methodType;
  }
  
  @umplesourcefile(line={453},file={"Generator_CodeCpp.ump"},javaline={573},length={24})
  public String translateReturnType(String methodType)
  {
    if ("String".equals(methodType))
    {
      return "\"\"";
    }
   
    if ("Boolean".equals(methodType))
    {
      return "false";
    }       
    
    if ("Double".equals(methodType) || "Integer".equals(methodType) || "Float".equals(methodType))
    {
    	return "0";
    }
    
    
    if (methodType.equals(""))
    		{
    	return"NULL";
    		}
    return methodType;
  }
  
  @umplesourcefile(line={478},file={"Generator_CodeCpp.ump"},javaline={599},length={884})
  public String translate(String name, UmpleClass aClass)
  {
    if ("constructorMandatory".equals(name))
    {
      return aClass.getGeneratedClass().getLookup("constructorSignature_mandatory");
    }
    else if ("packageDefinition".equals(name))
    {
    	if (aClass.getPackageName() ==null)
    	{
    		return aClass.getPackageName().length() == 0 ? "" : "namespace " + "{";
    	}
    else 
    	{
    		return aClass.getPackageName().length() == 0 ? "" : "namespace " + aClass.getPackageName() + "{";
    	}
    }
    else if ("type".equals(name))
    {
      return aClass.getName();
    }
    else if ("isA".equals(name))
    {
      return getExtendAndImplements(aClass);
    }
    return "UNKNOWN ID: " + name;
  }
  
  @umplesourcefile(line={506},file={"Generator_CodeCpp.ump"},javaline={628},length={16})
  private String getImplementsForInterfaces(UmpleInterface uInterface)
  {
      String implementedInterfaces = "";

      if (uInterface.hasExtendsInterface() == false){
          return "";
      }
      else{
          for (UmpleInterface aInterface : uInterface.getExtendsInterface())
          {
              implementedInterfaces += aInterface.getName() + ", public " ; 
          }
          implementedInterfaces = implementedInterfaces.substring(0, implementedInterfaces.length()-9);//-9 to rollback the extra ', public' word 
          return " : public " + implementedInterfaces;
      }
  }

  @umplesourcefile(line={523},file={"Generator_CodeCpp.ump"},javaline={646},length={10})
  private String getExtendAndImplements(UmpleClass uClass)
  {
      String extendsString = "";
      String implementsString = "";

      extendsString = getExtendClassesNames(uClass);
      implementsString = getImplementsInterfacesNames(uClass);

      return extendsString + implementsString; 
  }

  @umplesourcefile(line={534},file={"Generator_CodeCpp.ump"},javaline={658},length={11})
  private String getExtendClassesNames(UmpleClass uClass)
  {
      UmpleClass parent = uClass.getExtendsClass();
      if (parent == null)
      {
          return "";
      }
      else{
          return   ": public " + parent.getName();  
      }
  }

  @umplesourcefile(line={546},file={"Generator_CodeCpp.ump"},javaline={671},length={16})
  private String getImplementsInterfacesNames(UmpleClass uClass)
  {
      String implementedInterfaces = "";

      if (uClass.hasParentInterface() == false){
          return "";
      }
      else{
          for (UmpleInterface uInterface : uClass.getParentInterface())
          {
              implementedInterfaces += uInterface.getName() + ", public " ; 
          }
          implementedInterfaces = implementedInterfaces.substring(0, implementedInterfaces.length()-9);
          return ": public " + implementedInterfaces;
      }
  }

  @umplesourcefile(line={563},file={"Generator_CodeCpp.ump"},javaline={689},length={4})
  public String translate(String keyName, Attribute av)
  {
    return translate(keyName,av,av.getIsList());
  }
  
  @umplesourcefile(line={568},file={"Generator_CodeCpp.ump"},javaline={695},length={4})
  public String translate(String keyName, AssociationVariable av)
  {
    return translate(keyName,av,av.isMany());
  }
  
  @umplesourcefile(line={573},file={"Generator_CodeCpp.ump"},javaline={701},length={99})
  private String translate(String keyName, UmpleVariable av, boolean isMany)
  {
    if (OneOrManyLookup.contains(keyName))
    {
      String realKeyName = isMany ? keyName + "Many" : keyName + "One";
      return translate(realKeyName,av,isMany);
    }
    
    String singularName = isMany ? model.getGlossary().getSingular(av.getName()) : av.getName();
    String pluralName = isMany ? av.getName() : model.getGlossary().getPlural(av.getName());

    if (UpperCasePluralLookupMap.containsKey(keyName))
    {
      return StringFormatter.format(UpperCasePluralLookupMap.get(keyName),getUpperCaseName(pluralName));
    }
    else if (UpperCaseSingularLookupMap.containsKey(keyName))
    {
      return StringFormatter.format(UpperCaseSingularLookupMap.get(keyName),getUpperCaseName(singularName));
    }
    else if (AsIsPluralLookupMap.containsKey(keyName))
    {
      return StringFormatter.format(AsIsPluralLookupMap.get(keyName),pluralName);
    }
    else if (AsIsSingularLookupMap.containsKey(keyName))
    {
      return StringFormatter.format(AsIsSingularLookupMap.get(keyName),singularName);
    }
    else if ("parameterValue".equals(keyName))
    {
      if (av.getValue() == null)
      {
        return "null";
      }
      
      boolean isString = av.getValue().startsWith("\"") && av.getValue().endsWith("\"");
      if (isString && "Date".equals(av.getType()))
      {
        return "Date.valueOf("+ av.getValue() +")";      
      }
      else if (isString && "Time".equals(av.getType()))
      {
        return "Time.valueOf("+ av.getValue() +")";
      }
      else
      {
        return av.getValue();
      }
    }
    else if ("type".equals(keyName))
    {
      return getType(av);
    }
    else if ("typeMany".equals(keyName))
    {
      return isNullable(av) ? getType(av) : av.getType();
    }
    
    if (av instanceof AssociationVariable)
    {
      AssociationVariable assVar = (AssociationVariable)av;
      if ("callerArgumentsExcept".equals(keyName))
      {
        UmpleClass classToRemove = model.getUmpleClass(getType(assVar.getRelatedAssociation()));
        GeneratedClass generatedClassToRemove = classToRemove.getGeneratedClass();
        String   callerNameToRemove = translate("parameterOne",assVar);
        return StringFormatter.replaceParameter(generatedClassToRemove.getLookup("constructorSignature_caller"), callerNameToRemove, "this");
      }
      else if ("methodArgumentsExcept".equals(keyName))
      {
        UmpleClass classToRemove = model.getUmpleClass(getType(assVar.getRelatedAssociation()));
        GeneratedClass generatedClassToRemove = classToRemove.getGeneratedClass();
        String parameterNameToRemove = StringFormatter.format("{0} {1}", translate("type",assVar), translate("parameterOne",assVar));
        return StringFormatter.replaceParameter(generatedClassToRemove.getLookup("constructorSignature"), parameterNameToRemove, ""); 
      }
      else if ("callerArgumentsForMandatory".equals(keyName))
      {
        UmpleClass classToLookup = model.getUmpleClass(getType(av));
        String lookup = "constructorSignature_mandatory_" + assVar.getRelatedAssociation().getName();
        String parameters = classToLookup.getGeneratedClass().getLookup(lookup);
        return parameters;
      }
      else if ("associationCanSet".equals(keyName))
      {
        String actualLookup = assVar.isMany() ? "associationCanSetMany" : "associationCanSetOne";
        return translate(actualLookup,av,isMany);
      }
    }
    else if (av instanceof Attribute)
    {
      Attribute attVar = (Attribute)av;
      if ("attributeCanSet".equals(keyName))
      {
        String actualLookup = attVar.getIsList() ? "attributeCanSetMany" : "attributeCanSetOne";
        return translate(actualLookup,av,isMany);
      }
    }
    
    return "UNKNOWN ID: " + keyName;
  }
  
  @umplesourcefile(line={673},file={"Generator_CodeCpp.ump"},javaline={802},length={17})
  public void prepare()
  {
    List<UmpleClass> allClasses = new ArrayList<UmpleClass>(model.getUmpleClasses());
    for (UmpleClass aClass : allClasses)
    {
      prepare(aClass);
    }
    
    for (UmpleClass aClass : model.getUmpleClasses())
    {
      GeneratedClass genClass = aClass.getGeneratedClass();
      generateSecondaryConstructorSignatures(genClass);
      addImports(aClass,genClass);
    }
    
    addRelatedImports();
  }

  @umplesourcefile(line={691},file={"Generator_CodeCpp.ump"},javaline={821},length={23})
  public static String typeOf(String aType)
  {
    if (aType == null || aType.length() == 0)
    {
      return "string";
    }
    else if (aType.equals("Integer"))
    {
      return "int";
    }
    else if (aType.equals("Double"))
    {
      return "double";
    }
    else if (aType.equals("Boolean"))
    {
      return "bool";
    }
    else
    {
      return aType;
    }
  }

  @umplesourcefile(line={715},file={"Generator_CodeCpp.ump"},javaline={846},length={17})
  public String nameOf(String name, boolean hasMultiple)
  {
    if (name == null)
    {
      return null;
    }
    else if (hasMultiple)
    {
      //String pluralName = model.getGlossary().getPlural(name);
      return "all" + StringFormatter.toPascalCase(name);
    }
    else
    {
      //String singularName = model.getGlossary().getSingular(name);
      return "a" + StringFormatter.toPascalCase(name);
    }
  }

  
  //------------------------
  // PRIVATE METHODS
  //------------------------
  
  @umplesourcefile(line={738},file={"Generator_CodeCpp.ump"},javaline={870},length={4})
  private String getUpperCaseName(String name)
  {
    return StringFormatter.toPascalCase(name);
  }  
  
  @umplesourcefile(line={743},file={"Generator_CodeCpp.ump"},javaline={876},length={108})
  private void prepare(UmpleClass aClass)
  {
    if (aClass.getGeneratedClass() != null)
    {
      return;
    }
    else if (aClass.isRoot())
    {
      GeneratedClass genClass = aClass.createGeneratedClass(model);
      generateConstructorSignature(genClass);
    }
    else
    {
      UmpleClass parent = model.getUmpleClass(aClass.getExtendsClass().getName());
      prepare(parent);
      GeneratedClass genClass = aClass.createGeneratedClass(model);
      genClass.setParentClass(parent.getGeneratedClass());
      generateConstructorSignature(genClass);
    }

    for(Attribute av : aClass.getAttributes())
    {
      if (av.isImmutable() || aClass.getKey().isMember(av))
      {
        String code = StringFormatter.format("if (!{0}) { return false; }",translate("attributeCanSet",av));
        CodeInjection set = new CodeInjection("before",translate("setMethod",av) , code, aClass);
        set.setIsInternal(true);
        aClass.addCodeInjection(set);
      }
    
      if (aClass.getKey().isMember(av))
      {
        String code = StringFormatter.format("if (!{0}) { return false; }",translate("attributeCanSet",av));
        String methods = StringFormatter.format("{0},{1},{2},{3}",translate("addMethod",av),translate("removeMethod",av),translate("setManyMethod",av),translate("resetMethod",av));
        CodeInjection inject = new CodeInjection("before", methods, code, aClass);
        inject.setIsInternal(true);
        aClass.addCodeInjection(inject);
      }
    }
    
    for(AssociationVariable av : aClass.getAssociationVariables())
    {
      if (aClass.getKey().isMember(av))
      {
        String code = StringFormatter.format("if (!{0}) { return false; }",translate("associationCanSet",av));
        String methods = StringFormatter.format("{0},{1},{2},{3},{4}",translate("addMethod",av),translate("removeMethod",av),translate("setManyMethod",av),translate("setMethod",av),translate("resetMethod",av));
        CodeInjection inject = new CodeInjection("before",methods , code, aClass);
        inject.setIsInternal(true);
        aClass.addCodeInjection(inject);
      }
      
      if (av.isMany())
      {
        String code = StringFormatter.format("if (find({0}.begin(),{0}.end(),{1}) != {0}.end()) { return false; }",translate("attributeMany",av),translate("parameterOne",av));
        CodeInjection set = new CodeInjection("before",translate("addMethod",av) , code, aClass);
        set.setIsInternal(true);
        aClass.addCodeInjection(set);
      }
    }
    
    for (Constraint ac : aClass.getConstraints())
    {      
      List<ConstraintVariable> alreadyDone = new ArrayList<ConstraintVariable>();
      for (ConstraintVariable cur : ac.getExpressions())
      {
      	if(!cur.getIsAttribute() || alreadyDone.contains(cur))
      	  continue;
      	alreadyDone.add(cur);
      	String set_expression = "";
      	String con_expression = "";
      	String set_code = "if ({0})\n{";
      	String con_code = "if ( !({0}))\n{\n" +
      						     "  throw \"Please provide a valid "+ cur.getConstrainedVariable() +"\";\n"+
                                 "}";
      	for (ConstraintVariable  expr: ac.getExpressions())
        {
          if( expr.getIsAttribute() )
          {
          	con_expression += translate("parameterOne",aClass.getAttribute(expr.getValue()));
            if (cur == expr) { 
        	  set_expression += translate("parameterOne",aClass.getAttribute(expr.getValue()));
            }
            else 
            { 
        	  set_expression += translate("attributeOne",aClass.getAttribute(expr.getValue()));
            }
          } 
          else
          { //This appends all the STATIC code, further features may require additional if statments to analyze them seperately.
            con_expression += expr.getValue();
            set_expression += expr.getValue();
          }
        }
        String setMethod_code = StringFormatter.format(set_code, set_expression);
        CodeInjection before = new CodeInjection("before", translate("setMethod", aClass.getAttribute(cur.getValue())), setMethod_code, aClass);         
        CodeInjection after = new CodeInjection("after", translate("setMethod", aClass.getAttribute(cur.getValue())), "}", aClass);
        before.setIsInternal(true);
        after.setIsInternal(true);
        aClass.addCodeInjection(before);
        aClass.addCodeInjection(after);
        
        String constructor_code = StringFormatter.format(con_code, con_expression);
        before = new CodeInjection("before",  "constructor", constructor_code, aClass);  
        before.setIsInternal(true);
        aClass.addCodeInjection(before);
      
      }
    }
    
     for (Precondition pc : aClass.getPreconditions()){ 
    	String methodName = pc.getMethod().getName();
    	String precondition_code = StringFormatter.format(translate("NotClosed",pc),"throw \"Please provide a valid "+ translate("allAttributesValues",pc) +"\";");
    	CodeInjection before = new CodeInjection("before", methodName+"Precondition", precondition_code, aClass);         
    	before.setIsInternal(true);
    	aClass.addCodeInjection(before);    
    }
    
    Map<String,String> lookups = new HashMap<String,String>();
    String executeMethods = "public static void execute(String message) { getInstance().addTrace(message); }\n";
    executeMethods += "public void reset() { getInstance().traces.clear(); }";
    lookups.put("consoleTemplate","System.out.println(\"{0}=\" + {1});");
    lookups.put("stringTemplate","StringTracer.execute(\"{0}=\" + {1});");
    lookups.put("fileTemplate","fileTracer({0});");
    lookups.put("lttngTemplate","tracepoint({0}_tracepoint,\"message\",{0});");
    lookups.put("dependPackage","1");
    lookups.put("extraCode",executeMethods);
    //GeneratorHelper.prepareAllStringTracers(this,model,aClass,lookups);
    GeneratorHelper.prepareAllTracers(this,model,aClass,lookups);

    //Add  entry / exit methods to start and stop the timed events in Java
    boolean hasTimedEvents = false;
    for (StateMachine sm : aClass.getStateMachines())
    {
      prepareNestedStatesFor(sm,0);
      hasTimedEvents = prepareTimedEvents(sm) || hasTimedEvents;
    }
        
    if (hasTimedEvents)
    {
      aClass.addDepend(new Depend("java.util.*"));
    }
  }
   
  @umplesourcefile(line={886},file={"Generator_CodeCpp.ump"},javaline={1020},length={25})
  private boolean prepareTimedEvents(StateMachine sm)
  {
    boolean hasTimedEvents = false;
    for (State s : sm.getStates())
    {
      for (Transition t : s.getTransitions())
      {
        Event e = t.getEvent();
        if (!e.getIsTimer())
        {
          continue;
        }
        hasTimedEvents = true;
        Action entryAction = new Action(StringFormatter.format("{0}();",translate("eventStartMethod",e)));
        entryAction.setActionType("entry");
        
        Action exitAction = new Action(StringFormatter.format("{0}();",translate("eventStopMethod",e)));
        exitAction.setActionType("exit");

        t.getFromState().addAction(entryAction);
        t.getFromState().addAction(exitAction);
      }
    }
    return hasTimedEvents;
  }
  
  @umplesourcefile(line={912},file={"Generator_CodeCpp.ump"},javaline={1047},length={29})
  private void prepareNestedStatesFor(StateMachine sm,int concurrentIndex)
  {
    if (sm.getParentState() != null)
    {
      State parentState = sm.getParentState();
      Map<String,String> lookups = new HashMap<String,String>();
      lookups.put("entryEventName",translate("enterMethod",parentState));
      lookups.put("exitEventName",translate("exitMethod",parentState));
      lookups.put("parentEntryActionCode",StringFormatter.format("if ({0} == {2}) { {3}({4}); }"
          ,translate("stateMachineOne",sm)
          ,translate("type",sm)
          ,translate("stateNull",sm)
          ,translate("setMethod",sm)
          ,translate("stateOne",sm.getStartState()))
      );
      lookups.put("parentExitActionCode",StringFormatter.format("{0}();",translate("exitMethod",parentState)));
      GeneratorHelper.prepareNestedStateMachine(sm,concurrentIndex,lookups);  
    }

    for (State s : sm.getStates())
    {
      int nestedSmIndex = 0;
      for (StateMachine nestedSm : s.getNestedStateMachines())
      {
        prepareNestedStatesFor(nestedSm,nestedSmIndex);
        nestedSmIndex += 1;
      }
    }
  }
  
  @umplesourcefile(line={942},file={"Generator_CodeCpp.ump"},javaline={1078},length={70})
  private void generateConstructorSignature(GeneratedClass genClass)
  {
    StringBuffer signature = new StringBuffer();
    StringBuffer signatureCaller = new StringBuffer();
    
    UmpleClass uClass = genClass.getUClass();
    
    if (uClass.getExtendsClass() != null) 
    {
      GeneratedClass parent = genClass.getParentClass();
      signature.append(parent.getLookup("constructorSignature"));
      signatureCaller.append(parent.getLookup("constructorSignature_caller"));
    }    
    
    for (Attribute av : uClass.getAttributes()) 
    {
      if (av.getIsAutounique() || av.getIsList() || "defaulted".equals(av.getModifier()) || av.getIsLazy() || av.getValue() != null)
      {
        continue;
      }

      if (signature.length() > 0) 
      {
        signature.append(", ");
        signatureCaller.append(", ");
      }
        

      signature.append(StringFormatter.format("const {0} & {1}",typeOf(av),nameOf(av))); 
      signatureCaller.append(nameOf(av));   
    }

    for (AssociationVariable av : uClass.getAssociationVariables()) 
    {
      AssociationVariable relatedAv = av.getRelatedAssociation();

      if (av.getMultiplicity().getLowerBound() == 0 || !av.getIsNavigable())
      {
        continue;
      }
      
      if (relatedAv.getIsNavigable())
      {
        if (av.isMandatoryMany() && relatedAv.isMandatory())
        {
          continue;
        }
        
        if ((av.isMN() || av.isN()) && relatedAv.isOptionalN())
        {
          continue;
        }
      }
      
      if (signature.length() > 0) 
      {
        signature.append(", ");
        signatureCaller.append(", ");
      }
      //String typeModifier = av.isMany() ? "..." : "";
      String typeModifier = av.isMany() ? "vector<" : "";
      String typeModifier2 = av.isMany() ? "*>" : "";
      //if( !typeModifier.equals("") )
       signature.append(StringFormatter.format("{0}{1}{3} {2}",typeModifier,typeOf(av),nameOf(av),typeModifier2));      
      signatureCaller.append(nameOf(av));      
    }

    genClass.setLookup("constructorSignature", signature.toString());
    genClass.setLookup("constructorSignature_caller", signatureCaller.toString());
  }
  
  @umplesourcefile(line={1013},file={"Generator_CodeCpp.ump"},javaline={1150},length={37})
  private void generateSecondaryConstructorSignatures(GeneratedClass genClass)
  {
    UmpleClass uClass = genClass.getUClass();
    
    String mandatorySignature = genClass.getLookup("constructorSignature");
    
    for (AssociationVariable av : uClass.getAssociationVariables()) 
    {
      AssociationVariable relatedAv = av.getRelatedAssociation();
      if (av.isOnlyOne() && relatedAv.isOnlyOne() && av.getIsNavigable() && relatedAv.getIsNavigable())
      {
        UmpleClass relatedClass = model.getUmpleClass(av.getType());
        GeneratedClass relatedGen = relatedClass.getGeneratedClass();
        
        String selfParameter = StringFormatter.format("const {0}& {1}",typeOf(relatedAv),nameOf(relatedAv));
        String selfFor = StringFormatter.format("For{0}",av.getUpperCaseName());
        String newParameters = relatedGen.getLookup("constructorSignature");
        newParameters = StringFormatter.replaceParameter(newParameters, selfParameter, null);
        newParameters = StringFormatter.appendParameter(newParameters, selfFor);

        String relatedParameter = StringFormatter.format("const {0}& {1}",typeOf(av),nameOf(av));
        
        mandatorySignature = StringFormatter.replaceParameter(mandatorySignature, relatedParameter, newParameters);
        genClass.setLookup("constructorSignature_mandatory", mandatorySignature);
        
        String relatedFor = StringFormatter.format("For{0}",relatedAv.getUpperCaseName());
        String relatedCaller = genClass.getLookup("constructorSignature_caller");
        String relatedCallerParameter = nameOf(av);
        String mandatorySignatureCaller = StringFormatter.replaceParameter(relatedCaller, relatedCallerParameter, "_THIS_");
        mandatorySignatureCaller = StringFormatter.appendParameter(mandatorySignatureCaller, relatedFor);
        mandatorySignatureCaller = StringFormatter.replaceParameter(mandatorySignatureCaller, "_THIS_" + relatedFor, "this");
        
        String mandatoryCallerId = "constructorSignature_mandatory_" + relatedAv.getName();
        relatedGen.setLookup(mandatoryCallerId, mandatorySignatureCaller);
      }
    }
  }
  
  @umplesourcefile(line={1051},file={"Generator_CodeCpp.ump"},javaline={1189},length={35})
  private void addRelatedImports()
  {
    for (UmpleClass aClass : model.getUmpleClasses())
    {
      GeneratedClass genClass = aClass.getGeneratedClass();
      
      if (aClass.getExtendsClass() != null)
      {
        if (!aClass.getPackageName().equals(aClass.getExtendsClass().getPackageName()))
        {
          genClass.addMultiLookup("import", aClass.getExtendsClass().getPackageName() + "");  
        }
        addImports(aClass.getExtendsClass(),genClass);
      }
      
      for (AssociationVariable av : aClass.getAssociationVariables()) 
      {
        if (!av.getIsNavigable())
        {
          continue;
        }
        
        AssociationVariable relatedAssociation = av.getRelatedAssociation();
        if (relatedAssociation.isOnlyOne())
        { 
          UmpleClass relatedClass = model.getUmpleClass(av.getType());
          while (relatedClass != null)
          {
            addAttributeImports(relatedClass,genClass);
            relatedClass = relatedClass.getExtendsClass();
          }
        }
      }
    }
  }
  
  @umplesourcefile(line={1087},file={"Generator_CodeCpp.ump"},javaline={1226},length={27})
  private void addAttributeImports(UmpleClass aClass, GeneratedClass genClass)
  {
    String timeImport = "time.h";
    String dateImport = "time.h";
    String utilImport = "vector";
    
      for (Attribute av : aClass.getAttributes()) 
    {
      
      if ("Time".equals(av.getType()))
      {

        genClass.addMultiLookup("import", timeImport);
        av.setType("time_t*");
      }
      else if ("Date".equals(av.getType()))
      {
        genClass.addMultiLookup("import", dateImport);
        av.setType("string");
      }
      
      if (av.getIsList())
      {
        genClass.addMultiLookup("import", utilImport);
      }
    }
  }
  
  @umplesourcefile(line={1115},file={"Generator_CodeCpp.ump"},javaline={1255},length={25})
  private void addImports(UmpleClass aClass, GeneratedClass genClass)
  {
    addAttributeImports(aClass,genClass);
      
    for (AssociationVariable av : aClass.getAssociationVariables()) 
    {
      if (!av.getIsNavigable())
      {
        continue;
      }
      
      if (av.isMany())
      {
        genClass.addMultiLookup("import", "vector");
      }
    }
    
    for (String namespace : aClass.getNamespaces())
    {
      if (!namespace.equals(aClass.getPackageName()))
      {
        genClass.addMultiLookup("using", namespace);
      }
    }
  }
  
  @umplesourcefile(line={1141},file={"Generator_CodeCpp.ump"},javaline={1282},length={4})
  private String nameOf(Attribute av)
  {
    return nameOf(av.getName(),av.getIsList());
  }
  
  @umplesourcefile(line={1146},file={"Generator_CodeCpp.ump"},javaline={1288},length={5})
  private String nameOf(AssociationVariable av)
  {
    boolean hasMultiple = av.isMany();
    return nameOf(av.getName(),hasMultiple);
  }
  
  @umplesourcefile(line={1152},file={"Generator_CodeCpp.ump"},javaline={1295},length={9})
  private static String typeOf(UmpleVariable var)
  {
    String aType = var.getType();
    if (aType =="String")
    {
    	return "string";
    }
    return typeOf(aType);
  }
  
   //return applicable tracepoints arguments based on attribute type
  @umplesourcefile(line={1163},file={"Generator_CodeCpp.ump"},javaline={1307},length={10})
  private String getTpArguments(String t)
  {	  
		if (t.equals("String"))
			return "TP_ARGS(char *, text),\n";
		if (t.equals("Integer"))
			return "TP_ARGS(int, intfield),\n";
		if (t.equals("Double"))
			return "TP_ARGS(double, doublefield),\n";
		return "";
	}
  //tracepoint message
  @umplesourcefile(line={1174},file={"Generator_CodeCpp.ump"},javaline={1319},length={14})
  private String getTpMessage(String t)
  {
	  if(t.equals("String"))		
			return "message,\n"; 
		  if(t.equals( "Integer"))
			  return "intfield,\n"; 
		  if(t.equals( "Double"))
			  return "doublefield,\n";
		  if(t.equals("Entry"))		
				return "entry,\n"; 
			  if(t.equals( "Exit"))
				  return "exit,\n"; 
	  return"";
  }
  
 
  
  //get TP field: n name, t type
  @umplesourcefile(line={1192},file={"Generator_CodeCpp.ump"},javaline={1338},length={14})
  private String getTpField( String t, String n)
  {
	  if(t.equals("String"))		
		  return "ctf_string(message,"+ n+")";
	  if(t.equals( "Integer"))
		  return "ctf_integer(int, intfield,"+ n+")"; 
	  if(t.equals( "Double"))
		  return "ctf_string(double, doublefield,"+ n+")";
	  if(t.equals("Entry"))		
		  return "ctf_string(entry,"+ n+")";
	  if(t.equals("Exit"))		
		  return "ctf_string(exit,"+ n+")";
	  return"";
  }
  
  @umplesourcefile(line={1207},file={"Generator_CodeCpp.ump"},javaline={1354},length={16})
  private String getTpLogLevel(String t)
  {
	  String tp_loglevel = "\nTRACEPOINT_LOGLEVEL(\n";
	  if(t .equals("String"))	
		  tp_loglevel += "message,\n";
	  if(t .equals( "Integer"))
		  tp_loglevel += "intfield,\n"; 
	  if(t .equals( "Double"))
		  tp_loglevel += "doublefield,\n";
	  if(t .equals("Exit"))	
		  tp_loglevel += "exit,\n";
	  if(t .equals("Entry"))	
		  tp_loglevel += "entry,\n";
	  return tp_loglevel += "TRACE_WARNING)";
	  
  }
    
  @umplesourcefile(line={1224},file={"Generator_CodeCpp.ump"},javaline={1372},length={14})
  private String processLttngfile(Attribute att)
  {	  
	  String tp_code = null;
	  String tp_arg = getTpArguments(att.getType());
	  String tp_message = getTpMessage(att.getType());
	  String tp_field = getTpField(att.getType(), att.getName());
	  String tp_loglevel = getTpLogLevel(att.getType());	 
	  	  
	  //tracepoint code 
	  tp_code = "TRACEPOINT_EVENT(\n" + att.getName() + ",\n" + tp_arg + tp_message + tp_field + tp_loglevel + "\n)\n";
	  
	  //System.out.println(tp_code);
	  return tp_code;	  
  }
  
  //Process Lttng tracepoints for state machines, treating state as String.
  @umplesourcefile(line={1240},file={"Generator_CodeCpp.ump"},javaline={1389},length={24})
  private String processLttngFile(StateMachineTraceItem smti) {
	  String tp_code = null;
	  String tp_arg = getTpArguments("String"); //passing states to TP as string
	  String tp_message = null;	  
	  String tp_field = null;
	  String tp_loglevel = null;
	  
	  if(smti.getEntry())
		  {
		  tp_message = getTpMessage("Entry");
		  tp_field = getTpField("Entry",smti.getStateMachine().getName());
		  tp_loglevel = getTpLogLevel("Entry");
		  }
	  
	  else if(smti.getExit())
	  {	  
		  tp_message = getTpMessage("Exit");
		  tp_field = getTpField("Exit",smti.getStateMachine().getName());
		  tp_loglevel= getTpLogLevel("Exit");
	  }
	  	  	  
	  tp_code = "TRACEPOINT_EVENT(\n" + smti.getStateMachine().getName() + ",\n" + tp_arg + tp_message + tp_field + tp_loglevel + "\n)\n";
	  return tp_code;
  }
  
  
  @umplesourcefile(line={1266},file={"Generator_CodeCpp.ump"},javaline={1416},length={16})
  public void writeLttngFile(String name, String tp_code, String path) throws IOException
  {
	  
	  String lttngFileName = path + File.separator + name + "_tracepoint.tp";
		BufferedWriter lttngBw = new BufferedWriter(new FileWriter(lttngFileName));
		String lttngContent = tp_code.toString();
		//System.out.println(tp_code);
		model.getGeneratedCode().put(name +"_tp",lttngContent);
		try {
			lttngBw.write(lttngContent);
			lttngBw.flush();
		}
			finally {
			lttngBw.close();
		}	  
  }
  
  @umplesourcefile(line={1283},file={"Generator_CodeCpp.ump"},javaline={1434},length={66})
  private void writeFile(UmpleElement aClass) throws IOException
  {
    ILang language = getLanguageFor(aClass);
    ILang headerlanguage = getLanguageFor(aClass);

    String path = StringFormatter.addPathOrAbsolute( 
    						  model.getUmpleFile().getPath(), 
        	                  getOutput()) + 
        	                  aClass.getPackageName().replace(".", File.separator);
   File file = new File(path);
    file.mkdirs();
  
    String filename = (aClass instanceof UmpleClass) ? (path + File.separator + aClass.getName() + ".cpp"):(path + File.separator + aClass.getName() + ".h");
    BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
    String contents = language.getCode(model, aClass);
    model.getGeneratedCode().put(aClass.getName(),contents);
  
    
    
    //creating a header file for each class created. #header
    String hfilename = path + File.separator + aClass.getName() + ".h";
    BufferedWriter hbw = new BufferedWriter(new FileWriter(hfilename));
    String headerContent = headerlanguage.getCode(model, aClass);
    model.getGeneratedCode().put(aClass.getName()+"_header",headerContent);
    
    //creating and writing tracepoint files for LTTng #lttng
    if (aClass instanceof UmpleClass)
    {
      	UmpleClass uClass = (UmpleClass) aClass;
    	
      	if( callLttng = true)
		{
      	if (model.getTraceType().equals("Lttng") && uClass.hasTraceDirectives() && callHeader == false)
    	{     		 
      		//ILang lttngLang = new CppLttngGenerator();
    		//lttngLang.getCode(model, aClass);    	
    	   	//ILang lttngLang = new CppLttngGenerator();    			
    		
	    	for (TraceDirective td : uClass.getTraceDirectives())
	    	{ 
	    		String tp_code = null;
	    		for (AttributeTraceItem ati: td.getAttributeTraceItems())
	    	
	    		{
	    			for (UmpleVariable att : ati.getUmpleVariables()) 
	    			{
	    				 
      					tp_code = processLttngfile((Attribute)att);
						writeLttngFile(att.getName(), tp_code,path);
	    			}
	    		}
	    		
	    		for (StateMachineTraceItem smti : td.getStateMachineTraceItems() )
	    		{
	    		    tp_code = processLttngFile(smti);
				    writeLttngFile(smti.getStateMachine().getName(), tp_code,path);
	    		}
	    	}
    	}
    	
    	}
   }
    /*if (aClass instanceof UmpleInterface && model.getTraceType().equals("Lttng"))
    {
	   //Edit Later to support tracing for interface	   
    }*/

    try
    {
      bw.write(contents);
      hbw.write(headerContent);
      bw.flush();
    }
    finally
    {
      bw.close();
      hbw.close();
    }
  }

}