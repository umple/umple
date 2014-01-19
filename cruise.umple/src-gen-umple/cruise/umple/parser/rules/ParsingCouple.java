/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.parser.rules;
import java.util.*;
import cruise.umple.compiler.*;
import java.util.*;

/**
 * ParsingCouples are used by balanced rules to quickly find the corresponding brace. They are initialized at the begining of each file parsed
 * and are stored in the ParserDataPackage. They contain the character positions of each open brace and each close brace(when braces are the key)
 * so {{}} would have positionFrom = {1,2} and positionTo = {4,3}
 * ParsingCouples are used by balanced rules to quickly find the corresponding brace. They are initialized at the begining of each file parsed
 * and are stored in the ParserDataPackage. They contain the character positions of each open brace and each close brace(when braces are the key)
 * so {{}} would have positionFrom = {1,2} and positionTo = {4,3}
 * @umplesource ParsingRules.ump 149
 * @umplesource ParsingRules_Code.ump 920
 */
// line 149 "../../../../../src/ParsingRules.ump"
// line 920 "../../../../../src/ParsingRules_Code.ump"
public class ParsingCouple
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ParsingCouple Attributes
  private String open;
  private String close;
  private List<Integer> positionFrom;
  private List<Integer> positionTo;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ParsingCouple(String aOpen, String aClose)
  {
    open = aOpen;
    close = aClose;
    positionFrom = new ArrayList<Integer>();
    positionTo = new ArrayList<Integer>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setOpen(String aOpen)
  {
    boolean wasSet = false;
    open = aOpen;
    wasSet = true;
    return wasSet;
  }

  public boolean setClose(String aClose)
  {
    boolean wasSet = false;
    close = aClose;
    wasSet = true;
    return wasSet;
  }

  public boolean addPositionFrom(Integer aPositionFrom)
  {
    boolean wasAdded = false;
    wasAdded = positionFrom.add(aPositionFrom);
    return wasAdded;
  }

  public boolean removePositionFrom(Integer aPositionFrom)
  {
    boolean wasRemoved = false;
    wasRemoved = positionFrom.remove(aPositionFrom);
    return wasRemoved;
  }

  public boolean addPositionTo(Integer aPositionTo)
  {
    boolean wasAdded = false;
    wasAdded = positionTo.add(aPositionTo);
    return wasAdded;
  }

  public boolean removePositionTo(Integer aPositionTo)
  {
    boolean wasRemoved = false;
    wasRemoved = positionTo.remove(aPositionTo);
    return wasRemoved;
  }

  /**
   * The open key, a close brace or quote for example
   */
  public String getOpen()
  {
    return open;
  }

  /**
   * The close key, a close brace or quote for example
   */
  public String getClose()
  {
    return close;
  }

  public Integer getPositionFrom(int index)
  {
    Integer aPositionFrom = positionFrom.get(index);
    return aPositionFrom;
  }

  public Integer[] getPositionFrom()
  {
    Integer[] newPositionFrom = positionFrom.toArray(new Integer[positionFrom.size()]);
    return newPositionFrom;
  }

  public int numberOfPositionFrom()
  {
    int number = positionFrom.size();
    return number;
  }

  public boolean hasPositionFrom()
  {
    boolean has = positionFrom.size() > 0;
    return has;
  }

  public int indexOfPositionFrom(Integer aPositionFrom)
  {
    int index = positionFrom.indexOf(aPositionFrom);
    return index;
  }

  public Integer getPositionTo(int index)
  {
    Integer aPositionTo = positionTo.get(index);
    return aPositionTo;
  }

  public Integer[] getPositionTo()
  {
    Integer[] newPositionTo = positionTo.toArray(new Integer[positionTo.size()]);
    return newPositionTo;
  }

  public int numberOfPositionTo()
  {
    int number = positionTo.size();
    return number;
  }

  public boolean hasPositionTo()
  {
    boolean has = positionTo.size() > 0;
    return has;
  }

  public int indexOfPositionTo(Integer aPositionTo)
  {
    int index = positionTo.indexOf(aPositionTo);
    return index;
  }

  public void delete()
  {}


  /**
   * Searches the input string for the key this couple protects.
   * If a key is found with a \ before it, it is not considered
   * 
   * if a key is found between // and \n it is not considered
   * if a key is found within " and " it is not considered
   * if a key is found between ' and ' it is not considered
   * 
   * if ever there is a need for say "\{" to happen, i.e. that \ is  terminal followed by { code } or something like that
   * then this function will need to be revised so that there can be conditional escaping(it would probably just be an attribute of the couple)
   * 
   * future plans also include refactoring this function so that all the couples are found on one pass through the input instead of having to re-initialize on every new input
   * 
   * The ignore level comes into play for instance if you have /*lvl0 /*lvl1 and you only want to hide lvl1 you would put the ignore level as 1
   */
  @umplesourcefile(line={939},file={"ParsingRules_Code.ump"},javaline={177},length={117})
   public ParsingCouple init(String input){
    int level = 0;
    boolean isQuote = false;
    boolean isSingleQuote = false;
    boolean isComment = false;
    boolean isMultiComment = false;
    boolean escaping = false;
    char[] chars = input.toCharArray();
    int size = input.length();
    List<Integer> levels = new ArrayList<Integer>();
    for(int i=0;i<size;i++)
    {
      if(!escaping)
      {
        if(chars[i]=='\\')
        {
          escaping = true;
        }
        else if(!isComment&&!isMultiComment&&!isQuote&&!isSingleQuote)
        {
          if(level>0&&(close.length()==1&&close.charAt(0)==(chars[i]))||(close.length()>1&&(i+close.length()<input.length()?input.substring(i,i+close.length()).matches("\\Q"+close+"\\E"):false)))
          {            
            level--;
            if(level<0)
            {
              level=0;
            }
            else
            {
              positionFrom.add(levels.get(level));
              positionTo.add(new Integer(i));
            }
            if("\"".equals(close))
            {
              isQuote = false;
            }
          }            
          else if((open.length()==1&&open.charAt(0)==(chars[i]))||open.length()>1&&(i+open.length()<input.length()?input.substring(i,i+open.length()).matches("\\Q"+open+"\\E"):false))
          {
            if(levels.size()<=level)
            {
              levels.add(i);
            }
            else 
            {
              levels.set(level, i);
            }
            level++;
            if("\"".equals(open))
            {
              isQuote = true;
            }
          }            
          else if (level>ParsingCouple.ignoreLevel)
          {
            if(chars[i]=='\"')
            {
              isQuote = true;
            }
            else if(chars[i]=='\'')
            {
              isSingleQuote = true;
            }
            if(i<size-1&&chars[i]=='/')
            {
              if(chars[i+1]=='/')
              {
                isComment = true;
              }
              else if(chars[i+1]=='*')
              {
                isMultiComment = true;
                i++;
              }
            }
          }
        }          
        else if(isQuote&&chars[i]=='\"')
        {
          isQuote = false;
          
          if("\"".equals(close))
          {
        	level--;
            if(level<0)
            {
              level=0;
            }
            else
            {
              positionFrom.add(levels.get(level));
              positionTo.add(new Integer(i));
            }
          }
        }
        else if(isSingleQuote&&chars[i]=='\'')
        {
          isSingleQuote = false;
        }
        else if(isComment&&chars[i]=='\n')
        {
          isComment = false;
        }
        else if(isMultiComment&&i<size-1&&chars[i]=='*'&&chars[i+1]=='/')
        {
          isMultiComment = false;
        }          
        else {
          escaping = false;
        }      
      }
      else {
        escaping = false;
      }
    }
    return this;
  }

  @umplesourcefile(line={1058},file={"ParsingRules_Code.ump"},javaline={312},length={3})
   public int hashCode(){
    return open.hashCode()+close.hashCode();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "open" + ":" + getOpen()+ "," +
            "close" + ":" + getClose()+ "]"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={154},file={"ParsingRules.ump"},javaline={328},length={2})
  public static int ignoreLevel = 0 ;

  
}