package cruise.umple.implementation.py;

import java.io.File;

import org.junit.*;

import cruise.umple.implementation.ExternalInterfaceTemplateTest;

public class PythonExternalInterfaceTemplateTest extends ExternalInterfaceTemplateTest
{
  
  @Before
  public void setUp()
  {
    super.setUp();
    language = "Python";
    languagePath = "py";
  }
  
}