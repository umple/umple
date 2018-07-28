/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.28.0.4148.608b7c78e modeling language!*/

package cruise.umple.testgenerator;
import cruise.umple.testparser.*;

// line 30 "../../../../ump/TestCaseTemplate_model.ump"
public class Depend
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Depend Attributes
  private String name;
  private String type;

  //Depend Associations
  private TestModel testModel;
  private TestParser testParser;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Depend(String aName, String aType, TestModel aTestModel)
  {
    name = aName;
    type = aType;
    boolean didAddTestModel = setTestModel(aTestModel);
    if (!didAddTestModel)
    {
      throw new RuntimeException("Unable to create depend due to testModel");
    }
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

  public boolean setType(String aType)
  {
    boolean wasSet = false;
    type = aType;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getType()
  {
    return type;
  }
  /* Code from template association_GetOne */
  public TestModel getTestModel()
  {
    return testModel;
  }
  /* Code from template association_GetOne */
  public TestParser getTestParser()
  {
    return testParser;
  }

  public boolean hasTestParser()
  {
    boolean has = testParser != null;
    return has;
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
      existingTestModel.removeDepend(this);
    }
    testModel.addDepend(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOptionalOneToMany */
  public boolean setTestParser(TestParser aTestParser)
  {
    boolean wasSet = false;
    TestParser existingTestParser = testParser;
    testParser = aTestParser;
    if (existingTestParser != null && !existingTestParser.equals(aTestParser))
    {
      existingTestParser.removeDepend(this);
    }
    if (aTestParser != null)
    {
      aTestParser.addDepend(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    TestModel placeholderTestModel = testModel;
    this.testModel = null;
    if(placeholderTestModel != null)
    {
      placeholderTestModel.removeDepend(this);
    }
    if (testParser != null)
    {
      TestParser placeholderTestParser = testParser;
      this.testParser = null;
      placeholderTestParser.removeDepend(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "type" + ":" + getType()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "testModel = "+(getTestModel()!=null?Integer.toHexString(System.identityHashCode(getTestModel())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "testParser = "+(getTestParser()!=null?Integer.toHexString(System.identityHashCode(getTestParser())):"null");
  }
}