/*

Copyright 2010 Omar Badreddin, Andrew Forward, Timothy C. Lethbridge

This file is made available subject to the open source license found at:
http://cruise.site.uottawa.ca/UmpleMITLicense.html

State Machine extensions       

*/

package cruise.umple.tracer.implementation.cpp;

import org.junit.After;
import org.junit.Before;

import cruise.umple.tracer.implementation.*;
import cruise.umple.util.SampleFileWriter;

public class CppTracerTest extends TracerTest
{
  @Before
  public void setUp()
  {
    super.setUp();
    language = "Cpp";
    languagePath = "cpp";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "statemachine/cpp/example");
  }
}
