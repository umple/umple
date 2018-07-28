/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.28.0.4148.608b7c78e modeling language!*/

package cruise.umple.testgenerator;
import cruise.umple.parser.ParseResult;
import java.util.*;

// line 12 "../../../../ump/TestCaseTemplate_model.ump"
public class TestModel
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TestModel Attributes
  private String file;
  private String code;
  private String givenCode;
  private String whereCode;
  private String thenCode;
  private String coverageType;
  private ParseResult parseingResult;
  private String codeLang;

  //TestModel Associations
  private List<TestSuite> testSuites;
  private List<Depend> depends;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TestModel(String aFile, String aCode, String aGivenCode, String aWhereCode, String aThenCode, String aCoverageType, ParseResult aParseingResult, String aCodeLang)
  {
    file = aFile;
    code = aCode;
    givenCode = aGivenCode;
    whereCode = aWhereCode;
    thenCode = aThenCode;
    coverageType = aCoverageType;
    parseingResult = aParseingResult;
    codeLang = aCodeLang;
    testSuites = new ArrayList<TestSuite>();
    depends = new ArrayList<Depend>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setFile(String aFile)
  {
    boolean wasSet = false;
    file = aFile;
    wasSet = true;
    return wasSet;
  }

  public boolean setCode(String aCode)
  {
    boolean wasSet = false;
    code = aCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setGivenCode(String aGivenCode)
  {
    boolean wasSet = false;
    givenCode = aGivenCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setWhereCode(String aWhereCode)
  {
    boolean wasSet = false;
    whereCode = aWhereCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setThenCode(String aThenCode)
  {
    boolean wasSet = false;
    thenCode = aThenCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setCoverageType(String aCoverageType)
  {
    boolean wasSet = false;
    coverageType = aCoverageType;
    wasSet = true;
    return wasSet;
  }

  public boolean setParseingResult(ParseResult aParseingResult)
  {
    boolean wasSet = false;
    parseingResult = aParseingResult;
    wasSet = true;
    return wasSet;
  }

  public boolean setCodeLang(String aCodeLang)
  {
    boolean wasSet = false;
    codeLang = aCodeLang;
    wasSet = true;
    return wasSet;
  }

  public String getFile()
  {
    return file;
  }

  public String getCode()
  {
    return code;
  }

  public String getGivenCode()
  {
    return givenCode;
  }

  public String getWhereCode()
  {
    return whereCode;
  }

  public String getThenCode()
  {
    return thenCode;
  }

  public String getCoverageType()
  {
    return coverageType;
  }

  public ParseResult getParseingResult()
  {
    return parseingResult;
  }

  public String getCodeLang()
  {
    return codeLang;
  }
  /* Code from template association_GetMany */
  public TestSuite getTestSuite(int index)
  {
    TestSuite aTestSuite = testSuites.get(index);
    return aTestSuite;
  }

  public List<TestSuite> getTestSuites()
  {
    List<TestSuite> newTestSuites = Collections.unmodifiableList(testSuites);
    return newTestSuites;
  }

  public int numberOfTestSuites()
  {
    int number = testSuites.size();
    return number;
  }

  public boolean hasTestSuites()
  {
    boolean has = testSuites.size() > 0;
    return has;
  }

  public int indexOfTestSuite(TestSuite aTestSuite)
  {
    int index = testSuites.indexOf(aTestSuite);
    return index;
  }
  /* Code from template association_GetMany */
  public Depend getDepend(int index)
  {
    Depend aDepend = depends.get(index);
    return aDepend;
  }

  public List<Depend> getDepends()
  {
    List<Depend> newDepends = Collections.unmodifiableList(depends);
    return newDepends;
  }

  public int numberOfDepends()
  {
    int number = depends.size();
    return number;
  }

  public boolean hasDepends()
  {
    boolean has = depends.size() > 0;
    return has;
  }

  public int indexOfDepend(Depend aDepend)
  {
    int index = depends.indexOf(aDepend);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTestSuites()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public TestSuite addTestSuite()
  {
    return new TestSuite(this);
  }

  public boolean addTestSuite(TestSuite aTestSuite)
  {
    boolean wasAdded = false;
    if (testSuites.contains(aTestSuite)) { return false; }
    TestModel existingTestModel = aTestSuite.getTestModel();
    boolean isNewTestModel = existingTestModel != null && !this.equals(existingTestModel);
    if (isNewTestModel)
    {
      aTestSuite.setTestModel(this);
    }
    else
    {
      testSuites.add(aTestSuite);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTestSuite(TestSuite aTestSuite)
  {
    boolean wasRemoved = false;
    //Unable to remove aTestSuite, as it must always have a testModel
    if (!this.equals(aTestSuite.getTestModel()))
    {
      testSuites.remove(aTestSuite);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTestSuiteAt(TestSuite aTestSuite, int index)
  {  
    boolean wasAdded = false;
    if(addTestSuite(aTestSuite))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTestSuites()) { index = numberOfTestSuites() - 1; }
      testSuites.remove(aTestSuite);
      testSuites.add(index, aTestSuite);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTestSuiteAt(TestSuite aTestSuite, int index)
  {
    boolean wasAdded = false;
    if(testSuites.contains(aTestSuite))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTestSuites()) { index = numberOfTestSuites() - 1; }
      testSuites.remove(aTestSuite);
      testSuites.add(index, aTestSuite);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTestSuiteAt(aTestSuite, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDepends()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Depend addDepend(String aName, String aType)
  {
    return new Depend(aName, aType, this);
  }

  public boolean addDepend(Depend aDepend)
  {
    boolean wasAdded = false;
    if (depends.contains(aDepend)) { return false; }
    TestModel existingTestModel = aDepend.getTestModel();
    boolean isNewTestModel = existingTestModel != null && !this.equals(existingTestModel);
    if (isNewTestModel)
    {
      aDepend.setTestModel(this);
    }
    else
    {
      depends.add(aDepend);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDepend(Depend aDepend)
  {
    boolean wasRemoved = false;
    //Unable to remove aDepend, as it must always have a testModel
    if (!this.equals(aDepend.getTestModel()))
    {
      depends.remove(aDepend);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addDependAt(Depend aDepend, int index)
  {  
    boolean wasAdded = false;
    if(addDepend(aDepend))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDepends()) { index = numberOfDepends() - 1; }
      depends.remove(aDepend);
      depends.add(index, aDepend);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDependAt(Depend aDepend, int index)
  {
    boolean wasAdded = false;
    if(depends.contains(aDepend))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDepends()) { index = numberOfDepends() - 1; }
      depends.remove(aDepend);
      depends.add(index, aDepend);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDependAt(aDepend, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=testSuites.size(); i > 0; i--)
    {
      TestSuite aTestSuite = testSuites.get(i - 1);
      aTestSuite.delete();
    }
    for(int i=depends.size(); i > 0; i--)
    {
      Depend aDepend = depends.get(i - 1);
      aDepend.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "file" + ":" + getFile()+ "," +
            "code" + ":" + getCode()+ "," +
            "givenCode" + ":" + getGivenCode()+ "," +
            "whereCode" + ":" + getWhereCode()+ "," +
            "thenCode" + ":" + getThenCode()+ "," +
            "coverageType" + ":" + getCoverageType()+ "," +
            "codeLang" + ":" + getCodeLang()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "parseingResult" + "=" + (getParseingResult() != null ? !getParseingResult().equals(this)  ? getParseingResult().toString().replaceAll("  ","    ") : "this" : "null");
  }
}