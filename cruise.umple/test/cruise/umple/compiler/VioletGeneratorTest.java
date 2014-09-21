/*
 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license
 
*/

package cruise.umple.compiler;

import org.junit.*;


public class VioletGeneratorTest
{
  
  VioletGenerator c;
  
  @Before
  public void setUp()
  {
    c = new VioletGenerator();
  }

  @Test
  public void CreateVioletGeneratorFromUmpleSystem_Classes()
  {
    UmpleModel model = new UmpleModel(null);
    
    model.addUmpleClass("Mentor");
    model.addUmpleClass("Student");
    
    c.draw(model);
    
    VioletClass class1 = c.getVioletClass(0);
    VioletClass class2 = c.getVioletClass(1);
    
    if ("Student".equals(class1.getName()))
    {
      Assert.assertEquals("Student",class1.getName());
      Assert.assertEquals("Mentor",class2.getName());
    }
    else
    {
      Assert.assertEquals("Student",class2.getName());
      Assert.assertEquals("Mentor",class1.getName());
    }
    
  }
  
  @Test
  public void CreateVioletGeneratorFromUmpleSystem_Inheritance()
  {
    UmpleModel model = new UmpleModel(null);
    
    UmpleClass child = model.addUmpleClass("Mentor");
    UmpleClass parent = model.addUmpleClass("Student");
    child.setExtendsClass(parent);
    
    c.draw(model);
    
    VioletClass class1 = c.getVioletClass(0);
    VioletClass class2 = c.getVioletClass(1);
    
    if ("Student".equals(class1.getName()))
    {
      Assert.assertEquals("Student",class1.getName());
      Assert.assertEquals("Mentor",class2.getName());
      Assert.assertEquals(null,class1.getParentClass());
      Assert.assertEquals(class1,class2.getParentClass());
    }
    else
    {
      Assert.assertEquals("Student",class2.getName());
      Assert.assertEquals("Mentor",class1.getName());
      Assert.assertEquals(null,class2.getParentClass());
      Assert.assertEquals(class2,class1.getParentClass());
    }    
    
  }  
  
  @Test
  public void CreateVioletGeneratorFromUmpleSystem_Associations()
  {
    UmpleModel model = new UmpleModel(null);
    
    model.addUmpleClass("Mentor");
    model.addUmpleClass("Student");
    
    AssociationEnd end1 = new AssociationEnd("mentor","Mentor",null,"Student",createMultiplicity(0,1));
    AssociationEnd end2 = new AssociationEnd("student","Student",null,"Mentor",createMultiplicity(0,-1));
    Association association = new Association(true,true,false,false,end1,end2);
    model.addAssociation(association);
    
    VioletGenerator violet = new VioletGenerator();
    violet.draw(model);
    
    Assert.assertEquals("0..1",violet.getVioletAssociation(0).getStartLabel());
    Assert.assertEquals("*",violet.getVioletAssociation(0).getEndLabel());
  }  
  
  @Test

  public void newClass_attributes()

  {

    VioletClass e = c.newClass("Mentor");

    Assert.assertEquals("Mentor",e.getName());

    Assert.assertEquals(40.0,e.getX(), 0.0);

    Assert.assertEquals(40.0,e.getY(), 0.0);

  }

  

  @Test

  public void newClass_multipleCheckCoordinates()

  {

    VioletClass e = c.newClass("Mentor");

    Assert.assertEquals("Mentor",e.getName());

    Assert.assertEquals(40.0,e.getX(), 0.0);

    Assert.assertEquals(40.0,e.getY(), 0.0);

    

    VioletClass v2 = c.newClass("Student");

    Assert.assertEquals("Student",v2.getName());

    Assert.assertEquals(250.0,v2.getX(), 0.0);

    Assert.assertEquals(40.0,v2.getY(), 0.0);



    VioletClass v3 = c.newClass("Person");

    Assert.assertEquals("Person",v3.getName());

    Assert.assertEquals(250.0,v3.getX(), 0.0);

    Assert.assertEquals(150.0,v3.getY(), 0.0);    

    

  }  

  

  @Test

  public void newClass_addsIt()

  {

    VioletClass e = c.newClass("Mentor");

    Assert.assertEquals(e,c.getVioletClass(0));

  }  



  @Test

  public void newAssociation_addsIt()

  {

    VioletClass c1 = c.newClass("Mentor");

    VioletClass c2 = c.newClass("Student");

    VioletAssociation a1 = c.newAssociation("*","0..1",c1,c2);

    Assert.assertEquals(a1,c.getVioletAssociation(0));

  }  

  

  @Test

  public void toXml()

  {

    VioletClass class1 = c.newClass("Mentor");

    VioletClass class2 = c.newClass("Mentor");

    VioletAssociation association = c.newAssociation("0..*", "0..1",class1,class2);

    

    VioletDiagram diagram = new VioletDiagram();

    diagram.addVioletClass(class1);

    diagram.addVioletClass(class2);

    diagram.addVioletAssociation(association);

    

    String expected = diagram.toXml();

    String actual = c.toXml();

    Assert.assertEquals(expected,actual);

    

  }



  private Multiplicity createMultiplicity(int lower, int upper)

  {

    Multiplicity m = new Multiplicity();

    m.setRange(lower + "", upper + "");

    return m;

  }

}

