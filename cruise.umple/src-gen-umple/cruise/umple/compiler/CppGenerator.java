/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.util.*;
import java.io.*;
import cruise.umple.util.*;
import cruise.umple.compiler.exceptions.*;
import cruise.umple.compiler.cpp.*;

/**
 * @umplesource Generator.ump 247
 * @umplesource Generator_CodeCpp.ump 11
 */
// line 247 "../../../../src/Generator.ump"
// line 11 "../../../../src/Generator_CodeCpp.ump"
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

  @umplesourcefile(line={96},file={"Generator_CodeCpp.ump"},javaline={78},length={28})
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

  @umplesourcefile(line={127},file={"Generator_CodeCpp.ump"},javaline={108},length={25})
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

  @umplesourcefile(line={154},file={"Generator_CodeCpp.ump"},javaline={135},length={3})
   public boolean isNullable(UmpleVariable av){
    return !UmpleToPrimitiveMap.containsKey(av.getType());
  }

  @umplesourcefile(line={159},file={"Generator_CodeCpp.ump"},javaline={140},length={3})
   public String relatedTranslate(String name, AssociationVariable av){
    return translate(name,av.getRelatedAssociation());
  }

  @umplesourcefile(line={164},file={"Generator_CodeCpp.ump"},javaline={145},length={35})
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

  @umplesourcefile(line={201},file={"Generator_CodeCpp.ump"},javaline={182},length={44})
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

  @umplesourcefile(line={247},file={"Generator_CodeCpp.ump"},javaline={228},length={23})
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

  @umplesourcefile(line={272},file={"Generator_CodeCpp.ump"},javaline={253},length={18})
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

  @umplesourcefile(line={292},file={"Generator_CodeCpp.ump"},javaline={273},length={30})
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

  @umplesourcefile(line={324},file={"Generator_CodeCpp.ump"},javaline={305},length={23})
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

  @umplesourcefile(line={349},file={"Generator_CodeCpp.ump"},javaline={330},length={26})
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

  @umplesourcefile(line={377},file={"Generator_CodeCpp.ump"},javaline={358},length={15})
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

  @umplesourcefile(line={394},file={"Generator_CodeCpp.ump"},javaline={375},length={9})
   private String getExtendAndImplements(UmpleClass uClass){
    String extendsString = "";
      String implementsString = "";

      extendsString = getExtendClassesNames(uClass);
      implementsString = getImplementsInterfacesNames(uClass);

      return extendsString + implementsString;
  }

  @umplesourcefile(line={405},file={"Generator_CodeCpp.ump"},javaline={386},length={10})
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

  @umplesourcefile(line={417},file={"Generator_CodeCpp.ump"},javaline={398},length={15})
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

  @umplesourcefile(line={434},file={"Generator_CodeCpp.ump"},javaline={415},length={3})
   public String translate(String keyName, Attribute av){
    return translate(keyName,av,av.getIsList());
  }

  @umplesourcefile(line={439},file={"Generator_CodeCpp.ump"},javaline={420},length={3})
   public String translate(String keyName, AssociationVariable av){
    return translate(keyName,av,av.isMany());
  }


  /**
   * This method currently returns the String value of a Date or Time object to stay consistent with how C++ code is generated for classes
   */
  @umplesourcefile(line={444},file={"Generator_CodeCpp.ump"},javaline={425},length={22})
   public String translateInterfaceValue(String value, String type){
    if (value == null)
    {
      return "null";
    }
      
    boolean isString = value.startsWith("\"") && value.endsWith("\"");
    if (isString && "Date".equals(type))
    {
      //return "Date.valueOf("+ value +")";   
      return value;   
    }
    else if (isString && "Time".equals(type))
    {
      //return "Time.valueOf("+ value +")";
      return value;
    }
    else
    {
      return value;
    }
  }


  /**
   * Translates primitive data types to their C++ equivalent. Used for interfaces as they do not use attributes.
   */
  @umplesourcefile(line={469},file={"Generator_CodeCpp.ump"},javaline={453},length={3})
   public String translateInterfaceType(String type){
    return typeOf(type);
  }

  @umplesourcefile(line={474},file={"Generator_CodeCpp.ump"},javaline={462},length={110})
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
      else if ("hasUniqueMethod".equals(keyName)) 
      {
        return "hasWith" + attVar.getUpperCaseName();
      } 
      else if ("getUniqueMethod".equals(keyName))
      {
        return "getWith" + attVar.getUpperCaseName();
      }
      else if ("uniqueMap".equals(keyName))
      {
        return attVar.getUmpleClass().getName().toLowerCase() + "s" + "By" + attVar.getUpperCaseName();
      }
    }
    
    return "UNKNOWN ID: " + keyName;
  }

  @umplesourcefile(line={586},file={"Generator_CodeCpp.ump"},javaline={574},length={16})
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

  @umplesourcefile(line={604},file={"Generator_CodeCpp.ump"},javaline={592},length={38})
   public static  String typeOf(String aType){
    if (aType == null || aType.length() == 0)
    {
      return "string";
    }
    else if (aType.equals("String"))
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
    else if (aType.equals("Float"))
    {
      return "float";
    }
    else if (aType.equals("Boolean"))
    {
      return "bool";
    }
    else if(aType.equals("Date"))
    {
      return "string";
    }
    else if(aType.equals("Time"))
    {
      return "time_t*";
    }
    else
    {
      return aType;
    }
  }

  @umplesourcefile(line={644},file={"Generator_CodeCpp.ump"},javaline={632},length={16})
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
  @umplesourcefile(line={667},file={"Generator_CodeCpp.ump"},javaline={650},length={3})
   private String getUpperCaseName(String name){
    return StringFormatter.toPascalCase(name);
  }

  @umplesourcefile(line={672},file={"Generator_CodeCpp.ump"},javaline={661},length={86})
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
    
    prepareConstraints(aClass);
    
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

  @umplesourcefile(line={760},file={"Generator_CodeCpp.ump"},javaline={749},length={24})
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

  @umplesourcefile(line={786},file={"Generator_CodeCpp.ump"},javaline={775},length={28})
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

  @umplesourcefile(line={816},file={"Generator_CodeCpp.ump"},javaline={805},length={69})
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

  @umplesourcefile(line={887},file={"Generator_CodeCpp.ump"},javaline={876},length={36})
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

  @umplesourcefile(line={925},file={"Generator_CodeCpp.ump"},javaline={914},length={34})
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

  @umplesourcefile(line={961},file={"Generator_CodeCpp.ump"},javaline={950},length={26})
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

  @umplesourcefile(line={989},file={"Generator_CodeCpp.ump"},javaline={978},length={24})
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

  @umplesourcefile(line={1015},file={"Generator_CodeCpp.ump"},javaline={1004},length={3})
   private String nameOf(Attribute av){
    return nameOf(av.getName(),av.getIsList());
  }

  @umplesourcefile(line={1020},file={"Generator_CodeCpp.ump"},javaline={1009},length={4})
   private String nameOf(AssociationVariable av){
    boolean hasMultiple = av.isMany();
    return nameOf(av.getName(),hasMultiple);
  }

  @umplesourcefile(line={1026},file={"Generator_CodeCpp.ump"},javaline={1015},length={8})
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
  @umplesourcefile(line={1037},file={"Generator_CodeCpp.ump"},javaline={1025},length={9})
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
  @umplesourcefile(line={1048},file={"Generator_CodeCpp.ump"},javaline={1040},length={13})
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
  @umplesourcefile(line={1066},file={"Generator_CodeCpp.ump"},javaline={1059},length={13})
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

  @umplesourcefile(line={1081},file={"Generator_CodeCpp.ump"},javaline={1078},length={14})
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

  @umplesourcefile(line={1098},file={"Generator_CodeCpp.ump"},javaline={1094},length={13})
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
  @umplesourcefile(line={1113},file={"Generator_CodeCpp.ump"},javaline={1109},length={24})
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

  @umplesourcefile(line={1236},file={"Generator_CodeCpp.ump"},javaline={1139},length={31})
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
    ConstraintLookupMap.put("paramaccessor","");
    ConstraintLookupMap.put("exception","throw \"Please provide a valid{0}\";");
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

  @umplesourcefile(line={31},file={"Generator.ump"},javaline={1171},length={128})
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

  @umplesourcefile(line={32},file={"Generator.ump"},javaline={1301},length={10})
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
  //  @umplesourcefile(line={15},file={"Generator_CodeCpp.ump"},javaline={1325},length={181})
  private static Map<String,String> UpperCaseSingularLookupMap ;
