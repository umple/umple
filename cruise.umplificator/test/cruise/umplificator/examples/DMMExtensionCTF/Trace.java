/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 24 "DMMExtensionCTF.ump"
// line 165 "DMMExtensionCTF.ump"
public class Trace
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Trace Associations
  private Scenario scenario;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Trace()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public Scenario getScenario()
  {
    return scenario;
  }

  public boolean hasScenario()
  {
    boolean has = scenario != null;
    return has;
  }

  public boolean setScenario(Scenario aScenario)
  {
    boolean wasSet = false;
    Scenario existingScenario = scenario;
    scenario = aScenario;
    if (existingScenario != null && !existingScenario.equals(aScenario))
    {
      existingScenario.removeTrace(this);
    }
    if (aScenario != null)
    {
      aScenario.addTrace(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (scenario != null)
    {
      Scenario placeholderScenario = scenario;
      this.scenario = null;
      placeholderScenario.removeTrace(this);
    }
  }

}