/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import java.util.*;
import org.junit.*;

public class AssociationTest
{
  
  HashMap<String,UmpleClass> map;
  
  @Before
  public void setUp()
  {
    map = new HashMap<String, UmpleClass>();
    map.put("C1",new UmpleClass("C1"));
    map.put("C2",new UmpleClass("C2"));    
  }
  
  @Test
  public void isImmutable()
  {
    Association as = new Association(true,true,new AssociationEnd("R2","C1","M1","C2",createMultiplicity(3,4)), new AssociationEnd("R1","C2","M2","C1",createMultiplicity(1,2)));
    Assert.assertFalse(as.isImmutable());
    as.setImmutable();
    Assert.assertTrue(as.isImmutable());
  }
  
//  @Test
//  public void isNamed_defaulted()
//  {
//    Association as = new Association(true,true,new AssociationEnd("R2","C1","M1","C2",createMultiplicity(3,4)), new AssociationEnd("R1","C2","M2","C1",createMultiplicity(1,2)));    
//    Assert.assertEquals(false, as.isNamed());
//    as.setName("SomeName");
//    Assert.assertEquals(true, as.isNamed());
//    as.setName(as.deriveName());
//    Assert.assertEquals(true, as.isNamed());
//  }
  
  
  @Test
  public void CheckAssociations()
  {
   
    Association ass = new Association(true,true,new AssociationEnd("R2","C1","M1","C2",createMultiplicity(3,4)), new AssociationEnd("R1","C2","M2","C1",createMultiplicity(1,2)));

    AssociationEnd first = ass.getEnd(0);
    AssociationEnd second = ass.getEnd(1);
    
    Assert.assertEquals(new AssociationEnd("R2","C1","M1","C2", createMultiplicity(3,4)),first);
    Assert.assertEquals(new AssociationEnd("R1","C2","M2","C1",createMultiplicity(1,2)),second);
  }

  @Test
  public void toGenericString()
  {
    Association ass1 = new Association(true,true,new AssociationEnd("","C1","M1","C2",createMultiplicity(1,1)), new AssociationEnd("","C2","M2","C1",createMultiplicity(0, -1)));
    Association ass2 = new Association(true,true,new AssociationEnd("","C1","M1","C2",createMultiplicity(0,-1)), new AssociationEnd("","C2","M2","C1",createMultiplicity(1,1)));

    Assert.assertEquals("1 -- *",ass1.toGenericString());
    Assert.assertEquals("* -- 1",ass2.toGenericString());
  }
  
  @Test
  public void toGenericString_nToM()
  {
    Association ass1 = new Association(true,true,new AssociationEnd("","C1","M1","C2",createMultiplicity(4, 4)), new AssociationEnd("","C2","M2","C1",createMultiplicity(3,3)));
    Association ass2 = new Association(true,true,new AssociationEnd("","C1","M1","C2",createMultiplicity(3, 3)), new AssociationEnd("","C2","M2","C1",createMultiplicity(3,3)));

    Assert.assertEquals("n -- m",ass1.toGenericString());
    Assert.assertEquals("n -- n",ass2.toGenericString());
  }
  
  @Test
  public void toGenericString_rightUnidirectional()
  {
    Association ass1 = new Association(false,true,new AssociationEnd("","C1","M1","C2",createMultiplicity(4, 4)), new AssociationEnd("","C2","M2","C1",createMultiplicity(3,3)));
    Association ass2 = new Association(false,true,new AssociationEnd("","C1","M1","C2",createMultiplicity(3, 3)), new AssociationEnd("","C2","M2","C1",createMultiplicity(3,3)));

    Assert.assertEquals("n -> m",ass1.toGenericString());
    Assert.assertEquals("n -> n",ass2.toGenericString());
  }

  @Test
  public void toGenericString_leftUnidirectional()
  {
    Association ass1 = new Association(true,false,new AssociationEnd("","C1","M1","C2",createMultiplicity(4, 4)), new AssociationEnd("","C2","M2","C1",createMultiplicity(3,3)));
    Association ass2 = new Association(true,false,new AssociationEnd("","C1","M1","C2",createMultiplicity(3, 3)), new AssociationEnd("","C2","M2","C1",createMultiplicity(3,3)));

    Assert.assertEquals("n <- m",ass1.toGenericString());
    Assert.assertEquals("n <- n",ass2.toGenericString());
  }
  
  @Test
  public void toGenericString_noDirectional()
  {
    Association ass1 = new Association(false,false,new AssociationEnd("","C1","M1","C2",createMultiplicity(4, 4)), new AssociationEnd("","C2","M2","C1",createMultiplicity(3,3)));
    Association ass2 = new Association(false,false,new AssociationEnd("","C1","M1","C2",createMultiplicity(3, 3)), new AssociationEnd("","C2","M2","C1",createMultiplicity(3,3)));

    Assert.assertEquals("n >< m",ass1.toGenericString());
    Assert.assertEquals("n >< n",ass2.toGenericString());
  }
  
