/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.parser.rules;
import java.util.*;
import java.util.regex.*;
import cruise.umple.compiler.*;
import cruise.umple.parser.analysis.*;
import java.util.*;

/**
 * Terminals are the only rules that actually don't use sub rules, instead, they use regex to compute whether there is a successful parse.
 * for example if the parse position is at "String name;" the terminal which was created with the ~ (alphanumeric) symbol, will parse the
 * String(excluding whitespace) and will return the position so that the next parse position will be "name;"
 * @umplesource ParsingRules.ump 65
 * @umplesource ParsingRules_Code.ump 479
 */
// line 65 "../../../../../src/ParsingRules.ump"
// line 479 "../../../../../src/ParsingRules_Code.ump"
public class Terminal extends ChoiceRule
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Terminal Attributes
  private String regex;
  private String cannotBe;
  private Pattern cannotBePattern;
  private Pattern pattern;
  private Pattern pattern2;
  private boolean onlyValue;
  private boolean optional;
  private boolean lookBack;
  private boolean canBeNull;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  @umplesourcefile(line={496},file={"ParsingRules_Code.ump"},javaline={58},length={1})
  public Terminal(String aName, String aRegex)
  {
    super(aName);
    regex = aRegex;
    cannotBe = null;
    cannotBePattern = null;
    pattern = null;
    pattern2 = null;
    onlyValue = false;
    optional = false;
    lookBack = false;
    canBeNull = false;
    // line 496 "../../../../../src/ParsingRules_Code.ump"
    pattern = Pattern.compile("(("+regex+")).*",Pattern.DOTALL);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRegex(String aRegex)
  {
    boolean wasSet = false;
    regex = aRegex;
    wasSet = true;
    return wasSet;
  }

  @umplesourcefile(line={501},file={"ParsingRules_Code.ump"},javaline={80},length={1})
  public boolean setCannotBe(String aCannotBe)
  {
    boolean wasSet = false;
    cannotBe = aCannotBe;
    wasSet = true;
    // line 501 "../../../../../src/ParsingRules_Code.ump"
    cannotBePattern = Pattern.compile("["+space+"]*("+cannotBe+")["+space+"]*.*",Pattern.DOTALL);
    return wasSet;
  }

  public boolean setCannotBePattern(Pattern aCannotBePattern)
  {
    boolean wasSet = false;
    cannotBePattern = aCannotBePattern;
    wasSet = true;
    return wasSet;
  }

  public boolean setPattern(Pattern aPattern)
  {
    boolean wasSet = false;
    pattern = aPattern;
    wasSet = true;
    return wasSet;
  }

  public boolean setPattern2(Pattern aPattern2)
  {
    boolean wasSet = false;
    pattern2 = aPattern2;
    wasSet = true;
    return wasSet;
  }

  public boolean setOnlyValue(boolean aOnlyValue)
  {
    boolean wasSet = false;
    onlyValue = aOnlyValue;
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

  public boolean setLookBack(boolean aLookBack)
  {
    boolean wasSet = false;
    lookBack = aLookBack;
    wasSet = true;
    return wasSet;
  }

  public boolean setCanBeNull(boolean aCanBeNull)
  {
    boolean wasSet = false;
    canBeNull = aCanBeNull;
    wasSet = true;
    return wasSet;
  }

  /**
   * the inner regex(i.e. not the whitespace considerations or the neccessary trailing .*
   */
  public String getRegex()
  {
    return regex;
  }

  /**
   * A regex which, if matched by the parse, will cause the terminal to return -1(Failure). This is useful for such cases as a rolename consuming the "sorted" token
   */
  public String getCannotBe()
  {
    return cannotBe;
  }

  /**
   * The pattern associated to the cannotBe attribute
   */
  public Pattern getCannotBePattern()
  {
    return cannotBePattern;
  }

  /**
   * The main pattern, which is checked first for passing
   */
  public Pattern getPattern()
  {
    return pattern;
  }

  /**
   * Usually null except in the case where you have a premodifier-less token [token] and then an optional rule of some kind, which means that the first parse should try to parse as if the second rule is present, that is the regex becomes regex+nextRule.getFirstValue()
   */
  public Pattern getPattern2()
  {
    return pattern2;
  }

  /**
   * If true this is a STATIC token, which are things like braces and keywords
   */
  public boolean getOnlyValue()
  {
    return onlyValue;
  }

  /**
   * isOptional will return this value for Terminal
   */
  public boolean getOptional()
  {
    return optional;
  }

  /**
   * (not used)
   */
  public boolean getLookBack()
  {
    return lookBack;
  }

  /**
   * for determining whether "" is an acceptable parse
   */
  public boolean getCanBeNull()
  {
    return canBeNull;
  }

  public void delete()
  {
    super.delete();
  }


  /**
   * mustSpace being true makes sure that there is a space after the regex, false means that there is optional space.
   */
  @umplesourcefile(line={485},file={"ParsingRules_Code.ump"},javaline={218},length={6})
   public  Terminal(String name, String regex, boolean mustSpace){
    super(name);
    this.regex = regex;

    pattern = Pattern.compile("(["+space+"]*("+regex+")["+space+"]"+(mustSpace?"+":"*")+").*",Pattern.DOTALL);
  }


  /**
   * Returns the result of the regex matching the input string. Where the parseResult is the futurthest including spaces.
   */
  @umplesourcefile(line={508},file={"ParsingRules_Code.ump"},javaline={230},length={46})
   public int parse(Token token, int from, int max, String input, ParserDataPackage data){
    Matcher matcher = getPattern().matcher(input.substring(from,max));
    if(matcher.matches())
    {
      String matched = matcher.group(2);
      if(cannotBe!=null&&matched.matches(cannotBe)&&!getCannotBePattern().matcher(input.substring(from+matcher.group(1).length(),max)).matches())
      {
        return -1;
      }
      if(!getNegate())
      {
        if(!matched.equals("")||(canBeNull&&!getName().equals("extraCode")))
        {
          Token tok = onlyValue?new Token(matched.trim(),"STATIC"):new Token(getName(),matched.trim());
          addToken(token,tok,
              from,
              from+matcher.group(1).length(),data);
        }
      }
      return from+matcher.group(1).length();
    }
    else if(getPattern2()!=null)
    {
      matcher = getPattern2().matcher(input.substring(from,max));
      if(matcher.matches())
      {
        String matched = matcher.group(2);
        if(cannotBe!=null&&matched.matches(cannotBe)&&!getCannotBePattern().matcher(input.substring(from+matcher.group(1).length(),max)).matches())
        {
          return -1;
        }
        if(!getNegate())
        {
          if(!matched.equals("")||(canBeNull&&!getName().equals("extraCode")))
          {
            Token tok = onlyValue?new Token(matched.trim(),"STATIC"):new Token(getName(),matched.trim());
            addToken(token,tok,
                from,
                from+matcher.group(1).length(),data);
          }
        }
        return from+matcher.group(1).length();
      }
    }
    return -1;
  }


  /**
   * onlyValue is used for determining if the terminal is a token or a STATIC.
   */
  @umplesourcefile(line={559},file={"ParsingRules_Code.ump"},javaline={282},length={4})
   public ChoiceRule onlyValue(){
    onlyValue = true;
    return this;
  }


  /**
   * to set the space (for the grammar it's " \t", for the UmpleGrammar " \t\n"
   */
  @umplesourcefile(line={568},file={"ParsingRules_Code.ump"},javaline={292},length={3})
   public static  void space(String string){
    space = string;
  }


  /**
   * returns optional
   */
  @umplesourcefile(line={576},file={"ParsingRules_Code.ump"},javaline={301},length={3})
   public boolean isOptional(){
    return optional;
  }

  @umplesourcefile(line={581},file={"ParsingRules_Code.ump"},javaline={310},length={3})
   public String getFirstValue(){
    return regex;
  }


  /**
   * re-initializes the regex
   */
  @umplesourcefile(line={589},file={"ParsingRules_Code.ump"},javaline={315},length={4})
   public void redoRegex(String regex){
    this.regex = (isOptional()?"(":"")+regex+(isOptional()?")?":"");
    pattern = Pattern.compile("(["+space+"]*("+regex+")["+space+"]*).*",Pattern.DOTALL);
  }


  /**
   * re-initializes the regex with a given value that can follow the regex(this value should be commuted with getFirstValue).
   */
  @umplesourcefile(line={599},file={"ParsingRules_Code.ump"},javaline={325},length={12})
   public void redoRegex(String regex, String following, boolean optional){
    this.regex = (isOptional()?"(":"")+regex+(isOptional()?")?":"");	
    if(optional)
    {
    	pattern2 = Pattern.compile("(["+space+"]*("+regex+")["+space+"]*).*",Pattern.DOTALL);
    }
    pattern = Pattern.compile("(["+space+"]*("+regex+")["+space+"]*)("+following+").*",Pattern.DOTALL);	
	if(isOptional())
	{
	  setCannotBe(following);
	}
  }


  /**
   * This function removes the argument string from the regex
   */
  @umplesourcefile(line={615},file={"ParsingRules_Code.ump"},javaline={343},length={4})
   public void removeFromAllRegex(String replacement){
    this.regex = regex.replace(replacement,"");
    pattern = Pattern.compile("(["+space+"]*("+regex.replace(replacement,"")+")["+space.replace(replacement,"")+"]*).*",Pattern.DOTALL);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "regex" + ":" + getRegex()+ "," +
            "cannotBe" + ":" + getCannotBe()+ "," +
            "onlyValue" + ":" + getOnlyValue()+ "," +
            "optional" + ":" + getOptional()+ "," +
            "lookBack" + ":" + getLookBack()+ "," +
            "canBeNull" + ":" + getCanBeNull()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "cannotBePattern" + "=" + (getCannotBePattern() != null ? !getCannotBePattern().equals(this)  ? getCannotBePattern().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "pattern" + "=" + (getPattern() != null ? !getPattern().equals(this)  ? getPattern().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "pattern2" + "=" + (getPattern2() != null ? !getPattern2().equals(this)  ? getPattern2().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={101},file={"ParsingRules.ump"},javaline={372},length={2})
  static String space = " \\t";

  
}