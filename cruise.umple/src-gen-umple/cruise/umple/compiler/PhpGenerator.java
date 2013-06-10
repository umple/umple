/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.compiler;
import java.util.*;
import java.io.*;
import cruise.umple.util.*;
import cruise.umple.compiler.exceptions.*;
import cruise.umple.compiler.php.*;

/**
 * @umplesource Generator.ump 216
 * @umplesource Generator_CodePhp.ump 12
 */
// line 216 "../../../../src/Generator.ump"
// line 12 "../../../../src/Generator_CodePhp.ump"
public class PhpGenerator implements CodeGenerator,CodeTranslator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PhpGenerator Attributes
  private UmpleModel model;
  private String output;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PhpGenerator()
  {
    model = null;
    output = "";
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

  public void delete()
  {}


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
  // line 15 ../../../../src/Generator_CodePhp.ump
  private static Map<String,String> UpperCaseSingularLookupMap;
  private static Map<String,String> UpperCasePluralLookupMap;
  private static Map<String,String> AsIsSingularLookupMap;
  private static Map<String,String> AsIsPluralLookupMap;
  private static Map<String,String> TraceLookupMap;
  private static List<String> OneOrManyLookup;
  static
  {
    UpperCaseSingularLookupMap = new HashMap<String, String>();
    UpperCaseSingularLookupMap.put("parameterOne", "a{0}");
    UpperCaseSingularLookupMap.put("removeParameterOne", "placeholder{0}");
    UpperCaseSingularLookupMap.put("parameterNew", "aNew{0}");
    UpperCaseSingularLookupMap.put("parameterNext", "next{0}");
    UpperCaseSingularLookupMap.put("addMethod", "add{0}");
    UpperCaseSingularLookupMap.put("addViaMethod", "add{0}Via");
    UpperCaseSingularLookupMap.put("addAtMethod", "add{0}At");
    UpperCaseSingularLookupMap.put("addOrMoveAtMethod", "addOrMove{0}At");
    UpperCaseSingularLookupMap.put("removeMethod", "remove{0}");
    UpperCaseSingularLookupMap.put("indexOfMethod", "indexOf{0}");
    UpperCaseSingularLookupMap.put("parameterOld", "anOld{0}");
    UpperCaseSingularLookupMap.put("parameterExisting", "existing{0}");
    UpperCaseSingularLookupMap.put("parameterExistingSerialized", "existingSerialized{0}");
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
    UpperCaseSingularLookupMap.put("isMethod", "is{0}");
    UpperCaseSingularLookupMap.put("getFullMethod", "get{0}FullName");
    UpperCaseSingularLookupMap.put("isFinalMethod", "is{0}Final");
    UpperCaseSingularLookupMap.put("getDefaultMethod", "getDefault{0}");
    UpperCaseSingularLookupMap.put("didAdd", "didAdd{0}");
    UpperCaseSingularLookupMap.put("hasMethod", "has{0}");
    UpperCaseSingularLookupMap.put("associationCanSetOne","canSet{0}");
    UpperCaseSingularLookupMap.put("attributeCanSetOne","canSet{0}");
    UpperCaseSingularLookupMap.put("eventStartMethod", "start{0}Handler");
    UpperCaseSingularLookupMap.put("eventStopMethod", "stop{0}Handler");    
    UpperCaseSingularLookupMap.put("stateNull","{0}Null");
    
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
    //AsIsSingularLookupMap.put("stateOne","{0}");
    //AsIsSingularLookupMap.put("stateString","\"{0}\"");
    AsIsSingularLookupMap.put("eventMethod","{0}");
    AsIsSingularLookupMap.put("eventHandler", "{0}Handler");

    AsIsPluralLookupMap = new HashMap<String, String>();
    AsIsPluralLookupMap.put("associationMany","{0}");
    AsIsPluralLookupMap.put("attributeMany","{0}");

    OneOrManyLookup = new ArrayList<String>();
    OneOrManyLookup.add("attribute");
    OneOrManyLookup.add("parameter");
    
    TraceLookupMap = new HashMap<String,String>();
    TraceLookupMap.put("concatinator",".");
    TraceLookupMap.put("accessor","$this->");
    TraceLookupMap.put("indent","    ");
    TraceLookupMap.put("template","{0}Tracer::handle( {1} );");
    TraceLookupMap.put("timestamp","gettimeofday(true)");
    TraceLookupMap.put("identifier","spl_object_hash( {0} )");
    TraceLookupMap.put("thread","uniqid()");
    TraceLookupMap.put("self","$this");
    TraceLookupMap.put("increment","{0}++;");
    
  }

  @umplesourcefile(line={109},file={"Generator_CodePhp.ump"},javaline={186},length={18})
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
      generateNullableConstructorSignature(genClass);
      addImports(aClass,genClass);
    }

    addRelatedImports();
  }
  
  @umplesourcefile(line={128},file={"Generator_CodePhp.ump"},javaline={206},length={12})
  public String getType(UmpleVariable av)
  {
    String myType = av.getType();
    if (myType == null || myType.length() == 0)
    {
      return "String";
    }
    else
    {
      return myType;
    }
  }
  
  @umplesourcefile(line={141},file={"Generator_CodePhp.ump"},javaline={220},length={4})
  public boolean isNullable(UmpleVariable av)
  {
    return true;
  }
  @umplesourcefile(line={145},file={"Generator_CodePhp.ump"},javaline={225},length={73})
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
        		expression += "$a"+expr.getValue().substring(0,1).toUpperCase()+expr.getValue().substring(1);
        	}
            else if(format.contains(expr.getValue()))
            {
        	   expression += "$a"+expr.getValue().substring(0,1).toUpperCase()+expr.getValue().substring(1);
            }
            else 
            { 
        	  expression += "$"+expr.getValue();
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
  
  @umplesourcefile(line={234},file={"Generator_CodePhp.ump"},javaline={315},length={9})
  public String translate(String keyName, TraceItem ti)
  {
  	if (keyName.length()>5&&"trace".equals(keyName.substring(0,5))){
    	return TraceLookupMap.get(keyName.substring(5).toLowerCase());
    }
    else {
    	return "INVALID KEYNAME IN TRANSLATE";
    }
  }
  
  @umplesourcefile(line={244},file={"Generator_CodePhp.ump"},javaline={326},length={4})
  public String relatedTranslate(String name, AssociationVariable av)
  {
    return translate(name,av.getRelatedAssociation());
  }
  
  @umplesourcefile(line={249},file={"Generator_CodePhp.ump"},javaline={332},length={14})
  public ILang getLanguageFor(UmpleElement aElement)
  {
    if (aElement instanceof UmpleInterface)
    {
       return new PhpInterfaceGenerator();
    }
    else if (aElement instanceof UmpleClass)
    {
      return new PhpClassGenerator();
    } 
    else{
    	return null;    	
    }
  }
  
  @umplesourcefile(line={264},file={"Generator_CodePhp.ump"},javaline={348},length={8})
  public String translate(String name, UmpleInterface aInterface)
  {
    if ("packageDefinition".equals(name))
    {
      return aInterface.getPackageName().length() == 0 ? "" : "package " + aInterface.getPackageName() + ";"; 
    }
    return "UNKNOWN ID: " + name;
  }
  
  @umplesourcefile(line={273},file={"Generator_CodePhp.ump"},javaline={358},length={16})
  public String translate(String methodType)
  {
    if ("String".equals(methodType))
    {
      return "\"\"";
    }
    if ("int".equals(methodType))
    {
      return "0";
    }
    if ("boolean".equals(methodType))
    {
      return "false";
    }       
    return "null";
  }
  
  @umplesourcefile(line={290},file={"Generator_CodePhp.ump"},javaline={376},length={25})
  public String translate(String keyName, UmpleClass aClass)
  {
    if ("constructorMandatory".equals(keyName))
    {
      return aClass.getGeneratedClass().getLookup("constructorSignature_mandatory");
    }
    else if ("packageDefinition".equals(keyName))
    {
      return aClass.getPackageName().length() == 0 ? "" : "package " + aClass.getPackageName() + ";"; 
    }
    else if ("type".equals(keyName))
    {
      return aClass.getName();
    } 
    else if ("isA".equals(keyName))
    {
     return getExtendAndImplements(aClass);
    }
    else if ("deleteMethod".equals(keyName))
    {
      return "delete";
    }
    
    return "UNKNOWN ID: " + keyName;
  }
  
  @umplesourcefile(line={316},file={"Generator_CodePhp.ump"},javaline={403},length={10})
  private String getExtendAndImplements(UmpleClass uClass)
  {
	  String extendsString = "";
	  String implementsString = "";

	  extendsString = getExtendClassesNames(uClass);
	  implementsString = getImplementsInterfacesNames(uClass);

	  return extendsString + implementsString; 
  }

  @umplesourcefile(line={327},file={"Generator_CodePhp.ump"},javaline={415},length={11})
  private String getExtendClassesNames(UmpleClass uClass)
  {
	  UmpleClass parent = uClass.getExtendsClass();
	  if (parent == null)
	  {
		  return "";
	  }
	  else{
		  return   " extends " + parent.getName();  
	  }
  }

  @umplesourcefile(line={339},file={"Generator_CodePhp.ump"},javaline={428},length={9})
  private String getImplementsInterfacesNames(UmpleClass uClass)
  {
	  if (uClass.hasParentInterface() == false){
		  return "";
	  }
	  else{
		 return " implements " +  uClass.getParentInterface().get(0).getName();
	  }
  }

  @umplesourcefile(line={349},file={"Generator_CodePhp.ump"},javaline={439},length={5})
  public String translate(String keyName, Attribute av)
  {
    boolean isMany = av.getIsList();
    return translate(keyName,av,isMany);
  }
  
  @umplesourcefile(line={355},file={"Generator_CodePhp.ump"},javaline={446},length={5})
  public String translate(String keyName, AssociationVariable av)
  {
    boolean isMany = av.isMany();
    return translate(keyName,av,isMany);
  }  
  
  @umplesourcefile(line={361},file={"Generator_CodePhp.ump"},javaline={453},length={98})
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
        return "date(\"y-m-d\", strtotime("+ av.getValue() +"))";      
      }
      else if (isString && "Time".equals(av.getType()))
      {
        return "date(\"h:i:s\", strtotime("+ av.getValue() +"))";
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
        String   callerNameToRemove = StringFormatter.format("${0}",translate("parameterOne",assVar));
        return StringFormatter.replaceParameter(generatedClassToRemove.getLookup("constructorSignature_caller"), callerNameToRemove, "$this");
      }
      else if ("methodArgumentsExcept".equals(keyName))
      {
        UmpleClass classToRemove = model.getUmpleClass(getType(assVar.getRelatedAssociation()));
        GeneratedClass generatedClassToRemove = classToRemove.getGeneratedClass();
        String parameterNameToRemove = StringFormatter.format("${0}", translate("parameterOne",assVar));
        return StringFormatter.replaceParameter(generatedClassToRemove.getLookup("constructorSignature"), parameterNameToRemove, ""); 
      }
      else if ("associationCanSet".equals(keyName))
      {
        String actualLookup = assVar.isMany() ? "associationCanSetMany" : "associationCanSetOne";
        return translate(actualLookup,av,isMany);
      }
      else if ("callerArgumentsForMandatory".equals(keyName))
      {
        UmpleClass classToLookup = model.getUmpleClass(getType(av));
        String lookup = "constructorSignature_mandatory_" + assVar.getRelatedAssociation().getName();
        String parameters = classToLookup.getGeneratedClass().getLookup(lookup);
        return parameters;
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
  
  @umplesourcefile(line={460},file={"Generator_CodePhp.ump"},javaline={553},length={41})
  public String translate(String keyName, State state)
  {
    String singularName = state.getName();
    String pluralName = model.getGlossary().getPlural(singularName);
    String fullStateName = StringFormatter.format("{0}{1}",getUpperCaseName(state.getStateMachine().getFullName()),getUpperCaseName(singularName));
  
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
    else if ("stateOne".equals(keyName))
    {
      return fullStateName;
    }
    else if ("stateString".equals(keyName))
    {
      return "\"" + fullStateName + "\"";
    }
    else if ("doActivityMethod".equals(keyName))
    {
      return StringFormatter.format("doActivity{0}", GeneratorHelper.getFullActivityName(state)); 
    }
    else if ("doActivityThread".equals(keyName))
    {
      return StringFormatter.format("doActivity{0}Thread", GeneratorHelper.getFullActivityName(state)); 
    }
    
    return "UNKNOWN ID: " + keyName;
  }
  
  @umplesourcefile(line={502},file={"Generator_CodePhp.ump"},javaline={596},length={45})
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
      return "String";
    }
    else if ("type".equals(keyName))
    {
      return "int";
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
  
  @umplesourcefile(line={548},file={"Generator_CodePhp.ump"},javaline={643},length={23})
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
  
  @umplesourcefile(line={572},file={"Generator_CodePhp.ump"},javaline={668},length={19})
  public void generate()
  {
    prepare();
    try{
      for (UmpleElement currentElement : model.getUmpleElements())
      {
        if ("external".equals(currentElement.getModifier()))
        {
          continue;
        }
        writeFile(currentElement);
      }
    }
    catch (Exception e)
    {
      throw new UmpleCompilerException("There was a problem with generating classes. " + e, e);
    }
    GeneratorHelper.postpare(model);
  }

  @umplesourcefile(line={592},file={"Generator_CodePhp.ump"},javaline={689},length={17})
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
  
  @umplesourcefile(line={610},file={"Generator_CodePhp.ump"},javaline={708},length={23})
  public static String typeOf(String aType)
  {
    if (aType == null || aType.length() == 0)
    {
      return "String";
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
      return "boolean";
    }
    else
    {
      return aType;
    }
  }
  
  @umplesourcefile(line={634},file={"Generator_CodePhp.ump"},javaline={733},length={26})
  private void writeFile(UmpleElement aElement)
  {
    try
    {
      ILang language = getLanguageFor(aElement);

      String path = StringFormatter.addPathOrAbsolute( 
    						  model.getUmpleFile().getPath(), 
        	                  getOutput());
      
      String filename = path + File.separator + aElement.getName() + ".php";
      File file = new File(path);
      file.mkdirs();

      BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
      String contents = language.getCode(model, aElement);
      model.getGeneratedCode().put(aElement.getName(),contents);
      bw.write(contents);
      bw.flush();
      bw.close();
    }
    catch (Exception e)
    {
      throw new UmpleCompilerException("There was a problem with generating classes. " + e, e);
    }
  }

  @umplesourcefile(line={661},file={"Generator_CodePhp.ump"},javaline={761},length={15})
  private String getUpperCaseName(String name)
  {
    if (name == null || name.length() == 0)
    {
      return name;
    }
    else if (name.length() == 1)
    {
      return name.toUpperCase();
    }
    else
    {
      return name.toUpperCase().charAt(0) + name.substring(1);
    }
  }
    
  @umplesourcefile(line={677},file={"Generator_CodePhp.ump"},javaline={778},length={136})
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
        String code = StringFormatter.format("if (!$this->{0}) { return false; }",translate("attributeCanSet",av));
        CodeInjection set = new CodeInjection("before",translate("setMethod",av) , code, aClass);
        set.setIsInternal(true);
        aClass.addCodeInjection(set);
      }
    
      if (aClass.getKey().isMember(av))
      {
        String code = StringFormatter.format("if (!$this->{0}) { return false; }",translate("attributeCanSet",av));
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
        String code = StringFormatter.format("if (!$this->{0}) { return false; }",translate("associationCanSet",av));
        String methods = StringFormatter.format("{0},{1},{2},{3},{4}",translate("addMethod",av),translate("removeMethod",av),translate("setManyMethod",av),translate("setMethod",av),translate("resetMethod",av));
        CodeInjection inject = new CodeInjection("before", methods, code, aClass);
        inject.setIsInternal(true);
        aClass.addCodeInjection(inject);
      }
      
      if (av.isImmutable())
      {
        String code = StringFormatter.format("if (!$this->{0}) { return false; }\n$this->{0} = false;",translate("associationCanSet",av));
        String methods = StringFormatter.format("{0},{1}",translate("setManyMethod",av),translate("setMethod",av));
        CodeInjection set = new CodeInjection("before", methods, code, aClass);
        set.setIsInternal(true);
        aClass.addCodeInjection(set);
      }
      
      if (av.isMany())
      {
        String code = StringFormatter.format("if ($this->{0}(${1}) !== -1) { return false; }",translate("indexOfMethod",av),translate("parameterOne",av));
        CodeInjection set = new CodeInjection("before",translate("addMethod",av) , code, aClass);
        set.setIsInternal(true);
        aClass.addCodeInjection(set);
      }
      
      if(av.isSorted())
      {
      	String codeblock = 
		      "{ |x, y| "+
                "x.get_"+av.getPriority() +"() <=> "+ 
                "y.get_"+ av.getPriority() +"()"+
                "}";
      	String java_code = StringFormatter.format("wasAdded = wasAdded ? Collections.sort({0}, {0}Priority) : false;\n",translate("attributeMany",av));
      	String php_code = StringFormatter.format("if(wasAdded)\n    usort($this->{0}, $this->{0}Priority);\n",translate("attributeMany",av));
        String ruby_code = StringFormatter.format("@{0}.sort! "+codeblock+" if wasAdded\n",translate("attributeMany",av));
        String methods = translate("addMethod",av);
        CodeInjection set = new CodeInjection("after", methods,"", aClass);
        CodeBlock cb = new CodeBlock();
        cb.setCode("Java",java_code);
        cb.setCode("Php",php_code);
        cb.setCode("Ruby",ruby_code);
        set.setSnippet(cb);
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
      						     "  throw new RuntimeException(\"Please provide a valid "+ cur.getConstrainedVariable() +"\");\n"+
                                 "}";
      	for (ConstraintVariable  expr: ac.getExpressions())
        {
          if( expr.getIsAttribute() )
          {
          	con_expression += "$"+translate("parameterOne",aClass.getAttribute(expr.getValue()));
            if (cur == expr) { 
        	  set_expression += "$"+translate("parameterOne",aClass.getAttribute(expr.getValue()));
            }
            else 
            { 
        	  set_expression += "$"+translate("attributeOne",aClass.getAttribute(expr.getValue()));
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
    	String precondition_code = StringFormatter.format(translate("NotClosed",pc),"throw new RuntimeException(\"Please provide a valid "+ translate("Values",pc) +"\");");
    	CodeInjection before = new CodeInjection("before", methodName+"Precondition", precondition_code, aClass);         
    	before.setIsInternal(true);
    	aClass.addCodeInjection(before);    
    }
	
    Map<String,String> lookups = new HashMap<String,String>();
    String executeMethods = "public static function handle($message) { self::getInstance()->addTrace($message); }\n";
    executeMethods += "public function reset() { self::getInstance()->traces = array(); }";
    lookups.put("consoleTracer","public static function handle($message) { print($message); }");
    lookups.put("fileTemplate","fileTracer(${0});");
    lookups.put("stringTracer",executeMethods);
    lookups.put("startTime","0");
    GeneratorHelper.prepareAllTracers(this,model,aClass,lookups);
//    prepareAllTraces(this,model,aClass,lookups);
	     
    for (StateMachine sm : aClass.getStateMachines())
    {
      prepareNestedStatesFor(sm,null,0);
    }    
    
  }
  
  

  @umplesourcefile(line={841},file={"Generator_CodePhp.ump"},javaline={943},length={10})
  private void prepareFinalStateFor(StateMachine sm, StateMachine parentSm)
  {
    Map<String,String> lookups = new HashMap<String,String>();
    
    String deleteActionCode;
    deleteActionCode = StringFormatter.format("$this->{0}();",translate("deleteMethod",sm.getUmpleClass()));

    lookups.put("deleteActionCode",deleteActionCode);
    GeneratorHelper.prepareFinalState(sm,lookups);
  }
  
  @umplesourcefile(line={852},file={"Generator_CodePhp.ump"},javaline={955},length={37})
  private void prepareNestedStatesFor(StateMachine sm, StateMachine parentSm, int concurrentIndex)
  {
    prepareFinalStateFor(sm,parentSm);  
    if (sm.getParentState() != null && sm.getStartState() != null)
    {
      State parentState = sm.getParentState();
      while(parentState.getStateMachine().getParentState() != null)
      {
        parentState = parentState.getStateMachine().getParentState();
      }
      Map<String,String> lookups = new HashMap<String,String>();
      lookups.put("entryEventName",translate("enterMethod",parentState));
      lookups.put("exitEventName",translate("exitMethod",parentState));
      lookups.put("parentEntryActionCode",StringFormatter.format("if ($this->{0} == self::${1}) { $this->{2}(self::${3}); }"
          ,translate("stateMachineOne",sm)
          ,translate("stateNull",sm)
          ,translate("setMethod",sm)
          ,translate("stateOne",sm.getStartState()))
      );
      lookups.put("parentExitActionCode",StringFormatter.format("$this->{0}();",translate("exitMethod",parentState)));
      GeneratorHelper.prepareNestedStateMachine(sm,concurrentIndex,lookups);  
    }

    for (State s : sm.getStates())
    {
      int nestedSmIndex = 0;
      for (StateMachine nestedSm : s.getNestedStateMachines())
      {
        prepareNestedStatesFor(nestedSm,sm,nestedSmIndex);
        nestedSmIndex += 1;
      }
    }
    
    Map<String,String> lookups = new HashMap<String,String>();
    lookups.put("callEvent","$this->{0}();");
    GeneratorHelper.prepareAutoTransitions(sm,this,lookups);    
  }  
  
  @umplesourcefile(line={890},file={"Generator_CodePhp.ump"},javaline={994},length={66})
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
    
      signature.append(StringFormatter.format("${0}",nameOf(av)));
      signatureCaller.append(StringFormatter.format("${0}",nameOf(av)));
    }

    for (AssociationVariable av : uClass.getAssociationVariables()) 
    {
      AssociationVariable relatedAv = av.getRelatedAssociation();

      if ((av.getMultiplicity().getLowerBound() == 0 && !av.isImmutable()) || !av.getIsNavigable())
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
      
      signature.append(StringFormatter.format("${0}",nameOf(av)));
      signatureCaller.append(StringFormatter.format("${0}",nameOf(av)));      
    }

    genClass.setLookup("constructorSignature", signature.toString());
    genClass.setLookup("constructorSignature_caller", signatureCaller.toString());
  }

  @umplesourcefile(line={957},file={"Generator_CodePhp.ump"},javaline={1062},length={4})
  private String nameOf(Attribute av)
  {
    return nameOf(av.getName(),av.getIsList());
  }
  
  @umplesourcefile(line={962},file={"Generator_CodePhp.ump"},javaline={1068},length={5})
  private String nameOf(AssociationVariable av)
  {
    boolean hasMultiple = av.isMany();
    return nameOf(av.getName(),hasMultiple);
  }
  
  @umplesourcefile(line={968},file={"Generator_CodePhp.ump"},javaline={1075},length={37})
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
        
        String selfParameter = StringFormatter.format("${0}",nameOf(relatedAv));
        String selfFor = StringFormatter.format("For{0}",av.getUpperCaseName());
        String newParameters = relatedGen.getLookup("constructorSignature");
        newParameters = StringFormatter.replaceParameter(newParameters, selfParameter, null);
        newParameters = StringFormatter.appendParameter(newParameters, selfFor);

        String relatedParameter = StringFormatter.format("${0}",nameOf(av));
        
        mandatorySignature = StringFormatter.replaceParameter(mandatorySignature, relatedParameter, newParameters);
        genClass.setLookup("constructorSignature_mandatory", mandatorySignature);
        
        String relatedFor = StringFormatter.format("For{0}",relatedAv.getUpperCaseName());
        String relatedCaller = genClass.getLookup("constructorSignature_caller");
        String relatedCallerParameter = StringFormatter.format("${0}",nameOf(av));
        String mandatorySignatureCaller = StringFormatter.replaceParameter(relatedCaller, relatedCallerParameter, "_THIS_");
        mandatorySignatureCaller = StringFormatter.appendParameter(mandatorySignatureCaller, relatedFor);
        mandatorySignatureCaller = StringFormatter.replaceParameter(mandatorySignatureCaller, "_THIS_" + relatedFor, "$thisInstance");
        
        String mandatoryCallerId = "constructorSignature_mandatory_" + relatedAv.getName();
        relatedGen.setLookup(mandatoryCallerId, mandatorySignatureCaller);
      }
    }
  }
  
  @umplesourcefile(line={1006},file={"Generator_CodePhp.ump"},javaline={1114},length={5})
  private void generateNullableConstructorSignature(GeneratedClass genClass)
  {
    String currentConstructor = genClass.getLookup("constructorSignature");
    genClass.setLookup("constructorSignature_nulled", StringFormatter.appendParameter(currentConstructor, " = null"));
  }
  

  @umplesourcefile(line={1013},file={"Generator_CodePhp.ump"},javaline={1122},length={15})
  private void addImports(UmpleClass aClass, GeneratedClass genClass)
  {      
    for (AssociationVariable av : aClass.getAssociationVariables()) 
    {
      if (!av.getIsNavigable())
      {
        continue;
      }
      
      if (av.isMany())
      {
        genClass.addMultiLookup("import", "java.util.*");
      }
    }
  }

  @umplesourcefile(line={1029},file={"Generator_CodePhp.ump"},javaline={1139},length={34})
  private void addRelatedImports()
  {
    for (UmpleClass aClass : model.getUmpleClasses())
    {
      GeneratedClass genClass = aClass.getGeneratedClass();
      
      if (aClass.getExtendsClass() != null)
      {
        if (!aClass.getPackageName().equals(aClass.getExtendsClass().getPackageName()))
        {
          genClass.addMultiLookup("import", aClass.getExtendsClass().getPackageName() + ".*");  
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
            relatedClass = relatedClass.getExtendsClass();
          }
        }
      }
    }
  }

}