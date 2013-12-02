/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.util.*;
import java.io.*;
import cruise.umple.util.*;
import cruise.umple.compiler.exceptions.*;
import cruise.umple.parser.analysis.*;
import cruise.umple.parser.rules.*;

/**
 * @umplesource Generator.ump 272
 * @umplesource Generator_CodeUmple.ump 31
 */
// line 272 "../../../../src/Generator.ump"
// line 31 "../../../../src/Generator_CodeUmple.ump"
public class UmpleGenerator extends SuperCodeGenerator implements CodeTranslator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleGenerator()
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

  @umplesourcefile(line={339},file={"Generator_CodeUmple.ump"},javaline={47},length={7})
   private Scope getScope(){
    if(this.scopes.isEmpty()) {
      throw new UmpleCompilerException("Tried to get scope from empty stack.", null);
    }

    return scopes.peekFirst();
  }


  /**
   * Implementation of CodeTranslator. The following methods are not used, but are present 
   * so that the module can share the same superclasses as other generators/translators.
   */
  @umplesourcefile(line={353},file={"Generator_CodeUmple.ump"},javaline={56},length={3})
   public String translate(String id, Attribute attribute){
    return "";
  }

  @umplesourcefile(line={358},file={"Generator_CodeUmple.ump"},javaline={66},length={3})
   public String translate(String id, StateMachine stm){
    return "";
  }

  @umplesourcefile(line={363},file={"Generator_CodeUmple.ump"},javaline={71},length={3})
   public String translate(String keyName, State state){
    return "";
  }

  @umplesourcefile(line={373},file={"Generator_CodeUmple.ump"},javaline={76},length={3})
   public String translate(String id, Event e){
    return "";
  }

  @umplesourcefile(line={378},file={"Generator_CodeUmple.ump"},javaline={81},length={3})
   public String translate(String id, AssociationVariable aVar){
    return "";
  }

  @umplesourcefile(line={383},file={"Generator_CodeUmple.ump"},javaline={86},length={3})
   public String translate(String id, Constraint constraint){
    return "";
  }

  @umplesourcefile(line={388},file={"Generator_CodeUmple.ump"},javaline={91},length={3})
   public String translate(String id, TraceItem traceItem){
    return "";
  }

  @umplesourcefile(line={393},file={"Generator_CodeUmple.ump"},javaline={96},length={3})
   public String translate(String keyName, UmpleClass aClass0){
    return "";
  }

  @umplesourcefile(line={398},file={"Generator_CodeUmple.ump"},javaline={101},length={3})
   public String translate(String methodType){
    return "";
  }

  @umplesourcefile(line={403},file={"Generator_CodeUmple.ump"},javaline={106},length={3})
   public String translate(String name, UmpleInterface aInterface){
    return "";
  }

  @umplesourcefile(line={408},file={"Generator_CodeUmple.ump"},javaline={111},length={3})
   public String relatedTranslate(String name, AssociationVariable av){
    return "";
  }

  @umplesourcefile(line={413},file={"Generator_CodeUmple.ump"},javaline={116},length={3})
   public boolean isNullable(UmpleVariable av){
    return false;
  }

  @umplesourcefile(line={418},file={"Generator_CodeUmple.ump"},javaline={121},length={3})
   public String nameOf(String name, boolean hasMultiple){
    return "";
  }

  @umplesourcefile(line={423},file={"Generator_CodeUmple.ump"},javaline={126},length={3})
   public ILang getLanguageFor(UmpleElement aElement){
    return null;
  }

  @umplesourcefile(line={428},file={"Generator_CodeUmple.ump"},javaline={131},length={3})
   public static  String typeOf(String aType){
    return "";
  }

  @umplesourcefile(line={433},file={"Generator_CodeUmple.ump"},javaline={136},length={3})
   public void initializeLangaugeBasedVariables(){
    // do nothing
  }


  /**
   * End of CodeTranslator implementation.
   * prepare: Setup for code generation
   */
  @umplesourcefile(line={445},file={"Generator_CodeUmple.ump"},javaline={141},length={4})
   public void prepare(){
    // Create root scope (an unnamed, or 'anonymous', scope) 
    enterScope(RuleName.NIL.toInt(), false);
  }


  /**
   * Implementation of SuperCodeGenerator (CodeGenerator)
   */
  @umplesourcefile(line={454},file={"Generator_CodeUmple.ump"},javaline={152},length={18})
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


  /**
   * Purpose: Translate aElement to Umple and output to file
   * Implementation of: None. This is a local help function
   * Input: Expects a class or interface
   */
  @umplesourcefile(line={479},file={"Generator_CodeUmple.ump"},javaline={176},length={26})
   private void writeFile(UmpleElement aElement){
    if(!(aElement instanceof UmpleClass || aElement instanceof UmpleInterface)) {
      throw new UmpleCompilerException("Expected an UmpleClass or UmpleInterface.", null);
    }

    try 
    {   
      String path = StringFormatter.addPathOrAbsolute(getModel().getUmpleFile().getPath(), getOutput());
      String filename = path + File.separator + aElement.getName() + ".ump";
      File file = new File(path);
      file.mkdirs();

      BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
      this.getCode(getModel(), aElement);
      String contents = this.getScope().acceptedCode.toString();
      this.getModel().getGeneratedCode().put(aElement.getName(),contents);
      bw.write(contents);

      bw.flush();
      bw.close();
    }   
    catch (Exception e)
    {   
      throw new UmpleCompilerException("There was a problem with generating classes. " + e, e); 
    }
  }


  /**
   * Generate code for the input model and element.
   */
  @umplesourcefile(line={510},file={"Generator_CodeUmple.ump"},javaline={210},length={6})
   public void getCode(UmpleModel model, UmpleElement uElement){
    initializeParser();

    Token elementRootRuleToken = getElementRootRuleToken(model, uElement); 
    generateRuleOutput(elementRootRuleToken, model, uElement);
  }


  /**
   * Configure the parser and analyzer, plus acquire the root rule and root rule for
   * the input grammar.
   */
  @umplesourcefile(line={522},file={"Generator_CodeUmple.ump"},javaline={222},length={36})
   private void initializeParser(){
    if(parser != null) { // Parser is shared data, we need only generate once.
      return;
    }
    
    parser = new cruise.umple.parser.analysis.RuleBasedParser();

    // Populate the parser with Umple's grammar (see GrammarParsing_Code.ump)
    parser.addGrammarFile("/umple_core.grammar");
    parser.addGrammarFile("/umple_classes.grammar");
    parser.addGrammarFile("/umple_patterns.grammar");
    parser.addGrammarFile("/umple_state_machines.grammar");
    parser.addGrammarFile("/umple_traces.grammar");
    parser.addGrammarFile("/umple_constraints.grammar");  // TODO Under development
    parser.addGrammarFile("/umple_layout.grammar");
    parser.addGrammarFile("/umple_exceptions.grammar");

    parser.setupRules(true);    // Compute the Umple grammar rules

    rootRuleToken = parser.getGRootToken();
    if(rootRuleToken == null) {
      throw new UmpleCompilerException("rootRuleToken retrieved from parser is NULL.", null);
    }
  
    /*
     * The analyzer and its rules are not yet required because the rules are represented only
     * as regex, so the associated properties cannot be (easily) derived. However, the graph
     * nodes hold other useful information, for example about spacing. This could therefore
     * come into use for a whitespace-delimited language. 
     */
    analyzer = parser.getAnalyzer(); // Add this method to the RuleBasedParser
    rootRule = analyzer.getRules().get("$ROOT$");
    if(rootRule == null) {
      throw new UmpleCompilerException("Parser's rootRuleToken is null", null);
    }
  }


  /**
   * Find the best-fit root rule (defined by grammar in 'parser') for 'uElement'. If rule is not in cache, then
   * this method acts as a wapper for getRuleByName, which traverses the Rule graph (produced by Analyzer)
   * Note: UmpleElement can be an UmpleClassifier, which is currently a Class or Interface
   */
  @umplesourcefile(line={565},file={"Generator_CodeUmple.ump"},javaline={265},length={17})
   private ChoiceRule getElementRootRule(UmpleModel model, UmpleElement uElement){
    String elementRootRuleName = null;

    if(uElement instanceof UmpleClass) {
      elementRootRuleName = RuleName.CLASS_DEFINITION.toString();
    } else if(uElement instanceof UmpleInterface) {
      elementRootRuleName = RuleName.INTERFACE_DEFINITION.toString();
    } else {
      throw new UmpleCompilerException("Unrecognized element type.", null);
    }       

    if(!ruleCache.containsKey(elementRootRuleName)) {
      ruleCache.put(elementRootRuleName, getRuleByName(elementRootRuleName));
    }

    return ruleCache.get(elementRootRuleName);
  }


  /**
   * Find the best-fit root rule Token (defined by grammar in 'parser') for 'uElement'. If rule is not in cache, then
   * this method acts as a wapper for getRuleTokenByName, which traverses the RuleToken gaph (produced by RuleBasedParser)
   * Note: UmpleElement can be an UmpleClassifier, which is currently a Class or Interface
   */
  @umplesourcefile(line={589},file={"Generator_CodeUmple.ump"},javaline={290},length={17})
   private Token getElementRootRuleToken(UmpleModel model, UmpleElement uElement){
    String elementRootTokenName = null;

    if(uElement instanceof UmpleClass) {
      elementRootTokenName = RuleName.CLASS_DEFINITION.toString();
    } else if(uElement instanceof UmpleInterface) {
      elementRootTokenName = RuleName.INTERFACE_DEFINITION.toString();
    } else {
      throw new UmpleCompilerException("Unrecognized element type.", null);
    }       

    if(!tokenCache.containsKey(elementRootTokenName)) {
      tokenCache.put(elementRootTokenName, getRuleTokenByName(elementRootTokenName));
    }

    return tokenCache.get(elementRootTokenName);
  }


  /**
   * Perform breadth-first search to find rule with input name. The reason for breadth-first is that we're usually searching
   * for a token higher in the Rule graph, for example Interface, Class or Method; rather than leaf tokens.
   * - Assumptions are made about naming in grammars, such as the name of a class declaration token: concreteClassDeclaration
   */
  @umplesourcefile(line={613},file={"Generator_CodeUmple.ump"},javaline={315},length={43})
   private ChoiceRule getRuleByName(String name){
    Map<String,SearchState> visited = new HashMap<String,SearchState>();    // NULL => Unvisited, 0 => Recorded, 1 => Processed
    Queue<ChoiceRule> rules = new LinkedList<ChoiceRule>();
    ChoiceRule outputRule = null;

    if(name.equals(rootRule.getName())) { // base case
      return rootRule;
    }

    rules.add(rootRule);
    visited.put(rootRule.getName(), SearchState.RECORDED);

    SEARCH: 
    while(!rules.isEmpty()) {
      ChoiceRule curRule = rules.poll();
        if(curRule == null) {
          throw new UmpleCompilerException("Could not find rule for rule", null);
        }

      for(int i = 0; i < curRule.size(); ++i) {
        ChoiceRule subRule = curRule.get(i);
        if(subRule == null) continue;

        if(!visited.containsKey(subRule.getName())) {
          if(name.equals(subRule.getName())) { 
            outputRule = subRule;
            break SEARCH; 
          }
 
          rules.add(subRule);
          visited.put(subRule.getName(), SearchState.RECORDED);
        }
      } 

      visited.put(rootRule.getName(), SearchState.PROCESSED);
    } 

    if(outputRule == null) {
      throw new UmpleCompilerException("Could not find rule for rule, " + name, null);
    }

    return outputRule;
  }


  /**
   * Perform breadth-first search to find token with input name. The reason for breadth-first is that we're usually searching
   * for a token higher in the RuleToken graph, for example Interface, Class or Method; rather than leaf tokens.
   * - Assumptions are made about naming in grammars, such as the name of a class declaration token: concreteClassDeclaration
   */
  @umplesourcefile(line={663},file={"Generator_CodeUmple.ump"},javaline={366},length={38})
   private Token getRuleTokenByName(String name){
    Map<Integer,SearchState> visited = new HashMap<Integer,SearchState>();    // NULL => Unvisited, 0 => Recorded, 1 => Processed
    Queue<Token> tokens = new LinkedList<Token>();
    Token outputToken = null;

    if(name.equals(rootRuleToken.getValue())) { // base case
      return rootRuleToken;
    }

    tokens.add(rootRuleToken);
    visited.put(rootRuleToken.hashCode(), SearchState.RECORDED);

    SEARCH: 
    while(!tokens.isEmpty()) {
      Token curToken = tokens.poll();
      for(Token subToken : curToken.getSubTokens()) {
        if(subToken == null) continue;

        if(!visited.containsKey(subToken.hashCode())) {
          if(name.equals(subToken.getValue()) && RuleTokenType.RULE.equals(curToken)) { // Also ensure this is a rule, and not just a reference to a rule
            outputToken = curToken; // this is actually the parent of the token we are looking for. This is just how the rule graph is formatted.
            break SEARCH; 
          }
 
          tokens.add(subToken);
          visited.put(subToken.hashCode(), SearchState.RECORDED);
        }
      } 

      visited.put(rootRuleToken.hashCode(), SearchState.PROCESSED);
    } 

    if(outputToken == null) {
      throw new UmpleCompilerException("Could not find RuleToken with name, " + name, null);
    }

    return outputToken;
  }


  /**
   * Detects potential cycle in the Scope stack if 'id' is added.
   */
  @umplesourcefile(line={706},file={"Generator_CodeUmple.ump"},javaline={412},length={8})
   private boolean isRecursing(int id){
    Iterator<Scope> it = scopes.iterator();
    while(it.hasNext()) {
      if(it.next().id == id) return true;
    }

    return false;
  }


  /**
   * Wrapper for enterScope below; handles different entries into a new scope depending on whether a 
   * rule is anonymous or not.
   */
  @umplesourcefile(line={720},file={"Generator_CodeUmple.ump"},javaline={426},length={14})
   private boolean enterScope(Token ruleNameToken, boolean isOptional){
    boolean recursing = false;
    switch(RuleTokenType.fromToken(ruleNameToken)) {
      case ANONYMOUS_RULE:
        recursing = enterScope((new Random()).nextInt(), this.getScope().isOptional); // select parent's isOptional property
        break;

      default:
        recursing = enterScope(ruleNameToken.getValue().hashCode(), isOptional);
        break;
    } 

    return recursing;
  }


  /**
   * Push new scope to Scope Stack
   */
  @umplesourcefile(line={739},file={"Generator_CodeUmple.ump"},javaline={447},length={6})
   private boolean enterScope(int id, boolean isOptional){
    if(isRecursing(id)) return false; // Don't create scope if in cycle

    scopes.addFirst(new Scope(id, isOptional));
    return true;
  }


  /**
   * Exit current scope and combine exiting accepted state with new top-level state in the Scope stack.
   */
  @umplesourcefile(line={750},file={"Generator_CodeUmple.ump"},javaline={459},length={18})
   private double exitScope(){
    handleMutexClause(); // Exiting scope is implicit mutex clause, so we must try to transfer the candidate state to the accepted state

    Scope poppedScope = scopes.removeFirst();
    Scope topScope = scopes.peekFirst();
    if(topScope == null) {
      // A root scope is created when the generator is initialized, and should never be exited.
      throw new UmpleCompilerException("Tried to exit from root scope.", null);
    }

    // Restore scope
    if(poppedScope.acceptedRulesSatisfied > 0 || poppedScope.isOptional == false) {
      topScope.candidateCode.append(poppedScope.acceptedCode.toString());
      topScope.candidateRulesSatisfied += poppedScope.acceptedRulesSatisfied;
    } 

    return poppedScope.acceptedRulesSatisfied;
  }


  /**
   * Wrapper for generateRuleOutput below; this version handles rule modifiers ("RuleModifer" RuleToken).
   * Note: Each RuleToken has an associated RuleName SubToken, generated by the RuleBasedParser. The 
   * exception to this is an Anonymous Rule.
   */
  @umplesourcefile(line={775},file={"Generator_CodeUmple.ump"},javaline={483},length={28})
   private void generateRuleOutput(Token elementRootRuleToken, UmpleModel model, Object uElement){
    Token ruleNameToken = elementRootRuleToken;
    RuleModifier ruleModifier = RuleModifier.NIL;

    for(Token subToken : elementRootRuleToken.getSubTokens()) { // Should have 2 subtokens
      if(RuleTokenType.fromToken(subToken) == RuleTokenType.RULE_NAME) {
        ruleNameToken = subToken;
      } else if(RuleModifier.fromToken(subToken) != RuleModifier.NIL) {
        ruleModifier = RuleModifier.fromToken(subToken);
      }
    }

    switch(ruleModifier) {
      case ZERO_TO_MANY:
        while(generateRuleOutput(ruleNameToken,ruleModifier,model,uElement) > 0) {};
        break; 

      case OPTIONAL:
        generateRuleOutput(ruleNameToken,ruleModifier,model,uElement);
        break;

      default:
        generateRuleOutput(ruleNameToken,ruleModifier,model,uElement);
        break;
    }

    return;
  }


  /**
   * Generate output given a "RuleName" RuleToken (generated by RuleBasedParser).
   * A new scope is created for the rule, but only if the scope isn't already on the Queue stack, in 
   * which case there is a cycle and we simply backtrack.
   */
  @umplesourcefile(line={810},file={"Generator_CodeUmple.ump"},javaline={519},length={51})
   private double generateRuleOutput(Token ruleNameToken, RuleModifier ruleModifier, UmpleModel model, Object uElement){
    if(enterScope(ruleNameToken, (ruleModifier == RuleModifier.OPTIONAL)) == false) { // false => we're in a cycle; exit to avoid reprocessing
      return 0;
    }

    if(RuleTokenType.fromToken(ruleNameToken) == RuleTokenType.ANONYMOUS_RULE) {
        for(Token subToken : ruleNameToken.getSubTokens()) {
          generateRuleTokenOutput(subToken, model, uElement);
        }
        return exitScope();    
    } 

    switch(RuleName.fromString(ruleNameToken.getValue())) {
      case CONCRETE_METHOD_DECLARATION:
          if(curMethod < ((UmpleClass)uElement).getMethods().size()) {
            generateRuleTokenOutput(getRuleTokenByName(ruleNameToken.getValue()), model, ((UmpleClass)uElement).getMethods().get(curMethod));
            curMethod += 1;
          } else {
            curMethod = 0;
          } 
        break;

      case PARAMETER:
        if(curParam < ((Method)uElement).getMethodParameters().size()) {
          generateRuleTokenOutput(getRuleTokenByName(ruleNameToken.getValue()), model, ((Method)uElement).getMethodParameters().get(curParam)); 
          curParam++;
        } else {
          curParam = 0;
        }
        break;

      case PARAMETERS:
      case CLASS_CONTENT:
      case TYPED_NAME:
      case PARAMETER_LIST:
      case EXTRA_CODE:
      case METHOD_NAME:
      case METHOD_DECLARATOR:
      case METHOD_BODY:
      case ABSTRACT:
      case CLASS_DEFINITION:
        generateRuleTokenOutput(getRuleTokenByName(ruleNameToken.getValue()), model, uElement);
        break;

      default:
        // Unimplemented; Ignore
        break;
    }

    return exitScope(); // exit scope and return the # of rules satisfied by the scope (acceptedRulesSatisfied)
  }


  /**
   * Selects a best fit output between two mutually exclusive clauses
   */
  @umplesourcefile(line={866},file={"Generator_CodeUmple.ump"},javaline={578},length={13})
   private void handleMutexClause(){
    Scope scope = this.getScope();

    if(scope.candidateRulesSatisfied > scope.acceptedRulesSatisfied) {
      // Current scope's candidate state replaces the scope's accepted state if  
      scope.acceptedRulesSatisfied = scope.candidateRulesSatisfied;
      scope.acceptedCode = scope.candidateCode; 
    }

    // Reset state for next iteration
    scope.candidateRulesSatisfied = 0;
    scope.candidateCode = new StringBuilder();
  }


  /**
   * Generate output for Umple Element's using Rule Tokens that are generated by a RuleBasedParser.
   */
  @umplesourcefile(line={884},file={"Generator_CodeUmple.ump"},javaline={597},length={49})
   private void generateRuleTokenOutput(Token elementRootRuleToken, UmpleModel model, Object uContainer){
    RuleTokenType ruleTokenType = RuleTokenType.fromToken(elementRootRuleToken);
    StringBuilder buffer = this.getScope().candidateCode;

    switch(ruleTokenType) {
      case OPEN_CURL:
        buffer.append(pad(elementRootRuleToken.getValue(), ruleTokenType));
        break;

      case CLOSE_CURL:
        buffer.append(pad(elementRootRuleToken.getValue(), ruleTokenType));
        break;
        
      case TERMINAL:
        buffer.append(translateTerminal(elementRootRuleToken.getSubTokens().get(0).getValue()));
        buffer.append(Whitespace.SPACE.toString());
        break;

      case TOKEN_NAME:
        buffer.append(getElementProperty(elementRootRuleToken.getValue(), elementRootRuleToken, uContainer));
        break;

      case ANONYMOUS_RULE:
      case OTHER_RULE:
        generateRuleOutput(elementRootRuleToken, model, uContainer); // These are only references; RuleToken be fetched from the rule graph
        break;

      case SEPARATOR:
        handleMutexClause();
        break;

      case LBRACKET:
      case RBRACKET:
      case MODIFIER:
      case RULE:
      case BRACED:
      case TOKEN:
      case DEFINITION:
      case PREMODIFIER:
      case VALUE:
      case VALUE_COLON:
      case RULE_NAME:
      default:
        for(Token subToken : elementRootRuleToken.getSubTokens()) {
          generateRuleTokenOutput(subToken, model, uContainer);
        } 
        break;
    }
  }


  /**
   * Extracts some property from the input UmpleElement
   * Delegates element-specific requiests to handler for uElement 
   * Note: These 'property' methods can be reduced/eliminated if we just hashed properties
   * during the parse stage, rather than creating getters/setters for every property.
   */
  @umplesourcefile(line={941},file={"Generator_CodeUmple.ump"},javaline={652},length={24})
   private String getElementProperty(String property, Token elementRootRuleToken, Object uContainer){
    String elementProperty = null;

    if(property == null || property.length() == 0) {
      return elementProperty;
    }

    if(uContainer instanceof UmpleClass) {
      elementProperty = getClassProperty(property, elementRootRuleToken, (UmpleClass)uContainer);
    } else if(uContainer instanceof UmpleInterface) {
      elementProperty = getInterfaceProperty(property, elementRootRuleToken, (UmpleInterface)uContainer);
    } else if(uContainer instanceof Method) {
      elementProperty = getMethodProperty(property, elementRootRuleToken, (Method)uContainer);
    } else if(uContainer instanceof MethodParameter) {
      elementProperty = getMethodParameterProperty(property, elementRootRuleToken, (MethodParameter)uContainer);
    } 

    if(!(elementProperty == null || elementProperty.length() == 0)) {
      // A property was successfully retrieved, and hence the current rule has been satisfied.
      this.getScope().candidateRulesSatisfied += 1;
    } 

    return elementProperty;
  }

  @umplesourcefile(line={967},file={"Generator_CodeUmple.ump"},javaline={685},length={21})
   private String getClassProperty(String property, Token elementRootRuleToken, UmpleClass uClass){
    StringBuilder buffer = new StringBuilder();
    
    switch(RuleName.fromString(property)) {
      case NAME:
        buffer.append(pad(uClass.getName(), RuleName.NAME, uClass));    
        break;

      case ABSTRACT:
        if(uClass.getIsAbstract()) {
          buffer.append(elementRootRuleToken.getValue()); // Abstract keyword
        }
        break; 

      default:
        // Property unimplemented; ignore.
        break;
    }

    return buffer.toString();
  }

  @umplesourcefile(line={990},file={"Generator_CodeUmple.ump"},javaline={708},length={4})
   private String getInterfaceProperty(String property, Token elementRootRuleToken, UmpleInterface uInterface){
    StringBuilder buffer = new StringBuilder();
    return buffer.toString();
  }

  @umplesourcefile(line={996},file={"Generator_CodeUmple.ump"},javaline={714},length={33})
   private String getMethodProperty(String property, Token elementRootRuleToken, Method uMethod){
    StringBuilder buffer = new StringBuilder();

    switch(RuleName.fromString(property)) {
      case METHOD_NAME:
        buffer.append(pad(uMethod.getName(), RuleName.NAME, uMethod));    
        break;

      case ABSTRACT:
        if(uMethod.getIsAbstract()) {
          buffer.append(pad(elementRootRuleToken.getValue(), RuleName.ABSTRACT, uMethod));
        }
        break; 

      case MODIFIER:
        buffer.append(pad(uMethod.getModifier(), RuleName.MODIFIER, uMethod));
        break;

      case TYPE:
        buffer.append(pad(uMethod.getType(), RuleName.TYPE, uMethod));
        break;

      case CODE:
        buffer.append(pad(uMethod.getMethodBody().getExtraCode(), RuleName.CODE, uMethod)); 
        break;

      default:
        // Property unimplemented; ignore.
        break;
    }

    return buffer.toString();
  }

  @umplesourcefile(line={1031},file={"Generator_CodeUmple.ump"},javaline={749},length={19})
   private String getMethodParameterProperty(String property, Token elementRootRuleToken, MethodParameter uMethodParameter){
    StringBuilder buffer = new StringBuilder();

    switch(RuleName.fromString(property)) {
      case TYPE:
        buffer.append(pad(uMethodParameter.getType(), RuleName.TYPE, uMethodParameter));
        break;

      case NAME:
        buffer.append(pad(uMethodParameter.getName(), RuleName.NAME, uMethodParameter));
        break;

      default:
        // Property unimplemented; ignore.
        break;
    }

    return buffer.toString();
  }


  /**
   * Pad token value with whitespace
   * - Note: This is implementation allows whitespace to be easily configurable to address different coding practices/languages.
   * - Note: Protected so that space-delimited languages can override.
   */
  @umplesourcefile(line={1057},file={"Generator_CodeUmple.ump"},javaline={770},length={37})
   protected String pad(String input, RuleName ruleName, Object uContainer){
    StringBuilder buffer = new StringBuilder();
    String lpad = "", rpad = "";  

    switch(ruleName) {
      case MODIFIER:
        for(int i = 0; i < this.indent; ++i) buffer.append(Whitespace.TAB.toString());  // Add indents for current frame of reference
        lpad = Whitespace.NIL.toString();
        rpad = Whitespace.SPACE.toString();
        break;
    
      case CODE:
        for(int i = 0; i < this.indent; ++i) buffer.append(Whitespace.TAB.toString());  // Add indents for current frame of reference

        // Remove auto-indent from parse stage
        input = input.replaceAll(Whitespace.NL.toString() + Whitespace.TAB.toString(), Whitespace.NL.toString());

        // Add indentation for current frame of reference
        input = input.replaceAll(Whitespace.NL.toString(), Whitespace.NL.toString() + buffer.toString());
        rpad = Whitespace.NL.toString();
        break;

      case NAME:
        if(uContainer instanceof MethodParameter) {
          //rpad = Terminal.COMMA.getTranslation();
        }
      default:
        lpad += Whitespace.NIL.toString();
        rpad += Whitespace.SPACE.toString();
    }

    buffer.append(lpad);
    buffer.append(input);
    buffer.append(rpad);

    return buffer.toString();
  }


  /**
   * Padding for token types, as generated by the RuleBasedProcessor
   * Note: Protected so that space-delimited languages can override.
   */
  @umplesourcefile(line={1100},file={"Generator_CodeUmple.ump"},javaline={815},length={29})
   protected String pad(String input, RuleTokenType ruleTokenType){
    StringBuilder buffer = new StringBuilder();
    String lpad, rpad; 

    switch(ruleTokenType) {
      case CLOSE_CURL:
        this.indent--;
        lpad = Whitespace.NIL.toString();
        for(int i = 0; i < this.indent; ++i) lpad += Whitespace.TAB.toString();  // Add indents for current frame of reference
        rpad = Whitespace.NL.toString() + Whitespace.NL.toString();
        break;

      case OPEN_CURL:
        lpad = Whitespace.NIL.toString();
        rpad = Whitespace.NL.toString();
        this.indent++;
        break;
        
      default:
        lpad = Whitespace.NIL.toString();
        rpad = Whitespace.SPACE.toString();
    }

    buffer.append(lpad);
    buffer.append(input);
    buffer.append(rpad);

    return buffer.toString();
  }


  /**
   * Translates terminals using the TokenType catalogue
   */
  @umplesourcefile(line={1134},file={"Generator_CodeUmple.ump"},javaline={851},length={4})
   private String translateTerminal(String terminal){
    TerminalType translation = TerminalType.fromString(terminal);
    return translation != TerminalType.NIL ? translation.getTranslation() : terminal;
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={36},file={"Generator_CodeUmple.ump"},javaline={863},length={284})
  @umplesourcefile(line={37},file={"Generator_CodeUmple.ump"},javaline={864},length={46})
  private static Map<String,ChoiceRule> ruleCache = new HashMap<String,ChoiceRule>() ;

