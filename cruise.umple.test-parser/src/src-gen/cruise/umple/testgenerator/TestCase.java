/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.28.0.4148.608b7c78e modeling language!*/

package cruise.umple.testgenerator;
import java.util.*;

// line 50 "../../../../ump/TestCaseTemplate_model.ump"
public class TestCase
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TestCase Attributes
  private String name;
  private int locOrder;

  //TestCase Associations
  private List<TestInitialization> inits;
  private List<Assertion> assertions;
  private List<Action> actions;
  private TestSuite testSuite;
  private ClassUnderTest classUnderTest;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TestCase(String aName, int aLocOrder)
  {
    name = aName;
    locOrder = aLocOrder;
    inits = new ArrayList<TestInitialization>();
    assertions = new ArrayList<Assertion>();
    actions = new ArrayList<Action>();
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

  public boolean setLocOrder(int aLocOrder)
  {
    boolean wasSet = false;
    locOrder = aLocOrder;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public int getLocOrder()
  {
    return locOrder;
  }
  /* Code from template association_GetMany */
  public TestInitialization getInit(int index)
  {
    TestInitialization aInit = inits.get(index);
    return aInit;
  }

  public List<TestInitialization> getInits()
  {
    List<TestInitialization> newInits = Collections.unmodifiableList(inits);
    return newInits;
  }

  public int numberOfInits()
  {
    int number = inits.size();
    return number;
  }

  public boolean hasInits()
  {
    boolean has = inits.size() > 0;
    return has;
  }

  public int indexOfInit(TestInitialization aInit)
  {
    int index = inits.indexOf(aInit);
    return index;
  }
  /* Code from template association_GetMany */
  public Assertion getAssertion(int index)
  {
    Assertion aAssertion = assertions.get(index);
    return aAssertion;
  }

  public List<Assertion> getAssertions()
  {
    List<Assertion> newAssertions = Collections.unmodifiableList(assertions);
    return newAssertions;
  }

  public int numberOfAssertions()
  {
    int number = assertions.size();
    return number;
  }

  public boolean hasAssertions()
  {
    boolean has = assertions.size() > 0;
    return has;
  }

  public int indexOfAssertion(Assertion aAssertion)
  {
    int index = assertions.indexOf(aAssertion);
    return index;
  }
  /* Code from template association_GetMany */
  public Action getAction(int index)
  {
    Action aAction = actions.get(index);
    return aAction;
  }

  public List<Action> getActions()
  {
    List<Action> newActions = Collections.unmodifiableList(actions);
    return newActions;
  }

  public int numberOfActions()
  {
    int number = actions.size();
    return number;
  }

  public boolean hasActions()
  {
    boolean has = actions.size() > 0;
    return has;
  }

  public int indexOfAction(Action aAction)
  {
    int index = actions.indexOf(aAction);
    return index;
  }
  /* Code from template association_GetOne */
  public TestSuite getTestSuite()
  {
    return testSuite;
  }

  public boolean hasTestSuite()
  {
    boolean has = testSuite != null;
    return has;
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
  public static int minimumNumberOfInits()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addInit(TestInitialization aInit)
  {
    boolean wasAdded = false;
    if (inits.contains(aInit)) { return false; }
    TestCase existingTestcase = aInit.getTestcase();
    if (existingTestcase == null)
    {
      aInit.setTestcase(this);
    }
    else if (!this.equals(existingTestcase))
    {
      existingTestcase.removeInit(aInit);
      addInit(aInit);
    }
    else
    {
      inits.add(aInit);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeInit(TestInitialization aInit)
  {
    boolean wasRemoved = false;
    if (inits.contains(aInit))
    {
      inits.remove(aInit);
      aInit.setTestcase(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addInitAt(TestInitialization aInit, int index)
  {  
    boolean wasAdded = false;
    if(addInit(aInit))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInits()) { index = numberOfInits() - 1; }
      inits.remove(aInit);
      inits.add(index, aInit);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveInitAt(TestInitialization aInit, int index)
  {
    boolean wasAdded = false;
    if(inits.contains(aInit))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInits()) { index = numberOfInits() - 1; }
      inits.remove(aInit);
      inits.add(index, aInit);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addInitAt(aInit, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAssertions()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addAssertion(Assertion aAssertion)
  {
    boolean wasAdded = false;
    if (assertions.contains(aAssertion)) { return false; }
    TestCase existingTestcase = aAssertion.getTestcase();
    if (existingTestcase == null)
    {
      aAssertion.setTestcase(this);
    }
    else if (!this.equals(existingTestcase))
    {
      existingTestcase.removeAssertion(aAssertion);
      addAssertion(aAssertion);
    }
    else
    {
      assertions.add(aAssertion);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAssertion(Assertion aAssertion)
  {
    boolean wasRemoved = false;
    if (assertions.contains(aAssertion))
    {
      assertions.remove(aAssertion);
      aAssertion.setTestcase(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAssertionAt(Assertion aAssertion, int index)
  {  
    boolean wasAdded = false;
    if(addAssertion(aAssertion))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssertions()) { index = numberOfAssertions() - 1; }
      assertions.remove(aAssertion);
      assertions.add(index, aAssertion);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAssertionAt(Assertion aAssertion, int index)
  {
    boolean wasAdded = false;
    if(assertions.contains(aAssertion))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssertions()) { index = numberOfAssertions() - 1; }
      assertions.remove(aAssertion);
      assertions.add(index, aAssertion);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAssertionAt(aAssertion, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfActions()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addAction(Action aAction)
  {
    boolean wasAdded = false;
    if (actions.contains(aAction)) { return false; }
    TestCase existingTestCase = aAction.getTestCase();
    if (existingTestCase == null)
    {
      aAction.setTestCase(this);
    }
    else if (!this.equals(existingTestCase))
    {
      existingTestCase.removeAction(aAction);
      addAction(aAction);
    }
    else
    {
      actions.add(aAction);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAction(Action aAction)
  {
    boolean wasRemoved = false;
    if (actions.contains(aAction))
    {
      actions.remove(aAction);
      aAction.setTestCase(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addActionAt(Action aAction, int index)
  {  
    boolean wasAdded = false;
    if(addAction(aAction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfActions()) { index = numberOfActions() - 1; }
      actions.remove(aAction);
      actions.add(index, aAction);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveActionAt(Action aAction, int index)
  {
    boolean wasAdded = false;
    if(actions.contains(aAction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfActions()) { index = numberOfActions() - 1; }
      actions.remove(aAction);
      actions.add(index, aAction);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addActionAt(aAction, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOptionalOneToMany */
  public boolean setTestSuite(TestSuite aTestSuite)
  {
    boolean wasSet = false;
    TestSuite existingTestSuite = testSuite;
    testSuite = aTestSuite;
    if (existingTestSuite != null && !existingTestSuite.equals(aTestSuite))
    {
      existingTestSuite.removeTestcase(this);
    }
    if (aTestSuite != null)
    {
      aTestSuite.addTestcase(this);
    }
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
      existingClassUnderTest.removeTestCase(this);
    }
    if (aClassUnderTest != null)
    {
      aClassUnderTest.addTestCase(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    while( !inits.isEmpty() )
    {
      inits.get(0).setTestcase(null);
    }
    while( !assertions.isEmpty() )
    {
      assertions.get(0).setTestcase(null);
    }
    while( !actions.isEmpty() )
    {
      actions.get(0).setTestCase(null);
    }
    if (testSuite != null)
    {
      TestSuite placeholderTestSuite = testSuite;
      this.testSuite = null;
      placeholderTestSuite.removeTestcase(this);
    }
    if (classUnderTest != null)
    {
      ClassUnderTest placeholderClassUnderTest = classUnderTest;
      this.classUnderTest = null;
      placeholderClassUnderTest.removeTestCase(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "locOrder" + ":" + getLocOrder()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "testSuite = "+(getTestSuite()!=null?Integer.toHexString(System.identityHashCode(getTestSuite())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "classUnderTest = "+(getClassUnderTest()!=null?Integer.toHexString(System.identityHashCode(getClassUnderTest())):"null");
  }
}