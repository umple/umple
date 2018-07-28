/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.28.0.4148.608b7c78e modeling language!*/

package cruise.umple.testgenerator;
import java.util.*;

// line 96 "../../../../ump/TestCaseTemplate_model.ump"
public class Assertion
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Assertion Attributes
  private String type;
  private String assertMethod;
  private String action;
  private String expected;
  private String assertCode;
  private String assertCodeObjectLeft;
  private String assertCodeObjectRight;
  private int locOrder;

  //Assertion Associations
  private List<Parameter> parameters;
  private TestCase testcase;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Assertion(String aType, String aAssertMethod, String aAction, String aExpected, String aAssertCode, String aAssertCodeObjectLeft, String aAssertCodeObjectRight, int aLocOrder)
  {
    type = aType;
    assertMethod = aAssertMethod;
    action = aAction;
    expected = aExpected;
    assertCode = aAssertCode;
    assertCodeObjectLeft = aAssertCodeObjectLeft;
    assertCodeObjectRight = aAssertCodeObjectRight;
    locOrder = aLocOrder;
    parameters = new ArrayList<Parameter>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setType(String aType)
  {
    boolean wasSet = false;
    type = aType;
    wasSet = true;
    return wasSet;
  }

  public boolean setAssertMethod(String aAssertMethod)
  {
    boolean wasSet = false;
    assertMethod = aAssertMethod;
    wasSet = true;
    return wasSet;
  }

  public boolean setAction(String aAction)
  {
    boolean wasSet = false;
    action = aAction;
    wasSet = true;
    return wasSet;
  }

  public boolean setExpected(String aExpected)
  {
    boolean wasSet = false;
    expected = aExpected;
    wasSet = true;
    return wasSet;
  }

  public boolean setAssertCode(String aAssertCode)
  {
    boolean wasSet = false;
    assertCode = aAssertCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setAssertCodeObjectLeft(String aAssertCodeObjectLeft)
  {
    boolean wasSet = false;
    assertCodeObjectLeft = aAssertCodeObjectLeft;
    wasSet = true;
    return wasSet;
  }

  public boolean setAssertCodeObjectRight(String aAssertCodeObjectRight)
  {
    boolean wasSet = false;
    assertCodeObjectRight = aAssertCodeObjectRight;
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

  public String getType()
  {
    return type;
  }

  public String getAssertMethod()
  {
    return assertMethod;
  }

  public String getAction()
  {
    return action;
  }

  public String getExpected()
  {
    return expected;
  }

  public String getAssertCode()
  {
    return assertCode;
  }

  public String getAssertCodeObjectLeft()
  {
    return assertCodeObjectLeft;
  }

  public String getAssertCodeObjectRight()
  {
    return assertCodeObjectRight;
  }

  public int getLocOrder()
  {
    return locOrder;
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
  /* Code from template association_GetOne */
  public TestCase getTestcase()
  {
    return testcase;
  }

  public boolean hasTestcase()
  {
    boolean has = testcase != null;
    return has;
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
    Assertion existingAssertion = aParameter.getAssertion();
    if (existingAssertion == null)
    {
      aParameter.setAssertion(this);
    }
    else if (!this.equals(existingAssertion))
    {
      existingAssertion.removeParameter(aParameter);
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
      aParameter.setAssertion(null);
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
  /* Code from template association_SetOptionalOneToMany */
  public boolean setTestcase(TestCase aTestcase)
  {
    boolean wasSet = false;
    TestCase existingTestcase = testcase;
    testcase = aTestcase;
    if (existingTestcase != null && !existingTestcase.equals(aTestcase))
    {
      existingTestcase.removeAssertion(this);
    }
    if (aTestcase != null)
    {
      aTestcase.addAssertion(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    while( !parameters.isEmpty() )
    {
      parameters.get(0).setAssertion(null);
    }
    if (testcase != null)
    {
      TestCase placeholderTestcase = testcase;
      this.testcase = null;
      placeholderTestcase.removeAssertion(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "type" + ":" + getType()+ "," +
            "assertMethod" + ":" + getAssertMethod()+ "," +
            "action" + ":" + getAction()+ "," +
            "expected" + ":" + getExpected()+ "," +
            "assertCode" + ":" + getAssertCode()+ "," +
            "assertCodeObjectLeft" + ":" + getAssertCodeObjectLeft()+ "," +
            "assertCodeObjectRight" + ":" + getAssertCodeObjectRight()+ "," +
            "locOrder" + ":" + getLocOrder()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "testcase = "+(getTestcase()!=null?Integer.toHexString(System.identityHashCode(getTestcase())):"null");
  }
}