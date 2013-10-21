/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.parser.analysis;
import java.io.*;
import java.util.*;
import cruise.umple.compiler.*;
import cruise.umple.parser.rules.*;
import java.util.*;
import cruise.umple.compiler.*;

/**
 * The rule based parser takes in umple grammar files and parses them into Rule objects(ChoiceRule, ChainRule, etc.). Really what happens is
 * that the rulebasedparser contstructs an initial rootToken that contains all the grammar rules, and then the grammaranalyzer turns those
 * into rules. Regardless, then we have a graph of rules which each has a parse function. The parse function is called on the root, and
 * the parsing begins. After that there is the cleanup, that is recovery if there was a failure or getting the rootToken and storing it
 * if not.
 * @umplesource GrammarParsing.ump 40
 * @umplesource GrammarParsing_Code.ump 70
 */
// line 40 "../../../../../src/GrammarParsing.ump"
// line 70 "../../../../../src/GrammarParsing_Code.ump"
public class RuleBasedParser
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RuleBasedParser Attributes
  private Token rootToken;
  private ParseResult parseResult;
  private List<String> grammarFiles;

  //RuleBasedParser Associations
  private Position failedPosition;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RuleBasedParser()
  {
    rootToken = null;
    parseResult = null;
    grammarFiles = new ArrayList<String>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRootToken(Token aRootToken)
  {
    boolean wasSet = false;
    rootToken = aRootToken;
    wasSet = true;
    return wasSet;
  }

  public boolean setParseResult(ParseResult aParseResult)
  {
    boolean wasSet = false;
    parseResult = aParseResult;
    wasSet = true;
    return wasSet;
  }

  public boolean addGrammarFile(String aGrammarFile)
  {
    boolean wasAdded = false;
    wasAdded = grammarFiles.add(aGrammarFile);
    return wasAdded;
  }

  public boolean removeGrammarFile(String aGrammarFile)
  {
    boolean wasRemoved = false;
    wasRemoved = grammarFiles.remove(aGrammarFile);
    return wasRemoved;
  }

  /**
   * the Root Token that will be contain the result of the parse of the umple file
   */
  public Token getRootToken()
  {
    return rootToken;
  }

  /**
   * The parse's result, it will either have the value of success or failure, and should not be null after a parse
   */
  public ParseResult getParseResult()
  {
    return parseResult;
  }

  public String getGrammarFile(int index)
  {
    String aGrammarFile = grammarFiles.get(index);
    return aGrammarFile;
  }

  public String[] getGrammarFiles()
  {
    String[] newGrammarFiles = grammarFiles.toArray(new String[grammarFiles.size()]);
    return newGrammarFiles;
  }

  public int numberOfGrammarFiles()
  {
    int number = grammarFiles.size();
    return number;
  }

  public boolean hasGrammarFiles()
  {
    boolean has = grammarFiles.size() > 0;
    return has;
  }

  public int indexOfGrammarFile(String aGrammarFile)
  {
    int index = grammarFiles.indexOf(aGrammarFile);
    return index;
  }

  public Position getFailedPosition()
  {
    return failedPosition;
  }

  public boolean setFailedPosition(Position aNewFailedPosition)
  {
    boolean wasSet = false;
    failedPosition = aNewFailedPosition;
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    failedPosition = null;
  }


  /**
   * Takes a root rule and uses it to start parsing. The result will be put into the root token passed. The parsing will be performed
   * on the file. data is a DataPackage which needs to be initialized(using the init(Position)) before passing to this function.
   * The data package will contain miscellaneous data that will be computed throughout the parsing, such as FailPosition(if parsing fails)
   * and the location of couples(brackets and quotes).
   */
  @umplesourcefile(line={79},file={"GrammarParsing_Code.ump"},javaline={150},length={14})
   public void parse(ChoiceRule root, Token token, String filename, ParserDataPackage data){
    parsing++;
    int parseResult = root.parse(token, 0,data.getInput().length(),data.getInput(),data);
    if(parseResult==data.getInput().length())
    {
      setRootToken(token);
    }
    else
    {
      setRootToken(token);
      setFailedPosition(data.getPosition());
    }
    parsing--;
  }


  /**
   * After being passed all the grammar files by the UmpleInternalParser, this function is called to compute all the rules that are associated
   * to the umple language. For some reason this is computationally expensive, future implementations will hopefully be able to speed this up.
   */
  @umplesourcefile(line={100},file={"GrammarParsing_Code.ump"},javaline={173},length={57})
   public void setupRules(){
    Terminal.space(" \\t");
  ChoiceRule rulename = new Terminal("rulename","[a-zA-Z0-9_]+",false);
  ChoiceRule definition = new RepeatableRule("definition",0,Integer.MAX_VALUE);
  ChoiceRule openbrace = new Terminal("openbrace","\\(",false).dontCare();
  ChoiceRule closebrace = new Terminal("closebrace","\\)",false).dontCare();
  ChoiceRule opencurl = new Terminal("opencurl","(\\{|\")",false);
  ChoiceRule closecurl = new Terminal("closecurl","(\\}|\")",false);
  ChoiceRule otherRule = new ChainRule("otherrule",new Terminal("open","\\Q[[\\E",false).dontCare(),rulename,new Terminal("close","\\Q]]\\E",false).dontCare()).dontCare();
  ChoiceRule spaceSeparated = new BalancedRule("token","[",
    new ChainRule("multi",
    new Terminal("premodifier","[~!=*]?[*]?"),
    new Terminal("tokenname","([|][|]|[a-zA-Z0-9_,-]+)"),
    new Terminal("valuecolon","[:>]?",false),
    new Terminal("value",".*",false)).dontCare(),"]").dontCare();
    ChoiceRule options = new ChoiceRule("options",
      new ChainRule("braced",opencurl,definition,closecurl),
      new ChainRule("anonymousRule",openbrace,definition,closebrace, new Terminal("modifier","[*+?]?",false)),
      new ChainRule("otherrule",otherRule,new Terminal("modifier","[*+?]?",false)),
      new ChainRule("token",spaceSeparated,new Terminal("modifier","[*+?]?")),
      new Terminal("separator","[|]",false),
      new Terminal("spaces","",true).dontCare(),
      new ChainRule("terminal",new Terminal("terminal","(\\Q-(\\E|\\Q-)\\E|[^ \\t\\n\"\\{\\(\\}\\)]+)",false))).dontCare();
      
  definition.add(options);
    
  ChoiceRule rule = new ChoiceRule("rule",
    new ChainRule("layout",
      rulename,
      new Terminal("modifier","[-]?",false),
      new Terminal("colon","[:]",false).dontCare(),
      definition, new Terminal("newline", "[\\n]",false).dontCare()
    ).dontCare()
  );
  
  ChoiceRule root = new RepeatableRule("rules",0,Integer.MAX_VALUE,
   new ChoiceRule("options",
   new Terminal("comment","//[^\\n]*\\n",false).dontCare(),
   new Terminal("newline2","\\n",false).dontCare(),
   rule).dontCare()
  ).dontCare();
          
  ParsingCouple.ignoreLevel = 1;
  Token rootToken = new Token("ROOT","");
  List<Thread> parsers = new ArrayList<Thread>();
  String[] keys = new String[]{"[","]"};
  for(String filename:grammarFiles)
    {
    ParserDataPackage data = new ParserDataPackage(filename);
    data.getKeys().put("[]",keys);
    data.init(null);
    parse(root,rootToken,filename, data);
  }
  analyzer = new GrammarAnalyzer();
  analyzer.analyze(rootToken);
  analyzer.setupTerminals();
  }


  /**
   * Takes an umple file and parses it. It returns the ParseResult.
   */
  @umplesourcefile(line={161},file={"GrammarParsing_Code.ump"},javaline={237},length={11})
   public ParseResult parse(UmpleFile file){
    if(analyzer==null)
    {
      setupRules();
    }
    analyzer.init(file);
    analyzer.execute();
    setRootToken(analyzer.getRootToken());
    setParseResult(analyzer.getParseResult());
    return getParseResult();
  }

  @umplesourcefile(line={174},file={"GrammarParsing_Code.ump"},javaline={254},length={11})
   public ParseResult parse(String ruleName, String input){
    if(analyzer==null)
    {
      setupRules();
    }
    analyzer.init(ruleName, input);
    analyzer.execute();
    setRootToken(analyzer.getRootToken());
    setParseResult(analyzer.getParseResult());
    return getParseResult();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "rootToken" + "=" + (getRootToken() != null ? !getRootToken().equals(this)  ? getRootToken().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "parseResult" + "=" + (getParseResult() != null ? !getParseResult().equals(this)  ? getParseResult().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "failedPosition = "+(getFailedPosition()!=null?Integer.toHexString(System.identityHashCode(getFailedPosition())):"null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={48},file={"GrammarParsing.ump"},javaline={280},length={5})
  public static int parsing = 0 ;

//  @umplesourcefile(line={94},file={"GrammarParsing_Code.ump"},javaline={283},length={2})
  private static GrammarAnalyzer analyzer = null ;

  
}