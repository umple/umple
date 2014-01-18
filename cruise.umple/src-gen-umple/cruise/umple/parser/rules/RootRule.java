/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.parser.rules;
import java.util.*;
import cruise.umple.compiler.*;
import cruise.umple.parser.analysis.*;
import java.util.*;

/**
 * The only difference between a root rule and a choice rule is that after parsing the parse position must be at the end of the file for this rule to pass
 * @umplesource ParsingRules.ump 120
 * @umplesource ParsingRules_Code.ump 580
 */
// line 120 "../../../../../src/ParsingRules.ump"
// line 580 "../../../../../src/ParsingRules_Code.ump"
public class RootRule extends ChoiceRule
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RootRule(String aName)
  {
    super(aName);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }


  /**
   * For passing to super constructor.
   */
  @umplesourcefile(line={588},file={"ParsingRules_Code.ump"},javaline={46},length={3})
   public  RootRule(String name, ChoiceRule... rules){
    super(name,rules);
  }


  /**
   * Does exactly the same as the ChoiceRule, except it will return -1 if the parseResult was not the same as the input's length, i.e. it will fail if some of the file was not parsed.
   */
  @umplesourcefile(line={596},file={"ParsingRules_Code.ump"},javaline={55},length={18})
   public int parse(Token token, int from, int max, String input, ParserDataPackage data){
    Token self = new Token(getName(),"START_TOKEN");
    for(int i=0;i<this.size();++i)
    {
      int parseResult = get(i).parse(getNegate()?token:self,from, max, input, data);
      if(parseResult>=max)
      {
        if(!getNegate())
        {
          token.addSubToken(self);
        }
        return parseResult;
      }
      self = new Token(getName(),"START_TOKEN");
    }
    
    return -1;
  }

}