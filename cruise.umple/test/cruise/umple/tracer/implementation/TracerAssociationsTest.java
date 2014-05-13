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
    AssertAssoc("TraceAssociationCardinality1.ump","TraceAssociationCardinality1.");
  }
  
  @Test
  public void TraceAssociationManyToManyAdd()
  {
    AssertAssoc("TraceAssociationManyToManyAdd.ump","TraceAssociationManyToManyAdd.");
  }

  @Test @Ignore
  public void TracesSupportAssoiations()
  {
    AssertAssoc("AssociationTrace.ump","AssociationTrace.");
  }

  public void AssertAssoc( String inputUmplefile, String expectedOutputFile)
  {   
    assertUmpleTemplateFor( "associations/" + inputUmplefile,
        languagePath + tracerPath + expectedOutputFile + languagePath +".txt",
        "Company",
        false);
  }
}
