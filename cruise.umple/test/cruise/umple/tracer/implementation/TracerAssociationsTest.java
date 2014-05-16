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
  public void TraceAssociationCardinality()
  {
    AssertAssoc("TraceAssociationCardinality.ump","TraceAssociationCardinality.");
  }
  
  @Test
  public void TraceAssociationManyToManyAdd()
  {
    AssertAssoc("TraceAssociationManyToManyAdd.ump","TraceAssociationManyToManyAdd.");
  }
  
  @Test
  public void TraceAssociationManyToManyRemove()
  {
    AssertAssoc("TraceAssociationManyToManyRemove.ump","TraceAssociationManyToManyRemove.");
  }
  
  @Test
  public void TraceAssociationManyToManyRole()
  {
    AssertAssoc("TraceAssociationManyToManyRole.ump","TraceAssociationManyToManyRole.");
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
        true);
  }
}
