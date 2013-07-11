/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * Parses textual input and used in conjunction with the umple parser and internal parser to tokenize the contents of a file such
 * as an Umple file.
 * @umplesource TextParser.ump 16
 * @umplesource TextParser_Code.ump 12
 */
// line 16 "../../../../src/TextParser.ump"
// line 12 "../../../../src/TextParser_Code.ump"
public class TextParser
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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
  //  @umplesourcefile(line={13},file={"TextParser_Code.ump"},javaline={59},length={731})
  private char[] _textCharacters;

  @umplesourcefile(line={16},file={"TextParser_Code.ump"},javaline={62},length={5})
  public TextParser(String filename, String input)
  {
    init(input);
    _filename = filename;
  }

  @umplesourcefile(line={22},file={"TextParser_Code.ump"},javaline={69},length={4})
  public TextParser(String input)
  {
    init(input);
  }

  @umplesourcefile(line={27},file={"TextParser_Code.ump"},javaline={75},length={5})
  private String init(String text)
  {
    load(text);
    return text;
  }

  // ```````````````````````
  // INTERFACE
  // ```````````````````````

  @umplesourcefile(line={37},file={"TextParser_Code.ump"},javaline={86},length={4})
  public String getText()
  {
    return _text;
  }

  @umplesourcefile(line={42},file={"TextParser_Code.ump"},javaline={92},length={4})
  public String getFilename()
  {
    return _filename == null ? "" : _filename;
  }

  /*
   * Resets the parsers positional data based on a specified index.
   * 
   * @param startIndex The specified index that the position will be reset to in the parser.
   */
  @umplesourcefile(line={52},file={"TextParser_Code.ump"},javaline={103},length={8})
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
  @umplesourcefile(line={66},file={"TextParser_Code.ump"},javaline={118},length={6})
  public void load(String text)
  {
    _text = text;
    _textCharacters = text.toCharArray();
    reset(0);
  }

  @umplesourcefile(line={73},file={"TextParser_Code.ump"},javaline={126},length={14})
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

  @umplesourcefile(line={88},file={"TextParser_Code.ump"},javaline={142},length={8})
  public void insert(String newText)
  {
    int length = newText.length();
    _text = _text.substring(0,_currentCharacterIndex) + newText + _text.substring(_currentCharacterIndex);
    _currentCharacterIndex = _currentCharacterIndex + length;
    _maxCharacterIndex = _maxCharacterIndex + length;
    _textCharacters = _text.toCharArray();   
  }

  @umplesourcefile(line={97},file={"TextParser_Code.ump"},javaline={152},length={30})
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

  @umplesourcefile(line={128},file={"TextParser_Code.ump"},javaline={184},length={31})
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

  @umplesourcefile(line={160},file={"TextParser_Code.ump"},javaline={217},length={48})
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

  @umplesourcefile(line={209},file={"TextParser_Code.ump"},javaline={267},length={43})
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

  @umplesourcefile(line={253},file={"TextParser_Code.ump"},javaline={312},length={14})
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

  // undoes parsing back to the last non-whitespace
  // useful when we want to determine the real end of a token
  @umplesourcefile(line={270},file={"TextParser_Code.ump"},javaline={330},length={13})
  public void backUpWhitespace()
  {
    boolean done=false;
    while (_currentCharacterIndex > 0 && !done)
    {
      increment(-1);
      if (!isSpace())
      {
        done=true;
      }
    }
    increment(1);
  }

  @umplesourcefile(line={284},file={"TextParser_Code.ump"},javaline={345},length={9})
  public String next()
  {
    _lastCharacterIndex = _currentCharacterIndex;
    if (loadName(true, false) == null)
    {
      _lastCharacterIndex = -1;
    }
    return name();
  }

  @umplesourcefile(line={294},file={"TextParser_Code.ump"},javaline={356},length={44})
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

  @umplesourcefile(line={339},file={"TextParser_Code.ump"},javaline={402},length={6})
  public String extractFrom(int startIndex)
  {
    int endIndex = _currentCharacterIndex;
    String answer = _text.substring(startIndex, endIndex).trim();
    return "".equals(answer) ? null : answer;
  }

  @umplesourcefile(line={346},file={"TextParser_Code.ump"},javaline={410},length={4})
  public String peek()
  {
    return peekAt();
  }

  @umplesourcefile(line={351},file={"TextParser_Code.ump"},javaline={416},length={9})
  public String peekAt(String... stopAt)
  {
    int backupLastCharacterIndex = _lastCharacterIndex;
    int backupCurrentCharacterIndex = _currentCharacterIndex;
    String peekName = nextAt(stopAt);
    _lastCharacterIndex = backupLastCharacterIndex;
    _currentCharacterIndex = backupCurrentCharacterIndex;
    return peekName;
  }

  @umplesourcefile(line={361},file={"TextParser_Code.ump"},javaline={427},length={10})
  public String nextAt(String... stopAt)
  {
    _lastCharacterIndex = _currentCharacterIndex;
    if (loadName(false, true, stopAt) == null)
    {
      _lastCharacterIndex = -1;
    }
    return name();

  }

  @umplesourcefile(line={372},file={"TextParser_Code.ump"},javaline={439},length={4})
  public String nextUntil(String... stopBefore)
  {
    return nextUntil(true, stopBefore);
  }

  @umplesourcefile(line={377},file={"TextParser_Code.ump"},javaline={445},length={34})
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

  @umplesourcefile(line={412},file={"TextParser_Code.ump"},javaline={481},length={4})
  public String nextUntil(boolean stopAtSpace, String... stopBefore)
  {    
    return nextUntil(stopAtSpace, false, stopBefore);
  }

  @umplesourcefile(line={417},file={"TextParser_Code.ump"},javaline={487},length={9})
  public String nextUntil(boolean stopAtSpace, boolean alphanumeric, String... stopBefore)
  {
    _lastCharacterIndex = _currentCharacterIndex;
    if (loadName(stopAtSpace, false, alphanumeric, stopBefore) == null)
    {
      _lastCharacterIndex = -1;
    }
    return name();
  }


  @umplesourcefile(line={428},file={"TextParser_Code.ump"},javaline={499},length={9})
  public String nextAfter(boolean stopAtSpace, String... stopAfter)
  {
    int savedIndex = _currentCharacterIndex;
    nextUntil(stopAtSpace, stopAfter);
    nextAfter(stopAfter);
    _lastCharacterIndex = savedIndex;
    _currentName = _text.substring(_lastCharacterIndex,_currentCharacterIndex).trim();
    return name();
  }

  @umplesourcefile(line={438},file={"TextParser_Code.ump"},javaline={510},length={23})
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

  @umplesourcefile(line={462},file={"TextParser_Code.ump"},javaline={535},length={4})
  public int previousIndex()
  {
    return _lastCharacterIndex;
  }

  @umplesourcefile(line={467},file={"TextParser_Code.ump"},javaline={541},length={4})
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
  @umplesourcefile(line={478},file={"TextParser_Code.ump"},javaline={553},length={3})
  public Position currentPosition() {
    return currentPosition(true);
  }
  @umplesourcefile(line={481},file={"TextParser_Code.ump"},javaline={557},length={18})
  public Position currentPosition(boolean doSkipWhitespace) {
    if(doSkipWhitespace) skipWhitespace();
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

  @umplesourcefile(line={500},file={"TextParser_Code.ump"},javaline={577},length={11})
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

  @umplesourcefile(line={512},file={"TextParser_Code.ump"},javaline={590},length={4})
  public String name()
  {
    return _currentName;
  }

  // ```````````````````````
  // OBJECT INTERFACE
  // ```````````````````````

  @umplesourcefile(line={521},file={"TextParser_Code.ump"},javaline={600},length={28})
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

  @umplesourcefile(line={554},file={"TextParser_Code.ump"},javaline={634},length={3})
  private String loadName(boolean stopAtSpace, boolean stopAtMatch, String... lookups) {
    return loadName(stopAtSpace, stopAtMatch, false, lookups);
  }

  @umplesourcefile(line={558},file={"TextParser_Code.ump"},javaline={639},length={62})
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

  @umplesourcefile(line={621},file={"TextParser_Code.ump"},javaline={703},length={16})
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

  @umplesourcefile(line={638},file={"TextParser_Code.ump"},javaline={721},length={12})
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

  @umplesourcefile(line={651},file={"TextParser_Code.ump"},javaline={735},length={4})
  private boolean isEndsWith(String name, String... lookups)
  {
    return whichEndsWith(name, lookups) != null;
  }

  @umplesourcefile(line={656},file={"TextParser_Code.ump"},javaline={741},length={16})
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
  @umplesourcefile(line={678},file={"TextParser_Code.ump"},javaline={764},length={4})
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
  @umplesourcefile(line={690},file={"TextParser_Code.ump"},javaline={777},length={5})
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
  @umplesourcefile(line={701},file={"TextParser_Code.ump"},javaline={789},length={4})
  private char c()
  {
    return charAt(_currentCharacterIndex);
  }

  @umplesourcefile(line={706},file={"TextParser_Code.ump"},javaline={795},length={4})
  private char charAt(int index)
  {
    return index > _maxCharacterIndex ? ' ' : _textCharacters[index];
  }

  @umplesourcefile(line={711},file={"TextParser_Code.ump"},javaline={801},length={4})
  private boolean isSpace()
  {
    return isSpace(c());  
  }

  @umplesourcefile(line={716},file={"TextParser_Code.ump"},javaline={807},length={4})
  private boolean isSpace(char c)
  {
    return c == ' ' || c == '\n' || c == '\t' || c == '\r';
  }

  @umplesourcefile(line={721},file={"TextParser_Code.ump"},javaline={813},length={4})
  private boolean isAlpha(char c)
  {
    return (c >= 'a' && c < 'z') || (c >= 'A' && c < 'Z');
  }

  @umplesourcefile(line={726},file={"TextParser_Code.ump"},javaline={819},length={4})
  private boolean isNumeric(char c)
  {
    return c >= '0' && c < '9';
  }

  @umplesourcefile(line={731},file={"TextParser_Code.ump"},javaline={825},length={13})
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