/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.parser.analysis;
import java.util.*;
import cruise.umple.compiler.*;
import cruise.umple.parser.rules.*;
import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

/**
 * The grammar analayzer deals with first analyzing the root token of the grammar files, and constructing the rule graph for the grammar
 * then it has a execute function which will use the rule graph in the parsing of the umple file.
 * @umplesource GrammarParsing.ump 158
 * @umplesource GrammarParsing_Code.ump 535
 */
// line 158 "../../../../../src/GrammarParsing.ump"
// line 535 "../../../../../src/GrammarParsing_Code.ump"
public class GrammarAnalyzer extends Analyzer
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GrammarAnalyzer Attributes
  private Getter<ChoiceRule> rules;
  private Getter<Stack<ChoiceRule>> stacks;
  private Getter<Analyzer> analyzers;
  private Getter<String> strings;
  private Getter<Integer> ints;
  private HashMap<String,ParserAction> actionedTokens;
  private HashMap<String,String[]> keys;
  private List<RuleBasedParserThread> threads;
  private UmpleFile umpleFile;
  private String input;
  private ParseResult parseResult;
  private List<Terminal> openTerminal;
  private List<Terminal> closeTerminal;
  private List<Terminal> optionalTerminal;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  @umplesourcefile(line={540},file={"GrammarParsing_Code.ump"},javaline={68},length={29})
  public GrammarAnalyzer()
  {
    super();
    rules = new Getter<ChoiceRule>();
    stacks = new Getter<Stack<ChoiceRule>>();
    analyzers = new Getter<Analyzer>();
    strings = new Getter<String>();
    ints = new Getter<Integer>();
    actionedTokens = new HashMap<String,ParserAction>();
    keys = new HashMap<String,String[]>();
    threads = new ArrayList<RuleBasedParserThread>();
    umpleFile = null;
    input = null;
    parseResult = null;
    openTerminal = new ArrayList<Terminal>();
    closeTerminal = new ArrayList<Terminal>();
    optionalTerminal = new ArrayList<Terminal>();
    // line 540 "../../../../../src/GrammarParsing_Code.ump"
    actionedTokens.put("useStatement", new ParserAction()
        {
          @Override
          public void onSuccess(Token token, ParserDataPackage data)
          {
            String value = token.getValue("use");
            synchronized(data.getHasParsed())
            {
              if(!data.getHasParsed().contains(value))
              {
                data.getHasParsed().add(value);
                RuleBasedParserThread thread = new RuleBasedParserThread(
                  rules.get("$ROOT$"),
                  token,
                  umpleFile.getPath() + File.separator+value,
                  data);
                threads.add(thread);
                thread.start();
              }
            }
          }
        });
        set("anon_index",0);
        set("analyzer",new Analyzer());
        set("stack",new Stack<ChoiceRule>());//new RuleStack());
        ChoiceRule root = new ChoiceRule("root");
        stacks.get("stack").push(root);
        Terminal.space(" \\t\\n");
        ParsingCouple.ignoreLevel = -1;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRules(Getter<ChoiceRule> aRules)
  {
    boolean wasSet = false;
    rules = aRules;
    wasSet = true;
    return wasSet;
  }

  public boolean setStacks(Getter<Stack<ChoiceRule>> aStacks)
  {
    boolean wasSet = false;
    stacks = aStacks;
    wasSet = true;
    return wasSet;
  }

  public boolean setAnalyzers(Getter<Analyzer> aAnalyzers)
  {
    boolean wasSet = false;
    analyzers = aAnalyzers;
    wasSet = true;
    return wasSet;
  }

  public boolean setStrings(Getter<String> aStrings)
  {
    boolean wasSet = false;
    strings = aStrings;
    wasSet = true;
    return wasSet;
  }

  public boolean setInts(Getter<Integer> aInts)
  {
    boolean wasSet = false;
    ints = aInts;
    wasSet = true;
    return wasSet;
  }

  public boolean setActionedTokens(HashMap<String,ParserAction> aActionedTokens)
  {
    boolean wasSet = false;
    actionedTokens = aActionedTokens;
    wasSet = true;
    return wasSet;
  }

  public boolean setKeys(HashMap<String,String[]> aKeys)
  {
    boolean wasSet = false;
    keys = aKeys;
    wasSet = true;
    return wasSet;
  }

  public boolean addThread(RuleBasedParserThread aThread)
  {
    boolean wasAdded = false;
    wasAdded = threads.add(aThread);
    return wasAdded;
  }

  public boolean removeThread(RuleBasedParserThread aThread)
  {
    boolean wasRemoved = false;
    wasRemoved = threads.remove(aThread);
    return wasRemoved;
  }

  public boolean setUmpleFile(UmpleFile aUmpleFile)
  {
    boolean wasSet = false;
    umpleFile = aUmpleFile;
    wasSet = true;
    return wasSet;
  }

  public boolean setInput(String aInput)
  {
    boolean wasSet = false;
    input = aInput;
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

  public boolean addOpenTerminal(Terminal aOpenTerminal)
  {
    boolean wasAdded = false;
    wasAdded = openTerminal.add(aOpenTerminal);
    return wasAdded;
  }

  public boolean removeOpenTerminal(Terminal aOpenTerminal)
  {
    boolean wasRemoved = false;
    wasRemoved = openTerminal.remove(aOpenTerminal);
    return wasRemoved;
  }

  public boolean addCloseTerminal(Terminal aCloseTerminal)
  {
    boolean wasAdded = false;
    wasAdded = closeTerminal.add(aCloseTerminal);
    return wasAdded;
  }

  public boolean removeCloseTerminal(Terminal aCloseTerminal)
  {
    boolean wasRemoved = false;
    wasRemoved = closeTerminal.remove(aCloseTerminal);
    return wasRemoved;
  }

  public boolean addOptionalTerminal(Terminal aOptionalTerminal)
  {
    boolean wasAdded = false;
    wasAdded = optionalTerminal.add(aOptionalTerminal);
    return wasAdded;
  }

  public boolean removeOptionalTerminal(Terminal aOptionalTerminal)
  {
    boolean wasRemoved = false;
    wasRemoved = optionalTerminal.remove(aOptionalTerminal);
    return wasRemoved;
  }

  /**
   * Global variable getters and setters
   */
  public Getter<ChoiceRule> getRules()
  {
    return rules;
  }

  public Getter<Stack<ChoiceRule>> getStacks()
  {
    return stacks;
  }

  public Getter<Analyzer> getAnalyzers()
  {
    return analyzers;
  }

  public Getter<String> getStrings()
  {
    return strings;
  }

  public Getter<Integer> getInts()
  {
    return ints;
  }

  /**
   * currently only implemented with useStatement as the only element of this hashmap, but it is extendable, should the need arise.
   */
  public HashMap<String,ParserAction> getActionedTokens()
  {
    return actionedTokens;
  }

  /**
   * The keys that will be used by the couples of this hash map
   */
  public HashMap<String,String[]> getKeys()
  {
    return keys;
  }

  public RuleBasedParserThread getThread(int index)
  {
    RuleBasedParserThread aThread = threads.get(index);
    return aThread;
  }

  public RuleBasedParserThread[] getThreads()
  {
    RuleBasedParserThread[] newThreads = threads.toArray(new RuleBasedParserThread[threads.size()]);
    return newThreads;
  }

  public int numberOfThreads()
  {
    int number = threads.size();
    return number;
  }

  public boolean hasThreads()
  {
    boolean has = threads.size() > 0;
    return has;
  }

  public int indexOfThread(RuleBasedParserThread aThread)
  {
    int index = threads.indexOf(aThread);
    return index;
  }

  /**
   * Umple file that will be parsed(like Master.ump)
   */
  public UmpleFile getUmpleFile()
  {
    return umpleFile;
  }

  /**
   * filename of the file to be parsed
   */
  public String getInput()
  {
    return input;
  }

  /**
   * resulting parse result from the parse
   */
  public ParseResult getParseResult()
  {
    return parseResult;
  }

  public Terminal getOpenTerminal(int index)
  {
    Terminal aOpenTerminal = openTerminal.get(index);
    return aOpenTerminal;
  }

  public Terminal[] getOpenTerminal()
  {
    Terminal[] newOpenTerminal = openTerminal.toArray(new Terminal[openTerminal.size()]);
    return newOpenTerminal;
  }

  public int numberOfOpenTerminal()
  {
    int number = openTerminal.size();
    return number;
  }

  public boolean hasOpenTerminal()
  {
    boolean has = openTerminal.size() > 0;
    return has;
  }

  public int indexOfOpenTerminal(Terminal aOpenTerminal)
  {
    int index = openTerminal.indexOf(aOpenTerminal);
    return index;
  }

  public Terminal getCloseTerminal(int index)
  {
    Terminal aCloseTerminal = closeTerminal.get(index);
    return aCloseTerminal;
  }

  public Terminal[] getCloseTerminal()
  {
    Terminal[] newCloseTerminal = closeTerminal.toArray(new Terminal[closeTerminal.size()]);
    return newCloseTerminal;
  }

  public int numberOfCloseTerminal()
  {
    int number = closeTerminal.size();
    return number;
  }

  public boolean hasCloseTerminal()
  {
    boolean has = closeTerminal.size() > 0;
    return has;
  }

  public int indexOfCloseTerminal(Terminal aCloseTerminal)
  {
    int index = closeTerminal.indexOf(aCloseTerminal);
    return index;
  }

  public Terminal getOptionalTerminal(int index)
  {
    Terminal aOptionalTerminal = optionalTerminal.get(index);
    return aOptionalTerminal;
  }

  public Terminal[] getOptionalTerminal()
  {
    Terminal[] newOptionalTerminal = optionalTerminal.toArray(new Terminal[optionalTerminal.size()]);
    return newOptionalTerminal;
  }

  public int numberOfOptionalTerminal()
  {
    int number = optionalTerminal.size();
    return number;
  }

  public boolean hasOptionalTerminal()
  {
    boolean has = optionalTerminal.size() > 0;
    return has;
  }

  public int indexOfOptionalTerminal(Terminal aOptionalTerminal)
  {
    int index = optionalTerminal.indexOf(aOptionalTerminal);
    return index;
  }

  public void delete()
  {
    super.delete();
  }


  /**
   * Must be called before use with the execute function, this function sets up the file for parsing
   */
  @umplesourcefile(line={574},file={"GrammarParsing_Code.ump"},javaline={433},length={7})
   public void init(UmpleFile file){
    setUmpleFile(file);
    input = file.getPath()+File.separator+file.getFileName();
    setData(new ParserDataPackage(input));
    getData().setKeys(keys);
    getData().init(null);
  }

  @umplesourcefile(line={583},file={"GrammarParsing_Code.ump"},javaline={446},length={6})
   public void init(String ruleName, String input2){
    input = input2;
    setData(new ParserDataPackage("temp"));
    getData().setKeys(keys);
    getData().init(input,null);
  }


  /**
   * Performs the parsing on the umple file.
   */
  @umplesourcefile(line={593},file={"GrammarParsing_Code.ump"},javaline={454},length={43})
   public void execute(){
    setRootToken(new Token("ROOT",""));
    RuleBasedParser parser = new RuleBasedParser();
    parser.parse(rules.get("$ROOT$"),getRootToken(), input,getData());
    setRootToken(parser.getRootToken());
    while(threads.size()>0)
    {
      try 
      {
        RuleBasedParserThread thread = threads.remove(0);
        if(thread!=null)
        {
          thread.join();
        }
      } 
      catch (InterruptedException e)
      {
      }
    }
    setFailedPosition(parser.getFailedPosition());
    if(getFailedPosition()==null&&getData().getParseResult()==null)
    {
      setParseResult(new ParseResult(true));
    }
    else 
    {
      if(getData().getParseResult()!=null)
      {
        setParseResult(getData().getParseResult());
        return;
      }
      String badWord = getData().getInput().substring(getData().getPreviousFurthest(),getData().getFurthestGotten()).trim();
      int messageNumber = 1500;
      if("generate".equals(badWord) || "use".equals(badWord) || "strictness".equals(badWord) || "traceType".equals(badWord)) {
        messageNumber=1501;
      }
      else if("class".equals(badWord) || "association".equals(badWord) || "interface".equals(badWord) || "external".equals(badWord) || "associationClass".equals(badWord) || "stateMachine".equals(badWord)) {
        messageNumber=1502;
      }
      setParseResult(new ParseResult(false));
      getParseResult().addErrorMessage(new ErrorMessage(messageNumber,getFailedPosition(),badWord));
    }
  }


  /**
   * --Analyze Rule Methods
   * The rules token contains all the rules in a grammar file.
   */
  @umplesourcefile(line={642},file={"GrammarParsing_Code.ump"},javaline={503},length={3})
   public void rules(Token token){
    analyze(token);
  }


  /**
   * The rule token denotes the beginning of a rule definition.
   */
  @umplesourcefile(line={649},file={"GrammarParsing_Code.ump"},javaline={513},length={24})
   public void rule(Token token){
    if(rules.get(getValue(token,"rulename"))==null)
    {
      set(getValue(token,"rulename"),getFirst()?new RootRule(getValue(token,"rulename")):new ChoiceRule(getValue(token,"rulename")));
      if(getFirst())
      {
        set("$ROOT$",rules.get(getValue(token,"rulename")));
        setFirst(false);
      }
    }
    ChoiceRule self = rules.get(getValue(token,"rulename"));
    if(getValue(token,"modifier")!=null)
    {
      self.dontCare();
    }
    if(actionedTokens.get(self.getName())!=null)
    {
      self.setAction(actionedTokens.get(self.getName()));
    }
    stacks.get("stack").peek().add(self);
    stacks.get("stack").push(self);
    analyze(token);
    stacks.get("stack").pop();
  }


  /**
   * The definition token is used both for the rule definition, and anonymous rules(rules containsed within paratheses).
   */
  @umplesourcefile(line={678},file={"GrammarParsing_Code.ump"},javaline={543},length={8})
   public void definition(Token token){
    ChoiceRule self = new ChainRule("annoymous_multirule_"+ints.get("anon_index")).dontCare();
    set("anon_index",ints.get("anon_index")+1);
    stacks.get("stack").peek().add(self);
    stacks.get("stack").push(self);
    analyze(token);
    stacks.get("stack").pop();
  }


  /**
   * Otherrule tokens are for rule names within a definition, where the otherrule is defined elsewhere.
   */
  @umplesourcefile(line={690},file={"GrammarParsing_Code.ump"},javaline={557},length={38})
   public void otherrule(Token token){
    String modifier = getValue(token,"modifier");
    if(modifier!=null&&modifier.length()>0)
    {
      int start = 1;
      int end = 1;
      switch(getValue(token,"modifier").charAt(0))
      {
      case '*':
        start = 0;
        end = Integer.MAX_VALUE;
        break;
      case '?':
        start = 0;
        end = 1;
        break;
      case '+':
        start = 1;
        end = Integer.MAX_VALUE;
        break;
      }
      ChoiceRule star = new RepeatableRule("annoymous_starrule_"+ints.get("anon_index"),start,end).dontCare();
      set("anon_index",ints.get("anon_index")+1);
      stacks.get("stack").peek().add(star);
      stacks.get("stack").push(star);
    }

    if(rules.get(getValue(token,"rulename"))==null)
    {
      set(getValue(token,"rulename"),new ChoiceRule(getValue(token,"rulename")));
    }
    stacks.get("stack").peek().add(rules.get(getValue(token,"rulename")));  

    if(modifier!=null&&modifier.length()>0)
    {
      stacks.get("stack").pop();
    }
  }


  /**
   * Simple method to handle token values.
   */
  @umplesourcefile(line={732},file={"GrammarParsing_Code.ump"},javaline={601},length={11})
   public String getValue(Token token, String name){
    String value = null;
    for(Token sub:token.getSubTokens())
    {
      if(sub.is(name))
      {
        value = sub.getValue();
      }
    }
    return value;
  }


  /**
   * Terminals are keywords or syntax.
   */
  @umplesourcefile(line={748},file={"GrammarParsing_Code.ump"},javaline={618},length={56})
   public void terminal(Token token){
    String value = getValue(token,"terminal");
    value = value.replace("-(","(").replace("-)",")").replace("OPEN_ROUND_BRACKET","(").replace("CLOSE_ROUND_BRACKET",")");
    boolean following = false;
    boolean mustSpace = false;
    if(value.length()==0?false:(""+value.charAt(value.length()-1)).matches("[a-zA-Z]"))
    {
      int index = token.getParentToken().indexOfSubToken(token)+1;
      mustSpace = true;
    
      if(index!=0&&index<token.getParentToken().numberOfSubTokens())
      {
        while(index<token.getParentToken().numberOfSubTokens())
        {
          if(token.getParentToken().getSubToken(index).getName().equals("token"))
    	  {
    	    String premodifier = token.getParentToken().getSubToken(index).getValue("premodifier");
      	    if((premodifier!=null&&(premodifier.equals("")||premodifier.equals("~")))||premodifier==null)
      	    {
      	      following = true;
      	    }      	  
    	  }
    	  String modifier = token.getParentToken().getSubToken(index).getValue("modifier");
    	  if(modifier!=null&&(modifier.equals("*")||modifier.equals("?")))
    	  {
    		index++;
    	  }
    	  else
    	  {
    		break;
    	  }
        }
        if(index>=token.getParentToken().numberOfSubTokens())
        {
          index = token.getParentToken().numberOfSubTokens()-1;
        }
  	    if(token.getParentToken().getSubToken(index).getName().equals("terminal"))
  	    {
  	      mustSpace = (""+token.getParentToken().getSubToken(index).getSubToken(0).getValue("terminal").charAt(0)).matches("[a-zA-Z]");
  	    }
  	    else if(token.getParentToken().getSubToken(index).getName().equals("braced"))
	    {
	      mustSpace = false;
	    }
      }
    }
    Terminal terminal = new Terminal("anonymous_terminal_"+ints.get("anon_index"),"\\Q"+value+"\\E",mustSpace);
    if(following&&!mustSpace)
    {
      terminal.setCannotBe("\\Q"+value+"\\E"+"[a-zA-Z]+");
      terminal.redoRegex("\\Q"+value+"\\E"+"[a-zA-Z]*");
    }
    stacks.get("stack").peek().add(terminal.onlyValue());
    
    set("anon_index",ints.get("anon_index")+1);
  }


  /**
   * Tokens are of the form [{premodifier}tokenname{:value}] and denote a Terminal rule where the a Token is created with the value specified by some premodifier
   */
  @umplesourcefile(line={809},file={"GrammarParsing_Code.ump"},javaline={680},length={249})
   public void token(Token token){
    ChoiceRule terminal = null;
    String name = getValue(token,"tokenname");
    String premodifier = getValue(token,"premodifier");
    String modifier = getValue(token,"modifier");
    String value = getValue(token,"value");
    boolean makeTerminal = true;

    modifier = modifier==null?"":modifier;
    premodifier = premodifier==null?"":premodifier;
    value = value==null?"":value.replace("OPEN_ROUND_BRACKET","(").replace("CLOSE_ROUND_BRACKET",")");
    String regex;
    boolean post = false;
    if("-".equals(name)&&"||".equals(value))
    {
      name = "||";
      regex = "\\Q||\\E";
    }
    else if(name.contains(",")&&name.length()>1)
    {
      regex = "[^\\s\\{\\}\\(\\);,]+";
      String[] names = name.split(",");
      String[] numbers = value.split(",");
      for(int i=0;i<names.length;i++)
      {
        Terminal term = new Terminal(names[i],"("+regex+")"+(i<numbers.length?((numbers[i].equals("0"))?"":"?"):(i==0?"":"?")),false);
        stacks.get("stack").peek().add(term);    
      }
      return;
    }
    else
    {
      if("=".equals(premodifier))
      {
        if("".equals(value))
        {
          regex = "\\Q"+name+"\\E";
          value = name;
        }
        else
        {
          regex = value;
          Set<String> sorted = new TreeSet<String>(new Comparator<String>()
          {
            @Override
            public int compare(String o1, String o2)
            {  
              if (o1.length() > o2.length())
              {
                return -1;
              } 
              else if (o1.length() < o2.length())
              {
                return 1;
              }
              return o1.compareTo(o2);
           }
          });
          boolean first = true;
          boolean mustSpace = false;
          boolean allOne = true;
          for(String val:regex.split("\\Q|\\E"))
          {
            sorted.add(val);
            if(first)
            {
              mustSpace = val.length()==0?false:(""+val.charAt(val.length()-1)).matches("[a-zA-Z]");
              first = false;
            }
            else
            {
              if(mustSpace!=(val.length()==0?false:(""+val.charAt(val.length()-1)).matches("[a-zA-Z]")))
              {
                allOne = false;
              }
            }
          }

          int index = token.getParentToken().indexOfSubToken(token)+1;
          boolean canBeNotSpace = false;
          boolean following = false;
          if(index!=0&&index<token.getParentToken().numberOfSubTokens())
          {
            while(index<token.getParentToken().numberOfSubTokens())
            {
              if(token.getParentToken().getSubToken(index).getName().equals("token"))
    	      {
    	        String nextPremodifier = token.getParentToken().getSubToken(index).getValue("premodifier");
      	        if((nextPremodifier!=null&&(nextPremodifier.equals("")||nextPremodifier.equals("~")))||nextPremodifier==null)
      	        {
      	          following = true;
      	        }      	  
    	      }
    	      String nextModifier = token.getParentToken().getSubToken(index).getValue("modifier");
    	      if(nextModifier!=null&&(nextModifier.equals("*")||nextModifier.equals("?")))
    	      {
    	        index++;
    	      }
    	      else
    	      {
    	        break;
    	      }
            }
            if(index>=token.getParentToken().numberOfSubTokens())
            {
              index = token.getParentToken().numberOfSubTokens()-1;
            }
  	        if(token.getParentToken().getSubToken(index).getName().equals("terminal"))
  	        {
  	          canBeNotSpace = !(""+token.getParentToken().getSubToken(index).getSubToken(0).getValue("terminal").charAt(0)).matches("[a-zA-Z]");
  	        }
  	        else if(token.getParentToken().getSubToken(index).getName().equals("braced"))
	        {
	          canBeNotSpace = true;
	        }
          }
          else
          {
            canBeNotSpace = true;
          }

          regex = "";          
          
          if(!allOne)
          {
            terminal = new ChoiceRule(name).dontCare();
            
            for(String val:sorted)
            {
              if(!canBeNotSpace)
              {
                terminal.add(new Terminal(name,"\\Q"+val+"\\E",val.length()==0?false:(""+val.charAt(val.length()-1)).matches("[a-zA-Z]")));
              }
              else
              {
                terminal.add(new Terminal(name,"\\Q"+val+"\\E",false));
              }
            }
          }
          else
          {
            String pipe = "";
            for(String val:sorted)
            {
              regex += pipe + "\\Q"+val+"\\E";
              pipe = "|";
            }
            if(!canBeNotSpace)
            {
              terminal = new Terminal(name,regex,mustSpace);
            }
            else
            {
              terminal = new Terminal(name,regex,false);
              if(following)
              {
                ((Terminal)terminal).setCannotBe(regex+"[a-zA-Z]+");
                ((Terminal)terminal).redoRegex(regex+"[a-zA-Z]*");
              }
            }            
          }
          makeTerminal = false;
        }
      }
      else if("~".equals(premodifier))
      {
        regex = "[a-zA-Z_]([a-zA-Z0-9_]|-[a-zA-Z0-9_])*([ \\t]*<(([^\\{\\}\\(\\);\\n\\[\\]>]|\\[\\])*)>+)?";
      }
      else if("!".equals(premodifier))
      {
        regex = value;
      }
      else
      {
        regex = value;
        if(!"*".equals(premodifier)&&"".equals(value))
        {
          post = true;
        }
      }
    }
    if("**".equals(premodifier))
    {
      regex = ".*";
      post = true;
    }
    else if("*".equals(premodifier))
    {
      regex = "[^\\n]*\\n\\s*";
      ChoiceRule rule = stacks.get("stack").peek();
      if(rule.size()>0&&rule.get(0) instanceof Terminal)
      {
        ((Terminal)rule.get(0)).cannotHaveNewline();
      }
    }
    if(!"".equals(modifier))
    {
      regex = "("+regex+")"+modifier;
    }
    if(makeTerminal)
    {
      terminal = new Terminal(name,regex,false);
    }
    if("~".equals(premodifier))
    {
      closeTerminal.add((Terminal)terminal);
    }
    if("**".equals(premodifier))
    {
      terminal.setOptional(true);
      ((Terminal)terminal).setCanBeNull(true);
    }
    else if("*".equals(premodifier))
    {
      terminal = new Terminal(name,regex);
      terminal.setOptional(true);
    }
    if(post)
    {
      openTerminal.add((Terminal)terminal);
    }
    if(!"".equals(modifier))
    {
      int start = 1;
      int end = 1;
      switch(token.getValue("modifier").charAt(0))
      {
          case '*':
            start = 0;
            end = Integer.MAX_VALUE;
            break;
          case '?':
            start = 0;
            end = 1;
            break;
          case '+':
            start = 1;
            end = Integer.MAX_VALUE;
            break;
      }
      if(start==0)
      {
        terminal.setOptional(true);
      }
      terminal = new RepeatableRule("annoymous_starrule_"+ints.get("anon_index"),start,end,terminal).dontCare();
        set("anon_index",ints.get("anon_index")+1);
    }  
    stacks.get("stack").peek().add(terminal);
  }


  /**
   * These are rules that are specified within brackets, and are therefore not Tokenized.
   */
  @umplesourcefile(line={1063},file={"GrammarParsing_Code.ump"},javaline={935},length={34})
   public void anonymousRule(Token token){
    ChoiceRule rule = new ChoiceRule("annoymous_rule_"+ints.get("anon_index")).dontCare();
    set("anon_index",ints.get("anon_index")+1);
    int start = 1;
    int end = 1;
    String modifier = getValue(token,"modifier");
    if(modifier!=null&&modifier.length()>0)
    {
      switch(token.getValue("modifier").charAt(0))
      {
      case '*':
        start = 0;
        end = Integer.MAX_VALUE;
        break;
      case '?':
        start = 0;
        end = 1;
        break;
      case '+':
        start = 1;
        end = Integer.MAX_VALUE;
        break;
      }
    }
    ChoiceRule star = new RepeatableRule("annoymous_starrule_"+ints.get("anon_index"),start,end,rule).dontCare();
    set("anon_index",ints.get("anon_index")+1);

    stacks.get("stack").peek().add(star);
    stacks.get("stack").push(star);
    stacks.get("stack").push(rule);
    analyze(token);
    stacks.get("stack").pop();
    stacks.get("stack").pop();
  }


  /**
   * {} and "" are special couple characters and are handled by making a BalancedRule which will ensure that the { is paired with the proper } and so on
   */
  @umplesourcefile(line={1102},file={"GrammarParsing_Code.ump"},javaline={975},length={28})
   public void braced(Token token){
    ChoiceRule rule = new ChoiceRule("annoymous_rule_"+ints.get("anon_index")).dontCare();
    set("anon_index",ints.get("anon_index")+1);
    ChoiceRule multi = new ChainRule("annoymous_multirule_"+ints.get("anon_index")).dontCare();
    set("anon_index",ints.get("anon_index")+1);
    String open = getValue(token,"opencurl");
    String close = getValue(token,"closecurl");
    ChoiceRule couple = new BalancedRule("annoymous_braced_"+ints.get("anon_index"),
        open,
        rule,
        close).dontCare();
    String key = open+close;
    if(!keys.containsKey(key))
    {
      keys.put(key,new String[]{open,close});
    }
    set("anon_index",ints.get("anon_index")+1);
    multi.add(couple);

    stacks.get("stack").peek().add(multi);
    stacks.get("stack").push(couple);
    stacks.get("stack").push(multi);
    stacks.get("stack").push(rule);
    analyze(token);
    stacks.get("stack").pop();
    stacks.get("stack").pop();
    stacks.get("stack").pop();
  }


  /**
   * The separator token denotes the | in a rule. It means that everything before a separator is contained within one Rule and everything
   * after the | is contained in a separate Rule. The parent to both of these rules is a ChoiceRule, meaning that each of the rules created
   * will be tried.
   */
  @umplesourcefile(line={1136},file={"GrammarParsing_Code.ump"},javaline={1009},length={7})
   public void separator(Token token){
    stacks.get("stack").pop();
    ChoiceRule self = new ChainRule("annoymous_multirule_"+ints.get("anon_index")).dontCare();
    set("anon_index",ints.get("anon_index")+1);
    stacks.get("stack").peek().add(self);
    stacks.get("stack").push(self);
  }


  /**
   * There are some terminals that need to use their surroundings to determine what they can and cannot take on as values
   * this function iterates through all such terminals
   */
  @umplesourcefile(line={1149},file={"GrammarParsing_Code.ump"},javaline={1024},length={10})
   public void setupTerminals(){
    for(Terminal terminal:openTerminal)
    {
      setupTerminal(terminal);
    }
    for(Terminal terminal:closeTerminal)
    {
      setupAlphanumericTerminal(terminal);
    }
  }


  /**
   * Similar to the setupTerminal function this function makes sure that an alphanumeric does not take a value that is the value of then next terminal
   * for instance if an association looks like * -- 1 Student sorted { }; the rolename is student not sorted.
   * This works also for having * -- 1 Student sorted sorted { }; which will be a sorted list of students called sorted. (i.e. if the next one is accounted for then everything proceeds as normal)
   */
  @umplesourcefile(line={1165},file={"GrammarParsing_Code.ump"},javaline={1041},length={51})
   public void setupAlphanumericTerminal(Terminal terminal){
    ChoiceRule child = null;
    ChoiceRule parent = terminal;
    int index = 0;
    boolean optional = false;
    while(true)
    {
      child = parent;
      parent = parent.getParent();
      while(!(parent instanceof ChainRule)&&!(parent instanceof RepeatableRule))
      {
        child = parent;
        parent = parent.getParent();
        if(parent==null)
        {
          return;
        }
      }
      if(parent instanceof ChainRule)
      {
        index = parent.indexOf(child);
        if(index+1<parent.size())
        {
          optional = parent.get(index+1).isOptional();
          break;
        }
      }
      else if(parent instanceof RepeatableRule && ((RepeatableRule)parent).getMax()>1)
      {
        index = -1;
        optional = parent.isOptional();
        break;
      }
    }
    if(!"".equals(parent.get(index+1).getFirstValue()))
    {
      boolean shouldSet = false;
      for(String str:parent.get(index+1).getFirstValue().replace("\\Q", "").replace("\\E", "").split("|"))
      {
        if(str.matches(terminal.getRegex()))
        {
          shouldSet = true;
          break;
        }
      }
      if(shouldSet)
      {
        terminal.setCannotBe(parent.get(index+1).getFirstValue());
      }
    }
  }


  /**
   * Sets up the tokens with no premodifier to make sure they stop at the right place,
   * for instance [type] [=list[]]? should stop before the [], so the type only contains String, instead of String[]
   */
  @umplesourcefile(line={1223},file={"GrammarParsing_Code.ump"},javaline={1100},length={102})
   public void setupTerminal(Terminal terminal){
    ChoiceRule child = null;
    ChoiceRule parent = terminal;
    int index = 0;
    boolean optional = false;
    String value = "";
    while(true)
    {
      child = parent;
      parent = parent.getParent();
      while(!(parent instanceof ChainRule)&&!(parent instanceof BalancedRule)&&!(parent instanceof RepeatableRule))
      {
        child = parent;
        parent = parent.getParent();
        if(parent==null)
        {
          return;
        }
      }
      if(parent instanceof ChainRule)
      {
        index = parent.indexOf(child);
        if(index+1<parent.size())
        {
          optional = parent.get(index+1).isOptional();
          
          if(parent.get(index+1).getFirstValue().equals(""))
          {
            value = "";
          }
          else if(parent.get(index+1).getFirstValue().charAt(parent.get(index+1).getFirstValue().length()-1)=='?')
          {
        value = parent.get(index+1).getFirstValue().substring(0,parent.get(index+1).getFirstValue().length()-1);
        }
        else
        {
          value = parent.get(index+1).getFirstValue();
        }
        /* 
        Future developements: if you have a rule [rule1] [rule2]? [rule3]?
                              then rule1 should be optionally delimited by rule2 and rule3
                              currently it is only delimited by rule2
                              the code below does this, except it does not work when the rule 3 is an alphanumeric
          if(optional)
          {
            index++;
            while(index+1<parent.size()&&parent.get(index).isOptional())
            {
              if(parent.get(index+1).getFirstValue().charAt(parent.get(index+1).getFirstValue().length()-1)=='?')
              {
            value += "|"+parent.get(index+1).getFirstValue().substring(0,parent.get(index+1).getFirstValue().length()-1);
            }
            else
            {
              value += "|"+parent.get(index+1).getFirstValue();
            }              
              index++;
            }
          }*/
          break;
        }
      }
      else if(parent instanceof BalancedRule)
      {
        if(!terminal.getRegex().equals(".*"))
        {
          terminal.redoRegex("[^\\s\\{\\}\\(\\);,]+");
        }
        return;
      }
      else if(!terminal.getRegex().equals(".*")&&parent instanceof RepeatableRule && ((RepeatableRule)parent).getMax()>1)
      {
        value = parent.get(0).getFirstValue();
        optional = parent.isOptional();
        break;
      }
    }
    if(terminal.getRegex().equals(".*"))
    {
      if(!"".equals(value))
      {
        terminal.redoRegex("^((?!"+value+").)*");
      }
    }
    else 
    {
      if(!"".equals(value))
      {
        value = value.replace(
             "[a-zA-Z_]([a-zA-Z0-9_]|-[a-zA-Z0-9_])*([ \\t]*<(([^\\{\\}\\(\\);\\n\\[\\]>]|\\[\\])*)>+)?",
             "\\s[a-zA-Z_]([a-zA-Z0-9_]|-[a-zA-Z0-9_])*([ \\t]*<(([^\\{\\}\\(\\);\\n\\[\\]>]|\\[\\])*)>+)?");
        
        terminal.redoRegex("([^\\s\\{\\}\\(\\);,<]|<[^>]*>+)+",
          value,
          optional);
      }
      else
      {
        terminal.redoRegex("[^\\s\\{\\}\\(\\);,]+");
      }
    }
  }

  @umplesourcefile(line={1327},file={"GrammarParsing_Code.ump"},javaline={1209},length={37})
   public void analyze(Token tokens){
    for(Token token: tokens.getSubTokens())
    {
      if(token.is("rule"))
      {
        rule(token);
      }
      else if(token.is("definition"))
      {
        definition(token);
      }
      else if(token.is("otherrule"))
      {
        otherrule(token);
      }
      else if(token.is("anonymousRule"))
      {
        anonymousRule(token);
      }
      else if(token.is("token"))
      {
        this.token(token);
      }
      else if(token.is("separator"))
      {
        separator(token);
      }
      else if(token.is("terminal"))
      {
        terminal(token);
      }
      else if(token.is("braced"))
      {
        braced(token);
      }
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "input" + ":" + getInput()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "rules" + "=" + (getRules() != null ? !getRules().equals(this)  ? getRules().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "stacks" + "=" + (getStacks() != null ? !getStacks().equals(this)  ? getStacks().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "analyzers" + "=" + (getAnalyzers() != null ? !getAnalyzers().equals(this)  ? getAnalyzers().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "strings" + "=" + (getStrings() != null ? !getStrings().equals(this)  ? getStrings().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "ints" + "=" + (getInts() != null ? !getInts().equals(this)  ? getInts().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "actionedTokens" + "=" + (getActionedTokens() != null ? !getActionedTokens().equals(this)  ? getActionedTokens().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "keys" + "=" + (getKeys() != null ? !getKeys().equals(this)  ? getKeys().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "umpleFile" + "=" + (getUmpleFile() != null ? !getUmpleFile().equals(this)  ? getUmpleFile().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "parseResult" + "=" + (getParseResult() != null ? !getParseResult().equals(this)  ? getParseResult().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}