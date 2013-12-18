/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.util;
import java.util.*;

/**
 * @umplesource Util_Code.ump 846
 */
// line 846 "../../../../src/Util_Code.ump"
public class Glossary
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Glossary Attributes
  private List<Word> words;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  @umplesourcefile(line={851},file={"Util_Code.ump"},javaline={32},length={1})
  public Glossary()
  {
    words = new ArrayList<Word>();
    // line 851 "../../../../src/Util_Code.ump"
    init();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean addWord(Word aWord)
  {
    boolean wasAdded = false;
    wasAdded = words.add(aWord);
    return wasAdded;
  }

  public boolean removeWord(Word aWord)
  {
    boolean wasRemoved = false;
    wasRemoved = words.remove(aWord);
    return wasRemoved;
  }

  public Word getWord(int index)
  {
    Word aWord = words.get(index);
    return aWord;
  }

  public Word[] getWords()
  {
    Word[] newWords = words.toArray(new Word[words.size()]);
    return newWords;
  }

  public int numberOfWords()
  {
    int number = words.size();
    return number;
  }

  public boolean hasWords()
  {
    boolean has = words.size() > 0;
    return has;
  }

  public int indexOfWord(Word aWord)
  {
    int index = words.indexOf(aWord);
    return index;
  }

  public void delete()
  {}

  @umplesourcefile(line={857},file={"Util_Code.ump"},javaline={88},length={30})
   private void init(){
    addWord(new Word("fish","fish"));
    addWord(new Word("sheep","sheep"));
    addWord(new Word("equipment","equipment"));
    addWord(new Word("information","information"));
    addWord(new Word("rice","rice"));
    addWord(new Word("money","money"));
    addWord(new Word("species","species"));
    addWord(new Word("series","series"));
    addWord(new Word("man","men"));
    addWord(new Word("child","children"));
    addWord(new Word("sex","sexes"));
    addWord(new Word("move","moves"));


	addWord(new Word("shoe","shoes"));
	addWord(new Word("axis","axes"));
	addWord(new Word("testis","testes"));
	addWord(new Word("crisis","crises"));
	addWord(new Word("virus","viruses")); 
	addWord(new Word("octopus","octopi"));
	addWord(new Word("status","statuses"));
	addWord(new Word("alias","aliases"));
	addWord(new Word("ox","oxen"));
	addWord(new Word("index","indices"));
	addWord(new Word("vertex","vertices"));
	addWord(new Word("quiz","quizzes"));
	addWord(new Word("matrix","matrices"));
	addWord(new Word("radius","radii"));
  }

  @umplesourcefile(line={890},file={"Util_Code.ump"},javaline={120},length={52})
   public String getSingular(String plural){
    if (plural == null || plural.length() == 0)
    {
      return "";
    }
    else
    {
      for(Word w : getWords())
      {
        if (w.getPlural().equals(plural))
        {
          return w.getSingular();
        }
      }
      
      if (plural.endsWith("y"))
      {
        return plural;
      }
      else if (plural.endsWith("ies"))
      {
        return plural.substring(0,plural.length()-3) + "y";
      }
      
      else if (plural.endsWith("sses"))
      {
        return plural.substring(0,plural.length()-2);
      }
      else if (plural.endsWith("ss"))
      {
        return plural;
      }

      else if (plural.endsWith("uses"))
      {
        return plural.substring(0,plural.length()-2);
      }
      else if (plural.endsWith("us"))
      {
        return plural;
      }
      
      else if (plural.endsWith("s"))
      {
        return plural.substring(0,plural.length()-1);
      }
      else
      {
        return plural;
      }
    }
  }

  @umplesourcefile(line={944},file={"Util_Code.ump"},javaline={174},length={52})
   public String getPlural(String singular){
    if (singular == null || singular.length() == 0)
    {
      return "s";
    }
    else
    {
      for(Word w : getWords())
      {
        if (w.getSingular().equals(singular))
        {
          return w.getPlural();
        }
      }

      if (singular.endsWith("y"))
      {
        return singular.substring(0,singular.length()-1) + "ies";
      }
      else if (singular.endsWith("ies"))
      {
        return singular;
      }
      
      else if (singular.endsWith("sses"))
      {
        return singular;
      }
      else if (singular.endsWith("ss"))
      {
        return singular + "es";
      }

      else if (singular.endsWith("uses"))
      {
        return singular;
      }
      else if (singular.endsWith("us"))
      {
        return singular + "es";
      }
      
      else if (singular.endsWith("s"))
      {
        return singular;
      }
      else
      {
        return singular + "s";
      }
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]"
     + outputString;
  }
}