/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * Part of a grammar rule
 * @umplesource Parser.ump 165
 * @umplesource Parser_Code.ump 425
 */
// line 165 "../../../../src/Parser.ump"
// line 425 "../../../../src/Parser_Code.ump"
public class RulePart
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RulePart Attributes
  private String name;
  private String multiplicity;
  private List<String> nextIdentifiers;
  private int maximumPartsFound;

  //RulePart State Machines
  enum Type { Static, Variable, Rule }
  private Type type;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RulePart(String aName, String aMultiplicity)
  {
    name = aName;
    multiplicity = aMultiplicity;
    nextIdentifiers = new ArrayList<String>();
    maximumPartsFound = -1;
    setType(Type.Static);
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

  public boolean setMultiplicity(String aMultiplicity)
  {
    boolean wasSet = false;
    multiplicity = aMultiplicity;
    wasSet = true;
    return wasSet;
  }

  @umplesourcefile(line={177},file={"Parser.ump"},javaline={71},length={1})
  public boolean addNextIdentifier(String aNextIdentifier)
  {
    boolean wasAdded = false;
    // line 177 "../../../../src/Parser.ump"
    if (aNextIdentifier == null) { return false; }
    wasAdded = nextIdentifiers.add(aNextIdentifier);
    return wasAdded;
  }

  @umplesourcefile(line={177},file={"Parser.ump"},javaline={71},length={1})
  public boolean removeNextIdentifier(String aNextIdentifier)
  {
    boolean wasRemoved = false;
    wasRemoved = nextIdentifiers.remove(aNextIdentifier);
    return wasRemoved;
  }

  public boolean setMaximumPartsFound(int aMaximumPartsFound)
  {
    boolean wasSet = false;
    maximumPartsFound = aMaximumPartsFound;
    wasSet = true;
    return wasSet;
  }

  /**
   * The name of the rule part.
   */
  public String getName()
  {
    return name;
  }

  @umplesourcefile(line={178},file={"Parser.ump"},javaline={102},length={1})
  public String getMultiplicity()
  {
    // line 178 "../../../../src/Parser.ump"
    if (multiplicity == null) { return "1"; }
    return multiplicity;
  }

  public String getNextIdentifier(int index)
  {
    String aNextIdentifier = nextIdentifiers.get(index);
    return aNextIdentifier;
  }

  public String[] getNextIdentifiers()
  {
    String[] newNextIdentifiers = nextIdentifiers.toArray(new String[nextIdentifiers.size()]);
    return newNextIdentifiers;
  }

  public int numberOfNextIdentifiers()
  {
    int number = nextIdentifiers.size();
    return number;
  }

  public boolean hasNextIdentifiers()
  {
    boolean has = nextIdentifiers.size() > 0;
    return has;
  }

  public int indexOfNextIdentifier(String aNextIdentifier)
  {
    int index = nextIdentifiers.indexOf(aNextIdentifier);
    return index;
  }

  public int getMaximumPartsFound()
  {
    return maximumPartsFound;
  }

  public String getTypeFullName()
  {
    String answer = type.toString();
    return answer;
  }

  public Type getType()
  {
    return type;
  }

  public boolean setType(Type aType)
  {
    type = aType;
    return true;
  }

  public void delete()
  {}

  @umplesourcefile(line={428},file={"Parser_Code.ump"},javaline={164},length={3})
   public boolean isWithinLimits(int numberSoFar){
    return getMaximumPartsFound() == -1 || numberSoFar < getMaximumPartsFound();
  }

  @umplesourcefile(line={433},file={"Parser_Code.ump"},javaline={169},length={29})
   public String getDisplayName(){
    if (isEnum())
    {
      TextParser parser = new TextParser(name);
      parser.nextAt("=");
      return parser.nextUntil(":");
    }
    else if (isRegex())
    {
      TextParser parser = new TextParser(name);
      parser.nextAt("!");
      return parser.nextUntil(":");
    }
    else if (isToEndOfLine())
    {
      return name.substring(1);
    }
    else if (isMultiWord())
    {
      return name.substring(2);
    }
    else if (isAlphanumeric()) {
      return name.substring(1);
    }
    else
    {
      return name;
    }
  }

  @umplesourcefile(line={464},file={"Parser_Code.ump"},javaline={200},length={3})
   public void removeNextIdentifiers(){
    nextIdentifiers.clear();
  }

  @umplesourcefile(line={469},file={"Parser_Code.ump"},javaline={205},length={18})
   public String[] getInnerNames(){
    if (!hasInnerNames())
    {
      return new String[0];
    }

    TextParser parser = new TextParser(name);
    parser.load(parser.nextUntil(">"));
    ArrayList<String> allNames = new ArrayList<String>();


    while(parser.nextUntil(",") != null)
    {
      allNames.add(parser.name());
      parser.nextAt(",");
    }
    return allNames.toArray(new String[allNames.size()]);
  }

  @umplesourcefile(line={489},file={"Parser_Code.ump"},javaline={225},length={13})
   public boolean isValidInnerValues(String value){
    if (value == null)
    {
      return false;
    }
    TextParser parser = new TextParser(value);
    int number = 0;
    while (parser.next() != null)
    {
      number++;
    }
    return number > 0 && number <= getInnerNames().length;
  }

  @umplesourcefile(line={504},file={"Parser_Code.ump"},javaline={240},length={58})
   public RulePartValue[] getInnerValues(String value){
    if (!hasInnerNames())
    {
      return new RulePartValue[0];
    }

    String[] allNames = getInnerNames();
    RulePartValue[] allRulePartValues = new RulePartValue[allNames.length];

    for (int i=0; i<allNames.length; i++)
    {
      allRulePartValues[i] = new RulePartValue();
      allRulePartValues[i].setName(allNames[i]);
    }


    if (value == null)
    {
      return allRulePartValues;
    }

    ArrayList<String> allUnorderedValues = new ArrayList<String>();
    ArrayList<Position> allUnorderedPositions = new ArrayList<Position>();

    TextParser parser = new TextParser(value);
    while(parser.peek() != null)
    {
      allUnorderedPositions.add(parser.currentPosition().copy());
      allUnorderedValues.add(parser.next());
    }

    int[] allValueIndicies = new int[allNames.length];

    TextParser namesParser = new TextParser(name);
    namesParser.nextUntil(">");
    namesParser.nextAt(">");
    for (int i=0; i<allValueIndicies.length; i++)
    {
      String nextOrderText = namesParser.nextUntil(",");
      int next = nextOrderText == null ? i : Integer.parseInt(nextOrderText);
      namesParser.nextAt(",");
      allValueIndicies[i] = next;
    }

    int maximumIndex = allUnorderedValues.size() - 1;
    int unorderedIndex = 0;
    for (int i=0; i<allValueIndicies.length; i++)
    {
      int currentIndex = allValueIndicies[i];
      String orderedValue = currentIndex <= maximumIndex ? allUnorderedValues.get(unorderedIndex) : null;
      Position orderedPosition = currentIndex <= maximumIndex ? allUnorderedPositions.get(unorderedIndex++) : null;

      allRulePartValues[i].setValue(orderedValue);
      allRulePartValues[i].setPosition(orderedPosition);
    }

    return allRulePartValues;
  }

  @umplesourcefile(line={564},file={"Parser_Code.ump"},javaline={300},length={3})
   public boolean hasInnerNames(){
    return getName() != null && getName().indexOf(",") != -1;
  }

  @umplesourcefile(line={569},file={"Parser_Code.ump"},javaline={305},length={3})
   public boolean isStatic(){
    return Type.Static.equals(getType());
  }

  @umplesourcefile(line={574},file={"Parser_Code.ump"},javaline={310},length={3})
   public boolean isMultiWord(){
    return getName().startsWith("**");
  }

  @umplesourcefile(line={579},file={"Parser_Code.ump"},javaline={315},length={3})
   public boolean isToEndOfLine(){
    return !isMultiWord() && getName().startsWith("*");
  }

  @umplesourcefile(line={584},file={"Parser_Code.ump"},javaline={320},length={3})
   public boolean isAlphanumeric(){
    return getName().startsWith("~");
  }

  @umplesourcefile(line={589},file={"Parser_Code.ump"},javaline={325},length={3})
   public boolean isVariable(){
    return Type.Variable.equals(getType());
  }

  @umplesourcefile(line={594},file={"Parser_Code.ump"},javaline={330},length={3})
   public boolean isEnum(){
    return isVariable() && name != null && name.startsWith("=");
  }

  @umplesourcefile(line={599},file={"Parser_Code.ump"},javaline={335},length={3})
   public boolean isRegex(){
    return isVariable() && name != null && name.startsWith("!");
  }

  @umplesourcefile(line={603},file={"Parser_Code.ump"},javaline={340},length={15})
   public String getRegex(){
    if (name == null)
    {
      return null;
    }

    TextParser parser = new TextParser(name);
    parser.nextAfter(":");

    if (parser.peek() == null)
    {
      return null;
    }
    return parser.nextLine();
  }

  @umplesourcefile(line={619},file={"Parser_Code.ump"},javaline={357},length={22})
   public String[] getEnums(){
    if (name == null)
    {
      return new String[0];
    }

    TextParser parser = new TextParser(name);
    parser.nextAfter(":");

    if (parser.peek() == null)
    {
      return new String[] {getDisplayName()}; 
    }

    ArrayList<String> allEnums = new ArrayList<String>();
    while (parser.nextUntil("|") != null)
    {
      allEnums.add(parser.name());
      parser.nextAt("|");
    }
    return allEnums.toArray(new String[allEnums.size()]);
  }

  @umplesourcefile(line={643},file={"Parser_Code.ump"},javaline={381},length={15})
   public boolean isEnumValue(String input){
    if (!isEnum() || input == null)
    {
      return false;
    }

    for (String aEnum : getEnums())
    {
      if (aEnum.equals(input))
      {
        return true;
      }
    }
    return false;
  }

  @umplesourcefile(line={660},file={"Parser_Code.ump"},javaline={398},length={8})
   public boolean regexMatches(String input){
    String regex = getRegex();
    if (regex == null || input == null || !isRegex())
    {
      return false;
    }
    return input.matches(regex);
  }

  @umplesourcefile(line={669},file={"Parser_Code.ump"},javaline={408},length={3})
   public boolean isRule(){
    return Type.Rule.equals(getType());
  }

  @umplesourcefile(line={675},file={"Parser_Code.ump"},javaline={413},length={3})
   public boolean isOne(){
    return "1".equals(getMultiplicity());
  }

  @umplesourcefile(line={680},file={"Parser_Code.ump"},javaline={418},length={3})
   public boolean isOptional(){
    return "?".equals(getMultiplicity());
  }

  @umplesourcefile(line={685},file={"Parser_Code.ump"},javaline={423},length={3})
   public boolean isMany(){
    return "*".equals(getMultiplicity());
  }

  @umplesourcefile(line={690},file={"Parser_Code.ump"},javaline={428},length={3})
   public boolean isAnonymous(){
    return getName().startsWith("anonymous::");
  }

  @umplesourcefile(line={695},file={"Parser_Code.ump"},javaline={433},length={10})
   public String toString(){
    StringBuffer answer = new StringBuffer();
    answer.append("Nexts:");
    for (int i=0; i<nextIdentifiers.size(); i++)
    {
      answer.append("[" + nextIdentifiers.get(i) + "]");
    }
    answer.append("\n");
    return answer.toString();
  }

}