/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.0.352 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

public class Parser
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Parser Attributes
  private String name;
  private List<String> grammarRules;
  private ParseResult parseResult;
  private Token rootToken;

  //Parser Associations
  private List<Rule> rules;
  private List<Couple> couples;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Parser(String aName)
  {
    name = aName;
    grammarRules = new ArrayList<String>();
    parseResult = new ParseResult(true);
    rootToken = reset();
    rules = new ArrayList<Rule>();
    couples = new ArrayList<Couple>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean addGrammarRule(String aGrammarRule)
  {
    boolean wasAdded = false;
    wasAdded = grammarRules.add(aGrammarRule);
    return wasAdded;
  }

  public boolean removeGrammarRule(String aGrammarRule)
  {
    boolean wasRemoved = false;
    wasRemoved = grammarRules.remove(aGrammarRule);
    return wasRemoved;
  }

  public boolean setParseResult(ParseResult aParseResult)
  {
    boolean wasSet = false;
    parseResult = aParseResult;
    wasSet = true;
    return wasSet;
  }

  public boolean setRootToken(Token aRootToken)
  {
    boolean wasSet = false;
    rootToken = aRootToken;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getGrammarRule(int index)
  {
    String aGrammarRule = grammarRules.get(index);
    return aGrammarRule;
  }

  public String[] getGrammarRules()
  {
    String[] newGrammarRules = grammarRules.toArray(new String[grammarRules.size()]);
    return newGrammarRules;
  }

  public int numberOfGrammarRules()
  {
    int number = grammarRules.size();
    return number;
  }

  public boolean hasGrammarRules()
  {
    boolean has = grammarRules.size() > 0;
    return has;
  }

  public int indexOfGrammarRule(String aGrammarRule)
  {
    int index = grammarRules.indexOf(aGrammarRule);
    return index;
  }

  public ParseResult getParseResult()
  {
    return parseResult;
  }

  public Token getRootToken()
  {
    return rootToken;
  }

  public Rule getRule(int index)
  {
    Rule aRule = rules.get(index);
    return aRule;
  }

  public List<Rule> getRules()
  {
    List<Rule> newRules = Collections.unmodifiableList(rules);
    return newRules;
  }

  public int numberOfRules()
  {
    int number = rules.size();
    return number;
  }

  public boolean hasRules()
  {
    boolean has = rules.size() > 0;
    return has;
  }

  public int indexOfRule(Rule aRule)
  {
    int index = rules.indexOf(aRule);
    return index;
  }

  public Couple getCouple(int index)
  {
    Couple aCouple = couples.get(index);
    return aCouple;
  }

  public List<Couple> getCouples()
  {
    List<Couple> newCouples = Collections.unmodifiableList(couples);
    return newCouples;
  }

  public int numberOfCouples()
  {
    int number = couples.size();
    return number;
  }

  public boolean hasCouples()
  {
    boolean has = couples.size() > 0;
    return has;
  }

  public int indexOfCouple(Couple aCouple)
  {
    int index = couples.indexOf(aCouple);
    return index;
  }

  public static int minimumNumberOfRules()
  {
    return 0;
  }

  public boolean addRule(Rule aRule)
  {
    boolean wasAdded = false;
    if (rules.contains(aRule)) { return false; }
    rules.add(aRule);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRule(Rule aRule)
  {
    boolean wasRemoved = false;
    if (rules.contains(aRule))
    {
      rules.remove(aRule);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public static int minimumNumberOfCouples()
  {
    return 0;
  }

  public boolean addCouple(Couple aCouple)
  {
    boolean wasAdded = false;
    if (couples.contains(aCouple)) { return false; }
    couples.add(aCouple);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCouple(Couple aCouple)
  {
    boolean wasRemoved = false;
    if (couples.contains(aCouple))
    {
      couples.remove(aCouple);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public void delete()
  {
    rules.clear();
    couples.clear();
  }

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public Token reset()
  {
    rootToken = new Token(getName(),"ROOT", new Position(1,0,0));
    return rootToken;
  }
  
  public Rule getRule(String ruleName)
  {
    for (Rule r : rules)
    {
      if (r.getName().equals(ruleName))
      {
        return r;
      }
    }
    return null;
  }

  public String toString()
  {
    StringBuffer answer = new StringBuffer();
    toString(answer,rootToken);
    return answer.toString();
  }
  
  public String toGrammar()
  {
    StringBuilder answer = new StringBuilder();
    for(String rule : grammarRules)
    {
      if (answer.length() > 0)
      {
        answer.append("<br />\n");
      }
      
      String cleanedUpRule = rule;
      cleanedUpRule = cleanedUpRule.replace("OPEN_ROUND_BRACKET", "-(");
      cleanedUpRule = cleanedUpRule.replace("CLOSE_ROUND_BRACKET", "-)");
      cleanedUpRule = cleanedUpRule.replace("DOUBLE_OR_BARS", "-||");
      answer.append(cleanedUpRule);
    }
    return answer.toString();
  }
  
  public StringBuffer toString(StringBuffer stringSoFar, Token currentToken)
  {
    if ("START_TOKEN".equals(currentToken.getValue()))
    {
      stringSoFar.append("[" + currentToken.getName() + "]");
    }
    else if ("STATIC".equals(currentToken.getValue()))
    {
      //ignore
    }
    else if (!currentToken.equals(rootToken))
    {
      stringSoFar.append("[" + currentToken.getName() + ":" + currentToken.getValue() + "]");
    }
    
    for(Token subToken : currentToken.getSubTokens())
    {
      toString(stringSoFar,subToken);
    }
    return stringSoFar;
  }

  public void addRule(String input)
  {
    input = input.replace("-(","OPEN_ROUND_BRACKET");
    input = input.replace("-)","CLOSE_ROUND_BRACKET");
    input = input.replace("-||","DOUBLE_OR_BARS");
    
    grammarRules.add(input);
    TextParser ruleParser = new TextParser(input);
    String name = ruleParser.next();
    boolean shouldHide = false;
    if (name.endsWith("-"))
    {
      shouldHide = true;
      name = name.substring(0,name.length() - 1);
    }
    
    ruleParser.nextAt(":");
    int startIndex = ruleParser.previousIndex();
    
    int index = 0;
    Parser innerParser = new Parser("innerParser");
    while (ruleParser.lookFor("(",")",true) != null)
    {
      String anonymousRuleName = cruise.umple.util.StringFormatter.format("anonymous::{0}::{1}",name,++index);
      String anonymousRuleDefinition = ruleParser.name().substring(1,ruleParser.name().length() - 1).trim();
      innerParser.addRule(cruise.umple.util.StringFormatter.format("{0}- : {1}",anonymousRuleName,anonymousRuleDefinition));
      ruleParser.replace("[[" + anonymousRuleName + "]]");
    }
    ruleParser.reset(startIndex);
    ruleParser.nextAt(":");
    
    Rule newRule = new Rule(name);
    newRule.setShouldHide(shouldHide);
    while (ruleParser.nextUntil(false,"|") != null)
    {
      String definition = ruleParser.name();
      int innerStartIndex = ruleParser.previousIndex();
      while (isWithinVariable(definition))
      {
        ruleParser.nextAfter("]");
        ruleParser.nextUntil(false,"|");
        definition = ruleParser.extractFrom(innerStartIndex);
      }
      definition = definition.replace("OPEN_ROUND_BRACKET","(");
      definition = definition.replace("CLOSE_ROUND_BRACKET",")");
      definition = definition.replace("DOUBLE_OR_BARS","||");
      newRule.addDefinition(definition);
      ruleParser.nextAt("|");
    }
    rules.add(newRule);
    rules.addAll(innerParser.rules);
  }

  public ParseResult parse(String ruleName, String input)
  {
    TextParser inputParser = new TextParser(input);
    parseResult.setPosition(inputParser.currentPosition());
    boolean didParse = parse(ruleName, inputParser, rootToken, 0);
    parseResult.setWasSuccess(didParse);
    return parseResult;
  }

  private boolean parse(String ruleName, TextParser inputParser, Token parentToken, int level, String... stopAts)
  {
    for (Rule r : rules)
    {
      if (!r.getName().equals(ruleName))
      {
        continue;
      }
      
      Token currentToken = null;
      if (r.getShouldHide())
      {
        currentToken = parentToken;
      }
      else
      {
        currentToken = new Token(ruleName,"START_TOKEN",inputParser.currentPosition().copy()); 
      }
      
      for (String definition : r.getDefinitions())
      {
        int currentTokenSize = currentToken.numberOfSubTokens();
        boolean isSucceeding = true;
        int savedIndex = inputParser.currentIndex();
        
        RuleInstance instance = new RuleInstance(this);
        instance.configureDefinition(definition, stopAts);
        while (instance.hasMoreRuleParts())
        {
          Position startTokenPosition = inputParser.currentPosition().copy();
          RulePart part = instance.nextRulePart();
          String currentRule = part.getName();
          if (part.isStatic())
          {
            String inputValue = inputParser.nextAt(currentRule);
            if (inputValue == null)
            { 
              isSucceeding = false;
              break;
            }
            currentToken.addSubToken(new Token(inputValue, "STATIC", startTokenPosition));
            parseResult.setPosition(inputParser.currentPosition());
          }
          else if (part.isVariable())
          {
            String value = null;
            int startIndex = inputParser.currentIndex();
            if (part.isToEndOfLine())
            {
              value = inputParser.nextLine();
            }
            else if (part.getNextIdentifiers().length > 0)
            {
              boolean stopAtSpace = !part.isMultiWord() && !part.hasInnerNames();
              value = inputParser.nextUntil(stopAtSpace,part.getNextIdentifiers());

              while (part.isMultiWord() && !isBalanced(value))
              {
                int internalIndex = inputParser.currentIndex();
                inputParser.nextAt(part.getNextIdentifiers());
                String nextValue = inputParser.nextUntil(stopAtSpace,part.getNextIdentifiers());
                
                if (inputParser.peekAt(part.getNextIdentifiers()) == null)
                {
                  inputParser.reset(internalIndex);
                  break;
                }
                
                value = inputParser.extractFrom(startIndex);
                if (nextValue == null && inputParser.peekAt(part.getNextIdentifiers()) == null)
                {
                  break;
                }
              }
            }
            else if (part.isMultiWord())
            {
              value = inputParser.nextUntil(false,(String[])null);
            }
            else
            {
              value = inputParser.next();
            }
            
            if (part.isEnum() && !part.isEnumValue(value))
            {
              value = null;
            }
            
            if (part.hasInnerNames() && !part.isValidInnerValues(value))
            {
              value = null;
            }
            
            if (value == null && part.isOne())
            {
              isSucceeding = instance.removeOptionalPart();
              if (isSucceeding)
              {
                instance.resetRulePart();
                restorePrevious(inputParser,savedIndex,currentToken,currentTokenSize);
                continue;
              }
              else
              {
                break;
              }
            }
            else if (value == null)
            {
              instance.removeRulePart(part);
              instance.resetRulePart();
              restorePrevious(inputParser,savedIndex,currentToken,currentTokenSize);
              continue;
            }
            
            if (part.hasInnerNames())
            {
              RulePartValue[] allValues = part.getInnerValues(value);
              for (int innerI=0; innerI<allValues.length; innerI++)
              {
                String innerValue = allValues[innerI].getValue();
                if (innerValue == null)
                {
                  continue;
                }
                String innerName = allValues[innerI].getName();
                Position innerPosition = allValues[innerI].getPosition();
                currentToken.addSubToken(new Token(innerName,innerValue, startTokenPosition.add(innerPosition)));
              }
            }
            else
            {
              currentToken.addSubToken(new Token(part.getDisplayName(), value, startTokenPosition));
            }
          }
          else if (part.isRule())
          {
            if (part.isOne())
            {
              isSucceeding = parse(part.getName(),inputParser,currentToken,level+1,part.getNextIdentifiers());
            }
            else if (part.isOptional())
            {
              isSucceeding = true;
              boolean didParse = parse(part.getName(),inputParser,currentToken,level+1,part.getNextIdentifiers());
              if (!didParse)
              {
                instance.removeRulePart(part);
                instance.resetRulePart();
                restorePrevious(inputParser,savedIndex,currentToken,currentTokenSize);
                continue;
              }
            }
            else if (part.isMany())
            {
              int maxFound = part.getMaximumPartsFound();
              if (maxFound == 0)
              {
                instance.removeRulePart(part);
                instance.resetRulePart();
                restorePrevious(inputParser,savedIndex,currentToken,currentTokenSize);
                continue;
              }
            
              isSucceeding = true;
              int numberFoundSoFar = 0;
              while (part.isWithinLimits(numberFoundSoFar) && parse(part.getName(),inputParser,currentToken,level+1,part.getNextIdentifiers()))
              {
                numberFoundSoFar += 1;
              }
              part.setMaximumPartsFound(numberFoundSoFar - 2);
            }
          }
        }
        
        if (!isSucceeding)
        {
          restorePrevious(inputParser,savedIndex,currentToken,currentTokenSize);
        }
        else if (inputParser.peek() != null && level == 0)
        {
          restorePrevious(inputParser,savedIndex,currentToken,currentTokenSize);
          return false;
        }
        else
        {
          if (!r.getShouldHide())
          {
            parentToken.addSubToken(currentToken);
          }
          return true;
        }
      }
    }
    return false;
  }
  
  private void restorePrevious(TextParser inputParser, int savedIndex, Token currentToken, int size)
  {
    inputParser.reset(savedIndex);
    while (size < currentToken.numberOfSubTokens())
    {
      currentToken.remove(size);
    }
  }
  
  private boolean isWithinVariable(String definition)
  {
    int openBracket = definition.lastIndexOf("[");
    int closeBracket = definition.lastIndexOf("]");
    return openBracket > closeBracket;
  }
  
  private boolean isBalanced(String input)
  {
    for (Couple couple : couples)
    {
      if (!couple.isBalanced(input))
      {
        return false;
      }
    }
    return true;
  }
  
  public Token getToken(int index)
  {
    return rootToken.getSubToken(index);
  }
  
  public List<Token> getTokens()
  {
    return rootToken.getSubTokens();
  }

  public int numberOfTokens()
  {
    return rootToken.numberOfSubTokens();
  }

  public boolean hasTokens()
  {
    return numberOfTokens() > 0;
  }

  public int indexOf(Token aToken)
  {
    return rootToken.indexOfSubToken(aToken);
  }
}