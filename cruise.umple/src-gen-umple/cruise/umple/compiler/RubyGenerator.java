/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.util.*;
import java.io.*;
import cruise.umple.util.*;
import cruise.umple.compiler.exceptions.*;
import cruise.umple.compiler.ruby.*;

/**
 * @umplesource Generator.ump 283
 * @umplesource Generator_CodeRuby.ump 12
 */
// line 283 "../../../../src/Generator.ump"
// line 12 "../../../../src/Generator_CodeRuby.ump"
public class RubyGenerator extends SuperCodeGenerator implements CodeTranslator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RubyGenerator()
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

  @umplesourcefile(line={97},file={"Generator_CodeRuby.ump"},javaline={45},length={17})
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

  @umplesourcefile(line={116},file={"Generator_CodeRuby.ump"},javaline={64},length={3})
   public boolean isNullable(UmpleVariable av){
    return true;
  }

  @umplesourcefile(line={121},file={"Generator_CodeRuby.ump"},javaline={69},length={3})
   public String relatedTranslate(String name, AssociationVariable av){
    return translate(name,av.getRelatedAssociation());
  }

  @umplesourcefile(line={126},file={"Generator_CodeRuby.ump"},javaline={74},length={13})
   public ILang getLanguageFor(UmpleElement aElement){
    if (aElement instanceof UmpleInterface)
    {
      return new RubyInterfaceGenerator();
    }
    else if (aElement instanceof UmpleClass)
    {
      return new RubyClassGenerator();
    } 
    else{
    	return null;    	
    }
  }

  @umplesourcefile(line={141},file={"Generator_CodeRuby.ump"},javaline={89},length={8})
   public String translate(String name, UmpleInterface aInterface){
    if ("packageDefinition".equals(name))
    {
      String moduleName = StringFormatter.toPascalCase(aInterface.getPackageName());
      return aInterface.getPackageName().length() == 0 ? "" : "module " + moduleName; 
      }
    return "";
  }

  @umplesourcefile(line={151},file={"Generator_CodeRuby.ump"},javaline={99},length={24})
   public String translate(String name, UmpleClass aClass){
    if ("constructorMandatory".equals(name))
    {
      return aClass.getGeneratedClass().getLookup("constructorSignature_mandatory");
    }
    else if ("packageDefinition".equals(name))
    {
      String moduleName = StringFormatter.toPascalCase(aClass.getPackageName());
      return aClass.getPackageName().length() == 0 ? "" : "module " + moduleName; 
    }
    else if ("packageDefinitionEnd".equals(name))
    {
      return aClass.getPackageName().length() == 0 ? "" : "end";
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

  @umplesourcefile(line={177},file={"Generator_CodeRuby.ump"},javaline={125},length={9})
   private String getExtendAndImplements(UmpleClass uClass){
    String extendsString = "";
	  String implementsString = "";
	  
	  extendsString = getExtendClassesNames(uClass);
	  implementsString = getImplementsInterfacesNames(uClass);
	  
	  return extendsString + implementsString;
  }

  @umplesourcefile(line={188},file={"Generator_CodeRuby.ump"},javaline={136},length={8})
   private String getImplementsInterfacesNames(UmpleClass uClass){
    if (uClass.hasParentInterface() == false){
		  return "";
	  }
	  else{
		 return " < " +  uClass.getParentInterface().get(0).getName();
	  }
  }

  @umplesourcefile(line={198},file={"Generator_CodeRuby.ump"},javaline={146},length={10})
   private String getExtendClassesNames(UmpleClass uClass){
    UmpleClass parent = uClass.getExtendsClass();
	  if (parent == null)
	  {
		  return "";
	  }
	  else{
		  return   " < " + parent.getName();
	  }
  }

  @umplesourcefile(line={210},file={"Generator_CodeRuby.ump"},javaline={158},length={4})
   public String translate(String keyName, Attribute av){
    boolean isMany = av.getIsList();
    return translate(keyName,av,isMany);
  }

  @umplesourcefile(line={216},file={"Generator_CodeRuby.ump"},javaline={164},length={4})
   public String translate(String keyName, AssociationVariable av){
    boolean isMany = av.isMany();
    return translate(keyName,av,isMany);
  }

  @umplesourcefile(line={222},file={"Generator_CodeRuby.ump"},javaline={170},length={97})
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
        return StringFormatter.format("Date.parse({0})",av.getValue());
      }
      else if (isString && "Time".equals(av.getType()))
      {
        return StringFormatter.format("Time.parse({0})",av.getValue());
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
        String   callerNameToRemove = StringFormatter.format("{0}",translate("parameterOne",assVar));
        return StringFormatter.replaceParameter(generatedClassToRemove.getLookup("constructorSignature_caller"), callerNameToRemove, "self");
      }
      else if ("methodArgumentsExcept".equals(keyName))
      {
        UmpleClass classToRemove = getModel().getUmpleClass(getType(assVar.getRelatedAssociation()));
        GeneratedClass generatedClassToRemove = classToRemove.getGeneratedClass();
        String parameterNameToRemove = StringFormatter.format("{0}", translate("parameterOne",assVar));
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
    }    
    return "UNKNOWN ID: " + keyName;
  }

  @umplesourcefile(line={321},file={"Generator_CodeRuby.ump"},javaline={269},length={36})
   public String translate(String keyName, State state){
    String singularName = state.getName();
    String pluralName = getModel().getGlossary().getPlural(singularName);
    String stateMachinePlusState = StringFormatter.format("{0}{1}",getUpperCaseName(state.getStateMachine().getName()),getUpperCaseName(singularName));
  
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
      return stateMachinePlusState;
    }
    else if ("stateString".equals(keyName))
    {
      return "\"" + stateMachinePlusState + "\"";
    }
    else if ("doActivityMethod".equals(keyName))
    {
      return StringFormatter.format("doActivity{0}",stateMachinePlusState); 
    }
    
    return "UNKNOWN ID: " + keyName;
  }

  @umplesourcefile(line={359},file={"Generator_CodeRuby.ump"},javaline={307},length={22})
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
    return "UNKNOWN ID: " + keyName;
  }

  @umplesourcefile(line={383},file={"Generator_CodeRuby.ump"},javaline={331},length={23})
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

  @umplesourcefile(line={408},file={"Generator_CodeRuby.ump"},javaline={356},length={12})
   public void generate(){
    prepare();
    for (UmpleElement currentElement : getModel().getUmpleElements())
    {
      if ("external".equals(currentElement.getModifier()))
      {
        continue;
      }
      writeFile(currentElement);
    }
    GeneratorHelper.postpare(getModel());
  }

  @umplesourcefile(line={422},file={"Generator_CodeRuby.ump"},javaline={370},length={16})
   public String nameOf(String name, boolean hasMultiple){
    if (name == null)
    {
      return null;
    }
    else if (hasMultiple)
    {
      //String pluralName = getModel().getGlossary().getPlural(name);
      return "all_" + name;
    }
    else
    {
      //String singularName = getModel().getGlossary().getSingular(name);
      return "a_" + name;
    }
  }

  @umplesourcefile(line={440},file={"Generator_CodeRuby.ump"},javaline={388},length={22})
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

  @umplesourcefile(line={464},file={"Generator_CodeRuby.ump"},javaline={412},length={26})
   private void writeFile(UmpleElement aElement){
    try
    {
      ILang language = getLanguageFor(aElement);
      
      String path = StringFormatter.addPathOrAbsolute( 
    						  getModel().getUmpleFile().getPath(), 
        	                  getOutput());
      
      File file = new File(path);
      file.mkdirs();

      String rubyName = StringFormatter.toUnderscore(aElement.getName()) + ".rb";
      String filename = path + File.separator + rubyName;
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

  @umplesourcefile(line={492},file={"Generator_CodeRuby.ump"},javaline={440},length={14})
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

  @umplesourcefile(line={508},file={"Generator_CodeRuby.ump"},javaline={456},length={167})
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
    
    if (aClass.getIsSingleton())
    {
      aClass.addDepend(new Depend("singleton"));
    }
    
    
    for(Attribute av : aClass.getAttributes())
    {
      if (av.isImmutable() || aClass.getKey().isMember(av))
      {
        String code = StringFormatter.format("return false unless @{0}",translate("attributeCanSet",av));
        CodeInjection set = new CodeInjection("before",translate("setMethod",av) , code, aClass);
        set.setIsInternal(true);
        aClass.addCodeInjection(set);
      }
    
      if (aClass.getKey().isMember(av))
      {
        String code = StringFormatter.format("return false unless @{0}",translate("attributeCanSet",av));
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
        String code = StringFormatter.format("return false unless @{0}",translate("associationCanSet",av));
        String methods = StringFormatter.format("{0},{1},{2},{3},{4}",translate("addMethod",av),translate("removeMethod",av),translate("setManyMethod",av),translate("setMethod",av),translate("resetMethod",av));
        CodeInjection inject = new CodeInjection("before", methods, code, aClass);
        inject.setIsInternal(true);
        aClass.addCodeInjection(inject);
      }
      
      if (av.isImmutable())
      {
        String code = StringFormatter.format("return false unless @{0}\n@{0} = false",translate("associationCanSet",av));
        String methods = StringFormatter.format("{0},{1}",translate("setManyMethod",av),translate("setMethod",av));
        CodeInjection inject = new CodeInjection("before", methods, code, aClass);
        inject.setIsInternal(true);
        aClass.addCodeInjection(inject);
      }
      
      if (av.getIsNavigable()  && av.isMandatoryOne() && av.getRelatedAssociation().isMandatory())
      {
        String code = StringFormatter.format("raise \"Mandatory relationship with {0} not satisfied\" if (@initialized and !@deleted and @{1}.nil?)",av.getName(),translate("associationOne",av));
        CodeInjection injection = new CodeInjection("before","!constructor",code, aClass);
        injection.setIsInternal(true);
        aClass.addCodeInjection(injection);
      }
      
      if (av.isMany())
      {
        String code = StringFormatter.format("return false if {0}({1}) != -1",translate("indexOfMethod",av),translate("parameterOne",av));
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
      	String php_code  = StringFormatter.format("if(wasAdded)\n    usort($this->{0}, $this->{0}Priority);\n",translate("attributeMany",av));
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
      	String set_code = "if {0} then\n";
      	String con_code = "if !({0}) then\n" +
      	                         "  raise RuntimeError, \'Please provide a valid "+ cur.getValue() +"\' \n"+
      						     "end \n";
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
        	  set_expression += "@"+translate("attributeOne",aClass.getAttribute(expr.getValue()));
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
        CodeInjection after = new CodeInjection("after", translate("setMethod", aClass.getAttribute(cur.getValue())), "end", aClass);
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
    	String precondition_code = StringFormatter.format(translate("NotClosed",pc),"raise RuntimeError, \'Please provide a valid " + pc.toString() +"\'");
    	CodeInjection before = new CodeInjection("before", methodName+"Precondition", precondition_code, aClass);         
    	before.setIsInternal(true);
    	aClass.addCodeInjection(before);    
    }
    
    Map<String,String> lookups = new HashMap<String,String>();
    String executeMethods = "def self.execute(message)\nself.getInstance().addTrace(message)\nend\n";
    executeMethods += "def reset\nself.getInstance().traces = []\nend";
    lookups.put("consoleTemplate","puts \"{0}=#{{1}}\"");
    lookups.put("stringTemplate","StringTracer::execute(\"{0}=#{{1}}\")");
    lookups.put("executeMethods",executeMethods);
    //GeneratorHelper.prepareAllStringTracers(this,getModel(),aClass,lookups);
  }

  @umplesourcefile(line={678},file={"Generator_CodeRuby.ump"},javaline={625},length={65})
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
        
      signature.append(StringFormatter.format("{0}",nameOf(av)));
      signatureCaller.append(StringFormatter.format("{0}",nameOf(av)));
    }

    for (AssociationVariable av : uClass.getAssociationVariables()) 
    {
      AssociationVariable relatedAv = av.getRelatedAssociation();

      if ((av.getMultiplicity().getLowerBound() == 0 && !av.isImmutable())|| !av.getIsNavigable())
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
      
      signature.append(StringFormatter.format("{0}",nameOf(av)));
      signatureCaller.append(StringFormatter.format("{0}",nameOf(av)));      
    }

    genClass.setLookup("constructorSignature", signature.toString());
    genClass.setLookup("constructorSignature_caller", signatureCaller.toString());
  }

  @umplesourcefile(line={745},file={"Generator_CodeRuby.ump"},javaline={692},length={3})
   public String nameOf(Attribute av){
    return nameOf(av.getName(),false);
  }

  @umplesourcefile(line={750},file={"Generator_CodeRuby.ump"},javaline={697},length={4})
   public String nameOf(AssociationVariable av){
    boolean hasMultiple = av.isMany();
    return nameOf(av.getName(),hasMultiple);
  }

  @umplesourcefile(line={756},file={"Generator_CodeRuby.ump"},javaline={703},length={36})
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
        
        String selfParameter = StringFormatter.format("{0}",nameOf(relatedAv));
        String selfFor = StringFormatter.format("For{0}",av.getUpperCaseName());
        String newParameters = relatedGen.getLookup("constructorSignature");
        newParameters = StringFormatter.replaceParameter(newParameters, selfParameter, null);
        newParameters = StringFormatter.appendParameter(newParameters, selfFor);

        String relatedParameter = StringFormatter.format("{0}",nameOf(av));
        
        mandatorySignature = StringFormatter.replaceParameter(mandatorySignature, relatedParameter, newParameters);
        genClass.setLookup("constructorSignature_mandatory", mandatorySignature);
        
        String relatedFor = StringFormatter.format("For{0}",relatedAv.getUpperCaseName());
        String relatedCaller = genClass.getLookup("constructorSignature_caller");
        String relatedCallerParameter = StringFormatter.format("{0}",nameOf(av));
        String mandatorySignatureCaller = StringFormatter.replaceParameter(relatedCaller, relatedCallerParameter, "_THIS_");
        mandatorySignatureCaller = StringFormatter.appendParameter(mandatorySignatureCaller, relatedFor);
        mandatorySignatureCaller = StringFormatter.replaceParameter(mandatorySignatureCaller, "_THIS_" + relatedFor, "thisInstance");
        
        String mandatoryCallerId = "constructorSignature_mandatory_" + relatedAv.getName();
        relatedGen.setLookup(mandatoryCallerId, mandatorySignatureCaller);
      }
    }
  }

  @umplesourcefile(line={794},file={"Generator_CodeRuby.ump"},javaline={741},length={4})
   private void generateNullableConstructorSignature(GeneratedClass genClass){
    String currentConstructor = genClass.getLookup("constructorSignature");
    genClass.setLookup("constructorSignature_nulled", StringFormatter.appendParameter(currentConstructor, " = null"));
  }

  @umplesourcefile(line={801},file={"Generator_CodeRuby.ump"},javaline={747},length={4})
   private void addImports(UmpleClass aClass, GeneratedClass genClass){
    addAttributeImports(aClass,genClass);
    addAssociationImports(aClass,genClass);
  }

  @umplesourcefile(line={807},file={"Generator_CodeRuby.ump"},javaline={753},length={3})
   private void addAssociationImports(UmpleClass aClass, GeneratedClass genClass){
    
  }

  @umplesourcefile(line={812},file={"Generator_CodeRuby.ump"},javaline={758},length={17})
   private void addAttributeImports(UmpleClass aClass, GeneratedClass genClass){
    String timeImport = "time";
    String dateImport = "date";
    
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
    }
  }

  @umplesourcefile(line={831},file={"Generator_CodeRuby.ump"},javaline={777},length={33})
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

  @umplesourcefile(line={866},file={"Generator_CodeRuby.ump"},javaline={812},length={25})
   public void initializeLangaugeBasedVariables(){
    UmpleToPrimitiveMap.put("String","String");
	//
	TraceLookupMap.put("indent","    ");
    TraceLookupMap.put("template","{0}Tracer.handle( {1} );");
    TraceLookupMap.put("timestamp","new Date()");
    TraceLookupMap.put("identifier","System.identityHashCode({0})");
    TraceLookupMap.put("thread","Thread.currentThread().getId()");
    TraceLookupMap.put("self","this");
    //
    ConstraintLookupMap.put("==","=={0}");
    ConstraintLookupMap.put("accessor","@");
    ConstraintLookupMap.put("ifstatement","if {0} then");
    ConstraintLookupMap.put("end","end");
    ConstraintLookupMap.put("[]","{1}[{0}]");
    ConstraintLookupMap.put("initialise","{0}.new");
    ConstraintLookupMap.put("has",".include?({0})");
    ConstraintLookupMap.put("hasAll",".include?({0})");
    ConstraintLookupMap.put("cardinality==",".length=={0}");
    ConstraintLookupMap.put("cardinality!=",".length!={0}");
    ConstraintLookupMap.put("cardinality>=",".length>={0}");
    ConstraintLookupMap.put("cardinality<=",".length<={0}");
    ConstraintLookupMap.put("cardinality>",".length>{0}");
    ConstraintLookupMap.put("cardinality<",".length<{0}");
  }

  @umplesourcefile(line={31},file={"Generator.ump"},javaline={839},length={149})
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

  @umplesourcefile(line={32},file={"Generator.ump"},javaline={990},length={10})
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
  //  @umplesourcefile(line={14},file={"Generator_CodeRuby.ump"},javaline={1005},length={89})
  private static Map<String,String> UpperCaseSingularLookupMap ;

