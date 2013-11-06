/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.util.*;
import java.io.*;
import cruise.umple.util.*;
import cruise.umple.compiler.exceptions.*;
import cruise.umple.compiler.php.*;

/**
 * @umplesource Generator.ump 260
 * @umplesource Generator_CodePhp.ump 11
 */
// line 260 "../../../../src/Generator.ump"
// line 11 "../../../../src/Generator_CodePhp.ump"
public class PhpGenerator extends SuperCodeGenerator implements CodeTranslator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PhpGenerator()
  {
    super();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }

  @umplesourcefile(line={101},file={"Generator_CodePhp.ump"},javaline={46},length={17})
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
      generateNullableConstructorSignature(genClass);
      addImports(aClass,genClass);
    }

    addRelatedImports();
  }

  @umplesourcefile(line={120},file={"Generator_CodePhp.ump"},javaline={65},length={3})
   public boolean isNullable(UmpleVariable av){
    return true;
  }

  @umplesourcefile(line={125},file={"Generator_CodePhp.ump"},javaline={70},length={3})
   public String relatedTranslate(String name, AssociationVariable av){
    return translate(name,av.getRelatedAssociation());
  }

  @umplesourcefile(line={130},file={"Generator_CodePhp.ump"},javaline={75},length={13})
   public ILang getLanguageFor(UmpleElement aElement){
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

  @umplesourcefile(line={145},file={"Generator_CodePhp.ump"},javaline={90},length={7})
   public String translate(String name, UmpleInterface aInterface){
    if ("packageDefinition".equals(name))
    {
      return aInterface.getPackageName().length() == 0 ? "" : "package " + aInterface.getPackageName() + ";"; 
    }
    return "UNKNOWN ID: " + name;
  }

  @umplesourcefile(line={154},file={"Generator_CodePhp.ump"},javaline={99},length={15})
   public String translate(String methodType){
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

  @umplesourcefile(line={171},file={"Generator_CodePhp.ump"},javaline={116},length={24})
   public String translate(String keyName, UmpleClass aClass){
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

  @umplesourcefile(line={197},file={"Generator_CodePhp.ump"},javaline={142},length={9})
   private String getExtendAndImplements(UmpleClass uClass){
    String extendsString = "";
	  String implementsString = "";

	  extendsString = getExtendClassesNames(uClass);
	  implementsString = getImplementsInterfacesNames(uClass);

	  return extendsString + implementsString;
  }

  @umplesourcefile(line={208},file={"Generator_CodePhp.ump"},javaline={153},length={10})
   private String getExtendClassesNames(UmpleClass uClass){
    UmpleClass parent = uClass.getExtendsClass();
	  if (parent == null)
	  {
		  return "";
	  }
	  else{
		  return   " extends " + parent.getName();  
	  }
  }

  @umplesourcefile(line={220},file={"Generator_CodePhp.ump"},javaline={165},length={8})
   private String getImplementsInterfacesNames(UmpleClass uClass){
    if (uClass.hasParentInterface() == false){
		  return "";
	  }
	  else{
		 return " implements " +  uClass.getParentInterface().get(0).getName();
	  }
  }

  @umplesourcefile(line={230},file={"Generator_CodePhp.ump"},javaline={175},length={4})
   public String translate(String keyName, Attribute av){
    boolean isMany = av.getIsList();
    return translate(keyName,av,isMany);
  }

  @umplesourcefile(line={236},file={"Generator_CodePhp.ump"},javaline={181},length={4})
   public String translate(String keyName, AssociationVariable av){
    boolean isMany = av.isMany();
    return translate(keyName,av,isMany);
  }

  @umplesourcefile(line={242},file={"Generator_CodePhp.ump"},javaline={187},length={113})
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
        UmpleClass classToRemove = getModel().getUmpleClass(getType(assVar.getRelatedAssociation()));
        GeneratedClass generatedClassToRemove = classToRemove.getGeneratedClass();
        String   callerNameToRemove = StringFormatter.format("${0}",translate("parameterOne",assVar));
        return StringFormatter.replaceParameter(generatedClassToRemove.getLookup("constructorSignature_caller"), callerNameToRemove, "$this");
      }
      else if ("methodArgumentsExcept".equals(keyName))
      {
        UmpleClass classToRemove = getModel().getUmpleClass(getType(assVar.getRelatedAssociation()));
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
        UmpleClass classToLookup = getModel().getUmpleClass(getType(av));
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
      else if ("hasUniqueMethod".equals(keyName)) 
      {
        return "hasWith" + attVar.getUpperCaseName();
      } 
      else if ("getUniqueMethod".equals(keyName))
      {
        return "getWith" + attVar.getUpperCaseName();
      }
      else if ("getUniqueMap".equals(keyName))
      {
        return attVar.getUmpleClass().getName() + "::$" + translate("uniqueMap", av, isMany);
      }
      else if ("uniqueMap".equals(keyName))
      {
        return attVar.getUmpleClass().getName().toLowerCase() + "s" + "By" + attVar.getUpperCaseName();
      }
    }    
    return "UNKNOWN ID: " + keyName;
  }

  @umplesourcefile(line={357},file={"Generator_CodePhp.ump"},javaline={302},length={40})
   public String translate(String keyName, State state){
    String singularName = state.getName();
    String pluralName = getModel().getGlossary().getPlural(singularName);
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

  @umplesourcefile(line={399},file={"Generator_CodePhp.ump"},javaline={344},length={44})
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

  @umplesourcefile(line={445},file={"Generator_CodePhp.ump"},javaline={390},length={22})
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

  @umplesourcefile(line={469},file={"Generator_CodePhp.ump"},javaline={414},length={18})
   public void generate(){
    prepare();
    try{
      for (UmpleElement currentElement : getModel().getUmpleElements())
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
    GeneratorHelper.postpare(getModel());
  }

  @umplesourcefile(line={489},file={"Generator_CodePhp.ump"},javaline={434},length={16})
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

  @umplesourcefile(line={507},file={"Generator_CodePhp.ump"},javaline={452},length={22})
   public static  String typeOf(String aType){
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

  @umplesourcefile(line={531},file={"Generator_CodePhp.ump"},javaline={476},length={25})
   private void writeFile(UmpleElement aElement){
    try
    {
      ILang language = getLanguageFor(aElement);

      String path = StringFormatter.addPathOrAbsolute( 
    						  getModel().getUmpleFile().getPath(), 
        	                  getOutput());
      
      String filename = path + File.separator + aElement.getName() + ".php";
      File file = new File(path);
      file.mkdirs();

      BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
      String contents = language.getCode(getModel(), aElement);
      getModel().getGeneratedCode().put(aElement.getName(),contents);
      bw.write(contents);
      bw.flush();
      bw.close();
    }
    catch (Exception e)
    {
      throw new UmpleCompilerException("There was a problem with generating classes. " + e, e);
    }
  }

  @umplesourcefile(line={558},file={"Generator_CodePhp.ump"},javaline={503},length={14})
   private String getUpperCaseName(String name){
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

  @umplesourcefile(line={574},file={"Generator_CodePhp.ump"},javaline={519},length={12})
   private void injectIntoUnique(String method, String injection, String when, Attribute av, UmpleClass aClass){
    String code = StringFormatter.format(injection,
      av.getName(),
      translate("parameterOne", av),
      translate("parameterOld", av),
      translate("getMethod", av),
      translate("hasUniqueMethod", av),
      translate("getUniqueMap", av),
      av.getUmpleClass().getName());
    CodeInjection set = new CodeInjection(when, method, code, aClass);
    aClass.addCodeInjection(set);
  }

  @umplesourcefile(line={588},file={"Generator_CodePhp.ump"},javaline={533},length={3})
   private void injectIntoUniqueSet(String injection, String when, Attribute av, UmpleClass aClass){
    injectIntoUnique(translate("setMethod", av), injection, when, av, aClass);
  }

  @umplesourcefile(line={593},file={"Generator_CodePhp.ump"},javaline={538},length={3})
   private void injectIntoUniqueDelete(String injection, String when, Attribute av, UmpleClass aClass){
    injectIntoUnique("delete", injection, when, av, aClass);
  }

  @umplesourcefile(line={598},file={"Generator_CodePhp.ump"},javaline={543},length={123})
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
      
      if (av.getIsUnique())
      {
        injectIntoUniqueSet(
          "if (isset($this->{0})) {" + "\n" +
          "  ${2} = $this->{3}();" + "\n" + 
          "}" + "\n" + 
          "if ({6}::{4}(${1})) {" + "\n" + 
          "  return $wasSet;" + "\n" +
          "}", "before", av, aClass);
        injectIntoUniqueSet(
          "if (isset(${2})) {" + "\n" +
          "  unset({5}[(string)${2}]);" + "\n" +
          "}" + "\n" +
          "{5}[(string)${1}] = $this;", "after", av, aClass);
        injectIntoUniqueDelete(
          "unset({5}[(string)$this->{3}()]);", "before", av, aClass);
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
    
    prepareConstraints(aClass);
	
    Map<String,String> lookups = new HashMap<String,String>();
    String executeMethods = "public static function handle($message) { self::getInstance()->addTrace($message); }\n";
    executeMethods += "public function reset() { self::getInstance()->traces = array(); }";
    lookups.put("consoleTracer","public static function handle($message) { print($message); }");
    lookups.put("fileTemplate","fileTracer(${0});");
    lookups.put("stringTracer",executeMethods);
    lookups.put("startTime","0");
    GeneratorHelper.prepareAllTracers(this,getModel(),aClass,lookups);
//    prepareAllTraces(this,getModel(),aClass,lookups);
	     
    for (StateMachine sm : aClass.getStateMachines())
    {
      prepareNestedStatesFor(sm,null,0);
    }
  }

  @umplesourcefile(line={726},file={"Generator_CodePhp.ump"},javaline={668},length={9})
   private void prepareFinalStateFor(StateMachine sm, StateMachine parentSm){
    Map<String,String> lookups = new HashMap<String,String>();
    
    String deleteActionCode;
    deleteActionCode = StringFormatter.format("$this->{0}();",translate("deleteMethod",sm.getUmpleClass()));

    lookups.put("deleteActionCode",deleteActionCode);
    GeneratorHelper.prepareFinalState(sm,lookups);
  }

  @umplesourcefile(line={737},file={"Generator_CodePhp.ump"},javaline={679},length={36})
   private void prepareNestedStatesFor(StateMachine sm, StateMachine parentSm, int concurrentIndex){
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

  @umplesourcefile(line={775},file={"Generator_CodePhp.ump"},javaline={717},length={65})
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

  @umplesourcefile(line={842},file={"Generator_CodePhp.ump"},javaline={784},length={3})
   private String nameOf(Attribute av){
    return nameOf(av.getName(),av.getIsList());
  }

  @umplesourcefile(line={847},file={"Generator_CodePhp.ump"},javaline={789},length={4})
   private String nameOf(AssociationVariable av){
    boolean hasMultiple = av.isMany();
    return nameOf(av.getName(),hasMultiple);
  }

  @umplesourcefile(line={853},file={"Generator_CodePhp.ump"},javaline={795},length={36})
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

  @umplesourcefile(line={891},file={"Generator_CodePhp.ump"},javaline={833},length={4})
   private void generateNullableConstructorSignature(GeneratedClass genClass){
    String currentConstructor = genClass.getLookup("constructorSignature");
    genClass.setLookup("constructorSignature_nulled", StringFormatter.appendParameter(currentConstructor, " = null"));
  }

  @umplesourcefile(line={898},file={"Generator_CodePhp.ump"},javaline={839},length={14})
   private void addImports(UmpleClass aClass, GeneratedClass genClass){
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

  @umplesourcefile(line={914},file={"Generator_CodePhp.ump"},javaline={855},length={33})
   private void addRelatedImports(){
    for (UmpleClass aClass : getModel().getUmpleClasses())
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
          UmpleClass relatedClass = getModel().getUmpleClass(av.getType());
          while (relatedClass != null)
          {
            relatedClass = relatedClass.getExtendsClass();
          }
        }
      }
    }
  }

  @umplesourcefile(line={948},file={"Generator_CodePhp.ump"},javaline={890},length={32})
   public void initializeLangaugeBasedVariables(){
    UmpleToPrimitiveMap.put("String","String");
	//
	TraceLookupMap.put("concatinator",".");
    TraceLookupMap.put("accessor","$this->");
    TraceLookupMap.put("indent","    ");
    TraceLookupMap.put("template","{0}Tracer::handle( {1} );");
    TraceLookupMap.put("timestamp","gettimeofday(true)");
    TraceLookupMap.put("identifier","spl_object_hash( {0} )");
    TraceLookupMap.put("thread","uniqid()");
    TraceLookupMap.put("self","$this");
    TraceLookupMap.put("increment","{0}++;");
    //
    ConstraintLookupMap.put("==","=={0}");
    ConstraintLookupMap.put("accessor","$");
    ConstraintLookupMap.put("paramaccessor","$");
    ConstraintLookupMap.put("exception","throw new RuntimeException(\"Please provide a valid{0}\");");
    ConstraintLookupMap.put("ifstatement","if ({0})\n{");
    ConstraintLookupMap.put("end","}");
    ConstraintLookupMap.put(".","->{0}");
    ConstraintLookupMap.put("this","$this");
    ConstraintLookupMap.put("[]","{1}[{0}]");
    ConstraintLookupMap.put("initialise","new {0}");
    ConstraintLookupMap.put("has","in_array({0},{1})");
    ConstraintLookupMap.put("hasAll","in_array({0},{1})");
    ConstraintLookupMap.put("cardinality==","count({1})=={0}");
    ConstraintLookupMap.put("cardinality!=","count({1})!={0}");
    ConstraintLookupMap.put("cardinality>=","count({1})>={0}");
    ConstraintLookupMap.put("cardinality<=","count({1})<={0}");
    ConstraintLookupMap.put("cardinality>","count({1})>{0}");
    ConstraintLookupMap.put("cardinality<","count({1})<{0}");
  }

  @umplesourcefile(line={31},file={"Generator.ump"},javaline={923},length={128})
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

  @umplesourcefile(line={32},file={"Generator.ump"},javaline={1053},length={10})
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
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={14},file={"Generator_CodePhp.ump"},javaline={1068},length={93})
  private static Map<String,String> UpperCaseSingularLookupMap ;

//  @umplesourcefile(line={15},file={"Generator_CodePhp.ump"},javaline={1071},length={90})
  private static Map<String,String> UpperCasePluralLookupMap ;

//  @umplesourcefile(line={16},file={"Generator_CodePhp.ump"},javaline={1074},length={87})
  private static Map<String,String> AsIsSingularLookupMap ;

//  @umplesourcefile(line={17},file={"Generator_CodePhp.ump"},javaline={1077},length={84})
  private static Map<String,String> AsIsPluralLookupMap ;

//  @umplesourcefile(line={18},file={"Generator_CodePhp.ump"},javaline={1080},length={81})
  private static List<String> OneOrManyLookup ;

//  @umplesourcefile(line={19},file={"Generator_CodePhp.ump"},javaline={1083},length={78})
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
    UpperCaseSingularLookupMap.put("parameterGetUnique", "retrievedBy{0}");
    UpperCaseSingularLookupMap.put("parameterHasUnique", "hasUnique{0}");
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
  }

  
}