/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * Part of a grammar rule
 * @umplesource Parser.ump 164
 * @umplesource Parser_Code.ump 426
 */
// line 164 "../../../../src/Parser.ump"
// line 426 "../../../../src/Parser_Code.ump"
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

  @umplesourcefile(line={176},file={"Parser.ump"},javaline={70},length={1})
  public boolean addNextIdentifier(String aNextIdentifier)
  {
    boolean wasAdded = false;
    // line 176 "../../../../src/Parser.ump"
    if (aNextIdentifier == null) { return false; }
    wasAdded = nextIdentifiers.add(aNextIdentifier);
    return wasAdded;
  }

  @umplesourcefile(line={176},file={"Parser.ump"},javaline={70},length={1})
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

  @umplesourcefile(line={177},file={"Parser.ump"},javaline={101},length={1})
  public String getMultiplicity()
  {
    // line 177 "../../../../src/Parser.ump"
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
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  // line 429 ../../../../src/Parser_Code.ump
  @umplesourcefile(line={429},file={"Parser_Code.ump"},javaline={168},length={4})
  public boolean isWithinLimits(int numberSoFar)
  {
    return getMaximumPartsFound() == -1 || numberSoFar < getMaximumPartsFound();
  }

  @umplesourcefile(line={434},file={"Parser_Code.ump"},javaline={174},length={24})
  public String getDisplayName()
  {
    if (isEnum())
    {
      TextParser parser = new TextParser(name);
      parser.nextAt("=");
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

  @umplesourcefile(line={459},file={"Parser_Code.ump"},javaline={200},length={4})
  public void removeNextIdentifiers()
  {
    nextIdentifiers.clear();
  }

  @umplesourcefile(line={464},file={"Parser_Code.ump"},javaline={206},length={19})
  public String[] getInnerNames()
  {
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

  @umplesourcefile(line={484},file={"Parser_Code.ump"},javaline={227},length={14})
  public boolean isValidInnerValues(String value)
  {
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

  @umplesourcefile(line={499},file={"Parser_Code.ump"},javaline={243},length={59})
  public RulePartValue[] getInnerValues(String value)
  {
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

  @umplesourcefile(line={559},file={"Parser_Code.ump"},javaline={304},length={4})
  public boolean hasInnerNames()
  {
    return getName() != null && getName().indexOf(",") != -1;
  }

  @umplesourcefile(line={564},file={"Parser_Code.ump"},javaline={310},length={4})
  public boolean isStatic()
  {
    return Type.Static.equals(getType()); 
  }

  @umplesourcefile(line={569},file={"Parser_Code.ump"},javaline={316},length={4})
  public boolean isMultiWord()
  {
    return getName().startsWith("**");
  }

  @umplesourcefile(line={574},file={"Parser_Code.ump"},javaline={322},length={4})
  public boolean isToEndOfLine()
  {
    return !isMultiWord() && getName().startsWith("*");
  }

  @umplesourcefile(line={579},file={"Parser_Code.ump"},javaline={328},length={3})
  public boolean isAlphanumeric() {
    return getName().startsWith("~");
  }


  @umplesourcefile(line={584},file={"Parser_Code.ump"},javaline={334},length={4})
  public boolean isVariable()
  {
    return Type.Variable.equals(getType()); 
  }

  @umplesourcefile(line={589},file={"Parser_Code.ump"},javaline={340},length={4})
  public boolean isEnum()
  {
    return isVariable() && name != null && name.startsWith("="); 
  }

  @umplesourcefile(line={594},file={"Parser_Code.ump"},javaline={346},length={23})
  public String[] getEnums()
  {
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

  @umplesourcefile(line={618},file={"Parser_Code.ump"},javaline={371},length={16})
  public boolean isEnumValue(String input)
  {
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

  @umplesourcefile(line={635},file={"Parser_Code.ump"},javaline={389},length={4})
  public boolean isRule()
  {
    return Type.Rule.equals(getType()); 
  }  


  @umplesourcefile(line={641},file={"Parser_Code.ump"},javaline={396},length={4})
  public boolean isOne()
  {
    return "1".equals(getMultiplicity());
  }

  @umplesourcefile(line={646},file={"Parser_Code.ump"},javaline={402},length={4})
  public boolean isOptional()
  {
    return "?".equals(getMultiplicity());
  }

  @umplesourcefile(line={651},file={"Parser_Code.ump"},javaline={408},length={4})
  public boolean isMany()
  {
    return "*".equals(getMultiplicity());
  }

  @umplesourcefile(line={656},file={"Parser_Code.ump"},javaline={414},length={4})
  public boolean isAnonymous()
  {
    return getName().startsWith("anonymous::");
  }

  @umplesourcefile(line={661},file={"Parser_Code.ump"},javaline={420},length={11})
  public String toString()
  {
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