/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

State Machine extensions       

*/

package cruise.umple.tracer.implementation.php;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;

import cruise.umple.tracer.implementation.*;
import cruise.umple.util.SampleFileWriter;

public class PhpTracerTest extends TracerTest
{
  @Before
  public void setUp()
  {
    super.setUp();
    language = "Php";
    languagePath = "php";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "tracer/php/example");
    SampleFileWriter.destroy(pathToInput + "/Tracer.php");
    SampleFileWriter.destroy(pathToInput + "/StringTracer.php");
  }
}
