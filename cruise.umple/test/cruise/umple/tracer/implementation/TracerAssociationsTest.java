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
		
	@Test
	public void TraceAssociationCardinality1()
	{
		assertUmpleTemplateFor("TraceAssociationCardinality1.ump",languagePath + tracerPath + "/TraceAssociationCardinality1."+ languagePath +".txt","Company");
	}
	  
	@Test @Ignore
	public void TracesSupportAssoiations()
	{
		assertUmpleTemplateFor("AssociationTrace.ump",languagePath + "/AssociationTrace."+ languagePath +".txt","Tracer");
	}
	
}