//  @umplesourcefile(line={37},file={"Generator_CodeUmple.ump"},javaline={867},length={281})
  @umplesourcefile(line={38},file={"Generator_CodeUmple.ump"},javaline={868},length={43})
  private static Map<String,Token> tokenCache = new HashMap<String,Token>() ;

//  @umplesourcefile(line={38},file={"Generator_CodeUmple.ump"},javaline={871},length={278})
  private static RuleBasedParser parser = null ;

//  @umplesourcefile(line={39},file={"Generator_CodeUmple.ump"},javaline={874},length={275})
  private static GrammarAnalyzer analyzer = null ;

//  @umplesourcefile(line={40},file={"Generator_CodeUmple.ump"},javaline={877},length={272})
  private static Token rootRuleToken = null ;

//  @umplesourcefile(line={41},file={"Generator_CodeUmple.ump"},javaline={880},length={269})
  private static ChoiceRule rootRule = null ;

//  @umplesourcefile(line={46},file={"Generator_CodeUmple.ump"},javaline={883},length={266})
  private enum Whitespace 
  {
    NIL(0, ""),
    SPACE(1, " "),
    TAB(2, "    "), // use 4 spaces instead of a TAB (\t)
    NL(3, "\n"),     
    CRLF(4, "\r\n"), 
    LFCR(5, "\n\r"); 

    private int id;
    private String value;
  
  @umplesourcefile(line={59},file={"Generator_CodeUmple.ump"},javaline={896},length={5})
    private Whitespace(int id, String value)
    {
      this.id = id;
      this.value = value;
    }

  @umplesourcefile(line={65},file={"Generator_CodeUmple.ump"},javaline={903},length={4})
    public int toInt()
    {
      return this.id;
    }

  @umplesourcefile(line={70},file={"Generator_CodeUmple.ump"},javaline={909},length={4})
    public String toString()
    {
      return this.value;
    }
  }

