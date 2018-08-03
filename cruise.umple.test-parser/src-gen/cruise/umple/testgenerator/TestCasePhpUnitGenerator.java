/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.28.0.4148.608b7c78e modeling language!*/

package cruise.umple.testgenerator;
import java.io.BufferedWriter;
import cruise.umple.testparser.TestParser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import cruise.umple.compiler.*;
import cruise.umple.unitGen.phpUnit.PhpUnitGenerator;

// line 2 "../../../../ump/TestCaseTemplate_PhpUnitGenerator.ump"
// line 42 "../../../../ump/TestCaseTemplate_Generator.ump"
public class TestCasePhpUnitGenerator implements TestCaseGenerator
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TestCasePhpUnitGenerator Attributes
  private PhpUnitGenerator puG;
  private TestParser parser;
  private TestModel testModel;
  private String grammarFile;
  private File testModelFile;
  private StringBuilder code;
  private String path;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TestCasePhpUnitGenerator(TestModel aTestModel, String aGrammarFile, File aTestModelFile, StringBuilder aCode, String aPath)
  {
    puG = new PhpUnitGenerator();
    parser = new TestParser(null, null, null, 0);
    testModel = aTestModel;
    grammarFile = aGrammarFile;
    testModelFile = aTestModelFile;
    code = aCode;
    path = aPath;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPuG(PhpUnitGenerator aPuG)
  {
    boolean wasSet = false;
    puG = aPuG;
    wasSet = true;
    return wasSet;
  }

  public boolean setParser(TestParser aParser)
  {
    boolean wasSet = false;
    parser = aParser;
    wasSet = true;
    return wasSet;
  }

  public boolean setTestModel(TestModel aTestModel)
  {
    boolean wasSet = false;
    testModel = aTestModel;
    wasSet = true;
    return wasSet;
  }

  public boolean setGrammarFile(String aGrammarFile)
  {
    boolean wasSet = false;
    grammarFile = aGrammarFile;
    wasSet = true;
    return wasSet;
  }

  public boolean setTestModelFile(File aTestModelFile)
  {
    boolean wasSet = false;
    testModelFile = aTestModelFile;
    wasSet = true;
    return wasSet;
  }

  public boolean setCode(StringBuilder aCode)
  {
    boolean wasSet = false;
    code = aCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setPath(String aPath)
  {
    boolean wasSet = false;
    path = aPath;
    wasSet = true;
    return wasSet;
  }

  public PhpUnitGenerator getPuG()
  {
    return puG;
  }

  public TestParser getParser()
  {
    return parser;
  }

  public TestModel getTestModel()
  {
    return testModel;
  }

  public String getGrammarFile()
  {
    return grammarFile;
  }

  public File getTestModelFile()
  {
    return testModelFile;
  }

  public StringBuilder getCode()
  {
    return code;
  }

  public String getPath()
  {
    return path;
  }

  public void delete()
  {}


  @Override
  // line 21 "../../../../ump/TestCaseTemplate_PhpUnitGenerator.ump"
   public boolean setModel(UmpleModel model){
    // TODO Auto-generated method stub
  return false;
  }


  @Override
  // line 27 "../../../../ump/TestCaseTemplate_PhpUnitGenerator.ump"
   public void setCredential(){
    // TODO Auto-generated method stub
  }


  @Override
  // line 33 "../../../../ump/TestCaseTemplate_PhpUnitGenerator.ump"
   public void prepare(){
    grammarFile= "src/mbt_parsing.grammar";
		testModelFile = new File( "src/model1.umpt");
		
		parser.setGrammarFile(grammarFile);
		parser.setTestModelFile(testModelFile);
		parser.prepare();
  }


  @Override
  // line 44 "../../../../ump/TestCaseTemplate_PhpUnitGenerator.ump"
   public void generate(){
    //System.out.println("test");
		prepare();
		setTestModel(parser.getATestModel());
	
		//testModel.getTestSuite(0).getTestcases().forEach(action);
		//code.append(juG.getCode(testModel));
		System.out.println(puG.getCode(testModel));
		writeFile();
  }

  // line 56 "../../../../ump/TestCaseTemplate_PhpUnitGenerator.ump"
   public void writeFile(){
    File file = new File(path);
		String filename = (testModel.getFile().substring(0,testModel.getFile().length()-4))+"Test.php";
			
		System.out.print(file.getAbsolutePath());
		System.out.print("\n");
		file.mkdirs();

					try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(new File(file.getAbsolutePath(),filename)));
					bw.write(puG.getCode(testModel));
					System.out.println(puG.getCode(testModel));
					bw.flush();
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
  }


  @Override
  // line 78 "../../../../ump/TestCaseTemplate_PhpUnitGenerator.ump"
   public void writeFile(TestSuite ts){
    // TODO Auto-generated method stub
  }


  public String toString()
  {
    return super.toString() + "["+
            "grammarFile" + ":" + getGrammarFile()+ "," +
            "path" + ":" + getPath()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "puG" + "=" + (getPuG() != null ? !getPuG().equals(this)  ? getPuG().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "parser" + "=" + (getParser() != null ? !getParser().equals(this)  ? getParser().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "testModel" + "=" + (getTestModel() != null ? !getTestModel().equals(this)  ? getTestModel().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "testModelFile" + "=" + (getTestModelFile() != null ? !getTestModelFile().equals(this)  ? getTestModelFile().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "code" + "=" + (getCode() != null ? !getCode().equals(this)  ? getCode().toString().replaceAll("  ","    ") : "this" : "null");
  }
}