/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.parser.rules;
import java.util.*;
import cruise.umple.compiler.*;
import cruise.umple.parser.analysis.*;
import java.util.*;

/**
 * name : [[rule]] ( | [[rule]] )*
 * The basic parsing rule. Contains the neccassary components for most other parsing rules to function.
 * The basic structure is 1 -> * Rules.
 * Its own parse rule choses one of its sub-rules, and tries to parse that one(it does this in order, so it tries sub rule 0 first and 1 second and so on)
 * Parsing has three basic components, success of sub rules, token construction and then returning the new parse position
 * Success of subrules in the case of a Choice Rule is dependent on at least one sub rule being successful(not returning -1)
 * @umplesource ParsingRules.ump 10
 * @umplesource ParsingRules_Code.ump 1
 */
// line 10 "../../../../../src/ParsingRules.ump"
// line 1 "../../../../../src/ParsingRules_Code.ump"
public class ChoiceRule
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ChoiceRule Attributes
  private String name;
  private boolean negate;
  private ParserAction action;
  private ChoiceRule parent;
  private List<ChoiceRule> rules;
  private boolean dontDelete;
  private boolean optional;
  private StringBuilder firstValueBuilder;
  private boolean declared;
  private boolean reset;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ChoiceRule(String aName)
  {
    name = aName;
    negate = false;
    action = null;
    parent = null;
    rules = new ArrayList<ChoiceRule>();
    dontDelete = false;
    optional = false;
    firstValueBuilder = null;
    declared = false;
    reset = false;
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

  public boolean setNegate(boolean aNegate)
  {
    boolean wasSet = false;
    negate = aNegate;
    wasSet = true;
    return wasSet;
  }

  public boolean setAction(ParserAction aAction)
  {
    boolean wasSet = false;
    action = aAction;
    wasSet = true;
    return wasSet;
  }

  public boolean setParent(ChoiceRule aParent)
  {
    boolean wasSet = false;
    parent = aParent;
    wasSet = true;
    return wasSet;
  }

  public boolean addRule(ChoiceRule aRule)
  {
    boolean wasAdded = false;
    wasAdded = rules.add(aRule);
    return wasAdded;
  }

  public boolean removeRule(ChoiceRule aRule)
  {
    boolean wasRemoved = false;
    wasRemoved = rules.remove(aRule);
    return wasRemoved;
  }

  public boolean setDontDelete(boolean aDontDelete)
  {
    boolean wasSet = false;
    dontDelete = aDontDelete;
    wasSet = true;
    return wasSet;
  }

  public boolean setOptional(boolean aOptional)
  {
    boolean wasSet = false;
    optional = aOptional;
    wasSet = true;
    return wasSet;
  }

  public boolean setFirstValueBuilder(StringBuilder aFirstValueBuilder)
  {
    boolean wasSet = false;
    firstValueBuilder = aFirstValueBuilder;
    wasSet = true;
    return wasSet;
  }

  public boolean setDeclared(boolean aDeclared)
  {
    boolean wasSet = false;
    declared = aDeclared;
    wasSet = true;
    return wasSet;
  }

  public boolean setReset(boolean aReset)
  {
    boolean wasSet = false;
    reset = aReset;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public boolean getNegate()
  {
    return negate;
  }

  public ParserAction getAction()
  {
    return action;
  }

  public ChoiceRule getParent()
  {
    return parent;
  }

  public ChoiceRule getRule(int index)
  {
    ChoiceRule aRule = rules.get(index);
    return aRule;
  }

  public ChoiceRule[] getRules()
  {
    ChoiceRule[] newRules = rules.toArray(new ChoiceRule[rules.size()]);
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

  public int indexOfRule(ChoiceRule aRule)
  {
    int index = rules.indexOf(aRule);
    return index;
  }

  public boolean getDontDelete()
  {
    return dontDelete;
  }

  public boolean getOptional()
  {
    return optional;
  }

  public StringBuilder getFirstValueBuilder()
  {
    return firstValueBuilder;
  }

  public boolean getDeclared()
  {
    return declared;
  }

  public boolean getReset()
  {
    return reset;
  }

  public void delete()
  {}


  /**
   * For ease of use the ... is used here to help the user to input sub rules
   */
  @umplesourcefile(line={8},file={"ParsingRules_Code.ump"},javaline={231},length={7})
   public  ChoiceRule(String name, ChoiceRule... rules){
    this(name);
    for(ChoiceRule rule:rules)
    {
      this.add(rule);
    }
  }


  /**
   * Add sub rule
   */
  @umplesourcefile(line={19},file={"ParsingRules_Code.ump"},javaline={244},length={7})
   public boolean add(ChoiceRule rule){
    if(rule.parent==null)
    {
      rule.parent = this;
    }
    return rules.add(rule);
  }


  /**
   * Add sub rule at specific index
   */
  @umplesourcefile(line={30},file={"ParsingRules_Code.ump"},javaline={257},length={7})
   public void add(int i, ChoiceRule rule){
    if(rule.parent==null)
    {
      rule.parent = this;
    }
    rules.add(i,rule);
  }


  /**
   * Get sub rule
   */
  @umplesourcefile(line={41},file={"ParsingRules_Code.ump"},javaline={270},length={33})
   public ChoiceRule get(int index){
    if(index<rules.size())
	{
      return rules.get(index);
    }
	if(subrules!=null)
	{
	  synchronized(RuleBasedParser.choicerules)
	  {
        if(RuleBasedParser.choicerules.get(subrules[index])!=null)
        {
          if(index==rules.size())
          {
            rules.add(RuleBasedParser.choicerules.get(subrules[index]));
          }
	      return RuleBasedParser.choicerules.get(subrules[index]);
	    }
	    else 
	    {
		  RuleBasedParser.evaluate(subrules[index]);
		  if(index==rules.size())
          {
            rules.add(RuleBasedParser.choicerules.get(subrules[index]));
          }
		  return RuleBasedParser.choicerules.get(subrules[index]);
	    }
	  }
	}
	else
	{
	  return null;
	}
  }


  /**
   * Remove sub rule at specific index
   */
  @umplesourcefile(line={78},file={"ParsingRules_Code.ump"},javaline={309},length={3})
   public ChoiceRule remove(int index){
    return rules.remove(index);
  }


  /**
   * Index of sub rule
   */
  @umplesourcefile(line={85},file={"ParsingRules_Code.ump"},javaline={318},length={3})
   public int indexOf(ChoiceRule rule){
    return rules.indexOf(rule);
  }


  /**
   * Remove sub rule
   */
  @umplesourcefile(line={92},file={"ParsingRules_Code.ump"},javaline={327},length={3})
   public void remove(ChoiceRule rule){
    rules.remove(rule);
  }


  /**
   * Size of sub rules.
   */
  @umplesourcefile(line={99},file={"ParsingRules_Code.ump"},javaline={336},length={10})
   public int size(){
    if(subrules!=null)
    {
	  return subrules.length;
	}
	else 
	{
	  return rules.size();
	}
  }


  /**
   * Adds the self token to the parent token with the proper positions set for the self token.
   */
  @umplesourcefile(line={113},file={"ParsingRules_Code.ump"},javaline={352},length={6})
   public void addToken(Token parent, Token self, int from, int end, ParserDataPackage data){
    parent.addSubToken(self);
    
    self.setPosition(findPosition(from,data));
    self.setEndPosition(findPosition(end,data));
  }


  /**
   * Given an offset this function constructs the Position object using the ParserDataPackage's linenumbers hashmap
   */
  @umplesourcefile(line={123},file={"ParsingRules_Code.ump"},javaline={364},length={29})
   public Position findPosition(int lookfor, ParserDataPackage data){
    Set<Integer> keys = data.getLinenumbers().keySet();
    int offset = 0;
    int linenumber = 0;
    int offsetend = 0;
    int linenumberend = 0;
    int previous = 0;
    for(Integer key:keys)
    {
      if(key>=lookfor)
      {
        offset = lookfor-previous;
        linenumber = data.getLinenumbers().get(key);        
        break;
      }
      previous = key;
    }
    if(linenumber==0)
    {
      linenumber = 1;
      offset = lookfor;
    }
    return new Position(
        data.getFilename(),
        linenumber,
        offset,
        lookfor
        );
  }


  /**
   * For each sub token in the self token, this menthod adds it to the token Token
   */
  @umplesourcefile(line={156},file={"ParsingRules_Code.ump"},javaline={399},length={8})
   public void addAllTokens(Token token, Token self){
    for(int i=0;i<self.numberOfSubTokens();)
    {
      Token aSubToken = self.getSubToken(i);
      self.removeSubToken(aSubToken);
      token.addSubToken(aSubToken);
    }
  }


  /**
   * Tries to parse, if successful, will add a new Token to the token Token (if this rule is not negated). Returns the position where the parser
   * was able to get to. So, if the parse started at 9 and parsed the word "word" it would then be at 13 and would return that value.
   * If there is no sub rule which can parse the input, this function will return -1 to indicate a failure.
   */
  @umplesourcefile(line={170},file={"ParsingRules_Code.ump"},javaline={413},length={30})
   public int parse(Token token, int from, int max, String input, ParserDataPackage data){
    if(size()==0)
    {
      return from;
    }
    Token self = new Token(getName(),"START_TOKEN");
    for(int i=0;i<size();i++)
    {
      int parseResult = get(i).parse(self,from,max, input, data);
      if(parseResult!=-1)
      {
        if(!getNegate()&&from!=max)
        {
          addToken(token,self,from,parseResult,data);
        }
        else 
        {
          addAllTokens(token,self);
        }

        if(action!=null&&this.getName().equals("useStatement"))
        {
          action.onSuccess(getNegate()?token:self,data);
        }
        return parseResult;
      }
      self = new Token(getName(),"START_TOKEN");
    }
    return -1;
  }


  /**
   * Don't cares are things like spaces and anonymous rules which are
   */
  @umplesourcefile(line={204},file={"ParsingRules_Code.ump"},javaline={451},length={4})
   public ChoiceRule dontCare(){
    negate = true;
    return this;
  }


  /**
   * Computes whether this Rule is optional or not by checking if any of the optional sub rules are optional
   */
  @umplesourcefile(line={212},file={"ParsingRules_Code.ump"},javaline={461},length={16})
   public boolean isOptional(){
    if(optional)
    {
      return true;
    }
    optional  = true;
    for(ChoiceRule rule:getRules())
    {
      if(rule.isOptional())
      {
        return true;
      }
    }
    optional = false;
    return false;
  }


  /**
   * This function works, however it never called because the recursive decent into the
   */
  @umplesourcefile(line={233},file={"ParsingRules_Code.ump"},javaline={483},length={15})
   public void optimize(){
    if(!dontDelete&&negate&&optimizeCondition())
    {
      int index = parent.indexOf(this);
      if(index!=-1)
      {
        parent.remove(index);
        parent.add(index,get(0));
      }
      else
      {
        dontDelete = true;
      }
    }
  }


  /**
   * This function is used in the optimize method to decide whether this rule should be deleted
   */
  @umplesourcefile(line={253},file={"ParsingRules_Code.ump"},javaline={504},length={3})
   public boolean optimizeCondition(){
    return size()==1;
  }


  /**
   * For finding the first value of the next terminal in the rule.
   * Within the context of a choice rule this means any of the choices are a possibility
   */
  @umplesourcefile(line={262},file={"ParsingRules_Code.ump"},javaline={513},length={14})
   public String getFirstValue(){
    if(firstValueBuilder!=null)
    {
      return firstValueBuilder.toString();
    }
    firstValueBuilder = new StringBuilder();
    String pipe = "";
    for(int i=0;i<size();i++)
    {
      firstValueBuilder.append(pipe+get(i).getFirstValue());
      pipe = "|";
    }
    return firstValueBuilder.toString();
  }

  @umplesourcefile(line={278},file={"ParsingRules_Code.ump"},javaline={534},length={13})
   public void resetDeclare(){
    if(reset)
    {
      return;
    }
    reset = true;
    for(ChoiceRule rule:getRules())
    {
      rule.resetDeclare();
    }
    declared = false;
    reset = false;
  }

  @umplesourcefile(line={292},file={"ParsingRules_Code.ump"},javaline={549},length={21})
   public StringBuilder toDeclareString(StringBuilder builder){
    if(declared)
    {
      return builder;
    }
    declared = true;
    builder.append(getName()+hashCode()+"\n");
    builder.append(getClass().getSimpleName()+":"+getName()+":"+getName()+hashCode()+":"+getNegate()+":"+isOptional()+":");
    String pipe = "";
    for(ChoiceRule rule:rules)
    {
      builder.append(pipe+rule.getName()+rule.hashCode());
      pipe = ",";
    }
    builder.append("\n");
    for(int i=0;i<size();i++)
    {
      get(i).toDeclareString(builder);
    }
    return builder;
  }

  @umplesourcefile(line={315},file={"ParsingRules_Code.ump"},javaline={572},length={12})
   public StringBuilder toRedoRegexString(StringBuilder builder){
    if(declared)
    {
      return builder;
    }
    declared = true;
    for(ChoiceRule rule:getRules())
    {
      rule.toRedoRegexString(builder);
    }
    return builder;
  }

  @umplesourcefile(line={329},file={"ParsingRules_Code.ump"},javaline={586},length={12})
   public StringBuilder toCannotBeString(StringBuilder builder){
    if(declared)
    {
      return builder;
    }
    declared = true;
    for(ChoiceRule rule:getRules())
    {
      rule.toCannotBeString(builder);
    }
    return builder;
  }

  @umplesourcefile(line={343},file={"ParsingRules_Code.ump"},javaline={600},length={6})
   public void setSubrules(String string){
    if(string!=null)
    {
	  subrules = string.split(",");
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "negate" + ":" + getNegate()+ "," +
            "dontDelete" + ":" + getDontDelete()+ "," +
            "optional" + ":" + getOptional()+ "," +
            "declared" + ":" + getDeclared()+ "," +
            "reset" + ":" + getReset()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "action" + "=" + (getAction() != null ? !getAction().equals(this)  ? getAction().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "parent" + "=" + (getParent() != null ? !getParent().equals(this)  ? getParent().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "firstValueBuilder" + "=" + (getFirstValueBuilder() != null ? !getFirstValueBuilder().equals(this)  ? getFirstValueBuilder().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={26},file={"ParsingRules.ump"},javaline={626},length={2})
  private String[] subrules = null ;

  
}