//  @umplesourcefile(line={77},file={"Generator_CodeUmple.ump"},javaline={916},length={236})
  private enum TerminalType 
  {
    NIL(0, "", ""),
    LPAREN(1, "OPEN_ROUND_BRACKET", "("),
    RPAREN(2, "CLOSE_ROUND_BRACKET", ")"),
    COMMA(3, "COMMA", ",");

    private int id;
    private String value;
    private String translation;
  @umplesourcefile(line={88},file={"Generator_CodeUmple.ump"},javaline={927},length={11})
    private static final Map<String,TerminalType> strDict = new HashMap<String,TerminalType>();

    /*
     * Primarily used for dynamic typecasting
     */
    static 
    {   
        for(TerminalType t : EnumSet.allOf(TerminalType.class)) { 
            strDict.put(t.toString(), t);
        }   
    } 

  @umplesourcefile(line={100},file={"Generator_CodeUmple.ump"},javaline={940},length={4})
    public static TerminalType fromString(String t)
    {
      return strDict.containsKey(t) ? strDict.get(t) : NIL; 
    }
  
  @umplesourcefile(line={105},file={"Generator_CodeUmple.ump"},javaline={946},length={6})
    private TerminalType(int id, String value, String translation)
    {
      this.id = id;
      this.value = value;
      this.translation = translation;
    }

  @umplesourcefile(line={112},file={"Generator_CodeUmple.ump"},javaline={954},length={4})
    public int toInt()
    {
      return this.id;
    }

  @umplesourcefile(line={117},file={"Generator_CodeUmple.ump"},javaline={960},length={4})
    public String toString()
    {
      return this.value;
    } 

  @umplesourcefile(line={122},file={"Generator_CodeUmple.ump"},javaline={966},length={4})
    public String getTranslation()
    {
      return this.translation;
    }
  }

