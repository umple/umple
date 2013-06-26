/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * An open-close pair, such as open curly brackets and close curly brackets
 * Used to identify block start and end while parsing
 * @umplesource Parser.ump 18
 * @umplesource Parser_Code.ump 12
 */
// line 18 "../../../../src/Parser.ump"
// line 12 "../../../../src/Parser_Code.ump"
public class Couple
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Couple Attributes
  private String open;
  private String close;

  //Couple Associations
  private List<Couple> ignores;
  private Couple couple;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Couple(String aOpen, String aClose)
  {
    open = aOpen;
    close = aClose;
    ignores = new ArrayList<Couple>();
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

  public String getOpen()
  {
    return open;
  }

  public String getClose()
  {
    return close;
  }

  public Couple getIgnore(int index)
  {
    Couple aIgnore = ignores.get(index);
    return aIgnore;
  }

  public List<Couple> getIgnores()
  {
    List<Couple> newIgnores = Collections.unmodifiableList(ignores);
    return newIgnores;
  }

  public int numberOfIgnores()
  {
    int number = ignores.size();
    return number;
  }

  public boolean hasIgnores()
  {
    boolean has = ignores.size() > 0;
    return has;
  }

  public int indexOfIgnore(Couple aIgnore)
  {
    int index = ignores.indexOf(aIgnore);
    return index;
  }

  public Couple getCouple()
  {
    return couple;
  }

  public static int minimumNumberOfIgnores()
  {
    return 0;
  }

  public boolean addIgnore(Couple aIgnore)
  {
    boolean wasAdded = false;
    if (ignores.contains(aIgnore)) { return false; }
    Couple existingCouple = aIgnore.getCouple();
    if (existingCouple == null)
    {
      aIgnore.setCouple(this);
    }
    else if (!this.equals(existingCouple))
    {
      existingCouple.removeIgnore(aIgnore);
      addIgnore(aIgnore);
    }
    else
    {
      ignores.add(aIgnore);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeIgnore(Couple aIgnore)
  {
    boolean wasRemoved = false;
    if (ignores.contains(aIgnore))
    {
      ignores.remove(aIgnore);
      aIgnore.setCouple(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addIgnoreAt(Couple aIgnore, int index)
  {  
    boolean wasAdded = false;
    if(addIgnore(aIgnore))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIgnores()) { index = numberOfIgnores() - 1; }
      ignores.remove(aIgnore);
      ignores.add(index, aIgnore);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveIgnoreAt(Couple aIgnore, int index)
  {
    boolean wasAdded = false;
    if(ignores.contains(aIgnore))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIgnores()) { index = numberOfIgnores() - 1; }
      ignores.remove(aIgnore);
      ignores.add(index, aIgnore);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addIgnoreAt(aIgnore, index);
    }
    return wasAdded;
  }

  public boolean setCouple(Couple aCouple)
  {
    boolean wasSet = false;
    Couple existingCouple = couple;
    couple = aCouple;
    if (existingCouple != null && !existingCouple.equals(aCouple))
    {
      existingCouple.removeIgnore(this);
    }
    if (aCouple != null)
    {
      aCouple.addIgnore(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(Couple aIgnore : ignores)
    {
      aIgnore.setCouple(null);
    }
    if (couple != null)
    {
      Couple placeholderCouple = couple;
      this.couple = null;
      placeholderCouple.removeIgnore(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "open" + ":" + getOpen()+ "," +
            "close" + ":" + getClose()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "couple" + "=" + (getCouple() != null ? !getCouple().equals(this)  ? getCouple().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={14},file={"Parser_Code.ump"},javaline={225},length={64})
  @umplesourcefile(line={15},file={"Parser_Code.ump"},javaline={226},length={28})
  public boolean isBalanced(String input)
  {

    if (input == null)
    {
      return true;
    }

    input = removeIgnoredText(input);

    int numberOfOpen = 0;
    int numberOfClosed = 0;

    int currentIndex = 0;
    while ((currentIndex = input.indexOf(open,currentIndex)) != -1)
    {
      numberOfOpen += 1;
      currentIndex += 1;
    }

    currentIndex = 0;
    while (numberOfClosed <= numberOfOpen && (currentIndex = input.indexOf(close,currentIndex)) != -1)
    {
      numberOfClosed += 1;
      currentIndex += 1;
    }
    return numberOfOpen <= numberOfClosed;
  }


  @umplesourcefile(line={45},file={"Parser_Code.ump"},javaline={257},length={33})
  public String removeIgnoredText(String input)
  {
    String output = input;

    for (Couple ignore : ignores)
    {
      output = ignore.removeIgnoredText(output);
      int startIndex = 0;
      while ((startIndex = output.indexOf(ignore.getOpen())) != -1)
      {
        int endIndex = output.indexOf(ignore.getClose(),startIndex+ignore.getOpen().length());
        int endIndexOffset = ignore.getClose().length();

        if (startIndex == 0 && (endIndex == -1 || endIndex == output.length() - 1))
        {
          output = "";
        }
        else if (startIndex == 0)
        {
          output = output.substring(endIndex+ignore.getClose().length());
        }
        else if (endIndex == -1)
        {
          output = output.substring(0,startIndex);
        }
        else
        {
          output = output.substring(0,startIndex) + output.substring(endIndex+endIndexOffset);
        }
      }
    }
    return output;
  }

}