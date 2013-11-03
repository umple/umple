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
 * @umplesource GrammarParsing_Code.ump 61
 */
// line 40 "../../../../../src/GrammarParsing.ump"
// line 61 "../../../../../src/GrammarParsing_Code.ump"
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
  @umplesourcefile(line={72},file={"GrammarParsing_Code.ump"},javaline={150},length={16})
   public void parse(ChoiceRule root, Token token, String filename, ParserDataPackage data){
    parsing++;
    data.setCouples(new HashMap<String,ParsingCouple>());
    BalancedRule.initialize(data.getInput(),data);
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

  @umplesourcefile(line={90},file={"GrammarParsing_Code.ump"},javaline={175},length={16})
   public void parse(ChoiceRule root, Token token, String filename, int line, ParserDataPackage data){
    parsing++;
    data.setCouples(new HashMap<String,ParsingCouple>());
    BalancedRule.initialize(data.getLine(line),data);
    int parseResult = root.parse(token, 0,data.getLine(line).length(),data.getLine(line),data);
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
   * 
   * After being passed all the grammar files by the UmpleInternalParser, this function is called to compute all the rules that are associated
   * to the umple language. For some reason this is computationally expensive, future implementations will hopefully be able to speed this up.
   */
  @umplesourcefile(line={112},file={"GrammarParsing_Code.ump"},javaline={193},length={173})
   public void setupRules(){
    BufferedReader reader = null;
    InputStream resourceStream = null;
    boolean mustParse = false;
    try {
      File rulesfile = new File(new File("cruise.umple").getAbsolutePath()+File.separator+"bin"+File.separator+"rules.grammar");

      if(rulesfile.exists()&&rulesfile.canRead())
      {
        reader = new BufferedReader(new FileReader(rulesfile));
      }
      else
      {
        resourceStream = getClass().getResourceAsStream(File.separator+"rules.grammar");
        if(resourceStream == null)
        {
          mustParse = true;
          reader = null;
        }
        else
        {
          reader = new BufferedReader(new InputStreamReader(resourceStream));  
        }          
      }
      if(mustParse)
      {
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

        ChoiceRule root = rule;

        ParsingCouple.ignoreLevel = 1;
        Token rootToken = new Token("ROOT","");
        List<Thread> parsers = new ArrayList<Thread>();
        String[] keys = new String[]{"[","]"};
        rootToken = new Token("ROOT","");
        for(String filename:grammarFiles)
        {
          ParserDataPackage data = new ParserDataPackage(filename);
          data.getKeys().put("[]",keys);
          data.init(null);
          for(int i=0;i<data.numberOfLines();++i){
            if(!data.getLine(i).startsWith("//")&&!data.getLine(i).startsWith("\n")){
              parse(root,rootToken,filename,i, data);
            }
          }
        }
        analyzer = new GrammarAnalyzer();
        analyzer.analyze(rootToken);
        analyzer.setupTerminals();
        if(rulesfile.exists()&&rulesfile.canWrite()){
        	rulesfile.delete();
        }
        if(!rulesfile.exists())
        {
          if(new File("cruise.umple"+File.separator+"bin"+File.separator+"umple_core.grammar").canWrite())
          {
            rulesfile.createNewFile();
          }
          if(!rulesfile.canWrite()){
        	  return;
          }
          BufferedWriter writer = new BufferedWriter(new FileWriter(rulesfile));
          writer.write("");
          writer.append(analyzer.getRules().get("$ROOT$").toDeclareString(new StringBuilder()));
          writer.append("//END DECLARE\n");
          analyzer.getRules().get("$ROOT$").resetDeclare();
          writer.append(analyzer.getRules().get("$ROOT$").toCannotBeString(new StringBuilder()));
          writer.append("//END CANNOTBE\n");
          analyzer.getRules().get("$ROOT$").resetDeclare();
          writer.append(analyzer.getRules().get("$ROOT$").toRedoRegexString(new StringBuilder()));
          writer.append("//END REDOREGEX\n");
          writer.close();

          analyzer.getRules().get("$ROOT$").resetDeclare();
        }
      }
      else if(reader!=null)
      {
        String program = null;
        String currentLine = reader.readLine();
        analyzer = new GrammarAnalyzer();

        analyzer.getKeys().put("{}", new String[]{"{","}"});    
        analyzer.getKeys().put("\"", new String[]{"\"","\""});

        while(currentLine!=null){    
          if(currentLine.equals("//END DECLARE")){
            currentLine = reader.readLine();
            break;
          }
          String value = reader.readLine();


          todeclare.put(currentLine,value);
          if(program==null){
            program = currentLine;          
          }
          currentLine = reader.readLine();
        }
        while(currentLine!=null)
        {
          if(currentLine.equals("//END CANNOTBE"))
          {
            currentLine = reader.readLine();
            break;
          }
          int colon = currentLine.indexOf(":");
          String name = currentLine.substring(0,colon);
          evaluate(name);
          ((Terminal)choicerules.get(name)).setCannotBe(currentLine.substring(colon+1));
          currentLine = reader.readLine();
        }
        while(currentLine!=null)
        {
          if(currentLine.equals("//END REDOREGEX"))
          {
            currentLine = reader.readLine();
            break;
          }
          int colon = currentLine.indexOf(":");
          String name = currentLine.substring(0,colon);
          int colon2 = currentLine.indexOf(":",colon+1);
          evaluate(name);
          String regex =((Terminal)choicerules.get(name)).getRegex();
          if(choicerules.get(name).getOptional())
          {
            regex = regex.substring(0,regex.length()-1);
          }
          ((Terminal)choicerules.get(name)).redoRegex(regex,currentLine.substring(colon2+1),Boolean.parseBoolean(currentLine.substring(colon+1,colon2)));
          currentLine = reader.readLine();
        }
        evaluate(program);
        analyzer.set("$ROOT$",choicerules.get(program));
        reader.close();
      }
    } 
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }


  /**
   * Takes an umple file and parses it. It returns the ParseResult.
   */
  @umplesourcefile(line={289},file={"GrammarParsing_Code.ump"},javaline={374},length={11})
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

  @umplesourcefile(line={302},file={"GrammarParsing_Code.ump"},javaline={391},length={11})
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

  @umplesourcefile(line={315},file={"GrammarParsing_Code.ump"},javaline={404},length={82})
   public static  boolean evaluate(String hash){
    String currentLine = todeclare.get(hash);
    if(currentLine==null)
    {
      return false;
    }
    String[] args = currentLine.split("[:]");
    String type = args[0];
    String name = args[1];
    if(type.equals("ChoiceRule"))
    {
      choicerules.put(hash,new ChoiceRule(name));
      if(name.equals("useStatement"))
      {
        choicerules.get(hash).setAction(analyzer.getActionedTokens().get("useStatement"));
      }
    }
    else if(type.equals("ChainRule"))
    {
      choicerules.put(hash,new ChainRule(name));
      
    }
    else if(type.equals("RepeatableRule"))
    {
      choicerules.put(hash,new RepeatableRule(name,Integer.parseInt(args[6]),Integer.parseInt(args[7])));
    }
    else if(type.equals("BalancedRule"))
    {
      choicerules.put(hash,new BalancedRule(name,args[6],args[7]));
    }
    else if(type.equals("RootRule")){
      choicerules.put(hash,new RootRule(name));
    }
    else if(type.equals("Terminal"))
    {
      String regex = currentLine.substring(
        currentLine.indexOf(":",
          currentLine.indexOf(":",
            currentLine.indexOf(":",
              currentLine.indexOf(":",
                currentLine.indexOf(":",
                  currentLine.indexOf(":",
                    currentLine.indexOf(":",
                      currentLine.indexOf(":",
                        currentLine.indexOf(":",
                          currentLine.indexOf(":",
                            currentLine.indexOf(":")+1)+1)+1)+1)+1)+1)+1)+1)+1)+1)+1);
      Terminal terminal = null;
      if(args[9].equals("true"))
      {
        terminal = new Terminal(name,regex);
      }
      else
      {
        terminal = new Terminal(name,regex,args[10].equals("true"));
      }
      if(args[6].equals("true"))
      {
        terminal.onlyValue();
      }
      if(args[7].equals("true"))
      {
        terminal.setCanBeNull(true);
      }
      if(args[8].equals("true"))
      {
        terminal.cannotHaveNewline();
      }
      choicerules.put(hash,terminal);
    }
    choicerules.get(hash).setNegate(args[3].equals("true"));
    choicerules.get(hash).setOptional(args[4].equals("true"));
    try
    {
      choicerules.get(hash).setSubrules(args[5]);
    }
    catch(Exception e)
    {

    }
    return true;
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
  //  @umplesourcefile(line={48},file={"GrammarParsing.ump"},javaline={501},length={11})
  public static int parsing = 0 ;

//  @umplesourcefile(line={50},file={"GrammarParsing.ump"},javaline={504},length={8})
  @umplesourcefile(line={51},file={"GrammarParsing.ump"},javaline={505},length={7})
  public static HashMap<String,ChoiceRule> choicerules = new HashMap<String,ChoiceRule>() ;

//  @umplesourcefile(line={51},file={"GrammarParsing.ump"},javaline={508},length={5})
  @umplesourcefile(line={52},file={"GrammarParsing.ump"},javaline={509},length={4})
  private static HashMap<String,String> todeclare = new HashMap<String,String>() ;

//  @umplesourcefile(line={64},file={"GrammarParsing_Code.ump"},javaline={512},length={2})
  private static GrammarAnalyzer analyzer = null ;

  
}