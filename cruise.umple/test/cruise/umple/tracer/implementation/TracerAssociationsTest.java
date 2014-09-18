/*

 Copyright: All contributers to the Umple Project

 This file is made available subject to the open source license found at:
 http://umple.org/license

Test class for code generation for state machines

 */

package cruise.umple.tracer.implementation;

import org.junit.*;

@Ignore
public class TracerAssociationsTest extends TracerMethodTest
{

  @Test
  public void TraceAssociationCardinality()
  {
    AssertAssoc("TraceAssociationCardinality.ump","TraceAssociationCardinality.","Company");
  }

  //---------------------------------------- Company-Manager examples

  // (* -- *)

  @Test
  public void TraceBiAssocManyToManyAdd()
  {
    AssertAssoc("TraceBiAssocManyToManyAdd.ump","TraceBiAssocManyToManyAdd.","Company");
  }

  @Test
  public void TraceBiAssocManyToManyRemove()
  {
    AssertAssoc("TraceBiAssocManyToManyRemove.ump","TraceBiAssocManyToManyRemove.","Company");
  }

  @Test
  public void TraceBiAssocManyToManyRole()
  {
    AssertAssoc("TraceBiAssocManyToManyRole.ump","TraceBiAssocManyToManyRole.","Company");
  }
  
  @Test
  public void TraceBiAssocManyToManyRoleCondition()
  {
    AssertAssoc("TraceBiAssocManyToManyRoleCondition.ump","TraceBiAssocManyToManyRoleCondition.","Company");
  }

  // (1 -- *)

  @Test
  public void TraceBiAssocOneToManyAdd()
  {
    AssertAssoc("TraceBiAssocOneToManyAdd.ump","TraceBiAssocOneToManyAdd.","Company");
  }

  @Test
  public void TraceBiAssocOneToManyRemove()
  {
    AssertAssoc("TraceBiAssocOneToManyRemove.ump","TraceBiAssocOneToManyRemove.","Company");
  }

  @Test
  public void TraceBiAssocOneToManyRole()
  {
    AssertAssoc("TraceBiAssocOneToManyRole.ump","TraceBiAssocOneToManyRole.","Company");
  }

  // (* -> *)

  @Test
  public void TraceUniAssocManyToManyAdd()
  {
    AssertAssoc("TraceUniAssocManyToManyAdd.ump","TraceUniAssocManyToManyAdd.","Company");
  }

  @Test
  public void TraceUniAssocManyToManyRemove()
  {
    AssertAssoc("TraceUniAssocManyToManyRemove.ump","TraceUniAssocManyToManyRemove.","Company");
  }

  @Test
  public void TraceUniAssocManyToManyRole()
  {
    AssertAssoc("TraceUniAssocManyToManyRole.ump","TraceUniAssocManyToManyRole.","Company");
  }

  //- (1 -> *)

  @Test
  public void TraceUniAssocOneToManyAdd()
  {
    AssertAssoc("TraceUniAssocOneToManyAdd.ump","TraceUniAssocOneToManyAdd.","Company");
  }

  @Test
  public void TraceUniAssocOneToManyRemove()
  {
    AssertAssoc("TraceUniAssocOneToManyRemove.ump","TraceUniAssocOneToManyRemove.","Company");
  }

  @Test
  public void TraceUniAssocOneToManyRole()
  {
    AssertAssoc("TraceUniAssocOneToManyRole.ump","TraceUniAssocOneToManyRole.","Company");
  }
  
  //---------------------------------------- Student-Mentor examples
  
  @Test
  public void TraceAssocOptionalOneToOptionalOne()
  {
//    AssertAssoc("OptionalOneToOptionalOne.ump","OptionalOneToOptionalOneStudent.","Student");
    AssertAssoc("TraceAssocOptionalOneToOptionalOne.ump","TraceAssocOptionalOneToOptionalOneMentor.","Mentor");
  }
  
  @Test
  public void TraceAssocOptionalOneToOne()
  {
//    AssertAssoc("OptionalOneToOne.ump","OptionalOneToOneStudent.","Student");
    AssertAssoc("TraceAssocOptionalOneToOne.ump","TraceAssocOptionalOneToOneMentor.","Mentor");
  }

  //----------------------------------------
  
  public void AssertAssoc( String inputUmplefile, String expectedOutputFile, String testClassName)
  {   
    assertUmpleTemplateFor( "associations/" + inputUmplefile,
        languagePath + tracerPath + expectedOutputFile + languagePath +".txt",
        testClassName,
        true);
  }

}
