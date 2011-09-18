/*

Copyright 2010 Omar Badreddin, Andrew Forward, Timothy C. Lethbridge

This file is made available subject to the open source license found at:
http://cruise.site.uottawa.ca/UmpleMITLicense.html

State Machine extensions       

*/

package cruise.umple.tracer.implementation.java;

import org.junit.After;
import org.junit.Before;

import cruise.umple.tracer.implementation.TracerTest;
import cruise.umple.util.SampleFileWriter;

public class JavaTracerTest extends TracerTest
{
  @Before
  public void setUp()
  {
    super.setUp();
    language = "Java";
    languagePath = "java";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "statemachine/java/example");
  }
}
