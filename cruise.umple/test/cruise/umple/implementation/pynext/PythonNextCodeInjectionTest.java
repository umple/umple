package cruise.umple.implementation.pynext;

import org.junit.*;

import cruise.umple.implementation.CodeInjectionTest;;

public class PythonNextCodeInjectionTest extends CodeInjectionTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "PythonNext";
    languagePath = "pynext";
  }

  @Test
  public void WildCard(){
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("CodeInjectionWildCardTest.ump", 9211);
  }

  @Test
  public void AttributesAndDelete(){
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("CodeInjectionTest.ump", 9211);
  }

  @Test
  public void StateMachines(){
    super.StateMachines();
  }

  @Test
  public void Associations(){
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("CodeInjectionAssociationTest.ump", 9211);
  }

  @Ignore("the shared model has Java in untagged method bodies or extra code, which Python emits as native code; the corpus gate classifies it as generation-only")

  @Test
  public void ToplevelCodeInjection(){
    super.ToplevelCodeInjection();
  }
}
