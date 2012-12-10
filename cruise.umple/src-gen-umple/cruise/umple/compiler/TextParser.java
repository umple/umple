/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * Parses textual input and used in conjunction with the umple parser and internal parser to tokenize the contents of a file such
 * as an Umple file.
 */
// line 16 "../../../../src/TextParser.ump"
// line 12 "../../../../src/TextParser_Code.ump"
public class TextParser
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TextParser Attributes
  private String _currentName;
  private int _lastCharacterIndex;
  private int _currentCharacterIndex;
  private int _maxCharacterIndex;
  private Hashtable<Integer,Integer> indexToReplacementOffsetMap;
  private String _text;
  private String _filename;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TextParser()
  {
    _currentName = null;
    _lastCharacterIndex = 0;
    _currentCharacterIndex = 0;
    _maxCharacterIndex = 0;
    indexToReplacementOffsetMap = new Hashtable<Integer,Integer>();
    _text = init("");
    _filename = null;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 14 ../../../../src/TextParser_Code.ump
  private char[] _textCharacters;

  public TextParser(String filename, String input)
  {
    init(input);
    _filename = filename;
  }

  public TextParser(String input)
  {
    init(input);
  }

  private String init(String text)
  {
    load(text);
    return text;
  }

  // ```````````````````````
  // INTERFACE
  // ```````````````````````

  public String getText()
  {
    return _text;
  }

  public String getFilename()
  {
    return _filename == null ? "" : _filename;
  }

  /*
   * Resets the parsers positional data based on a specified index.
   * 
   * @param startIndex The specified index that the position will be reset to in the parser.
   */
  public void reset(int startIndex)
  {
    _currentName = null;
    _lastCharacterIndex = startIndex;
    _currentCharacterIndex = startIndex;
    _maxCharacterIndex = _textCharacters.length - 1;
    indexToReplacementOffsetMap = new Hashtable<Integer,Integer>();
  }

  /*
   * Initializes the textual data in the text file into the parsers character array, for future use in parsing with.
   * 
   * @param text The textual input to transform into a character array.
   */
  public void load(String text)
  {
    _text = text;
    _textCharacters = text.toCharArray();
    reset(0);
  }

  public String all()
  {
    _currentName = null;
    _lastCharacterIndex = _currentCharacterIndex;
    String text = section(_currentCharacterIndex).trim();
    _currentCharacterIndex = _maxCharacterIndex + 1;

    if (text.length() > 0)
    {
      _currentName = text;
    }
    return name();

  }

  public void insert(String newText)
  {
    int length = newText.length();
    _text = _text.substring(0,_currentCharacterIndex) + newText + _text.substring(_currentCharacterIndex);
    _currentCharacterIndex = _currentCharacterIndex + length;
    _maxCharacterIndex = _maxCharacterIndex + length;
    _textCharacters = _text.toCharArray();   
  }

  public void insertAfter(Token t, String insertText)
  {
    int length = insertText.length();
    if (t == null)
    {
      indexToReplacementOffsetMap.put(0, length);
      _text = insertText + _text;
      _currentCharacterIndex = _currentCharacterIndex + length;
      _maxCharacterIndex = _maxCharacterIndex + length;
      _textCharacters = _text.toCharArray();   
    }
    else
    {
      int originalInsertIndex = t.getPosition().getOffset() + t.getLength();
      int insertIndex = calculateStartIndex(originalInsertIndex);
      indexToReplacementOffsetMap.put(originalInsertIndex, length);
      String newText = _text.substring(0,insertIndex);
      newText += insertText;
      newText += _text.substring(insertIndex);

      if (_currentCharacterIndex >= insertIndex)
      {
        _currentCharacterIndex += length;
      }

      _text = newText;
      _textCharacters = _text.toCharArray();
      _maxCharacterIndex = _text.length() - 1;
    }
  }

  public void replace(Token t, String overwriteToken)
  {
    if (t == null)
    {
      return;
    }

    int originalStartIndex = t.getPosition().getOffset();
    int oldLength = t.getInnerLength();
    int replaceOffset = overwriteToken.length() - oldLength;
    indexToReplacementOffsetMap.put(originalStartIndex, replaceOffset);

    int startIndex = calculateStartIndex(originalStartIndex);
    int endIndex = startIndex + oldLength;

    String newText = _text.substring(0,startIndex);
    newText += overwriteToken;
    if (endIndex < _text.length())
    {
      newText += _text.substring(endIndex,_text.length());  
    }

    if (_currentCharacterIndex > startIndex)
    {
      _currentCharacterIndex += overwriteToken.length() - oldLength;
    }

    _text = newText;
    _textCharacters = _text.toCharArray();
    _maxCharacterIndex = _text.length() - 1;
  }

  public void replace(String newText)
  {
    if (name() == null)
    {
      return;
    }
    else
    {

      String beforeText = "";
      String afterText = "";

      int nextIndex = _lastCharacterIndex;

      if (nextIndex > 0)
      {
        beforeText = _text.substring(0, nextIndex);

        while (nextIndex <= _maxCharacterIndex)
        {
          char nextChar = charAt(nextIndex);
          if (isSpace(nextChar))
          {
            beforeText += nextChar;
            nextIndex += 1;
          }
          else
          {
            break;
          }
        }
      }
      nextIndex += name().length();

      if (nextIndex <= _maxCharacterIndex)
      {
        afterText = _text.substring(nextIndex);
      }

      int newLastIndex = _lastCharacterIndex;
      int newCharacterIndex = _lastCharacterIndex + newText.length();
      _text = beforeText + newText + afterText;
      init(_text);
      _lastCharacterIndex = newLastIndex;
      _currentCharacterIndex = newCharacterIndex;
      _currentName = newText;
    }
  }

  public String lookFor(String startCharacter, String stopCharacter, boolean goUntilWhitespace)
  {
    _currentName = null;

    if (_currentCharacterIndex > _maxCharacterIndex)
    {
      return null;
    }

    int offset = _currentCharacterIndex;
    String currentText = _text.substring(offset);

    int startIndex = currentText.indexOf(startCharacter);

    if (startIndex == -1)
    {
      _currentCharacterIndex = _maxCharacterIndex + 1;
      _lastCharacterIndex = _currentCharacterIndex;
      return name();
    }

    int endIndex = currentText.indexOf(stopCharacter, startIndex);
    if (endIndex == -1)
    {
      _currentCharacterIndex = _maxCharacterIndex + 1;
      _lastCharacterIndex = _currentCharacterIndex;
      return name();
    }

    if (goUntilWhitespace)
    {
      _currentCharacterIndex = offset + endIndex;
      next();
    }
    else
    {
      _currentCharacterIndex = offset + endIndex + 1;
    }

    _currentName = currentText.substring(startIndex, endIndex + 1);
    _lastCharacterIndex = offset + startIndex;
    return name();
  }

  public void skipWhitespace()
  {
    while (_currentCharacterIndex <= _maxCharacterIndex)
    {
      if (isSpace())
      {
        increment();
      }
      else
      {
        break;
      }
    }
  }

  public String next()
  {
    _lastCharacterIndex = _currentCharacterIndex;
    if (loadName(true, false) == null)
    {
      _lastCharacterIndex = -1;
    }
    return name();
  }

  public String nextVariable()
  {
    String name = next();
    if (name == null)
    {
      return name;
    }

    String variableName = "";
    boolean isAlphaNumericUnderscore = true;
    for (int i = 0; i < name.length(); i++)
    {
      char c = name.charAt(i);
      if (isAlpha(c) || isNumeric(c) || c == '_')
      {
        if (i == 0 || isAlphaNumericUnderscore)
        {
          variableName += c;
          isAlphaNumericUnderscore = true;
        }
        else
        {
          break;
        }
      }
      else
      {
        if (i == 0 || !isAlphaNumericUnderscore)
        {
          variableName += c;
          isAlphaNumericUnderscore = false;
        }
        else
        {
          break;
        }
      }
    }

    int delta = name.length() - variableName.length();
    _currentName = variableName;
    _currentCharacterIndex -= delta;
    return name();
  }

  public String extractFrom(int startIndex)
  {
    int endIndex = _currentCharacterIndex;
    String answer = _text.substring(startIndex, endIndex).trim();
    return "".equals(answer) ? null : answer;
  }

  public String peek()
  {
    return peekAt();
  }

  public String peekAt(String... stopAt)
  {
    int backupLastCharacterIndex = _lastCharacterIndex;
    int backupCurrentCharacterIndex = _currentCharacterIndex;
    String peekName = nextAt(stopAt);
    _lastCharacterIndex = backupLastCharacterIndex;
    _currentCharacterIndex = backupCurrentCharacterIndex;
    return peekName;
  }

  public String nextAt(String... stopAt)
  {
    _lastCharacterIndex = _currentCharacterIndex;
    if (loadName(false, true, stopAt) == null)
    {
      _lastCharacterIndex = -1;
    }
    return name();

  }

  public String nextUntil(String... stopBefore)
  {
    return nextUntil(true, stopBefore);
  }

  public String nextLine()
  {
    _lastCharacterIndex = _currentCharacterIndex;
    if (_currentCharacterIndex == -1)
    {
      _currentName = null;
      return name();
    }

    int nextNewline = _text.indexOf("\n", _currentCharacterIndex + 1);

    if (nextNewline == -1)
    {
      _currentName = _text.substring(_currentCharacterIndex).trim();
      _currentCharacterIndex = _maxCharacterIndex + 1;
    }
    else
    {
      _currentName = _text.substring(_currentCharacterIndex, nextNewline).trim();
      _currentCharacterIndex = nextNewline + 1;
    }

    if (_currentName != null && _currentName.length() == 0)
    {
      _currentName = null;
    }

    while (_currentCharacterIndex <= _maxCharacterIndex && isSpace())
    {
      increment();
    }

    return name();
  }

  public String nextUntil(boolean stopAtSpace, String... stopBefore)
  {    
    return nextUntil(stopAtSpace, false, stopBefore);
  }

  public String nextUntil(boolean stopAtSpace, boolean alphanumeric, String... stopBefore)
  {
    _lastCharacterIndex = _currentCharacterIndex;
    if (loadName(stopAtSpace, false, alphanumeric, stopBefore) == null)
    {
      _lastCharacterIndex = -1;
    }
    return name();
  }


  public String nextAfter(boolean stopAtSpace, String... stopAfter)
  {
    int savedIndex = _currentCharacterIndex;
    nextUntil(stopAtSpace, stopAfter);
    nextAfter(stopAfter);
    _lastCharacterIndex = savedIndex;
    _currentName = _text.substring(_lastCharacterIndex,_currentCharacterIndex).trim();
    return name();
  }

  public String nextAfter(String... stopAfter)
  {
    int savedLastCharacterIndex = _currentCharacterIndex;
    String partOne = nextUntil(false, stopAfter);
    String partTwo = nextAt(stopAfter);

    if (partOne == null && partTwo == null)
    {
      _currentName = null;
      _lastCharacterIndex = -1;
    }
    else if (partOne != null && partTwo == null)
    {
      _currentName = partOne;
      _lastCharacterIndex = savedLastCharacterIndex;
    }
    else
    {
      _currentName = partOne + partTwo;
      _lastCharacterIndex = savedLastCharacterIndex;
    }
    return name();
  }

  public int previousIndex()
  {
    return _lastCharacterIndex;
  }

  public int currentIndex()
  {
    return _currentCharacterIndex;
  }

  /*
   * Used to get positional data on the textual parser.
   * 
   * @return A Position object based off the filename the parser is based on, along with the line number and character index its sitting
   * at.
   */
  public Position currentPosition()
  {
    skipWhitespace();
    int lineNumber = 1;
    int currentLineOffset = -1;
    int nextLineOffset = 0;

    // Compute the line number that the parser is currently at.
    while ((nextLineOffset = _text.indexOf("\n", nextLineOffset)) != -1 && nextLineOffset < _currentCharacterIndex)
    {
      lineNumber++;
      currentLineOffset = nextLineOffset;
      nextLineOffset++;
    }

    int characterOffset = _currentCharacterIndex - currentLineOffset - 1;
    Position p = new Position(_filename, lineNumber, characterOffset, _currentCharacterIndex);
    return p;
  }

  public String section(int startIndex)
  {
    if (startIndex < 0 || startIndex > _text.length())
    {
      return "";
    }
    else
    {
      return _text.substring(startIndex).trim();
    }
  }

  public String name()
  {
    return _currentName;
  }

  // ```````````````````````
  // OBJECT INTERFACE
  // ```````````````````````

  public String toString()
  {
    String text = "";

    for (int i = 0; i < _textCharacters.length; i++)
    {
      char c = _textCharacters[i];

      if (c == '\n')
      {
        c = '_';
      }

      if (i == _currentCharacterIndex)
      {
        text += "[" + c + "]";
      }
      else
      {
        text += c;
      }
    }
    if (_currentCharacterIndex > _maxCharacterIndex)
    {
      text += "[]";
    }
    return text;
  }

  // ```````````````````````
  // PRIVATE METHODS
  // ```````````````````````

  private String loadName(boolean stopAtSpace, boolean stopAtMatch, String... lookups) {
    return loadName(stopAtSpace, stopAtMatch, false, lookups);
  }

  private String loadName(boolean stopAtSpace, boolean stopAtMatch, boolean isAlphanum, String... lookups)
  {

    boolean hasLookup = hasLookups(lookups);
    int backupCurrentCharacterIndex = _currentCharacterIndex;
    _currentName = null;

    String name = "";
    boolean wasSpace = false;
    while (_currentCharacterIndex <= _maxCharacterIndex)
    {
      //If the rule is alphanumeric only & we've reached a character that is not alphanumeric or an underscore, we haven't matched anything.
      if(isAlphanum && !(isAlpha(c()) || isNumeric(c())) && !(c() == '_') && name.length() > 0) {
        break;
      }

      if (isSpace() && (!hasLookup || stopAtMatch || stopAtSpace))
      {
        wasSpace = true;
        increment();
      }
      else if (wasSpace && name.length() > 0)
      {
        break;
      }
      else
      {
        wasSpace = false;
        name += c();
        increment();
      }

      if (!hasLookup)
      {
        continue;
      }

      if (stopAtMatch && isMatch(name, lookups))
      {
        break;
      }
      else if (!stopAtMatch && isEndsWith(name, lookups))
      {
        String lookup = whichEndsWith(name, lookups);
        _currentCharacterIndex -= lookup.length();
        name = name.substring(0, name.length() - lookup.length()).trim();
        break;
      }
    }

    name = name.trim();
    if (hasLookup && stopAtMatch && !isMatch(name, lookups))
    {
      _currentCharacterIndex = backupCurrentCharacterIndex;
    }
    else if (name.length() > 0)
    {
      _currentName = name;
    }

    return _currentName;
  }

  private boolean hasLookups(String... lookups)
  {
    if (lookups == null)
    {
      return true;
    }
    for (int i = 0; i < lookups.length; i++)
    {
      String potentialMatch = lookups[i];
      if (potentialMatch != null)
      {
        return true;
      }
    }
    return false;
  }

  private boolean isMatch(String name, String... lookups)
  {
    for (int i = 0; i < lookups.length; i++)
    {
      String potentialMatch = lookups[i];
      if (name.equals(potentialMatch))
      {
        return true;
      }
    }
    return false;
  }

  private boolean isEndsWith(String name, String... lookups)
  {
    return whichEndsWith(name, lookups) != null;
  }

  private String whichEndsWith(String name, String... lookups)
  {
    if (lookups == null)
    {
      return null;
    }
    for (int i = 0; i < lookups.length; i++)
    {
      String potentialMatch = lookups[i];
      if (name.endsWith(potentialMatch))
      {
        return potentialMatch;
      }
    }
    return null;
  }

  /**
   * Increments the parsers character index by 1, and then returns the character at that new index.
   * 
   * @return The character at the parsers new character index in the textual input data.
   */
  private char increment()
  {
    return increment(1);
  }

  /**
   * Increments the parsers character index (where it is in the textual input) and returns the new character it's sitting on.
   * 
   * @param howMuch How much to increment the index by.
   * 
   * @return The character that the parser is sitting on at its character index (in relation to the textual input data).
   */
  private char increment(int howMuch)
  {
    _currentCharacterIndex += howMuch;
    return c();
  }

  /**
   * Typically used in conjunction with increment, where the character that the parser's index is sitting on is returned.
   * 
   * @return The character that the parser's character index is at in the textual input data.
   */
  private char c()
  {
    return charAt(_currentCharacterIndex);
  }

  private char charAt(int index)
  {
    return index > _maxCharacterIndex ? ' ' : _textCharacters[index];
  }

  private boolean isSpace()
  {
    return isSpace(c());  
  }

  private boolean isSpace(char c)
  {
    return c == ' ' || c == '\n' || c == '\t' || c == '\r';
  }

  private boolean isAlpha(char c)
  {
    return (c >= 'a' && c < 'z') || (c >= 'A' && c < 'Z');
  }

  private boolean isNumeric(char c)
  {
    return c >= '0' && c < '9';
  }

  private int calculateStartIndex(int originalStartIndex)
  {                    
    int startIndex = originalStartIndex;
    for (Enumeration<Integer> i = indexToReplacementOffsetMap.keys(); i.hasMoreElements();)
    {
      Integer key = i.nextElement();
      if (key.intValue() < originalStartIndex)
      {
        startIndex += indexToReplacementOffsetMap.get(key).intValue();
      }
    }
    return startIndex;
  }
}