package cruise.umple.implementation.pynext;

import java.io.File;

import org.junit.*;

import cruise.umple.implementation.ExternalInterfaceTemplateTest;

public class PythonNextExternalInterfaceTemplateTest extends ExternalInterfaceTemplateTest
{
  
  @Before
  public void setUp()
  {
    super.setUp();
    language = "PythonNext";
    languagePath = "pynext";
  }
  
}