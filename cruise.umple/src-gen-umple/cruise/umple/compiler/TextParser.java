/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * Parses textual input and used in conjunction with the umple parser and internal parser to tokenize the contents of a file such
 * as an Umple file.
 * @umplesource TextParser.ump 15
 * @umplesource TextParser_Code.ump 11
 */
// line 15 "../../../../src/TextParser.ump"
// line 11 "../../../../src/TextParser_Code.ump"
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

  /**
   * Specifies where the parser currently is in terms of the textual input character array.
   */
  private int _currentCharacterIndex;
  private int _maxCharacterIndex;
  private Hashtable<Integer,Integer> indexToReplacementOffsetMap;

  /**
   * The textual input from the input file.
   */
  private String _text;

  /**
   * The filename that the parser is going to retrieve textual input data from.
   * ```````````````````````
   */
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

  @umplesourcefile(line={18},file={"TextParser_Code.ump"},javaline={70},length={4})
   public  TextParser(String filename, String input){
    init(input);
    _filename = filename;
  }

  @umplesourcefile(line={24},file={"TextParser_Code.ump"},javaline={76},length={3})
   public  TextParser(String input){
    init(input);
  }

  @umplesourcefile(line={29},file={"TextParser_Code.ump"},javaline={81},length={4})
   private String init(String text){
    load(text);
    return text;
  }


  /**
   * INTERFACE
   * ```````````````````````
   */
  @umplesourcefile(line={39},file={"TextParser_Code.ump"},javaline={87},length={3})
   public String getText(){
    return _text;
  }

  @umplesourcefile(line={44},file={"TextParser_Code.ump"},javaline={97},length={3})
   public String getFilename(){
    return _filename == null ? "" : _filename;
  }


  /**
   * Resets the parsers positional data based on a specified index.
   * 
   * @param startIndex The specified index that the position will be reset to in the parser.
   */
  @umplesourcefile(line={54},file={"TextParser_Code.ump"},javaline={102},length={7})
   public void reset(int startIndex){
    _currentName = null;
    _lastCharacterIndex = startIndex;
    _currentCharacterIndex = startIndex;
    _maxCharacterIndex = _textCharacters.length - 1;
    indexToReplacementOffsetMap = new Hashtable<Integer,Integer>();
  }


  /**
   * Initializes the textual data in the text file into the parsers character array, for future use in parsing with.
   * 
   * @param text The textual input to transform into a character array.
   */
  @umplesourcefile(line={68},file={"TextParser_Code.ump"},javaline={117},length={5})
   public void load(String text){
    _text = text;
    _textCharacters = text.toCharArray();
    reset(0);
  }

  @umplesourcefile(line={75},file={"TextParser_Code.ump"},javaline={130},length={12})
   public String all(){
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

  @umplesourcefile(line={90},file={"TextParser_Code.ump"},javaline={144},length={7})
   public void insert(String newText){
    int length = newText.length();
    _text = _text.substring(0,_currentCharacterIndex) + newText + _text.substring(_currentCharacterIndex);
    _currentCharacterIndex = _currentCharacterIndex + length;
    _maxCharacterIndex = _maxCharacterIndex + length;
    _textCharacters = _text.toCharArray();
  }

  @umplesourcefile(line={99},file={"TextParser_Code.ump"},javaline={153},length={29})
   public void insertAfter(Token t, String insertText){
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

  @umplesourcefile(line={130},file={"TextParser_Code.ump"},javaline={184},length={30})
   public void replace(Token t, String overwriteToken){
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

  @umplesourcefile(line={162},file={"TextParser_Code.ump"},javaline={216},length={47})
   public void replace(String newText){
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

  @umplesourcefile(line={211},file={"TextParser_Code.ump"},javaline={265},length={42})
   public String lookFor(String startCharacter, String stopCharacter, boolean goUntilWhitespace){
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

  @umplesourcefile(line={255},file={"TextParser_Code.ump"},javaline={309},length={13})
   public void skipWhitespace(){
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


  /**
   * undoes parsing back to the last non-whitespace
   * useful when we want to determine the real end of a token
   */
  @umplesourcefile(line={272},file={"TextParser_Code.ump"},javaline={324},length={12})
   public void backUpWhitespace(){
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

  @umplesourcefile(line={286},file={"TextParser_Code.ump"},javaline={343},length={8})
   public String next(){
    _lastCharacterIndex = _currentCharacterIndex;
    if (loadName(true, false) == null)
    {
      _lastCharacterIndex = -1;
    }
    return name();
  }

  @umplesourcefile(line={296},file={"TextParser_Code.ump"},javaline={353},length={43})
   public String nextVariable(){
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

  @umplesourcefile(line={341},file={"TextParser_Code.ump"},javaline={398},length={5})
   public String extractFrom(int startIndex){
    int endIndex = _currentCharacterIndex;
    String answer = _text.substring(startIndex, endIndex).trim();
    return "".equals(answer) ? null : answer;
  }

  @umplesourcefile(line={348},file={"TextParser_Code.ump"},javaline={405},length={3})
   public String peek(){
    return peekAt();
  }

  @umplesourcefile(line={353},file={"TextParser_Code.ump"},javaline={410},length={8})
   public String peekAt(String... stopAt){
    int backupLastCharacterIndex = _lastCharacterIndex;
    int backupCurrentCharacterIndex = _currentCharacterIndex;
    String peekName = nextAt(stopAt);
    _lastCharacterIndex = backupLastCharacterIndex;
    _currentCharacterIndex = backupCurrentCharacterIndex;
    return peekName;
  }

  @umplesourcefile(line={363},file={"TextParser_Code.ump"},javaline={420},length={8})
   public String nextAt(String... stopAt){
    _lastCharacterIndex = _currentCharacterIndex;
    if (loadName(false, true, stopAt) == null)
    {
      _lastCharacterIndex = -1;
    }
    return name();
  }

  @umplesourcefile(line={374},file={"TextParser_Code.ump"},javaline={430},length={3})
   public String nextUntil(String... stopBefore){
    return nextUntil(true, stopBefore);
  }

  @umplesourcefile(line={379},file={"TextParser_Code.ump"},javaline={435},length={33})
   public String nextLine(){
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

  @umplesourcefile(line={414},file={"TextParser_Code.ump"},javaline={470},length={3})
   public String nextUntil(boolean stopAtSpace, String... stopBefore){
    return nextUntil(stopAtSpace, false, stopBefore);
  }

  @umplesourcefile(line={419},file={"TextParser_Code.ump"},javaline={475},length={8})
   public String nextUntil(boolean stopAtSpace, boolean alphanumeric, String... stopBefore){
    _lastCharacterIndex = _currentCharacterIndex;
    if (loadName(stopAtSpace, false, alphanumeric, stopBefore) == null)
    {
      _lastCharacterIndex = -1;
    }
    return name();
  }

  @umplesourcefile(line={430},file={"TextParser_Code.ump"},javaline={485},length={8})
   public String nextAfter(boolean stopAtSpace, String... stopAfter){
    int savedIndex = _currentCharacterIndex;
    nextUntil(stopAtSpace, stopAfter);
    nextAfter(stopAfter);
    _lastCharacterIndex = savedIndex;
    _currentName = _text.substring(_lastCharacterIndex,_currentCharacterIndex).trim();
    return name();
  }

  @umplesourcefile(line={440},file={"TextParser_Code.ump"},javaline={495},length={22})
   public String nextAfter(String... stopAfter){
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

  @umplesourcefile(line={464},file={"TextParser_Code.ump"},javaline={519},length={3})
   public int previousIndex(){
    return _lastCharacterIndex;
  }

  @umplesourcefile(line={469},file={"TextParser_Code.ump"},javaline={524},length={3})
   public int currentIndex(){
    return _currentCharacterIndex;
  }


  /**
   * Used to get positional data on the textual parser.
   * 
   * @return A Position object based off the filename the parser is based on, along with the line number and character index its sitting
   * at.
   */
  @umplesourcefile(line={479},file={"TextParser_Code.ump"},javaline={529},length={3})
   public Position currentPosition(){
    return currentPosition(true);
  }

  @umplesourcefile(line={482},file={"TextParser_Code.ump"},javaline={541},length={18})
   public Position currentPosition(boolean doSkipWhitespace){
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

  @umplesourcefile(line={502},file={"TextParser_Code.ump"},javaline={561},length={10})
   public String section(int startIndex){
    if (startIndex < 0 || startIndex > _text.length())
    {
      return "";
    }
    else
    {
      return _text.substring(startIndex).trim();
    }
  }

  @umplesourcefile(line={514},file={"TextParser_Code.ump"},javaline={573},length={3})
   public String name(){
    return _currentName;
  }


  /**
   * ```````````````````````
   * OBJECT INTERFACE
   * ```````````````````````
   */
  @umplesourcefile(line={523},file={"TextParser_Code.ump"},javaline={578},length={27})
   public String toString(){
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


  /**
   * ```````````````````````
   * PRIVATE METHODS
   * ```````````````````````
   */
  @umplesourcefile(line={555},file={"TextParser_Code.ump"},javaline={613},length={3})
   private String loadName(boolean stopAtSpace, boolean stopAtMatch, String... lookups){
    return loadName(stopAtSpace, stopAtMatch, false, lookups);
  }

  @umplesourcefile(line={561},file={"TextParser_Code.ump"},javaline={624},length={127})
   private String loadName(boolean stopAtSpace, boolean stopAtMatch, boolean isAlphanum, String... lookups){
    boolean hasLookup = hasLookups(lookups);
    int backupCurrentCharacterIndex = _currentCharacterIndex;
    _currentName = null;

    String name = "";
    boolean wasSpace = false;
    boolean quote = lookups!=null?new ArrayList<String>(Arrays.asList(lookups)).contains("\""):false;
    boolean backslash = false;
    boolean single = false;
    boolean forwardslash = false;
    boolean comment = false;
    boolean multicomment = false;
    boolean star = false;
    while (_currentCharacterIndex <= _maxCharacterIndex)
    {
      if(isAlphanum && !(""+c()).matches("[a-z|A-Z|_]")&&name.length()==0){
        break;
      }
      //If the rule is alphanumeric only & we've reached a character that is not alphanumeric or an underscore, we haven't matched anything.
      if(isAlphanum && !((""+c()).matches("[a-z|A-Z|_|-|0-9|<|>|,]")) && name.length() > 0) {
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
        if(c()=='\"')
        {
          if(!backslash&&!single&&!comment&&!multicomment){
            quote =  !quote;
          }                
          backslash = false;
        }
        else if(c()=='\\')
        {
          backslash = !backslash;
        }
        else if(c()=='\'')
        {
          if(!backslash&&!quote&&!comment&&!multicomment){
            single = !single;
          }           
          backslash = false;
        }
        else if(!quote&&!single&&!comment&&c()=='/')
        {
          if (star)
          {
            multicomment = false;
          }
          else if(forwardslash)
          {
            comment = true;
          }
          else
          {
            forwardslash = true;  
          }
        }
        else if(!quote&&!single&&forwardslash&&c()=='*')
        {
          multicomment = true;
        }
        else if(!quote&&!single&&multicomment&&c()=='*')
        {
          star = true;
        }
        else if(comment && c()=='\n')
        {
          comment = false;
        }
        else 
        {
          backslash = false;
          forwardslash = false;
          star = false;
        }
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
      else if (!stopAtMatch && !quote && !comment && !multicomment && isEndsWith(name, lookups))
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
      if(isAlphanum&&!name.equals("true")&&!name.equals("false")&&!name.equals("["))
      {
         _currentName = name;
      }
      else if(!isAlphanum)
      {
        _currentName = name;
      }
    }

    return _currentName;
  }

  @umplesourcefile(line={690},file={"TextParser_Code.ump"},javaline={753},length={15})
   private boolean hasLookups(String... lookups){
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

  @umplesourcefile(line={707},file={"TextParser_Code.ump"},javaline={770},length={11})
   private boolean isMatch(String name, String... lookups){
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

  @umplesourcefile(line={720},file={"TextParser_Code.ump"},javaline={783},length={3})
   private boolean isEndsWith(String name, String... lookups){
    return whichEndsWith(name, lookups) != null;
  }

  @umplesourcefile(line={725},file={"TextParser_Code.ump"},javaline={788},length={15})
   private String whichEndsWith(String name, String... lookups){
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
   * 
   * Increments the parsers character index by 1, and then returns the character at that new index.
   * 
   * @return The character at the parsers new character index in the textual input data.
   */
  @umplesourcefile(line={747},file={"TextParser_Code.ump"},javaline={805},length={3})
   private char increment(){
    return increment(1);
  }


  /**
   * 
   * Increments the parsers character index (where it is in the textual input) and returns the new character it's sitting on.
   * 
   * @param howMuch How much to increment the index by.
   * 
   * @return The character that the parser is sitting on at its character index (in relation to the textual input data).
   */
  @umplesourcefile(line={759},file={"TextParser_Code.ump"},javaline={817},length={4})
   private char increment(int howMuch){
    _currentCharacterIndex += howMuch;
    return c();
  }


  /**
   * 
   * Typically used in conjunction with increment, where the character that the parser's index is sitting on is returned.
   * 
   * @return The character that the parser's character index is at in the textual input data.
   */
  @umplesourcefile(line={770},file={"TextParser_Code.ump"},javaline={832},length={3})
   private char c(){
    return charAt(_currentCharacterIndex);
  }

  @umplesourcefile(line={775},file={"TextParser_Code.ump"},javaline={844},length={3})
   private char charAt(int index){
    return index > _maxCharacterIndex ? ' ' : _textCharacters[index];
  }

  @umplesourcefile(line={780},file={"TextParser_Code.ump"},javaline={849},length={3})
   private boolean isSpace(){
    return isSpace(c());
  }

  @umplesourcefile(line={785},file={"TextParser_Code.ump"},javaline={854},length={3})
   private boolean isSpace(char c){
    return c == ' ' || c == '\n' || c == '\t' || c == '\r';
  }

  @umplesourcefile(line={790},file={"TextParser_Code.ump"},javaline={859},length={3})
   private boolean isAlpha(char c){
    return (c >= 'a' && c < 'z') || (c >= 'A' && c < 'Z');
  }

  @umplesourcefile(line={795},file={"TextParser_Code.ump"},javaline={864},length={3})
   private boolean isNumeric(char c){
    return c >= '0' && c < '9';
  }

  @umplesourcefile(line={800},file={"TextParser_Code.ump"},javaline={869},length={12})
   private int calculateStartIndex(int originalStartIndex){
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
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={13},file={"TextParser_Code.ump"},javaline={885},length={2})
  private char[] _textCharacters ;

  
}