//  @umplesourcefile(line={129},file={"Generator_CodeUmple.ump"},javaline={973},length={185})
  private enum RuleTokenType 
  {
    NIL(0, ""),
    LBRACKET(2, "["),
    RBRACKET(3, "]"),
    ANONYMOUS_RULE(4, "anonymousRule"),
    BRACED(5, "braced"),
    CLOSE_CURL(6, "closecurl"),
    DEFINITION(7, "definition"),
    MODIFIER(8, "modifier"),
    OPEN_CURL(9, "opencurl"),
    OTHER_RULE(10, "otherrule"),
    PREMODIFIER(11, "premodifier"),
    RULE(12, "rule"),
    RULE_NAME(13, "rulename"),
    SEPARATOR(14, "separator"),
    TERMINAL(15, "terminal"),
    TOKEN(16, "token"),
    TOKEN_NAME(17, "tokenname"),
    VALUE(18, "value"),
    VALUE_COLON(19, "valuecolon");

    private int id;
    private String value;
  @umplesourcefile(line={154},file={"Generator_CodeUmple.ump"},javaline={998},length={11})
    private static final Map<String,RuleTokenType> strDict = new HashMap<String,RuleTokenType>();

    /*
     * Primarily used for dynamic typecasting
     */
    static 
    {   
        for(RuleTokenType t : EnumSet.allOf(RuleTokenType.class)) { 
            strDict.put(t.toString(), t);
        }   
    } 

  @umplesourcefile(line={166},file={"Generator_CodeUmple.ump"},javaline={1011},length={4})
    public static RuleTokenType fromToken(Token t)
    {
      return strDict.containsKey(t.getName()) ? strDict.get(t.getName()) : NIL; 
    }
  
  @umplesourcefile(line={171},file={"Generator_CodeUmple.ump"},javaline={1017},length={5})
    private RuleTokenType(int id, String value)
    {
      this.id = id;
      this.value = value;
    }

  @umplesourcefile(line={177},file={"Generator_CodeUmple.ump"},javaline={1024},length={4})
    public int toInt()
    {
      return this.id;
    }

  @umplesourcefile(line={182},file={"Generator_CodeUmple.ump"},javaline={1030},length={4})
    public String toString()
    {
      return this.value;
    } 

  @umplesourcefile(line={187},file={"Generator_CodeUmple.ump"},javaline={1036},length={4})
    public boolean equals(Token t)
    {
      return this.value.equals(t.getName());
    }
  }

