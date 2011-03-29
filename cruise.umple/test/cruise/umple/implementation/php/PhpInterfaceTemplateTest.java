package cruise.umple.implementation.php;

import org.junit.*;

import cruise.umple.implementation.InterfaceTemplateTest;

public class PhpInterfaceTemplateTest extends InterfaceTemplateTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Php";
    languagePath = "php";
  }
}
