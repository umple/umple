/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.28.0.4148.608b7c78e modeling language!*/

package cruise.umple.testgenerator;

// line 88 "../../../../ump/TestCaseTemplate_model.ump"
public class Action
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Action Attributes
  private String name;
  private String code;
  private int locOrder;

  //Action Associations
  private TestCase testCase;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Action(String aName, String aCode, int aLocOrder)
  {
    name = aName;
    code = aCode;
    locOrder = aLocOrder;
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

  public boolean setCode(String aCode)
  {
    boolean wasSet = false;
    code = aCode;
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

  public String getCode()
  {
    return code;
  }

  public int getLocOrder()
  {
    return locOrder;
  }
  /* Code from template association_GetOne */
  public TestCase getTestCase()
  {
    return testCase;
  }

  public boolean hasTestCase()
  {
    boolean has = testCase != null;
    return has;
  }
  /* Code from template association_SetOptionalOneToMany */
  public boolean setTestCase(TestCase aTestCase)
  {
    boolean wasSet = false;
    TestCase existingTestCase = testCase;
    testCase = aTestCase;
    if (existingTestCase != null && !existingTestCase.equals(aTestCase))
    {
      existingTestCase.removeAction(this);
    }
    if (aTestCase != null)
    {
      aTestCase.addAction(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (testCase != null)
    {
      TestCase placeholderTestCase = testCase;
      this.testCase = null;
      placeholderTestCase.removeAction(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "code" + ":" + getCode()+ "," +
            "locOrder" + ":" + getLocOrder()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "testCase = "+(getTestCase()!=null?Integer.toHexString(System.identityHashCode(getTestCase())):"null");
  }
}