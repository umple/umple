/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.605 modeling language!*/

package cruise.umple.compiler;
import java.util.*;
import java.io.*;
import cruise.umple.util.*;
import cruise.umple.compiler.exceptions.*;
import cruise.umple.compiler.php.*;

public class PhpGenerator implements CodeGenerator,CodeTranslator
{

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
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  private static Map<String,String> UpperCaseSingularLookupMap;
  private static Map<String,String> UpperCasePluralLookupMap;
  private static Map<String,String> AsIsSingularLookupMap;
  private static Map<String,String> AsIsPluralLookupMap;
  private static List<String> OneOrManyLookup;
  static
  {
    UpperCaseSingularLookupMap = new HashMap<String, String>();
    UpperCaseSingularLookupMap.put("parameterOne", "a{0}");
    UpperCaseSingularLookupMap.put("removeParameterOne", "placeholder{0}");
    UpperCaseSingularLookupMap.put("parameterNew", "new{0}");
    UpperCaseSingularLookupMap.put("parameterNext", "next{0}");
    UpperCaseSingularLookupMap.put("addMethod", "add{0}");
    UpperCaseSingularLookupMap.put("addViaMethod", "add{0}Via");
    UpperCaseSingularLookupMap.put("removeMethod", "remove{0}");
    UpperCaseSingularLookupMap.put("indexOfMethod", "indexOf{0}");
    UpperCaseSingularLookupMap.put("parameterOld", "old{0}");
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
  
  public boolean isNullable(UmpleVariable av)
  {
    return true;
  }

  
  public String relatedTranslate(String name, AssociationVariable av)
  {
    return translate(name,av.getRelatedAssociation());
  }
  
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
  
  public String translate(String name, UmpleInterface aInterface)
  {
    if ("packageDefinition".equals(name))
    {
      return aInterface.getPackageName().length() == 0 ? "" : "package " + aInterface.getPackageName() + ";"; 
    }
    return "UNKNOWN ID: " + name;
  }
  
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
    return "UNKNOWN ID: " + keyName;
  }
  
 private String getExtendAndImplements(UmpleClass uClass)
  {
	  String extendsString = "";
	  String implementsString = "";

	  extendsString = getExtendClassesNames(uClass);
	  implementsString = getImplementsInterfacesNames(uClass);

	  return extendsString + implementsString; 
  }

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

  private String getImplementsInterfacesNames(UmpleClass uClass)
  {
	  if (uClass.hasParentInterface() == false){
		  return "";
	  }
	  else{
		 return " implements " +  uClass.getParentInterface().get(0).getName();
	  }
  }

  public String translate(String keyName, Attribute av)
  {
    boolean isMany = av.getIsList();
    return translate(keyName,av,isMany);
  }
  
  public String translate(String keyName, AssociationVariable av)
  {
    boolean isMany = av.isMany();
    return translate(keyName,av,isMany);
  }  
  
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
      return StringFormatter.format("doActivity{0}",fullStateName); 
    }
    
    return "UNKNOWN ID: " + keyName;
  }
  
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
  
  private void writeFile(UmpleElement aElement)
  {
    try
    {
      ILang language = getLanguageFor(aElement);
      String path = model.getUmpleFile().getPath() + File.separator + getOutput();
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
      if (av.getModifier().equals("immutable") || aClass.getKey().isMember(av))
      {
        String code = StringFormatter.format("if (!$this->{0}) { return false; }",translate("attributeCanSet",av));
        CodeInjection set = new CodeInjection("before",translate("setMethod",av) , code);
        set.setIsInternal(true);
        aClass.addCodeInjection(set);
      }
    
      if (aClass.getKey().isMember(av))
      {
        String code = StringFormatter.format("if (!$this->{0}) { return false; }",translate("attributeCanSet",av));
        String methods = StringFormatter.format("{0},{1},{2},{3}",translate("addMethod",av),translate("removeMethod",av),translate("setManyMethod",av),translate("resetMethod",av));
        CodeInjection inject = new CodeInjection("before", methods, code);
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
        CodeInjection inject = new CodeInjection("before", methods, code);
        inject.setIsInternal(true);
        aClass.addCodeInjection(inject);
      }
      
      if (av.isMany())
      {
        String code = StringFormatter.format("if ($this->{0}(${1}) !== -1) { return false; }",translate("indexOfMethod",av),translate("parameterOne",av));
        CodeInjection set = new CodeInjection("before",translate("addMethod",av) , code);
        set.setIsInternal(true);
        aClass.addCodeInjection(set);
      }
    }

    Map<String,String> lookups = new HashMap<String,String>();
    String executeMethods = "public static function execute($message) { self::getInstance()->addTrace($message); }\n";
    executeMethods += "public function reset() { self::getInstance()->traces = array(); }";
    lookups.put("consoleTemplate","print(\"{0}={${1}}\");");
    lookups.put("stringTemplate","StringTracer::execute(\"{0}={${1}}\");");
    lookups.put("extraCode",executeMethods);
    GeneratorHelper.prepareAllStringTracers(this,model,aClass,lookups);
    
    for (StateMachine sm : aClass.getStateMachines())
    {
      prepareNestedStatesFor(sm,0);
    }    
    
  }
  
  private void prepareNestedStatesFor(StateMachine sm,int concurrentIndex)
  {
    if (sm.getParentState() != null)
    {
      State parentState = sm.getParentState();
      Map<String,String> lookups = new HashMap<String,String>();
      lookups.put("entryEventName",translate("enterMethod",parentState));
      lookups.put("exitEventName",translate("exitMethod",parentState));
      lookups.put("parentEntryActionCode",StringFormatter.format("if ($this->{0} == self::${1}) { $this->{2}(\"{3}\"); }"
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
        prepareNestedStatesFor(nestedSm,nestedSmIndex);
        nestedSmIndex += 1;
      }
    }
  }  
  
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
      
      signature.append(StringFormatter.format("${0}",nameOf(av)));
      signatureCaller.append(StringFormatter.format("${0}",nameOf(av)));      
    }

    genClass.setLookup("constructorSignature", signature.toString());
    genClass.setLookup("constructorSignature_caller", signatureCaller.toString());
  }

  private String nameOf(Attribute av)
  {
    return nameOf(av.getName(),av.getIsList());
  }
  
  private String nameOf(AssociationVariable av)
  {
    boolean hasMultiple = av.isMany();
    return nameOf(av.getName(),hasMultiple);
  }
  
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
  
  private void generateNullableConstructorSignature(GeneratedClass genClass)
  {
    String currentConstructor = genClass.getLookup("constructorSignature");
    genClass.setLookup("constructorSignature_nulled", StringFormatter.appendParameter(currentConstructor, " = null"));
  }
  

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