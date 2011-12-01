/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.umple.compiler;
import java.io.*;
import cruise.umple.util.*;
import java.util.*;

/**
 * Copyright: All contributers to the Umple Project
 * 
 * This file is made available subject to the open source license found at:
 * http://umple.org/license
 * 
 * This is our internal parser implementation for the Umple language.  It uses
 * a generic Parser that can read an external EBNF grammar file, and then populate
 * an abstract syntax tree.
 * 
 * The work of the UmpleInternalParser is 
 * 
 * a) The grammar definition (defined externally in *.grammar files)
 * b) Analyzing the AST to populate an Umple meta model instance
 * c) Delegating to our code generator to produce the necessary artifacts (i.e. Java / PHP / Ruby code)
 * 
 * Please refer to UmpleInternalParser_Code.ump for implementation details.
 */
public class UmpleInternalParser extends Parser implements UmpleParser
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UmpleInternalParser Attributes
  private String currentPackageName;
  private UmpleModel model;
  private List<String> unparsedUmpleFiles;
  private List<String> parsedUmpleFiles;
  private List<AssociationVariable> unlinkedAssociationVariables;
  private List<Association> unlinkedAssociations;
  private Map<Position,String> positionToClassNameReference;
  private Map<UmpleClass,List<String>> unlinkedExtends;
  private Map<UmpleInterface,List<String>> unlinkedInterfaceExtends;
  private List<Comment> lastComments;
  private StateMachine placeholderStateMachine;
  private Map<String,Token> stateMachineNameToToken;
  private Map<UmpleClass,Pair> umpleClassToStateMachineDefinition;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleInternalParser(String aName, UmpleModel aModel)
  {
    super(aName);
    currentPackageName = "";
    model = aModel;
    unparsedUmpleFiles = new ArrayList<String>();
    parsedUmpleFiles = new ArrayList<String>();
    unlinkedAssociationVariables = new ArrayList<AssociationVariable>();
    unlinkedAssociations = new ArrayList<Association>();
    positionToClassNameReference = new HashMap<Position, String>();
    unlinkedExtends = new HashMap<UmpleClass,List<String>>();
    unlinkedInterfaceExtends = new HashMap<UmpleInterface,List<String>>();
    lastComments = new ArrayList<Comment>();
    placeholderStateMachine = null;
    stateMachineNameToToken = new HashMap<String, Token>();
    umpleClassToStateMachineDefinition = new HashMap<UmpleClass, Pair>();
    init();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCurrentPackageName(String aCurrentPackageName)
  {
    boolean wasSet = false;
    currentPackageName = aCurrentPackageName;
    wasSet = true;
    return wasSet;
  }

  public boolean setModel(UmpleModel aModel)
  {
    boolean wasSet = false;
    model = aModel;
    wasSet = true;
    if(model != null && model.getUmpleFile() != null) { super.setFilename(model.getUmpleFile().getFileName()); super.setRootToken(reset());}
    return wasSet;
  }

  public String getCurrentPackageName()
  {
    return currentPackageName;
  }

  public UmpleModel getModel()
  {
    return model;
  }

  public void delete()
  {
    super.delete();
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
   public UmpleInternalParser()  {
this("UmpleInternalParser", new UmpleModel(null));
  }
 public UmpleInternalParser(UmpleModel aModel)  {
this("UmpleInternalParser", aModel);
  }
private void init()
  {
	if(model.getUmpleFile() != null)
	{
		setFilename(model.getUmpleFile().getFileName());
		setRootToken(reset()); // Makes sure the root token position has the filename
    }
    
    addCouple(new Couple("\"","\""));
    addCouple(new Couple("{","}"));
    addRulesInFile("/umple_core.grammar");
    addRulesInFile("/umple_classes.grammar");
    addRulesInFile("/umple_patterns.grammar");
    addRulesInFile("/umple_state_machines.grammar");
    addRulesInFile("/umple_traces.grammar");
    addRulesInFile("/umple_layout.grammar");
  }

  public ParseResult parse(String ruleName, String input)
  {
    return super.parse(ruleName,input);
  }

  public ParseResult analyze(boolean shouldGenerate)
  {
    parseAllFiles();
    analyzeAllTokens(getRootToken());
    postTokenAnalysis();
    if (shouldGenerate && getParseResult().getWasSuccess())
    {
      model.generate();
    }
    return getParseResult();
  }

  //------------------------
  // PRIVATE METHODS
  //------------------------

  // When an error occurs, set the failed position and mark the compile as NOT successful
  private void setFailedPosition(Position position, int errorCode, String message)
  {
    //getParseResult().setWasSuccess(false);
    getParseResult().setPosition(position);
    getParseResult().addErrorMessage(new ErrorMessage(errorCode,position,message));
  }

  // Analyze all child tokens of the "root" token.  This delegates to a individual
  // analyzeToken and quits early if a problem arises
  private void analyzeAllTokens(Token rootToken)
  {
    for(Token t : rootToken.getSubTokens())
    {
      analyzeToken(t);
      if (!getParseResult().getWasSuccess())
      {
        return;
      }
    }
  }

  // Delegate function to analyze a token within the context of a class
  // Each token is analyzed twice, analysisStep is "1" is for the first round of analysis
  // and "2" for the second.  The "2" is used for chicken-and-egg initialization problems, otherwise
  // put everything under the "1"
  private void analyzeAllTokens(Token rootToken, UmpleClass aClass, int analysisStep)
  {
    for(Token token : rootToken.getSubTokens())
    {
      analyzeToken(token,aClass,analysisStep);
      if (!getParseResult().getWasSuccess())
      {
        break;
      }
    }
  }

  // Delegate function to analyze a token and send it to the write
  private void analyzeToken(Token t)
  {
    analyzeCoreToken(t);
    analyzeClassToken(t);
    analyzeStateMachineToken(t);
    analyzeTraceToken(t);
    analyzeLayoutToken(t);
  }

  // Analyze an individual token, delegates to the various components in Umple
  private void analyzeToken(Token t, UmpleClass aClass, int analysisStep)
  {
    analyzeCoreToken(t,aClass,analysisStep);
    analyzeClassToken(t,aClass,analysisStep);
    analyzeStateMachineToken(t,aClass,analysisStep);
    analyzeTraceToken(t,aClass,analysisStep);
    analyzeLayoutToken(t,aClass,analysisStep);
  }
  
  // Once you have analyze all tokens, you allowed a second 'pass' to apply any additional checks
  // Each step in the process might "fail", so we check the status before calling each delegate
  // token post token analysis method
  private void postTokenAnalysis()
  {
    
    if (getParseResult().getWasSuccess())
    {
      postTokenCoreAnalysis();
    }
    if (getParseResult().getWasSuccess())
    {
      postTokenInterfaceAnalysis();
    }
    if (getParseResult().getWasSuccess())
    {
      postTokenClassAnalysis();  
    }

    if (getParseResult().getWasSuccess())
    {
      postTokenStateMachineAnalysis();
    }
    
    if (getParseResult().getWasSuccess())
    {
      postTokenTraceAnalysis();  
    }

    if (getParseResult().getWasSuccess())
    {
      postTokenLayoutAnalysis();
    }

  }


  // Locate all 'use *.ump' references and add those files if not already parsed 
  private void addNecessaryFiles()
  {
    for(Token t : getRootToken().getSubTokens())
    {
      if (t.is("use"))
      {
        String filename = model.getUmpleFile().getPath() + File.separator + t.getValue();

        if (!parsedUmpleFiles.contains(filename) && !unparsedUmpleFiles.contains(filename))
        {
          unparsedUmpleFiles.add(filename);
        }  
      }
    }
  }
  
  // Loop through all unparsed files, parse them, and add any missing references
  private void parseAllFiles()
  {
    addNecessaryFiles();
    while (!unparsedUmpleFiles.isEmpty())
    {
      String nextFile = unparsedUmpleFiles.get(0);
      unparsedUmpleFiles.remove(0);
      parsedUmpleFiles.add(nextFile);
      String input = SampleFileWriter.readContent(new File(nextFile));
      //TODO: parse() should probably be responsible for
      // reading file data, if we refactor it to be as such,
      // then we can get rid of this ugly bit of code
      setFilename(nextFile);
      parse("program", input);
      addNecessaryFiles();
    }    
  }
private void analyzeCoreToken(Token t)
  {
    if (t.is("generate") || t.is("generate_path"))
    {
    	analyzeGenerate(t);
    }
    else if (t.is("glossary"))
    {
      analyzeGlossary(t);
    }
    else if (t.is("namespace"))
    {
    	//if (currentPackageName.length() != 0)
    	//setFailedPosition(t.getPosition(), 3, t.getValue());
    	
      currentPackageName = t.getValue();
      if (model.getDefaultNamespace() == null)
      {
        model.setDefaultNamespace(currentPackageName);  
      }
    }
    else if (t.is("debug"))
    {
    	model.setDebugMode(true);
    }
  }

  // There are currently no core tokens of concern in the context of an UmpleClass
  // This method is available if needed
  private void analyzeCoreToken(Token t, UmpleClass aClass, int analysisStep)
  {

  }

  // Perform post token analysis on core elements of the Umple language
  private void postTokenCoreAnalysis()
  {
 	  boolean overrode_all = false;
		
	  List<GenerateTarget> gen = new ArrayList<GenerateTarget>(Arrays.asList(model.getGenerates()));
	  HashMap<String, Boolean> overrideMap = new HashMap<String,Boolean>();
		
	  for(GenerateTarget target : model.getGenerates())
	  {
	  	if(target.getOverride() && !overrideMap.containsKey(target.getLanguage()))
	  	{
	  	   // Target is based on key {language} so this 
	  	   // should remove everything with the same key
	  	   while(gen.remove(target));
	  	   overrideMap.put(target.getLanguage(), true);
	  	   gen.add(target);
	  	}
	  	else
	  	{
	  		// Issue a warning that a generate statement has been issued 
	  		// with the override keyword twice
	  	}
	  		
	  	if(target.getOverrideAll() && overrideMap.containsKey(target.getLanguage()))
	  	{
	  		// issue warning
	  	}

	  	if(target.getOverrideAll() && overrode_all)
	  	{
	  		// issue warning
	  		continue;
	  	}
	  		
	  	if(target.getOverrideAll())
	  	{
	  		gen.clear();
	  		gen.add(target);
	  		overrideMap.put(target.getLanguage(), true);
	  		overrode_all = true;
	  	}
	}
	
	model.clearGenerates();
	model.addGenerate(gen);
	
    if (model.getDefaultGenerate() == null)
    {
      model.addGenerate("Java");
    }
  }  


  // Add singular / plural forms of words to the glossary to be used by the code generator
  private void analyzeGlossary(Token glossaryToken)
  {
    for(Token wordToken : glossaryToken.getSubTokens())
    {
      if (!wordToken.is("word"))
      {
        continue;
      }
      Word word = new Word(wordToken.getValue("singular"),wordToken.getValue("plural"));
      model.getGlossary().addWord(word);
    }
  }
  
  private void analyzeGenerate(Token genToken)
  {
  	if(genToken.is("generate_path"))
  	{
  	  String language = genToken.getValue("language");
  	  String path = genToken.getValue("output");
  	  GenerateTarget target = new GenerateTarget(language, path);
  	      
  	  if(genToken.getValue("override") != null && genToken.getValue("override").equals("--override"))
  	  	target.setOverride(true);
  	  
  	  if(genToken.getValue("override") != null && genToken.getValue("override").equals("--override-all"))
  	  	target.setOverrideAll(true);
  	  
  	   model.addGenerate(target);
  	}
  	else
  	{
      model.addGenerate(genToken.getValue());
  	}
  }
private void analyzeClassToken(Token t)
  {
    boolean shouldConsumeComment = lastComments.size() > 0;
      
  	if (t.isStatic("//") || t.isStatic("/*") || t.isStatic("*/"))
  	{
  	  shouldConsumeComment = false;
  	  
  	}
    else if (t.is("inlineComment"))
    {
      analyzeComment(t);
      shouldConsumeComment = false;
    }  
    
    else if (t.is("multilineComment"))
    {
    	analyzeMultilineComment(t);
    	shouldConsumeComment = false;
    }
    else if (t.is("classDefinition"))
    {
      analyzeClass(t);
    }
    else if (t.is("externalDefinition"))
    {
      analyzeExternal(t);
    }
    else if (t.is("interfaceDefinition"))
    {
      analyzeInterface(t);
    }
    else if (t.is("associationClassDefinition"))
    {
      analyzeAssociationClass(t);
    }
    else if (t.is("associationDefinition"))
    {
      analyzeAllAssociations(t);
    }
    
    if (shouldConsumeComment)
    {
      lastComments.clear();
    }
    
  }  
  
  private void analyzeComment(Token token)
  {
  	if (!token.getValue().equals("$?[End_of_model]$?")) {
  		
  	lastComments.add(new Comment(token.getValue()));
  	}
  }
  
  private void analyzeMultilineComment(Token token)
  {
  	String inlineComments[] = token.getValue().split("\n");
  	
  	for (int i = 0; i < inlineComments.length; i++) {
  		Comment comment = new Comment(inlineComments[i]);
  		comment.isInline = false;
  		lastComments.add(comment);
  	}
  }
  
  // Analyzed class content tokens
  private void analyzeClassToken(Token token, UmpleClass aClass, int analysisStep)
  {
    if (analysisStep != 1)
    {
      return;
    }
    if (token.is("classDefinition"))
    {
      UmpleClass childClass = analyzeClass(token);
      childClass.setExtendsClass(aClass);
    }
    else if (token.is("attribute"))
    {
      analyzeAttribute(token,aClass);
    }
    else if (token.is("beforeCode") || token.is("afterCode"))
    {
      analyzeInjectionCode(token,aClass);
    }
    else if (token.is("key") || token.is("defaultKey")) 
    {
      analyzeKey(token,aClass);
    }
    else if (token.is("extraCode"))
    {
      aClass.appendExtraCode(token.getValue());
    }
    else if (token.is("constantDeclaration"))
    {
      analyzeConstant(token,aClass);
    }
    else if (token.is("concreteMethodDeclaration"))
    {
      analyzeMethod(token,aClass);
    }
    else if (token.is("depend"))
    {
      Depend d = new Depend(token.getValue());
      aClass.addDepend(d);
    }
    else if (token.is("inlineAssociation"))
    {
      analyzeinlineAssociation(token,aClass);
    }
    else if (token.is("symmetricReflexiveAssociation"))
    {
      analyzeSymmetricReflexiveAssociation(token,aClass);
    }
  }  
  
  // Link associations, association variables and extends that were "defined" after their use
  private void postTokenClassAnalysis()
  {
    if (verifyClassesInUse())
    {
    	checkSingletonAssociations();
      addUnlinkedAssociationVariables();
      addUnlinkedAssociations();
      addUnlinkedExtends();
    }
  }
  
  private void postTokenInterfaceAnalysis()
  {
      addUnlinkedInterfaceExtends();
  }
  
  
  private void analyzeAllAssociations(Token associationToken)
  {
    String name = associationToken.getValue("name");
    for(Token token : associationToken.getSubTokens())
    {
      if (token.is("association"))
      {
        Association association = analyzeAssociation(token, "");
        association.setName(name);
        unlinkedAssociations.add(association);
      }
    }
  }  

  private UmpleClass analyzeClass(Token classToken)
  {
    UmpleClass aClass = model.addUmpleClass(classToken.getValue("name"));
        
    for (Comment c : lastComments)
    {
      aClass.addComment(c);
    }
        
    addExtendsTo(classToken, aClass);
    if (classToken.getValue("singleton") != null)
    {
      aClass.setIsSingleton(true);
    }
    aClass.setPackageName(currentPackageName);
    
    if (aClass.getIsSingleton()) 
    {
    	classToken.setName(classToken.getName());	
    }
    analyzeAllTokens(classToken,aClass,1);
    analyzeAllTokens(classToken,aClass,2);
    return aClass;
  }
  
  private void addExtendsTo(Token classToken, UmpleClass aClass)
  {
    List<String> extendsList = new ArrayList<String>();
    for (Token extendsToken : classToken.getSubTokens()){
      if (extendsToken.getValue("extendsName") != null)
      { 
        extendsList.add(extendsToken.getValue("extendsName"));
        unlinkedExtends.put(aClass, extendsList);
      }  
    }
  }
    
  private void addExtendsTo(Token classToken, UmpleInterface aInterface)
  {
    List<String> extendsList = new ArrayList<String>();
    for (Token extendsToken : classToken.getSubTokens()){
      if (extendsToken.getValue("extendsName") != null)
      { 
        extendsList.add(extendsToken.getValue("extendsName"));
        unlinkedInterfaceExtends.put(aInterface, extendsList);
      }  
    }
  }

  private UmpleClass analyzeExternal(Token externalToken)
  {
    UmpleClass aClass = analyzeClass(externalToken);
    aClass.setModifier("external");
    return aClass;
  }
  
  private void analyzeInterface(Token t)
  {
    UmpleInterface newInterface = new UmpleInterface(t.getValue("name"));
    model.addUmpleInterface(newInterface);
    newInterface.setPackageName(currentPackageName);
    analyzeInterface(t,newInterface);  
  }

  private void analyzeInterface(Token interfaceToken, UmpleInterface aInterface)
  {
    for(Token token : interfaceToken.getSubTokens())
    {
      if (token.is("depend"))
      {
        Depend d = new Depend(token.getValue());
        aInterface.addDepend(d);
      }
      if (token.is("interfaceMemberDeclaration"))
      {
        analyzeInterfaceMembers(token, aInterface);
      }
      else if (token.is("elementPosition"))
      {
        aInterface.setPosition(new Coordinate(token.getIntValue("x"),token.getIntValue("y"), token.getIntValue("width"), token.getIntValue("height")));
      }

    }
  }

  private void addUnlinkedInterfaceExtends()
  {  
    for (UmpleInterface child : unlinkedInterfaceExtends.keySet())
    {
      List<String> extendsNames = unlinkedInterfaceExtends.get(child);

      if (extendsNames == null)
      {
        continue;
      }

      for (int i=0; i < extendsNames.size();i++){
        String extendName= extendsNames.get(i);
          UmpleInterface uInterface=  model.getUmpleInterface(extendName);
          child.addExtendsInterface(uInterface);
      }
    }
  }  

  private void analyzeInterfaceMembers(Token interfaceMemberToken, UmpleInterface aInterface)
  {
    for(Token childToken : interfaceMemberToken.getSubTokens())
    {
      addExtendsTo(interfaceMemberToken, aInterface);
      if(childToken.is("abstractMethodDeclaration"))
      {
        analyzeMethod(childToken, aInterface);   
      }  
      else if (childToken.is("constantDeclaration"))
      {
        analyzeConstant(childToken, aInterface);    
      }
      else if (childToken.is("extraCode"))
      {
        aInterface.appendExtraCode(childToken.getValue("extraCode"));
      }
    }
  }

  private void analyzeAssociationClass(Token classToken)
  {
    AssociationClass aClass = model.addAssociationClass(classToken.getValue("name"));
    addExtendsTo(classToken, aClass);
    analyzeAllTokens(classToken,aClass,1);
    analyzeAllTokens(classToken,aClass,2);
    
    aClass.setPackageName(currentPackageName);

    Token leftAssociationToken = null;
    Token rightAssociationToken = null;

    for(Token token : classToken.getSubTokens())
    {
      if (token.is("singleAssociationEnd"))
      {
        if (leftAssociationToken == null)
        {
          leftAssociationToken = token;
        }
        else
        {
          rightAssociationToken = token;
        }
      }
    }

    if (leftAssociationToken == null || rightAssociationToken == null)
    {
      setFailedPosition(classToken.getPosition(), 8, classToken.getValue("name"));
      return;
    }

    String innerName = null;
    String innerType = aClass.getName();
    String innerModifier = null;
    Multiplicity innerMult = new Multiplicity();
    innerMult.setRange("0","1"); 

    String leftName = leftAssociationToken.getValue("roleName");
    String leftType = leftAssociationToken.getValue("type");
    String leftModifier = leftAssociationToken.getValue("modifier");
    String leftBound = leftAssociationToken.getValue("bound");
    String leftLowerBound = leftAssociationToken.getValue("lowerBound");
    String leftUpperBound = leftAssociationToken.getValue("upperBound");
    Multiplicity leftMult = new Multiplicity();
    leftMult.setBound(leftBound);
    leftMult.setRange(leftLowerBound,leftUpperBound);

    String rightName = rightAssociationToken.getValue("roleName");
    String rightType = rightAssociationToken.getValue("type");
    String rightModifier = rightAssociationToken.getValue("modifier");
    String rightBound = rightAssociationToken.getValue("bound");
    String rightLowerBound = rightAssociationToken.getValue("lowerBound");
    String rightUpperBound = rightAssociationToken.getValue("upperBound");
    Multiplicity rightMult = new Multiplicity();
    rightMult.setBound(rightBound);
    rightMult.setRange(rightLowerBound,rightUpperBound);

    AssociationEnd leftFirstEnd = new AssociationEnd(innerName,innerType,innerModifier,leftType,leftMult);
    AssociationEnd leftSecondEnd = new AssociationEnd(leftName,leftType,leftModifier,innerType,innerMult);

    AssociationEnd rightFirstEnd = new AssociationEnd(innerName,innerType,innerModifier,rightType,rightMult);
    AssociationEnd rightSecondEnd = new AssociationEnd(rightName,rightType,rightModifier,innerType,innerMult);    

    updateAssociationEnds(leftFirstEnd,leftSecondEnd);
    updateAssociationEnds(rightFirstEnd,rightSecondEnd);

    Association leftAssociation = new Association(true,true,leftFirstEnd,leftSecondEnd);
    Association rightAssociation = new Association(true,true,rightFirstEnd,rightSecondEnd);

    model.addAssociation(leftAssociation);
    model.addAssociation(rightAssociation);

    unlinkedAssociations.add(leftAssociation);
    unlinkedAssociations.add(rightAssociation);
  }
  
  private boolean verifyClassesInUse()
  {
    for(Map.Entry<Position, String> e : positionToClassNameReference.entrySet())
    {
      if (model.getUmpleClass(e.getValue()) == null)
      {
        UmpleClass aClass = model.addUmpleClass(e.getValue());
        aClass.setPackageName(model.getDefaultNamespace());
        setFailedPosition(e.getKey(), 5, e.getValue());
        return false;
      }
    }
    return true;
  }
  
  private void addUnlinkedAssociationVariables()
  {
    for (AssociationVariable av : unlinkedAssociationVariables)
    {
      UmpleClass aClass = model.getUmpleClass(av.getType());
      UmpleClass bClass = model.getUmpleClass(av.getRelatedAssociation().getType());       
      
      aClass.addAssociationVariable(av.getRelatedAssociation());
      aClass.addAssociation(bClass.getAssociation(bClass.indexOfAssociationVariable(av)));

      if (av.getIsNavigable())
      {
        bClass.addReferencedPackage(aClass.getPackageName());
      }

      if (av.getRelatedAssociation().getIsNavigable())
      {
        aClass.addReferencedPackage(bClass.getPackageName());
      }

    }
  }

  private boolean isUmpleClass(String elementName)
  {
    return (model.getUmpleInterface(elementName) != null) ? false: true;
  }

  private void addUnlinkedExtends()
  {  
    for (UmpleClass child : unlinkedExtends.keySet())
    {
      List<String> extendsNames = unlinkedExtends.get(child);

      if (extendsNames == null)
      {
        continue;
      }

      for (int i=0; i < extendsNames.size();i++){
        String extendName= extendsNames.get(i);
        if (isUmpleClass(extendName))
        {
          UmpleClass parent = model.getUmpleClass(extendName); 
          child.setExtendsClass(parent);
        }
        else {
          UmpleInterface uInterface=  model.getUmpleInterface(extendName);
          child.addParentInterface(uInterface);
          addImplementedMethodsFromInterface(uInterface, child);
        }
      }
    }
  }  


  private void addImplementedMethodsFromInterface(UmpleInterface parentInterface, UmpleClass uClass)
  {
    //GET AND SET METHODS CHECK?
    if (parentInterface.hasMethods())
    {
      for (Method aMethod : parentInterface.getMethods())
      {
        boolean shouldAddMethod = verifyIfMethodIsConstructorOrGetSet(uClass, aMethod);
        if (!(uClass.hasMethod(aMethod)) && shouldAddMethod)
        {
          aMethod.setIsImplemented(true);
          uClass.addMethod(aMethod);
        }
      }
    }
  }

  private boolean verifyIfMethodIsConstructorOrGetSet(UmpleClass uClass, Method aMethod)
  {
    String methodName = aMethod.getName();

    //1. Verify if method to be added is a setter or a getter
    String accessorName = methodName.substring(0,3);
    if ((accessorName.equals("get")) || (accessorName.equals("set"))){
      String possibleAttributeName =   methodName.substring(3,methodName.length()).toLowerCase();
      Attribute attr = uClass.getAttribute(possibleAttributeName);
      if (attr != null){
        return false;
      }
    }
    //2. Verify if method to be added is a constructor
    if (aMethod.getType().equals("public")){
      uClass.appendExtraCode(aMethod.toString());
      return false;
    }  
    //3. Verify if method from interface is already part of the Class extracode
    String match = "public " + aMethod.getType() + " " + aMethod.getName();    
    if (uClass.getExtraCode().contains(match)){
      return false;
    }
    return true;
  }

private void checkSingletonAssociations() {
	for (Association association : model.getAssociations()) {
		AssociationEnd myEnd = association.getEnd(0);
      AssociationEnd yourEnd = association.getEnd(1);

      UmpleClass myClass = model.getUmpleClass(myEnd.getClassName());
      UmpleClass yourClass = model.getUmpleClass(yourEnd.getClassName());

		if (myClass.getIsSingleton() && (yourEnd.getMultiplicity().getRangeParts()[0].equals("1") && yourEnd.getMultiplicity().getRangeParts()[1].equals("1"))) {
    	yourEnd.getMultiplicity().setRange("0", "1");
    	yourEnd.getMultiplicity().setBound(null);
    	setFailedPosition(association.getTokenPosition(), 2, association.getName());  
    }
        
    if (yourClass.getIsSingleton() && (myEnd.getMultiplicity().getRangeParts()[0].equals("1") && myEnd.getMultiplicity().getRangeParts()[1].equals("1"))) {
    	myEnd.getMultiplicity().setRange("0", "1");
    	myEnd.getMultiplicity().setBound(null);
    	setFailedPosition(association.getTokenPosition(), 2, association.getName());
    }
		
		if(myClass.getIsSingleton() && (myEnd.getMultiplicity().getUpperBound() < 0 || myEnd.getMultiplicity().getUpperBound() > 1)) {
			setFailedPosition(association.getTokenPosition(), 10, myEnd.getClassName());
		}
		
		if(yourClass.getIsSingleton() && (yourEnd.getMultiplicity().getUpperBound() < 0 || yourEnd.getMultiplicity().getUpperBound() > 1)) {
			setFailedPosition(association.getTokenPosition(), 10, yourEnd.getClassName());
		}
	}
}

  private void addUnlinkedAssociations()
  {
    for (Association association : unlinkedAssociations)
    {      	
      AssociationEnd myEnd = association.getEnd(0);
      AssociationEnd yourEnd = association.getEnd(1);

      UmpleClass myClass = model.getUmpleClass(myEnd.getClassName());
      UmpleClass yourClass = model.getUmpleClass(yourEnd.getClassName());
    	
      AssociationVariable myAs = new AssociationVariable(myEnd.getRoleName(),myEnd.getClassName(),myEnd.getModifier(),null,myEnd.getMultiplicity(),association.getIsLeftNavigable());
      AssociationVariable yourAs = new AssociationVariable(yourEnd.getRoleName(),yourEnd.getClassName(),yourEnd.getModifier(),null,yourEnd.getMultiplicity(),association.getIsRightNavigable());
      myAs.setRelatedAssociation(yourAs);
      myClass.addAssociationVariable(yourAs);
      myClass.addAssociation(association);

      yourClass.addAssociationVariable(myAs);
      yourClass.addAssociation(association);


      if (myAs.getIsNavigable())
      {
        myClass.addReferencedPackage(yourClass.getPackageName());
      }

      if (yourAs.getIsNavigable())
      {
        yourClass.addReferencedPackage(myClass.getPackageName());
      }      

    }
  }

  private void analyzeMethod(Token method, UmpleElement uElement)
  {
    String modifier = "";
    Method aMethod = new Method("","","",false);
    for(Token token : method.getSubTokens())
    {
      if (token.is("modifier"))
      {
        modifier += " " + (token.getValue());
        aMethod.setModifier(modifier);
      }
      else if (token.is("type"))
      {
        aMethod.setType(token.getValue());
      }
      else if (token.is("methodDeclarator"))
      {
        analyzeMethodDeclarator(token, aMethod);
      }
      else if (token.is("code"))
      {
        aMethod.setMethodBody(new MethodBody(token.getValue()));
      }
    }  

    // Add method to Class or Interface
    if (uElement instanceof UmpleClass)
    {
      UmpleClass uClass = (UmpleClass) uElement;
      boolean shouldAddMethod = verifyIfMethodIsConstructorOrGetSet(uClass, aMethod);
      if (!uClass.hasMethod(aMethod) && shouldAddMethod ){
        uClass.addMethod(aMethod); 
      }
    }
    else if (uElement instanceof UmpleInterface)
    {
      UmpleInterface uInterface = (UmpleInterface) uElement;
      if (!uInterface.hasMethod(aMethod)){
        uInterface.addMethod(aMethod); 
      }
    }  
  }

  private void analyzeMethodDeclarator(Token token, Method aMethod)
  {
    for(Token methodToken : token.getSubTokens())
    {
      if (methodToken.is("methodName")){
        aMethod.setName(methodToken.getValue());
      }
      if (methodToken.is("parameterList")){
        for(Token parameterToken : methodToken.getSubTokens())
        {
          boolean isList = false;
          if (parameterToken.is("parameter")){
            String paramType="";
            if (parameterToken.getSubToken("type") != null){
              paramType = parameterToken.getSubToken("type").getValue();
            }
            if (parameterToken.getSubToken("list") != null){
              isList = parameterToken.getSubToken("list").getValue() != null;        
            }
            String paramName = parameterToken.getSubToken("name").getValue();
            MethodParameter aParameter  = new MethodParameter(paramName,paramType,null,null, false);
            aParameter.setIsList(isList);
            aMethod.addMethodParameter(aParameter);
          }
        }
      }
    }
  }

  private void analyzeConstant(Token constantToken, UmpleElement uElement)
  {
    Constant aConstant = new Constant("","","","");
    String modifier = "";
    // Create the Constant Object
    for(Token token : constantToken.getSubTokens())
    {
      if (token.is("modifier"))
      {
        modifier += " " + (token.getSubToken(0).getName());
        aConstant.setModifier(modifier);
      }
      else if (token.is("name"))
      {
        aConstant.setName(token.getValue());
      }
      else  if (token.is("type"))
      {
        aConstant.setType(token.getValue());
      }
      else  if (token.is("value"))
      {
        aConstant.setValue(token.getValue());
      }
    }  
    // Add constant to Class or Interface
    if (uElement instanceof UmpleClass)
    {
      UmpleClass uClass = (UmpleClass) uElement;
      uClass.addConstant(aConstant);
    }
    else if (uElement instanceof UmpleInterface)
    {
      UmpleInterface uInterface = (UmpleInterface) uElement;
      uInterface.addConstant(aConstant);
    }  
  }


  private void analyzeInjectionCode(Token injectToken, UmpleClass aClass)
  {
    String type = injectToken.is("beforeCode") ? "before" : "after";
    aClass.addCodeInjection(new CodeInjection(type,injectToken.getValue("operationName"),injectToken.getValue("code")));
  }

  private void analyzeKey(Token keyToken, UmpleClass aClass)
  {
    if (aClass.getKey().isProvided())
    {
      setFailedPosition(keyToken.getPosition(), 7, keyToken.getParentToken().getValue("name"));
    }

    if (keyToken.is("defaultKey"))
    {
      aClass.getKey().setIsDefault(true);
      return;
    }

    for(Token token : keyToken.getSubTokens())
    {
      if (!token.is("keyId"))
      {
        continue;
      }
      aClass.getKey().addMember(token.getValue());
    }
  }

  private void analyzeSymmetricReflexiveAssociation(Token symmetricReflexiveAssociationToken, UmpleClass aClass)
  {
    String myName = symmetricReflexiveAssociationToken.getValue("roleName");
    String myType = aClass.getName();
    String myModifier = "symmetricreflexive";
    String myBound = symmetricReflexiveAssociationToken.getValue("bound");
    String myLowerBound = symmetricReflexiveAssociationToken.getValue("lowerBound");
    String myUpperBound = symmetricReflexiveAssociationToken.getValue("upperBound");
    Multiplicity myMult = new Multiplicity();
    myMult.setBound(myBound);
    myMult.setRange(myLowerBound,myUpperBound);

    AssociationVariable myAs = new AssociationVariable(myName,myType,myModifier,null,myMult,true);
    AssociationVariable yourAs = new AssociationVariable(myName,myType,myModifier,null,myMult,true);

    myAs.setRelatedAssociation(yourAs);
    aClass.addAssociationVariable(yourAs);
  }

  private Association createAssociation(String navigation, AssociationEnd firstEnd, AssociationEnd secondEnd)
  {
    boolean isNavigable = "--".equals(navigation);
    boolean isFirstNavigable = "<-".equals(navigation) || isNavigable;
    boolean isSecondNavigable = "->".equals(navigation) || isNavigable;
    return new Association(isFirstNavigable,isSecondNavigable,firstEnd,secondEnd);
  }

  private Association analyzeAssociation(Token associationToken, String defaultMyType)
  {
    Token myMultToken = associationToken.getSubToken(0);

    String navigation = associationToken.getValue("arrow");
    Token yourMultToken = associationToken.getSubToken(2);

    String myName = myMultToken.getValue("roleName");
    String myType = myMultToken.getValue("type") == null ? defaultMyType : myMultToken.getValue("type");
        
    String myModifier = myMultToken.getValue("modifier");
    String myBound = myMultToken.getValue("bound");
    String myLowerBound = myMultToken.getValue("lowerBound");
    String myUpperBound = myMultToken.getValue("upperBound");
    Multiplicity myMult = new Multiplicity(); 
    myMult.setBound(myBound);
    myMult.setRange(myLowerBound,myUpperBound);

    if (!myMult.isValid())
    {    	    	
	   	String invalidBound = myBound == null ? invalidBound = myLowerBound + ".." + myUpperBound : myBound;
      setFailedPosition(myMultToken.getPosition(), 4, invalidBound);
      return null;
    }

    String yourName = yourMultToken.getValue("roleName");
    String yourType = yourMultToken.getValue("type");
    String yourModifier = yourMultToken.getValue("modifier");
    String yourBound = yourMultToken.getValue("bound");
    String yourLowerBound = yourMultToken.getValue("lowerBound");
    String yourUpperBound = yourMultToken.getValue("upperBound");
    
    Multiplicity yourMult = new Multiplicity();
    yourMult.setBound(yourBound);
    yourMult.setRange(yourLowerBound,yourUpperBound);

    AssociationEnd firstEnd = new AssociationEnd(myName,myType,myModifier,yourType,myMult);
    AssociationEnd secondEnd = new AssociationEnd(yourName,yourType,yourModifier,myType,yourMult);
    updateAssociationEnds(firstEnd,secondEnd);

    Association association = createAssociation(navigation,firstEnd,secondEnd);

	association.setTokenPosition(associationToken.getPosition());
    if (!association.isValid())
    {
      Token atFaultToken = association.whoIsInvalid() == 0 ? myMultToken : yourMultToken;
      String invalidBound = atFaultToken.getValue("bound") == null ? invalidBound = atFaultToken.getValue("lowerBound") + ".." + atFaultToken.getValue("upperBound") : atFaultToken.getValue("bound");
      setFailedPosition(atFaultToken.getPosition(), 9, invalidBound);
      return null;
    }

    positionToClassNameReference.put(yourMultToken.getPosition("type"),yourType);
    model.addAssociation(association);
    return association;
  }

  private void updateAssociationEnds(AssociationEnd firstEnd, AssociationEnd secondEnd)
  {
  	  	
    if (firstEnd.getRoleName().length() == 0)
    { 
      String rawName = StringFormatter.toCamelCase(firstEnd.getClassName());
      String name = firstEnd.getMultiplicity().isMany() ? model.getGlossary().getPlural(rawName) : rawName;
      firstEnd.setRoleName(name);
      firstEnd.setIsDefaultRoleName(true);
    }

    if (secondEnd.getRoleName().length() == 0)
    {
      String rawName = StringFormatter.toCamelCase(secondEnd.getClassName());
      String name = secondEnd.getMultiplicity().isMany() ? model.getGlossary().getPlural(rawName) : rawName;
      secondEnd.setRoleName(name);
      secondEnd.setIsDefaultRoleName(true);
    }
  }

  private void analyzeinlineAssociation(Token inlineAssociationToken, UmpleClass aClass)
  {
    Association association = analyzeAssociation(inlineAssociationToken,aClass.getName());

    if (!getParseResult().getWasSuccess())
    {
      return;
    }

    AssociationEnd myEnd = association.getEnd(0);
    AssociationEnd yourEnd = association.getEnd(1);

    AssociationVariable myAs = new AssociationVariable(myEnd.getRoleName(),myEnd.getClassName(),myEnd.getModifier(),null,myEnd.getMultiplicity(),association.getIsLeftNavigable());
    AssociationVariable yourAs = new AssociationVariable(yourEnd.getRoleName(),yourEnd.getClassName(),yourEnd.getModifier(),null,yourEnd.getMultiplicity(),association.getIsRightNavigable());
    myAs.setRelatedAssociation(yourAs);

    unlinkedAssociationVariables.add(yourAs);
    aClass.addAssociationVariable(yourAs);
    aClass.addAssociation(association);
  }

  private void analyzeAttribute(Token attributeToken, UmpleClass aClass)
  {
    boolean isAutounique = attributeToken.getValue("autounique") != null;
    boolean isUnique = attributeToken.getValue("unique") != null;
    boolean isLazy = attributeToken.getValue("lazy") != null;
    if (aClass.getIsSingleton()) {
    	isLazy = true;
    	setFailedPosition(attributeToken.getPosition(), 1, attributeToken.getValue("name"));
    }
    String modifier = attributeToken.getValue("modifier");
    String type = attributeToken.getValue("type");
    String name = attributeToken.getValue("name");
    String value = attributeToken.getValue("value");
    String derivedValue = attributeToken.getValue("derivedValue");

    if (derivedValue != null)
    {
      value = derivedValue;
    }

    if ("defaulted".equals(modifier) && value == null)
    {
      setFailedPosition(attributeToken.getPosition(), 6, attributeToken.getValue("name"));
      return;
    }

    if (isUnique)
    {
      UniqueIdentifier uniqueIdentifier = new UniqueIdentifier(name,type,modifier,value);
      aClass.setUniqueIdentifier(uniqueIdentifier);
      return;
    }

    if (isAutounique)
    {
      type = "Integer";
    }

    if (type == null)
    {
      type = "String";
    }

    Attribute attribute = new Attribute(name,type,modifier,value,isAutounique);
    attribute.setIsLazy(isLazy);
    boolean isList = attributeToken.getValue("list") != null;

    if (name == null)
    {
      String rawName = StringFormatter.toCamelCase(type); 
      name = isList ? model.getGlossary().getPlural(rawName) : rawName;
    }

    if (derivedValue != null)
    {
      attribute.setIsDerived(true);
    }

    attribute.setIsList(isList);
    aClass.addAttribute(attribute);

  }
private void analyzeStateMachineToken(Token token)
  {
    if (token.is("stateMachineDefinition"))
    {
      analyzeStateMachineDefinition(token);
    }
  }  
  
  // Analyze state machine related tokens within the context of an Umple class
  private void analyzeStateMachineToken(Token token, UmpleClass aClass, int analysisStep)
  {
    if (analysisStep != 1)
    {
      return;
    }
    
    if (token.is("stateMachine"))
    {
      Token subToken = token.getSubToken(0);
      if (subToken.is("enum") || subToken.is("inlineStateMachine"))
      {
        analyzeStateMachine(subToken,aClass);
      }
      else if (subToken.is("referencedStateMachine"))
      {
        analyzedReferencedStateMachine(subToken,aClass);
      }
    }
  }

  
  private void postTokenStateMachineAnalysis()
  {
    addReferencedStateMachines();
  }
  
  private void addReferencedStateMachines()
  {
    for (UmpleClass clazz : umpleClassToStateMachineDefinition.keySet())
    {
      Pair nameToDefinition = umpleClassToStateMachineDefinition.get(clazz);
      Token stateMachineToken = stateMachineNameToToken.get(nameToDefinition.getValue());
      if (stateMachineToken == null)
      {
        continue;
      }

      StateMachine sm = new StateMachine(nameToDefinition.getName());
      sm.setUmpleClass(clazz);

      // analyze meta states

      populateStateMachine(stateMachineToken,sm);
    }
  }
  
  private void analyzeStateMachineDefinition(Token stateMachineDefinitionToken)
  {
    StateMachine smd = analyzeStateMachine(stateMachineDefinitionToken,null);
    model.addStateMachineDefinition(smd);
  }

  private void analyzedReferencedStateMachine(Token stateMachineToken, UmpleClass aClass)
  {
    String name = stateMachineToken.getValue("name");
    String value = stateMachineToken.getValue("definitionName");
    umpleClassToStateMachineDefinition.put(aClass,new Pair(name,value));


    // analyze meta states
  }

  private StateMachine analyzeStateMachine(Token stateMachineToken, UmpleClass aClass)
  {
    placeholderStateMachine = new StateMachine("PLACE_HOLDER");
    String name = stateMachineToken.getValue("name");
    stateMachineNameToToken.put(name,stateMachineToken);
    StateMachine sm = new StateMachine(name);
    sm.setUmpleClass(aClass);
    populateStateMachine(stateMachineToken, sm);

    while (placeholderStateMachine.numberOfStates() > 0)
    {
      placeholderStateMachine.getState(0).setStateMachine(sm);
    }
    return sm;
  }

  private State createStateFromTransition(Token transitionToken, StateMachine sm)
  {
    String name = transitionToken.getValue("stateName");
    State nextState = sm.findState(name);
    if (nextState == null)
    {
      nextState = placeholderStateMachine.findState(name);
    }

    if (nextState == null)
    {
      nextState = new State(transitionToken.getValue("stateName"),placeholderStateMachine);
    }
    return nextState;
  }

  private State createStateFromDefinition(Token stateToken, StateMachine sm)
  {
    State s = sm.findState(stateToken.getValue("stateName"),false);
    if (s == null)
    {
      s = placeholderStateMachine.findState(stateToken.getValue("stateName"));
      if (s != null)
      {
        s.setStateMachine(sm);
      }
    }
    if (s == null)
    {
      s = new State(stateToken.getValue("stateName"),sm);
    }
    return s;
  }

  private void populateStateMachine(Token stateMachineToken, StateMachine sm)
  {
    boolean isFirst = true;
    for(Token stateToken : stateMachineToken.getSubTokens())
    {
      if (!stateToken.is("state") && !stateToken.is("stateName"))
      {
        continue;
      }

      State s = createStateFromDefinition(stateToken,sm);
      if (isFirst)
      {
        s.setIsStartState(true);
      }
      isFirst = false;
      analyzeState(stateToken, s);
    }
  }

  private void analyzeState(Token stateToken, State fromState)
  {
      boolean addNewSm = true;
      boolean isConcurrentState = false;
    for(Token subToken : stateToken.getSubTokens())
    {
      if (subToken.is("transition"))
      {
        analyzeTransition(subToken, fromState); 
        continue;
      }
      else if (subToken.is("activity"))
      {
        analyzeActivity(subToken, fromState);
      }
      else if (subToken.is("entryOrExitAction"))
      {
        Action action = new Action(subToken.getValue("actionCode"));
        action.setActionType(subToken.getValue("type"));
        fromState.addAction(action);
      }
      else if (subToken.is("||"))
      {
        if (fromState.numberOfNestedStateMachines() == 0) { continue; }
        int previousSmIndex = fromState.numberOfNestedStateMachines() - 1;
              StateMachine nestedSm = fromState.getNestedStateMachine(previousSmIndex);
              if (nestedSm.numberOfStates() == 0) { continue; }
              nestedSm.setName(nestedSm.getState(0).getName());
              addNewSm = true;
              isConcurrentState = true;
      }
      else if (subToken.is("state"))
      {
        StateMachine nestedStateMachine = null;
        if (addNewSm)
        {
          nestedStateMachine = new StateMachine(fromState.getName());
          fromState.addNestedStateMachine(nestedStateMachine);
        }
        else
        {
          int lastIndex = fromState.numberOfNestedStateMachines() - 1;
          nestedStateMachine = fromState.getNestedStateMachine(lastIndex);
        }
        State s = createStateFromDefinition(subToken,nestedStateMachine);
        //alignStateDefinitionWithStateMachine(s,nestedStateMachine);
        if (addNewSm)
        {
                  if (isConcurrentState)
                  {
                    nestedStateMachine.setName(s.getName());
                  }
          s.setIsStartState(true);
        }
        addNewSm = false;
        analyzeState(subToken, s);
      }
    }
  }

  private void analyzeActivity(Token activityToken, State fromState)
  {
    new Activity(activityToken.getValue("activityCode"),fromState);
  }


  private void analyzeTransition(Token transitionToken, State fromState)
  {
    State nextState = createStateFromTransition(transitionToken,fromState.getStateMachine());
    Transition t = new Transition(fromState, nextState);

    String eventName = transitionToken.getValue("event");
    String eventTimerAmount = transitionToken.getValue("timer");

    if (eventName == null && eventTimerAmount != null)
    {
      eventName = fromState.newTimedEventName(nextState);
    }

    Token guardToken = transitionToken.getSubToken("guard");
    if (guardToken != null)
    {
      t.setGuard(new Guard(guardToken.getValue("guardCode")));
    }

    Token actionToken = transitionToken.getSubToken("action");
    if (actionToken != null)
    {
      t.setAction(new Action(actionToken.getValue("actionCode")));
    }

    if (eventName != null)
    {
      StateMachine sm = fromState.getStateMachine();
      UmpleClass uClass = sm.getUmpleClass();
      Event event = uClass == null ? sm.findOrCreateEvent(eventName) : uClass.findOrCreateEvent(eventName);
      if (eventTimerAmount != null)
      {
        event.setIsTimer(true);
        event.setTimerInSeconds(eventTimerAmount);
      }
      t.setEvent(event);
    }

  }
private void analyzeTraceToken(Token token)
  {
    if (token.is("traceType"))
    {
      model.setTraceType(token.getValue("traceType"));
    }
  }
  //****************************************
  //********* Trace Glue Code   ************
  //****************************************
  
  // Process trace related tokens within the context of a class
  private void analyzeTraceToken(Token token, UmpleClass aClass, int analysisStep)
  {
    // Only process trace tokens once all other entities have been analyzed
    if (analysisStep != 2)
    {
      return;
    }
    
    // Analyze trace statement token
    if (token.is("trace"))
    {
    	analyzeTraceStatement(aClass, token);
    }
  }
  
  // Process Trace statement subtokens. Token could be trace directive or trace case
  private void analyzeTraceStatement( UmpleClass aClass, Token token)
  {
	  TraceDirective traceDirective = new TraceDirective();
      MethodTraceEntity mte = new MethodTraceEntity();
      traceDirective.setUmpleClass(aClass);
      
      for( Token traceToken : token.getSubTokens() )
      {
    	  if( traceToken.is("trace_entity") )
    	  {
    		  analyzeTraceItem( traceToken , traceDirective , mte );
    	  }
    	  else if( traceToken.getName().equals("entry") )
    	  {
    		  mte.setEntry(true);
    	  }
    	  else if( traceToken.getName().equals("exit") )
    	  {
    		  mte.setExit(true);
    	  }
    	  else if( traceToken.is("traceWhere") )
    	  {
    		  TraceCondition tc = analyzeTraceCondition( traceToken, "where");
    		  traceDirective.addCondition(tc);
    	  }
    	  else if( traceToken.is("traceUntil") )
    	  {
    		  TraceCondition tc = analyzeTraceCondition( traceToken, "until");
    		  traceDirective.addCondition(tc);
    	  }
    	  else if( traceToken.is("traceAfter") )
    	  {
    		  TraceCondition tc = analyzeTraceCondition( traceToken, "after");
    		  traceDirective.addCondition(tc);
    	  }  	  
    	  else if( traceToken.is("trace_for") )
    	  {
    		  traceDirective.setForClause(Integer.parseInt(token.getValue("trace_for")));
    	  } 	  
    	  else if( traceToken.is("trace_period") )
    	  {
    		  traceDirective.setPeriodClause(token.getValue("trace_period"));
    	  }	  
    	  else if( traceToken.is("trace_duration") )
    	  {
    		  traceDirective.setDuringClause(token.getValue("trace_duration"));
    	  }	  
    	  else if( traceToken.is("trace_execute") )
    	  {
    		  traceDirective.setExecuteClause(token.getValue("trace_execute"));
    	  }  
    	  else if( traceToken.is("tracecase_name") )
    	  {
    		  analyzeTraceCaseToken( aClass , token );
    		  return;
    	  }
      }
  }
  
  // Analyze Trace Item Token whether trace item is an attribute or a method ... etc
  private void analyzeTraceItem( Token traceToken, TraceDirective traceDirective, MethodTraceEntity mte)
  {
	  Attribute attr = traceDirective.getUmpleClass().getAttribute(traceToken.getValue("trace_entity"));
	  List<StateMachine> stms = traceDirective.getUmpleClass().getStateMachines();
	  StateMachine stm = null;
	  String methodName = traceToken.getValue("trace_entity");
	  
	  // here, i faced a problem of finding traced state machine because
	  // -> in UmpleClass there no getStateMachine( String stm ) which gets state by searching its name
	  for( int i = 0 ; i < stms.size() ; ++i )
		  if( stms.get(i).getFullName().equals(traceToken.getValue("trace_entity")))
		  {
			  stm = stms.get(i);
			  break;
		  }
		  
	  // if trace entity is a method
	  if( methodName.contains("("))
	  {
		  if( mte.getName() !=  null)
		  {
			  mte = new MethodTraceEntity();
		  }
		  mte.setName(methodName);
		  traceDirective.addMethodTraceEntity(mte);
	  }
	  // if trace entity is an attribute
	  else if( attr != null )
	  {
		  traceDirective.addAttribute(attr);
	  }
	  // if trace entity is a state machine
	  else if( stm != null )
	  {
		  traceDirective.addStateMachine(stm);
	  }
	  
  }
  
  // Analyze Trace Condition Token. Called when different Trace Directive conditions are encountered (where,until,after)
  // Returns a trace condition filled with left and right hands operands, with comparison operator used
  private TraceCondition analyzeTraceCondition( Token traceConditionToken , String conditionType )
  {
	  ConditionRhs rhs = new ConditionRhs();
	  TraceCondition tc = new TraceCondition(rhs);
	  tc.setConditionType(conditionType);
	  for( Token subToken : traceConditionToken.getSubTokens() )
	  {
		  if(subToken.is("LHS"))
			  tc.setLhs(subToken.getValue("LHS"));
		  if(subToken.is("comparison_operator"))
			  rhs.setComparisonOperator(subToken.getValue("comparison_operator"));
		  if(subToken.is("RHS"))
			  rhs.setRhs(subToken.getValue("RHS"));
	  }
	  tc.setRhs(rhs);
	  return tc;
  }
  
  // Analyzes trace case token and its subtokens (i.e. trace directive tokens)
  public void analyzeTraceCaseToken( UmpleClass aClass , Token token )
  {
	  TraceCase tca = new TraceCase();
	  TraceDirective td = new TraceDirective();
	  td.setUmpleClass(aClass);
	  // set trace case name
	  tca.setName(token.getValue("tracecase_name"));
	  
	  for( Token traceToken : token.getSubTokens() )
	  { 
		  // "trace" indicates the beginning of a trace directive
		  if( traceToken.getName().equals("trace") )
		  {
			  td = new TraceDirective();
			  td.setUmpleClass(aClass);
		  }
		  // ";" indicates the end of a trace directive, once true, then the trace directive is added to the trace case
		  else if( traceToken.getName().equals(";") )
		  {
			  tca.addTraceDirective(td);
		  }
		  else
			  analyzeTraceDirectiveFragments( td , aClass , traceToken, token );
	  }
	  aClass.addTraceCase(tca);
  }
  
  // Modified version of method "analyzeTraceDirective"
  // This method analyzes trace directive fragments inside a trace case
  private void analyzeTraceDirectiveFragments( TraceDirective traceDirective , UmpleClass aClass , Token traceToken , Token token )
  {
      MethodTraceEntity mte = new MethodTraceEntity();
      
      if( traceToken.is("trace_entity") )  
      {
    	  analyzeTraceItem( traceToken , traceDirective , mte );
      }
      else if( traceToken.getName().equals("entry") )
      {
    	  mte.setEntry(true);  
      }	
      else if( traceToken.getName().equals("exit") )	
      { 	
    	  mte.setExit(true);  	  
      }   	
      else if( traceToken.is("traceWhere") )
	  {
		  TraceCondition tc = analyzeTraceCondition( traceToken, "where");
		  traceDirective.addCondition(tc);
	  }
	  else if( traceToken.is("traceUntil") )
	  {
		  TraceCondition tc = analyzeTraceCondition( traceToken, "until");
		  traceDirective.addCondition(tc);
	  }
	  else if( traceToken.is("traceAfter") )
	  {
		  TraceCondition tc = analyzeTraceCondition( traceToken, "after");
		  traceDirective.addCondition(tc);
	  }	    	
      else if( traceToken.is("trace_for") )  	
      {	
    	  traceDirective.setForClause(Integer.parseInt(token.getValue("trace_for"))); 	  
      } 	     	
      else if( traceToken.is("trace_period") )   	
      {  	
    	  traceDirective.setPeriodClause(token.getValue("trace_period"));   	  
      }	     	
      else if( traceToken.is("trace_duration") )   	
      {   	
    	  traceDirective.setDuringClause(token.getValue("trace_duration"));   	  
      }	     	
      else if( traceToken.is("trace_execute") )   	
      { 	
    	  traceDirective.setExecuteClause(token.getValue("trace_execute")); 	  
      }
     
  }
  
  // Perform post token analysis on trace related elements of the Umple language
  private void postTokenTraceAnalysis()
  {
  }
  
  //****************************************
  //********* End of Trace Glue Code   *****
  //****************************************
private void analyzeLayoutToken(Token token)
  {

  }

  // There are currently no core tokens of concern in the context of an UmpleClass
  // This method is available if needed
  private void analyzeLayoutToken(Token token, UmpleClass aClass, int analysisStep)
  {
    if (analysisStep != 2)
    {
      return;
    }
    
    if (token.is("elementPosition"))
    {
      aClass.setPosition(new Coordinate(token.getIntValue("x"),token.getIntValue("y"), token.getIntValue("width"), token.getIntValue("height")));
    }
    else if (token.is("associationPosition"))
    {
      String name = token.getValue("name");
      Association assoc = model.getAssociation(name);

      if (assoc != null)
      {
        assoc.setName(name);
        for(Token position : token.getSubTokens())
        {
          if (position.is("coordinate"))
          {
            assoc.addPosition(new Coordinate(position.getIntValue("x"),position.getIntValue("y"),0,0));
          }
        }
      }
    }
  }

  // Perform post token analysis on core elements of the Umple language
  private void postTokenLayoutAnalysis()
  {
    layoutNewElements();
  }  

  // Look for any new elements and give them positions if undefined
  private void layoutNewElements()
  {
    // layout classes
    for (int i=0; i<model.numberOfUmpleClasses(); i++)
    {
      UmpleClass c = model.getUmpleClass(i);

      if (c.getPosition().getStatus() == Coordinate.Status.Defaulted)
      {
        // Do nothing
      }
      else if (c.getPosition().getStatus() == Coordinate.Status.Undefined)
      {
        c.setPosition(model.getDefaultClassPosition(i+1));
        c.getPosition().setStatus(Coordinate.Status.Defaulted);
      }
    }

    // layout interfaces
    for (int i=0; i<model.numberOfUmpleInterfaces(); i++)
    {
      UmpleInterface c = model.getUmpleInterface(i);

      if (c.getPosition().getStatus() == Coordinate.Status.Defaulted)
      {
        // Do nothing
      }
      else if (c.getPosition().getStatus() == Coordinate.Status.Undefined)
      {
        c.setPosition(model.getDefaultClassPosition(i+1));
        c.getPosition().setStatus(Coordinate.Status.Defaulted);
      }
    }

    // Layout associations
    for (int i=0; i<model.numberOfAssociations(); i++)
    {
      Association a = model.getAssociation(i);
      int numberOfPositions = a.numberOfPositions();

      if (numberOfPositions < 2)
      {
        Coordinate[] defaults = model.getDefaultAssociationPosition(a);

        a.addPosition(defaults[0]);
        a.addPosition(defaults[1]);
        a.getPosition(0).setStatus(Coordinate.Status.Defaulted);
        a.getPosition(1).setStatus(Coordinate.Status.Defaulted);
      }
    }    
  }
}