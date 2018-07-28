/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.28.0.4148.608b7c78e modeling language!*/

package cruise.umple.testgenerator;
import java.util.*;

// line 36 "../../../../ump/TestCaseTemplate_model.ump"
public class TestSuite
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TestSuite Associations
  private List<TestCase> testcases;
  private TestModel testModel;
  private ClassUnderTest classUnderTest;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TestSuite(TestModel aTestModel)
  {
    testcases = new ArrayList<TestCase>();
    boolean didAddTestModel = setTestModel(aTestModel);
    if (!didAddTestModel)
    {
      throw new RuntimeException("Unable to create testSuite due to testModel");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public TestCase getTestcase(int index)
  {
    TestCase aTestcase = testcases.get(index);
    return aTestcase;
  }

  public List<TestCase> getTestcases()
  {
    List<TestCase> newTestcases = Collections.unmodifiableList(testcases);
    return newTestcases;
  }

  public int numberOfTestcases()
  {
    int number = testcases.size();
    return number;
  }

  public boolean hasTestcases()
  {
    boolean has = testcases.size() > 0;
    return has;
  }

  public int indexOfTestcase(TestCase aTestcase)
  {
    int index = testcases.indexOf(aTestcase);
    return index;
  }
  /* Code from template association_GetOne */
  public TestModel getTestModel()
  {
    return testModel;
  }
  /* Code from template association_GetOne */
  public ClassUnderTest getClassUnderTest()
  {
    return classUnderTest;
  }

  public boolean hasClassUnderTest()
  {
    boolean has = classUnderTest != null;
    return has;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTestcases()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addTestcase(TestCase aTestcase)
  {
    boolean wasAdded = false;
    if (testcases.contains(aTestcase)) { return false; }
    TestSuite existingTestSuite = aTestcase.getTestSuite();
    if (existingTestSuite == null)
    {
      aTestcase.setTestSuite(this);
    }
    else if (!this.equals(existingTestSuite))
    {
      existingTestSuite.removeTestcase(aTestcase);
      addTestcase(aTestcase);
    }
    else
    {
      testcases.add(aTestcase);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTestcase(TestCase aTestcase)
  {
    boolean wasRemoved = false;
    if (testcases.contains(aTestcase))
    {
      testcases.remove(aTestcase);
      aTestcase.setTestSuite(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTestcaseAt(TestCase aTestcase, int index)
  {  
    boolean wasAdded = false;
    if(addTestcase(aTestcase))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTestcases()) { index = numberOfTestcases() - 1; }
      testcases.remove(aTestcase);
      testcases.add(index, aTestcase);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTestcaseAt(TestCase aTestcase, int index)
  {
    boolean wasAdded = false;
    if(testcases.contains(aTestcase))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTestcases()) { index = numberOfTestcases() - 1; }
      testcases.remove(aTestcase);
      testcases.add(index, aTestcase);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTestcaseAt(aTestcase, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setTestModel(TestModel aTestModel)
  {
    boolean wasSet = false;
    if (aTestModel == null)
    {
      return wasSet;
    }

    TestModel existingTestModel = testModel;
    testModel = aTestModel;
    if (existingTestModel != null && !existingTestModel.equals(aTestModel))
    {
      existingTestModel.removeTestSuite(this);
    }
    testModel.addTestSuite(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOptionalOneToMany */
  public boolean setClassUnderTest(ClassUnderTest aClassUnderTest)
  {
    boolean wasSet = false;
    ClassUnderTest existingClassUnderTest = classUnderTest;
    classUnderTest = aClassUnderTest;
    if (existingClassUnderTest != null && !existingClassUnderTest.equals(aClassUnderTest))
    {
      existingClassUnderTest.removeTestSuite(this);
    }
    if (aClassUnderTest != null)
    {
      aClassUnderTest.addTestSuite(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    while( !testcases.isEmpty() )
    {
      testcases.get(0).setTestSuite(null);
    }
    TestModel placeholderTestModel = testModel;
    this.testModel = null;
    if(placeholderTestModel != null)
    {
      placeholderTestModel.removeTestSuite(this);
    }
    if (classUnderTest != null)
    {
      ClassUnderTest placeholderClassUnderTest = classUnderTest;
      this.classUnderTest = null;
      placeholderClassUnderTest.removeTestSuite(this);
    }
  }

}