/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.28.0.4148.608b7c78e modeling language!*/

package cruise.umple.testgenerator;

// line 43 "../../../../ump/TestCaseTemplate_model.ump"
public class Parameter
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Parameter Attributes
  private String value;
  private String type;
  private String name;

  //Parameter Associations
  private ClassUnderTest classUnderTest;
  private TestInitialization testInitialization;
  private Assertion assertion;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Parameter(String aValue, String aType, String aName)
  {
    value = aValue;
    type = aType;
    name = aName;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setValue(String aValue)
  {
    boolean wasSet = false;
    value = aValue;
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

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getValue()
  {
    return value;
  }

  public String getType()
  {
    return type;
  }

  public String getName()
  {
    return name;
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
  /* Code from template association_GetOne */
  public TestInitialization getTestInitialization()
  {
    return testInitialization;
  }

  public boolean hasTestInitialization()
  {
    boolean has = testInitialization != null;
    return has;
  }
  /* Code from template association_GetOne */
  public Assertion getAssertion()
  {
    return assertion;
  }

  public boolean hasAssertion()
  {
    boolean has = assertion != null;
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
      existingClassUnderTest.removeParameter(this);
    }
    if (aClassUnderTest != null)
    {
      aClassUnderTest.addParameter(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOptionalOneToMany */
  public boolean setTestInitialization(TestInitialization aTestInitialization)
  {
    boolean wasSet = false;
    TestInitialization existingTestInitialization = testInitialization;
    testInitialization = aTestInitialization;
    if (existingTestInitialization != null && !existingTestInitialization.equals(aTestInitialization))
    {
      existingTestInitialization.removeParameter(this);
    }
    if (aTestInitialization != null)
    {
      aTestInitialization.addParameter(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOptionalOneToMany */
  public boolean setAssertion(Assertion aAssertion)
  {
    boolean wasSet = false;
    Assertion existingAssertion = assertion;
    assertion = aAssertion;
    if (existingAssertion != null && !existingAssertion.equals(aAssertion))
    {
      existingAssertion.removeParameter(this);
    }
    if (aAssertion != null)
    {
      aAssertion.addParameter(this);
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
      placeholderClassUnderTest.removeParameter(this);
    }
    if (testInitialization != null)
    {
      TestInitialization placeholderTestInitialization = testInitialization;
      this.testInitialization = null;
      placeholderTestInitialization.removeParameter(this);
    }
    if (assertion != null)
    {
      Assertion placeholderAssertion = assertion;
      this.assertion = null;
      placeholderAssertion.removeParameter(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "value" + ":" + getValue()+ "," +
            "type" + ":" + getType()+ "," +
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "classUnderTest = "+(getClassUnderTest()!=null?Integer.toHexString(System.identityHashCode(getClassUnderTest())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "testInitialization = "+(getTestInitialization()!=null?Integer.toHexString(System.identityHashCode(getTestInitialization())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "assertion = "+(getAssertion()!=null?Integer.toHexString(System.identityHashCode(getAssertion())):"null");
  }
}