  @Test
  public void isValid_assumeUnderlyingMultiplityOk()
  {
    Assert.assertEquals(true,new Association(true,true,new AssociationEnd("student","Student",null,"Mentor",createMultiplicity(4,2)), new AssociationEnd("mentor","Mentor","","Student", createMultiplicity(3,3))).isValid());
  }

  @Test
  public void isValid_okay()
  {
    Assert.assertEquals(true,new Association(true,true,new AssociationEnd("student","Student",null,"Mentor",createMultiplicity(0, 1)), new AssociationEnd("mentor","Mentor","","Student", createMultiplicity(3,3))).isValid());
  }
  
  @Test
  public void isValid_reflexetionMustHaveLowerBoundOfZero()
  {
    Assert.assertEquals(false,new Association(true,true,new AssociationEnd("student","Student",null,"Student", createMultiplicity(1,2)), new AssociationEnd("mentor","Student","","Student",createMultiplicity(3, 3))).isValid());
    Assert.assertEquals(false,new Association(true,true,new AssociationEnd("student","Student",null,"Student", createMultiplicity(1,2)), new AssociationEnd("mentor","Student","","Student",createMultiplicity(0, 3))).isValid());
    Assert.assertEquals(false,new Association(true,true,new AssociationEnd("student","Student",null,"Student", createMultiplicity(0,2)), new AssociationEnd("mentor","Student","","Student",createMultiplicity(1, 3))).isValid());
    Assert.assertEquals(true,new Association(true,true,new AssociationEnd("student","Student",null,"Student", createMultiplicity(0,2)), new AssociationEnd("mentor","Student","","Student",createMultiplicity(0, 3))).isValid());
  }
  
  @Test
  public void isValid_uniDirectionalReflexetionNeedNotHaveLowerBoundOfZero()
  {
    Assert.assertEquals(true,new Association(false,true,new AssociationEnd("student","Student",null,"Student", createMultiplicity(1,2)), new AssociationEnd("mentor","Student","","Student",createMultiplicity(3,3))).isValid());
    Assert.assertEquals(true,new Association(true,false,new AssociationEnd("student","Student",null,"Student", createMultiplicity(1,2)), new AssociationEnd("mentor","Student","","Student",createMultiplicity(3,3))).isValid());    

    Assert.assertEquals(true,new Association(false,true,new AssociationEnd("student","Student",null,"Student", createMultiplicity(1,2)), new AssociationEnd("mentor","Student","","Student",createMultiplicity(0,3))).isValid());
    Assert.assertEquals(true,new Association(true,false,new AssociationEnd("student","Student",null,"Student", createMultiplicity(1,2)), new AssociationEnd("mentor","Student","","Student",createMultiplicity(0,3))).isValid());
    
    Assert.assertEquals(true,new Association(false,true,new AssociationEnd("student","Student",null,"Student", createMultiplicity(0,2)), new AssociationEnd("mentor","Student","","Student",createMultiplicity(1,3))).isValid());
    Assert.assertEquals(true,new Association(true,false,new AssociationEnd("student","Student",null,"Student", createMultiplicity(0,2)), new AssociationEnd("mentor","Student","","Student",createMultiplicity(1,3))).isValid());

    Assert.assertEquals(true,new Association(false,true,new AssociationEnd("student","Student",null,"Student", createMultiplicity(0,2)), new AssociationEnd("mentor","Student","","Student",createMultiplicity(0,3))).isValid());
    Assert.assertEquals(true,new Association(true,false,new AssociationEnd("student","Student",null,"Student", createMultiplicity(0,2)), new AssociationEnd("mentor","Student","","Student",createMultiplicity(0,3))).isValid());
  }  
  
  @Test
  public void whoIsInvalid()
  {
    Assert.assertEquals(0,new Association(true,true,new AssociationEnd("student","Student",null,"Student", createMultiplicity(1,2)), new AssociationEnd("mentor","Student","","Student",createMultiplicity(3,3))).whoIsInvalid());
    Assert.assertEquals(0,new Association(true,true,new AssociationEnd("student","Student",null,"Student", createMultiplicity(1,2)), new AssociationEnd("mentor","Student","","Student",createMultiplicity(0,3))).whoIsInvalid());
    Assert.assertEquals(1,new Association(true,true,new AssociationEnd("student","Student",null,"Student", createMultiplicity(0,2)), new AssociationEnd("mentor","Student","","Student",createMultiplicity(1,3))).whoIsInvalid());
    Assert.assertEquals(-1,new Association(true,true,new AssociationEnd("student","Student",null,"Student", createMultiplicity(0,2)), new AssociationEnd("mentor","Student","","Student",createMultiplicity(0,3))).whoIsInvalid());
  }  
  
  public static Multiplicity createMultiplicity(int lower, int upper)
  {
    Multiplicity m = new Multiplicity();
    m.setRange(lower + "", upper + "");
    return m;
  }
  
}