//  @umplesourcefile(line={16},file={"Generator_CodeCpp.ump"},javaline={1327},length={179})
  private static Map<String,String> UpperCasePluralLookupMap ;
//  @umplesourcefile(line={17},file={"Generator_CodeCpp.ump"},javaline={1329},length={177})
  private static Map<String,String> AsIsSingularLookupMap ;
//  @umplesourcefile(line={18},file={"Generator_CodeCpp.ump"},javaline={1331},length={175})
  private static Map<String,String> AsIsPluralLookupMap ;
//  @umplesourcefile(line={19},file={"Generator_CodeCpp.ump"},javaline={1333},length={173})
  private static List<String> OneOrManyLookup ;

//  @umplesourcefile(line={21},file={"Generator_CodeCpp.ump"},javaline={1336},length={170})
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

//  @umplesourcefile(line={1137},file={"Generator_CodeCpp.ump"},javaline={1409},length={97})
  @umplesourcefile(line={1138},file={"Generator_CodeCpp.ump"},javaline={1410},length={15})
  public void writeLttngFile (String name, String tp_code, String path) throws IOException 
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

//  @umplesourcefile(line={1154},file={"Generator_CodeCpp.ump"},javaline={1427},length={80})
  @umplesourcefile(line={1155},file={"Generator_CodeCpp.ump"},javaline={1428},length={66})
  private void writeFile (UmpleElement aClass) throws IOException 
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