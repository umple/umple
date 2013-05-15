/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.regex.*;
import java.util.*;

/**
 * Fundamental to all parsing, used in conjunction with rules and their definitions.
 * As parsing is taking place these will indicate what is currently being looked for
 * (such as a class definition or attribute) and helps to keep
 * track of the positions that the input parser parsed things at.
 * @umplesource Parser.ump 100
 * @umplesource Parser_Code.ump 81
 */
// line 100 "../../../../src/Parser.ump"
// line 81 "../../../../src/Parser_Code.ump"
public class Token
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int line();String file();int javaline();int length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Token Attributes
  private String name;
  private String value;

  //Token Associations
  private List<Token> subTokens;
  private Position position;
  private Token parentToken;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Token(String aName, String aValue)
  {
    name = aName;
    value = aValue;
    subTokens = new ArrayList<Token>();
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

  public boolean setValue(String aValue)
  {
    boolean wasSet = false;
    value = aValue;
    wasSet = true;
    return wasSet;
  }

  /**
   * The name of the token.
   */
  public String getName()
  {
    // line 110 "../../../../src/Parser.ump"
    if (name == null) { return ""; }
    return name;
  }

  /**
   * The value of the token.
   */
  public String getValue()
  {
    // line 111 "../../../../src/Parser.ump"
    if (value == null) { return ""; }
    return value;
  }

  public Token getSubToken(int index)
  {
    Token aSubToken = subTokens.get(index);
    return aSubToken;
  }

  public List<Token> getSubTokens()
  {
    List<Token> newSubTokens = Collections.unmodifiableList(subTokens);
    return newSubTokens;
  }

  public int numberOfSubTokens()
  {
    int number = subTokens.size();
    return number;
  }

  public boolean hasSubTokens()
  {
    boolean has = subTokens.size() > 0;
    return has;
  }

  public int indexOfSubToken(Token aSubToken)
  {
    int index = subTokens.indexOf(aSubToken);
    return index;
  }

  public Position getPosition()
  {
    return position;
  }

  public Token getParentToken()
  {
    return parentToken;
  }

  public static int minimumNumberOfSubTokens()
  {
    return 0;
  }

  public boolean addSubToken(Token aSubToken)
  {
    boolean wasAdded = false;
    if (subTokens.contains(aSubToken)) { return false; }
    Token existingParentToken = aSubToken.getParentToken();
    if (existingParentToken == null)
    {
      aSubToken.setParentToken(this);
    }
    else if (!this.equals(existingParentToken))
    {
      existingParentToken.removeSubToken(aSubToken);
      addSubToken(aSubToken);
    }
    else
    {
      subTokens.add(aSubToken);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSubToken(Token aSubToken)
  {
    boolean wasRemoved = false;
    if (subTokens.contains(aSubToken))
    {
      subTokens.remove(aSubToken);
      aSubToken.setParentToken(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addSubTokenAt(Token aSubToken, int index)
  {  
    boolean wasAdded = false;
    if(addSubToken(aSubToken))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSubTokens()) { index = numberOfSubTokens() - 1; }
      subTokens.remove(aSubToken);
      subTokens.add(index, aSubToken);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSubTokenAt(Token aSubToken, int index)
  {
    boolean wasAdded = false;
    if(subTokens.contains(aSubToken))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSubTokens()) { index = numberOfSubTokens() - 1; }
      subTokens.remove(aSubToken);
      subTokens.add(index, aSubToken);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSubTokenAt(aSubToken, index);
    }
    return wasAdded;
  }

  public boolean setPosition(Position aNewPosition)
  {
    boolean wasSet = false;
    // line 113 "../../../../src/Parser.ump"
    String tFilename = position == null ? aNewPosition.getFilename() : position.getFilename();
    position = aNewPosition;
    wasSet = true;
    // line 114 "../../../../src/Parser.ump"
    position.setFilename(tFilename);
    return wasSet;
  }

  public boolean setParentToken(Token aParentToken)
  {
    boolean wasSet = false;
    Token existingParentToken = parentToken;
    parentToken = aParentToken;
    if (existingParentToken != null && !existingParentToken.equals(aParentToken))
    {
      existingParentToken.removeSubToken(this);
    }
    if (aParentToken != null)
    {
      aParentToken.addSubToken(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(Token aSubToken : subTokens)
    {
      aSubToken.setParentToken(null);
    }
    position = null;
    if (parentToken != null)
    {
      Token placeholderParentToken = parentToken;
      this.parentToken = null;
      placeholderParentToken.removeSubToken(this);
    }
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
    @umplesourcefile(line=0,file="",javaline=246,length=4)
 public Token(String aName,String aValue,Position aPosition)  {
this(aName,aValue);
    setPosition(aPosition);
  }
// line 90 ../../../../src/Parser_Code.ump
  @umplesourcefile(line=90,file="Parser_Code.ump",javaline=252,length=9)
  public static boolean isValidIdentifier(String identifier, String prefix){
    String _prefix = "^" + prefix;
    String body = "[a-zA-Z0-9_]*$";
    String expression = _prefix + body;
    if(Pattern.matches(expression, identifier)){
    	return true;
    }
    return false;
  }
  
  @umplesourcefile(line=100,file="Parser_Code.ump",javaline=263,length=3)
  public static boolean isValidIdentifier(String identifier){
  	return isValidIdentifier(identifier, "[a-zA-Z_]");
  }
	
  @umplesourcefile(line=104,file="Parser_Code.ump",javaline=268,length=4)
  public void addSubToken(int index, Token aSubToken)
  {
    subTokens.add(index,aSubToken);
  }

  @umplesourcefile(line=109,file="Parser_Code.ump",javaline=274,length=12)
  public Position getPosition(String tokenName)
  {
    Token t = getSubToken(tokenName);
    if (t != null)
    {
      return t.getPosition();
    }
    else
    {
      return null;
    }
  }

  @umplesourcefile(line=122,file="Parser_Code.ump",javaline=288,length=15)
  public int getInnerLength()
  {
    if ("START_TOKEN".equals(getValue()))
    {
      return getLength(); 
    }
    else if (isStatic())
    {
      return getName().length();
    }
    else
    {
      return getValue().length();
    }
  }

  @umplesourcefile(line=138,file="Parser_Code.ump",javaline=305,length=54)
  public int getLength()
  {
    if (getParentToken() != null)
    {
      Token parent = getParentToken();
      Token grandParent = parent.getParentToken();
      int startOffset = this.getPosition().getOffset();
      int myIndex = getParentToken().indexOfSubToken(this);
      int nextIndex = myIndex + 1;

      boolean hasMoreSiblings = nextIndex < getParentToken().numberOfSubTokens();

      if (hasMoreSiblings)
      {
        return parent.getSubToken(nextIndex).getPosition().getOffset() - startOffset;
      }
      else 
      {
        if (grandParent != null)
        {
          int myParentIndex = grandParent.indexOfSubToken(parent);
          int nextParentIndex = myParentIndex + 1;
          boolean hasMoreParentSiblings = nextParentIndex < grandParent.numberOfSubTokens();
          if (hasMoreParentSiblings)
          {
            return grandParent.getSubToken(nextParentIndex).getPosition().getOffset() - startOffset;
          }
        }
        Token currentToken = this;
        Token lastToken = this;
        while (currentToken.numberOfSubTokens() > 0)
        {
          lastToken = currentToken.getSubToken(currentToken.numberOfSubTokens() - 1);
          currentToken = lastToken;
        }
        return lastToken.getPosition().getOffset() + lastToken.getValue().length() - getPosition().getOffset();
      }
    }
    else if (numberOfSubTokens() == 0)
    {
      return getValue().length();
    }
    else
    {
      Token currentParent = this;
      Token lastSubToken = null;
      while (currentParent.numberOfSubTokens() > 0)
      {
        lastSubToken = currentParent.getSubToken(currentParent.numberOfSubTokens() - 1);
        currentParent = lastSubToken;
      }
      return lastSubToken.getPosition().getOffset() + lastSubToken.getValue().length() - getPosition().getOffset();  
    }
  }

  @umplesourcefile(line=193,file="Parser_Code.ump",javaline=361,length=4)
  public int getIntValue(String tokenName)
  {
    return getIntValue(tokenName,0);
  }

  @umplesourcefile(line=198,file="Parser_Code.ump",javaline=367,length=19)
  public int getIntValue(String tokenName, int defaultIfInvalid)
  {
    String value = getValue(tokenName);
    if (value == null)
    {
      return defaultIfInvalid;
    }
    else
    {
      try
      {
        return Integer.parseInt(value);
      }
      catch (NumberFormatException e)
      {
        return defaultIfInvalid;
      }
    }
  }

  @umplesourcefile(line=218,file="Parser_Code.ump",javaline=388,length=23)
  public Token getSubToken(String tokenName, int offset)
  {
    if (is(tokenName))
    {
      return this;
    }
    else
    {
      int currentOffset = 0;
      for (Token t : subTokens)
      {
        if (t.is(tokenName))
        {
          if (currentOffset == offset)
          {
            return t;  
          }
          currentOffset += 1;  
        }
      }
    }
    return null;
  }

  @umplesourcefile(line=242,file="Parser_Code.ump",javaline=413,length=4)
  public Token getSubToken(String tokenName)
  {
    return getSubToken(tokenName,0);
  }

  @umplesourcefile(line=247,file="Parser_Code.ump",javaline=419,length=13)
  public String getValue(String tokenName)
  {
    Token t = getSubToken(tokenName);
    if (t != null)
    {
      return t.getValue();
    }
    else
    {
      // This should be "", as getValue() returns "" by default
      return null;
    }
  }

  @umplesourcefile(line=261,file="Parser_Code.ump",javaline=434,length=4)
  public boolean is(String aName)
  {
    return getName().equals(aName) && !isStatic();
  }

  @umplesourcefile(line=266,file="Parser_Code.ump",javaline=440,length=4)
  public boolean isStatic(String aName)
  {
    return getName().equals(aName) && isStatic();
  }

  @umplesourcefile(line=271,file="Parser_Code.ump",javaline=446,length=4)
  public boolean isStatic()
  {
    return "STATIC".equals(getValue());
  }

  @umplesourcefile(line=276,file="Parser_Code.ump",javaline=452,length=4)
  public boolean isValue(String compareTo)
  {
    return getValue().equals(compareTo);
  }

  @umplesourcefile(line=281,file="Parser_Code.ump",javaline=458,length=8)
  public void remove(int index)
  {
    if (index < 0 || index >= subTokens.size())
    {
      return;
    }
    subTokens.remove(index);
  }

  @umplesourcefile(line=290,file="Parser_Code.ump",javaline=468,length=6)
  public String toString()
  {
    StringBuffer answer = new StringBuffer();
    toString(answer,null);
    return answer.toString();
  }

  // Code refactored from Parser class to Token class
  @umplesourcefile(line=298,file="Parser_Code.ump",javaline=477,length=21)
  public StringBuffer toString(StringBuffer stringSoFar, Token parserRoot)
  {
    if ("START_TOKEN".equals(getValue()))
    {
      stringSoFar.append("[" + getName() + "]");
    }
    else if ("STATIC".equals(getValue()))
    {
      //ignore
    }
    else if (parserRoot == null || !this.equals(parserRoot))
    {
      stringSoFar.append("[" + getName() + ":" + getValue() + "]");
    }

    for(Token subToken : getSubTokens())
    {
      subToken.toString(stringSoFar,null);
    }
    return stringSoFar;
  }

}