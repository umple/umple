/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4657.40ea68fec modeling language!*/

package cruise.umple.testgenerator;
import java.util.Random;
import java.lang.reflect.Method;
import cruise.umple.testparser.TestParser;
import java.io.File;

// line 3 "../../../../ump/Utility.ump"
public class Util
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Util Attributes
  private Random random;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Util()
  {
    random = new Random ();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRandom(Random aRandom)
  {
    boolean wasSet = false;
    random = aRandom;
    wasSet = true;
    return wasSet;
  }

  public Random getRandom()
  {
    return random;
  }

  public void delete()
  {}


  /**
   * ------------------------
   * Random String Generator
   * ------------------------
   */
  // line 20 "../../../../ump/Utility.ump"
   public String randomGenerator(Random random, String characters, int length){
    char[] text = new char[length];
    for (int i = 0; i < length; i++)
    {
        text[i] = characters.charAt(random.nextInt(characters.length()));
    }
    return new String(text);
  }


  /**
   * ------------------------
   * Random Int Generator
   * ------------------------
   */
  // line 33 "../../../../ump/Utility.ump"
   public int randomGenerator(int range){
    int text = random.nextInt(range);
	  	
	return text;
  }


  /**
   * ------------------------
   * AssertMethod // check if a method is present in a class using reflection, example: assertMethod(foo.class, "methodName")
   * ------------------------
   */
  // line 45 "../../../../ump/Utility.ump"
   public Boolean assertMethod(Class cls, String methodName){
    Boolean hasMethod = false;
    	Method[] methods = cls.getMethods();
    	for (Method m : methods )
    	{
    		if ( m.getName() == methodName)
    		{ hasMethod = true; }
    	}
    	return hasMethod;
  }

  // line 61 "../../../../ump/Utility.ump"
   public TestModel createUmpleTestSystem(String path, String filename, String lang){
    String language =lang;
     //File file = new File(pathToInput+"/" + path, filename);
     File file = new File(path+filename);
     String grName = "";
     TestModel aTestModel = new TestModel(null, null, null, null, null,null, null, language);
     TestParser parser = new TestParser(null, "", file, 0);
     //ParseResult result = new ParseResult(false);
     //InputStream is = this.getClass().getResourceAsStream("mbt_parsing.grammar");
     //ClassLoader classLoader = getClass().getClassLoader();
     //File grammarFile = new File(classLoader.getResource("mbt_parsing.grammar").getFile());
     ////system.out.println(grammarFile.tos);
     //parser.setGrammarFile(path+"src/ump/mbt_parsing.grammar");
     //InputStream in = getClass().getResourceAsStream("/mbt_parsing.grammar"); 
     //BufferedReader reader = new BufferedReader(new InputStreamReader(in));
     //File grFile = new File (getClass().getResource("mbt_parsing.grammar").getPath().replace("file:", ""));
     //File grFile = new File ();
     //grName = file.getName();
     
     //grName = getClass().getResource("mbt_parsing.grammar").getFile();
     ////system.out.println(Util.class.getResource("mbt_parsing.grammar").getFile());
     //parser.setGrammarFile(Util.class.getResource("mbt_parsing.grammar").getFile().toString());
     ////system.out.println(parser.getGrammarFile());
     parser.setTestModelFile(file);
     //parser.setTestModelFile(file);
     
     
     ////system.out.println(path);
     parser.prepare();
     aTestModel = parser.getATestModel();
     //system.out.println(file.getAbsoluteFile());
     aTestModel.setCodeLang(language);
     //system.out.println(aTestModel.getCodeLang());
     if(aTestModel.getCodeLang().equals("JUnit"))
     {
     
     //language = lang;
     TestCaseJUnitGenerator junitGenerator = new TestCaseJUnitGenerator(null, null, null, null, null);
	     junitGenerator.setTestModel(aTestModel);
	     junitGenerator.setPath(path);
	     junitGenerator.writeFile();
     }
     if(aTestModel.getCodeLang().equals("PhpUnit"))
     {
     	TestCasePhpUnitGenerator phpGenerator = new TestCasePhpUnitGenerator(null, null, null, null, null); 
         phpGenerator.setTestModel(aTestModel);
         phpGenerator.setPath(path);
         phpGenerator.writeFile();
   }
     if(aTestModel.getCodeLang().equals("RubyUnit"))
     {
     	TestCaseRubyUnitGenerator rubyGenerator = new TestCaseRubyUnitGenerator(null, null, null, null, null); 
         rubyGenerator.setTestModel(aTestModel);
         rubyGenerator.setPath(path);
         rubyGenerator.writeFile();
     }
     
     
     
     return aTestModel;
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "random" + "=" + (getRandom() != null ? !getRandom().equals(this)  ? getRandom().toString().replaceAll("  ","    ") : "this" : "null");
  }
}