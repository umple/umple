/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.util.*;
import java.io.*;
import cruise.umple.util.*;
import cruise.umple.compiler.exceptions.*;
import cruise.umple.compiler.cpp.*;

/**
 * @umplesource Generator.ump 248
 * @umplesource Generator_CodeCpp.ump 12
 */
// line 248 "../../../../src/Generator.ump"
// line 12 "../../../../src/Generator_CodeCpp.ump"
public class CppGenerator extends SuperCodeGenerator implements CodeTranslator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CppGenerator Attributes
  private boolean callHeader;
  private boolean callLttng;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CppGenerator()
  {
    super();
    callHeader = false;
    callLttng = false;
  }

  //------------------------
  // INTERFACE
  //------------------------

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

  public boolean getCallHeader()
  {
    return callHeader;
  }

  public boolean getCallLttng()
  {
    return callLttng;
  }

  public void delete()
  {
    super.delete();
  }

  @umplesourcefile(line={94},file={"Generator_CodeCpp.ump"},javaline={77},length={28})
   public void generate(){
    prepare();
    UmpleElement lastElement = null;
    try
    {
      for (UmpleElement currentElement : getModel().getUmpleElements())
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
    GeneratorHelper.postpare(getModel());
  }

  @umplesourcefile(line={125},file={"Generator_CodeCpp.ump"},javaline={107},length={25})
   public ILang getLanguageFor(UmpleElement aElement){
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

  @umplesourcefile(line={152},file={"Generator_CodeCpp.ump"},javaline={134},length={3})
   public boolean isNullable(UmpleVariable av){
    return !UmpleToPrimitiveMap.containsKey(av.getType());
  }

  @umplesourcefile(line={157},file={"Generator_CodeCpp.ump"},javaline={139},length={3})
   public String relatedTranslate(String name, AssociationVariable av){
    return translate(name,av.getRelatedAssociation());
  }

  @umplesourcefile(line={162},file={"Generator_CodeCpp.ump"},javaline={144},length={35})
   public String translate(String keyName, State state){
    String singularName = state.getName();
    String pluralName = getModel().getGlossary().getPlural(singularName);
  
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

  @umplesourcefile(line={199},file={"Generator_CodeCpp.ump"},javaline={181},length={44})
   public String translate(String keyName, StateMachine sm){
    String singularName = sm.getFullName();
    String pluralName = getModel().getGlossary().getPlural(singularName);
  
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

  @umplesourcefile(line={245},file={"Generator_CodeCpp.ump"},javaline={227},length={23})
   public String translate(String keyName, Event event){
    String singularName = event.getName();
    String pluralName = getModel().getGlossary().getPlural(singularName);

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

  @umplesourcefile(line={270},file={"Generator_CodeCpp.ump"},javaline={252},length={18})
   public String translate(String name, UmpleInterface aInterface){
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

  @umplesourcefile(line={290},file={"Generator_CodeCpp.ump"},javaline={272},length={30})
   public String translate(String methodType){
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

  @umplesourcefile(line={322},file={"Generator_CodeCpp.ump"},javaline={304},length={23})
   public String translateReturnType(String methodType){
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

  @umplesourcefile(line={347},file={"Generator_CodeCpp.ump"},javaline={329},length={26})
   public String translate(String name, UmpleClass aClass){
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

  @umplesourcefile(line={375},file={"Generator_CodeCpp.ump"},javaline={357},length={15})
   private String getImplementsForInterfaces(UmpleInterface uInterface){
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

  @umplesourcefile(line={392},file={"Generator_CodeCpp.ump"},javaline={374},length={9})
   private String getExtendAndImplements(UmpleClass uClass){
    String extendsString = "";
      String implementsString = "";

      extendsString = getExtendClassesNames(uClass);
      implementsString = getImplementsInterfacesNames(uClass);

      return extendsString + implementsString;
  }

  @umplesourcefile(line={403},file={"Generator_CodeCpp.ump"},javaline={385},length={10})
   private String getExtendClassesNames(UmpleClass uClass){
    UmpleClass parent = uClass.getExtendsClass();
      if (parent == null)
      {
          return "";
      }
      else{
          return   ": public " + parent.getName();  
      }
  }

  @umplesourcefile(line={415},file={"Generator_CodeCpp.ump"},javaline={397},length={15})
   private String getImplementsInterfacesNames(UmpleClass uClass){
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

  @umplesourcefile(line={432},file={"Generator_CodeCpp.ump"},javaline={414},length={3})
   public String translate(String keyName, Attribute av){
    return translate(keyName,av,av.getIsList());
  }

  @umplesourcefile(line={437},file={"Generator_CodeCpp.ump"},javaline={419},length={3})
   public String translate(String keyName, AssociationVariable av){
    return translate(keyName,av,av.isMany());
  }

  @umplesourcefile(line={442},file={"Generator_CodeCpp.ump"},javaline={424},length={98})
   private String translate(String keyName, UmpleVariable av, boolean isMany){
    if (OneOrManyLookup.contains(keyName))
    {
      String realKeyName = isMany ? keyName + "Many" : keyName + "One";
      return translate(realKeyName,av,isMany);
    }
    
    String singularName = isMany ? getModel().getGlossary().getSingular(av.getName()) : av.getName();
    String pluralName = isMany ? av.getName() : getModel().getGlossary().getPlural(av.getName());

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
        UmpleClass classToRemove = getModel().getUmpleClass(getType(assVar.getRelatedAssociation()));
        GeneratedClass generatedClassToRemove = classToRemove.getGeneratedClass();
        String   callerNameToRemove = translate("parameterOne",assVar);
        return StringFormatter.replaceParameter(generatedClassToRemove.getLookup("constructorSignature_caller"), callerNameToRemove, "this");
      }
      else if ("methodArgumentsExcept".equals(keyName))
      {
        UmpleClass classToRemove = getModel().getUmpleClass(getType(assVar.getRelatedAssociation()));
        GeneratedClass generatedClassToRemove = classToRemove.getGeneratedClass();
        String parameterNameToRemove = StringFormatter.format("{0} {1}", translate("type",assVar), translate("parameterOne",assVar));
        return StringFormatter.replaceParameter(generatedClassToRemove.getLookup("constructorSignature"), parameterNameToRemove, ""); 
      }
      else if ("callerArgumentsForMandatory".equals(keyName))
      {
        UmpleClass classToLookup = getModel().getUmpleClass(getType(av));
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

  @umplesourcefile(line={542},file={"Generator_CodeCpp.ump"},javaline={524},length={16})
   public void prepare(){
    List<UmpleClass> allClasses = new ArrayList<UmpleClass>(getModel().getUmpleClasses());
    for (UmpleClass aClass : allClasses)
    {
      prepare(aClass);
    }
    
    for (UmpleClass aClass : getModel().getUmpleClasses())
    {
      GeneratedClass genClass = aClass.getGeneratedClass();
      generateSecondaryConstructorSignatures(genClass);
      addImports(aClass,genClass);
    }
    
    addRelatedImports();
  }

  @umplesourcefile(line={560},file={"Generator_CodeCpp.ump"},javaline={542},length={22})
   public static  String typeOf(String aType){
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

  @umplesourcefile(line={584},file={"Generator_CodeCpp.ump"},javaline={566},length={16})
   public String nameOf(String name, boolean hasMultiple){
    if (name == null)
    {
      return null;
    }
    else if (hasMultiple)
    {
      //String pluralName = getModel().getGlossary().getPlural(name);
      return "all" + StringFormatter.toPascalCase(name);
    }
    else
    {
      //String singularName = getModel().getGlossary().getSingular(name);
      return "a" + StringFormatter.toPascalCase(name);
    }
  }


  /**
   * ------------------------
   * PRIVATE METHODS
   * ------------------------
   */
  @umplesourcefile(line={607},file={"Generator_CodeCpp.ump"},javaline={584},length={3})
   private String getUpperCaseName(String name){
    return StringFormatter.toPascalCase(name);
  }

  @umplesourcefile(line={612},file={"Generator_CodeCpp.ump"},javaline={595},length={141})
   private void prepare(UmpleClass aClass){
    if (aClass.getGeneratedClass() != null)
    {
      return;
    }
    else if (aClass.isRoot())
    {
      GeneratedClass genClass = aClass.createGeneratedClass(getModel());
      generateConstructorSignature(genClass);
    }
    else
    {
      UmpleClass parent = getModel().getUmpleClass(aClass.getExtendsClass().getName());
      prepare(parent);
      GeneratedClass genClass = aClass.createGeneratedClass(getModel());
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
      						     "  throw \"Please provide a valid "+ cur.getValue() +"\";\n"+
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
    	String precondition_code = StringFormatter.format(translate("NotClosed",pc),"throw \"Please provide a valid "+ pc.toString() +"\";");
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
    //GeneratorHelper.prepareAllStringTracers(this,getModel(),aClass,lookups);
    GeneratorHelper.prepareAllTracers(this,getModel(),aClass,lookups);

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

  @umplesourcefile(line={755},file={"Generator_CodeCpp.ump"},javaline={738},length={24})
   private boolean prepareTimedEvents(StateMachine sm){
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

  @umplesourcefile(line={781},file={"Generator_CodeCpp.ump"},javaline={764},length={28})
   private void prepareNestedStatesFor(StateMachine sm, int concurrentIndex){
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

  @umplesourcefile(line={811},file={"Generator_CodeCpp.ump"},javaline={794},length={69})
   private void generateConstructorSignature(GeneratedClass genClass){
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

  @umplesourcefile(line={882},file={"Generator_CodeCpp.ump"},javaline={865},length={36})
   private void generateSecondaryConstructorSignatures(GeneratedClass genClass){
    UmpleClass uClass = genClass.getUClass();
    
    String mandatorySignature = genClass.getLookup("constructorSignature");
    
    for (AssociationVariable av : uClass.getAssociationVariables()) 
    {
      AssociationVariable relatedAv = av.getRelatedAssociation();
      if (av.isOnlyOne() && relatedAv.isOnlyOne() && av.getIsNavigable() && relatedAv.getIsNavigable())
      {
        UmpleClass relatedClass = getModel().getUmpleClass(av.getType());
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

  @umplesourcefile(line={920},file={"Generator_CodeCpp.ump"},javaline={903},length={34})
   private void addRelatedImports(){
    for (UmpleClass aClass : getModel().getUmpleClasses())
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
          UmpleClass relatedClass = getModel().getUmpleClass(av.getType());
          while (relatedClass != null)
          {
            addAttributeImports(relatedClass,genClass);
            relatedClass = relatedClass.getExtendsClass();
          }
        }
      }
    }
  }

  @umplesourcefile(line={956},file={"Generator_CodeCpp.ump"},javaline={939},length={26})
   private void addAttributeImports(UmpleClass aClass, GeneratedClass genClass){
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

  @umplesourcefile(line={984},file={"Generator_CodeCpp.ump"},javaline={967},length={24})
   private void addImports(UmpleClass aClass, GeneratedClass genClass){
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

  @umplesourcefile(line={1010},file={"Generator_CodeCpp.ump"},javaline={993},length={3})
   private String nameOf(Attribute av){
    return nameOf(av.getName(),av.getIsList());
  }

  @umplesourcefile(line={1015},file={"Generator_CodeCpp.ump"},javaline={998},length={4})
   private String nameOf(AssociationVariable av){
    boolean hasMultiple = av.isMany();
    return nameOf(av.getName(),hasMultiple);
  }

  @umplesourcefile(line={1021},file={"Generator_CodeCpp.ump"},javaline={1004},length={8})
   private static  String typeOf(UmpleVariable var){
    String aType = var.getType();
    if (aType =="String")
    {
    	return "string";
    }
    return typeOf(aType);
  }


  /**
   * return applicable tracepoints arguments based on attribute type
   */
  @umplesourcefile(line={1032},file={"Generator_CodeCpp.ump"},javaline={1014},length={9})
   private String getTpArguments(String t){
    if (t.equals("String"))
			return "TP_ARGS(char *, text),\n";
		if (t.equals("Integer"))
			return "TP_ARGS(int, intfield),\n";
		if (t.equals("Double"))
			return "TP_ARGS(double, doublefield),\n";
		return "";
  }


  /**
   * tracepoint message
   */
  @umplesourcefile(line={1043},file={"Generator_CodeCpp.ump"},javaline={1029},length={13})
   private String getTpMessage(String t){
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


  /**
   * get TP field: n name, t type
   */
  @umplesourcefile(line={1061},file={"Generator_CodeCpp.ump"},javaline={1048},length={13})
   private String getTpField(String t, String n){
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

  @umplesourcefile(line={1076},file={"Generator_CodeCpp.ump"},javaline={1067},length={14})
   private String getTpLogLevel(String t){
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

  @umplesourcefile(line={1093},file={"Generator_CodeCpp.ump"},javaline={1083},length={13})
   private String processLttngfile(Attribute att){
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


  /**
   * Process Lttng tracepoints for state machines, treating state as String.
   */
  @umplesourcefile(line={1109},file={"Generator_CodeCpp.ump"},javaline={1098},length={24})
   private String processLttngFile(StateMachineTraceItem smti){
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

  @umplesourcefile(line={1232},file={"Generator_CodeCpp.ump"},javaline={1128},length={29})
   public void initializeLangaugeBasedVariables(){
    UmpleToPrimitiveMap.put("Integer","int");
   	UmpleToPrimitiveMap.put("Boolean","bool");
   	UmpleToPrimitiveMap.put("Double","double");
   	UmpleToPrimitiveMap.put("Float","float");
   	UmpleToPrimitiveMap.put("String","string");	
   	//
   	TraceLookupMap.put("indent","    ");
   	TraceLookupMap.put("template","{0}Tracer.handle( {1} );");
  	TraceLookupMap.put("timestamp","new Date()");
   	TraceLookupMap.put("identifier","System.identityHashCode({0})");
   	TraceLookupMap.put("thread","Thread.currentThread().getId()");
   	TraceLookupMap.put("self","this");
   	//
    ConstraintLookupMap.put("==",".equals({0})");
    ConstraintLookupMap.put("accessor","");
    ConstraintLookupMap.put("ifstatement","if ({0})\n{");
    ConstraintLookupMap.put("end","}");
    ConstraintLookupMap.put("[]","{1}.get({0})");
    ConstraintLookupMap.put("initialise","new {0}");
    ConstraintLookupMap.put("has",".contains({0})");
    ConstraintLookupMap.put("hasAll",".contains({0})");
    ConstraintLookupMap.put("cardinality==",".size()=={0}");
    ConstraintLookupMap.put("cardinality!=",".size()!={0}");
    ConstraintLookupMap.put("cardinality>=",".size()>={0}");
    ConstraintLookupMap.put("cardinality<=",".size()<={0}");
    ConstraintLookupMap.put("cardinality>",".size()>{0}");
    ConstraintLookupMap.put("cardinality<",".size()<{0}");
  }

  @umplesourcefile(line={31},file={"Generator.ump"},javaline={1159},length={149})
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

  @umplesourcefile(line={32},file={"Generator.ump"},javaline={1310},length={10})
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


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "callHeader" + ":" + getCallHeader()+ "," +
            "callLttng" + ":" + getCallLttng()+ "]"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={15},file={"Generator_CodeCpp.ump"},javaline={1334},length={185})
  private static Map<String,String> UpperCaseSingularLookupMap ;

//  @umplesourcefile(line={16},file={"Generator_CodeCpp.ump"},javaline={1337},length={182})
  private static Map<String,String> UpperCasePluralLookupMap ;

//  @umplesourcefile(line={17},file={"Generator_CodeCpp.ump"},javaline={1340},length={179})
  private static Map<String,String> AsIsSingularLookupMap ;

//  @umplesourcefile(line={18},file={"Generator_CodeCpp.ump"},javaline={1343},length={176})
  private static Map<String,String> AsIsPluralLookupMap ;

//  @umplesourcefile(line={19},file={"Generator_CodeCpp.ump"},javaline={1346},length={173})
  private static List<String> OneOrManyLookup ;

//  @umplesourcefile(line={21},file={"Generator_CodeCpp.ump"},javaline={1349},length={170})
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
  }

//  @umplesourcefile(line={1134},file={"Generator_CodeCpp.ump"},javaline={1422},length={97})
  @umplesourcefile(line={1135},file={"Generator_CodeCpp.ump"},javaline={1423},length={15})
  public void writeLttngFile(String name, String tp_code, String path) throws IOException 
  {
    String lttngFileName = path + File.separator + name + "_tracepoint.tp";
		BufferedWriter lttngBw = new BufferedWriter(new FileWriter(lttngFileName));
		String lttngContent = tp_code.toString();
		//System.out.println(tp_code);
		getModel().getGeneratedCode().put(name +"_tp",lttngContent);
		try {
			lttngBw.write(lttngContent);
			lttngBw.flush();
		}
			finally {
			lttngBw.close();
		}
  }

//  @umplesourcefile(line={1151},file={"Generator_CodeCpp.ump"},javaline={1440},length={80})
  @umplesourcefile(line={1152},file={"Generator_CodeCpp.ump"},javaline={1441},length={66})
  private void writeFile(UmpleElement aClass) throws IOException 
  {
    ILang language = getLanguageFor(aClass);
    ILang headerlanguage = getLanguageFor(aClass);

    String path = StringFormatter.addPathOrAbsolute( 
    						  getModel().getUmpleFile().getPath(), 
        	                  getOutput()) + 
        	                  aClass.getPackageName().replace(".", File.separator);
   File file = new File(path);
    file.mkdirs();
  
    String filename = (aClass instanceof UmpleClass) ? (path + File.separator + aClass.getName() + ".cpp"):(path + File.separator + aClass.getName() + ".h");
    BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
    String contents = language.getCode(getModel(), aClass);
    getModel().getGeneratedCode().put(aClass.getName(),contents);
  
    
    
    //creating a header file for each class created. #header
    String hfilename = path + File.separator + aClass.getName() + ".h";
    BufferedWriter hbw = new BufferedWriter(new FileWriter(hfilename));
    String headerContent = headerlanguage.getCode(getModel(), aClass);
    getModel().getGeneratedCode().put(aClass.getName()+"_header",headerContent);
    
    //creating and writing tracepoint files for LTTng #lttng
    if (aClass instanceof UmpleClass)
    {
      	UmpleClass uClass = (UmpleClass) aClass;
    	
      	if( callLttng = true)
		{
      	if (getModel().getTraceType().equals("Lttng") && uClass.hasTraceDirectives() && callHeader == false)
    	{     		 
      		//ILang lttngLang = new CppLttngGenerator();
    		//lttngLang.getCode(getModel(), aClass);    	
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
    /*if (aClass instanceof UmpleInterface && getModel().getTraceType().equals("Lttng"))
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