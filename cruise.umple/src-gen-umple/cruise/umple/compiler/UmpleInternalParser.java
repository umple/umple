/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.io.*;
import cruise.umple.util.*;
import cruise.umple.parser.analysis.*;
import java.util.regex.*;
import java.util.*;

/**
 * Copyright: All contributers to the Umple Project
 * 
 * This file is made available subject to the open source license found at:
 * http://umple.org/license
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
 * @umplesource UmpleInternalParser.ump 22
 * @umplesource UmpleInternalParser_Code.ump 32
 * @umplesource UmpleInternalParser_CodeCore.ump 16
 * @umplesource UmpleInternalParser_CodeClass.ump 16
 * @umplesource UmpleInternalParser_CodeConstraints.ump 16
 * @umplesource UmpleInternalParser_CodeStateMachine.ump 16
 * @umplesource UmpleInternalParser_CodeTrace.ump 16
 * @umplesource UmpleInternalParser_CodeLayout.ump 16
 */
// line 22 "../../../../src/UmpleInternalParser.ump"
// line 32 "../../../../src/UmpleInternalParser_Code.ump"
// line 16 "../../../../src/UmpleInternalParser_CodeCore.ump"
// line 16 "../../../../src/UmpleInternalParser_CodeClass.ump"
// line 16 "../../../../src/UmpleInternalParser_CodeConstraints.ump"
// line 16 "../../../../src/UmpleInternalParser_CodeStateMachine.ump"
// line 16 "../../../../src/UmpleInternalParser_CodeTrace.ump"
// line 16 "../../../../src/UmpleInternalParser_CodeLayout.ump"
public class UmpleInternalParser extends Parser implements UmpleParser
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UmpleInternalParser Attributes
  private String currentPackageName;
  private boolean packageNameUsed;
  private boolean outputUmpleSource;
  private UmpleModel model;
  private RuleBasedParser parser;
  private List<Integer> allowedMessages;
  private List<Integer> ignoredMessages;
  private List<Integer> disallowedMessages;
  private List<Integer> expectedMessages;
  private List<String> unparsedUmpleFiles;
  private List<String> parsedUmpleFiles;
  private boolean shouldProcessAgain;
  private boolean shouldProcessClassAgain;
  private List<AssociationVariable> unlinkedAssociationVariables;
  private List<Association> unlinkedAssociations;
  private Map<Position,String> positionToClassNameReference;
  private Map<UmpleClassifier,List<String>> unlinkedExtends;
  private Map<UmpleClassifier,List<Token>> unlinkedExtendsTokens;
  private Map<UmpleClassifier,List<Token>> unlinkedExtendsTokensInterface;
  private Map<UmpleClassifier,List<String>> unlinkedInterfaceExtends;

  /**
   * List of comments populated by the parser to be added to the next class, attribute, association, method, etc.
   */
  private List<Comment> lastComments;

  /**
   * last attribute made.
   */
  private Attribute lastattr;

  /**
   * last association made.
   */
  private AssociationVariable lastassoc;
  private Position lastassocPosition;
  private boolean mustWarn;
  private StateMachine placeholderStateMachine;
  private Map<String,Token> stateMachineNameToToken;
  private Map<State,List<Token>> possiblyUnknownStates;
  private int traceFlagId;

  //UmpleInternalParser State Machines
  enum Strictness { none, modelOnly, noExtraCode }
  private Strictness strictness;

  //UmpleInternalParser Associations
  private List<ErrorType> messagesToExpect;
  private List<ErrorType> warningsToIgnore;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  @umplesourcefile(line={41},file={"UmpleInternalParser_Code.ump"},javaline={145},length={1})
  public UmpleInternalParser(String aName, UmpleModel aModel, RuleBasedParser aParser)
  {
    super(aName);
    currentPackageName = "";
    packageNameUsed = true;
    outputUmpleSource = false;
    model = aModel;
    parser = aParser;
    allowedMessages = new ArrayList<Integer>();
    ignoredMessages = new ArrayList<Integer>();
    disallowedMessages = new ArrayList<Integer>();
    expectedMessages = new ArrayList<Integer>();
    unparsedUmpleFiles = new ArrayList<String>();
    parsedUmpleFiles = new ArrayList<String>();
    shouldProcessAgain = false;
    shouldProcessClassAgain = false;
    unlinkedAssociationVariables = new ArrayList<AssociationVariable>();
    unlinkedAssociations = new ArrayList<Association>();
    positionToClassNameReference = new HashMap<Position, String>();
    unlinkedExtends = new HashMap<UmpleClassifier,List<String>>();
    unlinkedExtendsTokens = new HashMap<UmpleClassifier,List<Token>>();
    unlinkedExtendsTokensInterface = new HashMap <UmpleClassifier, List<Token>>();
    unlinkedInterfaceExtends = new HashMap<UmpleClassifier,List<String>>();
    lastComments = new ArrayList<Comment>();
    lastattr = null;
    lastassoc = null;
    lastassocPosition = null;
    mustWarn = true;
    placeholderStateMachine = null;
    stateMachineNameToToken = new HashMap<String, Token>();
    possiblyUnknownStates = new HashMap<State,List<Token>>();
    traceFlagId = 0;
    messagesToExpect = new ArrayList<ErrorType>();
    warningsToIgnore = new ArrayList<ErrorType>();
    setStrictness(Strictness.none);
    // line 41 "../../../../src/UmpleInternalParser_Code.ump"
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

  public boolean setPackageNameUsed(boolean aPackageNameUsed)
  {
    boolean wasSet = false;
    packageNameUsed = aPackageNameUsed;
    wasSet = true;
    return wasSet;
  }

  public boolean setOutputUmpleSource(boolean aOutputUmpleSource)
  {
    boolean wasSet = false;
    outputUmpleSource = aOutputUmpleSource;
    wasSet = true;
    return wasSet;
  }

  @umplesourcefile(line={75},file={"UmpleInternalParser.ump"},javaline={183},length={1})
  public boolean setModel(UmpleModel aModel)
  {
    boolean wasSet = false;
    model = aModel;
    wasSet = true;
    // line 75 "../../../../src/UmpleInternalParser.ump"
    if(model != null && model.getUmpleFile() != null) { super.setFilename(model.getUmpleFile().getFileName()); super.setRootToken(reset());}
    return wasSet;
  }

  public boolean setParser(RuleBasedParser aParser)
  {
    boolean wasSet = false;
    parser = aParser;
    wasSet = true;
    return wasSet;
  }

  public boolean addAllowedMessage(Integer aAllowedMessage)
  {
    boolean wasAdded = false;
    wasAdded = allowedMessages.add(aAllowedMessage);
    return wasAdded;
  }

  public boolean removeAllowedMessage(Integer aAllowedMessage)
  {
    boolean wasRemoved = false;
    wasRemoved = allowedMessages.remove(aAllowedMessage);
    return wasRemoved;
  }

  public boolean addIgnoredMessage(Integer aIgnoredMessage)
  {
    boolean wasAdded = false;
    wasAdded = ignoredMessages.add(aIgnoredMessage);
    return wasAdded;
  }

  public boolean removeIgnoredMessage(Integer aIgnoredMessage)
  {
    boolean wasRemoved = false;
    wasRemoved = ignoredMessages.remove(aIgnoredMessage);
    return wasRemoved;
  }

  public boolean addDisallowedMessage(Integer aDisallowedMessage)
  {
    boolean wasAdded = false;
    wasAdded = disallowedMessages.add(aDisallowedMessage);
    return wasAdded;
  }

  public boolean removeDisallowedMessage(Integer aDisallowedMessage)
  {
    boolean wasRemoved = false;
    wasRemoved = disallowedMessages.remove(aDisallowedMessage);
    return wasRemoved;
  }

  public boolean addExpectedMessage(Integer aExpectedMessage)
  {
    boolean wasAdded = false;
    wasAdded = expectedMessages.add(aExpectedMessage);
    return wasAdded;
  }

  public boolean removeExpectedMessage(Integer aExpectedMessage)
  {
    boolean wasRemoved = false;
    wasRemoved = expectedMessages.remove(aExpectedMessage);
    return wasRemoved;
  }

  public boolean setLastassocPosition(Position aLastassocPosition)
  {
    boolean wasSet = false;
    lastassocPosition = aLastassocPosition;
    wasSet = true;
    return wasSet;
  }

  public boolean setMustWarn(boolean aMustWarn)
  {
    boolean wasSet = false;
    mustWarn = aMustWarn;
    wasSet = true;
    return wasSet;
  }

  public boolean setTraceFlagId(int aTraceFlagId)
  {
    boolean wasSet = false;
    traceFlagId = aTraceFlagId;
    wasSet = true;
    return wasSet;
  }

  public String getCurrentPackageName()
  {
    return currentPackageName;
  }

  public boolean getPackageNameUsed()
  {
    return packageNameUsed;
  }

  public boolean getOutputUmpleSource()
  {
    return outputUmpleSource;
  }

  /**
   * The Umple meta model which will be populated based on what was parsed.
   */
  public UmpleModel getModel()
  {
    return model;
  }

  public RuleBasedParser getParser()
  {
    return parser;
  }

  public Integer getAllowedMessage(int index)
  {
    Integer aAllowedMessage = allowedMessages.get(index);
    return aAllowedMessage;
  }

  public Integer[] getAllowedMessages()
  {
    Integer[] newAllowedMessages = allowedMessages.toArray(new Integer[allowedMessages.size()]);
    return newAllowedMessages;
  }

  public int numberOfAllowedMessages()
  {
    int number = allowedMessages.size();
    return number;
  }

  public boolean hasAllowedMessages()
  {
    boolean has = allowedMessages.size() > 0;
    return has;
  }

  public int indexOfAllowedMessage(Integer aAllowedMessage)
  {
    int index = allowedMessages.indexOf(aAllowedMessage);
    return index;
  }

  public Integer getIgnoredMessage(int index)
  {
    Integer aIgnoredMessage = ignoredMessages.get(index);
    return aIgnoredMessage;
  }

  public Integer[] getIgnoredMessages()
  {
    Integer[] newIgnoredMessages = ignoredMessages.toArray(new Integer[ignoredMessages.size()]);
    return newIgnoredMessages;
  }

  public int numberOfIgnoredMessages()
  {
    int number = ignoredMessages.size();
    return number;
  }

  public boolean hasIgnoredMessages()
  {
    boolean has = ignoredMessages.size() > 0;
    return has;
  }

  public int indexOfIgnoredMessage(Integer aIgnoredMessage)
  {
    int index = ignoredMessages.indexOf(aIgnoredMessage);
    return index;
  }

  public Integer getDisallowedMessage(int index)
  {
    Integer aDisallowedMessage = disallowedMessages.get(index);
    return aDisallowedMessage;
  }

  public Integer[] getDisallowedMessages()
  {
    Integer[] newDisallowedMessages = disallowedMessages.toArray(new Integer[disallowedMessages.size()]);
    return newDisallowedMessages;
  }

  public int numberOfDisallowedMessages()
  {
    int number = disallowedMessages.size();
    return number;
  }

  public boolean hasDisallowedMessages()
  {
    boolean has = disallowedMessages.size() > 0;
    return has;
  }

  public int indexOfDisallowedMessage(Integer aDisallowedMessage)
  {
    int index = disallowedMessages.indexOf(aDisallowedMessage);
    return index;
  }

  public Integer getExpectedMessage(int index)
  {
    Integer aExpectedMessage = expectedMessages.get(index);
    return aExpectedMessage;
  }

  public Integer[] getExpectedMessages()
  {
    Integer[] newExpectedMessages = expectedMessages.toArray(new Integer[expectedMessages.size()]);
    return newExpectedMessages;
  }

  public int numberOfExpectedMessages()
  {
    int number = expectedMessages.size();
    return number;
  }

  public boolean hasExpectedMessages()
  {
    boolean has = expectedMessages.size() > 0;
    return has;
  }

  public int indexOfExpectedMessage(Integer aExpectedMessage)
  {
    int index = expectedMessages.indexOf(aExpectedMessage);
    return index;
  }

  public Position getLastassocPosition()
  {
    return lastassocPosition;
  }

  public boolean getMustWarn()
  {
    return mustWarn;
  }

  @umplesourcefile(line={20},file={"UmpleInternalParser_CodeTrace.ump"},javaline={436},length={1})
  public int getTraceFlagId()
  {
    // line 20 "../../../../src/UmpleInternalParser_CodeTrace.ump"
    traceFlagId++;
    return traceFlagId;
  }

  public boolean isPackageNameUsed()
  {
    return packageNameUsed;
  }

  public boolean isOutputUmpleSource()
  {
    return outputUmpleSource;
  }

  public String getStrictnessFullName()
  {
    String answer = strictness.toString();
    return answer;
  }

  public Strictness getStrictness()
  {
    return strictness;
  }

  public boolean modelOnly()
  {
    boolean wasEventProcessed = false;
    
    Strictness aStrictness = strictness;
    switch (aStrictness)
    {
      case none:
        setStrictness(Strictness.modelOnly);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean noExtraCode()
  {
    boolean wasEventProcessed = false;
    
    Strictness aStrictness = strictness;
    switch (aStrictness)
    {
      case none:
        setStrictness(Strictness.noExtraCode);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  @umplesourcefile(line={48,54,60}, file={"UmpleInternalParser.ump","UmpleInternalParser.ump","UmpleInternalParser.ump"}, javaline={507,513,519}, length={1,1,1})
  public boolean allowMessage(Integer id)
  {
    boolean wasEventProcessed = false;
    
    Strictness aStrictness = strictness;
    switch (aStrictness)
    {
      case none:
        // line 48 "../../../../src/UmpleInternalParser.ump"
        allowedMessages.add(id);
        setStrictness(Strictness.none);
        wasEventProcessed = true;
        break;
      case modelOnly:
        // line 54 "../../../../src/UmpleInternalParser.ump"
        allowedMessages.add(id);
        setStrictness(Strictness.modelOnly);
        wasEventProcessed = true;
        break;
      case noExtraCode:
        // line 60 "../../../../src/UmpleInternalParser.ump"
        allowedMessages.add(id);
        setStrictness(Strictness.noExtraCode);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  @umplesourcefile(line={49,55,61}, file={"UmpleInternalParser.ump","UmpleInternalParser.ump","UmpleInternalParser.ump"}, javaline={540,546,552}, length={1,1,1})
  public boolean ignoreMessage(Integer id)
  {
    boolean wasEventProcessed = false;
    
    Strictness aStrictness = strictness;
    switch (aStrictness)
    {
      case none:
        // line 49 "../../../../src/UmpleInternalParser.ump"
        ignoredMessages.add(id);
        setStrictness(Strictness.none);
        wasEventProcessed = true;
        break;
      case modelOnly:
        // line 55 "../../../../src/UmpleInternalParser.ump"
        ignoredMessages.add(id);
        setStrictness(Strictness.modelOnly);
        wasEventProcessed = true;
        break;
      case noExtraCode:
        // line 61 "../../../../src/UmpleInternalParser.ump"
        ignoredMessages.add(id);
        setStrictness(Strictness.noExtraCode);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  @umplesourcefile(line={50,56,62}, file={"UmpleInternalParser.ump","UmpleInternalParser.ump","UmpleInternalParser.ump"}, javaline={573,579,585}, length={1,1,1})
  public boolean disallowMessage(Integer id)
  {
    boolean wasEventProcessed = false;
    
    Strictness aStrictness = strictness;
    switch (aStrictness)
    {
      case none:
        // line 50 "../../../../src/UmpleInternalParser.ump"
        disallowedMessages.add(id);
        setStrictness(Strictness.none);
        wasEventProcessed = true;
        break;
      case modelOnly:
        // line 56 "../../../../src/UmpleInternalParser.ump"
        disallowedMessages.add(id);
        setStrictness(Strictness.modelOnly);
        wasEventProcessed = true;
        break;
      case noExtraCode:
        // line 62 "../../../../src/UmpleInternalParser.ump"
        disallowedMessages.add(id);
        setStrictness(Strictness.noExtraCode);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  @umplesourcefile(line={51,57,63}, file={"UmpleInternalParser.ump","UmpleInternalParser.ump","UmpleInternalParser.ump"}, javaline={606,612,618}, length={1,1,1})
  public boolean expectMessage(Integer id)
  {
    boolean wasEventProcessed = false;
    
    Strictness aStrictness = strictness;
    switch (aStrictness)
    {
      case none:
        // line 51 "../../../../src/UmpleInternalParser.ump"
        expectedMessages.add(id);
        setStrictness(Strictness.none);
        wasEventProcessed = true;
        break;
      case modelOnly:
        // line 57 "../../../../src/UmpleInternalParser.ump"
        expectedMessages.add(id);
        setStrictness(Strictness.modelOnly);
        wasEventProcessed = true;
        break;
      case noExtraCode:
        // line 63 "../../../../src/UmpleInternalParser.ump"
        expectedMessages.add(id);
        setStrictness(Strictness.noExtraCode);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setStrictness(Strictness aStrictness)
  {
    strictness = aStrictness;
  }

  public ErrorType getMessagesToExpect(int index)
  {
    ErrorType aMessagesToExpect = messagesToExpect.get(index);
    return aMessagesToExpect;
  }

  /**
   * List of errors or warnings to expect. It is an error if they do not occur.
   * This is used to set up test cases for the presence of certain messages
   */
  public List<ErrorType> getMessagesToExpect()
  {
    List<ErrorType> newMessagesToExpect = Collections.unmodifiableList(messagesToExpect);
    return newMessagesToExpect;
  }

  public int numberOfMessagesToExpect()
  {
    int number = messagesToExpect.size();
    return number;
  }

  public boolean hasMessagesToExpect()
  {
    boolean has = messagesToExpect.size() > 0;
    return has;
  }

  public int indexOfMessagesToExpect(ErrorType aMessagesToExpect)
  {
    int index = messagesToExpect.indexOf(aMessagesToExpect);
    return index;
  }

  public ErrorType getWarningsToIgnore(int index)
  {
    ErrorType aWarningsToIgnore = warningsToIgnore.get(index);
    return aWarningsToIgnore;
  }

  /**
   * List of warnings to allow and ignore
   * Used to suppress warnings that we do not care about
   */
  public List<ErrorType> getWarningsToIgnore()
  {
    List<ErrorType> newWarningsToIgnore = Collections.unmodifiableList(warningsToIgnore);
    return newWarningsToIgnore;
  }

  public int numberOfWarningsToIgnore()
  {
    int number = warningsToIgnore.size();
    return number;
  }

  public boolean hasWarningsToIgnore()
  {
    boolean has = warningsToIgnore.size() > 0;
    return has;
  }

  public int indexOfWarningsToIgnore(ErrorType aWarningsToIgnore)
  {
    int index = warningsToIgnore.indexOf(aWarningsToIgnore);
    return index;
  }

  public static int minimumNumberOfMessagesToExpect()
  {
    return 0;
  }

  public boolean addMessagesToExpect(ErrorType aMessagesToExpect)
  {
    boolean wasAdded = false;
    if (messagesToExpect.contains(aMessagesToExpect)) { return false; }
    messagesToExpect.add(aMessagesToExpect);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeMessagesToExpect(ErrorType aMessagesToExpect)
  {
    boolean wasRemoved = false;
    if (messagesToExpect.contains(aMessagesToExpect))
    {
      messagesToExpect.remove(aMessagesToExpect);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addMessagesToExpectAt(ErrorType aMessagesToExpect, int index)
  {  
    boolean wasAdded = false;
    if(addMessagesToExpect(aMessagesToExpect))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMessagesToExpect()) { index = numberOfMessagesToExpect() - 1; }
      messagesToExpect.remove(aMessagesToExpect);
      messagesToExpect.add(index, aMessagesToExpect);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMessagesToExpectAt(ErrorType aMessagesToExpect, int index)
  {
    boolean wasAdded = false;
    if(messagesToExpect.contains(aMessagesToExpect))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMessagesToExpect()) { index = numberOfMessagesToExpect() - 1; }
      messagesToExpect.remove(aMessagesToExpect);
      messagesToExpect.add(index, aMessagesToExpect);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMessagesToExpectAt(aMessagesToExpect, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfWarningsToIgnore()
  {
    return 0;
  }

  public boolean addWarningsToIgnore(ErrorType aWarningsToIgnore)
  {
    boolean wasAdded = false;
    if (warningsToIgnore.contains(aWarningsToIgnore)) { return false; }
    warningsToIgnore.add(aWarningsToIgnore);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeWarningsToIgnore(ErrorType aWarningsToIgnore)
  {
    boolean wasRemoved = false;
    if (warningsToIgnore.contains(aWarningsToIgnore))
    {
      warningsToIgnore.remove(aWarningsToIgnore);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addWarningsToIgnoreAt(ErrorType aWarningsToIgnore, int index)
  {  
    boolean wasAdded = false;
    if(addWarningsToIgnore(aWarningsToIgnore))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWarningsToIgnore()) { index = numberOfWarningsToIgnore() - 1; }
      warningsToIgnore.remove(aWarningsToIgnore);
      warningsToIgnore.add(index, aWarningsToIgnore);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveWarningsToIgnoreAt(ErrorType aWarningsToIgnore, int index)
  {
    boolean wasAdded = false;
    if(warningsToIgnore.contains(aWarningsToIgnore))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWarningsToIgnore()) { index = numberOfWarningsToIgnore() - 1; }
      warningsToIgnore.remove(aWarningsToIgnore);
      warningsToIgnore.add(index, aWarningsToIgnore);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addWarningsToIgnoreAt(aWarningsToIgnore, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    messagesToExpect.clear();
    warningsToIgnore.clear();
    super.delete();
  }

  @umplesourcefile(line={43},file={"UmpleInternalParser_Code.ump"},javaline={825},length={3})
   public  UmpleInternalParser(){
    this("UmpleInternalParser", new UmpleModel(null), new RuleBasedParser());
  }

  @umplesourcefile(line={48},file={"UmpleInternalParser_Code.ump"},javaline={830},length={3})
   public  UmpleInternalParser(UmpleModel aModel){
    this("UmpleInternalParser", aModel, new RuleBasedParser());
  }

  @umplesourcefile(line={53},file={"UmpleInternalParser_Code.ump"},javaline={835},length={25})
   private void init(){
    if(model.getUmpleFile() != null)
    {
      setFilename(model.getUmpleFile().getFileName());
      setRootToken(reset()); // Makes sure the root token position has the filename
    }
    
    Couple quotes = new Couple("\"","\"");
    Couple braces = new Couple("{","}");
    
    addCouple(quotes);    
    
    braces.addIgnore(quotes);
    braces.addIgnore(new Couple("//","\n"));
    
    addCouple(braces);
    parser.addGrammarFile("/umple_core.grammar");
    parser.addGrammarFile("/umple_classes.grammar");
    parser.addGrammarFile("/umple_patterns.grammar");
    parser.addGrammarFile("/umple_state_machines.grammar");
    parser.addGrammarFile("/umple_traces.grammar");
    parser.addGrammarFile("/umple_constraints.grammar");  // TODO Under development
    parser.addGrammarFile("/umple_layout.grammar");
    parser.addGrammarFile("/umple_exceptions.grammar");
  }

  @umplesourcefile(line={80},file={"UmpleInternalParser_Code.ump"},javaline={862},length={6})
   public ParseResult parse(String ruleName, String input){
    setParseResult(parser.parse(ruleName,input));
    setRootToken(parser.getRootToken());
    SampleFileWriter.destroy("temp.ump");
    return getParseResult();
  }

  @umplesourcefile(line={87},file={"UmpleInternalParser_Code.ump"},javaline={870},length={11})
   public ParseResult analyze(boolean shouldGenerate){
    setParseResult(parser.getParseResult());    
    setRootToken(parser.getRootToken());
    analyzeAllTokens(getRootToken());
    postTokenAnalysis();
    if (shouldGenerate && getParseResult().getWasSuccess())
    {
      model.generate();
    }
    return getParseResult();
  }


  /**
   * ------------------------
   * PRIVATE METHODS
   * ------------------------
   * When an error occurs, set the failed position and mark the compile as NOT successful
   */
  @umplesourcefile(line={105},file={"UmpleInternalParser_Code.ump"},javaline={883},length={5})
   private void setFailedPosition(Position position, int errorCode, String... messages){
    //getParseResult().setWasSuccess(false);
    getParseResult().setPosition(position);
    getParseResult().addErrorMessage(new ErrorMessage(errorCode,position,messages));
  }


  /**
   * Analyze all child tokens of the "root" token.  This delegates to a individual
   * Each token is analyzed as long as "shouldProcessAgain" is set to true during the analysis
   * analyzeToken and quits early if a problem arises
   */
  @umplesourcefile(line={115},file={"UmpleInternalParser_Code.ump"},javaline={897},length={18})
   private void analyzeAllTokens(Token rootToken){
    int analysisStep = 0;
    shouldProcessAgain = true;
    do
    {
      analysisStep += 1;
      shouldProcessAgain = false;
      for(Token t : rootToken.getSubTokens())
      {
        analyzeToken(t,analysisStep);
        if (!getParseResult().getWasSuccess())
        {
          return;
        }
      }
    }
    while (shouldProcessAgain);
  }


  /**
   * Delegate function to analyze a token within the context of a class
   * Each token is analyzed as long as "shouldProcessClassAgain" is set to true during the analysis
   * "1" is for the first round of analysis and "2" for the second.  The "2" is used for chicken-and-egg initialization problems, otherwise
   * put everything under the "1"
   */
  @umplesourcefile(line={139},file={"UmpleInternalParser_Code.ump"},javaline={923},length={18})
   private void analyzeAllTokens(Token rootToken, UmpleClass aClass){
    int analysisStep = 0;
    shouldProcessClassAgain = true;
    do
    {
      analysisStep += 1;
      shouldProcessClassAgain = false;
      for(Token token : rootToken.getSubTokens())
      {
        analyzeToken(token,aClass,analysisStep);
        if (!getParseResult().getWasSuccess())
        {
          return;
        }
      }
    }
    while (shouldProcessClassAgain);
  }


  /**
   * Delegate function to analyze a token and send it to the write
   */
  @umplesourcefile(line={160},file={"UmpleInternalParser_Code.ump"},javaline={950},length={7})
   private void analyzeToken(Token t, int analysisStep){
    analyzeCoreToken(t,analysisStep);
    analyzeClassToken(t,analysisStep);
    analyzeStateMachineToken(t,analysisStep);
    analyzeTraceToken(t,analysisStep);
    analyzeLayoutToken(t,analysisStep);
  }


  /**
   * Analyze an individual token, delegates to the various components in Umple
   */
  @umplesourcefile(line={170},file={"UmpleInternalParser_Code.ump"},javaline={963},length={6})
   private void analyzeToken(Token t, UmpleClass aClass, int analysisStep){
    analyzeCoreToken(t,aClass,analysisStep);
    analyzeClassToken(t,aClass,analysisStep);
    analyzeStateMachineToken(t,aClass,analysisStep);
    analyzeDependentTokens(t,aClass,analysisStep);
  }


  /**
   * The analysis methods in this function can depend on prior analysis (ex: constraints/keys on attributes defined later in the code)
   * Therefore it is necessary to force a second pass of the analysis for these cases
   */
  @umplesourcefile(line={181},file={"UmpleInternalParser_Code.ump"},javaline={975},length={24})
   private void analyzeDependentTokens(Token t, UmpleClass aClass, int analysisStep){
    if(analysisStep == 1 || shouldProcessClassAgain)
    {
      shouldProcessClassAgain = true;
      return;
    }

    // Methods after this point will occur on analysisStep > 1
    
    if (t.is("invariant"))
    {
      analyzeInvariant(t,aClass);
    }
    else if (t.is("beforeCode") || t.is("afterCode"))
    {
      analyzeInjectionCode(t,aClass);
    }
    else if (t.is("key") || t.is("defaultKey"))
    {
      analyzeKey(t,aClass);
    }
    analyzeTraceToken(t,aClass);
    analyzeLayoutToken(t,aClass,analysisStep);
  }


  /**
   * Once you have analyze all tokens, you allowed a second 'pass' to apply any additional checks
   * Each step in the process might "fail", so we check the status before calling each delegate
   * token post token analysis method
   */
  @umplesourcefile(line={210},file={"UmpleInternalParser_Code.ump"},javaline={1006},length={30})
   private void postTokenAnalysis(){
    analyzeParseResult();
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


  /**
   * Locate all 'use *.ump' references and add those files if not already parsed
   */
  @umplesourcefile(line={245},file={"UmpleInternalParser_Code.ump"},javaline={1044},length={3})
   private void addNecessaryFiles(){
    
  }


  /**
   * Loop through all unparsed files, parse them, and add any missing references
   */
  @umplesourcefile(line={250},file={"UmpleInternalParser_Code.ump"},javaline={1053},length={16})
   private void parseAllFiles(){
    addNecessaryFiles();
    while (!unparsedUmpleFiles.isEmpty() && getParseResult().getWasSuccess())
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

  @umplesourcefile(line={268},file={"UmpleInternalParser_Code.ump"},javaline={1075},length={81})
   public void analyzeParseResult(){
    int numberOfErrors = 0;
    int numberOfWarnings = 0;
    for(int i = 0; i<getParseResult().numberOfErrorMessages(); i++)
    {
      ErrorMessage error = getParseResult().getErrorMessage(i);
      if(error.getErrorType().getSeverity() <= 2)
      {
        numberOfErrors++;
      }
      else
      {
        numberOfWarnings++;
      }
      if(allowedMessages.contains(error.getErrorType().getErrorCode()))
      {
        if(error.getErrorType().getSeverity() <= 2)
        {
          numberOfErrors--;
        }
        else
        {
          numberOfWarnings--;
        }
        getParseResult().removeErrorMessage(error);
        i--;
        continue;
      }
      if(ignoredMessages.contains(error.getErrorType().getErrorCode()))
      {
        if(error.getErrorType().getSeverity() <= 2)
        {
          numberOfErrors--;
        }
        else
        {
          numberOfWarnings--;
        }
        getParseResult().removeErrorMessage(error);
        i--;
        continue;
      }
      if(expectedMessages.contains(error.getErrorType().getErrorCode()))
      {
        if(error.getErrorType().getSeverity() <= 2)
        {
          numberOfErrors--;
        }
        else
        {
          numberOfWarnings--;
        }
      }
    }
    for(Integer id: expectedMessages)
    {
      boolean hasMessage = false;
      for(int i = 0; i<getParseResult().numberOfErrorMessages(); i++)
      {        
        ErrorMessage error = getParseResult().getErrorMessage(i);
        if(error.getErrorType().getErrorCode() == id)
        {          
          getParseResult().removeErrorMessage(error);
          hasMessage = true;
          break;
        }
      }
      if(!hasMessage)
      {
        // setFailedPosition
      }
    }
    if(numberOfErrors == 0)
    {
      getParseResult().setWasSuccess(true);
    }
    if(numberOfWarnings == 0)
    {
      getParseResult().setHasWarnings(false);
    }
  }


  /**
   * Analyze core tokens to the Umple language
   */
  @umplesourcefile(line={21},file={"UmpleInternalParser_CodeCore.ump"},javaline={1158},length={19})
   private void analyzeCoreToken(Token t, int analyzeCoreToken){
    if (analyzeCoreToken != 1)
    {
      return;
    }
  
    if (t.is("generate") || t.is("generate_path"))
    {
    	analyzeGenerate(t);
    }
    else if (t.is("glossary"))
    {
      analyzeGlossary(t);
    }
    else if (t.is("debug"))
    {
    	model.setDebugMode(true);
    }
  }


  /**
   * There are currently no core tokens of concern in the context of an UmpleClass
   * This method is available if needed
   */
  @umplesourcefile(line={44},file={"UmpleInternalParser_CodeCore.ump"},javaline={1183},length={3})
   private void analyzeCoreToken(Token t, UmpleClass aClass, int analysisStep){
    
  }


  /**
   * Perform post token analysis on core elements of the Umple language
   */
  @umplesourcefile(line={50},file={"UmpleInternalParser_CodeCore.ump"},javaline={1193},length={50})
   private void postTokenCoreAnalysis(){
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


  /**
   * Add singular / plural forms of words to the glossary to be used by the code generator
   */
  @umplesourcefile(line={104},file={"UmpleInternalParser_CodeCore.ump"},javaline={1249},length={11})
   private void analyzeGlossary(Token glossaryToken){
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

  @umplesourcefile(line={117},file={"UmpleInternalParser_CodeCore.ump"},javaline={1266},length={20})
   private void analyzeGenerate(Token genToken){
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


  /**
   * Analyze class definitions and related tokens.
   * 
   * @param t The current token that will be analyzed to determine how to further make use of it (is it a comment, class, etc?)
   * @param analysisStep Used to determine whether or not things should be analyzed more than once (multi-pass).
   */
  @umplesourcefile(line={44},file={"UmpleInternalParser_CodeClass.ump"},javaline={1288},length={95})
   private void analyzeClassToken(Token t, int analysisStep){
    if (analysisStep != 2)
    {
      shouldProcessAgain = shouldProcessAgain || (analysisStep == 1);
      return;
    }

    // Only need to clear comments if there actually was comments.
    boolean shouldConsumeComment = lastComments.size() > 0;

    // Determine what the current token is primarily, and based on that the analysis procedure is determined.
    if (t.isStatic("//") || t.isStatic("/*") || t.isStatic("*/"))
    {
      shouldConsumeComment = false;
    }
    else if (t.is("useStatement") )
    {
    	analyzeAllTokens(t);
    }
    else if (t.is("strictness") )
    {
      // unimplemented feature. Issue a warning that it is currently not fully implemented
      setFailedPosition(t.getPosition(), 9999, t.getName(), t.toString());
    }
    else if (t.is("strictnessMessage"))
    {
      if(t.getValue("message").equals("allow"))
      {
        allowMessage(Integer.parseInt(t.getValue("messageNumber")));
      }
      else if(t.getValue("message").equals("disallow"))
      {
        disallowMessage(Integer.parseInt(t.getValue("messageNumber")));
      }
      else if(t.getValue("message").equals("ignore"))
      {
        ignoreMessage(Integer.parseInt(t.getValue("messageNumber")));
      }
      else if(t.getValue("message").equals("expect"))
      {
        expectMessage(Integer.parseInt(t.getValue("messageNumber")));
      }
    }      
    else if (t.is("namespace"))
    {
      if(!packageNameUsed && !t.getValue().equals(currentPackageName))
        setFailedPosition(t.getPosition(),31,currentPackageName,t.getValue());
      currentPackageName = t.getValue();
      if (model.getDefaultNamespace() == null)
      {
        model.setDefaultNamespace(currentPackageName);  
      }
      packageNameUsed = false;
    }
    else if (t.is("inlineComment"))
    {
      analyzeComment(t);
      shouldConsumeComment = addToLastAttributeOrAssociation(t);
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
      if (t.getValue("interface")!=null)
        analyzeExternalInterface(t);
      else
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

    // This essentially "clears" the comments in the list so that new comments, when parsed, will be the ones appearing above
    // classes, methods, attributes, etc (whichever comes next) rather than old comments propogating everywhere.
    if (shouldConsumeComment)
    {
      lastComments.clear();
    }
  }


  /**
   * If the last attribute/association made matches the line number of the comment, add the comment to the attribute/association.
   * 
   * @param t the comment token that is used to see the position of the comment
   */
  @umplesourcefile(line={147},file={"UmpleInternalParser_CodeClass.ump"},javaline={1392},length={36})
   private boolean addToLastAttributeOrAssociation(Token t){
    if (t.getPosition() == null) {return false;}
    if (lastattr != null)
    {
      if (lastattr.getPosition().getLineNum() == t.getPosition().getLineNum())
      {
        // this will only add the current comment, as there can only be 1 inline comment per line
        for (Comment c : lastComments)
        {
          lastattr.addComment(c);
        }
        return true;
      }
      else
      {
        lastattr = null;
      }
    }  
    else if (lastassoc != null && lastassocPosition != null)
    {
      if (lastassocPosition.getLineNum() == t.getPosition().getLineNum())
      {
        // this will only add the current comment, as there can only be 1 inline comment per line
        for (Comment c : lastComments)
        {
          lastassoc.addComment(c);
        }
        return true;
      }
      else
      {
        lastassoc = null;
      }
    }                
    return false;
  }


  /**
   * Analyze class content tokens.
   * 
   * @param token The current token that will be analyzed to determine how to further make use of it (is it a method, comment, 
   * attribute, etc?)
   * @param aClass The Umple class used such that parsed content such as methods, attributes, comments, etc may be added to
   * it.
   * @param analysisStep Used to determine whether or not things should be analyzed more than once (multi-pass).
   */
  @umplesourcefile(line={194},file={"UmpleInternalParser_CodeClass.ump"},javaline={1436},length={82})
   private void analyzeClassToken(Token token, UmpleClass aClass, int analysisStep){
    if (analysisStep != 1)
    {
      return;
    }

    // Only need to clear comments if there actually was comments.
    boolean shouldConsumeComment = lastComments.size() > 0;
    
    // Determine what the current token is primarily, and based on that the analysis procedure is determined.
    if (token.isStatic("//") || token.isStatic("/*") || token.isStatic("*/"))
    {
      shouldConsumeComment = false;
    }
    else if (token.is("inlineComment"))
    {
      analyzeComment(token);
      shouldConsumeComment = addToLastAttributeOrAssociation(token);
    }
    else if (token.is("multilineComment"))
    {
      analyzeMultilineComment(token);
      shouldConsumeComment = false;
    }
    // TODO Under development
    
    else if (token.is("classDefinition"))
    {
      UmpleClass childClass = analyzeClass(token);
      boolean wasSet = childClass.setExtendsClass(aClass);
      if (!wasSet)
      {
        setFailedPosition(token.getPosition(), 16, childClass.getName(), aClass.getName());
      }
    }
    else if (token.is("constantDeclaration"))
    {
      analyzeConstant(token,aClass);
    }
    else if(token.is("constantDeclarationDeprecated"))
    {
      setFailedPosition(token.getPosition(), 901);
      analyzeConstant(token,aClass);
    }
    else if (token.is("attribute"))
    {
      analyzeAttribute(token,aClass);
    }
    else if (token.is("extraCode"))
    {
      analyzeExtraCode(token,aClass);
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
    else if (token.is("exception"))
    {
      analyzeException(token,aClass);
    }

    // This essentially "clears" the comments in the list so that new comments, when parsed, will be the ones appearing above
    // classes, methods, attributes, etc (whichever comes next) rather than old comments propogating everywhere.
    if (shouldConsumeComment)
    {
      lastComments.clear();
    }
  }


  /**
   * 
   * Analyzes a comment to determine if it should be added into the list of currently parsed comments waiting to be added to
   * a class, attribute, association, method or otherwise.
   * 
   * Note that this is for an inline comment rather than a multiline comment.
   * 
   * @param token The current token which has been flagged to be a comment to analyze, containing its value.
   */
  @umplesourcefile(line={286},file={"UmpleInternalParser_CodeClass.ump"},javaline={1530},length={14})
   private void analyzeComment(Token token){
    String theValue = "";
    // Special comment directive to force umpleoutput directives to be added
    // In every class
    if (token.getValue().startsWith("@outputumplesource")) { 
      outputUmpleSource = true;
      return;
    }
    if (!token.getValue().equals("$?[End_of_model]$?")) 
    {
      theValue = token.getValue();
      lastComments.add(new Comment(theValue));
    }
  }


  /**
   * 
   * Analyzes a comment to determine if it should be added into the list of currently parsed comments waiting to be added to
   * a class, attribute, association, method or otherwise.
   * 
   * Note that this is for a multiline comment, which essentially means the possibility of multiple inline comments (1 per line)
   * that will be concatenated together.
   * 
   * @param token The current token which has been flagged to be a comment to analyze, containing its value.
   */
  @umplesourcefile(line={311},file={"UmpleInternalParser_CodeClass.ump"},javaline={1556},length={18})
   private void analyzeMultilineComment(Token token){
    String inlineComments[] = token.getValue().split("\n");

    // Go through the inline comments and add them to the list of comments waiting to be applied
    String theComment = "";
    for (int i = 0; i < inlineComments.length; i++) 
    {
      theComment = inlineComments[i];
      if(theComment.startsWith("@outputumplesource")) {
        outputUmpleSource = true;
      }
      else {
        Comment comment = new Comment(theComment);
        comment.setIsInline(false);
        lastComments.add(comment);
      }
    }
  }


  /**
   * Link associations, association variables and extends that were "defined" after their use
   */
  @umplesourcefile(line={333},file={"UmpleInternalParser_CodeClass.ump"},javaline={1587},length={15})
   private void postTokenClassAnalysis(){
    if (verifyClassesInUse())
    {
      checkSingletonAssociations();
      addUnlinkedAssociationVariables();
      addUnlinkedAssociations();
      addUnlinkedExtends();
      checkDuplicateAssociationNames();
      checkExtendsForCycles();
      checkSortedAssociations();
      checkClassInterfaceAssocations();
      checkExtendsClass();
      checkAbstractClass();
    }
  }

  @umplesourcefile(line={350},file={"UmpleInternalParser_CodeClass.ump"},javaline={1608},length={4})
   private void postTokenInterfaceAnalysis(){
    addUnlinkedInterfaceExtends();
    checkExtendsForCyclesInterface();
  }

  @umplesourcefile(line={385},file={"UmpleInternalParser_CodeClass.ump"},javaline={1614},length={16})
   private void checkExtendsForCyclesInterface(){
    for(UmpleInterface I : model.getUmpleInterfaces())
    {
      HashMap<UmpleInterface, Boolean> vistedMap = new HashMap<UmpleInterface, Boolean>();
      if(I.getExtendsInterface() != null)
      {
        if(recursiveCycleCheckInterface(I.getExtendsInterface(), I, vistedMap).contains(I)){
          Token t = I.getExtendsToken();
              if(t.getValue().equals(I.getName()))
                getParseResult().addErrorMessage(new ErrorMessage(11,t.getPosition(),"Interface",I.getName()));
              else
                getParseResult().addErrorMessage(new ErrorMessage(12,t.getPosition(),"Interface",t.getValue(),I.getName()));
        }
      }
    }
  }

  @umplesourcefile(line={403},file={"UmpleInternalParser_CodeClass.ump"},javaline={1632},length={17})
   private UmpleClass recursiveCycleCheck(UmpleClass extend, UmpleClass parent, HashMap<UmpleClass, Boolean> map){
    UmpleClass temp = null;

    if(extend == null)
      return null;

    if(map.containsKey(extend))
      return extend;

    map.put(extend, true);

    if(parent.equals(extend.getExtendsClass()))
      return extend.getExtendsClass();

    temp = recursiveCycleCheck(extend.getExtendsClass(), parent, map);
    return temp;
  }

  @umplesourcefile(line={422},file={"UmpleInternalParser_CodeClass.ump"},javaline={1651},length={17})
   private void checkExtendsForCycles(){
    for(UmpleClass C : model.getUmpleClasses())
    {
      HashMap<UmpleClass, Boolean> vistedMap = new HashMap<UmpleClass, Boolean>();
      if(C.getExtendsClass() != null)
      {
        if(C.equals(recursiveCycleCheck(C.getExtendsClass(), C, vistedMap))) 
        {
          Token t = C.getExtendsToken();
          if(t.getValue().equals(C.getName()))
            getParseResult().addErrorMessage(new ErrorMessage(11,t.getPosition(),"Class",C.getName()));
          else
            getParseResult().addErrorMessage(new ErrorMessage(12,t.getPosition(),"Class",t.getValue(),C.getName()));
        }
      }
    }
  }


  /**
   * Check for classes that should be abstract
   */
  @umplesourcefile(line={442},file={"UmpleInternalParser_CodeClass.ump"},javaline={1670},length={20})
   private void checkAbstractClass(){
    for(UmpleClass uClass : model.getUmpleClasses()) 
    { 
      if(uClass.getIsAbstract()) 
      {
        // no work needs to be done on this class.
        continue;
      }     

      if(uClass.getUnimplementedMethods().length > 0) 
      {
        uClass.setIsAbstract(true);
        continue;
      }      

      // Check if class should be abstract based on properties of ancestors
      HashMap<String, Integer> uChildren = new HashMap<String, Integer>();
      checkAbstractClassRecursive(uClass, uChildren);
    }
  }


  /**
   * Checks for unimplemented methods in ancestor classes
   * against the implemented methods in aClass. if neither
   * aClass nor its ancestors implemented a method, then
   * aClass must be abstract.
   */
  @umplesourcefile(line={469},file={"UmpleInternalParser_CodeClass.ump"},javaline={1696},length={23})
   private Method[] checkAbstractClassRecursive(UmpleClass aClass, HashMap<String, Integer> aChildren){
    if(aClass.getExtendsToken() == null || aClass.getExtendsClass() == null || aChildren.get(aClass.getName()) != null) 
    {
      return aClass.getUnimplementedMethods();
    }

    aChildren.put(aClass.getName(), 1);
    Method[] ancestorUnimplementedMethods = checkAbstractClassRecursive(aClass.getExtendsClass(), aChildren);
    for(Method unimplementedMethod : ancestorUnimplementedMethods) 
    {
      if(!aClass.hasMethod(unimplementedMethod)) 
      {
        aClass.addUnimplementedMethod(unimplementedMethod);
      }
    }

    if(aClass.getUnimplementedMethods().length > 0) 
    {
      aClass.setIsAbstract(true);
    }

    return aClass.getUnimplementedMethods();
  }


  /**
   * Check for the existence of a a parent class
   */
  @umplesourcefile(line={494},file={"UmpleInternalParser_CodeClass.ump"},javaline={1728},length={27})
   private void checkExtendsClass(){
    for(UmpleClass child : model.getUmpleClasses()) {
      if(child.getExtendsToken() != null) {
        if (child.getExtendsClass() != null ) {
          // check to make sure attribute doesn't share a name with inherited attribute - F.K.
          UmpleClass extend = child.getExtendsClass();
          for(Attribute aAttribute : child.getAttributes()){
            while(extend!=null) {
              for(Attribute extendAttr : extend.getAttributes()) {
                String currentName = aAttribute.getName();
                if (extendAttr.getName().equals(currentName)) {
                  setFailedPosition(aAttribute.getPosition(), 44, child.getName(), currentName, extend.getName());
                }
              }
              extend = extend.getExtendsClass();
            }  
          }     
          continue;
        }
        else{
          Token t = child.getExtendsToken();
          getParseResult().addErrorMessage(new ErrorMessage(33,t.getPosition(),t.getValue(),
            child.getName()));      
        }
      }
    }
  }


  /**
   * Analyzes all associations that are part of the given token indicated to be related to an association.
   * 
   * @param associationToken The token indicated to be an association or association Class where sub tokens will be analyzed from to further
   * analyze the individual associations.
   */
  @umplesourcefile(line={528},file={"UmpleInternalParser_CodeClass.ump"},javaline={1761},length={23})
   private void analyzeAllAssociations(Token associationToken){
    String name = associationToken.getValue("name");

    // Go through every token that is a child of the current token (all associations part of this association).
    for(Token token : associationToken.getSubTokens()){
      boolean isAssociationToken = token.is("association");

      //Issue 213/131: [association] elements inside associationClasses generate 2 associations instead of one
      if (isAssociationToken && associationToken.is("associationClassDefinition")) {
        for (Token t : token.getSubTokens()) {
          if (t.is("associationEnd")) {
            analyzeAssociation(t, "");
          }
        }
      } else if (isAssociationToken || token.is("singleAssociationEnd")){
        Association association = analyzeAssociation(token, "");
        if(isAssociationToken && association != null){
          association.setName(name);
        }
      }
      if (!getParseResult().getWasSuccess()) { return; }
    }
  }


  /**
   * Analyzes a class token to populate an Umple class.
   * 
   * This is also where the list of currently parsed comments will be added to the Umple class.
   * 
   * @param classToken The token which contains the data to be analyzed to populate an Umple class.
   * 
   * @return An Umple class populated with data based on the analysis of the class token.
   */
  @umplesourcefile(line={562},file={"UmpleInternalParser_CodeClass.ump"},javaline={1793},length={91})
   private UmpleClass analyzeClass(Token classToken){
    String className = classToken.getValue("name").split(" ")[classToken.getValue("name").split(" ").length-1];
    //Check to ensure the name is valid (starts with a letter, and only contains letters, numbers, or underscores
    if (Token.isValidIdentifier(className, "[A-Za-z]") != true) {
      setFailedPosition(classToken.getPosition(), 100, className);
    }
    else if ( className.matches("[a-z].*") ){ // Warn when class name does not start with a capital letter.
      setFailedPosition(classToken.getPosition(), 101, className);
    }
    UmpleClass aClass;
    //Issue 213: UmpleClass can be an AssociationClass
    if(classToken.is("associationClassDefinition")){
        aClass = model.addAssociationClass(classToken.getValue("name"));
    }else{
        aClass = model.addUmpleClass(classToken.getValue("name"));
    }
    if ( classToken.is("classDefinition") && "external".equals(aClass.getModifier()) )
      aClass.setModifier(""); // Remove the external modifier if a non-external specification of this class is found.

    Position thePosition = classToken.getPosition();
    Position endPosition = classToken.getEndPosition();

    // Set the original .ump file and line number
    aClass.addPosition(thePosition);
    aClass.addEndPosition(endPosition);

    // Add all the comments in the comment list to the Umple class.
    // But add them before any umplesource special comments
    int regularCommentCountEnd = 0;
    for (Comment c : aClass.getComments()) {
      if(c.getText().startsWith("@umplesource")) break;
      regularCommentCountEnd++;
    }

    for (Comment c : lastComments)
    {
      aClass.addCommentAt(c,regularCommentCountEnd);
      regularCommentCountEnd++;
    }
    
    // Add special position comment at the end if @outputumplesource had been 
    // detected earlier in a comment
    if(outputUmpleSource == true) {  
      aClass.addComment(new Comment("@umplesource " + thePosition.getRelativePath(null,"Java")+" "+thePosition.getLineNumber()));
    }

  // If the "abstract" keyword is parsed, make the Umple class an abstract class.
    if (classToken.getValue("abstract") != null)
    {
      boolean wasSet = aClass.setIsAbstract(true);
      
      // Ensure the value was set.
      if (wasSet == false)
      {
        setFailedPosition(classToken.getPosition(), 0, "Unable to make class abstract!");
      }
    }

    addExtendsTo(classToken, aClass, unlinkedExtends, unlinkedExtendsTokens);
    
    // If the "singleton" keyword is parsed, make the Umple class a singleton.
    if (classToken.getValue("singleton") != null)
    {
      aClass.setIsSingleton(true);
    }
    if(!"".equals(aClass.getPackageName()) && !currentPackageName.equals(aClass.getPackageName()) && !packageNameUsed){
      setFailedPosition(classToken.getPosition(), 30, aClass.getName(), currentPackageName);
      aClass.setPackageName(currentPackageName);    
    }    
    if("".equals(aClass.getPackageName())){
      aClass.setPackageName(currentPackageName);
  }
  packageNameUsed = true;
    if (aClass.getIsSingleton()) 
    {
      classToken.setName(classToken.getName());  
    }

    if (classToken.getValue("immutable") != null)
    {
      boolean wasSet = aClass.setImmutable();
      if (!wasSet)
      {
        // Future-proofing: currently all paths cause wasSet to be true
        setFailedPosition(classToken.getPosition(), 14, classToken.getName());
      }
    }

    analyzeAllTokens(classToken,aClass);
    return aClass;
  }


  /**
   * Returns the number of umple class in extends list (extList)
   */
  @umplesourcefile(line={687},file={"UmpleInternalParser_CodeClass.ump"},javaline={1896},length={9})
   private int numberOfExtendsClass(List<Token> extList){
    int counter = 0;
		for(Token t : extList)
		{	
			if(isAnUmpleClass(t.getValue("extendsName")))
				counter++;
		}
		return counter;
  }


  /**
   * This method checks if an umple element with name "name" is an umple class
   */
  @umplesourcefile(line={699},file={"UmpleInternalParser_CodeClass.ump"},javaline={1911},length={12})
   private boolean isAnUmpleClass(String name){
    for(UmpleClass aClass : model.getUmpleClasses())
		{
			if(aClass != null)
			{
				String nam = aClass.getName();
				if(nam.equals(name))
					return true;
			}
		}
		return false;
  }

  @umplesourcefile(line={712},file={"UmpleInternalParser_CodeClass.ump"},javaline={1929},length={9})
   private UmpleClass analyzeExternal(Token externalToken){
    // Check to see if there is an existing class
    UmpleClass existingClass = model.getUmpleClass(externalToken.getValue("name"));
    UmpleClass aClass = analyzeClass(externalToken);
    // Only set the modifier to external if there is not a class defined with the same name
    if ( existingClass == null )
      aClass.setModifier("external");
    return aClass;
  }

  @umplesourcefile(line={723},file={"UmpleInternalParser_CodeClass.ump"},javaline={1940},length={5})
   private UmpleInterface analyzeExternalInterface(Token externalToken){
    UmpleInterface anInterface = analyzeInterface(externalToken);
    anInterface.setModifier("external");
    return anInterface;
  }

  @umplesourcefile(line={730},file={"UmpleInternalParser_CodeClass.ump"},javaline={1947},length={23})
   private UmpleInterface analyzeInterface(Token t){
    String interfaceName = t.getValue("name");   
    //Check to ensure the name is valid (starts with a letter, and only contains letters, numbers, or underscores
    if (Token.isValidIdentifier(interfaceName, "[A-Za-z|@]") != true) {
      setFailedPosition(t.getPosition(), 110, interfaceName);
    }
    else if ( interfaceName.matches("[a-z].*") ){ // Warn when interface name doesn't start with a capital letter.
       setFailedPosition(t.getPosition(), 111, interfaceName);
    }
  
    UmpleInterface newInterface = new UmpleInterface(t.getValue("name"));
    model.addUmpleInterface(newInterface);
    if(!"".equals(newInterface.getPackageName()) && !currentPackageName.equals(newInterface.getPackageName()) && !packageNameUsed){
      setFailedPosition(t.getPosition(), 30, newInterface.getName(), currentPackageName);
      newInterface.setPackageName(currentPackageName);    
    }    
    if("".equals(newInterface.getPackageName())){
      newInterface.setPackageName(currentPackageName);
  }
  packageNameUsed = true;
    analyzeInterface(t,newInterface);
    return newInterface;
  }

  @umplesourcefile(line={755},file={"UmpleInternalParser_CodeClass.ump"},javaline={1972},length={26})
   private void analyzeInterface(Token interfaceToken, UmpleInterface aInterface){
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
        aInterface.setCoordinates(new Coordinate(token.getIntValue("x"),token.getIntValue("y"), token.getIntValue("width"), token.getIntValue("height")));
      }
      else if (token.is("displayColor"))
      {  // Note: See near clone in UmpleInternalParser_CodeLayout.ump
        String theColor = token.getValue("colorValue");
        if(theColor.startsWith("=")) theColor=theColor.substring(1,theColor.length());
        if(!theColor.startsWith("\"")) theColor= "\""+theColor;
        if(!theColor.endsWith("\"")) theColor= theColor+"\"";         
        aInterface.setDisplayColor(theColor);
      }
    }
  }

  @umplesourcefile(line={783},file={"UmpleInternalParser_CodeClass.ump"},javaline={2000},length={46})
   private void addUnlinkedInterfaceExtends(){
    for (UmpleClassifier c : unlinkedInterfaceExtends.keySet())
    {
      UmpleInterface child = null; //unlinkedInterfaceExtends guaranteed to contain only UmpleInterfaces
      if (c instanceof UmpleInterface){
        child = (UmpleInterface) c;
      }
      List<String> extendsNames = unlinkedInterfaceExtends.get(child);
      List<Token>  extendsToken = unlinkedExtendsTokensInterface.get(child);
      

      if (extendsNames == null)
      {
        continue;
      }
      

      for (int i=0; i < extendsNames.size();i++)
      {
        String extendName= extendsNames.get(i);
        UmpleInterface uInterface=  model.getUmpleInterface(extendName);
        boolean wasSet = child.addExtendsInterface(uInterface);
        
        if (!wasSet)
        {
          Position pos;
          try
          {
            pos = extendsToken.get(i).getPosition();
          }
          catch(Exception e)
          {
            pos = new Position("",0,0,0);
          }
          setFailedPosition(pos, 16, child.getName(), uInterface.getName());
          return;
        }
        try
        {
          child.setExtendsToken(extendsToken.get(i));
        }
        
        catch(Exception e){}
      }
    }
  }

  @umplesourcefile(line={831},file={"UmpleInternalParser_CodeClass.ump"},javaline={2048},length={23})
   private void analyzeInterfaceMembers(Token interfaceMemberToken, UmpleInterface aInterface){
    for(Token childToken : interfaceMemberToken.getSubTokens())
    {
      addExtendsTo(interfaceMemberToken, aInterface, unlinkedInterfaceExtends, unlinkedExtendsTokensInterface);
      if(childToken.is("abstractMethodDeclaration"))
      {
        analyzeMethod(childToken, aInterface);   
      }  
      else if (childToken.is("constantDeclaration"))
      {
        analyzeConstant(childToken, aInterface);    
      }
      else if (childToken.is("constantDeclarationDeprecated"))
      {
        setFailedPosition(childToken.getPosition(), 901);
        analyzeConstant(childToken, aInterface);    
      }
      else if (childToken.is("extraCode"))
      {
        aInterface.appendExtraCode(childToken.getValue("extraCode"));
      }
    }
  }

  @umplesourcefile(line={856},file={"UmpleInternalParser_CodeClass.ump"},javaline={2073},length={19})
   private void analyzeAssociationClass(Token classToken){
    //test if Association class has at least 1 association or more than one singleEndAssociation
    List<Token> subtokens = classToken.getSubTokens();
    int singleAssocNumber = 0;
    int assocNumber = 0;
    for(Token t : subtokens){
        if(t.is("singleAssociationEnd")){
            singleAssocNumber++;
        }else if (t.is("association")){
            assocNumber++;
        }
    }
    if(singleAssocNumber == 1 || (assocNumber == 0 && singleAssocNumber == 0)){
        setFailedPosition(classToken.getPosition(), 8, classToken.getValue("name"));
        return;
    }
    analyzeClass(classToken);
    analyzeAllAssociations(classToken);
  }

  @umplesourcefile(line={877},file={"UmpleInternalParser_CodeClass.ump"},javaline={2094},length={17})
   private boolean verifyClassesInUse(){
    for(Map.Entry<Position, String> e : positionToClassNameReference.entrySet())
    {
      boolean isAClass = model.getUmpleClass(e.getValue()) != null;
      boolean isAInterface = model.getUmpleInterface(e.getValue()) != null;

      if (!isAClass && !isAInterface) //item referenced not a class or interface
      {
        UmpleClass aClass = model.addUmpleClass(e.getValue());
        aClass.setPackageName(model.getDefaultNamespace());
        setFailedPosition(e.getKey(), 5, e.getValue());
        return false;
      }
    }
    
    return true;
  }

  @umplesourcefile(line={896},file={"UmpleInternalParser_CodeClass.ump"},javaline={2113},length={13})
   private boolean associationIsBetweenClassAndInterface(Association a){
    AssociationEnd myEnd = a.getEnd(0);
       AssociationEnd yourEnd = a.getEnd(1);
       
       UmpleClass myClass = model.getUmpleClass(myEnd.getClassName());
       UmpleInterface yourClass = model.getUmpleInterface(yourEnd.getClassName());
       
       if (myClass != null && yourClass != null ){ //association is between class and interface
         return true;
       }
       
       return false;
  }

  @umplesourcefile(line={913},file={"UmpleInternalParser_CodeClass.ump"},javaline={2128},length={38})
   private void addUnlinkedAssociationVariables(){
    for (AssociationVariable av : unlinkedAssociationVariables)
    {
       
      UmpleClass aClass = model.getUmpleClass(av.getType());
      UmpleClass bClass = model.getUmpleClass(av.getRelatedAssociation().getType());   
      
      if (aClass == null || bClass == null){ //Association is between Class and Interface
        continue;
      }   

      Association assoc = bClass.getAssociation(bClass.indexOfAssociationVariable(av));

      boolean added = aClass.addAssociationVariable(av.getRelatedAssociation());
      if (!added)
      {
        if ((!aClass.isImmutable() && !av.getRelatedAssociation().getIsNavigable()) || (!bClass.isImmutable() && !av.getIsNavigable())) 
        { 
          setFailedPosition(assoc.getTokenPosition(),13);
        }
        else { setFailedPosition(assoc.getTokenPosition(),18); }
        return;
      }

      aClass.addAssociation(assoc);

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

  @umplesourcefile(line={953},file={"UmpleInternalParser_CodeClass.ump"},javaline={2168},length={3})
   private boolean isUmpleClass(String elementName){
    return (model.getUmpleInterface(elementName) != null) ? false: true;
  }

  @umplesourcefile(line={958},file={"UmpleInternalParser_CodeClass.ump"},javaline={2173},length={50})
   private void addUnlinkedExtends(){
    for (UmpleClassifier c : unlinkedExtends.keySet())
    {
      UmpleClass child = null; // unlinkedExtends guaranteed to contain only UmpleClasses
      if (c instanceof UmpleClass){
        child = (UmpleClass) c;
      }  
    
      List<String> extendsNames = unlinkedExtends.get(child);    
      List<Token>  extendsToken = unlinkedExtendsTokens.get(child);

      if (extendsNames == null)
      {
        continue;
      }

      for (int i=0; i < extendsNames.size();i++){
        String extendName= extendsNames.get(i);
        if (isUmpleClass(extendName))
        {
          UmpleClass parent = model.getUmpleClass(extendName);     
          boolean wasSet = child.setExtendsClass(parent);
          if (!wasSet)
          {
            Position pos;
            try
            {
              pos = extendsToken.get(i).getPosition();
            }
            catch(Exception e)
            {
              pos = new Position("",0,0,0);
            }
            setFailedPosition(pos, 16, child.getName(), parent.getName());
            return;
          }
          try
          {
            child.setExtendsToken(extendsToken.get(i));
          }
          catch(Exception e){}
        }
        else {
          UmpleInterface uInterface=  model.getUmpleInterface(extendName);
          child.addParentInterface(uInterface);
          addImplementedMethodsFromInterface(uInterface, child);
        }
      }
    }
  }

  @umplesourcefile(line={1010},file={"UmpleInternalParser_CodeClass.ump"},javaline={2225},length={18})
   private void addImplementedMethodsFromInterface(UmpleInterface parentInterface, UmpleClass uClass){
    //GET AND SET METHODS CHECK?
    if (parentInterface.hasMethods())
    {
      for (Method aMethod : parentInterface.getMethods())
      {
        boolean shouldAddMethod = verifyIfMethodIsConstructorOrGetSet(uClass, aMethod);
        if (!(uClass.hasMethod(aMethod)) && shouldAddMethod)
        {
          if("".equals(aMethod.getMethodBody().getExtraCode("")))
          {
            aMethod.setIsImplemented(true);
          }
          uClass.addMethod(aMethod);
        }
      }
    }
  }


  /**
   * Used to determine if a method is a contructor or a getter/setter.
   * 
   * @param uClass The Umple class for which the method is contained.
   * @param aMethod The method which is contained within the Umple class.
   * 
   * @return True if the method is a constructor, getter/setter, false otherwise.
   */
  @umplesourcefile(line={1038},file={"UmpleInternalParser_CodeClass.ump"},javaline={2245},length={33})
   private boolean verifyIfMethodIsConstructorOrGetSet(UmpleClass uClass, Method aMethod){
    String methodName = aMethod.getName();

    // Have to check for short method names.
    if (methodName.length() >= 3)
    {
      //1. Verify if method to be added is a setter or a getter
      String accessorName = methodName.substring(0,3);
      if ((accessorName.equals("get") && aMethod.numberOfMethodParameters()==0) || (accessorName.equals("set")&& aMethod.numberOfMethodParameters()==1))
      {
        String possibleAttributeName =   methodName.substring(3,methodName.length()).toLowerCase();
        Attribute attr = uClass.getAttribute(possibleAttributeName);
        if (attr != null && !"internal".equals(attr.getModifier()))
        {
          return false;
        }
      }
      //2. Verify if method to be added is a constructor
      if (aMethod.getType().equals("public"))
      {
        uClass.appendExtraCode(aMethod.toString());
        return false;
      }  
      //3. Verify if method from interface is already part of the Class extracode
      String match = "public " + aMethod.getType() + " " + aMethod.getName();    
      if (uClass.getExtraCode().contains(match))
      {
        return false;
      }
    }

    return true;
  }

  @umplesourcefile(line={1073},file={"UmpleInternalParser_CodeClass.ump"},javaline={2289},length={110})
   private void checkDuplicateAssociationNames(){
    for(UmpleClass C : model.getUmpleClasses())
    {
      // Create the list of attribute names (for issue 272)
      List<String> existingAttributeNames = new ArrayList<String>();
      for (Attribute attr : C.getAttributes())
      {
              existingAttributeNames.add(attr.getName());
      }
      
      Boolean roleMatchesClassName, hasMultipleAssocToSameClass;
      List<String> classesWithAssociationsToCurrClass = new ArrayList<String>();
      List<String> roleNameSameAsClassName = new ArrayList<String>();
      List<String> existingNames = new ArrayList<String>();
      List<Association> visitedAssociations = new ArrayList<Association>();
      for(Association assoc : C.getAssociations())
      {  
       roleMatchesClassName = false;
       hasMultipleAssocToSameClass = false;
       
        if (visitedAssociations.contains(assoc))
        {
          continue;
        }
        
        AssociationEnd firstEnd = assoc.getEnd(0);
        AssociationEnd secondEnd = assoc.getEnd(1);  
        
        Boolean checkFirstEnd = !firstEnd.getClassName().equals(C.getName());
        Boolean checkSecondEnd = !secondEnd.getClassName().equals(C.getName());
        Boolean associationIsReflexive = !checkFirstEnd && !checkSecondEnd;
        
        //issue 288: firstEnd of association does not indicate current (this) class being analyzed.
        //If association is NOT reflexive, must check the differing class.  Check if role name
        //matches class name, but only if it is a user entered role name.  Current class must
        //also have multiple associations to the same class to cause java compile errors.  
        if(!associationIsReflexive && C.numberOfAssociations() > 1)
        { 
          //check the differing class
          if(checkFirstEnd)
          {
            if(roleNameSameAsClassName.contains(firstEnd.getClassName().toLowerCase()))
            {
              hasMultipleAssocToSameClass = true;   //flag error 19
            }
            //is a user-defined role name and rolename matches class name
            else if(firstEnd.getRoleName().toLowerCase().equals(firstEnd.getClassName().toLowerCase()) && !firstEnd.getIsDefaultRoleName())
            {    
              roleNameSameAsClassName.add(firstEnd.getRoleName().toLowerCase());
            }
            
            classesWithAssociationsToCurrClass.add(firstEnd.getClassName());
          }
          //check the differing class
          if(checkSecondEnd)
          {
            if(roleNameSameAsClassName.contains(secondEnd.getClassName().toLowerCase()))
            {
              hasMultipleAssocToSameClass = true;  //flag error 19
            }
            //is a user-defined role name and rolename matches class name
            else if(secondEnd.getRoleName().toLowerCase().equals(secondEnd.getClassName().toLowerCase()) && !secondEnd.getIsDefaultRoleName())
            {    
              roleNameSameAsClassName.add(secondEnd.getRoleName().toLowerCase());
            }
            
            classesWithAssociationsToCurrClass.add(secondEnd.getClassName());          
          }
        }

        // check names on other-class end of associations to other classes
        if ((checkFirstEnd || associationIsReflexive) && assoc.getIsLeftNavigable())
        { 
          if (existingNames.contains(firstEnd.getRoleName()) || hasMultipleAssocToSameClass)
          {
            getParseResult().addErrorMessage(new ErrorMessage(19,assoc.getTokenPosition(),C.getName(),firstEnd.getRoleName()));
          }
          else if (existingAttributeNames.contains(firstEnd.getRoleName()))
          {  // Check if the association name is the same as an attribute name
             getParseResult().addErrorMessage(new ErrorMessage(23,assoc.getTokenPosition(),C.getName(),firstEnd.getRoleName()));
          }
          else
          {
            existingNames.add(firstEnd.getRoleName());
          }
        }
        if ((checkSecondEnd || associationIsReflexive) && assoc.getIsRightNavigable())
        {
          if (existingNames.contains(secondEnd.getRoleName()) || hasMultipleAssocToSameClass)
          {
            getParseResult().addErrorMessage(new ErrorMessage(19,assoc.getTokenPosition(),C.getName(),secondEnd.getRoleName()));
          }
          else if (existingAttributeNames.contains(secondEnd.getRoleName()))
          {  // Check if the association name is the same as an attribute name
             getParseResult().addErrorMessage(new ErrorMessage(23,assoc.getTokenPosition(),C.getName(),secondEnd.getRoleName()));
          }
          else
          {
            existingNames.add(secondEnd.getRoleName());
          }
        }
        
        if (associationIsReflexive)
        { 
          // The UmpleClass is only expected to have duplicate references to reflexive associations
          visitedAssociations.add(assoc);
        }
      }
    }
  }

  @umplesourcefile(line={1185},file={"UmpleInternalParser_CodeClass.ump"},javaline={2401},length={36})
   private void checkSingletonAssociations(){
    for (Association association : model.getAssociations()) 
    {  
      if (associationIsBetweenClassAndInterface (association)){continue;}  
      
      AssociationEnd myEnd = association.getEnd(0);
      AssociationEnd yourEnd = association.getEnd(1);

      UmpleClass myClass = model.getUmpleClass(myEnd.getClassName());
      UmpleClass yourClass = model.getUmpleClass(yourEnd.getClassName());

      if (myClass.getIsSingleton() && (yourEnd.getMultiplicity().getRangeParts()[0].equals("1") && yourEnd.getMultiplicity().getRangeParts()[1].equals("1"))) 
      {
        yourEnd.getMultiplicity().setRange("0", "1");
        yourEnd.getMultiplicity().setBound(null);
        setFailedPosition(association.getTokenPosition(), 2, association.getName());  
      }

      if (yourClass.getIsSingleton() && (myEnd.getMultiplicity().getRangeParts()[0].equals("1") && myEnd.getMultiplicity().getRangeParts()[1].equals("1"))) 
      {
        myEnd.getMultiplicity().setRange("0", "1");
        myEnd.getMultiplicity().setBound(null);
        setFailedPosition(association.getTokenPosition(), 2, association.getName());
      }

      if(myClass.getIsSingleton() && (myEnd.getMultiplicity().getUpperBound() < 0 || myEnd.getMultiplicity().getUpperBound() > 1)) 
      {
        setFailedPosition(association.getTokenPosition(), 10, myEnd.getClassName());
      }

      if(yourClass.getIsSingleton() && (yourEnd.getMultiplicity().getUpperBound() < 0 || yourEnd.getMultiplicity().getUpperBound() > 1)) 
      {
        setFailedPosition(association.getTokenPosition(), 10, yourEnd.getClassName());
      }
    }
  }

  @umplesourcefile(line={1223},file={"UmpleInternalParser_CodeClass.ump"},javaline={2439},length={59})
   private void addUnlinkedAssociations(){
    for (Association association : unlinkedAssociations)
    {         
      if (associationIsBetweenClassAndInterface (association)){continue;}  
      
      AssociationEnd myEnd = association.getEnd(0);
      AssociationEnd yourEnd = association.getEnd(1);

      UmpleClass myClass = model.getUmpleClass(myEnd.getClassName());
      UmpleClass yourClass = model.getUmpleClass(yourEnd.getClassName());
      
      AssociationVariable myAs = new AssociationVariable(myEnd.getRoleName(),myEnd.getClassName(),myEnd.getModifier(),null,myEnd.getMultiplicity(),association.getIsLeftNavigable());
      AssociationVariable yourAs = new AssociationVariable(yourEnd.getRoleName(),yourEnd.getClassName(),yourEnd.getModifier(),null,yourEnd.getMultiplicity(),association.getIsRightNavigable());
      myAs.setRelatedAssociation(yourAs);
      
      if(!"".equals(myEnd.getPriority())) { myAs.setPriority(myEnd.getPriority()); }
      if(!"".equals(yourEnd.getPriority())) { yourAs.setPriority(yourEnd.getPriority()); }
      
      if (association.isImmutable())
      {
        boolean set = myAs.setImmutable();
        if (set) { yourAs.setImmutable(); }
        else
        {
          setFailedPosition(association.getTokenPosition(),17);
        }
      }
      
      boolean added = myClass.addAssociationVariable(yourAs);
      if (!added)
      {
        if (myClass.isImmutable()) { setFailedPosition(association.getTokenPosition(),17); }
        else { setFailedPosition(association.getTokenPosition(),13); }
        return;
      }
      myClass.addAssociation(association);

      added = yourClass.addAssociationVariable(myAs);
      if (!added)
      {
        if (myClass == yourClass) { setFailedPosition(association.getTokenPosition(),18); }
        else { setFailedPosition(association.getTokenPosition(),13); }
        return;
      }
      
      yourClass.addAssociation(association);

      if (myAs.getIsNavigable())
      {
        yourClass.addReferencedPackage(myClass.getPackageName());
      }

      if (yourAs.getIsNavigable())
      {
        myClass.addReferencedPackage(yourClass.getPackageName());
      }      

    }
  }

  @umplesourcefile(line={1284},file={"UmpleInternalParser_CodeClass.ump"},javaline={2500},length={94})
   private void checkSortedAssociations(){
    for (Association association : model.getAssociations()) 
    {
      if (associationIsBetweenClassAndInterface (association)){continue;}
      AssociationEnd myEnd = association.getEnd(0);
      AssociationEnd yourEnd = association.getEnd(1);

      UmpleClass myClass = model.getUmpleClass(myEnd.getClassName());
      UmpleClass yourClass = model.getUmpleClass(yourEnd.getClassName());

      String value;

      if(!"".equals(yourEnd.getPriority())){
        Attribute temp = yourClass.getAttribute(yourEnd.getPriority());
        if(temp != null)
        {
          if(Pattern.matches("Integer|Short|Long|Float|Double|String", temp.getType())) 
          {
            String attributeType = yourClass.getName();
            String priorityType = temp.getType();
            String sortedName = yourEnd.getPriority().substring(0,1).toUpperCase() + yourEnd.getPriority().substring(1);
            String php_codeblock = 
                "\n      function($x, $y)\n"+
                    "      {\n"+
                    "        return $x->get"+ sortedName +"() -\n"+ 
                    "               $y->get"+ sortedName +"();\n"+
                    "      }";  
            String java_codeblock = 
                "\n      new Comparator<" + attributeType +">(){\n"+
                    "        @Override\n"+
                    "        public int compare("+attributeType+" arg0, "+attributeType+" arg1)\n"+ 
                    "        {\n"+
                    "          return (("+priorityType+")arg0.get"+sortedName+"()).compareTo(\n"+
                    "                 (("+priorityType+")arg1.get"+sortedName+"()));\n"+ 
                    "        }\n"+
                    "      }";    

            Attribute priority = new Attribute(yourEnd.getRoleName()+"Priority","Comparator<" + attributeType +">", "", "", false, yourClass);
            CodeBlock cb = new CodeBlock();
            cb.setCode("Php", php_codeblock);
            cb.setCode("Java", java_codeblock);
            cb.setCode("Ruby", "\"\"");
            priority.setCodeblock(cb); 
            myClass.addAttribute(priority);

          } 
          else
            setFailedPosition(association.getTokenPosition(), 24, yourEnd.getPriority(), myClass.getName());
        }
        else
          setFailedPosition(association.getTokenPosition(), 25, yourClass.getName(), yourEnd.getPriority());
      }

      if(!"".equals(myEnd.getPriority())){
        Attribute temp = myClass.getAttribute(myEnd.getPriority());
        if(temp != null)
        {
          if(Pattern.matches("Integer|Short|Long|Float|Double|String", temp.getType()))
          {
            String attributeType = myClass.getName() ;
            String priorityType = temp.getType();
            String sortedName = myEnd.getPriority().substring(0,1).toUpperCase() + myEnd.getPriority().substring(1);
            String php_codeblock = 
                "\n      function($x, $y)\n"+
                    "      {\n"+
                    "        return $x->get"+ sortedName +"() -\n"+ 
                    "               $y->get"+ sortedName +"();\n"+
                    "      }";  
            String java_codeblock = 
                "\n      new Comparator<" + attributeType +">(){\n"+
                    "        @Override\n"+
                    "        public int compare("+attributeType+" arg0, "+attributeType +" arg1)\n"+ 
                    "        {\n"+
                    "          return (("+priorityType+")arg0.get"+sortedName+"()).compareTo(\n"+
                    "                 (("+priorityType+")arg1.get"+sortedName+"()));\n"+ 
                    "        }\n"+
                    "      }";    

            Attribute priority = new Attribute(myEnd.getRoleName()+"Priority","Comparator<" + attributeType +">", "", "", false, myClass);
            CodeBlock cb = new CodeBlock();
            cb.setCode("Php", php_codeblock);
            cb.setCode("Java", java_codeblock);
            cb.setCode("Ruby", "\"\"");
            priority.setCodeblock(cb); 
            yourClass.addAttribute(priority);
          }  
          else
            setFailedPosition(association.getTokenPosition(), 24, myEnd.getPriority(), yourClass.getName());
        }
        else
          setFailedPosition(association.getTokenPosition(), 25, myClass.getName(), myEnd.getPriority());
      }
    }
  }

  @umplesourcefile(line={1380},file={"UmpleInternalParser_CodeClass.ump"},javaline={2596},length={10})
   private void checkClassInterfaceAssocations(){
    for (Association a : model.getAssociations()){
      if (associationIsBetweenClassAndInterface(a)){
        boolean hasCorrectArrow = !a.getIsLeftNavigable()&&a.getIsRightNavigable(); // Assocation has "->" arrow
        if (!hasCorrectArrow){
          setFailedPosition(a.getTokenPosition(), 20, a.getEnd(0).getClassName());
        }
      }
    }
  }


  /**
   * Analyzes a token flagged to be a method in which case the data that makes up the method will be populated into a
   * method instance and added to an Umple element (which could be an Umple class).
   * 
   * @param method The token flagged to be the method.
   * @param uElement The Umple element for which the method will be added.
   */
  @umplesourcefile(line={1398},file={"UmpleInternalParser_CodeClass.ump"},javaline={2608},length={124})
   private void analyzeMethod(Token method, UmpleElement uElement){
    String modifier = "";
    Method aMethod = new Method("","","",false);

    // Set method position
    aMethod.setPosition(method.getPosition());
    aMethod.setEndPosition(method.getEndPosition());
  
    // Add comments above the method to the method.
    for (Comment c : lastComments)
    {
      aMethod.addComment(c);
    }

    // Go through all the sub tokens of the "method token" to obtain details about it, using them to populate a method instance.
    List<String> langs = new ArrayList<String>();
    CodeBlock cb = new CodeBlock("");
    boolean canClear = false;
    for(Token token : method.getSubTokens())
    {
      if (token.is("modifier"))
      {
        modifier += " " + (token.getValue());
        aMethod.setModifier(modifier);
      }
      else if(token.is("abstract")) {
        boolean wasSet = aMethod.setIsAbstract(true);

        // Ensure the value was set.
        if (wasSet == false)
        {
          setFailedPosition(token.getPosition(), 0, "Unable to make method abstract!");
        }
      }
      else if(token.is("static"))
      {
        modifier += " static ";
        aMethod.setModifier(modifier);
      }
      else if (token.is("type"))
      {
        aMethod.setType(token.getValue());
      }
      else if (token.is("list"))
      {
        aMethod.setType(aMethod.getType()+"[]");
      }
      else if (token.is("methodDeclarator"))
      {
        analyzeMethodDeclarator(token, uElement, aMethod);
      }
      else if (token.is("code"))
      {        
        if(langs.isEmpty())
        {
          cb.setCode(token.getValue());
        }  
        else
        {
          for(String str: langs)
          {
            cb.setCode(str,(cb.getCode(str)!=null?cb.getCode(str)+"\n":"")+token.getValue());
          }
        }
        canClear = true;
      }
      else if (token.is("codeLang"))
      {
        if(canClear)
        {
          langs.clear();
          canClear = false;
        }
        langs.add(token.getValue());
      }
      else if (token.is("precondition")){ 
        if (uElement instanceof UmpleClass){
          analyzePrecondition(token, (UmpleClass) uElement, aMethod);
        }  
      }
      else if (token.is("postcondition")){ 
        if (uElement instanceof UmpleClass){
          analyzePostcondition(token, (UmpleClass) uElement, aMethod);
        }  
      }
    }
    MethodBody meth = new MethodBody(cb);
    aMethod.setMethodBody(meth);

    // Handle Class/Interface Modifications
    if (uElement instanceof UmpleClass)
    {
      UmpleClass uClass = (UmpleClass) uElement;
      
      // Add Getter/Setter/Constructor to Class
      boolean shouldAddMethod = verifyIfMethodIsConstructorOrGetSet(uClass, aMethod);
      if (!uClass.hasMethod(aMethod) && shouldAddMethod)
      {
        uClass.addMethod(aMethod); 
      } 

      // Make class abstract if an abstract method was added
      if(uClass.hasMethod(aMethod) && aMethod.getIsAbstract()) 
      {
        uClass.setIsAbstract(true);
        uClass.addUnimplementedMethod(aMethod);
      }

      // If method not added to class, add it to list of
      // unimplemented methods
      if(!uClass.hasMethod(aMethod)) 
      {
        uClass.addUnimplementedMethod(aMethod);
      }
    }
    else if (uElement instanceof UmpleInterface)
    {
      UmpleInterface uInterface = (UmpleInterface) uElement;
      if (!uInterface.hasMethod(aMethod))
      {
        uInterface.addMethod(aMethod); 
      }
    }
  }


  /**
   * Analyzes a method header, from a token flagged to be one, to populate a method instance for things such as the
   * method name, type and parameters.
   * 
   * @param token The token flagged to be a method header.
   * @param aMethod The method to be populated from the analysis of the token.
   */
  @umplesourcefile(line={1531},file={"UmpleInternalParser_CodeClass.ump"},javaline={2742},length={38})
   private void analyzeMethodDeclarator(Token token, UmpleElement uElement, Method aMethod){
    // Go through all sub tokens of the method token to obtain data such as the methods name, parameters etc and add them to the method.
    for(Token methodToken : token.getSubTokens())
    {
      if (methodToken.is("methodName"))
      {
        aMethod.setName(methodToken.getValue());
        if (methodToken.getValue().equals("main"))
        {
          uElement.setHasMainMethod(true);
        }
      }
      if (methodToken.is("parameterList"))
      {
        for(Token parameterToken : methodToken.getSubTokens())
        {
          boolean isList = false;
          if (parameterToken.is("parameter"))
          {
            String paramType="";
            if (parameterToken.getSubToken("type") != null)
            {
              paramType = parameterToken.getSubToken("type").getValue();
            }
            if (parameterToken.getSubToken("list") != null)
            {
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


  /**
   * Analyzes a constant, from a token flagged to be one, to add a constant instance to an Umple element.
   * 
   * @param constantToken The token flagged to be a constant.
   * @param uElement The Umple element for which a new constant will be added (populated from analysis of the token).
   */
  @umplesourcefile(line={1577},file={"UmpleInternalParser_CodeClass.ump"},javaline={2790},length={48})
   private void analyzeConstant(Token constantToken, UmpleElement uElement){
    Constant aConstant = new Constant("","","","");
    String modifier = "";
    boolean validName = Token.isValidIdentifier(constantToken.getValue("name"));
    boolean properName = Token.isValidIdentifier(constantToken.getValue("name"), "[A-Z]");

    if(validName != true){
      setFailedPosition(constantToken.getPosition(), 160, constantToken.getValue("name"));
      return;
    }
    if(properName != true){
      setFailedPosition(constantToken.getPosition(), 161, constantToken.getValue("name"));
    }

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

  @umplesourcefile(line={1627},file={"UmpleInternalParser_CodeClass.ump"},javaline={2847},length={8})
   private void analyzeInjectionCode(Token injectToken, UmpleClass aClass){
    String type = injectToken.is("beforeCode") ? "before" : "after";    
    CodeBlock cb = new CodeBlock();
    CodeInjection injection = new CodeInjection(type,injectToken.getValue("operationName"),"",aClass);
    makeCodeInject(injectToken,injection,cb,aClass);
    injection.setSnippet(cb);
    aClass.addCodeInjection(injection);
  }

  @umplesourcefile(line={1637},file={"UmpleInternalParser_CodeClass.ump"},javaline={2857},length={30})
   private void makeCodeInject(Token injectToken, CodeInjection injection, CodeBlock cb, UmpleClass aClass){
    List<String> langs = new ArrayList<String>();
    for(Token sub: injectToken.getSubTokens())
    {
      if(sub.is("codeLang"))
      {
        langs.add(sub.getValue());
      }
      if(sub.is("code"))
      {          
        if(langs.size()==0)
        {
          cb.setCode(sub.getValue());
        }
        else
        {
          for(String lang:langs)
            {
            cb.setCode(lang,sub.getValue());
            }
        }
        langs.clear();      
      }
      if(sub.is("codeInject"))
      {
        makeCodeInject(sub,injection, cb , aClass);
      }
    }    
    injection.setPosition(injectToken.getPosition());
  }

  @umplesourcefile(line={1670},file={"UmpleInternalParser_CodeClass.ump"},javaline={2889},length={89})
   private void analyzeKey(Token keyToken, UmpleClass aClass){
    if (aClass.getKey().isProvided())
    {
      setFailedPosition(keyToken.getPosition(), 7, keyToken.getParentToken().getValue("name"));
    }

    if (keyToken.is("defaultKey"))
    {
      aClass.getKey().setIsDefault(true);
      return;
    }

    List<String> tokensAdded = new ArrayList<String>();
    Boolean tokenMatch;
    for(Token token : keyToken.getSubTokens())
    {
      tokenMatch = false;
      
      if (!token.is("keyId"))
      {
        continue;
      }
 
      //Checks for duplicate attributes/associations/stateMachines
      if(tokensAdded.contains(token.getValue()))
      {
        setFailedPosition(keyToken.getPosition(), 26, token.getValue(), keyToken.getParentToken().getValue("name"));
      }
   
    if(!aClass.hasAttributes() && !aClass.hasAssociations() && !aClass.hasStateMachines())
      {
        setFailedPosition(keyToken.getPosition(), 27, token.getValue(), keyToken.getParentToken().getValue("name"));
      }
      else{
        if(aClass.hasAttributes())
        {
          for(Attribute aAttribute : aClass.getAttributes())
          {
            if(aAttribute.getName().equals(token.getValue()))
            {
              tokenMatch = true;
              // throw warning if attribute is initialized
              if(aAttribute.getValue() != null)
              {
                setFailedPosition(keyToken.getPosition(), 45, aAttribute.getName(), aClass.getName());
              }
            }
          }
        }
      
        if(aClass.hasAssociations())
        {
          AssociationEnd firstEnd, secondEnd;
          String firstEndName, secondEndName;
    
          for(Association aAssociation : aClass.getAssociations())
          { 
            firstEnd = aAssociation.getEnd(0);
            secondEnd = aAssociation.getEnd(1);
            firstEndName =  firstEnd.getRoleName();
            secondEndName = secondEnd.getRoleName();        
                      
            if(firstEndName.equals(token.getValue()) || secondEndName.equals(token.getValue()))
            {
              tokenMatch = true;
            }
          }
        }  

        if(aClass.hasStateMachines())  
        {
        for(StateMachine aStateMachine : aClass.getStateMachines())
        {
          if(aStateMachine.getName().equals(token.getValue()))
          {
            tokenMatch = true;
          }      
        }
      }      

      if(!tokenMatch)
      {
        setFailedPosition(keyToken.getPosition(), 27, token.getValue(), keyToken.getParentToken().getValue("name"));
      }
    }
      aClass.getKey().addMember(token.getValue());
      tokensAdded.add(token.getValue()); 
    }
  }

  @umplesourcefile(line={1761},file={"UmpleInternalParser_CodeClass.ump"},javaline={2980},length={22})
   private void analyzeSymmetricReflexiveAssociation(Token symmetricReflexiveAssociationToken, UmpleClass aClass){
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
    
    AssociationEnd leftEnd = new AssociationEnd(null,myType,myModifier,myType,myMult);
    AssociationEnd rightEnd = new AssociationEnd(myName,myType,myModifier,myType,myMult);
    Association assoc = new Association(false, true, leftEnd, rightEnd);
    aClass.addAssociation(assoc);
  }

  @umplesourcefile(line={1785},file={"UmpleInternalParser_CodeClass.ump"},javaline={3004},length={12})
   private Association createAssociation(String navigation, AssociationEnd firstEnd, AssociationEnd secondEnd){
    Association association;
    if(navigation != null){
      boolean isNavigable = "--".equals(navigation);
      boolean isFirstNavigable = "<-".equals(navigation) || isNavigable;
      boolean isSecondNavigable = "->".equals(navigation) || isNavigable;
      association = new Association(isFirstNavigable,isSecondNavigable,firstEnd,secondEnd);
    }else{
      association = new Association(true, true, firstEnd, secondEnd);
    }
    return association;
  }

  @umplesourcefile(line={1799},file={"UmpleInternalParser_CodeClass.ump"},javaline={3018},length={103})
   private Association analyzeAssociation(Token associationToken, String defaultMyType){
    Token parentToken = associationToken.getParentToken();
    Token gParentToken = parentToken.getParentToken();
    boolean isAssociationClass = parentToken.is("associationClassDefinition") || gParentToken.is("associationClassDefinition");
    boolean isSingleAssociationEnd = associationToken.is("singleAssociationEnd");
    boolean isInlineAssociation = associationToken.is("inlineAssociation");
    Token myEndToken = null;
    Token yourEndToken = null;
    String navigation = null;
    String associationModifier = null;
    String name = null;

    //Issue 213/131: associations can be inside AssociationClasses, but
    //inline associations inside associationClasses are treated just like in regular classes
    if(isAssociationClass && !isInlineAssociation){
        if(isSingleAssociationEnd){
            myEndToken = parentToken;
            associationModifier = associationToken.getValue("modifier");
            navigation = null;
            name = parentToken.getValue("name");

        }else{ //association inside associationClass
            myEndToken = parentToken.getParentToken();
            associationModifier = parentToken.getValue("modifier");
            navigation = parentToken.getValue("arrow");
            name = gParentToken.getValue("name");
        }
        yourEndToken = associationToken;
    }else{//inline association or external "association{..}" block
        name = parentToken.getValue("name");
        int myMultOffset = 0;
        int yourMultOffset = 2;
        Token associationModifierToken = associationToken.getSubToken("modifier");
        if (associationModifierToken != null){
          associationModifier = associationModifierToken.getValue();
          myMultOffset++;
          yourMultOffset++;
        }
        myEndToken = associationToken.getSubToken(myMultOffset);
        navigation = associationToken.getValue("arrow");
        yourEndToken = associationToken.getSubToken(yourMultOffset);
    }
    AssociationEnd firstEnd = createPreliminaryAssociationEnd(myEndToken, defaultMyType);
    AssociationEnd secondEnd = createPreliminaryAssociationEnd(yourEndToken, defaultMyType);
    if(firstEnd == null || secondEnd == null){
        setFailedPosition(associationToken.getPosition(), 8, name);
        return null;
    }
    String myType = firstEnd.getClassName();
    String myRoleName = firstEnd.getRoleName();
    String yourType = secondEnd.getClassName();
    String yourRoleName = secondEnd.getRoleName();
    Multiplicity myMult = firstEnd.getMultiplicity();
    Multiplicity yourMult = secondEnd.getMultiplicity();

    if("".equals(firstEnd.getClassName())){
        firstEnd.setClassName(defaultMyType);
    }
    firstEnd.setReferenceToClassName(yourType);
    secondEnd.setReferenceToClassName(myType);
    //Association Classes have Mutiplicities switched between ends: an association
    //between A and B in associationClass C becomes A -- C and B -- C
    if(isAssociationClass){
        firstEnd.setMultiplicity(secondEnd.getMultiplicity());
        secondEnd.setMultiplicity(myMult);
    }
    updateAssociationEnds(firstEnd,secondEnd);

    // Trap cases where both ends are the same class (reflexive) and 
    // there is no or same role name and same multiplicity. Fixes issue 295
    if(myType.equals(yourType) && ((myRoleName == null && yourRoleName == null) || (myRoleName != null && yourRoleName != null && myRoleName.equals(yourRoleName))) && myMult.toString().equals(yourMult.toString())) {
      setFailedPosition(associationToken.getPosition(), 21, myType);
      return null;
    }
  
    if (firstEnd.getRoleName().equals(secondEnd.getRoleName()) && firstEnd.getClassName().equals(secondEnd.getClassName())){
      setFailedPosition(associationToken.getPosition(), 32, firstEnd.getRoleName());
      return null;
    }  
  
    Association association = createAssociation(navigation,firstEnd,secondEnd);
    
    if (associationModifier != null && "immutable".equals(associationModifier)){
      association.setImmutable();
    }
    association.setTokenPosition(associationToken.getPosition());
    association.setTokenEndPosition(associationToken.getEndPosition());
    
    if (!association.isValid()){
      Token atFaultToken = association.whoIsInvalid() == 0 ? myEndToken : yourEndToken;
      String invalidBound = atFaultToken.getValue("bound") == null ? invalidBound = atFaultToken.getValue("lowerBound") + ".." + atFaultToken.getValue("upperBound") : atFaultToken.getValue("bound");
      setFailedPosition(atFaultToken.getPosition(), 9, invalidBound);
      return null;
    }
    model.addAssociation(association);
    if(!isInlineAssociation){ unlinkedAssociations.add(association); }
    
    //check for non-constraint side warning per issue347
    if(isInlineAssociation || !isAssociationClass){
      analyzeNonconstraintAssociationEndForWarning(associationToken, firstEnd, secondEnd);
    }
    return association;
  }


  /**
   * Given a [[associationEnd]], [[singleAssociationEnd]], [[inlineAssociationEnd]] or 
   * a [[associationClassDefinition]] token, creates a
   * preliminary AssociationEnd object to help in the creation of an Association object.
   * The resulting object will have to be completed with setReferenceToClassName()depending on the type of association.
   * @return an AssociationEnd object or null if an error occured
   */
  @umplesourcefile(line={1911},file={"UmpleInternalParser_CodeClass.ump"},javaline={3123},length={47})
   private AssociationEnd createPreliminaryAssociationEnd(Token associationEndToken, String defaultType){
    if(associationEndToken != null){
      String name, type, modifier, roleName, bound, lowerBound, upperBound, priority;
      bound = lowerBound = upperBound = priority = roleName = null;
      Multiplicity mult = new Multiplicity();
      String typeIndex;

      //special case when [[singleAssociationEnd]] is used in one end: the 
      //parent associationClassDefinition is used as the other
      if(associationEndToken.is("associationClassDefinition")){
        name = null;
        type = associationEndToken.getValue("name");
        modifier = null;
        mult.setRange("1","1");
        typeIndex = "name";
      }else{
        type = associationEndToken.getValue("type");
        modifier = associationEndToken.getValue("modifier");
        roleName = associationEndToken.getValue("roleName");
        bound = associationEndToken.getValue("bound");
        lowerBound = associationEndToken.getValue("lowerBound");
        upperBound = associationEndToken.getValue("upperBound");
        priority = associationEndToken.getValue("priority");
        mult.setRange(lowerBound, upperBound);
        mult.setBound(bound);
        typeIndex = "type";
      }
      // Report an error if the multiplicity is invalid
      if (!mult.isValid()){
        String invalidBound = bound == null ? lowerBound + ".." + upperBound : bound;
        setFailedPosition(associationEndToken.getPosition(), 4, invalidBound);
        return null;
      }
      if(type == null){
          type = defaultType;
      }
      AssociationEnd assocEnd = new AssociationEnd(roleName,type,modifier,null,mult);

      if(priority != null){
          assocEnd.setPriority(priority);
      }
      positionToClassNameReference.put(associationEndToken.getPosition(typeIndex),type);
      return assocEnd;
    }else{
        return null;
    }
  }

  @umplesourcefile(line={1959},file={"UmpleInternalParser_CodeClass.ump"},javaline={3180},length={17})
   private void updateAssociationEnds(AssociationEnd firstEnd, AssociationEnd secondEnd){
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


  /**
   * Analyzes a token flagged to be an association within an Umple class to create an instance of one and add it to the class.
   * 
   * @param inlineAssociationToken The token flagged to be an inline association.
   * @param aClass The Umple class for which an association instance will be added (populated from analysis of the token).
   */
  @umplesourcefile(line={1985},file={"UmpleInternalParser_CodeClass.ump"},javaline={3199},length={56})
   private void analyzeinlineAssociation(Token inlineAssociationToken, UmpleClass aClass){
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
    
    if(!"".equals(myEnd.getPriority())) { myAs.setPriority(myEnd.getPriority()); }
    if(!"".equals(yourEnd.getPriority())) { yourAs.setPriority(yourEnd.getPriority()); }
    
    if (association.isImmutable())
    {
      boolean set = myAs.setImmutable();
      if (set)
      {
        yourAs.setImmutable();
      }
      else
      {
        setFailedPosition(inlineAssociationToken.getPosition(),17);
      }
    }

    // Add comments above the association to the association.
    for (Comment c : lastComments)
    {
      yourAs.addComment(c);
    }
    
    // set last association made to be yourAs. clear lastattr.
    lastassoc = yourAs;
    lastassocPosition = inlineAssociationToken.getPosition();
    lastattr = null;
    

    boolean added = aClass.addAssociationVariable(yourAs);
    if (added)
    {
      unlinkedAssociationVariables.add(yourAs);
      aClass.addAssociation(association);
    }
    else
    {
      if (aClass.isImmutable()) { setFailedPosition(inlineAssociationToken.getPosition(),17); }
      
      else { setFailedPosition(inlineAssociationToken.getPosition(),13); }
    }
  }


  /**
   * Set warning if non-constraint side of association is not many(*) or optional(0..1) association type per issue 347
   * 
   * @param Token The token is either inlineAssociationToken or associationDefinationToken.
   * @param AssociationEnd the first associationEnd.
   * @param AssociationEnd the second associationEnd.
   */
  @umplesourcefile(line={2050},file={"UmpleInternalParser_CodeClass.ump"},javaline={3264},length={44})
   private void analyzeNonconstraintAssociationEndForWarning(Token associationToken, AssociationEnd myEnd, AssociationEnd yourEnd){
    AssociationEnd nonConstraintEnd = null;
    boolean isUnidirection = true;
    
    //manual check as getIsLeftNavigatable() applies for "--" as well
    Token arrowToken = associationToken.getSubToken("arrow");
    boolean isLeftArrow = arrowToken.getValue().equals("<-");
    boolean isRightArrow = arrowToken.getValue().equals("->");
    
    //determine the non-arrow side
    if(isLeftArrow)
    {
      nonConstraintEnd = yourEnd;
    }
    else if(isRightArrow)
    {
      nonConstraintEnd = myEnd;
    }
    else
    {
      isUnidirection = false;
    }
    
    if(isUnidirection)
    {
      String nonConstraintEndLower = nonConstraintEnd.getLowerBoundString();
      String nonConstraintEndUpper = nonConstraintEnd.getUpperBoundString();
        
      //only allow optional and many constraint on non-arrow side
      boolean isMany = (nonConstraintEndLower.equals("0")) && (nonConstraintEndUpper.equals("*"));
      boolean isOptional = (nonConstraintEndLower.equals("0")) && (nonConstraintEndUpper.equals("1"));
        
      if(!isMany && !isOptional)
      {
        String bound = "";
        //case of mandatory constraint
    	if(nonConstraintEndLower.equals(nonConstraintEndUpper))
    		bound = nonConstraintEndLower;
    	else	
    		bound = "[" +nonConstraintEndLower+", "+nonConstraintEndUpper+"]";
        setFailedPosition(associationToken.getPosition(), 36, bound);
      }
    }
  }


  /**
   * Analyzes a token flagged to be an attribute within an Umple class to create an instance of one and add it to the class.
   * 
   * @param attributeToken The token flagged to be an attribute.
   * @param aClass The Umple class for which an attribute instance will be added (populated from analysis of the token).
   */
  @umplesourcefile(line={2102},file={"UmpleInternalParser_CodeClass.ump"},javaline={3318},length={175})
   private void analyzeAttribute(Token attributeToken, UmpleClass aClass){
    boolean isAutounique = attributeToken.getValue("autounique") != null;
    boolean isUnique = attributeToken.getValue("unique") != null;
    boolean isLazy = attributeToken.getValue("lazy") != null;
    boolean isConstant = "const".equals(attributeToken.getValue("modifier"));
    boolean validName = Token.isValidIdentifier(attributeToken.getValue("name"));
    boolean properName = !Token.isValidIdentifier(attributeToken.getValue("name"), "[A-Z]");
    boolean looksLikeAssociation = attributeToken.getValue("name").contains("--") || attributeToken.getValue("name").contains("->");
    looksLikeAssociation = looksLikeAssociation || attributeToken.getValue("name").contains("<-") || attributeToken.getValue("name").contains("..");
    looksLikeAssociation = looksLikeAssociation || attributeToken.getValue("name").contains("*");
    
    if(!validName)
    {
      if(looksLikeAssociation){
        setFailedPosition(attributeToken.getPosition(), 132, attributeToken.getValue("name"));
      } 
      else if(isConstant){
        setFailedPosition(attributeToken.getPosition(), 160, attributeToken.getValue("name"));
      }
      else {
        setFailedPosition(attributeToken.getPosition(), 130, attributeToken.getValue("name"));
      }
      
      return;
    }
    
    if(!properName && !isConstant){
      setFailedPosition(attributeToken.getPosition(), 131, attributeToken.getValue("name"));
    }
    else if(properName && isConstant){
      setFailedPosition(attributeToken.getPosition(), 161, attributeToken.getValue("name"));
    }
    
    if (aClass.getIsSingleton() && !isLazy) 
    {
      isLazy = true;
      setFailedPosition(attributeToken.getPosition(), 1, attributeToken.getValue("name"));
    }

    if(attributeToken.getValue("modifier") != null)
    {
      if((attributeToken.getValue("modifier").contains("const")) && (attributeToken.getValue("value") == null))
      {
        setFailedPosition(attributeToken.getPosition(), 35, attributeToken.getValue("name"));
      }
     }

    String modifier = attributeToken.getValue("modifier");
    String type = attributeToken.getValue("type");
    String name = attributeToken.getValue("name");
    String value = attributeToken.getValue("value");
    String derivedValue = attributeToken.getValue("code");
    
    // check to see if type has angle brackets <>
    if (type != null)
    {
      int lang_pos = type.lastIndexOf('<');
      int rang_pos = type.lastIndexOf('>');
      if (lang_pos > 0 && rang_pos > 0 && lang_pos < rang_pos)
      {
        setFailedPosition(attributeToken.getPosition(), 46, name, aClass.getName(), type);
      }
    }
    
    if (isLazyRedundant(isLazy, value))
    {
      setFailedPosition(attributeToken.getPosition(), 3, aClass.getName(), name);
    }

    for(Attribute aAttribute : aClass.getAttributes()){
      if (aAttribute.getName().equals(name)){
        setFailedPosition(attributeToken.getPosition(), 22, aClass.getName(), name);
      }
    }
    CodeBlock languageSpecificCode = new CodeBlock();
    if (derivedValue != null)
    {
      value = "";
      List<String> codelangs = new ArrayList<String>();
      for(Token tkn: attributeToken.getSubTokens())
      {
      if(tkn.is("codeLang"))
      {
        codelangs.add(tkn.getValue());
      } else if(tkn.is("code")) {
        if(codelangs.isEmpty())
        {
          languageSpecificCode.setCode(tkn.getValue());
        } else {
          for(String lang: codelangs)
          {
            languageSpecificCode.setCode(lang, tkn.getValue());
          }
          codelangs.clear();
        }
      }
      }
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
    }

    if (isAutounique)
    {
      type = "Integer";
    }

    if(type != null)
    { 
      Matcher m = Pattern.compile("([a-zA-Z_][0-9a-zA-Z_]*(<(.*)>)?)").matcher(type);
      if(!m.matches()) 
      {
        setFailedPosition(attributeToken.getPosition(), 140, type);
        return;
      }
    }
        
    if(type != null && value != null)
    {
      if(!compareTypeToValue(type,value))
      {
        setFailedPosition(attributeToken.getPosition(),141,type,value);  
      }
    }
    else if (type == null && value != null)
    {
      type = inferType(value, type);
    }
    else if(type == null)
    {
      type = "String";
    }

    Attribute attribute = new Attribute(name,type,modifier,value,isAutounique,aClass);
    attribute.setIsUnique(isUnique);
    attribute.setIsLazy(isLazy);
    boolean isList = attributeToken.getValue("list") != null;

    if (name == null)
    {
      String rawName = StringFormatter.toCamelCase(type); 
      name = isList ? model.getGlossary().getPlural(rawName) : rawName;
    }

    if (derivedValue != null)
    {
      attribute.setEndPosition(attributeToken.getEndPosition());
      attribute.setIsDerived(true);
      attribute.setCodeblock(languageSpecificCode);
    }

    // set position regardless of derivedValue    
    attribute.setPosition(attributeToken.getPosition());

    attribute.setIsList(isList);

    // Add comments above the attribute to the attribute.
    for (Comment c : lastComments)
    {
      attribute.addComment(c);
    }
    
    // set the last attribute made to be attribute, clear lastassoc
    lastattr = attribute;
    lastassoc = null;
  }

  @umplesourcefile(line={2281},file={"UmpleInternalParser_CodeClass.ump"},javaline={3502},length={51})
   private String inferType(String value, String type){
    String inferredType;
    if(value.matches("-?[0-9]+\\.[0-9]+"))
    {
      inferredType = "Double";
    }
    else if(value.matches("-?[0-9]+"))
    {
      inferredType = "Integer";
    }
    else if(value.matches("(true|false)"))
    {
      inferredType = "Boolean";
    }
    else if(value.matches("\"\\d{4}-[0-3][0-9]-[0-1][0-9]\""))
    {
      inferredType="Date";
    }
    else if(value.matches("\"[0-2][0-9]:[0-5][0-9]:[0-5][0-9]\""))
    {
      inferredType = "Time";
    }
    else if(value.matches("\".*\""))
    {
      inferredType = "String";
    }
    else if(type == null)
    {
      Matcher m = Pattern.compile("(new\\s+)([a-zA-Z_][0-9a-zA-Z_]*(\\s*<(.*)>)?)(\\s*\\(\\))").matcher(value);
      if(m.matches())        
      {  
        inferredType = m.group(2);
      }
      else
      { 
        //if anything other than the default new X(); one cannot infer the type
        inferredType = "String";
      }
    }
    //worst case scenarios when we can't anticipate what a user will use as value.
    //and to ignore inheritance/polymorphism 
    else if(type != null)
    {
      inferredType = type; 
    }
    else
    {
      inferredType = "String";
    }
    return inferredType;
  }

  @umplesourcefile(line={2334},file={"UmpleInternalParser_CodeClass.ump"},javaline={3555},length={29})
   private boolean compareTypeToValue(String type, String value){
    //cannot infer null
    if(value.equals("null"))
    {
      return true;
    }

    String inferredType = inferType(value,type);   
    if(type.equals("String") && (inferredType.equals("Date") || inferredType.equals("Time")))
    {
      return true;
    }
    else if((type.equals("Float") || type.equals("float") || type.equals("Double") || type.equals("double")) && (inferredType.equals("Integer") || inferredType.equals("Double")))
    {
      return true;
    }
    else if(type.equals("int") && inferredType.equals("Integer"))
    {
      return true;
    }
    else if(type.equals("boolean") && inferredType.equals("Boolean"))
    {
      return true;
    } 
    else
    {
      return inferredType.equals(type);
    }
  }

  @umplesourcefile(line={2365},file={"UmpleInternalParser_CodeClass.ump"},javaline={3586},length={3})
   private Boolean isLazyRedundant(Boolean isLazy, String value){
    return (isLazy && value != null);
  }

  @umplesourcefile(line={2370},file={"UmpleInternalParser_CodeClass.ump"},javaline={3591},length={89})
   private void analyzeException(Token exception, UmpleClass aClass){
    Token sub = exception.getSubToken(0);
    if(sub.is("misnamedAttribute"))
    {
      if(!Token.isValidIdentifier(sub.getValue("name")))
      {
        boolean looksLikeAssociation = sub.getValue("name").contains("--") || sub.getValue("name").contains("->");
        looksLikeAssociation = looksLikeAssociation || sub.getValue("name").contains("<-") || sub.getValue("name").contains("..");
        looksLikeAssociation = looksLikeAssociation || sub.getValue("name").contains("*");
        if(looksLikeAssociation)
        {
          setFailedPosition(sub.getPosition(), 132, sub.getValue("name"));
        }
        else 
        {
          setFailedPosition(sub.getPosition(), 130, sub.getValue("name"));
        }
        return;
      }
      if(Token.isValidIdentifier(sub.getValue("name"), "[A-Z]"))
      {
        setFailedPosition(sub.getPosition(), 131, sub.getValue("name"));
      }
      String type = sub.getValue("type");
      if(type!=null)
      {
        if(!Pattern.matches("([a-z]|[A-Z]|_)(\\d|\\w|<|>|,)*", type))
        {
          setFailedPosition(sub.getPosition(), 140, type);
        }
      }
    }
    else if(sub.is("malformedStatement1")||sub.is("malformedStatement2"))
    {
      String extraCode = "";
      for(Token token:sub.getSubTokens())
      {
        if(token.is("stuff"))
        {
          extraCode += token.getValue()+ " ";
        }
      }
      if(sub.getValue("innerstuff")!=null)
      {
        extraCode += "{"+sub.getValue("innerstuff")+"};";
      }
      else
      {
        extraCode += ";";
      }
      aClass.appendExtraCode("// line " + exception.getPosition().getLineNumber() + " " + exception.getPosition().getRelativePath(aClass, "Java"));
      aClass.appendExtraCode("  "+extraCode+"\n");
      setFailedPosition(sub.getPosition(), 1007, sub.getValue("name"));
    }
    else if(sub.is("malformedStatemachine1")||sub.is("malformedStatemachine2"))
    {
      String extraCode = "";
      for(Token token:sub.getSubTokens())
      {
        if(token.is("stuff"))
        {
          if(!"".equals(token.getValue())&&!token.getValue().contains(" ")&&!Token.isValidIdentifier(token.getValue()))
          {
            setFailedPosition(token.getPosition(), 150, token.getValue("name"));
          }
          extraCode += token.getValue()+ " ";
        }
      }
      extraCode += "\n  {\n    "+sub.getValue("innerstuff")+"\n  }";
      aClass.appendExtraCode("// line " + exception.getPosition().getLineNumber() + " " + exception.getPosition().getRelativePath(aClass, "Java"));
      aClass.appendExtraCode("  "+extraCode+"\n");
      setFailedPosition(sub.getPosition(), 1006, sub.getValue("name"));
    }
    else if(sub.is("malformedMethod"))
    {
      String extraCode = "";
      for(Token token:sub.getSubTokens())
      {
        if(token.is("stuff"))
        {
          extraCode += token.getValue()+ " ";
        }
      }
      extraCode += "\n  {\n    "+sub.getValue("innerstuff")+"\n  }";
      aClass.appendExtraCode("// line " + exception.getPosition().getLineNumber() + " " + exception.getPosition().getRelativePath(aClass, "Java"));
      aClass.appendExtraCode("  "+extraCode+"\n");
      setFailedPosition(sub.getPosition(), 1008, sub.getValue("name"));
    }
  }

  @umplesourcefile(line={2461},file={"UmpleInternalParser_CodeClass.ump"},javaline={3682},length={25})
   private void analyzeExtraCode(Token token, UmpleClass aClass){
    //This is a catch all and will be used less often as the grammar gets updated.
    if(extraCodeIsMalformedStateMachine(token)) setFailedPosition(token.getPosition(), 1006, "");
    //Append #line comment to indicate line and position of source
    if (token.getPosition() != null)
    {
      String extraCodeLineNumberComment = " line " + token.getPosition().getLineNumber() + " " + token.getPosition().getRelativePath(aClass, "Java");
	  String rubyComment = "#" + extraCodeLineNumberComment;
	  String otherComment = "//" + extraCodeLineNumberComment;
 	  if(aClass.hasExtraCode())
	  {
	    rubyComment = System.getProperty("line.separator") + rubyComment;
	    otherComment = System.getProperty("line.separator") + otherComment;
	  }
	  CodeBlock cb = new CodeBlock();
      cb.setCode(otherComment);
      cb.setCode("Ruby", rubyComment);
      aClass.appendExtraCode(true,cb);
      aClass.appendExtraCode("  " + token.getValue());
    }
    else
    {
      aClass.appendExtraCode(token.getValue());
    }
  }

  @umplesourcefile(line={20},file={"UmpleInternalParser_CodeConstraints.ump"},javaline={3709},length={10})
   private void analyzePrecondition(Token preconditionToken, UmpleClass aClass, Method method){
    List<ConstraintVariable> cvs = analyzeConstraint(preconditionToken, aClass); //adds all identifiers to constraints
    Precondition precondition = new Precondition(method);
    
    for(ConstraintVariable cv: cvs)
    {
    	precondition.addExpression(cv);
    }  
    aClass.addPrecondition(precondition);
  }

  @umplesourcefile(line={32},file={"UmpleInternalParser_CodeConstraints.ump"},javaline={3721},length={10})
   private void analyzePostcondition(Token PostconditionToken, UmpleClass aClass, Method method){
    List<ConstraintVariable> cvs = analyzeConstraint(PostconditionToken, aClass); //adds all identifiers to constraints
    Postcondition postcondition = new Postcondition(method);
    
    for(ConstraintVariable cv: cvs)
    {
    	postcondition.addExpression(cv);
    }  
    aClass.addPostcondition(postcondition);
  }


  /**
   * Analyzes a token recognized as a constraint
   * 
   * @param invariantToken The token containting the constraintsub.
   * @param aClass The Umple class for which an attribute is being constrained.
   */
  @umplesourcefile(line={50},file={"UmpleInternalParser_CodeConstraints.ump"},javaline={3733},length={10})
   private void analyzeInvariant(Token invariantToken, UmpleClass aClass){
    List<ConstraintVariable> cvs = analyzeConstraint(invariantToken, aClass); //adds all identifiers to constraints
    Constraint constraint = new Constraint();
    
    for(ConstraintVariable cv: cvs)
    {
    	constraint.addExpression(cv);
    }  
    aClass.addConstraint(constraint);
  }


  /**
   * This recursive function parses the expression. It's very broken down to allow new features to be added easily.
   */
  @umplesourcefile(line={63},file={"UmpleInternalParser_CodeConstraints.ump"},javaline={3752},length={53})
   private List<ConstraintVariable> analyzeConstraint(Token invariantToken, UmpleClass aClass){
    List<ConstraintVariable> rawLine = new ArrayList<ConstraintVariable>();
    List<Token> subs = invariantToken.getSubTokens();
    for (Token sub : subs)
    {
      if (sub.is("brace"))
      {
        rawLine.add(new ConstraintVariable("SYNTAX",sub.getValue()));
      }
      if (!sub.getValue().equals("STATIC"))
      { 
        if (sub.is("genExpr"))
        {
          rawLine.addAll(analyzeGeneralConstraintExpression(sub,aClass));  
        }        
        else if (sub.is("boolExpr"))
        {
          rawLine.addAll(analyzeBooleanConstraintExpression(sub,aClass));
        } 
        else if (sub.is("stringExpr"))
        {
          rawLine.addAll(analyzeStringConstraintExpression(sub,aClass));
        }
        else if (sub.is("numExpr"))
        {
          rawLine.addAll(analyzeNumberConstraintExpression(sub,aClass));
        }
        else if (sub.is("numExpr2"))
        {
          rawLine.addAll(analyzeNumberConstraintExpression(sub,aClass));
        }
        else if (sub.is("associationExpr"))
        {
          rawLine.addAll(analyzeAssociationConstraintExpression(sub,aClass));
        }
        else if(sub.is("loneBoolean"))
        {
          rawLine.add(analyzeConstraintName(sub.getSubToken(0),aClass,true));
        }
        else if (sub.is("linkingOp")){
        	rawLine.addAll(analyzeLinkingOpExpression(sub,aClass));
        }
        else if (sub.is("negativeConstraint")){
        	rawLine.addAll(analyzeNegativeConstraint(sub, aClass));
        }
        else
        {
          rawLine.addAll(analyzeConstraint(sub,aClass));
        }
      } 
    }
  return rawLine;
  }

  @umplesourcefile(line={118},file={"UmpleInternalParser_CodeConstraints.ump"},javaline={3811},length={21})
   private List<ConstraintVariable> analyzeNegativeConstraint(Token negativeConstraintToken, UmpleClass aClass){
    List<Token> negativeConstraintSubtokens = negativeConstraintToken.getSubTokens();
	  List<Token> subtokensCopy = new ArrayList<Token> ();
	  subtokensCopy.addAll(negativeConstraintSubtokens);
	  
	  List<ConstraintVariable> rawLine = new ArrayList<ConstraintVariable>();
	 
	  rawLine.add(new ConstraintVariable("OPERATOR","!"));
	 
	  for (Token s :subtokensCopy){
		   String name = s.getName();
	      	if (name.equals("!")|name.equals("not")|name.equals("~")){
	      		negativeConstraintToken.removeSubToken(s);	
	      	}
	      }
	  
	  rawLine.addAll(analyzeConstraint(negativeConstraintToken, aClass)); 
	  

	  return rawLine; //rawLine = !(constraintBodystuff)
  }

  @umplesourcefile(line={140},file={"UmpleInternalParser_CodeConstraints.ump"},javaline={3834},length={19})
   private List<ConstraintVariable> analyzeLinkingOpExpression(Token linkingOpExpressionToken, UmpleClass aClass){
    List<Token> LinkingOpExpressionSubtokens = linkingOpExpressionToken.getSubTokens();
	  List<ConstraintVariable> rawLine = new ArrayList<ConstraintVariable>();
	  
	  Token subOp = LinkingOpExpressionSubtokens.get(0); //the linking Expr (ie) &&, ||
	  
	
      if (subOp.is("||")||subOp.is("orOp"))
	  {
		  rawLine.add(new ConstraintVariable("OPERATOR","||"));
	  } 
	  else if (subOp.is("andOp"))
	  {
		  rawLine.add(new ConstraintVariable("OPERATOR","&&"));
	  }
	  rawLine.addAll(analyzeConstraint(linkingOpExpressionToken.getSubToken(1), aClass)); 

	  return rawLine;
  }

  @umplesourcefile(line={161},file={"UmpleInternalParser_CodeConstraints.ump"},javaline={3855},length={29})
   private List<ConstraintVariable> analyzeGeneralConstraintExpression(Token generalExpressionToken, UmpleClass aClass){
    List<ConstraintVariable> rawLine = new ArrayList<ConstraintVariable>();
	List<Token> generalExpressionSubtokens = generalExpressionToken.getSubTokens();
    for(Token sub : generalExpressionSubtokens)
    {
      if (sub.getValue().equals("STATIC"))
      {
        if(!sub.getName().equals("}")&&!sub.getName().equals("{")&&!sub.getName().equals("[")&&!sub.getName().equals("]")&&!sub.getName().equals("\'")&&!sub.getName().equals("\""))
          rawLine.add(new ConstraintVariable("SYNTAX",sub.getName()));
      } 
      else if(sub.is("constraintName"))
      {
        rawLine.add(analyzeConstraintName(sub,aClass,true));
      }
      else if(sub.is("equalsOp"))
      {
		ConstraintVariable cv = new ConstraintVariable("OPERATOR","==");
        cv.setIsPrimitive(false);
        rawLine.add(cv); 
      }
      else if(sub.is("notequalsOp"))
      {
        ConstraintVariable cv = new ConstraintVariable("OPERATOR","==");
        cv.setIsPrimitive(false);
        rawLine.add(cv); 
      }
    }
    return rawLine;
  }

  @umplesourcefile(line={192},file={"UmpleInternalParser_CodeConstraints.ump"},javaline={3886},length={33})
   private List<ConstraintVariable> analyzeBooleanConstraintExpression(Token booleanExpressionToken, UmpleClass aClass){
    List<Token> BooleanExpressionSubtokens = booleanExpressionToken.getSubTokens();
  	List<ConstraintVariable> rawLine = new ArrayList<ConstraintVariable>();
  	for(Token sub : BooleanExpressionSubtokens)
    {
      if (sub.getValue().equals("STATIC"))
      {
        if(!sub.getName().equals("}")&&!sub.getName().equals("{")&&!sub.getName().equals("[")&&!sub.getName().equals("]")&&!sub.getName().equals("\'")&&!sub.getName().equals("\""))
          rawLine.add(new ConstraintVariable("SYNTAX",sub.getName()));
      }
      else if (sub.getValue().equals("true"))
      {
        rawLine.add(new ConstraintVariable("OPERATOR","true"));
      } 
      else if (sub.getValue().equals("false"))
      {
        rawLine.add(new ConstraintVariable("OPERATOR","false"));
      }
      else if(sub.is("constraintName"))
      {
        rawLine.add(analyzeConstraintName(sub,aClass,true,"boolean"));
      }
      else if(sub.is("equalsOp"))
      {
        rawLine.add(new ConstraintVariable("OPERATOR","=="));
      }
      else if(sub.is("notequalsOp"))
      {
        rawLine.add(new ConstraintVariable("OPERATOR","!="));
      }           
    }
    return rawLine;
  }


  /**
   * cardinal && all : not doable
   * cardinal && !all : for each number in the list, size == that number ||, if assLit/name then size == number of elements in the list
   * !cardinal && all : for each number or name have a contains() &&, not currently implemented for a list of lists
   * !cardinal && !all : for each number or name have a contains() ||, not currently implemented for a list of lists
   */
  @umplesourcefile(line={233},file={"UmpleInternalParser_CodeConstraints.ump"},javaline={3921},length={62})
   private List<ConstraintVariable> analyzeAssociationLiteralConstraintExpression(Token literalToken, UmpleClass aClass, boolean cardinal, boolean all, boolean firstName, List<ConstraintVariable> subject, ConstraintVariable operator){
    List<ConstraintVariable> rawLine = new ArrayList<ConstraintVariable>();
    for(Token sub:literalToken.getSubTokens())
    {
      if(sub.is("associationLit"))
      {
        rawLine.addAll(analyzeAssociationLiteralConstraintExpression(sub, aClass, cardinal, all, firstName, subject, operator));
        firstName = false;
      }
      else if(sub.is("constraintName"))
      {
        if(!firstName)
        {
          if(all&&!cardinal)
          {
            rawLine.add(new ConstraintVariable("OPERATOR","&&"));
          }
          else 
          {
            rawLine.add(new ConstraintVariable("OPERATOR","||"));
          }          
        }
        else
        {
          firstName = false;
        }
        rawLine.addAll(subject);
        rawLine.add(operator);
        rawLine.add(analyzeConstraintName(sub,aClass,true));
      }
      else if(sub.is("elements"))
      {
        if(!cardinal)
        {
          operator.setValue("cardinality==");
        }
      }
      else if(sub.is("number"))
      {
        if(!firstName)
        {
          if(all&&!cardinal)
          {
            rawLine.add(new ConstraintVariable("OPERATOR","&&"));
          }
          else 
          {
            rawLine.add(new ConstraintVariable("OPERATOR","||"));
          }          
        }
        else
        {
          firstName = false;
        }
        rawLine.addAll(subject);
        rawLine.add(operator);
        rawLine.add(analyzeConstraintNumber(sub));
        firstName = false;
      }
    }
    return rawLine;
  }

  @umplesourcefile(line={297},file={"UmpleInternalParser_CodeConstraints.ump"},javaline={3992},length={81})
   private List<ConstraintVariable> analyzeAssociationConstraintExpression(Token associationExpressionToken, UmpleClass aClass){
    List<Token> associationExpressionSubtokens = associationExpressionToken.getSubTokens();
  	List<ConstraintVariable> rawLine = new ArrayList<ConstraintVariable>();
  	List<ConstraintVariable> subject = new ArrayList<ConstraintVariable>();
  	boolean card = associationExpressionToken.getValue("firstOp").equals("cardinality");
  	boolean all = false;
  	ConstraintVariable operator = new ConstraintVariable("OPERATOR",associationExpressionToken.getValue("firstOp"));
  	operator.setIsPrimitive(false);
  	for(Token sub : associationExpressionSubtokens)
    {
      if(sub.is("constraintName"))
      {
        subject.add(analyzeConstraintName(sub,aClass,true));
      }
      else if(sub.is("associationLit"))
      {
        rawLine.addAll(analyzeAssociationLiteralConstraintExpression(sub,aClass,card,all,true,subject,operator));
      }
      else if(sub.is("all"))
      {
        if(!card)
        {
          operator.setValue("hasAll");
          all = true;
        }
        else
        {
          //warning that cardinality all is not supported
        }
      }
      else if(sub.is("moreOp"))
      {        
        if(!card)
        {
          card = true;
        }
        operator.setValue("cardinality>");
      }
      else if(sub.is("smallerOp"))
      {        
        if(!card)
        {
          card = true;
        }
        operator.setValue("cardinality<");
      }
      else if(sub.is("greaterOp"))
      {        
        if(!card)
        {
          card = true;
        }
        operator.setValue("cardinality>=");
      }
      else if(sub.is("lessOp"))
      {        
        if(!card)
        {
          card = true;
        }
        operator.setValue("cardinality<=");
      }
      else if(sub.is("equalsOp"))
      {        
        if(!card)
        {
          card = true;
        }
        operator.setValue("cardinality==");
      }
      else if(sub.is("notequalsOp"))
      {        
        if(!card)
        {
          card = true;
        }
        operator.setValue("cardinality!=");
      }
    }
    return rawLine;
  }

  @umplesourcefile(line={380},file={"UmpleInternalParser_CodeConstraints.ump"},javaline={4075},length={33})
   private List<ConstraintVariable> analyzeStringConstraintExpression(Token stringExpressionToken, UmpleClass aClass){
    List<Token> stringExpressionSubtokens = stringExpressionToken.getSubTokens();
  	List<ConstraintVariable> rawLine = new ArrayList<ConstraintVariable>();
  	for(Token sub : stringExpressionSubtokens)
    {
      if (sub.getValue().equals("STATIC"))
      {
        if(!sub.getName().equals("}")&&!sub.getName().equals("{")&&!sub.getName().equals("[")&&!sub.getName().equals("]")&&!sub.getName().equals("\'")&&!sub.getName().equals("\""))
          rawLine.add(new ConstraintVariable("SYNTAX",sub.getName()));
      }
      else if (sub.is("quote"))
      {
        rawLine.add(new ConstraintVariable("OPERATOR","\""+sub.getValue()+"\""));
      }
      else if(sub.is("constraintName"))
      {
        rawLine.add(analyzeConstraintName(sub,aClass,true,"string"));
      }
      else if(sub.is("equalsOp"))
      {
        ConstraintVariable cv = new ConstraintVariable("OPERATOR","==");
        cv.setIsPrimitive(false);
        rawLine.add(cv);        
      }
      else if(sub.is("notequalsOp"))
      {
        ConstraintVariable cv = new ConstraintVariable("OPERATOR","!=");
        cv.setIsPrimitive(false);
        rawLine.add(cv); 
      }           
    }
    return rawLine;
  }

  @umplesourcefile(line={415},file={"UmpleInternalParser_CodeConstraints.ump"},javaline={4110},length={47})
   private List<ConstraintVariable> analyzeNumberConstraintExpression(Token numberExpressionToken, UmpleClass aClass){
    List<ConstraintVariable> rawLine = new ArrayList<ConstraintVariable>();
	List<Token> numberExpressionSubtokens = numberExpressionToken.getSubTokens();
    for(Token sub : numberExpressionSubtokens)
    {
      if (sub.getValue().equals("STATIC"))
      {
      	if(!sub.is("}")&&!sub.is("{")&&!sub.is("[")&&!sub.is("]")&&!sub.is("\'")&&!sub.is("\""))
          rawLine.add(new ConstraintVariable("SYNTAX",sub.getName()));
      } 
      else if(sub.is("constraintName"))
      {
        rawLine.add(analyzeConstraintName(sub,aClass,true,"integer","float","double"));
      }
      else if(sub.is("number"))
      {
        rawLine.add(analyzeConstraintNumber(sub));
      }
      else if(sub.is("moreOp"))
      {
        rawLine.add(new ConstraintVariable("OPERATOR",">"));
      }
      else if(sub.is("smallerOp"))
      {
        rawLine.add(new ConstraintVariable("OPERATOR","<"));
      }
      else if(sub.is("greaterOp"))
      {
        rawLine.add(new ConstraintVariable("OPERATOR",">="));
      }
      else if(sub.is("lessOp"))
      {
        rawLine.add(new ConstraintVariable("OPERATOR","<="));
      }
      else if(sub.is("equalsOp"))
      {
        ConstraintVariable cv = new ConstraintVariable("OPERATOR","==");
        rawLine.add(cv);        
      }
      else if(sub.is("notequalsOp"))
      {
        ConstraintVariable cv = new ConstraintVariable("OPERATOR","!=");
        rawLine.add(cv); 
      } 
    }
    return rawLine;
  }

  @umplesourcefile(line={465},file={"UmpleInternalParser_CodeConstraints.ump"},javaline={4159},length={161})
   private ConstraintVariable analyzeConstraintName(Token nameToken, UmpleClass aClass, boolean mustBeInClass, String... type){
    Token grandparentToken = nameToken.getParentToken().getParentToken();
  	ConstraintVariable cv = new ConstraintVariable("NAME","");
  	cv.setSubConstraint(new Constraint());
  	boolean isNew = false;
  	boolean isComplex = nameToken.numberOfSubTokens()>1;
  	for(Token sub:nameToken.getSubTokens())
  	{
  	  if(sub.is("constraintParameterList"))
  	  {
  	    for(Token param: sub.getSubTokens())
  	    {
  	      if(param.is("constraintParameter"))
  	      {
  	        Token value = param.getSubToken(0);
  	        if(value.is("boolLit"))
  	        {
  	          cv.getSubConstraint().addExpression(new ConstraintVariable("SYNTAX",sub.getValue()));
  	        }
  	        else if(value.is("quote"))
  	        {
  	          cv.getSubConstraint().addExpression(new ConstraintVariable("OPERATOR","\""+sub.getValue()+"\""));
  	        }
  	        else if(value.is("number"))
  	        {
  	          cv.getSubConstraint().addExpression(analyzeConstraintNumber(value));
  	        }
  	        else if(value.is("constraintName")){
  	          cv.getSubConstraint().addExpression(analyzeConstraintName(value,aClass,false));
  	        }
  	      }
  	      else
  	      {
  	        cv.getSubConstraint().addExpression(new ConstraintVariable("SYNTAX",param.getName()));
  	      }
  	    }
  	  }
  	  else if(sub.is("index"))
  	  {  	    
        analyzeConstraintIndex(sub,cv);
  	  }
  	  else if(sub.is("new"))
  	  {  	    
  	    isNew = true;
        cv.getSubConstraint().addExpression(new ConstraintVariable("OPERATOR","initialise").isNotPrimitive());
  	  }
  	  else if(sub.is("constraintScopeOperator"))
  	  {
  	    ConstraintVariable dot = new ConstraintVariable("OPERATOR",".");
  	    dot.setIsPrimitive(false);
  	    cv.getSubConstraint().addExpression(dot);
  	    mustWarn = false;
  	    for(Token subsub:sub.getSubTokens()){
  	      if(subsub.is("constraintName"))
  	      {
  	        cv.getSubConstraint().addExpression(analyzeConstraintName(subsub,aClass,true));
  	      }
  	    }  	    
  	    mustWarn = false;
  	  }
  	  else if(sub.is("name"))
  	  {
  	    cv.setValue(sub.getValue());
  	    cv.getAttribute(aClass);
  	    ConstraintVariable name = new ConstraintVariable("",sub.getValue());
  	    cv.getSubConstraint().addExpression(name);
  	    if("this".equals(name.getValue()))
  	    {
  	      continue;
  	    }
  	    UmpleVariable attribute;
        if(mustBeInClass)
        {
          attribute = name.getAttribute(aClass);
          
          if(attribute!=null||isNew)
          {
      	    if(type!=null&&type.length!=0)
      	    {
      	      boolean isType = false;
      	      String typesFailed = "";
      	      for(String t: type)
      	      {
      	        if((isNew?sub.getValue():attribute.getType()).toLowerCase().equals(t))
                {
                  isType = true;
                }          
                else
                {
                  typesFailed += t+",";
                }
              }
              if(!isType)
              {
          	    setFailedPosition(sub.getPosition(), 29, sub.getValue(), typesFailed);
              }
            }
            name.setType(isNew?sub.getValue():attribute.getType());
          }
          else if (grandparentToken.is("precondition")||grandparentToken.is("postcondition"))
          { //if it was a precondition or postcondition, check if it matches any of the method arguments
    	    Token concreteMethod = grandparentToken.getParentToken();
    	    ArrayList<MethodParameter> methodparams = new ArrayList<MethodParameter>();
    	    for (Token t : concreteMethod.getSubTokens())
    	    {
              if (t.getName().equals("methodDeclarator"))
              {
    		    for (Token st : t.getSubTokens())
    		    {
    	          if (st.getName().equals("parameterList"))
    	          {
    			    for (Token sst : st.getSubTokens())
    		        {
    			      if(sst.getName().equals("parameter"))
    			      {
    				    String paramName = null;
    				    String paramType = null;
    				    for (Token ssst: sst.getSubTokens())
    				    {
    				      if (ssst.getName().equals("type"))
    				      {
    					    paramType = ssst.getValue();
    				      }
    				      if (ssst.getName().equals("name"))
    				      {
    				        paramName = ssst.getValue();
    				      }
    				    }
    				    MethodParameter mp = new MethodParameter(paramName, paramType, null, null, false);
    			        methodparams.add(mp);
    			      }
    			    }
    	          }
    		    }
    	      }
    	      boolean matchesAnyMethodParams = false;
    	      for (MethodParameter mp : methodparams)
    	      { 
    	 	    if (mp.getName().equals(sub.getValue()))
    		    {
    	          matchesAnyMethodParams = true; 
    		      cv.setType(mp.getType());
    		    }
    	      }
            }
          }
          else if(attribute==null)
          {
            if(grandparentToken.is("postcondition")&&sub.getValue().equals("result")){
              //don't throw error if the attribute is named "result" the result is the return value from the original function
            }
            else if(!isComplex&&mustWarn&&aClass!=null){
              setFailedPosition(sub.getPosition(), 28, sub.getValue(), aClass.getName());
            }      
          }          
        }
      }
    }
    mustWarn = true;
    return cv;
  }

  @umplesourcefile(line={627},file={"UmpleInternalParser_CodeConstraints.ump"},javaline={4322},length={3})
   private ConstraintVariable analyzeConstraintNumber(Token numberToken){
    return new ConstraintVariable("OPERATOR",numberToken.getValue());
  }

  @umplesourcefile(line={631},file={"UmpleInternalParser_CodeConstraints.ump"},javaline={4327},length={16})
   private void analyzeConstraintIndex(Token indexToken, ConstraintVariable cv){
    Token sub = indexToken;
  	try {
      int i = Integer.parseInt(sub.getValue());
      if(cv.getIsAssociation())
      {
        cv.setIndex(i);
      }
      else
      {
        setFailedPosition(sub.getPosition(), 29, cv.getValue(), "association or list");
      }
    } catch (NumberFormatException e) {
      setFailedPosition(sub.getPosition(), 29, sub.getValue(), "integer");
    }
  }


  /**
   * Check if "extra code" is likely a malformed state machine
   */
  @umplesourcefile(line={28},file={"UmpleInternalParser_CodeStateMachine.ump"},javaline={4345},length={7})
   private boolean extraCodeIsMalformedStateMachine(Token extraCodeToken){
    String code = extraCodeToken.getValue();
    String[] parts = code.split("\\{");
    if(parts.length < 2) return false; // This means there are no opening brackets
    if(!Token.isValidIdentifier(parts[0].trim())) return false; //This means we don't have an identifier. If the SM name is misspelt, that should be picked up elsewhere.
    return true; //We have an identifier followed by a { followe by something else that is probably a state machine
  }


  /**
   * Analyze state machine related tokens
   */
  @umplesourcefile(line={37},file={"UmpleInternalParser_CodeStateMachine.ump"},javaline={4358},length={11})
   private void analyzeStateMachineToken(Token token, int analysisStep){
    if (analysisStep != 1)
    {
      return;
    }
  
    if (token.is("stateMachineDefinition"))
    {
      analyzeStateMachineDefinition(token);
    }
  }

  @umplesourcefile(line={50},file={"UmpleInternalParser_CodeStateMachine.ump"},javaline={4375},length={9})
   private String getThreadName(Token activeToken){
    Token name = activeToken.getSubToken("name");
    
    if (name == null)
    {
      return "thread1";
    }
    return name.getValue();
  }

  @umplesourcefile(line={61},file={"UmpleInternalParser_CodeStateMachine.ump"},javaline={4386},length={5})
   private String getActiveCode(Token activeToken){
    Token code = activeToken.getSubToken("code");
    
    return code.getValue();
  }

  @umplesourcefile(line={68},file={"UmpleInternalParser_CodeStateMachine.ump"},javaline={4393},length={11})
   private void analyzeActiveObject(Token activeToken, UmpleClass aClass){
    analyzeStateMachine(generateActiveStateMachineToken(activeToken), aClass);
    if (numberOfActiveObjects < numberOfActiveObjectsInClass(activeToken.getParentToken(), aClass))
    {
      numberOfActiveObjects++;
    }
    else
    {
      numberOfActiveObjects = 1;
    }
  }

  @umplesourcefile(line={81},file={"UmpleInternalParser_CodeStateMachine.ump"},javaline={4406},length={9})
   private Token generateActiveStateMachineToken(Token stateMachineToken){
    Token token = new Token("name", "stateMachine" + numberOfActiveObjects);
    
    token.addSubToken(new Token("{", "STATIC"));
    token.addSubToken(generateActiveTopLevelStateToken(stateMachineToken));
    token.addSubToken(new Token("}", "STATIC"));
    
    return token;
  }

  @umplesourcefile(line={92},file={"UmpleInternalParser_CodeStateMachine.ump"},javaline={4417},length={10})
   private Token generateActiveTopLevelStateToken(Token stateMachineToken){
    Token token = new Token("state", "START_TOKEN");
    
    token.addSubToken(new Token("stateName", "topLevel"));
    token.addSubToken(new Token("{", "STATIC"));
    token.addSubToken(generateActiveStateToken(stateMachineToken));
    token.addSubToken(new Token("}", "STATIC"));
    
    return token;
  }

  @umplesourcefile(line={104},file={"UmpleInternalParser_CodeStateMachine.ump"},javaline={4429},length={10})
   private Token generateActiveStateToken(Token stateMachineToken){
    Token token = new Token("state", "START_TOKEN");
    
    token.addSubToken(new Token("stateName", getThreadName(stateMachineToken)));
    token.addSubToken(new Token("{", "STATIC"));
    token.addSubToken(generateActivityToken(stateMachineToken));
    token.addSubToken(new Token("}", "STATIC"));
    
    return token;
  }

  @umplesourcefile(line={116},file={"UmpleInternalParser_CodeStateMachine.ump"},javaline={4441},length={10})
   private Token generateActivityToken(Token stateMachineToken){
    Token token = new Token("activity", "START_TOKEN");
    
    token.addSubToken(new Token("do", "STATIC"));
    token.addSubToken(new Token("{", "STATIC"));
    token.addSubToken(new Token("code", getActiveCode(stateMachineToken)));
    token.addSubToken(new Token("}", "STATIC"));
    
    return token;
  }


  /**
   * Analyze state machine related tokens within the context of an Umple class
   */
  @umplesourcefile(line={130},file={"UmpleInternalParser_CodeStateMachine.ump"},javaline={4453},length={31})
   private void analyzeStateMachineToken(Token token, UmpleClass aClass, int analysisStep){
    if (analysisStep != 1)
    {
      return;
    }
    
    if (token.is("stateMachine"))
    {
      if (aClass.isImmutable())
      {
    	  setFailedPosition(token.getPosition(), 15, aClass.getName());
    	  return;
      }
      
      Token subToken = token.getSubToken(0);
      if (subToken.is("activeDefinition"))
      {
        analyzeActiveObject(subToken, aClass);
      }
      
      if (subToken.is("enum") || subToken.is("inlineStateMachine"))
      {
        analyzeStateMachine(subToken,aClass);
      }
      
      if (subToken.is("referencedStateMachine"))
      {
        analyzedReferencedStateMachine(subToken,aClass);
      }
    }
  }

  @umplesourcefile(line={163},file={"UmpleInternalParser_CodeStateMachine.ump"},javaline={4490},length={20})
   private int numberOfActiveObjectsInClass(Token token, UmpleClass aClass){
    int activeObjects = 0;
    
    Token parent = token.getParentToken();
    if (parent != null)
    {
      for (Token sub : parent.getSubTokens())
      {
        if (sub.is("stateMachine"))
        {
          if (sub.getSubToken(0).is("activeDefinition"))
          {
            activeObjects++;
          }
        }
      }
    }
    
    return activeObjects;
  }

  @umplesourcefile(line={185},file={"UmpleInternalParser_CodeStateMachine.ump"},javaline={4512},length={14})
   private void postTokenStateMachineAnalysis(){
    // Generate error message for issue 354. Check for conflicting names between
    // state machines and attributes as well as state machines and association names
    checkStateMachineNameConflict();

    for(Iterator<Map.Entry<State, List<Token>>> i = possiblyUnknownStates.entrySet().iterator(); i.hasNext();){
    	Map.Entry<State, List<Token>> entry = (Map.Entry<State, List<Token>>)i.next();
    	List<Token> tokens = (List<Token>)entry.getValue();
		for(int j = 0; j < tokens.size(); j++){
			setFailedPosition(tokens.get(j).getPosition(), 50, tokens.get(j).getValue("stateName"));
		}    
    }
    possiblyUnknownStates = new HashMap<State,List<Token>>();
  }


  /**
   * Check for name conflicts between state machines and attributes/association names
   * Author: Blake Quebec Desloges
   */
  @umplesourcefile(line={205},file={"UmpleInternalParser_CodeStateMachine.ump"},javaline={4528},length={75})
   private void checkStateMachineNameConflict(){
    for(UmpleClass C : model.getUmpleClasses())
    {    
      // Create the list of attribute names 
      List<String> existingAttributeNames = new ArrayList<String>();
      for (Attribute attr : C.getAttributes())
      {
      	existingAttributeNames.add(attr.getName());
      }
      
      //Create the list of state machine names while checking for conflicts with attributes
      List<String> existingStateMachineNames = new ArrayList<String>();
      for (StateMachine sm : C.getStateMachines())
      {
      	// Check if the current state machine conflicts with an attribute name
      	if (existingAttributeNames.contains(sm.getName()))
      	{
      	   Token stateMachineToken = stateMachineNameToToken.get(sm.getName());
          setFailedPosition(stateMachineToken.getPosition(), 52, sm.getName());
       }
       else
          existingStateMachineNames.add(sm.getName());
      }
      
      List<String> existingAssociationNames = new ArrayList<String>();
      List<Association> visitedAssociations = new ArrayList<Association>();
      for(Association assoc : C.getAssociations())
      {
        if (visitedAssociations.contains(assoc))
        {
          continue;
        }
        
      	AssociationEnd firstEnd = assoc.getEnd(0);
      	AssociationEnd secondEnd = assoc.getEnd(1);
      	
      	Boolean checkFirstEnd = !firstEnd.getClassName().equals(C.getName());
      	Boolean checkSecondEnd = !secondEnd.getClassName().equals(C.getName());
      	Boolean associationIsReflexive = !checkFirstEnd && !checkSecondEnd;
      	
      	// check names on other-class end of associations to other classes
        if ((checkFirstEnd || associationIsReflexive) && assoc.getIsLeftNavigable())
        {
          // Check if the association name is the same as a state machine name
          if (existingStateMachineNames.contains(firstEnd.getRoleName()))
          {
             setFailedPosition(assoc.getTokenPosition(), 52, firstEnd.getRoleName());
          }
          else
          {
            existingAssociationNames.add(firstEnd.getRoleName());
          }
          
        }
        if ((checkSecondEnd || associationIsReflexive) && assoc.getIsRightNavigable())
        {
          // Check if the association name is the same as a state machine name
          if (existingStateMachineNames.contains(secondEnd.getRoleName()))
          {
             setFailedPosition(assoc.getTokenPosition(), 52, secondEnd.getRoleName());
          }
          else
          {
            existingAssociationNames.add(secondEnd.getRoleName());
          }
        }
         
        if (associationIsReflexive)
        { 
          // The UmpleClass is only expected to have duplicate references to reflexive associations
          visitedAssociations.add(assoc);
        }
      }
    }
  }

  @umplesourcefile(line={283},file={"UmpleInternalParser_CodeStateMachine.ump"},javaline={4610},length={4})
   private void analyzeStateMachineDefinition(Token stateMachineDefinitionToken){
    StateMachine smd = analyzeStateMachine(stateMachineDefinitionToken,null);
    model.addStateMachineDefinition(smd);
  }

  @umplesourcefile(line={289},file={"UmpleInternalParser_CodeStateMachine.ump"},javaline={4616},length={30})
   private void analyzedReferencedStateMachine(Token stateMachineToken, UmpleClass aClass){
    String name = stateMachineToken.getValue("name");

    if(!Token.isValidIdentifier(stateMachineToken.getValue("name"))){
    	setFailedPosition(stateMachineToken.getPosition(), 150, stateMachineToken.getValue("name"));
    }

    String definitionName = stateMachineToken.getValue("definitionName");
      
    Token stateMachineDefinitionToken = stateMachineNameToToken.get(definitionName);
    if (stateMachineDefinitionToken == null)
    {
      return;
    }

    StateMachine sm = new StateMachine(name);
    boolean wasSet = sm.setUmpleClass(aClass);
    if (!wasSet)
    {
    	// Future-proofing: currently all paths cause wasSet to be true
    	setFailedPosition(stateMachineToken.getPosition(), 15, aClass.getName());
    }
    
    populateStateMachine(stateMachineDefinitionToken,sm, aClass);
    Token extendedStateMachineTokens = stateMachineToken.getSubToken("extendedStateMachine");
    if (extendedStateMachineTokens != null)
    {
      populateStateMachine(extendedStateMachineTokens, sm, aClass);
    }
  }

  @umplesourcefile(line={322},file={"UmpleInternalParser_CodeStateMachine.ump"},javaline={4648},length={31})
   private StateMachine analyzeStateMachine(Token stateMachineToken, UmpleClass aClass){
    placeholderStateMachine = new StateMachine("PLACE_HOLDER");
    String name = stateMachineToken.getValue("name");

    if(!Token.isValidIdentifier(stateMachineToken.getValue("name"))){
    	setFailedPosition(stateMachineToken.getPosition(), 150, stateMachineToken.getValue("name"));
    }

    stateMachineNameToToken.put(name,stateMachineToken);
    
    StateMachine sm = new StateMachine(name);
    boolean wasSet = sm.setUmpleClass(aClass);
    if (!wasSet)
    {
    	// Future-proofing: currently all paths cause wasSet to be true
    	setFailedPosition(stateMachineToken.getPosition(), 15, aClass.getName());
    }
      
    if(stateMachineToken.is("queued"))
    {
      sm.setQueued(true);
    } 

    populateStateMachine(stateMachineToken, sm, aClass);

    while (placeholderStateMachine.numberOfStates() > 0)
    {
      placeholderStateMachine.getState(0).setStateMachine(sm);
    }
    return sm;
  }

  @umplesourcefile(line={355},file={"UmpleInternalParser_CodeStateMachine.ump"},javaline={4681},length={28})
   private State createStateFromTransition(Token transitionToken, StateMachine sm){
    if(!Token.isValidIdentifier(transitionToken.getValue("stateName"))){
    	setFailedPosition(transitionToken.getPosition(), 152, transitionToken.getValue("stateName"));
    }
    String name = transitionToken.getValue("stateName");
    State nextState = sm.findState(name);
    
    if ("Final".equals(name))
    {
      nextState = new State(name,sm);
    }
    else
    {
      if (nextState == null)
      {
        nextState = placeholderStateMachine.findState(name);
        if(nextState != null)possiblyUnknownStates.get(nextState).add(transitionToken);
      }

      if (nextState == null)
      {
        nextState = new State(name,placeholderStateMachine);
        possiblyUnknownStates.put(nextState, new ArrayList<Token>());
        possiblyUnknownStates.get(nextState).add(transitionToken);
      }
    }
    return nextState;
  }

  @umplesourcefile(line={385},file={"UmpleInternalParser_CodeStateMachine.ump"},javaline={4711},length={20})
   private State createStateFromDefinition(Token stateToken, StateMachine sm){
    if(!Token.isValidIdentifier(stateToken.getValue("stateName"))){
    	setFailedPosition(stateToken.getPosition(), 152, stateToken.getValue("stateName"));
    }
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
    possiblyUnknownStates.remove(s);
    return s;
  }

  @umplesourcefile(line={407},file={"UmpleInternalParser_CodeStateMachine.ump"},javaline={4733},length={49})
   private void populateStateMachine(Token stateMachineToken, StateMachine sm, UmpleClass aClass){
    boolean isFirst = true;
    boolean isFinalState = false;
    String changeType = null;
    
    for(Token stateToken : stateMachineToken.getSubTokens())
    {
      if(stateToken.is("queued"))
      {
        sm.setQueued(true);
      }
      
      // Concurrency is only allowed between nested state-machines
      if (stateToken.is("||"))
      {
        setFailedPosition(stateMachineToken.getPosition(), 53, sm.getName());
      }
      
      if(stateToken.is("trace"))
      {
    	analyzeTraceStatement(aClass,stateToken);
      }
      
      if (!stateToken.is("state") && !stateToken.is("stateName"))
      {
        if (stateToken.is("changeType")) { changeType = stateToken.getValue(); }      
        continue;
      }

      if ("-".equals(changeType))
      {
        State deleteMe = sm.findState(stateToken.getValue("stateName"));
        if (deleteMe != null) { deleteMe.delete(); }
      }
      else
      {
        State s = createStateFromDefinition(stateToken,sm);
        s.setFinalState(isFinalState);
        if (isFirst)
        {
          s.setIsStartState(true);
        }
        isFirst = false;
        isFinalState = false;
        analyzeState(stateToken, s);
        changeType = null;
      }
    }
  }

  @umplesourcefile(line={458},file={"UmpleInternalParser_CodeStateMachine.ump"},javaline={4784},length={70})
   private void analyzeState(Token stateToken, State fromState){
    boolean addNewSm = true;
    boolean isConcurrentState = false;
    boolean isFinalState = false;
    String changeType = null;
    
    for(Token subToken : stateToken.getSubTokens())
    {
      if (subToken.is("changeType"))
      {
        changeType = subToken.getValue();
      }
      else if (subToken.is("final"))
      {
        fromState.setFinalState(true);
      }
      else if (subToken.is("transition"))
      {
        analyzeTransition(false,subToken, fromState, changeType); 
      }
      else if (subToken.is("autoTransition"))
      {
        analyzeTransition(true,subToken, fromState, changeType);
      }
      else if (subToken.is("activity"))
      {
        analyzeActivity(subToken, fromState);
      }
      else if (subToken.is("entryOrExitAction"))
      {
      	fromState.addAction(analyzeAction(subToken, fromState));
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

  @umplesourcefile(line={530},file={"UmpleInternalParser_CodeStateMachine.ump"},javaline={4856},length={27})
   private Activity analyzeActivity(Token activityToken, State fromState){
    Activity act= new Activity("", fromState);
  	CodeBlock cb = new CodeBlock();
  	
  	List<String> codelangs = new ArrayList<String>();
  	for(Token tkn: activityToken.getSubTokens()){
  	  if(tkn.is("codeLang")){
  		codelangs.add(tkn.getValue());
  	  } else if(tkn.is("code")){
  		if(codelangs.isEmpty())
  		{
  		  cb.setCode(tkn.getValue());
  		} 
  		else {
  		  for(String lang: codelangs){
  			cb.setCode(lang, tkn.getValue());
          }
          codelangs.clear();
    	}
      }
    }
    act.setCodeblock(cb);
    
    act.setPosition(activityToken.getPosition());
    act.setEndPosition(activityToken.getEndPosition());
    return act;
  }

  @umplesourcefile(line={559},file={"UmpleInternalParser_CodeStateMachine.ump"},javaline={4885},length={28})
   private Action analyzeAction(Token actionToken, State fromState){
    Action action= new Action("");
  	CodeBlock cb = new CodeBlock();
  	List<String> codelangs = new ArrayList<String>();
  	for(Token tkn: actionToken.getSubTokens()){
  	  if(tkn.is("codeLang")){
  		codelangs.add(tkn.getValue());
  	  } else if(tkn.is("code")){
  		if(codelangs.isEmpty())
  		{
  		  cb.setCode(tkn.getValue());
  		} 
  		else {
  		  for(String lang: codelangs){
  			cb.setCode(lang, tkn.getValue());
          }
          codelangs.clear();
    	}
      }
    }
    action.setCodeblock(cb);
    	
    action.setPosition(actionToken.getPosition());
    action.setEndPosition(actionToken.getEndPosition());
    action.setActionType(actionToken.getValue("type"));
        
    return action;
  }

  @umplesourcefile(line={588},file={"UmpleInternalParser_CodeStateMachine.ump"},javaline={4915},length={143})
   private void analyzeTransition(boolean isAutoTransition, Token transitionToken, State fromState, String changeType){
    State nextState = createStateFromTransition(transitionToken,fromState.getStateMachine());
    
    Transition t; 
    if ("-".equals(changeType))
    {
      t = Transition.createPlaceholder(nextState);
    }
    else
    {
      t = new Transition(fromState, nextState);
    }

    t.setAutoTransition(isAutoTransition);

    String eventName = transitionToken.getValue("event");
    String eventTimerAmount = transitionToken.getValue("timer");
    String name="";
    String type="";
    String paramType="";
    String paramName="";
    if (eventName == null && eventTimerAmount != null)
    {
      eventName = fromState.newTimedEventName(nextState);
    }

    Token guardToken = transitionToken.getSubToken("guard");
    if (guardToken != null)
    {
      List <ConstraintVariable> cvs = analyzeConstraint(guardToken, fromState.getStateMachine().getRootStateMachine().getUmpleClass()); //adds all identifiers to constraints
      Guard constraint = new Guard();
      for(ConstraintVariable cv: cvs)
      {
        constraint.addExpression(cv);
      }
      constraint.setPosition(guardToken.getPosition());
      constraint.setEndPosition(guardToken.getEndPosition());
      t.setGuard(constraint);//analyzeGuard(guardToken, fromState));
    }

    Token actionToken = transitionToken.getSubToken("action");
    if (actionToken != null)
    {
      
      t.setAction(analyzeAction(actionToken,fromState));
    }
    if (eventName != null || isAutoTransition)
    {
      StateMachine sm = fromState.getStateMachine();
      UmpleClass uClass = sm.getUmpleClass();
      Event event = isAutoTransition ? Event.createAutoTransition() : uClass == null ? sm.findOrCreateEvent(eventName) : uClass.findOrCreateEvent(eventName);
      if (eventTimerAmount != null)
      {
        event.setIsTimer(true);
        event.setTimerInSeconds(eventTimerAmount);
      }
      t.setEvent(event);
      
      if ("-".equals(changeType))
      {
        fromState.removeTransition(t);      
      }
     
     for (Token subEventToken : transitionToken.getSubTokens())
     {
     	Event aEvent = sm.getEvent(event.getName());
        
      	if (subEventToken.is("parameterList"))
      	{
      		if ( aEvent == event && ! event.hasParams() )
      		{
      			for(Token parameterToken : subEventToken.getSubTokens())
      			{
      				boolean isList = false;
      				if (parameterToken.is("parameter"))
      				{
      					if (parameterToken.getSubToken("type") != null)
      					{
      						paramType = parameterToken.getSubToken("type").getValue();
      					}
      					if (parameterToken.getSubToken("list") != null)
      					{
      						isList = parameterToken.getSubToken("list").getValue() != null;
      					}
      					
      					paramName = parameterToken.getSubToken("name").getValue();
      					MethodParameter aParameter  = new MethodParameter(paramName,paramType,null,null, false);
      					aParameter.setIsList(isList);
      					if (event.getParams().contains(aParameter))
      					{
      						break;
      					}
      					else
      					{
      						event.addParam(aParameter);
      					}
      				}
      			}
      		}
      		else
      		{ 
      			for(Token parameterSecondToken : subEventToken.getSubTokens())
      			{
      				boolean isListt = false;
      				if (parameterSecondToken.is("parameter"))
      				{
      					String paramTypee="";
      					if (parameterSecondToken.getSubToken("type") != null)
      					{
      						type = parameterSecondToken.getSubToken("type").getValue();
      					}
      					if (parameterSecondToken.getSubToken("list") != null)
      					{
      						isListt = parameterSecondToken.getSubToken("list").getValue() != null;
      					}
      					name = parameterSecondToken.getSubToken("name").getValue();
      				}	
      			}
      		
      			for (int i=1; i <= event.getParams().size(); i++)
      			{
      			    if (!event.getArgs().contains(type) || !event.getArgs().contains(name))
      			    {
      			    	setFailedPosition(transitionToken.getPosition(), 51, event.getArgs());
      			    	
      			    }
      			}
      		}
      	}
      }
      
      for(Token subToken : transitionToken.getSubTokens())
      {
        if (subToken.is("activity"))
        {
          t.setAutoTransition(false);
          Activity act = analyzeActivity(subToken, fromState);
          act.setOnCompletionEvent(event);
        }
    }      
    
    }
  }


  /**
   * 
   * Trace Glue Code   ************
   * 
   */
  @umplesourcefile(line={25},file={"UmpleInternalParser_CodeTrace.ump"},javaline={5060},length={27})
   private void analyzeTraceToken(Token token, int analysisStep){
    if (analysisStep != 1)
    {
      return;
    }
    
    if (token.is("traceType"))
    {
      Tracer tracer = model.getTracer();
      for(Token subToken: token.getSubTokens())
      {
      	if(subToken.is("tracerType"))
      	{
      	  tracer = new Tracer(subToken.getValue());
      	}
      	else if(subToken.is("tracerArgument"))
      	{
      	  tracer.addArgument(subToken.getValue());
      	}
      	else if(subToken.is("verbosity"))
      	{
      	  tracer.setVerbosity(true);
      	}
      }
      model.setTracer(tracer);
    }
  }


  /**
   * Process trace related tokens within the context of a class
   */
  @umplesourcefile(line={58},file={"UmpleInternalParser_CodeTrace.ump"},javaline={5095},length={11})
   private void analyzeTraceToken(Token token, UmpleClass aClass){
    // Analyze trace statement token
    if (token.is("trace"))
    {
      if(model.getTracer()==null)
      {
      	model.setTracer(new Tracer("Console"));
      }
      analyzeTraceStatement(aClass, token);
    }
  }


  /**
   * Process Trace statement subtokens. Token could be trace directive or trace case
   */
  @umplesourcefile(line={72},file={"UmpleInternalParser_CodeTrace.ump"},javaline={5112},length={150})
   private void analyzeTraceStatement(UmpleClass aClass, Token token){
    TraceDirective traceDirective = new TraceDirective(model.getTracer());
    AttributeTraceItem traceAttr = new AttributeTraceItem(traceDirective);
    MethodTraceEntity mte = new MethodTraceEntity();
    TraceRecord traceRecord = null;
    traceDirective.setUmpleClass(aClass);
     
    boolean isFirst = true;
      
    for( Token traceToken : token.getSubTokens() )
    {
      if( traceToken.is("trace_entity") || traceToken.getName().equals("entry") || traceToken.getName().equals("exit"))
      {
        analyzeTraceItem( traceToken , traceDirective , mte, traceAttr);
      }
        
      else if( traceToken.is("traceWhen") ) //for where/giving/after/until
      {
        //using the constraint data type, used for holding umple specific conditionals
        int pos = 1;
        if(!traceToken.getSubToken(1).is("constraintToken")){
          String ctype = traceToken.getValue("conditionType");
          if(ctype!=null&&!ctype.equals("where"))
          {
          	traceAttr.setConditionType(ctype);
          	traceAttr.setConditionallyWhere(false);
          }
          
          pos = 2;
        }
        List <ConstraintVariable> cvs = analyzeConstraint(traceToken.getSubToken(pos), aClass); //adds all identifiers to constraints
        Constraint constraint = new Constraint();
        List<Attribute> others = new ArrayList<Attribute>();
        for(ConstraintVariable cv: cvs)
        {
          constraint.addExpression(cv);
          if(("after".equals(traceAttr.getConditionType())||
          	  "until".equals(traceAttr.getConditionType()))&&
          	  cv.getIsAttribute()
          )
          {
          	UmpleVariable av = cv.getAttribute(aClass);
            if(av instanceof Attribute)
            {
              others.add((Attribute)av);
            }
            else if(av instanceof AssociationVariable)
            {
              //others.add((AssociationVariable)av);
            }
            
          }
        }
        if(others.isEmpty())
        {
          traceAttr.setConstraint(constraint);
        }
        else
        {
          String  method = "";
          
          for(Attribute at:others)
          {
          	method+= ",set_"+at.getName();
          	method+= ",set"+at.getName().substring(0,1).toUpperCase()+at.getName().substring(1);          	
          }
          String flag = "traceFlag"+getTraceFlagId();
          String code = flag+"="+("after".equals(traceAttr.getConditionType())?"true":"until".equals(traceAttr.getConditionType())?"false":"");
          CodeInjection ci = new CodeInjection("after",method,"", aClass);
          CodeBlock cb = new CodeBlock(code+";");
          cb.setCode("Java",code+";");
          cb.setCode("Cpp",code+";");
          cb.setCode("Php",code+";");
          cb.setCode("Ruby",code);
          ci.setSnippet(cb);
          ci.setConstraint(constraint);
          aClass.addCodeInjection(ci);
          constraint = new Constraint();
          constraint.addExpression(new ConstraintVariable("",flag));
          traceAttr.setConstraint(constraint);
          new Attribute(flag,"Boolean","internal",("after".equals(traceAttr.getConditionType())?"false":"until".equals(traceAttr.getConditionType())?"true":""),false,aClass);
        }
      }
      else if ( traceToken.getName().equals("giving") )
      {
        TraceCondition tc = analyzeTraceCondition( token, "giving");
        traceDirective.addCondition(tc);
        UmpleVariable attr = traceDirective.getUmpleClass().getAttribute(token.getValue("LHS"));
        if(attr==null)
        {
          attr = traceDirective.getUmpleClass().getAssociationVariable(token.getValue("LHS"));
        }
        traceAttr.addUmpleVariable(attr);
      }     
      else if( traceToken.is("trace_for") )
      {
      	String flag = "traceFlag"+getTraceFlagId();
        traceAttr.setForClause(flag);
        Constraint constraint;
        if(traceAttr.getConstraint()==null)
        {
          constraint = new Constraint();
        } 
        else
        {
          constraint = traceAttr.getConstraint();
          constraint.addExpression(new ConstraintVariable("OPERATOR","&&"));
        }
        constraint.addExpression(new ConstraintVariable("integer",flag));
        constraint.addExpression(new ConstraintVariable("OPERATOR","<"));
        constraint.addExpression(new ConstraintVariable("SYNTAX",traceToken.getValue()));
        traceAttr.setConstraint(constraint);
        
        new Attribute(flag,"Integer","internal","0",false,aClass);
      }     
      else if( traceToken.is("trace_period") )
      {
      	traceAttr.setTraceSet(false);
      	traceAttr.setTraceGet(false);
      	traceAttr.setTraceConstructor(true);
        traceAttr.setPeriodClause(token.getValue("trace_period"));
      }
      else if( traceToken.is("trace_duration") )
      {
        traceAttr.setDuringClause(token.getValue("trace_duration"));
      }
      else if( traceToken.is("trace_record") || traceToken.getName().equals("only") )
      {
        if( isFirst )
        {
          traceRecord = new TraceRecord(traceDirective);
          analyzeTraceRecord(traceDirective,traceToken,traceRecord);
          isFirst = false;
        }
        else
          analyzeTraceRecord(traceDirective,traceToken,traceRecord);
      }
      else if( traceToken.is("trace_execute") )
      {
        traceAttr.setExecuteClause(token.getValue("trace_execute"));
      }  
      else if( traceToken.is("tracecase_name") )
      {
        analyzeTraceCaseToken( aClass , token );
        return;
      }
    }
    if( traceAttr.numberOfUmpleVariables() > 0 )
      traceDirective.addAttributeTraceItem(traceAttr);
  }


  /**
   * Analyze trace record in a trace directive
   */
  @umplesourcefile(line={226},file={"UmpleInternalParser_CodeTrace.ump"},javaline={5268},length={14})
   private void analyzeTraceRecord(TraceDirective traceDirective, Token token, TraceRecord traceRecord){
    String record = token.getValue("trace_record");
    Attribute attr = traceDirective.getUmpleClass().getAttribute(token.getValue("trace_record"));
    
    // trace only what is in the record entity
    if( token.getName().equals("only") )
      traceRecord.setRecordOnly(true);  
    // recording a String 
    else if( record.contains("\"") )
      traceRecord.addRecord(record);
    // recording an attribute
    else if( attr != null )
      traceRecord.addAttribute(attr);
  }


  /**
   * Analyze Trace Item Token whether trace item is an attribute or a method ... etc
   */
  @umplesourcefile(line={243},file={"UmpleInternalParser_CodeTrace.ump"},javaline={5288},length={64})
   private void analyzeTraceItem(Token traceToken, TraceDirective traceDirective, MethodTraceEntity mte, AttributeTraceItem traceAttr){
    UmpleVariable attr = traceDirective.getUmpleClass().getAttribute(traceToken.getValue("trace_entity"));
    attr = attr==null?traceDirective.getUmpleClass().getAssociationVariable(traceToken.getValue("trace_entity")):attr;
    String methodName = traceToken.getValue("trace_entity");
    
    // here, i faced a problem of finding traced state machine because
    // -> in UmpleClass there no getStateMachine( String stm ) which gets state by searching its name
    analyzeStateMachineTraceItem(traceToken,traceDirective);
    analyzeAssociationTraceItem(traceToken,traceDirective);
    if( traceToken.getName().equals("entry") )
    {
      mte.setEntry(true);
      
    }
    else if( traceToken.getName().equals("exit") )
    {
      mte.setExit(true);
    }
    
    // if trace entity is a method
    if( methodName != null && methodName.contains("("))
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
      traceAttr.setPosition(traceToken.getPosition());
      traceAttr.addUmpleVariable(attr);
       
      boolean wasSet = false;
      
      for(Token sub: traceToken.getParentToken().getSubTokens())
      {
        
        if(sub.is("traceOptions"))
        {
          traceAttr.setTraceSet(false);
          for(Token sub2: sub.getSubTokens())
          {
            if( "get".equals(sub2.getValue("option")) )
            {
              wasSet = true;
              traceAttr.setTraceGet(true);
            }
            if( "set".equals(sub2.getValue("option")) )
            {
              wasSet = true;
              traceAttr.setTraceSet(true);
            }
          }
        }
      }
      if(!wasSet)
      {
        traceAttr.setTraceSet(true);
      }
    }
  }

  @umplesourcefile(line={309},file={"UmpleInternalParser_CodeTrace.ump"},javaline={5358},length={134})
   private void analyzeStateMachineTraceItem(Token traceToken, TraceDirective traceDirective){
    List<StateMachine> stms = traceDirective.getUmpleClass().getStateMachines();
    StateMachine stm = null;
    State state = null;
    String stmTraceItem = traceToken.getValue("trace_entity");
    if( traceToken.getParentToken().getSubToken(1).numberOfSubTokens()>0){
      boolean isTransition = false;
      boolean isIn = false;
      boolean isOut = false;
      for(Token token:traceToken.getParentToken().getSubToken(1).getSubTokens()){
        if("transition".equals(token.getValue("option"))){
          isTransition = true;
        }
        if("in".equals(token.getValue("option"))){
          isIn = true;
        }
        if("out".equals(token.getValue("option"))){
          isOut = true;
        }
      }
      if(isTransition)
      {
        StateMachineTraceItem tracedStm = new StateMachineTraceItem(traceDirective);
        tracedStm.setIsOut(isOut);
        tracedStm.setIsIn(isIn);
        tracedStm.setPosition(traceToken.getPosition());
        if( traceToken.getParentToken().getValue("trace_level")!=null )
        {
          tracedStm.setLevel(Integer.parseInt(traceToken.getParentToken().getValue("trace_level")));
        }
        for( StateMachine sm:stms  )
        {
          for( State nestedState:sm.getStates())
          {
            for( Transition tsn:nestedState.getTransitions())
            {
              if( tsn.getEvent().getName().equals(traceToken.getValue()) )
              {
                tracedStm.setTransition(tsn);
                tracedStm.setStateMachine(sm);
                traceDirective.addStateMachineTraceItem(tracedStm);
              }
            }
          }
        }
      }
    }
    if( stmTraceItem != null && stmTraceItem.contains("."))
    {
      String delimiter = "\\.";
      String[] temp = stmTraceItem.split(delimiter);
      stmTraceItem = temp[temp.length-1];
    }
    if(stm==null)
    {
      for( StateMachine sm:stms )
      {
        state=sm.findState(stmTraceItem, true);
        if(state!=null)
        {
          stm=state.getStateMachine();
          break;
        }
      }
    }
    if(stm==null)
    {
      for( StateMachine sm:stms )
      {
        if( sm.getFullName().equals(stmTraceItem))
        {
          stm = sm;
          break;
        }            
      }
    }
    //System.out.println(stmTraceItem+"<>"+stm);  
    // if trace entity is a state machine  
    if( stm != null)
    {  
      StateMachineTraceItem tracedStm = new StateMachineTraceItem(traceDirective);
      tracedStm.setPosition(traceToken.getPosition());  
      tracedStm.setStateMachine(stm);
      tracedStm.setState(state);
      if( traceToken.getParentToken().getValue("trace_level")!=null )
      {
        tracedStm.setLevel(Integer.parseInt(traceToken.getParentToken().getValue("trace_level")));
      }
      for(Token sub: traceToken.getParentToken().getSubTokens())
      {
        if(sub.is("traceOptions"))
        {
          boolean wasSet = false;
          boolean wasInOut = false;
          for(Token sub2: sub.getSubTokens())
          {
            if( "entry".equals(sub2.getValue("option")) )
            {
              wasSet = true;
              tracedStm.setEntry(true);
            }
            if( "exit".equals(sub2.getValue("option")) )
            {
              wasSet = true;
              tracedStm.setExit(true);
            }
            if( "in".equals(sub2.getValue("option")) )
            {
              wasInOut = true;
              tracedStm.setIsIn(true);
            }
            if( "out".equals(sub2.getValue("option")) )
            {
              wasInOut = true;
              tracedStm.setIsOut(true);
            }
          }
          if(!wasSet)
          {
            tracedStm.setEntry(false);
            tracedStm.setExit(false);
          }
          if(!wasInOut)
          {
            tracedStm.setIsOut(true);
            tracedStm.setIsIn(false);
          }
        }
      }
      tracedStm.setTraceStateMachineFlag(state == null);
      traceDirective.addStateMachineTraceItem(tracedStm);
      
    }
  }

  @umplesourcefile(line={445},file={"UmpleInternalParser_CodeTrace.ump"},javaline={5494},length={12})
   private void analyzeAssociationTraceItem(Token traceToken, TraceDirective traceDirective){
    if( traceToken.getParentToken().getSubToken(1).getName().equals("cardinality") )  
    {
      for( AssociationVariable aVar : traceDirective.getUmpleClass().getAssociationVariables() )
      {
        if( traceToken.getValue("trace_entity").equals(aVar.getName()))
          traceDirective.setAssociationVariable(aVar);
      }
      
      
    }
  }


  /**
   * Analyze Trace Condition Token. Called when different Trace Directive conditions are encountered (where,until,after)
   * Returns a trace condition filled with left and right hands operands, with comparison operator used
   */
  @umplesourcefile(line={461},file={"UmpleInternalParser_CodeTrace.ump"},javaline={5508},length={16})
   private TraceCondition analyzeTraceCondition(Token traceConditionToken, String conditionType){
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


  /**
   * Analyzes trace case token and its subtokens (i.e. trace directive tokens)
   */
  @umplesourcefile(line={480},file={"UmpleInternalParser_CodeTrace.ump"},javaline={5531},length={25})
   public void analyzeTraceCaseToken(UmpleClass aClass, Token token){
    TraceCase tca = new TraceCase();
    TraceDirective td = new TraceDirective(model.getTracer());
    td.setUmpleClass(aClass);
    // set trace case name
    tca.setName(token.getValue("tracecase_name"));
    
    for( Token traceToken : token.getSubTokens() )
    { 
      // "trace" indicates the beginning of a trace directive
      if( traceToken.getName().equals("trace") )
      {
        td = new TraceDirective(model.getTracer());
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


  /**
   * Modified version of method "analyzeTraceDirective"
   * This method analyzes trace directive fragments inside a trace case
   */
  @umplesourcefile(line={509},file={"UmpleInternalParser_CodeTrace.ump"},javaline={5562},length={43})
   private void analyzeTraceDirectiveFragments(TraceDirective traceDirective, UmpleClass aClass, Token traceToken, Token token){
    AttributeTraceItem traceAttr = new AttributeTraceItem(traceDirective);
      MethodTraceEntity mte = new MethodTraceEntity();
      
      if( traceToken.is("trace_entity") )  
      {
        analyzeTraceItem( traceToken , traceDirective , mte, traceAttr );
      }
      else if( traceToken.getName().equals("entry") )
      {
        mte.setEntry(true);  
      }  
      else if( traceToken.getName().equals("exit") )  
      {   
        mte.setExit(true);      
      }     
      else if( traceToken.is("traceWhen") ) //for where/giving/after/until
      {
        //gets the string containing the condition's type
      String conditionType = traceToken.getValue("conditionType");
        TraceCondition tc = analyzeTraceCondition( traceToken, conditionType );
      traceDirective.addCondition(tc);
      }      
      else if( traceToken.is("trace_for") )    
      {  
        //traceAttr.setForClause(Integer.parseInt(token.getValue("trace_for")));     
      }          
      else if( traceToken.is("trace_period") )     
      {    
        traceAttr.setPeriodClause(token.getValue("trace_period"));       
      }         
      else if( traceToken.is("trace_duration") )     
      {     
        traceAttr.setDuringClause(token.getValue("trace_duration"));       
      }         
      else if( traceToken.is("trace_execute") )     
      {   
        traceAttr.setExecuteClause(token.getValue("trace_execute"));     
      }
      
      if( traceAttr.numberOfUmpleVariables() > 0 )
        traceDirective.addAttributeTraceItem(traceAttr);
  }


  /**
   * Perform post token analysis on trace related elements of the Umple language
   */
  @umplesourcefile(line={555},file={"UmpleInternalParser_CodeTrace.ump"},javaline={5612},length={3})
   private void postTokenTraceAnalysis(){
    
  }


  /**
   * Analyze layout tokens to the Umple language
   */
  @umplesourcefile(line={21},file={"UmpleInternalParser_CodeLayout.ump"},javaline={5621},length={3})
   private void analyzeLayoutToken(Token token, int analysisStep){
    
  }


  /**
   * There are currently no core tokens of concern in the context of an UmpleClass
   * This method is available if needed
   */
  @umplesourcefile(line={27},file={"UmpleInternalParser_CodeLayout.ump"},javaline={5630},length={38})
   private void analyzeLayoutToken(Token token, UmpleClass aClass, int analysisStep){
    // Only process layout tokens once all other entities have been analyzed
    if (analysisStep == 1 || shouldProcessClassAgain)
    {
      shouldProcessClassAgain = true;
      return;
    }
  
    if (token.is("elementPosition"))
    {
      aClass.setCoordinates(new Coordinate(token.getIntValue("x"),token.getIntValue("y"), token.getIntValue("width"), token.getIntValue("height")));
    }
    else if (token.is("displayColor"))
    { // See near clone in UmpleInternalParser_CodeClass.ump
      String theColor = token.getValue("colorValue");
      if(theColor.startsWith("=")) theColor=theColor.substring(1,theColor.length());
      if(!theColor.startsWith("\"")) theColor= "\""+theColor;
      if(!theColor.endsWith("\"")) theColor= theColor+"\"";
      aClass.setDisplayColor(theColor);
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


  /**
   * Perform post token analysis on core elements of the Umple language
   */
  @umplesourcefile(line={68},file={"UmpleInternalParser_CodeLayout.ump"},javaline={5675},length={3})
   private void postTokenLayoutAnalysis(){
    layoutNewElements();
  }


  /**
   * Look for any new elements and give them positions if undefined
   */
  @umplesourcefile(line={74},file={"UmpleInternalParser_CodeLayout.ump"},javaline={5684},length={53})
   private void layoutNewElements(){
    // layout classes
    for (int i=0; i<model.numberOfUmpleClasses(); i++)
    {
      UmpleClass c = model.getUmpleClass(i);

      if (c.getCoordinates().getStatus() == Coordinate.Status.Defaulted)
      {
        // Do nothing
      }
      else if (c.getCoordinates().getStatus() == Coordinate.Status.Undefined)
      {
        c.setCoordinates(model.getDefaultClassPosition(i+1));
        c.getCoordinates().setStatus(Coordinate.Status.Defaulted);
      }
    }

    // layout interfaces
    for (int i=0; i<model.numberOfUmpleInterfaces(); i++)
    {
      UmpleInterface c = model.getUmpleInterface(i);

      if (c.getCoordinates().getStatus() == Coordinate.Status.Defaulted)
      {
        // Do nothing
      }
      else if (c.getCoordinates().getStatus() == Coordinate.Status.Undefined)
      {
        c.setCoordinates(model.getDefaultClassPosition(i+1));
        c.getCoordinates().setStatus(Coordinate.Status.Defaulted);
      }
    }

    // Layout associations
    for (int i=0; i<model.numberOfAssociations(); i++)
    {
      Association a = model.getAssociation(i);
      
      if (associationIsBetweenClassAndInterface (a)){continue;}
      
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
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={355},file={"UmpleInternalParser_CodeClass.ump"},javaline={5746},length={57})
  @umplesourcefile(line={356},file={"UmpleInternalParser_CodeClass.ump"},javaline={5747},length={27})
  private List <UmpleInterface> recursiveCycleCheckInterface (List <UmpleInterface> extend,UmpleInterface parent, HashMap<UmpleInterface, Boolean> map) 
  {
    List <UmpleInterface> temp = new ArrayList <UmpleInterface>();

    if(extend == null|| extend.isEmpty())
      return temp;


    for (UmpleInterface I: extend){
      if(map.containsKey(I)){
        temp.add(I);
        return temp;
      }
      map.put(I, true);    

      for (UmpleInterface EI: I.getExtendsInterface()){
        if(parent.equals(EI)){
          temp.add(EI);
          return temp;
        }  
      }
      List <UmpleInterface> temptemp = recursiveCycleCheckInterface(I.getExtendsInterface(), parent, map);
      temp.addAll(temptemp);
    }  

    return temp;
  }

//  @umplesourcefile(line={660},file={"UmpleInternalParser_CodeClass.ump"},javaline={5776},length={28})
  @umplesourcefile(line={661},file={"UmpleInternalParser_CodeClass.ump"},javaline={5777},length={24})
  private void addExtendsTo (Token classifierToken, UmpleClassifier aClassifier, Map <UmpleClassifier,List <String>> unlinkedExtends, Map <UmpleClassifier, List<Token>> unlinkedExtendsTokens)
  //private void addExtendsTo(Token classToken, UmpleClassifier aClassifier) 
  {
    List<String> extendsList = new ArrayList<String>();
    List<Token> extendsTokenList = new ArrayList<Token>();

    // Go through all sub-tokens of the class token to add subclasses related to the Umple class.
    for (Token extendsToken : classifierToken.getSubTokens())
    {
      if (extendsToken.getValue("extendsName") != null)
      { 
        extendsList.add(extendsToken.getValue("extendsName"));
        extendsTokenList.add(extendsToken); // With this line we really don't need the above, todo: refactor
        unlinkedExtends.put(aClassifier, extendsList);
        unlinkedExtendsTokens.put(aClassifier, extendsTokenList);
      }  
    }
  	//Checks list of extends tokens to prevent multiple class inheritance
		if(numberOfExtendsClass(extendsTokenList) > 1)
		{
			Token t = extendsTokenList.get(0);			
			getParseResult().addErrorMessage(new ErrorMessage(34,t.getPosition(),aClassifier.getName(),t.getValue()));
		}
  }

//  @umplesourcefile(line={24},file={"UmpleInternalParser_CodeStateMachine.ump"},javaline={5803},length={2})
  private static int numberOfActiveObjects = 1 ;

  
}