//  @umplesourcefile(line={194},file={"Generator_CodeUmple.ump"},javaline={1043},length={121})
  private enum RuleModifier 
  {
    NIL(0, ""),
    ZERO_TO_MANY(1,"*"),
    OPTIONAL(2,"?");

    private int id;
    private String value;
  @umplesourcefile(line={203},file={"Generator_CodeUmple.ump"},javaline={1052},length={11})
    private static final Map<String,RuleModifier> strDict = new HashMap<String,RuleModifier>();

    /*
     * Primarily used for dynamic typecasting
     */
    static 
    {   
        for(RuleModifier t : EnumSet.allOf(RuleModifier.class)) { 
            strDict.put(t.toString(), t);
        }   
    } 

  @umplesourcefile(line={215},file={"Generator_CodeUmple.ump"},javaline={1065},length={4})
    public static RuleModifier fromToken(Token t)
    {
      return strDict.containsKey(t.getValue()) ? strDict.get(t.getValue()) : NIL; 
    }
  
  @umplesourcefile(line={220},file={"Generator_CodeUmple.ump"},javaline={1071},length={5})
    private RuleModifier(int id, String value)
    {
      this.id = id;
      this.value = value;
    }

  @umplesourcefile(line={226},file={"Generator_CodeUmple.ump"},javaline={1078},length={4})
    public int toInt()
    {
      return this.id;
    }

  @umplesourcefile(line={231},file={"Generator_CodeUmple.ump"},javaline={1084},length={4})
    public String toString()
    {
      return this.value;
    }
  }

