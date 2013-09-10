/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.util;
import java.util.*;

/**
 * @umplesource Util_Code.ump 24
 */
// line 24 "../../../../src/Util_Code.ump"
public class Language
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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

  @umplesourcefile(line={29},file={"Util_Code.ump"},javaline={34},length={1})
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

  @umplesourcefile(line={34},file={"Util_Code.ump"},javaline={54},length={4})
   private void init(){
    _allEnglish = new Hashtable<String, String>();
    add("problem_with_umple_file","Unable to use @1, due to @2");
  }

  @umplesourcefile(line={40},file={"Util_Code.ump"},javaline={60},length={3})
   public static  void reset(){
    getInstance().init();
  }

  @umplesourcefile(line={45},file={"Util_Code.ump"},javaline={65},length={3})
   public void add(String id, String english){
    _allEnglish.put(id, english);
  }

  @umplesourcefile(line={50},file={"Util_Code.ump"},javaline={70},length={3})
   public String lookup(String id){
    return lookup(id,default_strictness);
  }

  @umplesourcefile(line={55},file={"Util_Code.ump"},javaline={75},length={4})
   public String lookup(String id, boolean isStrict){
    String defaultText = isStrict ? "UNKNOWN: " + id : id;
    return _allEnglish.containsKey(id) ? _allEnglish.get(id) : defaultText;
  }

  @umplesourcefile(line={61},file={"Util_Code.ump"},javaline={81},length={3})
   public String lookup(String id, String [] allReplacements){
    return lookup(id,true,allReplacements);
  }

  @umplesourcefile(line={66},file={"Util_Code.ump"},javaline={86},length={8})
   public String lookup(String id, boolean isStrict, String [] allReplacements){
    String text = lookup(id,isStrict);
    for (int i=1; i<=allReplacements.length; i++)
    {
      text = text.replace("@" + i, allReplacements[i-1]);
    }
    return text;
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={30},file={"Util_Code.ump"},javaline={99},length={5})
  private static final boolean default_strictness = false ;

//  @umplesourcefile(line={31},file={"Util_Code.ump"},javaline={102},length={2})
  private Hashtable<String, String> _allEnglish ;

}