/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.util.*;
import java.io.*;
import cruise.umple.util.*;
import cruise.umple.compiler.exceptions.*;
import cruise.umple.compiler.java.*;
import cruise.umple.util.StringFormatter;

/**
 * @umplesource Generator.ump 218
 * @umplesource Generator_CodeJava.ump 11
 */
// line 218 "../../../../src/Generator.ump"
// line 11 "../../../../src/Generator_CodeJava.ump"
public class JavaGenerator extends SuperCodeGenerator implements CodeTranslator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public JavaGenerator()
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

  @umplesourcefile(line={102},file={"Generator_CodeJava.ump"},javaline={47},length={28})
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

  @umplesourcefile(line={133},file={"Generator_CodeJava.ump"},javaline={77},length={13})
   public ILang getLanguageFor(UmpleElement aElement){
    if (aElement instanceof UmpleInterface)
    {
      return new JavaInterfaceGenerator();
    }
    else if (aElement instanceof UmpleClass)
    {
      return new JavaClassGenerator();
    } 
    else{
        return null;        
    }
  }

  @umplesourcefile(line={148},file={"Generator_CodeJava.ump"},javaline={92},length={3})
   public boolean isNullable(UmpleVariable av){
    return !UmpleToPrimitiveMap.containsKey(av.getType());
  }

  @umplesourcefile(line={153},file={"Generator_CodeJava.ump"},javaline={97},length={3})
   public String relatedTranslate(String name, AssociationVariable av){
    return translate(name,av.getRelatedAssociation());
  }

  @umplesourcefile(line={158},file={"Generator_CodeJava.ump"},javaline={102},length={35})
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
      return StringFormatter.format("doActivity{0}", GeneratorHelper.getFullActivityName(state)); 
    }
    else if ("doActivityThread".equals(keyName))
    {
      return StringFormatter.format("doActivity{0}Thread", GeneratorHelper.getFullActivityName(state)); 
    }
    else if ("type".equals(keyName))
    {
      return getUpperCaseName(state.getStateMachine().getName());
    }
    
    return "UNKNOWN ID: " + keyName;
  }

  @umplesourcefile(line={195},file={"Generator_CodeJava.ump"},javaline={139},length={82})
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
    else if ("listEvents".equals(keyName))
    {
      String allEnums = "";
      for(Event event : sm.getEvents())
      {
        if (allEnums.length() > 0)
        {
          allEnums += ", ";
        }
        allEnums += translate("eventMethod",event);
        allEnums += "_M";
      }
      return allEnums;
    }
    else if ("listEventsNSM".equals(keyName))
    {
      String allEnums = "";
      String eveName="";
      for (StateMachine nsm : sm.getNestedStateMachines())
      {
        for (Event event : nsm.getEvents())
        {
          if(event.getIsInternal() == false)
          {
              if( eveName != event.getName()){
        	  if (allEnums.length() > 0 )
              {
                allEnums += ", ";
              }
              allEnums += translate("eventMethod",event);
              allEnums += "_M"; 
              eveName=event.getName();
              } 
          }
        }
      }
      return allEnums;
    }
        
    return "UNKNOWN ID: " + keyName;
  }

  @umplesourcefile(line={279},file={"Generator_CodeJava.ump"},javaline={223},length={23})
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

  @umplesourcefile(line={304},file={"Generator_CodeJava.ump"},javaline={248},length={11})
   public String translate(String name, UmpleInterface aInterface){
    if ("packageDefinition".equals(name))
    {
      return aInterface.getPackageName().length() == 0 ? "" : "package " + aInterface.getPackageName() + ";"; 
    }
    if ("isA".equals(name))
    {
      return getImplementsForInterfaces(aInterface);
    }
    return "";
  }

  @umplesourcefile(line={317},file={"Generator_CodeJava.ump"},javaline={261},length={19})
   public String translate(String methodType){
    if ("String".equals(methodType))
    {
      return "\"\"";
    }
    if ("int".equals(methodType) || "double".equals(methodType) || "float".equals(methodType))
    {
      return "0";
    }
    if ("boolean".equals(methodType))
    {
      return "false";
    }
    if ("void".equals(methodType))
    {
      return "";
    }        
    return "null";
  }

  @umplesourcefile(line={338},file={"Generator_CodeJava.ump"},javaline={282},length={24})
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

  @umplesourcefile(line={364},file={"Generator_CodeJava.ump"},javaline={308},length={15})
   private String getImplementsForInterfaces(UmpleInterface uInterface){
    String implementedInterfaces = "";

      if (uInterface.hasExtendsInterface() == false){
          return "";
      }
      else{
          for (UmpleInterface aInterface : uInterface.getExtendsInterface())
          {
              implementedInterfaces += aInterface.getName() + ", " ; 
          }
          implementedInterfaces = implementedInterfaces.substring(0, implementedInterfaces.length()-2); 
          return " extends " + implementedInterfaces;
      }
  }

  @umplesourcefile(line={381},file={"Generator_CodeJava.ump"},javaline={325},length={9})
   private String getExtendAndImplements(UmpleClass uClass){
    String extendsString = "";
      String implementsString = "";

      extendsString = getExtendClassesNames(uClass);
      implementsString = getImplementsInterfacesNames(uClass);

      return extendsString + implementsString;
  }

  @umplesourcefile(line={392},file={"Generator_CodeJava.ump"},javaline={336},length={10})
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

  @umplesourcefile(line={404},file={"Generator_CodeJava.ump"},javaline={348},length={15})
   private String getImplementsInterfacesNames(UmpleClass uClass){
    String implementedInterfaces = "";

      if (uClass.hasParentInterface() == false){
          return "";
      }
      else{
          for (UmpleInterface uInterface : uClass.getParentInterface())
          {
              implementedInterfaces += uInterface.getName() + "," ; 
          }
          implementedInterfaces = implementedInterfaces.substring(0, implementedInterfaces.length()-1); 
          return " implements " + implementedInterfaces;
      }
  }

  @umplesourcefile(line={421},file={"Generator_CodeJava.ump"},javaline={365},length={3})
   public String translate(String keyName, Attribute av){
    return translate(keyName,av,av.getIsList());
  }

  @umplesourcefile(line={426},file={"Generator_CodeJava.ump"},javaline={370},length={3})
   public String translate(String keyName, AssociationVariable av){
    return translate(keyName,av,av.isMany());
  }

  @umplesourcefile(line={431},file={"Generator_CodeJava.ump"},javaline={375},length={110})
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

  @umplesourcefile(line={543},file={"Generator_CodeJava.ump"},javaline={487},length={16})
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

  @umplesourcefile(line={561},file={"Generator_CodeJava.ump"},javaline={505},length={22})
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

  @umplesourcefile(line={585},file={"Generator_CodeJava.ump"},javaline={529},length={16})
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
  @umplesourcefile(line={608},file={"Generator_CodeJava.ump"},javaline={547},length={3})
   private String getUpperCaseName(String name){
    return StringFormatter.toPascalCase(name);
  }

  @umplesourcefile(line={613},file={"Generator_CodeJava.ump"},javaline={558},length={11})
   private void injectIntoUnique(String method, String injection, String when, Attribute av, UmpleClass aClass){
    String code = StringFormatter.format(injection,
      translate("type", av),
	    translate("parameterOne", av),
	    translate("parameterOld", av),
	    translate("getMethod", av),
	    translate("hasUniqueMethod", av),
	    translate("uniqueMap", av));
    CodeInjection set = new CodeInjection(when, method, code, aClass);
	  aClass.addCodeInjection(set);
  }

  @umplesourcefile(line={626},file={"Generator_CodeJava.ump"},javaline={571},length={3})
   private void injectIntoUniqueSet(String injection, String when, Attribute av, UmpleClass aClass){
    injectIntoUnique(translate("setMethod", av), injection, when, av, aClass);
  }

  @umplesourcefile(line={631},file={"Generator_CodeJava.ump"},javaline={576},length={3})
   private void injectIntoUniqueDelete(String injection, String when, Attribute av, UmpleClass aClass){
    injectIntoUnique("delete", injection, when, av, aClass);
  }

  @umplesourcefile(line={636},file={"Generator_CodeJava.ump"},javaline={581},length={163})
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
      
      if (av.getIsUnique())
      {
        injectIntoUniqueSet(
          "{0} {2} = {3}();" + "\n" + 
          "if ({4}({1})) {" + "\n" + 
          "  return wasSet;" + "\n" +
          "}", "before", av, aClass);
        injectIntoUniqueSet(
          "if ({2} != null) {" + "\n" +
          "  {5}.remove({2});" + "\n" +
          "}" + "\n" +
          "{5}.put({1}, this);", "after", av, aClass);
        injectIntoUniqueDelete(
          "{5}.remove({3}());", "before", av, aClass);
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
      
      if (av.isImmutable())
      {
        String code = StringFormatter.format("if (!{0}) { return false; }\n{0} = false;",translate("associationCanSet",av));
        String methods = StringFormatter.format("{0},{1}",translate("setManyMethod",av),translate("setMethod",av));
        CodeInjection set = new CodeInjection("before", methods, code, aClass);
        set.setIsInternal(true);
        aClass.addCodeInjection(set);
      }
      
      if (av.isMany())
      {
        String code = StringFormatter.format("if ({0}.contains({1})) { return false; }",translate("attributeMany",av),translate("parameterOne",av));
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
        String java_code = StringFormatter.format("if(wasAdded)\n    Collections.sort({0}, {0}Priority);\n",translate("attributeMany",av));
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
    String executeMethods = "public static void handle(String message) { getInstance().addTrace(message); }\n";
    executeMethods += "public void reset() { getInstance().traces.clear(); }";
    lookups.put("packageName","cruise.util");
    lookups.put("dependTracer","cruise.util.{0}Tracer");
    lookups.put("dependDate","java.util.Date");
    lookups.put("stringTracer",executeMethods);
    lookups.put("startTime","(int)System.currentTimeMillis()");
    lookups.put("initial","handle(\"Time,Thread,UmpleFile,LineNumber,Class,Object,Operation,Name,Value\");");
    lookups.put("static","static{getInstance();}");
    lookups.put("consoleTracer", "public static void handle(String message)\n"+
                 "  {\n"+
                 "     System.err.println(message);\n"+
                 "  }");
    lookups.put("fileTracer","public static void handle(String message)\n"+
                 "  {\n"+
               "    FileOutputStream fout = null;\n"+
               "    try\n"+
               "    {\n"+
               "      // Open an output stream\n"+
               "      fout = new FileOutputStream (filename,true);\n"+
               "    }\n"+
               "    catch (IOException e)\n"+
               "    {\n"+
               "      System.err.println (\"Unable to write to file\");\n"+
               "      System.exit(-1);\n"+
               "    }\n"+
               "    // Write traced Item information\n"+
               "    new PrintStream(fout).println(message);\n"+
               "    try\n"+
               "    {\n"+
               "      // Close output stream\n"+
               "      fout.close();\n"+
               "    }\n"+
               "    catch (IOException e)\n"+
               "    {\n"+
               "      e.printStackTrace();\n"+
               "    }\n"+
               "  }");
    lookups.put("handleMethod","public static void handle(String name, String value, String... extra)\n  {\n {0} \n  }");
    lookups.put("ifStatement","  if ( {0} )\n  {\n  {1}\n  }");
    lookups.put("callHandle","{0}.handle(name+\" = \"+value);");
    GeneratorHelper.prepareAllTracers(this,getModel(),aClass,lookups);
//    prepareAllTraces(this,getModel(),aClass,lookups);
    
    //Add  entry / exit methods to start and stop the timed events in Java
    boolean hasTimedEvents = false;
    for (StateMachine sm : aClass.getStateMachines())
    {
      prepareNestedStatesFor(sm,null,0);
      hasTimedEvents = prepareTimedEvents(sm) || hasTimedEvents;
    }
        
    if (hasTimedEvents)
    {
      aClass.addDepend(new Depend("java.util.*"));
    }
  }

  @umplesourcefile(line={803},file={"Generator_CodeJava.ump"},javaline={746},length={24})
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

  @umplesourcefile(line={829},file={"Generator_CodeJava.ump"},javaline={772},length={13})
   private void prepareDoActivityThreadInterrupt(StateMachine sm){
    for(State state : sm.getStates())
    {
      if (state.getActivity() != null)
      {
        String code = StringFormatter.format("if ({0} != null) { {0}.interrupt(); }",translate("doActivityThread",state));
        Action interruptAction = new Action(code);
        interruptAction.setIsInternal(true);
        interruptAction.setActionType("exit");
        state.addAction(interruptAction);
      }
    }
  }

  @umplesourcefile(line={844},file={"Generator_CodeJava.ump"},javaline={787},length={9})
   private void prepareFinalStateFor(StateMachine sm, StateMachine parentSm){
    Map<String,String> lookups = new HashMap<String,String>();
    
    String deleteActionCode;
    deleteActionCode = StringFormatter.format("{0}();",translate("deleteMethod",sm.getUmpleClass()));

    lookups.put("deleteActionCode",deleteActionCode);
    GeneratorHelper.prepareFinalState(sm,lookups);
  }

  @umplesourcefile(line={855},file={"Generator_CodeJava.ump"},javaline={798},length={38})
   private void prepareNestedStatesFor(StateMachine sm, StateMachine parentSm, int concurrentIndex){
    prepareFinalStateFor(sm,parentSm); 
    prepareDoActivityThreadInterrupt(sm); 
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
      lookups.put("parentEntryActionCode",StringFormatter.format("if ({0} == {1}.{2}) { {3}({1}.{4}); }"
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
        prepareNestedStatesFor(nestedSm,sm,nestedSmIndex);
        nestedSmIndex += 1;
      }
    }
    
    Map<String,String> lookups = new HashMap<String,String>();
    lookups.put("callEvent","{0}();");
    GeneratorHelper.prepareAutoTransitions(sm,this,lookups);
  }

  @umplesourcefile(line={895},file={"Generator_CodeJava.ump"},javaline={838},length={141})
   private void generateConstructorSignature(GeneratedClass genClass){
    StringBuffer signature = new StringBuffer();
    StringBuffer signatureCaller = new StringBuffer();
    
    UmpleClass uClass = genClass.getUClass();
    
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
        
      signature.append(StringFormatter.format("{0} {1}",typeOf(av),nameOf(av)));
      signatureCaller.append(nameOf(av));      
    }

    // This is the list of association variables that might use variable arguments in the constructor
    List<AssociationVariable> manyConstructorAVs = new ArrayList<AssociationVariable>();
    
    for (AssociationVariable av : uClass.getAssociationVariables()) 
    {
      if (!associationShouldAppearInConstructor(av))
      {
        continue;
      }
      if (av.isMany())
      {
        manyConstructorAVs.add(av);
        continue;
      }
      
      if (signature.length() > 0) 
      {
        signature.append(", ");
        signatureCaller.append(", ");
      }
      
      signature.append(StringFormatter.format("{0} {1}",typeOf(av),nameOf(av)));
      signatureCaller.append(nameOf(av));      
    }
    
    // Insert the parent class's contructor signature, with attention given to special
    // cases where the signature is modified if variable arguments are present.
    
    boolean parentConstructorContainsMany = false;   
    if (uClass.getExtendsClass() != null) 
    {
      GeneratedClass parent = genClass.getParentClass();
      String parentSignature = parent.getLookup("constructorSignature");
      String parentSignatureCaller = parent.getLookup("constructorSignature_caller");
      
      String parentSignatureToPrepend = "";
      String parentSignatureCallerToPrepend = "";
    
      if ((signature.length() == 0) && (manyConstructorAVs.size() == 0))
      {
        // if the child class will add nothing to the signature
        signature.append(parentSignature);
        signatureCaller.append(parentSignatureCaller);
      }
      else if (parentSignature.contains("..."))
      {
        if (manyConstructorAVs.size() > 0)
        {
          // if multiple associations in the constructor could use variable arguments, switch to using arrays.
          parentConstructorContainsMany = true;
          parentSignatureToPrepend = parentSignature.replace("...", "[]");
          parentSignatureCallerToPrepend = parentSignatureCaller;
        }
        else
        {
          //else push the variable argument parameter to the end of the constructor. 
               
          int idx = Math.max(parentSignature.lastIndexOf(","),0);
          if ((signature.length() > 0) && (idx == 0))
          {
            // if there was no comma in the parent signature, compensate.
            signature.append(", ");
            signatureCaller.append(", ");
          }   
          signature.append(parentSignature.substring(idx));
          parentSignatureToPrepend = parentSignature.substring(0, idx);
          
          idx = Math.max(parentSignatureCaller.lastIndexOf(","),0);
          signatureCaller.append(parentSignatureCaller.substring(idx));
          parentSignatureCallerToPrepend = parentSignatureCaller.substring(0, idx);
        }
      }
      else 
      {
        // else simply prepend the parent signature, as-is, to the child signature.
        parentSignatureToPrepend = parentSignature;
        parentSignatureCallerToPrepend = parentSignatureCaller;
        
        // also, check if the presence of arrays in the parent signature signals that the child
        // signature should use arrays for arguments that could otherwise use variable arguments.
        if (parentSignature.contains("[]"))
        {
          parentConstructorContainsMany = true;
        }
      }
      
      // prepend the parent signature to the child signature
      if (parentSignatureToPrepend.length() > 0)
      {
        if (signature.length() > 0)
        {
          signature.insert(0, parentSignatureToPrepend + ", ");
          signatureCaller.insert(0, parentSignatureCallerToPrepend + ", ");
        }
        else
        {
          signature.append(parentSignatureToPrepend);
          signatureCaller.append(parentSignatureCallerToPrepend);
        }
      }
    }
    
    // finally, append constructor parameter(s) that could be variable arguments or arrays depending on circumstances
    for (AssociationVariable manyAV : manyConstructorAVs)
    {
      if (signature.length() > 0) 
      {
        signature.append(", ");
        signatureCaller.append(", ");
      }
      String typeModifier = ((manyConstructorAVs.size() > 1) || (parentConstructorContainsMany)) ? "[]" : "...";
      signature.append(StringFormatter.format("{0}{1} {2}",typeOf(manyAV),typeModifier,nameOf(manyAV)));
      signatureCaller.append(nameOf(manyAV));     
    }

    genClass.setLookup("constructorSignature", signature.toString());
    genClass.setLookup("constructorSignature_caller", signatureCaller.toString());
  }

  @umplesourcefile(line={1039},file={"Generator_CodeJava.ump"},javaline={981},length={21})
   private boolean associationShouldAppearInConstructor(AssociationVariable av){
    boolean shouldAppear = true;
    AssociationVariable relatedAv = av.getRelatedAssociation();
    
    if ((av.getMultiplicity().getLowerBound() == 0 && !av.isImmutable()) || !av.getIsNavigable())
    {
      shouldAppear = false;
    }   
    else if (relatedAv.getIsNavigable())
    {
      if (av.isMandatoryMany() && relatedAv.isMandatory())
      {
        shouldAppear = false;
      }
      else if ((av.isMN() || av.isN()) && relatedAv.isOptionalN())
      {
        shouldAppear = false;
      }
    }
    return shouldAppear;
  }

  @umplesourcefile(line={1062},file={"Generator_CodeJava.ump"},javaline={1004},length={36})
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
        
        String selfParameter = StringFormatter.format("{0} {1}",typeOf(relatedAv),nameOf(relatedAv));
        String selfFor = StringFormatter.format("For{0}",av.getUpperCaseName());
        String newParameters = relatedGen.getLookup("constructorSignature");
        newParameters = StringFormatter.replaceParameter(newParameters, selfParameter, null);
        newParameters = StringFormatter.appendParameter(newParameters, selfFor);

        String relatedParameter = StringFormatter.format("{0} {1}",typeOf(av),nameOf(av));
        
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

  @umplesourcefile(line={1100},file={"Generator_CodeJava.ump"},javaline={1042},length={41})
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
        
        //add related imports in multilevel
        UmpleClass rootUClass = aClass;
		while (!rootUClass.isRoot()) 
		{
			addImports(rootUClass.getExtendsClass(), genClass);
			rootUClass = rootUClass.getExtendsClass();
		}
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

  @umplesourcefile(line={1143},file={"Generator_CodeJava.ump"},javaline={1085},length={23})
   private void addAttributeImports(UmpleClass aClass, GeneratedClass genClass){
    String timeImport = "java.sql.Time";
    String dateImport = "java.sql.Date";
    String utilImport = "java.util.*";
    
    for (Attribute av : aClass.getAttributes()) 
    {
      
      if ("Time".equals(av.getType()))
      {
        genClass.addMultiLookup("import", timeImport);
      }
      else if ("Date".equals(av.getType()))
      {
        genClass.addMultiLookup("import", dateImport);
      }
      
      if (av.getIsList() || av.getIsUnique())
      {
        genClass.addMultiLookup("import", utilImport);
      }
    }
  }

  @umplesourcefile(line={1168},file={"Generator_CodeJava.ump"},javaline={1110},length={33})
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
        genClass.addMultiLookup("import", "java.util.*");
      }
    }
    
    for (String namespace : aClass.getNamespaces())
    {
      if (!namespace.equals(aClass.getPackageName()))
      {
        genClass.addMultiLookup("import", namespace + ".*");
      }
    }

    for (StateMachine sm : aClass.getStateMachines())
    {
      if (sm.isQueued())
      {
        genClass.addMultiLookup("import", "java.util.*");
        genClass.addMultiLookup("import", "java.lang.Thread");
      }
    }
  }

  @umplesourcefile(line={1203},file={"Generator_CodeJava.ump"},javaline={1145},length={3})
   private String nameOf(Attribute av){
    return nameOf(av.getName(),av.getIsList());
  }

  @umplesourcefile(line={1208},file={"Generator_CodeJava.ump"},javaline={1150},length={4})
   private String nameOf(AssociationVariable av){
    boolean hasMultiple = av.isMany();
    return nameOf(av.getName(),hasMultiple);
  }

  @umplesourcefile(line={1214},file={"Generator_CodeJava.ump"},javaline={1156},length={4})
   private static  String typeOf(UmpleVariable var){
    String aType = var.getType();
    return typeOf(aType);
  }

  @umplesourcefile(line={1246},file={"Generator_CodeJava.ump"},javaline={1162},length={35})
   public void initializeLangaugeBasedVariables(){
    UmpleToPrimitiveMap.put("Integer","int");
    UmpleToPrimitiveMap.put("Boolean","boolean");
    UmpleToPrimitiveMap.put("Double","double");
    UmpleToPrimitiveMap.put("Float","float");
    UmpleToPrimitiveMap.put("String","String");
    //
    TraceLookupMap.put("concatinator","+");
    TraceLookupMap.put("accessor","");
    TraceLookupMap.put("indent","    ");
    TraceLookupMap.put("template","{0}Tracer.handle( {1} );");
    TraceLookupMap.put("timestamp","System.currentTimeMillis()");
    TraceLookupMap.put("identifier","System.identityHashCode({0})");
    TraceLookupMap.put("thread","Thread.currentThread().getId()");
    TraceLookupMap.put("self","this");
    TraceLookupMap.put("increment","{0}++;");
    TraceLookupMap.put("formatnonprimitive",".toString().replace(\"\\n\",\"\").replace(\",\",\";\")");
    //
    ConstraintLookupMap.put("==",".equals({0})");
    ConstraintLookupMap.put("accessor","");
    ConstraintLookupMap.put("paramaccessor","");
    ConstraintLookupMap.put("exception","throw new RuntimeException(\"Please provide a valid{0}\");");
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

  @umplesourcefile(line={31},file={"Generator.ump"},javaline={1198},length={128})
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

  @umplesourcefile(line={32},file={"Generator.ump"},javaline={1328},length={10})
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
  //  @umplesourcefile(line={15},file={"Generator_CodeJava.ump"},javaline={1343},length={121})
  private static Map<String,String> UpperCaseSingularLookupMap ;

//  @umplesourcefile(line={16},file={"Generator_CodeJava.ump"},javaline={1346},length={118})
  private static Map<String,String> UpperCasePluralLookupMap ;

//  @umplesourcefile(line={17},file={"Generator_CodeJava.ump"},javaline={1349},length={115})
  private static Map<String,String> AsIsSingularLookupMap ;

//  @umplesourcefile(line={18},file={"Generator_CodeJava.ump"},javaline={1352},length={112})
  private static Map<String,String> AsIsPluralLookupMap ;

//  @umplesourcefile(line={19},file={"Generator_CodeJava.ump"},javaline={1355},length={109})
  private static List<String> OneOrManyLookup ;

//  @umplesourcefile(line={21},file={"Generator_CodeJava.ump"},javaline={1358},length={106})
  static 
  {
    UpperCaseSingularLookupMap = new HashMap<String, String>();
    UpperCaseSingularLookupMap.put("parameterOne", "a{0}");
    UpperCaseSingularLookupMap.put("removeParameterOne", "placeholder{0}");    
    UpperCaseSingularLookupMap.put("parameterNew", "aNew{0}");
    UpperCaseSingularLookupMap.put("parameterNext", "next{0}");
    UpperCaseSingularLookupMap.put("addMethod", "add{0}");
    UpperCaseSingularLookupMap.put("addAtMethod", "add{0}At");
    UpperCaseSingularLookupMap.put("addOrMoveAtMethod", "addOrMove{0}At");
    UpperCaseSingularLookupMap.put("removeMethod", "remove{0}");
    UpperCaseSingularLookupMap.put("indexOfMethod", "indexOf{0}");
    UpperCaseSingularLookupMap.put("parameterOld", "anOld{0}");
    UpperCaseSingularLookupMap.put("parameterExisting", "existing{0}");
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
    UpperCaseSingularLookupMap.put("stateNull", "Null");
    UpperCaseSingularLookupMap.put("doExitMethod", "doExit{0}");
    UpperCaseSingularLookupMap.put("doEventMethod", "do{0}");

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

//  @umplesourcefile(line={1217},file={"Generator_CodeJava.ump"},javaline={1437},length={27})
  @umplesourcefile(line={1218},file={"Generator_CodeJava.ump"},javaline={1438},length={26})
  private void writeFile (UmpleElement aClass) throws IOException 
  {
    ILang language = getLanguageFor(aClass);
    
    String path = StringFormatter.addPathOrAbsolute( 
                  getModel().getUmpleFile().getPath(), 
                            getOutput()) + 
                            aClass.getPackageName().replace(".", File.separator);
    
    String filename = path + File.separator + aClass.getName() + ".java";
    File file = new File(path);
    file.mkdirs();

    BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
    String contents = language.getCode(getModel(), aClass);
    getModel().getGeneratedCode().put(aClass.getName(),contents);
    try
    {
      bw.write(contents);
      bw.flush();
    }
    finally
    {
      bw.close();
    }
  }

  
}