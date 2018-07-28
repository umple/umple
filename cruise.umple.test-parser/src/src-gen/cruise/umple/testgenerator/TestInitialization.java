/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.28.0.4148.608b7c78e modeling language!*/

package cruise.umple.testgenerator;
import java.util.*;

/**
 * 
 */
// line 78 "../../../../ump/TestCaseTemplate_model.ump"
public class TestInitialization
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TestInitialization Attributes
  private String position;
  private String type;
  private String identifier;
  private String objectName;
  private int locOrder;

  //TestInitialization Associations
  private ClassUnderTest classUnderTest;
  private List<Parameter> parameters;
  private TestCase testcase;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TestInitialization(String aPosition, String aType, String aIdentifier, String aObjectName, int aLocOrder)
  {
    position = aPosition;
    type = aType;
    identifier = aIdentifier;
    objectName = aObjectName;
    locOrder = aLocOrder;
    parameters = new ArrayList<Parameter>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPosition(String aPosition)
  {
    boolean wasSet = false;
    position = aPosition;
    wasSet = true;
    return wasSet;
  }

  public boolean setType(String aType)
  {
    boolean wasSet = false;
    type = aType;
    wasSet = true;
    return wasSet;
  }

  public boolean setIdentifier(String aIdentifier)
  {
    boolean wasSet = false;
    identifier = aIdentifier;
    wasSet = true;
    return wasSet;
  }

  public boolean setObjectName(String aObjectName)
  {
    boolean wasSet = false;
    objectName = aObjectName;
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

  public String getPosition()
  {
    return position;
  }

  /**
   * construction or assignment initialization
   */
  public String getType()
  {
    return type;
  }

  public String getIdentifier()
  {
    return identifier;
  }

  public String getObjectName()
  {
    return objectName;
  }

  public int getLocOrder()
  {
    return locOrder;
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
  /* Code from template association_SetOptionalOneToMany */
  public boolean setClassUnderTest(ClassUnderTest aClassUnderTest)
  {
    boolean wasSet = false;
    ClassUnderTest existingClassUnderTest = classUnderTest;
    classUnderTest = aClassUnderTest;
    if (existingClassUnderTest != null && !existingClassUnderTest.equals(aClassUnderTest))
    {
      existingClassUnderTest.removeTestInitialization(this);
    }
    if (aClassUnderTest != null)
    {
      aClassUnderTest.addTestInitialization(this);
    }
    wasSet = true;
    return wasSet;
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
    TestInitialization existingTestInitialization = aParameter.getTestInitialization();
    if (existingTestInitialization == null)
    {
      aParameter.setTestInitialization(this);
    }
    else if (!this.equals(existingTestInitialization))
    {
      existingTestInitialization.removeParameter(aParameter);
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
      aParameter.setTestInitialization(null);
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
      existingTestcase.removeInit(this);
    }
    if (aTestcase != null)
    {
      aTestcase.addInit(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (classUnderTest != null)
    {
      ClassUnderTest placeholderClassUnderTest = classUnderTest;
      this.classUnderTest = null;
      placeholderClassUnderTest.removeTestInitialization(this);
    }
    while( !parameters.isEmpty() )
    {
      parameters.get(0).setTestInitialization(null);
    }
    if (testcase != null)
    {
      TestCase placeholderTestcase = testcase;
      this.testcase = null;
      placeholderTestcase.removeInit(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "position" + ":" + getPosition()+ "," +
            "type" + ":" + getType()+ "," +
            "identifier" + ":" + getIdentifier()+ "," +
            "objectName" + ":" + getObjectName()+ "," +
            "locOrder" + ":" + getLocOrder()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "classUnderTest = "+(getClassUnderTest()!=null?Integer.toHexString(System.identityHashCode(getClassUnderTest())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "testcase = "+(getTestcase()!=null?Integer.toHexString(System.identityHashCode(getTestcase())):"null");
  }
}