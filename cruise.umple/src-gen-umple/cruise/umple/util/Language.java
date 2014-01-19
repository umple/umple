/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.util;
import java.util.*;

/**
 * @umplesource Util_Code.ump 23
 */
// line 23 "../../../../src/Util_Code.ump"
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

  @umplesourcefile(line={36},file={"Util_Code.ump"},javaline={55},length={4})
   private void init(){
    _allEnglish = new Hashtable<String, String>();
    add("problem_with_umple_file","Unable to use @1, due to @2");
  }

  @umplesourcefile(line={42},file={"Util_Code.ump"},javaline={61},length={3})
   public static  void reset(){
    getInstance().init();
  }

  @umplesourcefile(line={47},file={"Util_Code.ump"},javaline={66},length={3})
   public void add(String id, String english){
    _allEnglish.put(id, english);
  }

  @umplesourcefile(line={52},file={"Util_Code.ump"},javaline={71},length={3})
   public String lookup(String id){
    return lookup(id,default_strictness);
  }

  @umplesourcefile(line={57},file={"Util_Code.ump"},javaline={76},length={4})
   public String lookup(String id, boolean isStrict){
    String defaultText = isStrict ? "UNKNOWN: " + id : id;
    return _allEnglish.containsKey(id) ? _allEnglish.get(id) : defaultText;
  }

  @umplesourcefile(line={63},file={"Util_Code.ump"},javaline={82},length={3})
   public String lookup(String id, String [] allReplacements){
    return lookup(id,true,allReplacements);
  }

  @umplesourcefile(line={68},file={"Util_Code.ump"},javaline={87},length={8})
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
  //  @umplesourcefile(line={30},file={"Util_Code.ump"},javaline={99},length={4})
  private static final boolean default_strictness = false ;
//  @umplesourcefile(line={31},file={"Util_Code.ump"},javaline={101},length={2})
  private Hashtable<String, String> _allEnglish ;

  
}