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
  
  // * -- *
  @Test
  public void TraceBiAssocManyToManyAdd()
  {
    AssertAssoc("TraceBiAssocManyToManyAdd.ump","TraceBiAssocManyToManyAdd.");
  }
  
  @Test
  public void TraceBiAssocManyToManyRemove()
  {
    AssertAssoc("TraceBiAssocManyToManyRemove.ump","TraceBiAssocManyToManyRemove.");
  }
  
  @Test
  public void TraceBiAssocManyToManyRole()
  {
    AssertAssoc("TraceBiAssocManyToManyRole.ump","TraceBiAssocManyToManyRole.");
  }
  
  // 1 -- *
  @Test
  public void TraceBiAssocOneToManyAdd()
  {
    AssertAssoc("TraceBiAssocOneToManyAdd.ump","TraceBiAssocOneToManyAdd.");
  }
  
  @Test
  public void TraceBiAssocOneToManyRemove()
  {
    AssertAssoc("TraceBiAssocOneToManyRemove.ump","TraceBiAssocOneToManyRemove.");
  }
  
  @Test
  public void TraceBiAssocOneToManyRole()
  {
    AssertAssoc("TraceBiAssocOneToManyRole.ump","TraceBiAssocOneToManyRole.");
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
