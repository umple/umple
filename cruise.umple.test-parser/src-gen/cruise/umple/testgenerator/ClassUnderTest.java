/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.28.0.4148.608b7c78e modeling language!*/

package cruise.umple.testgenerator;
import java.util.*;

// line 66 "../../../../ump/TestCaseTemplate_model.ump"
public class ClassUnderTest
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassUnderTest Attributes
  private String name;
  private String element;

  //ClassUnderTest Associations
  private List<TestSuite> testSuites;
  private List<TestCase> testCases;
  private List<Parameter> parameters;
  private List<TestInitialization> testInitializations;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ClassUnderTest(String aName, String aElement)
  {
    name = aName;
    element = aElement;
    testSuites = new ArrayList<TestSuite>();
    testCases = new ArrayList<TestCase>();
    parameters = new ArrayList<Parameter>();
    testInitializations = new ArrayList<TestInitialization>();
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

  public boolean setElement(String aElement)
  {
    boolean wasSet = false;
    element = aElement;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getElement()
  {
    return element;
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
  public TestCase getTestCase(int index)
  {
    TestCase aTestCase = testCases.get(index);
    return aTestCase;
  }

  public List<TestCase> getTestCases()
  {
    List<TestCase> newTestCases = Collections.unmodifiableList(testCases);
    return newTestCases;
  }

  public int numberOfTestCases()
  {
    int number = testCases.size();
    return number;
  }

  public boolean hasTestCases()
  {
    boolean has = testCases.size() > 0;
    return has;
  }

  public int indexOfTestCase(TestCase aTestCase)
  {
    int index = testCases.indexOf(aTestCase);
    return index;
  }
  /* Code from template association_GetMany */
  public Parameter getParameter(int index)
  {
    Parameter aParameter = parameters.get(index);
    return aParameter;
  }

  public List<Parameter> getParameters()
  {
    List<Parameter> newParameters = Collections.unmodifiableList(parameters);
    return newParameters;
  }

  public int numberOfParameters()
  {
    int number = parameters.size();
    return number;
  }

  public boolean hasParameters()
  {
    boolean has = parameters.size() > 0;
    return has;
  }

  public int indexOfParameter(Parameter aParameter)
  {
    int index = parameters.indexOf(aParameter);
    return index;
  }
  /* Code from template association_GetMany */
  public TestInitialization getTestInitialization(int index)
  {
    TestInitialization aTestInitialization = testInitializations.get(index);
    return aTestInitialization;
  }

  public List<TestInitialization> getTestInitializations()
  {
    List<TestInitialization> newTestInitializations = Collections.unmodifiableList(testInitializations);
    return newTestInitializations;
  }

  public int numberOfTestInitializations()
  {
    int number = testInitializations.size();
    return number;
  }

  public boolean hasTestInitializations()
  {
    boolean has = testInitializations.size() > 0;
    return has;
  }

  public int indexOfTestInitialization(TestInitialization aTestInitialization)
  {
    int index = testInitializations.indexOf(aTestInitialization);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTestSuites()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addTestSuite(TestSuite aTestSuite)
  {
    boolean wasAdded = false;
    if (testSuites.contains(aTestSuite)) { return false; }
    ClassUnderTest existingClassUnderTest = aTestSuite.getClassUnderTest();
    if (existingClassUnderTest == null)
    {
      aTestSuite.setClassUnderTest(this);
    }
    else if (!this.equals(existingClassUnderTest))
    {
      existingClassUnderTest.removeTestSuite(aTestSuite);
      addTestSuite(aTestSuite);
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
    if (testSuites.contains(aTestSuite))
    {
      testSuites.remove(aTestSuite);
      aTestSuite.setClassUnderTest(null);
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
  public static int minimumNumberOfTestCases()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addTestCase(TestCase aTestCase)
  {
    boolean wasAdded = false;
    if (testCases.contains(aTestCase)) { return false; }
    ClassUnderTest existingClassUnderTest = aTestCase.getClassUnderTest();
    if (existingClassUnderTest == null)
    {
      aTestCase.setClassUnderTest(this);
    }
    else if (!this.equals(existingClassUnderTest))
    {
      existingClassUnderTest.removeTestCase(aTestCase);
      addTestCase(aTestCase);
    }
    else
    {
      testCases.add(aTestCase);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTestCase(TestCase aTestCase)
  {
    boolean wasRemoved = false;
    if (testCases.contains(aTestCase))
    {
      testCases.remove(aTestCase);
      aTestCase.setClassUnderTest(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTestCaseAt(TestCase aTestCase, int index)
  {  
    boolean wasAdded = false;
    if(addTestCase(aTestCase))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTestCases()) { index = numberOfTestCases() - 1; }
      testCases.remove(aTestCase);
      testCases.add(index, aTestCase);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTestCaseAt(TestCase aTestCase, int index)
  {
    boolean wasAdded = false;
    if(testCases.contains(aTestCase))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTestCases()) { index = numberOfTestCases() - 1; }
      testCases.remove(aTestCase);
      testCases.add(index, aTestCase);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTestCaseAt(aTestCase, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfParameters()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addParameter(Parameter aParameter)
  {
    boolean wasAdded = false;
    if (parameters.contains(aParameter)) { return false; }
    ClassUnderTest existingClassUnderTest = aParameter.getClassUnderTest();
    if (existingClassUnderTest == null)
    {
      aParameter.setClassUnderTest(this);
    }
    else if (!this.equals(existingClassUnderTest))
    {
      existingClassUnderTest.removeParameter(aParameter);
      addParameter(aParameter);
    }
    else
    {
      parameters.add(aParameter);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeParameter(Parameter aParameter)
  {
    boolean wasRemoved = false;
    if (parameters.contains(aParameter))
    {
      parameters.remove(aParameter);
      aParameter.setClassUnderTest(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addParameterAt(Parameter aParameter, int index)
  {  
    boolean wasAdded = false;
    if(addParameter(aParameter))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfParameters()) { index = numberOfParameters() - 1; }
      parameters.remove(aParameter);
      parameters.add(index, aParameter);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveParameterAt(Parameter aParameter, int index)
  {
    boolean wasAdded = false;
    if(parameters.contains(aParameter))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfParameters()) { index = numberOfParameters() - 1; }
      parameters.remove(aParameter);
      parameters.add(index, aParameter);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addParameterAt(aParameter, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTestInitializations()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addTestInitialization(TestInitialization aTestInitialization)
  {
    boolean wasAdded = false;
    if (testInitializations.contains(aTestInitialization)) { return false; }
    ClassUnderTest existingClassUnderTest = aTestInitialization.getClassUnderTest();
    if (existingClassUnderTest == null)
    {
      aTestInitialization.setClassUnderTest(this);
    }
    else if (!this.equals(existingClassUnderTest))
    {
      existingClassUnderTest.removeTestInitialization(aTestInitialization);
      addTestInitialization(aTestInitialization);
    }
    else
    {
      testInitializations.add(aTestInitialization);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTestInitialization(TestInitialization aTestInitialization)
  {
    boolean wasRemoved = false;
    if (testInitializations.contains(aTestInitialization))
    {
      testInitializations.remove(aTestInitialization);
      aTestInitialization.setClassUnderTest(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTestInitializationAt(TestInitialization aTestInitialization, int index)
  {  
    boolean wasAdded = false;
    if(addTestInitialization(aTestInitialization))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTestInitializations()) { index = numberOfTestInitializations() - 1; }
      testInitializations.remove(aTestInitialization);
      testInitializations.add(index, aTestInitialization);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTestInitializationAt(TestInitialization aTestInitialization, int index)
  {
    boolean wasAdded = false;
    if(testInitializations.contains(aTestInitialization))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTestInitializations()) { index = numberOfTestInitializations() - 1; }
      testInitializations.remove(aTestInitialization);
      testInitializations.add(index, aTestInitialization);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTestInitializationAt(aTestInitialization, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while( !testSuites.isEmpty() )
    {
      testSuites.get(0).setClassUnderTest(null);
    }
    while( !testCases.isEmpty() )
    {
      testCases.get(0).setClassUnderTest(null);
    }
    while( !parameters.isEmpty() )
    {
      parameters.get(0).setClassUnderTest(null);
    }
    while( !testInitializations.isEmpty() )
    {
      testInitializations.get(0).setClassUnderTest(null);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "element" + ":" + getElement()+ "]";
  }
}