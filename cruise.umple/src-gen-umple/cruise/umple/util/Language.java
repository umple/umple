/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.util;
import java.util.*;

/**
 * @umplesource Util_Code.ump 24
 */
// line 24 "../../../../src/Util_Code.ump"
public class Language
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Language theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private Language()
  {
    // line 29 "../../../../src/Util_Code.ump"
    init();
  }

  public static Language getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new Language();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 31 ../../../../src/Util_Code.ump
  private static final boolean default_strictness = false;
  private Hashtable<String, String> _allEnglish;

  private void init()
  {
    _allEnglish = new Hashtable<String, String>();
    add("problem_with_umple_file","Unable to use @1, due to @2");
  }

  public static void reset()
  {
    getInstance().init();
  }
  
  public void add(String id, String english)
  {
    _allEnglish.put(id, english);
  }
  
  public String lookup(String id)
  {
    return lookup(id,default_strictness);
  }
  
  public String lookup(String id, boolean isStrict)
  {
    String defaultText = isStrict ? "UNKNOWN: " + id : id;
    return _allEnglish.containsKey(id) ? _allEnglish.get(id) : defaultText;
  }

  public String lookup(String id, String[] allReplacements)
  {
    return lookup(id,true,allReplacements);
  }
  
  public String lookup(String id, boolean isStrict, String[] allReplacements)
  {
    String text = lookup(id,isStrict);
    for (int i=1; i<=allReplacements.length; i++)
    {
      text = text.replace("@" + i, allReplacements[i-1]);
    }
    return text;
  }
}