//  @umplesourcefile(line={243},file={"Generator_CodeUmple.ump"},javaline={1091},length={78})
  private enum RuleName 
  {
    NIL(0, ""),
    ANONYMOUS(1, "anonymousRule"), // Implicit definition; Not defined in the grammar
    NAME(100,"name"),
    ABSTRACT(101,"abstract"),
    CLASS_DEFINITION(200,"classDefinition"),
    CLASS_CONTENT(201, "classContent"),
    INTERFACE_DEFINITION(300,"interfaceDefinition"),
    CONCRETE_METHOD_DECLARATION(400, "concreteMethodDeclaration"),
    METHOD_DECLARATOR(401, "methodDeclarator"),
    METHOD_NAME(404, "methodName"),
    MODIFIER(405, "modifier"),
    PARAMETER(545, "parameter"),
    PARAMETER_LIST(546, "parameterList"),
    PARAMETERS(547, "parameters"),
    TYPED_NAME(576, "typedName"),
    TYPE(577, "type"),
    EXTRA_CODE(578, "extraCode"),
    CODE(579, "code"),
    METHOD_BODY(580, "methodBody");

    private int id;
    private String value;
  @umplesourcefile(line={268},file={"Generator_CodeUmple.ump"},javaline={1116},length={11})
    private static final Map<String,RuleName> strDict = new HashMap<String,RuleName>();

    /*
     * Primarily used for dynamic typecasting
     */
    static 
    {   
        for(RuleName t : EnumSet.allOf(RuleName.class)) { 
            strDict.put(t.toString(), t);
        }   
    } 
  
  @umplesourcefile(line={280},file={"Generator_CodeUmple.ump"},javaline={1129},length={5})
    private RuleName(int id, String value)
    {
      this.id = id;
      this.value = value;
    }

  @umplesourcefile(line={286},file={"Generator_CodeUmple.ump"},javaline={1136},length={4})
    public int toInt()
    {
      return this.id;
    }

  @umplesourcefile(line={291},file={"Generator_CodeUmple.ump"},javaline={1142},length={4})
    public String toString()
    {
      return this.value; 
    } 

  @umplesourcefile(line={296},file={"Generator_CodeUmple.ump"},javaline={1148},length={4})
    public boolean equals(String testVal)
    {
      return this.value.equals(testVal);
    }

  @umplesourcefile(line={301},file={"Generator_CodeUmple.ump"},javaline={1154},length={4})
    public static RuleName fromString(String s)
    {
      return strDict.containsKey(s) ? strDict.get(s) : NIL; 
    }
  }

//  @umplesourcefile(line={308},file={"Generator_CodeUmple.ump"},javaline={1161},length={14})
  private enum SearchState {RECORDED, PROCESSED};

//  @umplesourcefile(line={331},file={"Generator_CodeUmple.ump"},javaline={1164},length={11})
  @umplesourcefile(line={332},file={"Generator_CodeUmple.ump"},javaline={1165},length={10})
  private Deque<Scope> scopes = new ArrayDeque<Scope>() ;

//  @umplesourcefile(line={332},file={"Generator_CodeUmple.ump"},javaline={1168},length={8})
  private int indent = 0 ;

//  @umplesourcefile(line={333},file={"Generator_CodeUmple.ump"},javaline={1171},length={5})
  private int curMethod = 0 ;

//  @umplesourcefile(line={334},file={"Generator_CodeUmple.ump"},javaline={1174},length={2})
  private int curParam = 0 ;

  
}