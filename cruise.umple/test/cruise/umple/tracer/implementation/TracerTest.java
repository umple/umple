/*

Copyright 2010 Andrew Forward, Timothy C. Lethbridge

This file is made available subject to the open source license found at:
http://cruise.site.uottawa.ca/UmpleMITLicense.html

Test class for code generation for state machines

*/

package cruise.umple.tracer.implementation;

import org.junit.*;

public class TracerTest extends TracerTemplateTest
{
  
  @Test
  public void TracesSupportAttributes()
  {
   assertUmpleTemplateFor("AttributeTrace.ump",languagePath + "/AttributeTrace."+ languagePath +".txt","Tracer");
  }
  
  @Test @Ignore
  public void TracesSupportAssoiations()
  {
   assertUmpleTemplateFor("AssociationTrace.ump",languagePath + "/AssociationTrace."+ languagePath +".txt","Tracer");
  }

  
}
