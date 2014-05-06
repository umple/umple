/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

Test class for code generation for state machines

*/

package cruise.umple.tracer.implementation;

import org.junit.*;

@Ignore
public class TracerAssociationsTest extends TracerTemplateTest
{
  
  String path = "associations/";
  
	@Test
	public void TraceAssociationCardinality1()
	{
		assertUmpleTemplateFor(path+"TraceAssociationCardinality1.ump",languagePath + tracerPath + "/TraceAssociationCardinality1."+ languagePath +".txt","Company");
	}
	  
	@Test @Ignore
	public void TracesSupportAssoiations()
	{
		assertUmpleTemplateFor(path+"AssociationTrace.ump",languagePath + tracerPath + "/AssociationTrace."+ languagePath +".txt","Tracer");
	}
	
}