//  @umplesourcefile(line={15},file={"Generator_CodeRuby.ump"},javaline={1008},length={86})
  private static Map<String,String> UpperCasePluralLookupMap ;

//  @umplesourcefile(line={16},file={"Generator_CodeRuby.ump"},javaline={1011},length={83})
  private static Map<String,String> AsIsSingularLookupMap ;

//  @umplesourcefile(line={17},file={"Generator_CodeRuby.ump"},javaline={1014},length={80})
  private static Map<String,String> AsIsPluralLookupMap ;

//  @umplesourcefile(line={18},file={"Generator_CodeRuby.ump"},javaline={1017},length={77})
  private static List<String> OneOrManyLookup ;

//  @umplesourcefile(line={20},file={"Generator_CodeRuby.ump"},javaline={1020},length={74})
  static 
  {
    UpperCaseSingularLookupMap = new HashMap<String, String>();
    UpperCaseSingularLookupMap.put("attributeConstant", "{0}");

    UpperCasePluralLookupMap = new HashMap<String, String>();


    AsIsSingularLookupMap = new HashMap<String, String>();
    AsIsSingularLookupMap.put("parameterOne", "a_{0}");
    AsIsSingularLookupMap.put("removeParameterOne", "placeholder_{0}");
    AsIsSingularLookupMap.put("parameterNew", "a_new_{0}");
    AsIsSingularLookupMap.put("parameterNext", "next_{0}");
    AsIsSingularLookupMap.put("addMethod", "add_{0}");
    AsIsSingularLookupMap.put("addAtMethod", "add_{0}_at");
    AsIsSingularLookupMap.put("addOrMoveAtMethod", "add_or_move_{0}_at");
    AsIsSingularLookupMap.put("addViaMethod", "add_{0}_via");
    AsIsSingularLookupMap.put("removeMethod", "remove_{0}");
    AsIsSingularLookupMap.put("indexOfMethod", "index_of_{0}");
    AsIsSingularLookupMap.put("parameterOld", "an_old_{0}");
    AsIsSingularLookupMap.put("parameterExisting", "existing_{0}");
    AsIsSingularLookupMap.put("parameterExistingSerialized", "existing_serialized_{0}");
    AsIsSingularLookupMap.put("parameterIsNew", "is_new_{0}");
    AsIsSingularLookupMap.put("associationNew", "new_{0}");
    AsIsSingularLookupMap.put("canSetMethod", "can_set_{0}");
    AsIsSingularLookupMap.put("parameterCurrent", "current_{0}");
    AsIsSingularLookupMap.put("deleteMethod", "delete_{0}");
    AsIsSingularLookupMap.put("enterMethod", "enter_{0}");
    AsIsSingularLookupMap.put("exitMethod", "exit_{0}");
    AsIsSingularLookupMap.put("resetMethod", "reset_{0}");
    AsIsSingularLookupMap.put("getDefaultMethod", "get_default_{0}");
    AsIsSingularLookupMap.put("didAdd", "did_add_{0}");
    AsIsSingularLookupMap.put("hasMethod", "has_{0}");
    AsIsSingularLookupMap.put("associationCanSetOne","can_set_{0}");
    AsIsSingularLookupMap.put("attributeCanSetOne","can_set_{0}");
    AsIsSingularLookupMap.put("eventStartMethod", "start_{0}_handler");
    AsIsSingularLookupMap.put("eventStopMethod", "stop_{0}_handler");
    AsIsSingularLookupMap.put("associationOne","{0}");
    AsIsSingularLookupMap.put("attributeOne","{0}");
    AsIsSingularLookupMap.put("stateMachineOne","{0}");
    AsIsSingularLookupMap.put("eventMethod","{0}");
    AsIsSingularLookupMap.put("eventHandler","{0}_handler");
    AsIsSingularLookupMap.put("setMethod", "set_{0}");
    AsIsSingularLookupMap.put("getMethod", "get_{0}");
    AsIsSingularLookupMap.put("isMethod", "is_{0}");


    AsIsPluralLookupMap = new HashMap<String, String>();
    AsIsPluralLookupMap.put("parameterMany", "new_{0}");
    AsIsPluralLookupMap.put("parameterAll", "all_{0}");
    AsIsPluralLookupMap.put("numberOfMethod", "number_of_{0}");
    AsIsPluralLookupMap.put("minimumNumberOfMethod", "minimum_number_of_{0}");
    AsIsPluralLookupMap.put("maximumNumberOfMethod", "maximum_number_of_{0}");
    AsIsPluralLookupMap.put("isNumberOfValidMethod", "is_number_of_{0}_valid");
    AsIsPluralLookupMap.put("parameterVerifiedMany", "verified_{0}");
    AsIsPluralLookupMap.put("parameterOldMany", "old_{0}");
    AsIsPluralLookupMap.put("parameterCheckNewMany", "check_new_{0}");
    AsIsPluralLookupMap.put("parameterCopyOfMany", "copy_of_{0}");
    AsIsPluralLookupMap.put("parameterMany", "new_{0}");
    AsIsPluralLookupMap.put("didAddMany", "did_add_{0}");
    AsIsPluralLookupMap.put("hasManyMethod", "has_{0}");
    AsIsPluralLookupMap.put("associationCanSetMany","can_set_{0}");
    AsIsPluralLookupMap.put("attributeCanSetMany","can_set_{0}");
    AsIsPluralLookupMap.put("requiredNumberOfMethod", "required_number_of_{0}");
    AsIsPluralLookupMap.put("associationMany","{0}");
    AsIsPluralLookupMap.put("attributeMany","{0}");
    AsIsPluralLookupMap.put("getManyMethod", "get_{0}");
    AsIsPluralLookupMap.put("setManyMethod", "set_{0}");

    OneOrManyLookup = new ArrayList<String>();
    OneOrManyLookup.add("attribute");
    OneOrManyLookup.add("parameter");
  }

}