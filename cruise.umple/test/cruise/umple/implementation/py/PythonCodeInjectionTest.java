package cruise.umple.implementation.py;

import org.junit.*;

import cruise.umple.implementation.CodeInjectionTest;;

public class PythonCodeInjectionTest extends CodeInjectionTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Python";
    languagePath = "py";
  }

  @Test @Ignore
  public void WildCard(){
    super.WildCard();
  }

  @Test @Ignore
  public void AttributesAndDelete(){
    super.AttributesAndDelete();
  }

  @Test @Ignore
  public void StateMachines(){
    super.StateMachines();
  }

  @Test @Ignore
  public void Associations(){
    super.Associations();
  }

  @Test @Ignore
  public void ToplevelCodeInjection(){
    super.ToplevelCodeInjection();
  }
}
