/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

public class Token
{

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

  public String getName()
  {
    if (name == null) { return ""; }
    return name;
  }

  public String getValue()
  {
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

  public boolean setPosition(Position newPosition)
  {
    boolean wasSet = false;
    String tFilename = position == null ? newPosition.getFilename() : position.getFilename();
    position = newPosition;
    wasSet = true;
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
  
   public Token(String aName,String aValue,Position aPosition)  {
this(aName,aValue);
    setPosition(aPosition);
  }
public void addSubToken(int index, Token aSubToken)
  {
    subTokens.add(index,aSubToken);
  }
  
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
  
  public int getIntValue(String tokenName)
  {
    return getIntValue(tokenName,0);
  }
  
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
  
  public Token getSubToken(String tokenName)
  {
    return getSubToken(tokenName,0);
  }
  
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

  public boolean is(String aName)
  {
    return getName().equals(aName) && !isStatic();
  }
  
  public boolean isStatic(String aName)
  {
    return getName().equals(aName) && isStatic();
  }
  
  public boolean isStatic()
  {
    return "STATIC".equals(getValue());
  }
  
  public boolean isValue(String compareTo)
  {
    return getValue().equals(compareTo);
  }
  
  public void remove(int index)
  {
    if (index < 0 || index >= subTokens.size())
    {
      return;
    }
    subTokens.remove(index);
  }
}