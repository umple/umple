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

  //---------------------------------------- (* -- *)

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

  //---------------------------------------- (1 -- *)

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

  //---------------------------------------- (* -> *)

  @Test
  public void TraceUniAssocManyToManyAdd()
  {
    AssertAssoc("TraceUniAssocManyToManyAdd.ump","TraceUniAssocManyToManyAdd.");
  }

  @Test
  public void TraceUniAssocManyToManyRemove()
  {
    AssertAssoc("TraceUniAssocManyToManyRemove.ump","TraceUniAssocManyToManyRemove.");
  }

  @Test
  public void TraceUniAssocManyToManyRole()
  {
    AssertAssoc("TraceUniAssocManyToManyRole.ump","TraceUniAssocManyToManyRole.");
  }

  //---------------------------------------- (1 -> *)

  @Test
  public void TraceUniAssocOneToManyAdd()
  {
    AssertAssoc("TraceUniAssocOneToManyAdd.ump","TraceUniAssocOneToManyAdd.");
  }

  @Test
  public void TraceUniAssocOneToManyRemove()
  {
    AssertAssoc("TraceUniAssocOneToManyRemove.ump","TraceUniAssocOneToManyRemove.");
  }

  @Test
  public void TraceUniAssocOneToManyRole()
  {
    AssertAssoc("TraceUniAssocOneToManyRole.ump","TraceUniAssocOneToManyRole.");
  }

  //----------------------------------------
  
  public void AssertAssoc( String inputUmplefile, String expectedOutputFile)
  {   
    assertUmpleTemplateFor( "associations/" + inputUmplefile,
        languagePath + tracerPath + expectedOutputFile + languagePath +".txt",
        "Company",
        true);
  }

}
